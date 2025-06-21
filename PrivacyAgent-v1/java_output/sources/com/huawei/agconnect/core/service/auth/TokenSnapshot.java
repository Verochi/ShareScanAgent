package com.huawei.agconnect.core.service.auth;

/* loaded from: classes22.dex */
public interface TokenSnapshot {

    public enum State {
        SIGNED_IN,
        TOKEN_UPDATED,
        TOKEN_INVALID,
        SIGNED_OUT
    }

    com.huawei.agconnect.core.service.auth.TokenSnapshot.State getState();

    java.lang.String getToken();
}
