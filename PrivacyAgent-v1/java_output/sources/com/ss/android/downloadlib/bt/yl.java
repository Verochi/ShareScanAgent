package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class yl {
    public static boolean bt(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("clean_app_cache_dir", 0) == 1;
    }

    public static boolean kz(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("clean_space_switch", 0) == 1;
    }

    public static int t(@androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel) {
        return vw(wg(downloadModel));
    }

    public static long t(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean t() {
        return com.ss.android.downloadlib.addownload.z.x().optInt("is_enable_start_install_again") == 1;
    }

    public static boolean t(com.ss.android.downloadad.api.vw.vw vwVar) {
        return vw(vwVar).optInt("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && vwVar.k();
    }

    public static long v() {
        long optLong = com.ss.android.downloadlib.addownload.z.x().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static boolean v(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    public static double vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optDouble("clean_min_install_size", 0.0d);
    }

    public static int vw(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting vw(com.ss.android.downloadad.api.vw.vw vwVar) {
        return vwVar == null ? com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal() : vwVar.tq() != 0 ? com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vwVar.tq()) : vwVar.t() ? com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vw()) : vwVar.te() != null ? com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vwVar.te()) : com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal();
    }

    @androidx.annotation.Nullable
    public static org.json.JSONObject vw() {
        return com.ss.android.downloadlib.addownload.z.x().optJSONObject(com.umeng.analytics.pro.bo.aC);
    }

    public static org.json.JSONObject vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.x(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long wg(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("storage_min_size", 0L);
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting wg(com.ss.android.download.api.download.DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vw(downloadModel));
    }

    public static boolean wg() {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static boolean wg(com.ss.android.downloadad.api.vw.vw vwVar) {
        return vw(vwVar).optInt("pause_reserve_on_wifi", 0) == 1 && vwVar.k();
    }

    public static boolean wg(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static long yl() {
        long optLong = com.ss.android.downloadlib.addownload.z.x().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static boolean yl(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("clean_space_before_download_switch", 0L) == 1;
    }
}
