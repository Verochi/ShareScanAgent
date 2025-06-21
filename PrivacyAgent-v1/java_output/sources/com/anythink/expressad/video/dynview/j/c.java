package com.anythink.expressad.video.dynview.j;

/* loaded from: classes12.dex */
public final class c {
    private static final java.lang.String a = "ViewOptionWrapper";
    private static final java.lang.String b = "\\.xml";
    private static final java.lang.String c = "\\/xml";

    public static com.anythink.expressad.video.dynview.c a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar == null) {
            return null;
        }
        try {
            return new com.anythink.expressad.video.dynview.c.a().a(com.anythink.expressad.foundation.h.k.b(context) == 1 ? com.anythink.expressad.video.dynview.a.a.b : com.anythink.expressad.video.dynview.a.a.a).a(4).a(context).b(com.anythink.expressad.foundation.h.k.b(context)).b("").e(cVar.k()).d(i).a();
        } catch (java.lang.Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c a(android.content.Context context, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        int i;
        if (list == null) {
            return null;
        }
        try {
            float f = com.anythink.expressad.foundation.h.t.f(com.anythink.core.common.b.o.a().f());
            float e = com.anythink.expressad.foundation.h.t.e(com.anythink.core.common.b.o.a().f());
            if (list.size() <= 0 || list.get(0) == null) {
                i = 1;
            } else {
                com.anythink.expressad.foundation.d.c cVar = list.get(0);
                i = (cVar == null || cVar.M() == null) ? 1 : cVar.M().c();
                list.get(0).as();
                list.get(0).aq();
            }
            java.lang.String str = com.anythink.expressad.video.dynview.a.a.j;
            if (i != 1) {
                if (i == 2) {
                    str = com.anythink.expressad.video.dynview.a.a.i;
                } else if (com.anythink.expressad.video.dynview.i.c.a(context)) {
                    str = com.anythink.expressad.video.dynview.a.a.i;
                    i = 2;
                } else {
                    i = 1;
                }
            }
            return new com.anythink.expressad.video.dynview.c.a().a(context).a(str).a(1).a(e).b(f).a(list).b(i).b("").a();
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c a(android.view.View view, com.anythink.expressad.foundation.d.c cVar) {
        int i;
        java.lang.String str;
        if (cVar == null) {
            return null;
        }
        try {
            java.lang.String K = cVar.K();
            if (cVar.M() != null) {
                i = cVar.M().b();
                str = cVar.M().e();
            } else {
                i = 102;
                str = "";
            }
            java.lang.String a2 = a(i);
            boolean a3 = com.anythink.expressad.video.dynview.i.c.a(str);
            com.anythink.expressad.videocommon.e.d a4 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), K, false);
            int h = a4 != null ? a4.h() : 0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            return new com.anythink.expressad.video.dynview.c.a().a(a2).a(i).a(arrayList).a(view.getContext()).a(view).c(h).b(com.anythink.expressad.foundation.h.k.b(view.getContext())).d(i).a(a3).b("").e(cVar.k()).a();
        } catch (java.lang.Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static java.lang.String a(int i) {
        return i != 3 ? i != 302 ? i != 802 ? i != 904 ? "anythink_reward_layer_floor" : com.anythink.expressad.video.dynview.a.a.g : com.anythink.expressad.video.dynview.a.a.f : com.anythink.expressad.video.dynview.a.a.e : com.anythink.expressad.video.dynview.a.a.h;
    }

    public static com.anythink.expressad.video.dynview.c b(android.content.Context context, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        try {
            float f = com.anythink.expressad.foundation.h.t.f(com.anythink.core.common.b.o.a().f());
            float e = com.anythink.expressad.foundation.h.t.e(com.anythink.core.common.b.o.a().f());
            int i = 0;
            if (list.get(0) != null) {
                int k = list.get(0).k();
                list.get(0).as();
                list.get(0).aq();
                i = k;
            }
            int b2 = com.anythink.expressad.foundation.h.k.b(context);
            return new com.anythink.expressad.video.dynview.c.a().a(b2 == 1 ? com.anythink.expressad.video.dynview.a.a.k : com.anythink.expressad.video.dynview.a.a.l).a(5).a(context).a(e).b(f).a(list).b(b2).b("").e(i).d(i).a();
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c b(android.view.View view, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            java.lang.String K = cVar.K();
            java.lang.String a2 = a(3);
            com.anythink.expressad.videocommon.e.d a3 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), K, false);
            int h = a3 != null ? a3.h() : 0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            return new com.anythink.expressad.video.dynview.c.a().a(a2).a(3).a(arrayList).a(view.getContext()).a(view).c(h).b(com.anythink.expressad.foundation.h.k.b(view.getContext())).d(3).a();
        } catch (java.lang.Exception e) {
            e.getMessage();
            return null;
        }
    }
}
