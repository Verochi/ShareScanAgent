package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class q3 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.a.I8b7.t3 a;

    public q3(com.zx.a.I8b7.t3 t3Var) {
        this.a = t3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.zx.a.I8b7.e1 e1Var = com.zx.a.I8b7.e1.a.a;
        try {
            e1Var.a = java.lang.System.currentTimeMillis();
            e1Var.b = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
            java.lang.String a = l2Var.a.a(24);
            if (!android.text.TextUtils.isEmpty(a)) {
                e1Var.c = java.lang.Integer.parseInt(a);
            }
            e1Var.c++;
            com.zx.a.I8b7.u3 u3Var = l2Var.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e1Var.c);
            java.lang.String sb2 = sb.toString();
            u3Var.getClass();
            l2Var.a.a(24, sb2, true);
            com.zx.a.I8b7.r2.a("process start pts:" + e1Var.a + ", pid:" + e1Var.b + ", rc:" + e1Var.c);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
        if (!this.a.b.get()) {
            throw new java.lang.IllegalStateException("ZXSdkImpl not init, should init firstly");
        }
        try {
            com.zx.a.I8b7.t3.a(this.a);
        } catch (java.lang.Throwable th2) {
            this.a.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.e2.a(10000, th2.getMessage()));
            com.zx.a.I8b7.g3.a(th2, new java.lang.StringBuilder("ZXCore start failed: "));
        }
    }
}
