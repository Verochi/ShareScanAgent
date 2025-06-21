package com.anythink.core.api;

/* loaded from: classes12.dex */
public interface ATBiddingNotice {
    public static final java.lang.String ADN_ID = "adn_id";

    com.anythink.core.api.ATAdConst.CURRENCY getNoticePriceCurrency();

    void notifyBidDisplay(boolean z, double d);

    void notifyBidLoss(java.lang.String str, double d, java.util.Map<java.lang.String, java.lang.Object> map);

    void notifyBidWin(double d, double d2, java.util.Map<java.lang.String, java.lang.Object> map);
}
