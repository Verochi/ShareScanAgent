package org.repackage.a.a.a.a;

/* loaded from: classes26.dex */
public class c {
    public org.repackage.a.a.a.a a = null;
    public java.lang.String b = null;
    public java.lang.String c = null;
    public final java.lang.Object d = new java.lang.Object();
    public android.content.ServiceConnection e = new org.repackage.a.a.a.a.b(this);

    public static class a {
        public static final org.repackage.a.a.a.a.c a = new org.repackage.a.a.a.a.c(null);
    }

    public /* synthetic */ c(org.repackage.a.a.a.a.b bVar) {
    }

    public synchronized java.lang.String a(android.content.Context context, java.lang.String str) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Cannot run on MainThread");
        }
        if (this.a != null) {
            try {
                return b(context, str);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return "";
            }
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (context.bindService(intent, this.e, 1)) {
            synchronized (this.d) {
                try {
                    this.d.wait(3000L);
                } catch (java.lang.InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.a == null) {
            return "";
        }
        try {
            return b(context, str);
        } catch (android.os.RemoteException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public boolean a(android.content.Context context) {
        long longVersionCode;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return packageInfo != null && packageInfo.versionCode >= 1;
            }
            if (packageInfo == null) {
                return false;
            }
            longVersionCode = packageInfo.getLongVersionCode();
            return longVersionCode >= 1;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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
        java.lang.String a2 = ((org.repackage.a.a.a.a.AbstractBinderC0543a.C0544a) this.a).a(this.b, this.c, str);
        return android.text.TextUtils.isEmpty(a2) ? "" : a2;
    }
}
