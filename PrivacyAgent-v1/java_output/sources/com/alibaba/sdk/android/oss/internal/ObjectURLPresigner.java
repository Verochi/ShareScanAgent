package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class ObjectURLPresigner {
    private java.lang.String cloudBoxId;
    private com.alibaba.sdk.android.oss.ClientConfiguration conf;
    private com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider;
    private java.net.URI endpoint;
    private java.lang.String product = "oss";
    private java.lang.String region;

    public ObjectURLPresigner(java.net.URI uri, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
    }

    private java.lang.String buildCanonicalHost(java.net.URI uri, java.lang.String str, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        java.lang.String str2;
        java.lang.String host = uri.getHost();
        java.lang.String path = uri.getPath();
        int port = uri.getPort();
        java.lang.String valueOf = port != -1 ? java.lang.String.valueOf(port) : null;
        if (android.text.TextUtils.isEmpty(valueOf)) {
            str2 = host;
        } else {
            str2 = host + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + valueOf;
        }
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isOssOriginHost(host)) {
                str2 = str + "." + host;
            } else if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isInCustomCnameExcludeList(host, clientConfiguration.getCustomCnameExcludeList())) {
                try {
                    z = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isValidateIP(host);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } else if (clientConfiguration.isPathStyleAccessEnable()) {
                z = true;
            } else {
                str2 = str + "." + host;
            }
        }
        if (clientConfiguration.isCustomPathPrefixEnable() && path != null) {
            str2 = str2 + path;
        }
        if (!z) {
            return str2;
        }
        return str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
    }

    private com.alibaba.sdk.android.oss.signer.RequestPresigner createSigner(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration, com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (str != null) {
            str3 = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams = new com.alibaba.sdk.android.oss.signer.OSSSignerParams(sb.toString(), oSSCredentialProvider);
        oSSSignerParams.setProduct(this.product);
        oSSSignerParams.setRegion(this.region);
        oSSSignerParams.setCloudBoxId(this.cloudBoxId);
        oSSSignerParams.setExpiration(generatePresignedUrlRequest.getExpiration());
        oSSSignerParams.setAdditionalHeaderNames(generatePresignedUrlRequest.getAdditionalHeaderNames());
        return com.alibaba.sdk.android.oss.signer.OSSSignerBase.createRequestPresigner(clientConfiguration.getSignVersion(), oSSSignerParams);
    }

    public java.lang.String getCloudBoxId() {
        return this.cloudBoxId;
    }

    public java.lang.String getProduct() {
        return this.product;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public java.lang.String presignConstrainedURL(com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest generatePresignedUrlRequest) throws com.alibaba.sdk.android.oss.ClientException {
        java.lang.String bucketName = generatePresignedUrlRequest.getBucketName();
        java.lang.String key = generatePresignedUrlRequest.getKey();
        com.alibaba.sdk.android.oss.common.HttpMethod method = generatePresignedUrlRequest.getMethod() != null ? generatePresignedUrlRequest.getMethod() : com.alibaba.sdk.android.oss.common.HttpMethod.GET;
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(method);
        requestMessage.setBucketName(bucketName);
        requestMessage.setObjectKey(key);
        requestMessage.setHeaders(generatePresignedUrlRequest.getHeaders());
        if (generatePresignedUrlRequest.getContentType() != null && !generatePresignedUrlRequest.getContentType().trim().equals("")) {
            requestMessage.getHeaders().put("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMD5() != null && !generatePresignedUrlRequest.getContentMD5().trim().equals("")) {
            requestMessage.getHeaders().put("Content-MD5", generatePresignedUrlRequest.getContentMD5());
        }
        if (generatePresignedUrlRequest.getQueryParameter() != null && generatePresignedUrlRequest.getQueryParameter().size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : generatePresignedUrlRequest.getQueryParameter().entrySet()) {
                requestMessage.getParameters().put(entry.getKey(), entry.getValue());
            }
        }
        if (generatePresignedUrlRequest.getProcess() != null && !generatePresignedUrlRequest.getProcess().trim().equals("")) {
            requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS, generatePresignedUrlRequest.getProcess());
        }
        requestMessage.setUseUrlSignature(true);
        try {
            createSigner(bucketName, key, this.credentialProvider, this.conf, generatePresignedUrlRequest).presign(requestMessage);
            java.lang.String buildCanonicalHost = buildCanonicalHost(this.endpoint, bucketName, this.conf);
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            linkedHashMap.putAll(requestMessage.getParameters());
            return this.endpoint.getScheme() + "://" + buildCanonicalHost + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(key, "utf-8") + "?" + com.alibaba.sdk.android.oss.common.utils.HttpUtil.paramToQueryString(linkedHashMap, "utf-8");
        } catch (java.lang.Exception e) {
            throw new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
        }
    }

    public java.lang.String presignConstrainedURL(java.lang.String str, java.lang.String str2, long j) throws com.alibaba.sdk.android.oss.ClientException {
        com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest generatePresignedUrlRequest = new com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest(str, str2);
        generatePresignedUrlRequest.setExpiration(j);
        return presignConstrainedURL(generatePresignedUrlRequest);
    }

    public java.lang.String presignPublicURL(java.lang.String str, java.lang.String str2) {
        return this.endpoint.getScheme() + "://" + buildCanonicalHost(this.endpoint, str, this.conf) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(str2, "utf-8");
    }

    public void setCloudBoxId(java.lang.String str) {
        this.cloudBoxId = str;
    }

    public void setProduct(java.lang.String str) {
        this.product = str;
    }

    public void setRegion(java.lang.String str) {
        this.region = str;
    }
}
