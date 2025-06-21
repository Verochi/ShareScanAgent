package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public class OSSFederationToken {
    private long expiration;
    private java.lang.String securityToken;
    private java.lang.String tempAk;
    private java.lang.String tempSk;

    public OSSFederationToken(java.lang.String str, java.lang.String str2, java.lang.String str3, long j) {
        setTempAk(str);
        setTempSk(str2);
        setSecurityToken(str3);
        setExpiration(j);
    }

    public OSSFederationToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        setTempAk(str);
        setTempSk(str2);
        setSecurityToken(str3);
        setExpirationInGMTFormat(str4);
    }

    public long getExpiration() {
        return this.expiration;
    }

    public java.lang.String getSecurityToken() {
        return this.securityToken;
    }

    public java.lang.String getTempAK() {
        return this.tempAk;
    }

    public java.lang.String getTempSK() {
        return this.tempSk;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public void setExpirationInGMTFormat(java.lang.String str) {
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(org.apache.tools.ant.util.DateUtils.ISO8601_DATETIME_PATTERN);
            simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
            this.expiration = simpleDateFormat.parse(str).getTime() / 1000;
        } catch (java.text.ParseException e) {
            if (com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()) {
                e.printStackTrace();
            }
            this.expiration = (com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis() / 1000) + 30;
        }
    }

    public void setSecurityToken(java.lang.String str) {
        this.securityToken = str;
    }

    public void setTempAk(java.lang.String str) {
        this.tempAk = str;
    }

    public void setTempSk(java.lang.String str) {
        this.tempSk = str;
    }

    public java.lang.String toString() {
        return "OSSFederationToken [tempAk=" + this.tempAk + ", tempSk=" + this.tempSk + ", securityToken=" + this.securityToken + ", expiration=" + this.expiration + "]";
    }

    public boolean useSecurityToken() {
        return this.securityToken != null;
    }
}
