package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public class tanxc_new extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd> implements com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd {
    private final android.content.Context tanxc_do;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxc_if;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener tanxc_int;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener tanxc_new;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdClicked(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j, android.content.Context context, boolean z2, int i) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdClicked();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdClosed(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.removeAdView();
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdClosed();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdFinished(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdFinish();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdShowError(int i) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onShowError(new com.alimm.tanx.core.request.TanxError("错误码:" + i));
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdShowException(boolean z, java.lang.String str) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onShowError(new com.alimm.tanx.core.request.TanxError(str));
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void onAdStarted(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                try {
                    com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdRender((com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd) com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_for);
                } catch (java.lang.Exception unused) {
                    com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdRender(null);
                }
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
        public void requestCloseAd(boolean z, int i) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd iTanxSplashAd) {
            tanxc_do();
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
        public void onAdClose() {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.removeAdView();
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdClosed();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
        public void onAdShake() {
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.pauseTimer();
            }
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdShake();
            }
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_do(null, null, true);
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdShow(com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd iTanxSplashAd) {
            tanxc_if();
        }

        public void tanxc_do() {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.pauseTimer();
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdClicked();
            }
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if == null || com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.getClickView() == null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_if.notifyViewClick();
        }

        public void tanxc_if() {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.getAdSlot(), com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.getRequestId(), com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.getBidInfo(), "ITanxSplashInteractionListener-onAdShow", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD);
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.this.tanxc_int.onAdShow();
            }
        }
    }

    public tanxc_new(android.content.Context context, com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd iTanxSplashAd) {
        super(iTanxSplashAd);
        this.tanxc_do = context;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        com.alimm.tanx.core.utils.LogUtils.d("TanxSplashExpressAd", "媒体调用destroy（）");
        this.tanxc_int = null;
        this.tanxc_new = null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public int getFromType() {
        if (tanxc_if() != null) {
            return tanxc_if().fromType;
        }
        return -1;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener getOnSplashAdListener() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return "screen";
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public void setOnSplashAdListener(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener onSplashAdListener) {
        this.tanxc_int = onSplashAdListener;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView() {
        return getAdView((android.app.Activity) this.tanxc_do);
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView(android.app.Activity activity) {
        com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(getAdSlot(), getRequestId(), getBidInfo(), "TanxSplashExpressAd-getAdView", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD);
        if (this.tanxc_if == null) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView = new com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView(activity);
            this.tanxc_if = tanxSplashAdView;
            tanxSplashAdView.setTanxSplashExpressAd(this);
            this.tanxc_if.setRenderCallback(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.AnonymousClass1());
            this.tanxc_if.startShow(getBidInfo());
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.AnonymousClass2 anonymousClass2 = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.AnonymousClass2();
            this.tanxc_new = anonymousClass2;
            this.tanxc_if.setITanxSplashInteractionListener(anonymousClass2);
            com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd iTanxSplashAd = (com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd) this.tanxc_for;
            com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
            iTanxSplashAd.bindSplashAdView(tanxSplashAdView2, tanxSplashAdView2.getClickView(), this.tanxc_if.getCloseView(), this.tanxc_new);
        }
        return this.tanxc_if;
    }

    public void tanxc_do(java.lang.String str, java.lang.String str2, boolean z) {
        T t = this.tanxc_for;
        if (t instanceof com.alimm.tanx.core.ad.ad.splash.TanxSplashAd) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView = this.tanxc_if;
            if (tanxSplashAdView != null) {
                ((com.alimm.tanx.core.ad.ad.splash.TanxSplashAd) t).navigateAndUt(null, tanxSplashAdView.getContext(), z, str, str2);
            } else {
                com.alimm.tanx.core.utils.LogUtils.e("TanxSplashExpressAd", "摇一摇时，mAdView为空");
            }
        }
    }

    public com.alimm.tanx.core.ad.ad.splash.TanxSplashAd tanxc_if() {
        T t = this.tanxc_for;
        if (t == 0 || !(t instanceof com.alimm.tanx.core.ad.ad.splash.TanxSplashAd)) {
            return null;
        }
        return (com.alimm.tanx.core.ad.ad.splash.TanxSplashAd) t;
    }
}
