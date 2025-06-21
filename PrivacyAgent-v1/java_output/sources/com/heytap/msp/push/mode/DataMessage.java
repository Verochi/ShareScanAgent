package com.heytap.msp.push.mode;

/* loaded from: classes22.dex */
public class DataMessage extends com.heytap.msp.push.mode.BaseMode {
    private java.lang.String mAppId;
    private java.lang.String mAppPackage;
    private java.lang.String mBalanceTime;
    private java.lang.String mContent;
    private java.lang.String mDataExtra;
    private java.lang.String mDescription;
    private java.lang.String mDistinctContent;
    private java.lang.String mEndDate;
    private java.lang.String mEventId;
    private java.lang.String mForcedDelivery;
    private java.lang.String mGlobalId;
    private java.lang.String mMessageID;
    private int mMessageType;
    private int mMsgCommand;
    private int mNotifyID;
    private java.lang.String mRule;
    private java.lang.String mStartDate;
    private java.lang.String mStatisticsExtra;
    private java.lang.String mTimeRanges;
    private java.lang.String mTitle;
    private java.lang.String mTaskID = "";
    private java.lang.String mMiniProgramPkg = "";

    public java.lang.String getAppId() {
        return this.mAppId;
    }

    public java.lang.String getAppPackage() {
        return this.mAppPackage;
    }

    public java.lang.String getBalanceTime() {
        return this.mBalanceTime;
    }

    public java.lang.String getContent() {
        return this.mContent;
    }

    public java.lang.String getDataExtra() {
        return this.mDataExtra;
    }

    public java.lang.String getDescription() {
        return this.mDescription;
    }

    public java.lang.String getDistinctContent() {
        return this.mDistinctContent;
    }

    public java.lang.String getEndDate() {
        return this.mEndDate;
    }

    public java.lang.String getEventId() {
        return this.mEventId;
    }

    public java.lang.String getForcedDelivery() {
        return this.mForcedDelivery;
    }

    public java.lang.String getGlobalId() {
        return this.mGlobalId;
    }

    public java.lang.String getMessageID() {
        return this.mMessageID;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public java.lang.String getMiniProgramPkg() {
        return this.mMiniProgramPkg;
    }

    public int getMsgCommand() {
        return this.mMsgCommand;
    }

    public int getNotifyID() {
        return this.mNotifyID;
    }

    public java.lang.String getRule() {
        return this.mRule;
    }

    public java.lang.String getStartDate() {
        return this.mStartDate;
    }

    public java.lang.String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public java.lang.String getTaskID() {
        return this.mTaskID;
    }

    public java.lang.String getTimeRanges() {
        return this.mTimeRanges;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4103;
    }

    public void setAppId(java.lang.String str) {
        this.mAppId = str;
    }

    public void setAppPackage(java.lang.String str) {
        this.mAppPackage = str;
    }

    public void setBalanceTime(java.lang.String str) {
        this.mBalanceTime = str;
    }

    public void setContent(java.lang.String str) {
        this.mContent = str;
    }

    public void setDataExtra(java.lang.String str) {
        this.mDataExtra = str;
    }

    public void setDescription(java.lang.String str) {
        this.mDescription = str;
    }

    public void setDistinctContent(java.lang.String str) {
        this.mDistinctContent = str;
    }

    public void setEndDate(java.lang.String str) {
        this.mEndDate = str;
    }

    public void setEventId(java.lang.String str) {
        this.mEventId = str;
    }

    public void setForcedDelivery(java.lang.String str) {
        this.mForcedDelivery = str;
    }

    public void setGlobalId(java.lang.String str) {
        this.mGlobalId = str;
    }

    public void setMessageID(java.lang.String str) {
        this.mMessageID = str;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public void setMiniProgramPkg(java.lang.String str) {
        this.mMiniProgramPkg = str;
    }

    public void setMsgCommand(int i) {
        this.mMsgCommand = i;
    }

    public void setNotifyID(int i) {
        this.mNotifyID = i;
    }

    public void setRule(java.lang.String str) {
        this.mRule = str;
    }

    public void setStartDate(java.lang.String str) {
        this.mStartDate = str;
    }

    public void setStatisticsExtra(java.lang.String str) {
        this.mStatisticsExtra = str;
    }

    public void setTaskID(int i) {
        this.mTaskID = i + "";
    }

    public void setTaskID(java.lang.String str) {
        this.mTaskID = str;
    }

    public void setTimeRanges(java.lang.String str) {
        this.mTimeRanges = str;
    }

    public void setTitle(java.lang.String str) {
        this.mTitle = str;
    }

    public java.lang.String toString() {
        return "DataMessage{mMessageID='" + this.mMessageID + "'mMessageType='" + this.mMessageType + "'mAppPackage='" + this.mAppPackage + "', mTaskID='" + this.mTaskID + "'mTitle='" + this.mTitle + "'mNotifyID='" + this.mNotifyID + "', mContent='" + this.mContent + "', mGlobalId='" + this.mGlobalId + "', mBalanceTime='" + this.mBalanceTime + "', mStartDate='" + this.mStartDate + "', mEndDate='" + this.mEndDate + "', mTimeRanges='" + this.mTimeRanges + "', mRule='" + this.mRule + "', mForcedDelivery='" + this.mForcedDelivery + "', mDistinctContent='" + this.mDistinctContent + "', mAppId='" + this.mAppId + "'}";
    }
}
