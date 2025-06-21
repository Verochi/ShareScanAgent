package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public interface ResponseErrorCode {
    int getErrorCode();

    java.lang.String getErrorReason();

    android.os.Parcelable getParcelable();

    java.lang.String getResolution();

    int getStatusCode();

    java.lang.String getTransactionId();

    boolean hasResolution();
}
