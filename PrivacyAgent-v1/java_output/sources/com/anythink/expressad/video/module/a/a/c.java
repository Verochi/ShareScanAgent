package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.video.module.a.a.d {
    private com.anythink.expressad.video.signal.factory.IJSFactory ag;

    public c(com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, java.lang.String str, java.lang.String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i, z);
        this.ag = iJSFactory;
        if (iJSFactory == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.d, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        if (this.W) {
            if (i != 8) {
                if (i == 105) {
                    this.ag.getJSNotifyProxy().a(3, obj.toString());
                    i = -1;
                } else if (i == 107) {
                    this.ag.getJSContainerModule().showVideoClickView(-1);
                    this.ag.getJSVideoModule().setCover(false);
                    this.ag.getJSVideoModule().videoOperate(1);
                } else if (i == 112) {
                    this.ag.getJSVideoModule().setCover(true);
                    this.ag.getJSVideoModule().videoOperate(2);
                } else if (i == 115) {
                    com.anythink.expressad.video.signal.j jSVideoModule = this.ag.getJSVideoModule();
                    this.ag.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (this.ag.getJSContainerModule().showAlertWebView()) {
                this.ag.getJSVideoModule().alertWebViewShowed();
            } else {
                this.ag.getJSVideoModule().showAlertView();
            }
        }
        super.a(i, obj);
    }
}
