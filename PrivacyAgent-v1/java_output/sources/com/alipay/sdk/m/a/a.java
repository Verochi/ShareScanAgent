package com.alipay.sdk.m.a;

/* loaded from: classes.dex */
public interface a extends android.os.IInterface {

    /* renamed from: com.alipay.sdk.m.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0028a extends android.os.Binder implements com.alipay.sdk.m.a.a {

        /* renamed from: com.alipay.sdk.m.a.a$a$a, reason: collision with other inner class name */
        public static class C0029a implements com.alipay.sdk.m.a.a {
            public android.os.IBinder a;

            public C0029a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }
        }

        public static com.alipay.sdk.m.a.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.alipay.sdk.m.a.a)) ? new com.alipay.sdk.m.a.a.AbstractBinderC0028a.C0029a(iBinder) : (com.alipay.sdk.m.a.a) queryLocalInterface;
        }
    }

    public class b {
        public static boolean a;
        public static boolean b;
    }

    public class c {
        public com.alipay.sdk.m.a.a a = null;
        public java.lang.String b = null;
        public java.lang.String c = null;
        public final java.lang.Object d = new java.lang.Object();
        public android.content.ServiceConnection e = new com.alipay.sdk.m.a.a.c.ServiceConnectionC0030a();

        /* renamed from: com.alipay.sdk.m.a.a$c$a, reason: collision with other inner class name */
        public class ServiceConnectionC0030a implements android.content.ServiceConnection {
            public ServiceConnectionC0030a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
                com.alipay.sdk.m.a.a.c.this.a = com.alipay.sdk.m.a.a.AbstractBinderC0028a.a(iBinder);
                synchronized (com.alipay.sdk.m.a.a.c.this.d) {
                    com.alipay.sdk.m.a.a.c.this.d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(android.content.ComponentName componentName) {
                com.alipay.sdk.m.a.a.c.this.a = null;
            }
        }

        public static class b {
            public static final com.alipay.sdk.m.a.a.c a = new com.alipay.sdk.m.a.a.c(null);
        }

        public /* synthetic */ c(com.alipay.sdk.m.a.a.c.ServiceConnectionC0030a serviceConnectionC0030a) {
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
                            for (byte b2 : digest) {
                                sb.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (java.security.NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.c = str2;
            }
            java.lang.String a = ((com.alipay.sdk.m.a.a.AbstractBinderC0028a.C0029a) this.a).a(this.b, this.c, str);
            return android.text.TextUtils.isEmpty(a) ? "" : a;
        }
    }
}
