package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATNativePatchAd extends com.anythink.network.toutiao.TTATNativeAd {
    public TTATNativePatchAd(android.content.Context context, java.lang.String str, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd, boolean z, android.graphics.Bitmap bitmap, int i) {
        super(context, str, tTNativeAd, z, bitmap, i);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }

    @Override // com.anythink.network.toutiao.TTATNativeAd
    public void setAdData(boolean z, android.graphics.Bitmap bitmap, int i) {
        super.setAdData(z, bitmap, i);
    }
}
