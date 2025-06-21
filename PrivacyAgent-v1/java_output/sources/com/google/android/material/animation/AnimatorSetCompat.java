package com.google.android.material.animation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class AnimatorSetCompat {
    public static void playTogether(@androidx.annotation.NonNull android.animation.AnimatorSet animatorSet, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            android.animation.Animator animator = list.get(i);
            j = java.lang.Math.max(j, animator.getStartDelay() + animator.getDuration());
        }
        android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
