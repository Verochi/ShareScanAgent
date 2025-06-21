package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public final class jad_jt<Transcode> {
    public final java.util.List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_an = new java.util.ArrayList();
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> jad_bo = new java.util.ArrayList();
    public com.jd.ad.sdk.jad_gr.jad_er jad_cp;
    public java.lang.Object jad_dq;
    public int jad_er;
    public int jad_fs;
    public com.jd.ad.sdk.jad_mx.jad_hu.jad_er jad_hu;
    public com.jd.ad.sdk.jad_ju.jad_jw jad_iv;
    public java.lang.Class<?> jad_jt;
    public java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> jad_jw;
    public java.lang.Class<Transcode> jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_na;
    public com.jd.ad.sdk.jad_gr.jad_jt jad_ob;
    public com.jd.ad.sdk.jad_mx.jad_ly jad_pc;
    public boolean jad_qd;
    public boolean jad_re;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r1 = (com.jd.ad.sdk.jad_ju.jad_dq<X>) r3.jad_bo;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <X> com.jd.ad.sdk.jad_ju.jad_dq<X> jad_an(X x) {
        com.jd.ad.sdk.jad_ju.jad_dq<X> jad_dqVar;
        com.jd.ad.sdk.jad_bm.jad_an jad_anVar = this.jad_cp.jad_bo.jad_bo;
        java.lang.Class<?> cls = x.getClass();
        synchronized (jad_anVar) {
            java.util.Iterator<com.jd.ad.sdk.jad_bm.jad_an.C0376jad_an<?>> it = jad_anVar.jad_an.iterator();
            while (true) {
                if (!it.hasNext()) {
                    jad_dqVar = null;
                    break;
                }
                com.jd.ad.sdk.jad_bm.jad_an.C0376jad_an<?> next = it.next();
                if (next.jad_an.isAssignableFrom(cls)) {
                    break;
                }
            }
        }
        if (jad_dqVar != null) {
            return jad_dqVar;
        }
        throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_er(x.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <Data> com.jd.ad.sdk.jad_mx.jad_vi<Data, ?, Transcode> jad_an(java.lang.Class<Data> cls) {
        com.jd.ad.sdk.jad_mx.jad_vi<Data, ?, Transcode> jad_viVar;
        java.util.ArrayList arrayList;
        com.jd.ad.sdk.jad_yj.jad_er jad_erVar;
        com.jd.ad.sdk.jad_yj.jad_er jad_erVar2;
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar = this.jad_cp.jad_bo;
        java.lang.Class<?> cls2 = this.jad_jt;
        java.lang.Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_bm.jad_cp jad_cpVar = jad_huVar.jad_iv;
        com.jd.ad.sdk.jad_ir.jad_jw andSet = jad_cpVar.jad_bo.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_ir.jad_jw();
        }
        andSet.jad_an = cls;
        andSet.jad_bo = cls2;
        andSet.jad_cp = cls3;
        synchronized (jad_cpVar.jad_an) {
            jad_viVar = (com.jd.ad.sdk.jad_mx.jad_vi) jad_cpVar.jad_an.get(andSet);
        }
        jad_cpVar.jad_bo.set(andSet);
        jad_huVar.jad_iv.getClass();
        if (com.jd.ad.sdk.jad_bm.jad_cp.jad_cp.equals(jad_viVar)) {
            return null;
        }
        if (jad_viVar != null) {
            return jad_viVar;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator it = ((java.util.ArrayList) jad_huVar.jad_cp.jad_an(cls, cls2)).iterator();
        while (it.hasNext()) {
            java.lang.Class<?> cls4 = (java.lang.Class) it.next();
            java.util.Iterator it2 = ((java.util.ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)).iterator();
            while (it2.hasNext()) {
                java.lang.Class cls5 = (java.lang.Class) it2.next();
                com.jd.ad.sdk.jad_bm.jad_er jad_erVar3 = jad_huVar.jad_cp;
                synchronized (jad_erVar3) {
                    arrayList = new java.util.ArrayList();
                    java.util.Iterator<java.lang.String> it3 = jad_erVar3.jad_an.iterator();
                    while (it3.hasNext()) {
                        java.util.List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>> list = jad_erVar3.jad_bo.get(it3.next());
                        if (list != null) {
                            for (com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?> jad_anVar : list) {
                                if (jad_anVar.jad_an.isAssignableFrom(cls) && cls4.isAssignableFrom(jad_anVar.jad_bo)) {
                                    arrayList.add(jad_anVar.jad_cp);
                                }
                            }
                        }
                    }
                }
                com.jd.ad.sdk.jad_yj.jad_fs jad_fsVar = jad_huVar.jad_fs;
                synchronized (jad_fsVar) {
                    if (!cls5.isAssignableFrom(cls4)) {
                        for (com.jd.ad.sdk.jad_yj.jad_fs.jad_an<?, ?> jad_anVar2 : jad_fsVar.jad_an) {
                            if (jad_anVar2.jad_an.isAssignableFrom(cls4) && cls5.isAssignableFrom(jad_anVar2.jad_bo)) {
                                jad_erVar = jad_anVar2.jad_cp;
                            }
                        }
                        throw new java.lang.IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                    }
                    jad_erVar = com.jd.ad.sdk.jad_yj.jad_jt.jad_an;
                    jad_erVar2 = jad_erVar;
                }
                arrayList2.add(new com.jd.ad.sdk.jad_mx.jad_kx(cls, cls4, cls5, arrayList, jad_erVar2, jad_huVar.jad_jw));
            }
        }
        com.jd.ad.sdk.jad_mx.jad_vi<Data, ?, Transcode> jad_viVar2 = arrayList2.isEmpty() ? null : new com.jd.ad.sdk.jad_mx.jad_vi<>(cls, cls2, cls3, arrayList2, jad_huVar.jad_jw);
        com.jd.ad.sdk.jad_bm.jad_cp jad_cpVar2 = jad_huVar.jad_iv;
        synchronized (jad_cpVar2.jad_an) {
            jad_cpVar2.jad_an.put(new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3), jad_viVar2 != null ? jad_viVar2 : com.jd.ad.sdk.jad_bm.jad_cp.jad_cp);
        }
        return jad_viVar2;
    }

    public java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> jad_an() {
        if (!this.jad_mz) {
            this.jad_mz = true;
            this.jad_bo.clear();
            java.util.List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_cp = jad_cp();
            int size = jad_cp.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = jad_cp.get(i);
                if (!this.jad_bo.contains(jad_anVar.jad_an)) {
                    this.jad_bo.add(jad_anVar.jad_an);
                }
                for (int i2 = 0; i2 < jad_anVar.jad_bo.size(); i2++) {
                    if (!this.jad_bo.contains(jad_anVar.jad_bo.get(i2))) {
                        this.jad_bo.add(jad_anVar.jad_bo.get(i2));
                    }
                }
            }
        }
        return this.jad_bo;
    }

    public boolean jad_an(com.jd.ad.sdk.jad_mx.jad_xk<?> jad_xkVar) {
        return this.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp()) != null;
    }

    public <Z> com.jd.ad.sdk.jad_ju.jad_na<Z> jad_bo(java.lang.Class<Z> cls) {
        com.jd.ad.sdk.jad_ju.jad_na<Z> jad_naVar = (com.jd.ad.sdk.jad_ju.jad_na) this.jad_jw.get(cls);
        if (jad_naVar == null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>>> it = this.jad_jw.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.util.Map.Entry<java.lang.Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    jad_naVar = (com.jd.ad.sdk.jad_ju.jad_na) next.getValue();
                    break;
                }
            }
        }
        if (jad_naVar != null) {
            return jad_naVar;
        }
        if (!this.jad_jw.isEmpty() || !this.jad_qd) {
            return (com.jd.ad.sdk.jad_sd.jad_bo) com.jd.ad.sdk.jad_sd.jad_bo.jad_bo;
        }
        throw new java.lang.IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public com.jd.ad.sdk.jad_oz.jad_an jad_bo() {
        return ((com.jd.ad.sdk.jad_mx.jad_mz.jad_cp) this.jad_hu).jad_an();
    }

    public java.util.List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_cp() {
        if (!this.jad_ly) {
            this.jad_ly = true;
            this.jad_an.clear();
            java.util.List jad_an = this.jad_cp.jad_bo.jad_an((com.jd.ad.sdk.jad_gr.jad_hu) this.jad_dq);
            int size = jad_an.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_an2 = ((com.jd.ad.sdk.jad_qb.jad_na) jad_an.get(i)).jad_an(this.jad_dq, this.jad_er, this.jad_fs, this.jad_iv);
                if (jad_an2 != null) {
                    this.jad_an.add(jad_an2);
                }
            }
        }
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean jad_cp(java.lang.Class<?> cls) {
        return jad_an((java.lang.Class) cls) != null;
    }

    public java.util.List<java.lang.Class<?>> jad_dq() {
        java.util.List<java.lang.Class<?>> list;
        java.util.ArrayList arrayList;
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar = this.jad_cp.jad_bo;
        java.lang.Class<?> cls = this.jad_dq.getClass();
        java.lang.Class<?> cls2 = this.jad_jt;
        java.lang.Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_bm.jad_dq jad_dqVar = jad_huVar.jad_hu;
        com.jd.ad.sdk.jad_ir.jad_jw andSet = jad_dqVar.jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3);
        } else {
            andSet.jad_an = cls;
            andSet.jad_bo = cls2;
            andSet.jad_cp = cls3;
        }
        synchronized (jad_dqVar.jad_bo) {
            list = jad_dqVar.jad_bo.get(andSet);
        }
        jad_dqVar.jad_an.set(andSet);
        java.util.List<java.lang.Class<?>> list2 = list;
        if (list == null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            com.jd.ad.sdk.jad_qb.jad_pc jad_pcVar = jad_huVar.jad_an;
            synchronized (jad_pcVar) {
                com.jd.ad.sdk.jad_qb.jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    arrayList = new java.util.ArrayList();
                    for (com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                        if (!arrayList.contains(jad_boVar.jad_bo) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                            arrayList.add(jad_boVar.jad_bo);
                        }
                    }
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                java.util.Iterator it2 = ((java.util.ArrayList) jad_huVar.jad_cp.jad_an((java.lang.Class) it.next(), cls2)).iterator();
                while (it2.hasNext()) {
                    java.lang.Class cls4 = (java.lang.Class) it2.next();
                    if (!((java.util.ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            com.jd.ad.sdk.jad_bm.jad_dq jad_dqVar2 = jad_huVar.jad_hu;
            java.util.List<java.lang.Class<?>> unmodifiableList = java.util.Collections.unmodifiableList(arrayList2);
            synchronized (jad_dqVar2.jad_bo) {
                jad_dqVar2.jad_bo.put(new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3), unmodifiableList);
            }
            list2 = arrayList2;
        }
        return list2;
    }
}
