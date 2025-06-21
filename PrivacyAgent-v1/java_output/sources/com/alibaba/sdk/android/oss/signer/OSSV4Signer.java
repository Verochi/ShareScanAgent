package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public class OSSV4Signer extends com.alibaba.sdk.android.oss.signer.OSSSignerBase {
    private static final java.lang.String CONTENT_ALGORITHM = "algorithm";
    private static final java.lang.String CONTENT_DATE = "date";
    private static final java.lang.String CONTENT_PRODUCT = "product";
    private static final java.lang.String CONTENT_REGION = "region";
    private static final java.lang.String CONTENT_STRING_TO_SIGN = "stringToSign";
    private static final java.util.List<java.lang.String> DEFAULT_SIGNED_HEADERS = java.util.Arrays.asList("Content-Type".toLowerCase(), "Content-MD5".toLowerCase());
    private static final java.lang.String ISO8601_DATETIME_FORMAT = "yyyyMMdd'T'HHmmss'Z'";
    private static final java.lang.String ISO8601_DATE_FORMAT = "yyyyMMdd";
    private static final java.lang.String OSS4_HMAC_SHA256 = "OSS4-HMAC-SHA256";
    private static final java.lang.String SECRET_KEY_PREFIX = "aliyun_v4";
    private static final java.lang.String SECURITY_TOKEN = "x-oss-security-token";
    private static final java.lang.String SEPARATOR_BACKSLASH = "/";
    private static final java.lang.String TERMINATOR = "aliyun_v4_request";
    java.util.Set<java.lang.String> additionalSignedHeaders;
    private java.util.Date requestDateTime;

    public OSSV4Signer(com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams) {
        super(oSSSignerParams);
    }

    private void addOSSContentSha256Header(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        requestMessage.addHeader(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_CONTENT_SHA256, "UNSIGNED-PAYLOAD");
    }

    private void addSignedHeaderIfNeeded(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        if (!this.additionalSignedHeaders.contains("Host".toLowerCase()) || requestMessage.getHeaders().containsKey("Host")) {
            return;
        }
        requestMessage.addHeader("Host", requestMessage.getEndpoint().getHost());
    }

    private java.lang.String buildAuthorization(java.lang.String str, com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        java.lang.String str2;
        java.lang.String str3 = "Credential=" + oSSFederationToken.getTempAK() + "/" + buildScope();
        if (hasAdditionalSignedHeaders()) {
            str2 = ",AdditionalHeaders=" + com.alibaba.sdk.android.oss.common.utils.StringUtils.join(com.alipay.sdk.m.u.i.b, this.additionalSignedHeaders);
        } else {
            str2 = "";
        }
        return "OSS4-HMAC-SHA256 " + str3 + str2 + (",Signature=" + str);
    }

    private java.lang.String buildCanonicalRequest(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        java.lang.String obj = requestMessage.getMethod().toString();
        java.lang.String resourcePath = this.signerParams.getResourcePath();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(obj);
        sb.append("\n");
        sb.append(com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(resourcePath, true));
        sb.append("\n");
        java.util.Map<java.lang.String, java.lang.String> parameters = requestMessage.getParameters();
        java.util.TreeMap treeMap = new java.util.TreeMap();
        if (parameters != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : parameters.entrySet()) {
                treeMap.put(com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(com.alibaba.sdk.android.oss.common.utils.StringUtils.trim(entry.getKey()), false), com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(com.alibaba.sdk.android.oss.common.utils.StringUtils.trim(entry.getValue()), false));
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.lang.String str = "";
        for (java.util.Map.Entry entry2 : treeMap.entrySet()) {
            sb2.append(str);
            sb2.append((java.lang.String) entry2.getKey());
            if (entry2.getValue() != null && !((java.lang.String) entry2.getValue()).isEmpty()) {
                sb2.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb2.append((java.lang.String) entry2.getValue());
            }
            str = "&";
        }
        sb.append((java.lang.CharSequence) sb2);
        sb.append("\n");
        java.util.TreeMap<java.lang.String, java.lang.String> buildSortedHeadersMap = buildSortedHeadersMap(requestMessage.getHeaders());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry3 : buildSortedHeadersMap.entrySet()) {
            sb3.append(entry3.getKey());
            sb3.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb3.append(entry3.getValue().trim());
            sb3.append("\n");
        }
        sb.append((java.lang.CharSequence) sb3);
        sb.append("\n");
        sb.append(com.alibaba.sdk.android.oss.common.utils.StringUtils.join(com.alipay.sdk.m.u.i.b, this.additionalSignedHeaders));
        sb.append("\n");
        java.lang.String str2 = (java.lang.String) requestMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_CONTENT_SHA256);
        if (com.alibaba.sdk.android.oss.common.utils.StringUtils.isNullOrEmpty(str2)) {
            str2 = "UNSIGNED-PAYLOAD";
        }
        sb.append(str2);
        return sb.toString();
    }

    private java.lang.String buildScope() {
        return getDate() + "/" + getRegion() + "/" + getProduct() + "/" + TERMINATOR;
    }

    private java.lang.String buildSignature(byte[] bArr, java.lang.String str) {
        return com.alibaba.sdk.android.oss.common.utils.BinaryUtil.toHex(com.alibaba.sdk.android.oss.signer.ServiceSignature.create("HmacSHA256").computeHash(bArr, str.getBytes(com.alibaba.sdk.android.oss.common.utils.StringUtils.UTF8)));
    }

    private byte[] buildSigningKey(com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        com.alibaba.sdk.android.oss.signer.ServiceSignature create = com.alibaba.sdk.android.oss.signer.ServiceSignature.create("HmacSHA256");
        java.lang.String str = SECRET_KEY_PREFIX + oSSFederationToken.getTempSK();
        java.nio.charset.Charset charset = com.alibaba.sdk.android.oss.common.utils.StringUtils.UTF8;
        return create.computeHash(create.computeHash(create.computeHash(create.computeHash(str.getBytes(charset), getDate().getBytes(charset)), getRegion().getBytes(charset)), getProduct().getBytes(charset)), TERMINATOR.getBytes(charset));
    }

    private java.util.TreeMap<java.lang.String, java.lang.String> buildSortedHeadersMap(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.TreeMap<java.lang.String, java.lang.String> treeMap = new java.util.TreeMap<>();
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                java.lang.String lowerCase = entry.getKey().toLowerCase();
                if (hasSignedHeaders(lowerCase)) {
                    treeMap.put(lowerCase, entry.getValue());
                }
            }
        }
        return treeMap;
    }

    private java.lang.String buildStringToSign(java.lang.String str) {
        return "OSS4-HMAC-SHA256\n" + getDateTime() + "\n" + buildScope() + "\n" + com.alibaba.sdk.android.oss.common.utils.BinaryUtil.toHex(com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateSha256(str.getBytes(com.alibaba.sdk.android.oss.common.utils.StringUtils.UTF8)));
    }

    private java.lang.String getDate() {
        return getIso8601DateFormat().format(this.requestDateTime);
    }

    private java.lang.String getDateTime() {
        return getIso8601DateTimeFormat().format(this.requestDateTime);
    }

    private static java.text.DateFormat getIso8601DateFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(ISO8601_DATE_FORMAT, java.util.Locale.US);
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat;
    }

    private static java.text.DateFormat getIso8601DateTimeFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(ISO8601_DATETIME_FORMAT, java.util.Locale.US);
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat;
    }

    private java.lang.String getProduct() {
        return this.signerParams.getProduct();
    }

    private java.lang.String getRegion() {
        return this.signerParams.getCloudBoxId() != null ? this.signerParams.getCloudBoxId() : this.signerParams.getRegion();
    }

    private boolean hasAdditionalSignedHeaders() {
        java.util.Set<java.lang.String> set = this.additionalSignedHeaders;
        return (set == null || set.isEmpty()) ? false : true;
    }

    private boolean hasDefaultSignedHeaders(java.lang.String str) {
        if (DEFAULT_SIGNED_HEADERS.contains(str)) {
            return true;
        }
        return str.startsWith(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_PREFIX);
    }

    private boolean hasSignedHeaders(java.lang.String str) {
        if (hasDefaultSignedHeaders(str)) {
            return true;
        }
        return this.additionalSignedHeaders.contains(str);
    }

    private void initRequestDateTime() {
        java.util.Date date = new java.util.Date();
        long fixedSkewedTimeMillis = com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis();
        if (fixedSkewedTimeMillis != 0) {
            date.setTime(fixedSkewedTimeMillis);
        }
        this.requestDateTime = date;
    }

    private void resolveAdditionalSignedHeaders(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, java.util.Set<java.lang.String> set) {
        java.util.TreeSet treeSet = new java.util.TreeSet();
        if (set != null) {
            java.util.Iterator<java.lang.String> it = set.iterator();
            while (it.hasNext()) {
                java.lang.String lowerCase = it.next().toLowerCase();
                java.util.Iterator it2 = requestMessage.getHeaders().entrySet().iterator();
                while (it2.hasNext()) {
                    if (((java.lang.String) ((java.util.Map.Entry) it2.next()).getKey()).toLowerCase().equals(lowerCase) && !hasDefaultSignedHeaders(lowerCase)) {
                        treeSet.add(lowerCase);
                    }
                }
            }
        }
        this.additionalSignedHeaders = treeSet;
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase
    public void addAuthorizationHeader(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        requestMessage.addHeader("Authorization", buildAuthorization(buildSignature(buildSigningKey(oSSFederationToken), buildStringToSign(requestMessage)), oSSFederationToken));
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase
    public void addDateHeaderIfNeeded(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        initRequestDateTime();
        requestMessage.getHeaders().put("Date", getDateTime());
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase
    public java.lang.String buildStringToSign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        java.lang.String buildCanonicalRequest = buildCanonicalRequest(requestMessage);
        com.alibaba.sdk.android.oss.common.OSSLog.logInfo(buildCanonicalRequest);
        return buildStringToSign(buildCanonicalRequest);
    }

    @Override // com.alibaba.sdk.android.oss.signer.RequestPresigner
    public void presign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) throws java.lang.Exception {
        com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken;
        if (getRegion() == null) {
            throw new com.alibaba.sdk.android.oss.ClientException("Region haven't been set!");
        }
        com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider = this.signerParams.getCredentialProvider();
        if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) {
            throw new java.io.IOException("V4 signature does not support OSSCustomSignerCredentialProvider");
        }
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
        initRequestDateTime();
        java.lang.String valueOf = java.lang.String.valueOf(this.signerParams.getExpiration());
        requestMessage.addParameter("x-oss-date", getIso8601DateTimeFormat().format(this.requestDateTime));
        requestMessage.addParameter("x-oss-expires", valueOf);
        resolveAdditionalSignedHeaders(requestMessage, this.signerParams.getAdditionalHeaderNames());
        addSignedHeaderIfNeeded(requestMessage);
        if (hasAdditionalSignedHeaders()) {
            requestMessage.addParameter("x-oss-additional-headers", com.alibaba.sdk.android.oss.common.utils.StringUtils.join(com.alipay.sdk.m.u.i.b, this.additionalSignedHeaders));
        }
        requestMessage.addParameter("x-oss-signature-version", OSS4_HMAC_SHA256);
        if (oSSFederationToken.useSecurityToken()) {
            requestMessage.addParameter("x-oss-security-token", oSSFederationToken.getSecurityToken());
        }
        requestMessage.addParameter("x-oss-credential", oSSFederationToken.getTempAK() + "/" + buildScope());
        requestMessage.addParameter("x-oss-signature", buildSignature(buildSigningKey(oSSFederationToken), buildStringToSign(requestMessage)));
    }

    @Override // com.alibaba.sdk.android.oss.signer.OSSSignerBase, com.alibaba.sdk.android.oss.signer.RequestSigner
    public void sign(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) throws java.lang.Exception {
        com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken;
        if (requestMessage.isAuthorizationRequired()) {
            if (getRegion() == null) {
                throw new com.alibaba.sdk.android.oss.ClientException("Region haven't been set!");
            }
            com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider = this.signerParams.getCredentialProvider();
            if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) {
                throw new java.io.IOException("V4 signature does not support OSSCustomSignerCredentialProvider");
            }
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
            if (oSSFederationToken == null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("Can't get a federation token");
                throw new com.alibaba.sdk.android.oss.ClientException("Can't get a federation token");
            }
            resolveAdditionalSignedHeaders(requestMessage, requestMessage.getAdditionalHeaderNames());
            addSignedHeaderIfNeeded(requestMessage);
            addSecurityTokenHeaderIfNeeded(requestMessage, oSSFederationToken);
            addOSSContentSha256Header(requestMessage);
            addAuthorizationHeader(requestMessage, oSSFederationToken);
        }
    }
}
