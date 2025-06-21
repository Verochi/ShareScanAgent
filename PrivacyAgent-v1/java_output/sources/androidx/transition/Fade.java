package androidx.transition;

/* loaded from: classes.dex */
public class Fade extends androidx.transition.Visibility {
    public static final int IN = 1;
    private static final java.lang.String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final java.lang.String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    /* renamed from: androidx.transition.Fade$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.transition.TransitionListenerAdapter {
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view) {
            this.val$view = view;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.ViewUtils.setTransitionAlpha(this.val$view, 1.0f);
            androidx.transition.ViewUtils.clearNonTransitionAlpha(this.val$view);
            transition.removeListener(this);
        }
    }

    public static class FadeAnimatorListener extends android.animation.AnimatorListenerAdapter {
        private boolean mLayerTypeChanged = false;
        private final android.view.View mView;

        public FadeAnimatorListener(android.view.View view) {
            this.mView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            androidx.transition.ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (androidx.core.view.ViewCompat.hasOverlappingRendering(this.mView) && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }
    }

    public Fade() {
    }

    public Fade(int i) {
        setMode(i);
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public Fade(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.FADE);
        setMode(androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainStyledAttributes, (android.content.res.XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }

    private android.animation.Animator createAnimation(android.view.View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        androidx.transition.ViewUtils.setTransitionAlpha(view, f);
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(view, androidx.transition.ViewUtils.TRANSITION_ALPHA, f2);
        ofFloat.addListener(new androidx.transition.Fade.FadeAnimatorListener(view));
        addListener(new androidx.transition.Fade.AnonymousClass1(view));
        return ofFloat;
    }

    private static float getStartAlpha(androidx.transition.TransitionValues transitionValues, float f) {
        java.lang.Float f2;
        return (transitionValues == null || (f2 = (java.lang.Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA)) == null) ? f : f2.floatValue();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, java.lang.Float.valueOf(androidx.transition.ViewUtils.getTransitionAlpha(transitionValues.view)));
    }

    @Override // androidx.transition.Visibility
    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        float startAlpha = getStartAlpha(transitionValues, 0.0f);
        return createAnimation(view, startAlpha != 1.0f ? startAlpha : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        androidx.transition.ViewUtils.saveNonTransitionAlpha(view);
        return createAnimation(view, getStartAlpha(transitionValues, 1.0f), 0.0f);
    }
}
