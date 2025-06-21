package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    java.lang.String a;
    java.lang.String b;
    int c;
    java.lang.String d;
    int e;
    int f;
    int g;
    int h;
    private int j = -1;
    private int k = -2;
    boolean i = false;

    /* renamed from: com.anythink.network.gdt.GDTATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.network.gdt.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyError(java.lang.String str, java.lang.String str2) {
            com.anythink.network.gdt.GDTATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyLoaded(com.anythink.nativead.unitgroup.api.CustomNativeAd... customNativeAdArr) {
            com.anythink.network.gdt.GDTATAdapter gDTATAdapter = com.anythink.network.gdt.GDTATAdapter.this;
            if (gDTATAdapter.i) {
                com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = customNativeAdArr[0];
                if (customNativeAd instanceof com.anythink.network.gdt.GDTATNativeExpressAd) {
                    com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = (com.anythink.network.gdt.GDTATNativeExpressAd) customNativeAd;
                    if (gDTATAdapter.mBiddingListener != null) {
                        double ecpm = gDTATNativeExpressAd.b.getECPM();
                        com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(gDTATNativeExpressAd);
                        com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATAdapter.this.mBiddingListener;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(java.lang.System.currentTimeMillis());
                        aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), gDTATNativeExpressAd);
                        return;
                    }
                    return;
                }
            }
            if (((com.anythink.core.api.ATBaseAdAdapter) gDTATAdapter).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.gdt.GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.qq.e.ads.nativ.NativeADUnifiedListener {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public final void onADLoaded(java.util.List<com.qq.e.ads.nativ.NativeUnifiedADData> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (list == null || list.size() <= 0) {
                com.anythink.network.gdt.GDTATAdapter.this.notifyATLoadFail("", "Ad list is empty");
                return;
            }
            com.anythink.network.gdt.GDTATNativePatchAd gDTATNativePatchAd = null;
            com.anythink.network.gdt.GDTATNativeAd gDTATNativeAd = null;
            for (com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData : list) {
                if (com.anythink.network.gdt.GDTATAdapter.this.e == 4) {
                    android.content.Context context = this.a;
                    com.anythink.network.gdt.GDTATAdapter gDTATAdapter = com.anythink.network.gdt.GDTATAdapter.this;
                    gDTATNativePatchAd = new com.anythink.network.gdt.GDTATNativePatchAd(context, nativeUnifiedADData, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h);
                    arrayList.add(gDTATNativePatchAd);
                } else {
                    android.content.Context context2 = this.a;
                    com.anythink.network.gdt.GDTATAdapter gDTATAdapter2 = com.anythink.network.gdt.GDTATAdapter.this;
                    gDTATNativeAd = new com.anythink.network.gdt.GDTATNativeAd(context2, nativeUnifiedADData, gDTATAdapter2.f, gDTATAdapter2.g, gDTATAdapter2.h);
                    arrayList.add(gDTATNativeAd);
                }
            }
            com.anythink.nativead.unitgroup.api.CustomNativeAd[] customNativeAdArr = (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]);
            com.anythink.network.gdt.GDTATAdapter gDTATAdapter3 = com.anythink.network.gdt.GDTATAdapter.this;
            if (!gDTATAdapter3.i) {
                if (((com.anythink.core.api.ATBaseAdAdapter) gDTATAdapter3).mLoadListener != null) {
                    ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.gdt.GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            if (gDTATAdapter3.mBiddingListener != null) {
                if (gDTATAdapter3.e == 4 && gDTATNativePatchAd != null) {
                    double ecpm = gDTATNativePatchAd.c.getECPM();
                    com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(gDTATNativePatchAd);
                    com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATAdapter.this.mBiddingListener;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(java.lang.System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), gDTATNativePatchAd);
                    return;
                }
                if (gDTATNativeAd != null) {
                    double ecpm2 = gDTATNativeAd.c.getECPM();
                    com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice2 = new com.anythink.network.gdt.GDTATBiddingNotice(gDTATNativeAd);
                    com.anythink.core.api.ATBiddingListener aTBiddingListener2 = com.anythink.network.gdt.GDTATAdapter.this.mBiddingListener;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(java.lang.System.currentTimeMillis());
                    aTBiddingListener2.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm2, sb2.toString(), gDTATBiddingNotice2, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), gDTATNativeAd);
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public final void onNoAD(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATAdapter gDTATAdapter = com.anythink.network.gdt.GDTATAdapter.this;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass3(android.content.Context context, java.util.Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.gdt.GDTATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            com.anythink.network.gdt.GDTATAdapter.a(com.anythink.network.gdt.GDTATAdapter.this, this.a, this.b);
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            int i = this.e;
            if (i != 2 && i != 4) {
                com.anythink.network.gdt.GDTATAdapter.AnonymousClass1 anonymousClass1 = new com.anythink.network.gdt.GDTATAdapter.AnonymousClass1();
                if (this.e == 3) {
                    com.anythink.network.gdt.GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new com.anythink.network.gdt.GDTATNativeExpressPatchAd(context, this.b, this.j, this.k, this.f, this.g, this.h, this.d);
                    com.anythink.network.gdt.GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, com.anythink.network.gdt.GDTATInitManager.a(map));
                    return;
                } else {
                    com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = new com.anythink.network.gdt.GDTATNativeExpressAd(context, this.b, this.j, this.k, this.f, this.g, this.h, this.d);
                    com.anythink.network.gdt.GDTATInitManager.getInstance();
                    gDTATNativeExpressAd.a(anonymousClass1, com.anythink.network.gdt.GDTATInitManager.a(map));
                    return;
                }
            }
            android.content.Context applicationContext = context.getApplicationContext();
            com.anythink.network.gdt.GDTATAdapter.AnonymousClass2 anonymousClass2 = new com.anythink.network.gdt.GDTATAdapter.AnonymousClass2(applicationContext);
            com.qq.e.ads.nativ.NativeUnifiedAD nativeUnifiedAD = android.text.TextUtils.isEmpty(this.d) ? new com.qq.e.ads.nativ.NativeUnifiedAD(applicationContext, this.b, anonymousClass2) : new com.qq.e.ads.nativ.NativeUnifiedAD(applicationContext, this.b, anonymousClass2, this.d);
            int i2 = this.h;
            if (i2 != -1) {
                nativeUnifiedAD.setMaxVideoDuration(i2);
            }
            if (!android.text.TextUtils.isEmpty(this.d)) {
                nativeUnifiedAD.loadData(this.c);
                return;
            }
            int i3 = this.c;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(i3, com.anythink.network.gdt.GDTATInitManager.a(map));
        } catch (java.lang.Throwable th) {
            notifyATLoadFail("", th.getMessage());
        }
    }

    public static /* synthetic */ void a(com.anythink.network.gdt.GDTATAdapter gDTATAdapter, android.content.Context context, java.util.Map map) {
        try {
            int i = gDTATAdapter.e;
            if (i != 2 && i != 4) {
                com.anythink.network.gdt.GDTATAdapter.AnonymousClass1 anonymousClass1 = gDTATAdapter.new AnonymousClass1();
                if (gDTATAdapter.e == 3) {
                    com.anythink.network.gdt.GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new com.anythink.network.gdt.GDTATNativeExpressPatchAd(context, gDTATAdapter.b, gDTATAdapter.j, gDTATAdapter.k, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                    com.anythink.network.gdt.GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
                    return;
                } else {
                    com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = new com.anythink.network.gdt.GDTATNativeExpressAd(context, gDTATAdapter.b, gDTATAdapter.j, gDTATAdapter.k, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                    com.anythink.network.gdt.GDTATInitManager.getInstance();
                    gDTATNativeExpressAd.a(anonymousClass1, com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
                    return;
                }
            }
            android.content.Context applicationContext = context.getApplicationContext();
            com.anythink.network.gdt.GDTATAdapter.AnonymousClass2 anonymousClass2 = gDTATAdapter.new AnonymousClass2(applicationContext);
            com.qq.e.ads.nativ.NativeUnifiedAD nativeUnifiedAD = android.text.TextUtils.isEmpty(gDTATAdapter.d) ? new com.qq.e.ads.nativ.NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2) : new com.qq.e.ads.nativ.NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2, gDTATAdapter.d);
            int i2 = gDTATAdapter.h;
            if (i2 != -1) {
                nativeUnifiedAD.setMaxVideoDuration(i2);
            }
            if (!android.text.TextUtils.isEmpty(gDTATAdapter.d)) {
                nativeUnifiedAD.loadData(gDTATAdapter.c);
                return;
            }
            int i3 = gDTATAdapter.c;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(i3, com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
        } catch (java.lang.Throwable th) {
            gDTATAdapter.notifyATLoadFail("", th.getMessage());
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.c = this.i ? 1 : this.mRequestNum;
        try {
            this.j = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(com.anythink.network.gdt.GDTATConst.AD_HEIGHT)) {
                this.k = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.network.gdt.GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
                this.k = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
    }

    private void b(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.network.gdt.GDTATAdapter.AnonymousClass2 anonymousClass2 = new com.anythink.network.gdt.GDTATAdapter.AnonymousClass2(context);
        com.qq.e.ads.nativ.NativeUnifiedAD nativeUnifiedAD = android.text.TextUtils.isEmpty(this.d) ? new com.qq.e.ads.nativ.NativeUnifiedAD(context, this.b, anonymousClass2) : new com.qq.e.ads.nativ.NativeUnifiedAD(context, this.b, anonymousClass2, this.d);
        int i = this.h;
        if (i != -1) {
            nativeUnifiedAD.setMaxVideoDuration(i);
        }
        if (!android.text.TextUtils.isEmpty(this.d)) {
            nativeUnifiedAD.loadData(this.c);
            return;
        }
        int i2 = this.c;
        com.anythink.network.gdt.GDTATInitManager.getInstance();
        nativeUnifiedAD.loadData(i2, com.anythink.network.gdt.GDTATInitManager.a(map));
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        com.anythink.network.gdt.GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.c = this.i ? 1 : this.mRequestNum;
        try {
            this.j = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(com.anythink.network.gdt.GDTATConst.AD_HEIGHT)) {
                this.k = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.network.gdt.GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
                this.k = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
        if (android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            com.anythink.network.gdt.GDTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.gdt.GDTATAdapter.AnonymousClass3(context, map));
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
