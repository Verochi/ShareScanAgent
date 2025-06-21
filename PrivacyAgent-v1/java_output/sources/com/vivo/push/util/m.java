package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class m {
    public static java.util.Map<java.lang.String, java.lang.String> a(org.json.JSONObject jSONObject) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }
}
