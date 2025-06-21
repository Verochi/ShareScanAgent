package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public final class a {
    public static final java.lang.String a = "Anythink SDK M";
    public static boolean b = false;
    public static java.util.Map<java.lang.String, java.lang.Long> c = new java.util.HashMap();
    public static java.util.Set<java.lang.String> d = new java.util.HashSet();
    public static final java.lang.String e = "2";
    private static final int f = 1;
    private java.lang.String g;
    private long h;
    private com.anythink.expressad.foundation.c.c i;
    private android.content.Context j;
    private com.anythink.expressad.a.c k;
    private com.anythink.expressad.out.f l;
    private com.anythink.expressad.d.a n;
    private boolean o;
    private boolean r;
    private com.anythink.expressad.out.p.c m = null;
    private boolean p = false;
    private boolean q = true;

    /* renamed from: com.anythink.expressad.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.anythink.expressad.out.j b;

        public AnonymousClass1(boolean z, com.anythink.expressad.out.j jVar) {
            this.a = z;
            this.b = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a && !com.anythink.expressad.a.a.b && com.anythink.expressad.a.o) {
                com.anythink.expressad.a.a.a(com.anythink.expressad.a.a.this);
            }
            if (com.anythink.expressad.a.a.this.m == null || com.anythink.expressad.a.a.b || !com.anythink.expressad.a.o) {
                return;
            }
            com.anythink.expressad.a.a.this.m.b(this.b);
        }
    }

    public a(android.content.Context context, java.lang.String str) {
        this.i = null;
        this.j = null;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        this.n = b2;
        if (b2 == null) {
            com.anythink.expressad.d.b.a();
            this.n = com.anythink.expressad.d.b.c();
        }
        this.o = this.n.t();
        android.content.Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.g = str;
        if (this.i == null) {
            this.i = com.anythink.expressad.foundation.c.c.a(applicationContext);
        }
    }

    private void a(int i, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.out.p.c cVar2) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            if (i == 2) {
                com.anythink.expressad.foundation.h.s.a(this.j, str, cVar, cVar2);
            } else {
                com.anythink.expressad.foundation.h.s.a(this.j, str, cVar2);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, boolean z) {
        if (context == null) {
            return;
        }
        new com.anythink.expressad.a.c(context.getApplicationContext()).a("2", str, cVar, null, str2, false, z, com.anythink.expressad.a.a.a.h);
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, boolean z, boolean z2, int i) {
        if (context == null) {
            return;
        }
        new com.anythink.expressad.a.c(context.getApplicationContext()).a("2", str, cVar, null, str2, z, z2, i);
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String[] strArr, boolean z) {
        if (context == null || cVar == null || android.text.TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        com.anythink.expressad.a.c cVar2 = new com.anythink.expressad.a.c(context.getApplicationContext());
        for (java.lang.String str2 : strArr) {
            cVar2.a("2", str, cVar, null, str2, false, z, com.anythink.expressad.a.a.a.h);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.a.a aVar) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("ExitApp");
            com.anythink.core.common.b.l.a(aVar.j).a(intent);
        } catch (java.lang.Exception unused) {
        }
    }

    private void a(com.anythink.expressad.a.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(java.lang.String.valueOf(currentTimeMillis));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!android.text.TextUtils.isEmpty(bVar.j())) {
                fVar.f(java.net.URLEncoder.encode(bVar.j(), "utf-8"));
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.h / 1000);
            fVar.b(sb.toString());
            fVar.a(java.lang.Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.g);
            fVar.d(bVar.c());
            if (!android.text.TextUtils.isEmpty(bVar.j())) {
                fVar.f(java.net.URLEncoder.encode(bVar.j(), "utf-8"));
            }
            if (this.o) {
                fVar.c(bVar.a());
                if (!android.text.TextUtils.isEmpty(bVar.d())) {
                    fVar.d(java.net.URLEncoder.encode(bVar.d(), "utf-8"));
                }
                if (!android.text.TextUtils.isEmpty(bVar.f())) {
                    fVar.e(java.net.URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!android.text.TextUtils.isEmpty(bVar.e())) {
                    fVar.c(java.net.URLEncoder.encode(bVar.e(), "utf-8"));
                }
            }
            if (z) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(fVar);
            com.anythink.expressad.foundation.h.w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ab, code lost:
    
        if (com.anythink.expressad.foundation.h.s.a.a(r6.j, "market://details?id=" + r7.ba(), r6.m) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0139, code lost:
    
        b(r8, r7, true);
        r7 = r6.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013e, code lost:
    
        if (r7 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0140, code lost:
    
        r7.b(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0144, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.c.b bVar, boolean z, boolean z2) {
        com.anythink.expressad.out.p.c cVar2;
        try {
            if (this.q) {
                if (cVar != null && bVar != null) {
                    int i = i();
                    int i2 = bVar.i();
                    if (android.text.TextUtils.isEmpty(bVar.j()) && z) {
                        int Q = cVar.Q();
                        if (Q == 2) {
                            a(cVar, bVar, z, i());
                            return;
                        }
                        if (Q == 3) {
                            a(cVar, bVar, z);
                            return;
                        }
                        com.anythink.expressad.foundation.h.s.a(this.j, cVar.ad(), this.m);
                        b(bVar, cVar, true);
                        com.anythink.expressad.out.p.c cVar3 = this.m;
                        if (cVar3 != null) {
                            cVar3.a((com.anythink.expressad.out.j) cVar, bVar.j());
                            return;
                        }
                        return;
                    }
                    if (i2 == 1) {
                        if (android.text.TextUtils.isEmpty(cVar.ba()) || android.text.TextUtils.isEmpty(bVar.j()) || !bVar.j().contains(cVar.ba()) || !z) {
                            if (z) {
                                if (!android.text.TextUtils.isEmpty(cVar.ba())) {
                                }
                                a(i, bVar.j(), cVar, this.m);
                            }
                            cVar2 = this.m;
                            if (cVar2 != null && z) {
                                cVar2.a((com.anythink.expressad.out.j) cVar, bVar.j());
                            }
                        } else {
                            if (!com.anythink.expressad.foundation.h.s.a.a(this.j, bVar.j(), this.m)) {
                                a(i, bVar.j(), cVar, this.m);
                            }
                            cVar2 = this.m;
                            if (cVar2 != null) {
                                cVar2.a((com.anythink.expressad.out.j) cVar, bVar.j());
                            }
                        }
                    } else if (i2 == 3) {
                        if (z) {
                            com.anythink.expressad.foundation.h.s.a(this.j, bVar.j(), this.m);
                        }
                        com.anythink.expressad.out.p.c cVar4 = this.m;
                        if (cVar4 != null && z) {
                            cVar4.a((com.anythink.expressad.out.j) cVar, bVar.j());
                        }
                    } else if (z) {
                        if (3 == cVar.Q()) {
                            a(cVar, bVar, z);
                            return;
                        } else {
                            if (2 == cVar.Q()) {
                                a(cVar, bVar, z, i());
                                return;
                            }
                            com.anythink.expressad.foundation.h.s.a(this.j, bVar.j(), this.m);
                            com.anythink.expressad.out.p.c cVar5 = this.m;
                            if (cVar5 != null) {
                                cVar5.a((com.anythink.expressad.out.j) cVar, bVar.j());
                            }
                        }
                    }
                    if (a(cVar.Q(), bVar.j())) {
                        b(bVar, cVar, false);
                    } else {
                        b(bVar, cVar, true);
                    }
                    com.anythink.expressad.out.p.c cVar6 = this.m;
                    if (cVar6 == null || z || !z2) {
                        return;
                    }
                    cVar6.a((com.anythink.expressad.out.j) cVar, bVar.j());
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a(this.j, cVar, this.g, str, true, false, com.anythink.expressad.a.a.a.k);
    }

    private void a(com.anythink.expressad.out.f fVar) {
        this.l = fVar;
    }

    private void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && jVar != null) {
                com.anythink.expressad.foundation.d.c cVar = jVar instanceof com.anythink.expressad.foundation.d.c ? (com.anythink.expressad.foundation.d.c) jVar : null;
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || com.anythink.expressad.foundation.h.s.a.a(this.j, str, this.m) || cVar == null) {
                    return;
                }
                if (android.text.TextUtils.isEmpty(cVar.ba())) {
                    if (i() == 2) {
                        com.anythink.expressad.foundation.h.s.a(this.j, cVar.ad(), cVar, this.m);
                        return;
                    } else {
                        com.anythink.expressad.foundation.h.s.a(this.j, cVar.ad(), this.m);
                        return;
                    }
                }
                com.anythink.expressad.foundation.h.s.a.a(this.j, "market://details?id=" + cVar.ba(), this.m);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(java.lang.String str) {
        this.g = str;
    }

    private void a(boolean z, com.anythink.expressad.out.j jVar) {
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.anythink.expressad.a.a.AnonymousClass1(z, jVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0010, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L14;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0017 -> B:7:0x0018). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(int i, java.lang.String str) {
        boolean z = true;
        try {
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (i == 2) {
            if (com.anythink.expressad.foundation.h.s.a.a(str)) {
            }
            z = false;
        }
        return z;
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        java.lang.Long l;
        if (cVar == null) {
            return true;
        }
        try {
            if (2 != cVar.Q() && 3 != cVar.Q()) {
                return true;
            }
            java.lang.String aZ = cVar.aZ();
            java.util.Map<java.lang.String, java.lang.Long> map = c;
            if (map == null) {
                return true;
            }
            if (map.containsKey(aZ) && (l = c.get(aZ)) != null) {
                if (l.longValue() > java.lang.System.currentTimeMillis() || d.contains(cVar.aZ())) {
                    return false;
                }
            }
            c.put(cVar.aZ(), java.lang.Long.valueOf(java.lang.System.currentTimeMillis() + (cVar.Y() * 1000)));
            return true;
        } catch (java.lang.Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.c.b bVar, boolean z) {
        boolean z2 = false;
        if (z) {
            try {
                com.anythink.expressad.foundation.h.s.a(this.j, cVar.ad(), this.m);
                z2 = true;
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        b(bVar, cVar, true);
        if (z2) {
            com.anythink.expressad.out.p.c cVar2 = this.m;
            if (cVar2 != null) {
                cVar2.a((com.anythink.expressad.out.j) cVar, bVar.j());
            }
        } else {
            com.anythink.expressad.out.p.c cVar3 = this.m;
            if (cVar3 != null) {
                cVar3.b(cVar, bVar.j());
            }
        }
        return z2;
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.c.b bVar, boolean z, int i) {
        boolean z2 = false;
        if (z) {
            try {
                int parseInt = java.lang.Integer.parseInt(cVar.ac());
                if (parseInt == 1) {
                    com.anythink.expressad.foundation.h.s.a(this.j, bVar.j(), this.m);
                } else if (parseInt == 2) {
                    com.anythink.expressad.foundation.h.s.a(this.j, bVar.j(), cVar, this.m);
                } else if (cVar.ba() != null) {
                    if (!com.anythink.expressad.foundation.h.s.a.a(this.j, "market://details?id=" + cVar.ba(), this.m)) {
                        a(i, bVar.j(), cVar, this.m);
                    }
                } else {
                    a(i, bVar.j(), cVar, this.m);
                }
                z2 = true;
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        if (z2) {
            b(bVar, cVar, true);
            com.anythink.expressad.out.p.c cVar2 = this.m;
            if (cVar2 != null) {
                cVar2.a((com.anythink.expressad.out.j) cVar, bVar.j());
            }
        } else {
            b(bVar, cVar, true);
            com.anythink.expressad.out.p.c cVar3 = this.m;
            if (cVar3 != null && z) {
                cVar3.b(cVar, bVar.j());
            }
        }
        return z2;
    }

    private void b(com.anythink.expressad.a.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(java.lang.String.valueOf(currentTimeMillis));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!android.text.TextUtils.isEmpty(bVar.j())) {
                fVar.f(java.net.URLEncoder.encode(bVar.j(), "utf-8"));
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.h / 1000);
            fVar.b(sb.toString());
            fVar.a(java.lang.Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.g);
            fVar.d(bVar.c());
            if (!android.text.TextUtils.isEmpty(bVar.j())) {
                fVar.f(java.net.URLEncoder.encode(bVar.j(), "utf-8"));
            }
            if (this.o) {
                fVar.c(bVar.a());
                if (!android.text.TextUtils.isEmpty(bVar.d())) {
                    fVar.d(java.net.URLEncoder.encode(bVar.d(), "utf-8"));
                }
                if (!android.text.TextUtils.isEmpty(bVar.f())) {
                    fVar.e(java.net.URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!android.text.TextUtils.isEmpty(bVar.e())) {
                    fVar.c(java.net.URLEncoder.encode(bVar.e(), "utf-8"));
                }
            }
            if (z) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(fVar);
            com.anythink.expressad.foundation.h.w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        try {
            android.content.Intent intent = new android.content.Intent(this.j, (java.lang.Class<?>) com.anythink.expressad.out.LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("icon_url", cVar.bd());
            this.j.startActivity(intent);
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean c() {
        return this.q;
    }

    private com.anythink.expressad.out.f d() {
        return this.l;
    }

    private com.anythink.expressad.foundation.c.c e() {
        return this.i;
    }

    private static void f() {
    }

    private void g() {
        com.anythink.expressad.a.c cVar = this.k;
        if (cVar == null || !cVar.a()) {
            return;
        }
        this.k.b();
    }

    private static void h() {
    }

    private int i() {
        try {
            com.anythink.expressad.d.a aVar = this.n;
            if (aVar != null) {
                return aVar.k();
            }
            return 1;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    private void j() {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("ExitApp");
            com.anythink.core.common.b.l.a(this.j).a(intent);
        } catch (java.lang.Exception unused) {
        }
    }

    public final void a() {
        this.q = false;
    }

    public final void a(com.anythink.expressad.out.p.c cVar) {
        this.m = cVar;
    }

    public final void b() {
        try {
            this.m = null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
