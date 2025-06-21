package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public final class k<T> {
    public T a;
    public com.anythink.expressad.foundation.g.f.a.a b;
    public com.anythink.expressad.foundation.g.f.f.c c;

    private k(com.anythink.expressad.foundation.g.f.a.a aVar) {
        this.a = null;
        this.c = null;
        this.b = aVar;
    }

    private k(T t, com.anythink.expressad.foundation.g.f.f.c cVar) {
        this.b = null;
        this.a = t;
        this.c = cVar;
    }

    public static <T> com.anythink.expressad.foundation.g.f.k<T> a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return new com.anythink.expressad.foundation.g.f.k<>(aVar);
    }

    public static <T> com.anythink.expressad.foundation.g.f.k<T> a(T t, com.anythink.expressad.foundation.g.f.f.c cVar) {
        return new com.anythink.expressad.foundation.g.f.k<>(t, cVar);
    }

    private boolean a() {
        return this.b == null;
    }
}
