package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_fs implements android.view.View.OnTouchListener {
    public int jad_an;
    public int jad_bo;
    public final /* synthetic */ android.content.Context jad_cp;
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoRenderView jad_dq;

    public jad_fs(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, android.content.Context context) {
        this.jad_dq = videoRenderView;
        this.jad_cp = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_an = x;
            this.jad_bo = y;
            return true;
        }
        if (action != 1) {
            return true;
        }
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = this.jad_dq;
        android.content.Context context = this.jad_cp;
        float f = this.jad_an;
        float f2 = this.jad_bo;
        float f3 = x;
        float f4 = y;
        float f5 = videoRenderView.jad_kx;
        float f6 = videoRenderView.jad_na;
        boolean z = false;
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
            }
        }
        int ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal();
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_dq.jad_tg;
        if (lottieAnimationView != null && x >= lottieAnimationView.getLeft() && x <= this.jad_dq.jad_tg.getRight() && y >= this.jad_dq.jad_tg.getTop() && y <= this.jad_dq.jad_tg.getBottom()) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = this.jad_dq;
            com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener = videoRenderView2.jad_qd;
            if (videoInteractionListener == null) {
                return true;
            }
            videoInteractionListener.onAdClicked(videoRenderView2.jad_pc, ordinal);
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView3 = this.jad_dq;
            videoRenderView3.jad_an(videoRenderView3.jad_ju.getWidth(), this.jad_dq.jad_ju.getHeight());
            return true;
        }
        if (!z) {
            return true;
        }
        int ordinal2 = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView4 = this.jad_dq;
        com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener2 = videoRenderView4.jad_qd;
        if (videoInteractionListener2 == null) {
            return true;
        }
        videoInteractionListener2.onAdClicked(videoRenderView4.jad_pc, ordinal2);
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView5 = this.jad_dq;
        videoRenderView5.jad_an(videoRenderView5.jad_ju.getWidth(), this.jad_dq.jad_ju.getHeight());
        return true;
    }
}
