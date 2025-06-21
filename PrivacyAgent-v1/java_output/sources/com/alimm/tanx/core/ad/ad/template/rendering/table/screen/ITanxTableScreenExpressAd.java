package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

/* loaded from: classes.dex */
public interface ITanxTableScreenExpressAd extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd {

    public interface OnTableScreenAdListener extends com.alimm.tanx.core.ad.listener.ITanxInteractionListener {
        void onAdClose();

        void onAdShake();

        void onError(com.alimm.tanx.core.request.TanxError tanxError);
    }

    void setOnTableScreenAdListener(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener);

    void showAd(android.app.Activity activity);

    void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam tableScreenParam);

    void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam tableScreenParam, boolean z);
}
