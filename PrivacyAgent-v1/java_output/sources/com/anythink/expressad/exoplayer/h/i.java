package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class i extends com.anythink.expressad.exoplayer.h.f<com.anythink.expressad.exoplayer.h.i.e> implements com.anythink.expressad.exoplayer.x.b {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private final java.util.List<com.anythink.expressad.exoplayer.h.i.e> h;
    private final java.util.List<com.anythink.expressad.exoplayer.h.i.e> i;
    private final com.anythink.expressad.exoplayer.h.i.e j;
    private final java.util.Map<com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.i.e> k;
    private final java.util.List<com.anythink.expressad.exoplayer.h.i.d> l;
    private final boolean m;
    private final com.anythink.expressad.exoplayer.ae.b n;
    private com.anythink.expressad.exoplayer.h o;
    private boolean p;
    private com.anythink.expressad.exoplayer.h.aa q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f221s;

    public static final class a extends com.anythink.expressad.exoplayer.h.a {
        private final int b;
        private final int c;
        private final int[] d;
        private final int[] e;
        private final com.anythink.expressad.exoplayer.ae[] f;
        private final java.lang.Object[] g;
        private final java.util.HashMap<java.lang.Object, java.lang.Integer> h;

        public a(java.util.Collection<com.anythink.expressad.exoplayer.h.i.e> collection, int i, int i2, com.anythink.expressad.exoplayer.h.aa aaVar, boolean z) {
            super(z, aaVar);
            this.b = i;
            this.c = i2;
            int size = collection.size();
            this.d = new int[size];
            this.e = new int[size];
            this.f = new com.anythink.expressad.exoplayer.ae[size];
            this.g = new java.lang.Object[size];
            this.h = new java.util.HashMap<>();
            int i3 = 0;
            for (com.anythink.expressad.exoplayer.h.i.e eVar : collection) {
                this.f[i3] = eVar.c;
                this.d[i3] = eVar.f;
                this.e[i3] = eVar.e;
                java.lang.Object[] objArr = this.g;
                java.lang.Object obj = eVar.b;
                objArr[i3] = obj;
                this.h.put(obj, java.lang.Integer.valueOf(i3));
                i3++;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int a(int i) {
            return com.anythink.expressad.exoplayer.k.af.a(this.d, i + 1);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int b(int i) {
            return com.anythink.expressad.exoplayer.k.af.a(this.e, i + 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int b(java.lang.Object obj) {
            java.lang.Integer num = this.h.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.c;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final com.anythink.expressad.exoplayer.ae c(int i) {
            return this.f[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int d(int i) {
            return this.d[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int e(int i) {
            return this.e[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final java.lang.Object f(int i) {
            return this.g[i];
        }
    }

    public static final class b extends com.anythink.expressad.exoplayer.h.p {
        private static final java.lang.Object c = new java.lang.Object();
        private static final com.anythink.expressad.exoplayer.ae.a d = new com.anythink.expressad.exoplayer.ae.a();
        private static final com.anythink.expressad.exoplayer.h.i.c e = new com.anythink.expressad.exoplayer.h.i.c((byte) 0);
        private final java.lang.Object f;

        public b() {
            this(e, null);
        }

        private b(com.anythink.expressad.exoplayer.ae aeVar, java.lang.Object obj) {
            super(aeVar);
            this.f = obj;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(java.lang.Object obj) {
            com.anythink.expressad.exoplayer.ae aeVar = this.b;
            if (c.equals(obj)) {
                obj = this.f;
            }
            return aeVar.a(obj);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
            this.b.a(i, aVar, z);
            if (com.anythink.expressad.exoplayer.k.af.a(aVar.b, this.f)) {
                aVar.b = c;
            }
            return aVar;
        }

        public final com.anythink.expressad.exoplayer.h.i.b a(com.anythink.expressad.exoplayer.ae aeVar) {
            return new com.anythink.expressad.exoplayer.h.i.b(aeVar, (this.f != null || aeVar.c() <= 0) ? this.f : aeVar.a(0, d, true).b);
        }

        public final com.anythink.expressad.exoplayer.ae d() {
            return this.b;
        }
    }

    public static final class c extends com.anythink.expressad.exoplayer.ae {
        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int a(java.lang.Object obj) {
            return obj == null ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
            return aVar.a(null, null, -9223372036854775807L, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
            return bVar.a(null, -9223372036854775807L, -9223372036854775807L, false, true, j > 0 ? -9223372036854775807L : 0L, -9223372036854775807L, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return 1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return 1;
        }
    }

    public static final class d {
        public final android.os.Handler a;
        public final java.lang.Runnable b;

        public d(java.lang.Runnable runnable) {
            this.b = runnable;
            this.a = new android.os.Handler(android.os.Looper.myLooper() != null ? android.os.Looper.myLooper() : android.os.Looper.getMainLooper());
        }

        private void a() {
            this.a.post(this.b);
        }
    }

    public static final class e implements java.lang.Comparable<com.anythink.expressad.exoplayer.h.i.e> {
        public final com.anythink.expressad.exoplayer.h.s a;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public com.anythink.expressad.exoplayer.h.i.b c = new com.anythink.expressad.exoplayer.h.i.b();
        public java.util.List<com.anythink.expressad.exoplayer.h.l> i = new java.util.ArrayList();
        public final java.lang.Object b = new java.lang.Object();

        public e(com.anythink.expressad.exoplayer.h.s sVar) {
            this.a = sVar;
        }

        private int a(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.h.i.e eVar) {
            return this.f - eVar.f;
        }

        public final void a(int i, int i2, int i3) {
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = false;
            this.h = false;
            this.i.clear();
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.h.i.e eVar) {
            return this.f - eVar.f;
        }
    }

    public static final class f<T> {
        public final int a;
        public final T b;

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.h.i.d c;

        public f(int i, T t, @androidx.annotation.Nullable java.lang.Runnable runnable) {
            this.a = i;
            this.c = runnable != null ? new com.anythink.expressad.exoplayer.h.i.d(runnable) : null;
            this.b = t;
        }
    }

    public i() {
        this(false, (com.anythink.expressad.exoplayer.h.aa) new com.anythink.expressad.exoplayer.h.aa.a());
    }

    private i(boolean z) {
        this(z, new com.anythink.expressad.exoplayer.h.aa.a());
    }

    private i(boolean z, com.anythink.expressad.exoplayer.h.aa aaVar) {
        this(z, aaVar, new com.anythink.expressad.exoplayer.h.s[0]);
    }

    private i(boolean z, com.anythink.expressad.exoplayer.h.aa aaVar, com.anythink.expressad.exoplayer.h.s... sVarArr) {
        for (com.anythink.expressad.exoplayer.h.s sVar : sVarArr) {
            com.anythink.expressad.exoplayer.k.a.a(sVar);
        }
        this.q = aaVar.a() > 0 ? aaVar.d() : aaVar;
        this.k = new java.util.IdentityHashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.h = arrayList;
        this.i = new java.util.ArrayList();
        this.l = new java.util.ArrayList();
        this.j = new com.anythink.expressad.exoplayer.h.i.e(null);
        this.m = z;
        this.n = new com.anythink.expressad.exoplayer.ae.b();
        a(arrayList.size(), java.util.Arrays.asList(sVarArr), (java.lang.Runnable) null);
    }

    private i(com.anythink.expressad.exoplayer.h.s... sVarArr) {
        this(sVarArr, (byte) 0);
    }

    private i(com.anythink.expressad.exoplayer.h.s[] sVarArr, byte b2) {
        this(false, new com.anythink.expressad.exoplayer.h.aa.a(), sVarArr);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.anythink.expressad.exoplayer.h.i.e eVar, int i) {
        return i + eVar.e;
    }

    @androidx.annotation.Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static com.anythink.expressad.exoplayer.h.s.a a2(com.anythink.expressad.exoplayer.h.i.e eVar, com.anythink.expressad.exoplayer.h.s.a aVar) {
        for (int i = 0; i < eVar.i.size(); i++) {
            if (eVar.i.get(i).b.d == aVar.d) {
                return aVar.a(aVar.a + eVar.f);
            }
        }
        return null;
    }

    private void a(int i) {
        this.h.remove(i);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(2).a(new com.anythink.expressad.exoplayer.h.i.f(i, null, null)).i();
        }
    }

    private void a(int i, int i2) {
        if (i != i2) {
            java.util.List<com.anythink.expressad.exoplayer.h.i.e> list = this.h;
            list.add(i2, list.remove(i));
            com.anythink.expressad.exoplayer.h hVar = this.o;
            if (hVar != null) {
                hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(3).a(new com.anythink.expressad.exoplayer.h.i.f(i, java.lang.Integer.valueOf(i2), null)).i();
            }
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.r += i3;
        this.f221s += i4;
        while (i < this.i.size()) {
            this.i.get(i).d += i2;
            this.i.get(i).e += i3;
            this.i.get(i).f += i4;
            i++;
        }
    }

    private void a(int i, int i2, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        if (i == i2) {
            return;
        }
        java.util.List<com.anythink.expressad.exoplayer.h.i.e> list = this.h;
        list.add(i2, list.remove(i));
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(3).a(new com.anythink.expressad.exoplayer.h.i.f(i, java.lang.Integer.valueOf(i2), runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, com.anythink.expressad.exoplayer.h.i.e eVar) {
        if (i > 0) {
            com.anythink.expressad.exoplayer.h.i.e eVar2 = this.i.get(i - 1);
            eVar.a(i, eVar2.e + eVar2.c.b(), eVar2.f + eVar2.c.c());
        } else {
            eVar.a(i, 0, 0);
        }
        a(i, 1, eVar.c.b(), eVar.c.c());
        this.i.add(i, eVar);
        a((com.anythink.expressad.exoplayer.h.i) eVar, eVar.a);
    }

    private void a(int i, com.anythink.expressad.exoplayer.h.s sVar) {
        a(i, sVar, (java.lang.Runnable) null);
    }

    private void a(int i, com.anythink.expressad.exoplayer.h.s sVar, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        com.anythink.expressad.exoplayer.k.a.a(sVar);
        com.anythink.expressad.exoplayer.h.i.e eVar = new com.anythink.expressad.exoplayer.h.i.e(sVar);
        this.h.add(i, eVar);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(0).a(new com.anythink.expressad.exoplayer.h.i.f(i, eVar, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.h.remove(i);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(2).a(new com.anythink.expressad.exoplayer.h.i.f(i, null, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, java.util.Collection<com.anythink.expressad.exoplayer.h.s> collection) {
        a(i, collection, (java.lang.Runnable) null);
    }

    private void a(int i, java.util.Collection<com.anythink.expressad.exoplayer.h.s> collection, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        java.util.Iterator<com.anythink.expressad.exoplayer.h.s> it = collection.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.exoplayer.k.a.a(it.next());
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<com.anythink.expressad.exoplayer.h.s> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new com.anythink.expressad.exoplayer.h.i.e(it2.next()));
        }
        this.h.addAll(i, arrayList);
        if (this.o != null && !collection.isEmpty()) {
            this.o.a((com.anythink.expressad.exoplayer.x.b) this).a(1).a(new com.anythink.expressad.exoplayer.h.i.f(i, arrayList, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.i.d dVar) {
        if (!this.p) {
            this.o.a((com.anythink.expressad.exoplayer.x.b) this).a(5).i();
            this.p = true;
        }
        if (dVar != null) {
            this.l.add(dVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.h.i.e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new java.lang.IllegalArgumentException();
        }
        com.anythink.expressad.exoplayer.h.i.b bVar = eVar.c;
        if (bVar.d() != aeVar) {
            int b2 = aeVar.b() - bVar.b();
            int c2 = aeVar.c() - bVar.c();
            if (b2 != 0 || c2 != 0) {
                a(eVar.d + 1, 0, b2, c2);
            }
            eVar.c = bVar.a(aeVar);
            if (!eVar.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                com.anythink.expressad.exoplayer.ae.b bVar2 = this.n;
                long j = bVar2.j + bVar2.h;
                for (int i = 0; i < eVar.i.size(); i++) {
                    com.anythink.expressad.exoplayer.h.l lVar = eVar.i.get(i);
                    lVar.d(j);
                    lVar.f();
                }
                eVar.g = true;
            }
            a((com.anythink.expressad.exoplayer.h.i.d) null);
        }
    }

    private void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(this.h.size(), sVar, (java.lang.Runnable) null);
    }

    private void a(com.anythink.expressad.exoplayer.h.s sVar, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        a(this.h.size(), sVar, runnable);
    }

    private void a(@androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(4).a(runnable != null ? new com.anythink.expressad.exoplayer.h.i.d(runnable) : null).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(java.util.Collection<com.anythink.expressad.exoplayer.h.s> collection) {
        a(this.h.size(), collection, (java.lang.Runnable) null);
    }

    private void a(java.util.Collection<com.anythink.expressad.exoplayer.h.s> collection, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        a(this.h.size(), collection, runnable);
    }

    private com.anythink.expressad.exoplayer.h.s b(int i) {
        return this.h.get(i).a;
    }

    private void b(int i, int i2) {
        int min = java.lang.Math.min(i, i2);
        int max = java.lang.Math.max(i, i2);
        int i3 = this.i.get(min).e;
        int i4 = this.i.get(min).f;
        java.util.List<com.anythink.expressad.exoplayer.h.i.e> list = this.i;
        list.add(i2, list.remove(i));
        while (min <= max) {
            com.anythink.expressad.exoplayer.h.i.e eVar = this.i.get(min);
            eVar.e = i3;
            eVar.f = i4;
            i3 += eVar.c.b();
            i4 += eVar.c.c();
            min++;
        }
    }

    private void b(int i, java.util.Collection<com.anythink.expressad.exoplayer.h.i.e> collection) {
        java.util.Iterator<com.anythink.expressad.exoplayer.h.i.e> it = collection.iterator();
        while (it.hasNext()) {
            a(i, it.next());
            i++;
        }
    }

    private void b(com.anythink.expressad.exoplayer.h.i.e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new java.lang.IllegalArgumentException();
        }
        com.anythink.expressad.exoplayer.h.i.b bVar = eVar.c;
        if (bVar.d() == aeVar) {
            return;
        }
        int b2 = aeVar.b() - bVar.b();
        int c2 = aeVar.c() - bVar.c();
        if (b2 != 0 || c2 != 0) {
            a(eVar.d + 1, 0, b2, c2);
        }
        eVar.c = bVar.a(aeVar);
        if (!eVar.g && !aeVar.a()) {
            aeVar.a(0, this.n, false);
            com.anythink.expressad.exoplayer.ae.b bVar2 = this.n;
            long j = bVar2.j + bVar2.h;
            for (int i = 0; i < eVar.i.size(); i++) {
                com.anythink.expressad.exoplayer.h.l lVar = eVar.i.get(i);
                lVar.d(j);
                lVar.f();
            }
            eVar.g = true;
        }
        a((com.anythink.expressad.exoplayer.h.i.d) null);
    }

    private void c() {
        this.h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.expressad.exoplayer.x.b) this).a(4).a((java.lang.Object) null).i();
        }
    }

    private void c(int i) {
        com.anythink.expressad.exoplayer.h.i.e remove = this.i.remove(i);
        com.anythink.expressad.exoplayer.h.i.b bVar = remove.c;
        a(i, -1, -bVar.b(), -bVar.c());
        remove.h = true;
        if (remove.i.isEmpty()) {
            a((com.anythink.expressad.exoplayer.h.i) remove);
        }
    }

    private int d() {
        return this.h.size();
    }

    private int d(int i) {
        com.anythink.expressad.exoplayer.h.i.e eVar = this.j;
        eVar.f = i;
        int binarySearch = java.util.Collections.binarySearch(this.i, eVar);
        if (binarySearch < 0) {
            return (-binarySearch) - 2;
        }
        while (binarySearch < this.i.size() - 1) {
            int i2 = binarySearch + 1;
            if (this.i.get(i2).f != i) {
                break;
            }
            binarySearch = i2;
        }
        return binarySearch;
    }

    private void e() {
        this.p = false;
        java.util.List emptyList = this.l.isEmpty() ? java.util.Collections.emptyList() : new java.util.ArrayList(this.l);
        this.l.clear();
        a(new com.anythink.expressad.exoplayer.h.i.a(this.i, this.r, this.f221s, this.q, this.m), (java.lang.Object) null);
        if (emptyList.isEmpty()) {
            return;
        }
        this.o.a((com.anythink.expressad.exoplayer.x.b) this).a(6).a(emptyList).i();
    }

    private void f() {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            c(size);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* bridge */ /* synthetic */ int a(com.anythink.expressad.exoplayer.h.i.e eVar, int i) {
        return i + eVar.e;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        int i;
        int i2 = aVar.a;
        com.anythink.expressad.exoplayer.h.i.e eVar = this.j;
        eVar.f = i2;
        int binarySearch = java.util.Collections.binarySearch(this.i, eVar);
        if (binarySearch < 0) {
            i = (-binarySearch) - 2;
        } else {
            while (binarySearch < this.i.size() - 1) {
                int i3 = binarySearch + 1;
                if (this.i.get(i3).f != i2) {
                    break;
                }
                binarySearch = i3;
            }
            i = binarySearch;
        }
        com.anythink.expressad.exoplayer.h.i.e eVar2 = this.i.get(i);
        com.anythink.expressad.exoplayer.h.l lVar = new com.anythink.expressad.exoplayer.h.l(eVar2.a, aVar.a(aVar.a - eVar2.f), bVar);
        this.k.put(lVar, eVar2);
        eVar2.i.add(lVar);
        if (eVar2.g) {
            lVar.f();
        }
        return lVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    @androidx.annotation.Nullable
    public final /* synthetic */ com.anythink.expressad.exoplayer.h.s.a a(com.anythink.expressad.exoplayer.h.i.e eVar, com.anythink.expressad.exoplayer.h.s.a aVar) {
        com.anythink.expressad.exoplayer.h.i.e eVar2 = eVar;
        for (int i = 0; i < eVar2.i.size(); i++) {
            if (eVar2.i.get(i).b.d == aVar.d) {
                return aVar.a(aVar.a + eVar2.f);
            }
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.i.clear();
        this.o = null;
        this.q = this.q.d();
        this.r = 0;
        this.f221s = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.exoplayer.x.b
    public final void a(int i, java.lang.Object obj) {
        switch (i) {
            case 0:
                com.anythink.expressad.exoplayer.h.i.f fVar = (com.anythink.expressad.exoplayer.h.i.f) obj;
                this.q = this.q.a(fVar.a, 1);
                a(fVar.a, (com.anythink.expressad.exoplayer.h.i.e) fVar.b);
                a(fVar.c);
                return;
            case 1:
                com.anythink.expressad.exoplayer.h.i.f fVar2 = (com.anythink.expressad.exoplayer.h.i.f) obj;
                this.q = this.q.a(fVar2.a, ((java.util.Collection) fVar2.b).size());
                b(fVar2.a, (java.util.Collection<com.anythink.expressad.exoplayer.h.i.e>) fVar2.b);
                a(fVar2.c);
                return;
            case 2:
                com.anythink.expressad.exoplayer.h.i.f fVar3 = (com.anythink.expressad.exoplayer.h.i.f) obj;
                this.q = this.q.c(fVar3.a);
                c(fVar3.a);
                a(fVar3.c);
                return;
            case 3:
                com.anythink.expressad.exoplayer.h.i.f fVar4 = (com.anythink.expressad.exoplayer.h.i.f) obj;
                com.anythink.expressad.exoplayer.h.aa c2 = this.q.c(fVar4.a);
                this.q = c2;
                this.q = c2.a(((java.lang.Integer) fVar4.b).intValue(), 1);
                int i2 = fVar4.a;
                int intValue = ((java.lang.Integer) fVar4.b).intValue();
                int min = java.lang.Math.min(i2, intValue);
                int max = java.lang.Math.max(i2, intValue);
                int i3 = this.i.get(min).e;
                int i4 = this.i.get(min).f;
                java.util.List<com.anythink.expressad.exoplayer.h.i.e> list = this.i;
                list.add(intValue, list.remove(i2));
                while (min <= max) {
                    com.anythink.expressad.exoplayer.h.i.e eVar = this.i.get(min);
                    eVar.e = i3;
                    eVar.f = i4;
                    i3 += eVar.c.b();
                    i4 += eVar.c.c();
                    min++;
                }
                a(fVar4.c);
                return;
            case 4:
                for (int size = this.i.size() - 1; size >= 0; size--) {
                    c(size);
                }
                a((com.anythink.expressad.exoplayer.h.i.d) obj);
                return;
            case 5:
                e();
                return;
            case 6:
                java.util.List list2 = (java.util.List) obj;
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    com.anythink.expressad.exoplayer.h.i.d dVar = (com.anythink.expressad.exoplayer.h.i.d) list2.get(i5);
                    dVar.a.post(dVar.b);
                }
                return;
            default:
                throw new java.lang.IllegalStateException();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        com.anythink.expressad.exoplayer.h.i.e remove = this.k.remove(rVar);
        ((com.anythink.expressad.exoplayer.h.l) rVar).g();
        remove.i.remove(rVar);
        if (remove.i.isEmpty() && remove.h) {
            a((com.anythink.expressad.exoplayer.h.i) remove);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        this.o = hVar;
        if (this.h.isEmpty()) {
            e();
            return;
        }
        this.q = this.q.a(0, this.h.size());
        b(0, this.h);
        a((com.anythink.expressad.exoplayer.h.i.d) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.i.e eVar, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        com.anythink.expressad.exoplayer.h.i.e eVar2 = eVar;
        if (eVar2 == null) {
            throw new java.lang.IllegalArgumentException();
        }
        com.anythink.expressad.exoplayer.h.i.b bVar = eVar2.c;
        if (bVar.d() != aeVar) {
            int b2 = aeVar.b() - bVar.b();
            int c2 = aeVar.c() - bVar.c();
            if (b2 != 0 || c2 != 0) {
                a(eVar2.d + 1, 0, b2, c2);
            }
            eVar2.c = bVar.a(aeVar);
            if (!eVar2.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                com.anythink.expressad.exoplayer.ae.b bVar2 = this.n;
                long j = bVar2.j + bVar2.h;
                for (int i = 0; i < eVar2.i.size(); i++) {
                    com.anythink.expressad.exoplayer.h.l lVar = eVar2.i.get(i);
                    lVar.d(j);
                    lVar.f();
                }
                eVar2.g = true;
            }
            a((com.anythink.expressad.exoplayer.h.i.d) null);
        }
    }
}
