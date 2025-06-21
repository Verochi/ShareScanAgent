package com.huawei.hms.support.api.client;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class ResolvingResultCallbacks<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.ResultCallbacks<R> {
    private static final java.lang.String TAG = "ResolvingResultCallbacks";
    private final android.app.Activity mActivity;
    private final int requestCode;

    public ResolvingResultCallbacks(android.app.Activity activity, int i) {
        this.mActivity = (android.app.Activity) com.huawei.hms.common.internal.Preconditions.checkNotNull(activity, "Activity must not be null");
        this.requestCode = i;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public final void onFailure(com.huawei.hms.support.api.client.Status status) {
        try {
            if (status.hasResolution()) {
                status.startResolutionForResult(this.mActivity, this.requestCode);
            } else {
                onUnresolvableFailure(status);
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "Failed to start resolution: " + e);
            onUnresolvableFailure(com.huawei.hms.support.api.client.Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(com.huawei.hms.support.api.client.Status status);
}
