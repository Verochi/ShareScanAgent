package androidx.transition;

/* loaded from: classes.dex */
public class ChangeScroll extends androidx.transition.Transition {
    private static final java.lang.String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final java.lang.String PROPNAME_SCROLL_Y = "android:changeScroll:y";
    private static final java.lang.String[] PROPERTIES = {PROPNAME_SCROLL_X, PROPNAME_SCROLL_Y};

    public ChangeScroll() {
    }

    public ChangeScroll(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_SCROLL_X, java.lang.Integer.valueOf(transitionValues.view.getScrollX()));
        transitionValues.values.put(PROPNAME_SCROLL_Y, java.lang.Integer.valueOf(transitionValues.view.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        android.animation.ObjectAnimator objectAnimator;
        android.animation.ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        android.view.View view = transitionValues2.view;
        int intValue = ((java.lang.Integer) transitionValues.values.get(PROPNAME_SCROLL_X)).intValue();
        int intValue2 = ((java.lang.Integer) transitionValues2.values.get(PROPNAME_SCROLL_X)).intValue();
        int intValue3 = ((java.lang.Integer) transitionValues.values.get(PROPNAME_SCROLL_Y)).intValue();
        int intValue4 = ((java.lang.Integer) transitionValues2.values.get(PROPNAME_SCROLL_Y)).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = android.animation.ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = android.animation.ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return androidx.transition.TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public java.lang.String[] getTransitionProperties() {
        return PROPERTIES;
    }
}
