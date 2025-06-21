package com.huawei.hms.activity;

/* loaded from: classes22.dex */
public class ForegroundBusDelegate implements com.huawei.hms.activity.IBridgeActivityDelegate {
    private static final java.lang.String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
    private static final java.lang.String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
    public static final java.lang.String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final java.lang.String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final java.lang.String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final java.lang.String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final java.lang.String INNER_PKG_NAME = "INNER_PACKAGE_NAME";
    private static final int REQUEST_CODE_BUS = 431057;
    private static final java.lang.String TAG = "ForegroundBusDelegate";
    private static final java.lang.String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
    private java.lang.String foregroundBody;
    private com.huawei.hms.common.internal.RequestHeader foregroundHeader;
    private com.huawei.hms.activity.internal.ForegroundInnerHeader innerHeader = new com.huawei.hms.activity.internal.ForegroundInnerHeader();
    private boolean isUseInnerHms;
    private java.lang.ref.WeakReference<android.app.Activity> mThisWeakRef;
    private com.huawei.hms.common.internal.ResponseHeader responseHeader;

    public class MyAvailableCallBack implements com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack {
        private MyAvailableCallBack() {
        }

        public /* synthetic */ MyAvailableCallBack(com.huawei.hms.activity.ForegroundBusDelegate foregroundBusDelegate, com.huawei.hms.activity.ForegroundBusDelegate.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            if (i == 0) {
                com.huawei.hms.activity.ForegroundBusDelegate.this.startApkHubActivity();
            } else {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.activity.ForegroundBusDelegate.TAG, "version check failed");
                com.huawei.hms.activity.ForegroundBusDelegate.this.errorReturn(0, "apk version is invalid");
            }
        }
    }

    private void biReportRequestEntryForegroundBus() {
        java.util.Map<java.lang.String, java.lang.String> mapFromForegroundRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestEntryStartCore() {
        java.util.Map<java.lang.String, java.lang.String> mapFromForegroundRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestReturnForegroundBus() {
        if (this.foregroundHeader != null) {
            java.util.Map<java.lang.String, java.lang.String> mapFromForegroundRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
            mapFromForegroundRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            com.huawei.hms.common.internal.ResponseHeader responseHeader = this.responseHeader;
            if (responseHeader != null) {
                mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(responseHeader.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", java.lang.String.valueOf(this.responseHeader.getErrorCode()));
            }
            if (getActivity() != null) {
                com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestReturnStartCore() {
        java.util.Map<java.lang.String, java.lang.String> mapFromForegroundRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        com.huawei.hms.common.internal.ResponseHeader responseHeader = this.responseHeader;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", java.lang.String.valueOf(this.responseHeader.getErrorCode()));
        }
        if (getActivity() != null) {
            com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void checkMinVersion() {
        if (getActivity() == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.isUseInnerHms) {
            startApkHubActivity();
            return;
        }
        if (!com.huawei.hms.utils.Util.isAvailableLibExist(getActivity().getApplicationContext())) {
            if (com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "checkMinVersion failed, and no available lib exists.");
                return;
            } else {
                startApkHubActivity();
                return;
            }
        }
        com.huawei.hms.activity.ForegroundBusDelegate.MyAvailableCallBack myAvailableCallBack = new com.huawei.hms.activity.ForegroundBusDelegate.MyAvailableCallBack(this, null);
        com.huawei.hms.adapter.AvailableAdapter availableAdapter = new com.huawei.hms.adapter.AvailableAdapter(this.innerHeader.getApkVersion());
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(getActivity());
        if (isHuaweiMobileServicesAvailable == 0) {
            myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            resolution(getActivity(), availableAdapter, myAvailableCallBack);
        } else {
            myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorReturn(int i, java.lang.String str) {
        com.huawei.hms.support.log.HMSLog.e(TAG, str);
        android.app.Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        com.huawei.hms.activity.internal.BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
        if (responseCallback != null) {
            com.huawei.hms.activity.internal.BusResponseResult innerError = responseCallback.innerError(this.mThisWeakRef.get(), i, str);
            if (innerError == null) {
                activity.setResult(0);
            } else {
                activity.setResult(innerError.getCode(), innerError.getIntent());
            }
        } else {
            activity.setResult(0);
        }
        finishBridgeActivity();
    }

    private void finishBridgeActivity() {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    private android.app.Activity getActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private com.huawei.hms.activity.internal.BusResponseCallback getResponseCallback(java.lang.String str) {
        return com.huawei.hms.activity.internal.ForegroundBusResponseMgr.getInstance().get(str);
    }

    private static void resolution(android.app.Activity activity, com.huawei.hms.adapter.AvailableAdapter availableAdapter, com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApkHubActivity() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "startApkHubActivity");
        android.app.Activity activity = getActivity();
        if (activity == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "startApkHubActivity but activity is null");
            return;
        }
        java.lang.String packageName = this.isUseInnerHms ? activity.getPackageName() : com.huawei.hms.utils.HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
        android.content.Intent intent = new android.content.Intent(this.innerHeader.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
        try {
            intent.setPackage(packageName);
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_IS_FULLSCREEN, com.huawei.hms.utils.UIUtil.isActivityFullscreen(activity));
        intent.setClassName(packageName, UI_JUMP_ACTIVITY_NAME);
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
        intent.putExtra(EXTRA_DELEGATE_NAME, EXTRA_DELEGATE_VALUE);
        try {
            biReportRequestEntryStartCore();
            activity.startActivityForResult(intent, REQUEST_CODE_BUS);
        } catch (android.content.ActivityNotFoundException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "Launch sign in Intent failed. hms is probably being updated：", e);
            errorReturn(0, "launch bus intent failed");
        }
    }

    private void succeedReturn(int i, android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "succeedReturn");
        android.app.Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(i, intent);
        finishBridgeActivity();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return REQUEST_CODE_BUS;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        this.mThisWeakRef = new java.lang.ref.WeakReference<>(activity);
        android.content.Intent intent = activity.getIntent();
        java.lang.String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
        com.huawei.hms.common.internal.RequestHeader requestHeader = new com.huawei.hms.common.internal.RequestHeader();
        this.foregroundHeader = requestHeader;
        if (!requestHeader.fromJson(stringExtra)) {
            errorReturn(0, "header is invalid");
            return;
        }
        this.foregroundBody = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
        com.huawei.hms.activity.internal.ForegroundInnerHeader foregroundInnerHeader = this.innerHeader;
        if (foregroundInnerHeader == null) {
            errorReturn(0, "inner header is invalid");
            return;
        }
        foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
        if (android.text.TextUtils.isEmpty(this.foregroundHeader.getApiName())) {
            errorReturn(0, "action is invalid");
            return;
        }
        biReportRequestEntryForegroundBus();
        if (!android.text.TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "isUseInnerHms: true");
            this.isUseInnerHms = true;
        }
        checkMinVersion();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        biReportRequestReturnForegroundBus();
        this.mThisWeakRef = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != REQUEST_CODE_BUS) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            java.lang.String stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader();
            this.responseHeader = responseHeader;
            com.huawei.hms.utils.JsonUtil.jsonToEntity(stringExtra, responseHeader);
        }
        biReportRequestReturnStartCore();
        com.huawei.hms.activity.internal.BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
        if (responseCallback == null) {
            succeedReturn(i2, intent);
            return true;
        }
        com.huawei.hms.activity.internal.BusResponseResult succeedReturn = responseCallback.succeedReturn(this.mThisWeakRef.get(), i2, intent);
        if (succeedReturn == null) {
            succeedReturn(i2, intent);
            return true;
        }
        succeedReturn(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
    }
}
