package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public abstract class f<T> extends com.anythink.expressad.exoplayer.h.c {
    private final java.util.HashMap<T, com.anythink.expressad.exoplayer.h.f.b> a = new java.util.HashMap<>();
    private com.anythink.expressad.exoplayer.h b;
    private android.os.Handler c;

    /* renamed from: com.anythink.expressad.exoplayer.h.f$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.h.s.b {
        final /* synthetic */ java.lang.Object a;

        public AnonymousClass1(java.lang.Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.anythink.expressad.exoplayer.h.s.b
        public final void a(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
            com.anythink.expressad.exoplayer.h.f.this.a(this.a, sVar, aeVar, obj);
        }
    }

    public final class a implements com.anythink.expressad.exoplayer.h.t {

        @androidx.annotation.Nullable
        private final T b;
        private com.anythink.expressad.exoplayer.h.t.a c;

        public a(@androidx.annotation.Nullable T t) {
            this.c = com.anythink.expressad.exoplayer.h.f.this.a((com.anythink.expressad.exoplayer.h.s.a) null);
            this.b = t;
        }

        private com.anythink.expressad.exoplayer.h.t.c a(com.anythink.expressad.exoplayer.h.t.c cVar) {
            long a = com.anythink.expressad.exoplayer.h.f.this.a(cVar.f);
            long a2 = com.anythink.expressad.exoplayer.h.f.this.a(cVar.g);
            return (a == cVar.f && a2 == cVar.g) ? cVar : new com.anythink.expressad.exoplayer.h.t.c(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, a, a2);
        }

        private boolean d(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar) {
            com.anythink.expressad.exoplayer.h.s.a aVar2;
            if (aVar != null) {
                aVar2 = com.anythink.expressad.exoplayer.h.f.this.a((com.anythink.expressad.exoplayer.h.f) this.b, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int a = com.anythink.expressad.exoplayer.h.f.this.a((com.anythink.expressad.exoplayer.h.f) this.b, i);
            com.anythink.expressad.exoplayer.h.t.a aVar3 = this.c;
            if (aVar3.a == a && com.anythink.expressad.exoplayer.k.af.a(aVar3.b, aVar2)) {
                return true;
            }
            this.c = com.anythink.expressad.exoplayer.h.f.this.a(a, aVar2);
            return true;
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            if (d(i, aVar)) {
                this.c.a();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
            if (d(i, aVar)) {
                this.c.a(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar, java.io.IOException iOException, boolean z) {
            if (d(i, aVar)) {
                this.c.a(bVar, a(cVar), iOException, z);
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
            if (d(i, aVar)) {
                this.c.a(a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            if (d(i, aVar)) {
                this.c.b();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
            if (d(i, aVar)) {
                this.c.b(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
            if (d(i, aVar)) {
                this.c.b(a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            if (d(i, aVar)) {
                this.c.c();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
            if (d(i, aVar)) {
                this.c.c(bVar, a(cVar));
            }
        }
    }

    public static final class b {
        public final com.anythink.expressad.exoplayer.h.s a;
        public final com.anythink.expressad.exoplayer.h.s.b b;
        public final com.anythink.expressad.exoplayer.h.t c;

        public b(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.h.s.b bVar, com.anythink.expressad.exoplayer.h.t tVar) {
            this.a = sVar;
            this.b = bVar;
            this.c = tVar;
        }
    }

    public int a(@androidx.annotation.Nullable T t, int i) {
        return i;
    }

    public long a(long j) {
        return j;
    }

    @androidx.annotation.Nullable
    public com.anythink.expressad.exoplayer.h.s.a a(@androidx.annotation.Nullable T t, com.anythink.expressad.exoplayer.h.s.a aVar) {
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    @androidx.annotation.CallSuper
    public void a() {
        for (com.anythink.expressad.exoplayer.h.f.b bVar : this.a.values()) {
            bVar.a.a(bVar.b);
            bVar.a.a(bVar.c);
        }
        this.a.clear();
        this.b = null;
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    @androidx.annotation.CallSuper
    public void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        this.b = hVar;
        this.c = new android.os.Handler();
    }

    public final void a(@androidx.annotation.Nullable T t) {
        com.anythink.expressad.exoplayer.h.f.b remove = this.a.remove(t);
        remove.a.a(remove.b);
        remove.a.a(remove.c);
    }

    public final void a(@androidx.annotation.Nullable T t, com.anythink.expressad.exoplayer.h.s sVar) {
        com.anythink.expressad.exoplayer.k.a.a(!this.a.containsKey(t));
        com.anythink.expressad.exoplayer.h.f.AnonymousClass1 anonymousClass1 = new com.anythink.expressad.exoplayer.h.f.AnonymousClass1(t);
        com.anythink.expressad.exoplayer.h.f.a aVar = new com.anythink.expressad.exoplayer.h.f.a(t);
        this.a.put(t, new com.anythink.expressad.exoplayer.h.f.b(sVar, anonymousClass1, aVar));
        sVar.a(this.c, aVar);
        sVar.a(this.b, false, anonymousClass1);
    }

    public abstract void a(@androidx.annotation.Nullable T t, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj);

    @Override // com.anythink.expressad.exoplayer.h.s
    @androidx.annotation.CallSuper
    public void b() {
        java.util.Iterator<com.anythink.expressad.exoplayer.h.f.b> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a.b();
        }
    }
}
