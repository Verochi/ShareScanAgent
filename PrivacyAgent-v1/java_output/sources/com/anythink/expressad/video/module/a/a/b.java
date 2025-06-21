package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class b extends com.anythink.expressad.video.module.a.a.d {
    private com.anythink.expressad.video.module.AnythinkVideoView ag;
    private com.anythink.expressad.video.module.AnythinkContainerView ah;

    public b(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView, com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, java.lang.String str, java.lang.String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i, z);
        this.ag = anythinkVideoView;
        this.ah = anythinkContainerView;
        if (anythinkVideoView == null || anythinkContainerView == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.d, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        if (this.W) {
            if (i == 8) {
                com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.ah;
                if (anythinkContainerView == null) {
                    com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.ag;
                    if (anythinkVideoView != null) {
                        anythinkVideoView.showAlertView();
                    }
                } else if (anythinkContainerView.showAlertWebView()) {
                    com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = this.ag;
                    if (anythinkVideoView2 != null) {
                        anythinkVideoView2.alertWebViewShowed();
                    }
                } else {
                    com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView3 = this.ag;
                    if (anythinkVideoView3 != null) {
                        anythinkVideoView3.showAlertView();
                    }
                }
            } else if (i == 107) {
                this.ah.showVideoClickView(-1);
                this.ag.setCover(false);
                this.ag.videoOperate(1);
            } else if (i == 112) {
                this.ag.setCover(true);
                this.ag.videoOperate(2);
            } else if (i == 115) {
                this.ah.resizeMiniCard(this.ag.getBorderViewWidth(), this.ag.getBorderViewHeight(), this.ag.getBorderViewRadius());
            }
        }
        super.a(i, obj);
    }
}
