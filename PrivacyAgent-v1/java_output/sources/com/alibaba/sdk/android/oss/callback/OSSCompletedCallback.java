package com.alibaba.sdk.android.oss.callback;

/* loaded from: classes.dex */
public interface OSSCompletedCallback<T1 extends com.alibaba.sdk.android.oss.model.OSSRequest, T2 extends com.alibaba.sdk.android.oss.model.OSSResult> {
    void onFailure(T1 t1, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException);

    void onSuccess(T1 t1, T2 t2);
}
