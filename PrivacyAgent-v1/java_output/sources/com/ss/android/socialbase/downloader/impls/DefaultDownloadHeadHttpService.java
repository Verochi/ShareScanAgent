package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultDownloadHeadHttpService implements com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService {

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection {
        final /* synthetic */ okhttp3.Call val$requestCall;
        final /* synthetic */ okhttp3.Response val$response;

        public AnonymousClass1(okhttp3.Response response, okhttp3.Call call) {
            this.val$response = response;
            this.val$requestCall = call;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public void cancel() {
            okhttp3.Call call = this.val$requestCall;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.val$requestCall.cancel();
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

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService
    public com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.io.IOException {
        okhttp3.OkHttpClient downloadClient = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadClient();
        if (downloadClient == null) {
            throw new java.io.IOException("can't get httpClient");
        }
        okhttp3.Request.Builder head = new okhttp3.Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                head.addHeader(httpHeader.getName(), com.ss.android.socialbase.downloader.utils.DownloadUtils.getEncodedStr(httpHeader.getValue()));
            }
        }
        okhttp3.Call newCall = downloadClient.newCall(head.build());
        okhttp3.Response execute = newCall.execute();
        if (execute == null) {
            throw new java.io.IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(2097152)) {
            execute.close();
        }
        return new com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService.AnonymousClass1(execute, newCall);
    }
}
