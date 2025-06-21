package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATBiddingNotice implements com.anythink.core.api.ATBiddingNotice {
    java.lang.Object a;

    public GDTATBiddingNotice(java.lang.Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public com.anythink.core.api.ATAdConst.CURRENCY getNoticePriceCurrency() {
        return com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(java.lang.String str, double d, java.util.Map<java.lang.String, java.lang.Object> map) {
        char c;
        int i;
        java.lang.Object obj;
        int i2 = 4;
        java.util.HashMap hashMap = new java.util.HashMap(4);
        str.hashCode();
        switch (str.hashCode()) {
            case 50:
                if (str.equals("2")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 48627:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 48628:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i = 2;
                break;
            case 1:
            case 2:
                i = 1;
                break;
            default:
                i = 10001;
                break;
        }
        hashMap.put(com.qq.e.comm.pi.IBidding.WIN_PRICE, java.lang.Integer.valueOf((int) java.lang.Math.round(d)));
        hashMap.put(com.qq.e.comm.pi.IBidding.LOSS_REASON, java.lang.Integer.valueOf(i));
        try {
            int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID, -1);
            if (intFromMap == 1) {
                i2 = 1;
            } else if (intFromMap != 2) {
                i2 = intFromMap != 3 ? intFromMap != 4 ? intFromMap : 2 : 3;
            }
            if (i2 != -1) {
                hashMap.put(com.qq.e.comm.pi.IBidding.ADN_ID, java.lang.Integer.valueOf(i2));
            }
        } catch (java.lang.Throwable unused) {
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.Object obj2 = this.a;
            sb.append(obj2 != null ? obj2.toString() : "");
            sb.append(": notifyBidLoss lossCode:");
            sb.append(str);
            sb.append(",lossReason:");
            sb.append(i);
            sb.append("\n");
            sb.append(hashMap.toString());
        }
        try {
            java.lang.Object obj3 = this.a;
            if (obj3 instanceof com.qq.e.ads.rewardvideo.RewardVideoAD) {
                ((com.qq.e.ads.rewardvideo.RewardVideoAD) obj3).sendLossNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            java.lang.Object obj4 = this.a;
            if (obj4 instanceof com.qq.e.ads.interstitial2.UnifiedInterstitialAD) {
                ((com.qq.e.ads.interstitial2.UnifiedInterstitialAD) obj4).sendLossNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            java.lang.Object obj5 = this.a;
            if (obj5 instanceof com.qq.e.ads.splash.SplashAD) {
                ((com.qq.e.ads.splash.SplashAD) obj5).sendLossNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            java.lang.Object obj6 = this.a;
            if (obj6 instanceof com.qq.e.ads.banner2.UnifiedBannerView) {
                ((com.qq.e.ads.banner2.UnifiedBannerView) obj6).sendLossNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            obj = this.a;
        } catch (java.lang.Throwable unused6) {
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativeExpressAd) {
            ((com.anythink.network.gdt.GDTATNativeExpressAd) obj).b.sendLossNotification(hashMap);
            return;
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativePatchAd) {
            ((com.anythink.network.gdt.GDTATNativePatchAd) obj).c.sendLossNotification(hashMap);
            return;
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativeAd) {
            ((com.anythink.network.gdt.GDTATNativeAd) obj).c.sendLossNotification(hashMap);
            return;
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d, double d2, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        java.util.HashMap hashMap = new java.util.HashMap(4);
        hashMap.put(com.qq.e.comm.pi.IBidding.HIGHEST_LOSS_PRICE, java.lang.Integer.valueOf((int) java.lang.Math.round(d2)));
        try {
            java.lang.Object obj2 = this.a;
            if (obj2 instanceof com.qq.e.ads.rewardvideo.RewardVideoAD) {
                com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD = (com.qq.e.ads.rewardvideo.RewardVideoAD) obj2;
                hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(rewardVideoAD.getECPM()));
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.lang.Object obj3 = this.a;
                    sb.append(obj3 != null ? obj3.toString() : "");
                    sb.append(": notifyBidWin: ");
                    sb.append(hashMap.toString());
                }
                rewardVideoAD.sendWinNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Object obj4 = this.a;
            if (obj4 instanceof com.qq.e.ads.interstitial2.UnifiedInterstitialAD) {
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = (com.qq.e.ads.interstitial2.UnifiedInterstitialAD) obj4;
                hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(unifiedInterstitialAD.getECPM()));
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    java.lang.Object obj5 = this.a;
                    sb2.append(obj5 != null ? obj5.toString() : "");
                    sb2.append(": notifyBidWin: ");
                    sb2.append(hashMap.toString());
                }
                unifiedInterstitialAD.sendWinNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            java.lang.Object obj6 = this.a;
            if (obj6 instanceof com.qq.e.ads.splash.SplashAD) {
                com.qq.e.ads.splash.SplashAD splashAD = (com.qq.e.ads.splash.SplashAD) obj6;
                hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(splashAD.getECPM()));
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    java.lang.Object obj7 = this.a;
                    sb3.append(obj7 != null ? obj7.toString() : "");
                    sb3.append(": notifyBidWin: ");
                    sb3.append(hashMap.toString());
                }
                splashAD.sendWinNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            java.lang.Object obj8 = this.a;
            if (obj8 instanceof com.qq.e.ads.banner2.UnifiedBannerView) {
                com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView = (com.qq.e.ads.banner2.UnifiedBannerView) obj8;
                hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(unifiedBannerView.getECPM()));
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    java.lang.Object obj9 = this.a;
                    sb4.append(obj9 != null ? obj9.toString() : "");
                    sb4.append(": notifyBidWin: ");
                    sb4.append(hashMap.toString());
                }
                unifiedBannerView.sendWinNotification(hashMap);
                return;
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            obj = this.a;
        } catch (java.lang.Throwable unused5) {
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativeExpressAd) {
            com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = (com.anythink.network.gdt.GDTATNativeExpressAd) obj;
            hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(gDTATNativeExpressAd.b.getECPM()));
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                java.lang.Object obj10 = this.a;
                sb5.append(obj10 != null ? obj10.toString() : "");
                sb5.append(": notifyBidWin: ");
                sb5.append(hashMap.toString());
            }
            gDTATNativeExpressAd.b.sendWinNotification(hashMap);
            return;
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativePatchAd) {
            com.anythink.network.gdt.GDTATNativePatchAd gDTATNativePatchAd = (com.anythink.network.gdt.GDTATNativePatchAd) obj;
            hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(gDTATNativePatchAd.c.getECPM()));
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                java.lang.Object obj11 = this.a;
                sb6.append(obj11 != null ? obj11.toString() : "");
                sb6.append(": notifyBidWin: ");
                sb6.append(hashMap.toString());
            }
            gDTATNativePatchAd.c.sendWinNotification(hashMap);
            return;
        }
        if (obj instanceof com.anythink.network.gdt.GDTATNativeAd) {
            com.anythink.network.gdt.GDTATNativeAd gDTATNativeAd = (com.anythink.network.gdt.GDTATNativeAd) obj;
            hashMap.put(com.qq.e.comm.pi.IBidding.EXPECT_COST_PRICE, java.lang.Integer.valueOf(gDTATNativeAd.c.getECPM()));
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                java.lang.Object obj12 = this.a;
                sb7.append(obj12 != null ? obj12.toString() : "");
                sb7.append(": notifyBidWin: ");
                sb7.append(hashMap.toString());
            }
            gDTATNativeAd.c.sendWinNotification(hashMap);
            return;
        }
        this.a = null;
    }
}
