package com.vivo.push.cache;

/* loaded from: classes19.dex */
public final class b {
    private static volatile com.vivo.push.cache.b a;
    private com.vivo.push.cache.d b;

    private b() {
    }

    public static synchronized com.vivo.push.cache.b a() {
        com.vivo.push.cache.b bVar;
        synchronized (com.vivo.push.cache.b.class) {
            if (a == null) {
                a = new com.vivo.push.cache.b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final com.vivo.push.cache.d a(android.content.Context context) {
        com.vivo.push.cache.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        try {
            java.lang.reflect.Method method = com.vivo.push.cache.ClientConfigManagerImpl.class.getMethod("getInstance", android.content.Context.class);
            com.vivo.push.util.p.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            com.vivo.push.cache.d dVar2 = (com.vivo.push.cache.d) method.invoke(null, context);
            this.b = dVar2;
            return dVar2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.b("ConfigManagerFactory", "createConfig error", e);
            return null;
        }
    }
}
