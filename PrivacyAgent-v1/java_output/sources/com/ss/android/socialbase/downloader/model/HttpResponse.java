package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class HttpResponse {
    public final com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection connection;
    private long contentLength;
    public final int responseCode;
    private long totalLength;
    public final java.lang.String url;

    public HttpResponse(java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection) throws java.io.IOException {
        this.url = str;
        this.responseCode = iDownloadHeadHttpConnection.getResponseCode();
        this.connection = iDownloadHeadHttpConnection;
    }

    public boolean acceptPartial() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.canAcceptPartial(this.responseCode, this.connection.getResponseHeaderField("Accept-Ranges"));
    }

    public java.lang.String getCacheControl() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Cache-Control");
    }

    public long getContentLength() {
        if (this.contentLength <= 0) {
            this.contentLength = com.ss.android.socialbase.downloader.utils.DownloadUtils.getContentLength(this.connection);
        }
        return this.contentLength;
    }

    public java.lang.String getContentRange() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Content-Range");
    }

    public java.lang.String getContentType() {
        return this.connection.getResponseHeaderField("Content-Type");
    }

    public java.lang.String getEtag() {
        return this.connection.getResponseHeaderField(com.ss.android.socialbase.downloader.utils.DownloadUtils.ETAG);
    }

    public java.lang.String getLastModified() {
        java.lang.String respHeadFieldIgnoreCase = com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "last-modified");
        return android.text.TextUtils.isEmpty(respHeadFieldIgnoreCase) ? com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Last-Modified") : respHeadFieldIgnoreCase;
    }

    public long getMaxAge() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.parserMaxAge(getCacheControl());
    }

    public long getTotalLength() {
        if (this.totalLength <= 0) {
            if (isChunked()) {
                this.totalLength = -1L;
            } else {
                java.lang.String contentRange = getContentRange();
                if (!android.text.TextUtils.isEmpty(contentRange)) {
                    this.totalLength = com.ss.android.socialbase.downloader.utils.DownloadUtils.parseContentRangeOfInstanceLength(contentRange);
                }
            }
        }
        return this.totalLength;
    }

    public boolean isChunked() {
        return com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8) ? com.ss.android.socialbase.downloader.utils.DownloadUtils.isChunkedTask(this.connection) : com.ss.android.socialbase.downloader.utils.DownloadUtils.isChunkedTask(getContentLength());
    }

    public boolean isResponseDataFromBegin() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseDataFromBegin(this.responseCode);
    }
}
