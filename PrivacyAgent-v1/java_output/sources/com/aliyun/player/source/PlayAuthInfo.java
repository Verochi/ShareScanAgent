package com.aliyun.player.source;

/* loaded from: classes.dex */
public class PlayAuthInfo {
    private java.util.List<com.aliyun.player.source.MediaFormat> mFormats;
    private java.lang.String mPlayAuth;

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

    public java.util.List<com.aliyun.player.source.MediaFormat> getFormats() {
        return this.mFormats;
    }

    public java.lang.String getPlayAuth() {
        return this.mPlayAuth;
    }

    public void setFormats(java.util.List<com.aliyun.player.source.MediaFormat> list) {
        this.mFormats = list;
    }

    public void setPlayAuth(java.lang.String str) {
        this.mPlayAuth = str;
    }
}
