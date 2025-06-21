package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<com.alimm.tanx.core.ad.listener.model.IModel, com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd, com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> {
    public tanxc_do(android.content.Context context, com.alimm.tanx.core.ad.listener.model.IModel iModel) {
        super(context, iModel);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd tanxc_do(com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd) {
        return new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if(iTanxTableScreenAd);
    }

    public void tanxc_do(java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> list, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd iTanxTableScreenExpressAd = list.get(0);
                    if (iTanxTableScreenExpressAd == null || iTanxTableScreenExpressAd.getBidInfo() == null || iTanxTableScreenExpressAd.getBidInfo().getTemplateConf() == null || android.text.TextUtils.isEmpty(iTanxTableScreenExpressAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                        onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"));
                        return;
                    }
                    return;
                }
            } catch (java.lang.Exception e) {
                if (onAdLoadListener != null) {
                    onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("缓存try - catch异常: " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
                    return;
                }
                return;
            }
        }
        onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("RewardPresenter返回广告list为空"));
    }
}
