package com.anythink.core.common.p;

/* loaded from: classes12.dex */
public final class f {
    public static final java.lang.String a = com.anythink.core.common.g.class.getSimpleName();
    final int b;
    int c;
    int d;
    long e;
    com.anythink.core.common.f.ay o;
    com.anythink.core.common.f.ap p;
    com.anythink.core.common.p.h q;
    com.anythink.core.common.f.p r;

    /* renamed from: s, reason: collision with root package name */
    com.anythink.core.common.f.p f183s;
    private java.util.List<com.anythink.core.common.f.au> t;
    volatile int k = 0;
    volatile int l = 0;
    volatile int m = 0;
    volatile int n = 0;
    java.util.List<com.anythink.core.common.f.au> f = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
    java.util.List<com.anythink.core.common.f.au> g = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
    java.util.List<com.anythink.core.common.f.au> h = java.util.Collections.synchronizedList(new java.util.ArrayList(2));
    java.util.List<com.anythink.core.common.p.e> i = java.util.Collections.synchronizedList(new java.util.ArrayList(2));
    java.util.List<com.anythink.core.common.f.au> j = java.util.Collections.synchronizedList(new java.util.ArrayList(2));

    public f(com.anythink.core.common.p.g gVar) {
        this.c = 1;
        this.f.addAll(gVar.d);
        this.j.addAll(gVar.e);
        this.q = gVar.i;
        this.r = gVar.k;
        this.f183s = gVar.l;
        this.b = gVar.c.h();
        this.c = gVar.c.e();
        this.d = gVar.c.f();
        this.e = gVar.c.j();
        java.util.List<com.anythink.core.common.f.au> c = c(gVar.d);
        if (c != null) {
            this.f.removeAll(c);
            this.h.addAll(c);
        }
        this.t = java.util.Collections.synchronizedList(new java.util.ArrayList(3));
        this.o = gVar.h;
        this.p = gVar.j;
    }

    private double A() {
        return a(true);
    }

    public static com.anythink.core.common.f.au a(java.util.Map<java.lang.String, com.anythink.core.common.p.d> map) {
        com.anythink.core.common.f.au auVar;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.core.common.p.d>> it = map.entrySet().iterator();
        com.anythink.core.common.f.au auVar2 = null;
        if (it != null) {
            while (it.hasNext()) {
                com.anythink.core.common.p.d value = it.next().getValue();
                if (value != null && !value.i && (auVar = value.c) != null && (auVar2 == null || com.anythink.core.common.o.h.a(auVar) > com.anythink.core.common.o.h.a(auVar2))) {
                    auVar2 = auVar;
                }
            }
        }
        return auVar2;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.x.a(context).a(str);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.au auVar2) {
        com.anythink.core.common.f.ay.a aVar;
        com.anythink.core.common.f.ay.a aVar2 = null;
        if (auVar != null) {
            com.anythink.core.common.f.ay.a aVar3 = new com.anythink.core.common.f.ay.a(auVar, auVar.M());
            aVar = null;
            aVar2 = aVar3;
        } else {
            aVar = auVar2 != null ? new com.anythink.core.common.f.ay.a(auVar2, auVar2.M()) : null;
        }
        com.anythink.core.common.x.a(context).a(str, str2, aVar2, aVar);
    }

    public static void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar) {
        if (auVar != null && auVar.k() && auVar.K() == 2) {
            a(auVar, hVar.S(), true);
        }
    }

    private static void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar, boolean z) {
        com.anythink.core.common.f.q M = auVar.M();
        if (M != null) {
            com.anythink.core.b.d.b.a(M, new com.anythink.core.common.f.y(2, auVar, hVar), z);
        }
    }

    public static void a(java.lang.String str) {
        com.anythink.core.common.d.a().b(str);
    }

    private void a(java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2) {
        int ae;
        int size = list2.size();
        int size2 = this.t.size();
        for (int i = 0; i < size; i++) {
            com.anythink.core.common.f.au auVar = list2.get(i);
            if (auVar.k() && (ae = auVar.ae()) > 0 && ae <= size2 && com.anythink.core.common.o.h.a(auVar) < com.anythink.core.common.o.h.a(this.t.get(ae - 1))) {
                list.add(auVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r4 != 7) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.anythink.core.common.f.au auVar, com.anythink.core.common.p.i iVar) {
        boolean z = auVar.X() == 1;
        if (z) {
            int m = auVar.m();
            if (m != 1 && m != 3) {
                if (m == 6) {
                    if (iVar.g) {
                        return false;
                    }
                    iVar.g = true;
                }
            }
            if (iVar.f) {
                return false;
            }
            iVar.f = true;
        }
        return z;
    }

    public static boolean a(java.lang.String str, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar) {
        boolean z = false;
        try {
            if (auVar.k()) {
                com.anythink.core.common.f.q M = auVar.M();
                com.anythink.core.b.f.a().a(str, M);
                if (M != null && M.a()) {
                    z = true;
                }
                if (z && M != null) {
                    com.anythink.core.b.d.b.a(M, new com.anythink.core.common.f.y(1, auVar, hVar), true);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return z;
    }

    public static java.lang.String b(java.util.List<com.anythink.core.common.f.au> list) {
        java.lang.String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(list.get(i).d());
            str = str + sb.toString();
        }
        return str;
    }

    private static java.util.List<com.anythink.core.common.f.au> c(java.util.List<com.anythink.core.common.f.au> list) {
        java.util.ArrayList arrayList = null;
        for (com.anythink.core.common.f.au auVar : list) {
            if (auVar.m() == 8) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList(4);
                }
                arrayList.add(auVar);
            }
        }
        return arrayList;
    }

    public static double h(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.q M;
        double a2 = com.anythink.core.common.o.h.a(auVar);
        return (auVar.Z() && a2 == 10000.0d && (M = auVar.M()) != null) ? M.o : a2;
    }

    private java.util.List<com.anythink.core.common.f.au> w() {
        return this.f;
    }

    private java.util.List<com.anythink.core.common.f.au> x() {
        return this.g;
    }

    private java.util.List<com.anythink.core.common.f.au> y() {
        return this.h;
    }

    private double z() {
        return a(false);
    }

    public final double a(boolean z) {
        synchronized (this.t) {
            int size = this.t.size();
            if (size == 0) {
                return 0.0d;
            }
            int i = this.b - 1;
            int i2 = size - 1;
            if (z && i2 < i) {
                return 0.0d;
            }
            return com.anythink.core.common.o.h.a(this.t.get(java.lang.Math.min(i, i2)));
        }
    }

    public final long a(boolean z, long j) {
        if (this.h.size() <= 0) {
            return -1L;
        }
        if (this.f.size() == 0 && z) {
            return 0L;
        }
        return j;
    }

    public final com.anythink.core.common.p.h a() {
        return this.q;
    }

    public final void a(int i) {
        if (this.c == 2 && i == 1) {
            this.n--;
        }
    }

    public final void a(int i, int i2) {
        this.k += i;
        if (i2 != 2) {
            this.l += i;
        } else {
            this.m += i;
        }
    }

    public final void a(com.anythink.core.common.f.au auVar) {
        this.g.add(auVar);
    }

    public final void a(com.anythink.core.common.f.au auVar, int i) {
        synchronized (this.i) {
            java.util.Iterator<com.anythink.core.common.p.e> it = this.i.iterator();
            int i2 = 0;
            while (it.hasNext() && com.anythink.core.common.o.h.a(it.next().a) > com.anythink.core.common.o.h.a(auVar)) {
                i2++;
            }
            this.i.add(i2, new com.anythink.core.common.p.e(auVar, i));
        }
    }

    public final void a(com.anythink.core.common.f.h hVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList(5);
        synchronized (this.t) {
            a(arrayList, this.t);
        }
        synchronized (this.g) {
            a(arrayList, this.g);
        }
        java.util.Iterator<com.anythink.core.common.f.au> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), hVar, false);
        }
    }

    public final void a(java.util.List<com.anythink.core.common.f.au> list) {
        this.g.addAll(list);
    }

    public final com.anythink.core.common.f.au b(boolean z) {
        com.anythink.core.common.f.au a2;
        if (!z || (a2 = this.r.a()) == null) {
            return null;
        }
        if (!a2.k()) {
            a2.toString();
            return null;
        }
        if (a2.aj() == 1) {
            return null;
        }
        double a3 = com.anythink.core.common.o.h.a(a2);
        synchronized (this.g) {
            for (com.anythink.core.common.f.au auVar : this.g) {
                if (com.anythink.core.common.o.h.a(auVar) > a3) {
                    auVar.toString();
                    return null;
                }
            }
            synchronized (this.i) {
                java.util.Iterator<com.anythink.core.common.p.e> it = this.i.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.f.au auVar2 = it.next().a;
                    if (com.anythink.core.common.o.h.a(auVar2) > a3) {
                        auVar2.toString();
                        return null;
                    }
                }
                a2.toString();
                return a2;
            }
        }
    }

    public final com.anythink.core.common.f.p b() {
        return this.r;
    }

    public final java.util.List<com.anythink.core.common.f.au> b(int i) {
        java.util.List<com.anythink.core.common.f.au> list = i != 2 ? this.f : this.h;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() != 0) {
            com.anythink.core.common.f.au auVar = list.get(0);
            if (i == 2) {
                arrayList.add(auVar);
            } else {
                boolean z = com.anythink.core.common.o.h.a(auVar) > a(true);
                int i2 = this.c;
                if (i2 == 1) {
                    if ((this.l < this.d ? 1 : 0) != 0 && z) {
                        arrayList.add(auVar);
                    }
                } else if (i2 == 2 && this.n == 0 && z) {
                    double a2 = com.anythink.core.common.o.h.a(auVar);
                    int size = list.size();
                    while (r3 < size) {
                        com.anythink.core.common.f.au auVar2 = list.get(r3);
                        if (com.anythink.core.common.o.h.a(auVar2) == a2) {
                            arrayList.add(auVar2);
                        }
                        r3++;
                    }
                    this.n = arrayList.size();
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
        return arrayList;
    }

    public final void b(com.anythink.core.common.f.au auVar) {
        this.g.remove(auVar);
    }

    public final synchronized void b(com.anythink.core.common.f.au auVar, int i) {
        java.util.List<com.anythink.core.common.f.au> list = i != 2 ? this.f : this.h;
        synchronized (list) {
            com.anythink.core.common.o.h.a(list, auVar);
        }
    }

    public final void b(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.f.au auVar;
        synchronized (this.f) {
            for (com.anythink.core.common.f.au auVar2 : this.f) {
                if (auVar2 != null && auVar2.k()) {
                    a(auVar2, hVar);
                }
            }
            this.f.clear();
        }
        synchronized (this.i) {
            for (com.anythink.core.common.p.e eVar : this.i) {
                if (eVar != null && (auVar = eVar.a) != null && auVar.k()) {
                    a(eVar.a, hVar);
                }
            }
            this.i.clear();
        }
        synchronized (this.h) {
            this.h.clear();
        }
    }

    public final int c() {
        return this.f.size();
    }

    public final void c(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.p.h hVar = this.q;
        if (hVar != null) {
            hVar.a(auVar);
        }
    }

    public final com.anythink.core.common.f.au d() {
        if (this.f.size() > 0) {
            return this.f.get(0);
        }
        return null;
    }

    public final void d(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.q M;
        if (auVar == null || !auVar.k() || (M = auVar.M()) == null) {
            return;
        }
        M.a(this.r);
    }

    public final int e() {
        return this.g.size();
    }

    public final void e(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.p pVar = this.r;
        if (pVar == null || auVar == null) {
            return;
        }
        com.anythink.core.common.f.au a2 = pVar.a();
        if (a2 == null) {
            this.r.a(auVar);
            return;
        }
        double a3 = com.anythink.core.common.o.h.a(auVar);
        double a4 = com.anythink.core.common.o.h.a(a2);
        if (a3 > a4) {
            this.r.a(auVar);
        } else {
            if (a3 != a4 || auVar.al() >= a2.al()) {
                return;
            }
            this.r.a(auVar);
        }
    }

    public final int f() {
        return this.h.size();
    }

    public final void f(com.anythink.core.common.f.au auVar) {
        synchronized (this.t) {
            if (this.t.size() == 0) {
                this.t.add(auVar);
            } else {
                double a2 = com.anythink.core.common.o.h.a(auVar);
                int i = 0;
                while (true) {
                    if (i >= this.t.size()) {
                        break;
                    }
                    if (a2 > com.anythink.core.common.o.h.a(this.t.get(i))) {
                        this.t.add(i, auVar);
                        break;
                    } else {
                        if (i == this.t.size() - 1) {
                            this.t.add(auVar);
                            break;
                        }
                        i++;
                    }
                }
            }
        }
    }

    public final com.anythink.core.common.f.au g() {
        return this.h.remove(0);
    }

    public final boolean g(com.anythink.core.common.f.au auVar) {
        double d;
        double a2 = com.anythink.core.common.o.h.a(auVar);
        double a3 = a(true);
        synchronized (this.g) {
            java.util.Iterator<com.anythink.core.common.f.au> it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    d = 0.0d;
                    break;
                }
                com.anythink.core.common.f.au next = it.next();
                d = com.anythink.core.common.o.h.a(next);
                if (next.k() && d > com.anythink.core.common.o.h.a(auVar)) {
                    break;
                }
            }
        }
        return a2 > java.lang.Math.max(a3, d);
    }

    public final boolean h() {
        return this.h.size() == 0 && this.f.size() == 0;
    }

    public final void i() {
        this.h.clear();
    }

    public final com.anythink.core.common.f.au j() {
        com.anythink.core.common.f.au auVar;
        com.anythink.core.common.p.e eVar;
        synchronized (this.i) {
            auVar = (this.i.size() <= 0 || (eVar = this.i.get(0)) == null) ? null : eVar.a;
        }
        return auVar;
    }

    public final int k() {
        return this.i.size();
    }

    public final java.util.List<com.anythink.core.common.p.e> l() {
        return this.i;
    }

    public final boolean m() {
        java.util.List<com.anythink.core.common.f.au> list = this.j;
        return list == null || list.size() == 0;
    }

    public final java.util.List<com.anythink.core.common.f.au> n() {
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        arrayList.addAll(this.j);
        this.j.clear();
        return arrayList;
    }

    public final int o() {
        return this.k;
    }

    public final int p() {
        return this.l;
    }

    public final int q() {
        return this.m;
    }

    public final com.anythink.core.common.f.ay r() {
        return this.o;
    }

    public final com.anythink.core.common.f.ap s() {
        return this.p;
    }

    public final com.anythink.core.common.f.p t() {
        return this.f183s;
    }

    public final java.util.List<com.anythink.core.common.f.au> u() {
        java.util.List<com.anythink.core.common.f.au> b;
        int i = this.c;
        if (i == 1) {
            b = new java.util.ArrayList<>();
            int min = java.lang.Math.min(this.d, this.f.size());
            for (int i2 = 0; i2 < min; i2++) {
                b.add(this.f.get(i2));
            }
        } else {
            b = i == 2 ? b(1) : null;
        }
        if (b != null) {
            b.size();
        }
        if (b.size() > 0) {
            this.f.removeAll(b);
        }
        return b;
    }

    public final boolean v() {
        return this.f.size() == 0 && this.h.size() == 0 && this.i.size() == 0 && this.g.size() == 0;
    }
}
