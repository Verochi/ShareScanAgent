package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_na<R> implements com.jd.ad.sdk.jad_mx.jad_hu.jad_bo<R>, com.jd.ad.sdk.jad_js.jad_an.jad_dq {
    public static final com.jd.ad.sdk.jad_mx.jad_na.jad_cp jad_zm = new com.jd.ad.sdk.jad_mx.jad_na.jad_cp();
    public final com.jd.ad.sdk.jad_mx.jad_re.jad_an jad_cp;
    public final androidx.core.util.Pools.Pool<com.jd.ad.sdk.jad_mx.jad_na<?>> jad_dq;
    public final com.jd.ad.sdk.jad_mx.jad_na.jad_cp jad_er;
    public final com.jd.ad.sdk.jad_mx.jad_ob jad_fs;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_hu;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_iv;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_jt;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_jw;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public boolean jad_ob;
    public boolean jad_pc;
    public com.jd.ad.sdk.jad_mx.jad_xk<?> jad_qd;
    public com.jd.ad.sdk.jad_ju.jad_an jad_re;
    public boolean jad_sf;
    public com.jd.ad.sdk.jad_mx.jad_sf jad_tg;
    public boolean jad_uh;
    public com.jd.ad.sdk.jad_mx.jad_re<?> jad_vi;
    public com.jd.ad.sdk.jad_mx.jad_hu<R> jad_wj;
    public volatile boolean jad_xk;
    public boolean jad_yl;
    public final com.jd.ad.sdk.jad_mx.jad_na.jad_er jad_an = new com.jd.ad.sdk.jad_mx.jad_na.jad_er();
    public final com.jd.ad.sdk.jad_js.jad_dq jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();
    public final java.util.concurrent.atomic.AtomicInteger jad_kx = new java.util.concurrent.atomic.AtomicInteger();

    public class jad_an implements java.lang.Runnable {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;

        public jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_en.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_en.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (com.jd.ad.sdk.jad_mx.jad_na.this) {
                    if (com.jd.ad.sdk.jad_mx.jad_na.this.jad_an.jad_an.contains(new com.jd.ad.sdk.jad_mx.jad_na.jad_dq(this.jad_an, com.jd.ad.sdk.jad_ir.jad_er.jad_bo))) {
                        com.jd.ad.sdk.jad_mx.jad_na jad_naVar = com.jd.ad.sdk.jad_mx.jad_na.this;
                        com.jd.ad.sdk.jad_en.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_en.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_tg, 5);
                        } catch (java.lang.Throwable th) {
                            throw new com.jd.ad.sdk.jad_mx.jad_bo(th);
                        }
                    }
                    com.jd.ad.sdk.jad_mx.jad_na.this.jad_bo();
                }
            }
        }
    }

    public class jad_bo implements java.lang.Runnable {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;

        public jad_bo(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_en.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_en.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (com.jd.ad.sdk.jad_mx.jad_na.this) {
                    if (com.jd.ad.sdk.jad_mx.jad_na.this.jad_an.jad_an.contains(new com.jd.ad.sdk.jad_mx.jad_na.jad_dq(this.jad_an, com.jd.ad.sdk.jad_ir.jad_er.jad_bo))) {
                        com.jd.ad.sdk.jad_mx.jad_na.this.jad_vi.jad_an();
                        com.jd.ad.sdk.jad_mx.jad_na jad_naVar = com.jd.ad.sdk.jad_mx.jad_na.this;
                        com.jd.ad.sdk.jad_en.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_en.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_vi, jad_naVar.jad_re, jad_naVar.jad_yl);
                            com.jd.ad.sdk.jad_mx.jad_na.this.jad_an(this.jad_an);
                        } catch (java.lang.Throwable th) {
                            throw new com.jd.ad.sdk.jad_mx.jad_bo(th);
                        }
                    }
                    com.jd.ad.sdk.jad_mx.jad_na.this.jad_bo();
                }
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class jad_cp {
    }

    public static final class jad_dq {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;
        public final java.util.concurrent.Executor jad_bo;

        public jad_dq(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar, java.util.concurrent.Executor executor) {
            this.jad_an = jad_ivVar;
            this.jad_bo = executor;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.jd.ad.sdk.jad_mx.jad_na.jad_dq) {
                return this.jad_an.equals(((com.jd.ad.sdk.jad_mx.jad_na.jad_dq) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }
    }

    public static final class jad_er implements java.lang.Iterable<com.jd.ad.sdk.jad_mx.jad_na.jad_dq> {
        public final java.util.List<com.jd.ad.sdk.jad_mx.jad_na.jad_dq> jad_an;

        public jad_er() {
            this(new java.util.ArrayList(2));
        }

        public jad_er(java.util.List<com.jd.ad.sdk.jad_mx.jad_na.jad_dq> list) {
            this.jad_an = list;
        }

        @Override // java.lang.Iterable
        @androidx.annotation.NonNull
        public java.util.Iterator<com.jd.ad.sdk.jad_mx.jad_na.jad_dq> iterator() {
            return this.jad_an.iterator();
        }
    }

    @androidx.annotation.VisibleForTesting
    public jad_na(com.jd.ad.sdk.jad_pa.jad_an jad_anVar, com.jd.ad.sdk.jad_pa.jad_an jad_anVar2, com.jd.ad.sdk.jad_pa.jad_an jad_anVar3, com.jd.ad.sdk.jad_pa.jad_an jad_anVar4, com.jd.ad.sdk.jad_mx.jad_ob jad_obVar, com.jd.ad.sdk.jad_mx.jad_re.jad_an jad_anVar5, androidx.core.util.Pools.Pool<com.jd.ad.sdk.jad_mx.jad_na<?>> pool, com.jd.ad.sdk.jad_mx.jad_na.jad_cp jad_cpVar) {
        this.jad_jt = jad_anVar;
        this.jad_hu = jad_anVar2;
        this.jad_iv = jad_anVar3;
        this.jad_jw = jad_anVar4;
        this.jad_fs = jad_obVar;
        this.jad_cp = jad_anVar5;
        this.jad_dq = pool;
        this.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
        return this.jad_bo;
    }

    public synchronized void jad_an(int i) {
        com.jd.ad.sdk.jad_mx.jad_re<?> jad_reVar;
        com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_cp(), "Not yet complete!");
        if (this.jad_kx.getAndAdd(i) == 0 && (jad_reVar = this.jad_vi) != null) {
            jad_reVar.jad_an();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
    
        if (r4.jad_kx.get() != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        jad_dq();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
        this.jad_bo.jad_bo();
        this.jad_an.jad_an.remove(new com.jd.ad.sdk.jad_mx.jad_na.jad_dq(jad_ivVar, com.jd.ad.sdk.jad_ir.jad_er.jad_bo));
        if (this.jad_an.jad_an.isEmpty()) {
            boolean z = true;
            if (!jad_cp()) {
                this.jad_xk = true;
                com.jd.ad.sdk.jad_mx.jad_hu<R> jad_huVar = this.jad_wj;
                jad_huVar.jad_gr = true;
                com.jd.ad.sdk.jad_mx.jad_fs jad_fsVar = jad_huVar.jad_ep;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_cp();
                }
                com.jd.ad.sdk.jad_mx.jad_ob jad_obVar = this.jad_fs;
                com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2 = this.jad_ly;
                com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar = (com.jd.ad.sdk.jad_mx.jad_mz) jad_obVar;
                synchronized (jad_mzVar) {
                    com.jd.ad.sdk.jad_mx.jad_uh jad_uhVar = jad_mzVar.jad_an;
                    jad_uhVar.getClass();
                    java.util.Map<com.jd.ad.sdk.jad_ju.jad_hu, com.jd.ad.sdk.jad_mx.jad_na<?>> jad_an2 = jad_uhVar.jad_an(this.jad_pc);
                    if (equals(jad_an2.get(jad_huVar2))) {
                        jad_an2.remove(jad_huVar2);
                    }
                }
            }
            if (!this.jad_sf && !this.jad_uh) {
                z = false;
            }
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar, java.util.concurrent.Executor executor) {
        java.lang.Runnable jad_anVar;
        this.jad_bo.jad_bo();
        this.jad_an.jad_an.add(new com.jd.ad.sdk.jad_mx.jad_na.jad_dq(jad_ivVar, executor));
        if (this.jad_sf) {
            jad_an(1);
            jad_anVar = new com.jd.ad.sdk.jad_mx.jad_na.jad_bo(jad_ivVar);
        } else if (this.jad_uh) {
            jad_an(1);
            jad_anVar = new com.jd.ad.sdk.jad_mx.jad_na.jad_an(jad_ivVar);
        } else {
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(!this.jad_xk, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(jad_anVar);
    }

    public void jad_an(com.jd.ad.sdk.jad_mx.jad_hu<?> jad_huVar) {
        (this.jad_na ? this.jad_iv : this.jad_ob ? this.jad_jw : this.jad_hu).jad_an.execute(jad_huVar);
    }

    public void jad_bo() {
        com.jd.ad.sdk.jad_mx.jad_re<?> jad_reVar;
        synchronized (this) {
            this.jad_bo.jad_bo();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_cp(), "Not yet complete!");
            int decrementAndGet = this.jad_kx.decrementAndGet();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                jad_reVar = this.jad_vi;
                jad_dq();
            } else {
                jad_reVar = null;
            }
        }
        if (jad_reVar != null) {
            jad_reVar.jad_jt();
        }
    }

    public final boolean jad_cp() {
        return this.jad_uh || this.jad_sf || this.jad_xk;
    }

    public final synchronized void jad_dq() {
        boolean jad_an2;
        if (this.jad_ly == null) {
            throw new java.lang.IllegalArgumentException();
        }
        this.jad_an.jad_an.clear();
        this.jad_ly = null;
        this.jad_vi = null;
        this.jad_qd = null;
        this.jad_uh = false;
        this.jad_xk = false;
        this.jad_sf = false;
        this.jad_yl = false;
        com.jd.ad.sdk.jad_mx.jad_hu<R> jad_huVar = this.jad_wj;
        com.jd.ad.sdk.jad_mx.jad_hu.jad_fs jad_fsVar = jad_huVar.jad_jt;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an = true;
            jad_an2 = jad_fsVar.jad_an(false);
        }
        if (jad_an2) {
            jad_huVar.jad_fs();
        }
        this.jad_wj = null;
        this.jad_tg = null;
        this.jad_re = null;
        this.jad_dq.release(this);
    }
}
