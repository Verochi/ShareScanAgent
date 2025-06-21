package com.anythink.core.common.e;

/* loaded from: classes12.dex */
public class c {
    private static final java.lang.String a = "DomainManager";
    private static final java.lang.String b = "anythink_sdk";
    private static final java.lang.String c = "cdn_request_time_key";
    private static final java.lang.String d = "cur_using_domain_key";
    private static final java.lang.String e = "ru";
    private static final java.lang.String f = "api.";
    private static final int g = 24;
    private static final java.lang.String h = "tpnapi-new.moji.com";
    private static final java.lang.String i = "tpnapi-new.moji.com";
    private static volatile com.anythink.core.common.e.c r;
    private volatile boolean l;
    private volatile boolean m;
    private volatile long n;
    private volatile java.lang.String q;
    private final java.lang.Object j = new java.lang.Object();
    private final java.util.List<java.lang.String> k = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private volatile java.lang.String o = "";
    private volatile java.lang.String p = "";

    /* renamed from: com.anythink.core.common.e.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.h.k {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass1(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.core.common.e.c.b(com.anythink.core.common.e.c.this);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.common.e.c cVar = com.anythink.core.common.e.c.this;
            cVar.a(cVar.k, "", this.b, this.c);
            com.anythink.core.common.e.c.b(com.anythink.core.common.e.c.this);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            com.anythink.core.common.e.c.a(com.anythink.core.common.e.c.this, this.a);
            if (obj != null) {
                java.lang.String str = com.anythink.core.common.e.c.f + obj.toString();
                com.anythink.core.common.e.c cVar = com.anythink.core.common.e.c.this;
                cVar.a(cVar.k, str, this.b, this.c);
            } else {
                com.anythink.core.common.e.c cVar2 = com.anythink.core.common.e.c.this;
                cVar2.a(cVar2.k, "", this.b, this.c);
            }
            com.anythink.core.common.e.c.b(com.anythink.core.common.e.c.this);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    private c() {
        java.lang.String[] strArr;
        this.q = "";
        if (com.anythink.core.api.ATSDK.isCnSDK() || (strArr = com.anythink.core.common.e.b.a) == null || strArr.length <= 0) {
            return;
        }
        java.util.List asList = java.util.Arrays.asList(strArr);
        java.lang.String country = java.util.Locale.getDefault().getCountry();
        if (asList.contains(country)) {
            this.q = country;
        }
    }

    public static com.anythink.core.common.e.c a() {
        if (r == null) {
            synchronized (com.anythink.core.common.e.c.class) {
                r = new com.anythink.core.common.e.c();
            }
        }
        return r;
    }

    public static /* synthetic */ void a(com.anythink.core.common.e.c cVar, android.content.Context context) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cVar.n = currentTimeMillis;
        com.anythink.core.common.o.r.a(context, "anythink_sdk", c, currentTimeMillis);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.n.c.c(this.p, str, str2, java.lang.String.valueOf(c(com.anythink.core.common.b.o.a().f())));
    }

    private void a(java.util.List<java.lang.String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.p = list.get(0);
        b(this.p);
    }

    private void a(java.util.List<java.lang.String> list, java.lang.String str, java.lang.String str2) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            c(list, str);
        }
        java.lang.String str3 = list.get(0);
        if (str3.equals(str)) {
            return;
        }
        b(str3);
        e();
        a(str3, str2);
        com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), "anythink_sdk", d, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.List<java.lang.String> list, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        boolean a2 = a(list, str2);
        d("handleSwitchDomain() >>> isCanSwitch = ".concat(java.lang.String.valueOf(a2)));
        if (a2) {
            if (android.text.TextUtils.isEmpty(str)) {
                a(list, str2, str3);
                return;
            }
            if (str.equals(str2)) {
                c(list, str2);
            } else {
                b(list, str);
            }
            a(list, str2, str3);
        }
    }

    private static boolean a(java.util.List<java.lang.String> list, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || list.size() <= 0) {
            return false;
        }
        java.lang.String str2 = list.get(0);
        d("isCanSwitchDomain() >>> firstDomain = " + str2 + " failedDomain = " + str);
        return str.equals(str2);
    }

    private void b(android.content.Context context) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.n = currentTimeMillis;
        com.anythink.core.common.o.r.a(context, "anythink_sdk", c, currentTimeMillis);
    }

    private void b(java.lang.String str) {
        this.o = str;
        d("setCurrentDomain() >>> currentDomain = ".concat(java.lang.String.valueOf(str)));
    }

    private static void b(java.util.List<java.lang.String> list, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || list == null) {
            return;
        }
        int indexOf = list.indexOf(str);
        if (indexOf > 0) {
            list.remove(str);
            list.add(0, str);
        } else if (indexOf < 0) {
            list.add(0, str);
        }
    }

    public static /* synthetic */ boolean b(com.anythink.core.common.e.c cVar) {
        cVar.m = false;
        return false;
    }

    private java.lang.Long c(android.content.Context context) {
        long j = this.n;
        if (j == 0) {
            j = com.anythink.core.common.o.r.a(context, "anythink_sdk", c, (java.lang.Long) 0L).longValue();
        }
        return java.lang.Long.valueOf(j);
    }

    private void c(java.lang.String str) {
        if (com.anythink.core.api.ATSDK.isCnSDK()) {
            return;
        }
        d("tryGetDomainFromCdn() >>> start isTrying = " + this.m + " url = " + str);
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        if (android.text.TextUtils.isEmpty(str) || this.m || !com.anythink.core.common.o.i.a(f2)) {
            return;
        }
        java.lang.String str2 = "";
        try {
            str2 = new java.net.URL(str).getHost();
        } catch (java.lang.Exception e2) {
            d("tryGetDomainFromCdn() >>> " + e2.getMessage());
        }
        synchronized (this.j) {
            if (this.m) {
                return;
            }
            this.m = true;
            this.n = c(f2).longValue();
            if (this.n > 0) {
                long currentTimeMillis = (java.lang.System.currentTimeMillis() - this.n) / 3600000;
                if (currentTimeMillis < 24) {
                    d("tryGetDomainFromCdn() >>> intervalTime = ".concat(java.lang.String.valueOf(currentTimeMillis)));
                    a(this.k, "", str2, str);
                    this.m = false;
                    return;
                }
            }
            new com.anythink.core.common.h.h().a(0, (com.anythink.core.common.h.k) new com.anythink.core.common.e.c.AnonymousClass1(f2, str2, str));
        }
    }

    private static void c(java.util.List<java.lang.String> list, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || list == null) {
            return;
        }
        int indexOf = list.indexOf(str);
        if (indexOf >= 0 && indexOf < list.size() - 1) {
            list.remove(str);
            list.add(str);
        } else if (indexOf < 0) {
            list.add(str);
        }
    }

    private static void d(java.lang.String str) {
        java.lang.Thread.currentThread().getId();
    }

    private static boolean d() {
        java.lang.String str;
        try {
            str = java.util.Locale.getDefault().getLanguage();
        } catch (java.lang.Exception unused) {
            str = "";
        }
        return str.equalsIgnoreCase("ru");
    }

    private static void e() {
        com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b();
    }

    private static void f() {
    }

    public final java.lang.String a(java.lang.String str) {
        if (com.anythink.core.api.ATSDK.isCnSDK()) {
            return str;
        }
        try {
            java.lang.String str2 = this.o;
            return android.text.TextUtils.isEmpty(str2) ? str : str.replace(new java.net.URL(str).getHost(), str2);
        } catch (java.lang.Exception e2) {
            d("replaceUrlDomain() >> exception:" + e2.getMessage());
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (android.text.TextUtils.equals(r6, "tpnapi-new.moji.com") == false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.content.Context context) {
        if (com.anythink.core.api.ATSDK.isCnSDK()) {
            return;
        }
        if (context instanceof android.app.Activity) {
            context = context.getApplicationContext();
        }
        if (this.l) {
            return;
        }
        this.l = true;
        java.util.List<java.lang.String> list = this.k;
        if (!d()) {
            list.add("tpnapi-new.moji.com");
        }
        list.add("tpnapi-new.moji.com");
        java.lang.String str = "";
        java.lang.String b2 = com.anythink.core.common.o.r.b(context, "anythink_sdk", d, "");
        if (b()) {
            list.clear();
            list.add(com.anythink.core.common.e.a.a);
            list.add("tpnapi-new.moji.com");
            if (!android.text.TextUtils.equals(b2, "tpnapi-new.moji.com")) {
            }
            d("initDomain() >>> curUseDomain = ".concat(java.lang.String.valueOf(str)));
            if (!android.text.TextUtils.isEmpty(str)) {
                a(list);
                return;
            } else {
                b(list, str);
                a(list);
                return;
            }
        }
        str = b2;
        d("initDomain() >>> curUseDomain = ".concat(java.lang.String.valueOf(str)));
        if (!android.text.TextUtils.isEmpty(str)) {
        }
    }

    public final boolean b() {
        if (android.text.TextUtils.isEmpty(this.q)) {
            return false;
        }
        return com.anythink.core.api.ATCountryCode.INDIA.equalsIgnoreCase(this.q);
    }

    public final java.lang.String c() {
        b();
        return "";
    }
}
