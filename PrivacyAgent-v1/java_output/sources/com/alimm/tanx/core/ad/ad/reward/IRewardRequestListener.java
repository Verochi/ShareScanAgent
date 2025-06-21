package com.alimm.tanx.core.ad.ad.reward;

/* loaded from: classes.dex */
public interface IRewardRequestListener {
    void onError(com.alimm.tanx.core.request.TanxError tanxError);

    void onRewardArrived(boolean z, int i, java.util.Map<java.lang.String, java.lang.Object> map);
}
