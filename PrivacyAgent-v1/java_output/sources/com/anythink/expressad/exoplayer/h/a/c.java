package com.anythink.expressad.exoplayer.h.a;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.exoplayer.h.f<com.anythink.expressad.exoplayer.h.s.a> {
    private static final java.lang.String a = "AdsMediaSource";
    private final com.anythink.expressad.exoplayer.h.s b;
    private final com.anythink.expressad.exoplayer.h.a.c.e c;
    private final com.anythink.expressad.exoplayer.h.a.b d;
    private final android.view.ViewGroup e;

    @androidx.annotation.Nullable
    private final android.os.Handler f;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.h.a.c.d g;
    private final android.os.Handler h;
    private final java.util.Map<com.anythink.expressad.exoplayer.h.s, java.util.List<com.anythink.expressad.exoplayer.h.l>> i;
    private final com.anythink.expressad.exoplayer.ae.a j;
    private com.anythink.expressad.exoplayer.h.a.c.C0197c k;
    private com.anythink.expressad.exoplayer.ae l;
    private java.lang.Object m;
    private com.anythink.expressad.exoplayer.h.a.a n;
    private com.anythink.expressad.exoplayer.h.s[][] o;
    private long[][] p;

    /* renamed from: com.anythink.expressad.exoplayer.h.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.exoplayer.h a;
        final /* synthetic */ com.anythink.expressad.exoplayer.h.a.c.C0197c b;

        public AnonymousClass1(com.anythink.expressad.exoplayer.h hVar, com.anythink.expressad.exoplayer.h.a.c.C0197c c0197c) {
            this.a = hVar;
            this.b = c0197c;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.exoplayer.h.a.b unused = com.anythink.expressad.exoplayer.h.a.c.this.d;
            android.view.ViewGroup unused2 = com.anythink.expressad.exoplayer.h.a.c.this.e;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.h.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.exoplayer.h.a.b unused = com.anythink.expressad.exoplayer.h.a.c.this.d;
        }
    }

    public static final class a extends java.io.IOException {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public final int e;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$a$a, reason: collision with other inner class name */
        public @interface InterfaceC0196a {
        }

        private a(int i, java.lang.Exception exc) {
            super(exc);
            this.e = i;
        }

        public static com.anythink.expressad.exoplayer.h.a.c.a a(java.lang.Exception exc) {
            return new com.anythink.expressad.exoplayer.h.a.c.a(0, exc);
        }

        private static com.anythink.expressad.exoplayer.h.a.c.a a(java.lang.Exception exc, int i) {
            return new com.anythink.expressad.exoplayer.h.a.c.a(1, new java.io.IOException("Failed to load ad group ".concat(java.lang.String.valueOf(i)), exc));
        }

        private static com.anythink.expressad.exoplayer.h.a.c.a a(java.lang.RuntimeException runtimeException) {
            return new com.anythink.expressad.exoplayer.h.a.c.a(3, runtimeException);
        }

        private java.lang.RuntimeException a() {
            com.anythink.expressad.exoplayer.k.a.b(this.e == 3);
            return (java.lang.RuntimeException) getCause();
        }

        private static com.anythink.expressad.exoplayer.h.a.c.a b(java.lang.Exception exc) {
            return new com.anythink.expressad.exoplayer.h.a.c.a(2, exc);
        }
    }

    public final class b implements com.anythink.expressad.exoplayer.h.l.a {
        private final android.net.Uri b;
        private final int c;
        private final int d;

        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$b$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.IOException a;

            public AnonymousClass1(java.io.IOException iOException) {
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.h.a.b unused = com.anythink.expressad.exoplayer.h.a.c.this.d;
                int unused2 = com.anythink.expressad.exoplayer.h.a.c.b.this.c;
                int unused3 = com.anythink.expressad.exoplayer.h.a.c.b.this.d;
            }
        }

        public b(android.net.Uri uri, int i, int i2) {
            this.b = uri;
            this.c = i;
            this.d = i2;
        }

        @Override // com.anythink.expressad.exoplayer.h.l.a
        public final void a(com.anythink.expressad.exoplayer.h.s.a aVar, java.io.IOException iOException) {
            com.anythink.expressad.exoplayer.h.a.c.this.a(aVar).a(new com.anythink.expressad.exoplayer.j.k(this.b), com.anythink.expressad.exoplayer.h.a.c.a.a(iOException));
            com.anythink.expressad.exoplayer.h.a.c.this.h.post(new com.anythink.expressad.exoplayer.h.a.c.b.AnonymousClass1(iOException));
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c, reason: collision with other inner class name */
    public final class C0197c implements com.anythink.expressad.exoplayer.h.a.b.a {
        private final android.os.Handler b = new android.os.Handler();
        private volatile boolean c;

        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.h.a.a a;

            public AnonymousClass1(com.anythink.expressad.exoplayer.h.a.a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.exoplayer.h.a.c.C0197c.this.c) {
                    return;
                }
                com.anythink.expressad.exoplayer.h.a.c.a(com.anythink.expressad.exoplayer.h.a.c.this, this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.exoplayer.h.a.c.C0197c.this.c) {
                    return;
                }
                com.anythink.expressad.exoplayer.h.a.c.d unused = com.anythink.expressad.exoplayer.h.a.c.this.g;
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.exoplayer.h.a.c.C0197c.this.c) {
                    return;
                }
                com.anythink.expressad.exoplayer.h.a.c.d unused = com.anythink.expressad.exoplayer.h.a.c.this.g;
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.h.a.c.a a;

            public AnonymousClass4(com.anythink.expressad.exoplayer.h.a.c.a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.exoplayer.h.a.c.C0197c.this.c) {
                    return;
                }
                if (this.a.e != 3) {
                    com.anythink.expressad.exoplayer.h.a.c.d unused = com.anythink.expressad.exoplayer.h.a.c.this.g;
                    return;
                }
                com.anythink.expressad.exoplayer.h.a.c.d unused2 = com.anythink.expressad.exoplayer.h.a.c.this.g;
                com.anythink.expressad.exoplayer.h.a.c.a aVar = this.a;
                com.anythink.expressad.exoplayer.k.a.b(aVar.e == 3);
                aVar.getCause();
            }
        }

        public C0197c() {
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a() {
            if (this.c || com.anythink.expressad.exoplayer.h.a.c.this.f == null || com.anythink.expressad.exoplayer.h.a.c.this.g == null) {
                return;
            }
            com.anythink.expressad.exoplayer.h.a.c.this.f.post(new com.anythink.expressad.exoplayer.h.a.c.C0197c.AnonymousClass2());
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(com.anythink.expressad.exoplayer.h.a.a aVar) {
            if (this.c) {
                return;
            }
            this.b.post(new com.anythink.expressad.exoplayer.h.a.c.C0197c.AnonymousClass1(aVar));
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(com.anythink.expressad.exoplayer.h.a.c.a aVar, com.anythink.expressad.exoplayer.j.k kVar) {
            if (this.c) {
                return;
            }
            com.anythink.expressad.exoplayer.h.a.c.this.a((com.anythink.expressad.exoplayer.h.s.a) null).a(kVar, aVar);
            if (com.anythink.expressad.exoplayer.h.a.c.this.f == null || com.anythink.expressad.exoplayer.h.a.c.this.g == null) {
                return;
            }
            com.anythink.expressad.exoplayer.h.a.c.this.f.post(new com.anythink.expressad.exoplayer.h.a.c.C0197c.AnonymousClass4(aVar));
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void b() {
            if (this.c || com.anythink.expressad.exoplayer.h.a.c.this.f == null || com.anythink.expressad.exoplayer.h.a.c.this.g == null) {
                return;
            }
            com.anythink.expressad.exoplayer.h.a.c.this.f.post(new com.anythink.expressad.exoplayer.h.a.c.C0197c.AnonymousClass3());
        }

        public final void c() {
            this.c = true;
            this.b.removeCallbacksAndMessages(null);
        }
    }

    @java.lang.Deprecated
    public interface d {
        void a();

        void b();

        void c();

        void d();
    }

    public interface e {
        int[] a();

        com.anythink.expressad.exoplayer.h.s b(android.net.Uri uri);
    }

    private c(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.h.a.c.e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, android.view.ViewGroup viewGroup) {
        this(sVar, eVar, bVar, viewGroup, (android.os.Handler) null, (com.anythink.expressad.exoplayer.h.a.c.d) null);
    }

    @java.lang.Deprecated
    private c(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.h.a.c.e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.a.c.d dVar) {
        this.b = sVar;
        this.c = eVar;
        this.d = bVar;
        this.e = viewGroup;
        this.f = handler;
        this.g = dVar;
        this.h = new android.os.Handler(android.os.Looper.getMainLooper());
        this.i = new java.util.HashMap();
        this.j = new com.anythink.expressad.exoplayer.ae.a();
        this.o = new com.anythink.expressad.exoplayer.h.s[0][];
        this.p = new long[0][];
    }

    private c(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, android.view.ViewGroup viewGroup) {
        this(sVar, new com.anythink.expressad.exoplayer.h.o.c(aVar), bVar, viewGroup, (android.os.Handler) null, (com.anythink.expressad.exoplayer.h.a.c.d) null);
    }

    @java.lang.Deprecated
    private c(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.a.c.d dVar) {
        this(sVar, new com.anythink.expressad.exoplayer.h.o.c(aVar), bVar, viewGroup, handler, dVar);
    }

    @androidx.annotation.Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static com.anythink.expressad.exoplayer.h.s.a a2(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.s.a aVar2) {
        return aVar.a() ? aVar : aVar2;
    }

    private void a(com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (this.n == null) {
            com.anythink.expressad.exoplayer.h.s[][] sVarArr = new com.anythink.expressad.exoplayer.h.s[aVar.g][];
            this.o = sVarArr;
            java.util.Arrays.fill(sVarArr, new com.anythink.expressad.exoplayer.h.s[0]);
            long[][] jArr = new long[aVar.g][];
            this.p = jArr;
            java.util.Arrays.fill(jArr, new long[0]);
        }
        this.n = aVar;
        c();
    }

    public static /* synthetic */ void a(com.anythink.expressad.exoplayer.h.a.c cVar, com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (cVar.n == null) {
            com.anythink.expressad.exoplayer.h.s[][] sVarArr = new com.anythink.expressad.exoplayer.h.s[aVar.g][];
            cVar.o = sVarArr;
            java.util.Arrays.fill(sVarArr, new com.anythink.expressad.exoplayer.h.s[0]);
            long[][] jArr = new long[aVar.g][];
            cVar.p = jArr;
            java.util.Arrays.fill(jArr, new long[0]);
        }
        cVar.n = aVar;
        cVar.c();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        if (!aVar.a()) {
            this.l = aeVar;
            this.m = obj;
            c();
            return;
        }
        int i = aVar.b;
        int i2 = aVar.c;
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            java.util.List<com.anythink.expressad.exoplayer.h.l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }

    private void a(com.anythink.expressad.exoplayer.h.s sVar, int i, int i2, com.anythink.expressad.exoplayer.ae aeVar) {
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            java.util.List<com.anythink.expressad.exoplayer.h.l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, java.lang.Object obj) {
        this.l = aeVar;
        this.m = obj;
        c();
    }

    private void c() {
        com.anythink.expressad.exoplayer.h.a.a aVar = this.n;
        if (aVar == null || this.l == null) {
            return;
        }
        com.anythink.expressad.exoplayer.h.a.a a2 = aVar.a(this.p);
        this.n = a2;
        a(a2.g == 0 ? this.l : new com.anythink.expressad.exoplayer.h.a.d(this.l, this.n), this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        if (this.n.g <= 0 || !aVar.a()) {
            com.anythink.expressad.exoplayer.h.l lVar = new com.anythink.expressad.exoplayer.h.l(this.b, aVar, bVar);
            lVar.f();
            return lVar;
        }
        int i = aVar.b;
        int i2 = aVar.c;
        android.net.Uri uri = this.n.i[i].b[i2];
        if (this.o[i].length <= i2) {
            com.anythink.expressad.exoplayer.h.s b2 = this.c.b(uri);
            com.anythink.expressad.exoplayer.h.s[][] sVarArr = this.o;
            com.anythink.expressad.exoplayer.h.s[] sVarArr2 = sVarArr[i];
            int length = sVarArr2.length;
            if (i2 >= length) {
                int i3 = i2 + 1;
                sVarArr[i] = (com.anythink.expressad.exoplayer.h.s[]) java.util.Arrays.copyOf(sVarArr2, i3);
                long[][] jArr = this.p;
                jArr[i] = java.util.Arrays.copyOf(jArr[i], i3);
                java.util.Arrays.fill(this.p[i], length, i3, -9223372036854775807L);
            }
            this.o[i][i2] = b2;
            this.i.put(b2, new java.util.ArrayList());
            a((com.anythink.expressad.exoplayer.h.a.c) aVar, b2);
        }
        com.anythink.expressad.exoplayer.h.s sVar = this.o[i][i2];
        com.anythink.expressad.exoplayer.h.l lVar2 = new com.anythink.expressad.exoplayer.h.l(sVar, new com.anythink.expressad.exoplayer.h.s.a(0, aVar.d), bVar);
        lVar2.a(new com.anythink.expressad.exoplayer.h.a.c.b(uri, i, i2));
        java.util.List<com.anythink.expressad.exoplayer.h.l> list = this.i.get(sVar);
        if (list == null) {
            lVar2.f();
        } else {
            list.add(lVar2);
        }
        return lVar2;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    @androidx.annotation.Nullable
    public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.h.s.a a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.s.a aVar2) {
        com.anythink.expressad.exoplayer.h.s.a aVar3 = aVar;
        return aVar3.a() ? aVar3 : aVar2;
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.k.c();
        this.k = null;
        this.i.clear();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new com.anythink.expressad.exoplayer.h.s[0][];
        this.p = new long[0][];
        this.h.post(new com.anythink.expressad.exoplayer.h.a.c.AnonymousClass2());
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        com.anythink.expressad.exoplayer.h.l lVar = (com.anythink.expressad.exoplayer.h.l) rVar;
        java.util.List<com.anythink.expressad.exoplayer.h.l> list = this.i.get(lVar.a);
        if (list != null) {
            list.remove(lVar);
        }
        lVar.g();
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        com.anythink.expressad.exoplayer.k.a.a(z);
        com.anythink.expressad.exoplayer.h.a.c.C0197c c0197c = new com.anythink.expressad.exoplayer.h.a.c.C0197c();
        this.k = c0197c;
        a((com.anythink.expressad.exoplayer.h.a.c) new com.anythink.expressad.exoplayer.h.s.a(0), this.b);
        this.h.post(new com.anythink.expressad.exoplayer.h.a.c.AnonymousClass1(hVar, c0197c));
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        com.anythink.expressad.exoplayer.h.s.a aVar2 = aVar;
        if (!aVar2.a()) {
            this.l = aeVar;
            this.m = obj;
            c();
            return;
        }
        int i = aVar2.b;
        int i2 = aVar2.c;
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            java.util.List<com.anythink.expressad.exoplayer.h.l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }
}
