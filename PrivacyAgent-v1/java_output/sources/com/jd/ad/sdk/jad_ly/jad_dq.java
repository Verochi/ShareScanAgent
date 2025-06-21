package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_dq implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoRenderView jad_an;

    public jad_dq(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView) {
        this.jad_an = videoRenderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView = this.jad_an.jad_it;
        if (videoSkipView != null) {
            int i = videoSkipView.jad_an;
            if (i < 1 || i > 30) {
                videoSkipView.jad_an = 5;
            }
            videoSkipView.post(videoSkipView.jad_er);
        }
    }
}
