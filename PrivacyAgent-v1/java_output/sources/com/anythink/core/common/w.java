package com.anythink.core.common;

/* loaded from: classes12.dex */
public class w {
    private static final java.lang.String a = "w";
    private static volatile com.anythink.core.common.w u;
    private volatile android.os.Handler d;
    private com.anythink.core.common.l.d e;
    private java.util.List<com.anythink.core.common.l.e> f;
    private java.util.Set<java.lang.String> h;
    private java.util.List<com.anythink.core.common.l.e> i;
    private java.util.Map<java.lang.String, com.anythink.core.common.l.b> j;
    private java.util.Map<java.lang.String, com.anythink.core.common.w.a> k;
    private int l;
    private com.anythink.core.api.ATSharedPlacementConfig m;
    private final java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final int n = 0;
    private final int o = 1;
    private final int p = 2;
    private final int q = 3;
    private int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private long f186s = -1;
    private final int t = 30000;
    private android.content.Context b = com.anythink.core.common.b.o.a().f();
    private final java.util.Map<java.lang.String, com.anythink.core.common.l.e> g = new java.util.concurrent.ConcurrentHashMap(5);

    /* renamed from: com.anythink.core.common.w$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.l.d a;

        public AnonymousClass1(com.anythink.core.common.l.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.w.this.b(this.a);
        }
    }

    /* renamed from: com.anythink.core.common.w$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.common.w.this.i != null && com.anythink.core.common.w.this.i.size() != 0) {
                com.anythink.core.common.w.this.e();
            } else {
                java.lang.String unused = com.anythink.core.common.w.a;
                com.anythink.core.common.w.c(com.anythink.core.common.w.this);
            }
        }
    }

    /* renamed from: com.anythink.core.common.w$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!com.anythink.core.common.w.this.c(this.a)) {
                java.lang.String unused = com.anythink.core.common.w.a;
                return;
            }
            java.lang.String unused2 = com.anythink.core.common.w.a;
            com.anythink.core.common.w.this.a((com.anythink.core.common.l.e) com.anythink.core.common.w.this.g.get(this.a), 6);
        }
    }

    /* renamed from: com.anythink.core.common.w$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass4(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (android.text.TextUtils.isEmpty(this.a)) {
                return;
            }
            if (com.anythink.core.common.w.this.r != 3) {
                java.lang.String unused = com.anythink.core.common.w.a;
                int unused2 = com.anythink.core.common.w.this.r;
            } else if (com.anythink.core.common.w.this.k != null && com.anythink.core.common.w.this.k.get(this.a) != null) {
                java.lang.String unused3 = com.anythink.core.common.w.a;
            } else {
                java.lang.String unused4 = com.anythink.core.common.w.a;
                com.anythink.core.common.w.this.d(this.a);
            }
        }
    }

    /* renamed from: com.anythink.core.common.w$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.l.e a;
        final /* synthetic */ int b;
        final /* synthetic */ com.anythink.core.common.l.b c;

        /* renamed from: com.anythink.core.common.w$5$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.common.l.c {

            /* renamed from: com.anythink.core.common.w$5$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC01731 implements java.lang.Runnable {
                final /* synthetic */ java.lang.String a;
                final /* synthetic */ com.anythink.core.common.l.e b;

                public RunnableC01731(java.lang.String str, com.anythink.core.common.l.e eVar) {
                    this.a = str;
                    this.b = eVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.w.this.a(this.a, this.b);
                }
            }

            /* renamed from: com.anythink.core.common.w$5$1$2, reason: invalid class name */
            public class AnonymousClass2 implements java.lang.Runnable {
                final /* synthetic */ java.lang.String a;
                final /* synthetic */ com.anythink.core.common.l.e b;
                final /* synthetic */ com.anythink.core.api.AdError c;

                public AnonymousClass2(java.lang.String str, com.anythink.core.common.l.e eVar, com.anythink.core.api.AdError adError) {
                    this.a = str;
                    this.b = eVar;
                    this.c = adError;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.w.this.a(this.a, this.b, this.c);
                }
            }

            /* renamed from: com.anythink.core.common.w$5$1$3, reason: invalid class name */
            public class AnonymousClass3 implements java.lang.Runnable {
                final /* synthetic */ java.lang.String a;
                final /* synthetic */ com.anythink.core.common.l.e b;

                public AnonymousClass3(java.lang.String str, com.anythink.core.common.l.e eVar) {
                    this.a = str;
                    this.b = eVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.w.this.b(this.a, this.b);
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.anythink.core.common.l.c
            public final void a(java.lang.String str, com.anythink.core.common.l.e eVar) {
                synchronized (com.anythink.core.common.w.this) {
                    com.anythink.core.common.w.this.d().post(new com.anythink.core.common.w.AnonymousClass5.AnonymousClass1.RunnableC01731(str, eVar));
                }
            }

            @Override // com.anythink.core.common.l.c
            public final void a(java.lang.String str, com.anythink.core.common.l.e eVar, com.anythink.core.api.AdError adError) {
                synchronized (com.anythink.core.common.w.this) {
                    com.anythink.core.common.w.this.d().post(new com.anythink.core.common.w.AnonymousClass5.AnonymousClass1.AnonymousClass2(str, eVar, adError));
                }
            }

            @Override // com.anythink.core.common.l.c
            public final void b(java.lang.String str, com.anythink.core.common.l.e eVar) {
                synchronized (com.anythink.core.common.w.this) {
                    com.anythink.core.common.w.this.d().post(new com.anythink.core.common.w.AnonymousClass5.AnonymousClass1.AnonymousClass3(str, eVar));
                }
            }
        }

        public AnonymousClass5(com.anythink.core.common.l.e eVar, int i, com.anythink.core.common.l.b bVar) {
            this.a = eVar;
            this.b = i;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a(this.a, this.b);
            if (this.b == 10) {
                aVar.a();
                aVar.a(com.anythink.core.common.w.this.e.c());
            }
            aVar.a(new com.anythink.core.common.w.AnonymousClass5.AnonymousClass1());
            this.c.a(aVar);
            this.c.c();
        }
    }

    public class a implements java.lang.Runnable {
        java.lang.String a;

        public a(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.common.w.this) {
                if (com.anythink.core.common.w.this.c(this.a)) {
                    com.anythink.core.common.w.this.a((com.anythink.core.common.l.e) com.anythink.core.common.w.this.g.get(this.a), 11);
                }
            }
        }
    }

    private w() {
    }

    public static com.anythink.core.common.f a(java.lang.String str, java.lang.String str2) {
        return com.anythink.core.common.u.a().a(str, str2);
    }

    public static com.anythink.core.common.w a() {
        if (u == null) {
            synchronized (com.anythink.core.common.w.class) {
                if (u == null) {
                    u = new com.anythink.core.common.w();
                }
            }
        }
        return u;
    }

    private java.util.List<com.anythink.core.common.l.e> a(java.util.List<com.anythink.core.common.l.e> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        int min = java.lang.Math.min(this.e.b(), list.size());
        for (int i = 0; i < min; i++) {
            arrayList.add(list.get(i));
            list.get(i).toString();
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    private void a(com.anythink.core.common.l.b bVar) {
        if (bVar.d() == 10 && bVar.b()) {
            this.l--;
            if (this.l >= this.e.b()) {
                return;
            }
            if (this.i.size() > 0) {
                com.anythink.core.common.l.e remove = this.i.remove(0);
                remove.toString();
                a(remove, 10);
            } else if (this.l == 0) {
                this.r = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.l.e eVar, int i) {
        if (eVar == null) {
            return;
        }
        eVar.toString();
        e(eVar.b);
        if (i == 10) {
            this.l++;
            eVar.toString();
            if (this.h == null) {
                this.h = java.util.Collections.synchronizedSet(new java.util.HashSet());
            }
            this.h.add(eVar.b);
        }
        com.anythink.core.common.l.b bVar = new com.anythink.core.common.l.b(eVar.b);
        if (this.j == null) {
            this.j = new java.util.concurrent.ConcurrentHashMap();
        }
        this.j.put(bVar.a(), bVar);
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.w.AnonymousClass5(eVar, i, bVar), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, com.anythink.core.common.l.e eVar) {
        java.util.List<com.anythink.core.api.ATAdInfo> a2;
        eVar.toString();
        com.anythink.core.common.l.b remove = this.j.remove(str);
        if (remove == null) {
            return;
        }
        eVar.toString();
        java.lang.String str2 = eVar.b;
        com.anythink.core.common.f a3 = c(str2) ? a(str2, java.lang.String.valueOf(eVar.a)) : null;
        boolean z = false;
        if (a3 == null) {
            eVar.toString();
        } else {
            int i = eVar.d;
            double d = eVar.e;
            if (i > 0 && (a2 = a3.a(this.b)) != null && a2.size() < i) {
                a2.size();
                eVar.toString();
                z = true;
            }
            if (!z) {
                if (d > 0.0d) {
                    com.anythink.core.common.f.b a4 = a3.a(this.b, false, false, (java.util.Map<java.lang.String, java.lang.Object>) new java.util.HashMap(), (com.anythink.core.common.f.c) null);
                    if (a4 != null && a4.m() < d) {
                        a4.m();
                        eVar.toString();
                    }
                }
            }
            z = true;
        }
        if (z) {
            d(remove.e());
        }
        a(remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, com.anythink.core.common.l.e eVar, com.anythink.core.api.AdError adError) {
        eVar.toString();
        adError.getFullErrorInfo();
        com.anythink.core.common.l.b remove = this.j.remove(str);
        if (remove == null) {
            return;
        }
        d(remove.e());
        a(remove);
    }

    private boolean a(com.anythink.core.common.l.e eVar) {
        java.util.List<com.anythink.core.api.ATAdInfo> a2;
        eVar.toString();
        java.lang.String str = eVar.b;
        com.anythink.core.common.f a3 = c(str) ? a(str, java.lang.String.valueOf(eVar.a)) : null;
        boolean z = false;
        if (a3 == null) {
            eVar.toString();
            return false;
        }
        int i = eVar.d;
        double d = eVar.e;
        if (i > 0 && (a2 = a3.a(this.b)) != null && a2.size() < i) {
            a2.size();
            eVar.toString();
            z = true;
        }
        if (z) {
            return true;
        }
        if (d > 0.0d) {
            com.anythink.core.common.f.b a4 = a3.a(this.b, false, false, (java.util.Map<java.lang.String, java.lang.Object>) new java.util.HashMap(), (com.anythink.core.common.f.c) null);
            if (a4 != null && a4.m() < d) {
                a4.m();
                eVar.toString();
                return true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.anythink.core.common.l.d dVar) {
        this.e = dVar;
        synchronized (this.g) {
            this.g.clear();
            this.g.putAll(dVar.d());
        }
        this.f = dVar.e();
        if (this.r == 0) {
            this.r = 1;
            this.i = java.util.Collections.synchronizedList(new java.util.ArrayList());
            for (com.anythink.core.common.l.e eVar : this.f) {
                this.i.add(eVar);
                b(eVar.b, java.lang.String.valueOf(eVar.a));
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j = this.f186s;
            d().postDelayed(new com.anythink.core.common.w.AnonymousClass2(), elapsedRealtime < j ? j - android.os.SystemClock.elapsedRealtime() : 0L);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList();
        java.util.Iterator<com.anythink.core.common.l.e> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b);
        }
        java.util.Set<java.lang.String> set = this.h;
        if (set != null) {
            arrayList2.addAll(set);
        }
        if (arrayList2.size() > 0) {
            arrayList2.removeAll(arrayList);
        }
        java.util.Set<java.lang.String> set2 = this.h;
        if (set2 != null) {
            arrayList.removeAll(set2);
        }
        if (arrayList.size() > 0) {
            this.i = java.util.Collections.synchronizedList(new java.util.ArrayList());
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.anythink.core.common.l.e eVar2 = this.g.get((java.lang.String) it2.next());
                b(eVar2.b, java.lang.String.valueOf(eVar2.a));
                if (this.r == 3) {
                    a(eVar2, 10);
                } else {
                    eVar2.toString();
                    this.i.add(eVar2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            for (java.lang.String str : arrayList2) {
                e(str);
                this.h.remove(str);
            }
        }
    }

    private void b(com.anythink.core.common.l.e eVar) {
        a(eVar, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(java.lang.String str, com.anythink.core.common.l.e eVar) {
        eVar.toString();
        com.anythink.core.common.l.b bVar = this.j.get(str);
        if (bVar == null) {
            return;
        }
        a(bVar);
    }

    private void b(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.u.a().a(str, false);
        c(str, str2);
    }

    public static /* synthetic */ int c(com.anythink.core.common.w wVar) {
        wVar.r = 3;
        return 3;
    }

    private void c(com.anythink.core.common.l.e eVar) {
        a(eVar, 6);
    }

    private void c(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, java.lang.Object> nativeLocalExtra;
        if (this.m == null) {
            return;
        }
        str2.hashCode();
        switch (str2) {
            case "0":
                nativeLocalExtra = this.m.getNativeLocalExtra();
                break;
            case "1":
                nativeLocalExtra = this.m.getRewardVideoLocalExtra();
                break;
            case "2":
                nativeLocalExtra = this.m.getBannerLocalExtra();
                break;
            case "3":
                nativeLocalExtra = this.m.getInterstitialLocalExtra();
                break;
            case "4":
                nativeLocalExtra = this.m.getSplashLocalExtra();
                break;
            default:
                nativeLocalExtra = null;
                break;
        }
        if (nativeLocalExtra != null) {
            nativeLocalExtra.toString();
        }
        com.anythink.core.common.u.a().a(str, nativeLocalExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.os.Handler d() {
        if (this.d == null) {
            synchronized (com.anythink.core.common.w.class) {
                if (this.d == null) {
                    this.d = com.anythink.core.common.o.b.b.a().a(15);
                }
            }
        }
        return this.d;
    }

    private com.anythink.core.common.f d(java.lang.String str, java.lang.String str2) {
        if (c(str)) {
            return a(str, str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(java.lang.String str) {
        com.anythink.core.common.l.e eVar;
        if (c(str) && (eVar = this.g.get(str)) != null) {
            if (this.k == null) {
                this.k = new java.util.concurrent.ConcurrentHashMap(5);
            }
            int i = eVar.c;
            if (i < 30000) {
                i = 30000;
            }
            com.anythink.core.common.w.a aVar = new com.anythink.core.common.w.a(str);
            this.k.put(str, aVar);
            d().postDelayed(aVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        this.r = 2;
        java.util.List<com.anythink.core.common.l.e> list = this.i;
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        int min = java.lang.Math.min(this.e.b(), list.size());
        for (int i = 0; i < min; i++) {
            arrayList.add(list.get(i));
            list.get(i).toString();
        }
        list.removeAll(arrayList);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((com.anythink.core.common.l.e) it.next(), 10);
        }
    }

    private void e(java.lang.String str) {
        java.util.Map<java.lang.String, com.anythink.core.common.w.a> map;
        com.anythink.core.common.w.a remove;
        if (android.text.TextUtils.isEmpty(str) || (map = this.k) == null || (remove = map.remove(str)) == null) {
            return;
        }
        d().removeCallbacks(remove);
    }

    public final synchronized void a(com.anythink.core.api.ATSharedPlacementConfig aTSharedPlacementConfig) {
        if (aTSharedPlacementConfig == null) {
            com.anythink.core.api.ATSDK.isNetworkLogDebug();
            return;
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            new java.lang.StringBuilder("setSharedPlacementConfig: ").append(aTSharedPlacementConfig.toString());
        }
        this.m = aTSharedPlacementConfig;
        java.util.List<com.anythink.core.common.l.e> list = this.f;
        if (list != null) {
            for (com.anythink.core.common.l.e eVar : list) {
                c(eVar.b, java.lang.String.valueOf(eVar.a));
            }
        }
    }

    public final synchronized void a(com.anythink.core.common.l.d dVar) {
        this.c.set(dVar.e().size() != 0);
        if (this.r == 0) {
            if (this.f186s == -1) {
                this.f186s = android.os.SystemClock.elapsedRealtime() + dVar.a();
                dVar.a();
            }
            if (!this.c.get()) {
                return;
            }
        }
        d().post(new com.anythink.core.common.w.AnonymousClass1(dVar));
    }

    public final synchronized void a(java.lang.String str) {
        d().post(new com.anythink.core.common.w.AnonymousClass3(str));
    }

    public final boolean a(com.anythink.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        return c(eVar.j());
    }

    public final synchronized void b(java.lang.String str) {
        d().post(new com.anythink.core.common.w.AnonymousClass4(str));
    }

    public final boolean b() {
        return this.c.get();
    }

    public final boolean c(java.lang.String str) {
        try {
            if (!this.c.get() || com.anythink.core.common.b.o.a().v() || android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return this.g.containsKey(str);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
