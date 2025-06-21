package com.anythink.expressad.atsignalcommon.bridge;

/* loaded from: classes12.dex */
public abstract class CommonBannerJSBridgeImp implements com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge {
    public static final java.lang.String a = "CommonBannerJSBridgeImp";

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
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

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void click(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getNetstat(java.lang.Object obj, java.lang.String str) {
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
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(1));
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.m, com.anythink.expressad.foundation.h.k.a());
            java.lang.String jSONObject2 = jSONObject.toString();
            if (!android.text.TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = android.util.Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, jSONObject2);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            e.getMessage();
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.increaseOfferFrequence(obj, new org.json.JSONObject(str));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void init(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void install(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void onJSBridgeConnect(java.lang.Object obj, java.lang.String str) {
        try {
            if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.b(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
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

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void readyStatus(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
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
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
    }
}
