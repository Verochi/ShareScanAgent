package com.alimm.tanx.ui.ad;

/* loaded from: classes.dex */
public interface ITanxSdkManager extends com.alimm.tanx.core.ad.ITanxCoreManager {
    com.alimm.tanx.core.ad.listener.ITanxAdLoader createAdLoader(android.content.Context context);

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    com.alimm.tanx.core.ad.loader.ITanxRequestLoader createRequestLoader(android.content.Context context);

    com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest createRewardRequest(android.content.Context context);
}
