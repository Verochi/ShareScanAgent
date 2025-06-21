package cn.fly.verify;

/* loaded from: classes.dex */
public class bk {
    public static final java.lang.String[] a = {cn.fly.verify.ds.b("008Wdieidkfhfgdiejhb"), cn.fly.verify.ds.b("006Bdigbdidiejhb"), cn.fly.verify.ds.b("007]gbffehebdhdghb"), cn.fly.verify.ds.b("007Pgbffehfkdfdiei"), cn.fly.verify.ds.b("0097difgfjfifgfhdhekhj"), cn.fly.verify.ds.b("008Ggbffehdkejdiejhb"), cn.fly.verify.ds.b("008Tgbffehhcdfdkfhej")};
    private static java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static final java.util.HashMap<java.lang.String, cn.fly.verify.bd> d = new java.util.HashMap<>();

    /* renamed from: cn.fly.verify.bk$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.fy {
        @Override // cn.fly.verify.fy
        public void a() {
            cn.fly.verify.ed.a().a("init sks start", new java.lang.Object[0]);
            cn.fly.verify.bk.b();
            cn.fly.verify.ed.a().a("init sks over", new java.lang.Object[0]);
        }
    }

    /* renamed from: cn.fly.verify.bk$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.fh.a {
        final /* synthetic */ int a;
        final /* synthetic */ java.util.ArrayList b;
        final /* synthetic */ java.lang.String[] c;

        public AnonymousClass2(int i, java.util.ArrayList arrayList, java.lang.String[] strArr) {
            this.a = i;
            this.b = arrayList;
            this.c = strArr;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) throws java.lang.Throwable {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3 = "";
            java.lang.String encode = android.text.TextUtils.isEmpty(cn.fly.verify.fh.d.c()) ? "" : java.net.URLEncoder.encode(cn.fly.verify.fh.d.c(), "utf-8");
            java.lang.String encode2 = android.text.TextUtils.isEmpty(cn.fly.verify.fh.d.f()) ? "" : java.net.URLEncoder.encode(cn.fly.verify.fh.d.f(), "utf-8");
            java.lang.String encode3 = android.text.TextUtils.isEmpty(cn.fly.verify.fh.d.k()) ? "" : java.net.URLEncoder.encode(cn.fly.verify.fh.d.k(), "utf-8");
            java.lang.String encode4 = android.text.TextUtils.isEmpty(cn.fly.verify.fh.d.j()) ? "" : java.net.URLEncoder.encode(cn.fly.verify.fh.d.j(), "utf-8");
            java.lang.String encode5 = android.text.TextUtils.isEmpty(bVar.p()) ? "" : java.net.URLEncoder.encode(bVar.p(), "utf-8");
            java.lang.String encode6 = android.text.TextUtils.isEmpty(cn.fly.verify.fh.d.h()) ? "" : java.net.URLEncoder.encode(cn.fly.verify.fh.d.h(), "utf-8");
            java.util.HashMap<java.lang.String, java.lang.Object> b = cn.fly.verify.dt.a().b();
            java.lang.String str4 = cn.fly.verify.ds.b("004JdkfkfkOk") + encode + com.alipay.sdk.m.u.i.b + encode2;
            java.lang.String str5 = cn.fly.verify.ds.b("012JdihjdiWk+dkBdWcbcidcchcbif") + cn.fly.verify.fh.d.g() + com.alipay.sdk.m.u.i.b + encode6;
            java.lang.String str6 = cn.fly.verify.ds.b("004SdiejdhFk") + ((!cn.fly.verify.dy.b() || this.a == 3) ? bVar.c(new int[0]) : bVar.h());
            java.lang.String str7 = cn.fly.verify.ds.b("003-ekgbRk") + encode3 + com.alipay.sdk.m.u.i.b + encode4;
            if (!android.text.TextUtils.isEmpty(encode5)) {
                str7 = str7 + com.alipay.sdk.m.u.i.b + encode5;
            }
            java.lang.String str8 = cn.fly.verify.ds.b("003PdgfgOk") + bVar.g() + com.alipay.sdk.m.u.i.b + bVar.d();
            java.lang.String str9 = cn.fly.verify.ds.b("0059ebZcd'dd3k") + java.util.Locale.getDefault().toString().replace(cn.fly.verify.ds.b("002Kgjci"), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            java.lang.String str10 = cn.fly.verify.ds.b("004$fjebfi<k") + cn.fly.verify.ax.a;
            java.lang.String b2 = cn.fly.verify.ds.b("004[diejhbAk");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                int i = 0;
                while (i < size) {
                    try {
                        cn.fly.verify.bd bdVar = (cn.fly.verify.bd) this.b.get(i);
                        if (i != 0) {
                            str2 = str3;
                            try {
                                b2 = b2 + ",";
                            } catch (java.lang.Throwable unused) {
                            }
                        } else {
                            str2 = str3;
                        }
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(b2);
                            java.lang.String str11 = b2;
                            try {
                                sb.append(bdVar.a());
                                sb.append(com.alipay.sdk.m.u.i.b);
                                sb.append(bdVar.b());
                                sb.append(com.alipay.sdk.m.u.i.b);
                                sb.append(b.get(bdVar.a()));
                                b2 = sb.toString();
                            } catch (java.lang.Throwable unused2) {
                                b2 = str11;
                            }
                        } catch (java.lang.Throwable unused3) {
                        }
                    } catch (java.lang.Throwable unused4) {
                        str2 = str3;
                    }
                    i++;
                    str3 = str2;
                }
            }
            java.lang.String str12 = str3;
            int i2 = this.a;
            java.lang.String str13 = i2 == 1 ? "DC/[DC]" : i2 == 2 ? "DC/[DC2]" : "DC/9";
            java.lang.String i3 = cn.fly.verify.fh.d.i();
            if (android.text.TextUtils.isEmpty(i3)) {
                str = str12;
            } else {
                str = cn.fly.verify.ds.b("003Zdjhkcg") + i3;
            }
            java.lang.String c = cn.fly.verify.bm.a().c();
            java.lang.String str14 = "TID/";
            if (!android.text.TextUtils.isEmpty(c)) {
                str14 = "TID/" + c;
            }
            int a = cn.fly.verify.ce.a();
            java.lang.String str15 = "SVM/" + a;
            if (cn.fly.verify.ei.c()) {
                if (!cn.fly.verify.ds.b("004Jdiejhb]k").equals(b2)) {
                    b2 = b2 + ",";
                }
                b2 = b2 + "CS;" + a;
            }
            java.lang.String f = cn.fly.verify.dz.a().f();
            java.lang.String str16 = "RD/";
            if (!android.text.TextUtils.isEmpty(f)) {
                str16 = "RD/" + f;
            }
            this.c[0] = str4 + " " + str5 + " " + str6 + " " + str7 + " " + str8 + " " + str9 + " " + str10 + " " + b2 + " " + str13 + " " + str + " " + str14 + " " + str15 + " " + str16;
        }
    }

    private static synchronized java.lang.String a(java.util.ArrayList<cn.fly.verify.bd> arrayList, int i) {
        java.lang.String str;
        synchronized (cn.fly.verify.bk.class) {
            java.lang.String[] strArr = {""};
            cn.fly.verify.fh.c d2 = cn.fly.verify.fh.a(cn.fly.verify.ax.g()).p().g().d();
            if (!cn.fly.verify.dy.b() || i == 3) {
                d2.c(true);
            } else {
                d2.h();
            }
            d2.a(new cn.fly.verify.bk.AnonymousClass2(i, arrayList, strArr));
            str = strArr[0];
        }
        return str;
    }

    public static void a() {
        g();
        cn.fly.verify.ea.c.execute(new cn.fly.verify.bk.AnonymousClass1());
    }

    public static void a(cn.fly.verify.bd bdVar) {
        java.util.HashMap<java.lang.String, cn.fly.verify.bd> hashMap = d;
        synchronized (hashMap) {
            if (bdVar != null) {
                if (!hashMap.containsKey(bdVar.a())) {
                    hashMap.put(bdVar.a(), bdVar);
                }
            }
        }
    }

    public static java.util.ArrayList<cn.fly.verify.bd> b() {
        java.util.ArrayList<cn.fly.verify.bd> arrayList;
        java.util.HashMap<java.lang.String, cn.fly.verify.bd> hashMap = d;
        synchronized (hashMap) {
            if (cn.fly.verify.dy.h() && b.compareAndSet(false, true)) {
                hashMap.putAll(h());
            }
            arrayList = new java.util.ArrayList<>();
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public static synchronized java.lang.String c() {
        java.lang.String a2;
        synchronized (cn.fly.verify.bk.class) {
            a2 = a(b(), 0);
        }
        return a2;
    }

    public static synchronized java.lang.String d() {
        java.lang.String a2;
        synchronized (cn.fly.verify.bk.class) {
            a2 = a(b(), 1);
        }
        return a2;
    }

    public static synchronized java.lang.String e() {
        java.lang.String a2;
        synchronized (cn.fly.verify.bk.class) {
            a2 = a(b(), 2);
        }
        return a2;
    }

    public static synchronized java.lang.String f() {
        java.lang.String a2;
        synchronized (cn.fly.verify.bk.class) {
            a2 = a(b(), 3);
        }
        return a2;
    }

    private static void g() {
    }

    private static java.util.HashMap<java.lang.String, cn.fly.verify.bd> h() {
        java.util.HashMap<java.lang.String, cn.fly.verify.bd> hashMap = new java.util.HashMap<>();
        for (java.lang.Object obj : cn.fly.verify.du.a) {
            try {
                java.lang.Class<?> cls = obj instanceof java.lang.String ? java.lang.Class.forName(java.lang.String.valueOf(obj).trim()) : (java.lang.Class) obj;
                if (!cn.fly.verify.bd.class.isAssignableFrom(cls) || cn.fly.verify.bd.class.equals(cls)) {
                    cls.newInstance();
                } else {
                    cn.fly.verify.bd bdVar = (cn.fly.verify.bd) cls.newInstance();
                    java.lang.String a2 = bdVar.a();
                    java.lang.String[] strArr = a;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            java.lang.String str = strArr[i];
                            if (str.equals(a2)) {
                                hashMap.put(str, bdVar);
                                break;
                            }
                            i++;
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return hashMap;
    }
}
