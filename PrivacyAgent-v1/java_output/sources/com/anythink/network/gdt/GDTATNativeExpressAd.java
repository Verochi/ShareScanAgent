package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATNativeExpressAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.qq.e.ads.nativ.NativeExpressAD a;
    com.qq.e.ads.nativ.NativeExpressADView b;
    com.anythink.network.gdt.a c;
    java.lang.String d;
    private java.lang.Boolean e = java.lang.Boolean.FALSE;

    /* renamed from: com.anythink.network.gdt.GDTATNativeExpressAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener {

        /* renamed from: com.anythink.network.gdt.GDTATNativeExpressAd$1$1, reason: invalid class name and collision with other inner class name */
        public class C02391 implements com.qq.e.ads.nativ.NativeExpressMediaListener {
            public C02391() {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoCached(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoComplete(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
                com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoError(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView, com.qq.e.comm.util.AdError adError) {
                com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = com.anythink.network.gdt.GDTATNativeExpressAd.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(adError.getErrorCode());
                gDTATNativeExpressAd.notifyAdVideoVideoPlayFail(sb.toString(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoInit(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoLoading(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoPageClose(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoPageOpen(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoPause(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoReady(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView, long j) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public final void onVideoStart(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
                com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyAdVideoStart();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onADClicked(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onADClosed(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onADExposure(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATNativeExpressAd.this.getShowId(), new java.lang.ref.WeakReference(com.anythink.network.gdt.GDTATNativeExpressAd.this.b));
            com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onADLeftApplication(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onADLoaded(java.util.List<com.qq.e.ads.nativ.NativeExpressADView> list) {
            try {
                if (list.size() <= 0) {
                    com.anythink.network.gdt.a aVar = com.anythink.network.gdt.GDTATNativeExpressAd.this.c;
                    if (aVar != null) {
                        aVar.notifyError("", "GDT Ad request success but no Ad return.");
                    }
                    com.anythink.network.gdt.GDTATNativeExpressAd.this.c = null;
                    return;
                }
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView = list.get(0);
                com.anythink.network.gdt.GDTATNativeExpressAd.this.setNetworkInfoMap(nativeExpressADView.getExtraInfo());
                com.anythink.network.gdt.GDTATNativeExpressAd.this.b = nativeExpressADView;
                com.qq.e.comm.pi.AdData boundData = nativeExpressADView.getBoundData();
                if (boundData != null) {
                    if (boundData.getAdPatternType() == 2) {
                        ((com.anythink.nativead.unitgroup.a) com.anythink.network.gdt.GDTATNativeExpressAd.this).mAdSourceType = "1";
                    } else {
                        ((com.anythink.nativead.unitgroup.a) com.anythink.network.gdt.GDTATNativeExpressAd.this).mAdSourceType = "2";
                    }
                }
                com.anythink.network.gdt.GDTATNativeExpressAd.this.setVideoDuration(boundData != null ? boundData.getVideoDuration() / 1000 : 0.0d);
                com.anythink.network.gdt.GDTATNativeExpressAd.this.b.setMediaListener(new com.anythink.network.gdt.GDTATNativeExpressAd.AnonymousClass1.C02391());
                com.anythink.network.gdt.GDTATNativeExpressAd gDTATNativeExpressAd = com.anythink.network.gdt.GDTATNativeExpressAd.this;
                com.anythink.network.gdt.a aVar2 = gDTATNativeExpressAd.c;
                if (aVar2 != null) {
                    aVar2.notifyLoaded(gDTATNativeExpressAd);
                }
                com.anythink.network.gdt.GDTATNativeExpressAd.this.c = null;
            } catch (java.lang.Throwable th) {
                com.anythink.network.gdt.a aVar3 = com.anythink.network.gdt.GDTATNativeExpressAd.this.c;
                if (aVar3 != null) {
                    aVar3.notifyError("", "GDT Ad request fail:" + th.getMessage());
                }
                com.anythink.network.gdt.GDTATNativeExpressAd.this.c = null;
                th.printStackTrace();
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public final void onNoAD(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.a aVar = com.anythink.network.gdt.GDTATNativeExpressAd.this.c;
            if (aVar != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(adError.getErrorCode());
                aVar.notifyError(sb.toString(), adError.getErrorMsg());
            }
            com.anythink.network.gdt.GDTATNativeExpressAd.this.c = null;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onRenderFail(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
            com.anythink.network.gdt.a aVar = com.anythink.network.gdt.GDTATNativeExpressAd.this.c;
            if (aVar != null) {
                aVar.notifyError("", "GDT onRenderFail");
            }
            com.anythink.network.gdt.GDTATNativeExpressAd.this.c = null;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public final void onRenderSuccess(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView) {
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATNativeExpressAd$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView = com.anythink.network.gdt.GDTATNativeExpressAd.this.b;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATNativeExpressAd$3, reason: invalid class name */
    public class AnonymousClass3 implements com.qq.e.comm.compliance.DownloadConfirmListener {
        public AnonymousClass3() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
            com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
            gDTDownloadFirmInfo.appInfoUrl = str;
            gDTDownloadFirmInfo.scenes = i;
            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
            com.anythink.network.gdt.GDTATNativeExpressAd.this.notifyDownloadConfirm(activity, null, gDTDownloadFirmInfo);
        }
    }

    public GDTATNativeExpressAd(android.content.Context context, java.lang.String str, int i, int i2, int i3, int i4, int i5, java.lang.String str2) {
        int i6;
        int i7;
        this.d = str2;
        com.anythink.network.gdt.GDTATNativeExpressAd.AnonymousClass1 anonymousClass1 = new com.anythink.network.gdt.GDTATNativeExpressAd.AnonymousClass1();
        if (i > 0) {
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            i6 = com.anythink.network.gdt.GDTATInitManager.a(context, i);
        } else {
            i6 = -1;
        }
        if (i2 > 0) {
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            i7 = com.anythink.network.gdt.GDTATInitManager.a(context, i2);
        } else {
            i7 = -2;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            this.a = new com.qq.e.ads.nativ.NativeExpressAD(context, new com.qq.e.ads.nativ.ADSize(i6, i7), str, anonymousClass1);
        } else {
            this.a = new com.qq.e.ads.nativ.NativeExpressAD(context, new com.qq.e.ads.nativ.ADSize(i6, i7), str, anonymousClass1, str2);
        }
        this.a.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(i3 == 1).setDetailPageMuted(i3 == 1).setAutoPlayPolicy(i4).build());
        if (i5 != -1) {
            this.a.setMaxVideoDuration(i5);
        }
    }

    public final void a(com.anythink.network.gdt.a aVar, com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.c = aVar;
        if (android.text.TextUtils.isEmpty(this.d)) {
            this.a.loadAD(1, loadAdParams);
        } else {
            this.a.loadAD(1);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(null);
            this.b.destroy();
        }
        this.b = null;
        this.c = null;
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        if (!this.e.booleanValue() && this.b != null) {
            synchronized (this.e) {
                if (!this.e.booleanValue()) {
                    this.e = java.lang.Boolean.TRUE;
                    try {
                        this.b.post(new com.anythink.network.gdt.GDTATNativeExpressAd.AnonymousClass2());
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
        return this.b;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATNativeExpressAd.AnonymousClass3());
        }
    }
}
