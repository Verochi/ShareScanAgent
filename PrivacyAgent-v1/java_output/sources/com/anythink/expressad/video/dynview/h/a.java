package com.anythink.expressad.video.dynview.h;

/* loaded from: classes12.dex */
public final class a {

    /* renamed from: com.anythink.expressad.video.dynview.h.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.f.e {
        final /* synthetic */ com.anythink.expressad.video.dynview.f.h a;

        public AnonymousClass1(com.anythink.expressad.video.dynview.f.h hVar) {
            this.a = hVar;
        }

        @Override // com.anythink.expressad.video.dynview.f.e
        public final void a(android.view.View view, java.util.List<android.view.View> list) {
            com.anythink.expressad.video.dynview.a aVar = new com.anythink.expressad.video.dynview.a();
            aVar.a(view);
            aVar.a(list);
            aVar.d();
            this.a.a(aVar);
        }

        @Override // com.anythink.expressad.video.dynview.f.e
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            this.a.a(bVar);
        }
    }

    public a(android.content.Context context, java.util.List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.video.dynview.f.h hVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        new com.anythink.expressad.video.dynview.j.c();
        a(com.anythink.expressad.video.dynview.j.c.a(context, list), hVar, map);
    }

    public a(com.anythink.expressad.video.dynview.c cVar, com.anythink.expressad.video.dynview.f.h hVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        a(cVar, hVar, map);
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, com.anythink.expressad.video.dynview.f.h hVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (hVar == null) {
            return;
        }
        if (cVar == null) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (cVar.a() == null) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
            return;
        }
        if (android.text.TextUtils.isEmpty(cVar.b())) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_LAYOUTNAME);
            return;
        }
        android.view.View inflate = android.view.LayoutInflater.from(cVar.a()).inflate(com.anythink.expressad.foundation.h.i.a(cVar.a(), cVar.b(), "layout"), (android.view.ViewGroup) null);
        com.anythink.expressad.video.dynview.b.b.a();
        com.anythink.expressad.video.dynview.b.b.a(inflate, cVar);
        com.anythink.expressad.video.dynview.b.a.a().a(inflate, cVar, map, new com.anythink.expressad.video.dynview.h.a.AnonymousClass1(hVar));
    }
}
