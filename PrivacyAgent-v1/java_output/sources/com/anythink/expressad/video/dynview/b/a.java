package com.anythink.expressad.video.dynview.b;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.expressad.video.dynview.b.a b;
    public com.anythink.expressad.video.dynview.e.a a;

    private a() {
    }

    public static com.anythink.expressad.video.dynview.b.a a() {
        com.anythink.expressad.video.dynview.b.a aVar;
        if (b != null) {
            return b;
        }
        synchronized (com.anythink.expressad.video.dynview.b.a.class) {
            if (b == null) {
                b = new com.anythink.expressad.video.dynview.b.a();
            }
            aVar = b;
        }
        return aVar;
    }

    private static void a(com.anythink.expressad.video.dynview.c cVar, android.view.View view, com.anythink.expressad.video.dynview.f.e eVar) {
        new com.anythink.expressad.video.dynview.j.a().a(cVar, view, eVar);
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        com.anythink.expressad.video.dynview.j.a aVar = new com.anythink.expressad.video.dynview.j.a();
        aVar.a(cVar, view, map, eVar);
        this.a = aVar.b;
    }

    public static void b() {
        if (b != null) {
            b = null;
        }
    }

    private static void b(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        new com.anythink.expressad.video.dynview.j.a().b(cVar, view, map, eVar);
    }

    private void c() {
        com.anythink.expressad.video.dynview.e.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void c(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        new com.anythink.expressad.video.dynview.j.a().c(cVar, view, map, eVar);
    }

    private static void d() {
    }

    private void e() {
        com.anythink.expressad.video.dynview.e.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void a(android.view.View view, com.anythink.expressad.video.dynview.c cVar, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        int h = cVar.h();
        if (h == 1) {
            com.anythink.expressad.video.dynview.j.a aVar = new com.anythink.expressad.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.a = aVar.b;
        } else {
            if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
                new com.anythink.expressad.video.dynview.j.a().b(cVar, view, map, eVar);
                return;
            }
            if (h == 4) {
                new com.anythink.expressad.video.dynview.j.a().a(cVar, view, eVar);
            } else if (h != 5) {
                eVar.a(view, new java.util.ArrayList());
            } else {
                new com.anythink.expressad.video.dynview.j.a().c(cVar, view, map, eVar);
            }
        }
    }
}
