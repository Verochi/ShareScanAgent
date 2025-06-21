package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class c0 {
    public static boolean a() {
        try {
            if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.B)) {
                return false;
            }
            if (java.lang.System.currentTimeMillis() - com.zx.a.I8b7.m3.u >= new org.json.JSONObject(com.zx.a.I8b7.m3.B).getLong("frequency") * 1000) {
                return false;
            }
            com.zx.a.I8b7.r2.a("report freq c true");
            return true;
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            return false;
        }
    }
}
