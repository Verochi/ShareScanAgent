package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class VodInfo {
    private java.lang.Integer cateId;
    private java.lang.String coverUrl;
    private java.lang.String desc;
    private java.lang.String fileName;
    private java.lang.String fileSize;
    private java.lang.String imageType;
    private java.lang.Boolean isProcess = java.lang.Boolean.TRUE;
    private java.lang.Boolean isShowWaterMark;
    private java.lang.Integer priority;
    private java.util.List<java.lang.String> tags;
    private java.lang.String title;
    private java.lang.String userData;

    public java.lang.Integer getCateId() {
        return this.cateId;
    }

    public java.lang.String getCoverUrl() {
        return this.coverUrl;
    }

    public java.lang.String getDesc() {
        return this.desc;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public java.lang.String getFileSize() {
        return this.fileSize;
    }

    public java.lang.String getImageType() {
        return this.imageType;
    }

    public java.lang.Boolean getIsProcess() {
        return this.isProcess;
    }

    public java.lang.Boolean getIsShowWaterMark() {
        return this.isShowWaterMark;
    }

    public java.lang.Integer getPriority() {
        return this.priority;
    }

    public java.util.List<java.lang.String> getTags() {
        return this.tags;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getUserData() {
        return this.userData;
    }

    public void setCateId(java.lang.Integer num) {
        this.cateId = num;
    }

    public void setCoverUrl(java.lang.String str) {
        this.coverUrl = str;
    }

    public void setDesc(java.lang.String str) {
        this.desc = str;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public void setFileSize(java.lang.String str) {
        this.fileSize = str;
    }

    public void setImageType(java.lang.String str) {
        this.imageType = str;
    }

    public void setIsProcess(java.lang.Boolean bool) {
        this.isProcess = bool;
    }

    public void setIsShowWaterMark(java.lang.Boolean bool) {
        this.isShowWaterMark = bool;
    }

    public void setPriority(java.lang.Integer num) {
        this.priority = num;
    }

    public void setTags(java.util.List<java.lang.String> list) {
        this.tags = list;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setUserData(java.lang.String str) {
        this.userData = str;
    }

    public java.lang.String toVodJsonStringWithBase64() {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject = new org.json.JSONObject();
            jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE, getTitle());
            jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DESCRIPTION, getDesc());
            jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_CATEID, java.lang.String.valueOf(getCateId()));
            jSONObject.put("CoverUrl", getCoverUrl());
            jSONObject.put("IsProcess", getIsProcess().toString());
            java.lang.String str = "";
            if (getTags() != null && getTags().size() > 0) {
                java.lang.String obj = getTags().toString();
                str = obj.substring(1, obj.length() - 1);
            }
            jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TAGS, str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (this.isShowWaterMark == null && this.priority == null) {
            jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_USERDATA, getUserData());
            jSONObject2.put("Vod", jSONObject);
            return android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2);
        }
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        java.lang.Boolean bool = this.isShowWaterMark;
        if (bool == null || !bool.booleanValue()) {
            jSONObject3.put("IsShowWaterMark", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else {
            jSONObject3.put("IsShowWaterMark", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        jSONObject3.put("Priority", java.lang.String.valueOf(getPriority()));
        jSONObject.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_USERDATA, jSONObject3);
        jSONObject2.put("Vod", jSONObject);
        return android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2);
    }
}
