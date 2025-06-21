package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public class SplashAdCacheManager implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String MAIN_PAGE = "index.html";
    private static final java.lang.String PREF_KEY_PRE_REQUEST_ID = "pre_request_id";
    private static final java.lang.String PREF_LOCAL_ADV_IDS = "tanx_adsdk_local_adv_ids";
    private static final java.lang.String SPLASH_AD_CACHE_PATH = "ad/splash";
    private static final java.lang.String SPLASH_AD_RESPONSE_CACHE_PATH = "ad/response";
    private static final java.lang.String SPLASH_AD_ZIP_PATH = "zip";
    private static final java.lang.String TAG = "SplashAdCacheManager";
    private static java.lang.String sSplashAdCachePath;
    private static java.lang.String sSplashAdResponseDir;
    private static java.lang.String sSplashAdResponseFile;
    private static java.lang.String sSplashAdZipCachePath;
    private final int DEFAULT_AD_EXPIRED_DAYS;
    private final int DEFAULT_EXPIRED_DAYS;
    private final int DEFAULT_MAX_AD_COUNT;
    private final android.content.Context mContext;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null && file2 != null) {
                return -1;
            }
            if (file != null && file2 == null) {
                return 1;
            }
            if (file.lastModified() < file2.lastModified()) {
                return -1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : 1;
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback assetDownloadCallback) {
            this.tanxc_do = assetDownloadCallback;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownLoadTotal(long j) {
            com.alimm.tanx.core.utils.LogUtils.d("onDownLoadTotal", j + "");
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloadFailed(int i, java.lang.String str) {
            com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback assetDownloadCallback = this.tanxc_do;
            if (assetDownloadCallback != null) {
                assetDownloadCallback.onFail(i, str);
            }
            com.alimm.tanx.core.utils.LogUtils.d("onDownloadFailed", "code:" + i + "  msg:" + str);
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloadSuccess(java.io.File file) {
            com.alimm.tanx.core.utils.LogUtils.d("onDownloadSuccess" + file.getAbsolutePath(), new java.lang.String[0]);
            com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback assetDownloadCallback = this.tanxc_do;
            if (assetDownloadCallback != null) {
                assetDownloadCallback.onSuccess(file);
            }
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloading(int i) {
            com.alimm.tanx.core.utils.LogUtils.d("onDownloading", i + "");
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback {
        final /* synthetic */ java.util.List tanxc_do;

        public AnonymousClass3(java.util.List list) {
            this.tanxc_do = list;
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
        public void onFail(int i, java.lang.String str) {
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
        public void onSuccess(java.io.File file) {
            com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager splashAdCacheManager = com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.this;
            splashAdCacheManager.handleAssetDownloadFinished(splashAdCacheManager.mContext, this.tanxc_do);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.utils.FileUtils.FileKeepRule {
        final /* synthetic */ android.content.Context tanxc_do;

        public AnonymousClass4(android.content.Context context) {
            this.tanxc_do = context;
        }

        @Override // com.alimm.tanx.core.utils.FileUtils.FileKeepRule
        public boolean needKept(java.lang.String str) {
            com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(this.tanxc_do, str, 3);
            return false;
        }
    }

    public static class SingletonHolder implements com.alimm.tanx.core.utils.NotConfused {
        static final com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager INSTANCE = new com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager(null);

        private SingletonHolder() {
        }
    }

    private SplashAdCacheManager() {
        this.DEFAULT_EXPIRED_DAYS = 7;
        this.DEFAULT_AD_EXPIRED_DAYS = 1;
        this.DEFAULT_MAX_AD_COUNT = 15;
        this.mContext = com.alimm.tanx.core.TanxCoreSdk.getApplication();
    }

    public /* synthetic */ SplashAdCacheManager(com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private void deleteAssetForExpired(@androidx.annotation.NonNull android.content.Context context, int i) {
        try {
            com.alimm.tanx.core.utils.FileUtils.deleteExpiredFiles(getSplashAdCacheDirPath(context), i, new com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.AnonymousClass4(context));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "deleteAssetForExpired: exception.", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteAssetForExpired: exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    private void deleteFileForCacheFull(@androidx.annotation.NonNull android.content.Context context, int i, boolean z) {
        java.util.List<java.io.File> files = com.alimm.tanx.core.utils.FileUtils.getFiles(z ? getSplashAdResponseDir(context) : getSplashAdCacheDirPath(context));
        int size = files.size();
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteFileForCacheFull: maxCacheNum = " + i + ", fileCount = " + size);
        if (size >= i) {
            sortFilesByModifyTime(files);
            int i2 = size - (i / 2);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteFileForCacheFull: deleteFileCount = " + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                java.io.File file = files.get(i3);
                com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(context, file.getName(), 4);
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteFileForCacheFull: deleteFile = " + file.getName());
                com.alimm.tanx.core.utils.FileUtils.deleteFile(file);
            }
        }
    }

    public static com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager getInstance() {
        return com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.SingletonHolder.INSTANCE;
    }

    public static java.lang.String getSplashAdCacheDirPath(@androidx.annotation.NonNull android.content.Context context) {
        if (android.text.TextUtils.isEmpty(sSplashAdCachePath)) {
            java.io.File externalDir = com.alimm.tanx.core.utils.FileUtils.getExternalDir(context, 0);
            if (externalDir != null) {
                sSplashAdCachePath = com.alimm.tanx.core.utils.FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
            } else {
                java.io.File externalDir2 = com.alimm.tanx.core.utils.FileUtils.getExternalDir(context, 1);
                if (externalDir2 != null) {
                    sSplashAdCachePath = com.alimm.tanx.core.utils.FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
                }
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getSplashAdCacheDirPath: path = " + sSplashAdCachePath);
        }
        return sSplashAdCachePath;
    }

    public static java.lang.String getSplashAdResponseDir(@androidx.annotation.NonNull android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(sSplashAdResponseDir)) {
                java.io.File externalDir = com.alimm.tanx.core.utils.FileUtils.getExternalDir(context, 0);
                if (externalDir != null) {
                    sSplashAdResponseDir = com.alimm.tanx.core.utils.FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                } else {
                    java.io.File externalDir2 = com.alimm.tanx.core.utils.FileUtils.getExternalDir(context, 1);
                    if (externalDir2 != null) {
                        sSplashAdResponseDir = com.alimm.tanx.core.utils.FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                    }
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "getSplashAdResponseDir: sSplashAdResponseDir = " + sSplashAdResponseDir);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
        return sSplashAdResponseDir;
    }

    public static java.lang.String getSplashAdResponseFile(@androidx.annotation.NonNull android.content.Context context, java.lang.String str) {
        try {
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(sSplashAdResponseFile) || !sSplashAdResponseFile.contains(str)) {
            if (android.text.TextUtils.isEmpty(sSplashAdResponseDir)) {
                getSplashAdResponseDir(context);
            }
            sSplashAdResponseFile = com.alimm.tanx.core.utils.FileUtils.joinPath(sSplashAdResponseDir, str);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getSplashAdResponseFile: fileName = " + sSplashAdResponseFile);
        }
        return sSplashAdResponseFile;
    }

    public static java.lang.String getSplashAdZipCacheDirPath(@androidx.annotation.NonNull android.content.Context context) {
        if (android.text.TextUtils.isEmpty(sSplashAdZipCachePath)) {
            sSplashAdZipCachePath = com.alimm.tanx.core.utils.FileUtils.joinPath(getSplashAdCacheDirPath(context), SPLASH_AD_ZIP_PATH);
        }
        return sSplashAdZipCachePath;
    }

    public static java.lang.String getSplashCacheFile(@androidx.annotation.NonNull android.content.Context context, java.lang.String str) {
        if (!com.alimm.tanx.core.utils.FileUtils.exists(getSplashAdCacheDirPath(context))) {
            return null;
        }
        java.lang.String joinPath = com.alimm.tanx.core.utils.FileUtils.joinPath(getSplashAdCacheDirPath(context), str);
        if (com.alimm.tanx.core.utils.FileUtils.exists(joinPath)) {
            return joinPath;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAssetDownloadFinished(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.IBidInfo> list) {
        java.util.HashMap hashMap = new java.util.HashMap(16);
        for (com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo : list) {
            if (isAssetCached(iBidInfo)) {
                java.lang.String formatTimeInMillis = com.alimm.tanx.core.utils.Utils.formatTimeInMillis(iBidInfo.getReleaseStartTime() * 1000, "yyyy-MM-dd");
                java.lang.String str = hashMap.get(formatTimeInMillis);
                if (android.text.TextUtils.isEmpty(str)) {
                    hashMap.put(formatTimeInMillis, iBidInfo.getCreativeId());
                } else {
                    hashMap.put(formatTimeInMillis, str + "," + iBidInfo.getCreativeId());
                }
            }
        }
        setCacheAdvIds(hashMap);
    }

    private void setCacheAdvIds(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        android.content.SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "setCacheAdvIds: date = " + entry.getKey() + ", cached_ids = " + entry.getValue());
        }
        edit.apply();
    }

    private static void sortFilesByModifyTime(java.util.List<java.io.File> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            java.util.Collections.sort(list, new com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.AnonymousClass1());
        } catch (java.lang.IllegalArgumentException e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "sortFilesByModifyTime: exception.", e);
        }
    }

    public void clearAllCachedAsset() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "clearAllCachedAsset.");
        com.alimm.tanx.core.utils.FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void clearCachedAdvIds() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "clearCachedAdvIds.");
        android.content.SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.clear();
        edit.apply();
    }

    public void deleteAllCachedFiles() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteAllCachedFiles.");
        deleteCachedResponseJson();
        clearAllCachedAsset();
        clearCachedAdvIds();
    }

    public void deleteCachedResponseJson() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteCachedResponseJson.");
        com.alimm.tanx.core.utils.FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void downloadAdAsset(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.IBidInfo> list) {
        downloadAdAsset(list, new com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.AnonymousClass3(list));
    }

    public void downloadAdAsset(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.IBidInfo> list, com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback assetDownloadCallback) {
        com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(this.mContext);
        if (list == null || list.isEmpty()) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "downloadAdAsset no adv information.");
            return;
        }
        java.lang.String splashAdCacheDirPath = getSplashAdCacheDirPath(this.mContext);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "downloadAdAsset cachePath=." + splashAdCacheDirPath);
        for (com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo : list) {
            if (iBidInfo != null) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "下载素材 downloadAdAsset: rs = " + iBidInfo.getCreativePath() + ", name = " + iBidInfo.getCreativeName() + ", RST = " + iBidInfo.getCreativeType() + ", MD5 = " + iBidInfo.getCreativeMd5());
                java.lang.String creativePath = iBidInfo.getCreativePath();
                if (!android.text.TextUtils.isEmpty(creativePath) && !isAssetCached(iBidInfo)) {
                    com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpDownload(new com.alimm.tanx.core.net.bean.DownLoadRequestBean().setPath(splashAdCacheDirPath).setFileName(iBidInfo.getCreativeName()).setTag(iBidInfo.getCreativeName()).setUrl(creativePath), new com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.AnonymousClass2(assetDownloadCallback));
                }
            }
        }
    }

    public java.lang.String getAdvIds(long j) {
        java.lang.String formatTimeInMillis = com.alimm.tanx.core.utils.Utils.formatTimeInMillis(j, "yyyy-MM-dd");
        java.lang.String string = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(formatTimeInMillis, "");
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "getAdvIds: date = " + formatTimeInMillis + ", advIds = " + string);
        return string;
    }

    public java.lang.String getPreRequestId() {
        return this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(PREF_KEY_PRE_REQUEST_ID, "");
    }

    public boolean isAssetCached(@androidx.annotation.NonNull com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo) {
        return isAssetCached(iBidInfo, false);
    }

    public boolean isAssetCached(@androidx.annotation.NonNull com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isAssetCached: filePath = " + getSplashCacheFile(this.mContext, iBidInfo.getCreativeName()) + ", replaceAssetPath = " + z + ", creativeName = " + iBidInfo.getCreativeName());
        return !android.text.TextUtils.isEmpty(r0);
    }

    public boolean isFileMd5Matched(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str) {
        if (bidInfo != null && !android.text.TextUtils.isEmpty(bidInfo.getCreativeMd5()) && !android.text.TextUtils.isEmpty(str)) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "isFileMd5Matched bidInfo.getCreativeMd5= " + bidInfo.getCreativeMd5() + " ---getFilePathMD5String= " + com.alimm.tanx.core.utils.MD5Utils.getFilePathMD5String(str));
            return bidInfo.getCreativeMd5().equalsIgnoreCase(com.alimm.tanx.core.utils.MD5Utils.getFilePathMD5String(str));
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:false ---bidInfo = " + bidInfo);
        if (bidInfo != null && android.text.TextUtils.isEmpty(bidInfo.getCreativeMd5())) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:bidInfo.getCreativeMd5() 为空");
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:本地缓存文件名称MD5 为空");
        return false;
    }

    public void setPreRequestId(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "setPreRequestId: preRequestId = " + str);
        android.content.SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.putString(PREF_KEY_PRE_REQUEST_ID, str);
        edit.apply();
    }

    public void trimLocalCache() {
        deleteAssetForExpired(this.mContext, 7);
        deleteFileForCacheFull(this.mContext, 15, false);
        deleteFileForCacheFull(this.mContext, 15, true);
    }

    public void trimLocalCache2Json() {
        com.alimm.tanx.core.utils.FileUtils.deleteExpiredFile(getSplashAdResponseDir(this.mContext), 1, (com.alimm.tanx.core.utils.FileUtils.FileKeepRule) null);
    }
}
