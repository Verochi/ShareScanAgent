package com.alimm.tanx.core.ad.ad.template.rendering.presenter;

/* loaded from: classes.dex */
public interface IPresenter<F extends com.alimm.tanx.core.ad.ITanxAd> {
    com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter destroy();

    com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener);

    com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j);
}
