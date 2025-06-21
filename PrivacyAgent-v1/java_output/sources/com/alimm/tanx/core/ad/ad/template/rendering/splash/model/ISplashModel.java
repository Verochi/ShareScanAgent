package com.alimm.tanx.core.ad.ad.template.rendering.splash.model;

/* loaded from: classes.dex */
public interface ISplashModel extends com.alimm.tanx.core.ad.listener.model.IModel {
    void sendRequest(boolean z, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener);

    void sendRequest(boolean z, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j);
}
