package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public abstract class AbsDownloadHttpConnection implements com.ss.android.socialbase.downloader.network.IDownloadHttpConnection {
    public java.lang.String getHostIp() {
        return "";
    }

    public java.lang.String getRequestLog() {
        return "";
    }

    public void monitorNetworkInfo(org.json.JSONObject jSONObject, boolean z) {
    }

    public void onThrowable(java.lang.Throwable th) {
    }

    public void setThrottleNetSpeedWhenRunning(long j) {
    }
}
