package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATBiddingNotify implements com.anythink.core.api.ATBiddingNotice {
    com.bytedance.sdk.openadsdk.TTClientBidding a;

    public TTATBiddingNotify(com.bytedance.sdk.openadsdk.TTClientBidding tTClientBidding) {
        this.a = tTClientBidding;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public com.anythink.core.api.ATAdConst.CURRENCY getNoticePriceCurrency() {
        return com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("notifyBidDisplay :  price:");
            sb.append(d);
            sb.append(",isWinner:");
            sb.append(z);
        }
        try {
            this.a.setPrice(java.lang.Double.valueOf(d));
        } catch (java.lang.Throwable unused) {
        }
        this.a = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(java.lang.String str, double d, java.util.Map<java.lang.String, java.lang.Object> map) {
        str.hashCode();
        int hashCode = str.hashCode();
        java.lang.String str2 = com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB;
        char c = 65535;
        switch (hashCode) {
            case 50:
                if (str.equals("2")) {
                    c = 0;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c = 1;
                    break;
                }
                break;
            case 48627:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)) {
                    c = 2;
                    break;
                }
                break;
            case 48628:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = "2";
                break;
            case 1:
            default:
                str2 = "201";
                break;
            case 2:
            case 3:
                break;
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("notifyBidLoss :  price: ");
            sb.append(d);
            sb.append(", lossCode: ");
            sb.append(str);
            sb.append(", lossReason: ");
            sb.append(str2);
        }
        try {
            this.a.loss(java.lang.Double.valueOf(d), str2, null);
        } catch (java.lang.Throwable unused) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d, double d2, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            "notifyBidWin : second price:".concat(java.lang.String.valueOf(d2));
        }
        try {
            this.a.win(java.lang.Double.valueOf(d2));
        } catch (java.lang.Throwable unused) {
        }
    }
}
