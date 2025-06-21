package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class TanxThirdInstanceDefault implements com.alimm.tanx.core.utils.NotConfused {
    public com.alimm.tanx.core.TanxCoreInstanceConfig build() {
        com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig = com.alimm.tanx.core.TanxCoreInstanceConfig.getInstance();
        tanxCoreInstanceConfig.setSplashModel(new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel());
        tanxCoreInstanceConfig.setNetWork(new com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl());
        tanxCoreInstanceConfig.setTanxUserTracker(new com.alimm.tanx.ui.tanxu_for(this));
        tanxCoreInstanceConfig.setTanxPlayer(new com.alimm.tanx.core.view.player.core.TanxPlayer());
        tanxCoreInstanceConfig.setImageLoader(new com.alimm.tanx.ui.image.GlideSourceCodeImageLoader());
        return tanxCoreInstanceConfig;
    }
}
