package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel, com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd, com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> {
    private final java.lang.String tanxc_for;
    private final boolean tanxc_int;
    private final boolean tanxc_new;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd> {
        final /* synthetic */ boolean tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener tanxc_if;

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00211 implements java.lang.Runnable {
            final /* synthetic */ java.util.List tanxc_do;

            public RunnableC00211(java.util.List list) {
                this.tanxc_do = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener;
                com.alimm.tanx.core.utils.LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_do);
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1 anonymousClass1 = com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this;
                if (!anonymousClass1.tanxc_do || (onAdLoadListener = anonymousClass1.tanxc_if) == null) {
                    return;
                }
                onAdLoadListener.onLoaded(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.this.tanxc_do(this.tanxc_do));
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.alimm.tanx.core.request.TanxError tanxc_do;

            public AnonymousClass2(com.alimm.tanx.core.request.TanxError tanxError) {
                this.tanxc_do = tanxError;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("开屏请求错误 syncReq= ");
                sb.append(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_do);
                sb.append("--reason= ");
                com.alimm.tanx.core.request.TanxError tanxError = this.tanxc_do;
                sb.append(tanxError != null ? tanxError.toString() : "");
                com.alimm.tanx.core.utils.LogUtils.e("SplashAdPresenter", sb.toString());
                int intCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("开屏请求错误 syncReq= ");
                sb2.append(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_do);
                sb2.append("--reason= ");
                com.alimm.tanx.core.request.TanxError tanxError2 = this.tanxc_do;
                sb2.append(tanxError2 != null ? tanxError2.getMessage() : "");
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(intCode, "SplashAdPresenter", sb2.toString(), "");
                com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_if;
                if (onAdLoadListener != null) {
                    onAdLoadListener.onError(this.tanxc_do);
                }
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.utils.LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_do);
                com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.this.tanxc_if;
                if (onAdLoadListener != null) {
                    onAdLoadListener.onTimeOut();
                }
            }
        }

        public AnonymousClass1(boolean z, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            this.tanxc_do = z;
            this.tanxc_if = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.utils.UIThreadUtils.post(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.AnonymousClass2(tanxError));
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(java.util.List<com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd> list) {
            com.alimm.tanx.core.utils.UIThreadUtils.post(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.RunnableC00211(list));
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            com.alimm.tanx.core.utils.UIThreadUtils.post(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1.AnonymousClass3());
        }
    }

    public tanxc_int(android.content.Context context, com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel iSplashModel) {
        super(context, iSplashModel);
        this.tanxc_for = "SplashAdPresenter";
        this.tanxc_int = false;
        this.tanxc_new = false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do, com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter destroy() {
        return super.destroy();
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter tanxc_do(boolean z, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        ((com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel) this.tanxc_if).sendRequest(z, tanxAdSlot, new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.AnonymousClass1(z, onAdLoadListener), j);
        return this;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd tanxc_do(com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd iTanxSplashAd) {
        return new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new(this.tanxc_do, iTanxSplashAd);
    }

    public void tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot) {
        tanxc_do(false, tanxAdSlot, null, 0L);
    }

    public void tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        tanxc_do(true, tanxAdSlot, onAdLoadListener, j);
    }
}
