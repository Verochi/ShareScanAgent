package com.bytedance.sdk.openadsdk.downloadnew;

/* loaded from: classes22.dex */
public final class v implements com.bykv.vk.openvk.api.proto.Bridge {
    private static volatile com.bytedance.sdk.openadsdk.downloadnew.v vw;
    private com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder bt;
    private com.ss.android.downloadad.api.download.AdDownloadController kz;
    private com.ss.android.downloadad.api.download.AdDownloadEventConfig o;
    private com.ss.android.downloadad.api.download.AdDownloadModel.Builder t;
    private com.ss.android.downloadad.api.download.AdDownloadModel v;
    private final android.content.Context wg;
    private com.ss.android.downloadad.api.download.AdDownloadController.Builder yl;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.v$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider {
        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) {
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.v$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) {
            return null;
        }
    }

    private v(android.content.Context context) {
        this.wg = context;
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener bt(java.lang.Object obj) {
        if (obj instanceof com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener) {
            return (com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener) obj;
        }
        return null;
    }

    private void es(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z);
        } catch (java.lang.Throwable unused) {
        }
    }

    private android.app.Activity getActivity(java.lang.Object obj) {
        if (obj instanceof android.app.Activity) {
            return (android.app.Activity) obj;
        }
        return null;
    }

    private com.ss.android.download.api.download.DownloadController kz(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.download.DownloadController) {
            return (com.ss.android.download.api.download.DownloadController) obj;
        }
        return null;
    }

    private void kz(int i) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i);
    }

    private void kz(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((java.lang.Long) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        java.lang.String str = (java.lang.String) map.get("md5");
        long longValue2 = ((java.lang.Long) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean booleanValue = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AD)).booleanValue();
        int intValue = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_MODEL_TYPE)).intValue();
        java.util.List<java.lang.String> list = (java.util.List) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_TRACK_URL);
        java.util.List<java.lang.String> list2 = (java.util.List) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_BACK_UP_URLS);
        java.lang.String str2 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        java.lang.String str3 = (java.lang.String) map.get("mimeType");
        java.util.Map<java.lang.String, java.lang.String> map2 = (java.util.Map) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HEADERS);
        boolean booleanValue2 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean booleanValue3 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_NEED_WIFI)).booleanValue();
        java.lang.String str4 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME);
        int intValue2 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE)).intValue();
        java.lang.String str5 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME);
        java.lang.String str6 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.v vw2 = new com.ss.android.download.api.model.v.vw().vw(str6).wg((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).vw();
        int intValue3 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        java.lang.String str7 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_START_TOAST);
        java.lang.String str8 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean booleanValue4 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean booleanValue5 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean booleanValue6 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long longValue3 = ((java.lang.Long) map.get("id")).longValue();
        java.lang.String str9 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_APP_ICON);
        boolean booleanValue7 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean booleanValue8 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        java.lang.String str10 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LOG_EXTRA);
        org.json.JSONObject jSONObject = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON);
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_SETTINGS);
        java.lang.String str11 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_PATH);
        java.lang.String str12 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL);
        java.lang.String str13 = (java.lang.String) map.get("appName");
        java.lang.String str14 = (java.lang.String) map.get("packageName");
        boolean booleanValue9 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        java.lang.String str15 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_OPEN_URL);
        java.lang.String str16 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_TITLE);
        java.lang.String str17 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_URL);
        com.ss.android.downloadad.api.download.AdDownloadModel.Builder fileUriProvider = new com.ss.android.downloadad.api.download.AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5(str).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str4).setVersionCode(intValue2).setVersionName(str5).setQuickAppModel(vw2).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new com.bytedance.sdk.openadsdk.downloadnew.v.AnonymousClass2());
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!android.text.TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!android.text.TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!android.text.TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!android.text.TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(vw(longValue3, str15, str16, str17));
        this.v = this.t.build();
    }

    private com.ss.android.download.api.config.OnItemClickListener o(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.config.OnItemClickListener) {
            return (com.ss.android.download.api.config.OnItemClickListener) obj;
        }
        if (obj instanceof com.bykv.vk.openvk.api.proto.EventListener) {
            return new com.bytedance.sdk.openadsdk.api.vw.bt((com.bykv.vk.openvk.api.proto.EventListener) obj);
        }
        return null;
    }

    private int r() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private com.ss.android.download.api.download.DownloadStatusChangeListener t(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.download.DownloadStatusChangeListener) {
            return (com.ss.android.download.api.download.DownloadStatusChangeListener) obj;
        }
        if (obj instanceof com.bykv.vk.openvk.api.proto.EventListener) {
            return new com.bytedance.sdk.openadsdk.api.vw.yl((com.bykv.vk.openvk.api.proto.EventListener) obj);
        }
        return null;
    }

    private void t(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LINK_MODE)).intValue();
        int intValue2 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean booleanValue = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean booleanValue2 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        java.lang.Object obj = map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_OPERATION);
        boolean booleanValue3 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int intValue3 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        org.json.JSONObject jSONObject = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON);
        java.lang.Object obj2 = map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_OBJECT);
        boolean booleanValue4 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean booleanValue5 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean booleanValue6 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean booleanValue7 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean booleanValue8 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        com.ss.android.downloadad.api.download.AdDownloadController.Builder enableOppoAutoDownload = new com.ss.android.downloadad.api.download.AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setExtraOperation(obj).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson(jSONObject).setExtraObject(obj2).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.yl = enableOppoAutoDownload;
        this.kz = enableOppoAutoDownload.build();
    }

    private com.ss.android.download.api.download.DownloadModel v(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.download.DownloadModel) {
            return (com.ss.android.download.api.download.DownloadModel) obj;
        }
        return null;
    }

    private void v(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        java.lang.String str = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_BUTTON_TAG);
        java.lang.String str2 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_ITEM_TAG);
        java.lang.String str3 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_START);
        java.lang.String str4 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        java.lang.String str5 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_PAUSE);
        java.lang.String str6 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_STORAGE_DENY);
        java.lang.String str7 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        org.json.JSONObject jSONObject = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder isEnableV3Event = new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.bt = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.o = this.bt.build();
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.v vw(android.content.Context context) {
        if (vw == null) {
            synchronized (com.bytedance.sdk.openadsdk.downloadnew.v.class) {
                if (vw == null) {
                    vw = new com.bytedance.sdk.openadsdk.downloadnew.v(context);
                }
            }
        }
        return vw;
    }

    private com.ss.android.download.api.model.DeepLink vw(long j, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.ss.android.download.api.model.DeepLink deepLink = new com.ss.android.download.api.model.DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private com.ss.android.downloadad.api.download.AdDownloadModel.Builder vw(long j, java.lang.String str, boolean z, boolean z2, java.lang.String str2, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, boolean z3, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        com.ss.android.downloadad.api.download.AdDownloadModel.Builder fileUriProvider = new com.ss.android.downloadad.api.download.AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new com.bytedance.sdk.openadsdk.downloadnew.v.AnonymousClass1());
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!android.text.TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(vw(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void vw(int i, int i2, boolean z, boolean z2, boolean z3) {
        com.ss.android.downloadad.api.download.AdDownloadController.Builder isAddToDownloadManage = new com.ss.android.downloadad.api.download.AdDownloadController.Builder().setLinkMode(i).setDownloadMode(i2).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.yl = isAddToDownloadManage;
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            this.yl.setEnableAM(z3);
        }
        this.kz = this.yl.build();
    }

    private void vw(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder = this.t;
        if (builder == null) {
            return;
        }
        this.v = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private static boolean vw(com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private void wg(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        com.ss.android.downloadad.api.download.AdDownloadModel.Builder vw2 = vw(((java.lang.Long) map.get("id")).longValue(), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_APP_ICON), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LOG_EXTRA), (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON), (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_SETTINGS), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_PATH), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL), (java.lang.String) map.get("appName"), (java.lang.String) map.get("packageName"), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_OPEN_URL), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_TITLE), (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_URL));
        this.t = vw2;
        this.v = vw2.build();
    }

    private com.ss.android.download.api.config.IDownloadButtonClickListener x(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.config.IDownloadButtonClickListener) {
            return (com.ss.android.download.api.config.IDownloadButtonClickListener) obj;
        }
        if (obj instanceof com.bykv.vk.openvk.api.proto.EventListener) {
            return new com.bytedance.sdk.openadsdk.api.vw.kz((com.bykv.vk.openvk.api.proto.EventListener) obj);
        }
        return null;
    }

    private com.ss.android.download.api.download.DownloadEventConfig yl(java.lang.Object obj) {
        if (obj instanceof com.ss.android.download.api.download.DownloadEventConfig) {
            return (com.ss.android.download.api.download.DownloadEventConfig) obj;
        }
        return null;
    }

    private void yl(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        java.lang.String str = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_BUTTON_TAG);
        java.lang.String str2 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_ITEM_TAG);
        java.lang.String str3 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_LABEL);
        int intValue = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        java.lang.String str4 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER);
        org.json.JSONObject jSONObject = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON);
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_PARAMS_JSON);
        java.lang.String str5 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_START);
        java.lang.String str6 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        java.lang.String str7 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_PAUSE);
        java.lang.String str8 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_STORAGE_DENY);
        java.lang.String str9 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        org.json.JSONObject jSONObject3 = (org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder paramsJson = new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.bt = paramsJson;
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.o = this.bt.build();
    }

    public java.util.Map<java.lang.String, java.lang.String> a() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public org.json.JSONObject am() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    public java.lang.String ao() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public java.lang.String aq() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public org.json.JSONObject b() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel bt(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z);
    }

    public void bt(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public boolean bt() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public boolean c() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (i != 20) {
            return (T) vw(cls, i, (valueSet == null || valueSet.objectValue(0, java.util.Map.class) == null) ? new java.util.HashMap<>() : (java.util.Map) valueSet.objectValue(0, java.util.Map.class));
        }
        vw((android.os.Bundle) valueSet.objectValue(0, android.os.Bundle.class));
        return null;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel cp(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public boolean cp() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel d(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public boolean d() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public long e() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel es(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public java.lang.Object es() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    public java.lang.String f() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public boolean fu() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public boolean g() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public boolean gu() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    public java.lang.String h() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public int hg() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public boolean hp() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public java.lang.String ih() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public int ip() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public java.lang.String iq() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public java.lang.String iz() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel j(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public boolean j() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public boolean jb() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel k(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    public java.lang.String k() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public void ki() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public java.lang.String kk() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    public boolean kn() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public int kz() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel kz(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z);
    }

    public void kz(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public java.util.List<java.lang.String> l() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public boolean la() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? com.ss.android.download.api.t.wg.vw(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vs()), f()) : adDownloadModel.shouldDownloadWithPatchApply();
    }

    public java.util.List<java.lang.String> lb() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public void m() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public java.lang.String mi() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public java.lang.String ml() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public java.lang.String mp() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public java.lang.String n() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public int o() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel o(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z);
    }

    public void o(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public java.lang.String ol() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public long oo() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public com.ss.android.download.api.model.v p() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public java.lang.String q() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public java.lang.String qc() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public java.lang.String qm() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public boolean qn() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public boolean s() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public java.lang.String sh() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel t(int i) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i);
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel t(long j) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j);
    }

    public void t(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public void t(org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public void t(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z);
    }

    public boolean t() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public java.lang.String te() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public java.lang.Object tj() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public int tn() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public java.lang.String tq() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    public long tv() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel u(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    public boolean u() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public org.json.JSONObject up() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public java.lang.String ux() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel v(int i) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i);
    }

    public java.lang.Object v() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void v(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void v(org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public void v(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(0, com.bytedance.sdk.openadsdk.downloadnew.t.vw).vw(1, java.lang.Boolean.valueOf(com.bytedance.sdk.openadsdk.downloadnew.t.wg)).vw(10000, 3).wg();
    }

    public int vk() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel vl(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public boolean vl() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public org.json.JSONObject vs() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public int vw() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel vw(com.ss.android.download.api.model.v vVar) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(vVar);
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel vw(java.util.List<java.lang.String> list) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel vw(java.util.Map<java.lang.String, java.lang.String> map) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public <T> T vw(java.lang.Class<T> cls, int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        switch (i) {
            case 3:
                com.bytedance.sdk.openadsdk.downloadnew.t.vw(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HID)).intValue());
                break;
            case 4:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
                com.bytedance.sdk.openadsdk.downloadnew.t.vw().vw(adDownloadModel == null ? (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE)).intValue());
                break;
            case 5:
                int intValue = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE)).intValue();
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel2 = this.v;
                com.bytedance.sdk.openadsdk.downloadnew.t.vw().vw(this.wg, intValue, t(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), adDownloadModel2 == null ? v(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODEL)) : v(adDownloadModel2));
                break;
            case 6:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel3 = this.v;
                break;
            case 7:
                com.bytedance.sdk.openadsdk.downloadnew.t.wg();
                break;
            case 8:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel4 = this.v;
                com.bytedance.sdk.openadsdk.downloadnew.t.vw().vw(adDownloadModel4 == null ? (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((java.lang.Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                com.bytedance.sdk.openadsdk.downloadnew.t.vw(((java.lang.Integer) map.get("id")).intValue(), (com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                break;
            case 10:
                com.bytedance.sdk.openadsdk.downloadnew.t.vw((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_PATH));
                break;
            case 12:
                android.net.Uri uri = (android.net.Uri) map.get("uri");
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel5 = this.v;
                com.ss.android.download.api.download.DownloadModel v = adDownloadModel5 == null ? v(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODEL)) : v(adDownloadModel5);
                com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
                com.ss.android.download.api.download.DownloadEventConfig yl = adDownloadEventConfig == null ? yl(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)) : yl(adDownloadEventConfig);
                com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
                com.ss.android.download.api.download.DownloadController kz = adDownloadController == null ? kz(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_CONTROLLER)) : kz(adDownloadController);
                com.ss.android.download.api.config.IDownloadButtonClickListener x = x(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (!vw(x)) {
                    break;
                } else {
                    break;
                }
            case 13:
                int intValue2 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                java.lang.String str = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_USERAGENT);
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel6 = this.v;
                com.ss.android.download.api.download.DownloadModel v2 = adDownloadModel6 == null ? v(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODEL)) : v(adDownloadModel6);
                com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig2 = this.o;
                com.ss.android.download.api.download.DownloadEventConfig yl2 = adDownloadEventConfig2 == null ? yl(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)) : yl(adDownloadEventConfig2);
                com.ss.android.downloadad.api.download.AdDownloadController adDownloadController2 = this.kz;
                com.ss.android.download.api.download.DownloadController kz2 = adDownloadController2 == null ? kz(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_CONTROLLER)) : kz(adDownloadController2);
                com.ss.android.download.api.download.DownloadStatusChangeListener t = t(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                com.ss.android.download.api.config.IDownloadButtonClickListener x2 = x(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (!vw(x2)) {
                    com.bytedance.sdk.openadsdk.downloadnew.t.vw().yl().vw(this.wg, str, booleanValue, v2, yl2, kz2, t, intValue2);
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.downloadnew.t.vw().yl().vw(this.wg, str, booleanValue, v2, yl2, kz2, t, intValue2, x2);
                    break;
                }
            case 14:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel7 = this.v;
                long longValue = adDownloadModel7 == null ? ((java.lang.Long) map.get("id")).longValue() : adDownloadModel7.getId();
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel8 = this.v;
                break;
            case 16:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel9 = this.v;
                java.lang.String downloadUrl = adDownloadModel9 == null ? (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel10 = this.v;
                long longValue2 = adDownloadModel10 == null ? ((java.lang.Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig3 = this.o;
                com.ss.android.download.api.download.DownloadEventConfig yl3 = adDownloadEventConfig3 == null ? yl(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)) : yl(adDownloadEventConfig3);
                com.ss.android.downloadad.api.download.AdDownloadController adDownloadController3 = this.kz;
                com.bytedance.sdk.openadsdk.downloadnew.t.vw().vw(downloadUrl, longValue2, intValue3, yl3, adDownloadController3 == null ? kz(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_CONTROLLER)) : kz(adDownloadController3));
                break;
            case 17:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel11 = this.v;
                java.lang.String downloadUrl2 = adDownloadModel11 == null ? (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((java.lang.Long) map.get("id")).longValue();
                int intValue4 = ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig4 = this.o;
                com.ss.android.download.api.download.DownloadEventConfig yl4 = adDownloadEventConfig4 == null ? yl(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)) : yl(adDownloadEventConfig4);
                com.ss.android.downloadad.api.download.AdDownloadController adDownloadController4 = this.kz;
                com.bytedance.sdk.openadsdk.downloadnew.t.vw().vw(downloadUrl2, longValue3, intValue4, yl4, adDownloadController4 == null ? kz(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_CONTROLLER)) : kz(adDownloadController4), o(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ITEM_CLICK_LISTENER)), x(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                break;
            case 18:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel12 = this.v;
                break;
            case 19:
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel13 = this.v;
                break;
            case 23:
                if (!((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    wg(map);
                    break;
                } else {
                    com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder = new com.ss.android.downloadad.api.download.AdDownloadModel.Builder();
                    this.t = builder;
                    this.v = builder.build();
                    break;
                }
            case 24:
                vw((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_APP_ICON), (java.lang.String) map.get("appName"), (java.lang.String) map.get("packageName"));
                break;
            case 25:
                vw(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_AUTO_OPEN)).intValue(), ((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                break;
            case 26:
                kz(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                break;
            case 28:
                es(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
                break;
            case 29:
                v(map);
                break;
            case 30:
                wg(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                break;
            case 31:
                yl(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                break;
            case 32:
                t(map);
                break;
            case 44:
                vw(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LINK_MODE)).intValue());
                break;
            case 46:
                vw(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                break;
            case 49:
                wg(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                break;
            case 50:
                t(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                break;
            case 53:
                vw(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_OBJECT));
                break;
            case 54:
                vw((org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON));
                break;
            case 56:
                yl(map);
                break;
            case 72:
                wg(map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                break;
            case 73:
                vw((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_BUTTON_TAG));
                break;
            case 74:
                wg((org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                break;
            case 75:
                t((org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_PARAMS_JSON));
                break;
            case 76:
                wg((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_ITEM_TAG));
                break;
            case 78:
                t((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER));
                break;
            case 79:
                v((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                break;
            case 80:
                kz(map);
                break;
            case 98:
                m();
                break;
            case 100:
                ki();
                break;
            case 101:
                ym();
                break;
            case 123:
                yl((java.lang.String) map.get("md5"));
                break;
            case 124:
                vw(((java.lang.Long) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                break;
            case 125:
                v(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_NEED_WIFI)).booleanValue());
                break;
            case 127:
                wg(((java.lang.Long) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_VALUE)).longValue());
                break;
            case 128:
                kz((java.lang.String) map.get("appName"));
                break;
            case 129:
                v((org.json.JSONObject) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_JSON));
                break;
            case 130:
                bt((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_START_TOAST));
                break;
            case 131:
                o((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_SDK_MONITOR_SCENE));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
                t(((java.lang.Long) map.get("id")).longValue());
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
                kz(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AD)).booleanValue());
                break;
            case 134:
                t(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_MODEL_TYPE)).intValue());
                break;
            case 135:
                x((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LOG_EXTRA));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                es((java.lang.String) map.get("packageName"));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                z((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_APP_ICON));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                vw((java.util.List<java.lang.String>) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_TRACK_URL));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL /* 140 */:
                vl((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_DOWNLOAD_URL));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS /* 141 */:
                wg((java.util.List<java.lang.String>) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_BACK_UP_URLS));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL /* 142 */:
                u((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE /* 143 */:
                cp((java.lang.String) map.get("mimeType"));
                break;
            case 144:
                vw((java.util.Map<java.lang.String, java.lang.String>) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HEADERS));
                break;
            case 145:
                bt(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH /* 146 */:
                d((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_PATH));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME /* 147 */:
                j((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME));
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS /* 148 */:
                o(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE /* 149 */:
                v(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE)).intValue());
                break;
            case 150:
                k((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME));
                break;
            case 151:
                vw(new com.ss.android.download.api.model.v.vw().vw((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).wg((java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).vw());
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION /* 152 */:
                x(((java.lang.Boolean) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE /* 153 */:
                yl(((java.lang.Integer) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                break;
        }
        return null;
    }

    public void vw(int i) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i);
    }

    public void vw(long j) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j);
    }

    public void vw(android.os.Bundle bundle) {
        com.bytedance.sdk.openadsdk.downloadnew.t.vw(this.wg);
    }

    public void vw(java.lang.Object obj) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void vw(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void vw(org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void vw(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z);
    }

    public int w() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel wg(java.util.List<java.lang.String> list) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public void wg(int i) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i);
    }

    public void wg(long j) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j);
    }

    public void wg(java.lang.Object obj) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void wg(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void wg(org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public void wg(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z);
    }

    public boolean wg() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public com.ss.android.download.api.model.DeepLink wj() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public java.lang.String wu() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public boolean wy() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel x(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel x(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z);
    }

    public org.json.JSONObject x() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    public boolean xs() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public boolean yg() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel yl(int i) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i);
    }

    public void yl(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void yl(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z);
    }

    public boolean yl() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public void ym() {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel z(java.lang.String str) {
        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = this.v;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public boolean z() {
        com.ss.android.downloadad.api.download.AdDownloadController adDownloadController = this.kz;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public boolean zl() {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig = this.o;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }
}
