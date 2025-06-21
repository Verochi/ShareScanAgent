package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class OppoImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;
    public java.lang.String b;

    /* renamed from: com.tanx.onlyid.api.impl.OppoImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            try {
                return com.tanx.onlyid.api.impl.OppoImpl.this.c(iBinder);
            } catch (android.os.RemoteException e) {
                throw e;
            } catch (com.tanx.onlyid.api.OAIDException e2) {
                throw e2;
            } catch (java.lang.Exception e3) {
                throw new com.tanx.onlyid.api.OAIDException(e3);
            }
        }
    }

    public OppoImpl(android.content.Context context) {
        if (context instanceof android.app.Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    public final java.lang.String b(android.os.IBinder iBinder, java.lang.String str, java.lang.String str2) throws android.os.RemoteException, com.tanx.onlyid.api.OAIDException {
        com.tanx.onlyid.core.heytap.openid.IOpenID asInterface = com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new com.tanx.onlyid.api.OAIDException("IOpenID is null");
    }

    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    public final java.lang.String c(android.os.IBinder iBinder) throws android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, android.os.RemoteException, com.tanx.onlyid.api.OAIDException {
        java.lang.String packageName = this.a.getPackageName();
        java.lang.String str = this.b;
        if (str != null) {
            return b(iBinder, packageName, str);
        }
        byte[] digest = java.security.MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : digest) {
            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        java.lang.String sb2 = sb.toString();
        this.b = sb2;
        return b(iBinder, packageName, sb2);
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.OppoImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
