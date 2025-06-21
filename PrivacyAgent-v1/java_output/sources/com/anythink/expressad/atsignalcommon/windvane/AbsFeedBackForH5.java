package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public abstract class AbsFeedBackForH5 extends com.anythink.expressad.atsignalcommon.windvane.l {
    public static final java.lang.String a = "onFeedbackAlertStatusNotify";
    public static final java.lang.String b = "status";
    public static final int c = 1;
    public static final int d = 2;
    private static int i = 0;
    private static int j = 1;
    private java.lang.String h = "AbsFeedBackForH5";

    public void callbackExcep(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", j);
            jSONObject.put("message", str);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void callbackSuccess(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", "");
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            callbackExcep(obj, e.getMessage());
            e.getMessage();
        }
    }

    public void callbackSuccessWithData(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("code", i);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            callbackExcep(obj, e.getMessage());
            e.getMessage();
        }
    }

    public void feedbackLayoutOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt("radius", 20);
                int optInt4 = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, -1);
                int optInt5 = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                java.lang.String optString = jSONObject.optString("fontColor", "");
                java.lang.String optString2 = jSONObject.optString("bgColor", "");
                com.anythink.expressad.foundation.f.a.a a2 = com.anythink.expressad.foundation.f.b.a().a(jSONObject.optString("key", ""));
                android.content.Context f = com.anythink.core.common.b.o.a().f();
                a2.a(com.anythink.expressad.foundation.h.t.b(f, optInt4), com.anythink.expressad.foundation.h.t.b(f, optInt5), com.anythink.expressad.foundation.h.t.b(f, optInt), com.anythink.expressad.foundation.h.t.b(f, optInt2), com.anythink.expressad.foundation.h.t.b(f, optInt3), (float) optDouble, optString, optString2);
            }
            callbackSuccess(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                java.lang.String optString = jSONObject.optString("key", "");
                com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
                int i2 = optInt == 1 ? 8 : 0;
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
                com.anythink.expressad.foundation.f.a.a a3 = a2.a(optString);
                if (a3.c() != null) {
                    a3.a(i2);
                    if (i2 == 0) {
                        a2.a(optString, com.anythink.core.common.b.o.a().f(), windVaneWebView, null, null);
                    }
                }
            }
            callbackSuccess(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                com.anythink.expressad.foundation.f.a.a a2 = com.anythink.expressad.foundation.f.b.a().a(jSONObject.optString("key", ""));
                if (optInt == 1) {
                    a2.b();
                } else {
                    a2.a();
                }
            }
            callbackSuccess(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void getCacheKey(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.c.a.a().a(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void startShake(java.lang.Object obj, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                jSONObject.optInt("deviceMotionUpdateInterval", 1);
                com.anythink.expressad.atsignalcommon.c.a.a().a(obj, ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, jSONObject.optString("oldCache", ""), jSONObject.optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void stopShake(java.lang.Object obj, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.c.a.a().a(obj, ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, new org.json.JSONObject(str).optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}
