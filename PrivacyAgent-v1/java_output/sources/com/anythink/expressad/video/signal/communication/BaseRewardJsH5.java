package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public class BaseRewardJsH5 implements com.anythink.expressad.video.signal.communication.IRewardBridge {
    protected static final java.lang.String a = "JS-Reward-Brigde";
    protected com.anythink.expressad.video.signal.factory.IJSFactory b;

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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(java.lang.Object obj, java.lang.String str) {
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory = this.b;
            if (iJSFactory != null) {
                java.lang.String a2 = iJSFactory.getIJSRewardVideoV1().a();
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, !android.text.TextUtils.isEmpty(a2) ? android.util.Base64.encodeToString(a2.getBytes(), 2) : "");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("packageNameList", "[]");
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.getIJSRewardVideoV1().handlerPlayableException(new org.json.JSONObject(str).optString("msg"));
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        if (context instanceof com.anythink.expressad.video.signal.factory.IJSFactory) {
            this.b = (com.anythink.expressad.video.signal.factory.IJSFactory) context;
        }
    }

    public void initialize(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        if (obj instanceof com.anythink.expressad.video.signal.factory.IJSFactory) {
            this.b = (com.anythink.expressad.video.signal.factory.IJSFactory) obj;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.video.signal.a.j jVar;
        android.content.Context context;
        try {
            if (this.b != null) {
                if (obj != null) {
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if ((aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) && (jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject()) != null && (context = aVar.a.getContext()) != null && context != context.getApplicationContext()) {
                        jVar.a(context);
                    }
                }
                if (this.b.getJSContainerModule().endCardShowing()) {
                    this.b.getJSCommon().click(3, str);
                } else {
                    this.b.getJSCommon().click(1, str);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.getIJSRewardVideoV1().notifyCloseBtn(new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.getIJSRewardVideoV1().b(new org.json.JSONObject(str).optString(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.getIJSRewardVideoV1().toggleCloseBtn(new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, a(0));
            this.b.getIJSRewardVideoV1().a(new org.json.JSONObject(str).optString(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b));
        } catch (java.lang.Throwable unused) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, a(-1));
        }
    }
}
