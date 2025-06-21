package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class t implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.ss.android.download.api.download.DownloadModel vw;

    public t(com.ss.android.download.api.download.DownloadModel downloadModel) {
        this.vw = downloadModel;
    }

    public boolean a() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean ao() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public com.ss.android.download.api.model.v aq() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public java.util.List<java.lang.String> b() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public long bt() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        switch (i) {
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                te();
                return null;
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                q();
                return null;
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                qm();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) vw((java.lang.String) valueSet.objectValue(223431, java.lang.String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public boolean cp() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public boolean d() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public boolean e() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public java.util.Map<java.lang.String, java.lang.String> es() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public java.lang.String f() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public int h() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public java.lang.String iq() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean iz() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public java.lang.String j() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public java.lang.String k() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public int kk() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public long kz() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public int lb() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public java.lang.String mi() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public boolean n() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public java.lang.String o() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider oo() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public void q() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public void qm() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public boolean s() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public java.lang.String t() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    public void te() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public java.lang.String tj() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public org.json.JSONObject tq() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public int tv() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public boolean u() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public org.json.JSONObject up() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public long v() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, vw()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, wg()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, t()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, v()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, yl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, kz()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, bt()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, o()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, x()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, es()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, z()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, vl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, u()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, cp()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, d()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, j()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, k()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, tq()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, n()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, h()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, iq()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, iz()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, tj()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, w()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, zl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, wy()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, b()).vw(223430, up()).vw(223431, tv()).vw(223432, aq()).vw(223433, e()).vw(223434, oo()).vw(223435, ao()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, lb()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, kk()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, mi()).vw(223432, f()).vw(223433, a()).vw(223434, s()).vw(223435, xs()).wg();
    }

    public boolean vl() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public com.ss.android.download.api.download.DownloadModel vw(java.lang.String str) {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }

    public java.lang.String vw() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public java.lang.String w() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public java.util.List<java.lang.String> wg() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public com.ss.android.download.api.model.DeepLink wy() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public java.lang.String x() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public boolean xs() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public java.lang.String yl() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public boolean z() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public java.lang.String zl() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }
}
