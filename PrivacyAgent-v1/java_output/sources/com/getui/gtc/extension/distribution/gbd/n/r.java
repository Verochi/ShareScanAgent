package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public class r {
    public static java.util.concurrent.ThreadPoolExecutor a;
    private static final com.getui.gtc.extension.distribution.gbd.n.r.a b;
    private static volatile com.getui.gtc.extension.distribution.gbd.n.r c;
    private static android.content.Context d;
    private static boolean e;
    private static boolean f;
    private com.getui.gtc.extension.distribution.gbd.n.r.b g = null;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.r$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.r.c(this.a);
            com.getui.gtc.extension.distribution.gbd.n.r.b unused = com.getui.gtc.extension.distribution.gbd.n.r.this.g;
            boolean unused2 = com.getui.gtc.extension.distribution.gbd.n.r.f;
            com.getui.gtc.extension.distribution.gbd.n.r.e();
        }
    }

    public interface a {

        /* renamed from: com.getui.gtc.extension.distribution.gbd.n.r$a$a, reason: collision with other inner class name */
        public static class C0328a {
            private static com.getui.gtc.extension.distribution.gbd.n.r.a a(java.lang.String str) {
                str.hashCode();
                switch (str) {
                    case "HONOR":
                    case "HUA_WEI":
                    case "HUAWEI":
                        return new com.getui.gtc.extension.distribution.gbd.n.r.g();
                    default:
                        return null;
                }
            }
        }

        boolean a(android.content.Context context);

        java.lang.String b(android.content.Context context);

        boolean c(android.content.Context context);
    }

    public interface b {
        void a();
    }

    public static class c implements com.getui.gtc.extension.distribution.gbd.n.r.a {
        static java.lang.String a;
        private static boolean c;
        private static boolean d;
        private static final java.util.concurrent.CountDownLatch e = new java.util.concurrent.CountDownLatch(1);
        com.getui.gtc.extension.distribution.gbd.n.r.e b;
        private final java.lang.String f;
        private final java.lang.String g = null;
        private final java.lang.String h;
        private final java.lang.String i;

        public c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.f = str;
            this.h = str2;
            this.i = str3;
        }

        private static java.lang.String a() {
            return null;
        }

        private static java.lang.String b() {
            return null;
        }

        private static java.lang.String c() {
            return null;
        }

        private static int d() {
            return 1;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.a
        public boolean a(android.content.Context context) {
            long longVersionCode;
            if (d) {
                return c;
            }
            boolean z = false;
            if (context != null && !android.text.TextUtils.isEmpty(this.f)) {
                try {
                    android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f, 0);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        if (packageInfo != null) {
                            longVersionCode = packageInfo.getLongVersionCode();
                            if (longVersionCode >= 1) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (packageInfo != null && packageInfo.versionCode > 0) {
                        z = true;
                    }
                } catch (java.lang.Throwable unused) {
                    return false;
                }
            }
            c = z;
            d = true;
            return c;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.a
        public java.lang.String b(android.content.Context context) {
            com.getui.gtc.extension.distribution.gbd.n.r.e eVar;
            com.getui.gtc.extension.distribution.gbd.n.r.d dVar;
            com.getui.gtc.extension.distribution.gbd.n.r.e eVar2;
            if (!android.text.TextUtils.isEmpty(a) || (eVar = this.b) == null || (dVar = eVar.a) == null) {
                return a;
            }
            try {
                java.lang.String a2 = dVar.a();
                a = a2;
                if (!android.text.TextUtils.isEmpty(a2) && (eVar2 = this.b) != null) {
                    context.unbindService(eVar2);
                }
            } catch (java.lang.Throwable unused) {
            }
            return a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.a
        public boolean c(android.content.Context context) {
            if (context == null || android.text.TextUtils.isEmpty(this.f)) {
                return false;
            }
            if (this.b == null) {
                this.b = new com.getui.gtc.extension.distribution.gbd.n.r.e(this.i, e);
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
    }

    public static class d implements android.os.IInterface {
        private android.os.IBinder a;
        private java.lang.String b;

        private d(android.os.IBinder iBinder, java.lang.String str) {
            this.a = iBinder;
            this.b = str;
        }

        public static com.getui.gtc.extension.distribution.gbd.n.r.d a(android.os.IBinder iBinder, java.lang.String str) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
            return queryLocalInterface instanceof com.getui.gtc.extension.distribution.gbd.n.r.d ? (com.getui.gtc.extension.distribution.gbd.n.r.d) queryLocalInterface : new com.getui.gtc.extension.distribution.gbd.n.r.d(iBinder, str);
        }

        public final java.lang.String a() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(this.b);
                    if (!android.text.TextUtils.isEmpty(null)) {
                        obtain.writeString(null);
                    }
                    if (!android.text.TextUtils.isEmpty(null)) {
                        obtain.writeString(null);
                    }
                    if (!android.text.TextUtils.isEmpty(null)) {
                        obtain.writeString(null);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
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
        com.getui.gtc.extension.distribution.gbd.n.r.d a;
        android.os.IBinder b;
        private java.lang.String c;
        private java.util.concurrent.CountDownLatch d;

        public e(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.c = str;
            this.d = countDownLatch;
        }

        private com.getui.gtc.extension.distribution.gbd.n.r.d a() {
            return this.a;
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
                this.d.await(3L, java.util.concurrent.TimeUnit.SECONDS);
                this.a = com.getui.gtc.extension.distribution.gbd.n.r.d.a(this.b, this.c);
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

    public static class f extends com.getui.gtc.extension.distribution.gbd.n.r.c {
        private static final java.lang.String c = "com.huawei.hwid";
        private static final java.lang.String d = "com.uodis.opendevice.OPENIDS_SERVICE";
        private static final java.lang.String e = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

        public f() {
            super("com.huawei.hwid", d, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final /* bridge */ /* synthetic */ java.lang.String b(android.content.Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    public static class g extends com.getui.gtc.extension.distribution.gbd.n.r.c {
        private static final java.lang.String c = "com.hihonor.id";
        private static final java.lang.String d = "com.hihonor.id.HnOaIdService";
        private static final java.lang.String e = "com.hihonor.cloudservice.oaid.IOAIDService";
        private final java.util.concurrent.CountDownLatch f;

        /* renamed from: com.getui.gtc.extension.distribution.gbd.n.r$g$1, reason: invalid class name */
        public class AnonymousClass1 extends com.getui.gtc.extension.distribution.gbd.n.r.g.a {
            public AnonymousClass1() {
            }

            @Override // com.getui.gtc.extension.distribution.gbd.n.r.g.a
            public final void a(int i, android.os.Bundle bundle) {
                if (i == 0 && bundle != null) {
                    com.getui.gtc.extension.distribution.gbd.n.r.c.a = bundle.getString("oa_id_flag");
                }
                com.getui.gtc.extension.distribution.gbd.n.r.g.this.f.countDown();
            }
        }

        public static abstract class a extends android.os.Binder implements android.os.IInterface {
            private static final java.lang.String a = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

            public a() {
                attachInterface(this, a);
            }

            public abstract void a(int i, android.os.Bundle bundle);

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(a);
                    return true;
                }
                parcel.enforceInterface(a);
                a(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
        }

        public g() {
            super(c, d, e);
            this.f = new java.util.concurrent.CountDownLatch(1);
        }

        private static void a(com.getui.gtc.extension.distribution.gbd.n.r.g.a aVar, android.os.IBinder iBinder) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(e);
                obtain.writeStrongBinder(aVar.asBinder());
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public static boolean a() {
            android.content.pm.PackageInfo a2;
            long longVersionCode;
            try {
                a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(c, 0);
            } catch (java.lang.Throwable unused) {
            }
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return a2.versionCode > 0;
            }
            longVersionCode = a2.getLongVersionCode();
            return longVersionCode >= 1;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final /* bridge */ /* synthetic */ boolean a(android.content.Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final java.lang.String b(android.content.Context context) {
            com.getui.gtc.extension.distribution.gbd.n.r.e eVar;
            com.getui.gtc.extension.distribution.gbd.n.r.e eVar2;
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.n.r.c.a) || (eVar = this.b) == null || eVar.a == null) {
                return com.getui.gtc.extension.distribution.gbd.n.r.c.a;
            }
            try {
                android.os.IBinder iBinder = eVar.b;
                com.getui.gtc.extension.distribution.gbd.n.r.g.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.n.r.g.AnonymousClass1();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(e);
                    obtain.writeStrongBinder(anonymousClass1.asBinder());
                    iBinder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                    this.f.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                    if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.n.r.c.a) && (eVar2 = this.b) != null) {
                        context.unbindService(eVar2);
                    }
                } catch (java.lang.Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            } catch (java.lang.Throwable unused) {
            }
            return com.getui.gtc.extension.distribution.gbd.n.r.c.a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.r.c, com.getui.gtc.extension.distribution.gbd.n.r.a
        public final /* bridge */ /* synthetic */ boolean c(android.content.Context context) {
            return super.c(context);
        }
    }

    static {
        com.getui.gtc.extension.distribution.gbd.n.r.g gVar;
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        upperCase.hashCode();
        switch (upperCase) {
            case "HONOR":
            case "HUA_WEI":
            case "HUAWEI":
                gVar = new com.getui.gtc.extension.distribution.gbd.n.r.g();
                break;
            default:
                gVar = null;
                break;
        }
        b = gVar;
    }

    private void a(android.content.Context context, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor, com.getui.gtc.extension.distribution.gbd.n.r.b bVar) {
        try {
            threadPoolExecutor.getMaximumPoolSize();
            a = threadPoolExecutor;
            this.g = bVar;
            threadPoolExecutor.execute(new com.getui.gtc.extension.distribution.gbd.n.r.AnonymousClass1(context));
        } catch (java.lang.Throwable unused) {
        }
    }

    private static java.lang.String b(android.content.Context context) {
        c(context);
        if (e) {
            return e();
        }
        return null;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.r c() {
        if (c == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.n.r.class) {
                if (c == null) {
                    c = new com.getui.gtc.extension.distribution.gbd.n.r();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.n.r.a aVar = b;
        if (aVar == null || context == null) {
            return;
        }
        d = context.getApplicationContext();
        boolean d2 = d();
        f = d2;
        if (d2) {
            e = aVar.c(d);
        }
    }

    private static boolean d() {
        com.getui.gtc.extension.distribution.gbd.n.r.a aVar;
        try {
            android.content.Context context = d;
            if (context == null || (aVar = b) == null) {
                return false;
            }
            return aVar.a(context);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String e() {
        com.getui.gtc.extension.distribution.gbd.n.r.a aVar;
        try {
            android.content.Context context = d;
            if (context != null && (aVar = b) != null && e) {
                return aVar.b(context);
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
