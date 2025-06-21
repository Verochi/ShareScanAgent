package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    private static final java.lang.String l = "GDTATNativeAd";
    java.lang.ref.WeakReference<android.content.Context> a;
    android.content.Context b;
    com.qq.e.ads.nativ.NativeUnifiedADData c;
    int d;
    int e;
    int f;
    android.view.View h;
    com.qq.e.ads.nativ.MediaView i;
    com.qq.e.ads.nativ.widget.NativeAdContainer k;
    int g = 0;
    boolean j = false;

    /* renamed from: com.anythink.network.gdt.GDTATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.qq.e.comm.compliance.DownloadConfirmListener {
        public AnonymousClass1() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
            com.anythink.network.gdt.GDTATNativeAd gDTATNativeAd = com.anythink.network.gdt.GDTATNativeAd.this;
            android.view.View view = gDTATNativeAd.h;
            gDTATNativeAd.h = null;
            com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
            gDTDownloadFirmInfo.appInfoUrl = str;
            gDTDownloadFirmInfo.scenes = i;
            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
            com.anythink.network.gdt.GDTATNativeAd.this.notifyDownloadConfirm(activity, view, gDTDownloadFirmInfo);
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 extends com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo {
        final /* synthetic */ com.qq.e.ads.nativ.NativeUnifiedADData a;

        public AnonymousClass2(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData) {
            this.a = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
        public final void onADClicked(android.view.View view) {
            com.anythink.network.gdt.GDTATNativeAd.this.h = view;
            "onADClicked....".concat(java.lang.String.valueOf(view));
            com.anythink.network.gdt.GDTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADError(com.qq.e.comm.util.AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADExposed() {
            com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATNativeAd.this.getShowId(), new java.lang.ref.WeakReference(this.a));
            com.anythink.network.gdt.GDTATNativeAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADStatusChanged() {
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATNativeAd$3, reason: invalid class name */
    public class AnonymousClass3 implements com.qq.e.ads.nativ.NativeADMediaListener {
        public AnonymousClass3() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoCompleted() {
            com.anythink.network.gdt.GDTATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoError(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATNativeAd gDTATNativeAd = com.anythink.network.gdt.GDTATNativeAd.this;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATNativeAd.notifyAdVideoVideoPlayFail(sb.toString(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoLoaded(int i) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoStart() {
            com.anythink.network.gdt.GDTATNativeAd.this.notifyAdVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public final void onVideoStop() {
        }
    }

    public GDTATNativeAd(android.content.Context context, com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3) {
        java.lang.String str;
        this.b = context.getApplicationContext();
        this.a = new java.lang.ref.WeakReference<>(context);
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.c = nativeUnifiedADData;
        setTitle(nativeUnifiedADData.getTitle());
        setDescriptionText(nativeUnifiedADData.getDesc());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        setStarRating(java.lang.Double.valueOf(nativeUnifiedADData.getAppScore()));
        setAppPrice(nativeUnifiedADData.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData));
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImageWidth(nativeUnifiedADData.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData.getPictureHeight());
        setImageUrlList(nativeUnifiedADData.getImgList());
        setVideoDuration(nativeUnifiedADData.getVideoDuration() / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData.isAppAd() ? 1 : 0);
        com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd() && appMiitInfo != null) {
            try {
                str = java.lang.String.valueOf(nativeUnifiedADData.getDownloadCount());
            } catch (java.lang.Exception unused) {
                str = "";
            }
            setAdAppInfo(new com.anythink.network.gdt.GDTATDownloadAppInfo(appMiitInfo, str));
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData.setNativeAdEventListener(new com.anythink.network.gdt.GDTATNativeAd.AnonymousClass2(nativeUnifiedADData));
        setNetworkInfoMap(nativeUnifiedADData.getExtraInfo());
    }

    private void a(android.view.View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof android.view.ViewGroup) || view == this.i) {
            view.setOnClickListener(null);
            view.setClickable(false);
        } else {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
        }
    }

    private void a(android.view.View view, java.util.List<android.view.View> list) {
        if (!(view instanceof android.view.ViewGroup) || view == this.i) {
            list.add(view);
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            a(viewGroup.getChildAt(i), list);
        }
    }

    private void a(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData) {
        java.lang.String str;
        setTitle(nativeUnifiedADData.getTitle());
        setDescriptionText(nativeUnifiedADData.getDesc());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        setStarRating(java.lang.Double.valueOf(nativeUnifiedADData.getAppScore()));
        setAppPrice(nativeUnifiedADData.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData));
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImageWidth(nativeUnifiedADData.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData.getPictureHeight());
        setImageUrlList(nativeUnifiedADData.getImgList());
        setVideoDuration(nativeUnifiedADData.getVideoDuration() / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData.isAppAd() ? 1 : 0);
        com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd() && appMiitInfo != null) {
            try {
                str = java.lang.String.valueOf(nativeUnifiedADData.getDownloadCount());
            } catch (java.lang.Exception unused) {
                str = "";
            }
            setAdAppInfo(new com.anythink.network.gdt.GDTATDownloadAppInfo(appMiitInfo, str));
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData.setNativeAdEventListener(new com.anythink.network.gdt.GDTATNativeAd.AnonymousClass2(nativeUnifiedADData));
        setNetworkInfoMap(nativeUnifiedADData.getExtraInfo());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setNativeAdEventListener(null);
            this.c.destroy();
            this.c = null;
        }
        this.i = null;
        this.b = null;
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
        com.qq.e.ads.nativ.widget.NativeAdContainer nativeAdContainer = this.k;
        if (nativeAdContainer != null) {
            nativeAdContainer.removeAllViews();
            this.k = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null && nativeUnifiedADData.getAdPatternType() == 2) {
            if (this.i == null) {
                com.qq.e.ads.nativ.MediaView mediaView = new com.qq.e.ads.nativ.MediaView(this.b);
                this.i = mediaView;
                mediaView.setBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                android.view.ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new android.view.ViewGroup.LayoutParams(-1, -2);
                }
                this.i.setLayoutParams(layoutParams);
            }
            return this.i;
        }
        return super.getAdMediaView(objArr);
    }

    public java.lang.String getCallToAction(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData) {
        if (!android.text.TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            return nativeUnifiedADData.getCTAText();
        }
        boolean isAppAd = nativeUnifiedADData.isAppAd();
        int appStatus = nativeUnifiedADData.getAppStatus();
        return !isAppAd ? "浏览" : appStatus != 0 ? appStatus != 1 ? appStatus != 2 ? appStatus != 4 ? appStatus != 8 ? appStatus != 16 ? "浏览" : "下载" : "安装" : "下载" : "更新" : "启动" : "下载";
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public android.view.ViewGroup getCustomAdContainer() {
        if (this.c != null) {
            this.k = new com.qq.e.ads.nativ.widget.NativeAdContainer(this.b);
        }
        return this.k;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.c != null ? r0.getVideoCurrentPosition() / 1000.0d : super.getVideoProgress();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        java.util.List<android.view.View> creativeClickViewList;
        if (this.c == null || this.k == null) {
            return;
        }
        java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = new java.util.ArrayList<>();
            a(view, clickViewList);
        }
        java.util.List<android.view.View> list = clickViewList;
        android.widget.FrameLayout.LayoutParams choiceViewLayoutParams = aTNativePrepareInfo.getChoiceViewLayoutParams();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if ((aTNativePrepareInfo instanceof com.anythink.nativead.api.ATNativePrepareExInfo) && (creativeClickViewList = ((com.anythink.nativead.api.ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList.addAll(creativeClickViewList);
        }
        this.c.bindAdToView(view.getContext(), this.k, choiceViewLayoutParams, list, arrayList);
        try {
            com.qq.e.ads.nativ.MediaView mediaView = this.i;
            if (mediaView == null) {
                return;
            }
            this.c.bindMediaView(mediaView, new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(this.d == 1).setDetailPageMuted(this.d == 1).setAutoPlayPolicy(this.e).build(), new com.anythink.network.gdt.GDTATNativeAd.AnonymousClass3());
            int i = this.g;
            if (i > 0) {
                this.c.setVideoMute(i == 1);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        this.c.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATNativeAd.AnonymousClass1());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.g = z ? 1 : 2;
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(z);
        }
    }
}
