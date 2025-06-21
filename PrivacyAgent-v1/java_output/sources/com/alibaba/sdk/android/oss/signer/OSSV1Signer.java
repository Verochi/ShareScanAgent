package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public class OSSV1Signer extends com.alibaba.sdk.android.oss.signer.OSSSignerBase {
    public OSSV1Signer(com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams) {
        super(oSSSignerParams);
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase
    public void addAuthorizationHeader(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        requestMessage.addHeader("Authorization", com.alibaba.sdk.android.oss.common.utils.SignUtils.composeRequestAuthorization(oSSFederationToken.getTempAK(), com.alibaba.sdk.android.oss.signer.ServiceSignature.create().computeSignature(oSSFederationToken.getTempSK(), buildStringToSign(requestMessage))));
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase
    public java.lang.String buildStringToSign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        return com.alibaba.sdk.android.oss.common.utils.SignUtils.buildCanonicalString(requestMessage.getMethod().toString(), this.signerParams.getResourcePath(), requestMessage, null);
    }

    @Override // com.alibaba.sdk.android.oss.signer.RequestPresigner
    public void presign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) throws java.lang.Exception {
        com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken;
        java.lang.String substring;
        java.lang.String str;
        com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider = this.signerParams.getCredentialProvider();
        if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider) {
            oSSFederationToken = ((com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider) credentialProvider).getValidFederationToken();
        } else if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider) {
            oSSFederationToken = credentialProvider.getFederationToken();
        } else if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider) {
            com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = (com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider) credentialProvider;
            oSSFederationToken = new com.alibaba.sdk.android.oss.common.auth.OSSFederationToken(oSSPlainTextAKSKCredentialProvider.getAccessKeyId(), oSSPlainTextAKSKCredentialProvider.getAccessKeySecret(), (java.lang.String) null, 0L);
        } else {
            oSSFederationToken = null;
        }
        java.lang.String resourcePath = this.signerParams.getResourcePath();
        java.lang.String valueOf = java.lang.String.valueOf((com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis() / 1000) + this.signerParams.getExpiration());
        requestMessage.addHeader("Date", valueOf);
        if (oSSFederationToken != null && oSSFederationToken.useSecurityToken()) {
            requestMessage.addParameter(com.alibaba.sdk.android.oss.common.RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
        }
        java.lang.String buildCanonicalString = com.alibaba.sdk.android.oss.common.utils.SignUtils.buildCanonicalString(requestMessage.getMethod().toString(), resourcePath, requestMessage, valueOf);
        if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) {
            try {
                java.lang.String signContent = ((com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) credentialProvider).signContent(buildCanonicalString);
                substring = signContent.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0].substring(4);
                str = signContent.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
            } catch (java.lang.Exception e) {
                throw new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
            }
        } else {
            java.lang.String tempAK = oSSFederationToken.getTempAK();
            java.lang.String computeSignature = com.alibaba.sdk.android.oss.signer.ServiceSignature.create().computeSignature(oSSFederationToken.getTempSK(), buildCanonicalString);
            substring = tempAK;
            str = computeSignature;
        }
        requestMessage.addParameter("Expires", valueOf);
        requestMessage.addParameter("Signature", str);
        requestMessage.addParameter(com.alibaba.sdk.android.oss.common.RequestParameters.OSS_ACCESS_KEY_ID, substring);
    }
}
