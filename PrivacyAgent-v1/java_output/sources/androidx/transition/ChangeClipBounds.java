package androidx.transition;

/* loaded from: classes.dex */
public class ChangeClipBounds extends androidx.transition.Transition {
    private static final java.lang.String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final java.lang.String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final java.lang.String[] sTransitionProperties = {PROPNAME_CLIP};

    /* renamed from: androidx.transition.ChangeClipBounds$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.view.View val$endView;

        public AnonymousClass1(android.view.View view) {
            this.val$endView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            androidx.core.view.ViewCompat.setClipBounds(this.val$endView, null);
        }
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        android.graphics.Rect clipBounds = androidx.core.view.ViewCompat.getClipBounds(view);
        transitionValues.values.put(PROPNAME_CLIP, clipBounds);
        if (clipBounds == null) {
            transitionValues.values.put(PROPNAME_BOUNDS, new android.graphics.Rect(0, 0, view.getWidth(), view.getHeight()));
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
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        android.animation.ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && transitionValues.values.containsKey(PROPNAME_CLIP) && transitionValues2.values.containsKey(PROPNAME_CLIP)) {
            android.graphics.Rect rect = (android.graphics.Rect) transitionValues.values.get(PROPNAME_CLIP);
            android.graphics.Rect rect2 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_CLIP);
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (android.graphics.Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            } else if (rect2 == null) {
                rect2 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            }
            if (rect.equals(rect2)) {
                return null;
            }
            androidx.core.view.ViewCompat.setClipBounds(transitionValues2.view, rect);
            objectAnimator = android.animation.ObjectAnimator.ofObject(transitionValues2.view, (android.util.Property<android.view.View, V>) androidx.transition.ViewUtils.CLIP_BOUNDS, (android.animation.TypeEvaluator) new androidx.transition.RectEvaluator(new android.graphics.Rect()), (java.lang.Object[]) new android.graphics.Rect[]{rect, rect2});
            if (z) {
                objectAnimator.addListener(new androidx.transition.ChangeClipBounds.AnonymousClass1(transitionValues2.view));
            }
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public java.lang.String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
