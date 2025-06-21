package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class a1 {
    public static final com.zx.a.I8b7.a1.a a;
    public static volatile com.zx.a.I8b7.a1 b;
    public static android.content.Context c;
    public static boolean d;

    public interface a {
        boolean a(android.content.Context context);

        java.lang.String b(android.content.Context context);

        boolean c(android.content.Context context);
    }

    public static class b implements com.zx.a.I8b7.a1.a {
        public static java.lang.String f;
        public static boolean g;
        public static boolean h;
        public static final java.util.concurrent.CountDownLatch i = new java.util.concurrent.CountDownLatch(1);
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.lang.String c;
        public final java.lang.String d;
        public com.zx.a.I8b7.a1.e e;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public int a() {
            return 1;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(android.content.Context context) {
            if (context == null || android.text.TextUtils.isEmpty(this.a)) {
                return false;
            }
            if (this.e == null) {
                this.e = new com.zx.a.I8b7.a1.e(this.d, i);
            }
            android.content.Intent intent = new android.content.Intent();
            if (android.text.TextUtils.isEmpty(this.b)) {
                intent.setPackage(this.a);
            } else {
                intent.setComponent(new android.content.ComponentName(this.a, this.b));
            }
            if (!android.text.TextUtils.isEmpty(this.c)) {
                intent.setAction(this.c);
            }
            return this.e.a(context, intent);
        }

        public java.lang.String b() {
            return null;
        }

        @Override // com.zx.a.I8b7.a1.a
        public java.lang.String b(android.content.Context context) {
            com.zx.a.I8b7.a1.e eVar;
            com.zx.a.I8b7.a1.d dVar;
            com.zx.a.I8b7.a1.e eVar2;
            if (!android.text.TextUtils.isEmpty(f) || (eVar = this.e) == null || (dVar = eVar.a) == null) {
                return f;
            }
            try {
                java.lang.String a = dVar.a(d(context), e(context), b(), a());
                f = a;
                if (!android.text.TextUtils.isEmpty(a) && (eVar2 = this.e) != null) {
                    context.unbindService(eVar2);
                }
            } catch (java.lang.Throwable unused) {
            }
            return f;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(android.content.Context context) {
            long longVersionCode;
            if (h) {
                return g;
            }
            boolean z = false;
            if (context != null && !android.text.TextUtils.isEmpty(this.a)) {
                try {
                    android.content.pm.PackageInfo a = com.zx.a.I8b7.i3.a(this.a, 0);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        if (a != null) {
                            longVersionCode = a.getLongVersionCode();
                            if (longVersionCode >= 1) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (a != null && a.versionCode > 0) {
                        z = true;
                    }
                } catch (java.lang.Throwable unused) {
                    return false;
                }
            }
            g = z;
            h = true;
            return g;
        }

        public java.lang.String d(android.content.Context context) {
            return null;
        }

        public java.lang.String e(android.content.Context context) {
            return null;
        }
    }

    public static class c implements com.zx.a.I8b7.a1.a {
        public static java.lang.String e;
        public static boolean f;
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String[] c;
        public boolean d = false;

        public c(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
        
            if (r8 != null) goto L13;
         */
        @Override // com.zx.a.I8b7.a1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String b(android.content.Context context) {
            android.database.Cursor cursor;
            if (android.text.TextUtils.isEmpty(e)) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("content://");
                a.append(this.a);
                a.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                a.append(this.b);
                try {
                    cursor = context.getContentResolver().query(android.net.Uri.parse(a.toString()), null, null, this.c, null);
                    if (cursor != null) {
                        try {
                            cursor.moveToFirst();
                            e = cursor.getString(cursor.getColumnIndex("value"));
                        } catch (java.lang.Throwable unused) {
                            try {
                                e = null;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                    cursor = null;
                }
            }
            return e;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(android.content.Context context) {
            if (this.d) {
                return f;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager c = com.zx.a.I8b7.w3.c(context);
                f = (c == null || c.resolveContentProvider(this.a, 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                f = false;
            }
            this.d = true;
            return f;
        }
    }

    public static class d implements android.os.IInterface {
        public android.os.IBinder a;
        public java.lang.String b;

        public d(android.os.IBinder iBinder, java.lang.String str) {
            this.a = iBinder;
            this.b = str;
        }

        public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(this.b);
                    if (!android.text.TextUtils.isEmpty(str)) {
                        obtain.writeString(str);
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        obtain.writeString(str2);
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        obtain.writeString(str3);
                    }
                    this.a.transact(i, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (java.lang.Exception unused) {
                    return "";
                }
            } catch (java.lang.Throwable unused2) {
                obtain.recycle();
                obtain2.recycle();
                return "";
            }
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static class e implements android.content.ServiceConnection {
        public com.zx.a.I8b7.a1.d a;
        public java.lang.String b;
        public java.util.concurrent.CountDownLatch c;
        public android.os.IBinder d;

        public e(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.b = str;
            this.c = countDownLatch;
        }

        public boolean a(android.content.Context context, android.content.Intent intent) {
            com.zx.a.I8b7.a1.d dVar;
            if (this.a != null) {
                return true;
            }
            try {
                boolean bindService = context.bindService(intent, this, 1);
                this.c.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                android.os.IBinder iBinder = this.d;
                java.lang.String str = this.b;
                if (iBinder == null) {
                    dVar = null;
                } else {
                    android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    dVar = queryLocalInterface instanceof com.zx.a.I8b7.a1.d ? (com.zx.a.I8b7.a1.d) queryLocalInterface : new com.zx.a.I8b7.a1.d(iBinder, str);
                }
                this.a = dVar;
                return bindService;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.d = iBinder;
                this.c.countDown();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            this.a = null;
            this.d = null;
        }
    }

    public static class f extends com.zx.a.I8b7.a1.b {
        public f() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        public static java.lang.String a(java.lang.String str) {
            return new java.lang.String(android.util.Base64.decode(str, 0));
        }

        @Override // com.zx.a.I8b7.a1.b
        public int a() {
            return 2;
        }
    }

    public static class g extends com.zx.a.I8b7.a1.b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.zx.a.I8b7.a1.b
        public int a() {
            return 2;
        }
    }

    public static class h extends com.zx.a.I8b7.a1.b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", com.alipay.sdk.m.c.b.a);
        }
    }

    public static class i extends com.zx.a.I8b7.a1.c {
        public i() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.zx.a.I8b7.a1.c, com.zx.a.I8b7.a1.a
        public java.lang.String b(android.content.Context context) {
            this.c = new java.lang.String[]{"oaid"};
            return super.b(context);
        }

        @Override // com.zx.a.I8b7.a1.c, com.zx.a.I8b7.a1.a
        public boolean c(android.content.Context context) {
            if (super.c(context)) {
                com.zx.a.I8b7.a1.c.f = true;
            } else {
                try {
                    android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"support"}, null);
                    if (query == null) {
                        return false;
                    }
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        java.lang.String string = query.getString(columnIndex);
                        if (android.text.TextUtils.isEmpty(string)) {
                            return false;
                        }
                        com.zx.a.I8b7.a1.c.f = "0".equals(string);
                    } else {
                        com.zx.a.I8b7.a1.c.f = false;
                    }
                } catch (java.lang.Throwable unused) {
                    com.zx.a.I8b7.a1.c.f = false;
                    return false;
                }
            }
            this.d = true;
            return com.zx.a.I8b7.a1.c.f;
        }
    }

    public static class j implements com.zx.a.I8b7.a1.a {
        public boolean a = false;
        public boolean b = false;
        public java.lang.String c = null;

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.a1.a
        public java.lang.String b(android.content.Context context) {
            android.os.Bundle bundle;
            try {
                if (android.text.TextUtils.isEmpty(this.c)) {
                    android.net.Uri parse = android.net.Uri.parse("content://cn.nubia.identity/identity");
                    int i = android.os.Build.VERSION.SDK_INT;
                    android.content.ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient != null) {
                        bundle = acquireContentProviderClient.call("getOAID", null, null);
                        try {
                            if (i >= 24) {
                                java.lang.Class.forName("android.content.ContentProviderClient").getMethod("close", new java.lang.Class[0]).invoke(acquireContentProviderClient, new java.lang.Object[0]);
                            } else {
                                acquireContentProviderClient.release();
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                    } else {
                        bundle = null;
                    }
                    if (bundle == null) {
                        return this.c;
                    }
                    if (bundle.getInt("code", -1) == 0) {
                        this.c = bundle.getString("id");
                    }
                }
            } catch (java.lang.Throwable unused2) {
                this.c = null;
            }
            return this.c;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(android.content.Context context) {
            if (this.b) {
                return this.a;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager c = com.zx.a.I8b7.w3.c(context);
                this.a = (c == null || c.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                this.a = false;
            }
            this.b = true;
            return this.a;
        }
    }

    public static class k extends com.zx.a.I8b7.a1.b {
        public java.lang.String j;
        public java.lang.String k;

        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.zx.a.I8b7.a1.b
        public java.lang.String b() {
            return "OUID";
        }

        @Override // com.zx.a.I8b7.a1.b
        public java.lang.String d(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.k)) {
                this.k = context.getPackageName();
            }
            return this.k;
        }

        @Override // com.zx.a.I8b7.a1.b
        @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
        public java.lang.String e(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.j)) {
                try {
                    if (android.text.TextUtils.isEmpty(this.k)) {
                        this.k = context.getPackageName();
                    }
                    java.lang.String str = this.k;
                    this.k = str;
                    android.content.pm.Signature[] signatureArr = com.zx.a.I8b7.i3.a(str, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = java.security.MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : digest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.j = sb.toString();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            return this.j;
        }
    }

    public static class l extends com.zx.a.I8b7.a1.b {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
        }
    }

    public static class m extends com.zx.a.I8b7.a1.c {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class n implements com.zx.a.I8b7.a1.a {
        public static java.lang.String b;
        public java.lang.Class<?> a = null;

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.a1.a
        public java.lang.String b(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(b)) {
                try {
                    b = java.lang.String.valueOf(this.a.getMethod("getOAID", android.content.Context.class).invoke(this.a.newInstance(), context));
                } catch (java.lang.Throwable unused) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.zx.a.I8b7.a1.a
        @android.annotation.SuppressLint({"PrivateApi"})
        public boolean c(android.content.Context context) {
            try {
                this.a = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    public static class o extends com.zx.a.I8b7.a1.b {
        public o() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
        }
    }

    static {
        com.zx.a.I8b7.a1.a oVar;
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        upperCase.getClass();
        switch (upperCase) {
            case "LENOVO":
            case "ZUI":
            case "ZUK":
            case "MOTOLORA":
                oVar = new com.zx.a.I8b7.a1.o();
                break;
            case "REALME":
            case "ONEPLUS":
            case "OPPO":
                oVar = new com.zx.a.I8b7.a1.k();
                break;
            case "SAMSUNG":
                oVar = new com.zx.a.I8b7.a1.l();
                break;
            case "XIAOMI":
            case "BLACKSHARK":
            case "REDMI":
                oVar = new com.zx.a.I8b7.a1.n();
                break;
            case "ASUS":
                oVar = new com.zx.a.I8b7.a1.f();
                break;
            case "IQOO":
            case "VIVO":
                oVar = new com.zx.a.I8b7.a1.m();
                break;
            case "HONOR":
            case "HUA_WEI":
            case "HUAWEI":
                oVar = new com.zx.a.I8b7.a1.h();
                break;
            case "MEIZU":
                oVar = new com.zx.a.I8b7.a1.i();
                break;
            case "NUBIA":
                oVar = new com.zx.a.I8b7.a1.j();
                break;
            case "COOLPAD":
                oVar = new com.zx.a.I8b7.a1.g();
                break;
            default:
                oVar = null;
                break;
        }
        a = oVar;
    }
}
