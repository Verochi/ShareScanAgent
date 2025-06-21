package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_mz extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback, android.graphics.drawable.Animatable {
    public final android.graphics.Matrix jad_an = new android.graphics.Matrix();
    public com.jd.ad.sdk.jad_lu.jad_jt jad_bo;
    public final com.jd.ad.sdk.jad_xg.jad_er jad_cp;
    public float jad_dq;
    public boolean jad_er;
    public boolean jad_fs;
    public final java.util.ArrayList<com.jd.ad.sdk.jad_lu.jad_mz.jad_ob> jad_hu;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_py.jad_bo jad_iv;
    public boolean jad_jt;

    @androidx.annotation.Nullable
    public java.lang.String jad_jw;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_bo jad_kx;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_py.jad_an jad_ly;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_an jad_mz;
    public boolean jad_na;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_tc.jad_bo jad_ob;
    public int jad_pc;
    public boolean jad_qd;
    public boolean jad_re;
    public boolean jad_sf;
    public boolean jad_tg;
    public boolean jad_uh;

    public class jad_an implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ java.lang.String jad_an;

        public jad_an(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_bo(this.jad_an);
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ int jad_an;
        public final /* synthetic */ int jad_bo;

        public jad_bo(int i, int i2) {
            this.jad_an = i;
            this.jad_bo = i2;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_an(this.jad_an, this.jad_bo);
        }
    }

    public class jad_cp implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_cp(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_an(this.jad_an);
        }
    }

    public class jad_dq implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_dq(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_cp(this.jad_an);
        }
    }

    public class jad_er implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ com.jd.ad.sdk.jad_qz.jad_er jad_an;
        public final /* synthetic */ java.lang.Object jad_bo;
        public final /* synthetic */ com.jd.ad.sdk.jad_yh.jad_cp jad_cp;

        public jad_er(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, java.lang.Object obj, com.jd.ad.sdk.jad_yh.jad_cp jad_cpVar) {
            this.jad_an = jad_erVar;
            this.jad_bo = obj;
            this.jad_cp = jad_cpVar;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_an(this.jad_an, this.jad_bo, this.jad_cp);
        }
    }

    public class jad_fs implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public jad_fs() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = com.jd.ad.sdk.jad_lu.jad_mz.this;
            com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = jad_mzVar.jad_ob;
            if (jad_boVar != null) {
                jad_boVar.jad_cp(jad_mzVar.jad_cp.jad_cp());
            }
        }
    }

    public class jad_hu implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_jt();
        }
    }

    public class jad_iv implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_iv(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_cp(this.jad_an);
        }
    }

    public class jad_jt implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public jad_jt() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_fs();
        }
    }

    public class jad_jw implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_jw(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_bo(this.jad_an);
        }
    }

    public class jad_kx implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_kx(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_bo(this.jad_an);
        }
    }

    public class jad_ly implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_ly(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_lu.jad_mz$jad_mz, reason: collision with other inner class name */
    public class C0389jad_mz implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ java.lang.String jad_an;

        public C0389jad_mz(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_cp(this.jad_an);
        }
    }

    public class jad_na implements com.jd.ad.sdk.jad_lu.jad_mz.jad_ob {
        public final /* synthetic */ java.lang.String jad_an;

        public jad_na(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.jad_lu.jad_mz.this.jad_an(this.jad_an);
        }
    }

    public interface jad_ob {
        void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar);
    }

    public jad_mz() {
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar = new com.jd.ad.sdk.jad_xg.jad_er();
        this.jad_cp = jad_erVar;
        this.jad_dq = 1.0f;
        this.jad_er = true;
        this.jad_fs = false;
        this.jad_jt = false;
        this.jad_hu = new java.util.ArrayList<>();
        com.jd.ad.sdk.jad_lu.jad_mz.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_lu.jad_mz.jad_fs();
        this.jad_pc = 255;
        this.jad_tg = true;
        this.jad_uh = false;
        jad_erVar.addUpdateListener(jad_fsVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.jad_uh = false;
        if (this.jad_jt) {
            try {
                jad_an(canvas);
            } catch (java.lang.Throwable unused) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            }
        } else {
            jad_an(canvas);
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.jad_pc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.width());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jad_uh) {
            return;
        }
        this.jad_uh = true;
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return jad_er();
    }

    public void jad_an(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_ly(f));
        } else {
            jad_bo((int) com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
        }
    }

    public void jad_an(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_cp(i));
        } else {
            this.jad_cp.jad_an(i);
        }
    }

    public void jad_an(int i, int i2) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_bo(i, i2));
        } else {
            this.jad_cp.jad_an(i, i2 + 0.99f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_an(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        boolean z;
        float f;
        float f2;
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar != null && !getBounds().isEmpty()) {
            android.graphics.Rect bounds = getBounds();
            float width = bounds.width() / bounds.height();
            android.graphics.Rect rect = jad_jtVar.jad_jw;
            if (width != rect.width() / rect.height()) {
                z = false;
                int i = -1;
                if (!z) {
                    com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = this.jad_ob;
                    com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar2 = this.jad_bo;
                    if (jad_boVar == null || jad_jtVar2 == null) {
                        return;
                    }
                    float f3 = this.jad_dq;
                    float min = java.lang.Math.min(canvas.getWidth() / jad_jtVar2.jad_jw.width(), canvas.getHeight() / jad_jtVar2.jad_jw.height());
                    if (f3 > min) {
                        f = this.jad_dq / min;
                    } else {
                        min = f3;
                        f = 1.0f;
                    }
                    if (f > 1.0f) {
                        i = canvas.save();
                        float width2 = jad_jtVar2.jad_jw.width() / 2.0f;
                        float height = jad_jtVar2.jad_jw.height() / 2.0f;
                        float f4 = width2 * min;
                        float f5 = height * min;
                        float f6 = this.jad_dq;
                        canvas.translate((width2 * f6) - f4, (f6 * height) - f5);
                        canvas.scale(f, f, f4, f5);
                    }
                    this.jad_an.reset();
                    this.jad_an.preScale(min, min);
                    jad_boVar.jad_an(canvas, this.jad_an, this.jad_pc);
                    if (i > 0) {
                        canvas.restoreToCount(i);
                        return;
                    }
                    return;
                }
                com.jd.ad.sdk.jad_tc.jad_bo jad_boVar2 = this.jad_ob;
                com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar3 = this.jad_bo;
                if (jad_boVar2 == null || jad_jtVar3 == null) {
                    return;
                }
                android.graphics.Rect bounds2 = getBounds();
                float width3 = bounds2.width() / jad_jtVar3.jad_jw.width();
                float height2 = bounds2.height() / jad_jtVar3.jad_jw.height();
                if (this.jad_tg) {
                    float min2 = java.lang.Math.min(width3, height2);
                    if (min2 < 1.0f) {
                        f2 = 1.0f / min2;
                        width3 /= f2;
                        height2 /= f2;
                    } else {
                        f2 = 1.0f;
                    }
                    if (f2 > 1.0f) {
                        i = canvas.save();
                        float width4 = bounds2.width() / 2.0f;
                        float height3 = bounds2.height() / 2.0f;
                        float f7 = width4 * min2;
                        float f8 = min2 * height3;
                        canvas.translate(width4 - f7, height3 - f8);
                        canvas.scale(f2, f2, f7, f8);
                    }
                }
                this.jad_an.reset();
                this.jad_an.preScale(width3, height2);
                jad_boVar2.jad_an(canvas, this.jad_an, this.jad_pc);
                if (i > 0) {
                    canvas.restoreToCount(i);
                    return;
                }
                return;
            }
        }
        z = true;
        int i2 = -1;
        if (!z) {
        }
    }

    public <T> void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = this.jad_ob;
        if (jad_boVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_er(jad_erVar, t, jad_cpVar));
            return;
        }
        boolean z = true;
        if (jad_erVar == com.jd.ad.sdk.jad_qz.jad_er.jad_cp) {
            jad_boVar.jad_an((com.jd.ad.sdk.jad_tc.jad_bo) t, (com.jd.ad.sdk.jad_yh.jad_cp<com.jd.ad.sdk.jad_tc.jad_bo>) jad_cpVar);
        } else {
            com.jd.ad.sdk.jad_qz.jad_fs jad_fsVar = jad_erVar.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an(t, jad_cpVar);
            } else {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                this.jad_ob.jad_an(jad_erVar, 0, arrayList, new com.jd.ad.sdk.jad_qz.jad_er(new java.lang.String[0]));
                for (int i = 0; i < arrayList.size(); i++) {
                    ((com.jd.ad.sdk.jad_qz.jad_er) arrayList.get(i)).jad_bo.jad_an(t, jad_cpVar);
                }
                z = true ^ arrayList.isEmpty();
            }
        }
        if (z) {
            invalidateSelf();
            if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_gr) {
                jad_cp(this.jad_cp.jad_cp());
            }
        }
    }

    public void jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_na(str));
            return;
        }
        com.jd.ad.sdk.jad_qz.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_bo((int) (jad_bo2.jad_bo + jad_bo2.jad_cp));
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public final boolean jad_an() {
        return this.jad_er || this.jad_fs;
    }

    public final void jad_bo() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar = com.jd.ad.sdk.jad_ve.jad_vi.jad_an;
        android.graphics.Rect rect = jad_jtVar.jad_jw;
        com.jd.ad.sdk.jad_tc.jad_er jad_erVar = new com.jd.ad.sdk.jad_tc.jad_er(java.util.Collections.emptyList(), jad_jtVar, "__container", -1L, 1, -1L, null, java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_ra.jad_ly(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, java.util.Collections.emptyList(), 1, null, false, null, null);
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar2 = this.jad_bo;
        com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = new com.jd.ad.sdk.jad_tc.jad_bo(this, jad_erVar, jad_jtVar2.jad_iv, jad_jtVar2);
        this.jad_ob = jad_boVar;
        if (this.jad_re) {
            jad_boVar.jad_an(true);
        }
    }

    public void jad_bo(float f) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_jw(f));
        } else {
            jad_cp((int) com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
        }
    }

    public void jad_bo(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_kx(i));
            return;
        }
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar = this.jad_cp;
        jad_erVar.jad_an(jad_erVar.jad_hu, i + 0.99f);
    }

    public void jad_bo(java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_an(str));
            return;
        }
        com.jd.ad.sdk.jad_qz.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            int i = (int) jad_bo2.jad_bo;
            jad_an(i, ((int) jad_bo2.jad_cp) + i);
        } else {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void jad_cp() {
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar.jad_kx) {
            jad_erVar.cancel();
        }
        this.jad_bo = null;
        this.jad_ob = null;
        this.jad_iv = null;
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar2 = this.jad_cp;
        jad_erVar2.jad_jw = null;
        jad_erVar2.jad_hu = -2.1474836E9f;
        jad_erVar2.jad_iv = 2.1474836E9f;
        invalidateSelf();
    }

    public void jad_cp(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_dq(f));
        } else {
            this.jad_cp.jad_an(com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Drawable#setProgress");
        }
    }

    public void jad_cp(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_iv(i));
        } else {
            this.jad_cp.jad_an(i, (int) r0.jad_iv);
        }
    }

    public void jad_cp(java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.C0389jad_mz(str));
            return;
        }
        com.jd.ad.sdk.jad_qz.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_cp((int) jad_bo2.jad_bo);
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public com.jd.ad.sdk.jad_lu.jad_jt jad_dq() {
        return this.jad_bo;
    }

    public boolean jad_er() {
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar == null) {
            return false;
        }
        return jad_erVar.jad_kx;
    }

    @androidx.annotation.MainThread
    public void jad_fs() {
        if (this.jad_ob == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_jt());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_xg.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            boolean jad_fs2 = jad_erVar.jad_fs();
            for (android.animation.Animator.AnimatorListener animatorListener : jad_erVar.jad_bo) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(jad_erVar, jad_fs2);
                } else {
                    animatorListener.onAnimationStart(jad_erVar);
                }
            }
            jad_erVar.jad_an((int) (jad_erVar.jad_fs() ? jad_erVar.jad_dq() : jad_erVar.jad_er()));
            jad_erVar.jad_er = 0L;
            jad_erVar.jad_jt = 0;
            jad_erVar.jad_jt();
        }
        if (jad_an()) {
            return;
        }
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar2 = this.jad_cp;
        jad_an((int) (jad_erVar2.jad_cp < 0.0f ? jad_erVar2.jad_er() : jad_erVar2.jad_dq()));
        this.jad_cp.jad_bo();
    }

    @androidx.annotation.MainThread
    public void jad_jt() {
        if (this.jad_ob == null) {
            this.jad_hu.add(new com.jd.ad.sdk.jad_lu.jad_mz.jad_hu());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_xg.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            jad_erVar.jad_jt();
            jad_erVar.jad_er = 0L;
            if (jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_er()) {
                jad_erVar.jad_fs = jad_erVar.jad_dq();
            } else if (!jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_dq()) {
                jad_erVar.jad_fs = jad_erVar.jad_er();
            }
        }
        if (jad_an()) {
            return;
        }
        com.jd.ad.sdk.jad_xg.jad_er jad_erVar2 = this.jad_cp;
        jad_an((int) (jad_erVar2.jad_cp < 0.0f ? jad_erVar2.jad_er() : jad_erVar2.jad_dq()));
        this.jad_cp.jad_bo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@androidx.annotation.IntRange(from = 0, to = 255) int i) {
        this.jad_pc = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @androidx.annotation.MainThread
    public void start() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!(callback instanceof android.view.View) || ((android.view.View) callback).isInEditMode()) {
            return;
        }
        jad_fs();
    }

    @Override // android.graphics.drawable.Animatable
    @androidx.annotation.MainThread
    public void stop() {
        this.jad_hu.clear();
        this.jad_cp.jad_bo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
