package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_jt implements android.view.View.OnTouchListener {
    public final /* synthetic */ float[] jad_n_an;
    public final /* synthetic */ float[] jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ float jad_n_dq;
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_er;

    public jad_n_jt(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, float[] fArr, float[] fArr2, float f, float f2) {
        this.jad_n_er = jad_n_ivVar;
        this.jad_n_an = fArr;
        this.jad_n_bo = fArr2;
        this.jad_n_cp = f;
        this.jad_n_dq = f2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_n_an[0] = motionEvent.getX();
            this.jad_n_an[1] = motionEvent.getY();
            return true;
        }
        if (action == 1) {
            this.jad_n_bo[0] = motionEvent.getX();
            this.jad_n_bo[1] = motionEvent.getY();
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = this.jad_n_er;
            float[] fArr = this.jad_n_an;
            float f = fArr[0];
            float f2 = fArr[1];
            float[] fArr2 = this.jad_n_bo;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            float f5 = this.jad_n_cp;
            float f6 = this.jad_n_dq;
            jad_n_ivVar.getClass();
            float f7 = f3 - f;
            float f8 = f4 - f2;
            if (f5 <= 0.0f) {
                f5 = 1.0f;
            }
            if (f6 <= 0.0f) {
                f6 = 45.0f;
            }
            float f9 = 180.0f - f6;
            float sqrt = (float) java.lang.Math.sqrt(java.lang.Math.pow(f8, 2.0d) + java.lang.Math.pow(f7, 2.0d));
            float degrees = (float) java.lang.Math.toDegrees(java.lang.Math.atan2(java.lang.Math.abs(f8), java.lang.Math.abs(f7)));
            if ((f8 < 0.0f && sqrt > com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(jad_n_ivVar.jad_n_fs.getContext(), f5)) && degrees >= f6 && degrees <= f9) {
                jad_n_ivVar.jad_n_jw = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                jad_n_ivVar.jad_n_bo(jad_n_ivVar.jad_n_fs);
            }
        }
        return false;
    }
}
