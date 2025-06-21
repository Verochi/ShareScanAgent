package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class StatsDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public long b;
    public android.net.Uri c = android.net.Uri.EMPTY;
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> d = java.util.Collections.emptyMap();

    public StatsDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.a = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        this.a.close();
    }

    public long getBytesRead() {
        return this.b;
    }

    public android.net.Uri getLastOpenedUri() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getLastResponseHeaders() {
        return this.d;
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
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.c = dataSpec.uri;
        this.d = java.util.Collections.emptyMap();
        long open = this.a.open(dataSpec);
        this.c = (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(getUri());
        this.d = getResponseHeaders();
        return open;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = this.a.read(bArr, i, i2);
        if (read != -1) {
            this.b += read;
        }
        return read;
    }

    public void resetBytesRead() {
        this.b = 0L;
    }
}
