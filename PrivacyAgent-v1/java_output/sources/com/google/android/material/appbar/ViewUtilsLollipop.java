package com.google.android.material.appbar;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {android.R.attr.stateListAnimator};

    public static void setBoundsViewOutlineProvider(@androidx.annotation.NonNull android.view.View view) {
        view.setOutlineProvider(android.view.ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@androidx.annotation.NonNull android.view.View view, float f) {
        int integer = view.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{android.R.attr.enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, android.animation.ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{android.R.attr.enabled}, android.animation.ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], android.animation.ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    public static void setStateListAnimatorFromAttrs(@androidx.annotation.NonNull android.view.View view, android.util.AttributeSet attributeSet, int i, int i2) {
        android.content.Context context = view.getContext();
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i, i2, new int[0]);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view.setStateListAnimator(android.animation.AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
