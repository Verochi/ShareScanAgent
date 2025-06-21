package com.ss.android.download.api.t;

/* loaded from: classes19.dex */
public class vw {
    public static android.net.Uri vw(java.lang.String str) {
        return (com.ss.android.socialbase.appdownloader.kz.yl.k() && com.ss.android.downloadlib.addownload.z.x().optInt("enable_honor_market_scheme_opt", 1) == 1) ? new android.net.Uri.Builder().scheme("honormarket").authority(com.ss.android.download.api.constant.BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str).build() : android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)));
    }

    public static boolean vw(android.net.Uri uri) {
        if (uri == null) {
            return false;
        }
        java.lang.String scheme = uri.getScheme();
        if (android.text.TextUtils.isEmpty(scheme)) {
            return false;
        }
        return com.ss.android.downloadlib.addownload.z.x().optInt("market_url_opt", 1) == 0 ? "market".equals(scheme) : "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme);
    }

    public static java.lang.String wg(@androidx.annotation.NonNull android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        return (com.ss.android.downloadlib.addownload.z.x().optInt("market_scheme_opt") == 1 && com.ss.android.socialbase.appdownloader.kz.yl.bt() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) ? pathSegments.get(0) : com.ss.android.download.api.t.wg.vw(uri.getQueryParameter("id"), uri.getQueryParameter(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter(com.anythink.expressad.videocommon.e.b.u));
    }
}
