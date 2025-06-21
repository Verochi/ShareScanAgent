package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadSettingsUtils {
    public static boolean isOptimizeAddListener(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OptimizeForError.OPTIMIZE_ADD_LISTENER) == 1;
    }

    public static boolean isOptimizeHeadRequest(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OptimizeForError.OPTIMIZE_HEAD_REQUEST) == 1;
    }

    public static boolean isOptimizeSavePath(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OptimizeForError.OPTIMIZE_SAVE_PATH) == 1;
    }
}
