package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class c1 implements com.zx.sdk.api.PermissionCallback {
    public com.zx.sdk.api.PermissionCallback a;

    public c1(com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = permissionCallback;
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onAuthorized() {
        try {
            if (this.a != null) {
                com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
                com.zx.sdk.api.PermissionCallback permissionCallback = this.a;
                b.getClass();
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.u2(b, permissionCallback));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onUnauthorized() {
        try {
            if (this.a != null) {
                com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
                b.getClass();
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.v2(b));
                this.a.onUnauthorized();
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
