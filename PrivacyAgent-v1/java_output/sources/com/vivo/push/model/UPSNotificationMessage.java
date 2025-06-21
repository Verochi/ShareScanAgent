package com.vivo.push.model;

/* loaded from: classes19.dex */
public class UPSNotificationMessage {
    public static final int CUSTOM = 3;
    public static final int ISMACROREPLACE = 1;
    public static final int OPENACTIVITY = 4;
    public static final int OPENAPP = 1;
    public static final int OPENURL = 2;
    public static final int UNKNOWN = 0;
    private java.lang.String mAdClickCheckUrl;
    private int mCompatibleType;
    private java.lang.String mContent;
    private java.lang.String mCoverUrl;
    private java.lang.String mIconUrl;
    private int mIsMacroReplace;
    private long mMsgId;
    private int mNotifyType;
    private java.util.Map<java.lang.String, java.lang.String> mParams = new java.util.HashMap();
    private java.lang.String mPurePicUrl;
    private boolean mShowTime;
    private java.lang.String mSkipContent;
    private int mSkipType;
    private int mTargetType;
    private java.lang.String mTitle;
    private java.lang.String mTragetContent;

    public void clearCoverUrl() {
        this.mIconUrl = "";
    }

    public void clearPurePicUrl() {
        this.mPurePicUrl = "";
    }

    public java.lang.String getAdClickCheckUrl() {
        return this.mAdClickCheckUrl;
    }

    public int getCompatibleType() {
        return this.mCompatibleType;
    }

    public java.lang.String getContent() {
        return this.mContent;
    }

    public java.lang.String getCoverUrl() {
        return this.mCoverUrl;
    }

    public java.lang.String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIsMacroReplace() {
        return this.mIsMacroReplace;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public int getNotifyType() {
        return this.mNotifyType;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.mParams;
    }

    public java.lang.String getPurePicUrl() {
        return this.mPurePicUrl;
    }

    public java.lang.String getSkipContent() {
        return this.mSkipContent;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public java.lang.String getTragetContent() {
        return this.mTragetContent;
    }

    public boolean isMacroReplace() {
        return this.mIsMacroReplace == 1;
    }

    public boolean isShowTime() {
        return this.mShowTime;
    }

    public void setAdClickCheckUrl(java.lang.String str) {
        this.mAdClickCheckUrl = str;
    }

    public void setCompatibleType(int i) {
        this.mCompatibleType = i;
    }

    public void setContent(java.lang.String str) {
        this.mContent = str;
    }

    public void setCoverUrl(java.lang.String str) {
        this.mCoverUrl = str;
    }

    public void setIconUrl(java.lang.String str) {
        this.mIconUrl = str;
    }

    public void setIsMacroReplace(int i) {
        this.mIsMacroReplace = i;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public void setNotifyType(int i) {
        this.mNotifyType = i;
    }

    public void setParams(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mParams = map;
    }

    public void setPurePicUrl(java.lang.String str) {
        this.mPurePicUrl = str;
    }

    public void setShowTime(boolean z) {
        this.mShowTime = z;
    }

    public void setSkipContent(java.lang.String str) {
        this.mSkipContent = str;
    }

    public void setSkipType(int i) {
        this.mSkipType = i;
    }

    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    public void setTitle(java.lang.String str) {
        this.mTitle = str;
    }

    public void setTragetContext(java.lang.String str) {
        this.mTragetContent = str;
    }

    public java.lang.String toString() {
        return "UPSNotificationMessage{mTargetType=" + this.mTargetType + ", mTragetContent='" + this.mTragetContent + "', mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mNotifyType=" + this.mNotifyType + ", mPurePicUrl='" + this.mPurePicUrl + "', mIconUrl='" + this.mIconUrl + "', mCoverUrl='" + this.mCoverUrl + "', mSkipContent='" + this.mSkipContent + "', mSkipType=" + this.mSkipType + ", mShowTime=" + this.mShowTime + ", mMsgId=" + this.mMsgId + ", mParams=" + this.mParams + '}';
    }
}
