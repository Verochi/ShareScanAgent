package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public abstract class ResolvingResultCallbacks<R extends com.google.android.gms.common.api.Result> extends com.google.android.gms.common.api.ResultCallbacks<R> {
    public final android.app.Activity a;
    public final int b;

    public ResolvingResultCallbacks(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull int i) {
        this.a = (android.app.Activity) com.google.android.gms.common.internal.Preconditions.checkNotNull(activity, "Activity must not be null");
        this.b = i;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    @com.google.android.gms.common.annotation.KeepForSdk
    public final void onFailure(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status) {
        if (!status.hasResolution()) {
            onUnresolvableFailure(status);
            return;
        }
        try {
            status.startResolutionForResult(this.a, this.b);
        } catch (android.content.IntentSender.SendIntentException unused) {
            onUnresolvableFailure(new com.google.android.gms.common.api.Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(@androidx.annotation.RecentlyNonNull R r);

    public abstract void onUnresolvableFailure(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status);
}
