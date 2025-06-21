package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class FadeModeEvaluators {
    private static final com.google.android.material.transition.platform.FadeModeEvaluator IN = new com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass1();
    private static final com.google.android.material.transition.platform.FadeModeEvaluator OUT = new com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass2();
    private static final com.google.android.material.transition.platform.FadeModeEvaluator CROSS = new com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass3();
    private static final com.google.android.material.transition.platform.FadeModeEvaluator THROUGH = new com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass4();

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.android.material.transition.platform.FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public com.google.android.material.transition.platform.FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return com.google.android.material.transition.platform.FadeModeResult.endOnTop(255, com.google.android.material.transition.platform.TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.android.material.transition.platform.FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public com.google.android.material.transition.platform.FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return com.google.android.material.transition.platform.FadeModeResult.startOnTop(com.google.android.material.transition.platform.TransitionUtils.lerp(255, 0, f2, f3, f), 255);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.android.material.transition.platform.FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public com.google.android.material.transition.platform.FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return com.google.android.material.transition.platform.FadeModeResult.startOnTop(com.google.android.material.transition.platform.TransitionUtils.lerp(255, 0, f2, f3, f), com.google.android.material.transition.platform.TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.google.android.material.transition.platform.FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public com.google.android.material.transition.platform.FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            float f5 = ((f3 - f2) * f4) + f2;
            return com.google.android.material.transition.platform.FadeModeResult.startOnTop(com.google.android.material.transition.platform.TransitionUtils.lerp(255, 0, f2, f5, f), com.google.android.material.transition.platform.TransitionUtils.lerp(0, 255, f5, f3, f));
        }
    }

    private FadeModeEvaluators() {
    }

    public static com.google.android.material.transition.platform.FadeModeEvaluator get(int i, boolean z) {
        if (i == 0) {
            return z ? IN : OUT;
        }
        if (i == 1) {
            return z ? OUT : IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        throw new java.lang.IllegalArgumentException("Invalid fade mode: " + i);
    }
}
