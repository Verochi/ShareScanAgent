package com.qq.e.ads.banner2;

/* loaded from: classes19.dex */
class UnifiedBannerAD extends com.qq.e.ads.LiteAbstractAD<com.qq.e.comm.pi.UBVI> implements com.qq.e.comm.pi.NFBI, com.qq.e.comm.pi.IReward {
    private com.qq.e.ads.banner2.UnifiedBannerADListener i;
    private java.util.concurrent.atomic.AtomicInteger j;
    private int k;
    private com.qq.e.comm.constants.LoadAdParams l;
    private com.qq.e.ads.banner2.UnifiedBannerView m;
    private final com.qq.e.ads.banner2.ADListenerAdapter n;
    private volatile com.qq.e.ads.rewardvideo.ServerSideVerificationOptions o;

    public UnifiedBannerAD(android.app.Activity activity, com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView, java.lang.String str, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    public UnifiedBannerAD(android.app.Activity activity, com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView, java.lang.String str, java.lang.String str2, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener) {
        this.j = new java.util.concurrent.atomic.AtomicInteger(0);
        this.k = 30;
        this.l = null;
        this.i = unifiedBannerADListener;
        this.m = unifiedBannerView;
        this.n = new com.qq.e.ads.banner2.ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.m, (android.app.Activity) context, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(java.lang.Object obj) {
        com.qq.e.comm.pi.UBVI ubvi = (com.qq.e.comm.pi.UBVI) obj;
        int i = this.k;
        this.k = i;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).setRefresh(i);
        }
        com.qq.e.comm.constants.LoadAdParams loadAdParams = this.l;
        this.l = loadAdParams;
        T t2 = this.a;
        if (t2 != 0) {
            ((com.qq.e.comm.pi.UBVI) t2).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.o);
        while (this.j.getAndDecrement() > 0) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener = this.i;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void c(int i) {
        this.k = i;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).setRefresh(i);
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.j.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).onWindowFocusChanged(z);
        }
    }

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.l = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.n.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.o = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }
}
