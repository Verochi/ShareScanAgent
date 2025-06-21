package com.alimm.tanx.core.ad.listener.bean;

/* loaded from: classes.dex */
public interface IAdInfo {
    int getAdCount();

    java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.IBidInfo> getBidInfoList();

    java.lang.String getDecrypt();

    java.lang.String getRequestId();

    java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ISeatInfo> getSeatList();

    int getStatus();
}
