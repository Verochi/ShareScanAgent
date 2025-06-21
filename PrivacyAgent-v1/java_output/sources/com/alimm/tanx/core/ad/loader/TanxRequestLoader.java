package com.alimm.tanx.core.ad.loader;

/* loaded from: classes.dex */
public class TanxRequestLoader implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader, com.alimm.tanx.core.utils.NotConfused {
    private boolean requestFilter() {
        return false;
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends com.alimm.tanx.core.ad.ITanxAd> void biddingResult(java.util.List<T> list, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener<T> onBiddingListener) {
        if (onBiddingListener != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (list != null) {
                for (T t : list) {
                    if (t.getBiddingInfo() != null && t.getBiddingInfo().isBidResult()) {
                        arrayList.add(t);
                    }
                }
            }
            onBiddingListener.onResult(arrayList);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.biddingResult(list);
            com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do.tanxc_do().tanxc_do(arrayList);
        }
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public void request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        request(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends com.alimm.tanx.core.ad.ITanxAd> void request(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener, long j) {
        if (requestFilter()) {
            return;
        }
        tanxAdSlot.addAdSlot(2);
        new com.alimm.tanx.core.ad.ad.feed.FeedAdModel().sendRequest(tanxAdSlot, iTanxRequestListener, j);
    }
}
