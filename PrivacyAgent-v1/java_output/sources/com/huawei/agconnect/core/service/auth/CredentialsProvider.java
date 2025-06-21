package com.huawei.agconnect.core.service.auth;

/* loaded from: classes22.dex */
public interface CredentialsProvider {
    com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens();

    com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens(boolean z);
}
