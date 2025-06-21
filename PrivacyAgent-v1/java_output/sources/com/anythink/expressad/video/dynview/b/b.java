package com.anythink.expressad.video.dynview.b;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.expressad.video.dynview.b.b a;

    private b() {
    }

    public static com.anythink.expressad.video.dynview.b.b a() {
        com.anythink.expressad.video.dynview.b.b bVar;
        if (a != null) {
            return a;
        }
        synchronized (com.anythink.expressad.video.dynview.b.b.class) {
            if (a == null) {
                a = new com.anythink.expressad.video.dynview.b.b();
            }
            bVar = a;
        }
        return bVar;
    }

    private static void a(android.view.View view) {
        new com.anythink.expressad.video.dynview.j.b().a(view);
    }

    public static void a(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        if (cVar == null) {
            return;
        }
        int h = cVar.h();
        if (h == 1) {
            new com.anythink.expressad.video.dynview.j.b().a(view);
            return;
        }
        if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
            new com.anythink.expressad.video.dynview.j.b().a(view, cVar);
            return;
        }
        if (h == 3) {
            new com.anythink.expressad.video.dynview.j.b().b(view, cVar);
        } else if (h == 4) {
            new com.anythink.expressad.video.dynview.j.b().c(view, cVar);
        } else {
            if (h != 5) {
                return;
            }
            new com.anythink.expressad.video.dynview.j.b();
        }
    }

    public static void b() {
        if (a != null) {
            a = null;
        }
    }

    private static void b(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        new com.anythink.expressad.video.dynview.j.b().a(view, cVar);
    }

    private static void c() {
        new com.anythink.expressad.video.dynview.j.b();
    }

    private static void c(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        new com.anythink.expressad.video.dynview.j.b().b(view, cVar);
    }

    private static void d(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        new com.anythink.expressad.video.dynview.j.b().c(view, cVar);
    }
}
