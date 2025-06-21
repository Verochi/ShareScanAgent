package com.anythink.expressad.video.signal.factory;

/* loaded from: classes12.dex */
public class b extends com.anythink.expressad.video.signal.factory.a {
    private android.app.Activity h;
    private android.webkit.WebView i;
    private com.anythink.expressad.video.module.AnythinkVideoView j;
    private com.anythink.expressad.video.module.AnythinkContainerView k;
    private com.anythink.expressad.foundation.d.c l;
    private com.anythink.expressad.video.bt.module.AnythinkBTContainer m;
    private java.util.List<com.anythink.expressad.foundation.d.c> n;
    private com.anythink.expressad.video.signal.c.a o;
    private java.lang.String p;

    public b(android.app.Activity activity) {
        this.h = activity;
    }

    private b(android.app.Activity activity, android.webkit.WebView webView, com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView, com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar) {
        this.h = activity;
        this.i = webView;
        this.j = anythinkVideoView;
        this.k = anythinkContainerView;
        this.l = cVar;
    }

    public b(android.app.Activity activity, android.webkit.WebView webView, com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView, com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.video.signal.c.a aVar) {
        this.h = activity;
        this.i = webView;
        this.j = anythinkVideoView;
        this.k = anythinkContainerView;
        this.l = cVar;
        this.o = aVar;
        this.p = anythinkVideoView.getUnitId();
    }

    public b(android.app.Activity activity, com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer, android.webkit.WebView webView) {
        this.h = activity;
        this.m = anythinkBTContainer;
        this.i = webView;
    }

    public final void a(com.anythink.expressad.video.signal.a.j jVar) {
        this.b = jVar;
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.n = list;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        android.webkit.WebView webView = this.i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.a == null) {
            this.a = new com.anythink.expressad.video.signal.a.h(webView);
        }
        return this.a;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.i getIJSRewardVideoV1() {
        android.app.Activity activity;
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView == null || (activity = this.h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f == null) {
            this.f = new com.anythink.expressad.video.signal.a.m(activity, anythinkContainerView);
        }
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        if (this.h == null || this.m == null) {
            return super.getJSBTModule();
        }
        if (this.g == null) {
            this.g = new com.anythink.expressad.video.signal.a.i(this.h, this.m);
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        if (this.h == null || this.l == null) {
            return super.getJSCommon();
        }
        if (this.b == null) {
            this.b = new com.anythink.expressad.video.signal.a.j(this.h, this.l);
        }
        if (this.l.k() == 5 && (list = this.n) != null) {
            com.anythink.expressad.video.signal.c cVar = this.b;
            if (cVar instanceof com.anythink.expressad.video.signal.a.j) {
                ((com.anythink.expressad.video.signal.a.j) cVar).a(list);
            }
        }
        this.b.a(this.h);
        this.b.a(this.p);
        this.b.a(this.o);
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.e getJSContainerModule() {
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.e == null) {
            this.e = new com.anythink.expressad.video.signal.a.k(anythinkContainerView);
        }
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.g getJSNotifyProxy() {
        android.webkit.WebView webView = this.i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.d == null) {
            this.d = new com.anythink.expressad.video.signal.a.l(webView);
        }
        return this.d;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.j;
        if (anythinkVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.c == null) {
            this.c = new com.anythink.expressad.video.signal.a.n(anythinkVideoView);
        }
        return this.c;
    }
}
