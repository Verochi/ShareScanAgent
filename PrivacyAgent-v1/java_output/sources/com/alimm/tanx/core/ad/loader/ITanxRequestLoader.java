package com.alimm.tanx.core.ad.loader;

/* loaded from: classes.dex */
public interface ITanxRequestLoader {

    public interface ITanxRequestListener<T extends com.alimm.tanx.core.ad.ITanxAd> {
        void onError(com.alimm.tanx.core.request.TanxError tanxError);

        void onSuccess(java.util.List<T> list);

        void onTimeOut();
    }

    public interface OnBiddingListener<T extends com.alimm.tanx.core.ad.ITanxAd> {
        void onResult(java.util.List<T> list);
    }

    <T extends com.alimm.tanx.core.ad.ITanxAd> void biddingResult(java.util.List<T> list, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener<T> onBiddingListener);

    <T extends com.alimm.tanx.core.ad.ITanxAd> void request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener);

    <T extends com.alimm.tanx.core.ad.ITanxAd> void request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener, long j);
}
