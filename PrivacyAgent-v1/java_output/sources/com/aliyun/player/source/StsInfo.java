package com.aliyun.player.source;

/* loaded from: classes.dex */
public class StsInfo {
    private java.lang.String mAccessKeyId;
    private java.lang.String mAccessKeySecret;
    private java.util.List<com.aliyun.player.source.MediaFormat> mFormats;
    private java.lang.String mRegion;
    private java.lang.String mSecurityToken;

    private java.lang.String getFormatStr() {
        java.util.List<com.aliyun.player.source.MediaFormat> list = this.mFormats;
        if (list == null || list.isEmpty()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        for (com.aliyun.player.source.MediaFormat mediaFormat : this.mFormats) {
            if (mediaFormat != null) {
                sb.append(mediaFormat.getFormat());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public java.lang.String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public java.util.List<com.aliyun.player.source.MediaFormat> getFormats() {
        return this.mFormats;
    }

    public java.lang.String getRegion() {
        return this.mRegion;
    }

    public java.lang.String getSecurityToken() {
        return this.mSecurityToken;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.mAccessKeySecret = str;
    }

    public void setFormats(java.util.List<com.aliyun.player.source.MediaFormat> list) {
        this.mFormats = list;
    }

    public void setRegion(java.lang.String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(java.lang.String str) {
        this.mSecurityToken = str;
    }
}
