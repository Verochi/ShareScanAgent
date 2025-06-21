package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class x<TResult> implements com.hihonor.push.sdk.tasks.OnCanceledListener, com.hihonor.push.sdk.tasks.OnFailureListener, com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> {
    public final java.util.concurrent.CountDownLatch a = new java.util.concurrent.CountDownLatch(1);

    @Override // com.hihonor.push.sdk.tasks.OnCanceledListener
    public final void onCanceled() {
        this.a.countDown();
    }

    @Override // com.hihonor.push.sdk.tasks.OnFailureListener
    public final void onFailure(java.lang.Exception exc) {
        this.a.countDown();
    }

    @Override // com.hihonor.push.sdk.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        this.a.countDown();
    }
}
