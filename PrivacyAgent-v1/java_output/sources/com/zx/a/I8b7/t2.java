package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class t2 implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ com.zx.sdk.api.Callback b;

    public t2(com.zx.a.I8b7.x2 x2Var, android.content.Context context, com.zx.sdk.api.Callback callback) {
        this.a = context;
        this.b = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String a;
        try {
            android.content.Context context = this.a;
            if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.j) || "{}".equals(com.zx.a.I8b7.m3.j)) {
                com.zx.a.I8b7.m3.a = context.getApplicationContext();
                com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                com.zx.a.I8b7.m3.a(l2Var.a);
                a = l2Var.a.a(16);
                com.zx.a.I8b7.m3.j = a;
            } else {
                a = com.zx.a.I8b7.m3.j;
            }
            try {
                java.lang.String optString = new org.json.JSONObject(a).optString("openid");
                if ("OPENID_CLOSED".equals(optString)) {
                    this.b.onFailed(10001, "未开通");
                    return;
                }
                com.zx.sdk.api.Callback callback = this.b;
                if (android.text.TextUtils.isEmpty(optString)) {
                    optString = "";
                }
                callback.onSuccess(optString);
            } catch (java.lang.Throwable th) {
                this.b.onFailed(10000, th.getMessage());
            }
        } catch (java.lang.Throwable th2) {
            com.zx.sdk.api.Callback callback2 = this.b;
            if (callback2 != null) {
                callback2.onFailed(10000, th2.getMessage());
            }
            com.zx.a.I8b7.g3.a(th2, com.zx.a.I8b7.f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}
