package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class PriorityDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public final com.google.android.exoplayer2.util.PriorityTaskManager b;
    public final int c;

    public PriorityDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i) {
        this.a = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
        this.b = (com.google.android.exoplayer2.util.PriorityTaskManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(priorityTaskManager);
        this.c = i;
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
        this.b.proceedOrThrow(this.c);
        return this.a.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.b.proceedOrThrow(this.c);
        return this.a.read(bArr, i, i2);
    }
}
