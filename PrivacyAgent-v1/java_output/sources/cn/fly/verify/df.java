package cn.fly.verify;

/* loaded from: classes.dex */
public final class df {
    static volatile java.lang.String a;
    private static volatile java.lang.Boolean b;
    private static volatile java.lang.String c;
    private static volatile boolean d;
    private static java.util.HashSet<java.lang.String> e = new java.util.HashSet<>();
    private static final cn.fly.verify.ay f = new cn.fly.verify.ay();

    /* renamed from: cn.fly.verify.df$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.fy {
        final /* synthetic */ cn.fly.verify.bd a;

        /* renamed from: cn.fly.verify.df$1$1, reason: invalid class name and collision with other inner class name */
        public class C00091 extends cn.fly.verify.fv<java.lang.Void> {
            public C00091() {
            }

            @Override // cn.fly.verify.fv
            public void a(java.lang.Void r1) {
            }
        }

        public AnonymousClass1(cn.fly.verify.bd bdVar) {
            this.a = bdVar;
        }

        @Override // cn.fly.verify.fy
        public void a() {
            if (cn.fly.verify.bo.a(cn.fly.verify.ba.a("002,fefk"))) {
                boolean unused = cn.fly.verify.df.d = true;
                if (!cn.fly.verify.bo.d()) {
                    int i = 0;
                    while (i < 5) {
                        i++;
                        try {
                            java.lang.Thread.sleep(5000L);
                            if (cn.fly.verify.bo.d()) {
                                break;
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                }
                if (cn.fly.verify.bo.d()) {
                    cn.fly.verify.df.d().a(this.a, new cn.fly.verify.df.AnonymousClass1.C00091());
                }
            }
        }
    }

    public static synchronized java.lang.String a(cn.fly.verify.bd bdVar) {
        synchronized (cn.fly.verify.df.class) {
            java.util.HashMap<java.lang.String, java.lang.Object> b2 = b(bdVar);
            if (b2 == null) {
                return null;
            }
            return (java.lang.String) b2.get(cn.fly.verify.fb.a);
        }
    }

    public static boolean a() {
        return !cn.fly.verify.bo.a();
    }

    public static java.lang.String b() {
        if (a()) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(a)) {
            java.lang.String a2 = d().a();
            if (!android.text.TextUtils.isEmpty(a2) && android.text.TextUtils.isEmpty(a)) {
                a = a2;
            }
        }
        return a;
    }

    public static synchronized java.util.HashMap<java.lang.String, java.lang.Object> b(cn.fly.verify.bd bdVar) {
        boolean z;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
        synchronized (cn.fly.verify.df.class) {
            boolean z2 = true;
            if (bdVar != null) {
                cn.fly.verify.bk.a(bdVar);
                z = !e.contains(bdVar.a());
                if (z) {
                    e.add(bdVar.a());
                }
            } else {
                z = false;
            }
            if (android.text.TextUtils.isEmpty(a)) {
                a = d().b();
            } else {
                z2 = z;
            }
            cn.fly.verify.ed.a().a("aut pro: " + bdVar + ", ndReg: " + z2 + ", hsReged: " + d, new java.lang.Object[0]);
            if (z2 || !d) {
                cn.fly.verify.ea.c.execute(new cn.fly.verify.df.AnonymousClass1(bdVar));
            }
            if (b == null) {
                java.lang.String b2 = cn.fly.verify.bl.a().b("key_curr_passed_duid", (java.lang.String) null);
                c = b2;
                b = (android.text.TextUtils.isEmpty(b2) || b2.equals(a)) ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
            }
            cn.fly.verify.bl.a().a("key_curr_passed_duid", a);
            hashMap = new java.util.HashMap<>();
            hashMap.put(cn.fly.verify.fb.a, a);
            hashMap.put("isModified", java.lang.Boolean.valueOf(b.booleanValue()));
            hashMap.put("duidPrevious", c);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.fly.verify.ay d() {
        return f;
    }
}
