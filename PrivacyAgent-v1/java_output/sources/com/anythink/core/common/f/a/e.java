package com.anythink.core.common.f.a;

/* loaded from: classes12.dex */
public final class e extends com.anythink.core.api.BaseAd implements com.anythink.core.common.f.a.a, java.io.Serializable {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private com.anythink.core.api.BaseAd f;
    private java.util.Map<java.lang.String, java.lang.Object> g;

    public e(com.anythink.core.api.BaseAd baseAd, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a = 1;
        this.b = 5;
        this.c = 1;
        this.e = 5;
        this.f = baseAd;
        this.g = map;
        java.lang.Object obj = map.get("orientation");
        if (obj != null) {
            this.a = java.lang.Integer.parseInt(obj.toString());
        }
        java.lang.Object obj2 = map.get(com.anythink.expressad.d.a.b.dk);
        if (obj2 != null) {
            this.b = java.lang.Integer.parseInt(obj2.toString());
        }
        java.lang.Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.c = java.lang.Integer.parseInt(obj3.toString());
        }
        java.lang.Object obj4 = map.get("button_type");
        if (obj4 != null) {
            this.d = java.lang.Integer.parseInt(obj4.toString());
        }
        java.lang.Object obj5 = map.get("s_c_t");
        if (obj5 != null) {
            this.e = java.lang.Integer.parseInt(obj5.toString());
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj = map.get("orientation");
        if (obj != null) {
            this.a = java.lang.Integer.parseInt(obj.toString());
        }
        java.lang.Object obj2 = map.get(com.anythink.expressad.d.a.b.dk);
        if (obj2 != null) {
            this.b = java.lang.Integer.parseInt(obj2.toString());
        }
        java.lang.Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.c = java.lang.Integer.parseInt(obj3.toString());
        }
        java.lang.Object obj4 = map.get("button_type");
        if (obj4 != null) {
            this.d = java.lang.Integer.parseInt(obj4.toString());
        }
        java.lang.Object obj5 = map.get("s_c_t");
        if (obj5 != null) {
            this.e = java.lang.Integer.parseInt(obj5.toString());
        }
    }

    private boolean j() {
        return i() == 0;
    }

    @Override // com.anythink.core.common.f.a.a
    public final int a() {
        return this.a;
    }

    @Override // com.anythink.core.common.f.a.a
    public final long b() {
        return this.b;
    }

    @Override // com.anythink.core.common.f.a.a
    public final int c() {
        int i = this.c;
        return (i != 1 && i == 0) ? 1 : 0;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void clear(android.view.View view) {
        com.anythink.core.api.BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.clear(view);
        }
    }

    @Override // com.anythink.core.common.f.a.a
    public final int d() {
        int i = this.d;
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void destroy() {
        this.f.destroy();
    }

    @Override // com.anythink.core.common.f.a.a
    public final int e() {
        return this.e;
    }

    @Override // com.anythink.core.common.f.a.a
    public final int f() {
        java.lang.Object obj;
        if (this.f.getDetail() == null || this.f.getDetail().M() != 8 || (obj = this.g.get("video_muted")) == null) {
            return 0;
        }
        return android.text.TextUtils.equals(obj.toString(), "0") ? 1 : 0;
    }

    @Override // com.anythink.core.common.f.a.a
    public final int g() {
        java.util.Map<java.lang.String, java.lang.Object> map = this.g;
        if (map != null && map.containsKey(com.anythink.core.d.e.a.ar)) {
            java.lang.Object obj = this.g.get(com.anythink.core.d.e.a.ar);
            if (obj instanceof java.lang.Integer) {
                return ((java.lang.Integer) obj).intValue();
            }
        }
        return 1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.ATAdAppInfo getAdAppInfo() {
        return this.f.getAdAppInfo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdChoiceIconUrl() {
        return this.f.getAdChoiceIconUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdFrom() {
        return this.f.getAdFrom();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdIconView() {
        return this.f.getAdIconView();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.graphics.Bitmap getAdLogo() {
        return this.f.getAdLogo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdLogoView() {
        return this.f.getAdLogoView();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdMediaView(java.lang.Object... objArr) {
        return this.f.getAdMediaView(objArr);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdType() {
        return this.f.getAdType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.IATAdvertiserInfoOperate getAdvertiserInfoOperate() {
        com.anythink.core.api.BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getAdvertiserInfoOperate();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdvertiserName() {
        return this.f.getAdvertiserName();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getAppCommentNum() {
        return this.f.getAppCommentNum();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAppDownloadButton() {
        return this.f.getAppDownloadButton();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getAppPrice() {
        return this.f.getAppPrice();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getCallToActionText() {
        return this.f.getCallToActionText();
    }

    @Override // com.anythink.core.api.BaseAd
    public final android.view.ViewGroup getCustomAdContainer() {
        return this.f.getCustomAdContainer();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getDescriptionText() {
        return this.f.getDescriptionText();
    }

    @Override // com.anythink.core.api.BaseAd
    public final com.anythink.core.common.f.h getDetail() {
        return this.f.getDetail();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getDomain() {
        com.anythink.core.api.BaseAd baseAd = this.f;
        return baseAd != null ? baseAd.getDomain() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getIconImageUrl() {
        return this.f.getIconImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.List<java.lang.String> getImageUrlList() {
        return this.f.getImageUrlList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageHeight() {
        return this.f.getMainImageHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getMainImageUrl() {
        return this.f.getMainImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageWidth() {
        return this.f.getMainImageWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeAdInteractionType() {
        return this.f.getNativeAdInteractionType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.ATCustomVideo getNativeCustomVideo() {
        return this.f.getNativeCustomVideo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressHeight() {
        return this.f.getNativeExpressHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressWidth() {
        return this.f.getNativeExpressWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeType() {
        return this.f.getNativeType();
    }

    @Override // com.anythink.core.api.BaseAd, com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.f.getNetworkInfoMap();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getShakeView(int i, int i2, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.anythink.core.api.BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getShakeView(i, i2, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getSlideView(int i, int i2, int i3, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.anythink.core.api.BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getSlideView(i, i2, i3, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.Double getStarRating() {
        return this.f.getStarRating();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getTitle() {
        return this.f.getTitle();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoDuration() {
        return this.f.getVideoDuration();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoHeight() {
        return this.f.getVideoHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoProgress() {
        return this.f.getVideoProgress();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getVideoUrl() {
        return this.f.getVideoUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoWidth() {
        return this.f.getVideoWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getWarning() {
        com.anythink.core.api.BaseAd baseAd = this.f;
        return baseAd != null ? baseAd.getWarning() : "";
    }

    @Override // com.anythink.core.common.f.a.a
    public final int[] h() {
        int[] iArr = {1, 2, 3, 4, 5};
        java.util.Map<java.lang.String, java.lang.Object> map = this.g;
        if (map == null || !map.containsKey(com.anythink.core.d.e.a.as)) {
            return iArr;
        }
        java.lang.Object obj = this.g.get(com.anythink.core.d.e.a.as);
        return obj instanceof int[] ? (int[]) obj : iArr;
    }

    @Override // com.anythink.core.common.f.a.a
    public final int i() {
        java.lang.Object obj;
        java.util.Map<java.lang.String, java.lang.Object> map = this.g;
        if (map != null && (obj = map.get("close_button")) != null) {
            try {
                return java.lang.Integer.parseInt(obj.toString());
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        return 0;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams) {
        this.f.registerListener(view, list, layoutParams);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams, com.anythink.core.basead.b.b bVar) {
        this.f.registerListener(view, list, layoutParams, bVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNativeEventListener(com.anythink.core.common.b.m mVar) {
        this.f.setNativeEventListener(mVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNetworkInfoMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.f.setNetworkInfoMap(map);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(com.anythink.core.common.f.h hVar) {
        this.f.setTrackingInfo(hVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setVideoMute(boolean z) {
        this.f.setVideoMute(z);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPermissionClickViewList() {
        com.anythink.core.api.BaseAd baseAd = this.f;
        return baseAd != null && baseAd.supportSetPermissionClickViewList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPrivacyClickViewList() {
        com.anythink.core.api.BaseAd baseAd = this.f;
        return baseAd != null && baseAd.supportSetPrivacyClickViewList();
    }
}
