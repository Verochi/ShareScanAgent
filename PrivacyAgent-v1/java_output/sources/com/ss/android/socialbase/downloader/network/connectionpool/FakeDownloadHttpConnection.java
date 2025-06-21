package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: classes19.dex */
public class FakeDownloadHttpConnection implements com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection {
    private boolean isRequesting;
    private com.ss.android.socialbase.downloader.network.IDownloadHttpConnection mConnection;
    private long mCreateTime;
    private java.io.InputStream mInputStream;
    protected final java.lang.Object mJoinLock = new java.lang.Object();
    private final int mMaxLength;
    private final java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> mRequestHeaders;
    private final java.lang.String mUrl;

    public FakeDownloadHttpConnection(int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) {
        this.mMaxLength = i;
        this.mUrl = str;
        this.mRequestHeaders = list;
    }

    private com.ss.android.socialbase.downloader.network.IDownloadHttpConnection doExecute() throws java.io.IOException, com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.network.IDownloadHttpService defaultHttpService = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDefaultHttpService();
        if (defaultHttpService != null) {
            return defaultHttpService.downloadWithConnection(this.mMaxLength, this.mUrl, this.mRequestHeaders);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public void cancel() {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.cancel();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
    public void end() {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void execute() throws java.io.IOException, com.ss.android.socialbase.downloader.exception.BaseException {
        if (this.mConnection != null) {
            return;
        }
        synchronized (this.mJoinLock) {
            try {
                this.isRequesting = true;
                com.ss.android.socialbase.downloader.network.IDownloadHttpConnection doExecute = doExecute();
                this.mConnection = doExecute;
                if (doExecute != null) {
                    this.mCreateTime = java.lang.System.currentTimeMillis();
                    this.mInputStream = this.mConnection.getInputStream();
                }
            } finally {
                this.isRequesting = false;
                this.mJoinLock.notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
    public java.io.InputStream getInputStream() throws java.io.IOException {
        java.io.InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> getRequestHeaders() {
        return this.mRequestHeaders;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public int getResponseCode() throws java.io.IOException {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
        if (iDownloadHttpConnection != null) {
            return iDownloadHttpConnection.getResponseCode();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public java.lang.String getResponseHeaderField(java.lang.String str) {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
        if (iDownloadHttpConnection != null) {
            return iDownloadHttpConnection.getResponseHeaderField(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isRequesting() {
        return this.isRequesting;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isSuccessful() {
        try {
            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
            if (iDownloadHttpConnection != null) {
                return isSuccessful(iDownloadHttpConnection.getResponseCode());
            }
            return false;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isSuccessful(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isValid() {
        return java.lang.System.currentTimeMillis() - this.mCreateTime < com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sConnectionOutdatedTime;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void joinExecute() throws java.lang.InterruptedException {
        synchronized (this.mJoinLock) {
            if (this.isRequesting && this.mConnection == null) {
                this.mJoinLock.wait();
            }
        }
    }
}
