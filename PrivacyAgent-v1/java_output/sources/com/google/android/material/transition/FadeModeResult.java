package com.google.android.material.transition;

/* loaded from: classes22.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i, int i2, boolean z) {
        this.startAlpha = i;
        this.endAlpha = i2;
        this.endOnTop = z;
    }

    public static com.google.android.material.transition.FadeModeResult endOnTop(int i, int i2) {
        return new com.google.android.material.transition.FadeModeResult(i, i2, true);
    }

    public static com.google.android.material.transition.FadeModeResult startOnTop(int i, int i2) {
        return new com.google.android.material.transition.FadeModeResult(i, i2, false);
    }
}
