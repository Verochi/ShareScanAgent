package com.aliyun.svideo.base.http;

/* loaded from: classes.dex */
public interface HttpCallback<T> {
    void onFailure(java.lang.Throwable th);

    void onSuccess(T t);
}
