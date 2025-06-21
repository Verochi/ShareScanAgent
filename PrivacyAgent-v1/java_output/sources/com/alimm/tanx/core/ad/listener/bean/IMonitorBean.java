package com.alimm.tanx.core.ad.listener.bean;

/* loaded from: classes.dex */
public interface IMonitorBean {
    java.util.List<java.lang.String> getClickTrackUrl();

    java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> getEventTrack();

    java.util.List<java.lang.String> getImpTrackUrl();

    java.lang.String getWinNoticeUrl();
}
