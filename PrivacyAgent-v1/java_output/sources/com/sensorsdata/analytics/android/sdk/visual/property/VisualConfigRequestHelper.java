package com.sensorsdata.analytics.android.sdk.visual.property;

/* loaded from: classes19.dex */
public class VisualConfigRequestHelper {
    private static final java.lang.String TAG = "SA.VP.VisualConfigRequestHelper";
    private volatile android.os.CountDownTimer mCountDownTimer;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback val$callback;
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$version;

        /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper$1$1, reason: invalid class name and collision with other inner class name */
        public class CountDownTimerC04431 extends android.os.CountDownTimer {

            /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C04441 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.StringCallback {
                public C04441() {
                }

                @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
                public void onAfter() {
                }

                @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
                public void onFailure(int i, java.lang.String str) {
                    if (i == 304 || i == 404 || i == 205) {
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.resetTimer();
                        if (i == 205) {
                            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().save2Cache("");
                        }
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.TAG, "requestVisualConfig return 304 Or 404");
                    }
                }

                @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
                public void onResponse(java.lang.String str) {
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.resetTimer();
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback iApiCallback = com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1.this.val$callback;
                    if (iApiCallback != null) {
                        iApiCallback.onSuccess(str);
                    }
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.TAG, "requestVisualConfig success response is " + str);
                }
            }

            public CountDownTimerC04431(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl())) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.TAG, "visualConfigRequest server url is null and return");
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1 anonymousClass1 = com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1.this;
                    java.lang.String requestUrl = com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.getRequestUrl(anonymousClass1.val$context, anonymousClass1.val$version);
                    if (android.text.TextUtils.isEmpty(requestUrl)) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.TAG, "visualConfigRequest request url is null and return");
                    } else {
                        new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET, requestUrl).callback(new com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1.CountDownTimerC04431.C04441()).execute();
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }

        public AnonymousClass1(android.content.Context context, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback iApiCallback) {
            this.val$context = context;
            this.val$version = str;
            this.val$callback = iApiCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.mCountDownTimer != null) {
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.mCountDownTimer.cancel();
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.mCountDownTimer = null;
                }
                com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.mCountDownTimer = new com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1.CountDownTimerC04431(90000L, 30000L);
                com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.this.mCountDownTimer.start();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public interface IApiCallback {
        void onSuccess(java.lang.String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getRequestUrl(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        if (context == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "getRequestUrl context is null and return");
            return null;
        }
        java.lang.String serverUrl = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl();
        if (android.text.TextUtils.isEmpty(serverUrl)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "visualConfigRequest server url is null and return");
            return null;
        }
        int lastIndexOf = serverUrl.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (lastIndexOf != -1) {
            str2 = serverUrl.substring(0, lastIndexOf) + "/config/visualized/Android.conf";
        } else {
            str2 = null;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        android.net.Uri.Builder buildUpon = android.net.Uri.parse(str2).buildUpon();
        if (!android.text.TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter("v", str);
        }
        java.lang.String queryParameter = android.net.Uri.parse(serverUrl).getQueryParameter("project");
        if (!android.text.TextUtils.isEmpty(queryParameter)) {
            buildUpon.appendQueryParameter("project", queryParameter);
        }
        java.lang.String processName = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(context);
        if (!android.text.TextUtils.isEmpty(processName)) {
            buildUpon.appendQueryParameter("app_id", processName);
        }
        return buildUpon.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimer() {
        try {
            try {
                if (this.mCountDownTimer != null) {
                    this.mCountDownTimer.cancel();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        } finally {
            this.mCountDownTimer = null;
        }
    }

    public void requestVisualConfig(android.content.Context context, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback iApiCallback) {
        com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().post(new com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.AnonymousClass1(context, str, iApiCallback));
    }
}
