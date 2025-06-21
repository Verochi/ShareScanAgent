package com.efs.sdk.base.http;

/* loaded from: classes22.dex */
public abstract class AbsHttpListener implements com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse> {
    public abstract void onError(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse);

    public abstract void onSuccess(@androidx.annotation.NonNull com.efs.sdk.base.http.HttpResponse httpResponse);

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public void result(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ) {
            onError(httpResponse);
        } else {
            onSuccess(httpResponse);
        }
    }
}
