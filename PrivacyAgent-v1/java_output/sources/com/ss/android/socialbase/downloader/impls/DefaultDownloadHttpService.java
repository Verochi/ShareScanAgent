package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultDownloadHttpService implements com.ss.android.socialbase.downloader.network.IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.utils.LruCache<java.lang.String, okhttp3.OkHttpClient> hostIpClientCache = new com.ss.android.socialbase.downloader.utils.LruCache<>(4, 8);

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService$1, reason: invalid class name */
    public class AnonymousClass1 extends com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection {
        final /* synthetic */ java.io.InputStream val$inputStream;
        final /* synthetic */ okhttp3.Call val$requestCall;
        final /* synthetic */ okhttp3.Response val$response;
        final /* synthetic */ okhttp3.ResponseBody val$responseBody;

        public AnonymousClass1(java.io.InputStream inputStream, okhttp3.Response response, okhttp3.Call call, okhttp3.ResponseBody responseBody) {
            this.val$inputStream = inputStream;
            this.val$response = response;
            this.val$requestCall = call;
            this.val$responseBody = responseBody;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public void cancel() {
            okhttp3.Call call = this.val$requestCall;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.val$requestCall.cancel();
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public void end() {
            try {
                okhttp3.ResponseBody responseBody = this.val$responseBody;
                if (responseBody != null) {
                    responseBody.close();
                }
                okhttp3.Call call = this.val$requestCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                this.val$requestCall.cancel();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
        public java.lang.String getHostIp() {
            return "";
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public java.io.InputStream getInputStream() throws java.io.IOException {
            return this.val$inputStream;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public int getResponseCode() throws java.io.IOException {
            return this.val$response.code();
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public java.lang.String getResponseHeaderField(java.lang.String str) {
            return this.val$response.header(str);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService$2, reason: invalid class name */
    public class AnonymousClass2 implements okhttp3.Dns {
        final /* synthetic */ java.lang.String val$host;
        final /* synthetic */ java.lang.String val$hostIp;

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.val$host = str;
            this.val$hostIp = str2;
        }

        @Override // okhttp3.Dns
        public java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException {
            return android.text.TextUtils.equals(this.val$host, str) ? java.util.Collections.singletonList(java.net.InetAddress.getByName(this.val$hostIp)) : okhttp3.Dns.SYSTEM.lookup(str);
        }
    }

    private okhttp3.OkHttpClient createSpecialHostIpClient(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String host = android.net.Uri.parse(str).getHost();
            if (!android.text.TextUtils.isEmpty(host) && !android.text.TextUtils.isEmpty(str2)) {
                java.lang.String str3 = host + "_" + str2;
                synchronized (this.hostIpClientCache) {
                    okhttp3.OkHttpClient okHttpClient = this.hostIpClientCache.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    okhttp3.OkHttpClient.Builder createDownloadClientBuilder = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.createDownloadClientBuilder();
                    createDownloadClientBuilder.dns(new com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.AnonymousClass2(host, str2));
                    okhttp3.OkHttpClient build = createDownloadClientBuilder.build();
                    synchronized (this.hostIpClientCache) {
                        this.hostIpClientCache.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadClient();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection(int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.io.IOException {
        java.lang.String str2;
        okhttp3.Request.Builder url = new okhttp3.Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                java.lang.String name = httpHeader.getName();
                if (str2 == null && com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_REQUEST_HOST_IP.equals(name)) {
                    str2 = httpHeader.getValue();
                } else {
                    url.addHeader(name, com.ss.android.socialbase.downloader.utils.DownloadUtils.getEncodedStr(httpHeader.getValue()));
                }
            }
        }
        okhttp3.OkHttpClient createSpecialHostIpClient = !android.text.TextUtils.isEmpty(str2) ? createSpecialHostIpClient(str, str2) : com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadClient();
        if (createSpecialHostIpClient == null) {
            throw new java.io.IOException("can't get httpClient");
        }
        okhttp3.Call newCall = createSpecialHostIpClient.newCall(url.build());
        okhttp3.Response execute = newCall.execute();
        if (execute == null) {
            throw new java.io.IOException("can't get response");
        }
        okhttp3.ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        java.io.InputStream byteStream = body.byteStream();
        java.lang.String header = execute.header("Content-Encoding");
        return new com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.AnonymousClass1((header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof java.util.zip.GZIPInputStream)) ? byteStream : new java.util.zip.GZIPInputStream(byteStream), execute, newCall, body);
    }
}
