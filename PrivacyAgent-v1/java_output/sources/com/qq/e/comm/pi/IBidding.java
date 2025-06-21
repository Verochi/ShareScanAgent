package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface IBidding {
    public static final java.lang.String ADN_ID = "adnId";
    public static final java.lang.String EXPECT_COST_PRICE = "expectCostPrice";
    public static final java.lang.String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final java.lang.String LOSS_REASON = "lossReason";
    public static final java.lang.String WIN_PRICE = "winPrice";

    @java.lang.Deprecated
    void sendLossNotification(int i, int i2, java.lang.String str);

    void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> map);

    @java.lang.Deprecated
    void sendWinNotification(int i);

    void sendWinNotification(java.util.Map<java.lang.String, java.lang.Object> map);

    void setBidECPM(int i);
}
