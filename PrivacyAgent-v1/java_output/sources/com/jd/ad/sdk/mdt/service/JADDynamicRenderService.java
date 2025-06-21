package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADDynamicRenderService {
    com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView createDynamicView(android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback);

    void registerAdViewClick(android.content.Context context, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener);
}
