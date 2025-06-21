package com.huawei.hms.common;

/* loaded from: classes22.dex */
public class ResolvableApiException extends com.huawei.hms.common.ApiException {
    public ResolvableApiException(com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode) {
        super(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason()));
        if (responseErrorCode.hasResolution()) {
            if (responseErrorCode.getParcelable() instanceof android.app.PendingIntent) {
                this.mStatus.setPendingIntent((android.app.PendingIntent) responseErrorCode.getParcelable());
            } else if (responseErrorCode.getParcelable() instanceof android.content.Intent) {
                this.mStatus.setIntent((android.content.Intent) responseErrorCode.getParcelable());
            }
        }
    }

    public ResolvableApiException(com.huawei.hms.support.api.client.Status status) {
        super(status);
    }

    public android.app.PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }

    public android.content.Intent getResolutionIntent() {
        return this.mStatus.getResolutionIntent();
    }

    public void startResolutionForResult(android.app.Activity activity, int i) throws android.content.IntentSender.SendIntentException {
        this.mStatus.startResolutionForResult(activity, i);
    }
}
