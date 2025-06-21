package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public class VodVideoUploadAuth {
    private java.lang.String uploadAddress;
    private java.lang.String uploadAuth;
    private java.lang.String videoId;

    public static com.aliyun.svideo.editor.publish.VodVideoUploadAuth getVideoTokenInfo(java.lang.String str) {
        try {
            com.aliyun.svideo.editor.publish.VodVideoUploadAuth vodVideoUploadAuth = (com.aliyun.svideo.editor.publish.VodVideoUploadAuth) new com.google.gson.Gson().fromJson(new com.google.gson.JsonParser().parse(str).getAsJsonObject().get("data"), com.aliyun.svideo.editor.publish.VodVideoUploadAuth.class);
            vodVideoUploadAuth.toString();
            return vodVideoUploadAuth;
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Get TOKEN info failed, json :");
            sb.append(str);
            return null;
        }
    }

    public java.lang.String getUploadAddress() {
        return this.uploadAddress;
    }

    public java.lang.String getUploadAuth() {
        return this.uploadAuth;
    }

    public java.lang.String getVideoId() {
        return this.videoId;
    }

    public void setUploadAddress(java.lang.String str) {
        this.uploadAddress = str;
    }

    public void setUploadAuth(java.lang.String str) {
        this.uploadAuth = str;
    }

    public void setVideoId(java.lang.String str) {
        this.videoId = str;
    }

    public java.lang.String toString() {
        return "VodVideoUploadAuth{videoId='" + this.videoId + "', uploadAddress='" + this.uploadAddress + "', uploadAuth='" + this.uploadAuth + "'}";
    }
}
