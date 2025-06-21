package com.huawei.hms.support.api.client;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class ResultCallbacks<R extends com.huawei.hms.support.api.client.Result> implements com.huawei.hms.support.api.client.ResultCallback<R> {
    private static final java.lang.String TAG = "ResultCallbacks";

    public abstract void onFailure(com.huawei.hms.support.api.client.Status status);

    @Override // com.huawei.hms.support.api.client.ResultCallback
    public final void onResult(R r) {
        try {
            com.huawei.hms.support.api.client.Status status = r.getStatus();
            if (status.isSuccess()) {
                onSuccess(r);
            } else {
                onFailure(status);
                if (r instanceof com.huawei.hms.common.api.Releasable) {
                    ((com.huawei.hms.common.api.Releasable) r).release();
                }
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w(TAG, "Failed to release " + r + ", reason: " + e);
        }
    }

    public abstract void onSuccess(R r);
}
