package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class AssetDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public final android.content.res.AssetManager e;

    @androidx.annotation.Nullable
    public android.net.Uri f;

    @androidx.annotation.Nullable
    public java.io.InputStream g;
    public long h;
    public boolean i;

    public static final class AssetDataSourceException extends java.io.IOException {
        public AssetDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(android.content.Context context) {
        super(false);
        this.e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException {
        this.f = null;
        try {
            try {
                java.io.InputStream inputStream = this.g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e);
            }
        } finally {
            this.g = null;
            if (this.i) {
                this.i = false;
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
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException {
        try {
            android.net.Uri uri = dataSpec.uri;
            this.f = uri;
            java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str.substring(1);
            }
            transferInitializing(dataSpec);
            java.io.InputStream open = this.e.open(str, 1);
            this.g = open;
            if (open.skip(dataSpec.position) < dataSpec.position) {
                throw new java.io.EOFException();
            }
            long j = dataSpec.length;
            if (j != -1) {
                this.h = j;
            } else {
                long available = this.g.available();
                this.h = available;
                if (available == 2147483647L) {
                    this.h = -1L;
                }
            }
            this.i = true;
            transferStarted(dataSpec);
            return this.h;
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e);
            }
        }
        int read = ((java.io.InputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.g)).read(bArr, i, i2);
        if (read == -1) {
            if (this.h == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(new java.io.EOFException());
        }
        long j2 = this.h;
        if (j2 != -1) {
            this.h = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
