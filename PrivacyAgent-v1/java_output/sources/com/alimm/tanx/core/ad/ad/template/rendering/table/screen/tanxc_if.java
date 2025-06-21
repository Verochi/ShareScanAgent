package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

/* loaded from: classes.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd> implements com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd {
    public com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd tanxc_do;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_if;
    private com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam tanxc_int;

    public tanxc_if(com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd) {
        super(iTanxTableScreenAd);
        this.tanxc_do = iTanxTableScreenAd;
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

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        com.alimm.tanx.core.utils.LogUtils.d("TanxTableScreenExpressAd", "媒体调用destroy（）");
        super.destroy();
        this.tanxc_do = null;
        this.tanxc_if = null;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public /* synthetic */ android.view.View getAdView(android.app.Activity activity) {
        return tanxc_do();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return com.alimm.tanx.core.constant.TanxAdType.TABLE_SCREEN_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void setOnTableScreenAdListener(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener) {
        this.tanxc_if = onTableScreenAdListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void showAd(android.app.Activity activity) {
        showAd(activity, new com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam());
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam tableScreenParam) {
        showAd(activity, tableScreenParam, true);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam tableScreenParam, boolean z) {
        com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd = this.tanxc_do;
        if (iTanxTableScreenAd != null && iTanxTableScreenAd.getBidInfo() != null && this.tanxc_do.getBidInfo().getTemplateConf() != null && !android.text.TextUtils.isEmpty(this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId())) {
            com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd PidStyleId:", this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId());
            com.alimm.tanx.core.utils.LogUtils.d("TanxRewardExpressAd", "启动插屏广告");
            this.tanxc_int = tableScreenParam;
            tanxc_do(activity, com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.class, z);
            return;
        }
        com.alimm.tanx.core.request.TanxError tanxError = new com.alimm.tanx.core.request.TanxError("TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空");
        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener = this.tanxc_if;
        if (onTableScreenAdListener != null) {
            onTableScreenAdListener.onError(tanxError);
        }
        com.alimm.tanx.core.utils.LogUtils.e(tanxError);
    }

    public com.alimm.tanx.core.ad.view.TanxAdView tanxc_do() {
        return null;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_for() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView() {
        return null;
    }
}
