package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_vi<Model> implements com.jd.ad.sdk.jad_qb.jad_na<Model, Model> {
    public static final com.jd.ad.sdk.jad_qb.jad_vi<?> jad_an = new com.jd.ad.sdk.jad_qb.jad_vi<>();

    public static class jad_an<Model> implements com.jd.ad.sdk.jad_qb.jad_ob<Model, Model> {
        public static final com.jd.ad.sdk.jad_qb.jad_vi.jad_an<?> jad_an = new com.jd.ad.sdk.jad_qb.jad_vi.jad_an<>();

        @java.lang.Deprecated
        public jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<Model, Model> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return com.jd.ad.sdk.jad_qb.jad_vi.jad_an;
        }
    }

    public static class jad_bo<Model> implements com.jd.ad.sdk.jad_kv.jad_dq<Model> {
        public final Model jad_an;

        public jad_bo(Model model) {
            this.jad_an = model;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<Model> jad_an() {
            return (java.lang.Class<Model>) this.jad_an.getClass();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Model> jad_anVar) {
            jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Model>) this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    @java.lang.Deprecated
    public jad_vi() {
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<Model> jad_an(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(model), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_vi.jad_bo(model));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull Model model) {
        return true;
    }
}
