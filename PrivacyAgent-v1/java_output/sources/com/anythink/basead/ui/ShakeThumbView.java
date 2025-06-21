package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ShakeThumbView extends com.anythink.basead.ui.BaseShakeView {
    private android.widget.ImageView k;
    private android.widget.TextView l;

    public ShakeThumbView(android.content.Context context) {
        super(context);
    }

    public ShakeThumbView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeThumbView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ShakeThumbView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void a(android.view.View view) {
        int a = com.anythink.core.common.o.i.a(getContext(), 88.0f);
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
        this.k = new android.widget.ImageView(getContext());
        this.k.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 90.0f), com.anythink.core.common.o.i.a(getContext(), 90.0f)));
        android.widget.ImageView imageView = this.k;
        int a = com.anythink.core.common.o.i.a(getContext(), 88.0f);
        int parseColor = android.graphics.Color.parseColor("#99000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.a = new android.widget.ImageView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 40.0f), com.anythink.core.common.o.i.a(getContext(), 40.0f));
        layoutParams.gravity = 49;
        layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
        this.a.setLayoutParams(layoutParams);
        this.l = new android.widget.TextView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        this.l.setMaxWidth(com.anythink.core.common.o.i.a(getContext(), 62.0f));
        this.l.setMaxLines(1);
        this.l.setEllipsize(android.text.TextUtils.TruncateAt.END);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 14.0f);
        this.l.setLayoutParams(layoutParams2);
        this.l.setText(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_shake_simple_title", com.anythink.expressad.foundation.h.i.g));
        this.l.setTextSize(1, 10.0f);
        this.l.setTextColor(-1);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        frameLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(this.k);
        frameLayout.addView(this.a);
        frameLayout.addView(this.l);
        addView(frameLayout);
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        try {
            this.a.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(com.anythink.core.common.f.n nVar) {
        android.widget.TextView textView;
        super.setShakeSetting(nVar);
        java.lang.String str = this.g;
        if (str == null || (textView = this.l) == null) {
            return;
        }
        textView.setText(str);
    }
}
