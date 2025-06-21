package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class BaseAd implements com.anythink.core.api.IATThirdPartyMaterial {
    public abstract void clear(android.view.View view);

    public abstract void destroy();

    public abstract android.view.ViewGroup getCustomAdContainer();

    public abstract com.anythink.core.common.f.h getDetail();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap();

    public abstract void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams);

    public abstract void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams, com.anythink.core.basead.b.b bVar);

    public abstract void setNativeEventListener(com.anythink.core.common.b.m mVar);

    public abstract void setNetworkInfoMap(java.util.Map<java.lang.String, java.lang.Object> map);

    public abstract void setTrackingInfo(com.anythink.core.common.f.h hVar);

    public abstract void setVideoMute(boolean z);
}
