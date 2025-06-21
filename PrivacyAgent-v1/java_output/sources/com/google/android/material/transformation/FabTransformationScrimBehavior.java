package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class FabTransformationScrimBehavior extends com.google.android.material.transformation.ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final com.google.android.material.animation.MotionTiming collapseTiming;
    private final com.google.android.material.animation.MotionTiming expandTiming;

    /* renamed from: com.google.android.material.transformation.FabTransformationScrimBehavior$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.view.View val$child;
        final /* synthetic */ boolean val$expanded;

        public AnonymousClass1(boolean z, android.view.View view) {
            this.val$expanded = z;
            this.val$child = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.val$expanded) {
                return;
            }
            this.val$child.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (this.val$expanded) {
                this.val$child.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.expandTiming = new com.google.android.material.animation.MotionTiming(75L, 150L);
        this.collapseTiming = new com.google.android.material.animation.MotionTiming(0L, 150L);
    }

    public FabTransformationScrimBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.expandTiming = new com.google.android.material.animation.MotionTiming(75L, 150L);
        this.collapseTiming = new com.google.android.material.animation.MotionTiming(0L, 150L);
    }

    private void createScrimAnimation(@androidx.annotation.NonNull android.view.View view, boolean z, boolean z2, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.animation.ObjectAnimator ofFloat;
        com.google.android.material.animation.MotionTiming motionTiming = z ? this.expandTiming : this.collapseTiming;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = android.animation.ObjectAnimator.ofFloat(view, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.ALPHA, 1.0f);
        } else {
            ofFloat = android.animation.ObjectAnimator.ofFloat(view, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.ALPHA, 0.0f);
        }
        motionTiming.apply(ofFloat);
        list.add(ofFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
        return view2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @androidx.annotation.NonNull
    public android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, boolean z2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        createScrimAnimation(view2, z, z2, arrayList, new java.util.ArrayList());
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new com.google.android.material.transformation.FabTransformationScrimBehavior.AnonymousClass1(z, view2));
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
