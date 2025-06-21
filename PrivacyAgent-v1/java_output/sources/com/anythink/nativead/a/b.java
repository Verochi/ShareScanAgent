package com.anythink.nativead.a;

/* loaded from: classes12.dex */
public final class b implements com.anythink.nativead.api.ATNativeMaterial {
    com.anythink.nativead.unitgroup.api.CustomNativeAd a;

    public b(com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd) {
        this.a = customNativeAd;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.ATAdAppInfo getAdAppInfo() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAdAppInfo();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdChoiceIconUrl() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getAdChoiceIconUrl() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdFrom() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getAdFrom() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdIconView() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAdIconView();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.graphics.Bitmap getAdLogo() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAdLogo();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdLogoView() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAdLogoView();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdMediaView(java.lang.Object... objArr) {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd;
        if (this.a.isNativeExpress() || (customNativeAd = this.a) == null) {
            return null;
        }
        return customNativeAd.getAdMediaView(objArr);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdType() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getAdType() : "0";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.IATAdvertiserInfoOperate getAdvertiserInfoOperate() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAdvertiserInfoOperate();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdvertiserName() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getAdvertiserName() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getAppCommentNum() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAppCommentNum();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAppDownloadButton() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAppDownloadButton();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getAppPrice() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getAppPrice();
        }
        return 0.0d;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getCallToActionText() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getCallToActionText() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getDescriptionText() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getDescriptionText() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getDomain() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getDomain() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getIconImageUrl() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getIconImageUrl() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.List<java.lang.String> getImageUrlList() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getImageUrlList();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageHeight() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getMainImageHeight();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getMainImageUrl() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getMainImageUrl() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageWidth() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getMainImageWidth();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeAdInteractionType() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNativeAdInteractionType();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final com.anythink.core.api.ATCustomVideo getNativeCustomVideo() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNativeCustomVideo();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressHeight() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNativeExpressHeight();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressWidth() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNativeExpressWidth();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeType() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNativeType();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getNetworkInfoMap();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getShakeView(int i, int i2, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getShakeView(i, i2, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getSlideView(int i, int i2, int i3, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getSlideView(i, i2, i3, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.Double getStarRating() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        double d = 0.0d;
        if (customNativeAd != null && customNativeAd.getStarRating() != null) {
            d = this.a.getStarRating().doubleValue();
        }
        return java.lang.Double.valueOf(d);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getTitle() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getTitle() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoDuration() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getVideoDuration();
        }
        return 0.0d;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoHeight() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getVideoHeight();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoProgress() {
        return this.a.getVideoProgress();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getVideoUrl() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getVideoUrl() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoWidth() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        if (customNativeAd != null) {
            return customNativeAd.getVideoWidth();
        }
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getWarning() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null ? customNativeAd.getWarning() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPermissionClickViewList() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null && customNativeAd.supportSetPermissionClickViewList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPrivacyClickViewList() {
        com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = this.a;
        return customNativeAd != null && customNativeAd.supportSetPrivacyClickViewList();
    }
}
