package com.anythink.nativead.unitgroup.api;

/* loaded from: classes12.dex */
public abstract class CustomNativeAdapter extends com.anythink.core.api.ATBaseAdAdapter {
    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final boolean isAdReady() {
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final boolean isMixFormatAd() {
        int i = this.mMixedFormatAdType;
        return (i == -1 || i == 0) ? false : true;
    }
}
