package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public interface ResponseParser<T extends com.alibaba.sdk.android.oss.model.OSSResult> {
    T parse(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage) throws java.io.IOException;
}
