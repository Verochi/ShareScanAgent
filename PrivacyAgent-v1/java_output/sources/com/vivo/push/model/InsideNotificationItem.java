package com.vivo.push.model;

/* loaded from: classes19.dex */
public class InsideNotificationItem extends com.vivo.push.model.UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageType;
    private int mNotifyDisplayStatus;
    private java.lang.String mReactPackage;
    private java.lang.String mSuitReactVersion;

    private int parsingNotifyStyle() {
        int i = this.mDisplayStyle;
        return ((i & 32) == 0 && (i & 16) != 0) ? 1 : 0;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public java.lang.String getReactPackage() {
        return this.mReactPackage;
    }

    public java.lang.String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public void setDisplayStyle(int i) {
        this.mDisplayStyle = i;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public void setInnerPriority(int i) {
        this.mInnerPriority = i;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public void setReactPackage(java.lang.String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(java.lang.String str) {
        this.mSuitReactVersion = str;
    }
}
