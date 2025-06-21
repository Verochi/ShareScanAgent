package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public class ResolvableApiException extends com.google.android.gms.common.api.ApiException {
    public ResolvableApiException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status) {
        super(status);
    }

    @androidx.annotation.RecentlyNonNull
    public android.app.PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull int i) throws android.content.IntentSender.SendIntentException {
        getStatus().startResolutionForResult(activity, i);
    }
}
