package com.huawei.agconnect.core.service.auth;

/* loaded from: classes22.dex */
public interface AuthProvider {
    void addTokenListener(com.huawei.agconnect.core.service.auth.OnTokenListener onTokenListener);

    com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens();

    com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens(boolean z);

    java.lang.String getUid();

    void removeTokenListener(com.huawei.agconnect.core.service.auth.OnTokenListener onTokenListener);
}
