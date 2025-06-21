package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class de {
    private static volatile com.xiaomi.push.de f;
    public android.content.Context a;
    public java.lang.String b;
    public java.lang.String c;
    public int d;
    public com.xiaomi.push.di e;
    private java.util.HashMap<com.xiaomi.push.dg, com.xiaomi.push.dh> g;

    private de(android.content.Context context) {
        java.util.HashMap<com.xiaomi.push.dg, com.xiaomi.push.dh> hashMap = new java.util.HashMap<>();
        this.g = hashMap;
        this.a = context;
        hashMap.put(com.xiaomi.push.dg.SERVICE_ACTION, new com.xiaomi.push.dk());
        this.g.put(com.xiaomi.push.dg.SERVICE_COMPONENT, new com.xiaomi.push.dl());
        this.g.put(com.xiaomi.push.dg.ACTIVITY, new com.xiaomi.push.dc());
        this.g.put(com.xiaomi.push.dg.PROVIDER, new com.xiaomi.push.dj());
    }

    public static com.xiaomi.push.de a(android.content.Context context) {
        if (f == null) {
            synchronized (com.xiaomi.push.de.class) {
                if (f == null) {
                    f = new com.xiaomi.push.de(context);
                }
            }
        }
        return f;
    }

    public static boolean b(android.content.Context context) {
        return com.xiaomi.push.service.p.a(context, context.getPackageName());
    }

    public final void a(com.xiaomi.push.dg dgVar, android.content.Context context, android.content.Intent intent, java.lang.String str) {
        if (dgVar != null) {
            this.g.get(dgVar).a(context, intent, str);
        } else {
            com.xiaomi.push.cz.a(context, com.igexin.push.core.b.m, 1008, "A receive a incorrect message with empty type");
        }
    }
}
