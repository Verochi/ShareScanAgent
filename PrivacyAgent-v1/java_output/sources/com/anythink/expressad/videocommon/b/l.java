package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class l {
    private static java.util.Map<java.lang.String, java.lang.Boolean> b = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.Boolean> a;
    private java.util.Map<java.lang.String, java.lang.Boolean> c;
    private java.util.Map<java.lang.String, java.lang.Boolean> d;
    private java.util.Map<java.lang.String, java.lang.Boolean> e;

    public static final class a {
        public static com.anythink.expressad.videocommon.b.l a = new com.anythink.expressad.videocommon.b.l((byte) 0);

        private a() {
        }
    }

    private l() {
        this.a = new java.util.HashMap();
        this.c = new java.util.HashMap();
        this.d = new java.util.HashMap();
        this.e = new java.util.HashMap();
    }

    public /* synthetic */ l(byte b2) {
        this();
    }

    public static com.anythink.expressad.videocommon.b.l a() {
        return com.anythink.expressad.videocommon.b.l.a.a;
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            b(cVar);
            e(cVar.aZ());
        }
    }

    private static boolean a(com.anythink.expressad.foundation.d.c.C0208c c0208c) {
        java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f;
        java.util.List<java.lang.String> list;
        if (c0208c != null && (f = c0208c.f()) != null) {
            for (com.anythink.expressad.foundation.d.c.C0208c.a aVar : f) {
                if (aVar != null && (list = aVar.b) != null) {
                    for (java.lang.String str : list) {
                        boolean a2 = a(b, str);
                        if (a2 || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
                            a2 = true;
                        }
                        if (!a2) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean a(java.util.Map<java.lang.String, java.lang.Boolean> map, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        if (map == null) {
            new java.util.HashMap().put(str, java.lang.Boolean.FALSE);
            return false;
        }
        if (map.containsKey(str)) {
            return map.get(str).booleanValue();
        }
        map.put(str, java.lang.Boolean.FALSE);
        return false;
    }

    private boolean a(boolean z, java.lang.String str) {
        boolean a2 = a(this.c, str);
        if (a2 || !z || android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str))) {
            return a2;
        }
        this.c.put(str, java.lang.Boolean.TRUE);
        return true;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f;
        if (cVar != null) {
            java.lang.String S = cVar.S();
            java.util.Map<java.lang.String, java.lang.Boolean> map = this.a;
            if (map != null && !map.containsKey(S)) {
                this.a.put(S, java.lang.Boolean.FALSE);
            }
            java.lang.String I = cVar.I();
            java.util.Map<java.lang.String, java.lang.Boolean> map2 = this.c;
            if (map2 != null && !map2.containsKey(I)) {
                this.c.put(I, java.lang.Boolean.FALSE);
            }
            com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
            if (M == null || (f = M.f()) == null) {
                return;
            }
            for (com.anythink.expressad.foundation.d.c.C0208c.a aVar : f) {
                if (aVar != null) {
                    b(aVar.b);
                }
            }
        }
    }

    private static void b(java.util.List<java.lang.String> list) {
        java.util.Map<java.lang.String, java.lang.Boolean> map;
        if (list == null || list.size() == 0) {
            return;
        }
        for (java.lang.String str : list) {
            if (!android.text.TextUtils.isEmpty(str) && (map = b) != null && !map.containsKey(str)) {
                b.put(str, java.lang.Boolean.valueOf(com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)));
            }
        }
    }

    public static void c(java.lang.String str) {
        if (b == null) {
            b = new java.util.HashMap();
        }
        b.put(str, java.lang.Boolean.TRUE);
    }

    private void e(java.lang.String str) {
        if (this.d == null) {
            this.d = new java.util.HashMap();
        }
        this.d.put(str, java.lang.Boolean.FALSE);
    }

    private void f(java.lang.String str) {
        if (this.e.containsKey(str)) {
            this.e.remove(str);
        }
    }

    private static boolean g(java.lang.String str) {
        boolean a2 = a(b, str);
        if (a2 || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
            return true;
        }
        return a2;
    }

    private static boolean h(java.lang.String str) {
        java.io.File file = new java.io.File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC) + java.io.File.separator + com.anythink.expressad.foundation.h.m.d(str));
        try {
            if (file.exists() && file.isFile()) {
                return file.canRead();
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final void a(java.lang.String str, boolean z) {
        if (this.a == null) {
            this.a = new java.util.HashMap();
        }
        this.a.put(str, java.lang.Boolean.valueOf(z));
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                b(cVar);
                e(cVar.aZ());
            }
        }
    }

    public final boolean a(java.lang.String str) {
        if (this.a == null || android.text.TextUtils.isEmpty(str) || !this.a.containsKey(str)) {
            return false;
        }
        return this.a.get(str).booleanValue();
    }

    public final void b(java.lang.String str, boolean z) {
        if (this.c == null) {
            this.c = new java.util.HashMap();
        }
        this.c.put(str, java.lang.Boolean.valueOf(z));
    }

    public final boolean b(java.lang.String str) {
        if (this.c == null || android.text.TextUtils.isEmpty(str) || !this.c.containsKey(str)) {
            return false;
        }
        return this.c.get(str).booleanValue();
    }

    public final void c(java.lang.String str, boolean z) {
        if (this.e == null) {
            this.e = new java.util.HashMap();
        }
        this.e.put(str, java.lang.Boolean.valueOf(z));
    }

    public final boolean d(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.e.containsKey(str)) {
            return this.e.get(str).booleanValue();
        }
        return false;
    }
}
