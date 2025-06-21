package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_hu {
    public final com.jd.ad.sdk.jad_qb.jad_pc jad_an;
    public final com.jd.ad.sdk.jad_bm.jad_an jad_bo;
    public final com.jd.ad.sdk.jad_bm.jad_er jad_cp;
    public final com.jd.ad.sdk.jad_bm.jad_fs jad_dq;
    public final com.jd.ad.sdk.jad_kv.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_yj.jad_fs jad_fs;
    public final com.jd.ad.sdk.jad_bm.jad_dq jad_hu = new com.jd.ad.sdk.jad_bm.jad_dq();
    public final com.jd.ad.sdk.jad_bm.jad_cp jad_iv = new com.jd.ad.sdk.jad_bm.jad_cp();
    public final com.jd.ad.sdk.jad_bm.jad_bo jad_jt;
    public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_jw;

    public static class jad_an extends java.lang.RuntimeException {
        public jad_an(@androidx.annotation.NonNull java.lang.String str) {
            super(str);
        }
    }

    public static final class jad_bo extends com.jd.ad.sdk.jad_gr.jad_hu.jad_an {
        public jad_bo() {
            super("Failed to find image header parser.");
        }
    }

    public static class jad_cp extends com.jd.ad.sdk.jad_gr.jad_hu.jad_an {
        public jad_cp(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public jad_cp(@androidx.annotation.NonNull java.lang.Object obj) {
            super(r0.toString());
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed to find any ModelLoaders registered for model class: ");
            jad_an.append(obj.getClass());
        }

        public <M> jad_cp(@androidx.annotation.NonNull M m, @androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_qb.jad_na<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    public static class jad_dq extends com.jd.ad.sdk.jad_gr.jad_hu.jad_an {
        public jad_dq(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class jad_er extends com.jd.ad.sdk.jad_gr.jad_hu.jad_an {
        public jad_er(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public jad_hu() {
        androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_an2 = com.jd.ad.sdk.jad_js.jad_an.jad_an();
        this.jad_jw = jad_an2;
        this.jad_an = new com.jd.ad.sdk.jad_qb.jad_pc(jad_an2);
        this.jad_bo = new com.jd.ad.sdk.jad_bm.jad_an();
        this.jad_cp = new com.jd.ad.sdk.jad_bm.jad_er();
        this.jad_dq = new com.jd.ad.sdk.jad_bm.jad_fs();
        this.jad_er = new com.jd.ad.sdk.jad_kv.jad_fs();
        this.jad_fs = new com.jd.ad.sdk.jad_yj.jad_fs();
        this.jad_jt = new com.jd.ad.sdk.jad_bm.jad_bo();
        jad_an(java.util.Arrays.asList("Animation", com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_bm.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            jad_boVar.jad_an.add(jad_fsVar);
        }
        return this;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_anVar) {
        com.jd.ad.sdk.jad_kv.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.put(jad_anVar.jad_an(), jad_anVar);
        }
        return this;
    }

    @androidx.annotation.NonNull
    public <Data> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_dq<Data> jad_dqVar) {
        com.jd.ad.sdk.jad_bm.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_anVar) {
            jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_bm.jad_an.C0376jad_an<>(cls, jad_dqVar));
        }
        return this;
    }

    @androidx.annotation.NonNull
    public <TResource> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_mz<TResource> jad_mzVar) {
        com.jd.ad.sdk.jad_bm.jad_fs jad_fsVar = this.jad_dq;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new com.jd.ad.sdk.jad_bm.jad_fs.jad_an<>(cls, jad_mzVar));
        }
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_ly<Data, TResource> jad_lyVar) {
        jad_an("legacy_append", cls, cls2, jad_lyVar);
        return this;
    }

    @androidx.annotation.NonNull
    public <Model, Data> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_ob<Model, Data> jad_obVar) {
        com.jd.ad.sdk.jad_qb.jad_pc jad_pcVar = this.jad_an;
        synchronized (jad_pcVar) {
            com.jd.ad.sdk.jad_qb.jad_re jad_reVar = jad_pcVar.jad_an;
            synchronized (jad_reVar) {
                com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> jad_boVar = new com.jd.ad.sdk.jad_qb.jad_re.jad_bo<>(cls, cls2, jad_obVar);
                java.util.List<com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?>> list = jad_reVar.jad_an;
                list.add(list.size(), jad_boVar);
            }
            jad_pcVar.jad_bo.jad_an.clear();
        }
        return this;
    }

    @androidx.annotation.NonNull
    public <TResource, Transcode> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull java.lang.Class<Transcode> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_yj.jad_er<TResource, Transcode> jad_erVar) {
        com.jd.ad.sdk.jad_yj.jad_fs jad_fsVar = this.jad_fs;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new com.jd.ad.sdk.jad_yj.jad_fs.jad_an<>(cls, cls2, jad_erVar));
        }
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_ly<Data, TResource> jad_lyVar) {
        java.util.List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>> list;
        com.jd.ad.sdk.jad_bm.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            synchronized (jad_erVar) {
                if (!jad_erVar.jad_an.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
                list = jad_erVar.jad_bo.get(str);
                if (list == null) {
                    list = new java.util.ArrayList<>();
                    jad_erVar.jad_bo.put(str, list);
                }
            }
            return this;
        }
        list.add(new com.jd.ad.sdk.jad_bm.jad_er.jad_an<>(cls, cls2, jad_lyVar));
        return this;
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_gr.jad_hu jad_an(@androidx.annotation.NonNull java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        com.jd.ad.sdk.jad_bm.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(jad_erVar.jad_an);
            jad_erVar.jad_an.clear();
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                jad_erVar.jad_an.add((java.lang.String) it2.next());
            }
            java.util.Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                java.lang.String str = (java.lang.String) it3.next();
                if (!arrayList.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
            }
        }
        return this;
    }

    @androidx.annotation.NonNull
    public java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an() {
        java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list;
        com.jd.ad.sdk.jad_bm.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            list = jad_boVar.jad_an;
        }
        if (list.isEmpty()) {
            throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_bo();
        }
        return list;
    }

    @androidx.annotation.NonNull
    public <Model> java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, ?>> jad_an(@androidx.annotation.NonNull Model model) {
        java.util.List<com.jd.ad.sdk.jad_qb.jad_na<?, ?>> list;
        java.util.ArrayList arrayList;
        com.jd.ad.sdk.jad_qb.jad_pc jad_pcVar = this.jad_an;
        jad_pcVar.getClass();
        java.lang.Class<?> cls = model.getClass();
        synchronized (jad_pcVar) {
            com.jd.ad.sdk.jad_qb.jad_pc.jad_an.C0406jad_an<?> c0406jad_an = jad_pcVar.jad_bo.jad_an.get(cls);
            list = c0406jad_an == null ? null : c0406jad_an.jad_an;
            if (list == null) {
                com.jd.ad.sdk.jad_qb.jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    try {
                        arrayList = new java.util.ArrayList();
                        for (com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                            if (!jad_reVar.jad_cp.contains(jad_boVar) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                                jad_reVar.jad_cp.add(jad_boVar);
                                arrayList.add((com.jd.ad.sdk.jad_qb.jad_na) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(jad_reVar)));
                                jad_reVar.jad_cp.remove(jad_boVar);
                            }
                        }
                    } finally {
                    }
                }
                list = java.util.Collections.unmodifiableList(arrayList);
                if (jad_pcVar.jad_bo.jad_an.put(cls, new com.jd.ad.sdk.jad_qb.jad_pc.jad_an.C0406jad_an<>(list)) != null) {
                    throw new java.lang.IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (list.isEmpty()) {
            throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_cp(model);
        }
        int size = list.size();
        java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, ?>> emptyList = java.util.Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            com.jd.ad.sdk.jad_qb.jad_na<?, ?> jad_naVar = list.get(i);
            if (jad_naVar.jad_an(model)) {
                if (z) {
                    emptyList = new java.util.ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(jad_naVar);
            }
        }
        if (emptyList.isEmpty()) {
            throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_cp(model, (java.util.List<com.jd.ad.sdk.jad_qb.jad_na<Model, ?>>) list);
        }
        return emptyList;
    }

    @androidx.annotation.NonNull
    public <X> com.jd.ad.sdk.jad_kv.jad_er<X> jad_bo(@androidx.annotation.NonNull X x) {
        com.jd.ad.sdk.jad_kv.jad_er<X> jad_erVar;
        com.jd.ad.sdk.jad_kv.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            if (x == null) {
                throw new java.lang.NullPointerException("Argument must not be null");
            }
            com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_anVar = jad_fsVar.jad_an.get(x.getClass());
            if (jad_anVar == null) {
                java.util.Iterator<com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>> it = jad_fsVar.jad_an.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> next = it.next();
                    if (next.jad_an().isAssignableFrom(x.getClass())) {
                        jad_anVar = next;
                        break;
                    }
                }
            }
            if (jad_anVar == null) {
                jad_anVar = com.jd.ad.sdk.jad_kv.jad_fs.jad_bo;
            }
            jad_erVar = (com.jd.ad.sdk.jad_kv.jad_er<X>) jad_anVar.jad_an(x);
        }
        return jad_erVar;
    }
}
