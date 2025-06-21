package com.google.android.material.circularreveal;

/* loaded from: classes22.dex */
public interface CircularRevealWidget extends com.google.android.material.circularreveal.CircularRevealHelper.Delegate {

    public static class CircularRevealEvaluator implements android.animation.TypeEvaluator<com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo> {
        public static final android.animation.TypeEvaluator<com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealEvaluator();
        private final com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo((com.google.android.material.circularreveal.CircularRevealWidget.AnonymousClass1) null);

        @Override // android.animation.TypeEvaluator
        @androidx.annotation.NonNull
        public com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo evaluate(float f, @androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo, @androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo2) {
            this.revealInfo.set(com.google.android.material.math.MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f), com.google.android.material.math.MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f), com.google.android.material.math.MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo> {
        public static final android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealProperty("circularReveal");

        private CircularRevealProperty(java.lang.String str) {
            super(com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo.class, str);
        }

        @Override // android.util.Property
        @androidx.annotation.Nullable
        public com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo get(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget, @androidx.annotation.Nullable com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    public static class CircularRevealScrimColorProperty extends android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, java.lang.Integer> {
        public static final android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, java.lang.Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(java.lang.String str) {
            super(java.lang.Integer.class, str);
        }

        @Override // android.util.Property
        @androidx.annotation.NonNull
        public java.lang.Integer get(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget) {
            return java.lang.Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget, @androidx.annotation.NonNull java.lang.Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        private RevealInfo() {
        }

        public RevealInfo(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public /* synthetic */ RevealInfo(com.google.android.material.circularreveal.CircularRevealWidget.AnonymousClass1 anonymousClass1) {
            this();
        }

        public RevealInfo(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }

        public boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }

        public void set(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public void set(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo) {
            set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(android.graphics.Canvas canvas);

    @androidx.annotation.Nullable
    android.graphics.drawable.Drawable getCircularRevealOverlayDrawable();

    @androidx.annotation.ColorInt
    int getCircularRevealScrimColor();

    @androidx.annotation.Nullable
    com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    void setCircularRevealScrimColor(@androidx.annotation.ColorInt int i);

    void setRevealInfo(@androidx.annotation.Nullable com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo);
}
