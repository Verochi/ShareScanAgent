package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    private static final java.lang.String e = "BaiduATNativeAd";
    protected com.baidu.mobads.sdk.api.NativeResponse a;
    protected android.content.Context b;
    com.anythink.network.baidu.impression.BDImpressionTracker c;
    boolean d = true;
    private com.baidu.mobads.sdk.api.XNativeView f;

    /* renamed from: com.anythink.network.baidu.BaiduATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADExposed() {
            com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = com.anythink.network.baidu.BaiduATNativeAd.this.c;
            if (bDImpressionTracker != null) {
                bDImpressionTracker.clear();
                com.anythink.network.baidu.BaiduATNativeAd.this.c = null;
            }
            com.anythink.network.baidu.BaiduATNativeAd.this.notifyAdImpression();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADExposureFailed(int i) {
            java.lang.String unused = com.anythink.network.baidu.BaiduATNativeAd.e;
            "Baidu Native onADExposureFailed:".concat(java.lang.String.valueOf(i));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADStatusChanged() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onAdClick() {
            com.anythink.network.baidu.BaiduATNativeAd.this.notifyAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onAdUnionClick() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.network.baidu.impression.BDImpressionController {
        public AnonymousClass2() {
        }

        @Override // com.anythink.network.baidu.impression.BDImpressionController, com.anythink.network.baidu.impression.BDImpressionInterface
        public final void recordImpression(android.view.View view) {
            try {
                com.baidu.mobads.sdk.api.NativeResponse nativeResponse = com.anythink.network.baidu.BaiduATNativeAd.this.a;
                if (nativeResponse == null || view == null) {
                    return;
                }
                nativeResponse.recordImpression(view);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeAd$3, reason: invalid class name */
    public class AnonymousClass3 implements com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener {
        public AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
        public final void onNativeViewClick(com.baidu.mobads.sdk.api.XNativeView xNativeView) {
            com.anythink.network.baidu.BaiduATNativeAd.this.notifyAdClicked();
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeAd$4, reason: invalid class name */
    public class AnonymousClass4 implements com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener {
        final /* synthetic */ com.anythink.core.api.ATShakeViewListener a;

        public AnonymousClass4(com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
            this.a = aTShakeViewListener;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
        public final void onDismiss() {
            com.anythink.core.api.ATShakeViewListener aTShakeViewListener = this.a;
            if (aTShakeViewListener != null) {
                aTShakeViewListener.onDismiss();
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeAd$5, reason: invalid class name */
    public class AnonymousClass5 implements com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener {
        final /* synthetic */ com.anythink.core.api.ATShakeViewListener a;

        public AnonymousClass5(com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
            this.a = aTShakeViewListener;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
        public final void onDismiss() {
            com.anythink.core.api.ATShakeViewListener aTShakeViewListener = this.a;
            if (aTShakeViewListener != null) {
                aTShakeViewListener.onDismiss();
            }
        }
    }

    public BaiduATNativeAd() {
    }

    public BaiduATNativeAd(android.content.Context context, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        a(context, nativeResponse);
    }

    private java.util.List<android.view.View> a(android.view.View view) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!(view instanceof android.view.ViewGroup) || view == this.f) {
            arrayList.add(view);
        } else {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(a(viewGroup.getChildAt(i)));
            }
        }
        return arrayList;
    }

    private void a(android.view.View view, android.view.View.OnClickListener onClickListener) {
        if (!(view instanceof android.view.ViewGroup) || view == this.f) {
            view.setOnClickListener(onClickListener);
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            a(viewGroup.getChildAt(i), onClickListener);
        }
    }

    private void b(android.view.View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof android.view.ViewGroup) || view == this.f) {
            view.setOnClickListener(null);
            view.setClickable(false);
        } else {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                b(viewGroup.getChildAt(i));
            }
        }
    }

    public final void a(android.content.Context context, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new com.anythink.network.baidu.impression.BDImpressionTracker(applicationContext, 50);
        this.a = nativeResponse;
        setData(nativeResponse);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
        b(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.a = null;
        com.baidu.mobads.sdk.api.XNativeView xNativeView = this.f;
        if (xNativeView != null) {
            xNativeView.setNativeItem(null);
            this.f.setNativeViewClickListener(null);
            this.f = null;
        }
        this.b = null;
        com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = this.c;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || nativeResponse.getMaterialType() != com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO) {
            return null;
        }
        if (this.f == null) {
            com.baidu.mobads.sdk.api.XNativeView xNativeView = new com.baidu.mobads.sdk.api.XNativeView(this.b);
            this.f = xNativeView;
            xNativeView.setNativeItem(this.a);
            this.f.setVideoMute(this.d);
            this.f.setNativeViewClickListener(new com.anythink.network.baidu.BaiduATNativeAd.AnonymousClass3());
        }
        return this.f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getShakeView(int i, int i2, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new com.anythink.network.baidu.BaiduATNativeAd.AnonymousClass4(aTShakeViewListener));
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getSlideView(int i, int i2, int i3, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderSlideView(i, i2, i3, new com.anythink.network.baidu.BaiduATNativeAd.AnonymousClass5(aTShakeViewListener));
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(android.view.View view) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        java.util.List creativeClickViewList;
        if (this.a != null) {
            java.util.List arrayList = new java.util.ArrayList();
            if ((aTNativePrepareInfo instanceof com.anythink.nativead.api.ATNativePrepareExInfo) && (creativeClickViewList = ((com.anythink.nativead.api.ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
                arrayList = creativeClickViewList;
            }
            java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() == 0) {
                clickViewList = a(view);
            }
            this.a.registerViewForInteraction(view, clickViewList, arrayList, new com.anythink.network.baidu.BaiduATNativeAd.AnonymousClass1());
        }
        com.baidu.mobads.sdk.api.XNativeView xNativeView = this.f;
        if (xNativeView != null) {
            xNativeView.render();
        }
        try {
            com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = this.c;
            if (bDImpressionTracker != null) {
                bDImpressionTracker.addView(view, new com.anythink.network.baidu.BaiduATNativeAd.AnonymousClass2());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setData(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        setIconImageUrl(nativeResponse.getIconUrl());
        if (android.text.TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            java.util.List<java.lang.String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls != null && multiPicUrls.size() > 0) {
                setMainImageUrl(multiPicUrls.get(0));
                setMainImageWidth(nativeResponse.getMainPicWidth());
                setMainImageHeight(nativeResponse.getMainPicHeight());
            }
        } else {
            setMainImageUrl(nativeResponse.getImageUrl());
            setMainImageWidth(nativeResponse.getMainPicWidth());
            setMainImageHeight(nativeResponse.getMainPicHeight());
        }
        setMainImageWidth(nativeResponse.getMainPicWidth());
        setMainImageHeight(nativeResponse.getMainPicHeight());
        setImageUrlList(nativeResponse.getMultiPicUrls());
        setVideoUrl(nativeResponse.getVideoUrl());
        setVideoDuration(nativeResponse.getDuration());
        setAdChoiceIconUrl(nativeResponse.getBaiduLogoUrl());
        setTitle(nativeResponse.getTitle());
        setDescriptionText(nativeResponse.getDesc());
        setCallToActionText(nativeResponse.getActButtonString());
        setAdvertiserName(nativeResponse.getBrandName());
        int i = nativeResponse.getAdActionType() != 2 ? nativeResponse.getAdActionType() == 1 ? 2 : 0 : 1;
        if (nativeResponse.getAdActionType() == 3) {
            i = 3;
        }
        setNativeInteractionType(i);
        if (nativeResponse.getAdActionType() == 2) {
            setAdAppInfo(new com.anythink.network.baidu.BaiduATDownloadAppInfo(nativeResponse));
        }
        if (android.text.TextUtils.equals(nativeResponse.getAdMaterialType(), com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO.getValue())) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.d = z;
        com.baidu.mobads.sdk.api.XNativeView xNativeView = this.f;
        if (xNativeView != null) {
            xNativeView.setVideoMute(z);
        }
    }
}
