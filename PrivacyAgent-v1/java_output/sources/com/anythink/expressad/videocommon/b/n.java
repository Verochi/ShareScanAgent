package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class n {
    private static final java.lang.String c = "UnitCacheCtroller";
    private com.anythink.expressad.videocommon.d.b f;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.d.b> g;
    private java.util.concurrent.ExecutorService k;
    private java.lang.String m;
    private com.anythink.expressad.videocommon.e.d n;
    private int p;
    private com.anythink.expressad.d.c q;
    private java.util.List<com.anythink.expressad.foundation.d.c> d = new java.util.ArrayList();
    private boolean e = true;
    private com.anythink.expressad.videocommon.b.f h = new com.anythink.expressad.videocommon.b.n.AnonymousClass1();
    private java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> i = new java.util.concurrent.CopyOnWriteArrayList<>();
    private long l = com.anythink.expressad.d.a.b.P;
    private int o = 2;
    com.anythink.expressad.d.c a = null;
    com.anythink.expressad.d.c b = null;
    private android.content.Context j = com.anythink.core.common.b.o.a().f();

    /* renamed from: com.anythink.expressad.videocommon.b.n$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.videocommon.b.f {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j, int i) {
            if (i == 5 || i == 4) {
                com.anythink.expressad.videocommon.b.n.a(com.anythink.expressad.videocommon.b.n.this);
                com.anythink.expressad.videocommon.b.n.this.a();
            }
            if (i == 2) {
                com.anythink.expressad.videocommon.b.n.a(com.anythink.expressad.videocommon.b.n.this);
            }
        }
    }

    /* renamed from: com.anythink.expressad.videocommon.b.n$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.videocommon.d.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass2(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str) {
            com.anythink.expressad.videocommon.d.b bVar;
            if (com.anythink.expressad.videocommon.b.n.this.f != null) {
                com.anythink.expressad.videocommon.b.n.this.f.a(str);
            }
            if (com.anythink.expressad.videocommon.b.n.this.g == null || com.anythink.expressad.videocommon.b.n.this.g.size() <= 0 || this.a == null || (bVar = (com.anythink.expressad.videocommon.d.b) com.anythink.expressad.videocommon.b.n.this.g.get(this.a.Z())) == null) {
                return;
            }
            bVar.a(str);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.d.b bVar;
            com.anythink.expressad.foundation.d.c cVar = this.a;
            if (cVar == null || cVar.aB() == null || this.a.aB().size() <= 0 || !this.a.aB().contains(0)) {
                if (com.anythink.expressad.videocommon.b.n.this.f != null) {
                    com.anythink.expressad.videocommon.b.n.this.f.a(str, str2);
                }
                if (com.anythink.expressad.videocommon.b.n.this.g == null || com.anythink.expressad.videocommon.b.n.this.g.size() <= 0 || this.a == null || (bVar = (com.anythink.expressad.videocommon.d.b) com.anythink.expressad.videocommon.b.n.this.g.get(this.a.Z())) == null) {
                    return;
                }
                bVar.a(str, str2);
            }
        }
    }

    public n(com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.ExecutorService executorService, java.lang.String str, int i) {
        this.p = 1;
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        c(this.d);
    }

    public n(java.util.List<com.anythink.expressad.foundation.d.c> list, java.util.concurrent.ExecutorService executorService, java.lang.String str, int i) {
        this.p = 1;
        java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        c(this.d);
    }

    private static synchronized void a(com.anythink.expressad.videocommon.b.c cVar) {
        synchronized (com.anythink.expressad.videocommon.b.n.class) {
            com.anythink.expressad.foundation.d.c n = cVar != null ? cVar.n() : null;
            if (n == null) {
                return;
            }
            if (n.w() == 94 || n.w() == 287) {
                cVar.a(c(cVar));
            }
        }
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(cVar.ar()) || android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        return com.anythink.expressad.videocommon.b.l.a().d(this.m + "_" + cVar.Z() + "_" + str);
    }

    private static boolean a(com.anythink.expressad.videocommon.b.c cVar, int i) {
        long p = cVar.p();
        long f = cVar.f();
        if (android.text.TextUtils.isEmpty(cVar.a())) {
            return true;
        }
        if (i == 0) {
            if (cVar.n() == null || android.text.TextUtils.isEmpty(cVar.n().S())) {
                return false;
            }
            a(cVar);
            return true;
        }
        if (f <= 0 || p * 100 < f * i) {
            return false;
        }
        a(cVar);
        return true;
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.videocommon.b.n nVar) {
        nVar.e = true;
        return true;
    }

    private static boolean a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
                return true;
            }
            if ((!cVar.j() || com.anythink.expressad.foundation.h.t.f(str)) && !com.anythink.expressad.foundation.h.w.a(str)) {
                return b(str, cVar);
            }
            return true;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private static boolean a(java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList) {
        try {
            java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                if (next != null) {
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it2 = next.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getValue().k() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            return cVar.ao() != -1 ? cVar.ao() : d(cVar);
        }
        return -1;
    }

    private static synchronized java.lang.String b(com.anythink.expressad.videocommon.b.c cVar) {
        java.lang.String c2;
        synchronized (com.anythink.expressad.videocommon.b.n.class) {
            c2 = c(cVar);
        }
        return c2;
    }

    private static boolean b(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        if (cVar.j()) {
            return true;
        }
        if ((cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) && !android.text.TextUtils.isEmpty(str) && cVar.av() == 0) {
            com.anythink.expressad.videocommon.b.i.a().c(str);
            if (com.anythink.expressad.videocommon.b.i.a().c(str) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(com.anythink.expressad.videocommon.b.c cVar, int i) {
        return a(cVar, i);
    }

    private static boolean b(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar.H() || android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        if (cVar.av() != 1 || c(cVar)) {
            return (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) || com.anythink.expressad.foundation.h.w.b(com.anythink.expressad.videocommon.b.i.a().c(str)) || com.anythink.expressad.foundation.h.w.b(com.anythink.expressad.videocommon.b.j.a.a.b(str));
        }
        return true;
    }

    public static boolean b(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        android.graphics.Bitmap a;
        boolean z = true;
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            java.lang.String I = cVar.I();
            java.lang.String S = cVar.S();
            java.lang.String be = cVar.be();
            java.lang.String bd = cVar.bd();
            java.lang.String e = cVar.M() != null ? cVar.M().e() : "";
            cVar.M();
            if (!z || android.text.TextUtils.isEmpty(e) || e.contains(com.anythink.expressad.foundation.d.c.d) || b(cVar, e)) {
                boolean z2 = !cVar.j() || com.anythink.expressad.foundation.h.t.f(I);
                if (!z || !z2 || b(I, cVar)) {
                    if (z && !com.anythink.expressad.foundation.h.w.a(S)) {
                        com.anythink.expressad.videocommon.b.a.a();
                        java.lang.String a2 = com.anythink.expressad.videocommon.b.a.a(S);
                        if (!com.anythink.expressad.foundation.h.w.a(a2)) {
                            if (new java.io.File(a2).length() <= 0) {
                            }
                        }
                    }
                    if (z && !android.text.TextUtils.isEmpty(be) && ((a = com.anythink.expressad.foundation.g.d.a.a(com.anythink.expressad.foundation.h.s.a(be))) == null || a.isRecycled())) {
                        z = false;
                    }
                    if (z) {
                        if (!android.text.TextUtils.isEmpty(bd)) {
                            android.graphics.Bitmap a3 = com.anythink.expressad.foundation.g.d.a.a(com.anythink.expressad.foundation.h.s.a(bd));
                            if (a3 != null && !a3.isRecycled()) {
                            }
                        }
                    }
                }
            }
            z = false;
        }
        return z;
    }

    private static synchronized java.lang.String c(com.anythink.expressad.videocommon.b.c cVar) {
        synchronized (com.anythink.expressad.videocommon.b.n.class) {
            if (cVar == null) {
                return "";
            }
            java.lang.String S = cVar.n().S();
            try {
                if (cVar.k() == 5) {
                    java.lang.String e = cVar.e();
                    if (!com.anythink.expressad.foundation.h.w.a(e)) {
                        if (new java.io.File(e).length() > 0) {
                            S = e;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            return S;
        }
    }

    private void c(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        f();
        e();
        int i = this.p;
        if (i != 1) {
            if (i != 287) {
                if (i == 298) {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.d.c d = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    this.b = d;
                    if (d == null) {
                        com.anythink.expressad.d.b.a();
                        this.b = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    }
                    com.anythink.expressad.d.c cVar = this.b;
                    if (cVar != null) {
                        this.l = cVar.i();
                        this.o = this.b.m();
                    }
                } else if (i != 94) {
                    if (i == 95) {
                        try {
                            if (!android.text.TextUtils.isEmpty(this.m)) {
                                com.anythink.expressad.d.b.a();
                                com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                                if (c2 == null) {
                                    c2 = com.anythink.expressad.d.c.d(this.m);
                                }
                                if (c2 != null) {
                                    this.l = c2.i();
                                    this.o = c2.m();
                                }
                            }
                        } catch (java.lang.Exception unused) {
                            return;
                        }
                    }
                }
            }
            try {
                com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
                if (b == null) {
                    com.anythink.expressad.videocommon.e.c.a();
                    com.anythink.expressad.videocommon.e.c.c();
                }
                if (b != null) {
                    this.l = b.e();
                }
                if (!android.text.TextUtils.isEmpty(this.m)) {
                    this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                }
                com.anythink.expressad.videocommon.e.d dVar = this.n;
                if (dVar != null) {
                    this.o = dVar.F();
                }
            } catch (java.lang.Exception unused2) {
                return;
            }
        } else {
            try {
                if (!android.text.TextUtils.isEmpty(this.m)) {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.d.c c3 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    this.a = c3;
                    if (c3 == null) {
                        this.a = com.anythink.expressad.d.c.c(this.m);
                    }
                    com.anythink.expressad.d.c cVar2 = this.a;
                    if (cVar2 != null) {
                        this.l = cVar2.i();
                        this.o = this.a.m();
                    }
                }
            } catch (java.lang.Exception unused3) {
                return;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.anythink.expressad.foundation.d.c cVar3 = list.get(i2);
            if (cVar3 != null) {
                int i3 = this.p;
                java.lang.String str = (i3 == 94 || i3 == 287) ? cVar3.Z() + cVar3.aZ() + cVar3.S() : cVar3.aZ() + cVar3.S() + cVar3.B();
                if ((c(cVar3) || !android.text.TextUtils.isEmpty(cVar3.S())) && (copyOnWriteArrayList = this.i) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i4 = 0;
                        while (true) {
                            try {
                                if (i4 >= this.i.size()) {
                                    z = false;
                                    break;
                                }
                                java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> map = this.i.get(i4);
                                if (map != null && map.containsKey(str)) {
                                    com.anythink.expressad.videocommon.b.c cVar4 = map.get(str);
                                    cVar4.a(cVar3);
                                    cVar4.a(this.o);
                                    cVar4.a(false);
                                    map.remove(str);
                                    map.put(str, cVar4);
                                    this.i.set(i4, map);
                                    z = true;
                                    break;
                                }
                                i4++;
                            } catch (java.lang.Throwable unused4) {
                            }
                        }
                        if (!z) {
                            com.anythink.expressad.videocommon.b.c cVar5 = new com.anythink.expressad.videocommon.b.c(this.j, cVar3, this.k, this.m);
                            cVar5.a(this.o);
                            cVar5.e(this.p);
                            java.util.HashMap hashMap = new java.util.HashMap();
                            hashMap.put(str, cVar5);
                            this.i.add(hashMap);
                        }
                    }
                }
            }
        }
        java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.d.clear();
    }

    private static boolean c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        try {
            return cVar.J() == 2;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int d(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (cVar.w() == 298) {
                if (this.b == null) {
                    com.anythink.expressad.d.b.a();
                    this.b = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                }
                return this.b.f();
            }
            if (cVar.w() == 42) {
                return h();
            }
            if (this.n == null) {
                this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m, false);
            }
            return this.n.v();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return 100;
        }
    }

    private void e() {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    int i = 0;
                    while (i < this.i.size()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> map = this.i.get(i);
                        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.anythink.expressad.videocommon.b.c value = it.next().getValue();
                            if (value != null) {
                                if (currentTimeMillis - value.c() > this.l * 1000 && value.k() == 1) {
                                    value.j();
                                    value.a(this.o);
                                    this.i.remove(map);
                                    i--;
                                }
                                if (value.k() != 1 && value.k() != 5 && value.k() != 0) {
                                    this.i.remove(map);
                                    i--;
                                }
                            }
                        }
                        i++;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i = 0;
                    while (i < this.i.size()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> map = this.i.get(i);
                        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.anythink.expressad.videocommon.b.c value = it.next().getValue();
                            if (value != null && value.n() != null && value.b() && value.d()) {
                                value.o();
                                this.i.remove(map);
                                i--;
                            }
                        }
                        i++;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static boolean g() {
        return true;
    }

    private int h() {
        try {
            com.anythink.expressad.d.c cVar = this.a;
            if (cVar != null) {
                return cVar.f();
            }
            return 100;
        } catch (java.lang.Exception unused) {
            return 100;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e2 A[Catch: all -> 0x01a4, Exception -> 0x01a6, TRY_ENTER, TryCatch #1 {Exception -> 0x01a6, blocks: (B:5:0x0008, B:6:0x000d, B:8:0x0015, B:9:0x0025, B:11:0x002b, B:13:0x0039, B:15:0x0040, B:17:0x0046, B:20:0x0054, B:27:0x004e, B:30:0x005d, B:32:0x006d, B:33:0x0075, B:38:0x0087, B:40:0x008d, B:42:0x0095, B:45:0x009b, B:47:0x00a1, B:61:0x00a7, B:49:0x00ab, B:51:0x00b3, B:62:0x00bf, B:64:0x00d1, B:71:0x00e2, B:74:0x00e8, B:78:0x00f6, B:84:0x00ff, B:91:0x0109, B:93:0x0114, B:95:0x0122, B:100:0x0137, B:102:0x013b, B:104:0x0141, B:114:0x0155, B:116:0x015b, B:118:0x015f, B:120:0x0169, B:123:0x016f, B:126:0x0173, B:130:0x017d, B:132:0x0187, B:137:0x018f), top: B:4:0x0008, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.expressad.videocommon.b.c a(int i, boolean z) {
        long j;
        int k;
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        com.anythink.expressad.videocommon.b.c cVar = null;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                int i2 = 0;
                while (i2 < this.i.size()) {
                    java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> map = this.i.get(i2);
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        com.anythink.expressad.videocommon.b.c value = it.next().getValue();
                        if (value != null && value.n() != null) {
                            com.anythink.expressad.foundation.d.c n = value.n();
                            if ((!z || n.A()) && (z || !n.A())) {
                                java.lang.String I = n.I();
                                java.lang.String S = n.S();
                                java.lang.String e = n.M() != null ? n.M().e() : "";
                                n.M();
                                if (this.p != 94) {
                                    if (i == 287) {
                                    }
                                    boolean isEmpty = android.text.TextUtils.isEmpty(value.m());
                                    k = value.k();
                                    if (this.p != 298 && a(value, b(n))) {
                                        return value;
                                    }
                                    if (k == 5) {
                                        long c2 = value.c();
                                        if (value.k() == 1) {
                                            j = currentTimeMillis;
                                            if (currentTimeMillis - c2 > this.l * 1000) {
                                                value.j();
                                                this.i.remove(map);
                                                i2--;
                                                int i3 = this.p;
                                                if (i3 != 1) {
                                                    if (i3 == 94) {
                                                    }
                                                }
                                                currentTimeMillis = j;
                                                cVar = null;
                                            }
                                        } else {
                                            j = currentTimeMillis;
                                        }
                                        if (this.p == 95) {
                                            if (!value.b()) {
                                                return value;
                                            }
                                            value.o();
                                            this.i.remove(map);
                                        } else if (k == 4 || k == 2) {
                                            this.i.remove(map);
                                        } else {
                                            if (k == 1) {
                                                if (!value.b()) {
                                                    if (!com.anythink.expressad.a.p && a(value, b(n)) && a(I, n)) {
                                                        boolean z2 = com.anythink.expressad.a.a;
                                                        return value;
                                                    }
                                                }
                                                currentTimeMillis = j;
                                                cVar = null;
                                            }
                                            int i4 = this.p;
                                            if ((i4 == 94 || i4 == 287) && a(value, b(n)) && a(I, n)) {
                                                return value;
                                            }
                                            currentTimeMillis = j;
                                            cVar = null;
                                        }
                                        i2--;
                                        currentTimeMillis = j;
                                        cVar = null;
                                    } else if (value.b()) {
                                        value.o();
                                        this.i.remove(map);
                                        i2--;
                                    } else {
                                        if (isEmpty) {
                                            return a(I, n) ? value : cVar;
                                        }
                                        value.l();
                                        if (this.p == 95) {
                                            return value;
                                        }
                                        j = currentTimeMillis;
                                        currentTimeMillis = j;
                                        cVar = null;
                                    }
                                }
                                if (android.text.TextUtils.isEmpty(e) || e.contains(com.anythink.expressad.foundation.d.c.d) || b(n, e)) {
                                    if (b(I, n)) {
                                        if (value.b()) {
                                            value.o();
                                        } else {
                                            if (com.anythink.expressad.foundation.h.w.a(S)) {
                                                return value;
                                            }
                                            if (a(value, b(n))) {
                                                return value;
                                            }
                                        }
                                    }
                                    boolean isEmpty2 = android.text.TextUtils.isEmpty(value.m());
                                    k = value.k();
                                    if (this.p != 298) {
                                    }
                                    if (k == 5) {
                                    }
                                }
                                j = currentTimeMillis;
                                currentTimeMillis = j;
                                cVar = null;
                            } else {
                                n.A();
                            }
                        }
                        j = currentTimeMillis;
                        currentTimeMillis = j;
                        cVar = null;
                    }
                    i2++;
                    cVar = null;
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public final com.anythink.expressad.videocommon.b.c a(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                while (it.hasNext()) {
                    java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                    if (next != null && next.containsKey(str)) {
                        return next.get(str);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            return null;
        }
    }

    public final java.util.List<com.anythink.expressad.videocommon.b.c> a(boolean z, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    int i = 0;
                    while (i < this.i.size()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> map = this.i.get(i);
                        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.anythink.expressad.videocommon.b.c value = it.next().getValue();
                            if (value != null && value.n() != null) {
                                com.anythink.expressad.foundation.d.c n = value.n();
                                boolean z2 = false;
                                for (com.anythink.expressad.foundation.d.c cVar : list) {
                                    if (n != null && cVar != null && !android.text.TextUtils.isEmpty(n.Z()) && !android.text.TextUtils.isEmpty(cVar.Z()) && n.aZ().equals(cVar.aZ()) && n.Z().equals(cVar.Z())) {
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    continue;
                                } else if ((!z || n.A()) && (z || !n.A())) {
                                    java.lang.String I = n.I();
                                    java.lang.String S = n.S();
                                    java.lang.String e = n.M() != null ? n.M().e() : "";
                                    n.M();
                                    if (android.text.TextUtils.isEmpty(e) || e.contains(com.anythink.expressad.foundation.d.c.d) || b(n, e)) {
                                        if (b(I, n)) {
                                            if (value.b()) {
                                                value.o();
                                            } else if (com.anythink.expressad.foundation.h.w.a(S)) {
                                                arrayList.add(value);
                                            } else if (a(value, b(n))) {
                                                arrayList.add(value);
                                            }
                                        }
                                        boolean isEmpty = android.text.TextUtils.isEmpty(value.m());
                                        int k = value.k();
                                        if (k != 5) {
                                            long c2 = value.c();
                                            if (value.k() != 1 || currentTimeMillis - c2 <= this.l * 1000) {
                                                if (k != 4 && k != 2) {
                                                    if (k == 1) {
                                                        if (!value.b()) {
                                                            if (!com.anythink.expressad.a.p && a(value, b(n)) && a(I, n)) {
                                                                boolean z3 = com.anythink.expressad.a.a;
                                                                arrayList.add(value);
                                                            }
                                                        }
                                                    }
                                                    if (a(value, b(n)) && a(I, n)) {
                                                        arrayList.add(value);
                                                    }
                                                }
                                                this.i.remove(map);
                                            } else {
                                                value.j();
                                                this.i.remove(map);
                                            }
                                            i--;
                                        } else if (value.b()) {
                                            value.o();
                                            this.i.remove(map);
                                            i--;
                                        } else if (!isEmpty) {
                                            value.l();
                                        } else {
                                            if (!a(I, n)) {
                                                return null;
                                            }
                                            arrayList.add(value);
                                        }
                                    }
                                } else {
                                    n.A();
                                }
                            }
                        }
                        i++;
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0031 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4 A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x0029, B:15:0x0031, B:17:0x0037, B:20:0x0045, B:23:0x004b, B:25:0x0051, B:26:0x0053, B:28:0x006b, B:30:0x006f, B:31:0x0077, B:32:0x007b, B:38:0x008f, B:40:0x0093, B:41:0x00a6, B:43:0x00aa, B:44:0x00b0, B:46:0x00b4, B:48:0x00b8, B:49:0x00cb, B:51:0x00cf, B:52:0x00fd, B:54:0x0102, B:55:0x0108, B:57:0x0115, B:59:0x0119, B:62:0x0121, B:63:0x0128, B:65:0x012c, B:67:0x0132, B:69:0x0140, B:80:0x0152, B:83:0x0156, B:96:0x0161, B:100:0x0167, B:86:0x016c, B:91:0x0179, B:94:0x0176, B:111:0x00d4, B:113:0x00d8, B:116:0x00ed, B:118:0x00f3, B:120:0x00f7, B:128:0x017e), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0102 A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x0029, B:15:0x0031, B:17:0x0037, B:20:0x0045, B:23:0x004b, B:25:0x0051, B:26:0x0053, B:28:0x006b, B:30:0x006f, B:31:0x0077, B:32:0x007b, B:38:0x008f, B:40:0x0093, B:41:0x00a6, B:43:0x00aa, B:44:0x00b0, B:46:0x00b4, B:48:0x00b8, B:49:0x00cb, B:51:0x00cf, B:52:0x00fd, B:54:0x0102, B:55:0x0108, B:57:0x0115, B:59:0x0119, B:62:0x0121, B:63:0x0128, B:65:0x012c, B:67:0x0132, B:69:0x0140, B:80:0x0152, B:83:0x0156, B:96:0x0161, B:100:0x0167, B:86:0x016c, B:91:0x0179, B:94:0x0176, B:111:0x00d4, B:113:0x00d8, B:116:0x00ed, B:118:0x00f3, B:120:0x00f7, B:128:0x017e), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115 A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x0029, B:15:0x0031, B:17:0x0037, B:20:0x0045, B:23:0x004b, B:25:0x0051, B:26:0x0053, B:28:0x006b, B:30:0x006f, B:31:0x0077, B:32:0x007b, B:38:0x008f, B:40:0x0093, B:41:0x00a6, B:43:0x00aa, B:44:0x00b0, B:46:0x00b4, B:48:0x00b8, B:49:0x00cb, B:51:0x00cf, B:52:0x00fd, B:54:0x0102, B:55:0x0108, B:57:0x0115, B:59:0x0119, B:62:0x0121, B:63:0x0128, B:65:0x012c, B:67:0x0132, B:69:0x0140, B:80:0x0152, B:83:0x0156, B:96:0x0161, B:100:0x0167, B:86:0x016c, B:91:0x0179, B:94:0x0176, B:111:0x00d4, B:113:0x00d8, B:116:0x00ed, B:118:0x00f3, B:120:0x00f7, B:128:0x017e), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0161 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int x;
        com.anythink.expressad.videocommon.d.b bVar;
        int i;
        e();
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                if (!a(this.i)) {
                    this.e = true;
                }
                java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                while (it.hasNext()) {
                    java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                    if (next != null) {
                        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it2 = next.entrySet().iterator();
                        while (it2.hasNext()) {
                            com.anythink.expressad.videocommon.b.c value = it2.next().getValue();
                            if (value != null && !value.b()) {
                                if (this.p == 95) {
                                    this.e = true;
                                }
                                int k = value.k();
                                com.anythink.expressad.foundation.d.c n = value.n();
                                value.a(new com.anythink.expressad.videocommon.b.n.AnonymousClass2(n));
                                int b = b(n);
                                if (this.p == 1) {
                                    if (this.a == null) {
                                        this.a = com.anythink.expressad.d.c.c(this.m);
                                    }
                                    b = h();
                                }
                                value.d(b);
                                int i2 = this.p;
                                if (i2 != 94 && i2 != 287 && i2 != 95) {
                                    if (i2 == 298) {
                                        if (this.b == null) {
                                            com.anythink.expressad.d.b.a();
                                            this.b = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                                        }
                                        com.anythink.expressad.d.c cVar = this.b;
                                        if (cVar != null) {
                                            x = cVar.g();
                                            if (this.p == 1) {
                                                if (this.a == null) {
                                                    com.anythink.expressad.d.b.a();
                                                    this.a = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                                                }
                                                com.anythink.expressad.d.c cVar2 = this.a;
                                                if (cVar2 != null) {
                                                    x = cVar2.g();
                                                }
                                            }
                                            value.b(x);
                                            value.c(n != null ? n.aC() : 1);
                                            if (a(value, b(n))) {
                                                com.anythink.expressad.videocommon.d.b bVar2 = this.f;
                                                if (bVar2 != null && ((i = this.p) == 297 || i == 298)) {
                                                    bVar2.a(n.S());
                                                }
                                                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.d.b> concurrentHashMap = this.g;
                                                if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (bVar = this.g.get(n.Z())) != null) {
                                                    bVar.a(n.S());
                                                }
                                            }
                                            if (k == 1 && k != 5 && k != 4 && (k == 2 || this.e)) {
                                                value.a(this.h);
                                                if (a(value, b)) {
                                                    int i3 = this.p;
                                                    if (i3 == 1 || i3 == 95 || i3 == 298) {
                                                        this.e = false;
                                                    }
                                                    value.h();
                                                } else {
                                                    int i4 = this.p;
                                                    if (i4 == 94 || i4 == 287) {
                                                        value.h();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    x = 0;
                                    if (this.p == 1) {
                                    }
                                    value.b(x);
                                    value.c(n != null ? n.aC() : 1);
                                    if (a(value, b(n))) {
                                    }
                                    if (k == 1) {
                                        value.a(this.h);
                                        if (a(value, b)) {
                                        }
                                    }
                                }
                                if (this.n == null) {
                                    this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m, this.p == 287);
                                }
                                com.anythink.expressad.videocommon.e.d dVar = this.n;
                                x = dVar != null ? dVar.x() : 0;
                                value.b(x);
                                value.c(n != null ? n.aC() : 1);
                                if (a(value, b(n))) {
                                }
                                if (k == 1) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        c(this.d);
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.f = bVar;
    }

    public final void a(java.lang.String str, com.anythink.expressad.videocommon.d.b bVar) {
        if (this.g == null) {
            this.g = new java.util.concurrent.ConcurrentHashMap<>();
        }
        this.g.put(str, bVar);
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        c(this.d);
    }

    public final com.anythink.expressad.videocommon.b.c b(int i, boolean z) {
        try {
            return a(i, z);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final void b() {
        int k;
        try {
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
            if (copyOnWriteArrayList != null) {
                synchronized (copyOnWriteArrayList) {
                    java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                        if (next != null) {
                            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it2 = next.entrySet().iterator();
                            while (it2.hasNext()) {
                                com.anythink.expressad.videocommon.b.c value = it2.next().getValue();
                                if (value != null && (k = value.k()) != 1 && k != 5) {
                                    if (com.anythink.expressad.foundation.h.k.a() != 9 && this.o == 2) {
                                        return;
                                    }
                                    if (k == 2 || k == 0) {
                                        value.h();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void b(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList;
        try {
            synchronized (this.i) {
                if (!android.text.TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.i) != null && copyOnWriteArrayList.size() > 0) {
                    java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                        if (next != null) {
                            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c> entry : next.entrySet()) {
                                if (entry != null && android.text.TextUtils.equals(entry.getKey(), str)) {
                                    this.i.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public final void c() {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                        if (next != null) {
                            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it2 = next.entrySet().iterator();
                            while (it2.hasNext()) {
                                com.anythink.expressad.videocommon.b.c value = it2.next().getValue();
                                if (value != null && value.k() == 1) {
                                    value.j();
                                    this.i.remove(next);
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public final void d() {
        java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    java.util.Iterator<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c> next = it.next();
                        if (next == null) {
                            return;
                        }
                        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.c>> it2 = next.entrySet().iterator();
                        while (it2.hasNext()) {
                            com.anythink.expressad.videocommon.b.c value = it2.next().getValue();
                            if (value != null) {
                                value.o();
                            }
                        }
                    }
                    this.i.clear();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.clear();
    }
}
