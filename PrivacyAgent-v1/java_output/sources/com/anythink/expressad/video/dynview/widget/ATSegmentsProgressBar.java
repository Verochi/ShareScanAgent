package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATSegmentsProgressBar extends android.widget.LinearLayout {
    private final java.lang.String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private java.util.List<android.widget.ProgressBar> i;
    private android.widget.TextView j;
    private java.lang.String k;
    private boolean l;

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.animation.Animation.AnimationListener {
        public AnonymousClass1() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public ATSegmentsProgressBar(android.content.Context context) {
        super(context);
        this.a = "ATSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new java.util.ArrayList();
        this.l = false;
    }

    public ATSegmentsProgressBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "ATSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new java.util.ArrayList();
        this.l = false;
    }

    public ATSegmentsProgressBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "ATSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new java.util.ArrayList();
        this.l = false;
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ATSegmentsProgressBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = "ATSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new java.util.ArrayList();
        this.l = false;
    }

    private java.lang.StringBuilder a(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            sb.append(java.lang.String.format(this.k, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.b)));
        } catch (java.lang.Throwable th) {
            sb.append(this.b);
            sb.append("videos, the");
            sb.append(i);
            sb.append(" is playing.");
            th.getMessage();
        }
        return sb;
    }

    private void a() {
        android.graphics.drawable.Drawable drawable;
        try {
            if (this.c == 1) {
                setOrientation(1);
                if (android.text.TextUtils.isEmpty(this.k)) {
                    this.k = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_segment_process_bar_hint_text", com.anythink.expressad.foundation.h.i.g));
                }
            }
            if (this.c == 2) {
                setOrientation(0);
                if (android.text.TextUtils.isEmpty(this.k)) {
                    this.k = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_segment_process_bar_hint_text_lite", com.anythink.expressad.foundation.h.i.g));
                }
            }
            this.i.clear();
            removeAllViews();
            setBackgroundDrawable(c());
            android.widget.TextView textView = new android.widget.TextView(getContext());
            this.j = textView;
            textView.setTextColor(-1);
            this.j.setTextSize(12.0f);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            this.j.setLayoutParams(layoutParams);
            if (this.c == 1) {
                layoutParams.gravity = 5;
                android.widget.TextView textView2 = this.j;
                int i = this.d;
                textView2.setPadding(i / 2, 15, i / 2, 5);
            }
            if (this.c == 2) {
                this.j.setGravity(16);
                android.widget.TextView textView3 = this.j;
                int i2 = this.d;
                textView3.setPadding(i2 / 2, 0, i2 / 2, 0);
            }
            try {
                int a = com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_reward_video_icon", com.anythink.expressad.foundation.h.i.c);
                if (a != 0 && (drawable = getContext().getResources().getDrawable(a)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.j.setCompoundDrawables(drawable, null, null, null);
                    this.j.setCompoundDrawablePadding(5);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            this.j.setText(a(this.f));
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            linearLayout.setOrientation(0);
            android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i3 = 0; i3 < this.b; i3++) {
                android.widget.ProgressBar progressBar = new android.widget.ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(b());
                android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(0, 20, 1.0f);
                int i4 = this.d;
                layoutParams3.leftMargin = i4 / 2;
                layoutParams3.rightMargin = i4 / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.i.add(progressBar);
            }
            if (this.c == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.j);
                addView(linearLayout);
            }
            if (this.c == 2) {
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.j);
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    private android.graphics.drawable.LayerDrawable b() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.e);
        gradientDrawable.setColor(this.g);
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.e);
        gradientDrawable2.setColor(this.h);
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{gradientDrawable, new android.graphics.drawable.ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        return layerDrawable;
    }

    private static android.graphics.drawable.GradientDrawable c() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setDither(true);
        try {
            gradientDrawable.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{0, 1291845632});
        } catch (java.lang.Throwable unused) {
        }
        return gradientDrawable;
    }

    public void dismiss() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar.AnonymousClass1());
        startAnimation(alphaAnimation);
    }

    public void init(int i, int i2) {
        this.b = i;
        this.c = i2;
        a();
    }

    public void init(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.h = i3;
        this.g = i4;
        a();
    }

    public void init(int i, int i2, int i3, int i4, int i5, int i6) {
        this.b = i;
        this.c = i2;
        this.h = i3;
        this.g = i4;
        this.d = i5;
        this.e = i6;
        a();
    }

    public void setIndicatorText(java.lang.String str) {
        this.k = str;
    }

    public void setProgress(int i, int i2) {
        try {
            if (this.i.size() == 0) {
                return;
            }
            if (i2 < this.i.size()) {
                this.i.get(i2).setProgress(i);
            }
            int i3 = i2 + 1;
            if (i3 > this.f) {
                this.f = i3;
                android.widget.TextView textView = this.j;
                if (textView != null) {
                    textView.setText(a(i3));
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
