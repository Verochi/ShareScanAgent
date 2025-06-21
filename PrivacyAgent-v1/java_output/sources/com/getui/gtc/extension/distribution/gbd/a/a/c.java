package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public class c implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String a = "GBD_RIA";
    private static volatile com.getui.gtc.extension.distribution.gbd.a.a.c b;
    private android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> d = null;
    private com.getui.gtc.extension.distribution.gbd.g.c e = new com.getui.gtc.extension.distribution.gbd.a.a.c.AnonymousClass1();
    private android.net.ConnectivityManager c = com.getui.gtc.extension.distribution.gbd.n.q.c(com.getui.gtc.extension.distribution.gbd.d.c.d);

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj instanceof com.getui.gtc.extension.distribution.gbd.c.b) {
                    com.getui.gtc.extension.distribution.gbd.c.b bVar = (com.getui.gtc.extension.distribution.gbd.c.b) obj;
                    boolean z = bVar.b;
                    java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list = bVar.a;
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    if (z) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.c.a, "instant bir report s.");
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.c.a, "instant bir report f");
                    if (com.getui.gtc.extension.distribution.gbd.a.a.c.this.d != null) {
                        com.getui.gtc.extension.distribution.gbd.a.a.c.this.a(com.getui.gtc.extension.distribution.gbd.a.a.c.g(), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    private c() {
    }

    private static java.lang.String a(android.net.Network network) {
        int h = com.getui.gtc.extension.distribution.gbd.n.l.h(com.getui.gtc.extension.distribution.gbd.d.c.d);
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(format);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.K());
        sb.append("|");
        sb.append(h);
        sb.append("|");
        if (network != null) {
            h = 0;
        }
        sb.append(h);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al data: type = 255 content = ".concat(java.lang.String.valueOf(sb)));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair) {
        try {
            com.getui.gtc.extension.distribution.gbd.c.p pVar = new com.getui.gtc.extension.distribution.gbd.c.p();
            pVar.b = 255;
            pVar.c = str;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(pVar);
            this.d = pair;
            com.getui.gtc.extension.distribution.gbd.g.a.i iVar = pair == null ? new com.getui.gtc.extension.distribution.gbd.g.a.i(str.getBytes("UTF-8"), arrayList) : new com.getui.gtc.extension.distribution.gbd.g.a.i(str.getBytes("UTF-8"), arrayList, pair, this.c);
            iVar.m = this.e;
            try {
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(iVar));
            } catch (java.lang.Throwable unused) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "instant bir requestService false.");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "doReport requestService isReporting=false " + th.toString());
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.a.a.c f() {
        if (b == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.a.a.c.class) {
                if (b == null) {
                    b = new com.getui.gtc.extension.distribution.gbd.a.a.c();
                }
            }
        }
        return b;
    }

    public static /* synthetic */ java.lang.String g() {
        return a((android.net.Network) null);
    }

    private void h() {
        if (!com.getui.gtc.extension.distribution.gbd.n.q.b(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "net info is null");
        } else if (com.getui.gtc.extension.distribution.gbd.n.q.a(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "in cellular.");
            a(a((android.net.Network) null), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "in wi.");
            i();
        }
    }

    private void i() {
        java.lang.Object obj;
        try {
            if (!com.getui.gtc.extension.distribution.gbd.n.q.d(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "sc no cu.");
                a(a((android.net.Network) null), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.d.dr && com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.CHANGE_NETWORK_STATE")) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "in w mode, attempt 2 cu.");
                android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> a2 = com.getui.gtc.extension.distribution.gbd.n.q.a(this.c);
                if (a2 != null && (obj = a2.first) != null) {
                    a(a((android.net.Network) obj), a2);
                    return;
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "register switch network failed");
                    a(a((android.net.Network) null), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
                    return;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "sc dy not allow or no net perm.");
            a(a((android.net.Network) null), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "doSample");
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(255)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "type 255 in type black list, return.");
                return;
            }
            if (!com.getui.gtc.extension.distribution.gbd.n.q.b(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "net info is null");
            } else if (com.getui.gtc.extension.distribution.gbd.n.q.a(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "in cellular.");
                a(a((android.net.Network) null), (android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback>) null);
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "in wi.");
                i();
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th.getMessage());
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 255;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
