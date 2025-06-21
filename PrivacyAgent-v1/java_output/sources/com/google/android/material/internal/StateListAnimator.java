package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class StateListAnimator {
    private final java.util.ArrayList<com.google.android.material.internal.StateListAnimator.Tuple> tuples = new java.util.ArrayList<>();

    @androidx.annotation.Nullable
    private com.google.android.material.internal.StateListAnimator.Tuple lastMatch = null;

    @androidx.annotation.Nullable
    android.animation.ValueAnimator runningAnimator = null;
    private final android.animation.Animator.AnimatorListener animationListener = new com.google.android.material.internal.StateListAnimator.AnonymousClass1();

    /* renamed from: com.google.android.material.internal.StateListAnimator$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.internal.StateListAnimator stateListAnimator = com.google.android.material.internal.StateListAnimator.this;
            if (stateListAnimator.runningAnimator == animator) {
                stateListAnimator.runningAnimator = null;
            }
        }
    }

    public static class Tuple {
        final android.animation.ValueAnimator animator;
        final int[] specs;

        public Tuple(int[] iArr, android.animation.ValueAnimator valueAnimator) {
            this.specs = iArr;
            this.animator = valueAnimator;
        }
    }

    private void cancel() {
        android.animation.ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(@androidx.annotation.NonNull com.google.android.material.internal.StateListAnimator.Tuple tuple) {
        android.animation.ValueAnimator valueAnimator = tuple.animator;
        this.runningAnimator = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, android.animation.ValueAnimator valueAnimator) {
        com.google.android.material.internal.StateListAnimator.Tuple tuple = new com.google.android.material.internal.StateListAnimator.Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(tuple);
    }

    public void jumpToCurrentState() {
        android.animation.ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        com.google.android.material.internal.StateListAnimator.Tuple tuple;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tuple = null;
                break;
            }
            tuple = this.tuples.get(i);
            if (android.util.StateSet.stateSetMatches(tuple.specs, iArr)) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.material.internal.StateListAnimator.Tuple tuple2 = this.lastMatch;
        if (tuple == tuple2) {
            return;
        }
        if (tuple2 != null) {
            cancel();
        }
        this.lastMatch = tuple;
        if (tuple != null) {
            start(tuple);
        }
    }
}
