package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class TanxSdkManager extends com.alimm.tanx.core.TanxCoreManager implements com.alimm.tanx.ui.ad.ITanxSdkManager {

    public static class SingletonHolder implements com.alimm.tanx.core.utils.NotConfused {
        static final com.alimm.tanx.ui.TanxSdkManager INSTANCE = new com.alimm.tanx.ui.TanxSdkManager();

        private SingletonHolder() {
        }
    }

    public static com.alimm.tanx.ui.TanxSdkManager getInstance() {
        return com.alimm.tanx.ui.TanxSdkManager.SingletonHolder.INSTANCE;
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public com.alimm.tanx.core.ad.listener.ITanxAdLoader createAdLoader(android.content.Context context) {
        return new com.alimm.tanx.core.ad.loader.NewTanxAdLoader(context);
    }

    @Override // com.alimm.tanx.core.TanxCoreManager, com.alimm.tanx.core.ad.ITanxCoreManager
    public com.alimm.tanx.core.ad.loader.ITanxRequestLoader createRequestLoader(android.content.Context context) {
        return new com.alimm.tanx.core.ad.loader.TanxRequestLoader();
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest createRewardRequest(android.content.Context context) {
        return new com.alimm.tanx.core.ad.listener.reward.TanxRewardRequest();
    }
}
