package com.alimm.tanx.core.bridge;

/* loaded from: classes.dex */
public class JsBridgeBean implements com.alimm.tanx.core.utils.NotConfused {
    private java.lang.String clickThroughUrl;
    private java.lang.String creativeId;
    private java.lang.String deepLinkUrl;
    private java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack;
    private int openType;
    private java.lang.String pid;
    private java.lang.String rawJsonStr;
    private java.lang.String reqId;
    private java.lang.String templateId;

    public JsBridgeBean() {
    }

    public JsBridgeBean(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot) {
        if (tanxAdSlot != null) {
            this.pid = tanxAdSlot.getPid();
            this.reqId = tanxAdSlot.getReqId();
        }
        if (bidInfo != null) {
            this.rawJsonStr = bidInfo.getRawJsonStr();
            this.eventTrack = bidInfo.getEventTrack();
            this.templateId = bidInfo.getTemplateId();
            this.creativeId = bidInfo.getCreativeId();
            this.openType = bidInfo.getOpenType();
            this.deepLinkUrl = bidInfo.getDeepLinkUrl();
            this.clickThroughUrl = bidInfo.getClickThroughUrl();
        }
    }

    public JsBridgeBean(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> list, java.lang.String str4, java.lang.String str5, int i, java.lang.String str6, java.lang.String str7) {
        this.pid = str;
        this.reqId = str2;
        this.rawJsonStr = str3;
        this.eventTrack = list;
        this.templateId = str4;
        this.creativeId = str5;
        this.openType = i;
        this.deepLinkUrl = str6;
        this.clickThroughUrl = str7;
    }

    public java.lang.String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public java.lang.String getCreativeId() {
        return this.creativeId;
    }

    public java.lang.String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> getEventTrack() {
        return this.eventTrack;
    }

    public int getOpenType() {
        return this.openType;
    }

    public java.lang.String getPid() {
        return this.pid;
    }

    public java.lang.String getRawJsonStr() {
        return this.rawJsonStr;
    }

    public java.lang.String getReqId() {
        return this.reqId;
    }

    public java.lang.String getTemplateId() {
        return this.templateId;
    }

    public void setClickThroughUrl(java.lang.String str) {
        this.clickThroughUrl = str;
    }

    public void setCreativeId(java.lang.String str) {
        this.creativeId = str;
    }

    public void setDeepLinkUrl(java.lang.String str) {
        this.deepLinkUrl = str;
    }

    public void setEventTrack(java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> list) {
        this.eventTrack = list;
    }

    public void setOpenType(int i) {
        this.openType = i;
    }

    public void setPid(java.lang.String str) {
        this.pid = str;
    }

    public void setRawJsonStr(java.lang.String str) {
        this.rawJsonStr = str;
    }

    public void setReqId(java.lang.String str) {
        this.reqId = str;
    }

    public void setTemplateId(java.lang.String str) {
        this.templateId = str;
    }
}
