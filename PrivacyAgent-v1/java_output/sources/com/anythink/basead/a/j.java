package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class j {
    private static volatile com.anythink.basead.a.j a;
    private android.content.Context b = com.anythink.core.common.b.o.a().f();
    private com.anythink.core.common.o.a.c c = new com.anythink.core.common.o.a.c(50);
    private com.anythink.core.common.o.a.f.b d = new com.anythink.core.common.o.a.f.b();

    private j() {
    }

    public static com.anythink.basead.a.j a() {
        if (a == null) {
            synchronized (com.anythink.basead.a.g.class) {
                if (a == null) {
                    a = new com.anythink.basead.a.j();
                }
            }
        }
        return a;
    }

    public final com.anythink.core.common.o.a.c b() {
        return this.c;
    }

    public final com.anythink.core.common.o.a.f.b c() {
        return this.d;
    }
}
