package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IOAdEvent {
    int getCode();

    java.util.Map<java.lang.String, java.lang.Object> getData();

    java.lang.String getMessage();

    java.lang.Object getTarget();

    java.lang.String getType();

    void setTarget(java.lang.Object obj);
}
