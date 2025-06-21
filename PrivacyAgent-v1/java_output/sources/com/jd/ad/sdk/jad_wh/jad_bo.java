package com.jd.ad.sdk.jad_wh;

/* loaded from: classes23.dex */
public class jad_bo implements com.jd.ad.sdk.jad_mx.jad_xk<java.io.File> {
    public final java.io.File jad_an;

    public jad_bo(java.io.File file) {
        if (file == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        this.jad_an = file;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public final java.io.File get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public final /* bridge */ /* synthetic */ int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public java.lang.Class<java.io.File> jad_cp() {
        return this.jad_an.getClass();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public /* bridge */ /* synthetic */ void jad_dq() {
    }
}
