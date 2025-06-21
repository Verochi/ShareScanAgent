package com.alimm.tanx.core.ad.listener.bean;

/* loaded from: classes.dex */
public interface IBidInfo {
    java.lang.String getAdSource();

    java.lang.String getAdvLogo();

    long getBidPrice();

    com.alimm.tanx.core.ad.listener.bean.IClickBean getClickBean();

    java.lang.String getCreativeId();

    java.lang.String getCreativeMd5();

    java.lang.String getCreativeName();

    java.lang.String getCreativePath();

    java.lang.String getCreativeType();

    int getId();

    java.lang.Integer[] getInteractType();

    int getInteractType2Int();

    boolean getInteractType2Shake();

    com.alimm.tanx.core.ad.listener.bean.IMaterialBean getMaterialBean();

    com.alimm.tanx.core.ad.listener.bean.IMonitorBean getMonitorBean();

    int getOpenType();

    long getReleaseEndTime();

    long getReleaseStartTime();

    java.lang.String getSessionId();

    java.lang.String getTemplateId();
}
