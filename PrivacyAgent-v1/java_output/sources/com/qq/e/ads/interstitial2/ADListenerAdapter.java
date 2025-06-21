package com.qq.e.ads.interstitial2;

/* loaded from: classes19.dex */
class ADListenerAdapter implements com.qq.e.comm.adevent.ADListener {
    private final com.qq.e.ads.interstitial2.UnifiedInterstitialADListener a;
    private com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener b;
    private com.qq.e.comm.listeners.ADRewardListener c;
    private com.qq.e.comm.listeners.NegativeFeedbackListener d;

    public ADListenerAdapter(com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.a = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
        com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener;
        java.lang.String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 109) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.a;
            if (unifiedInterstitialADListener2 == null || !com.qq.e.comm.util.a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.a.onRenderSuccess();
            return;
        }
        if (type == 110) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.a;
            if (unifiedInterstitialADListener3 == null || !com.qq.e.comm.util.a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.a.onRenderFail();
            return;
        }
        if (type == 201) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
            com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.a;
                if (unifiedInterstitialADListener5 != null) {
                    unifiedInterstitialADListener5.onADReceive();
                    break;
                }
                break;
            case 101:
                java.lang.Integer num2 = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                if (num2 != null && (unifiedInterstitialADListener = this.a) != null) {
                    unifiedInterstitialADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num2.intValue()));
                    break;
                }
                break;
            case 102:
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.a;
                if (unifiedInterstitialADListener6 != null) {
                    unifiedInterstitialADListener6.onADOpened();
                    break;
                }
                break;
            case 103:
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.a;
                if (unifiedInterstitialADListener7 != null) {
                    unifiedInterstitialADListener7.onADExposure();
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
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.a;
                if (unifiedInterstitialADListener8 != null) {
                    unifiedInterstitialADListener8.onADClicked();
                    break;
                }
                break;
            case 106:
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.a;
                if (unifiedInterstitialADListener9 != null) {
                    unifiedInterstitialADListener9.onADClosed();
                    break;
                }
                break;
            default:
                switch (type) {
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_INIT /* 209 */:
                        com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.b;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                            break;
                        }
                        break;
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_READY /* 210 */:
                        java.lang.Integer num3 = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                        com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.b;
                        if (unifiedInterstitialMediaListener6 != null && num3 != null) {
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            break;
                        }
                        break;
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING /* 211 */:
                        com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.b;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            break;
                        }
                        break;
                    default:
                        switch (type) {
                            case 301:
                                com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.b;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    break;
                                }
                                break;
                            case 302:
                                com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.b;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    break;
                                }
                                break;
                            case 303:
                                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.a;
                                if (unifiedInterstitialADListener10 != null) {
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                    break;
                                }
                                break;
                            case 304:
                                com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener = this.d;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                    break;
                                }
                                break;
                        }
                }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.c = aDRewardListener;
    }

    public void setMediaListener(com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.b = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.d = negativeFeedbackListener;
    }
}
