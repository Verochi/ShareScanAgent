package com.anythink.china.a;

/* loaded from: classes12.dex */
public final class b {

    /* renamed from: com.anythink.china.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.china.a.a a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;

        /* renamed from: com.anythink.china.a.b$1$1, reason: invalid class name and collision with other inner class name */
        public class C01541 implements com.anythink.china.a.a {
            public C01541() {
            }

            @Override // com.anythink.china.a.a
            public final void a() {
                com.anythink.china.a.b.AnonymousClass1 anonymousClass1 = com.anythink.china.a.b.AnonymousClass1.this;
                com.anythink.china.a.b.c(anonymousClass1.b, anonymousClass1.a);
            }

            @Override // com.anythink.china.a.a
            public final void a(java.lang.String str, boolean z) {
                com.anythink.china.a.a aVar = com.anythink.china.a.b.AnonymousClass1.this.a;
                if (aVar != null) {
                    aVar.a(str, z);
                }
            }
        }

        public AnonymousClass1(com.anythink.china.a.a aVar, android.content.Context context, java.lang.String str) {
            this.a = aVar;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            char c;
            com.anythink.china.a.b.AnonymousClass1.C01541 c01541 = new com.anythink.china.a.b.AnonymousClass1.C01541();
            try {
                java.lang.String str = this.c;
                switch (str.hashCode()) {
                    case -2053026509:
                        if (str.equals("LENOVO")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1712043046:
                        if (str.equals("SAMSUNG")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -602397472:
                        if (str.equals("ONEPLUS")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 89163:
                        if (str.equals("ZTE")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2018896:
                        if (str.equals("ASUS")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2432928:
                        if (str.equals(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2555124:
                        if (str.equals("SSUI")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 73239724:
                        if (str.equals("MEIZU")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case 630905871:
                        if (str.equals("MOTOLORA")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 976565563:
                        if (str.equals("FERRMEOS")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1670208650:
                        if (str.equals("COOLPAD")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1670211654:
                        if (str.equals("COOLSEA")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2081893636:
                        if (str.equals("FREEME")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2141820391:
                        if (str.equals("HUAWEI")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        new com.anythink.china.a.a.b(this.b).a(c01541);
                        break;
                    case 1:
                    case 2:
                        new com.anythink.china.a.a.l(this.b).a(c01541);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        com.anythink.china.a.b.c(this.b, this.a);
                        break;
                    case 6:
                        new com.anythink.china.a.a.h(this.b).a(c01541);
                        break;
                    case 7:
                        new com.anythink.china.a.a.o(this.b).a(c01541);
                        break;
                    case '\b':
                    case '\t':
                        new com.anythink.china.a.a.r(this.b).a(c01541);
                        break;
                    case '\n':
                        new com.anythink.china.a.a.j(this.b).a(c01541);
                        break;
                    case 11:
                        new com.anythink.china.a.a.f(this.b).a(c01541);
                        break;
                    case '\f':
                        new com.anythink.china.a.a.c(this.b).a(c01541);
                        break;
                    case '\r':
                        new com.anythink.china.a.a.d(this.b).a(c01541);
                        break;
                    default:
                        com.anythink.china.a.b.c(this.b, this.a);
                        break;
                }
            } catch (java.lang.Throwable th) {
                com.anythink.china.a.a aVar = this.a;
                if (aVar != null) {
                    th.getMessage();
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: com.anythink.china.a.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.anythink.china.a.a b;

        /* renamed from: com.anythink.china.a.b$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.china.api.OaidSDKCallbackListener {
            public AnonymousClass1() {
            }

            @Override // com.anythink.china.api.OaidSDKCallbackListener
            public final void OnSupport(boolean z, com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
                com.anythink.china.a.b.a(idSupplier, com.anythink.china.a.b.AnonymousClass2.this.b);
            }

            @Override // com.anythink.china.api.OaidSDKCallbackListener
            public final void onSupport(com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
                com.anythink.china.a.b.a(idSupplier, com.anythink.china.a.b.AnonymousClass2.this.b);
            }
        }

        public AnonymousClass2(android.content.Context context, com.anythink.china.a.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.china.api.ATChinaSDKHandler.handleInitOaidSDK(this.a.getApplicationContext(), new com.anythink.china.a.b.AnonymousClass2.AnonymousClass1());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @android.annotation.SuppressLint({"PrivateApi"})
    public static final class a {
        private static java.lang.Object e;
        private static java.lang.Class<?> f;
        private static java.lang.reflect.Method g;
        private static java.lang.reflect.Method h;
        private static java.lang.reflect.Method i;
        private static java.lang.reflect.Method j;
        final java.lang.String a;
        final java.lang.String b;
        final java.lang.String c;
        final java.lang.String d;

        static {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
                f = cls;
                e = cls.newInstance();
                g = f.getMethod("getUDID", android.content.Context.class);
                h = f.getMethod("getOAID", android.content.Context.class);
                i = f.getMethod("getVAID", android.content.Context.class);
                j = f.getMethod("getAAID", android.content.Context.class);
            } catch (java.lang.Throwable unused) {
            }
        }

        public a(android.content.Context context) {
            this.a = a(context, g);
            this.b = a(context, h);
            this.c = a(context, i);
            this.d = a(context, j);
        }

        private static java.lang.String a(android.content.Context context, java.lang.reflect.Method method) {
            java.lang.Object obj = e;
            if (obj == null || method == null) {
                return null;
            }
            try {
                java.lang.Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (java.lang.String) invoke;
                }
                return null;
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        private static boolean a() {
            return (f == null || e == null) ? false : true;
        }
    }

    private static java.lang.String a(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void a(android.content.Context context, com.anythink.china.a.a aVar) {
        java.lang.String str;
        try {
            str = b(context);
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            aVar.a(str, false);
            return;
        }
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        java.lang.String a2 = a("ro.build.freeme.label");
        if (!android.text.TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS")) {
            str2 = "FERRMEOS";
        } else {
            java.lang.String a3 = a("ro.ssui.product");
            if ((android.text.TextUtils.isEmpty(a3) || a3.equalsIgnoreCase("unknown")) ? false : true) {
                str2 = "SSUI";
            } else {
                java.lang.String a4 = a("ro.build.freeme.label");
                if ((android.text.TextUtils.isEmpty(a4) || a4.equalsIgnoreCase("unknown")) ? false : true) {
                    str2 = "FREEME";
                } else if (a(context)) {
                    str2 = "COOLPAD";
                } else if (a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE")) {
                    str2 = "COOLSEA";
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            java.lang.String upperCase = str2.toUpperCase();
            if (java.util.Arrays.asList("ASUS", "HUAWEI", com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT, "ONEPLUS", "ZTE", "FERRMEOS", "SSUI", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO", "FREEME", "COOLPAD", "COOLSEA").contains(upperCase)) {
                com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.a.b.AnonymousClass1(aVar, context, upperCase), 2, true);
            } else if ("VIVO".equals(upperCase)) {
                str = new com.anythink.china.a.a.p(context).a();
            } else if ("NUBIA".equals(upperCase)) {
                str = new com.anythink.china.a.a.k(context).a();
            } else {
                c(context, aVar);
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        aVar.a(str, false);
    }

    private static void a(android.content.Context context, java.lang.String str, com.anythink.china.a.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.a.b.AnonymousClass1(aVar, context, str), 2, true);
    }

    public static /* synthetic */ void a(com.bun.miitmdid.interfaces.IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        java.lang.String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (android.text.TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static boolean a() {
        java.lang.String a2 = a("ro.build.freeme.label");
        return !android.text.TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    private static boolean a(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static java.lang.String b(android.content.Context context) {
        try {
            return new com.anythink.china.a.b.a(context).b;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static void b(com.bun.miitmdid.interfaces.IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        java.lang.String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (android.text.TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static boolean b() {
        java.lang.String a2 = a("ro.ssui.product");
        return (android.text.TextUtils.isEmpty(a2) || a2.equalsIgnoreCase("unknown")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, com.anythink.china.a.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.a.b.AnonymousClass2(context, aVar), 2, true);
    }

    private static boolean c() {
        java.lang.String a2 = a("ro.build.freeme.label");
        return (android.text.TextUtils.isEmpty(a2) || a2.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static boolean d() {
        return a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE");
    }
}
