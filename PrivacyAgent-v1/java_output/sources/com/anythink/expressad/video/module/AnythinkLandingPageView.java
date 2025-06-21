package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkLandingPageView extends com.anythink.expressad.video.module.AnythinkH5EndCardView {

    public static final class a implements com.anythink.expressad.atsignalcommon.base.a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.anythink.expressad.atsignalcommon.base.a
        public final boolean a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || android.webkit.URLUtil.isNetworkUrl(str)) {
                return false;
            }
            com.anythink.expressad.foundation.h.s.a(com.anythink.core.common.b.o.a().f(), str, null);
            return true;
        }
    }

    public AnythinkLandingPageView(android.content.Context context) {
        super(context);
    }

    public AnythinkLandingPageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final java.lang.String a() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            return cVar.ad();
        }
        return null;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        super.init(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        if (this.f) {
            this.f274s.setFilter(new com.anythink.expressad.video.module.AnythinkLandingPageView.a((byte) 0));
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        try {
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.f274s, "webviewshow", "");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
