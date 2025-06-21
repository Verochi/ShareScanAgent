package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class d {
    public static int a(android.content.Context context, com.anythink.core.common.f.l lVar) {
        int G = lVar.G();
        return (G == 1 || G == 4) ? com.anythink.core.common.o.i.a(context, "myoffer_cta_install_now", com.anythink.expressad.foundation.h.i.g) : com.anythink.core.common.o.i.a(context, "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.g);
    }

    public static boolean a(com.anythink.core.common.f.l lVar) {
        return (android.text.TextUtils.isEmpty(lVar.w()) && android.text.TextUtils.isEmpty(lVar.u()) && android.text.TextUtils.isEmpty(lVar.v())) ? false : true;
    }

    public static boolean a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        if (lVar == null || mVar == null) {
            return false;
        }
        java.lang.String valueOf = java.lang.String.valueOf(mVar.j);
        valueOf.hashCode();
        if (valueOf.equals("1")) {
            return true;
        }
        return valueOf.equals("3") && lVar.F() == 1 && lVar.H();
    }

    public static boolean b(com.anythink.core.common.f.l lVar) {
        return lVar != null && lVar.j();
    }
}
