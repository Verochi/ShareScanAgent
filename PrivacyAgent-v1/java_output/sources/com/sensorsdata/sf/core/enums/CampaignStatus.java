package com.sensorsdata.sf.core.enums;

/* loaded from: classes19.dex */
public enum CampaignStatus {
    CAMPAIGN_TRIGGER_CUSTOMIZED_START(-1, null),
    DIALOG_SHOW(-1, null),
    DIALOG_NOT_SHOW_JSON_FAILED(1001, "预览信息解析失败，请检查计划配置"),
    DIALOG_NOT_SHOW(1003, "对照组"),
    CAMPAIGN_NOT_START_LISTENER(1004, "campaignShouldStart 接口返回 false"),
    CAMPAIGN_NOT_START_TRIGGER(1005, "计划下发 is_trigger 为 false"),
    CAMPAIGN_CUSTOMIZED_NULL_LISTENER(1006, "自定义触达计划未实现弹窗生命周期回调"),
    ACTIVITY_IN_BACKGROUND_FINISH(1002, "App 在后台或者已经有弹窗展示");

    private final int errorCode;
    private final java.lang.String errorMessage;

    CampaignStatus(int i, java.lang.String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public java.lang.String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return "CampaignStatus{errorMessage='" + this.errorMessage + "', errorCode=" + this.errorCode + '}';
    }
}
