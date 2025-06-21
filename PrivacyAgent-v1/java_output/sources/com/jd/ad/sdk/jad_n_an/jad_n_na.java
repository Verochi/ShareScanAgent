package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_na extends android.view.View {
    public android.view.View jad_n_an;
    public android.widget.ImageView jad_n_bo;
    public android.animation.ObjectAnimator jad_n_cp;
    public android.widget.TextView jad_n_dq;
    public android.widget.TextView jad_n_er;
    public java.lang.String jad_n_fs;

    public class jad_n_an implements java.lang.Runnable {
        public jad_n_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_bo.setPivotX(r0.getWidth());
            com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_bo.setPivotY(r0.getHeight());
        }
    }

    public class jad_n_bo implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ android.content.Context jad_n_an;

        public jad_n_bo(android.content.Context context) {
            this.jad_n_an = context;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            android.view.ViewGroup.LayoutParams layoutParams = com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_an.getLayoutParams();
            if (layoutParams != null) {
                int i = layoutParams.width;
                int i2 = layoutParams.height;
                if (i > 0 && i2 > 0) {
                    float dip2px = ((int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(this.jad_n_an, 100.0f)) * 1.0f;
                    float max = java.lang.Math.max(i2 / dip2px, i / dip2px);
                    float min = java.lang.Math.min(i2, i) / 2;
                    android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_bo.getLayoutParams();
                    if (layoutParams2 != null) {
                        int i3 = (int) min;
                        layoutParams2.width = i3;
                        layoutParams2.height = i3;
                        int dip2px2 = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(this.jad_n_an, 15.0f * max);
                        layoutParams2.gravity = 17;
                        layoutParams2.setMargins(0, dip2px2, 0, 0);
                        com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_bo.setLayoutParams(layoutParams2);
                    }
                    com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_dq.setTextSize(12.0f * max);
                    com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_er.setTextSize(max * 9.0f);
                }
            }
            com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_an.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public class jad_n_cp implements android.view.View.OnAttachStateChangeListener {
        public jad_n_cp() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            android.animation.ObjectAnimator objectAnimator = com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            android.animation.ObjectAnimator objectAnimator = com.jd.ad.sdk.jad_n_an.jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
        }
    }

    public jad_n_na(android.content.Context context) {
        super(context);
        jad_n_an(context);
        jad_n_an();
    }

    public jad_n_na(android.content.Context context, java.lang.String str) {
        super(context);
        this.jad_n_fs = str;
        jad_n_an(context);
        jad_n_an();
    }

    public android.view.View getView() {
        return this.jad_n_an;
    }

    public void jad_n_an() {
        android.widget.ImageView imageView;
        if (this.jad_n_an == null || (imageView = this.jad_n_bo) == null || this.jad_n_cp == null) {
            return;
        }
        imageView.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_na.jad_n_cp());
    }

    public final void jad_n_an(android.content.Context context) {
        try {
            android.view.View inflate = android.view.View.inflate(context, com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_shake_template", "layout"), null);
            this.jad_n_an = inflate;
            this.jad_n_bo = (android.widget.ImageView) inflate.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "iv_shake_template", "id"));
            this.jad_n_dq = (android.widget.TextView) this.jad_n_an.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "tv_shake_first_content", "id"));
            this.jad_n_er = (android.widget.TextView) this.jad_n_an.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "tv_shake_second_content", "id"));
            if (this.jad_n_dq != null && !android.text.TextUtils.isEmpty(this.jad_n_fs)) {
                this.jad_n_dq.setText(this.jad_n_fs);
            }
            this.jad_n_bo.post(new com.jd.ad.sdk.jad_n_an.jad_n_na.jad_n_an());
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.jad_n_bo, "rotation", 0.0f, 30.0f, 0.0f, 30.0f, 0.0f);
            this.jad_n_cp = ofFloat;
            ofFloat.setDuration(1000L);
            this.jad_n_cp.setRepeatCount(-1);
            android.view.ViewTreeObserver viewTreeObserver = this.jad_n_an.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new com.jd.ad.sdk.jad_n_an.jad_n_na.jad_n_bo(context));
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("JADShakeView initView error :" + android.util.Log.getStackTraceString(e), new java.lang.Object[0]);
        }
    }
}
