package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class d {
    public static org.json.JSONObject a;

    private static void a(java.lang.String str) {
        try {
            a = new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
