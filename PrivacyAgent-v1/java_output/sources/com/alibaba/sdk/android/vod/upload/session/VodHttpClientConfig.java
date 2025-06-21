package com.alibaba.sdk.android.vod.upload.session;

/* loaded from: classes.dex */
public class VodHttpClientConfig {
    private int connectionTimeout;
    private int maxRetryCount;
    private int socketTimeout;

    public static class Builder {
        int _MaxRetryCount = Integer.MAX_VALUE;
        int _ConnectionTimeout = 15000;
        int _SocketTimeout = 15000;

        public com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig build() {
            return new com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig(this);
        }

        public com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder setConnectionTimeout(int i) {
            this._ConnectionTimeout = i;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder setMaxRetryCount(int i) {
            if (i > 0) {
                this._MaxRetryCount = i;
                return this;
            }
            this._MaxRetryCount = 2;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder setSocketTimeout(int i) {
            this._SocketTimeout = i;
            return this;
        }
    }

    public VodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder builder) {
        this.maxRetryCount = Integer.MAX_VALUE;
        this.connectionTimeout = 15000;
        this.socketTimeout = 15000;
        this.maxRetryCount = builder._MaxRetryCount;
        this.connectionTimeout = builder._ConnectionTimeout;
        this.socketTimeout = builder._SocketTimeout;
    }

    public static com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder builder() {
        return new com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }
}
