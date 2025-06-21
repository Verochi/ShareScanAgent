package com.jd.ad.sdk.jad_en;

/* loaded from: classes23.dex */
public final class jad_jw<R> implements com.jd.ad.sdk.jad_en.jad_dq, com.jd.ad.sdk.jad_fo.jad_dq, com.jd.ad.sdk.jad_en.jad_iv {
    public static final boolean jad_fq = android.util.Log.isLoggable("GlideRequest", 2);

    @androidx.annotation.Nullable
    public final java.lang.String jad_an;
    public final com.jd.ad.sdk.jad_js.jad_dq jad_bo;

    @androidx.annotation.GuardedBy("requestLock")
    public int jad_cn;
    public final java.lang.Object jad_cp;

    @androidx.annotation.GuardedBy("requestLock")
    public boolean jad_do;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_en.jad_jt<R> jad_dq;

    @androidx.annotation.Nullable
    public java.lang.RuntimeException jad_ep;
    public final com.jd.ad.sdk.jad_en.jad_fs jad_er;
    public final android.content.Context jad_fs;

    @androidx.annotation.Nullable
    public final java.lang.Object jad_hu;
    public final java.lang.Class<R> jad_iv;
    public final com.jd.ad.sdk.jad_gr.jad_er jad_jt;
    public final com.jd.ad.sdk.jad_en.jad_an<?> jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final com.jd.ad.sdk.jad_gr.jad_jt jad_mz;
    public final com.jd.ad.sdk.jad_fo.jad_er<R> jad_na;

    @androidx.annotation.Nullable
    public final java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> jad_ob;
    public final com.jd.ad.sdk.jad_gp.jad_cp<? super R> jad_pc;
    public final java.util.concurrent.Executor jad_qd;

    @androidx.annotation.GuardedBy("requestLock")
    public com.jd.ad.sdk.jad_mx.jad_xk<R> jad_re;

    @androidx.annotation.GuardedBy("requestLock")
    public com.jd.ad.sdk.jad_mx.jad_mz.jad_dq jad_sf;

    @androidx.annotation.GuardedBy("requestLock")
    public long jad_tg;
    public volatile com.jd.ad.sdk.jad_mx.jad_mz jad_uh;

    @androidx.annotation.GuardedBy("requestLock")
    public int jad_vi;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    public android.graphics.drawable.Drawable jad_wj;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    public android.graphics.drawable.Drawable jad_xk;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    public android.graphics.drawable.Drawable jad_yl;

    @androidx.annotation.GuardedBy("requestLock")
    public int jad_zm;

    public jad_jw(android.content.Context context, com.jd.ad.sdk.jad_gr.jad_er jad_erVar, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2, java.lang.Class<R> cls, com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar, int i, int i2, com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_fo.jad_er<R> jad_erVar2, @androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_jt<R> jad_jtVar2, @androidx.annotation.Nullable java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list, com.jd.ad.sdk.jad_en.jad_fs jad_fsVar, com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar, com.jd.ad.sdk.jad_gp.jad_cp<? super R> jad_cpVar, java.util.concurrent.Executor executor) {
        this.jad_an = jad_fq ? java.lang.String.valueOf(hashCode()) : null;
        this.jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();
        this.jad_cp = obj;
        this.jad_fs = context;
        this.jad_jt = jad_erVar;
        this.jad_hu = obj2;
        this.jad_iv = cls;
        this.jad_jw = jad_anVar;
        this.jad_kx = i;
        this.jad_ly = i2;
        this.jad_mz = jad_jtVar;
        this.jad_na = jad_erVar2;
        this.jad_dq = jad_jtVar2;
        this.jad_ob = list;
        this.jad_er = jad_fsVar;
        this.jad_uh = jad_mzVar;
        this.jad_pc = jad_cpVar;
        this.jad_qd = executor;
        this.jad_vi = 1;
        if (this.jad_ep == null && jad_erVar.jad_cp().jad_an(com.jd.ad.sdk.jad_gr.jad_dq.C0379jad_dq.class)) {
            this.jad_ep = new java.lang.RuntimeException("Glide request origin trace");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001e, B:14:0x0022, B:19:0x002e, B:20:0x0037, B:21:0x0039), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_en.jad_dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clear() {
        boolean z;
        synchronized (this.jad_cp) {
            jad_bo();
            this.jad_bo.jad_bo();
            if (this.jad_vi == 6) {
                return;
            }
            jad_jt();
            com.jd.ad.sdk.jad_mx.jad_xk<R> jad_xkVar = this.jad_re;
            if (jad_xkVar != null) {
                this.jad_re = null;
            } else {
                jad_xkVar = null;
            }
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
            if (jad_fsVar != null && !jad_fsVar.jad_cp(this)) {
                z = false;
                if (z) {
                    this.jad_na.jad_an(jad_iv());
                }
                this.jad_vi = 6;
                if (jad_xkVar == null) {
                    this.jad_uh.jad_an(jad_xkVar);
                    return;
                }
                return;
            }
            z = true;
            if (z) {
            }
            this.jad_vi = 6;
            if (jad_xkVar == null) {
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z;
        synchronized (this.jad_cp) {
            int i = this.jad_vi;
            z = i == 2 || i == 3;
        }
        return z;
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final android.graphics.drawable.Drawable jad_an(@androidx.annotation.DrawableRes int i) {
        android.content.res.Resources.Theme theme = this.jad_jw.jad_uh;
        if (theme == null) {
            theme = this.jad_fs.getTheme();
        }
        com.jd.ad.sdk.jad_gr.jad_er jad_erVar = this.jad_jt;
        return com.jd.ad.sdk.jad_vg.jad_bo.jad_an(jad_erVar, jad_erVar, i, theme);
    }

    public void jad_an(int i, int i2) {
        java.lang.Object obj;
        int i3 = i;
        this.jad_bo.jad_bo();
        java.lang.Object obj2 = this.jad_cp;
        synchronized (obj2) {
            try {
                try {
                    boolean z = jad_fq;
                    if (z) {
                        jad_an("Got onSizeReady in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                    }
                    if (this.jad_vi == 3) {
                        this.jad_vi = 2;
                        float f = this.jad_jw.jad_bo;
                        if (i3 != Integer.MIN_VALUE) {
                            i3 = java.lang.Math.round(i3 * f);
                        }
                        this.jad_zm = i3;
                        this.jad_cn = i2 == Integer.MIN_VALUE ? i2 : java.lang.Math.round(f * i2);
                        if (z) {
                            jad_an("finished setup for calling load in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                        }
                        com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar = this.jad_uh;
                        com.jd.ad.sdk.jad_gr.jad_er jad_erVar = this.jad_jt;
                        java.lang.Object obj3 = this.jad_hu;
                        com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar = this.jad_jw;
                        try {
                            obj = obj2;
                            try {
                                this.jad_sf = jad_mzVar.jad_an(jad_erVar, obj3, jad_anVar.jad_ly, this.jad_zm, this.jad_cn, jad_anVar.jad_sf, this.jad_iv, this.jad_mz, jad_anVar.jad_cp, jad_anVar.jad_re, jad_anVar.jad_mz, jad_anVar.jad_yl, jad_anVar.jad_qd, jad_anVar.jad_iv, jad_anVar.jad_wj, jad_anVar.jad_zm, jad_anVar.jad_xk, this, this.jad_qd);
                                if (this.jad_vi != 2) {
                                    this.jad_sf = null;
                                }
                                if (z) {
                                    jad_an("finished onSizeReady in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    obj = obj2;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        }
    }

    public final void jad_an(com.jd.ad.sdk.jad_mx.jad_sf jad_sfVar, int i) {
        boolean z;
        this.jad_bo.jad_bo();
        synchronized (this.jad_cp) {
            jad_sfVar.getClass();
            int i2 = this.jad_jt.jad_hu;
            boolean z2 = true;
            if (i2 <= i) {
                com.jd.ad.sdk.logger.Logger.w("Glide", "Load failed for " + this.jad_hu + " with size [" + this.jad_zm + "x" + this.jad_cn + "]", jad_sfVar);
                if (i2 <= 4) {
                    jad_sfVar.jad_an("Glide");
                }
            }
            this.jad_sf = null;
            this.jad_vi = 5;
            this.jad_do = true;
            try {
                java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list = this.jad_ob;
                if (list != null) {
                    java.util.Iterator<com.jd.ad.sdk.jad_en.jad_jt<R>> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw());
                    }
                } else {
                    z = false;
                }
                com.jd.ad.sdk.jad_en.jad_jt<R> jad_jtVar = this.jad_dq;
                if (jad_jtVar == null || !jad_jtVar.jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    jad_kx();
                }
                this.jad_do = false;
                com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_fs(this);
                }
            } catch (java.lang.Throwable th) {
                this.jad_do = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jad_an(com.jd.ad.sdk.jad_mx.jad_xk<?> jad_xkVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
        com.jd.ad.sdk.jad_en.jad_jw jad_jwVar;
        java.lang.Throwable th;
        this.jad_bo.jad_bo();
        com.jd.ad.sdk.jad_mx.jad_xk<?> jad_xkVar2 = null;
        try {
            synchronized (this.jad_cp) {
                try {
                    this.jad_sf = null;
                    if (jad_xkVar == null) {
                        jad_an(new com.jd.ad.sdk.jad_mx.jad_sf("Expected to receive a Resource<R> with an object of " + this.jad_iv + " inside, but instead got null.", java.util.Collections.emptyList()), 5);
                        return;
                    }
                    java.lang.Object obj = jad_xkVar.get();
                    try {
                        if (obj != null && this.jad_iv.isAssignableFrom(obj.getClass())) {
                            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
                            if (jad_fsVar == null || jad_fsVar.jad_an(this)) {
                                jad_an(jad_xkVar, obj, jad_anVar, z);
                                return;
                            }
                            this.jad_re = null;
                            this.jad_vi = 4;
                            this.jad_uh.jad_an(jad_xkVar);
                            return;
                        }
                        this.jad_re = null;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.jad_iv);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(jad_xkVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        jad_an(new com.jd.ad.sdk.jad_mx.jad_sf(sb.toString(), java.util.Collections.emptyList()), 5);
                        this.jad_uh.jad_an(jad_xkVar);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        jad_xkVar2 = jad_xkVar;
                        jad_jwVar = this;
                        while (true) {
                            try {
                                try {
                                    throw th;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    if (jad_xkVar2 != null) {
                                        jad_jwVar.jad_uh.jad_an(jad_xkVar2);
                                    }
                                    throw th;
                                }
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                jad_jwVar = jad_jwVar;
                            }
                            th = th4;
                            jad_jwVar = jad_jwVar;
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    jad_jwVar = this;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            jad_jwVar = this;
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final void jad_an(com.jd.ad.sdk.jad_mx.jad_xk<R> jad_xkVar, R r, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
        boolean z2;
        boolean jad_jw = jad_jw();
        this.jad_vi = 4;
        this.jad_re = jad_xkVar;
        boolean z3 = true;
        if (this.jad_jt.jad_hu <= 3) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished loading ");
            jad_an.append(r.getClass().getSimpleName());
            jad_an.append(" from ");
            jad_an.append(jad_anVar);
            jad_an.append(" for ");
            jad_an.append(this.jad_hu);
            jad_an.append(" with size [");
            jad_an.append(this.jad_zm);
            jad_an.append("x");
            jad_an.append(this.jad_cn);
            jad_an.append("] in ");
            jad_an.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
            jad_an.append(" ms");
            com.jd.ad.sdk.logger.Logger.d("Glide", jad_an.toString());
        }
        this.jad_do = true;
        try {
            java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                java.util.Iterator<com.jd.ad.sdk.jad_en.jad_jt<R>> it = list.iterator();
                z2 = false;
                while (it.hasNext()) {
                    z2 |= it.next().jad_an(r, this.jad_hu, this.jad_na, jad_anVar, jad_jw);
                }
            } else {
                z2 = false;
            }
            com.jd.ad.sdk.jad_en.jad_jt<R> jad_jtVar = this.jad_dq;
            if (jad_jtVar == null || !jad_jtVar.jad_an(r, this.jad_hu, this.jad_na, jad_anVar, jad_jw)) {
                z3 = false;
            }
            if (!(z2 | z3)) {
                this.jad_pc.getClass();
                this.jad_na.jad_an(r, com.jd.ad.sdk.jad_gp.jad_an.jad_an);
            }
            this.jad_do = false;
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
            if (jad_fsVar != null) {
                jad_fsVar.jad_dq(this);
            }
        } catch (java.lang.Throwable th) {
            this.jad_do = false;
            throw th;
        }
    }

    public final void jad_an(java.lang.String str) {
        com.jd.ad.sdk.logger.Logger.v("GlideRequest", str + " this: " + this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 4;
        }
        return z;
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final void jad_bo() {
        if (this.jad_do) {
            throw new java.lang.IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_cp() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 4;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_cp) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 6;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        int i;
        int i2;
        java.lang.Object obj;
        java.lang.Class<R> cls;
        com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar;
        com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar;
        int size;
        int i3;
        int i4;
        java.lang.Object obj2;
        java.lang.Class<R> cls2;
        com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar2;
        com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar2;
        int size2;
        if (!(jad_dqVar instanceof com.jd.ad.sdk.jad_en.jad_jw)) {
            return false;
        }
        synchronized (this.jad_cp) {
            i = this.jad_kx;
            i2 = this.jad_ly;
            obj = this.jad_hu;
            cls = this.jad_iv;
            jad_anVar = this.jad_jw;
            jad_jtVar = this.jad_mz;
            java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list = this.jad_ob;
            size = list != null ? list.size() : 0;
        }
        com.jd.ad.sdk.jad_en.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_en.jad_jw) jad_dqVar;
        synchronized (jad_jwVar.jad_cp) {
            i3 = jad_jwVar.jad_kx;
            i4 = jad_jwVar.jad_ly;
            obj2 = jad_jwVar.jad_hu;
            cls2 = jad_jwVar.jad_iv;
            jad_anVar2 = jad_jwVar.jad_jw;
            jad_jtVar2 = jad_jwVar.jad_mz;
            java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list2 = jad_jwVar.jad_ob;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i == i3 && i2 == i4) {
            char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
            if ((obj == null ? obj2 == null : obj instanceof com.jd.ad.sdk.jad_qb.jad_ly ? ((com.jd.ad.sdk.jad_qb.jad_ly) obj).jad_an(obj2) : obj.equals(obj2)) && cls.equals(cls2) && jad_anVar.equals(jad_anVar2) && jad_jtVar == jad_jtVar2 && size == size2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        synchronized (this.jad_cp) {
            jad_bo();
            this.jad_bo.jad_bo();
            this.jad_tg = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
            if (this.jad_hu == null) {
                if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                    this.jad_zm = this.jad_kx;
                    this.jad_cn = this.jad_ly;
                }
                jad_an(new com.jd.ad.sdk.jad_mx.jad_sf("Received null model", java.util.Collections.emptyList()), jad_hu() == null ? 5 : 3);
                return;
            }
            int i = this.jad_vi;
            if (i == 2) {
                throw new java.lang.IllegalArgumentException("Cannot restart a running request");
            }
            if (i == 4) {
                jad_an(this.jad_re, com.jd.ad.sdk.jad_ju.jad_an.MEMORY_CACHE, false);
                return;
            }
            java.util.List<com.jd.ad.sdk.jad_en.jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                for (com.jd.ad.sdk.jad_en.jad_jt<R> jad_jtVar : list) {
                    if (jad_jtVar instanceof com.jd.ad.sdk.jad_en.jad_cp) {
                        ((com.jd.ad.sdk.jad_en.jad_cp) jad_jtVar).getClass();
                    }
                }
            }
            this.jad_vi = 3;
            if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                jad_an(this.jad_kx, this.jad_ly);
            } else {
                this.jad_na.jad_bo(this);
            }
            int i2 = this.jad_vi;
            if (i2 == 2 || i2 == 3) {
                com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
                if (jad_fsVar == null || jad_fsVar.jad_bo(this)) {
                    this.jad_na.jad_bo(jad_iv());
                }
            }
            if (jad_fq) {
                jad_an("finished run method in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
            }
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final android.graphics.drawable.Drawable jad_hu() {
        int i;
        if (this.jad_yl == null) {
            com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar = this.jad_jw;
            android.graphics.drawable.Drawable drawable = jad_anVar.jad_ob;
            this.jad_yl = drawable;
            if (drawable == null && (i = jad_anVar.jad_pc) > 0) {
                this.jad_yl = jad_an(i);
            }
        }
        return this.jad_yl;
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final android.graphics.drawable.Drawable jad_iv() {
        int i;
        if (this.jad_xk == null) {
            com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar = this.jad_jw;
            android.graphics.drawable.Drawable drawable = jad_anVar.jad_jt;
            this.jad_xk = drawable;
            if (drawable == null && (i = jad_anVar.jad_hu) > 0) {
                this.jad_xk = jad_an(i);
            }
        }
        return this.jad_xk;
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final void jad_jt() {
        jad_bo();
        this.jad_bo.jad_bo();
        this.jad_na.jad_an((com.jd.ad.sdk.jad_fo.jad_dq) this);
        com.jd.ad.sdk.jad_mx.jad_mz.jad_dq jad_dqVar = this.jad_sf;
        if (jad_dqVar != null) {
            synchronized (com.jd.ad.sdk.jad_mx.jad_mz.this) {
                jad_dqVar.jad_an.jad_an(jad_dqVar.jad_bo);
            }
            this.jad_sf = null;
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final boolean jad_jw() {
        com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
        return jad_fsVar == null || !jad_fsVar.jad_bo().jad_an();
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final void jad_kx() {
        int i;
        com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_er;
        if (jad_fsVar == null || jad_fsVar.jad_bo(this)) {
            android.graphics.drawable.Drawable jad_hu = this.jad_hu == null ? jad_hu() : null;
            if (jad_hu == null) {
                if (this.jad_wj == null) {
                    com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar = this.jad_jw;
                    android.graphics.drawable.Drawable drawable = jad_anVar.jad_er;
                    this.jad_wj = drawable;
                    if (drawable == null && (i = jad_anVar.jad_fs) > 0) {
                        this.jad_wj = jad_an(i);
                    }
                }
                jad_hu = this.jad_wj;
            }
            if (jad_hu == null) {
                jad_hu = jad_iv();
            }
            this.jad_na.jad_cp(jad_hu);
        }
    }

    public java.lang.String toString() {
        java.lang.Object obj;
        java.lang.Class<R> cls;
        synchronized (this.jad_cp) {
            obj = this.jad_hu;
            cls = this.jad_iv;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
