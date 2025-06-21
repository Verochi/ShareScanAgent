package com.qq.e.ads.rewardvideo;

/* loaded from: classes19.dex */
public class RewardVideoAD extends com.qq.e.ads.LiteAbstractAD<com.qq.e.comm.pi.RVADI> implements com.qq.e.comm.pi.NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    private final com.qq.e.ads.rewardvideo.RewardVideoADListener i;
    private volatile boolean j;
    private com.qq.e.comm.constants.LoadAdParams k;
    private com.qq.e.ads.rewardvideo.ServerSideVerificationOptions l;
    private final boolean m;
    private final com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter n;

    public static class ADListenerAdapter implements com.qq.e.comm.adevent.ADListener {
        private com.qq.e.comm.listeners.NegativeFeedbackListener a;
        public com.qq.e.ads.rewardvideo.RewardVideoADListener adListener;

        public ADListenerAdapter(com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public static void a(com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter aDListenerAdapter, com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener = this.a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    break;
                case 103:
                    this.adListener.onADExpose();
                    break;
                case 104:
                    java.lang.String str = (java.lang.String) aDEvent.getParam(java.lang.String.class);
                    if (str != null) {
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put("transId", str);
                        java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(1, java.lang.Integer.class);
                        if (num != null) {
                            hashMap.put(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.ACTION, num);
                        }
                        this.adListener.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    this.adListener.onADClick();
                    break;
                case 106:
                    this.adListener.onADClose();
                    break;
                case 107:
                    java.lang.Integer num2 = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                    if (num2 != null) {
                        this.adListener.onError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num2.intValue()));
                        break;
                    }
                    break;
            }
        }
    }

    public RewardVideoAD(android.content.Context context, java.lang.String str, com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(android.content.Context context, java.lang.String str, com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener, boolean z) {
        this(rewardVideoADListener, z);
        a(context, str);
    }

    public RewardVideoAD(android.content.Context context, java.lang.String str, com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener, boolean z, java.lang.String str2) {
        this(rewardVideoADListener, z);
        a(context, str, str2);
    }

    private RewardVideoAD(com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener, boolean z) {
        this.k = null;
        this.m = z;
        this.i = rewardVideoADListener;
        this.n = new com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(java.lang.Object obj) {
        com.qq.e.comm.pi.RVADI rvadi = (com.qq.e.comm.pi.RVADI) obj;
        rvadi.setVolumeOn(this.m);
        rvadi.setLoadAdParams(this.k);
        rvadi.setServerSideVerificationOptions(this.l);
        if (this.j) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.rewardvideo.RewardVideoADListener rewardVideoADListener = this.i;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.RVADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.RVADI) t).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.RVADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.RVADI) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.j = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.k = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.a(this.n, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.l = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.RVADI) t).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(android.app.Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.RVADI) t).showAD(activity);
        } else {
            a("showAD");
        }
    }
}
