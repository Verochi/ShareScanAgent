package com.getui.gtc.dim.c;

/* loaded from: classes22.dex */
public class d {
    static final com.getui.gtc.dim.c.d.a a;
    static android.content.Context b;
    static boolean c;
    public static final java.lang.String d;
    private static volatile com.getui.gtc.dim.c.d e;

    public interface a {
        boolean a(android.content.Context context);

        java.lang.String b(android.content.Context context);

        boolean c(android.content.Context context);
    }

    public static class b implements com.getui.gtc.dim.c.d.a {
        java.lang.String a;
        com.getui.gtc.dim.c.d.e b;
        private boolean c = false;
        private boolean d = false;
        private final java.util.concurrent.CountDownLatch e = new java.util.concurrent.CountDownLatch(1);
        private final java.lang.String f;
        private final java.lang.String g;
        private final java.lang.String h;
        private final java.lang.String i;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = str4;
        }

        public java.lang.String a() {
            return null;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(android.content.Context context) {
            long longVersionCode;
            if (this.d) {
                return this.c;
            }
            if (context == null || android.text.TextUtils.isEmpty(this.f)) {
                this.c = false;
            } else {
                try {
                    android.content.pm.PackageInfo a = com.getui.gtc.dim.e.d.a(this.f, 0);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = a.getLongVersionCode();
                        return longVersionCode >= 1;
                    }
                    this.c = a.versionCode > 0;
                } catch (java.lang.Throwable unused) {
                    return false;
                }
            }
            this.d = true;
            return this.c;
        }

        public int b() {
            return 1;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public java.lang.String b(android.content.Context context) {
            com.getui.gtc.dim.c.d.e eVar;
            com.getui.gtc.dim.c.d.C0301d c0301d;
            com.getui.gtc.dim.c.d.e eVar2;
            if (!android.text.TextUtils.isEmpty(this.a) || (eVar = this.b) == null || (c0301d = eVar.a) == null) {
                return this.a;
            }
            try {
                java.lang.String a = c0301d.a(d(context), e(context), a(), b());
                this.a = a;
                if (!android.text.TextUtils.isEmpty(a) && (eVar2 = this.b) != null) {
                    context.unbindService(eVar2);
                }
            } catch (java.lang.Throwable unused) {
            }
            return this.a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean c(android.content.Context context) {
            if (context == null || android.text.TextUtils.isEmpty(this.f)) {
                return false;
            }
            if (this.b == null) {
                this.b = new com.getui.gtc.dim.c.d.e(this.i, this.e);
            }
            android.content.Intent intent = new android.content.Intent();
            if (android.text.TextUtils.isEmpty(this.g)) {
                intent.setPackage(this.f);
            } else {
                intent.setComponent(new android.content.ComponentName(this.f, this.g));
            }
            if (!android.text.TextUtils.isEmpty(this.h)) {
                intent.setAction(this.h);
            }
            return this.b.a(context, intent);
        }

        public java.lang.String d(android.content.Context context) {
            return null;
        }

        public java.lang.String e(android.content.Context context) {
            return null;
        }
    }

    public static class c implements com.getui.gtc.dim.c.d.a {
        protected static boolean b;
        private static java.lang.String d;
        java.lang.String[] a;
        protected boolean c = false;
        private java.lang.String e;
        private java.lang.String f;

        public c(java.lang.String str, java.lang.String str2) {
            this.e = str;
            this.f = str2;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(android.content.Context context) {
            if (this.c) {
                return b;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                b = (packageManager == null || packageManager.resolveContentProvider(this.e, 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                b = false;
            }
            this.c = true;
            return b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0045, code lost:
        
            if (r8 != null) goto L13;
         */
        @Override // com.getui.gtc.dim.c.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String b(android.content.Context context) {
            android.database.Cursor cursor;
            if (android.text.TextUtils.isEmpty(d)) {
                try {
                    cursor = context.getContentResolver().query(android.net.Uri.parse("content://" + this.e + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.f), null, null, this.a, null);
                    if (cursor != null) {
                        try {
                            cursor.moveToFirst();
                            d = cursor.getString(cursor.getColumnIndex("value"));
                        } catch (java.lang.Throwable unused) {
                            try {
                                d = null;
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
            return d;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(android.content.Context context) {
            return true;
        }
    }

    /* renamed from: com.getui.gtc.dim.c.d$d, reason: collision with other inner class name */
    public static class C0301d implements android.os.IInterface {
        private android.os.IBinder a;
        private java.lang.String b;

        private C0301d(android.os.IBinder iBinder, java.lang.String str) {
            this.a = iBinder;
            this.b = str;
        }

        public static com.getui.gtc.dim.c.d.C0301d a(android.os.IBinder iBinder, java.lang.String str) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
            return queryLocalInterface instanceof com.getui.gtc.dim.c.d.C0301d ? (com.getui.gtc.dim.c.d.C0301d) queryLocalInterface : new com.getui.gtc.dim.c.d.C0301d(iBinder, str);
        }

        public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
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
        public final android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static class e implements android.content.ServiceConnection {
        com.getui.gtc.dim.c.d.C0301d a;
        android.os.IBinder b;
        private java.lang.String c;
        private java.util.concurrent.CountDownLatch d;

        public e(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.c = str;
            this.d = countDownLatch;
        }

        public final boolean a(android.content.Context context, android.content.Intent intent) {
            if (context == null) {
                return false;
            }
            if (this.a != null) {
                return true;
            }
            try {
                boolean bindService = context.bindService(intent, this, 1);
                this.d.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                this.a = com.getui.gtc.dim.c.d.C0301d.a(this.b, this.c);
                return bindService;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b = iBinder;
                this.d.countDown();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            this.a = null;
            this.b = null;
        }
    }

    public static class f extends com.getui.gtc.dim.c.d.b {
        public f() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        private static java.lang.String a(java.lang.String str) {
            return new java.lang.String(android.util.Base64.decode(str, 0));
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class g extends com.getui.gtc.dim.c.d.b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class h extends com.getui.gtc.dim.c.d.b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", com.alipay.sdk.m.c.b.a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class i extends com.getui.gtc.dim.c.d.b {
        final java.util.concurrent.CountDownLatch c;

        /* renamed from: com.getui.gtc.dim.c.d$i$1, reason: invalid class name */
        public class AnonymousClass1 extends com.getui.gtc.dim.c.d.i.a {
            public AnonymousClass1() {
            }

            @Override // com.getui.gtc.dim.c.d.i.a
            public final void a(int i, android.os.Bundle bundle) {
                if (i == 0 && bundle != null) {
                    com.getui.gtc.dim.c.d.i.this.a = bundle.getString("oa_id_flag");
                }
                com.getui.gtc.dim.c.d.i.this.c.countDown();
            }
        }

        public static abstract class a extends android.os.Binder implements android.os.IInterface {
            public a() {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }

            public abstract void a(int i, android.os.Bundle bundle);

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
        }

        public i() {
            super("com.hihonor.id", null, "com.hihonor.id.HnOaIdService", "com.hihonor.cloudservice.oaid.IOAIDService");
            this.c = new java.util.concurrent.CountDownLatch(1);
        }

        public static boolean c() {
            android.content.pm.PackageInfo a2;
            long longVersionCode;
            try {
                a2 = com.getui.gtc.dim.e.d.a("com.hihonor.id", 0);
            } catch (java.lang.Throwable unused) {
            }
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return a2.versionCode > 0;
            }
            longVersionCode = a2.getLongVersionCode();
            return longVersionCode >= 1;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final java.lang.String b(android.content.Context context) {
            com.getui.gtc.dim.c.d.e eVar;
            com.getui.gtc.dim.c.d.e eVar2;
            if (!android.text.TextUtils.isEmpty(this.a) || (eVar = this.b) == null || eVar.a == null) {
                return this.a;
            }
            try {
                android.os.IBinder iBinder = eVar.b;
                com.getui.gtc.dim.c.d.i.AnonymousClass1 anonymousClass1 = new com.getui.gtc.dim.c.d.i.AnonymousClass1();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(anonymousClass1.asBinder());
                    iBinder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                    this.c.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                    if (!android.text.TextUtils.isEmpty(this.a) && (eVar2 = this.b) != null) {
                        context.unbindService(eVar2);
                    }
                } catch (java.lang.Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            } catch (java.lang.Throwable unused) {
            }
            return this.a;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class j extends com.getui.gtc.dim.c.d.c {
        public j() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final boolean a(android.content.Context context) {
            if (super.a(context)) {
                com.getui.gtc.dim.c.d.c.b = true;
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
                        com.getui.gtc.dim.c.d.c.b = "0".equals(string);
                    } else {
                        com.getui.gtc.dim.c.d.c.b = false;
                    }
                } catch (java.lang.Throwable unused) {
                    com.getui.gtc.dim.c.d.c.b = false;
                    return false;
                }
            }
            this.c = true;
            return com.getui.gtc.dim.c.d.c.b;
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final java.lang.String b(android.content.Context context) {
            this.a = new java.lang.String[]{"oaid"};
            return super.b(context);
        }
    }

    public static class k implements com.getui.gtc.dim.c.d.a {
        private boolean a;
        private boolean b;
        private java.lang.String c;

        private k() {
            this.a = false;
            this.b = false;
            this.c = null;
        }

        public /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean a(android.content.Context context) {
            if (this.b) {
                return this.a;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                this.a = (packageManager == null || packageManager.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                this.a = false;
            }
            this.b = true;
            return this.a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final java.lang.String b(android.content.Context context) {
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

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(android.content.Context context) {
            return true;
        }
    }

    public static class l extends com.getui.gtc.dim.c.d.b {
        private java.lang.String c;
        private java.lang.String d;

        public l() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final java.lang.String a() {
            return "OUID";
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final java.lang.String d(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.d)) {
                this.d = context.getPackageName();
            }
            return this.d;
        }

        @Override // com.getui.gtc.dim.c.d.b
        @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
        public final java.lang.String e(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.c)) {
                try {
                    java.lang.String d = d(context);
                    this.d = d;
                    android.content.pm.Signature[] signatureArr = com.getui.gtc.dim.e.d.a(d, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = java.security.MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : digest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.c = sb.toString();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            return this.c;
        }
    }

    public static class m extends com.getui.gtc.dim.c.d.b {
        public m() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class n extends com.getui.gtc.dim.c.d.c {
        public n() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class o implements com.getui.gtc.dim.c.d.a {
        private static java.lang.String b;
        private java.lang.Class<?> a = null;

        @Override // com.getui.gtc.dim.c.d.a
        @android.annotation.SuppressLint({"PrivateApi"})
        public final boolean a(android.content.Context context) {
            try {
                this.a = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final java.lang.String b(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(b)) {
                try {
                    b = java.lang.String.valueOf(this.a.getMethod("getOAID", android.content.Context.class).invoke(this.a.newInstance(), context));
                } catch (java.lang.Throwable unused) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(android.content.Context context) {
            return true;
        }
    }

    public static class p extends com.getui.gtc.dim.c.d.b {
        public p() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    static {
        com.getui.gtc.dim.c.d.a pVar;
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        d = upperCase;
        upperCase.hashCode();
        switch (upperCase) {
            case "LENOVO":
            case "ZUI":
            case "ZUK":
            case "MOTOLORA":
                pVar = new com.getui.gtc.dim.c.d.p();
                break;
            case "REALME":
            case "ONEPLUS":
            case "OPPO":
                pVar = new com.getui.gtc.dim.c.d.l();
                break;
            case "SAMSUNG":
                pVar = new com.getui.gtc.dim.c.d.m();
                break;
            case "XIAOMI":
            case "BLACKSHARK":
            case "REDMI":
                pVar = new com.getui.gtc.dim.c.d.o();
                break;
            case "ASUS":
                pVar = new com.getui.gtc.dim.c.d.f();
                break;
            case "IQOO":
            case "VIVO":
                pVar = new com.getui.gtc.dim.c.d.n();
                break;
            case "HONOR":
                pVar = new com.getui.gtc.dim.c.d.i();
                break;
            case "MEIZU":
                pVar = new com.getui.gtc.dim.c.d.j();
                break;
            case "NUBIA":
                pVar = new com.getui.gtc.dim.c.d.k((byte) 0);
                break;
            case "COOLPAD":
                pVar = new com.getui.gtc.dim.c.d.g();
                break;
            case "HUA_WEI":
            case "HUAWEI":
                pVar = new com.getui.gtc.dim.c.d.h();
                break;
            default:
                pVar = null;
                break;
        }
        a = pVar;
    }

    public static com.getui.gtc.dim.c.d a() {
        if (e == null) {
            synchronized (com.getui.gtc.dim.c.d.class) {
                if (e == null) {
                    e = new com.getui.gtc.dim.c.d();
                }
            }
        }
        return e;
    }

    public static boolean b() {
        com.getui.gtc.dim.c.d.a aVar;
        try {
            android.content.Context context = b;
            if (context == null || (aVar = a) == null) {
                return false;
            }
            return aVar.a(context);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String c() {
        com.getui.gtc.dim.c.d.a aVar;
        try {
            android.content.Context context = b;
            if (context != null && (aVar = a) != null && c) {
                return aVar.b(context);
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
