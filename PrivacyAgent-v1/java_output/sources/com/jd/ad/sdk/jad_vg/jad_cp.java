package com.jd.ad.sdk.jad_vg;

/* loaded from: classes23.dex */
public abstract class jad_cp<T extends android.graphics.drawable.Drawable> implements com.jd.ad.sdk.jad_mx.jad_xk<T>, com.jd.ad.sdk.jad_mx.jad_tg {
    public final T jad_an;

    public jad_cp(T t) {
        this.jad_an = (T) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(t);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Object get() {
        android.graphics.drawable.Drawable.ConstantState constantState = this.jad_an.getConstantState();
        return constantState == null ? this.jad_an : constantState.newDrawable();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        android.graphics.Bitmap jad_bo;
        T t = this.jad_an;
        if (t instanceof android.graphics.drawable.BitmapDrawable) {
            jad_bo = ((android.graphics.drawable.BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof com.jd.ad.sdk.jad_xi.jad_cp)) {
            return;
        } else {
            jad_bo = ((com.jd.ad.sdk.jad_xi.jad_cp) t).jad_bo();
        }
        jad_bo.prepareToDraw();
    }
}
