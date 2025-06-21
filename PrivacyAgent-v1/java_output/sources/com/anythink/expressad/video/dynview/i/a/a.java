package com.anythink.expressad.video.dynview.i.a;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.expressad.video.dynview.i.a.a a;
    private android.view.View b;
    private android.graphics.Bitmap c;
    private android.graphics.Bitmap d;

    private a() {
    }

    public static com.anythink.expressad.video.dynview.i.a.a a() {
        com.anythink.expressad.video.dynview.i.a.a aVar;
        if (a != null) {
            return a;
        }
        synchronized (com.anythink.expressad.video.dynview.i.a.a.class) {
            if (a == null) {
                a = new com.anythink.expressad.video.dynview.i.a.a();
            }
            aVar = a;
        }
        return aVar;
    }

    private synchronized void a(int i, float f, float f2, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        com.anythink.expressad.video.dynview.g.a.C0228a a2 = com.anythink.expressad.video.dynview.g.a.a();
        a2.a(i).a(bitmap).b(bitmap2);
        if (i != 2) {
            a2.a(f).b(f2);
        } else if (f > f2) {
            a2.a(f).b(f2);
        } else {
            a2.a(f2).b(f);
        }
        this.b.setBackgroundDrawable(a2.b());
    }

    public final void a(java.util.Map map, com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        android.graphics.Bitmap bitmap;
        java.util.List<com.anythink.expressad.foundation.d.c> g;
        this.b = view;
        int e = cVar.e();
        float d = cVar.d();
        float c = cVar.c();
        if (map != null && map.size() > 1 && (g = cVar.g()) != null && g.size() > 1) {
            if (map.get(com.anythink.expressad.foundation.h.p.a(g.get(0).be())) != null && (map.get(com.anythink.expressad.foundation.h.p.a(g.get(0).be())) instanceof android.graphics.Bitmap)) {
                android.graphics.Bitmap bitmap2 = (android.graphics.Bitmap) map.get(com.anythink.expressad.foundation.h.p.a(g.get(0).be()));
                if (g.get(0) != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    com.anythink.expressad.video.dynview.i.b.a();
                    this.c = com.anythink.expressad.video.dynview.i.b.a(bitmap2, 0);
                }
            }
            if (map.get(com.anythink.expressad.foundation.h.p.a(g.get(1).be())) != null && (map.get(com.anythink.expressad.foundation.h.p.a(g.get(1).be())) instanceof android.graphics.Bitmap)) {
                android.graphics.Bitmap bitmap3 = (android.graphics.Bitmap) map.get(com.anythink.expressad.foundation.h.p.a(g.get(1).be()));
                if (g.get(1) != null && !bitmap3.isRecycled()) {
                    com.anythink.expressad.video.dynview.i.b.a();
                    this.d = com.anythink.expressad.video.dynview.i.b.a(bitmap3, 1);
                }
            }
        }
        android.graphics.Bitmap bitmap4 = this.c;
        if (bitmap4 == null || bitmap4.isRecycled() || (bitmap = this.d) == null || bitmap.isRecycled()) {
            return;
        }
        a(e, d, c, this.c, this.d);
    }

    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        android.graphics.Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        android.graphics.Bitmap bitmap2 = this.d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.d.recycle();
        this.d = null;
    }
}
