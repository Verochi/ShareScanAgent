package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class TrackItem extends com.alimm.tanx.core.ad.bean.BaseBean implements com.alimm.tanx.core.ad.listener.bean.ITrackItem {

    @com.alibaba.fastjson.annotation.JSONField(name = "time")
    private int time;

    @com.alibaba.fastjson.annotation.JSONField(name = "type")
    private int type;

    @com.alibaba.fastjson.annotation.JSONField(name = "url")
    private java.util.List<java.lang.String> url;

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getTime() {
        return this.time;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getType() {
        return this.type;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public java.util.List<java.lang.String> getUrl() {
        return this.url;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(java.util.List<java.lang.String> list) {
        this.url = list;
    }
}
