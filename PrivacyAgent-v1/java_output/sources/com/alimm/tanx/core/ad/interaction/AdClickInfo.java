package com.alimm.tanx.core.ad.interaction;

/* loaded from: classes.dex */
public class AdClickInfo implements com.alimm.tanx.core.utils.NotConfused {
    private int adType;
    private com.alimm.tanx.core.ut.AdUtConstants adUtConstants;
    private java.lang.String clickThroughUrl;
    private java.lang.String creativeId;
    private java.lang.String deepLinkUrl;
    private java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack;
    private int openType;
    private java.lang.String pid;
    private java.lang.String pidStyleId;
    private java.lang.String rawJsonStr;
    private java.lang.String reqId;
    private java.lang.String sessionId;
    private java.lang.String templateId;
    private java.util.Map<java.lang.String, java.lang.String> utArgs = new java.util.HashMap();
    private java.lang.String webClickThroughUrl;
    private java.lang.String webDeepLinkUrl;

    public AdClickInfo(int i, java.lang.String str, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, com.alimm.tanx.core.ut.AdUtConstants adUtConstants, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> list) {
        this.adType = -1;
        this.openType = -1;
        this.adType = i;
        this.creativeId = str;
        this.openType = i2;
        this.templateId = str2;
        this.sessionId = str3;
        this.pidStyleId = str4;
        this.pid = str5;
        this.reqId = str6;
        this.clickThroughUrl = str7;
        this.deepLinkUrl = str8;
        this.adUtConstants = adUtConstants;
        this.webClickThroughUrl = str9;
        this.webDeepLinkUrl = str10;
        this.rawJsonStr = str11;
        this.eventTrack = list;
    }

    public int getAdType() {
        return this.adType;
    }

    public com.alimm.tanx.core.ut.AdUtConstants getAdUtConstants() {
        return this.adUtConstants;
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

    public java.lang.String getPidStyleId() {
        return this.pidStyleId;
    }

    public java.lang.String getRawJsonStr() {
        return this.rawJsonStr;
    }

    public java.lang.String getReqId() {
        return this.reqId;
    }

    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    public java.lang.String getTemplateId() {
        return this.templateId;
    }

    public java.util.Map<java.lang.String, java.lang.String> getUtArgs() {
        return this.utArgs;
    }

    public java.lang.String getWebClickThroughUrl() {
        return this.webClickThroughUrl;
    }

    public java.lang.String getWebDeepLinkUrl() {
        return this.webDeepLinkUrl;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdUtConstants(com.alimm.tanx.core.ut.AdUtConstants adUtConstants) {
        this.adUtConstants = adUtConstants;
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

    public void setPidStyleId(java.lang.String str) {
        this.pidStyleId = str;
    }

    public void setRawJsonStr(java.lang.String str) {
        this.rawJsonStr = str;
    }

    public void setReqId(java.lang.String str) {
        this.reqId = str;
    }

    public void setSessionId(java.lang.String str) {
        this.sessionId = str;
    }

    public void setTemplateId(java.lang.String str) {
        this.templateId = str;
    }

    public void setUtArgs(java.util.Map<java.lang.String, java.lang.String> map) {
        this.utArgs = map;
    }

    public void setWebClickThroughUrl(java.lang.String str) {
        this.webClickThroughUrl = str;
    }

    public void setWebDeepLinkUrl(java.lang.String str) {
        this.webDeepLinkUrl = str;
    }
}
