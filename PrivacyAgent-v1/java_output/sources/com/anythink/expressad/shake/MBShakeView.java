package com.anythink.expressad.shake;

/* loaded from: classes12.dex */
public class MBShakeView extends android.widget.LinearLayout {
    private static final java.lang.String a = "MBSplashShakeView";
    private android.widget.ImageView b;
    private android.view.animation.Animation c;

    public MBShakeView(android.content.Context context) {
        super(context);
    }

    public MBShakeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBShakeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public MBShakeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_view_other_app", com.anythink.expressad.foundation.h.i.g)) : str;
    }

    private void a() {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.c = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.c.setRepeatMode(2);
        this.c.setRepeatCount(-1);
        this.b.startAnimation(this.c);
    }

    private static void a(android.view.View view) {
        int parseColor = android.graphics.Color.parseColor("#80000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200.0f);
        view.setBackgroundDrawable(gradientDrawable);
    }

    public void initView(java.lang.String str) {
        initView(str, false);
    }

    public void initView(java.lang.String str, boolean z) {
        setOrientation(1);
        setGravity(1);
        android.view.View imageView = new android.widget.ImageView(getContext());
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), z ? 60.0f : 80.0f), com.anythink.expressad.foundation.h.t.b(getContext(), z ? 60.0f : 80.0f)));
        int parseColor = android.graphics.Color.parseColor("#80000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200.0f);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.b = new android.widget.ImageView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), z ? 20.0f : 40.0f), com.anythink.expressad.foundation.h.t.b(getContext(), z ? 20.0f : 40.0f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageResource(getResources().getIdentifier("anythink_splash_btn_shake", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        frameLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.b);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        getContext().getResources().getConfiguration().locale.getLanguage();
        textView.setText(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_hint_text", com.anythink.expressad.foundation.h.i.g)));
        textView.setTextSize(z ? 16.0f : 20.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        if (android.text.TextUtils.isEmpty(str)) {
            str = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_view_other_app", com.anythink.expressad.foundation.h.i.g));
        }
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        textView2.setTextSize(z ? 12.0f : 16.0f);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.c = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.c.setRepeatMode(2);
        this.c.setRepeatCount(-1);
        this.b.startAnimation(this.c);
    }
}
