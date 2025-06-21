package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_new extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd> implements com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd {
    public com.alimm.tanx.core.ad.ad.reward.model.VideoParam tanxc_do;
    public com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd tanxc_if;
    private java.lang.String tanxc_int;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd.OnRewardAdListener tanxc_new;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z, boolean z2) {
            int i;
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_int, "触发前后台切换的查奖链路，nowBackground/secondUp：" + z + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + z2);
            if (z2) {
                if (com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.getBidInfo() == null || com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.getBidInfo().getTemplateConf() == null || com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode() != 1) {
                    try {
                        i = com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode();
                    } catch (java.lang.Exception e) {
                        com.alimm.tanx.core.utils.LogUtils.e(e);
                        i = -1;
                    }
                    com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_int, "appVisibleCallBack:当前不是客户端发奖，rewardMode:" + i);
                    return;
                }
                if (!com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_new() || com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if == null || android.text.TextUtils.isEmpty(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if.tanxc_if)) {
                    return;
                }
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_int, "自动查询奖励开始：" + com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if.toString());
                com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if.tanxc_do, com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if.tanxc_int, 1, null);
                com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_new != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_new.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener
        public void onRewardArrived(boolean z, int i, java.util.Map<java.lang.String, java.lang.Object> map) {
            java.lang.String str = "";
            if (map != null) {
                try {
                    str = ((((("\n pid:") + map.get("pid")) + "\n sessionId:") + map.get("sessionId")) + "\n completeTime:") + map.get("completeTime");
                } catch (java.lang.Exception e) {
                    com.alimm.tanx.core.utils.LogUtils.e(e);
                }
            }
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_int, "查询奖励成功，本次奖励信息为：" + str);
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_new != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.this.tanxc_new.onRewardArrived(z, i, map);
            }
        }
    }

    public tanxc_new(com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
        super(iTanxRewardVideoAd);
        this.tanxc_int = "TanxRewardExpressAd";
        this.tanxc_if = iTanxRewardVideoAd;
    }

    private void tanxc_do(android.content.Context context, java.lang.Class<?> cls, boolean z) {
        com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.put(getRequestId(), this);
        android.content.Intent intent = new android.content.Intent(context, cls);
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("REQ_ID", getRequestId());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.bean.RewardParam rewardParam, java.lang.Integer num, java.lang.String str3) {
        new com.alimm.tanx.core.ad.listener.reward.TanxRewardRequest().queryRewards(new com.alimm.tanx.core.ad.bean.RewardRequestBean().build(str, str2, rewardParam), num, str3, new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.AnonymousClass2());
    }

    private void tanxc_int() {
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().register(this.tanxc_int, new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tanxc_new() {
        if (getAdSlot() != null && getAdSlot().getRewardParam() != null && getAdSlot().getRewardParam().isAutoQuerySwitch()) {
            return true;
        }
        com.alimm.tanx.core.utils.LogUtils.d(this.tanxc_int, "自动查询奖励关闭");
        return false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().unRegister(this.tanxc_int);
        com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd", "媒体调用destroy（）");
        this.tanxc_new = null;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public /* synthetic */ android.view.View getAdView(android.app.Activity activity) {
        return tanxc_do();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return "rewardVideo";
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void setOnRewardAdListener(com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener) {
        this.tanxc_new = onRewardAdListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(android.app.Activity activity) {
        showAd(activity, new com.alimm.tanx.core.ad.ad.reward.model.VideoParam());
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam) {
        showAd(activity, videoParam, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        if (r0.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_ORDER_REWARD_ID) == false) goto L18;
     */
    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam, boolean z) {
        com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd = this.tanxc_if;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.tanxc_if.getBidInfo().getTemplateConf() == null || android.text.TextUtils.isEmpty(this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId())) {
            com.alimm.tanx.core.request.TanxError tanxError = new com.alimm.tanx.core.request.TanxError("TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener = this.tanxc_new;
            if (onRewardAdListener != null) {
                onRewardAdListener.onError(tanxError);
            }
            com.alimm.tanx.core.utils.LogUtils.e(tanxError);
            return;
        }
        char c = 2;
        if (tanxc_new() && getAdSlot().getRewardParam().isQueryHistoryRewards()) {
            tanxc_do(getAdSlot().getMediaUid(), getAdSlot().getPid(), getAdSlot().getRewardParam(), 2, getBidInfo().getSessionId());
        }
        com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd PidStyleId:", this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId());
        java.lang.String pidStyleId = this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId();
        pidStyleId.hashCode();
        switch (pidStyleId.hashCode()) {
            case 1448635041:
                if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_REWARD_VIDEO_ID)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1448635042:
                if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_REWARD_ID)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1448635076:
                break;
            case 1448635077:
                if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_NEW_REWARD_ID)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1448635103:
                if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_OPEN_TAO_BAO_REWARD_ID)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd", "启动激励视频");
                this.tanxc_do = videoParam;
                tanxc_do(activity, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.class, z);
                break;
            case 1:
                com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd", "启动激励浏览");
                tanxc_do(activity, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.class, z);
                break;
            case 2:
            case 3:
            case 4:
                com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd", "启动淘宝浏览");
                if (!new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for(this).tanxc_do(activity)) {
                    tanxc_do(activity, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.class, z);
                    break;
                } else {
                    tanxc_int();
                    break;
                }
        }
    }

    public com.alimm.tanx.core.ad.view.TanxAdView tanxc_do() {
        return null;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd.OnRewardAdListener tanxc_for() {
        return this.tanxc_new;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView() {
        return null;
    }
}
