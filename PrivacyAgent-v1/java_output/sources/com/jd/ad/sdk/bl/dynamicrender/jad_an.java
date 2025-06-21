package com.jd.ad.sdk.bl.dynamicrender;

/* loaded from: classes23.dex */
public class jad_an implements android.animation.Animator.AnimatorListener {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_bo;

    public jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.content.Context context) {
        this.jad_bo = dynamicRenderView;
        this.jad_an = context;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(android.animation.Animator animator) {
        com.jd.ad.sdk.logger.Logger.d("onAnimationCancel动画取消");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(android.animation.Animator animator) {
        com.jd.ad.sdk.logger.Logger.d("onAnimationEnd动画结束");
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = this.jad_bo;
        com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
        if (iDynamicCountdownListener != null && dynamicRenderView.jad_ep >= 0) {
            dynamicRenderView.jad_ep = -1;
            iDynamicCountdownListener.onAdCountdown(0);
        }
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = this.jad_bo.jad_cn;
        if (iDynamicRenderCallback != null) {
            iDynamicRenderCallback.onAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(android.animation.Animator animator) {
        com.jd.ad.sdk.logger.Logger.d("onAnimationRepeat动画重复");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(android.animation.Animator animator) {
        if (this.jad_an == null) {
            return;
        }
        com.jd.ad.sdk.logger.Logger.d("onAnimationStart动画开始");
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = this.jad_bo;
        if (dynamicRenderView.jad_jt == 2) {
            android.content.Context context = this.jad_an;
            if (dynamicRenderView.jad_kv == 0.0f && dynamicRenderView.jad_mx == 0.0f) {
                dynamicRenderView.jad_kv = 15.0f;
            }
            com.jd.ad.sdk.jad_hu.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_hu.jad_jw(dynamicRenderView, context, dynamicRenderView.jad_kv, dynamicRenderView.jad_mx, dynamicRenderView.jad_ny);
            dynamicRenderView.jad_hu = jad_jwVar;
            jad_jwVar.register();
        }
    }
}
