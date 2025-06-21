package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_iv implements android.view.View.OnTouchListener {
    public java.lang.String jad_an = "";
    public java.lang.String jad_bo = "";
    public int jad_cp;
    public int jad_dq;
    public final /* synthetic */ android.content.Context jad_er;
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_fs;

    public jad_iv(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.content.Context context) {
        this.jad_fs = dynamicRenderView;
        this.jad_er = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_an = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(this.jad_fs, x, y);
            this.jad_cp = x;
            this.jad_dq = y;
            return false;
        }
        if (action != 1) {
            return false;
        }
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = this.jad_fs;
        android.content.Context context = this.jad_er;
        float f = this.jad_cp;
        float f2 = this.jad_dq;
        float f3 = x;
        float f4 = y;
        float f5 = dynamicRenderView.jad_lw;
        float f6 = dynamicRenderView.jad_oz;
        if (context != null) {
            float f7 = f3 - f;
            float f8 = f4 - f2;
            if (f5 <= 0.0f) {
                f5 = 1.0f;
            }
            if (f6 <= 0.0f) {
                f6 = 45.0f;
            }
            float sqrt = (float) java.lang.Math.sqrt(java.lang.Math.pow(f8, 2.0d) + java.lang.Math.pow(f7, 2.0d));
            float degrees = (float) java.lang.Math.toDegrees(java.lang.Math.atan2(java.lang.Math.abs(f8), java.lang.Math.abs(f7)));
            float f9 = 180.0f - f6;
            if ((f8 < 0.0f && sqrt > com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(context, f5)) && degrees >= f6 && degrees <= f9) {
                z = true;
                this.jad_bo = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(this.jad_fs, x, y);
                if (!android.text.TextUtils.isEmpty(this.jad_an) || android.text.TextUtils.isEmpty(this.jad_bo) || !this.jad_an.equals(this.jad_bo)) {
                    if (this.jad_fs.jad_jt != 3 && z) {
                        int ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView2 = this.jad_fs;
                        com.jd.ad.sdk.jad_hu.jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
                        if (jad_anVar == null) {
                            return false;
                        }
                        jad_anVar.jad_dq = ordinal;
                        jad_anVar.jad_an(view);
                        return true;
                    }
                }
                if (this.jad_bo.equals("sdkInteractiveShake")) {
                    return false;
                }
                com.jd.ad.sdk.jad_hu.jad_an jad_anVar2 = this.jad_fs.jad_wj.get(this.jad_bo);
                int ordinal2 = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal();
                if (!android.text.TextUtils.isEmpty(this.jad_an) && this.jad_an.equals(this.jad_fs.jad_xk) && this.jad_fs.jad_jt == 3 && z) {
                    ordinal2 = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                }
                if (jad_anVar2 == null) {
                    return false;
                }
                jad_anVar2.jad_dq = ordinal2;
                jad_anVar2.jad_an(view);
                return true;
            }
        }
        z = false;
        this.jad_bo = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(this.jad_fs, x, y);
        if (!android.text.TextUtils.isEmpty(this.jad_an)) {
        }
        return this.jad_fs.jad_jt != 3 ? false : false;
    }
}
