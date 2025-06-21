package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_iv<TranscodeType> extends com.jd.ad.sdk.jad_en.jad_an<com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType>> {
    public final android.content.Context jad_cn;
    public final com.jd.ad.sdk.jad_gr.jad_jw jad_do;
    public final java.lang.Class<TranscodeType> jad_ep;
    public final com.jd.ad.sdk.jad_gr.jad_er jad_fq;

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_kx<?, ? super TranscodeType> jad_gr;

    @androidx.annotation.Nullable
    public java.lang.Object jad_hs;

    @androidx.annotation.Nullable
    public java.util.List<com.jd.ad.sdk.jad_en.jad_jt<TranscodeType>> jad_it;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ju;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_kv;
    public boolean jad_lw = true;
    public boolean jad_mx;
    public boolean jad_ny;

    static {
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_an(com.jd.ad.sdk.jad_gr.jad_jt.LOW).jad_an(true);
    }

    @android.annotation.SuppressLint({"CheckResult"})
    public jad_iv(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar, java.lang.Class<TranscodeType> cls, android.content.Context context) {
        this.jad_do = jad_jwVar;
        this.jad_ep = cls;
        this.jad_cn = context;
        this.jad_gr = jad_jwVar.jad_an(cls);
        this.jad_fq = jad_cpVar.jad_dq();
        jad_an(jad_jwVar.jad_fs());
        jad_bo(jad_jwVar.jad_jt());
    }

    @Override // com.jd.ad.sdk.jad_en.jad_an
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_en.jad_an jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_en.jad_an jad_anVar) {
        return jad_bo((com.jd.ad.sdk.jad_en.jad_an<?>) jad_anVar);
    }

    public final com.jd.ad.sdk.jad_en.jad_dq jad_an(java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_erVar, com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar, com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar, com.jd.ad.sdk.jad_en.jad_fs jad_fsVar, com.jd.ad.sdk.jad_gr.jad_kx<?, ? super TranscodeType> jad_kxVar, com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar2, int i, int i2, java.util.concurrent.Executor executor) {
        android.content.Context context = this.jad_cn;
        com.jd.ad.sdk.jad_gr.jad_er jad_erVar2 = this.jad_fq;
        java.lang.Object obj2 = this.jad_hs;
        java.lang.Class<TranscodeType> cls = this.jad_ep;
        java.util.List<com.jd.ad.sdk.jad_en.jad_jt<TranscodeType>> list = this.jad_it;
        com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar = jad_erVar2.jad_fs;
        jad_kxVar.getClass();
        return new com.jd.ad.sdk.jad_en.jad_jw(context, jad_erVar2, obj, obj2, cls, jad_anVar, i, i2, jad_jtVar2, jad_erVar, jad_jtVar, list, jad_fsVar, jad_mzVar, com.jd.ad.sdk.jad_gp.jad_an.jad_bo, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.jd.ad.sdk.jad_en.jad_dq jad_an(java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_erVar, @androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar, @androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_fs jad_fsVar, com.jd.ad.sdk.jad_gr.jad_kx<?, ? super TranscodeType> jad_kxVar, com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar2, int i, int i2, com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar, java.util.concurrent.Executor executor) {
        com.jd.ad.sdk.jad_en.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_en.jad_fs jad_fsVar2;
        com.jd.ad.sdk.jad_en.jad_dq jad_an;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.jad_kv != null) {
            jad_fsVar2 = new com.jd.ad.sdk.jad_en.jad_bo(obj, jad_fsVar);
            jad_boVar = jad_fsVar2;
        } else {
            jad_boVar = 0;
            jad_fsVar2 = jad_fsVar;
        }
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar = this.jad_ju;
        if (jad_ivVar == null) {
            jad_an = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_fsVar2, jad_kxVar, jad_jtVar2, i, i2, executor);
        } else {
            if (this.jad_ny) {
                throw new java.lang.IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            com.jd.ad.sdk.jad_gr.jad_kx<?, ? super TranscodeType> jad_kxVar2 = jad_ivVar.jad_lw ? jad_kxVar : jad_ivVar.jad_gr;
            com.jd.ad.sdk.jad_gr.jad_jt jad_bo = com.jd.ad.sdk.jad_en.jad_an.jad_an(jad_ivVar.jad_an, 8) ? this.jad_ju.jad_dq : jad_bo(jad_jtVar2);
            com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar2 = this.jad_ju;
            int i7 = jad_ivVar2.jad_kx;
            int i8 = jad_ivVar2.jad_jw;
            if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(i, i2)) {
                com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar3 = this.jad_ju;
                if (!com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(jad_ivVar3.jad_kx, jad_ivVar3.jad_jw)) {
                    i6 = jad_anVar.jad_kx;
                    i5 = jad_anVar.jad_jw;
                    com.jd.ad.sdk.jad_en.jad_kx jad_kxVar3 = new com.jd.ad.sdk.jad_en.jad_kx(obj, jad_fsVar2);
                    com.jd.ad.sdk.jad_en.jad_dq jad_an2 = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_kxVar3, jad_kxVar, jad_jtVar2, i, i2, executor);
                    this.jad_ny = true;
                    com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar4 = this.jad_ju;
                    com.jd.ad.sdk.jad_en.jad_dq jad_an3 = jad_ivVar4.jad_an(obj, jad_erVar, jad_jtVar, jad_kxVar3, jad_kxVar2, jad_bo, i6, i5, jad_ivVar4, executor);
                    this.jad_ny = false;
                    jad_kxVar3.jad_cp = jad_an2;
                    jad_kxVar3.jad_dq = jad_an3;
                    jad_an = jad_kxVar3;
                }
            }
            i5 = i8;
            i6 = i7;
            com.jd.ad.sdk.jad_en.jad_kx jad_kxVar32 = new com.jd.ad.sdk.jad_en.jad_kx(obj, jad_fsVar2);
            com.jd.ad.sdk.jad_en.jad_dq jad_an22 = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_kxVar32, jad_kxVar, jad_jtVar2, i, i2, executor);
            this.jad_ny = true;
            com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar42 = this.jad_ju;
            com.jd.ad.sdk.jad_en.jad_dq jad_an32 = jad_ivVar42.jad_an(obj, jad_erVar, jad_jtVar, jad_kxVar32, jad_kxVar2, jad_bo, i6, i5, jad_ivVar42, executor);
            this.jad_ny = false;
            jad_kxVar32.jad_cp = jad_an22;
            jad_kxVar32.jad_dq = jad_an32;
            jad_an = jad_kxVar32;
        }
        if (jad_boVar == 0) {
            return jad_an;
        }
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar5 = this.jad_kv;
        int i9 = jad_ivVar5.jad_kx;
        int i10 = jad_ivVar5.jad_jw;
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(i, i2)) {
            com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar6 = this.jad_kv;
            if (!com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(jad_ivVar6.jad_kx, jad_ivVar6.jad_jw)) {
                i4 = jad_anVar.jad_kx;
                i3 = jad_anVar.jad_jw;
                com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar7 = this.jad_kv;
                com.jd.ad.sdk.jad_en.jad_dq jad_an4 = jad_ivVar7.jad_an(obj, jad_erVar, jad_jtVar, jad_boVar, jad_ivVar7.jad_gr, jad_ivVar7.jad_dq, i4, i3, jad_ivVar7, executor);
                jad_boVar.jad_cp = jad_an;
                jad_boVar.jad_dq = jad_an4;
                return jad_boVar;
            }
        }
        i3 = i10;
        i4 = i9;
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar72 = this.jad_kv;
        com.jd.ad.sdk.jad_en.jad_dq jad_an42 = jad_ivVar72.jad_an(obj, jad_erVar, jad_jtVar, jad_boVar, jad_ivVar72.jad_gr, jad_ivVar72.jad_dq, i4, i3, jad_ivVar72, executor);
        jad_boVar.jad_cp = jad_an;
        jad_boVar.jad_dq = jad_an42;
        return jad_boVar;
    }

    @androidx.annotation.NonNull
    public <Y extends com.jd.ad.sdk.jad_fo.jad_er<TranscodeType>> Y jad_an(@androidx.annotation.NonNull Y y) {
        java.util.concurrent.Executor executor = com.jd.ad.sdk.jad_ir.jad_er.jad_an;
        if (y == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        if (!this.jad_mx) {
            throw new java.lang.IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.jd.ad.sdk.jad_en.jad_dq jad_an = jad_an(new java.lang.Object(), y, (com.jd.ad.sdk.jad_en.jad_jt) null, (com.jd.ad.sdk.jad_en.jad_fs) null, this.jad_gr, this.jad_dq, this.jad_kx, this.jad_jw, this, executor);
        com.jd.ad.sdk.jad_fo.jad_an jad_anVar = (com.jd.ad.sdk.jad_fo.jad_an) y;
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = jad_anVar.jad_cp;
        if (jad_an.jad_er(jad_dqVar)) {
            if (!(!this.jad_iv && jad_dqVar.jad_cp())) {
                if (!((com.jd.ad.sdk.jad_en.jad_dq) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_dqVar)).isRunning()) {
                    jad_dqVar.jad_fs();
                }
                return y;
            }
        }
        this.jad_do.jad_an((com.jd.ad.sdk.jad_fo.jad_er<?>) y);
        jad_anVar.jad_cp = jad_an;
        com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar = this.jad_do;
        synchronized (jad_jwVar) {
            jad_jwVar.jad_fs.jad_an.add(y);
            com.jd.ad.sdk.jad_zk.jad_re jad_reVar = jad_jwVar.jad_dq;
            jad_reVar.jad_an.add(jad_an);
            if (jad_reVar.jad_cp) {
                jad_an.clear();
                if (android.util.Log.isLoggable("RequestTracker", 2)) {
                    com.jd.ad.sdk.logger.Logger.v("RequestTracker", "Paused, delaying request");
                }
                jad_reVar.jad_bo.add(jad_an);
            } else {
                jad_an.jad_fs();
            }
        }
        return y;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_an((com.jd.ad.sdk.jad_en.jad_jt) jad_jtVar);
        }
        if (jad_jtVar != null) {
            if (this.jad_it == null) {
                this.jad_it = new java.util.ArrayList();
            }
            this.jad_it.add(jad_jtVar);
        }
        return jad_bo();
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_an(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this.jad_vi) {
            return clone().jad_an(obj);
        }
        this.jad_hs = obj;
        this.jad_mx = true;
        return jad_bo();
    }

    @android.annotation.SuppressLint({"CheckResult"})
    public final void jad_an(java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> list) {
        java.util.Iterator<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> it = list.iterator();
        while (it.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_en.jad_jt) it.next());
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar) {
        if (jad_anVar != null) {
            return (com.jd.ad.sdk.jad_gr.jad_iv) super.jad_an(jad_anVar);
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_bo(@androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_bo(jad_jtVar);
        }
        this.jad_it = null;
        return jad_an((com.jd.ad.sdk.jad_en.jad_jt) jad_jtVar);
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_gr.jad_jt jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar) {
        int ordinal = jad_jtVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return com.jd.ad.sdk.jad_gr.jad_jt.IMMEDIATE;
        }
        if (ordinal == 2) {
            return com.jd.ad.sdk.jad_gr.jad_jt.HIGH;
        }
        if (ordinal == 3) {
            return com.jd.ad.sdk.jad_gr.jad_jt.NORMAL;
        }
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("unknown priority: ");
        jad_an.append(this.jad_dq);
        throw new java.lang.IllegalArgumentException(jad_an.toString());
    }

    @Override // com.jd.ad.sdk.jad_en.jad_an
    @androidx.annotation.CheckResult
    /* renamed from: jad_cp, reason: merged with bridge method [inline-methods] */
    public com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> clone() {
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar = (com.jd.ad.sdk.jad_gr.jad_iv) super.clone();
        jad_ivVar.jad_gr = (com.jd.ad.sdk.jad_gr.jad_kx<?, ? super TranscodeType>) jad_ivVar.jad_gr.jad_an();
        if (jad_ivVar.jad_it != null) {
            jad_ivVar.jad_it = new java.util.ArrayList(jad_ivVar.jad_it);
        }
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar2 = jad_ivVar.jad_ju;
        if (jad_ivVar2 != null) {
            jad_ivVar.jad_ju = jad_ivVar2.clone();
        }
        com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType> jad_ivVar3 = jad_ivVar.jad_kv;
        if (jad_ivVar3 != null) {
            jad_ivVar.jad_kv = jad_ivVar3.clone();
        }
        return jad_ivVar;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_dq() {
        return jad_an((com.jd.ad.sdk.jad_gr.jad_iv<TranscodeType>) new com.jd.ad.sdk.jad_fo.jad_cp(this.jad_do, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
