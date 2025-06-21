package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public abstract class OSSCustomSignerCredentialProvider implements com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider {
    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() {
        return null;
    }

    public abstract java.lang.String signContent(java.lang.String str);
}
