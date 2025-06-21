package com.anythink.core.api;

/* loaded from: classes12.dex */
public interface IATThirdPartyMaterial {
    com.anythink.core.api.ATAdAppInfo getAdAppInfo();

    java.lang.String getAdChoiceIconUrl();

    java.lang.String getAdFrom();

    android.view.View getAdIconView();

    android.graphics.Bitmap getAdLogo();

    android.view.View getAdLogoView();

    android.view.View getAdMediaView(java.lang.Object... objArr);

    java.lang.String getAdType();

    com.anythink.core.api.IATAdvertiserInfoOperate getAdvertiserInfoOperate();

    java.lang.String getAdvertiserName();

    int getAppCommentNum();

    android.view.View getAppDownloadButton();

    double getAppPrice();

    java.lang.String getCallToActionText();

    java.lang.String getDescriptionText();

    java.lang.String getDomain();

    java.lang.String getIconImageUrl();

    java.util.List<java.lang.String> getImageUrlList();

    int getMainImageHeight();

    java.lang.String getMainImageUrl();

    int getMainImageWidth();

    int getNativeAdInteractionType();

    com.anythink.core.api.ATCustomVideo getNativeCustomVideo();

    int getNativeExpressHeight();

    int getNativeExpressWidth();

    int getNativeType();

    java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap();

    android.view.View getShakeView(int i, int i2, com.anythink.core.api.ATShakeViewListener aTShakeViewListener);

    android.view.View getSlideView(int i, int i2, int i3, com.anythink.core.api.ATShakeViewListener aTShakeViewListener);

    java.lang.Double getStarRating();

    java.lang.String getTitle();

    double getVideoDuration();

    int getVideoHeight();

    double getVideoProgress();

    java.lang.String getVideoUrl();

    int getVideoWidth();

    java.lang.String getWarning();

    boolean supportSetPermissionClickViewList();

    boolean supportSetPrivacyClickViewList();
}
