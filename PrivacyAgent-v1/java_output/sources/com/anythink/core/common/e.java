package com.anythink.core.common;

/* loaded from: classes12.dex */
public class e {
    public static java.lang.String a = "e";
    public static final java.lang.String b = "cp_event_callback_info";
    public static final java.lang.String c = "type_start_load";

    private static org.json.JSONObject a(java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.core.d.e.a.U, str);
                jSONObject.put("request_id", str2);
                return jSONObject;
            } catch (java.lang.Throwable unused) {
                return jSONObject;
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static void a(java.lang.Object obj, java.lang.String str, com.anythink.core.common.f.h hVar) {
        if (hVar == null) {
            return;
        }
        a(obj, str, hVar.ac(), hVar.V(), hVar.ad());
    }

    private static void a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (obj == null) {
            return;
        }
        obj.toString();
        try {
            if (obj instanceof java.util.Map) {
                java.util.Map map = (java.util.Map) obj;
                org.json.JSONObject a2 = a(str3, str4);
                if (a2 != null) {
                    map.put(str, a2);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (map == null) {
            return;
        }
        a(map.get(b), str, str2, str3, str4);
    }
}
