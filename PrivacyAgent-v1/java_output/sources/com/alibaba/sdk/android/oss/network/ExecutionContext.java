package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class ExecutionContext<Request extends com.alibaba.sdk.android.oss.model.OSSRequest, Result extends com.alibaba.sdk.android.oss.model.OSSResult> {
    private android.content.Context applicationContext;
    private com.alibaba.sdk.android.oss.network.CancellationHandler cancellationHandler;
    private okhttp3.OkHttpClient client;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback completedCallback;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback progressCallback;
    private Request request;
    private com.alibaba.sdk.android.oss.callback.OSSRetryCallback retryCallback;

    public ExecutionContext(okhttp3.OkHttpClient okHttpClient, Request request) {
        this(okHttpClient, request, null);
    }

    public ExecutionContext(okhttp3.OkHttpClient okHttpClient, Request request, android.content.Context context) {
        this.cancellationHandler = new com.alibaba.sdk.android.oss.network.CancellationHandler();
        setClient(okHttpClient);
        setRequest(request);
        this.applicationContext = context;
    }

    public android.content.Context getApplicationContext() {
        return this.applicationContext;
    }

    public com.alibaba.sdk.android.oss.network.CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public okhttp3.OkHttpClient getClient() {
        return this.client;
    }

    public com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> getCompletedCallback() {
        return this.completedCallback;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public Request getRequest() {
        return this.request;
    }

    public com.alibaba.sdk.android.oss.callback.OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setClient(okhttp3.OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public void setCompletedCallback(com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public void setProgressCallback(com.alibaba.sdk.android.oss.callback.OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setRetryCallback(com.alibaba.sdk.android.oss.callback.OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }
}
