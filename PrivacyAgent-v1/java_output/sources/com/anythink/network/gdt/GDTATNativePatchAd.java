package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATNativePatchAd extends com.anythink.network.gdt.GDTATNativeAd {
    public GDTATNativePatchAd(android.content.Context context, com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3) {
        super(context, nativeUnifiedADData, i, i2, i3);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
