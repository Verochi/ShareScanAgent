package com.bumptech.glide.integration.okhttp3;

/* loaded from: classes.dex */
public class OkHttpStreamFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.InputStream>, okhttp3.Callback {
    private static final java.lang.String TAG = "OkHttpFetcher";
    private volatile okhttp3.Call call;
    private com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> callback;
    private final okhttp3.Call.Factory client;
    private okhttp3.ResponseBody responseBody;
    private java.io.InputStream stream;
    private final com.bumptech.glide.load.model.GlideUrl url;

    public OkHttpStreamFetcher(okhttp3.Call.Factory factory, com.bumptech.glide.load.model.GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        okhttp3.Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            java.io.InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (java.io.IOException unused) {
        }
        okhttp3.ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            responseBody.close();
        }
        this.callback = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> dataCallback) {
        okhttp3.Request.Builder url = new okhttp3.Request.Builder().url(this.url.toStringUrl());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.url.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        okhttp3.Request build = url.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        this.call.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(@androidx.annotation.NonNull okhttp3.Call call, @androidx.annotation.NonNull java.io.IOException iOException) {
        this.callback.onLoadFailed(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@androidx.annotation.NonNull okhttp3.Call call, @androidx.annotation.NonNull okhttp3.Response response) {
        this.responseBody = response.body();
        if (!response.isSuccessful()) {
            this.callback.onLoadFailed(new com.bumptech.glide.load.HttpException(response.message(), response.code()));
            return;
        }
        java.io.InputStream obtain = com.bumptech.glide.util.ContentLengthInputStream.obtain(this.responseBody.byteStream(), ((okhttp3.ResponseBody) com.bumptech.glide.util.Preconditions.checkNotNull(this.responseBody)).contentLength());
        this.stream = obtain;
        this.callback.onDataReady(obtain);
    }
}
