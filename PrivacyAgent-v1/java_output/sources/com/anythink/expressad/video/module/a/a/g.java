package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class g extends com.anythink.expressad.video.module.a.a.i {
    private com.anythink.expressad.video.module.AnythinkClickMiniCardView a;

    public g(com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView, com.anythink.expressad.video.module.a.a aVar) {
        super(aVar);
        this.a = anythinkClickMiniCardView;
    }

    @Override // com.anythink.expressad.video.module.a.a.i, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        boolean z = false;
        switch (i) {
            case 100:
                com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.a;
                if (anythinkClickMiniCardView != null) {
                    anythinkClickMiniCardView.webviewshow();
                    com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView2 = this.a;
                    anythinkClickMiniCardView2.onSelfConfigurationChanged(anythinkClickMiniCardView2.getResources().getConfiguration());
                    break;
                }
                break;
            case 101:
            case 102:
                z = true;
                break;
            case 103:
                i = 107;
                break;
        }
        if (z) {
            return;
        }
        super.a(i, obj);
    }
}
