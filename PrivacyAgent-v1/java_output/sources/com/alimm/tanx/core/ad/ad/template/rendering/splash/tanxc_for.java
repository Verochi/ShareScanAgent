package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public class tanxc_for extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do {
    private android.widget.LinearLayout tanxc_break;
    private volatile boolean tanxc_catch;
    protected com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil tanxc_this;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.component.AdAnimatableImageView tanxc_void;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "loadImg: onFailure");
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_do(com.alimm.tanx.core.ut.UtErrorCode.ERROR_IMG_LOAD.getIntCode(), str);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "loadImg: Success");
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_long.onResourceLoadSuccess();
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_void.setVisibility(0);
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_void.setImageBitmap(bitmap);
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_void.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_do.getImageConfig()));
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_for();
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_int();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.SplashWebInterface {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashWebCreate(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_long, 1);
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z) {
            if (z) {
                com.alimm.tanx.core.utils.LogUtils.d("utLog", "utViewDraw");
            } else {
                if (com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_catch) {
                    return;
                }
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_long, com.alimm.tanx.core.ut.UtErrorCode.CRASH_H5_ERROR);
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.this.tanxc_catch = true;
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.e("SplashAdImageRenderer", "webError: cmd :" + i + " msg:" + str);
        }
    }

    public tanxc_for(com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback, android.app.Activity activity, com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView, com.alimm.tanx.core.ad.ITanxAd iTanxAd, boolean z) {
        super(iRenderCallback, activity, tanxSplashAdView, iTanxAd, z);
        this.tanxc_catch = false;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
        if (tanxSplashAdView2 == null) {
            com.alimm.tanx.core.utils.LogUtils.e("SplashAdImageRenderer", "mAdRootView为空终止逻辑");
            return;
        }
        this.tanxc_void = (com.alimm.tanx.core.ad.ad.template.rendering.splash.component.AdAnimatableImageView) tanxSplashAdView2.findViewById(com.alimm.tanx.core.R.id.xadsdk_splash_ad_image_view);
        this.tanxc_break = (android.widget.LinearLayout) this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.ll_web_root);
        this.tanxc_void.setVisibility(4);
    }

    private void tanxc_class() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd == null || iTanxSplashExpressAd.getBidInfo() == null || this.tanxc_long.getBidInfo().getTemplateConf() == null || android.text.TextUtils.isEmpty(this.tanxc_long.getBidInfo().getTemplateConf().getPidStyleId()) || !this.tanxc_long.getBidInfo().getTemplateConf().getPidStyleId().equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_SPLASH_WEB_ID)) {
            return;
        }
        com.alimm.tanx.core.ut.impl.TanxCommonUt.utWebStartLoad(this.tanxc_long);
        com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil splashWebViewUtil = new com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil();
        this.tanxc_this = splashWebViewUtil;
        splashWebViewUtil.tanxc_do(this.tanxc_break, this.tanxc_long, this.tanxc_if, new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.AnonymousClass2());
    }

    private void tanxc_do(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "showAdView: imgUrl =" + str);
        if (android.text.TextUtils.isEmpty(str)) {
            tanxc_do(com.alimm.tanx.core.ut.UtErrorCode.ERROR_RS_INVALID.getIntCode());
            return;
        }
        if (com.alimm.tanx.core.image.ImageManager.getLoader() != null) {
            com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.tanxc_do).url(str).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.CENTER_CROP).build();
            com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.AnonymousClass1(build));
        } else {
            com.alimm.tanx.core.utils.LogUtils.e("SplashAdImageRenderer", "ImageManager.getLoader()为空");
            tanxc_do(com.alimm.tanx.core.ut.UtErrorCode.IMAGE_LOAD_NULL.getIntCode());
        }
        super.tanxc_catch();
        tanxc_class();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do
    public void tanxc_char() {
        super.tanxc_char();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do
    public void tanxc_if() {
        if (this.tanxc_for == null) {
            tanxc_do(com.alimm.tanx.core.ut.UtErrorCode.ERROR_NO_BID_INFO.getIntCode());
            return;
        }
        this.tanxc_try = android.os.SystemClock.elapsedRealtime();
        com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance();
        java.lang.String splashCacheFile = com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashCacheFile(this.tanxc_do, this.tanxc_for.getCreativeName());
        if (android.text.TextUtils.isEmpty(splashCacheFile) || !com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().isFileMd5Matched(this.tanxc_for, splashCacheFile)) {
            com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "no cache bitmap Or Md5 not match 校验广告素材，没有缓存路径或者md5验证不通过，走在线URL素材展示");
            splashCacheFile = this.tanxc_for.getCreativePath();
        } else {
            com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "有本地缓存的文件素材，走缓存文件曝光展示");
        }
        if (!android.text.TextUtils.isEmpty(splashCacheFile)) {
            tanxc_do(splashCacheFile);
        } else {
            com.alimm.tanx.core.utils.LogUtils.d("SplashAdImageRenderer", "do Start: 实时请求下来的广告素材的url为空，无法进行展示报错");
            tanxc_do(com.alimm.tanx.core.ut.UtErrorCode.ERROR_RS_INVALID.getIntCode());
        }
    }
}
