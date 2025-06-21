package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class av {
    private static com.amap.api.mapcore.util.av a;
    private com.amap.api.mapcore.util.ii b;
    private java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.ij> c = new java.util.LinkedHashMap<>();
    private boolean d = true;

    private av() {
        try {
            if (this.b == null) {
                this.b = com.amap.api.mapcore.util.ii.c();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static com.amap.api.mapcore.util.av a() {
        return c();
    }

    private static synchronized com.amap.api.mapcore.util.av c() {
        com.amap.api.mapcore.util.av avVar;
        synchronized (com.amap.api.mapcore.util.av.class) {
            try {
                com.amap.api.mapcore.util.av avVar2 = a;
                if (avVar2 == null) {
                    a = new com.amap.api.mapcore.util.av();
                } else if (avVar2.b == null) {
                    avVar2.b = com.amap.api.mapcore.util.ii.b();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            avVar = a;
        }
        return avVar;
    }

    private void d() {
        synchronized (this.c) {
            if (this.c.size() <= 0) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.amap.api.mapcore.util.ij> entry : this.c.entrySet()) {
                entry.getKey();
                ((com.amap.api.mapcore.util.ar) entry.getValue()).a();
            }
            this.c.clear();
        }
    }

    private static void e() {
        a = null;
    }

    public final void a(com.amap.api.mapcore.util.au auVar) {
        synchronized (this.c) {
            com.amap.api.mapcore.util.ar arVar = (com.amap.api.mapcore.util.ar) this.c.get(auVar.b());
            if (arVar == null) {
                return;
            }
            arVar.a();
            this.c.remove(auVar.b());
        }
    }

    public final void a(com.amap.api.mapcore.util.au auVar, android.content.Context context) throws com.amap.api.mapcore.util.eu {
        if (!this.c.containsKey(auVar.b())) {
            com.amap.api.mapcore.util.ar arVar = new com.amap.api.mapcore.util.ar((com.amap.api.mapcore.util.bl) auVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.c) {
                this.c.put(auVar.b(), arVar);
            }
        }
        this.b.a(this.c.get(auVar.b()));
    }

    public final void b() {
        d();
        this.b.d();
        this.b = null;
        e();
    }

    public final void b(com.amap.api.mapcore.util.au auVar) {
        com.amap.api.mapcore.util.ar arVar = (com.amap.api.mapcore.util.ar) this.c.get(auVar.b());
        if (arVar != null) {
            synchronized (this.c) {
                arVar.b();
                this.c.remove(auVar.b());
            }
        }
    }
}
