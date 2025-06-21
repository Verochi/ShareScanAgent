package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class BidInfo extends com.alimm.tanx.core.ad.bean.BaseBean implements com.alimm.tanx.core.ad.listener.bean.IBidInfo {

    @com.alibaba.fastjson.annotation.JSONField(name = "ad_source")
    private java.lang.String adSource;

    @com.alibaba.fastjson.annotation.JSONField(name = com.anythink.expressad.foundation.d.c.a.h)
    private java.lang.String advLogo;

    @com.alibaba.fastjson.annotation.JSONField(name = "bid_price")
    private long bidPrice;

    @com.alibaba.fastjson.annotation.JSONField(name = "click_through_url")
    private java.lang.String clickThroughUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "click_tracking_url")
    private java.util.List<java.lang.String> clickTrackUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "creative_id")
    private java.lang.String creativeId;

    @com.alibaba.fastjson.annotation.JSONField(name = "materials")
    private com.alimm.tanx.core.ad.bean.CreativeItem creativeItem;

    @com.alibaba.fastjson.annotation.JSONField(name = com.anythink.basead.b.a.C0131a.o)
    private java.lang.String deepLinkUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "event_track")
    private java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack;

    @com.alibaba.fastjson.annotation.JSONField(name = "id")
    private int id;

    @com.alibaba.fastjson.annotation.JSONField(name = "impression_tracking_url")
    private java.util.List<java.lang.String> impTrackUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.interactType)
    private java.lang.Integer[] interactType;

    @com.alibaba.fastjson.annotation.JSONField(name = "open_type")
    private int openType;

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    private java.lang.String rawJsonStr;

    @com.alibaba.fastjson.annotation.JSONField(name = "end_time")
    private long releaseEndTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "begin_time")
    private long releaseStartTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "session_id")
    private java.lang.String sessionId;

    @com.alibaba.fastjson.annotation.JSONField(name = "sub_materials")
    private java.lang.String subMaterials;

    @com.alibaba.fastjson.annotation.JSONField(name = "template_conf")
    private com.alimm.tanx.core.ad.bean.TemplateConfig templateConf;

    @com.alibaba.fastjson.annotation.JSONField(name = "template_height")
    private java.lang.String templateHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId)
    private java.lang.String templateId;

    @com.alibaba.fastjson.annotation.JSONField(name = "template_width")
    private java.lang.String templateWidth;

    @com.alibaba.fastjson.annotation.JSONField(name = "winnotice_url")
    private java.lang.String winNoticeUrl;
    private final com.alimm.tanx.core.ad.bean.tanxc_do clickBean = new com.alimm.tanx.core.ad.bean.tanxc_do();
    private final com.alimm.tanx.core.ad.bean.tanxc_if monitorBean = new com.alimm.tanx.core.ad.bean.tanxc_if();

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getAdSource() {
        return this.adSource;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getAdvLogo() {
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getAdvLogo();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getBidPrice() {
        return this.bidPrice;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public com.alimm.tanx.core.ad.listener.bean.IClickBean getClickBean() {
        return this.clickBean;
    }

    public java.lang.String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public java.util.List<java.lang.String> getClickTrackUrl() {
        return this.clickTrackUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getCreativeId() {
        return this.creativeId;
    }

    public com.alimm.tanx.core.ad.bean.CreativeItem getCreativeItem() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getCreativeMd5() {
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageMd5();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getCreativeName() {
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem = this.creativeItem;
        return (creativeItem == null || android.text.TextUtils.isEmpty(creativeItem.getImageUrl())) ? "" : com.alimm.tanx.core.utils.MD5Utils.getMD5String(this.creativeItem.getImageUrl());
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getCreativePath() {
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageUrl();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getCreativeType() {
        return "splash";
    }

    public java.lang.String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> getEventTrack() {
        return this.eventTrack;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getId() {
        return this.id;
    }

    public java.util.List<java.lang.String> getImpTrackUrl() {
        return this.impTrackUrl;
    }

    public boolean getInteractType(int i) {
        return getInteractType() != null && getInteractType().length > 0 && java.util.Arrays.binarySearch(getInteractType(), java.lang.Integer.valueOf(i)) >= 0;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.Integer[] getInteractType() {
        return this.interactType;
    }

    public boolean getInteractType2FeedSlide() {
        return getInteractType(3);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getInteractType2Int() {
        java.lang.Integer[] numArr = this.interactType;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public boolean getInteractType2Shake() {
        return getInteractType(1);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public com.alimm.tanx.core.ad.listener.bean.IMaterialBean getMaterialBean() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public com.alimm.tanx.core.ad.listener.bean.IMonitorBean getMonitorBean() {
        return this.monitorBean;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getOpenType() {
        return this.openType;
    }

    public java.lang.String getRawJsonStr() {
        return this.rawJsonStr;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseEndTime() {
        return this.releaseEndTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseStartTime() {
        return this.releaseStartTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    public java.lang.String getSubMaterials() {
        return this.subMaterials;
    }

    public com.alimm.tanx.core.ad.bean.TemplateConfig getTemplateConf() {
        return this.templateConf;
    }

    public java.lang.String getTemplateHeight() {
        return this.templateHeight;
    }

    public int getTemplateHeight2Int() {
        int i;
        try {
            i = java.lang.Integer.parseInt(this.templateHeight);
        } catch (java.lang.Exception unused) {
            i = 9;
        }
        if (i <= 0) {
            return 9;
        }
        return i;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public java.lang.String getTemplateId() {
        return this.templateId;
    }

    public java.lang.String getTemplateWidth() {
        return this.templateWidth;
    }

    public int getTemplateWidth2Int() {
        int i;
        try {
            i = java.lang.Integer.parseInt(this.templateWidth);
        } catch (java.lang.Exception unused) {
            i = 16;
        }
        if (i <= 0) {
            return 16;
        }
        return i;
    }

    public java.lang.String getWinNoticeUrl() {
        return this.winNoticeUrl;
    }

    public com.alimm.tanx.core.ad.bean.BidInfo removeSensitiveData() {
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = new com.alimm.tanx.core.ad.bean.BidInfo();
        bidInfo.setId(getId());
        bidInfo.setCreativeId(getCreativeId());
        bidInfo.setBidPrice(getBidPrice());
        bidInfo.setInteractType(getInteractType());
        bidInfo.setTemplateId(getTemplateId());
        bidInfo.setCreativeItem(getCreativeItem());
        bidInfo.setClickThroughUrl(getClickThroughUrl());
        bidInfo.setOpenType(getOpenType());
        bidInfo.setClickTrackUrl(getClickTrackUrl());
        bidInfo.setWinNoticeUrl(getWinNoticeUrl());
        bidInfo.setEventTrack(getEventTrack());
        bidInfo.setReleaseStartTime(getReleaseStartTime());
        bidInfo.setReleaseEndTime(getReleaseEndTime());
        bidInfo.setAdSource(getAdSource());
        bidInfo.setDeepLinkUrl(getDeepLinkUrl());
        bidInfo.setAdvLogo(getAdvLogo());
        bidInfo.setSubMaterials(getSubMaterials());
        bidInfo.setTemplateConf(getTemplateConf());
        bidInfo.setSessionId(getSessionId());
        bidInfo.setTemplateWidth(getTemplateWidth());
        bidInfo.setTemplateHeight(getTemplateHeight());
        bidInfo.setRawJsonStr(getRawJsonStr());
        return bidInfo;
    }

    public void setAdSource(java.lang.String str) {
        this.adSource = str;
    }

    public void setAdvLogo(java.lang.String str) {
        this.advLogo = str;
    }

    public void setBidPrice(long j) {
        this.bidPrice = j;
    }

    public void setClickThroughUrl(java.lang.String str) {
        this.clickThroughUrl = str;
        com.alimm.tanx.core.ad.bean.tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(str);
        }
    }

    public void setClickTrackUrl(java.util.List<java.lang.String> list) {
        this.clickTrackUrl = list;
        com.alimm.tanx.core.ad.bean.tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_if(list);
        }
    }

    public void setCreativeId(java.lang.String str) {
        this.creativeId = str;
    }

    public void setCreativeItem(com.alimm.tanx.core.ad.bean.CreativeItem creativeItem) {
        this.creativeItem = creativeItem;
    }

    public void setDeepLinkUrl(java.lang.String str) {
        this.deepLinkUrl = str;
        com.alimm.tanx.core.ad.bean.tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_if(str);
        }
    }

    public void setEventTrack(java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> list) {
        this.eventTrack = list;
        com.alimm.tanx.core.ad.bean.tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_for(list);
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImpTrackUrl(java.util.List<java.lang.String> list) {
        this.impTrackUrl = list;
        com.alimm.tanx.core.ad.bean.tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(list);
        }
    }

    public void setInteractType(java.lang.Integer[] numArr) {
        this.interactType = numArr;
        com.alimm.tanx.core.ad.bean.tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(numArr);
        }
    }

    public void setOpenType(int i) {
        this.openType = i;
        com.alimm.tanx.core.ad.bean.tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(i);
        }
    }

    public void setRawJsonStr(java.lang.String str) {
        this.rawJsonStr = str;
    }

    public void setReleaseEndTime(long j) {
        this.releaseEndTime = j;
    }

    public void setReleaseStartTime(long j) {
        this.releaseStartTime = j;
    }

    public void setSessionId(java.lang.String str) {
        this.sessionId = str;
    }

    public void setSubMaterials(java.lang.String str) {
        this.subMaterials = str;
    }

    public void setTemplateConf(com.alimm.tanx.core.ad.bean.TemplateConfig templateConfig) {
        this.templateConf = templateConfig;
    }

    public void setTemplateHeight(java.lang.String str) {
        this.templateHeight = str;
    }

    public void setTemplateId(java.lang.String str) {
        this.templateId = str;
    }

    public void setTemplateWidth(java.lang.String str) {
        this.templateWidth = str;
    }

    public void setWinNoticeUrl(java.lang.String str) {
        this.winNoticeUrl = str;
        com.alimm.tanx.core.ad.bean.tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(str);
        }
    }
}
