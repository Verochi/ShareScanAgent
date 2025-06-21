package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public abstract class OSSSignerBase implements com.alibaba.sdk.android.oss.signer.RequestSigner, com.alibaba.sdk.android.oss.signer.RequestPresigner {
    protected final com.alibaba.sdk.android.oss.signer.OSSSignerParams signerParams;

    public OSSSignerBase(com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams) {
        this.signerParams = oSSSignerParams;
    }

    public static com.alibaba.sdk.android.oss.signer.RequestPresigner createRequestPresigner(com.alibaba.sdk.android.oss.signer.SignVersion signVersion, com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams) {
        return com.alibaba.sdk.android.oss.signer.SignVersion.V4.equals(signVersion) ? new com.alibaba.sdk.android.oss.signer.OSSV4Signer(oSSSignerParams) : new com.alibaba.sdk.android.oss.signer.OSSV1Signer(oSSSignerParams);
    }

    public static com.alibaba.sdk.android.oss.signer.RequestSigner createRequestSigner(com.alibaba.sdk.android.oss.signer.SignVersion signVersion, com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams) {
        return com.alibaba.sdk.android.oss.signer.SignVersion.V4.equals(signVersion) ? new com.alibaba.sdk.android.oss.signer.OSSV4Signer(oSSSignerParams) : new com.alibaba.sdk.android.oss.signer.OSSV1Signer(oSSSignerParams);
    }

    public abstract void addAuthorizationHeader(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken);

    public void addDateHeaderIfNeeded(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        java.util.Date date = new java.util.Date();
        long fixedSkewedTimeMillis = com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis();
        if (fixedSkewedTimeMillis != 0) {
            date.setTime(fixedSkewedTimeMillis);
        }
        requestMessage.getHeaders().put("Date", com.alibaba.sdk.android.oss.common.utils.DateUtil.formatRfc822Date(date));
    }

    public void addSecurityTokenHeaderIfNeeded(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        if (!oSSFederationToken.useSecurityToken() || requestMessage.isUseUrlSignature()) {
            return;
        }
        requestMessage.addHeader(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
    }

    public abstract java.lang.String buildStringToSign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage);

    @Override // com.alibaba.sdk.android.oss.signer.RequestSigner
    public void sign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) throws java.lang.Exception {
        com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken;
        if (requestMessage.isAuthorizationRequired()) {
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
            addDateHeaderIfNeeded(requestMessage);
            if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) {
                try {
                    requestMessage.addHeader("Authorization", ((com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) credentialProvider).signContent(buildStringToSign(requestMessage)));
                } catch (java.lang.Exception e) {
                    throw new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
                }
            } else {
                if (oSSFederationToken == null) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logError("Can't get a federation token");
                    throw new com.alibaba.sdk.android.oss.ClientException("Can't get a federation token");
                }
                addSecurityTokenHeaderIfNeeded(requestMessage, oSSFederationToken);
                addAuthorizationHeader(requestMessage, oSSFederationToken);
            }
        }
    }
}
