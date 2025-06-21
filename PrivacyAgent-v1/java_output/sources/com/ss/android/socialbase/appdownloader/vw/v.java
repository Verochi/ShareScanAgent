package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class v {
    public static com.ss.android.socialbase.appdownloader.vw.vw vw(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        java.lang.String savePath = downloadInfo.getSavePath();
        if (android.text.TextUtils.isEmpty(savePath) || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = new java.io.File(savePath);
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo);
        if (str.equals(com.alipay.sdk.m.x.c.c)) {
            return new com.ss.android.socialbase.appdownloader.vw.es(context, obtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals(com.alipay.sdk.m.x.c.d)) {
            return new com.ss.android.socialbase.appdownloader.vw.z(context, obtain, file.getAbsolutePath());
        }
        if (str.equals(com.anythink.expressad.foundation.g.a.j)) {
            return new com.ss.android.socialbase.appdownloader.vw.vl(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new com.ss.android.socialbase.appdownloader.vw.bt(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new com.ss.android.socialbase.appdownloader.vw.o(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            java.lang.String dBJsonString = downloadInfo.getDBJsonString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.CONTENT_URI);
            if (android.text.TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new com.ss.android.socialbase.appdownloader.vw.x(context, obtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new com.ss.android.socialbase.appdownloader.vw.t(context, obtain, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new com.ss.android.socialbase.appdownloader.vw.u(context, obtain, com.ss.android.socialbase.appdownloader.t.vw(downloadInfo.getId(), com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.v.es().v(), new java.io.File(downloadInfo.getSavePath() + java.io.File.separator + downloadInfo.getName())).toString());
    }

    public static boolean vw(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        if (context != null && str != null) {
            java.lang.String wg = com.ss.android.socialbase.appdownloader.t.wg();
            if (!android.text.TextUtils.isEmpty(wg) && !android.text.TextUtils.isEmpty(str)) {
                com.ss.android.socialbase.appdownloader.vw.vw esVar = (com.ss.android.socialbase.appdownloader.kz.yl.v() && str.equals(com.alipay.sdk.m.x.c.c)) ? new com.ss.android.socialbase.appdownloader.vw.es(context, downloadSetting, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.v() && str.equals(com.alipay.sdk.m.x.c.d)) ? new com.ss.android.socialbase.appdownloader.vw.z(context, downloadSetting, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.v() && str.equals(com.anythink.expressad.foundation.g.a.j)) ? new com.ss.android.socialbase.appdownloader.vw.vl(context, downloadSetting, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.yl() && str.equals("o1")) ? new com.ss.android.socialbase.appdownloader.vw.bt(context, downloadSetting, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.yl() && str.equals("o2")) ? new com.ss.android.socialbase.appdownloader.vw.o(context, downloadSetting, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.yl() && str.equals("o3")) ? new com.ss.android.socialbase.appdownloader.vw.x(context, downloadSetting, wg, wg, wg) : (com.ss.android.socialbase.appdownloader.kz.yl.v() && str.equals("custom")) ? new com.ss.android.socialbase.appdownloader.vw.t(context, downloadSetting, wg, jSONObject) : (com.ss.android.socialbase.appdownloader.kz.yl.v() && str.equals("vbi")) ? new com.ss.android.socialbase.appdownloader.vw.u(context, downloadSetting, wg) : null;
                if (esVar != null && esVar.vw()) {
                    return true;
                }
            }
        }
        return false;
    }
}
