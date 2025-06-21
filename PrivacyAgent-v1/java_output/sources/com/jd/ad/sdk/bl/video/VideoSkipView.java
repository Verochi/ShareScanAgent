package com.jd.ad.sdk.bl.video;

/* loaded from: classes23.dex */
public class VideoSkipView extends android.widget.FrameLayout {
    public int jad_an;
    public com.jd.ad.sdk.bl.video.VideoSkipView.jad_bo jad_bo;
    public android.widget.TextView jad_cp;
    public boolean jad_dq;
    public final java.lang.Runnable jad_er;

    public class jad_an implements java.lang.Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView = com.jd.ad.sdk.bl.video.VideoSkipView.this;
            android.widget.TextView textView = videoSkipView.jad_cp;
            if (textView == null) {
                return;
            }
            if (videoSkipView.jad_an > 5) {
                textView.setText("跳过");
            } else {
                textView.setText(java.lang.String.format(java.util.Locale.getDefault(), "跳过 %d", java.lang.Integer.valueOf(com.jd.ad.sdk.bl.video.VideoSkipView.this.jad_an)));
            }
            com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView2 = com.jd.ad.sdk.bl.video.VideoSkipView.this;
            if (videoSkipView2.jad_dq) {
                com.jd.ad.sdk.bl.video.VideoSkipView.jad_bo jad_boVar = videoSkipView2.jad_bo;
                if (jad_boVar != null) {
                    int i = videoSkipView2.jad_an;
                    com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener = ((com.jd.ad.sdk.bl.video.jad_bo) jad_boVar).jad_an.jad_qd;
                    if (videoInteractionListener != null) {
                        videoInteractionListener.onAdCountdown(i);
                    }
                }
                com.jd.ad.sdk.bl.video.VideoSkipView.this.jad_an--;
            }
            com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView3 = com.jd.ad.sdk.bl.video.VideoSkipView.this;
            if (videoSkipView3.jad_an >= 0) {
                videoSkipView3.postDelayed(videoSkipView3.jad_er, 1000L);
                return;
            }
            com.jd.ad.sdk.bl.video.VideoSkipView.jad_bo jad_boVar2 = videoSkipView3.jad_bo;
            if (jad_boVar2 != null) {
                com.jd.ad.sdk.bl.video.jad_bo jad_boVar3 = (com.jd.ad.sdk.bl.video.jad_bo) jad_boVar2;
                com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = jad_boVar3.jad_an;
                com.jd.ad.sdk.bl.video.VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_an);
                com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener2 = jad_boVar3.jad_an.jad_qd;
                if (videoInteractionListener2 != null) {
                    videoInteractionListener2.onAdTimeOver();
                }
                com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView4 = jad_boVar3.jad_an.jad_it;
                if (videoSkipView4 != null) {
                    videoSkipView4.removeCallbacks(null);
                }
            }
        }
    }

    public interface jad_bo {
    }

    public VideoSkipView(android.content.Context context) {
        super(context);
        this.jad_dq = true;
        this.jad_er = new com.jd.ad.sdk.bl.video.VideoSkipView.jad_an();
        jad_an(context);
    }

    public VideoSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_dq = true;
        this.jad_er = new com.jd.ad.sdk.bl.video.VideoSkipView.jad_an();
        jad_an(context);
    }

    public VideoSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_dq = true;
        this.jad_er = new com.jd.ad.sdk.bl.video.VideoSkipView.jad_an();
        jad_an(context);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public VideoSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jad_dq = true;
        this.jad_er = new com.jd.ad.sdk.bl.video.VideoSkipView.jad_an();
        jad_an(context);
    }

    public final void jad_an(android.content.Context context) {
        try {
            android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.jd.ad.sdk.R.layout.jad_video_skip_btn_layout, (android.view.ViewGroup) null);
            this.jad_cp = (android.widget.TextView) inflate.findViewById(com.jd.ad.sdk.R.id.jad_tv_video_count);
            addView(inflate);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while splash video skip init: " + e, new java.lang.Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_dq = z;
    }

    public void setTotalCount(int i) {
        this.jad_an = i;
        android.widget.TextView textView = this.jad_cp;
        if (textView == null) {
            return;
        }
        if (i > 5) {
            textView.setText("跳过");
        } else {
            textView.setText(java.lang.String.format(java.util.Locale.getDefault(), "跳过 %d", java.lang.Integer.valueOf(this.jad_an)));
        }
    }
}
