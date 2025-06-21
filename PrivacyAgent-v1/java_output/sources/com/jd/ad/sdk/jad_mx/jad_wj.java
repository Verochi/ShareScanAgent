package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public final class jad_wj<Z> implements com.jd.ad.sdk.jad_mx.jad_xk<Z>, com.jd.ad.sdk.jad_js.jad_an.jad_dq {
    public static final androidx.core.util.Pools.Pool<com.jd.ad.sdk.jad_mx.jad_wj<?>> jad_er = com.jd.ad.sdk.jad_js.jad_an.jad_an(20, new com.jd.ad.sdk.jad_mx.jad_wj.jad_an());
    public final com.jd.ad.sdk.jad_js.jad_dq jad_an = com.jd.ad.sdk.jad_js.jad_dq.jad_an();
    public com.jd.ad.sdk.jad_mx.jad_xk<Z> jad_bo;
    public boolean jad_cp;
    public boolean jad_dq;

    public class jad_an implements com.jd.ad.sdk.jad_js.jad_an.jad_bo<com.jd.ad.sdk.jad_mx.jad_wj<?>> {
        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_bo
        public com.jd.ad.sdk.jad_mx.jad_wj<?> jad_an() {
            return new com.jd.ad.sdk.jad_mx.jad_wj<>();
        }
    }

    @androidx.annotation.NonNull
    public static <Z> com.jd.ad.sdk.jad_mx.jad_wj<Z> jad_an(com.jd.ad.sdk.jad_mx.jad_xk<Z> jad_xkVar) {
        com.jd.ad.sdk.jad_mx.jad_wj<Z> jad_wjVar = (com.jd.ad.sdk.jad_mx.jad_wj) com.jd.ad.sdk.jad_ir.jad_kx.jad_an((com.jd.ad.sdk.jad_mx.jad_wj) ((com.jd.ad.sdk.jad_js.jad_an.jad_cp) jad_er).acquire());
        jad_wjVar.jad_dq = false;
        jad_wjVar.jad_cp = true;
        jad_wjVar.jad_bo = jad_xkVar;
        return jad_wjVar;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public Z get() {
        return this.jad_bo.get();
    }

    @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return this.jad_bo.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Class<Z> jad_cp() {
        return this.jad_bo.jad_cp();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public synchronized void jad_dq() {
        this.jad_an.jad_bo();
        this.jad_dq = true;
        if (!this.jad_cp) {
            this.jad_bo.jad_dq();
            this.jad_bo = null;
            ((com.jd.ad.sdk.jad_js.jad_an.jad_cp) jad_er).release(this);
        }
    }

    public synchronized void jad_er() {
        this.jad_an.jad_bo();
        if (!this.jad_cp) {
            throw new java.lang.IllegalStateException("Already unlocked");
        }
        this.jad_cp = false;
        if (this.jad_dq) {
            jad_dq();
        }
    }
}
