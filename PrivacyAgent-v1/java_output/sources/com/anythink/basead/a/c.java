package com.anythink.basead.a;

/* loaded from: classes12.dex */
public class c {
    public static final java.lang.String a = "c";
    private static volatile com.anythink.basead.a.c c;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.basead.c.d> b = new java.util.concurrent.ConcurrentHashMap<>();

    private c() {
    }

    public static com.anythink.basead.a.c a() {
        if (c == null) {
            synchronized (com.anythink.basead.a.c.class) {
                if (c == null) {
                    c = new com.anythink.basead.a.c();
                }
            }
        }
        return c;
    }

    public final com.anythink.basead.c.d a(int i, java.lang.String str) {
        return this.b.get(i + str);
    }

    public final void a(int i, java.lang.String str, com.anythink.basead.c.d dVar) {
        this.b.put(i + str, dVar);
    }
}
