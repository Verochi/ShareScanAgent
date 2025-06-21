package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class g2 implements com.zx.sdk.api.ZXApi {
    public java.lang.String a;

    public g2(java.lang.String str) throws java.lang.IllegalStateException {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalStateException("ZX_APPID not found");
        }
        this.a = str;
    }

    @Override // com.zx.sdk.api.ZXApi
    public void addZXIDChangedListener(com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "addZXIDChangedListener", "");
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            java.lang.String str = this.a;
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.e3(b, str, zXIDChangedListener));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void allowPermissionDialog(boolean z) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "allowPermissionDialog", "enable=".concat(java.lang.String.valueOf(z)));
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.c3(b, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void checkPermission(android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "checkPermission", "");
            if (permissionCallback == null) {
                return;
            }
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.w2(b, permissionCallback, activity));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getAuthToken(com.zx.sdk.api.Callback callback) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "getAuthToken", "");
            if (callback == null) {
                return;
            }
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            java.lang.String str = this.a;
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.a3(b, str, callback));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getOpenID(com.zx.sdk.api.Callback callback, android.content.Context context) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "getOpenID", "");
            if (callback != null) {
                com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
                b.getClass();
                com.zx.a.I8b7.v3.f.a.c.execute(new com.zx.a.I8b7.t2(b, context, callback));
            }
        } catch (java.lang.Throwable th) {
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.getOpenID(cb) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getSAID(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.zx.sdk.api.SAIDCallback sAIDCallback) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "getUAID", "");
            if (sAIDCallback != null) {
                com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
                java.lang.String str6 = this.a;
                b.getClass();
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.y2(b, str6, str, str2, str3, str4, str5, sAIDCallback));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager getSAID onFailed:"));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getTag(com.zx.sdk.api.Callback callback) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "getTag", "");
            if (callback == null) {
                return;
            }
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            java.lang.String str = this.a;
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.z2(b, str, callback));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public java.lang.String getVersion() {
        com.zx.a.I8b7.y.b.a.a(this.a, "getVersion", "");
        return "3.3.4.43514";
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getZXID(com.zx.sdk.api.ZXIDListener zXIDListener) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "getZXID", "");
            if (zXIDListener != null) {
                com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
                java.lang.String str = this.a;
                b.getClass();
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.s2(b, str, zXIDListener));
            }
        } catch (java.lang.Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void init(android.content.Context context) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "init", "");
            com.zx.a.I8b7.x2.a(context);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r.b("ZXManager.init failed:".concat(java.lang.String.valueOf(th)));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public java.lang.String invoke(java.lang.String str, java.lang.String str2) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "invoke", "method=" + str + "&argument" + str2);
            return com.zx.a.I8b7.x2.b().a(str, str2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isAllowPermissionDialog() {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "isAllowPermissionDialog", "");
            com.zx.a.I8b7.x2.b().getClass();
            return com.zx.a.I8b7.m3.f490s == 1;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isEnable() {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "isEnable", "");
            com.zx.a.I8b7.x2.b().getClass();
            return com.zx.a.I8b7.m3.r == 1;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setDebug(boolean z) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "setDebug", "isDebug=".concat(java.lang.String.valueOf(z)));
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.d3(b, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setEnable(boolean z) {
        try {
            com.zx.a.I8b7.y.b.a.a(this.a, "setEnable", "enable=".concat(java.lang.String.valueOf(z)));
            com.zx.a.I8b7.x2 b = com.zx.a.I8b7.x2.b();
            b.getClass();
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.b3(b, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.setEnable failed: "));
        }
    }
}
