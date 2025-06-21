package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class i extends com.anythink.expressad.video.signal.a.b {
    private android.app.Activity a;
    private com.anythink.expressad.video.bt.module.AnythinkBTContainer d;

    public i(android.app.Activity activity, com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer) {
        this.a = activity;
        this.d = anythinkBTContainer;
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void click(int i, java.lang.String str) {
        super.click(i, str);
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.click(i, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void handlerH5Exception(int i, java.lang.String str) {
        super.handlerH5Exception(i, str);
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.handlerH5Exception(i, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.b
    public final void reactDeveloper(java.lang.Object obj, java.lang.String str) {
        super.reactDeveloper(obj, str);
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.reactDeveloper(obj, str);
        }
    }
}
