package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_qd<K, A> extends com.jd.ad.sdk.jad_ox.jad_an<K, A> {
    public final A jad_iv;

    public jad_qd(com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar, @androidx.annotation.Nullable A a) {
        super(java.util.Collections.emptyList());
        jad_an(jad_cpVar);
        this.jad_iv = a;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public A jad_an(com.jd.ad.sdk.jad_yh.jad_an<K> jad_anVar, float f) {
        return jad_fs();
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public void jad_an(float f) {
        this.jad_dq = f;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public float jad_bo() {
        return 1.0f;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public A jad_fs() {
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        A a = this.jad_iv;
        float f = this.jad_dq;
        return jad_cpVar.jad_an(0.0f, 0.0f, a, a, f, f, f);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public void jad_jt() {
        if (this.jad_er != null) {
            super.jad_jt();
        }
    }
}
