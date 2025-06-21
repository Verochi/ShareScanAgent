package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class l {
    com.anythink.china.a.a.m a;
    android.content.ServiceConnection b = new com.anythink.china.a.a.l.AnonymousClass1();
    private android.content.Context c;

    /* renamed from: com.anythink.china.a.a.l$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.anythink.china.a.a.l.this.a = com.anythink.china.a.a.m.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.anythink.china.a.a.l.this.a = null;
        }
    }

    public l(android.content.Context context) {
        this.c = context;
    }

    private java.lang.String a(java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        java.lang.String packageName = this.c.getPackageName();
        java.lang.String str2 = null;
        try {
            signatureArr = this.c.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (java.lang.Exception e) {
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
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return ((com.anythink.china.a.a.m.a.C0153a) this.a).a(packageName, str2, str);
    }

    public final java.lang.String a(com.anythink.china.a.a aVar) {
        java.lang.String str = "";
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return "";
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (this.c.bindService(intent, this.b, 1)) {
            try {
                android.os.SystemClock.sleep(3000L);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (this.a != null) {
                str = a("OUID");
                aVar.a(str, false);
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            aVar.a();
        }
        return str;
    }
}
