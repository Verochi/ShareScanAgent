package com.aliyun.svideosdk.common.struct.form;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class ResourceForm {
    private transient boolean isMore;

    @com.google.gson.annotations.SerializedName("description")
    private java.lang.String mDescription;

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

    @com.google.gson.annotations.SerializedName("pasterList")
    private java.util.List<com.aliyun.svideosdk.common.struct.form.PasterForm> mPasterList;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW)
    private java.lang.String mPreviewUrl;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)
    private int mSort;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mId == ((com.aliyun.svideosdk.common.struct.form.ResourceForm) obj).mId;
    }

    public java.lang.String getDescription() {
        return this.mDescription;
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

    public java.util.List<com.aliyun.svideosdk.common.struct.form.PasterForm> getPasterList() {
        return this.mPasterList;
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

    public void setDescription(java.lang.String str) {
        this.mDescription = str;
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

    public void setPasterList(java.util.List<com.aliyun.svideosdk.common.struct.form.PasterForm> list) {
        this.mPasterList = list;
    }

    public void setPreviewUrl(java.lang.String str) {
        this.mPreviewUrl = str;
    }

    public void setSort(int i) {
        this.mSort = i;
    }
}
