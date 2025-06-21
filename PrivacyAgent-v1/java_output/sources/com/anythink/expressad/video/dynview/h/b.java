package com.anythink.expressad.video.dynview.h;

/* loaded from: classes12.dex */
public final class b {

    /* renamed from: com.anythink.expressad.video.dynview.h.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.Animator.AnimatorListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass1(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(android.animation.Animator animator) {
            android.view.View view = this.a;
            if (view == null || !(view instanceof android.view.ViewGroup)) {
                return;
            }
            ((android.view.ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            android.view.View view = this.a;
            if (view == null || !(view instanceof android.view.ViewGroup)) {
                return;
            }
            ((android.view.ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(android.animation.Animator animator) {
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.h.b$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass2(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            android.view.View view = this.a;
            if (view != null) {
                view.setPadding(0, 0, 0, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                this.a.requestLayout();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.h.b$3, reason: invalid class name */
    public class AnonymousClass3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass3(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            android.view.View view = this.a;
            if (view != null) {
                view.getLayoutParams().width = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.requestLayout();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.h.b$4, reason: invalid class name */
    public class AnonymousClass4 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass4(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            android.view.View view = this.a;
            if (view != null) {
                view.getLayoutParams().height = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.requestLayout();
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.h.b$5, reason: invalid class name */
    public class AnonymousClass5 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass5(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.h.b$6, reason: invalid class name */
    public class AnonymousClass6 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass6(android.view.View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.a.setScaleX(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            this.a.setScaleY(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static android.animation.ObjectAnimator a(android.view.View view) {
        android.animation.ObjectAnimator duration = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, a(android.view.View.SCALE_X), a(android.view.View.SCALE_Y), a(android.view.View.ROTATION_X, 5.0f)).setDuration(2000L);
        duration.setRepeatCount(-1);
        return duration;
    }

    private static android.animation.PropertyValuesHolder a(android.util.Property property) {
        return android.animation.PropertyValuesHolder.ofKeyframe(property, android.animation.Keyframe.ofFloat(0.0f, 1.0f), android.animation.Keyframe.ofFloat(0.1f, 0.6f), android.animation.Keyframe.ofFloat(0.2f, 0.8f), android.animation.Keyframe.ofFloat(0.3f, 1.3f), android.animation.Keyframe.ofFloat(0.4f, 0.8f), android.animation.Keyframe.ofFloat(0.5f, 1.3f), android.animation.Keyframe.ofFloat(0.6f, 0.9f), android.animation.Keyframe.ofFloat(0.7f, 1.3f), android.animation.Keyframe.ofFloat(0.8f, 1.0f), android.animation.Keyframe.ofFloat(0.9f, 1.1f), android.animation.Keyframe.ofFloat(1.0f, 1.0f));
    }

    private static android.animation.PropertyValuesHolder a(android.util.Property property, float f) {
        float f2 = (-2.0f) * f;
        float f3 = f * 2.0f;
        return android.animation.PropertyValuesHolder.ofKeyframe(property, android.animation.Keyframe.ofFloat(0.0f, 0.0f), android.animation.Keyframe.ofFloat(0.1f, f2), android.animation.Keyframe.ofFloat(0.2f, f2), android.animation.Keyframe.ofFloat(0.3f, f3), android.animation.Keyframe.ofFloat(0.4f, f2), android.animation.Keyframe.ofFloat(0.5f, f3), android.animation.Keyframe.ofFloat(0.6f, f2), android.animation.Keyframe.ofFloat(0.7f, f3), android.animation.Keyframe.ofFloat(0.8f, f2), android.animation.Keyframe.ofFloat(0.9f, f3), android.animation.Keyframe.ofFloat(1.0f, 0.0f));
    }

    private void a(android.view.View view, int i, int i2, int i3, int i4, long j) {
        android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass3(view));
        android.animation.ValueAnimator ofInt2 = android.animation.ValueAnimator.ofInt(i3, i4);
        ofInt2.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass4(view));
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setDuration(j);
        animatorSet.start();
    }

    private void a(android.view.View view, int i, int i2, long j) {
        android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(i, i2).setDuration(j);
        duration.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass2(view));
        duration.start();
    }

    private void a(android.view.View view, int i, long j) {
        android.animation.ValueAnimator ofInt = view.getLayoutParams().width == 0 ? android.animation.ValueAnimator.ofInt(0, i) : android.animation.ValueAnimator.ofInt(i, 0);
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass5(view));
        android.animation.ValueAnimator ofFloat = view.getLayoutParams().width == 0 ? android.animation.ValueAnimator.ofFloat(0.0f, 1.0f) : android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass6(view));
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.start();
    }

    private void a(android.view.View view, long j) {
        if (view == null) {
            return;
        }
        android.animation.ValueAnimator ofInt = view.getLayoutParams().width == 0 ? android.animation.ValueAnimator.ofInt(0, r0) : android.animation.ValueAnimator.ofInt(r0, 0);
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass5(view));
        android.animation.ValueAnimator ofFloat = view.getLayoutParams().width == 0 ? android.animation.ValueAnimator.ofFloat(0.0f, 1.0f) : android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.addUpdateListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass6(view));
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.start();
    }

    private static void a(java.util.Map map, com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map, cVar, view);
        }
    }

    public static android.animation.ObjectAnimator b(android.view.View view) {
        android.animation.ObjectAnimator duration = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, b(android.view.View.SCALE_X), b(android.view.View.SCALE_Y)).setDuration(2000L);
        duration.setRepeatCount(-1);
        return duration;
    }

    private static android.animation.PropertyValuesHolder b(android.util.Property property) {
        return android.animation.PropertyValuesHolder.ofKeyframe(property, android.animation.Keyframe.ofFloat(0.0f, 1.0f), android.animation.Keyframe.ofFloat(0.1f, 0.6f), android.animation.Keyframe.ofFloat(0.2f, 0.6f), android.animation.Keyframe.ofFloat(0.3f, 1.0f), android.animation.Keyframe.ofFloat(0.4f, 1.0f), android.animation.Keyframe.ofFloat(0.5f, 1.0f), android.animation.Keyframe.ofFloat(0.6f, 1.0f), android.animation.Keyframe.ofFloat(0.7f, 1.0f), android.animation.Keyframe.ofFloat(0.8f, 1.0f), android.animation.Keyframe.ofFloat(0.9f, 1.0f), android.animation.Keyframe.ofFloat(1.0f, 1.0f));
    }

    public static android.animation.ObjectAnimator c(android.view.View view) {
        android.animation.ObjectAnimator duration = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, a(android.view.View.ROTATION, 2.0f)).setDuration(900L);
        duration.setRepeatCount(-1);
        return duration;
    }

    public static void e(android.view.View view) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(500L);
        }
    }

    private static android.view.animation.TranslateAnimation f(android.view.View view) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        view.setVisibility(0);
        return translateAnimation;
    }

    private static android.animation.ObjectAnimator g(android.view.View view) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, a(android.view.View.SCALE_X), a(android.view.View.SCALE_Y), a(android.view.View.ROTATION_X, 5.0f)).setDuration(2000L);
    }

    private static android.animation.ObjectAnimator h(android.view.View view) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, b(android.view.View.SCALE_X), b(android.view.View.SCALE_Y)).setDuration(2000L);
    }

    private static android.animation.ObjectAnimator i(android.view.View view) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, a(android.view.View.ROTATION, 2.0f)).setDuration(900L);
    }

    public final void d(android.view.View view) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(500L).setListener(new com.anythink.expressad.video.dynview.h.b.AnonymousClass1(view));
        }
    }
}
