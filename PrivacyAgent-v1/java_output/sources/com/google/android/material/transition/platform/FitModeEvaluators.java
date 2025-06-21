package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class FitModeEvaluators {
    private static final com.google.android.material.transition.platform.FitModeEvaluator WIDTH = new com.google.android.material.transition.platform.FitModeEvaluators.AnonymousClass1();
    private static final com.google.android.material.transition.platform.FitModeEvaluator HEIGHT = new com.google.android.material.transition.platform.FitModeEvaluators.AnonymousClass2();

    /* renamed from: com.google.android.material.transition.platform.FitModeEvaluators$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.android.material.transition.platform.FitModeEvaluator {
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(android.graphics.RectF rectF, float f, com.google.android.material.transition.platform.FitModeResult fitModeResult) {
            rectF.bottom -= java.lang.Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public com.google.android.material.transition.platform.FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = com.google.android.material.transition.platform.TransitionUtils.lerp(f4, f6, f2, f3, f, true);
            float f8 = lerp / f4;
            float f9 = lerp / f6;
            return new com.google.android.material.transition.platform.FitModeResult(f8, f9, lerp, f5 * f8, lerp, f7 * f9);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(com.google.android.material.transition.platform.FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FitModeEvaluators$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.android.material.transition.platform.FitModeEvaluator {
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(android.graphics.RectF rectF, float f, com.google.android.material.transition.platform.FitModeResult fitModeResult) {
            float abs = (java.lang.Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public com.google.android.material.transition.platform.FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = com.google.android.material.transition.platform.TransitionUtils.lerp(f5, f7, f2, f3, f, true);
            float f8 = lerp / f5;
            float f9 = lerp / f7;
            return new com.google.android.material.transition.platform.FitModeResult(f8, f9, f4 * f8, lerp, f6 * f9, lerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(com.google.android.material.transition.platform.FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    }

    private FitModeEvaluators() {
    }

    public static com.google.android.material.transition.platform.FitModeEvaluator get(int i, boolean z, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        if (i == 0) {
            return shouldAutoFitToWidth(z, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i == 1) {
            return WIDTH;
        }
        if (i == 2) {
            return HEIGHT;
        }
        throw new java.lang.IllegalArgumentException("Invalid fit mode: " + i);
    }

    private static boolean shouldAutoFitToWidth(boolean z, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f = (height2 * width) / width2;
        float f2 = (width2 * height) / width;
        if (z) {
            if (f >= height) {
                return true;
            }
        } else if (f2 >= height2) {
            return true;
        }
        return false;
    }
}
