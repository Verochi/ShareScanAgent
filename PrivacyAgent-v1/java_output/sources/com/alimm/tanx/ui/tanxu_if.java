package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class tanxu_if {

    /* renamed from: tanxu_do, reason: collision with root package name */
    private com.alimm.tanx.core.config.TanxConfig f80tanxu_do;

    public com.alimm.tanx.core.config.TanxConfig tanxu_do() {
        return this.f80tanxu_do;
    }

    public void tanxu_do(android.app.Application application, com.alimm.tanx.core.config.TanxConfig tanxConfig) {
        this.f80tanxu_do = tanxConfig;
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("initImageLoader");
        tanxu_do2.append(com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean().imageSwitch.toString());
        com.alimm.tanx.core.utils.LogUtils.d("ImageManager init", tanxu_do2.toString());
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getAllAppImageSwitch() || com.alimm.tanx.core.orange.OrangeManager.getInstance().getImageSwitch(this.f80tanxu_do.getAppKey())) {
            com.alimm.tanx.core.utils.LogUtils.d("ImageManager init", "命中appkey重新设置GlideSourceCodeImageLoader");
            com.alimm.tanx.core.image.ImageManager.setLoader(new com.alimm.tanx.ui.image.GlideSourceCodeImageLoader());
        }
    }

    public com.alimm.tanx.ui.ad.ITanxSdkManager tanxu_if() {
        return com.alimm.tanx.ui.TanxSdkManager.getInstance();
    }
}
