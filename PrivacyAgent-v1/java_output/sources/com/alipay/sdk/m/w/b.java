package com.alipay.sdk.m.w;

/* loaded from: classes.dex */
public class b {

    public static class a implements java.util.concurrent.Callable<android.net.wifi.WifiInfo> {
        public final /* synthetic */ android.content.Context a;

        public a(android.content.Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public android.net.wifi.WifiInfo call() {
            return ((android.net.wifi.WifiManager) this.a.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        }
    }

    /* renamed from: com.alipay.sdk.m.w.b$b, reason: collision with other inner class name */
    public static class C0046b implements com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0045a
        public java.lang.Boolean a(java.lang.Object obj) {
            return java.lang.Boolean.valueOf((obj instanceof java.lang.String) || obj == null);
        }
    }

    public static class c implements java.util.concurrent.Callable<java.lang.String> {
        public final /* synthetic */ android.content.Context a;

        public c(android.content.Context context) {
            this.a = context;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.String call() {
            return com.alipay.sdk.m.b.c.a(this.a);
        }
    }

    public static class d implements com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0045a
        public java.lang.Boolean a(java.lang.Object obj) {
            return java.lang.Boolean.valueOf((obj instanceof android.net.NetworkInfo) || obj == null);
        }
    }

    public static class e implements java.util.concurrent.Callable<android.net.NetworkInfo> {
        public final /* synthetic */ android.content.Context a;

        public e(android.content.Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public android.net.NetworkInfo call() {
            return ((android.net.ConnectivityManager) this.a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    public static class f implements com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0045a
        public java.lang.Boolean a(java.lang.Object obj) {
            return java.lang.Boolean.valueOf((obj instanceof java.lang.String) || obj == null);
        }
    }

    public static class g implements java.util.concurrent.Callable<java.lang.String> {
        public final /* synthetic */ android.content.Context a;
        public final /* synthetic */ com.alipay.sdk.m.s.a b;

        public g(android.content.Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.String call() {
            try {
                return com.alipay.sdk.m.n0.a.c(this.a);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.b(this.b, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.u, th.getClass().getName());
                return "";
            }
        }
    }

    public static class h implements com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0045a
        public java.lang.Boolean a(java.lang.Object obj) {
            return java.lang.Boolean.valueOf((obj instanceof java.lang.String) || obj == null);
        }
    }

    public static class i implements java.util.concurrent.Callable<java.lang.String> {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ java.lang.String b;
        public final /* synthetic */ android.content.Context c;
        public final /* synthetic */ com.alipay.sdk.m.s.a d;

        public class a implements com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener {
            public final /* synthetic */ java.lang.String[] a;
            public final /* synthetic */ android.os.ConditionVariable b;

            public a(java.lang.String[] strArr, android.os.ConditionVariable conditionVariable) {
                this.a = strArr;
                this.b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }

        public i(java.lang.String str, java.lang.String str2, android.content.Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = aVar;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.String call() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("tid", this.a);
            hashMap.put(com.alipay.sdk.m.l.b.g, this.b);
            java.lang.String[] strArr = {""};
            try {
                com.alipay.apmobilesecuritysdk.face.APSecuritySdk aPSecuritySdk = com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getInstance(this.c);
                android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
                aPSecuritySdk.initToken(0, hashMap, new com.alipay.sdk.m.w.b.i.a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.r, th.getClass().getName());
            }
            if (android.text.TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.f81s, "missing token");
            }
            return strArr[0];
        }
    }

    public static class j implements com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0045a
        public java.lang.Boolean a(java.lang.Object obj) {
            return java.lang.Boolean.valueOf((obj instanceof android.net.wifi.WifiInfo) || obj == null);
        }
    }

    public static android.net.NetworkInfo a(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        android.content.Context a2 = com.alipay.sdk.m.w.a.a(context);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        return (android.net.NetworkInfo) com.alipay.sdk.m.w.a.a(2, 10L, timeUnit, new com.alipay.sdk.m.w.b.d(), new com.alipay.sdk.m.w.b.e(a2), false, 10L, timeUnit, aVar, false);
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Context a2 = com.alipay.sdk.m.w.a.a(context);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        return (java.lang.String) com.alipay.sdk.m.w.a.a(4, 10L, timeUnit, new com.alipay.sdk.m.w.b.h(), new com.alipay.sdk.m.w.b.i(str, str2, a2, aVar), true, 3L, timeUnit, aVar, true);
    }

    public static java.lang.String b(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        if (!com.alipay.sdk.m.m.a.D().x()) {
            return "";
        }
        return (java.lang.String) com.alipay.sdk.m.w.a.a(1, 1L, java.util.concurrent.TimeUnit.DAYS, new com.alipay.sdk.m.w.b.C0046b(), new com.alipay.sdk.m.w.b.c(com.alipay.sdk.m.w.a.a(context)), true, 200L, java.util.concurrent.TimeUnit.MILLISECONDS, aVar, true);
    }

    public static java.lang.String c(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        return (java.lang.String) com.alipay.sdk.m.w.a.a(3, 1L, java.util.concurrent.TimeUnit.DAYS, new com.alipay.sdk.m.w.b.f(), new com.alipay.sdk.m.w.b.g(com.alipay.sdk.m.w.a.a(context), aVar), true, 3L, java.util.concurrent.TimeUnit.SECONDS, aVar, false);
    }

    public static android.net.wifi.WifiInfo d(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        android.content.Context a2 = com.alipay.sdk.m.w.a.a(context);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        return (android.net.wifi.WifiInfo) com.alipay.sdk.m.w.a.a(5, 10L, timeUnit, new com.alipay.sdk.m.w.b.j(), new com.alipay.sdk.m.w.b.a(a2), false, 10L, timeUnit, aVar, false);
    }
}
