package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class BaseHttpRequestCallback<T> {
    public static final int ERROR_RESPONSE_DATA_PARSE_EXCEPTION = 1002;
    public static final int ERROR_RESPONSE_UNKNOWN = 1003;
    protected okhttp3.Headers headers;
    protected java.lang.reflect.Type type = com.aliyun.vod.qupaiokhttp.ClassTypeReflect.getModelClazz(getClass());

    public okhttp3.Headers getHeaders() {
        return this.headers;
    }

    public void onFailure(int i, java.lang.String str) {
    }

    public void onFinish() {
    }

    public void onProgress(int i, long j, boolean z) {
    }

    public void onResponse(java.lang.String str, okhttp3.Headers headers) {
    }

    public void onResponse(okhttp3.Response response, java.lang.String str, okhttp3.Headers headers) {
    }

    public void onStart() {
    }

    public void onSuccess(T t) {
    }

    public void onSuccess(okhttp3.Headers headers, T t) {
    }

    public void setResponseHeaders(okhttp3.Headers headers) {
        this.headers = headers;
    }
}
