package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class ao {
    com.anythink.core.d.e a;
    com.anythink.core.common.f.h b;
    java.util.List<com.anythink.core.common.f.au> c;
    java.util.List<com.anythink.core.common.f.au> d;
    java.util.List<com.anythink.core.common.f.au> e;
    int f;

    public ao(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar, int i) {
        this.a = eVar;
        this.b = hVar;
        this.f = i;
    }

    public final com.anythink.core.d.e a() {
        return this.a;
    }

    public final void a(java.util.List<com.anythink.core.common.f.au> list) {
        this.c = list;
    }

    public final int b() {
        return this.f;
    }

    public final void b(java.util.List<com.anythink.core.common.f.au> list) {
        this.d = list;
    }

    public final com.anythink.core.common.f.h c() {
        return this.b;
    }

    public final void c(java.util.List<com.anythink.core.common.f.au> list) {
        this.e = list;
    }

    public final java.util.List<com.anythink.core.common.f.au> d() {
        return this.c;
    }

    public final java.util.List<com.anythink.core.common.f.au> e() {
        return this.d;
    }

    public final java.util.List<com.anythink.core.common.f.au> f() {
        return this.e;
    }

    public final boolean g() {
        java.util.List<com.anythink.core.common.f.au> list = this.c;
        if (list != null && list.size() > 0) {
            return true;
        }
        java.util.List<com.anythink.core.common.f.au> list2 = this.d;
        if (list2 != null && list2.size() > 0) {
            return true;
        }
        java.util.List<com.anythink.core.common.f.au> list3 = this.e;
        return list3 != null && list3.size() > 0;
    }
}
