package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class i {
    public static final java.lang.String a = "layout";
    public static final java.lang.String b = "id";
    public static final java.lang.String c = "drawable";
    public static final java.lang.String d = "color";
    public static final java.lang.String e = "style";
    public static final java.lang.String f = "anim";
    public static final java.lang.String g = "string";
    public static final int h = -1;
    private static final java.lang.String i = "ResourceUtil";

    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = "";
        try {
            str3 = com.anythink.expressad.foundation.b.a.b().a();
        } catch (java.lang.Exception unused) {
        }
        try {
            if (com.anythink.expressad.foundation.h.w.a(str3) && context != null) {
                str3 = context.getPackageName();
            }
            if (!com.anythink.expressad.foundation.h.w.a(str3) && context != null) {
                return context.getResources().getIdentifier(str, str2, str3);
            }
        } catch (java.lang.Exception unused2) {
        }
        return -1;
    }

    public static android.content.res.Resources a(android.content.Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        return null;
    }
}
