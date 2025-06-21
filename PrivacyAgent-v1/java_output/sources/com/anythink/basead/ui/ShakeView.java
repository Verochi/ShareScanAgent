package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ShakeView extends com.anythink.basead.ui.BaseShakeView {
    android.widget.TextView k;
    java.lang.String l;
    private android.widget.ImageView m;
    private android.view.View n;
    private java.lang.Boolean o;

    public ShakeView(android.content.Context context) {
        super(context);
        this.o = java.lang.Boolean.FALSE;
    }

    public ShakeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = java.lang.Boolean.FALSE;
    }

    public ShakeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = java.lang.Boolean.FALSE;
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ShakeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.o = java.lang.Boolean.FALSE;
    }

    private void a(android.view.View view) {
        int a = com.anythink.core.common.o.i.a(getContext(), 115.0f);
        int parseColor = android.graphics.Color.parseColor("#99000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a);
        view.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public final void a() {
        setOrientation(1);
        setGravity(1);
        this.m = new android.widget.ImageView(getContext());
        this.m.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 115.0f), com.anythink.core.common.o.i.a(getContext(), 115.0f)));
        android.widget.ImageView imageView = this.m;
        int a = com.anythink.core.common.o.i.a(getContext(), 115.0f);
        int parseColor = android.graphics.Color.parseColor("#99000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.a = new android.widget.ImageView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 76.0f), com.anythink.core.common.o.i.a(getContext(), 76.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(this.m);
        frameLayout.addView(this.a);
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_shake_hint_text", "layout"), (android.view.ViewGroup) null);
        this.n = inflate;
        inflate.setLayoutParams(layoutParams2);
        android.widget.TextView textView = (android.widget.TextView) this.n.findViewById(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "tv_splash_shake_hint_text", "id"));
        this.k = textView;
        textView.setText(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_shake_full_title", com.anythink.expressad.foundation.h.i.g));
        this.b = (android.widget.ImageView) this.n.findViewById(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "tv_splash_shake_hint_icon", "id"));
        addView(frameLayout);
        addView(this.n);
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setNeedHideShakeIcon(boolean z) {
        this.o = java.lang.Boolean.valueOf(z);
        if (z) {
            android.widget.ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            android.widget.ImageView imageView2 = this.m;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            android.widget.ImageView imageView3 = this.a;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        try {
            this.a.setOnClickListener(onClickListener);
            this.m.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setShakeHintText(java.lang.String str) {
        this.l = str;
        if (this.k == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.k.setText(str);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(com.anythink.core.common.f.n nVar) {
        super.setShakeSetting(nVar);
        if (this.f == null || this.k == null || !android.text.TextUtils.isEmpty(this.l)) {
            return;
        }
        this.k.setText(this.f);
    }

    @Override // android.view.View
    public void startAnimation(android.view.animation.Animation animation) {
        if (this.o.booleanValue()) {
            return;
        }
        super.startAnimation(animation);
    }
}
