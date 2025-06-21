package com.sijla.g;

/* loaded from: classes19.dex */
public final class a {
    private android.content.Context a;
    private java.lang.Class b;
    private java.lang.Object c;
    private java.lang.reflect.Method d;
    private java.lang.reflect.Method e;
    private java.lang.reflect.Method f;
    private java.lang.reflect.Method g;

    public a(android.content.Context context) {
        this.a = context;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
            try {
                this.d = this.b.getMethod("getDefaultUDID", android.content.Context.class);
            } catch (java.lang.Exception unused) {
            }
            try {
                this.e = this.b.getMethod("getOAID", android.content.Context.class);
            } catch (java.lang.Exception unused2) {
            }
            try {
                this.f = this.b.getMethod("getVAID", android.content.Context.class);
            } catch (java.lang.Exception unused3) {
            }
            this.g = this.b.getMethod("getAAID", android.content.Context.class);
        } catch (java.lang.Exception unused4) {
        }
    }

    private java.lang.String a(android.content.Context context, java.lang.reflect.Method method) {
        java.lang.Object obj = this.c;
        if (obj != null && method != null) {
            try {
                return (java.lang.String) method.invoke(obj, context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void a(android.content.Context context) {
        if (com.sijla.h.a.a.b(context, com.anythink.china.common.d.a) && com.sijla.h.c.a(context, "cht_itl_bs", com.sijla.c.d.a.optInt("itl_bs", com.anythink.expressad.d.a.b.bx))) {
            new com.sijla.g.a.a.c(new com.sijla.g.b(context)).a(context);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        if (com.sijla.h.c.a(str)) {
            return;
        }
        com.sijla.h.j.a(context, "oaidspkey", str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("oaid", str);
            jSONObject.put("api", i);
            com.sijla.a.a.a(new com.sijla.g.c(context, jSONObject));
        } catch (java.lang.Throwable unused) {
        }
    }

    public final java.lang.String a() {
        return a(this.a, this.e);
    }
}
