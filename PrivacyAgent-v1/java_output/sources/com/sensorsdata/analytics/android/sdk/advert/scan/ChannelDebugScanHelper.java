package com.sensorsdata.analytics.android.sdk.advert.scan;

/* loaded from: classes19.dex */
public class ChannelDebugScanHelper implements com.sensorsdata.analytics.android.sdk.advert.scan.IAdvertScanListener {

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass1(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.trackChannelDebugInstallation(this.val$activity);
            com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.showChannelDebugActiveDialog(this.val$activity);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass2(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$activity);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass3(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                android.app.Activity activity = this.val$activity;
                jSONObject.put("$ios_install_source", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(activity, com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(activity), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(this.val$activity), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(this.val$activity)));
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName("$ChannelDebugInstall").setProperties(jSONObject));
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
                jSONObject2.put("$first_visit_time", new java.util.Date());
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET_ONCE).setProperties(jSONObject2));
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$4, reason: invalid class name */
    public static class AnonymousClass4 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ java.lang.String val$accountId;
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ java.lang.String val$baseUrl;
        final /* synthetic */ java.lang.String val$monitorId;
        final /* synthetic */ java.lang.String val$projectId;

        /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
            final /* synthetic */ com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog val$loadingDialog;

            public AnonymousClass1(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog sensorsDataLoadingDialog) {
                this.val$loadingDialog = sensorsDataLoadingDialog;
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onFailure(int i, java.lang.String str) {
                this.val$loadingDialog.dismiss();
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "ChannelDebug request error:" + str);
                android.app.Activity activity = com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4.this.val$activity;
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_request));
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onResponse(org.json.JSONObject jSONObject) {
                this.val$loadingDialog.dismiss();
                if (jSONObject == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "ChannelDebug response error msg: response is null");
                    android.app.Activity activity = com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4.this.val$activity;
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_whitelist));
                } else {
                    if (jSONObject.optInt("code", 0) == 1) {
                        com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.showChannelDebugActiveDialog(com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4.this.val$activity);
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "ChannelDebug response error msg:" + jSONObject.optString("message"));
                    android.app.Activity activity2 = com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4.this.val$activity;
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity2, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity2, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_whitelist));
                }
            }
        }

        public AnonymousClass4(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.val$activity = activity;
            this.val$baseUrl = str;
            this.val$monitorId = str2;
            this.val$projectId = str3;
            this.val$accountId = str4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            android.content.Context applicationContext = this.val$activity.getApplicationContext();
            boolean isTrackInstallation = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isTrackInstallation();
            if (isTrackInstallation && !com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isCorrectTrackInstallation()) {
                com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.showChannelDebugErrorDialog(this.val$activity);
                return;
            }
            java.lang.String identifier = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(applicationContext);
            java.lang.String openAdIdentifier = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(applicationContext);
            if (isTrackInstallation && !com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isGetDeviceInfo(identifier, openAdIdentifier)) {
                com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.showChannelDebugErrorDialog(this.val$activity);
                return;
            }
            if (!com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable(applicationContext)) {
                android.app.Activity activity = this.val$activity;
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_network));
                return;
            }
            android.app.Activity activity2 = this.val$activity;
            java.lang.String deviceInfo = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(activity2, identifier, openAdIdentifier, com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(activity2));
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog sensorsDataLoadingDialog = new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog(this.val$activity);
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
            com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.requestActiveChannel(this.val$baseUrl, this.val$monitorId, this.val$projectId, this.val$accountId, deviceInfo, isTrackInstallation, new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4.AnonymousClass1(sensorsDataLoadingDialog));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$5, reason: invalid class name */
    public static class AnonymousClass5 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass5(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$activity);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper$6, reason: invalid class name */
    public static class AnonymousClass6 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass6(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestActiveChannel(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("monitor_id", str2);
            jSONObject.put("distinct_id", com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId());
            jSONObject.put("project_id", str3);
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID, str4);
            jSONObject.put("has_active", z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            jSONObject.put("device_code", str5);
            new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST, str + "/api/sdk/channel_tool/url").jsonData(jSONObject.toString()).callback(httpCallback).execute();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void showChannelDebugActiveDialog(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_title), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_content), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_activate), new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass1(activity), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_cancel), new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass2(activity));
    }

    public static void showChannelDebugDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_starting), "", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_ok), new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass4(activity, str, str2, str3, str4), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_cancel), new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass5(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showChannelDebugErrorDialog(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_debug_fail_title), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_debug_fail_content), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_dialog_ok), new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass6(activity), null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void trackChannelDebugInstallation(android.app.Activity activity) {
        new java.lang.Thread(new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper.AnonymousClass3(activity)).start();
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.scan.IAdvertScanListener
    public void handlerScanUri(android.app.Activity activity, android.net.Uri uri) {
        if (com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmByMetaData(activity)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_listener));
            return;
        }
        java.lang.String queryParameter = uri.getQueryParameter("monitor_id");
        if (android.text.TextUtils.isEmpty(queryParameter)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        java.lang.String serverUrl = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl();
        if (android.text.TextUtils.isEmpty(serverUrl)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_url));
            return;
        }
        com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl serverUrl2 = new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(serverUrl);
        if (!serverUrl2.getProject().equals(uri.getQueryParameter("project_name"))) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_project));
            return;
        }
        java.lang.String queryParameter2 = uri.getQueryParameter("project_id");
        java.lang.String queryParameter3 = uri.getQueryParameter(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID);
        if (!"1".equals(uri.getQueryParameter("is_relink"))) {
            showChannelDebugDialog(activity, serverUrl2.getBaseUrl(), queryParameter, queryParameter2, queryParameter3);
        } else if (com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.checkDeviceInfo(activity, uri.getQueryParameter("device_code"))) {
            showChannelDebugActiveDialog(activity);
        } else {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_error_retry));
        }
    }
}
