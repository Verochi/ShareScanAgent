package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class NativeAd {
    private boolean hasSetShowTkDetail;
    private com.anythink.core.common.f.b mAdCacheInfo;
    protected com.anythink.nativead.unitgroup.a mBaseNativeAd;
    com.anythink.nativead.api.NativeAd.DownloadConfirmListener mConfirmListener;
    private android.content.Context mContext;
    private com.anythink.nativead.api.ATNativeDislikeListener mDislikeListener;
    com.anythink.core.api.ATEventInterface mEventInterface;
    private boolean mIsDestroyed;
    private com.anythink.nativead.api.ATNativeEventListener mNativeEventListener;
    com.anythink.nativead.api.ATNativeAdView mNativeView;
    private java.lang.String mPlacementId;
    private boolean mRecordedImpression;
    private boolean mRecordedShow;
    com.anythink.nativead.api.ATNativeMaterial nativeMaterial;
    private final java.lang.String TAG = getClass().getSimpleName();
    android.view.View.OnClickListener mDefaultCloseViewListener = new com.anythink.nativead.api.NativeAd.AnonymousClass5();
    boolean isManualImpressionTrack = false;

    /* renamed from: com.anythink.nativead.api.NativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.b.m {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdClicked(android.view.View view) {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleClick(nativeAd.mNativeView, view);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdDislikeButtonClick() {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdImpressed() {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleImpression(nativeAd.mNativeView);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoEnd() {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleVideoEnd(nativeAd.mNativeView);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoProgress(int i) {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleVideoProgress(nativeAd.mNativeView, i);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoStart() {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleVideoStart(nativeAd.mNativeView);
        }

        @Override // com.anythink.core.common.b.m
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.handleDeeplinkCallback(nativeAd.mNativeView, z);
        }

        @Override // com.anythink.core.common.b.m
        public final void onDownloadConfirmCallback(android.content.Context context, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.nativead.api.NativeAd.this.handleDownloadConfirm(context, view, aTNetworkConfirmInfo);
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass10(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
            this.val$view = aTNativeAdView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener != null) {
                com.anythink.nativead.api.NativeAd.this.mNativeEventListener.onAdVideoStart(this.val$view);
            }
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass11(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
            this.val$view = aTNativeAdView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mDislikeListener != null) {
                com.anythink.nativead.api.NativeAd.this.mDislikeListener.onAdCloseButtonClick(this.val$view, com.anythink.core.common.b.k.a(com.anythink.nativead.api.NativeAd.this.mBaseNativeAd));
            }
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass2(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
            this.val$view = aTNativeAdView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener != null) {
                com.anythink.nativead.api.NativeAd.this.mNativeEventListener.onAdVideoEnd(this.val$view);
            }
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int val$progress;
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass3(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, int i) {
            this.val$view = aTNativeAdView;
            this.val$progress = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener != null) {
                com.anythink.nativead.api.NativeAd.this.mNativeEventListener.onAdVideoProgress(this.val$view, this.val$progress);
            }
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.nativead.api.NativeAd.ImpressionEventListener {
        public AnonymousClass4() {
        }

        @Override // com.anythink.nativead.api.NativeAd.ImpressionEventListener
        public final void onImpression() {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.anythink.nativead.unitgroup.a aVar = com.anythink.nativead.api.NativeAd.this.mBaseNativeAd;
            com.anythink.core.common.f.h detail = aVar != null ? aVar.getDetail() : null;
            if (detail != null && android.text.TextUtils.isEmpty(detail.q())) {
                detail.h(com.anythink.core.common.o.h.a(detail.ad(), detail.C(), currentTimeMillis));
            }
            com.anythink.nativead.unitgroup.a aVar2 = com.anythink.nativead.api.NativeAd.this.mBaseNativeAd;
            if (aVar2 instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
                ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar2).setShowId(detail.q());
            }
            com.anythink.nativead.api.NativeAd nativeAd = com.anythink.nativead.api.NativeAd.this;
            nativeAd.recordShow(nativeAd.mNativeView);
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.nativead.unitgroup.a aVar = com.anythink.nativead.api.NativeAd.this.mBaseNativeAd;
            if (aVar != null) {
                aVar.notifyAdDislikeClick();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.h val$adTrackingInfo;

        public AnonymousClass6(com.anythink.core.common.f.h hVar) {
            this.val$adTrackingInfo = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mIsDestroyed || com.anythink.nativead.api.NativeAd.this.mAdCacheInfo == null) {
                return;
            }
            com.anythink.nativead.api.NativeAd.this.fillShowTrackingInfo(this.val$adTrackingInfo);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                currentTimeMillis = java.lang.Long.parseLong(this.val$adTrackingInfo.q().split("_")[r2.length - 1]);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            long j = currentTimeMillis;
            com.anythink.nativead.unitgroup.a aVar = com.anythink.nativead.api.NativeAd.this.mBaseNativeAd;
            if (aVar != null && (aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
                ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).setShowId(this.val$adTrackingInfo.q());
            }
            com.anythink.core.common.a.a().a(com.anythink.nativead.api.NativeAd.this.mContext.getApplicationContext(), com.anythink.nativead.api.NativeAd.this.mAdCacheInfo);
            com.anythink.core.common.n.a.a(com.anythink.nativead.api.NativeAd.this.mContext).a(13, this.val$adTrackingInfo, com.anythink.nativead.api.NativeAd.this.mAdCacheInfo.d().getUnitGroupInfo(), j);
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        /* renamed from: com.anythink.nativead.api.NativeAd$7$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$atAdInfo;

            public AnonymousClass1(com.anythink.core.api.ATAdInfo aTAdInfo) {
                this.val$atAdInfo = aTAdInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener != null) {
                    com.anythink.nativead.api.NativeAd.this.mNativeEventListener.onAdImpressed(com.anythink.nativead.api.NativeAd.AnonymousClass7.this.val$view, this.val$atAdInfo);
                }
            }
        }

        public AnonymousClass7(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
            this.val$view = aTNativeAdView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.nativead.api.NativeAd.this.mIsDestroyed) {
                return;
            }
            try {
                com.anythink.nativead.unitgroup.a aVar = com.anythink.nativead.api.NativeAd.this.mBaseNativeAd;
                if (aVar != null) {
                    com.anythink.core.common.f.h detail = aVar.getDetail();
                    detail.a(com.anythink.nativead.api.NativeAd.this.mBaseNativeAd.getNetworkInfoMap());
                    com.anythink.core.common.o.o.a(detail, com.anythink.core.common.b.h.m.c, com.anythink.core.common.b.h.m.l, "");
                    com.anythink.nativead.api.NativeAd.this.fillShowTrackingInfo(detail);
                    com.anythink.core.common.n.a.a(com.anythink.nativead.api.NativeAd.this.mContext.getApplicationContext()).a(4, detail, com.anythink.nativead.api.NativeAd.this.mAdCacheInfo.d().getUnitGroupInfo());
                    com.anythink.core.common.b.k a = com.anythink.core.common.b.k.a(com.anythink.nativead.api.NativeAd.this.mBaseNativeAd);
                    if (a.getNetworkFirmId() == -1) {
                        com.anythink.core.common.n.e.a(com.anythink.core.common.b.h.i.a, com.anythink.nativead.api.NativeAd.this.mAdCacheInfo.d(), com.anythink.nativead.api.NativeAd.this.mBaseNativeAd);
                    }
                    com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass7.AnonymousClass1(a));
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ boolean val$isSuccess;
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass8(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, boolean z) {
            this.val$view = aTNativeAdView;
            this.val$isSuccess = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener == null || !(com.anythink.nativead.api.NativeAd.this.mNativeEventListener instanceof com.anythink.nativead.api.ATNativeEventExListener)) {
                return;
            }
            ((com.anythink.nativead.api.ATNativeEventExListener) com.anythink.nativead.api.NativeAd.this.mNativeEventListener).onDeeplinkCallback(this.val$view, com.anythink.core.common.b.k.a(com.anythink.nativead.api.NativeAd.this.mBaseNativeAd), this.val$isSuccess);
        }
    }

    /* renamed from: com.anythink.nativead.api.NativeAd$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.nativead.api.ATNativeAdView val$view;

        public AnonymousClass9(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
            this.val$view = aTNativeAdView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.nativead.api.NativeAd.this.mNativeEventListener != null) {
                com.anythink.nativead.api.NativeAd.this.mNativeEventListener.onAdClicked(this.val$view, com.anythink.core.common.b.k.a(com.anythink.nativead.api.NativeAd.this.mBaseNativeAd));
            }
        }
    }

    public interface DownloadConfirmListener {
        void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATAdInfo aTAdInfo, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo);
    }

    public interface ImpressionEventListener {
        void onImpression();
    }

    public NativeAd(android.content.Context context, java.lang.String str, com.anythink.core.common.f.b bVar) {
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mAdCacheInfo = bVar;
        com.anythink.nativead.unitgroup.a aVar = (com.anythink.nativead.unitgroup.a) bVar.e();
        this.mBaseNativeAd = aVar;
        aVar.setNativeEventListener(new com.anythink.nativead.api.NativeAd.AnonymousClass1());
        com.anythink.nativead.unitgroup.a aVar2 = this.mBaseNativeAd;
        if (aVar2 instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
            this.nativeMaterial = new com.anythink.nativead.a.b((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar2);
        }
    }

    private void bindListener() {
        com.anythink.nativead.api.ATNativePrepareInfo nativePrepareInfo;
        android.view.View closeView;
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
            com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd = (com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar;
            if (customNativeAd.checkHasCloseViewListener() || (nativePrepareInfo = customNativeAd.getNativePrepareInfo()) == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
                return;
            }
            closeView.setOnClickListener(this.mDefaultCloseViewListener);
        }
    }

    private void checkBindView(com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        if (aTNativePrepareInfo == null) {
            return;
        }
        if (aTNativePrepareInfo.getTitleView() == null) {
            printNotSetViewLog("titleView");
        }
        if (aTNativePrepareInfo.getCtaView() == null) {
            printNotSetViewLog("ctaView");
        }
        if (aTNativePrepareInfo.getDescView() == null) {
            printNotSetViewLog("descView");
        }
        if (aTNativePrepareInfo.getIconView() == null) {
            printNotSetViewLog("iconView");
        }
        if (aTNativePrepareInfo.getMainImageView() == null) {
            printNotSetViewLog("mainImageView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fillShowTrackingInfo(com.anythink.core.common.f.h hVar) {
        if (!this.hasSetShowTkDetail) {
            this.hasSetShowTkDetail = true;
            if (hVar != null) {
                com.anythink.core.common.o.u.a(this.mContext, hVar);
            }
        }
    }

    private void printNotSetViewLog(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("The ");
        sb.append(str);
        sb.append(" is not set, it may cause the ad to not be clicked normally.");
    }

    private void renderViewToWindow(android.view.View view) {
        com.anythink.core.common.o.o.b(this.mPlacementId, com.anythink.core.common.b.h.m.r, com.anythink.core.common.b.h.m.y, com.anythink.core.common.b.h.m.n, "");
        android.view.ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        int hashCode = hashCode();
        if (view.getParent() != null) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        if (customAdContainer != null) {
            if (customAdContainer.getParent() != null) {
                ((android.view.ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            customAdContainer.addView(view);
        }
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        this.mNativeView.renderView(hashCode, view, new com.anythink.nativead.api.NativeAd.AnonymousClass4());
    }

    public synchronized void clear(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        try {
            com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
            if (aVar != null) {
                aVar.clear(this.mNativeView);
            }
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.nativead.api.ATNativeAdView aTNativeAdView2 = this.mNativeView;
        if (aTNativeAdView2 != null) {
            aTNativeAdView2.clearImpressionListener(hashCode());
            this.mNativeView = null;
        }
    }

    public synchronized void destory() {
        if (this.mIsDestroyed) {
            return;
        }
        clear(this.mNativeView);
        this.mIsDestroyed = true;
        this.mNativeEventListener = null;
        this.mDislikeListener = null;
        this.mDefaultCloseViewListener = null;
        this.mNativeView = null;
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            aVar.setNativePrepareInfo(null);
            this.mBaseNativeAd.destroy();
        }
    }

    public com.anythink.core.api.ATAdInfo getAdInfo() {
        return com.anythink.core.common.b.k.a(this.mBaseNativeAd);
    }

    public int getAdInteractionType() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return 0;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).getNativeAdInteractionType();
    }

    public com.anythink.nativead.api.ATNativeMaterial getAdMaterial() {
        return this.nativeMaterial;
    }

    @java.lang.Deprecated
    public com.anythink.core.api.ATCustomVideo getCustomVideo() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return null;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).getNativeCustomVideo();
    }

    public int getNativeType() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return 0;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).getNativeType();
    }

    public double getVideoDuration() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return 0.0d;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).getVideoDuration();
    }

    public double getVideoProgress() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return 0.0d;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).getVideoProgress();
    }

    public synchronized void handleAdDislikeButtonClick(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass11(aTNativeAdView));
    }

    public synchronized void handleClick(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, android.view.View view) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            com.anythink.core.common.f.h detail = aVar.getDetail();
            com.anythink.core.common.o.o.a(detail, com.anythink.core.common.b.h.m.d, com.anythink.core.common.b.h.m.l, "");
            com.anythink.core.common.n.a.a(this.mContext.getApplicationContext()).a(6, detail);
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass9(aTNativeAdView));
    }

    public synchronized void handleDeeplinkCallback(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, boolean z) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass8(aTNativeAdView, z));
    }

    public synchronized void handleDownloadConfirm(android.content.Context context, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.nativead.api.NativeAd.DownloadConfirmListener downloadConfirmListener = this.mConfirmListener;
        if (downloadConfirmListener != null && (aVar = this.mBaseNativeAd) != null) {
            if (context == null) {
                context = this.mContext;
            }
            downloadConfirmListener.onDownloadConfirm(context, com.anythink.core.common.b.k.a(aVar), view, aTNetworkConfirmInfo);
        }
    }

    public synchronized void handleImpression(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        if (!this.mRecordedImpression && !this.mIsDestroyed) {
            this.mRecordedImpression = true;
            com.anythink.core.common.o.b.b.a().a(new com.anythink.nativead.api.NativeAd.AnonymousClass7(aTNativeAdView));
        }
    }

    public synchronized void handleVideoEnd(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            com.anythink.core.common.f.h detail = aVar.getDetail();
            detail.t = 100;
            com.anythink.core.common.n.a.a(this.mContext.getApplicationContext()).a(9, detail);
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass2(aTNativeAdView));
    }

    public synchronized void handleVideoProgress(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, int i) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass3(aTNativeAdView, i));
    }

    public synchronized void handleVideoStart(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            com.anythink.core.common.f.h detail = aVar.getDetail();
            detail.t = 0;
            com.anythink.core.common.n.a.a(this.mContext.getApplicationContext()).a(8, detail);
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.NativeAd.AnonymousClass10(aTNativeAdView));
    }

    public boolean isNativeExpress() {
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd)) {
            return false;
        }
        return ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).isNativeExpress();
    }

    public void manualImpressionTrack() {
        if (this.mIsDestroyed) {
            return;
        }
        if (!this.isManualImpressionTrack) {
            com.anythink.core.common.b.o.a().A();
            return;
        }
        com.anythink.nativead.api.ATNativeAdView aTNativeAdView = this.mNativeView;
        com.anythink.core.common.f.b bVar = this.mAdCacheInfo;
        com.anythink.core.api.ATBaseAdAdapter d = bVar != null ? bVar.d() : null;
        if (d != null && d.supportImpressionCallback()) {
            com.anythink.core.common.b.o.a().A();
            return;
        }
        if (aTNativeAdView == null) {
            com.anythink.core.common.b.o.a().A();
            return;
        }
        if (!aTNativeAdView.isShown()) {
            com.anythink.core.common.b.o.a().A();
            return;
        }
        if (!aTNativeAdView.isAttachedToWindow()) {
            com.anythink.core.common.b.o.a().A();
            return;
        }
        com.anythink.core.common.b.o.a().A();
        com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
        if (aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
            ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).impressionTrack(aTNativeAdView);
        }
    }

    public void onPause() {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onPause();
    }

    public void onResume() {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onResume();
    }

    public void pauseVideo() {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.pauseVideo();
    }

    public synchronized void prepare(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.mIsDestroyed) {
            return;
        }
        if (aTNativeAdView != null) {
            if (aTNativePrepareInfo == null) {
                aTNativePrepareInfo = new com.anythink.nativead.api.ATNativePrepareInfo();
            }
            this.mBaseNativeAd.setNativePrepareInfo(aTNativePrepareInfo);
            this.mBaseNativeAd.prepare(aTNativeAdView, aTNativePrepareInfo);
            bindListener();
            if (!this.mBaseNativeAd.isNativeExpress()) {
                checkBindView(aTNativePrepareInfo);
            }
        }
    }

    public synchronized void recordShow(com.anythink.nativead.api.ATNativeAdView aTNativeAdView) {
        com.anythink.core.common.f a;
        if (!this.mRecordedShow) {
            com.anythink.core.common.f.h detail = this.mBaseNativeAd.getDetail();
            this.mRecordedShow = true;
            if (this.mAdCacheInfo != null && (a = com.anythink.core.common.u.a().a(this.mPlacementId, "0")) != null) {
                a.a(this.mAdCacheInfo);
            }
            com.anythink.core.common.o.b.b.a().a(new com.anythink.nativead.api.NativeAd.AnonymousClass6(detail));
        }
    }

    public synchronized void renderAdContainer(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, android.view.View view) {
        if (this.mIsDestroyed) {
            return;
        }
        if (aTNativeAdView != null) {
            aTNativeAdView.clear();
        }
        if (aTNativeAdView == null) {
            return;
        }
        if (isNativeExpress()) {
            com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
            if (aVar != null) {
                view = aVar.getAdMediaView(aTNativeAdView, java.lang.Integer.valueOf(aTNativeAdView.getWidth()));
                if (view == null) {
                    return;
                }
            } else {
                view = null;
            }
        } else if (view == null) {
            return;
        }
        this.mNativeView = aTNativeAdView;
        aTNativeAdView.attachNativeAd(this);
        if (view != null) {
            view.setVisibility(0);
            renderViewToWindow(view);
        }
    }

    public void resumeVideo() {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.resumeVideo();
    }

    public void setAdDownloadListener(com.anythink.core.api.ATEventInterface aTEventInterface) {
        this.mEventInterface = aTEventInterface;
        com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
        if (b == null) {
            this.mBaseNativeAd.setDownloadListener(null);
        } else if (aTEventInterface != null) {
            this.mBaseNativeAd.setDownloadListener(b.createDownloadListener(this.mAdCacheInfo.d(), this.mBaseNativeAd, aTEventInterface));
        } else {
            this.mBaseNativeAd.setDownloadListener(null);
        }
    }

    public void setDislikeCallbackListener(com.anythink.nativead.api.ATNativeDislikeListener aTNativeDislikeListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mDislikeListener = aTNativeDislikeListener;
    }

    public void setDownloadConfirmListener(com.anythink.nativead.api.NativeAd.DownloadConfirmListener downloadConfirmListener) {
        if (downloadConfirmListener != null) {
            com.anythink.nativead.unitgroup.a aVar = this.mBaseNativeAd;
            if (aVar instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
                ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar).registerDownloadConfirmListener();
            }
        } else {
            com.anythink.nativead.unitgroup.a aVar2 = this.mBaseNativeAd;
            if (aVar2 instanceof com.anythink.nativead.unitgroup.api.CustomNativeAd) {
                ((com.anythink.nativead.unitgroup.api.CustomNativeAd) aVar2).unregeisterDownloadConfirmListener();
            }
        }
        this.mConfirmListener = downloadConfirmListener;
    }

    public void setManualImpressionTrack(boolean z) {
        this.isManualImpressionTrack = z;
    }

    public void setNativeEventListener(com.anythink.nativead.api.ATNativeEventListener aTNativeEventListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mNativeEventListener = aTNativeEventListener;
    }

    public void setVideoMute(boolean z) {
        com.anythink.nativead.unitgroup.a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.setVideoMute(z);
    }
}
