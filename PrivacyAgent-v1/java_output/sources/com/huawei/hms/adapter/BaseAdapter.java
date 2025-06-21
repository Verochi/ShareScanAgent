package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class BaseAdapter {
    private static final java.lang.String HMS_SESSION_INVALID = "com.huawei.hms.core.action.SESSION_INVALID";
    private static final java.lang.String TAG = "BaseAdapter";
    private java.lang.ref.WeakReference<android.app.Activity> activityWeakReference;
    private java.lang.ref.WeakReference<com.huawei.hms.support.api.client.ApiClient> api;
    private android.content.Context appContext;
    private com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBackReplay;
    private com.huawei.hms.adapter.BaseAdapter.BaseCallBack callback;
    private java.lang.String jsonHeaderReplay;
    private java.lang.String jsonObjectReplay;
    private com.huawei.hms.adapter.sysobs.SystemObserver observer;
    private android.os.Parcelable parcelableReplay;
    private com.huawei.hms.common.internal.RequestHeader requestHeader = new com.huawei.hms.common.internal.RequestHeader();
    private com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader();
    private java.lang.String transactionId;

    /* renamed from: com.huawei.hms.adapter.BaseAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.huawei.hms.adapter.sysobs.SystemObserver {
        public AnonymousClass1() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(android.content.Intent intent, java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onSolutionResult but id is null");
                com.huawei.hms.adapter.BaseAdapter.BaseCallBack callBack = com.huawei.hms.adapter.BaseAdapter.this.getCallBack();
                if (callBack == null) {
                    com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onSolutionResult baseCallBack null");
                    return true;
                }
                callBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-6));
                return true;
            }
            if (!str.equals(com.huawei.hms.adapter.BaseAdapter.this.transactionId)) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "onSolutionResult + id is :" + str);
            com.huawei.hms.adapter.BaseAdapter.BaseCallBack callBack2 = com.huawei.hms.adapter.BaseAdapter.this.getCallBack();
            if (callBack2 == null) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onResult baseCallBack null");
                return true;
            }
            if (intent == null) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onSolutionResult but data is null");
                java.lang.String responseHeaderForError = com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-7);
                com.huawei.hms.adapter.BaseAdapter baseAdapter = com.huawei.hms.adapter.BaseAdapter.this;
                baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, com.huawei.hms.adapter.BaseAdapter.this.responseHeader, 0L);
                callBack2.onError(responseHeaderForError);
                return true;
            }
            if (com.huawei.hms.adapter.BaseAdapter.this.hasExtraUpdateResult(intent, callBack2) || com.huawei.hms.adapter.BaseAdapter.this.hasExtraPrivacyResult(intent, callBack2)) {
                return true;
            }
            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onComplete for on activity result");
            com.huawei.hms.adapter.BaseAdapter.this.onCompleteResult(intent, callBack2);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            return false;
        }
    }

    public interface BaseCallBack {
        void onComplete(java.lang.String str, java.lang.String str2, android.os.Parcelable parcelable);

        void onError(java.lang.String str);
    }

    public class BaseRequestResultCallback implements com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse>> {
        private java.util.concurrent.atomic.AtomicBoolean isFirstRsp = new java.util.concurrent.atomic.AtomicBoolean(true);

        /* renamed from: com.huawei.hms.adapter.BaseAdapter$BaseRequestResultCallback$1, reason: invalid class name */
        public class AnonymousClass1 implements com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack {
            final /* synthetic */ com.huawei.hms.adapter.BaseAdapter.BaseCallBack val$baseCallBack;

            public AnonymousClass1(com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
                this.val$baseCallBack = baseCallBack;
            }

            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i) {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "complete handleSolutionForHMS, result: " + i);
                if (i != 0) {
                    com.huawei.hms.adapter.BaseAdapter baseAdapter = com.huawei.hms.adapter.BaseAdapter.this;
                    this.val$baseCallBack.onError(baseAdapter.buildResponseWrap(i, baseAdapter.buildBodyStr(i)).toJson());
                } else {
                    com.huawei.hms.utils.HMSPackageManager.getInstance(com.huawei.hms.adapter.BaseAdapter.this.appContext).resetMultiServiceState();
                    com.huawei.hms.adapter.BaseAdapter baseAdapter2 = com.huawei.hms.adapter.BaseAdapter.this;
                    this.val$baseCallBack.onError(baseAdapter2.buildResponseWrap(11, baseAdapter2.buildBodyStr(11)).toJson());
                    com.huawei.hms.adapter.BaseAdapter.this.sendBroadcastAfterResolutionHms();
                }
            }
        }

        public BaseRequestResultCallback() {
        }

        private void handleSolutionForHms(com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
            if (!com.huawei.hms.utils.Util.isAvailableLibExist(com.huawei.hms.adapter.BaseAdapter.this.appContext)) {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "handleSolutionForHms: no Available lib exist");
                baseCallBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-9));
                return;
            }
            android.app.Activity cpActivity = com.huawei.hms.adapter.BaseAdapter.this.getCpActivity();
            if (cpActivity == null || cpActivity.isFinishing()) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "activity is null");
                com.huawei.hms.adapter.BaseAdapter baseAdapter = com.huawei.hms.adapter.BaseAdapter.this;
                baseCallBack.onError(baseAdapter.buildResponseWrap(-3, baseAdapter.buildBodyStr(-3)).toJson());
            } else {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "start handleSolutionForHMS");
                com.huawei.hms.adapter.AvailableAdapter availableAdapter = new com.huawei.hms.adapter.AvailableAdapter(com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION);
                availableAdapter.setCalledBySolutionInstallHms(true);
                availableAdapter.startResolution(cpActivity, new com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.AnonymousClass1(baseCallBack));
            }
        }

        private void handleSolutionIntent(com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack, com.huawei.hms.adapter.CoreBaseResponse coreBaseResponse) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "baseCallBack.onComplete");
            android.app.PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            android.content.Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
            } else {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
            }
        }

        private void resolutionResult(java.lang.String str, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack, com.huawei.hms.adapter.CoreBaseResponse coreBaseResponse, int i) {
            if (!com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                if (!"installHMS".equals(str)) {
                    handleSolutionIntent(baseCallBack, coreBaseResponse);
                    return;
                } else {
                    com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "has resolutin: installHMS, but base-sdk can't support to install HMS");
                    handleSolutionForHms(baseCallBack);
                    return;
                }
            }
            android.app.Activity cpActivity = com.huawei.hms.adapter.BaseAdapter.this.getCpActivity();
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "activity is: " + cpActivity);
            if (cpActivity == null || cpActivity.isFinishing()) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "activity null");
                handleSolutionIntent(baseCallBack, coreBaseResponse);
                return;
            }
            android.app.PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                if (com.huawei.hms.utils.Util.isAvailableLibExist(com.huawei.hms.adapter.BaseAdapter.this.appContext)) {
                    com.huawei.hms.adapter.BaseAdapter.this.startResolution(cpActivity, pendingIntent);
                    return;
                } else {
                    baseCallBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-9));
                    return;
                }
            }
            android.content.Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                if (com.huawei.hms.utils.Util.isAvailableLibExist(com.huawei.hms.adapter.BaseAdapter.this.appContext)) {
                    com.huawei.hms.adapter.BaseAdapter.this.startResolution(cpActivity, intent);
                    return;
                } else {
                    baseCallBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-9));
                    return;
                }
            }
            if (i == 2) {
                com.huawei.hms.adapter.BaseAdapter baseAdapter = com.huawei.hms.adapter.BaseAdapter.this;
                baseCallBack.onError(baseAdapter.getResponseHeaderForError(baseAdapter.responseHeader.getErrorCode()));
            } else {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "hasResolution is true but NO_SOLUTION");
                baseCallBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-4));
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse> resolveResult) {
            com.huawei.hms.adapter.BaseAdapter.BaseCallBack callBack = com.huawei.hms.adapter.BaseAdapter.this.getCallBack();
            if (callBack == null) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "result null");
                callBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-1));
                return;
            }
            com.huawei.hms.adapter.CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "response null");
                callBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-1));
                return;
            }
            if (android.text.TextUtils.isEmpty(value.getJsonHeader())) {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BaseAdapter.TAG, "jsonHeader null");
                callBack.onError(com.huawei.hms.adapter.BaseAdapter.this.getResponseHeaderForError(-1));
                return;
            }
            com.huawei.hms.utils.JsonUtil.jsonToEntity(value.getJsonHeader(), com.huawei.hms.adapter.BaseAdapter.this.responseHeader);
            if (this.isFirstRsp.compareAndSet(true, false)) {
                com.huawei.hms.adapter.BaseAdapter baseAdapter = com.huawei.hms.adapter.BaseAdapter.this;
                baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, com.huawei.hms.adapter.BaseAdapter.this.responseHeader);
            }
            java.lang.String resolution = com.huawei.hms.adapter.BaseAdapter.this.responseHeader.getResolution();
            int statusCode = com.huawei.hms.adapter.BaseAdapter.this.responseHeader.getStatusCode();
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BaseAdapter.TAG, "api is: " + com.huawei.hms.adapter.BaseAdapter.this.responseHeader.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
            resolutionResult(resolution, callBack, value, statusCode);
        }
    }

    public static class MPendingResultImpl extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse>, com.huawei.hms.adapter.CoreBaseResponse> {
        public MPendingResultImpl(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse> onComplete(com.huawei.hms.adapter.CoreBaseResponse coreBaseResponse) {
            com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse> resolveResult = new com.huawei.hms.support.api.ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(com.huawei.hms.support.api.client.Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(com.huawei.hms.support.api.client.ApiClient apiClient) {
        this.api = new java.lang.ref.WeakReference<>(apiClient);
        this.appContext = apiClient.getContext().getApplicationContext();
        com.huawei.hms.support.log.HMSLog.i(TAG, "In constructor, WeakReference is " + this.api);
    }

    public BaseAdapter(com.huawei.hms.support.api.client.ApiClient apiClient, android.app.Activity activity) {
        this.api = new java.lang.ref.WeakReference<>(apiClient);
        this.activityWeakReference = new java.lang.ref.WeakReference<>(activity);
        this.appContext = activity.getApplicationContext();
        com.huawei.hms.support.log.HMSLog.i(TAG, "In constructor, activityWeakReference is " + this.activityWeakReference + ", activity is " + this.activityWeakReference.get());
    }

    private com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.adapter.CoreBaseResponse>> baseRequest(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.adapter.CoreBaseRequest coreBaseRequest) {
        return new com.huawei.hms.adapter.BaseAdapter.MPendingResultImpl(apiClient, str, coreBaseRequest);
    }

    private void biReportRequestEntryIpc(android.content.Context context, com.huawei.hms.common.internal.RequestHeader requestHeader) {
        java.util.Map<java.lang.String, java.lang.String> mapFromRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    private void biReportRequestEntrySolution(android.content.Context context, com.huawei.hms.common.internal.RequestHeader requestHeader) {
        java.util.Map<java.lang.String, java.lang.String> mapFromRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biReportRequestReturnIpc(android.content.Context context, com.huawei.hms.common.internal.ResponseHeader responseHeader) {
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance();
        java.util.Map<java.lang.String, java.lang.String> mapFromRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biReportRequestReturnSolution(android.content.Context context, com.huawei.hms.common.internal.ResponseHeader responseHeader, long j) {
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance();
        java.util.Map<java.lang.String, java.lang.String> mapFromRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, java.lang.String.valueOf(j));
        mapFromRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String buildBodyStr(int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "buildBodyStr failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.hms.common.internal.ResponseWrap buildResponseWrap(int i, java.lang.String str) {
        setResponseHeader(i);
        com.huawei.hms.common.internal.ResponseWrap responseWrap = new com.huawei.hms.common.internal.ResponseWrap(this.responseHeader);
        responseWrap.setBody(str);
        return responseWrap;
    }

    private com.huawei.hms.adapter.BaseAdapter.BaseCallBack getBaseCallBackReplay() {
        return this.baseCallBackReplay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.hms.adapter.BaseAdapter.BaseCallBack getCallBack() {
        com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack = this.callback;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        com.huawei.hms.support.log.HMSLog.e(TAG, "callback null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.app.Activity getCpActivity() {
        if (this.activityWeakReference == null) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "activityWeakReference is " + this.activityWeakReference);
            return null;
        }
        com.huawei.hms.support.api.client.ApiClient apiClient = this.api.get();
        if (apiClient == null) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "tmpApi is null");
            return null;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "activityWeakReference has " + this.activityWeakReference.get());
        return com.huawei.hms.utils.Util.getActiveActivity(this.activityWeakReference.get(), apiClient.getContext());
    }

    private java.lang.String getJsonHeaderReplay() {
        return this.jsonHeaderReplay;
    }

    private java.lang.String getJsonObjectReplay() {
        return this.jsonObjectReplay;
    }

    private android.os.Parcelable getParcelableReplay() {
        return this.parcelableReplay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getResponseHeaderForError(int i) {
        setResponseHeader(i);
        return this.responseHeader.toJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasExtraPrivacyResult(android.content.Intent intent, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        if (!intent.hasExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        if (intent.getIntExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001) == 1001) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "privacy_statement_confirm_result agreed, replay request");
            replayRequest();
            return true;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "privacy_statement_confirm_result rejected");
        baseCallBack.onError(buildResponseWrap(com.huawei.hms.adapter.internal.CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, buildBodyStr(com.huawei.hms.adapter.internal.CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasExtraUpdateResult(android.content.Intent intent, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        if (!intent.hasExtra(com.huawei.hms.update.kpms.KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(com.huawei.hms.update.kpms.KpmsConstant.KIT_UPDATE_RESULT, 0);
        com.huawei.hms.support.log.HMSLog.i(TAG, "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "kit update success,replay request");
            replayRequest();
        } else {
            com.huawei.hms.support.log.HMSLog.e(TAG, "kit update failed");
            baseCallBack.onError(buildResponseWrap(-10, buildBodyStr(intExtra)).toJson());
        }
        return true;
    }

    private void initObserver() {
        this.observer = new com.huawei.hms.adapter.BaseAdapter.AnonymousClass1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteResult(android.content.Intent intent, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        long j;
        java.lang.String stringExtra = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.JSON_HEADER);
        java.lang.String stringExtra2 = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.JSON_BODY);
        java.lang.Object infoFromJsonobject = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(stringExtra, com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE);
        java.lang.Object infoFromJsonobject2 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            java.lang.Object infoFromJsonobject3 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof java.lang.Long) {
                j = ((java.lang.Long) infoFromJsonobject3).longValue();
                if ((infoFromJsonobject instanceof java.lang.Integer) || !(infoFromJsonobject2 instanceof java.lang.Integer)) {
                    getResponseHeaderForError(-8);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                } else {
                    int intValue = ((java.lang.Integer) infoFromJsonobject).intValue();
                    getResponseHeaderForError(((java.lang.Integer) infoFromJsonobject2).intValue());
                    this.responseHeader.setStatusCode(intValue);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j = 0;
        if (infoFromJsonobject instanceof java.lang.Integer) {
        }
        getResponseHeaderForError(-8);
        biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    private void replayRequest() {
        if (this.jsonHeaderReplay == null || this.baseCallBackReplay == null) {
            return;
        }
        this.responseHeader = null;
        this.responseHeader = new com.huawei.hms.common.internal.ResponseHeader();
        baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcastAfterResolutionHms() {
        if (this.appContext == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        android.content.Intent intent = new android.content.Intent(HMS_SESSION_INVALID);
        intent.setPackage(this.appContext.getPackageName());
        this.appContext.sendBroadcast(intent);
    }

    private void setBaseCallBackReplay(com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        this.baseCallBackReplay = baseCallBack;
    }

    private void setJsonHeaderReplay(java.lang.String str) {
        this.jsonHeaderReplay = str;
    }

    private void setJsonObjectReplay(java.lang.String str) {
        this.jsonObjectReplay = str;
    }

    private void setParcelableReplay(android.os.Parcelable parcelable) {
        this.parcelableReplay = parcelable;
    }

    private void setReplayData(java.lang.String str, java.lang.String str2, android.os.Parcelable parcelable, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        setJsonHeaderReplay(str);
        setJsonObjectReplay(str2);
        setParcelableReplay(parcelable);
        setBaseCallBackReplay(baseCallBack);
    }

    private void setResponseHeader(int i) {
        this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
        this.responseHeader.setAppID(this.requestHeader.getAppID());
        this.responseHeader.setApiName(this.requestHeader.getApiName());
        this.responseHeader.setSrvName(this.requestHeader.getSrvName());
        this.responseHeader.setPkgName(this.requestHeader.getPkgName());
        this.responseHeader.setStatusCode(1);
        this.responseHeader.setErrorCode(i);
        this.responseHeader.setErrorReason("Core error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startResolution(android.app.Activity activity, android.os.Parcelable parcelable) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "startResolution");
        com.huawei.hms.common.internal.RequestHeader requestHeader = this.requestHeader;
        if (requestHeader != null) {
            biReportRequestEntrySolution(this.appContext, requestHeader);
        }
        if (this.observer == null) {
            initObserver();
        }
        com.huawei.hms.adapter.sysobs.SystemManager.getSystemNotifier().registerObserver(this.observer);
        android.content.Intent intentStartBridgeActivity = com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.adapter.ui.BaseResolutionAdapter.class.getName());
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.transactionId);
        activity.startActivity(intentStartBridgeActivity);
    }

    public void baseRequest(java.lang.String str, java.lang.String str2, android.os.Parcelable parcelable, com.huawei.hms.adapter.BaseAdapter.BaseCallBack baseCallBack) {
        setReplayData(str, str2, parcelable, baseCallBack);
        if (this.api == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "client is null");
            baseCallBack.onError(getResponseHeaderForError(-2));
            return;
        }
        this.callback = baseCallBack;
        com.huawei.hms.utils.JsonUtil.jsonToEntity(str, this.requestHeader);
        com.huawei.hms.adapter.CoreBaseRequest coreBaseRequest = new com.huawei.hms.adapter.CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        java.lang.String apiName = this.requestHeader.getApiName();
        if (android.text.TextUtils.isEmpty(apiName)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "get uri null");
            baseCallBack.onError(getResponseHeaderForError(-5));
            return;
        }
        java.lang.String transactionId = this.requestHeader.getTransactionId();
        this.transactionId = transactionId;
        if (android.text.TextUtils.isEmpty(transactionId)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "get transactionId null");
            baseCallBack.onError(getResponseHeaderForError(-6));
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.transactionId);
        biReportRequestEntryIpc(this.appContext, this.requestHeader);
        baseRequest(this.api.get(), apiName, coreBaseRequest).setResultCallback(new com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback());
    }
}
