package com.qq.e.ads.banner2;

/* loaded from: classes19.dex */
class ADListenerAdapter implements com.qq.e.comm.adevent.ADListener {
    private final com.qq.e.ads.banner2.UnifiedBannerADListener a;
    private com.qq.e.comm.listeners.NegativeFeedbackListener b;
    private com.qq.e.comm.listeners.ADRewardListener c;

    public ADListenerAdapter(com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener) {
        this.a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
        com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener;
        java.lang.String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 100) {
            com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener2 = this.a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
            if (num == null || (unifiedBannerADListener = this.a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener3 = this.a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener = this.b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener4 = this.a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.c != null && (str = (java.lang.String) aDEvent.getParam(java.lang.String.class)) != null) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("transId", str);
                    this.c.onReward(hashMap);
                    break;
                }
                break;
            case 105:
                com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener5 = this.a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                    break;
                }
                break;
            case 106:
                com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener6 = this.a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                    break;
                }
                break;
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.b = negativeFeedbackListener;
    }
}
