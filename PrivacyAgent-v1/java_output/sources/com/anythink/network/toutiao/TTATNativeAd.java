package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.bytedance.sdk.openadsdk.TTNativeAd a;
    android.content.Context b;
    java.lang.String c;
    boolean d = false;
    com.anythink.network.toutiao.TTATCustomVideo e;
    double f;
    android.view.View g;

    /* renamed from: com.anythink.network.toutiao.TTATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onProgressUpdate(long j, long j2) {
            if (com.anythink.network.toutiao.TTATNativeAd.this.getVideoDuration() == 0.0d) {
                com.anythink.network.toutiao.TTATNativeAd.this.setVideoDuration(j2 / 1000.0d);
            }
            com.anythink.network.toutiao.TTATNativeAd tTATNativeAd = com.anythink.network.toutiao.TTATNativeAd.this;
            double d = j / 1000.0d;
            tTATNativeAd.f = d;
            tTATNativeAd.notifyAdVideoPlayProgress((int) d);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdVideoStart();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoError(int i, int i2) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdVideoVideoPlayFail(java.lang.String.valueOf(i), java.lang.String.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public final void onVideoLoad(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd) {
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            com.anythink.network.toutiao.TTATNativeAd tTATNativeAd = com.anythink.network.toutiao.TTATNativeAd.this;
            if (tTATNativeAd.d) {
                if (((com.anythink.nativead.unitgroup.a) tTATNativeAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            tTATNativeAd.d = true;
            if (((com.anythink.nativead.unitgroup.a) tTATNativeAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeAd.this).mDownloadListener).onInstalled(str, str2);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeAd$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ android.app.Activity a;

        /* renamed from: com.anythink.network.toutiao.TTATNativeAd$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback {
            public AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public final void onCancel() {
            }

            @java.lang.Deprecated
            public final void onRefuse() {
            }

            @java.lang.Deprecated
            public final void onSelected(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public final void onSelected(int i, java.lang.String str, boolean z) {
                com.anythink.network.toutiao.TTATNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public final void onShow() {
            }
        }

        public AnonymousClass3(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd = com.anythink.network.toutiao.TTATNativeAd.this.a;
            if (tTNativeAd == null) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.bytedance.sdk.openadsdk.TTAdDislike dislikeDialog = tTNativeAd.getDislikeDialog(this.a);
            dislikeDialog.setDislikeInteractionCallback(new com.anythink.network.toutiao.TTATNativeAd.AnonymousClass3.AnonymousClass1());
            if (!dislikeDialog.isShow()) {
                dislikeDialog.showDislikeDialog();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class a implements com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener {
        private a() {
        }

        public /* synthetic */ a(com.anythink.network.toutiao.TTATNativeAd tTATNativeAd, byte b) {
            this();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdClicked(android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdCreativeClick(android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd) {
            com.anythink.network.toutiao.TTATNativeAd.this.notifyAdImpression();
        }
    }

    public TTATNativeAd(android.content.Context context, java.lang.String str, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd, boolean z, android.graphics.Bitmap bitmap, int i) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.a = tTNativeAd;
        setNetworkInfoMap(tTNativeAd.getMediaExtraInfo());
        setAdData(z, bitmap, i);
    }

    private void a(android.app.Activity activity) {
        bindDislikeListener(new com.anythink.network.toutiao.TTATNativeAd.AnonymousClass3(activity));
    }

    private void a(android.view.View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            view.setOnClickListener(null);
            view.setClickable(false);
            return;
        }
        com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd = this.a;
        if (tTNativeAd == null || view != tTNativeAd.getAdView()) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
        }
    }

    private void a(java.util.List<android.view.View> list, android.view.View view) {
        if (!(view instanceof android.view.ViewGroup) || view == this.a.getAdView()) {
            if (view != this.a.getAdView()) {
                list.add(view);
            }
        } else {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(list, viewGroup.getChildAt(i));
            }
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        try {
            com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd != null) {
                tTNativeAd.setActivityForDownloadApp(null);
            }
        } catch (java.lang.Exception unused) {
        }
        this.b = null;
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public android.graphics.Bitmap getAdLogo() {
        try {
            com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd != null) {
                return tTNativeAd.getAdLogo();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        if (this.g == null) {
            this.g = this.a.getAdView();
        }
        return this.g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public com.anythink.core.api.ATCustomVideo getNativeCustomVideo() {
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = new java.util.ArrayList<>();
            a(clickViewList, view);
        }
        com.anythink.network.toutiao.TTATNativeAd.a aVar = new com.anythink.network.toutiao.TTATNativeAd.a(this, (byte) 0);
        if (clickViewList.size() > 0) {
            this.a.registerViewForInteraction((android.view.ViewGroup) view, clickViewList, clickViewList, aVar);
        } else {
            this.a.registerViewForInteraction((android.view.ViewGroup) view, view, aVar);
        }
        if (view.getContext() instanceof android.app.Activity) {
            this.a.setActivityForDownloadApp((android.app.Activity) view.getContext());
            bindDislikeListener(new com.anythink.network.toutiao.TTATNativeAd.AnonymousClass3((android.app.Activity) view.getContext()));
        }
    }

    public void setAdData(boolean z, android.graphics.Bitmap bitmap, int i) {
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setAdFrom(this.a.getSource());
        setStarRating(java.lang.Double.valueOf(this.a.getAppScore()));
        setAppCommentNum(this.a.getAppCommentNum());
        com.bytedance.sdk.openadsdk.TTImage icon = this.a.getIcon();
        if (icon != null) {
            setIconImageUrl(icon.getImageUrl());
        }
        java.util.List<com.bytedance.sdk.openadsdk.TTImage> imageList = this.a.getImageList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (imageList != null && imageList.size() > 0) {
            for (int i2 = 0; i2 < imageList.size(); i2++) {
                com.bytedance.sdk.openadsdk.TTImage tTImage = imageList.get(i2);
                if (tTImage != null) {
                    arrayList.add(tTImage.getImageUrl());
                    if (i2 == 0) {
                        setMainImageUrl(tTImage.getImageUrl());
                        setMainImageWidth(tTImage.getWidth());
                        setMainImageHeight(tTImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.a.getButtonText());
        com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd = this.a;
        if (tTNativeAd instanceof com.bytedance.sdk.openadsdk.TTDrawFeedAd) {
            com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customVideo = ((com.bytedance.sdk.openadsdk.TTDrawFeedAd) tTNativeAd).getCustomVideo();
            if (customVideo != null) {
                setVideoUrl(customVideo.getVideoUrl());
                this.e = new com.anythink.network.toutiao.TTATCustomVideo(customVideo);
            }
            ((com.bytedance.sdk.openadsdk.TTDrawFeedAd) this.a).setCanInterruptVideoPlay(z);
            if (bitmap != null && i > 0) {
                ((com.bytedance.sdk.openadsdk.TTDrawFeedAd) this.a).setPauseIcon(bitmap, i);
            }
        }
        com.bytedance.sdk.openadsdk.ComplianceInfo complianceInfo = this.a.getComplianceInfo();
        if (complianceInfo != null && (!android.text.TextUtils.isEmpty(complianceInfo.getAppName()) || !android.text.TextUtils.isEmpty(complianceInfo.getAppVersion()) || !android.text.TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !android.text.TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !android.text.TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !android.text.TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
            setAdAppInfo(new com.anythink.network.toutiao.TTATDownloadAppInfo(complianceInfo, this.a.getAppSize()));
        }
        int i3 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i3 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i3 = 2;
        }
        setNativeInteractionType(i3);
        com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd2 = this.a;
        if (tTNativeAd2 instanceof com.bytedance.sdk.openadsdk.TTFeedAd) {
            com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customVideo2 = ((com.bytedance.sdk.openadsdk.TTFeedAd) tTNativeAd2).getCustomVideo();
            if (customVideo2 != null) {
                setVideoUrl(customVideo2.getVideoUrl());
                this.e = new com.anythink.network.toutiao.TTATCustomVideo(customVideo2);
            }
            setVideoDuration(((com.bytedance.sdk.openadsdk.TTFeedAd) this.a).getVideoDuration());
            ((com.bytedance.sdk.openadsdk.TTFeedAd) this.a).setVideoAdListener(new com.anythink.network.toutiao.TTATNativeAd.AnonymousClass1());
        }
        this.a.setDownloadListener(new com.anythink.network.toutiao.TTATNativeAd.AnonymousClass2());
        int imageMode = this.a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }
}
