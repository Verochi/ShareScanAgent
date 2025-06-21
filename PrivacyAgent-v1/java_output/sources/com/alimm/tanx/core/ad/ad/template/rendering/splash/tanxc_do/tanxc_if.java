package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do {
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener tanxc_long;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if.this.tanxc_goto.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ android.widget.ImageView tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_if;

        public AnonymousClass2(android.widget.ImageView imageView, com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageView;
            this.tanxc_if = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("DefaultTemplate", "loadImg: onFailure");
            this.tanxc_do.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.utils.LogUtils.d("DefaultTemplate", "loadImg: Success");
            this.tanxc_do.setImageBitmap(bitmap);
            this.tanxc_do.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_if.getImageConfig()));
        }
    }

    public tanxc_if(@androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        super(tanxc_doVar, context, viewGroup, iTanxAd);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_byte() {
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo;
        super.tanxc_byte();
        android.view.View findViewById = this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.splash_ad_click_message_container_ex);
        this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.splash_ad_count_and_skip_container_ex);
        if (this.tanxc_for != null && this.tanxc_case) {
            ((android.widget.TextView) this.tanxc_goto.findViewById(com.alimm.tanx.core.R.id.splash_ad_txt_title)).setText((this.tanxc_for.getTemplateConf() == null || android.text.TextUtils.isEmpty(this.tanxc_for.getTemplateConf().getActionText())) ? "点击跳转详情页或第三方应用" : this.tanxc_for.getTemplateConf().getActionText());
            findViewById.setVisibility(0);
            this.tanxc_goto.getViewTreeObserver().addOnGlobalLayoutListener(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if.AnonymousClass1());
        }
        android.widget.ImageView imageView = (android.widget.ImageView) tanxc_long();
        if (imageView == null || (bidInfo = this.tanxc_for) == null || android.text.TextUtils.isEmpty(bidInfo.getAdvLogo()) || com.alimm.tanx.core.image.ImageManager.getLoader() == null) {
            return;
        }
        com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.tanxc_do).url(this.tanxc_for.getAdvLogo()).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.CENTER_CROP).build();
        com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if.AnonymousClass2(imageView, build));
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public android.view.View tanxc_char() {
        return null;
    }

    public void tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        this.tanxc_long = iTanxSplashInteractionListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public android.view.View tanxc_else() {
        android.view.View view = this.tanxc_goto;
        if (view != null) {
            return view;
        }
        android.view.ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(com.alimm.tanx.core.R.id.splash_ad_click_message_container);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public android.view.View tanxc_goto() {
        android.view.View view = this.tanxc_else;
        if (view != null) {
            return view;
        }
        android.view.ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(com.alimm.tanx.core.R.id.splash_ad_count_and_skip_container);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public android.view.View tanxc_long() {
        android.view.ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(com.alimm.tanx.core.R.id.iv_ad_logo);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public int tanxc_try() {
        return com.alimm.tanx.core.R.id.xadsdk_splash_ad_stub_default;
    }
}
