package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DataSchemeDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final java.lang.String SCHEME_DATA = "data";

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSpec e;

    @androidx.annotation.Nullable
    public byte[] f;
    public int g;
    public int h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f != null) {
            this.f = null;
            transferEnded();
        }
        this.e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = this.e;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        transferInitializing(dataSpec);
        this.e = dataSpec;
        this.h = (int) dataSpec.position;
        android.net.Uri uri = dataSpec.uri;
        java.lang.String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            java.lang.String valueOf = java.lang.String.valueOf(scheme);
            throw new com.google.android.exoplayer2.ParserException(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new java.lang.String("Unsupported scheme: "));
        }
        java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(uri.getSchemeSpecificPart(), ",");
        if (split.length != 2) {
            java.lang.String valueOf2 = java.lang.String.valueOf(uri);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf2.length() + 23);
            sb.append("Unexpected URI format: ");
            sb.append(valueOf2);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
        java.lang.String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.f = android.util.Base64.decode(str, 0);
            } catch (java.lang.IllegalArgumentException e) {
                java.lang.String valueOf3 = java.lang.String.valueOf(str);
                throw new com.google.android.exoplayer2.ParserException(valueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf3) : new java.lang.String("Error while parsing Base64 encoded string: "), e);
            }
        } else {
            this.f = com.google.android.exoplayer2.util.Util.getUtf8Bytes(java.net.URLDecoder.decode(str, com.google.common.base.Charsets.US_ASCII.name()));
        }
        long j = dataSpec.length;
        int length = j != -1 ? ((int) j) + this.h : this.f.length;
        this.g = length;
        if (length > this.f.length || this.h > length) {
            this.f = null;
            throw new com.google.android.exoplayer2.upstream.DataSourceException(0);
        }
        transferStarted(dataSpec);
        return this.g - this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.g - this.h;
        if (i3 == 0) {
            return -1;
        }
        int min = java.lang.Math.min(i2, i3);
        java.lang.System.arraycopy(com.google.android.exoplayer2.util.Util.castNonNull(this.f), this.h, bArr, i, min);
        this.h += min;
        bytesTransferred(min);
        return min;
    }
}
