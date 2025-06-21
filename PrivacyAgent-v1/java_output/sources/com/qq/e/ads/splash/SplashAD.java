package com.qq.e.ads.splash;

/* loaded from: classes19.dex */
public final class SplashAD extends com.qq.e.ads.LiteAbstractAD<com.qq.e.comm.pi.NSPVI> implements com.qq.e.comm.pi.IReward {
    private volatile android.view.ViewGroup i;
    private volatile com.qq.e.ads.splash.SplashADListener j;
    private volatile com.qq.e.comm.listeners.ADRewardListener k;
    private volatile com.qq.e.comm.constants.LoadAdParams l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile int p;
    private volatile byte[] q;
    private volatile com.qq.e.ads.rewardvideo.ServerSideVerificationOptions r;

    /* renamed from: s, reason: collision with root package name */
    private int f424s;

    public class ADListenerAdapter implements com.qq.e.comm.adevent.ADListener {
        private ADListenerAdapter() {
        }

        public /* synthetic */ ADListenerAdapter(com.qq.e.ads.splash.SplashAD splashAD, com.qq.e.ads.splash.SplashAD.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
            java.lang.String str;
            if (com.qq.e.ads.splash.SplashAD.this.j == null) {
                com.qq.e.comm.util.GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                java.lang.Long l = (java.lang.Long) aDEvent.getParam(java.lang.Long.class);
                if (l != null) {
                    com.qq.e.ads.splash.SplashAD.this.j.onADTick(l.longValue());
                }
                return;
            }
            switch (type) {
                case 100:
                    java.lang.Long l2 = (java.lang.Long) aDEvent.getParam(java.lang.Long.class);
                    if (l2 != null) {
                        com.qq.e.ads.splash.SplashAD.this.j.onADLoaded(l2.longValue());
                        break;
                    }
                    break;
                case 101:
                    java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                    if (num != null) {
                        com.qq.e.ads.splash.SplashAD.this.j.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
                        break;
                    }
                    break;
                case 102:
                    com.qq.e.ads.splash.SplashAD.this.j.onADPresent();
                    break;
                case 103:
                    com.qq.e.ads.splash.SplashAD.this.j.onADExposure();
                    break;
                case 104:
                    if (com.qq.e.ads.splash.SplashAD.this.k != null && (str = (java.lang.String) aDEvent.getParam(java.lang.String.class)) != null) {
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put("transId", str);
                        com.qq.e.ads.splash.SplashAD.this.k.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    com.qq.e.ads.splash.SplashAD.this.j.onADClicked();
                    break;
                case 106:
                    com.qq.e.ads.splash.SplashAD.this.j.onADDismissed();
                    break;
            }
        }
    }

    public SplashAD(android.content.Context context, java.lang.String str, com.qq.e.ads.splash.SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(android.content.Context context, java.lang.String str, com.qq.e.ads.splash.SplashADListener splashADListener, int i) {
        this.m = false;
        this.j = splashADListener;
        this.f424s = i;
        a(context, str);
    }

    public SplashAD(android.content.Context context, java.lang.String str, com.qq.e.ads.splash.SplashADListener splashADListener, int i, java.lang.String str2) {
        this.m = false;
        this.j = splashADListener;
        this.f424s = i;
        a(context, str, str2);
    }

    private void a(android.view.ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            com.qq.e.comm.util.GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.o = z;
            this.i = viewGroup;
            return;
        }
        com.qq.e.comm.pi.NSPVI nspvi = (com.qq.e.comm.pi.NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z) {
        if (a()) {
            if (!b()) {
                this.o = z;
                this.n = true;
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            com.qq.e.comm.pi.NSPVI nspvi = (com.qq.e.comm.pi.NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(android.view.ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            com.qq.e.comm.util.GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.i = viewGroup;
            return;
        }
        com.qq.e.comm.pi.NSPVI nspvi = (com.qq.e.comm.pi.NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(java.lang.Object obj) {
        com.qq.e.comm.pi.NSPVI nspvi = (com.qq.e.comm.pi.NSPVI) obj;
        if (this.l != null) {
            nspvi.setLoadAdParams(this.l);
        }
        if (this.p != 0) {
            nspvi.setDeveloperLogo(this.p);
        }
        if (this.q != null) {
            nspvi.setDeveloperLogo(this.q);
        }
        nspvi.setFetchDelay(this.f424s);
        nspvi.setAdListener(new com.qq.e.ads.splash.SplashAD.ADListenerAdapter(this, null));
        nspvi.setServerSideVerificationOptions(this.r);
        if (this.i != null) {
            if (this.o) {
                a(this.i, true);
            } else {
                a(this.i, false);
            }
        }
        if (this.m) {
            nspvi.preload();
            this.m = false;
        }
        if (this.n) {
            if (this.o) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.n = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        if (this.j != null) {
            this.j.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @java.lang.Deprecated
    public android.graphics.Bitmap getZoomOutBitmap() {
        com.qq.e.comm.util.GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.m = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @java.lang.Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.a;
        if (t == 0) {
            this.p = i;
        } else {
            ((com.qq.e.comm.pi.NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.a;
        if (t == 0) {
            this.q = bArr;
        } else {
            ((com.qq.e.comm.pi.NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.l = loadAdParams;
        }
    }

    @java.lang.Deprecated
    public void setPreloadView(android.view.View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.k = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.r = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(android.view.ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(android.view.ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    @java.lang.Deprecated
    public void zoomOutAnimationFinish() {
        com.qq.e.comm.util.GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }
}
