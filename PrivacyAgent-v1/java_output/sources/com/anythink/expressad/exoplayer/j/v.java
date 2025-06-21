package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class v<T> implements com.anythink.expressad.exoplayer.j.t.c {
    public final com.anythink.expressad.exoplayer.j.k a;
    public final int b;
    private final com.anythink.expressad.exoplayer.j.h c;
    private final com.anythink.expressad.exoplayer.j.v.a<? extends T> d;
    private volatile T e;
    private volatile long f;

    public interface a<T> {
        T a();
    }

    private v(com.anythink.expressad.exoplayer.j.h hVar, android.net.Uri uri, com.anythink.expressad.exoplayer.j.v.a<? extends T> aVar) {
        this(hVar, new com.anythink.expressad.exoplayer.j.k(uri, 3), aVar);
    }

    private v(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.v.a<? extends T> aVar) {
        this.c = hVar;
        this.a = kVar;
        this.b = 0;
        this.d = aVar;
    }

    private static <T> T a(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.v.a<? extends T> aVar, android.net.Uri uri) {
        com.anythink.expressad.exoplayer.j.v vVar = new com.anythink.expressad.exoplayer.j.v(hVar, uri, aVar);
        vVar.b();
        return vVar.e;
    }

    private T c() {
        return this.e;
    }

    private long d() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        com.anythink.expressad.exoplayer.j.j jVar = new com.anythink.expressad.exoplayer.j.j(this.c, this.a);
        try {
            jVar.b();
            com.anythink.expressad.exoplayer.j.v.a<? extends T> aVar = this.d;
            this.c.a();
            this.e = aVar.a();
        } finally {
            this.f = jVar.a();
            com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) jVar);
        }
    }
}
