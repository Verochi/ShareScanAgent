package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public class RefreshVodVideoUploadAuth {
    private java.lang.String uploadAddress;
    private java.lang.String uploadAuth;

    public static com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth getReVideoTokenInfo(java.lang.String str) {
        try {
            com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth refreshVodVideoUploadAuth = (com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth) new com.google.gson.Gson().fromJson(new com.google.gson.JsonParser().parse(str).getAsJsonObject().get("data"), com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth.class);
            refreshVodVideoUploadAuth.toString();
            return refreshVodVideoUploadAuth;
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

    public void setUploadAddress(java.lang.String str) {
        this.uploadAddress = str;
    }

    public void setUploadAuth(java.lang.String str) {
        this.uploadAuth = str;
    }

    public java.lang.String toString() {
        return "RefreshVodVideoUploadAuth{uploadAddress='" + this.uploadAddress + "', uploadAuth='" + this.uploadAuth + "'}";
    }
}
