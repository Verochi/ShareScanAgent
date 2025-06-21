package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class u2 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback a;

    public u2(com.zx.a.I8b7.x2 x2Var, com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.l2.a.a.a.c(1);
            com.zx.a.I8b7.r.a("用户已授权获取卓信ID");
            try {
                com.zx.a.I8b7.x2.a().a(com.zx.a.I8b7.m3.a);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.r.b(e.getMessage());
            }
            this.a.onAuthorized();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("卓信ID授权失败 error: "));
        }
    }
}
