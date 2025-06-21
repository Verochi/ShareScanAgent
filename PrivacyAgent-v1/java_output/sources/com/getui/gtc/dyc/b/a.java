package com.getui.gtc.dyc.b;

/* loaded from: classes22.dex */
public class a {
    public static java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> a(android.content.Context context) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        return com.getui.gtc.dyc.a.a().c();
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, com.getui.gtc.dyc.b.b bVar) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        if (a(bVar)) {
            return com.getui.gtc.dyc.a.a().a(bVar);
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, java.lang.String str) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        return com.getui.gtc.dyc.a.a().a(str);
    }

    public static void a(android.content.Context context, com.getui.gtc.dyc.b.c cVar) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        com.getui.gtc.dyc.f.a().a(cVar);
    }

    public static void a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        com.getui.gtc.dyc.a.a().a(str, map);
    }

    private static boolean a(com.getui.gtc.dyc.b.b bVar) {
        boolean z;
        if (android.text.TextUtils.isEmpty(bVar.a())) {
            com.getui.gtc.dyc.a.a.a.a("url missing for dyc request: " + bVar.g());
            z = false;
        } else {
            z = true;
        }
        if (android.text.TextUtils.isEmpty(bVar.b())) {
            com.getui.gtc.dyc.a.a.a.a("moduleName missing for dyc request: " + bVar.g());
            z = false;
        }
        if (android.text.TextUtils.isEmpty(bVar.c())) {
            com.getui.gtc.dyc.a.a.a.a("appid missing for dyc request: " + bVar.g());
            z = false;
        }
        if (!android.text.TextUtils.isEmpty(bVar.g())) {
            return z;
        }
        com.getui.gtc.dyc.a.a.a.a("version missing for dyc request: " + bVar.g());
        return false;
    }

    public static void b(android.content.Context context, com.getui.gtc.dyc.b.c cVar) {
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        com.getui.gtc.dyc.f.a().c(cVar);
    }
}
