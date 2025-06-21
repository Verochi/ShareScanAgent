package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public class NativeExpressAD extends com.qq.e.ads.NativeAbstractAD<com.qq.e.comm.pi.NEADI> implements com.qq.e.comm.pi.IReward {
    private volatile int h;
    private volatile int i;
    private java.util.List<java.lang.Integer> j = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private com.qq.e.ads.cfg.VideoOption k;
    private com.qq.e.ads.nativ.ADSize l;
    private com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener m;
    private final com.qq.e.ads.nativ.NativeExpressAD.ADListenerAdapter n;
    private com.qq.e.comm.constants.LoadAdParams o;
    private volatile com.qq.e.ads.rewardvideo.ServerSideVerificationOptions p;

    public static class ADListenerAdapter implements com.qq.e.comm.adevent.ADListener {
        private com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener a;
        private com.qq.e.ads.nativ.NativeExpressMediaListener b;
        private com.qq.e.comm.listeners.NegativeFeedbackListener c;
        private com.qq.e.comm.listeners.ADRewardListener d;

        public ADListenerAdapter(com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener nativeExpressADListener) {
            this.a = nativeExpressADListener;
        }

        public ADListenerAdapter(com.qq.e.ads.nativ.NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
            if (com.qq.e.ads.nativ.NativeExpressAD.a(this.a, aDEvent) || com.qq.e.ads.nativ.NativeExpressAD.a(this.b, aDEvent) || com.qq.e.ads.nativ.NativeExpressAD.a(this.c, aDEvent)) {
                return;
            }
            com.qq.e.ads.nativ.NativeExpressAD.a(this.d, aDEvent);
        }

        public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
            this.d = aDRewardListener;
        }

        public void setMediaListener(com.qq.e.ads.nativ.NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
            this.c = negativeFeedbackListener;
        }
    }

    public interface NativeExpressADListener extends com.qq.e.ads.NativeAbstractAD.BasicADListener {
        void onADClicked(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

        void onADClosed(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

        void onADExposure(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

        void onADLeftApplication(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

        void onADLoaded(java.util.List<com.qq.e.ads.nativ.NativeExpressADView> list);

        void onRenderFail(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

        void onRenderSuccess(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(android.content.Context context, com.qq.e.ads.nativ.ADSize aDSize, java.lang.String str, com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener nativeExpressADListener) {
        this.m = nativeExpressADListener;
        this.n = new com.qq.e.ads.nativ.NativeExpressAD.ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(android.content.Context context, com.qq.e.ads.nativ.ADSize aDSize, java.lang.String str, com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener nativeExpressADListener, java.lang.String str2) {
        this.m = nativeExpressADListener;
        this.n = new com.qq.e.ads.nativ.NativeExpressAD.ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean a(com.qq.e.ads.nativ.ADSize aDSize) {
        if (aDSize != null) {
            this.l = aDSize;
            return false;
        }
        com.qq.e.comm.util.GDTLogger.e("初始化错误：参数adSize不能为空");
        a(2001);
        return true;
    }

    public static boolean a(com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener nativeExpressADListener, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                java.util.List<com.qq.e.ads.nativ.NativeExpressADView> list = (java.util.List) aDEvent.getParam(java.util.List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView2 = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView3 = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView4 = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView5 = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView6 = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    public static boolean a(com.qq.e.ads.nativ.NativeExpressMediaListener nativeExpressMediaListener, com.qq.e.comm.adevent.ADEvent aDEvent) {
        com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (com.qq.e.ads.nativ.NativeExpressADView) aDEvent.getParam(com.qq.e.ads.nativ.NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(1, java.lang.Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case com.qq.e.comm.adevent.AdEventType.VIDEO_INIT /* 209 */:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    break;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_READY /* 210 */:
                    if (((java.lang.Integer) aDEvent.getParam(1, java.lang.Integer.class)) != null) {
                        nativeExpressMediaListener.onVideoReady(nativeExpressADView, r6.intValue());
                        break;
                    }
                    break;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING /* 211 */:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    break;
            }
            return true;
        }
        return false;
    }

    public static boolean a(com.qq.e.comm.listeners.ADRewardListener aDRewardListener, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        java.lang.String str = (java.lang.String) aDEvent.getParam(java.lang.String.class);
        if (str != null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("transId", str);
            aDRewardListener.onReward(hashMap);
        }
        return true;
    }

    public static boolean a(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.l, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(java.lang.Object obj) {
        com.qq.e.comm.pi.NEADI neadi = (com.qq.e.comm.pi.NEADI) obj;
        neadi.setMinVideoDuration(this.h);
        neadi.setMaxVideoDuration(this.i);
        ((com.qq.e.comm.pi.NEADI) this.a).setServerSideVerificationOptions(this.p);
        com.qq.e.ads.cfg.VideoOption videoOption = this.k;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.j) {
            java.util.Iterator<java.lang.Integer> it = this.j.iterator();
            while (it.hasNext()) {
                T t = this.a;
                if (t != 0) {
                    if (this.o != null) {
                        ((com.qq.e.comm.pi.NEADI) t).loadAd(it.next().intValue(), this.o);
                    } else {
                        ((com.qq.e.comm.pi.NEADI) t).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener nativeExpressADListener = this.m;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.NEADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.j) {
                    this.j.add(java.lang.Integer.valueOf(i));
                }
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            com.qq.e.comm.constants.LoadAdParams loadAdParams2 = this.o;
            com.qq.e.comm.pi.NEADI neadi = (com.qq.e.comm.pi.NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        }
    }

    public void setAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.o = loadAdParams;
    }

    public void setMaxVideoDuration(int i) {
        this.i = i;
        if (this.i > 0 && this.h > this.i) {
            com.qq.e.comm.util.GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NEADI) t).setMaxVideoDuration(this.i);
        }
    }

    public void setMinVideoDuration(int i) {
        this.h = i;
        if (this.i > 0 && this.h > this.i) {
            com.qq.e.comm.util.GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NEADI) t).setMinVideoDuration(this.h);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(com.qq.e.ads.cfg.VideoOption videoOption) {
        this.k = videoOption;
        T t = this.a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((com.qq.e.comm.pi.NEADI) t).setVideoOption(videoOption);
    }
}
