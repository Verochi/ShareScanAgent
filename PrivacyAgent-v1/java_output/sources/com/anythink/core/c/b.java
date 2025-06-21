package com.anythink.core.c;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.core.c.b a;
    private final com.anythink.core.c.b.b b = new com.anythink.core.c.b.b();

    private b() {
    }

    public static com.anythink.core.c.b a() {
        if (a == null) {
            synchronized (com.anythink.core.c.b.class) {
                if (a == null) {
                    a = new com.anythink.core.c.b();
                }
            }
        }
        return a;
    }

    public final org.json.JSONObject a(java.lang.String str) {
        return this.b.a(str, 0);
    }

    public final org.json.JSONObject a(java.lang.String str, int i) {
        return this.b.a(str, 4, i);
    }

    public final void a(com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        this.b.a(atVar, auVar);
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
        this.b.a(str, str2, auVar);
    }

    public final void b(java.lang.String str) {
        this.b.b(str);
    }
}
