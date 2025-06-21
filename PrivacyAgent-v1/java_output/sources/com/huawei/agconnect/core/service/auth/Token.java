package com.huawei.agconnect.core.service.auth;

/* loaded from: classes22.dex */
public interface Token {
    long getExpiration();

    long getIssuedAt();

    long getNotBefore();

    java.lang.String getTokenString();
}
