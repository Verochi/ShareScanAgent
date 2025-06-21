package com.anythink.expressad.foundation.g.f.g;

/* loaded from: classes12.dex */
public class d {
    private static final java.lang.String a = "d";

    public static java.lang.String a(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        com.anythink.expressad.foundation.g.f.c.c b = b(list, "Content-Type");
        if (b != null) {
            java.lang.String b2 = b.b();
            if (!android.text.TextUtils.isEmpty(b2)) {
                java.lang.String[] split = b2.split(com.alipay.sdk.m.u.i.b);
                for (int i = 1; i < split.length; i++) {
                    java.lang.String[] split2 = split[i].trim().split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    public static java.lang.String a(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list, java.lang.String str) {
        com.anythink.expressad.foundation.g.f.c.c b = b(list, str);
        return b != null ? b.b() : "";
    }

    private static void a(com.anythink.expressad.foundation.g.f.h.b bVar, java.lang.String str, java.lang.String str2) {
        if (bVar != null) {
            try {
                if (!com.anythink.expressad.foundation.h.w.a(str) && !com.anythink.expressad.foundation.h.w.a(str2)) {
                    bVar.a(str, str2);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static com.anythink.expressad.foundation.g.f.c.c b(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list, java.lang.String str) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                com.anythink.expressad.foundation.g.f.c.c cVar = list.get(i);
                if (cVar != null && str.equals(cVar.a())) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public static boolean b(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        return android.text.TextUtils.equals(a(list, "Content-Encoding"), "gzip");
    }

    private static boolean c(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        if (android.text.TextUtils.equals(a(list, "Accept-Ranges"), "bytes")) {
            return true;
        }
        java.lang.String a2 = a(list, "Content-Range");
        return a2 != null && a2.startsWith("bytes");
    }
}
