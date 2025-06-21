package com.alimm.tanx.ui.image.glide.integration.okhttp3;

/* loaded from: classes.dex */
public class OkHttpStreamFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> {
    private volatile okhttp3.Call call;
    private final okhttp3.Call.Factory client;
    private okhttp3.ResponseBody responseBody;
    private java.io.InputStream stream;
    private final com.alimm.tanx.ui.image.glide.load.model.GlideUrl url;

    public OkHttpStreamFetcher(okhttp3.Call.Factory factory, com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
        okhttp3.Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
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
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.url.getCacheKey();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.io.InputStream loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
        okhttp3.Request.Builder url = new okhttp3.Request.Builder().url(this.url.toStringUrl());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.url.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        this.call = this.client.newCall(url.build());
        okhttp3.Response execute = this.call.execute();
        this.responseBody = execute.body();
        if (!execute.isSuccessful()) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Request failed with code: ");
            tanxu_do2.append(execute.code());
            throw new java.io.IOException(tanxu_do2.toString());
        }
        java.io.InputStream obtain = com.alimm.tanx.ui.image.glide.util.ContentLengthInputStream.obtain(this.responseBody.byteStream(), this.responseBody.contentLength());
        this.stream = obtain;
        return obtain;
    }
}
