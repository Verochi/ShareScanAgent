package com.anythink.expressad.foundation.g.c;

/* loaded from: classes12.dex */
public final class b extends com.anythink.expressad.foundation.g.c.f {
    private static final java.lang.String b = "anythink_template/";
    private static final java.lang.String c = "anythink_template/res/Movies";
    private static final java.lang.String d = "anythink_template/res";
    private static final java.lang.String e = "anythink_template/res/.Anythink_VC";
    private static final java.lang.String f = "anythink_template/res/.anythink700";
    private static final java.lang.String g = "anythink_template/res/img";
    private static final java.lang.String h = "anythink_template/crashinfo";
    private static final java.lang.String i = "anythink_template/other";
    private static final java.lang.String j = "anythink_template/res/xml";
    private static final java.lang.String k = "anythink_template/anythink/config";
    private static final java.lang.String l = "anythink_template/res/res";
    private static final java.lang.String m = "anythink_template/res/html";

    public b(java.lang.String str) {
        super(str);
    }

    @Override // com.anythink.expressad.foundation.g.c.f
    public final java.util.List<com.anythink.expressad.foundation.g.c.e> a() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.foundation.g.c.f.a(arrayList, com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR, d);
        com.anythink.expressad.foundation.g.c.f.a(arrayList, com.anythink.expressad.foundation.g.c.a.AD_MOVIES, c).a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC, e);
        com.anythink.expressad.foundation.g.c.e a = com.anythink.expressad.foundation.g.c.f.a(arrayList, com.anythink.expressad.foundation.g.c.a.AD_ANYTHINK_700, f);
        a.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_IMG, g);
        a.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_XML, j);
        a.a(com.anythink.expressad.foundation.g.c.a.MBRIDGE_700_CONFIG, k);
        a.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_RES, l);
        a.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML, m);
        com.anythink.expressad.foundation.g.c.a aVar = com.anythink.expressad.foundation.g.c.a.ANYTHINK_OTHER;
        com.anythink.expressad.foundation.g.c.f.a(arrayList, aVar, i);
        com.anythink.expressad.foundation.g.c.f.a(arrayList, com.anythink.expressad.foundation.g.c.a.ANYTHINK_CRASH_INFO, h);
        com.anythink.expressad.foundation.g.c.f.a(arrayList, aVar, i);
        return arrayList;
    }
}
