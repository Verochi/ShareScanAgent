package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public final class e {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;

    public static final class a {
        public static final java.lang.String a = "screen_style";
    }

    private static java.util.List<com.anythink.basead.ui.b.b> a(int i, android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, int i2, com.anythink.basead.ui.b.b.a aVar) {
        android.view.ViewGroup viewGroup2 = viewGroup;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) viewGroup2.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide2click_container", "id"));
        android.view.View findViewById = viewGroup2.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide2click_mask", "id"));
        android.view.View findViewById2 = viewGroup2.findViewById(com.anythink.core.common.o.i.a(viewGroup.getContext(), "myoffer_rl_root", "id"));
        if (findViewById2 == null || !(findViewById2 instanceof android.view.ViewGroup)) {
            android.view.View findViewById3 = viewGroup2.findViewById(com.anythink.core.common.o.i.a(viewGroup.getContext(), "myoffer_splash_root", "id"));
            if (findViewById3 != null && (findViewById3 instanceof android.view.ViewGroup)) {
                viewGroup2 = (android.view.ViewGroup) findViewById3;
            }
        } else {
            viewGroup2 = (android.view.ViewGroup) findViewById2;
        }
        if ((i & 1) == 1) {
            com.anythink.basead.ui.b.f fVar = new com.anythink.basead.ui.b.f();
            fVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i2, aVar);
            arrayList.add(fVar);
        }
        if ((i & 2) == 2) {
            com.anythink.basead.ui.b.c cVar = new com.anythink.basead.ui.b.c();
            cVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i2, aVar);
            arrayList.add(cVar);
        }
        if ((i & 4) == 4) {
            com.anythink.basead.ui.b.g gVar = new com.anythink.basead.ui.b.g();
            gVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i2, aVar);
            arrayList.add(gVar);
        }
        if (relativeLayout != null && (i & 8) == 8) {
            com.anythink.basead.ui.b.d dVar = new com.anythink.basead.ui.b.d();
            dVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i2, aVar);
            arrayList.add(dVar);
        }
        return arrayList;
    }
}
