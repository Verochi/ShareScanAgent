package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class FileDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {

    @androidx.annotation.Nullable
    public java.io.RandomAccessFile e;

    @androidx.annotation.Nullable
    public android.net.Uri f;
    public long g;
    public boolean h;

    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.TransferListener a;

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public com.google.android.exoplayer2.upstream.FileDataSource createDataSource() {
            com.google.android.exoplayer2.upstream.FileDataSource fileDataSource = new com.google.android.exoplayer2.upstream.FileDataSource();
            com.google.android.exoplayer2.upstream.TransferListener transferListener = this.a;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }

        public com.google.android.exoplayer2.upstream.FileDataSource.Factory setListener(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
            this.a = transferListener;
            return this;
        }
    }

    public static class FileDataSourceException extends java.io.IOException {
        public FileDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(java.lang.String str, java.io.IOException iOException) {
            super(str, iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static java.io.RandomAccessFile a(android.net.Uri uri) throws com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException {
        try {
            return new java.io.RandomAccessFile((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getPath()), "r");
        } catch (java.io.FileNotFoundException e) {
            if (android.text.TextUtils.isEmpty(uri.getQuery()) && android.text.TextUtils.isEmpty(uri.getFragment())) {
                throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e);
            }
            throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(java.lang.String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException {
        this.f = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile = this.e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e);
            }
        } finally {
            this.e = null;
            if (this.h) {
                this.h = false;
                transferEnded();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException {
        try {
            android.net.Uri uri = dataSpec.uri;
            this.f = uri;
            transferInitializing(dataSpec);
            java.io.RandomAccessFile a = a(uri);
            this.e = a;
            a.seek(dataSpec.position);
            long j = dataSpec.length;
            if (j == -1) {
                j = this.e.length() - dataSpec.position;
            }
            this.g = j;
            if (j < 0) {
                throw new java.io.EOFException();
            }
            this.h = true;
            transferStarted(dataSpec);
            return this.g;
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.g == 0) {
            return -1;
        }
        try {
            int read = ((java.io.RandomAccessFile) com.google.android.exoplayer2.util.Util.castNonNull(this.e)).read(bArr, i, (int) java.lang.Math.min(this.g, i2));
            if (read > 0) {
                this.g -= read;
                bytesTransferred(read);
            }
            return read;
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e);
        }
    }
}
