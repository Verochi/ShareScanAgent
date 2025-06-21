package com.aliyun.svideo.base.Form;

/* loaded from: classes.dex */
public class PasterForm {

    @com.google.gson.annotations.SerializedName("url")
    private java.lang.String mDownloadUrl;

    @com.google.gson.annotations.SerializedName("fontId")
    private int mFontId;

    @com.google.gson.annotations.SerializedName("icon")
    private java.lang.String mIcon;

    @com.google.gson.annotations.SerializedName("id")
    private int mId;

    @com.google.gson.annotations.SerializedName("md5")
    private java.lang.String mMD5;

    @com.google.gson.annotations.SerializedName("name")
    private java.lang.String mName;

    @com.google.gson.annotations.SerializedName("path")
    private java.lang.String mPath;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW)
    private java.lang.String mPreviewUrl;

    @com.google.gson.annotations.SerializedName("priority")
    private int mPriority;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)
    private int mSort;

    @com.google.gson.annotations.SerializedName("type")
    private int mType;

    public java.lang.String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public int getFontId() {
        return this.mFontId;
    }

    public java.lang.String getIcon() {
        return this.mIcon;
    }

    public int getId() {
        return this.mId;
    }

    public java.lang.String getMD5() {
        return this.mMD5;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getPath() {
        return this.mPath;
    }

    public java.lang.String getPreviewUrl() {
        return this.mPreviewUrl;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getSort() {
        return this.mSort;
    }

    public int getType() {
        return this.mType;
    }

    public void setDownloadUrl(java.lang.String str) {
        this.mDownloadUrl = str;
    }

    public void setFontId(int i) {
        this.mFontId = i;
    }

    public void setIcon(java.lang.String str) {
        this.mIcon = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMD5(java.lang.String str) {
        this.mMD5 = str;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setPath(java.lang.String str) {
        this.mPath = str;
    }

    public void setPreviewUrl(java.lang.String str) {
        this.mPreviewUrl = str;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setSort(int i) {
        this.mSort = i;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
