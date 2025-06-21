package com.sensorsdata.sf.ui.listener;

/* loaded from: classes19.dex */
public interface SensorsFocusCampaignListener {
    boolean campaignShouldStart(com.sensorsdata.sf.core.entity.SFCampaign sFCampaign);

    void onCampaignEnd(com.sensorsdata.sf.core.entity.SFCampaign sFCampaign);

    void onCampaignFailed(com.sensorsdata.sf.core.entity.SFCampaign sFCampaign, int i, java.lang.String str);

    void onCampaignStart(com.sensorsdata.sf.core.entity.SFCampaign sFCampaign);
}
