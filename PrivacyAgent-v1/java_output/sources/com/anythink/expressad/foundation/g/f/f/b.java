package com.anythink.expressad.foundation.g.f.f;

/* loaded from: classes12.dex */
public final class b {
    private final int a;
    private final java.util.List<com.anythink.expressad.foundation.g.f.c.c> b;
    private final java.io.InputStream c;

    public b(int i, java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this(i, list, null);
    }

    public b(int i, java.util.List<com.anythink.expressad.foundation.g.f.c.c> list, java.io.InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final java.util.List<com.anythink.expressad.foundation.g.f.c.c> b() {
        return java.util.Collections.unmodifiableList(this.b);
    }

    public final java.io.InputStream c() {
        return this.c;
    }
}
