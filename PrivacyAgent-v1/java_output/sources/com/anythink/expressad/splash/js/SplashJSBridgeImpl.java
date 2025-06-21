package com.anythink.expressad.splash.js;

/* loaded from: classes12.dex */
public class SplashJSBridgeImpl implements com.anythink.expressad.splash.js.ISplashBridge {
    private java.lang.ref.WeakReference<android.content.Context> b;
    private java.util.List<com.anythink.expressad.foundation.d.c> c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private int g;
    private int i;
    private com.anythink.expressad.splash.d.a j;
    private com.anythink.expressad.splash.js.SplashExpandDialog k;
    private java.lang.String a = "SplashJSBridgeImpl";
    private int h = 5;

    public SplashJSBridgeImpl(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.e = str;
        this.d = str2;
        this.b = new java.lang.ref.WeakReference<>(context);
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void cai(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                java.lang.String optString = new org.json.JSONObject(str).optString("packageName");
                if (android.text.TextUtils.isEmpty(optString)) {
                    com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "packageName is empty");
                }
                int i = com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), optString) ? 1 : 2;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
                    e.getMessage();
                }
            } catch (java.lang.Throwable th) {
                com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
            }
        } catch (org.json.JSONException e2) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        try {
            com.anythink.expressad.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.c();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(java.lang.String str, boolean z) {
        try {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            java.lang.ref.WeakReference<android.content.Context> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            com.anythink.expressad.splash.js.SplashExpandDialog splashExpandDialog = this.k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                com.anythink.expressad.splash.js.SplashExpandDialog splashExpandDialog2 = new com.anythink.expressad.splash.js.SplashExpandDialog(this.b.get(), bundle, this.j);
                this.k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.d, this.c);
                this.k.show();
                com.anythink.expressad.splash.d.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.c.get(0);
    }

    public com.anythink.expressad.splash.d.a getSplashBridgeListener() {
        return this.j;
    }

    public java.util.List<com.anythink.expressad.foundation.d.c> getmCampaignList() {
        return this.c;
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("packageNameList", new org.json.JSONArray());
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            e.getMessage();
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void init(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.anythink.expressad.splash.a.a aVar = new com.anythink.expressad.splash.a.a(com.anythink.core.common.b.o.a().f());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, aVar.a());
            jSONObject.put("campaignList", com.anythink.expressad.foundation.d.c.b(this.c));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.d);
            if (c == null) {
                c = com.anythink.expressad.d.c.c(this.d);
            }
            if (!android.text.TextUtils.isEmpty(this.e)) {
                c.e(this.e);
            }
            c.a(this.d);
            c.b(this.h);
            c.a(this.g);
            jSONObject.put("unitSetting", c.s());
            com.anythink.expressad.d.b.a();
            java.lang.String a = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
            if (!android.text.TextUtils.isEmpty(a)) {
                jSONObject.put("appSetting", new org.json.JSONObject(a));
            }
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.atsignalcommon.base.d.a);
            jSONObject.toString();
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void install(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.c;
            if (list == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = (list == null || list.size() <= 0) ? null : this.c.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject a = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    a.put(next, jSONObject.getString(next));
                }
                com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(a);
                java.lang.String optString = a.optString("unitId");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    b.l(optString);
                }
                cVar = b;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.anythink.expressad.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(cVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void onJSBridgeConnect(java.lang.Object obj, java.lang.String str) {
        try {
            if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.b(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(java.lang.String str) {
        com.anythink.expressad.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (f == null) {
            try {
                if ((obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                    f = windVaneWebView.getContext();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        if (f == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.anythink.core.common.o.m.a(optString);
            } else if (optInt == 2) {
                com.anythink.core.common.o.m.a(f, optString);
            }
        } catch (org.json.JSONException e2) {
            e2.getMessage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void pauseCountDown(java.lang.Object obj, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.anythink.expressad.d.a.b.dk, this.i);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
        com.anythink.expressad.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void readyStatus(java.lang.Object obj, java.lang.String str) {
    }

    public void release() {
        if (this.j != null) {
            this.j = null;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void reportUrls(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type");
                java.lang.String optString = jSONObject.optString("url");
                int optInt2 = jSONObject.optInt(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_REPORT);
                boolean z = true;
                if (optInt2 == 0) {
                    android.content.Context f = com.anythink.core.common.b.o.a().f();
                    if (optInt == 0) {
                        z = false;
                    }
                    com.anythink.expressad.a.a.a(f, (com.anythink.expressad.foundation.d.c) null, "", optString, z);
                } else {
                    com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), null, "", optString, false, optInt != 0, optInt2);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.splash.js.SplashJsUtils.codeToJsonString(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int i = new org.json.JSONObject(str).getInt(com.anythink.expressad.d.a.b.dk);
            com.anythink.expressad.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.b(i);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @Override // com.anythink.expressad.splash.js.ISplashBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resumeCountDown(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.d.a aVar;
        int i = 0;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                int optInt = new org.json.JSONObject(str).optInt(com.anythink.expressad.d.a.b.dk);
                try {
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.splash.js.SplashJsUtils.codeToJsonString(0));
                    i = optInt;
                } catch (java.lang.Exception e) {
                    e = e;
                    i = optInt;
                    e.getMessage();
                    aVar = this.j;
                    if (aVar == null) {
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        }
        aVar = this.j;
        if (aVar == null) {
            aVar.a(2, i);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String string = jSONArray.getString(i);
                for (com.anythink.expressad.foundation.d.c cVar : this.c) {
                    if (cVar.aZ().equals(string)) {
                        com.anythink.expressad.foundation.g.a.f.a(this.d, cVar, "splash");
                        arrayList.add(string);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setAllowSkip(int i) {
        this.g = i;
    }

    public void setCampaignList(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.c = list;
    }

    public void setCountdownS(int i) {
        this.h = i;
    }

    public void setDevCloseBtnStatus(int i) {
        this.f = i;
    }

    public void setSplashBridgeListener(com.anythink.expressad.splash.d.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
            com.anythink.expressad.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(optInt);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    public void updateContext(android.content.Context context) {
        this.b = new java.lang.ref.WeakReference<>(context);
    }

    public void updateCountDown(int i) {
        this.i = i;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            com.anythink.expressad.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
