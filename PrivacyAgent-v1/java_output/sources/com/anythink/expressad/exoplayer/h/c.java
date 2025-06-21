package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public abstract class c implements com.anythink.expressad.exoplayer.h.s {
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.s.b> a = new java.util.ArrayList<>(1);
    private final com.anythink.expressad.exoplayer.h.t.a b = new com.anythink.expressad.exoplayer.h.t.a();
    private com.anythink.expressad.exoplayer.h c;
    private com.anythink.expressad.exoplayer.ae d;
    private java.lang.Object e;

    private com.anythink.expressad.exoplayer.h.t.a a(com.anythink.expressad.exoplayer.h.s.a aVar, long j) {
        com.anythink.expressad.exoplayer.k.a.a(aVar != null);
        return this.b.a(0, aVar, j);
    }

    public final com.anythink.expressad.exoplayer.h.t.a a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar) {
        return this.b.a(i, aVar, 0L);
    }

    public final com.anythink.expressad.exoplayer.h.t.a a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar) {
        return this.b.a(0, aVar, 0L);
    }

    public abstract void a();

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(android.os.Handler handler, com.anythink.expressad.exoplayer.h.t tVar) {
        this.b.a(handler, tVar);
    }

    public final void a(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        this.d = aeVar;
        this.e = obj;
        java.util.Iterator<com.anythink.expressad.exoplayer.h.s.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, aeVar, obj);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.s.b bVar) {
        this.a.remove(bVar);
        if (this.a.isEmpty()) {
            this.c = null;
            this.d = null;
            this.e = null;
            a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.t tVar) {
        this.b.a(tVar);
    }

    public abstract void a(com.anythink.expressad.exoplayer.h hVar, boolean z);

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z, com.anythink.expressad.exoplayer.h.s.b bVar) {
        com.anythink.expressad.exoplayer.h hVar2 = this.c;
        com.anythink.expressad.exoplayer.k.a.a(hVar2 == null || hVar2 == hVar);
        this.a.add(bVar);
        if (this.c == null) {
            this.c = hVar;
            a(hVar, z);
        } else {
            com.anythink.expressad.exoplayer.ae aeVar = this.d;
            if (aeVar != null) {
                bVar.a(this, aeVar, this.e);
            }
        }
    }
}
