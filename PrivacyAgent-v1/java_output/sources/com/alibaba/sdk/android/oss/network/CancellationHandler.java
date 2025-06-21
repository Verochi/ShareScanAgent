package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class CancellationHandler {
    private volatile okhttp3.Call call;
    private volatile boolean isCancelled;

    public void cancel() {
        if (this.call != null) {
            this.call.cancel();
        }
        this.isCancelled = true;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCall(okhttp3.Call call) {
        this.call = call;
    }
}
