package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class TaskApiCallWrapper<TResult> extends com.huawei.hms.common.internal.BaseContentWrapper {
    private final com.huawei.hms.common.internal.TaskApiCall<? extends com.huawei.hms.common.internal.AnyClient, TResult> mTaskApiCall;
    private final com.huawei.hmf.tasks.TaskCompletionSource<TResult> mTaskCompletionSource;

    public TaskApiCallWrapper(com.huawei.hms.common.internal.TaskApiCall<? extends com.huawei.hms.common.internal.AnyClient, TResult> taskApiCall, com.huawei.hmf.tasks.TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.mTaskApiCall = taskApiCall;
        this.mTaskCompletionSource = taskCompletionSource;
    }

    public com.huawei.hms.common.internal.TaskApiCall<? extends com.huawei.hms.common.internal.AnyClient, TResult> getTaskApiCall() {
        return this.mTaskApiCall;
    }

    public com.huawei.hmf.tasks.TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.mTaskCompletionSource;
    }
}
