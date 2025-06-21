package com.sensorsdata.analytics.android.sdk.remote;

/* loaded from: classes19.dex */
public class SensorsDataRemoteManagerDebug extends com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager {
    private static final java.lang.String TAG = "SA.SensorsDataRemoteManagerDebug";
    private java.lang.String errorMsg;

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$eventProperties;

        public AnonymousClass1(org.json.JSONObject jSONObject) {
            this.val$eventProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppRemoteConfigChanged").setProperties(this.val$eventProperties).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ android.net.Uri val$uri;

        /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.StringCallback {
            final /* synthetic */ com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog val$loadingDialog;

            /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug$2$1$1, reason: invalid class name and collision with other inner class name */
            public class DialogInterfaceOnClickListenerC04411 implements android.content.DialogInterface.OnClickListener {
                public DialogInterfaceOnClickListenerC04411() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity);
                }
            }

            public AnonymousClass1(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog sensorsDataLoadingDialog) {
                this.val$loadingDialog = sensorsDataLoadingDialog;
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onAfter() {
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onFailure(int i, java.lang.String str) {
                this.val$loadingDialog.dismiss();
                android.app.Activity activity = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity;
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_fail));
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was failed,code is " + i + ",errorMessage is" + str);
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onResponse(java.lang.String str) {
                this.val$loadingDialog.dismiss();
                if (android.text.TextUtils.isEmpty(str)) {
                    android.app.Activity activity = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity;
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_other_error));
                } else {
                    com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sDKRemoteConfig = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.this.toSDKRemoteConfig(str);
                    java.lang.String queryParameter = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$uri.getQueryParameter("nv");
                    if (sDKRemoteConfig.getNewVersion().equals(queryParameter)) {
                        android.app.Activity activity2 = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity;
                        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity2, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity2, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_succeed));
                        com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.this.setSDKRemoteConfig(sDKRemoteConfig);
                    } else {
                        android.app.Activity activity3 = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity;
                        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity3, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity3, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_version_error), java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_version_tip), sDKRemoteConfig.getNewVersion(), queryParameter), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.this.val$activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_ok), new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.AnonymousClass1.DialogInterfaceOnClickListenerC04411(), null, null);
                    }
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was successful,response data is " + str);
            }
        }

        public AnonymousClass2(android.app.Activity activity, android.net.Uri uri) {
            this.val$activity = activity;
            this.val$uri = uri;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog sensorsDataLoadingDialog = new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog(this.val$activity);
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
            com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.this.requestRemoteConfig(false, (com.sensorsdata.analytics.android.sdk.network.HttpCallback.StringCallback) new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2.AnonymousClass1(sensorsDataLoadingDialog));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass3(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$activity);
        }
    }

    public SensorsDataRemoteManagerDebug(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.content.Context context) {
        super(sensorsDataAPI, sensorsDataAPI.getSAContextManager());
        this.errorMsg = "";
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Construct a SensorsDataRemoteManagerDebug");
    }

    private boolean verifyRemoteRequestParameter(android.net.Uri uri, android.app.Activity activity) {
        boolean z;
        java.lang.String queryParameter = uri.getQueryParameter("app_id");
        java.lang.String queryParameter2 = uri.getQueryParameter("os");
        java.lang.String queryParameter3 = uri.getQueryParameter("project");
        java.lang.String queryParameter4 = uri.getQueryParameter("nv");
        java.lang.String serverUrl = this.mSensorsDataAPI.getServerUrl();
        java.lang.String project = !android.text.TextUtils.isEmpty(serverUrl) ? new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(serverUrl).getProject() : "";
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: ServerUrl is " + serverUrl);
        if (com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable(this.mContextManager.getContext())) {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI = this.mSensorsDataAPI;
            if (sensorsDataAPI != null && !sensorsDataAPI.isNetworkRequestEnable()) {
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_disable_network);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "enableNetworkRequest is false");
            } else if (this.mDisableDefaultRemoteConfig) {
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_disable_remote);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "disableDefaultRemoteConfig is true");
            } else if (!project.equals(queryParameter3)) {
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_project);
            } else if (!"Android".equals(queryParameter2)) {
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_os);
            } else if (!com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(activity).equals(queryParameter)) {
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_appid);
            } else {
                if (!android.text.TextUtils.isEmpty(queryParameter4)) {
                    z = true;
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Uri is " + uri.toString());
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: The verification result is " + z);
                    return z;
                }
                this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_qrcode);
            }
        } else {
            this.errorMsg = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_tip_error_network);
        }
        z = false;
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Uri is " + uri.toString());
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: The verification result is " + z);
        return z;
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void applySDKConfigFromCache() {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Running applySDKConfigFromCache");
    }

    public void checkRemoteConfig(android.net.Uri uri, android.app.Activity activity) {
        if (verifyRemoteRequestParameter(uri, activity)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_title), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_remote_config), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_continue), new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass2(activity, uri), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_cancel), new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass3(activity));
        } else {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, this.errorMsg);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void pullSDKConfigFromServer() {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Running pullSDKConfigFromServer");
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Running requestRemoteConfig");
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void resetPullSDKConfigTimer() {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Running resetPullSDKConfigTimer");
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void setSDKRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("$app_remote_config", sensorsDataSDKRemoteConfig.toJson().put("debug", true).toString());
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug.AnonymousClass1(jSONObject));
            this.mSensorsDataAPI.flush();
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sensorsDataSDKRemoteConfig;
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: The remote configuration takes effect immediately");
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
