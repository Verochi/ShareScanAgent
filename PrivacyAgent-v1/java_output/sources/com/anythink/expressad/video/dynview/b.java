package com.anythink.expressad.video.dynview;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.expressad.video.dynview.b b;
    public java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.view.View>> a = new java.util.HashMap();

    private b() {
    }

    public static com.anythink.expressad.video.dynview.b a() {
        com.anythink.expressad.video.dynview.b bVar;
        if (b != null) {
            return b;
        }
        synchronized (com.anythink.expressad.video.dynview.b.class) {
            if (b == null) {
                b = new com.anythink.expressad.video.dynview.b();
            }
            bVar = b;
        }
        return bVar;
    }

    public static void a(android.content.Context context, java.util.List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.video.dynview.f.h hVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        new com.anythink.expressad.video.dynview.h.a(context, list, hVar, map);
    }

    public static void a(com.anythink.expressad.video.dynview.c cVar, com.anythink.expressad.video.dynview.f.h hVar) {
        new com.anythink.expressad.video.dynview.h.a(cVar, hVar, new java.util.HashMap());
    }

    public static void a(com.anythink.expressad.video.dynview.c cVar, com.anythink.expressad.video.dynview.f.h hVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        new com.anythink.expressad.video.dynview.h.a(cVar, hVar, map);
    }

    private static void b() {
    }

    private static void c() {
        com.anythink.expressad.video.dynview.b.b.a();
        com.anythink.expressad.video.dynview.b.b.b();
        com.anythink.expressad.video.dynview.b.a.a();
        com.anythink.expressad.video.dynview.b.a.b();
    }
}
