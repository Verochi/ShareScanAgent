package com.getui.gs.h.a;

/* loaded from: classes22.dex */
public final class a {
    public static com.getui.gtc.dim.DimRequest.Builder a(java.lang.String str) {
        return new com.getui.gtc.dim.DimRequest.Builder().key(str).caller(com.getui.gtc.dim.Caller.IDO);
    }

    public static java.lang.String a() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.f330s).storageCacheValidTime(0L).useExpiredCacheForReserve(true).build());
        return str == null ? "" : str;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return com.getui.gtc.dim.DimManager.getInstance().setSetting(context, str, com.getui.gtc.dim.Caller.IDO.name(), str2);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a(th);
            return false;
        }
    }

    public static java.lang.String b() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.v).storageCacheValidTime(0L).useExpiredCacheForReserve(true).build());
        return str == null ? "" : str;
    }

    public static java.lang.String c() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.k).storageCacheValidTime(0L).useExpiredCacheForReserve(true).build());
        return str == null ? "" : str;
    }

    public static java.lang.String d() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.u).ramCacheValidTime(0L).storageCacheValidTime(0L).build());
        return str == null ? "" : str;
    }

    public static java.lang.String e() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.w).ramCacheValidTime(0L).storageCacheValidTime(0L).build());
        return (str == null || "其他".equals(str)) ? "" : str;
    }

    public static java.lang.String f() {
        java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(a(com.getui.gtc.extension.distribution.gbd.f.e.b.x).ramCacheValidTime(0L).storageCacheValidTime(0L).build());
        return (str == null || "其他".equals(str)) ? "" : str;
    }
}
