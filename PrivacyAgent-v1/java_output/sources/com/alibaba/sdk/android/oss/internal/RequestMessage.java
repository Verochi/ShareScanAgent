package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class RequestMessage extends com.alibaba.sdk.android.oss.internal.HttpMessage {
    private java.lang.String bucketName;
    private boolean checkCRC64;
    private com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider;
    private java.net.URI endpoint;
    private java.lang.String ipWithHeader;
    private com.alibaba.sdk.android.oss.common.HttpMethod method;
    private java.lang.String objectKey;
    private java.net.URI service;
    private com.alibaba.sdk.android.oss.signer.RequestSigner signer;
    private byte[] uploadData;
    private java.lang.String uploadFilePath;
    private android.net.Uri uploadUri;
    private boolean isAuthorizationRequired = true;
    private java.util.Map<java.lang.String, java.lang.String> parameters = new java.util.LinkedHashMap();
    private boolean httpDnsEnable = false;
    private boolean pathStyleAccessEnable = false;
    private boolean customPathPrefixEnable = false;
    private boolean isInCustomCnameExcludeList = false;
    private boolean useUrlSignature = false;
    private java.util.Set<java.lang.String> additionalHeaderNames = new java.util.HashSet();

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void addHeader(java.lang.String str, java.lang.String str2) {
        super.addHeader(str, str2);
    }

    public void addParameter(java.lang.String str, java.lang.String str2) {
        this.parameters.put(str, str2);
    }

    public java.lang.String buildCanonicalURL() throws java.lang.Exception {
        boolean z = false;
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(this.endpoint != null, "Endpoint haven't been set!");
        java.lang.String scheme = this.endpoint.getScheme();
        java.lang.String host = this.endpoint.getHost();
        java.lang.String path = this.endpoint.getPath();
        int port = this.endpoint.getPort();
        java.lang.String str = null;
        java.lang.String valueOf = port != -1 ? java.lang.String.valueOf(port) : null;
        if (android.text.TextUtils.isEmpty(host)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("endpoint url : " + this.endpoint.toString());
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" scheme : " + scheme);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" originHost : " + host);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" port : " + valueOf);
        java.lang.String str2 = scheme + "://" + host;
        if (!android.text.TextUtils.isEmpty(valueOf)) {
            str2 = str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + valueOf;
        }
        if (!android.text.TextUtils.isEmpty(this.bucketName)) {
            if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isOssOriginHost(host)) {
                java.lang.String str3 = this.bucketName + "." + host;
                if (isHttpDnsEnable()) {
                    str = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.getInstance().getIpByHostAsync(str3);
                } else {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[buildCannonicalURL], disable httpdns");
                }
                addHeader("Host", str3);
                str2 = android.text.TextUtils.isEmpty(str) ? scheme + "://" + str3 : scheme + "://" + str;
            } else if (this.isInCustomCnameExcludeList) {
                if (!this.pathStyleAccessEnable) {
                    str2 = scheme + "://" + this.bucketName + "." + host;
                }
                z = true;
            } else if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isValidateIP(host)) {
                if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.ipWithHeader)) {
                    addHeader("Host", getIpWithHeader());
                }
                z = true;
            }
        }
        if (this.customPathPrefixEnable && path != null) {
            str2 = str2 + path;
        }
        if (z) {
            str2 = str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.bucketName;
        }
        if (!android.text.TextUtils.isEmpty(this.objectKey)) {
            str2 = str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(this.objectKey, "utf-8");
        }
        java.lang.String paramToQueryString = com.alibaba.sdk.android.oss.common.utils.OSSUtils.paramToQueryString(this.parameters, "utf-8");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("request---------------------\n");
        sb.append("request url=" + str2 + "\n");
        sb.append("request params=" + paramToQueryString + "\n");
        for (java.lang.String str4 : getHeaders().keySet()) {
            sb.append("requestHeader [" + str4 + "]: ");
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append((java.lang.String) getHeaders().get(str4));
            sb2.append("\n");
            sb.append(sb2.toString());
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(sb.toString());
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(paramToQueryString)) {
            return str2;
        }
        return str2 + "?" + paramToQueryString;
    }

    public java.lang.String buildOSSServiceURL() {
        java.lang.String str;
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(this.service != null, "Service haven't been set!");
        java.lang.String host = this.service.getHost();
        java.lang.String scheme = this.service.getScheme();
        if (isHttpDnsEnable() && scheme.equalsIgnoreCase(com.alipay.sdk.m.l.a.q)) {
            str = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.getInstance().getIpByHostAsync(host);
        } else {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[buildOSSServiceURL], disable httpdns or http is not need httpdns");
            str = null;
        }
        if (str == null) {
            str = host;
        }
        getHeaders().put("Host", host);
        java.lang.String str2 = scheme + "://" + str;
        java.lang.String paramToQueryString = com.alibaba.sdk.android.oss.common.utils.OSSUtils.paramToQueryString(this.parameters, "utf-8");
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(paramToQueryString)) {
            return str2;
        }
        return str2 + "?" + paramToQueryString;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void close() throws java.io.IOException {
        super.close();
    }

    public void createBucketRequestBodyMarshall(java.util.Map<java.lang.String, java.lang.String> map) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (map != null) {
            stringBuffer.append("<CreateBucketConfiguration>");
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                stringBuffer.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
            }
            stringBuffer.append("</CreateBucketConfiguration>");
            setStringBody(stringBuffer.toString());
        }
    }

    public byte[] deleteMultipleObjectRequestBodyMarshall(java.util.List<java.lang.String> list, boolean z) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<Delete>");
        if (z) {
            stringBuffer.append("<Quiet>true</Quiet>");
        } else {
            stringBuffer.append("<Quiet>false</Quiet>");
        }
        for (java.lang.String str : list) {
            stringBuffer.append("<Object>");
            stringBuffer.append("<Key>");
            stringBuffer.append(com.alibaba.sdk.android.oss.common.utils.OSSUtils.escapeKey(str));
            stringBuffer.append("</Key>");
            stringBuffer.append("</Object>");
        }
        stringBuffer.append("</Delete>");
        java.lang.String stringBuffer2 = stringBuffer.toString();
        byte[] bytes = stringBuffer2.getBytes("utf-8");
        setStringBody(stringBuffer2);
        return bytes;
    }

    public java.util.Set<java.lang.String> getAdditionalHeaderNames() {
        return this.additionalHeaderNames;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.io.InputStream getContent() {
        return super.getContent();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    public com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public java.net.URI getEndpoint() {
        return this.endpoint;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.util.Map getHeaders() {
        return super.getHeaders();
    }

    public java.lang.String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public com.alibaba.sdk.android.oss.common.HttpMethod getMethod() {
        return this.method;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
        return this.parameters;
    }

    public java.net.URI getService() {
        return this.service;
    }

    public com.alibaba.sdk.android.oss.signer.RequestSigner getSigner() {
        return this.signer;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.lang.String getStringBody() {
        return super.getStringBody();
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public java.lang.String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public android.net.Uri getUploadUri() {
        return this.uploadUri;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isCustomPathPrefixEnable() {
        return this.customPathPrefixEnable;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isInCustomCnameExcludeList() {
        return this.isInCustomCnameExcludeList;
    }

    public boolean isPathStyleAccessEnable() {
        return this.pathStyleAccessEnable;
    }

    public boolean isUseUrlSignature() {
        return this.useUrlSignature;
    }

    public void putBucketLifecycleRequestBodyMarshall(java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> arrayList) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<LifecycleConfiguration>");
        java.util.Iterator<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> it = arrayList.iterator();
        while (it.hasNext()) {
            com.alibaba.sdk.android.oss.model.BucketLifecycleRule next = it.next();
            stringBuffer.append("<Rule>");
            if (next.getIdentifier() != null) {
                stringBuffer.append("<ID>" + next.getIdentifier() + "</ID>");
            }
            if (next.getPrefix() != null) {
                stringBuffer.append("<Prefix>" + next.getPrefix() + "</Prefix>");
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("<Status>");
            sb.append(next.getStatus() ? "Enabled" : "Disabled");
            sb.append("</Status>");
            stringBuffer.append(sb.toString());
            if (next.getDays() != null) {
                stringBuffer.append("<Days>" + next.getDays() + "</Days>");
            } else if (next.getExpireDate() != null) {
                stringBuffer.append("<Date>" + next.getExpireDate() + "</Date>");
            }
            if (next.getMultipartDays() != null) {
                stringBuffer.append("<AbortMultipartUpload><Days>" + next.getMultipartDays() + "</Days></AbortMultipartUpload>");
            } else if (next.getMultipartExpireDate() != null) {
                stringBuffer.append("<AbortMultipartUpload><Date>" + next.getMultipartDays() + "</Date></AbortMultipartUpload>");
            }
            if (next.getIADays() != null) {
                stringBuffer.append("<Transition><Days>" + next.getIADays() + "</Days><StorageClass>IA</StorageClass></Transition>");
            } else if (next.getIAExpireDate() != null) {
                stringBuffer.append("<Transition><Date>" + next.getIAExpireDate() + "</Date><StorageClass>IA</StorageClass></Transition>");
            } else if (next.getArchiveDays() != null) {
                stringBuffer.append("<Transition><Days>" + next.getArchiveDays() + "</Days><StorageClass>Archive</StorageClass></Transition>");
            } else if (next.getArchiveExpireDate() != null) {
                stringBuffer.append("<Transition><Date>" + next.getArchiveExpireDate() + "</Date><StorageClass>Archive</StorageClass></Transition>");
            }
            stringBuffer.append("</Rule>");
        }
        stringBuffer.append("</LifecycleConfiguration>");
        setStringBody(stringBuffer.toString());
    }

    public void putBucketLoggingRequestBodyMarshall(java.lang.String str, java.lang.String str2) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<BucketLoggingStatus>");
        if (str != null) {
            stringBuffer.append("<LoggingEnabled><TargetBucket>" + str + "</TargetBucket>");
            if (str2 != null) {
                stringBuffer.append("<TargetPrefix>" + str2 + "</TargetPrefix>");
            }
            stringBuffer.append("</LoggingEnabled>");
        }
        stringBuffer.append("</BucketLoggingStatus>");
        setStringBody(stringBuffer.toString());
    }

    public void putBucketRefererRequestBodyMarshall(java.util.ArrayList<java.lang.String> arrayList, boolean z) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<RefererConfiguration>");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<AllowEmptyReferer>");
        sb.append(z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        sb.append("</AllowEmptyReferer>");
        stringBuffer.append(sb.toString());
        if (arrayList != null && arrayList.size() > 0) {
            stringBuffer.append("<RefererList>");
            java.util.Iterator<java.lang.String> it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append("<Referer>" + it.next() + "</Referer>");
            }
            stringBuffer.append("</RefererList>");
        }
        stringBuffer.append("</RefererConfiguration>");
        setStringBody(stringBuffer.toString());
    }

    public byte[] putObjectTaggingRequestBodyMarshall(java.util.Map<java.lang.String, java.lang.String> map) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<Tagging>");
        stringBuffer.append("<TagSet>");
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                stringBuffer.append("<Tag>");
                stringBuffer.append("<Key>");
                stringBuffer.append(entry.getKey());
                stringBuffer.append("</Key>");
                stringBuffer.append("<Value>");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("</Value>");
                stringBuffer.append("</Tag>");
            }
        }
        stringBuffer.append("</TagSet>");
        stringBuffer.append("</Tagging>");
        java.lang.String stringBuffer2 = stringBuffer.toString();
        byte[] bytes = stringBuffer2.getBytes("utf-8");
        setStringBody(stringBuffer2);
        return bytes;
    }

    public void setAdditionalHeaderNames(java.util.Set<java.lang.String> set) {
        this.additionalHeaderNames = set;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContent(java.io.InputStream inputStream) {
        super.setContent(inputStream);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContentLength(long j) {
        super.setContentLength(j);
    }

    public void setCredentialProvider(com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setCustomPathPrefixEnable(boolean z) {
        this.customPathPrefixEnable = z;
    }

    public void setEndpoint(java.net.URI uri) {
        this.endpoint = uri;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setHeaders(java.util.Map map) {
        super.setHeaders(map);
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setIpWithHeader(java.lang.String str) {
        this.ipWithHeader = str;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }

    public void setIsInCustomCnameExcludeList(boolean z) {
        this.isInCustomCnameExcludeList = z;
    }

    public void setMethod(com.alibaba.sdk.android.oss.common.HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setParameters(java.util.Map<java.lang.String, java.lang.String> map) {
        this.parameters = map;
    }

    public void setPathStyleAccessEnable(boolean z) {
        this.pathStyleAccessEnable = z;
    }

    public void setService(java.net.URI uri) {
        this.service = uri;
    }

    public void setSigner(com.alibaba.sdk.android.oss.signer.RequestSigner requestSigner) {
        this.signer = requestSigner;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setStringBody(java.lang.String str) {
        super.setStringBody(str);
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public void setUploadFilePath(java.lang.String str) {
        this.uploadFilePath = str;
    }

    public void setUploadUri(android.net.Uri uri) {
        this.uploadUri = uri;
    }

    public void setUseUrlSignature(boolean z) {
        this.useUrlSignature = z;
    }
}
