package com.loc;

/* loaded from: classes23.dex */
public class ai {
    private static com.loc.ai a;
    private final android.content.Context b;
    private final java.lang.String c = com.loc.ap.a(com.loc.y.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private ai(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.loc.ai a(android.content.Context context) {
        if (a == null) {
            synchronized (com.loc.ai.class) {
                if (a == null) {
                    a = new com.loc.ai(context);
                }
            }
        }
        return a;
    }

    public final synchronized void a() {
        try {
            if (com.loc.p.c() == null) {
                com.loc.p.a(com.loc.am.a());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str) {
        com.loc.aj.a(this.b).a(this.c);
        com.loc.aj.a(this.b).b(str);
    }
}
