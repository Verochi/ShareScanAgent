package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: classes19.dex */
public class FakeDownloadHeadHttpConnection implements com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection {
    private static final java.lang.String TAG = "FakeDownloadHeadHttpCon";
    private static final java.util.ArrayList<java.lang.String> usedHeaders;
    private boolean isRequesting;
    private boolean isSuccessful;
    private long mCreateTime;
    protected java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> mRequestHeaders;
    private int mResponseCode;
    protected final long mStartOffset;
    protected final java.lang.String mUrl;
    private com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection realConnection;
    private java.util.Map<java.lang.String, java.lang.String> mResponseHeaders = null;
    protected final java.lang.Object mJoinLock = new java.lang.Object();

    static {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(6);
        usedHeaders = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add(com.ss.android.socialbase.downloader.utils.DownloadUtils.ETAG);
        arrayList.add("Content-Disposition");
    }

    public FakeDownloadHeadHttpConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) {
        this.mUrl = str;
        this.mRequestHeaders = list;
        this.mStartOffset = j;
    }

    private void parseHeaders(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, java.util.Map<java.lang.String, java.lang.String> map) {
        if (iDownloadHeadHttpConnection == null || map == null) {
            return;
        }
        java.util.Iterator<java.lang.String> it = usedHeaders.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            map.put(next, iDownloadHeadHttpConnection.getResponseHeaderField(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public void cancel() {
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.realConnection;
        if (iDownloadHeadHttpConnection != null) {
            iDownloadHeadHttpConnection.cancel();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void execute() throws java.lang.Exception {
        if (this.mResponseHeaders != null) {
            return;
        }
        try {
            this.isRequesting = true;
            this.realConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithHeadConnection(this.mUrl, this.mRequestHeaders);
            synchronized (this.mJoinLock) {
                if (this.realConnection != null) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    this.mResponseHeaders = hashMap;
                    parseHeaders(this.realConnection, hashMap);
                    this.mResponseCode = this.realConnection.getResponseCode();
                    this.mCreateTime = java.lang.System.currentTimeMillis();
                    this.isSuccessful = isSuccessful(this.mResponseCode);
                }
                this.isRequesting = false;
                this.mJoinLock.notifyAll();
            }
        } catch (java.lang.Throwable th) {
            synchronized (this.mJoinLock) {
                if (this.realConnection != null) {
                    java.util.HashMap hashMap2 = new java.util.HashMap();
                    this.mResponseHeaders = hashMap2;
                    parseHeaders(this.realConnection, hashMap2);
                    this.mResponseCode = this.realConnection.getResponseCode();
                    this.mCreateTime = java.lang.System.currentTimeMillis();
                    this.isSuccessful = isSuccessful(this.mResponseCode);
                }
                this.isRequesting = false;
                this.mJoinLock.notifyAll();
                throw th;
            }
        }
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> getRequestHeaders() {
        return this.mRequestHeaders;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public int getResponseCode() throws java.io.IOException {
        return this.mResponseCode;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public java.lang.String getResponseHeaderField(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.mResponseHeaders;
        if (map != null) {
            return map.get(str);
        }
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.realConnection;
        if (iDownloadHeadHttpConnection != null) {
            return iDownloadHeadHttpConnection.getResponseHeaderField(str);
        }
        return null;
    }

    public java.util.Map<java.lang.String, java.lang.String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isRequesting() {
        return this.isRequesting;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public boolean isSuccessful(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isValid() {
        return java.lang.System.currentTimeMillis() - this.mCreateTime < com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sHeadInfoOutdatedTime;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void joinExecute() throws java.lang.InterruptedException {
        synchronized (this.mJoinLock) {
            if (this.isRequesting && this.mResponseHeaders == null) {
                this.mJoinLock.wait();
            }
        }
    }
}
