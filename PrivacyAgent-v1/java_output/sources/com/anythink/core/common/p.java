package com.anythink.core.common;

/* loaded from: classes12.dex */
public class p {
    private static volatile com.anythink.core.common.p c;
    private final java.lang.String a = "1";
    private final java.lang.String b = "2";

    private p() {
    }

    public static com.anythink.core.common.p a() {
        if (c == null) {
            synchronized (com.anythink.core.common.p.class) {
                if (c == null) {
                    c = new com.anythink.core.common.p();
                }
            }
        }
        return c;
    }

    public static void a(com.anythink.core.common.f.h hVar) {
        if (hVar == null) {
            return;
        }
        try {
            com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
            if (a != null) {
                java.lang.String N = a.N();
                if (android.text.TextUtils.isEmpty(N)) {
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(N);
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("1");
                if (optJSONObject != null) {
                    java.lang.String optString = optJSONObject.optString("token");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        java.lang.String u = hVar.u();
                        double B = hVar.B() / 1000.0d;
                        java.lang.String q = hVar.q();
                        try {
                            com.adjust.sdk.AdjustEvent adjustEvent = new com.adjust.sdk.AdjustEvent(optString);
                            adjustEvent.setRevenue(B, u);
                            adjustEvent.setOrderId(q);
                            com.adjust.sdk.Adjust.trackEvent(adjustEvent);
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
                org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("2");
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("rtye");
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("af_order_id", hVar.q());
                    hashMap.put("af_content_id", hVar.ac());
                    hashMap.put("af_content_type", hVar.ae());
                    hashMap.put("af_revenue", java.lang.Double.valueOf(optInt == 2 ? hVar.B() : hVar.B() / 1000.0d));
                    hashMap.put("af_currency", "USD");
                    com.appsflyer.AppsFlyerLib.getInstance().trackEvent(com.anythink.core.common.b.o.a().f(), "af_ad_view", hashMap);
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    private static void a(java.lang.String str, double d, java.lang.String str2, java.lang.String str3) {
        try {
            com.adjust.sdk.AdjustEvent adjustEvent = new com.adjust.sdk.AdjustEvent(str);
            adjustEvent.setRevenue(d, str2);
            adjustEvent.setOrderId(str3);
            com.adjust.sdk.Adjust.trackEvent(adjustEvent);
        } catch (java.lang.Throwable unused) {
        }
    }
}
