package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class q {
    public static java.util.Map<java.lang.Class<? extends com.zx.a.I8b7.b>, com.zx.a.I8b7.b> a = new java.util.HashMap();

    public static <T extends com.zx.a.I8b7.c> T a(java.lang.Class<? extends com.zx.a.I8b7.b> cls, java.lang.Class<T> cls2) {
        com.zx.a.I8b7.b bVar = (com.zx.a.I8b7.b) ((java.util.HashMap) a).get(cls);
        if (bVar == null) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("db ");
            a2.append(cls.getSimpleName());
            a2.append(" has not been initialized");
            throw new java.lang.RuntimeException(a2.toString());
        }
        T t = (T) bVar.a.get(cls2);
        if (t != null) {
            return t;
        }
        java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("table ");
        a3.append(cls2.getSimpleName());
        a3.append(" has not been added to db ");
        a3.append(bVar.a());
        throw new java.lang.RuntimeException(a3.toString());
    }

    public static void a(android.content.Context context, java.lang.Class<? extends com.zx.a.I8b7.b> cls, java.lang.Class<? extends com.zx.a.I8b7.c>... clsArr) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        android.content.Context applicationContext = context.getApplicationContext();
        com.zx.a.I8b7.b bVar = (com.zx.a.I8b7.b) ((java.util.HashMap) a).get(cls);
        if (bVar == null) {
            bVar = cls.newInstance();
            ((java.util.HashMap) a).put(cls, bVar);
        }
        for (java.lang.Class<? extends com.zx.a.I8b7.c> cls2 : clsArr) {
            com.zx.a.I8b7.c cVar = bVar.a.get(cls2);
            if (cVar == null) {
                cVar = cls2.newInstance();
                bVar.a.put(cls2, cVar);
            }
            cVar.a = bVar;
        }
        if (bVar.c.getAndSet(true)) {
            return;
        }
        bVar.b = new com.zx.a.I8b7.a(bVar, applicationContext, bVar.a(), null, bVar.c());
        java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.c>> it = bVar.a.keySet().iterator();
        while (it.hasNext()) {
            bVar.a.get(it.next()).getClass();
        }
    }
}
