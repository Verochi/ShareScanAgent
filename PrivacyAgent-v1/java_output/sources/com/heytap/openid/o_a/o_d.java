package com.heytap.openid.o_a;

/* loaded from: classes22.dex */
public class o_d {
    public com.heytap.openid.o_a a = null;
    public java.lang.String b = null;
    public java.lang.String c = null;
    public final java.lang.Object d = new java.lang.Object();
    public android.content.ServiceConnection e = new com.heytap.openid.o_a.o_c(this);

    public static class o_a {
        public static final com.heytap.openid.o_a.o_d a = new com.heytap.openid.o_a.o_d(null);
    }

    public /* synthetic */ o_d(com.heytap.openid.o_a.o_c o_cVar) {
    }

    public synchronized java.lang.String a(android.content.Context context, java.lang.String str) {
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getOpenID:" + str);
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            com.heytap.openid.o_a.o_b.b("HeyTapID", "Get ID Cannot run on MainThread");
            return "";
        }
        if (this.a != null) {
            try {
                com.heytap.openid.o_a.o_b.a("OpenIDHelper", "Service already Connected,execute getResultFromService");
                return b(context, str);
            } catch (android.os.RemoteException e) {
                com.heytap.openid.o_a.o_b.a("OpenIDHelper", e);
                return "";
            }
        }
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "openIDService is NULL");
        b(context);
        if (this.a == null) {
            com.heytap.openid.o_a.o_b.b("OpenIDHelper", "openIDService is NULL, return NULL");
            return "";
        }
        try {
            com.heytap.openid.o_a.o_b.a("OpenIDHelper", "execute getResultFromService");
            return b(context, str);
        } catch (android.os.RemoteException e2) {
            com.heytap.openid.o_a.o_b.a("OpenIDHelper", e2);
            return "";
        }
    }

    public boolean a(android.content.Context context) {
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "isSupported");
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 1;
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final java.lang.String b(android.content.Context context, java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (android.text.TextUtils.isEmpty(this.c)) {
            java.lang.String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : digest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (java.security.NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = str2;
        }
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getOpenId Start");
        com.heytap.openid.o_a o_aVar = this.a;
        if (o_aVar != null) {
            java.lang.String a = ((com.heytap.openid.o_a.AbstractBinderC0358o_a.C0359o_a) o_aVar).a(this.b, this.c, str);
            com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getOpenId End");
            return android.text.TextUtils.isEmpty(a) ? "" : a;
        }
        com.heytap.openid.o_a.o_b.b(context.getPackageName() + ":OpenIDHelper", "openIDService is NULL, return NULL");
        return "";
    }

    public final void b(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "bindService START");
        if (context.bindService(intent, this.e, 1)) {
            com.heytap.openid.o_a.o_b.a("OpenIDHelper", "LOCK to wait 3000 until Service connected");
            synchronized (this.d) {
                try {
                    this.d.wait(3000L);
                } catch (java.lang.InterruptedException e) {
                    com.heytap.openid.o_a.o_b.a("OpenIDHelper", e);
                }
            }
        }
    }
}
