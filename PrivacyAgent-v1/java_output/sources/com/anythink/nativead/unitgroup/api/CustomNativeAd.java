package com.anythink.nativead.unitgroup.api;

/* loaded from: classes12.dex */
public class CustomNativeAd extends com.anythink.nativead.unitgroup.a {
    public static java.lang.String IS_AUTO_PLAY_KEY = "is_auto_play";
    static final double MAX_STAR_RATING = 5.0d;
    static final double MIN_STAR_RATING = 0.0d;
    private com.anythink.core.api.ATAdAppInfo adAppInfo;
    private android.view.View adLogoView;
    private java.lang.String mAdChoiceIconUrl;
    private java.lang.String mAdFrom;
    private java.lang.String mAdvertiserName;
    private int mAppCommentNum;
    private android.view.View mAppDownloadButton;
    private double mAppPrice;
    private java.lang.String mCallToAction;
    private java.lang.String mClickDestinationUrl;
    private android.view.View.OnClickListener mCloseViewListener;
    private java.lang.String mDomain;
    private java.lang.String mIconImageUrl;
    private java.util.List<java.lang.String> mImageUrlList;
    private int mMainImageHeight;
    private java.lang.String mMainImageUrl;
    private int mMainImageWidth;
    private int mNativeExpressHeight;
    private int mNativeExpressWidth;
    private java.util.Map<java.lang.String, java.lang.Object> mNetworkInfoMap;
    private java.lang.String mText;
    private java.lang.String mTitle;
    private int mVideoHeight;
    private java.lang.String mVideoUrl;
    private int mVideoWidth;
    private java.lang.String mWarning;
    private java.lang.String showId;
    private double videoDuration;
    private java.lang.Double mStarRating = java.lang.Double.valueOf(0.0d);
    private int nInteractionType = 0;

    public class NativeAdConst {
        public static final java.lang.String IMAGE_TYPE = "2";
        public static final java.lang.String UNKNOWN_TYPE = "0";
        public static final java.lang.String VIDEO_TYPE = "1";

        public NativeAdConst() {
        }
    }

    public class NativeType {
        public static final int FEED = 1;
        public static final int PATCH = 2;

        public NativeType() {
        }
    }

    @Override // com.anythink.nativead.unitgroup.a
    public final void bindDislikeListener(android.view.View.OnClickListener onClickListener) {
        android.view.View closeView;
        this.mCloseViewListener = onClickListener;
        com.anythink.nativead.api.ATNativePrepareInfo nativePrepareInfo = getNativePrepareInfo();
        if (nativePrepareInfo == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.mCloseViewListener);
    }

    public final boolean checkHasCloseViewListener() {
        return this.mCloseViewListener != null;
    }

    @Override // com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
    }

    @Override // com.anythink.core.api.BaseAd
    public void destroy() {
        this.mCloseViewListener = null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public com.anythink.core.api.ATAdAppInfo getAdAppInfo() {
        return this.adAppInfo;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdChoiceIconUrl() {
        return this.mAdChoiceIconUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getAdFrom() {
        return this.mAdFrom;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdIconView() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public android.graphics.Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final android.view.View getAdLogoView() {
        return this.adLogoView;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getAdvertiserName() {
        return this.mAdvertiserName;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getAppCommentNum() {
        return this.mAppCommentNum;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAppDownloadButton() {
        return this.mAppDownloadButton;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getAppPrice() {
        return this.mAppPrice;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getCallToActionText() {
        return this.mCallToAction;
    }

    @Override // com.anythink.core.api.BaseAd
    public android.view.ViewGroup getCustomAdContainer() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getDescriptionText() {
        return this.mText;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getDomain() {
        return this.mDomain;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.List<java.lang.String> getImageUrlList() {
        return this.mImageUrlList;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        int i = this.mMainImageHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        int i = this.mMainImageWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeAdInteractionType() {
        return this.nInteractionType;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public com.anythink.core.api.ATCustomVideo getNativeCustomVideo() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressHeight() {
        int i = this.mNativeExpressHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressWidth() {
        int i = this.mNativeExpressWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 1;
    }

    @Override // com.anythink.core.api.BaseAd, com.anythink.core.api.IATThirdPartyMaterial
    public final java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.mNetworkInfoMap;
    }

    public final java.lang.String getShowId() {
        return this.showId;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.Double getStarRating() {
        return this.mStarRating;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getTitle() {
        return this.mTitle;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getVideoHeight() {
        int i = this.mVideoHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return 0.0d;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getVideoUrl() {
        return this.mVideoUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getVideoWidth() {
        int i = this.mVideoWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public java.lang.String getWarning() {
        return this.mWarning;
    }

    public void impressionTrack(android.view.View view) {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onPause() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onResume() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
    }

    public void registerDownloadConfirmListener() {
    }

    @Override // com.anythink.core.api.BaseAd
    public void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams) {
        registerListener(view, list, layoutParams, null);
    }

    @Override // com.anythink.core.api.BaseAd
    public void registerListener(android.view.View view, java.util.List<android.view.View> list, android.widget.FrameLayout.LayoutParams layoutParams, com.anythink.core.basead.b.b bVar) {
        com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo = new com.anythink.nativead.api.ATNativePrepareInfo();
        if (bVar != null) {
            aTNativePrepareInfo.setTitleView(bVar.a());
            aTNativePrepareInfo.setDescView(bVar.d());
            aTNativePrepareInfo.setAdFromView(bVar.f());
            aTNativePrepareInfo.setCloseView(bVar.j());
            aTNativePrepareInfo.setCtaView(bVar.e());
            aTNativePrepareInfo.setAdLogoView(bVar.g());
            aTNativePrepareInfo.setMainImageView(bVar.c());
            aTNativePrepareInfo.setDomainView(bVar.h());
            aTNativePrepareInfo.setWarningView(bVar.i());
            aTNativePrepareInfo.setIconView(bVar.b());
        }
        aTNativePrepareInfo.setClickViewList(list);
        aTNativePrepareInfo.setChoiceViewLayoutParams(layoutParams);
        prepare(view, aTNativePrepareInfo);
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
    }

    public final void setAdAppInfo(com.anythink.core.api.ATAdAppInfo aTAdAppInfo) {
        this.adAppInfo = aTAdAppInfo;
    }

    public final void setAdChoiceIconUrl(java.lang.String str) {
        this.mAdChoiceIconUrl = str;
    }

    public final void setAdFrom(java.lang.String str) {
        this.mAdFrom = str;
    }

    public final void setAdLogoView(android.view.View view) {
        this.adLogoView = view;
    }

    public void setAdvertiserName(java.lang.String str) {
        this.mAdvertiserName = str;
    }

    public void setAppCommentNum(int i) {
        this.mAppCommentNum = i;
    }

    public void setAppDownloadButton(android.view.View view) {
        this.mAppDownloadButton = view;
    }

    public void setAppPrice(double d) {
        this.mAppPrice = d;
    }

    public final void setCallToActionText(java.lang.String str) {
        this.mCallToAction = str;
    }

    public final void setDescriptionText(java.lang.String str) {
        this.mText = str;
    }

    public final void setDomain(java.lang.String str) {
        this.mDomain = str;
    }

    public final void setIconImageUrl(java.lang.String str) {
        this.mIconImageUrl = str;
    }

    public final void setImageUrlList(java.util.List<java.lang.String> list) {
        this.mImageUrlList = list;
    }

    public void setMainImageHeight(int i) {
        this.mMainImageHeight = i;
    }

    public final void setMainImageUrl(java.lang.String str) {
        this.mMainImageUrl = str;
    }

    public void setMainImageWidth(int i) {
        this.mMainImageWidth = i;
    }

    public void setNativeExpressHeight(int i) {
        this.mNativeExpressHeight = i;
    }

    public void setNativeExpressWidth(int i) {
        this.mNativeExpressWidth = i;
    }

    public final void setNativeInteractionType(int i) {
        this.nInteractionType = i;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNetworkInfoMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mNetworkInfoMap = map;
    }

    public final void setShowId(java.lang.String str) {
        this.showId = str;
    }

    public final void setStarRating(java.lang.Double d) {
        if (d == null) {
            this.mStarRating = null;
        } else {
            if (d.doubleValue() < 0.0d || d.doubleValue() > MAX_STAR_RATING) {
                return;
            }
            this.mStarRating = d;
        }
    }

    public final void setTitle(java.lang.String str) {
        this.mTitle = str;
    }

    public final void setVideoDuration(double d) {
        this.videoDuration = d;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    @Override // com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
    }

    public final void setVideoUrl(java.lang.String str) {
        this.mVideoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }

    public final void setWarning(java.lang.String str) {
        this.mWarning = str;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public boolean supportSetPermissionClickViewList() {
        return false;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public boolean supportSetPrivacyClickViewList() {
        return false;
    }

    public void unregeisterDownloadConfirmListener() {
    }
}
