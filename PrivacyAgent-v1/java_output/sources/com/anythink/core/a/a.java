package com.anythink.core.a;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.core.a.a g;
    com.anythink.core.common.c.l a;
    android.content.Context d;
    private final java.lang.String f = getClass().getSimpleName();
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.an> e = new java.util.concurrent.ConcurrentHashMap<>(3);
    java.text.SimpleDateFormat b = new java.text.SimpleDateFormat("yyyyMMdd");
    java.text.SimpleDateFormat c = new java.text.SimpleDateFormat("yyyyMMddHH");

    /* renamed from: com.anythink.core.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.a.a aVar = com.anythink.core.a.a.this;
            aVar.a.a(aVar.b.format(new java.util.Date(java.lang.System.currentTimeMillis())));
        }
    }

    private a(android.content.Context context) {
        this.a = com.anythink.core.common.c.l.a(com.anythink.core.common.c.c.a(context));
        this.d = context;
    }

    public static com.anythink.core.a.a a(android.content.Context context) {
        if (g == null) {
            synchronized (com.anythink.core.a.a.class) {
                if (g == null) {
                    g = new com.anythink.core.a.a(context);
                }
            }
        }
        return g;
    }

    public final com.anythink.core.common.f.an.a a(java.lang.String str, java.lang.String str2, int i) {
        com.anythink.core.common.f.an.a a;
        com.anythink.core.common.f.an a2 = a(str, i);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return null;
        }
        if (!android.text.TextUtils.equals(a.c, a2.g)) {
            a.c = a2.g;
            a.d = 0;
            a.b = a2.f;
            a.e = 0;
        } else if (!android.text.TextUtils.equals(a.b, a2.f)) {
            a.b = a2.f;
            a.e = 0;
        }
        return a;
    }

    public final com.anythink.core.common.f.an a(java.lang.String str, int i) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String format = this.b.format(new java.util.Date(currentTimeMillis));
        java.lang.String format2 = this.c.format(new java.util.Date(currentTimeMillis));
        com.anythink.core.common.f.an anVar = this.e.get(str);
        if (anVar != null) {
            if (!android.text.TextUtils.equals(anVar.g, format)) {
                anVar.c = 0;
                anVar.g = format;
                anVar.d = 0;
                anVar.f = format2;
            } else if (!android.text.TextUtils.equals(anVar.f, format2)) {
                anVar.d = 0;
                anVar.f = format2;
            }
        }
        synchronized (com.anythink.core.common.u.a().a(str)) {
            if (anVar == null) {
                anVar = this.a.a(str, format, format2);
                if (anVar == null) {
                    anVar = new com.anythink.core.common.f.an();
                    anVar.b = str;
                    anVar.a = i;
                }
                anVar.g = format;
                anVar.f = format2;
                this.e.put(str, anVar);
            }
        }
        return anVar;
    }

    public final void a() {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.a.a.AnonymousClass1(), 2, true);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.anythink.core.common.u.a().a(str2)) {
            int parseInt = java.lang.Integer.parseInt(str);
            com.anythink.core.common.f.an a = a(str2, parseInt);
            com.anythink.core.common.f.an.a a2 = a(str2, str3, parseInt);
            if (a2 == null) {
                a2 = new com.anythink.core.common.f.an.a();
                a2.a = str3;
                a.a(str3, a2);
            }
            a2.c = a.g;
            a2.b = a.f;
            a.c++;
            a2.d++;
            a.d++;
            a2.e++;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            a.e = currentTimeMillis;
            a2.f = currentTimeMillis;
            a.toString();
            a2.toString();
            this.a.a(parseInt, str2, a2);
        }
    }

    public final boolean a(com.anythink.core.d.e eVar, java.lang.String str) {
        if (eVar == null) {
            return false;
        }
        if (eVar.ak() == -1 && eVar.al() == -1) {
            return false;
        }
        com.anythink.core.common.f.an a = a(str, eVar.ag());
        int i = a != null ? a.c : 0;
        int i2 = a != null ? a.d : 0;
        if (eVar.ak() == -1 || i < eVar.ak()) {
            return eVar.al() != -1 && ((long) i2) >= eVar.al();
        }
        return true;
    }

    public final boolean a(java.lang.String str, com.anythink.core.common.f.au auVar, int i) {
        com.anythink.core.common.f.an.a a;
        if ((auVar.g() == -1 && auVar.f() == -1) || (a = a(str, auVar.u(), i)) == null) {
            return false;
        }
        if (auVar.g() == -1 || a.e < auVar.g()) {
            return auVar.f() != -1 && a.d >= auVar.f();
        }
        return true;
    }

    public final int[] a(int i) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        int[] a = this.a.a(i, this.b.format(new java.util.Date(currentTimeMillis)), this.c.format(new java.util.Date(currentTimeMillis)));
        int i2 = a[0];
        int i3 = a[1];
        return a;
    }
}
