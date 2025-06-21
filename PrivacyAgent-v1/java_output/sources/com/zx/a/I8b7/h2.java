package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class h2 {
    public static final java.util.Set<java.lang.String> b;
    public com.zx.a.I8b7.o3 a;

    static {
        java.util.HashSet hashSet = new java.util.HashSet();
        b = hashSet;
        com.zx.a.I8b7.m3.c = "core-n";
        com.zx.a.I8b7.m3.d = "3.3.4.43514";
        hashSet.add("fd39c63f1732f201");
        hashSet.add("182215c3273d3c96");
        hashSet.add("30c3b906fa3a6c10");
        hashSet.add("83e1f70a049353e0");
        hashSet.add("a14a9b473d09b4a4");
        hashSet.add("c5d0f5289411bfb1");
        hashSet.add("888db8aca12678cf");
        hashSet.add("4d34408b292920ff");
        java.util.Set<java.lang.String> set = com.zx.a.I8b7.m3.H;
        set.add("fd39c63f1732f201");
        set.add("182215c3273d3c96");
        set.add("30c3b906fa3a6c10");
        set.add("83e1f70a049353e0");
        set.add("888db8aca12678cf");
    }

    public final java.lang.String a(java.lang.String str, int i) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }

    public java.lang.String f182215c3273d3c96(java.lang.String str) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", false);
        jSONObject.put("code", 0);
        return jSONObject.toString();
    }

    public java.lang.String f30c3b906fa3a6c10(java.lang.String str) throws org.json.JSONException {
        try {
            boolean z = new org.json.JSONObject(str).getBoolean("isDebug");
            "isDebug: ".concat(java.lang.String.valueOf(z));
            com.zx.a.I8b7.r.a = z;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", 0);
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return a(th.getMessage(), 1);
        }
    }

    public void f4d34408b292920ff(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.r2.a("getAuthToken:" + str + "with cb");
        try {
            com.zx.a.I8b7.n3.b.a.b(new org.json.JSONObject(str), callback, 1);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.b("getAuthToken error:".concat(java.lang.String.valueOf(th)));
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.r2.a(th2);
                }
            }
        }
    }

    public java.lang.String f83e1f70a049353e0(java.lang.String str) throws org.json.JSONException {
        com.zx.a.I8b7.m3.b = new org.json.JSONObject(str).getString("version");
        return a("", 0);
    }

    public java.lang.String f888db8aca12678cf(java.lang.String str) throws org.json.JSONException {
        return a("lib not work", 1);
    }

    public void fa14a9b473d09b4a4(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.r2.a("getUAID:" + str + "with cb");
        try {
            com.zx.a.I8b7.n3.b.a.b(new org.json.JSONObject(str), callback, 0);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.b("getUAID error:".concat(java.lang.String.valueOf(th)));
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.r2.a(th2);
                }
            }
        }
    }

    public void fc5d0f5289411bfb1(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.r2.a("getTag:" + str + "with cb");
        try {
            callback.callback(a(com.zx.a.I8b7.b2.c(), 0));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.b("getTag error:".concat(java.lang.String.valueOf(th)));
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.r2.a(th2);
                }
            }
        }
    }

    public java.lang.String ffd39c63f1732f201(java.lang.String str) throws org.json.JSONException {
        java.lang.String str2;
        boolean z = new org.json.JSONObject(str).getBoolean("allowExpired");
        ((com.zx.a.I8b7.t3) this.a).getClass();
        if (!z) {
            java.lang.String str3 = com.zx.a.I8b7.m3.i;
            boolean z2 = true;
            if (!android.text.TextUtils.isEmpty(str3)) {
                try {
                    if (java.lang.System.currentTimeMillis() < java.lang.Long.parseLong(str3.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]) * 1000) {
                        z2 = false;
                    }
                } catch (java.lang.Exception e) {
                    com.zx.a.I8b7.r2.b("zid判断过期异常:" + str3 + ", err :" + e.getMessage());
                }
            }
            if (z2) {
                str2 = null;
                return a(str2, 0);
            }
        }
        str2 = com.zx.a.I8b7.m3.a();
        return a(str2, 0);
    }
}
