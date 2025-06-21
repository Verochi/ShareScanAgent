package com.huawei.hms.support.api;

/* loaded from: classes22.dex */
public class ResolvePendingResult<T extends com.huawei.hms.core.aidl.IMessageEntity> extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.ResolveResult<T>, T> {
    public ResolvePendingResult(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<T> cls) {
        super(apiClient, str, iMessageEntity, cls);
    }

    public static <R extends com.huawei.hms.core.aidl.IMessageEntity> com.huawei.hms.support.api.ResolvePendingResult<R> build(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<R> cls) {
        return new com.huawei.hms.support.api.ResolvePendingResult<>(apiClient, str, iMessageEntity, cls);
    }

    public T get() {
        return (T) await().getValue();
    }

    @Override // com.huawei.hms.support.api.PendingResultImpl
    public com.huawei.hms.support.api.ResolveResult<T> onComplete(T t) {
        com.huawei.hms.support.api.ResolveResult<T> resolveResult = new com.huawei.hms.support.api.ResolveResult<>(t);
        resolveResult.setStatus(new com.huawei.hms.support.api.client.Status(0));
        return resolveResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.support.api.PendingResultImpl
    public /* bridge */ /* synthetic */ com.huawei.hms.support.api.client.Result onComplete(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        return onComplete((com.huawei.hms.support.api.ResolvePendingResult<T>) iMessageEntity);
    }
}
