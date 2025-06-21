package com.google.android.material.tabs;

/* loaded from: classes22.dex */
class ElasticTabIndicatorInterpolator extends com.google.android.material.tabs.TabIndicatorInterpolator {
    private static float accInterp(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (float) (1.0d - java.lang.Math.cos((f * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (float) java.lang.Math.sin((f * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void setIndicatorBoundsForOffset(com.google.android.material.tabs.TabLayout tabLayout, android.view.View view, android.view.View view2, float f, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        float decInterp;
        float accInterp;
        android.graphics.RectF calculateIndicatorWidthForTab = com.google.android.material.tabs.TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        android.graphics.RectF calculateIndicatorWidthForTab2 = com.google.android.material.tabs.TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view2);
        if (calculateIndicatorWidthForTab.left < calculateIndicatorWidthForTab2.left) {
            decInterp = accInterp(f);
            accInterp = decInterp(f);
        } else {
            decInterp = decInterp(f);
            accInterp = accInterp(f);
        }
        drawable.setBounds(com.google.android.material.animation.AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, decInterp), drawable.getBounds().top, com.google.android.material.animation.AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, accInterp), drawable.getBounds().bottom);
    }
}
