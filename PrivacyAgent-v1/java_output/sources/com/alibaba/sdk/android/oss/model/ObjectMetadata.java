package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ObjectMetadata {
    public static final java.lang.String AES_256_SERVER_SIDE_ENCRYPTION = "AES256";
    private java.util.Map<java.lang.String, java.lang.String> userMetadata = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap();
    private java.util.Map<java.lang.String, java.lang.Object> metadata = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap();

    public void addUserMetadata(java.lang.String str, java.lang.String str2) {
        this.userMetadata.put(str, str2);
    }

    public java.lang.String getCacheControl() {
        return (java.lang.String) this.metadata.get("Cache-Control");
    }

    public java.lang.String getContentDisposition() {
        return (java.lang.String) this.metadata.get("Content-Disposition");
    }

    public java.lang.String getContentEncoding() {
        return (java.lang.String) this.metadata.get("Content-Encoding");
    }

    public long getContentLength() {
        java.lang.Long l = (java.lang.Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public java.lang.String getContentMD5() {
        return (java.lang.String) this.metadata.get("Content-MD5");
    }

    public java.lang.String getContentType() {
        return (java.lang.String) this.metadata.get("Content-Type");
    }

    public java.lang.String getETag() {
        return (java.lang.String) this.metadata.get("ETag");
    }

    public java.util.Date getExpirationTime() throws java.text.ParseException {
        return com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date((java.lang.String) this.metadata.get("Expires"));
    }

    public java.util.Date getLastModified() {
        return (java.util.Date) this.metadata.get("Last-Modified");
    }

    public java.lang.String getObjectType() {
        return (java.lang.String) this.metadata.get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_OBJECT_TYPE);
    }

    public java.lang.String getRawExpiresValue() {
        return (java.lang.String) this.metadata.get("Expires");
    }

    public java.util.Map<java.lang.String, java.lang.Object> getRawMetadata() {
        return java.util.Collections.unmodifiableMap(this.metadata);
    }

    public java.lang.String getSHA1() {
        return (java.lang.String) this.metadata.get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HASH_SHA1);
    }

    public java.lang.String getServerSideEncryption() {
        return (java.lang.String) this.metadata.get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION);
    }

    public java.util.Map<java.lang.String, java.lang.String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setCacheControl(java.lang.String str) {
        this.metadata.put("Cache-Control", str);
    }

    public void setContentDisposition(java.lang.String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public void setContentEncoding(java.lang.String str) {
        this.metadata.put("Content-Encoding", str);
    }

    public void setContentLength(long j) {
        if (j > com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_FILE_SIZE_LIMIT) {
            throw new java.lang.IllegalArgumentException("The content length could not be more than 5GB.");
        }
        this.metadata.put("Content-Length", java.lang.Long.valueOf(j));
    }

    public void setContentMD5(java.lang.String str) {
        this.metadata.put("Content-MD5", str);
    }

    public void setContentType(java.lang.String str) {
        this.metadata.put("Content-Type", str);
    }

    public void setExpirationTime(java.util.Date date) {
        this.metadata.put("Expires", com.alibaba.sdk.android.oss.common.utils.DateUtil.formatRfc822Date(date));
    }

    public void setHeader(java.lang.String str, java.lang.Object obj) {
        this.metadata.put(str, obj);
    }

    public void setLastModified(java.util.Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public void setSHA1(java.lang.String str) {
        this.metadata.put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HASH_SHA1, str);
    }

    public void setServerSideEncryption(java.lang.String str) {
        this.metadata.put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, str);
    }

    public void setUserMetadata(java.util.Map<java.lang.String, java.lang.String> map) {
        this.userMetadata.clear();
        if (map == null || map.isEmpty()) {
            return;
        }
        this.userMetadata.putAll(map);
    }

    public java.lang.String toString() {
        java.lang.String str;
        try {
            str = getExpirationTime().toString();
        } catch (java.lang.Exception unused) {
            str = "";
        }
        return "Last-Modified:" + getLastModified() + "\nExpires" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str + "\nrawExpires:" + getRawExpiresValue() + "\nContent-MD5" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getContentMD5() + "\n" + com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_OBJECT_TYPE + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getObjectType() + "\n" + com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getServerSideEncryption() + "\nContent-Disposition" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getContentDisposition() + "\nContent-Encoding" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getContentEncoding() + "\nCache-Control" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getCacheControl() + "\nETag" + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getETag() + "\n";
    }
}
