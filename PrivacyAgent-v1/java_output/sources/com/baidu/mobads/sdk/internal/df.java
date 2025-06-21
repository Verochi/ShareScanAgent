package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class df extends com.baidu.mobads.sdk.internal.dh {
    private com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener a;

    public df(android.content.Context context, java.lang.String str, boolean z) {
        super(context, str, z, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.dh
    public void a(com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener) {
        super.a(screenVideoAdListener);
        if (screenVideoAdListener instanceof com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener) {
            this.a = (com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.dh, com.baidu.mobads.sdk.internal.bi
    public void g(java.lang.String str) {
        com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(java.lang.Float.parseFloat(str));
        }
    }
}
