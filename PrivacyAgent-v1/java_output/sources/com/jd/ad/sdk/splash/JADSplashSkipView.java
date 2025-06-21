package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class JADSplashSkipView extends android.widget.FrameLayout {
    public int jad_s_an;
    public com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_bo jad_s_bo;
    public android.widget.TextView jad_s_cp;
    public boolean jad_s_dq;
    public final java.lang.Runnable jad_s_er;

    public class jad_s_an implements java.lang.Runnable {
        public jad_s_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView = com.jd.ad.sdk.splash.JADSplashSkipView.this;
            android.widget.TextView textView = jADSplashSkipView.jad_s_cp;
            if (textView == null) {
                return;
            }
            if (jADSplashSkipView.jad_s_an > 5) {
                textView.setText("跳过");
            } else {
                textView.setText(java.lang.String.format(java.util.Locale.getDefault(), "跳过 %d", java.lang.Integer.valueOf(com.jd.ad.sdk.splash.JADSplashSkipView.this.jad_s_an)));
            }
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView2 = com.jd.ad.sdk.splash.JADSplashSkipView.this;
            if (jADSplashSkipView2.jad_s_dq) {
                com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_bo jad_s_boVar = jADSplashSkipView2.jad_s_bo;
                if (jad_s_boVar != null) {
                    com.jd.ad.sdk.splash.jad_s_an.jad_s_an(((com.jd.ad.sdk.splash.jad_s_cp) jad_s_boVar).jad_s_an, jADSplashSkipView2.jad_s_an);
                }
                com.jd.ad.sdk.splash.JADSplashSkipView.this.jad_s_an--;
            }
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView3 = com.jd.ad.sdk.splash.JADSplashSkipView.this;
            if (jADSplashSkipView3.jad_s_an >= 0) {
                jADSplashSkipView3.postDelayed(jADSplashSkipView3.jad_s_er, 1000L);
                return;
            }
            com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_bo jad_s_boVar2 = jADSplashSkipView3.jad_s_bo;
            if (jad_s_boVar2 != null) {
                com.jd.ad.sdk.splash.jad_s_cp jad_s_cpVar = (com.jd.ad.sdk.splash.jad_s_cp) jad_s_boVar2;
                com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_cpVar.jad_s_an);
                com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView4 = jad_s_cpVar.jad_s_an.jad_s_kx;
                if (jADSplashSkipView4 != null) {
                    jADSplashSkipView4.removeCallbacks(null);
                }
            }
        }
    }

    public interface jad_s_bo {
    }

    public JADSplashSkipView(android.content.Context context) {
        super(context);
        this.jad_s_dq = true;
        this.jad_s_er = new com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_an();
        jad_s_an(context);
    }

    public JADSplashSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_s_dq = true;
        this.jad_s_er = new com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_an();
        jad_s_an(context);
    }

    public JADSplashSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_s_dq = true;
        this.jad_s_er = new com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_an();
        jad_s_an(context);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public JADSplashSkipView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jad_s_dq = true;
        this.jad_s_er = new com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_an();
        jad_s_an(context);
    }

    public final void jad_s_an(android.content.Context context) {
        try {
            android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_skip_btn", "layout"), (android.view.ViewGroup) null);
            this.jad_s_cp = (android.widget.TextView) inflate.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "tv_count", "id"));
            addView(inflate);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while splash skip init: " + e, new java.lang.Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_s_dq = z;
    }

    public void setTotalCount(@androidx.annotation.NonNull com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_bo jad_s_boVar) {
        this.jad_s_an = 5;
        this.jad_s_bo = jad_s_boVar;
        setOnClickListener(new com.jd.ad.sdk.splash.jad_s_er(this));
    }
}
