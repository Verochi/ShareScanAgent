package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
final class IcyDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public final int b;
    public final com.google.android.exoplayer2.source.IcyDataSource.Listener c;
    public final byte[] d;
    public int e;

    public interface Listener {
        void onIcyMetadata(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.source.IcyDataSource.Listener listener) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        this.a = dataSource;
        this.b = i;
        this.c = listener;
        this.d = new byte[1];
        this.e = i;
    }

    public final boolean a() throws java.io.IOException {
        if (this.a.read(this.d, 0, 1) == -1) {
            return false;
        }
        int i = (this.d[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int read = this.a.read(bArr, i3, i2);
            if (read == -1) {
                return false;
            }
            i3 += read;
            i2 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.c.onIcyMetadata(new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.e == 0) {
            if (!a()) {
                return -1;
            }
            this.e = this.b;
        }
        int read = this.a.read(bArr, i, java.lang.Math.min(this.e, i2));
        if (read != -1) {
            this.e -= read;
        }
        return read;
    }
}
