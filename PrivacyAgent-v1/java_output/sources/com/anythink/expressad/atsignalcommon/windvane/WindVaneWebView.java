package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public class WindVaneWebView extends com.anythink.expressad.atsignalcommon.base.BaseWebView {
    private java.lang.Object a;
    private java.lang.Object b;
    private java.lang.String c;
    private com.anythink.expressad.atsignalcommon.windvane.e d;
    protected com.anythink.expressad.atsignalcommon.windvane.o f;
    protected com.anythink.expressad.atsignalcommon.windvane.d g;
    protected com.anythink.expressad.atsignalcommon.windvane.i h;
    private java.lang.String i;
    private boolean j;
    private float k;
    private float l;

    /* renamed from: com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.this);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.this.destroy();
        }
    }

    public WindVaneWebView(android.content.Context context) {
        super(context);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public WindVaneWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public WindVaneWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        windVaneWebView.j = true;
        return true;
    }

    @Override // com.anythink.expressad.atsignalcommon.base.BaseWebView
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        try {
            getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        } catch (java.lang.Throwable unused) {
            getSettings().setUserAgentString(com.anythink.core.common.o.e.i() + " WindVane/3.0.2");
        }
        if (this.f == null) {
            this.f = new com.anythink.expressad.atsignalcommon.windvane.o(this);
        }
        setWebViewChromeClient(this.f);
        com.anythink.expressad.atsignalcommon.windvane.p pVar = new com.anythink.expressad.atsignalcommon.windvane.p();
        this.mWebViewClient = pVar;
        setWebViewClient(pVar);
        if (this.g == null) {
            com.anythink.expressad.atsignalcommon.windvane.d mVar = new com.anythink.expressad.atsignalcommon.windvane.m(this.e);
            this.g = mVar;
            setSignalCommunication(mVar);
        }
        this.h = new com.anythink.expressad.atsignalcommon.windvane.i(this.e, this);
    }

    public void clearWebView() {
        if (this.j) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(this, com.anythink.core.common.res.d.a);
        loadUrl(com.anythink.core.common.res.d.a);
    }

    public java.lang.String getCampaignId() {
        return this.c;
    }

    public java.lang.Object getJsObject(java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.i iVar = this.h;
        if (iVar == null) {
            return null;
        }
        return iVar.a(str);
    }

    public java.lang.Object getMraidObject() {
        return this.b;
    }

    public java.lang.Object getObject() {
        return this.a;
    }

    public java.lang.String getRid() {
        return this.i;
    }

    public com.anythink.expressad.atsignalcommon.windvane.d getSignalCommunication() {
        return this.g;
    }

    public com.anythink.expressad.atsignalcommon.windvane.e getWebViewListener() {
        return this.d;
    }

    public boolean isDestroyed() {
        return this.j;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.anythink.expressad.atsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof android.content.IntentFilter)) {
            java.lang.String url = getUrl();
            if (!android.text.TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.k = motionEvent.getRawX();
                    this.l = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.k;
                    float y = motionEvent.getY() - this.l;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48.0f) && ((rawX <= 0.0f || rawX <= 48.0f) && ((y >= 0.0f || (-1.0f) * y <= 48.0f) && (y <= 0.0f || y <= 48.0f)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(java.lang.Class cls) {
        if (this.h == null) {
            return;
        }
        com.anythink.expressad.atsignalcommon.windvane.i.a(cls);
    }

    public void release() {
        try {
            removeAllViews();
            setDownloadListener(null);
            this.a = null;
            if (com.anythink.expressad.foundation.h.t.j(getContext()) != 0) {
                com.anythink.core.common.b.o.a().a(new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.AnonymousClass1(), r0 * 1000);
            } else {
                this.j = true;
                destroy();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(android.content.Context context) {
        com.anythink.expressad.atsignalcommon.windvane.i iVar = this.h;
        if (iVar != null) {
            iVar.a(context);
        }
    }

    public void setApiManagerJSFactory(java.lang.Object obj) {
        com.anythink.expressad.atsignalcommon.windvane.i iVar = this.h;
        if (iVar != null) {
            iVar.a(obj);
        }
    }

    public void setCampaignId(java.lang.String str) {
        this.c = str;
    }

    public void setMraidObject(java.lang.Object obj) {
        this.b = obj;
    }

    public void setObject(java.lang.Object obj) {
        this.a = obj;
    }

    public void setRid(java.lang.String str) {
        this.i = str;
    }

    public void setSignalCommunication(com.anythink.expressad.atsignalcommon.windvane.d dVar) {
        this.g = dVar;
        dVar.a(this);
    }

    public void setWebViewChromeClient(com.anythink.expressad.atsignalcommon.windvane.o oVar) {
        this.f = oVar;
        setWebChromeClient(oVar);
    }

    public void setWebViewListener(com.anythink.expressad.atsignalcommon.windvane.e eVar) {
        this.d = eVar;
        com.anythink.expressad.atsignalcommon.windvane.o oVar = this.f;
        if (oVar != null) {
            oVar.a(eVar);
        }
        com.anythink.expressad.atsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(eVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }
}
