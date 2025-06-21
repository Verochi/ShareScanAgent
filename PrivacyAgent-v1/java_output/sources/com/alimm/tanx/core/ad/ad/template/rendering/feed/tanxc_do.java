package com.alimm.tanx.core.ad.ad.template.rendering.feed;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<com.alimm.tanx.core.ad.listener.model.IModel, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd, com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd> {
    private final com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_for tanxc_for;

    public tanxc_do(android.content.Context context, com.alimm.tanx.core.ad.listener.model.IModel iModel) {
        super(context, iModel);
        this.tanxc_for = new com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_for();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd tanxc_do(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
        return new com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if(this.tanxc_do, iTanxFeedAd, this.tanxc_for);
    }
}
