package com.sensorsdata.sf.core.http;

/* loaded from: classes19.dex */
public class HttpRequestHelper {
    private static final java.lang.String PLATFORM_TYPE = "ANDROID";
    private static final java.lang.String POP_CONFIGS_URL = "%s/sfo/user_popup_configs?distinct_id=%s&project=%s&platform=%s&sdk_version=%s";
    private static final java.lang.String POP_DISPLAY_STATE_URL = "%s/sfo/popup_displays?popup_display_uuids=%s&project=%s";
    private static final java.lang.String POP_INFO_URL = "%s/sfo/popup_windows/%s?project=%s&platform=%s&sdk_version=%s&distinct_id=%s";
    private static final java.lang.String TAG = "HttpRequestHelper";
    private static com.sensorsdata.sf.core.http.HttpRequestHelper instance;
    private java.lang.String mBaseUrl;
    private java.util.Map<java.lang.String, java.lang.String> mProjectMap = new java.util.HashMap();
    private com.sensorsdata.sf.core.http.internal.HttpClient mHttpClient = new com.sensorsdata.sf.core.http.internal.HttpClient.Builder().build();

    private HttpRequestHelper(java.lang.String str) {
        this.mBaseUrl = str;
    }

    private java.lang.String getProject() {
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
            java.lang.reflect.Method declaredMethod = sharedInstance.getClass().getDeclaredMethod("getServerUrl", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.String str = (java.lang.String) declaredMethod.invoke(sharedInstance, new java.lang.Object[0]);
            if (android.text.TextUtils.isEmpty(str)) {
                return "default";
            }
            java.lang.String str2 = this.mProjectMap.get(str);
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = android.net.Uri.parse(str).getQueryParameter("project");
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "http request project = " + str2);
                if (android.text.TextUtils.isEmpty(str2)) {
                    return "default";
                }
                this.mProjectMap.put(str, str2);
            }
            return str2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return "default";
        }
    }

    public static com.sensorsdata.sf.core.http.HttpRequestHelper shareInstance() {
        if (instance == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "The static method getInstance(String baseUrl) should be called before calling getInstance()");
        }
        return instance;
    }

    public static com.sensorsdata.sf.core.http.HttpRequestHelper shareInstance(java.lang.String str) {
        if (instance == null) {
            instance = new com.sensorsdata.sf.core.http.HttpRequestHelper(str);
        }
        return instance;
    }

    public java.lang.String pullEventConfig(java.lang.String str) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String format = java.lang.String.format(POP_CONFIGS_URL, this.mBaseUrl, java.net.URLEncoder.encode(str, "UTF-8"), getProject(), "ANDROID", com.sensorsdata.sf.android.sdk.BuildConfig.VERSION_NAME);
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "PullEventConfig url = " + format);
        com.sensorsdata.sf.core.http.internal.ResponseBody submit = this.mHttpClient.makeHttpCall(new com.sensorsdata.sf.core.http.internal.HttpRequest.Builder().url(format).build()).submit();
        if (submit != null) {
            return submit.body();
        }
        return null;
    }

    public void pullWindowInfo(java.lang.String str, com.sensorsdata.sf.core.http.internal.HttpCallBack httpCallBack) {
        try {
            java.lang.String format = java.lang.String.format(POP_INFO_URL, this.mBaseUrl, str, getProject(), "ANDROID", com.sensorsdata.sf.android.sdk.BuildConfig.VERSION_NAME, com.sensorsdata.sf.core.SFContextManger.getInstance().getDistinctId());
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "PullWindowInfo url = " + format);
            com.sensorsdata.sf.core.http.internal.HttpCall makeHttpCall = this.mHttpClient.makeHttpCall(new com.sensorsdata.sf.core.http.internal.HttpRequest.Builder().url(format).build());
            makeHttpCall.setHttpCallBack(httpCallBack);
            makeHttpCall.execute();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public java.lang.String pullWindowState(java.lang.String str) {
        try {
            java.lang.String format = java.lang.String.format(POP_DISPLAY_STATE_URL, this.mBaseUrl, str, getProject());
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "PullWindowState url = " + format);
            com.sensorsdata.sf.core.http.internal.ResponseBody submit = this.mHttpClient.makeHttpCall(new com.sensorsdata.sf.core.http.internal.HttpRequest.Builder().url(format).build()).submit();
            if (submit != null) {
                return submit.body();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }
}
