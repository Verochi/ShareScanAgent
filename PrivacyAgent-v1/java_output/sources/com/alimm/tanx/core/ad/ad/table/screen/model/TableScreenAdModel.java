package com.alimm.tanx.core.ad.ad.table.screen.model;

/* loaded from: classes.dex */
public class TableScreenAdModel extends com.alimm.tanx.core.ad.model.BaseModel {

    /* renamed from: com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenAdModel$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener tanxc_for;
        final /* synthetic */ long tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, long j, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            this.tanxc_do = tanxAdSlot;
            this.tanxc_if = j;
            this.tanxc_for = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_TABLE_SCREEN, "error", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(java.util.List list) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_TABLE_SCREEN, "success", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onSuccess(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_TABLE_SCREEN, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onTimeOut();
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public java.lang.String getScene() {
        return com.alimm.tanx.core.constant.TanxAdType.TABLE_SCREEN_STRING;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && !android.text.TextUtils.isEmpty(adInfo.getRequestId()) && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                    java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        java.util.Iterator<com.alimm.tanx.core.ad.bean.BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new com.alimm.tanx.core.ad.ad.table.screen.tanxc_do(this.adSlot, it.next(), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
                this.requestListener.onSuccess(arrayList);
                return;
            }
        }
        this.requestListener.onError(new com.alimm.tanx.core.request.TanxError(adInfo != null ? adInfo.getRequestId() : "", com.alimm.tanx.core.request.TanxError.ERROR_ADINFO_ADCOUNT_NULL));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_TABLE_SCREEN);
        super.sendRequest(tanxAdSlot, new com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenAdModel.AnonymousClass1(tanxAdSlot, currentTimeMillis, iTanxRequestListener), j);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo adInfo, boolean z, int i) {
        com.alimm.tanx.core.ad.ad.table.screen.tanxc_do tanxc_doVar = null;
        r0 = null;
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxc_doVar = new com.alimm.tanx.core.ad.ad.table.screen.tanxc_do(this.adSlot, bidInfo, adInfo.getRequestId(), getScene());
        }
        com.alimm.tanx.core.ut.impl.TanxCommonUt.utTimer(tanxc_doVar, z, i);
    }
}
