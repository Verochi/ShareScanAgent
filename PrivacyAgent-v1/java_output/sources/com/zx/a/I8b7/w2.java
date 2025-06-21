package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class w2 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback a;
    public final /* synthetic */ android.app.Activity b;

    public w2(com.zx.a.I8b7.x2 x2Var, com.zx.sdk.api.PermissionCallback permissionCallback, android.app.Activity activity) {
        this.a = permissionCallback;
        this.b = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.c1 c1Var = new com.zx.a.I8b7.c1(this.a);
            android.os.Handler handler = com.zx.a.I8b7.k3.a;
            com.zx.a.I8b7.k3 k3Var = com.zx.a.I8b7.k3.a.a;
            if (k3Var.b()) {
                com.zx.a.I8b7.k3.a.post(new com.zx.a.I8b7.j3(k3Var, this.b, c1Var));
            } else if (k3Var.a()) {
                c1Var.onAuthorized();
            } else {
                c1Var.onUnauthorized();
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.registerListener(listener) failed: "));
        }
    }
}
