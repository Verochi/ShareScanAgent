package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_jw implements android.content.ComponentCallbacks2, com.jd.ad.sdk.jad_zk.jad_mz {
    public static final com.jd.ad.sdk.jad_en.jad_hu jad_kx;
    public final com.jd.ad.sdk.jad_gr.jad_cp jad_an;
    public final android.content.Context jad_bo;
    public final com.jd.ad.sdk.jad_zk.jad_ly jad_cp;

    @androidx.annotation.GuardedBy("this")
    public final com.jd.ad.sdk.jad_zk.jad_re jad_dq;

    @androidx.annotation.GuardedBy("this")
    public final com.jd.ad.sdk.jad_zk.jad_qd jad_er;

    @androidx.annotation.GuardedBy("this")
    public final com.jd.ad.sdk.jad_zk.jad_vi jad_fs = new com.jd.ad.sdk.jad_zk.jad_vi();
    public final com.jd.ad.sdk.jad_zk.jad_cp jad_hu;
    public final java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> jad_iv;
    public final java.lang.Runnable jad_jt;

    @androidx.annotation.GuardedBy("this")
    public com.jd.ad.sdk.jad_en.jad_hu jad_jw;

    public class jad_an implements java.lang.Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar = com.jd.ad.sdk.jad_gr.jad_jw.this;
            jad_jwVar.jad_cp.jad_bo(jad_jwVar);
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_zk.jad_cp.jad_an {

        @androidx.annotation.GuardedBy("RequestManager.this")
        public final com.jd.ad.sdk.jad_zk.jad_re jad_an;

        public jad_bo(com.jd.ad.sdk.jad_zk.jad_re jad_reVar) {
            this.jad_an = jad_reVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_cp.jad_an
        public void jad_an(boolean z) {
            if (z) {
                synchronized (com.jd.ad.sdk.jad_gr.jad_jw.this) {
                    com.jd.ad.sdk.jad_zk.jad_re jad_reVar = this.jad_an;
                    java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)).iterator();
                    while (it.hasNext()) {
                        com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_en.jad_dq) it.next();
                        if (!jad_dqVar.jad_cp() && !jad_dqVar.jad_er()) {
                            jad_dqVar.clear();
                            if (jad_reVar.jad_cp) {
                                jad_reVar.jad_bo.add(jad_dqVar);
                            } else {
                                jad_dqVar.jad_fs();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        com.jd.ad.sdk.jad_en.jad_hu jad_an2 = new com.jd.ad.sdk.jad_en.jad_hu().jad_an(android.graphics.Bitmap.class);
        jad_an2.jad_tg = true;
        jad_kx = jad_an2;
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class).jad_tg = true;
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_an(com.jd.ad.sdk.jad_gr.jad_jt.LOW).jad_an(true);
    }

    public jad_jw(com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, com.jd.ad.sdk.jad_zk.jad_ly jad_lyVar, com.jd.ad.sdk.jad_zk.jad_qd jad_qdVar, com.jd.ad.sdk.jad_zk.jad_re jad_reVar, com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar, android.content.Context context) {
        com.jd.ad.sdk.jad_gr.jad_jw.jad_an jad_anVar = new com.jd.ad.sdk.jad_gr.jad_jw.jad_an();
        this.jad_jt = jad_anVar;
        this.jad_an = jad_cpVar;
        this.jad_cp = jad_lyVar;
        this.jad_er = jad_qdVar;
        this.jad_dq = jad_reVar;
        this.jad_bo = context;
        com.jd.ad.sdk.jad_zk.jad_cp jad_an2 = ((com.jd.ad.sdk.jad_zk.jad_fs) jad_dqVar).jad_an(context.getApplicationContext(), new com.jd.ad.sdk.jad_gr.jad_jw.jad_bo(jad_reVar));
        this.jad_hu = jad_an2;
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
            com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_anVar);
        } else {
            jad_lyVar.jad_bo(this);
        }
        jad_lyVar.jad_bo(jad_an2);
        this.jad_iv = new java.util.concurrent.CopyOnWriteArrayList<>(jad_cpVar.jad_dq().jad_an());
        jad_an(jad_cpVar.jad_dq().jad_bo());
        jad_cpVar.jad_an(this);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.Nullable java.lang.String str) {
        return new com.jd.ad.sdk.jad_gr.jad_iv(this.jad_an, this, android.graphics.drawable.Drawable.class, this.jad_bo).jad_an(str);
    }

    @androidx.annotation.NonNull
    public <T> com.jd.ad.sdk.jad_gr.jad_kx<?, T> jad_an(java.lang.Class<T> cls) {
        com.jd.ad.sdk.jad_gr.jad_er jad_erVar = this.jad_an.jad_cp;
        com.jd.ad.sdk.jad_gr.jad_kx<?, T> jad_kxVar = (com.jd.ad.sdk.jad_gr.jad_kx) jad_erVar.jad_er.get(cls);
        if (jad_kxVar == null) {
            for (java.util.Map.Entry<java.lang.Class<?>, com.jd.ad.sdk.jad_gr.jad_kx<?, ?>> entry : jad_erVar.jad_er.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jad_kxVar = (com.jd.ad.sdk.jad_gr.jad_kx) entry.getValue();
                }
            }
        }
        return jad_kxVar == null ? (com.jd.ad.sdk.jad_gr.jad_kx<?, T>) com.jd.ad.sdk.jad_gr.jad_er.jad_jw : jad_kxVar;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_an() {
        synchronized (this) {
            com.jd.ad.sdk.jad_zk.jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = true;
            java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)).iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_en.jad_dq) it.next();
                if (jad_dqVar.isRunning()) {
                    jad_dqVar.jad_dq();
                    jad_reVar.jad_bo.add(jad_dqVar);
                }
            }
        }
        this.jad_fs.jad_an();
    }

    public synchronized void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_en.jad_hu jad_huVar) {
        com.jd.ad.sdk.jad_en.jad_hu clone = jad_huVar.clone();
        if (clone.jad_tg && !clone.jad_vi) {
            throw new java.lang.IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        clone.jad_vi = true;
        clone.jad_tg = true;
        this.jad_jw = clone;
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_fo.jad_er<?> jad_erVar) {
        boolean z;
        if (jad_erVar == null) {
            return;
        }
        boolean jad_bo2 = jad_bo(jad_erVar);
        com.jd.ad.sdk.jad_en.jad_dq jad_bo3 = jad_erVar.jad_bo();
        if (jad_bo2) {
            return;
        }
        com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            java.util.Iterator<com.jd.ad.sdk.jad_gr.jad_jw> it = jad_cpVar.jad_hu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().jad_bo(jad_erVar)) {
                    z = true;
                    break;
                }
            }
        }
        if (z || jad_bo3 == null) {
            return;
        }
        jad_erVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) null);
        jad_bo3.clear();
    }

    public synchronized boolean jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.jad_fo.jad_er<?> jad_erVar) {
        com.jd.ad.sdk.jad_en.jad_dq jad_bo2 = jad_erVar.jad_bo();
        if (jad_bo2 == null) {
            return true;
        }
        if (!this.jad_dq.jad_an(jad_bo2)) {
            return false;
        }
        this.jad_fs.jad_an.remove(jad_erVar);
        jad_erVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) null);
        return true;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_cp() {
        synchronized (this) {
            com.jd.ad.sdk.jad_zk.jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = false;
            java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)).iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_en.jad_dq) it.next();
                if (!jad_dqVar.jad_cp() && !jad_dqVar.isRunning()) {
                    jad_dqVar.jad_fs();
                }
            }
            jad_reVar.jad_bo.clear();
        }
        this.jad_fs.jad_cp();
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_dq() {
        this.jad_fs.jad_dq();
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_fs.jad_an)).iterator();
        while (it.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_fo.jad_er<?>) it.next());
        }
        this.jad_fs.jad_an.clear();
        com.jd.ad.sdk.jad_zk.jad_re jad_reVar = this.jad_dq;
        java.util.Iterator it2 = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)).iterator();
        while (it2.hasNext()) {
            jad_reVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) it2.next());
        }
        jad_reVar.jad_bo.clear();
        this.jad_cp.jad_an(this);
        this.jad_cp.jad_an(this.jad_hu);
        com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().removeCallbacks(this.jad_jt);
        com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            if (!jad_cpVar.jad_hu.contains(this)) {
                throw new java.lang.IllegalStateException("Cannot unregister not yet registered manager");
            }
            jad_cpVar.jad_hu.remove(this);
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap> jad_er() {
        return new com.jd.ad.sdk.jad_gr.jad_iv(this.jad_an, this, android.graphics.Bitmap.class, this.jad_bo).jad_bo(jad_kx);
    }

    public java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> jad_fs() {
        return this.jad_iv;
    }

    public synchronized com.jd.ad.sdk.jad_en.jad_hu jad_jt() {
        return this.jad_jw;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    public synchronized java.lang.String toString() {
        return super.toString() + "{tracker=" + this.jad_dq + ", treeNode=" + this.jad_er + com.alipay.sdk.m.u.i.d;
    }
}
