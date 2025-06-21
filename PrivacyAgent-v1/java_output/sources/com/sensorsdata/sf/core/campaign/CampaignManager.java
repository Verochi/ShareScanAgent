package com.sensorsdata.sf.core.campaign;

/* loaded from: classes19.dex */
public class CampaignManager {
    public static com.sensorsdata.sf.core.entity.SFCampaign cacheSFCampaign;

    public static com.sensorsdata.sf.core.enums.CampaignStatus setCampaignStatus(java.lang.String str, boolean z, boolean z2, com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener, java.lang.String str2, boolean z3) {
        if (z3) {
            if (z) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW;
            }
            if (sensorsFocusCampaignListener != null && !sensorsFocusCampaignListener.campaignShouldStart(cacheSFCampaign.m96clone())) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_NOT_START_LISTENER;
            }
            return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_SHOW;
        }
        if (!z2) {
            return com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_NOT_START_TRIGGER;
        }
        if (sensorsFocusCampaignListener != null) {
            if (!sensorsFocusCampaignListener.campaignShouldStart(cacheSFCampaign.m96clone())) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_NOT_START_LISTENER;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED;
            }
            if ("CUSTOMIZED".equals(str)) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_TRIGGER_CUSTOMIZED_START;
            }
            if ("PRESET".equals(str)) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_SHOW;
            }
        } else {
            if ("CUSTOMIZED".equals(str)) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_CUSTOMIZED_NULL_LISTENER;
            }
            if ("PRESET".equals(str)) {
                return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_SHOW;
            }
        }
        return null;
    }

    public static com.sensorsdata.sf.core.enums.CampaignStatus setDebugCampaignStatus(java.lang.String str, java.lang.String str2, com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED;
        }
        if ("PRESET".equals(str2)) {
            return com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_SHOW;
        }
        if ("CUSTOMIZED".equals(str2)) {
            return sensorsFocusCampaignListener == null ? com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_CUSTOMIZED_NULL_LISTENER : com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_TRIGGER_CUSTOMIZED_START;
        }
        return null;
    }
}
