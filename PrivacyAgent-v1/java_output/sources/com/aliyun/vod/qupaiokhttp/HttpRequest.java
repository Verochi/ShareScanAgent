package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public final class HttpRequest {
    public static void cancel(java.lang.String str) {
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        okhttp3.Call call = com.aliyun.vod.qupaiokhttp.OkHttpCallManager.getInstance().getCall(str);
        if (call != null) {
            call.cancel();
        }
        com.aliyun.vod.qupaiokhttp.OkHttpCallManager.getInstance().removeCall(str);
    }

    public static void delete(java.lang.String str) {
        delete(str, null, null);
    }

    public static void delete(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, null, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        delete(str, requestParams, null);
    }

    public static void delete(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.DELETE, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void delete(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.DELETE, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void download(java.lang.String str, java.io.File file) {
        download(str, file, null);
    }

    public static void download(java.lang.String str, java.io.File file, com.aliyun.vod.qupaiokhttp.FileDownloadCallback fileDownloadCallback) {
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str) || file == null) {
            return;
        }
        new com.aliyun.vod.qupaiokhttp.FileDownloadTask(str, file, fileDownloadCallback).execute(new java.lang.Void[0]);
    }

    private static void executeRequest(com.aliyun.vod.qupaiokhttp.Method method, java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        if (builder == null) {
            builder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        }
        new com.aliyun.vod.qupaiokhttp.OkHttpTask(method, str, requestParams, builder, baseHttpRequestCallback).execute();
    }

    public static void get(java.lang.String str) {
        get(str, null, null);
    }

    public static void get(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("HttpGet:");
        sb.append(str);
        get(str, null, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        get(str, requestParams, null);
    }

    public static void get(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.GET, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        get(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void get(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.GET, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str) {
        head(str, null, null);
    }

    public static void head(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, null, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        head(str, requestParams, null);
    }

    public static void head(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.HEAD, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void head(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.HEAD, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str) {
        patch(str, null, null);
    }

    public static void patch(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, null, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        patch(str, requestParams, null);
    }

    public static void patch(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.PATCH, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void patch(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.PATCH, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str) {
        post(str, null, null);
    }

    public static void post(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, null, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        post(str, requestParams, null);
    }

    public static void post(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.POST, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void post(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.POST, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str) {
        put(str, null, null);
    }

    public static void put(java.lang.String str, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, null, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams) {
        put(str, requestParams, null);
    }

    public static void put(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, long j, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.PUT, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void put(java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(com.aliyun.vod.qupaiokhttp.Method.PUT, str, requestParams, builder, baseHttpRequestCallback);
    }
}
