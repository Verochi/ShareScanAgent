package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class z implements com.google.common.base.Supplier {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImplInternal n;

    public /* synthetic */ z(com.google.android.exoplayer2.ExoPlayerImplInternal exoPlayerImplInternal) {
        this.n = exoPlayerImplInternal;
    }

    @Override // com.google.common.base.Supplier
    public final java.lang.Object get() {
        java.lang.Boolean I;
        I = this.n.I();
        return I;
    }
}
