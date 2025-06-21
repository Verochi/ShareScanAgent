package com.aliyun.svideo.base.Form;

/* loaded from: classes.dex */
public class ResourceForm {
    private transient boolean isMore;
    private java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> mAnimationEffectForms;

    @com.google.gson.annotations.SerializedName("description")
    private java.lang.String mDescription;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN)
    private java.lang.String mDescriptionEn;

    @com.google.gson.annotations.SerializedName("icon")
    private java.lang.String mIcon;

    @com.google.gson.annotations.SerializedName("id")
    private int mId;

    @com.google.gson.annotations.SerializedName("isNew")
    private int mIsNew;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL)
    private int mLevel;

    @com.google.gson.annotations.SerializedName("name")
    private java.lang.String mName;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN)
    private java.lang.String mNameEn;

    @com.google.gson.annotations.SerializedName("pasterList")
    private java.util.List<com.aliyun.svideo.base.Form.PasterForm> mPasterList;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW)
    private java.lang.String mPreviewUrl;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)
    private int mSort;
    private java.lang.String path;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mId == ((com.aliyun.svideo.base.Form.ResourceForm) obj).mId;
    }

    public java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> getAnimationEffectForms() {
        return this.mAnimationEffectForms;
    }

    public java.lang.String getDescription() {
        return this.mDescription;
    }

    public java.lang.String getDescriptionEn() {
        return this.mDescriptionEn;
    }

    public java.lang.String getIcon() {
        return this.mIcon;
    }

    public int getId() {
        return this.mId;
    }

    public int getIsNew() {
        return this.mIsNew;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getNameEn() {
        return this.mNameEn;
    }

    public java.util.List<com.aliyun.svideo.base.Form.PasterForm> getPasterList() {
        return this.mPasterList;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public java.lang.String getPreviewUrl() {
        return this.mPreviewUrl;
    }

    public int getSort() {
        return this.mSort;
    }

    public int hashCode() {
        return this.mId;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setAnimationEffectForms(java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list) {
        this.mAnimationEffectForms = list;
    }

    public void setDescription(java.lang.String str) {
        this.mDescription = str;
    }

    public void setDescriptionEn(java.lang.String str) {
        this.mDescriptionEn = str;
    }

    public void setIcon(java.lang.String str) {
        this.mIcon = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setIsNew(int i) {
        this.mIsNew = i;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setNameEn(java.lang.String str) {
        this.mNameEn = str;
    }

    public void setPasterList(java.util.List<com.aliyun.svideo.base.Form.PasterForm> list) {
        this.mPasterList = list;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setPreviewUrl(java.lang.String str) {
        this.mPreviewUrl = str;
    }

    public void setSort(int i) {
        this.mSort = i;
    }
}
