package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class t3 implements com.zx.a.I8b7.o3 {
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    public com.zx.module.base.Listener c;

    public static void a(com.zx.a.I8b7.t3 t3Var) throws java.lang.Throwable {
        t3Var.getClass();
        java.lang.String str = com.zx.a.I8b7.m3.i;
        if (!com.zx.a.I8b7.m3.p) {
            com.zx.a.I8b7.l.c();
        }
        com.zx.a.I8b7.p1.f();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("data", com.zx.a.I8b7.m3.a());
        java.lang.String jSONObject2 = jSONObject.toString();
        t3Var.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", jSONObject2);
        if (android.text.TextUtils.equals(str, com.zx.a.I8b7.m3.i)) {
            return;
        }
        t3Var.c.onMessage("MESSAGE_ON_ZXID_CHANGED", jSONObject2);
    }
}
