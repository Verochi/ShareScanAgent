package com.anythink.expressad.foundation.g.g;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String a = "b";
    private static java.util.WeakHashMap<android.content.Context, com.anythink.expressad.foundation.g.g.c> b = new java.util.WeakHashMap<>();
    private com.anythink.expressad.foundation.g.g.c c;
    private android.content.Context d;

    private b(android.content.Context context) {
        this.d = context;
        if (b.get(context) != null) {
            this.c = b.get(this.d);
            return;
        }
        com.anythink.expressad.foundation.g.g.c cVar = new com.anythink.expressad.foundation.g.g.c(this.d, 5);
        this.c = cVar;
        b.put(this.d, cVar);
    }

    private void a(com.anythink.expressad.foundation.g.g.a aVar) {
        this.c.a(aVar);
    }
}
