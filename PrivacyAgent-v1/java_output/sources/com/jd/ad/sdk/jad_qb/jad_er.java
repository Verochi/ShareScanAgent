package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public final class jad_er<Model, Data> implements com.jd.ad.sdk.jad_qb.jad_na<Model, Data> {
    public final com.jd.ad.sdk.jad_qb.jad_er.jad_an<Data> jad_an;

    public interface jad_an<Data> {
    }

    public static final class jad_bo<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final java.lang.String jad_an;
        public final com.jd.ad.sdk.jad_qb.jad_er.jad_an<Data> jad_bo;
        public Data jad_cp;

        public jad_bo(java.lang.String str, com.jd.ad.sdk.jad_qb.jad_er.jad_an<Data> jad_anVar) {
            this.jad_an = str;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<Data> jad_an() {
            ((com.jd.ad.sdk.jad_qb.jad_er.jad_cp.jad_an) this.jad_bo).getClass();
            return java.io.InputStream.class;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [Data, java.lang.Object] */
        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            try {
                ?? r2 = (Data) ((com.jd.ad.sdk.jad_qb.jad_er.jad_cp.jad_an) this.jad_bo).jad_an(this.jad_an);
                this.jad_cp = r2;
                jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data>) r2);
            } catch (java.lang.IllegalArgumentException e) {
                jad_anVar.jad_an((java.lang.Exception) e);
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            try {
                com.jd.ad.sdk.jad_qb.jad_er.jad_an<Data> jad_anVar = this.jad_bo;
                Data data = this.jad_cp;
                ((com.jd.ad.sdk.jad_qb.jad_er.jad_cp.jad_an) jad_anVar).getClass();
                ((java.io.InputStream) data).close();
            } catch (java.io.IOException unused) {
            }
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

    public static final class jad_cp<Model> implements com.jd.ad.sdk.jad_qb.jad_ob<Model, java.io.InputStream> {
        public final com.jd.ad.sdk.jad_qb.jad_er.jad_an<java.io.InputStream> jad_an = new com.jd.ad.sdk.jad_qb.jad_er.jad_cp.jad_an(this);

        public class jad_an implements com.jd.ad.sdk.jad_qb.jad_er.jad_an<java.io.InputStream> {
            public jad_an(com.jd.ad.sdk.jad_qb.jad_er.jad_cp jad_cpVar) {
            }

            public java.lang.Object jad_an(java.lang.String str) {
                if (!str.startsWith("data:image")) {
                    throw new java.lang.IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new java.lang.IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, indexOf).endsWith(";base64")) {
                    return new java.io.ByteArrayInputStream(android.util.Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new java.lang.IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<Model, java.io.InputStream> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_er(this.jad_an);
        }
    }

    public jad_er(com.jd.ad.sdk.jad_qb.jad_er.jad_an<Data> jad_anVar) {
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<Data> jad_an(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(model), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_er.jad_bo(model.toString(), this.jad_an));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
