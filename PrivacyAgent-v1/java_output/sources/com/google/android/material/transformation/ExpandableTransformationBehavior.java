package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class ExpandableTransformationBehavior extends com.google.android.material.transformation.ExpandableBehavior {

    @androidx.annotation.Nullable
    private android.animation.AnimatorSet currentAnimation;

    /* renamed from: com.google.android.material.transformation.ExpandableTransformationBehavior$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.transformation.ExpandableTransformationBehavior.this.currentAnimation = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public abstract android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(android.view.View view, android.view.View view2, boolean z, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @androidx.annotation.CallSuper
    public boolean onExpandedStateChange(android.view.View view, android.view.View view2, boolean z, boolean z2) {
        android.animation.AnimatorSet animatorSet = this.currentAnimation;
        boolean z3 = animatorSet != null;
        if (z3) {
            animatorSet.cancel();
        }
        android.animation.AnimatorSet onCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z, z3);
        this.currentAnimation = onCreateExpandedStateChangeAnimation;
        onCreateExpandedStateChangeAnimation.addListener(new com.google.android.material.transformation.ExpandableTransformationBehavior.AnonymousClass1());
        this.currentAnimation.start();
        if (!z2) {
            this.currentAnimation.end();
        }
        return true;
    }
}
