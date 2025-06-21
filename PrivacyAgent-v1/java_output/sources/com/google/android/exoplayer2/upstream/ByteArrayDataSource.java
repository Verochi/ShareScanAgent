package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class ByteArrayDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public final byte[] e;

    @androidx.annotation.Nullable
    public android.net.Uri f;
    public int g;
    public int h;
    public boolean i;

    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        com.google.android.exoplayer2.util.Assertions.checkArgument(bArr.length > 0);
        this.e = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.i) {
            this.i = false;
            transferEnded();
        }
        this.f = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.f = dataSpec.uri;
        transferInitializing(dataSpec);
        long j = dataSpec.position;
        int i = (int) j;
        this.g = i;
        long j2 = dataSpec.length;
        if (j2 == -1) {
            j2 = this.e.length - j;
        }
        int i2 = (int) j2;
        this.h = i2;
        if (i2 > 0 && i + i2 <= this.e.length) {
            this.i = true;
            transferStarted(dataSpec);
            return this.h;
        }
        int i3 = this.g;
        long j3 = dataSpec.length;
        int length = this.e.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i3);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new java.io.IOException(sb.toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int min = java.lang.Math.min(i2, i3);
        java.lang.System.arraycopy(this.e, this.g, bArr, i, min);
        this.g += min;
        this.h -= min;
        bytesTransferred(min);
        return min;
    }
}
