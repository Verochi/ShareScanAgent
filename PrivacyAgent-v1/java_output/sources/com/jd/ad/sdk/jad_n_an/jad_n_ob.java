package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_ob extends android.view.View {
    public android.view.View jad_n_an;
    public android.widget.LinearLayout jad_n_bo;
    public android.animation.ObjectAnimator jad_n_cp;
    public android.animation.ObjectAnimator jad_n_dq;

    public class jad_n_an implements android.view.View.OnAttachStateChangeListener {
        public jad_n_an() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            android.animation.ObjectAnimator objectAnimator = com.jd.ad.sdk.jad_n_an.jad_n_ob.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            android.animation.ObjectAnimator objectAnimator2 = com.jd.ad.sdk.jad_n_an.jad_n_ob.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            android.animation.ObjectAnimator objectAnimator = com.jd.ad.sdk.jad_n_an.jad_n_ob.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            android.animation.ObjectAnimator objectAnimator2 = com.jd.ad.sdk.jad_n_an.jad_n_ob.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.end();
            }
        }
    }

    public jad_n_ob(android.content.Context context) {
        super(context);
        jad_n_an(context);
        jad_n_an();
    }

    public android.view.View getView() {
        return this.jad_n_an;
    }

    public final void jad_n_an() {
        android.widget.LinearLayout linearLayout;
        if (this.jad_n_an == null || (linearLayout = this.jad_n_bo) == null || this.jad_n_cp == null || this.jad_n_dq == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_ob.jad_n_an());
    }

    public final void jad_n_an(android.content.Context context) {
        try {
            android.view.View inflate = android.view.View.inflate(context, com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_swipe_template", "layout"), null);
            this.jad_n_an = inflate;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) inflate.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "liner_swipe_template", "id"));
            this.jad_n_bo = linearLayout;
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, -30.0f, 0.0f);
            this.jad_n_cp = ofFloat;
            ofFloat.setRepeatCount(4);
            this.jad_n_cp.setDuration(1500L);
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.jad_n_bo, "alpha", 1.0f, 0.7f, 1.0f);
            this.jad_n_dq = ofFloat2;
            ofFloat2.setDuration(1500L);
            this.jad_n_dq.setRepeatCount(4);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("JADSwipeView initView error :" + android.util.Log.getStackTraceString(e), new java.lang.Object[0]);
        }
    }
}
