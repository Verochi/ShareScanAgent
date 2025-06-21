package cn.fly.verify;

/* loaded from: classes.dex */
public class d {
    private static java.lang.Boolean a;
    private static byte[] b;
    private static java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> c;
    private static java.util.concurrent.ExecutorService d = java.util.concurrent.Executors.newSingleThreadExecutor();

    /* renamed from: cn.fly.verify.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            java.util.List list;
            try {
                int m = cn.fly.verify.ai.a().m();
                if (m != 1) {
                    cn.fly.verify.f.a().a("cancel upload, logSwitch: " + m);
                    return;
                }
                cn.fly.verify.d.h();
                if (cn.fly.verify.d.c.isEmpty()) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int size = cn.fly.verify.d.c.size();
                cn.fly.verify.f.a().a("upload check total size: " + size);
                if (size > 100) {
                    int i = size - 1;
                    list = cn.fly.verify.d.c.subList(i - 100, i);
                } else {
                    list = cn.fly.verify.d.c;
                }
                arrayList.addAll(list);
                java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
                hashMap.put(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, arrayList);
                try {
                    cn.fly.verify.j.a(false).a(hashMap, cn.fly.verify.i.a(4) + "api/log");
                    if (size > 100) {
                        cn.fly.verify.d.c.removeAll(arrayList);
                        cn.fly.verify.d.c(cn.fly.verify.d.c);
                        cn.fly.verify.f.a().a("upload size: " + arrayList.size() + ", remain size: " + cn.fly.verify.d.c.size());
                    } else {
                        java.util.ArrayList unused = cn.fly.verify.d.c = null;
                        cn.fly.verify.aq.b((java.lang.String) null);
                    }
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.f.a().a(th);
                }
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.f.a().a(th2);
            }
        }
    }

    /* renamed from: cn.fly.verify.d$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ cn.fly.verify.c a;

        public AnonymousClass2(cn.fly.verify.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(cn.fly.verify.d.b(this.a, cn.fly.verify.d.g()));
                hashMap.put(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, arrayList);
                try {
                    cn.fly.verify.j.a(false).a(hashMap, cn.fly.verify.i.a(4) + "api/log");
                    cn.fly.verify.f.a().a("forceUploadLog: " + this.a.c() + "," + this.a.d());
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.f.a().a(th);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: cn.fly.verify.d$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ cn.fly.verify.c a;

        public AnonymousClass3(cn.fly.verify.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (cn.fly.verify.aq.f()) {
                    cn.fly.verify.f.a().a("del log");
                    cn.fly.verify.d.a(new cn.fly.verify.e(cn.fly.verify.g.LOG).b("delLog"));
                }
                if (cn.fly.verify.ai.a().m() != -1) {
                    cn.fly.verify.d.h();
                    cn.fly.verify.d.c.add(cn.fly.verify.d.b(this.a, cn.fly.verify.d.g()));
                    cn.fly.verify.d.c(cn.fly.verify.d.c);
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().a(th);
            }
        }
    }

    public static java.util.concurrent.ExecutorService a() {
        return d;
    }

    public static void a(cn.fly.verify.c cVar) {
        d.execute(new cn.fly.verify.d.AnonymousClass2(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.HashMap<java.lang.String, java.lang.Object> b(cn.fly.verify.c cVar, boolean z) {
        cVar.a(z);
        return cn.fly.verify.h.a().a(cVar);
    }

    public static void b() {
        d.execute(new cn.fly.verify.d.AnonymousClass1());
    }

    public static void b(cn.fly.verify.c cVar) {
        d.execute(new cn.fly.verify.d.AnonymousClass3(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> arrayList) {
        try {
            java.lang.String a2 = new cn.fly.verify.fl().a(arrayList);
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            java.lang.String[] a3 = cn.fly.verify.an.a(i(), a2);
            cn.fly.verify.aq.b(a3[0] + "&&" + a3[1]);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            cn.fly.verify.aq.b((java.lang.String) null);
        }
    }

    private static java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> f() {
        try {
            java.lang.String e = cn.fly.verify.aq.e();
            if (android.text.TextUtils.isEmpty(e)) {
                return null;
            }
            java.lang.String[] split = e.split("&&");
            if (split.length != 2) {
                cn.fly.verify.aq.b((java.lang.String) null);
                return null;
            }
            java.lang.String str = split[0];
            return (java.util.ArrayList) new cn.fly.verify.fl().a(cn.fly.verify.an.b(cn.fly.verify.as.c(str), split[1]).trim(), java.util.ArrayList.class);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g() {
        java.lang.Boolean bool;
        if (a == null) {
            java.io.File file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), ".preverfy_xhs");
            if (file.exists()) {
                bool = java.lang.Boolean.FALSE;
            } else {
                try {
                    file.createNewFile();
                } catch (java.io.IOException unused) {
                }
                bool = java.lang.Boolean.TRUE;
            }
            a = bool;
        }
        return a.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (c == null) {
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> f = f();
            c = f;
            if (f == null) {
                c = new java.util.ArrayList<>();
            }
        }
    }

    private static byte[] i() {
        if (b == null) {
            try {
                b = cn.fly.verify.an.a();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().a(th);
            }
        }
        return b;
    }
}
