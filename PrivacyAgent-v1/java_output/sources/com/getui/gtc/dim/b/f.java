package com.getui.gtc.dim.b;

/* loaded from: classes22.dex */
abstract class f {
    static final java.util.List<java.lang.String> a = java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K);
    com.getui.gtc.dim.AppDataProvider e;
    java.lang.String f;
    private volatile int k;
    private volatile java.lang.String r;
    int c = 1;
    int d = 1;
    private int m = 3;
    private final int[] n = {-1, 33};

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f312s = true;
    final java.util.Map<java.lang.String, java.lang.Integer> b = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Integer> g = new java.util.HashMap();
    private final java.util.List<java.lang.String> i = new java.util.ArrayList();
    private final java.util.List<java.lang.String> j = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, java.lang.String> h = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Boolean> o = new java.util.HashMap(4);
    private final java.util.List<java.lang.String> p = new java.util.ArrayList();
    private final java.util.List<java.lang.String> q = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, java.lang.Boolean> l = new java.util.HashMap();

    /* renamed from: com.getui.gtc.dim.b.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.getui.gtc.dim.Caller.values().length];
            a = iArr;
            try {
                iArr[com.getui.gtc.dim.Caller.PUSH.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.getui.gtc.dim.Caller.IDO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.getui.gtc.dim.Caller.GY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.getui.gtc.dim.Caller.WUS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.getui.gtc.dim.Caller.ONEID.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private static boolean a(boolean z, java.lang.String str) {
        if (z && "*".equals(str)) {
            return true;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        for (java.lang.String str2 : str.split("#")) {
            if (str2.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split.length == 2 && i >= java.lang.Integer.parseInt(split[0]) && i <= java.lang.Integer.parseInt(split[1])) {
                    return true;
                }
            } else if (java.lang.String.valueOf(i).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static java.lang.String b(com.getui.gtc.dim.Caller caller) {
        if (caller == null) {
            return "";
        }
        int i = com.getui.gtc.dim.b.f.AnonymousClass1.a[caller.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "oneid" : "wus" : "gy" : "ido" : "gt";
    }

    public static boolean h(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "dim-2-1-21-1":
                case "dim-2-1-21-2":
                case "dim-2-1-21-3":
                case "dim-2-1-21-5":
                    return true;
            }
        }
        return false;
    }

    private static boolean i(java.lang.String str) {
        try {
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private java.lang.Boolean j(java.lang.String str) {
        try {
            if (this.l.containsKey(str)) {
                return this.l.get(str);
            }
            com.getui.gtc.dim.b.d unused = com.getui.gtc.dim.b.d.a.a;
            com.getui.gtc.dim.b.h a2 = com.getui.gtc.dim.b.d.a(str);
            java.lang.Boolean bool = a2 != null ? (java.lang.Boolean) a2.a : null;
            com.getui.gtc.dim.e.b.a("dim sys callable from db : " + str + " : " + bool);
            this.l.put(str, bool);
            return bool;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("callable", th);
            return null;
        }
    }

    public int a() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
        com.getui.gtc.dim.e.b.a("dim sys busi enable set: ".concat(java.lang.String.valueOf(i)));
    }

    public void a(com.getui.gtc.dim.AppDataProvider appDataProvider) {
        this.e = appDataProvider;
        com.getui.gtc.dim.e.b.a("dim sys app data provider set: ".concat(java.lang.String.valueOf(appDataProvider)));
    }

    public void a(com.getui.gtc.dim.Caller caller) {
        if (caller != null) {
            synchronized (this) {
                this.k |= caller.index;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc init caller set: ".concat(java.lang.String.valueOf(caller)));
    }

    public void a(java.lang.String str, int i) {
        if (str.equalsIgnoreCase(android.os.Build.BRAND)) {
            this.n[0] = i;
        } else if (str.equals("dim-2-2-0-1")) {
            this.n[1] = i;
        }
        com.getui.gtc.dim.e.b.a("dim sys pm policy set: " + str + " : " + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r6.j.contains(r8 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + b(r7)) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.getui.gtc.dim.Caller caller, java.lang.String str) {
        if (caller != null && caller != com.getui.gtc.dim.Caller.UNKNOWN && caller.containAt(this.k)) {
            try {
                if (!this.j.isEmpty()) {
                }
                if ((this.m & 1) == 0) {
                    com.getui.gtc.dim.e.b.a("dim sys ig ca");
                    return true;
                }
                com.getui.gtc.dim.b.a a2 = com.getui.gtc.dim.b.a.a(str);
                if (a2 != null) {
                    java.lang.Boolean j = j(a2.a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + caller.name());
                    com.getui.gtc.dim.e.b.a("dim sys get callable " + caller + " : " + str + " : " + j);
                    if (j != null && !j.booleanValue()) {
                        return false;
                    }
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
            }
        }
        return false;
    }

    public final boolean a(java.lang.String str) {
        try {
            return this.i.contains(str);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean a(java.lang.String str, com.getui.gtc.dim.Caller caller, boolean z) {
        this.l.put(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + caller.name(), java.lang.Boolean.valueOf(z));
        com.getui.gtc.dim.b.d unused = com.getui.gtc.dim.b.d.a.a;
        com.getui.gtc.dim.b.d.a(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + caller.name(), java.lang.Boolean.valueOf(z));
        com.getui.gtc.dim.e.b.a("dim sys callable set: " + str + " : " + caller + " : " + z);
        return true;
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        if (com.getui.gtc.dim.Caller.valueOf(str2) == com.getui.gtc.dim.Caller.IDO) {
            return this.f312s;
        }
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable get always true");
        return true;
    }

    public final int b(java.lang.String str) {
        java.lang.Integer num = 0;
        if (!android.text.TextUtils.isEmpty(str) && (num = this.g.get(str)) == null) {
            num = this.g.get("dim-2-2-0-1");
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public java.lang.Boolean b(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            return j(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + com.getui.gtc.dim.Caller.valueOf(str2).name());
        }
        for (com.getui.gtc.dim.Caller caller : com.getui.gtc.dim.Caller.values()) {
            if (caller.containAt(this.k)) {
                java.lang.Boolean j = j(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + caller.name());
                if (j == null || j.booleanValue()) {
                    return java.lang.Boolean.TRUE;
                }
            }
        }
        return java.lang.Boolean.FALSE;
    }

    public void b(int i) {
        this.c = i;
        com.getui.gtc.dim.e.b.a("dim sys trace enable set: ".concat(java.lang.String.valueOf(i)));
    }

    public void b(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, java.lang.Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow set: " + str + " : " + i);
    }

    public final boolean b() {
        int[] iArr = this.n;
        int i = iArr[0];
        return i >= 0 ? android.os.Build.VERSION.SDK_INT >= i : android.os.Build.VERSION.SDK_INT >= iArr[1];
    }

    public boolean b(java.lang.String str, com.getui.gtc.dim.Caller caller, boolean z) {
        if (caller != com.getui.gtc.dim.Caller.IDO || i("com.igexin.sdk.PushManager") || i("com.g.gysdk.GYManager") || !i("com.getui.gs.sdk.GsManager")) {
            com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set ignored");
            return false;
        }
        this.f312s = z;
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set: ".concat(java.lang.String.valueOf(z)));
        return true;
    }

    public int c() {
        return this.k;
    }

    public void c(int i) {
        this.d = i;
        com.getui.gtc.dim.e.b.a("dim sys trace hw oaid enable set: ".concat(java.lang.String.valueOf(i)));
    }

    public void c(java.lang.String str) {
        if (str != null) {
            try {
                if (str.contains(new java.lang.String(android.util.Base64.decode("Y29tLmdldHVpLmd0Yy5leHRlbnNpb24uZGlzdHJpYnV0aW9uLmdkaS5zdHViLlB1c2hFeHRlbnNpb24=", 2)))) {
                    this.f = str;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
                return;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc dyc config set: ".concat(java.lang.String.valueOf(str)));
    }

    public void c(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, java.lang.Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow policy set: " + str + " : " + i);
    }

    public void c(java.lang.String str, java.lang.String str2) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            for (java.lang.String str3 : str2.split("#")) {
                this.j.add(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str3);
            }
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2, th);
        }
    }

    public void d(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.h.put(str, str2);
        com.getui.gtc.dim.e.b.a("dim sys global trace order set: " + str + " : " + str2);
    }

    public final boolean d(java.lang.String str) {
        for (com.getui.gtc.dim.Caller caller : com.getui.gtc.dim.Caller.values()) {
            if (a(caller, str)) {
                return true;
            }
        }
        return false;
    }

    public final com.getui.gtc.dim.DimSource e(java.lang.String str) {
        java.util.ArrayList<com.getui.gtc.dim.Caller> arrayList;
        int i;
        java.lang.String str2;
        try {
            arrayList = new java.util.ArrayList();
            for (com.getui.gtc.dim.Caller caller : com.getui.gtc.dim.Caller.values()) {
                if (a(caller, str)) {
                    arrayList.add(caller);
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("allowSource key:".concat(java.lang.String.valueOf(str)), th);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (this.h.isEmpty()) {
            str2 = null;
        } else {
            str2 = this.h.get(str);
            if (str2 == null) {
                str2 = this.h.get("dim-2-2-0-1");
            }
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            java.lang.String[] split = str2.split("#");
            if (split.length >= 4) {
                for (java.lang.String str3 : split) {
                    for (com.getui.gtc.dim.Caller caller2 : arrayList) {
                        if (b(caller2).equals(str3)) {
                            return com.getui.gtc.dim.DimSource.of(caller2);
                        }
                    }
                }
            } else {
                com.getui.gtc.dim.e.b.b("dim sys trace order: " + str2 + " not match for " + str);
            }
        }
        com.getui.gtc.dim.Caller caller3 = com.getui.gtc.dim.Caller.IDO;
        if (arrayList.contains(caller3)) {
            return com.getui.gtc.dim.DimSource.of(caller3);
        }
        com.getui.gtc.dim.Caller caller4 = com.getui.gtc.dim.Caller.PUSH;
        if (arrayList.contains(caller4)) {
            return com.getui.gtc.dim.DimSource.of(caller4);
        }
        com.getui.gtc.dim.Caller caller5 = com.getui.gtc.dim.Caller.GY;
        if (arrayList.contains(caller5)) {
            return com.getui.gtc.dim.DimSource.of(caller5);
        }
        com.getui.gtc.dim.Caller caller6 = com.getui.gtc.dim.Caller.WUS;
        if (arrayList.contains(caller6)) {
            return com.getui.gtc.dim.DimSource.of(caller6);
        }
        com.getui.gtc.dim.Caller caller7 = com.getui.gtc.dim.Caller.ONEID;
        if (arrayList.contains(caller7)) {
            return com.getui.gtc.dim.DimSource.of(caller7);
        }
        return null;
    }

    public void e(java.lang.String str, java.lang.String str2) {
        boolean a2 = a(false, str2);
        this.o.put(str, java.lang.Boolean.valueOf(a2));
        com.getui.gtc.dim.e.b.a("dim sys black version set: " + str + " : " + str2 + " : " + a2);
    }

    public void f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.i.add(str);
        com.getui.gtc.dim.e.b.a("dim sys app provider globalAllow set: " + str + " : true");
    }

    public void f(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String[] split;
        java.lang.StringBuilder sb;
        boolean z = false;
        try {
            str4 = android.os.Build.BRAND;
            split = str2.split("&");
        } catch (java.lang.Throwable th) {
            th = th;
        }
        if (!str4.equalsIgnoreCase(split[0])) {
            sb = new java.lang.StringBuilder("dim sys black rom set: ");
        } else {
            if (a(true, split[1])) {
                java.lang.String str5 = split[2];
                if (!str5.equals("*")) {
                    if (this.r == null) {
                        this.r = com.getui.gtc.dim.c.a.d();
                    }
                    if (android.text.TextUtils.isEmpty(this.r)) {
                        sb = new java.lang.StringBuilder("dim sys black rom set: ");
                    } else {
                        java.lang.String[] split2 = str5.split("#");
                        int length = split2.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            if (this.r.startsWith(split2[i])) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                        if (!z) {
                            sb = new java.lang.StringBuilder("dim sys black rom set: ");
                        }
                    }
                }
                try {
                    this.q.add(str);
                    sb = new java.lang.StringBuilder("dim sys black rom set: ");
                    sb.append(str);
                    sb.append(" : ");
                    sb.append(str2);
                    sb.append(" : true");
                    str3 = sb.toString();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    z = true;
                    try {
                        com.getui.gtc.dim.e.b.b(th);
                        str3 = "dim sys black rom set: " + str + " : " + str2 + " : " + z;
                        com.getui.gtc.dim.e.b.a(str3);
                    } catch (java.lang.Throwable th3) {
                        com.getui.gtc.dim.e.b.a("dim sys black rom set: " + str + " : " + str2 + " : " + z);
                        throw th3;
                    }
                }
                com.getui.gtc.dim.e.b.a(str3);
            }
            sb = new java.lang.StringBuilder("dim sys black rom set: ");
        }
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        sb.append(" : false");
        str3 = sb.toString();
        com.getui.gtc.dim.e.b.a(str3);
    }

    public void g(java.lang.String str, java.lang.String str2) {
        java.lang.String[] split = str2.split("#");
        int length = split.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (split[i].equals(android.os.Build.MODEL)) {
                this.p.add(str);
                z = true;
                break;
            }
            i++;
        }
        com.getui.gtc.dim.e.b.a("dim sys black model set: " + str + " : " + str2 + " : " + z);
    }

    public final boolean g(java.lang.String str) {
        try {
            java.lang.Boolean bool = this.o.get(str);
            if (bool == null) {
                bool = this.o.get("dim-2-2-0-1");
            }
            if (bool == null) {
                if (android.os.Build.VERSION.SDK_INT >= 34 && h(str)) {
                    com.getui.gtc.dim.e.b.a("dim sys black version use ld for: " + str + " : true");
                    return true;
                }
            } else if (bool.booleanValue()) {
                return true;
            }
            return this.p.contains(str) || this.q.contains(str);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return true;
        }
    }
}
