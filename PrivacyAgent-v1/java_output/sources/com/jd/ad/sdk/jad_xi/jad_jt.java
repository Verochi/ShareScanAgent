package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_jt {
    public final com.jd.ad.sdk.jad_it.jad_an jad_an;
    public final android.os.Handler jad_bo;
    public final java.util.List<com.jd.ad.sdk.jad_xi.jad_jt.jad_bo> jad_cp;
    public final com.jd.ad.sdk.jad_gr.jad_jw jad_dq;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_er;
    public boolean jad_fs;
    public com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap> jad_hu;
    public com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_iv;
    public boolean jad_jt;
    public boolean jad_jw;
    public com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_kx;
    public android.graphics.Bitmap jad_ly;
    public com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_mz;
    public com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;

    @androidx.annotation.VisibleForTesting
    public static class jad_an extends com.jd.ad.sdk.jad_fo.jad_an<android.graphics.Bitmap> {
        public final android.os.Handler jad_dq;
        public final int jad_er;
        public final long jad_fs;
        public android.graphics.Bitmap jad_jt;

        public jad_an(android.os.Handler handler, int i, long j) {
            this.jad_dq = handler;
            this.jad_er = i;
            this.jad_fs = j;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.jad_jt = null;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
            this.jad_jt = (android.graphics.Bitmap) obj;
            this.jad_dq.sendMessageAtTime(this.jad_dq.obtainMessage(1, this), this.jad_fs);
        }
    }

    public interface jad_bo {
        void jad_an();
    }

    public class jad_cp implements android.os.Handler.Callback {
        public jad_cp() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                com.jd.ad.sdk.jad_xi.jad_jt.this.jad_an((com.jd.ad.sdk.jad_xi.jad_jt.jad_an) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            com.jd.ad.sdk.jad_xi.jad_jt.this.jad_dq.jad_an((com.jd.ad.sdk.jad_xi.jad_jt.jad_an) message.obj);
            return false;
        }
    }

    public jad_jt(com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, com.jd.ad.sdk.jad_it.jad_an jad_anVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_naVar, android.graphics.Bitmap bitmap) {
        this(jad_cpVar.jad_an(), com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_cpVar.jad_cp()), jad_anVar, null, jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_cpVar.jad_cp()), i, i2), jad_naVar, bitmap);
    }

    public jad_jt(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar, com.jd.ad.sdk.jad_it.jad_an jad_anVar, android.os.Handler handler, com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap> jad_ivVar, com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_naVar, android.graphics.Bitmap bitmap) {
        this.jad_cp = new java.util.ArrayList();
        this.jad_dq = jad_jwVar;
        android.os.Handler handler2 = new android.os.Handler(android.os.Looper.getMainLooper(), new com.jd.ad.sdk.jad_xi.jad_jt.jad_cp());
        this.jad_er = jad_erVar;
        this.jad_bo = handler2;
        this.jad_hu = jad_ivVar;
        this.jad_an = jad_anVar;
        jad_an(jad_naVar, bitmap);
    }

    public static com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar, int i, int i2) {
        return jad_jwVar.jad_er().jad_bo(new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_an).jad_bo(true).jad_an(true).jad_bo(i, i2));
    }

    public final void jad_an() {
        if (!this.jad_fs || this.jad_jt) {
            return;
        }
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar = this.jad_na;
        if (jad_anVar != null) {
            this.jad_na = null;
            jad_an(jad_anVar);
            return;
        }
        this.jad_jt = true;
        long uptimeMillis = android.os.SystemClock.uptimeMillis() + this.jad_an.jad_dq();
        this.jad_an.jad_jt();
        this.jad_kx = new com.jd.ad.sdk.jad_xi.jad_jt.jad_an(this.jad_bo, this.jad_an.jad_an(), uptimeMillis);
        this.jad_hu.jad_bo(new com.jd.ad.sdk.jad_en.jad_hu().jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(java.lang.Double.valueOf(java.lang.Math.random())))).jad_an(this.jad_an).jad_an((com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap>) this.jad_kx);
    }

    public void jad_an(com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_naVar, android.graphics.Bitmap bitmap) {
        if (jad_naVar == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        this.jad_mz = jad_naVar;
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        this.jad_ly = bitmap;
        this.jad_hu = this.jad_hu.jad_bo(new com.jd.ad.sdk.jad_en.jad_hu().jad_an(jad_naVar, true));
        this.jad_ob = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap);
        this.jad_pc = bitmap.getWidth();
        this.jad_qd = bitmap.getHeight();
    }

    @androidx.annotation.VisibleForTesting
    public void jad_an(com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar) {
        this.jad_jt = false;
        if (this.jad_jw) {
            this.jad_bo.obtainMessage(2, jad_anVar).sendToTarget();
            return;
        }
        if (!this.jad_fs) {
            this.jad_na = jad_anVar;
            return;
        }
        if (jad_anVar.jad_jt != null) {
            android.graphics.Bitmap bitmap = this.jad_ly;
            if (bitmap != null) {
                this.jad_er.jad_an(bitmap);
                this.jad_ly = null;
            }
            com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar2 = this.jad_iv;
            this.jad_iv = jad_anVar;
            for (int size = this.jad_cp.size() - 1; size >= 0; size--) {
                this.jad_cp.get(size).jad_an();
            }
            if (jad_anVar2 != null) {
                this.jad_bo.obtainMessage(2, jad_anVar2).sendToTarget();
            }
        }
        jad_an();
    }
}
