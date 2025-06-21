package com.anythink.expressad.advanced.js;

/* loaded from: classes12.dex */
public class NativeAdvancedJSBridgeImpl extends com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp {
    private java.lang.ref.WeakReference<android.content.Context> c;
    private java.util.List<com.anythink.expressad.foundation.d.c> d;
    private java.lang.String e;
    private java.lang.String f;
    private int g;
    private int h;
    private com.anythink.expressad.advanced.d.a j;
    private com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog k;
    private java.lang.String b = "NativeAdvancedJSBridgeImpl";
    private int i = 5;

    public NativeAdvancedJSBridgeImpl(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.f = str;
        this.e = str2;
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void click(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
            com.anythink.expressad.foundation.d.c cVar = (list == null || list.size() <= 0) ? null : this.d.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject a = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME);
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
            com.anythink.expressad.advanced.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(cVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        try {
            com.anythink.expressad.advanced.d.a aVar = this.j;
            if (aVar != null) {
                aVar.e();
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
            java.lang.ref.WeakReference<android.content.Context> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog nativeAdvancedExpandDialog = this.k;
            if (nativeAdvancedExpandDialog == null || !nativeAdvancedExpandDialog.isShowing()) {
                com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog nativeAdvancedExpandDialog2 = new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog(this.c.get(), bundle, this.j);
                this.k = nativeAdvancedExpandDialog2;
                nativeAdvancedExpandDialog2.setCampaignList(this.e, this.d);
                this.k.show();
                com.anythink.expressad.advanced.d.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is empty");
            return;
        }
        try {
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.getFileInfo(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.d.get(0);
    }

    public java.util.List<com.anythink.expressad.foundation.d.c> getmCampaignList() {
        return this.d;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void init(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.anythink.expressad.advanced.a.b bVar = new com.anythink.expressad.advanced.a.b(com.anythink.core.common.b.o.a().f());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, bVar.a());
            jSONObject.put("campaignList", com.anythink.expressad.foundation.d.c.b(this.d));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c d = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.e);
            if (d == null) {
                d = com.anythink.expressad.d.c.y();
            }
            if (!android.text.TextUtils.isEmpty(this.f)) {
                d.e(this.f);
            }
            d.a(this.e);
            d.b(this.i);
            d.a(this.h);
            jSONObject.put("unitSetting", d.s());
            jSONObject.put("appSetting", new org.json.JSONObject());
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.atsignalcommon.base.d.a);
            jSONObject.toString();
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void install(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
            com.anythink.expressad.foundation.d.c cVar = (list == null || list.size() <= 0) ? null : this.d.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject a = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME);
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
            com.anythink.expressad.advanced.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(cVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
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
        com.anythink.expressad.advanced.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void readyStatus(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) || (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, new org.json.JSONObject(str).getInt("isReady"));
            } catch (java.lang.Exception unused) {
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, 2);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void release() {
        if (this.j != null) {
            this.j = null;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            new org.json.JSONObject(str).getInt(com.anythink.expressad.d.a.b.dk);
            com.anythink.expressad.advanced.d.a aVar = this.j;
            if (aVar != null) {
                aVar.c();
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String string = jSONArray.getString(i);
                for (com.anythink.expressad.foundation.d.c cVar : this.d) {
                    if (cVar.aZ().equals(string)) {
                        com.anythink.expressad.foundation.g.a.f.a(this.e, cVar, com.anythink.expressad.foundation.g.a.f.g);
                        arrayList.add(string);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setAllowSkip(int i) {
        this.h = i;
    }

    public void setCampaignList(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.d = list;
    }

    public void setCountdownS(int i) {
        this.i = i;
    }

    public void setDevCloseBtnStatus(int i) {
        this.g = i;
    }

    public void setNativeAdvancedBridgeListener(com.anythink.expressad.advanced.d.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
            com.anythink.expressad.advanced.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(optInt);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (this.j != null) {
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.callbackSuccess(obj);
            this.j.a();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    public void updateContext(android.content.Context context) {
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        try {
            if (this.h == -1) {
                int i = z ? 2 : 1;
                com.anythink.expressad.advanced.d.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(i);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
