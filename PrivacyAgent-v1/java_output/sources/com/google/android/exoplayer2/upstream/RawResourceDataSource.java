package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class RawResourceDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final java.lang.String RAW_RESOURCE_SCHEME = "rawresource";
    public final android.content.res.Resources e;
    public final java.lang.String f;

    @androidx.annotation.Nullable
    public android.net.Uri g;

    @androidx.annotation.Nullable
    public android.content.res.AssetFileDescriptor h;

    @androidx.annotation.Nullable
    public java.io.InputStream i;
    public long j;
    public boolean k;

    public static class RawResourceDataSourceException extends java.io.IOException {
        public RawResourceDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }

        public RawResourceDataSourceException(java.lang.String str) {
            super(str);
        }
    }

    public RawResourceDataSource(android.content.Context context) {
        super(false);
        this.e = context.getResources();
        this.f = context.getPackageName();
    }

    public static android.net.Uri buildRawResourceUri(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i);
        return android.net.Uri.parse(sb.toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException {
        this.g = null;
        try {
            try {
                java.io.InputStream inputStream = this.i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.i = null;
                try {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptor = this.h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.h = null;
                        if (this.k) {
                            this.k = false;
                            transferEnded();
                        }
                    }
                } catch (java.io.IOException e) {
                    throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e);
                }
            } catch (java.io.IOException e2) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e2);
            }
        } catch (java.lang.Throwable th) {
            this.i = null;
            try {
                try {
                    android.content.res.AssetFileDescriptor assetFileDescriptor2 = this.h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.h = null;
                    if (this.k) {
                        this.k = false;
                        transferEnded();
                    }
                    throw th;
                } catch (java.io.IOException e3) {
                    throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e3);
                }
            } finally {
                this.h = null;
                if (this.k) {
                    this.k = false;
                    transferEnded();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException {
        int parseInt;
        android.net.Uri uri = dataSpec.uri;
        this.g = uri;
        if (android.text.TextUtils.equals("rawresource", uri.getScheme()) || (android.text.TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getLastPathSegment()));
            } catch (java.lang.NumberFormatException unused) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } else {
            if (!android.text.TextUtils.equals("android.resource", uri.getScheme())) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
            }
            java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getPath());
            if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str.substring(1);
            }
            java.lang.String host = uri.getHost();
            java.lang.String valueOf = java.lang.String.valueOf(android.text.TextUtils.isEmpty(host) ? "" : java.lang.String.valueOf(host).concat(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR));
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            parseInt = this.e.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new java.lang.String(valueOf), "raw", this.f);
            if (parseInt == 0) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException("Resource not found.");
            }
        }
        transferInitializing(dataSpec);
        android.content.res.AssetFileDescriptor openRawResourceFd = this.e.openRawResourceFd(parseInt);
        this.h = openRawResourceFd;
        if (openRawResourceFd == null) {
            java.lang.String valueOf3 = java.lang.String.valueOf(uri);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf3.length() + 24);
            sb.append("Resource is compressed: ");
            sb.append(valueOf3);
            throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(sb.toString());
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(openRawResourceFd.getFileDescriptor());
        this.i = fileInputStream;
        try {
            fileInputStream.skip(openRawResourceFd.getStartOffset());
            if (fileInputStream.skip(dataSpec.position) < dataSpec.position) {
                throw new java.io.EOFException();
            }
            long j = dataSpec.length;
            if (j != -1) {
                this.j = j;
            } else {
                long length = openRawResourceFd.getLength();
                this.j = length != -1 ? length - dataSpec.position : -1L;
            }
            this.k = true;
            transferStarted(dataSpec);
            return this.j;
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.j;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e);
            }
        }
        int read = ((java.io.InputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.i)).read(bArr, i, i2);
        if (read == -1) {
            if (this.j == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(new java.io.EOFException());
        }
        long j2 = this.j;
        if (j2 != -1) {
            this.j = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
