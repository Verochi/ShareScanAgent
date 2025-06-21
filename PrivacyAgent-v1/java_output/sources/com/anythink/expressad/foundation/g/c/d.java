package com.anythink.expressad.foundation.g.c;

/* loaded from: classes12.dex */
public final class d {
    private static final java.lang.String a = "AnythinkDirManager";
    private static com.anythink.expressad.foundation.g.c.d d;
    private com.anythink.expressad.foundation.g.c.f b;
    private java.util.ArrayList<com.anythink.expressad.foundation.g.c.d.a> c = new java.util.ArrayList<>();

    public static final class a {
        public com.anythink.expressad.foundation.g.c.a a;
        public java.io.File b;

        public a(com.anythink.expressad.foundation.g.c.a aVar, java.io.File file) {
            this.a = aVar;
            this.b = file;
        }
    }

    private d(com.anythink.expressad.foundation.g.c.f fVar) {
        this.b = fVar;
    }

    public static synchronized com.anythink.expressad.foundation.g.c.d a() {
        com.anythink.expressad.foundation.g.c.d dVar;
        synchronized (com.anythink.expressad.foundation.g.c.d.class) {
            if (d == null && com.anythink.expressad.foundation.b.a.b().d() != null) {
                com.anythink.expressad.foundation.h.r.a(com.anythink.expressad.foundation.b.a.b().d());
            }
            com.anythink.expressad.foundation.g.c.d dVar2 = d;
            dVar = d;
        }
        return dVar;
    }

    public static java.io.File a(com.anythink.expressad.foundation.g.c.a aVar) {
        try {
            if (a() == null || a().c == null || a().c.size() <= 0) {
                return null;
            }
            java.util.Iterator<com.anythink.expressad.foundation.g.c.d.a> it = a().c.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.foundation.g.c.d.a next = it.next();
                if (next.a.equals(aVar)) {
                    return next.b;
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static synchronized void a(com.anythink.expressad.foundation.g.c.f fVar) {
        synchronized (com.anythink.expressad.foundation.g.c.d.class) {
            if (d == null) {
                d = new com.anythink.expressad.foundation.g.c.d(fVar);
            }
        }
    }

    private boolean a(com.anythink.expressad.foundation.g.c.e eVar) {
        java.lang.String str;
        com.anythink.expressad.foundation.g.c.e c = eVar.c();
        if (c == null) {
            str = eVar.b();
        } else {
            java.io.File a2 = a(c.a());
            if (a2 == null) {
                return false;
            }
            str = a2.getAbsolutePath() + java.io.File.separator + eVar.b();
        }
        java.io.File file = new java.io.File(str);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.c.add(new com.anythink.expressad.foundation.g.c.d.a(eVar.a(), file));
        java.util.List<com.anythink.expressad.foundation.g.c.e> d2 = eVar.d();
        if (d2 != null) {
            java.util.Iterator<com.anythink.expressad.foundation.g.c.e> it = d2.iterator();
            while (it.hasNext()) {
                if (!a(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static java.lang.String b(com.anythink.expressad.foundation.g.c.a aVar) {
        java.io.File a2 = a(aVar);
        if (a2 != null) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    public final boolean b() {
        return a(this.b.b());
    }
}
