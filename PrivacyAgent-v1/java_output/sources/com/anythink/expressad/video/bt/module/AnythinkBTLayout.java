package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class AnythinkBTLayout extends com.anythink.expressad.video.bt.module.BTBaseView {
    private static final java.lang.String p = "portrait";
    private static final java.lang.String q = "landscape";
    private android.webkit.WebView r;

    public AnythinkBTLayout(android.content.Context context) {
        super(context);
    }

    public AnythinkBTLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void broadcast(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.r != null) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                jSONObject2.put("id", getInstanceId());
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(this.r, "broadcast", android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (java.lang.Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(this.r, "broadcast", getInstanceId());
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(android.content.Context context) {
    }

    public void notifyEvent(java.lang.String str) {
        android.webkit.WebView webView = this.r;
        if (webView != null) {
            com.anythink.expressad.video.bt.module.BTBaseView.a(webView, str, this.d);
        }
    }

    public void onBackPressed() {
        if (this.r != null) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.r, "onSystemBackPressed", this.d);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (this.r != null) {
            try {
                com.anythink.expressad.foundation.d.c cVar = this.b;
                if (cVar == null || !cVar.j()) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    if (configuration.orientation == 2) {
                        jSONObject.put("orientation", q);
                    } else {
                        jSONObject.put("orientation", p);
                    }
                    jSONObject.put("instanceId", this.d);
                    java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(this.r, "orientation", encodeToString);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
    }

    public void setWebView(android.webkit.WebView webView) {
        this.r = webView;
    }
}
