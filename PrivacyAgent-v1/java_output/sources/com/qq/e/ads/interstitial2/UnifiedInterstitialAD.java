package com.qq.e.ads.interstitial2;

/* loaded from: classes19.dex */
public class UnifiedInterstitialAD extends com.qq.e.ads.LiteAbstractAD<com.qq.e.comm.pi.UIADI> implements com.qq.e.comm.pi.NFBI, com.qq.e.comm.pi.IReward {
    private java.util.concurrent.atomic.AtomicInteger i;
    private java.util.concurrent.atomic.AtomicInteger j;
    private volatile com.qq.e.ads.cfg.VideoOption k;
    private volatile int l;
    private volatile int m;
    private volatile com.qq.e.comm.constants.LoadAdParams n;
    private com.qq.e.ads.interstitial2.UnifiedInterstitialADListener o;
    private com.qq.e.ads.rewardvideo.ServerSideVerificationOptions p;
    private final com.qq.e.ads.interstitial2.ADListenerAdapter q;

    public UnifiedInterstitialAD(android.app.Activity activity, java.lang.String str, com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(android.app.Activity activity, java.lang.String str, com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener, java.util.Map map) {
        this.i = new java.util.concurrent.atomic.AtomicInteger(0);
        this.j = new java.util.concurrent.atomic.AtomicInteger(0);
        this.o = unifiedInterstitialADListener;
        this.q = new com.qq.e.ads.interstitial2.ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(android.app.Activity activity, java.lang.String str, com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener, java.util.Map map, java.lang.String str2) {
        this.i = new java.util.concurrent.atomic.AtomicInteger(0);
        this.j = new java.util.concurrent.atomic.AtomicInteger(0);
        this.o = unifiedInterstitialADListener;
        this.q = new com.qq.e.ads.interstitial2.ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((android.app.Activity) context, str, str2, str3, this.q);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(java.lang.Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.interstitial2.UnifiedInterstitialADListener unifiedInterstitialADListener = this.o;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void c() {
        setVideoOption(this.k);
        setMinVideoDuration(this.l);
        setMaxVideoDuration(this.m);
        setLoadAdParams(this.n);
        setServerSideVerificationOptions(this.p);
        while (this.i.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.j.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.i.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.j.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.n = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).setLoadAdParams(this.n);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.m = i;
        if (this.m > 0 && this.l > this.m) {
            com.qq.e.comm.util.GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.q.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i) {
        this.l = i;
        if (this.m > 0 && this.l > this.m) {
            com.qq.e.comm.util.GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).setMinVideoDuration(i);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.q.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.q.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(com.qq.e.ads.cfg.VideoOption videoOption) {
        this.k = videoOption;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).show();
        } else {
            a("show");
        }
    }

    public void show(android.app.Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).show(activity);
        } else {
            a("show");
        }
    }

    public void showFullScreenAD(android.app.Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
