package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public interface IBaseAd {
    int getECPM();

    java.util.Map<java.lang.String, java.lang.Object> getExtraInfo();

    java.lang.String getReqId();

    void sendLossNotification(int i, int i2, java.lang.String str);

    void sendWinNotification(int i);

    void setBidECPM(int i);

    void setPayload(java.lang.String str);
}
