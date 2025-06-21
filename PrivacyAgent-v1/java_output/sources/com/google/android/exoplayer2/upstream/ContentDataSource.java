package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class ContentDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public final android.content.ContentResolver e;

    @androidx.annotation.Nullable
    public android.net.Uri f;

    @androidx.annotation.Nullable
    public android.content.res.AssetFileDescriptor g;

    @androidx.annotation.Nullable
    public java.io.FileInputStream h;
    public long i;
    public boolean j;

    public static class ContentDataSourceException extends java.io.IOException {
        public ContentDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(android.content.Context context) {
        super(false);
        this.e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException {
        this.f = null;
        try {
            try {
                java.io.FileInputStream fileInputStream = this.h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.h = null;
                try {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptor = this.g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.g = null;
                        if (this.j) {
                            this.j = false;
                            transferEnded();
                        }
                    }
                } catch (java.io.IOException e) {
                    throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e);
                }
            } catch (java.io.IOException e2) {
                throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e2);
            }
        } catch (java.lang.Throwable th) {
            this.h = null;
            try {
                try {
                    android.content.res.AssetFileDescriptor assetFileDescriptor2 = this.g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.g = null;
                    if (this.j) {
                        this.j = false;
                        transferEnded();
                    }
                    throw th;
                } catch (java.io.IOException e3) {
                    throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e3);
                }
            } finally {
                this.g = null;
                if (this.j) {
                    this.j = false;
                    transferEnded();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException {
        try {
            android.net.Uri uri = dataSpec.uri;
            this.f = uri;
            transferInitializing(dataSpec);
            android.content.res.AssetFileDescriptor openAssetFileDescriptor = this.e.openAssetFileDescriptor(uri, "r");
            this.g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                java.lang.String valueOf = java.lang.String.valueOf(uri);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(valueOf);
                throw new java.io.FileNotFoundException(sb.toString());
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.h = fileInputStream;
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
            if (skip != dataSpec.position) {
                throw new java.io.EOFException();
            }
            long j = dataSpec.length;
            if (j != -1) {
                this.i = j;
            } else {
                long length = openAssetFileDescriptor.getLength();
                if (length == -1) {
                    java.nio.channels.FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.i = -1L;
                    } else {
                        long position = size - channel.position();
                        this.i = position;
                        if (position < 0) {
                            throw new java.io.EOFException();
                        }
                    }
                } else {
                    long j2 = length - skip;
                    this.i = j2;
                    if (j2 < 0) {
                        throw new java.io.EOFException();
                    }
                }
            }
            this.j = true;
            transferStarted(dataSpec);
            return this.i;
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e);
            }
        }
        int read = ((java.io.FileInputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.h)).read(bArr, i, i2);
        if (read == -1) {
            if (this.i == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(new java.io.EOFException());
        }
        long j2 = this.i;
        if (j2 != -1) {
            this.i = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
