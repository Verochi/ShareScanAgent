package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class OkHttp3Connection implements com.liulishuo.filedownloader.connection.FileDownloadConnection {
    final okhttp3.OkHttpClient mClient;
    private okhttp3.Request mRequest;
    private final okhttp3.Request.Builder mRequestBuilder;
    private okhttp3.Response mResponse;

    public static class Creator implements com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator {
        private okhttp3.OkHttpClient.Builder mBuilder;
        private okhttp3.OkHttpClient mClient;

        public Creator() {
        }

        public Creator(okhttp3.OkHttpClient.Builder builder) {
            this.mBuilder = builder;
        }

        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator
        public com.liulishuo.filedownloader.connection.FileDownloadConnection create(java.lang.String str) throws java.io.IOException {
            if (this.mClient == null) {
                synchronized (com.aliyun.svideo.downloader.OkHttp3Connection.Creator.class) {
                    if (this.mClient == null) {
                        okhttp3.OkHttpClient.Builder builder = this.mBuilder;
                        this.mClient = builder != null ? builder.build() : new okhttp3.OkHttpClient();
                        this.mBuilder = null;
                    }
                }
            }
            return new com.aliyun.svideo.downloader.OkHttp3Connection(str, this.mClient);
        }

        public okhttp3.OkHttpClient.Builder customize() {
            if (this.mBuilder == null) {
                this.mBuilder = new okhttp3.OkHttpClient.Builder();
            }
            return this.mBuilder;
        }
    }

    public OkHttp3Connection(java.lang.String str, okhttp3.OkHttpClient okHttpClient) {
        this(new okhttp3.Request.Builder().url(str), okHttpClient);
    }

    public OkHttp3Connection(okhttp3.Request.Builder builder, okhttp3.OkHttpClient okHttpClient) {
        this.mRequestBuilder = builder;
        this.mClient = okHttpClient;
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void addHeader(java.lang.String str, java.lang.String str2) {
        this.mRequestBuilder.addHeader(str, str2);
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public boolean dispatchAddResumeOffset(java.lang.String str, long j) {
        return false;
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void ending() {
        this.mRequest = null;
        this.mResponse = null;
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void execute() throws java.io.IOException {
        if (this.mRequest == null) {
            this.mRequest = this.mRequestBuilder.build();
        }
        this.mResponse = this.mClient.newCall(this.mRequest).execute();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.io.InputStream getInputStream() throws java.io.IOException {
        okhttp3.Response response = this.mResponse;
        if (response == null) {
            throw new java.io.IOException("Please invoke #execute first!");
        }
        okhttp3.ResponseBody body = response.body();
        if (body != null) {
            return body.byteStream();
        }
        throw new java.io.IOException("No body found on response!");
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestHeaderFields() {
        if (this.mRequest == null) {
            this.mRequest = this.mRequestBuilder.build();
        }
        return this.mRequest.headers().toMultimap();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public int getResponseCode() throws java.io.IOException {
        okhttp3.Response response = this.mResponse;
        if (response != null) {
            return response.code();
        }
        throw new java.lang.IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.lang.String getResponseHeaderField(java.lang.String str) {
        okhttp3.Response response = this.mResponse;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaderFields() {
        okhttp3.Response response = this.mResponse;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public boolean setRequestMethod(java.lang.String str) throws java.net.ProtocolException {
        this.mRequestBuilder.method(str, null);
        return true;
    }
}
