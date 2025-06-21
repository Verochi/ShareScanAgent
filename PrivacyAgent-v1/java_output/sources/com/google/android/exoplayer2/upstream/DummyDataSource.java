package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DummyDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public static final com.google.android.exoplayer2.upstream.DummyDataSource INSTANCE = new com.google.android.exoplayer2.upstream.DummyDataSource();
    public static final com.google.android.exoplayer2.upstream.DataSource.Factory FACTORY = new defpackage.a70();

    public static /* synthetic */ com.google.android.exoplayer2.upstream.DummyDataSource a() {
        return new com.google.android.exoplayer2.upstream.DummyDataSource();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ java.util.Map getResponseHeaders() {
        return defpackage.yv.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        throw new java.io.IOException("DummyDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        throw new java.lang.UnsupportedOperationException();
    }
}
