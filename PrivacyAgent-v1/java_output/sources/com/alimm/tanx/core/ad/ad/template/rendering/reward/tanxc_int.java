package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<com.alimm.tanx.core.ad.listener.model.IModel, com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd, com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> {

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.view.player.cache.videocache.PreloadListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd tanxc_do;
        final /* synthetic */ java.util.List tanxc_for;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd iTanxRewardExpressAd, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener, java.util.List list) {
            this.tanxc_do = iTanxRewardExpressAd;
            this.tanxc_if = onRewardAdLoadListener;
            this.tanxc_for = list;
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onCached(java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("video_cache", "缓存完成");
            com.alimm.tanx.core.ut.impl.TanxCommonUt.cacheCheck(this.tanxc_do, str, 0, null);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener = this.tanxc_if;
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onRewardVideoCached((com.alimm.tanx.core.ad.listener.INewTanxExpressAd) this.tanxc_for.get(0));
            }
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onError(java.lang.String str, java.lang.Exception exc) {
            com.alimm.tanx.core.utils.LogUtils.e("video_cache", "缓存异常");
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener = this.tanxc_if;
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("缓存异常: " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc)));
            }
            com.alimm.tanx.core.ut.impl.TanxCommonUt.cacheCheck(this.tanxc_do, str, 1, exc);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode((com.alimm.tanx.core.ad.ITanxAd) this.tanxc_for.get(0), com.alimm.tanx.core.ut.UtErrorCode.VIDEO_DOWNLOAD_ERROR);
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onStartCached(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
            if (iTanxAd == null || iTanxAd.getAdSlot() == null) {
                return;
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(iTanxAd.getAdSlot().getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REWARD_VIDEO_START_CACHE);
        }
    }

    public tanxc_int(android.content.Context context, com.alimm.tanx.core.ad.listener.model.IModel iModel) {
        super(context, iModel);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd tanxc_do(com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
        return new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new(iTanxRewardVideoAd);
    }

    public void tanxc_do(java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> list, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener) {
        char c;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd iTanxRewardExpressAd = list.get(0);
                    if (iTanxRewardExpressAd != null && iTanxRewardExpressAd.getBidInfo() != null && iTanxRewardExpressAd.getBidInfo().getTemplateConf() != null && !android.text.TextUtils.isEmpty(iTanxRewardExpressAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                        java.lang.String pidStyleId = iTanxRewardExpressAd.getBidInfo().getTemplateConf().getPidStyleId();
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
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            com.alimm.tanx.core.utils.VideoCacheManager.getInstance().preload((com.alimm.tanx.core.ad.ITanxAd) list.get(0), false, (com.alimm.tanx.core.view.player.cache.videocache.PreloadListener) new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int.AnonymousClass1(iTanxRewardExpressAd, onRewardAdLoadListener, list));
                            return;
                        } else {
                            if (c != 1) {
                                return;
                            }
                            com.alimm.tanx.core.utils.LogUtils.d("video_cache", "不是激励视频广告，不需要缓存，直接回调媒体");
                            if (onRewardAdLoadListener != null) {
                                onRewardAdLoadListener.onRewardVideoCached(list.get(0));
                                return;
                            }
                            return;
                        }
                    }
                    onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"));
                    return;
                }
            } catch (java.lang.Exception e) {
                if (onRewardAdLoadListener != null) {
                    onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("缓存try - catch异常: " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
                    return;
                }
                return;
            }
        }
        onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("RewardPresenter返回广告list为空"));
    }
}
