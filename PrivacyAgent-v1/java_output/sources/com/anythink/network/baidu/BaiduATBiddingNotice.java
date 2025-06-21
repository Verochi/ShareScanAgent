package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATBiddingNotice implements com.anythink.core.api.ATBiddingNotice {
    private static final java.lang.String b = "adn";
    private static final java.lang.String c = "ad_t";
    private static final java.lang.String d = "ad_time";
    private static final java.lang.String e = "bid_t";
    private static final java.lang.String f = "is_s";
    private static final java.lang.String g = "is_c";
    java.lang.Object a;

    /* renamed from: com.anythink.network.baidu.BaiduATBiddingNotice$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.BiddingListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.BiddingListener
        public final void onBiddingResult(boolean z, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onBiddingResult-win: ");
                sb.append(z);
                sb.append(" msg信息：");
                sb.append(str);
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATBiddingNotice$2, reason: invalid class name */
    public class AnonymousClass2 implements com.baidu.mobads.sdk.api.BiddingListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.BiddingListener
        public final void onBiddingResult(boolean z, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onBiddingResult-loss: ");
                sb.append(z);
                sb.append(" msg信息：");
                sb.append(str);
            }
        }
    }

    public BaiduATBiddingNotice(java.lang.Object obj) {
        this.a = obj;
    }

    private static java.util.LinkedHashMap<java.lang.String, java.lang.Object> a() {
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = new java.util.LinkedHashMap<>(4);
        linkedHashMap.put("adn", 10);
        linkedHashMap.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
        linkedHashMap.put(e, 4);
        linkedHashMap.put(c, 7);
        a(linkedHashMap, true);
        return linkedHashMap;
    }

    private static java.util.LinkedHashMap<java.lang.String, java.lang.Object> a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = new java.util.LinkedHashMap<>(8);
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
        linkedHashMap.put("adn", java.lang.Integer.valueOf((intFromMap == 1 || intFromMap == 2) ? 9 : 10));
        linkedHashMap.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
        linkedHashMap.put(e, 4);
        linkedHashMap.put(f, 2);
        linkedHashMap.put(g, 2);
        linkedHashMap.put(c, 7);
        a(linkedHashMap, false);
        return linkedHashMap;
    }

    private static void a(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        if (map.size() != 0 && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.util.Iterator<java.lang.String> it = map.keySet().iterator();
            while (it.hasNext()) {
                map.get(it.next());
            }
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public com.anythink.core.api.ATAdConst.CURRENCY getNoticePriceCurrency() {
        return com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d2) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x0143, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x0010, B:14:0x004b, B:16:0x0056, B:18:0x005f, B:19:0x0066, B:21:0x0081, B:25:0x0097, B:70:0x013f, B:83:0x0014, B:86:0x001e, B:89:0x0028, B:92:0x0032), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6 A[Catch: all -> 0x00fd, TRY_LEAVE, TryCatch #5 {all -> 0x00fd, blocks: (B:27:0x00f0, B:29:0x00f6), top: B:26:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #4 {all -> 0x010a, blocks: (B:35:0x00fd, B:37:0x0103), top: B:34:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110 A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #3 {all -> 0x0117, blocks: (B:42:0x010a, B:44:0x0110), top: B:41:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011d A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #2 {all -> 0x0124, blocks: (B:49:0x0117, B:51:0x011d), top: B:48:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a A[Catch: all -> 0x0131, TRY_LEAVE, TryCatch #0 {all -> 0x0131, blocks: (B:56:0x0124, B:58:0x012a), top: B:55:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0137 A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #6 {all -> 0x013e, blocks: (B:63:0x0131, B:65:0x0137), top: B:62:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0049  */
    @Override // com.anythink.core.api.ATBiddingNotice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void notifyBidLoss(java.lang.String str, double d2, java.util.Map<java.lang.String, java.lang.Object> map) {
        char c2;
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        java.lang.Object obj5;
        java.lang.Object obj6;
        int hashCode = str.hashCode();
        if (hashCode == 50) {
            if (str.equals("2")) {
                c2 = 0;
                if (c2 != 0) {
                }
                int round = (int) java.lang.Math.round(d2);
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                }
                java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = new java.util.LinkedHashMap<>(8);
                int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
                linkedHashMap.put("adn", java.lang.Integer.valueOf((intFromMap != 1 || intFromMap == 2) ? 9 : 10));
                linkedHashMap.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
                linkedHashMap.put(e, 4);
                linkedHashMap.put(f, 2);
                linkedHashMap.put(g, 2);
                linkedHashMap.put(c, 7);
                a(linkedHashMap, false);
                linkedHashMap.put("ecpm", java.lang.Integer.valueOf(round));
                linkedHashMap.put("reason", java.lang.Integer.valueOf(r0));
                com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2 anonymousClass2 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2();
                obj6 = this.a;
                if (obj6 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
                }
                obj5 = this.a;
                if (obj5 instanceof com.baidu.mobads.sdk.api.SplashAd) {
                }
                obj4 = this.a;
                if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
                }
                obj3 = this.a;
                if (obj3 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
                }
                obj2 = this.a;
                if (obj2 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
                }
                obj = this.a;
                if (obj instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
                }
                this.a = null;
                return;
            }
            c2 = 65535;
            if (c2 != 0) {
            }
            int round2 = (int) java.lang.Math.round(d2);
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            }
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap2 = new java.util.LinkedHashMap<>(8);
            int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
            linkedHashMap2.put("adn", java.lang.Integer.valueOf((intFromMap2 != 1 || intFromMap2 == 2) ? 9 : 10));
            linkedHashMap2.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
            linkedHashMap2.put(e, 4);
            linkedHashMap2.put(f, 2);
            linkedHashMap2.put(g, 2);
            linkedHashMap2.put(c, 7);
            a(linkedHashMap2, false);
            linkedHashMap2.put("ecpm", java.lang.Integer.valueOf(round2));
            linkedHashMap2.put("reason", java.lang.Integer.valueOf(r0));
            com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2 anonymousClass22 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2();
            obj6 = this.a;
            if (obj6 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
            }
            obj5 = this.a;
            if (obj5 instanceof com.baidu.mobads.sdk.api.SplashAd) {
            }
            obj4 = this.a;
            if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
            }
            obj3 = this.a;
            if (obj3 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
            }
            obj2 = this.a;
            if (obj2 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
            }
            obj = this.a;
            if (obj instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
            }
            this.a = null;
            return;
        }
        if (hashCode == 53) {
            if (str.equals("5")) {
                c2 = 3;
                if (c2 != 0) {
                }
                int round22 = (int) java.lang.Math.round(d2);
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                }
                java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap22 = new java.util.LinkedHashMap<>(8);
                int intFromMap22 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
                linkedHashMap22.put("adn", java.lang.Integer.valueOf((intFromMap22 != 1 || intFromMap22 == 2) ? 9 : 10));
                linkedHashMap22.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
                linkedHashMap22.put(e, 4);
                linkedHashMap22.put(f, 2);
                linkedHashMap22.put(g, 2);
                linkedHashMap22.put(c, 7);
                a(linkedHashMap22, false);
                linkedHashMap22.put("ecpm", java.lang.Integer.valueOf(round22));
                linkedHashMap22.put("reason", java.lang.Integer.valueOf(r0));
                com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2 anonymousClass222 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2();
                obj6 = this.a;
                if (obj6 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
                }
                obj5 = this.a;
                if (obj5 instanceof com.baidu.mobads.sdk.api.SplashAd) {
                }
                obj4 = this.a;
                if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
                }
                obj3 = this.a;
                if (obj3 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
                }
                obj2 = this.a;
                if (obj2 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
                }
                obj = this.a;
                if (obj instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
                }
                this.a = null;
                return;
            }
            c2 = 65535;
            if (c2 != 0) {
            }
            int round222 = (int) java.lang.Math.round(d2);
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            }
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap222 = new java.util.LinkedHashMap<>(8);
            int intFromMap222 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
            linkedHashMap222.put("adn", java.lang.Integer.valueOf((intFromMap222 != 1 || intFromMap222 == 2) ? 9 : 10));
            linkedHashMap222.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
            linkedHashMap222.put(e, 4);
            linkedHashMap222.put(f, 2);
            linkedHashMap222.put(g, 2);
            linkedHashMap222.put(c, 7);
            a(linkedHashMap222, false);
            linkedHashMap222.put("ecpm", java.lang.Integer.valueOf(round222));
            linkedHashMap222.put("reason", java.lang.Integer.valueOf(r0));
            com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2 anonymousClass2222 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2();
            obj6 = this.a;
            if (obj6 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
            }
            obj5 = this.a;
            if (obj5 instanceof com.baidu.mobads.sdk.api.SplashAd) {
            }
            obj4 = this.a;
            if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
            }
            obj3 = this.a;
            if (obj3 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
            }
            obj2 = this.a;
            if (obj2 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
            }
            obj = this.a;
            if (obj instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
            }
            this.a = null;
            return;
        }
        switch (hashCode) {
            case 48627:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 48628:
                if (str.equals(com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        int i = c2 != 0 ? (c2 == 1 || c2 == 2) ? 203 : 900 : 100;
        int round2222 = (int) java.lang.Math.round(d2);
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.Object obj7 = this.a;
            sb.append(obj7 != null ? obj7.toString() : "");
            sb.append(": notifyBidLoss winPrice: ");
            sb.append(round2222);
            sb.append(", lossCode:");
            sb.append(str);
            sb.append(", lossReason:");
            sb.append(i);
        }
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap2222 = new java.util.LinkedHashMap<>(8);
        int intFromMap2222 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.api.ATBiddingNotice.ADN_ID);
        linkedHashMap2222.put("adn", java.lang.Integer.valueOf((intFromMap2222 != 1 || intFromMap2222 == 2) ? 9 : 10));
        linkedHashMap2222.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
        linkedHashMap2222.put(e, 4);
        linkedHashMap2222.put(f, 2);
        linkedHashMap2222.put(g, 2);
        linkedHashMap2222.put(c, 7);
        a(linkedHashMap2222, false);
        linkedHashMap2222.put("ecpm", java.lang.Integer.valueOf(round2222));
        linkedHashMap2222.put("reason", java.lang.Integer.valueOf(i));
        com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2 anonymousClass22222 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass2();
        try {
            obj6 = this.a;
            if (obj6 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
                ((com.baidu.mobads.sdk.api.RewardVideoAd) obj6).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            obj5 = this.a;
            if (obj5 instanceof com.baidu.mobads.sdk.api.SplashAd) {
                ((com.baidu.mobads.sdk.api.SplashAd) obj5).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            obj4 = this.a;
            if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
                ((com.baidu.mobads.sdk.api.NativeResponse) obj4).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            obj3 = this.a;
            if (obj3 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
                ((com.baidu.mobads.sdk.api.ExpressResponse) obj3).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            obj2 = this.a;
            if (obj2 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
                ((com.baidu.mobads.sdk.api.ExpressInterstitialAd) obj2).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            obj = this.a;
            if (obj instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
                ((com.baidu.mobads.sdk.api.FullScreenVideoAd) obj).biddingFail(linkedHashMap2222, anonymousClass22222);
                return;
            }
        } catch (java.lang.Throwable unused6) {
        }
        this.a = null;
        return;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidWin(double d2, double d3, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = new java.util.LinkedHashMap<>(4);
        linkedHashMap.put("adn", 10);
        linkedHashMap.put(d, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
        linkedHashMap.put(e, 4);
        linkedHashMap.put(c, 7);
        a(linkedHashMap, true);
        java.lang.String valueOf = java.lang.String.valueOf((int) java.lang.Math.round(d3));
        linkedHashMap.put("ecpm", java.lang.Integer.valueOf(java.lang.Integer.parseInt(valueOf)));
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.Object obj = this.a;
            sb.append(obj != null ? obj.toString() : "");
            sb.append(": notifyBidWin : second price:");
            sb.append(valueOf);
        }
        com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass1 anonymousClass1 = new com.anythink.network.baidu.BaiduATBiddingNotice.AnonymousClass1();
        try {
            java.lang.Object obj2 = this.a;
            if (obj2 instanceof com.baidu.mobads.sdk.api.RewardVideoAd) {
                ((com.baidu.mobads.sdk.api.RewardVideoAd) obj2).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Object obj3 = this.a;
            if (obj3 instanceof com.baidu.mobads.sdk.api.SplashAd) {
                ((com.baidu.mobads.sdk.api.SplashAd) obj3).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            java.lang.Object obj4 = this.a;
            if (obj4 instanceof com.baidu.mobads.sdk.api.NativeResponse) {
                ((com.baidu.mobads.sdk.api.NativeResponse) obj4).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            java.lang.Object obj5 = this.a;
            if (obj5 instanceof com.baidu.mobads.sdk.api.ExpressResponse) {
                ((com.baidu.mobads.sdk.api.ExpressResponse) obj5).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            java.lang.Object obj6 = this.a;
            if (obj6 instanceof com.baidu.mobads.sdk.api.ExpressInterstitialAd) {
                ((com.baidu.mobads.sdk.api.ExpressInterstitialAd) obj6).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            java.lang.Object obj7 = this.a;
            if (obj7 instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd) {
                ((com.baidu.mobads.sdk.api.FullScreenVideoAd) obj7).biddingSuccess(linkedHashMap, anonymousClass1);
                return;
            }
        } catch (java.lang.Throwable unused6) {
        }
        this.a = null;
    }
}
