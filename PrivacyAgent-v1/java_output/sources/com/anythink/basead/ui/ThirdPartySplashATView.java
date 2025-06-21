package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ThirdPartySplashATView extends com.anythink.basead.ui.AsseblemSplashATView {
    com.anythink.core.api.BaseAd Q;

    public ThirdPartySplashATView(android.content.Context context) {
        super(context);
    }

    public ThirdPartySplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar, java.lang.String str) {
        super(context, mVar, lVar, aVar);
        com.anythink.core.api.BaseAd baseAd;
        this.Q = com.anythink.basead.d.i.a().a(str);
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.p.add(frameLayout);
        }
        android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd = this.Q) != null && baseAd.getAdMediaView(new java.lang.Object[0]) != null) {
            android.view.View adMediaView = this.Q.getAdMediaView(new java.lang.Object[0]);
            if (adMediaView.getParent() != null) {
                ((android.view.ViewGroup) adMediaView.getParent()).removeView(adMediaView);
            }
            frameLayout2.addView(adMediaView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && this.Q.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof android.view.ViewGroup)) {
            android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            android.view.ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                if (this.b.n.w() == 2) {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                } else {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).rightMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((android.view.ViewGroup) roundImageView.getParent()).addView(this.Q.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (((com.anythink.basead.ui.BaseSdkSplashATView) this).v == null || this.Q.getAdLogoView() == null || ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent() == null || !(((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent() instanceof android.view.ViewGroup)) {
            return;
        }
        ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.setVisibility(0);
        ((android.view.ViewGroup) ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent()).addView(this.Q.getAdLogoView(), ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getLayoutParams());
    }

    private void q() {
        com.anythink.core.api.BaseAd baseAd;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.p.add(frameLayout);
        }
        android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd = this.Q) != null && baseAd.getAdMediaView(new java.lang.Object[0]) != null) {
            android.view.View adMediaView = this.Q.getAdMediaView(new java.lang.Object[0]);
            if (adMediaView.getParent() != null) {
                ((android.view.ViewGroup) adMediaView.getParent()).removeView(adMediaView);
            }
            frameLayout2.addView(adMediaView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && this.Q.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof android.view.ViewGroup)) {
            android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            android.view.ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                if (this.b.n.w() == 2) {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                } else {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).rightMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((android.view.ViewGroup) roundImageView.getParent()).addView(this.Q.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (((com.anythink.basead.ui.BaseSdkSplashATView) this).v == null || this.Q.getAdLogoView() == null || ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent() == null || !(((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent() instanceof android.view.ViewGroup)) {
            return;
        }
        ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.setVisibility(0);
        ((android.view.ViewGroup) ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getParent()).addView(this.Q.getAdLogoView(), ((com.anythink.basead.ui.BaseSdkSplashATView) this).v.getLayoutParams());
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final float a(com.anythink.basead.ui.a aVar, int i) {
        return 1.0f;
    }

    @Override // com.anythink.basead.ui.AsseblemSplashATView, com.anythink.basead.ui.BaseSdkSplashATView
    public final void c() {
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final boolean k() {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    public final void o() {
        super.o();
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView
    public final void p() {
    }

    public void registerNativeClickListener(android.view.View view) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 5.0f);
        layoutParams.rightMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
        if (this.Q != null) {
            if (this.b.n.D() == 0) {
                this.p.add(this);
                this.Q.registerListener(view, this.p, layoutParams);
            } else {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(this.f149s);
                this.Q.registerListener(view, arrayList, layoutParams);
            }
        }
    }
}
