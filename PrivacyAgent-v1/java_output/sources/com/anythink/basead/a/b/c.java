package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
public final class c {
    public static final int a = 0;
    public static final int b = -1;
    public static final int c = 100;
    private static java.util.Map<java.lang.String, java.lang.Integer> d = new java.util.HashMap();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.basead.mraid.MraidWebView> e = new java.util.concurrent.ConcurrentHashMap<>(3);

    public static void a(java.lang.String str, int i) {
        java.lang.Integer num = d.get(str);
        if (num == null || num.intValue() < i) {
            d.put(str, java.lang.Integer.valueOf(i));
        }
    }

    public static void a(java.lang.String str, com.anythink.basead.mraid.MraidWebView mraidWebView) {
        e.put(str, mraidWebView);
    }

    public static boolean a(com.anythink.core.common.f.l lVar, int i, com.anythink.core.common.f.n nVar) {
        if (!android.text.TextUtils.equals(java.lang.String.valueOf(i), "1")) {
            if (android.text.TextUtils.equals(java.lang.String.valueOf(i), "3") && lVar.F() == 1 && !android.text.TextUtils.isEmpty(lVar.A())) {
                return a(lVar, nVar);
            }
            return true;
        }
        if (!android.text.TextUtils.isEmpty(lVar.A())) {
            return a(lVar, nVar);
        }
        if (nVar.aj() != 1 && nVar.ak() <= 0) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(lVar.x())) {
            return lVar.j() && nVar.ak() == 1;
        }
        return true;
    }

    public static boolean a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        if (lVar == null) {
            return false;
        }
        return a(lVar, mVar.j, mVar.n);
    }

    public static boolean a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        int W = nVar.W();
        java.lang.String A = lVar.A();
        if (android.text.TextUtils.isEmpty(A)) {
            return false;
        }
        if (W == 0) {
            return true;
        }
        boolean a2 = com.anythink.core.common.a.k.a().a(A, W);
        if (a2) {
            com.anythink.basead.a.b.g.a(lVar, nVar);
        }
        return a2;
    }

    public static boolean a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        if (mVar == null || lVar == null) {
            return false;
        }
        return e.containsKey(b(mVar, lVar));
    }

    public static boolean a(java.lang.String str) {
        java.lang.Integer num = d.get(str);
        return num != null && num.intValue() == 0;
    }

    public static com.anythink.basead.mraid.MraidWebView b(java.lang.String str) {
        return e.remove(str);
    }

    public static java.lang.String b(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        return mVar.d + "_" + lVar.s();
    }

    public static boolean b(java.lang.String str, int i) {
        return com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).b(i, com.anythink.core.common.o.g.a(str));
    }

    public static boolean c(java.lang.String str) {
        return b(str, 1);
    }
}
