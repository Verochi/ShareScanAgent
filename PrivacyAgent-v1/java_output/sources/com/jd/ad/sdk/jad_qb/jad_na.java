package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public interface jad_na<Model, Data> {

    public static class jad_an<Data> {
        public final com.jd.ad.sdk.jad_ju.jad_hu jad_an;
        public final java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> jad_bo;
        public final com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_cp;

        public jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, @androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> list, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar) {
            this.jad_an = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
            this.jad_bo = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_cp = (com.jd.ad.sdk.jad_kv.jad_dq) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_dqVar);
        }
    }

    @androidx.annotation.Nullable
    com.jd.ad.sdk.jad_qb.jad_na.jad_an<Data> jad_an(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar);

    boolean jad_an(@androidx.annotation.NonNull Model model);
}
