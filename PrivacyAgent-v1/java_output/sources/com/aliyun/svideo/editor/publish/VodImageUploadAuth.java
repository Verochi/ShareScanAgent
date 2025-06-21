package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public class VodImageUploadAuth {
    private java.lang.String imageId;
    private java.lang.String imageURL;
    private java.lang.String uploadAddress;
    private java.lang.String uploadAuth;

    public static com.aliyun.svideo.editor.publish.VodImageUploadAuth getImageTokenInfo(java.lang.String str) {
        try {
            com.aliyun.svideo.editor.publish.VodImageUploadAuth vodImageUploadAuth = (com.aliyun.svideo.editor.publish.VodImageUploadAuth) new com.google.gson.Gson().fromJson(new com.google.gson.JsonParser().parse(str).getAsJsonObject().get("data"), com.aliyun.svideo.editor.publish.VodImageUploadAuth.class);
            vodImageUploadAuth.toString();
            return vodImageUploadAuth;
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Get TOKEN info failed, json :");
            sb.append(str);
            return null;
        }
    }

    public java.lang.String getImageId() {
        return this.imageId;
    }

    public java.lang.String getImageURL() {
        return this.imageURL;
    }

    public java.lang.String getUploadAddress() {
        return this.uploadAddress;
    }

    public java.lang.String getUploadAuth() {
        return this.uploadAuth;
    }

    public void setImageId(java.lang.String str) {
        this.imageId = str;
    }

    public void setImageURL(java.lang.String str) {
        this.imageURL = str;
    }

    public void setUploadAddress(java.lang.String str) {
        this.uploadAddress = str;
    }

    public void setUploadAuth(java.lang.String str) {
        this.uploadAuth = str;
    }

    public java.lang.String toString() {
        return "VodImageUploadAuth{uploadAddress='" + this.uploadAddress + "', uploadAuth='" + this.uploadAuth + "', imageId='" + this.imageId + "', imageURL='" + this.imageURL + "'}";
    }
}
