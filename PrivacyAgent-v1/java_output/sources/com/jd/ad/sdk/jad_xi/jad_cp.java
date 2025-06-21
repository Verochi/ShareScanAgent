package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_cp extends android.graphics.drawable.Drawable implements com.jd.ad.sdk.jad_xi.jad_jt.jad_bo, android.graphics.drawable.Animatable, androidx.vectordrawable.graphics.drawable.Animatable2Compat {
    public final com.jd.ad.sdk.jad_xi.jad_cp.jad_an jad_an;
    public boolean jad_bo;
    public boolean jad_cp;
    public boolean jad_dq;
    public int jad_fs;
    public boolean jad_hu;
    public android.graphics.Paint jad_iv;
    public android.graphics.Rect jad_jw;
    public java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback> jad_kx;
    public boolean jad_er = true;
    public int jad_jt = -1;

    public static final class jad_an extends android.graphics.drawable.Drawable.ConstantState {

        @androidx.annotation.VisibleForTesting
        public final com.jd.ad.sdk.jad_xi.jad_jt jad_an;

        public jad_an(com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar) {
            this.jad_an = jad_jtVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            return new com.jd.ad.sdk.jad_xi.jad_cp(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new com.jd.ad.sdk.jad_xi.jad_cp(this);
        }
    }

    public jad_cp(com.jd.ad.sdk.jad_xi.jad_cp.jad_an jad_anVar) {
        this.jad_an = (com.jd.ad.sdk.jad_xi.jad_cp.jad_an) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_anVar);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback> list = this.jad_kx;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.jad_dq) {
            return;
        }
        if (this.jad_hu) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            android.graphics.Rect bounds = getBounds();
            if (this.jad_jw == null) {
                this.jad_jw = new android.graphics.Rect();
            }
            android.view.Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.jad_jw);
            this.jad_hu = false;
        }
        com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar = this.jad_an.jad_an;
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar = jad_jtVar.jad_iv;
        android.graphics.Bitmap bitmap = jad_anVar != null ? jad_anVar.jad_jt : jad_jtVar.jad_ly;
        if (this.jad_jw == null) {
            this.jad_jw = new android.graphics.Rect();
        }
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, this.jad_jw, jad_cp());
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.jad_an;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.jad_an.jad_an.jad_qd;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.jad_an.jad_an.jad_pc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_jt.jad_bo
    public void jad_an() {
        java.lang.Object callback = getCallback();
        while (callback instanceof android.graphics.drawable.Drawable) {
            callback = ((android.graphics.drawable.Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar = this.jad_an.jad_an.jad_iv;
        if ((jad_anVar != null ? jad_anVar.jad_er : -1) == r0.jad_an.jad_bo() - 1) {
            this.jad_fs++;
        }
        int i = this.jad_jt;
        if (i == -1 || this.jad_fs < i) {
            return;
        }
        java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback> list = this.jad_kx;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.jad_kx.get(i2).onAnimationEnd(this);
            }
        }
        stop();
    }

    public android.graphics.Bitmap jad_bo() {
        return this.jad_an.jad_an.jad_ly;
    }

    public final android.graphics.Paint jad_cp() {
        if (this.jad_iv == null) {
            this.jad_iv = new android.graphics.Paint(2);
        }
        return this.jad_iv;
    }

    public final void jad_dq() {
        com.jd.ad.sdk.jad_ir.jad_kx.jad_an(!this.jad_dq, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.jad_an.jad_an.jad_an.jad_bo() != 1) {
            if (this.jad_bo) {
                return;
            }
            this.jad_bo = true;
            com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar = this.jad_an.jad_an;
            if (jad_jtVar.jad_jw) {
                throw new java.lang.IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (jad_jtVar.jad_cp.contains(this)) {
                throw new java.lang.IllegalStateException("Cannot subscribe twice in a row");
            }
            boolean isEmpty = jad_jtVar.jad_cp.isEmpty();
            jad_jtVar.jad_cp.add(this);
            if (isEmpty && !jad_jtVar.jad_fs) {
                jad_jtVar.jad_fs = true;
                jad_jtVar.jad_jw = false;
                jad_jtVar.jad_an();
            }
        }
        invalidateSelf();
    }

    public final void jad_er() {
        this.jad_bo = false;
        com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar = this.jad_an.jad_an;
        jad_jtVar.jad_cp.remove(this);
        if (jad_jtVar.jad_cp.isEmpty()) {
            jad_jtVar.jad_fs = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.jad_hu = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.jad_kx == null) {
            this.jad_kx = new java.util.ArrayList();
        }
        this.jad_kx.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        jad_cp().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        jad_cp().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.jd.ad.sdk.jad_ir.jad_kx.jad_an(!this.jad_dq, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.jad_er = z;
        if (!z) {
            jad_er();
        } else if (this.jad_cp) {
            jad_dq();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.jad_cp = true;
        this.jad_fs = 0;
        if (this.jad_er) {
            jad_dq();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.jad_cp = false;
        jad_er();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback) {
        java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback> list = this.jad_kx;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }
}
