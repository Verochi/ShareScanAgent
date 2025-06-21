package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public abstract class BaseDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final boolean a;
    public final java.util.ArrayList<com.google.android.exoplayer2.upstream.TransferListener> b = new java.util.ArrayList<>(1);
    public int c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSpec d;

    public BaseDataSource(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        if (this.b.contains(transferListener)) {
            return;
        }
        this.b.add(transferListener);
        this.c++;
    }

    public final void bytesTransferred(int i) {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Util.castNonNull(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.get(i2).onBytesTransferred(this, dataSpec, this.a, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ java.util.Map getResponseHeaders() {
        return defpackage.yv.a(this);
    }

    public final void transferEnded() {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Util.castNonNull(this.d);
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferEnd(this, dataSpec, this.a);
        }
        this.d = null;
    }

    public final void transferInitializing(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferInitializing(this, dataSpec, this.a);
        }
    }

    public final void transferStarted(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        this.d = dataSpec;
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferStart(this, dataSpec, this.a);
        }
    }
}
