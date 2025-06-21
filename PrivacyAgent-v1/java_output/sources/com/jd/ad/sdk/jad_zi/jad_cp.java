package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_cp extends com.jd.ad.sdk.jad_hu.jad_an {
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener jad_er;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_cp(com.jd.ad.sdk.jad_zi.jad_er jad_erVar, java.lang.String str, com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener) {
        super(str);
        this.jad_er = iDynamicInteractionListener;
    }

    @Override // com.jd.ad.sdk.jad_hu.jad_an
    public void jad_an(android.view.View view) {
        com.jd.ad.sdk.logger.Logger.d("click sdkSkipArea");
        com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener = this.jad_er;
        if (iDynamicInteractionListener != null) {
            iDynamicInteractionListener.onAdSkip(view);
        }
    }
}
