package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class TextScale extends androidx.transition.Transition {
    private static final java.lang.String PROPNAME_SCALE = "android:textscale:scale";

    /* renamed from: com.google.android.material.internal.TextScale$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.widget.TextView val$view;

        public AnonymousClass1(android.widget.TextView textView) {
            this.val$view = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            this.val$view.setScaleX(floatValue);
            this.val$view.setScaleY(floatValue);
        }
    }

    private void captureValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        if (view instanceof android.widget.TextView) {
            transitionValues.values.put(PROPNAME_SCALE, java.lang.Float.valueOf(((android.widget.TextView) view).getScaleX()));
        }
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
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof android.widget.TextView)) {
            return null;
        }
        android.view.View view = transitionValues2.view;
        if (!(view instanceof android.widget.TextView)) {
            return null;
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        java.util.Map<java.lang.String, java.lang.Object> map = transitionValues.values;
        java.util.Map<java.lang.String, java.lang.Object> map2 = transitionValues2.values;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((java.lang.Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float floatValue2 = map2.get(PROPNAME_SCALE) != null ? ((java.lang.Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new com.google.android.material.internal.TextScale.AnonymousClass1(textView));
        return ofFloat;
    }
}
