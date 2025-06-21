package com.efs.sdk.net;

/* loaded from: classes22.dex */
public class NetManager {
    private static final java.lang.String TAG = "OkHttpManager";
    private static android.content.Context mContext;
    private static com.efs.sdk.net.NetConfigManager mNetConfigManager;
    private static com.efs.sdk.base.EfsReporter mReporter;

    /* renamed from: com.efs.sdk.net.NetManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements okhttp3.Interceptor {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // okhttp3.Interceptor
        @org.jetbrains.annotations.NotNull
        public final okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain chain) {
            return chain.proceed(chain.request().newBuilder().url(this.a).build());
        }
    }

    public static void get(java.lang.String str, okhttp3.Callback callback) {
        new okhttp3.OkHttpClient.Builder().eventListenerFactory(com.efs.sdk.net.OkHttpListener.get()).addNetworkInterceptor(new com.efs.sdk.net.OkHttpInterceptor()).build().newCall(new okhttp3.Request.Builder().url(str).build()).enqueue(callback);
    }

    public static com.efs.sdk.net.NetConfigManager getNetConfigManager() {
        return mNetConfigManager;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return mReporter;
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            com.efs.sdk.base.core.util.Log.e(TAG, "init net manager error! parameter is null!");
            return;
        }
        mReporter = efsReporter;
        mNetConfigManager = new com.efs.sdk.net.NetConfigManager(context, efsReporter);
        mContext = context;
    }

    public static void post(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, okhttp3.Callback callback) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : map.keySet()) {
            sb.append(str2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(map.get(str2));
            sb.append("&");
        }
        new okhttp3.OkHttpClient.Builder().eventListenerFactory(com.efs.sdk.net.OkHttpListener.get()).addNetworkInterceptor(new com.efs.sdk.net.OkHttpInterceptor()).build().newCall(new okhttp3.Request.Builder().url(str).post(okhttp3.RequestBody.create(okhttp3.MediaType.parse(com.anythink.expressad.foundation.g.f.g.b.e), sb.toString())).build()).enqueue(callback);
    }

    public static void postJson(java.lang.String str, java.lang.String str2, okhttp3.Callback callback) {
        new okhttp3.OkHttpClient.Builder().eventListenerFactory(com.efs.sdk.net.OkHttpListener.get()).addNetworkInterceptor(new com.efs.sdk.net.OkHttpInterceptor()).build().newCall(new okhttp3.Request.Builder().url(str).post(okhttp3.RequestBody.create(str2, okhttp3.MediaType.parse("application/json;charset=utf-8"))).build()).enqueue(callback);
    }

    public static void postJsonWithUrlUpdate(java.lang.String str, java.lang.String str2, java.lang.String str3, okhttp3.Callback callback) {
        new okhttp3.OkHttpClient.Builder().eventListenerFactory(com.efs.sdk.net.OkHttpListener.get()).addNetworkInterceptor(new com.efs.sdk.net.OkHttpInterceptor()).addInterceptor(new com.efs.sdk.net.NetManager.AnonymousClass1(str2)).build().newCall(new okhttp3.Request.Builder().url(str).post(okhttp3.RequestBody.create(str3, okhttp3.MediaType.parse("application/json;charset=utf-8"))).build()).enqueue(callback);
    }

    public static void updateFile(java.lang.String str, okhttp3.Callback callback) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(mContext.getApplicationInfo().dataDir);
        java.lang.String str2 = java.io.File.separator;
        sb.append(str2);
        sb.append("apm_backup_files");
        sb.append(str2);
        sb.append("65095ece58a9eb5b0adfa5f9_1.0_35121c11_AOSP-on-coral_11_172543991954633533_20240904165201_fg_ucebujava.log");
        java.io.File file = new java.io.File(sb.toString());
        new okhttp3.OkHttpClient.Builder().eventListenerFactory(com.efs.sdk.net.OkHttpListener.get()).addNetworkInterceptor(new com.efs.sdk.net.OkHttpInterceptor()).build().newCall(new okhttp3.Request.Builder().url(str).post(new okhttp3.MultipartBody.Builder().setType(okhttp3.MultipartBody.FORM).addFormDataPart("file", file.getName(), okhttp3.RequestBody.create(file, okhttp3.MediaType.parse(com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE))).build()).build()).enqueue(callback);
    }
}
