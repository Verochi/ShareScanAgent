package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_re {
    public static final com.jd.ad.sdk.jad_qb.jad_re.jad_cp jad_er = new com.jd.ad.sdk.jad_qb.jad_re.jad_cp();
    public static final com.jd.ad.sdk.jad_qb.jad_na<java.lang.Object, java.lang.Object> jad_fs = new com.jd.ad.sdk.jad_qb.jad_re.jad_an();
    public final java.util.List<com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?>> jad_an;
    public final com.jd.ad.sdk.jad_qb.jad_re.jad_cp jad_bo;
    public final java.util.Set<com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?>> jad_cp;
    public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_dq;

    public static class jad_an implements com.jd.ad.sdk.jad_qb.jad_na<java.lang.Object, java.lang.Object> {
        @Override // com.jd.ad.sdk.jad_qb.jad_na
        @androidx.annotation.Nullable
        public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.lang.Object> jad_an(@androidx.annotation.NonNull java.lang.Object obj, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            return null;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_na
        public boolean jad_an(@androidx.annotation.NonNull java.lang.Object obj) {
            return false;
        }
    }

    public static class jad_bo<Model, Data> {
        public final java.lang.Class<Model> jad_an;
        public final java.lang.Class<Data> jad_bo;
        public final com.jd.ad.sdk.jad_qb.jad_ob<? extends Model, ? extends Data> jad_cp;

        public jad_bo(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_ob<? extends Model, ? extends Data> jad_obVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_obVar;
        }
    }

    public static class jad_cp {
    }

    public jad_re(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this(pool, jad_er);
    }

    @androidx.annotation.VisibleForTesting
    public jad_re(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool, @androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re.jad_cp jad_cpVar) {
        this.jad_an = new java.util.ArrayList();
        this.jad_cp = new java.util.HashSet();
        this.jad_dq = pool;
        this.jad_bo = jad_cpVar;
    }

    @androidx.annotation.NonNull
    public final <Model, Data> com.jd.ad.sdk.jad_qb.jad_na<Model, Data> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> jad_boVar) {
        return (com.jd.ad.sdk.jad_qb.jad_na) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(this));
    }

    @androidx.annotation.NonNull
    public synchronized <Model, Data> com.jd.ad.sdk.jad_qb.jad_na<Model, Data> jad_an(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?>> it = this.jad_an.iterator();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> next = it.next();
                if (this.jad_cp.contains(next)) {
                    z = true;
                } else {
                    if (!next.jad_an.isAssignableFrom(cls) || !next.jad_bo.isAssignableFrom(cls2)) {
                        z2 = false;
                    }
                    if (z2) {
                        this.jad_cp.add(next);
                        arrayList.add(jad_an(next));
                        this.jad_cp.remove(next);
                    }
                }
            }
            if (arrayList.size() > 1) {
                com.jd.ad.sdk.jad_qb.jad_re.jad_cp jad_cpVar = this.jad_bo;
                androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool = this.jad_dq;
                jad_cpVar.getClass();
                return new com.jd.ad.sdk.jad_qb.jad_qd(arrayList, pool);
            }
            if (arrayList.size() == 1) {
                return (com.jd.ad.sdk.jad_qb.jad_na) arrayList.get(0);
            }
            if (!z) {
                throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_cp((java.lang.Class<?>) cls, (java.lang.Class<?>) cls2);
            }
            return (com.jd.ad.sdk.jad_qb.jad_na<Model, Data>) jad_fs;
        } catch (java.lang.Throwable th) {
            this.jad_cp.clear();
            throw th;
        }
    }
}
