package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_for extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if {
    private long tanxc_break;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView tanxc_catch;
    protected android.view.ViewGroup tanxc_this;
    protected android.widget.LinearLayout tanxc_void;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void destroy(java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.utShakeDestroy(com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for.this.tanxc_int, str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void onShake() {
            com.alimm.tanx.core.utils.LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView 互动成功摇一摇跳转");
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for.this.tanxc_break();
        }
    }

    public tanxc_for(@androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        super(tanxc_doVar, context, viewGroup, iTanxAd);
    }

    private void tanxc_catch() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("add_interaction_view_time", java.lang.String.valueOf(android.os.SystemClock.elapsedRealtime() - this.tanxc_break));
        com.alimm.tanx.core.ut.impl.TanxBaseUt.shake("add_interaction_view_time", null, hashMap);
    }

    public static void tanxc_do(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        com.alimm.tanx.core.ut.impl.TanxBaseUt.shake(str, bidInfo, null);
    }

    private void tanxc_if(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        com.alimm.tanx.core.utils.LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView");
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.tanxc_for;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean build = (bidInfo == null || bidInfo.getTemplateConf() == null) ? null : new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean().build(this.tanxc_for.getTemplateConf());
        if (this.tanxc_catch == null) {
            this.tanxc_catch = new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView(this.tanxc_do, build);
        }
        this.tanxc_this.setVisibility(0);
        tanxc_catch();
        this.tanxc_catch.setClickable(false);
        this.tanxc_catch.setOnTouchListener(null);
        this.tanxc_catch.load(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for.AnonymousClass1(), true);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, com.alimm.tanx.core.utils.DimenUtil.dp2px(this.tanxc_do, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.tanxc_catch, layoutParams);
    }

    public void tanxc_break() {
        if (this.tanxc_char) {
            com.alimm.tanx.core.utils.LogUtils.d("ShakeInteractionTemplate", "mClickedOnce = true");
            return;
        }
        this.tanxc_char = true;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener = this.tanxc_long;
        if (iTanxSplashInteractionListener != null) {
            iTanxSplashInteractionListener.onAdShake();
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_byte() {
        super.tanxc_byte();
        this.tanxc_void = (android.widget.LinearLayout) this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.splash_ad_interaction_root);
        this.tanxc_this = (android.view.ViewGroup) this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.splash_ad_interaction_container);
        if (tanxc_void()) {
            this.tanxc_void.setVisibility(0);
            this.tanxc_this.setVisibility(0);
            tanxc_do(this.tanxc_this);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public android.view.View tanxc_char() {
        return this.tanxc_catch;
    }

    public void tanxc_do(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.tanxc_break = android.os.SystemClock.elapsedRealtime();
        tanxc_if(viewGroup);
        tanxc_do(this.tanxc_for, "add_interaction_view", null);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public int tanxc_try() {
        return com.alimm.tanx.core.R.id.xadsdk_splash_ad_stub_interaction;
    }

    public boolean tanxc_void() {
        return true;
    }
}
