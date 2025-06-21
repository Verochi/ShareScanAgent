package com.aliyun.common.qupaiokhttp;

/* loaded from: classes.dex */
public final class HttpRequest {
    static {
        com.aliyun.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
    }

    public static void cancel(java.lang.String str) {
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        okhttp3.Call call = com.aliyun.common.qupaiokhttp.OkHttpCallManager.getInstance().getCall(str);
        if (call != null) {
            call.cancel();
        }
        com.aliyun.common.qupaiokhttp.OkHttpCallManager.getInstance().removeCall(str);
    }

    public static void delete(java.lang.String str) {
        delete(str, null, null);
    }

    public static void delete(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, null, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        delete(str, requestParams, null);
    }

    public static void delete(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.DELETE, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.DELETE, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void download(java.lang.String str, java.io.File file) {
        download(str, file, null);
    }

    public static void download(java.lang.String str, java.io.File file, com.aliyun.common.qupaiokhttp.FileDownloadCallback fileDownloadCallback) {
        if (com.aliyun.common.utils.StringUtils.isEmpty(str) || file == null) {
            return;
        }
        new com.aliyun.common.qupaiokhttp.FileDownloadTask(str, file, fileDownloadCallback).execute(new java.lang.Void[0]);
    }

    private static void executeRequest(com.aliyun.common.qupaiokhttp.Method method, java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        if (builder == null) {
            builder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        }
        new com.aliyun.common.qupaiokhttp.OkHttpTask(method, str, requestParams, builder, baseHttpRequestCallback).execute();
    }

    public static void get(java.lang.String str) {
        get(str, null, null);
    }

    public static void get(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("HttpGet:");
        sb.append(str);
        get(str, null, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        get(str, requestParams, null);
    }

    public static void get(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.GET, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        get(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.GET, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str) {
        head(str, null, null);
    }

    public static void head(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, null, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        head(str, requestParams, null);
    }

    public static void head(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.HEAD, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.HEAD, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str) {
        patch(str, null, null);
    }

    public static void patch(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, null, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        patch(str, requestParams, null);
    }

    public static void patch(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.PATCH, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.PATCH, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str) {
        post(str, null, null);
    }

    public static void post(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, null, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        post(str, requestParams, null);
    }

    public static void post(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.POST, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.POST, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str) {
        put(str, null, null);
    }

    public static void put(java.lang.String str, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, null, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams) {
        put(str, requestParams, null);
    }

    public static void put(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.common.qupaiokhttp.Method.PUT, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.common.qupaiokhttp.Method.PUT, str, requestParams, builder, baseHttpRequestCallback);
    }
}
