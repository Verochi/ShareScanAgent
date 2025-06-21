package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    private static final java.lang.String b = com.anythink.network.baidu.BaiduATBannerAdapter.class.getSimpleName();
    java.lang.String a;

    /* renamed from: com.anythink.network.baidu.BaiduATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass1(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            if (com.anythink.network.baidu.BaiduATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATBannerAdapter.this.mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                if (com.anythink.network.baidu.BaiduATBannerAdapter.this.getMixedFormatAdType() == 0) {
                    com.anythink.network.baidu.BaiduATBannerAdapter.this.thirdPartyLoad(new com.anythink.network.baidu.BaiduATAdapter(), this.a, this.b, this.c);
                } else {
                    com.anythink.network.baidu.BaiduATBannerAdapter.this.notifyATLoadFail("", "not support baidu banner");
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                if (com.anythink.network.baidu.BaiduATBannerAdapter.this.mLoadListener != null) {
                    com.anythink.network.baidu.BaiduATBannerAdapter.this.mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                }
            }
        }
    }

    public void destory() {
    }

    public android.view.View getBannerView() {
        return null;
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.a)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("", "app_id or ad_place_id is empty.");
            }
        } else if (!(context instanceof android.app.Activity)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("", "Baidu Banner's context must be activity.");
            }
        } else if (getMixedFormatAdType() != 0) {
            notifyATLoadFail("", "not support baidu banner");
        } else {
            com.anythink.network.baidu.BaiduATInitManager.getInstance().initSDK(context, map, new com.anythink.network.baidu.BaiduATBannerAdapter.AnonymousClass1(context, map, map2));
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        return getMixedFormatAdType() == 0 ? thirdPartyStartBiddingRequest(new com.anythink.network.baidu.BaiduATAdapter(), context, map, map2, aTBiddingListener) : super.startBiddingRequest(context, map, map2, aTBiddingListener);
    }

    public boolean supportImpressionCallback() {
        return getMixedFormatAdType() == 0;
    }
}
