package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_jt implements android.animation.Animator.AnimatorListener {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoRenderView jad_bo;

    public jad_jt(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, android.content.Context context) {
        this.jad_bo = videoRenderView;
        this.jad_an = context;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(android.animation.Animator animator) {
        com.jd.ad.sdk.logger.Logger.d("onAnimationCancel动画取消");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(android.animation.Animator animator) {
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = this.jad_bo;
        com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener = videoRenderView.jad_qd;
        if (videoInteractionListener == null || videoRenderView.jad_yl < 0) {
            return;
        }
        videoRenderView.jad_yl = -1;
        videoInteractionListener.onAdCountdown(0);
        this.jad_bo.jad_qd.onVideoAnimationEnd();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(android.animation.Animator animator) {
        com.jd.ad.sdk.logger.Logger.d("onAnimationRepeat动画重复");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(android.animation.Animator animator) {
        android.content.Context context = this.jad_an;
        if (context == null) {
            return;
        }
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = this.jad_bo;
        if (videoRenderView.jad_pc == 2) {
            if (videoRenderView.jad_jw == 0.0f && videoRenderView.jad_ly == 0.0f) {
                videoRenderView.jad_jw = 15.0f;
            }
            com.jd.ad.sdk.jad_ly.jad_hu jad_huVar = new com.jd.ad.sdk.jad_ly.jad_hu(videoRenderView, context, videoRenderView.jad_jw, videoRenderView.jad_ly, videoRenderView.jad_mz);
            videoRenderView.jad_hu = jad_huVar;
            jad_huVar.register();
        }
    }
}
