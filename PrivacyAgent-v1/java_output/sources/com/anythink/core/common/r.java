package com.anythink.core.common;

/* loaded from: classes12.dex */
public class r {
    public static final int a = 35;
    public static final java.lang.String b = "isDefaultOffer";
    private static volatile com.anythink.core.common.r g;
    java.lang.reflect.Method c;
    java.lang.reflect.Method d;
    java.lang.reflect.Method e;
    java.lang.reflect.Method f;

    private r() {
        try {
            this.c = com.anythink.network.myoffer.MyOfferAPI.class.getDeclaredMethod("preloadATOffer", android.content.Context.class, com.anythink.core.common.f.aa.class);
            this.d = com.anythink.network.myoffer.MyOfferAPI.class.getDeclaredMethod("getOutOfCapOfferIds", android.content.Context.class);
            this.e = com.anythink.network.myoffer.MyOfferAPI.class.getDeclaredMethod("getDefaultOfferId", android.content.Context.class, java.lang.String.class);
            this.f = com.anythink.network.myoffer.MyOfferAPI.class.getDeclaredMethod("checkOffersOutOfCap", android.content.Context.class, java.lang.String.class);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static com.anythink.core.common.r a() {
        if (g == null) {
            synchronized (com.anythink.core.common.r.class) {
                if (g == null) {
                    g = new com.anythink.core.common.r();
                }
            }
        }
        return g;
    }

    public final org.json.JSONArray a(android.content.Context context) {
        try {
            java.lang.reflect.Method method = this.d;
            if (method != null) {
                return new org.json.JSONArray(method.invoke(null, context).toString());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return new org.json.JSONArray();
    }

    public final void a(android.content.Context context, java.lang.String str) {
        try {
            if (this.c != null) {
                com.anythink.core.common.f.aa aaVar = new com.anythink.core.common.f.aa();
                aaVar.a = str;
                this.c.invoke(null, context, aaVar);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            java.lang.reflect.Method method = this.e;
            return method != null ? method.invoke(null, context, str).toString() : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean c(android.content.Context context, java.lang.String str) {
        try {
            java.lang.reflect.Method method = this.f;
            if (method != null) {
                return ((java.lang.Boolean) method.invoke(null, context, str)).booleanValue();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
