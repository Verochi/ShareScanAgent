package com.alimm.tanx.core.ad.listener.model;

/* loaded from: classes.dex */
public interface IModel {
    void cancel();

    void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener);

    void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j);
}
