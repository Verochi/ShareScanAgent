package com.aliyun.svideo.base.widget.pagerecyclerview;

/* loaded from: classes.dex */
public class GiftListItemForm {
    private int mDynamic;
    private java.lang.String mIconUrl;
    private int mId;
    private java.lang.String mName;
    private int mOrderNum;
    private int mPrice;
    private java.lang.String mResourceUrl;
    private int mSequence;
    private int mUpdated;

    public boolean equals(java.lang.Object obj) {
        return (obj == null || !(obj instanceof com.aliyun.svideo.base.widget.pagerecyclerview.GiftListItemForm)) ? super.equals(obj) : ((com.aliyun.svideo.base.widget.pagerecyclerview.GiftListItemForm) obj).getId() == this.mId;
    }

    public int getDynamic() {
        return this.mDynamic;
    }

    public java.lang.String getIconUrl() {
        return this.mIconUrl;
    }

    public int getId() {
        return this.mId;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public int getOrderNum() {
        return this.mOrderNum;
    }

    public int getPrice() {
        return this.mPrice;
    }

    public java.lang.String getResourceUrl() {
        return this.mResourceUrl;
    }

    public int getSequence() {
        return this.mSequence;
    }

    public int getUpdated() {
        return this.mUpdated;
    }

    public boolean isContinuous() {
        return this.mSequence == 1;
    }

    public boolean isDynamic() {
        return this.mDynamic == 1;
    }

    public void setDynamic(int i) {
        this.mDynamic = i;
    }

    public void setIconUrl(java.lang.String str) {
        this.mIconUrl = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setOrderNum(int i) {
        this.mOrderNum = i;
    }

    public void setPrice(int i) {
        this.mPrice = i;
    }

    public void setResourceUrl(java.lang.String str) {
        this.mResourceUrl = str;
    }

    public void setSequence(int i) {
        this.mSequence = i;
    }

    public void setUpdated(int i) {
        this.mUpdated = i;
    }
}
