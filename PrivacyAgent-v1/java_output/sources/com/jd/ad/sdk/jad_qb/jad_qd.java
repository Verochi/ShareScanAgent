package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_qd<Model, Data> implements com.jd.ad.sdk.jad_qb.jad_na<Model, Data> {
    public final java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, Data>> jad_an;
    public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_bo;

    public static class jad_an<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data>, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<Data> {
        public final java.util.List<com.jd.ad.sdk.jad_kv.jad_dq<Data>> jad_an;
        public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_bo;
        public int jad_cp;
        public com.jd.ad.sdk.jad_gr.jad_jt jad_dq;
        public com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_er;

        @androidx.annotation.Nullable
        public java.util.List<java.lang.Throwable> jad_fs;
        public boolean jad_jt;

        public jad_an(@androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_kv.jad_dq<Data>> list, @androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
            this.jad_bo = pool;
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_an = list;
            this.jad_cp = 0;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<Data> jad_an() {
            return this.jad_an.get(0).jad_an();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            this.jad_dq = jad_jtVar;
            this.jad_er = jad_anVar;
            this.jad_fs = this.jad_bo.acquire();
            this.jad_an.get(this.jad_cp).jad_an(jad_jtVar, this);
            if (this.jad_jt) {
                jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
        public void jad_an(@androidx.annotation.NonNull java.lang.Exception exc) {
            ((java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_fs)).add(exc);
            jad_er();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
        public void jad_an(@androidx.annotation.Nullable Data data) {
            if (data != null) {
                this.jad_er.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data>) data);
            } else {
                jad_er();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            java.util.List<java.lang.Throwable> list = this.jad_fs;
            if (list != null) {
                this.jad_bo.release(list);
            }
            this.jad_fs = null;
            java.util.Iterator<com.jd.ad.sdk.jad_kv.jad_dq<Data>> it = this.jad_an.iterator();
            while (it.hasNext()) {
                it.next().jad_bo();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
            this.jad_jt = true;
            java.util.Iterator<com.jd.ad.sdk.jad_kv.jad_dq<Data>> it = this.jad_an.iterator();
            while (it.hasNext()) {
                it.next().jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return this.jad_an.get(0).jad_dq();
        }

        public final void jad_er() {
            if (this.jad_jt) {
                return;
            }
            if (this.jad_cp < this.jad_an.size() - 1) {
                this.jad_cp++;
                jad_an(this.jad_dq, this.jad_er);
            } else {
                com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_fs);
                this.jad_er.jad_an((java.lang.Exception) new com.jd.ad.sdk.jad_mx.jad_sf("Fetch failed", new java.util.ArrayList(this.jad_fs)));
            }
        }
    }

    public jad_qd(@androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, Data>> list, @androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.jad_an = list;
        this.jad_bo = pool;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<Data> jad_an(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<Data> jad_an2;
        int size = this.jad_an.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.jd.ad.sdk.jad_qb.jad_na<Model, Data> jad_naVar = this.jad_an.get(i3);
            if (jad_naVar.jad_an(model) && (jad_an2 = jad_naVar.jad_an(model, i, i2, jad_jwVar)) != null) {
                jad_huVar = jad_an2.jad_an;
                arrayList.add(jad_an2.jad_cp);
            }
        }
        if (arrayList.isEmpty() || jad_huVar == null) {
            return null;
        }
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(jad_huVar, java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_qd.jad_an(arrayList, this.jad_bo));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull Model model) {
        java.util.Iterator<com.jd.ad.sdk.jad_qb.jad_na<Model, Data>> it = this.jad_an.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an(model)) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("MultiModelLoader{modelLoaders=");
        jad_an2.append(java.util.Arrays.toString(this.jad_an.toArray()));
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
