package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(com.huawei.hmf.tasks.Task<TResult> task);
}
