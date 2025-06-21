package com.huawei.hms.common.api;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class UnsupportedApiCallException extends java.lang.UnsupportedOperationException {
    private final com.huawei.hms.common.Feature feature;

    public UnsupportedApiCallException(com.huawei.hms.common.Feature feature) {
        this.feature = feature;
    }

    @Override // java.lang.Throwable
    public final java.lang.String getMessage() {
        return this.feature + " is unsupported";
    }
}
