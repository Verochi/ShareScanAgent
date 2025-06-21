package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_pc {
    public final com.jd.ad.sdk.jad_qb.jad_re jad_an;
    public final com.jd.ad.sdk.jad_qb.jad_pc.jad_an jad_bo;

    public static class jad_an {
        public final java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_qb.jad_pc.jad_an.C0406jad_an<?>> jad_an = new java.util.HashMap();

        /* renamed from: com.jd.ad.sdk.jad_qb.jad_pc$jad_an$jad_an, reason: collision with other inner class name */
        public static class C0406jad_an<Model> {
            public final java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, ?>> jad_an;

            public C0406jad_an(java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, ?>> list) {
                this.jad_an = list;
            }
        }
    }

    public jad_pc(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this(new com.jd.ad.sdk.jad_qb.jad_re(pool));
    }

    public jad_pc(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
        this.jad_bo = new com.jd.ad.sdk.jad_qb.jad_pc.jad_an();
        this.jad_an = jad_reVar;
    }
}
