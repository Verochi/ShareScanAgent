package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ah implements com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener {
    final /* synthetic */ java.lang.Object a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.ae b;

    public ah(com.baidu.mobads.sdk.internal.ae aeVar, java.lang.Object obj) {
        this.b = aeVar;
        this.a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(org.json.JSONObject jSONObject) {
        java.lang.Object obj = this.a;
        if (obj instanceof android.app.Activity) {
            android.view.View findViewById = ((android.app.Activity) obj).findViewById(17);
            if (findViewById instanceof android.webkit.WebView) {
                this.b.a((android.webkit.WebView) findViewById, jSONObject);
            }
        }
    }
}
