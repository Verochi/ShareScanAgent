package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class y implements com.google.common.base.Supplier {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImplInternal n;

    public /* synthetic */ y(com.google.android.exoplayer2.ExoPlayerImplInternal exoPlayerImplInternal) {
        this.n = exoPlayerImplInternal;
    }

    @Override // com.google.common.base.Supplier
    public final java.lang.Object get() {
        java.lang.Boolean H;
        H = this.n.H();
        return H;
    }
}
