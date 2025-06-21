package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public class BaseRewardJs extends com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5 implements com.anythink.expressad.video.signal.communication.IRewardBridge {
    protected static final java.lang.String h = "JS-Reward-Brigde";
    protected com.anythink.expressad.video.signal.communication.IRewardBridge i;

    private static java.lang.String a() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", -1);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.communication.IRewardBridge iRewardBridge = this.i;
            if (iRewardBridge != null) {
                iRewardBridge.getEndScreenInfo(obj, str);
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (!(windVaneWebView instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(obj);
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
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.handlerPlayableException(obj, str);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(context, windVaneWebView);
        try {
            z = com.anythink.expressad.video.signal.factory.IJSFactory.class.isInstance(context);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                this.i = (com.anythink.expressad.video.signal.communication.IRewardBridge) com.anythink.expressad.video.signal.communication.BaseRewardJsH5.class.newInstance();
                com.anythink.expressad.video.signal.communication.BaseRewardJsH5.class.getMethod("initialize", android.content.Context.class, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.class).invoke(this.i, context, windVaneWebView);
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.communication.IRewardBridge)) {
                    return;
                }
                this.i = (com.anythink.expressad.video.signal.communication.IRewardBridge) windVaneWebView.getObject();
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(obj, windVaneWebView);
        try {
            z = com.anythink.expressad.video.signal.factory.IJSFactory.class.isInstance(obj);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                this.i = (com.anythink.expressad.video.signal.communication.IRewardBridge) com.anythink.expressad.video.signal.communication.BaseRewardJsH5.class.newInstance();
                com.anythink.expressad.video.signal.communication.BaseRewardJsH5.class.getMethod("initialize", java.lang.Object.class, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.class).invoke(this.i, obj, windVaneWebView);
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.communication.IRewardBridge)) {
                    return;
                }
                this.i = (com.anythink.expressad.video.signal.communication.IRewardBridge) windVaneWebView.getObject();
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.communication.IRewardBridge iRewardBridge = this.i;
            if (iRewardBridge != null) {
                iRewardBridge.install(obj, str);
                return;
            }
            if (android.text.TextUtils.isEmpty(str) || obj == null) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject();
                android.content.Context context = aVar.a.getContext();
                if (context != null && context != context.getApplicationContext()) {
                    jVar.a(context);
                }
                jVar.click(1, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.notifyCloseBtn(obj, str);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.anythink.core.common.o.m.a(optString);
            } else if (optInt == 2) {
                com.anythink.core.common.o.m.a(this.e, optString);
            }
        } catch (org.json.JSONException e) {
            e.getMessage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.setOrientation(obj, str);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.toggleCloseBtn(obj, str);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.triggerCloseBtn(obj, str);
        } catch (java.lang.Throwable unused) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, a());
        }
    }
}
