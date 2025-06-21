package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes.dex */
public interface a extends com.baidu.mobads.sdk.api.IOAdEvent {
    @androidx.annotation.NonNull
    com.baidu.mobads.sdk.api.IAdInterListener getDelegator();

    java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr);
}
