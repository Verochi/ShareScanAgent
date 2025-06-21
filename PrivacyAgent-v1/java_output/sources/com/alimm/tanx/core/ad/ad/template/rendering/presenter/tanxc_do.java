package com.alimm.tanx.core.ad.ad.template.rendering.presenter;

/* loaded from: classes.dex */
public abstract class tanxc_do<M extends com.alimm.tanx.core.ad.listener.model.IModel, T extends com.alimm.tanx.core.ad.ITanxAd, F extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd> implements com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter {
    protected android.content.Context tanxc_do;
    protected M tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<T> {
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            this.tanxc_do = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            this.tanxc_do.onError(tanxError);
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(java.util.List<T> list) {
            this.tanxc_do.onLoaded(com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.this.tanxc_do(list));
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            this.tanxc_do.onTimeOut();
        }
    }

    public tanxc_do(android.content.Context context, M m) {
        this.tanxc_do = context;
        this.tanxc_if = m;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter destroy() {
        return this;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
        return request(tanxAdSlot, onAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        if (onAdLoadListener == null) {
            return this;
        }
        this.tanxc_if.sendRequest(tanxAdSlot, new com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.AnonymousClass1(onAdLoadListener), j);
        return this;
    }

    public abstract F tanxc_do(T t);

    public java.util.List<F> tanxc_do(java.util.List<T> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(tanxc_do((com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<M, T, F>) it.next()));
        }
        return arrayList;
    }
}
