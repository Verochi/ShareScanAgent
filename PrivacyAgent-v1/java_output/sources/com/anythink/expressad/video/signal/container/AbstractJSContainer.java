package com.anythink.expressad.video.signal.container;

/* loaded from: classes12.dex */
public abstract class AbstractJSContainer extends android.widget.FrameLayout implements com.anythink.expressad.video.signal.factory.IJSFactory {
    protected static final java.lang.String l = "AbstractJSContainer";
    protected com.anythink.expressad.video.signal.factory.IJSFactory A;
    private int a;
    private int b;
    protected android.app.Activity m;
    protected java.lang.String n;
    protected java.lang.String o;
    protected com.anythink.expressad.videocommon.e.d p;
    protected java.lang.String q;
    protected com.anythink.expressad.videocommon.c.c r;

    /* renamed from: s, reason: collision with root package name */
    protected java.lang.String f281s;
    protected int t;
    protected boolean u;
    protected boolean v;
    protected int w;
    protected int x;
    protected int y;
    protected boolean z;

    public AbstractJSContainer(android.content.Context context) {
        super(context);
        this.a = 0;
        this.b = 1;
        this.t = 2;
        this.u = false;
        this.v = false;
        this.z = false;
        this.A = new com.anythink.expressad.video.signal.factory.a();
    }

    public AbstractJSContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 1;
        this.t = 2;
        this.u = false;
        this.v = false;
        this.z = false;
        this.A = new com.anythink.expressad.video.signal.factory.a();
    }

    private static java.lang.String a(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static void a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, str, android.util.Base64.encodeToString(str2.getBytes(), 2));
    }

    public static void a(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(str.getBytes(), 2));
    }

    private void b(java.lang.Object obj) {
        com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, a(this.b));
    }

    private static void b(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(str.getBytes(), 2));
    }

    @android.annotation.SuppressLint({"SourceLockedOrientationActivity"})
    private boolean b(int i) {
        try {
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        if (i != 1) {
            if (i == 2) {
                this.m.setRequestedOrientation(11);
            }
            return false;
        }
        this.m.setRequestedOrientation(12);
        return true;
    }

    public final void a(com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.d.c.C0208c M;
        if (c(cVar) == 1) {
            return;
        }
        if (((cVar == null || (M = cVar.M()) == null) ? false : b(M.c())) || dVar == null) {
            return;
        }
        b(this.p.b());
    }

    public final void a(java.lang.Object obj) {
        com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, a(this.a));
    }

    public void a(java.lang.String str) {
        android.app.Activity activity = this.m;
        if (activity != null) {
            activity.finish();
        }
    }

    public final com.anythink.expressad.video.signal.a.j b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.anythink.expressad.videocommon.a.C0231a a = com.anythink.expressad.videocommon.a.a(this.u ? com.anythink.expressad.foundation.g.a.aU : 94, cVar);
        if (a != null && a.c()) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a2 = a.a();
            if (a2.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                return (com.anythink.expressad.video.signal.a.j) a2.getObject();
            }
        }
        return null;
    }

    public final java.lang.String b() {
        com.anythink.expressad.videocommon.e.d dVar;
        return (!android.text.TextUtils.isEmpty(this.o) || (dVar = this.p) == null || android.text.TextUtils.isEmpty(dVar.O())) ? this.o : this.p.O();
    }

    public final int c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.video.signal.a.j b = b(cVar);
        if (b != null) {
            return b.d();
        }
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        return this.A.getActivityProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.i getIJSRewardVideoV1() {
        return this.A.getIJSRewardVideoV1();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        return this.A.getJSBTModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        return this.A.getJSCommon();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.e getJSContainerModule() {
        return this.A.getJSContainerModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.g getJSNotifyProxy() {
        return this.A.getJSNotifyProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        return this.A.getJSVideoModule();
    }

    public java.lang.String getPlacementId() {
        return this.o;
    }

    public java.lang.String getUnitId() {
        return this.n;
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (getJSCommon().g()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().g()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().g()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().g()) {
            getActivityProxy();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        if (getJSCommon().g()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().g()) {
            getActivityProxy();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().g()) {
            getActivityProxy();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory) {
        this.A = iJSFactory;
    }

    public void setActivity(android.app.Activity activity) {
        this.m = activity;
    }

    public void setBidCampaign(boolean z) {
        this.v = z;
    }

    public void setBigOffer(boolean z) {
        this.z = z;
    }

    public void setIV(boolean z) {
        this.u = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.w = i;
        this.x = i2;
        this.y = i3;
    }

    public void setMute(int i) {
        this.t = i;
    }

    public void setPlacementId(java.lang.String str) {
        this.o = str;
    }

    public void setReward(com.anythink.expressad.videocommon.c.c cVar) {
        this.r = cVar;
    }

    public void setRewardId(java.lang.String str) {
        this.f281s = str;
    }

    public void setRewardUnitSetting(com.anythink.expressad.videocommon.e.d dVar) {
        this.p = dVar;
    }

    public void setUnitId(java.lang.String str) {
        this.n = str;
    }

    public void setUserId(java.lang.String str) {
        this.q = str;
    }
}
