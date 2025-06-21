package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class tanxc_if implements com.alimm.tanx.core.ad.listener.bean.IMonitorBean {
    private java.util.List<java.lang.String> tanxc_do;
    private java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> tanxc_for;
    private java.util.List<java.lang.String> tanxc_if;
    private java.lang.String tanxc_int;

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public java.util.List<java.lang.String> getClickTrackUrl() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> getEventTrack() {
        return this.tanxc_for;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public java.util.List<java.lang.String> getImpTrackUrl() {
        return this.tanxc_do;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public java.lang.String getWinNoticeUrl() {
        return this.tanxc_int;
    }

    public void tanxc_do(java.lang.String str) {
        this.tanxc_int = str;
    }

    public void tanxc_do(java.util.List<java.lang.String> list) {
        this.tanxc_do = list;
    }

    public void tanxc_for(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> list) {
        this.tanxc_for = list;
    }

    public void tanxc_if(java.util.List<java.lang.String> list) {
        this.tanxc_if = list;
    }
}
