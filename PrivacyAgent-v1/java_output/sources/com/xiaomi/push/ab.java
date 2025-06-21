package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ab implements com.xiaomi.push.u {
    private static boolean e;
    android.content.Context a;
    volatile int b;
    volatile com.xiaomi.push.ab.a c = null;
    final java.lang.Object d = new java.lang.Object();
    private android.content.ServiceConnection f = new com.xiaomi.push.ab.b(this, (byte) 0);

    public class a {
        java.lang.String a;
        java.lang.String b;
        java.lang.String c;
        java.lang.String d;

        private a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public /* synthetic */ a(com.xiaomi.push.ab abVar, byte b) {
            this();
        }
    }

    public class b implements android.content.ServiceConnection {
        private b() {
        }

        public /* synthetic */ b(com.xiaomi.push.ab abVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (com.xiaomi.push.ab.this.c != null) {
                return;
            }
            new java.lang.Thread(new com.xiaomi.push.ac(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static class c {
        public static java.lang.String a(android.os.IBinder iBinder, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ab(android.content.Context context) {
        boolean z = false;
        this.b = 0;
        this.a = context;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.a.bindService(intent, this.f, 1);
        } catch (java.lang.Exception unused) {
        }
        this.b = z ? 1 : 2;
    }

    public static /* synthetic */ void a(com.xiaomi.push.ab abVar) {
        android.content.ServiceConnection serviceConnection = abVar.f;
        if (serviceConnection != null) {
            try {
                abVar.a.unbindService(serviceConnection);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = android.os.Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                e = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        return e;
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        if (this.b == 1 && android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            synchronized (this.d) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.a("oppo's getOAID wait...");
                    this.d.wait(3000L);
                } catch (java.lang.Exception unused) {
                }
            }
        }
        if (this.c == null) {
            return null;
        }
        return this.c.b;
    }

    public final java.lang.String c() {
        try {
            android.content.pm.Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
