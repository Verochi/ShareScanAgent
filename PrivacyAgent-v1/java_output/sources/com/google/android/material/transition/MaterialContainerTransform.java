package com.google.android.material.transition;

/* loaded from: classes22.dex */
public final class MaterialContainerTransform extends androidx.transition.Transition {
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final java.lang.String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private boolean appliedThemeValues;

    @androidx.annotation.ColorInt
    private int containerColor;
    private boolean drawDebugEnabled;

    @androidx.annotation.IdRes
    private int drawingViewId;
    private boolean elevationShadowEnabled;

    @androidx.annotation.ColorInt
    private int endContainerColor;
    private float endElevation;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.ShapeAppearanceModel endShapeAppearanceModel;

    @androidx.annotation.Nullable
    private android.view.View endView;

    @androidx.annotation.IdRes
    private int endViewId;
    private int fadeMode;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleMaskProgressThresholds;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleProgressThresholds;

    @androidx.annotation.ColorInt
    private int scrimColor;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds shapeMaskProgressThresholds;

    @androidx.annotation.ColorInt
    private int startContainerColor;
    private float startElevation;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.ShapeAppearanceModel startShapeAppearanceModel;

    @androidx.annotation.Nullable
    private android.view.View startView;

    @androidx.annotation.IdRes
    private int startViewId;
    private int transitionDirection;
    private static final java.lang.String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final java.lang.String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final java.lang.String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.25f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.75f), null);
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.6f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.3f, 0.9f), null);
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 0.4f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 0.9f), null);
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.6f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.2f, 0.9f), null);

    /* renamed from: com.google.android.material.transition.MaterialContainerTransform$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable val$transitionDrawable;

        public AnonymousClass1(com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable transitionDrawable) {
            this.val$transitionDrawable = transitionDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.val$transitionDrawable.setProgress(valueAnimator.getAnimatedFraction());
        }
    }

    /* renamed from: com.google.android.material.transition.MaterialContainerTransform$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.transition.TransitionListenerAdapter {
        final /* synthetic */ android.view.View val$drawingView;
        final /* synthetic */ android.view.View val$endView;
        final /* synthetic */ android.view.View val$startView;
        final /* synthetic */ com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable val$transitionDrawable;

        public AnonymousClass2(android.view.View view, com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable transitionDrawable, android.view.View view2, android.view.View view3) {
            this.val$drawingView = view;
            this.val$transitionDrawable = transitionDrawable;
            this.val$startView = view2;
            this.val$endView = view3;
        }

        @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            com.google.android.material.transition.MaterialContainerTransform.this.removeListener(this);
            if (com.google.android.material.transition.MaterialContainerTransform.this.holdAtEndEnabled) {
                return;
            }
            this.val$startView.setAlpha(1.0f);
            this.val$endView.setAlpha(1.0f);
            com.google.android.material.internal.ViewUtils.getOverlay(this.val$drawingView).remove(this.val$transitionDrawable);
        }

        @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            com.google.android.material.internal.ViewUtils.getOverlay(this.val$drawingView).add(this.val$transitionDrawable);
            this.val$startView.setAlpha(0.0f);
            this.val$endView.setAlpha(0.0f);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        private final float end;

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        private final float start;

        public ProgressThresholds(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.start = f;
            this.end = f2;
        }

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    public static class ProgressThresholdsGroup {

        @androidx.annotation.NonNull
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds fade;

        @androidx.annotation.NonNull
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scale;

        @androidx.annotation.NonNull
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleMask;

        @androidx.annotation.NonNull
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(@androidx.annotation.NonNull com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds, @androidx.annotation.NonNull com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds2, @androidx.annotation.NonNull com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds3, @androidx.annotation.NonNull com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds4) {
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }

        public /* synthetic */ ProgressThresholdsGroup(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds2, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds3, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds4, com.google.android.material.transition.MaterialContainerTransform.AnonymousClass1 anonymousClass1) {
            this(progressThresholds, progressThresholds2, progressThresholds3, progressThresholds4);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public static final class TransitionDrawable extends android.graphics.drawable.Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final com.google.android.material.shape.MaterialShapeDrawable compatShadowDrawable;
        private final android.graphics.Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final android.graphics.RectF currentEndBounds;
        private final android.graphics.RectF currentEndBoundsMasked;
        private android.graphics.RectF currentMaskBounds;
        private final android.graphics.RectF currentStartBounds;
        private final android.graphics.RectF currentStartBoundsMasked;
        private final android.graphics.Paint debugPaint;
        private final android.graphics.Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final android.graphics.RectF endBounds;
        private final android.graphics.Paint endContainerPaint;
        private final float endElevation;
        private final com.google.android.material.shape.ShapeAppearanceModel endShapeAppearanceModel;
        private final android.view.View endView;
        private final boolean entering;
        private final com.google.android.material.transition.FadeModeEvaluator fadeModeEvaluator;
        private com.google.android.material.transition.FadeModeResult fadeModeResult;
        private final com.google.android.material.transition.FitModeEvaluator fitModeEvaluator;
        private com.google.android.material.transition.FitModeResult fitModeResult;
        private final com.google.android.material.transition.MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final android.graphics.PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholds;
        private final android.graphics.Paint scrimPaint;
        private final android.graphics.Paint shadowPaint;
        private final android.graphics.RectF startBounds;
        private final android.graphics.Paint startContainerPaint;
        private final float startElevation;
        private final com.google.android.material.shape.ShapeAppearanceModel startShapeAppearanceModel;
        private final android.view.View startView;

        /* renamed from: com.google.android.material.transition.MaterialContainerTransform$TransitionDrawable$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.android.material.transition.TransitionUtils.CanvasOperation {
            public AnonymousClass1() {
            }

            @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
            public void run(android.graphics.Canvas canvas) {
                com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.this.startView.draw(canvas);
            }
        }

        /* renamed from: com.google.android.material.transition.MaterialContainerTransform$TransitionDrawable$2, reason: invalid class name */
        public class AnonymousClass2 implements com.google.android.material.transition.TransitionUtils.CanvasOperation {
            public AnonymousClass2() {
            }

            @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
            public void run(android.graphics.Canvas canvas) {
                com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.this.endView.draw(canvas);
            }
        }

        private TransitionDrawable(androidx.transition.PathMotion pathMotion, android.view.View view, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f, android.view.View view2, android.graphics.RectF rectF2, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, float f2, @androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, @androidx.annotation.ColorInt int i3, int i4, boolean z, boolean z2, com.google.android.material.transition.FadeModeEvaluator fadeModeEvaluator, com.google.android.material.transition.FitModeEvaluator fitModeEvaluator, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup, boolean z3) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.containerPaint = paint;
            android.graphics.Paint paint2 = new android.graphics.Paint();
            this.startContainerPaint = paint2;
            android.graphics.Paint paint3 = new android.graphics.Paint();
            this.endContainerPaint = paint3;
            this.shadowPaint = new android.graphics.Paint();
            android.graphics.Paint paint4 = new android.graphics.Paint();
            this.scrimPaint = paint4;
            this.maskEvaluator = new com.google.android.material.transition.MaskEvaluator();
            this.motionPathPosition = new float[]{rectF.centerX(), rectF.top};
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            this.compatShadowDrawable = materialShapeDrawable;
            android.graphics.Paint paint5 = new android.graphics.Paint();
            this.debugPaint = paint5;
            this.debugPath = new android.graphics.Path();
            this.startView = view;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.startElevation = f;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.endElevation = f2;
            this.entering = z;
            this.elevationShadowEnabled = z2;
            this.fadeModeEvaluator = fadeModeEvaluator;
            this.fitModeEvaluator = fitModeEvaluator;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z3;
            android.view.WindowManager windowManager = (android.view.WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new android.util.DisplayMetrics());
            this.displayWidth = r12.widthPixels;
            this.displayHeight = r12.heightPixels;
            paint.setColor(i);
            paint2.setColor(i2);
            paint3.setColor(i3);
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(COMPAT_SHADOW_COLOR);
            android.graphics.RectF rectF3 = new android.graphics.RectF(rectF);
            this.currentStartBounds = rectF3;
            this.currentStartBoundsMasked = new android.graphics.RectF(rectF3);
            android.graphics.RectF rectF4 = new android.graphics.RectF(rectF3);
            this.currentEndBounds = rectF4;
            this.currentEndBoundsMasked = new android.graphics.RectF(rectF4);
            android.graphics.PointF motionPathPoint = getMotionPathPoint(rectF);
            android.graphics.PointF motionPathPoint2 = getMotionPathPoint(rectF2);
            android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(pathMotion.getPath(motionPathPoint.x, motionPathPoint.y, motionPathPoint2.x, motionPathPoint2.y), false);
            this.motionPathMeasure = pathMeasure;
            this.motionPathLength = pathMeasure.getLength();
            paint4.setStyle(android.graphics.Paint.Style.FILL);
            paint4.setShader(com.google.android.material.transition.TransitionUtils.createColorShader(i4));
            paint5.setStyle(android.graphics.Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        public /* synthetic */ TransitionDrawable(androidx.transition.PathMotion pathMotion, android.view.View view, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f, android.view.View view2, android.graphics.RectF rectF2, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, com.google.android.material.transition.FadeModeEvaluator fadeModeEvaluator, com.google.android.material.transition.FitModeEvaluator fitModeEvaluator, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup, boolean z3, com.google.android.material.transition.MaterialContainerTransform.AnonymousClass1 anonymousClass1) {
            this(pathMotion, view, rectF, shapeAppearanceModel, f, view2, rectF2, shapeAppearanceModel2, f2, i, i2, i3, i4, z, z2, fadeModeEvaluator, fitModeEvaluator, progressThresholdsGroup, z3);
        }

        private static float calculateElevationDxMultiplier(android.graphics.RectF rectF, float f) {
            return ((rectF.centerX() / (f / 2.0f)) - 1.0f) * SHADOW_DX_MULTIPLIER_ADJUSTMENT;
        }

        private static float calculateElevationDyMultiplier(android.graphics.RectF rectF, float f) {
            return (rectF.centerY() / f) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Path path, @androidx.annotation.ColorInt int i) {
            android.graphics.PointF motionPathPoint = getMotionPathPoint(rectF);
            if (this.progress == 0.0f) {
                path.reset();
                path.moveTo(motionPathPoint.x, motionPathPoint.y);
            } else {
                path.lineTo(motionPathPoint.x, motionPathPoint.y);
                this.debugPaint.setColor(i);
                canvas.drawPath(path, this.debugPaint);
            }
        }

        private void drawDebugRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, @androidx.annotation.ColorInt int i) {
            this.debugPaint.setColor(i);
            canvas.drawRect(rectF, this.debugPaint);
        }

        private void drawElevationShadow(android.graphics.Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.maskEvaluator.getPath(), android.graphics.Region.Op.DIFFERENCE);
            if (android.os.Build.VERSION.SDK_INT > 28) {
                drawElevationShadowWithPaintShadowLayer(canvas);
            } else {
                drawElevationShadowWithMaterialShapeDrawable(canvas);
            }
            canvas.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(android.graphics.Canvas canvas) {
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.compatShadowDrawable;
            android.graphics.RectF rectF = this.currentMaskBounds;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(canvas);
        }

        private void drawElevationShadowWithPaintShadowLayer(android.graphics.Canvas canvas) {
            com.google.android.material.shape.ShapeAppearanceModel currentShapeAppearanceModel = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (!currentShapeAppearanceModel.isRoundRect(this.currentMaskBounds)) {
                canvas.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
            } else {
                float cornerSize = currentShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
                canvas.drawRoundRect(this.currentMaskBounds, cornerSize, cornerSize, this.shadowPaint);
            }
        }

        private void drawEndView(android.graphics.Canvas canvas) {
            maybeDrawContainerColor(canvas, this.endContainerPaint);
            android.graphics.Rect bounds = getBounds();
            android.graphics.RectF rectF = this.currentEndBounds;
            com.google.android.material.transition.TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.AnonymousClass2());
        }

        private void drawStartView(android.graphics.Canvas canvas) {
            maybeDrawContainerColor(canvas, this.startContainerPaint);
            android.graphics.Rect bounds = getBounds();
            android.graphics.RectF rectF = this.currentStartBounds;
            com.google.android.material.transition.TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.AnonymousClass1());
        }

        private static android.graphics.PointF getMotionPathPoint(android.graphics.RectF rectF) {
            return new android.graphics.PointF(rectF.centerX(), rectF.top);
        }

        private void maybeDrawContainerColor(android.graphics.Canvas canvas, android.graphics.Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgress(float f) {
            if (this.progress != f) {
                updateProgress(f);
            }
        }

        private void updateProgress(float f) {
            float f2;
            float f3;
            this.progress = f;
            this.scrimPaint.setAlpha((int) (this.entering ? com.google.android.material.transition.TransitionUtils.lerp(0.0f, 255.0f, f) : com.google.android.material.transition.TransitionUtils.lerp(255.0f, 0.0f, f)));
            this.motionPathMeasure.getPosTan(this.motionPathLength * f, this.motionPathPosition, null);
            float[] fArr = this.motionPathPosition;
            float f4 = fArr[0];
            float f5 = fArr[1];
            if (f > 1.0f || f < 0.0f) {
                if (f > 1.0f) {
                    f3 = (f - 1.0f) / 0.00999999f;
                    f2 = 0.99f;
                } else {
                    f2 = 0.01f;
                    f3 = (f / 0.01f) * (-1.0f);
                }
                this.motionPathMeasure.getPosTan(this.motionPathLength * f2, fArr, null);
                float[] fArr2 = this.motionPathPosition;
                f4 += (f4 - fArr2[0]) * f3;
                f5 += (f5 - fArr2[1]) * f3;
            }
            float f6 = f4;
            float f7 = f5;
            com.google.android.material.transition.FitModeResult evaluate = this.fitModeEvaluator.evaluate(f, ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.scale.start))).floatValue(), ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.scale.end))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = evaluate;
            android.graphics.RectF rectF = this.currentStartBounds;
            float f8 = evaluate.currentStartWidth;
            rectF.set(f6 - (f8 / 2.0f), f7, (f8 / 2.0f) + f6, evaluate.currentStartHeight + f7);
            android.graphics.RectF rectF2 = this.currentEndBounds;
            com.google.android.material.transition.FitModeResult fitModeResult = this.fitModeResult;
            float f9 = fitModeResult.currentEndWidth;
            rectF2.set(f6 - (f9 / 2.0f), f7, f6 + (f9 / 2.0f), fitModeResult.currentEndHeight + f7);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float floatValue = ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.scaleMask.start))).floatValue();
            float floatValue2 = ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.scaleMask.end))).floatValue();
            boolean shouldMaskStartBounds = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            android.graphics.RectF rectF3 = shouldMaskStartBounds ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
            float lerp = com.google.android.material.transition.TransitionUtils.lerp(0.0f, 1.0f, floatValue, floatValue2, f);
            if (!shouldMaskStartBounds) {
                lerp = 1.0f - lerp;
            }
            this.fitModeEvaluator.applyMask(rectF3, lerp, this.fitModeResult);
            this.currentMaskBounds = new android.graphics.RectF(java.lang.Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), java.lang.Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), java.lang.Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), java.lang.Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(f, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
            this.currentElevation = com.google.android.material.transition.TransitionUtils.lerp(this.startElevation, this.endElevation, f);
            float calculateElevationDxMultiplier = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float calculateElevationDyMultiplier = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float f10 = this.currentElevation;
            float f11 = (int) (calculateElevationDyMultiplier * f10);
            this.currentElevationDy = f11;
            this.shadowPaint.setShadowLayer(f10, (int) (calculateElevationDxMultiplier * f10), f11, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(f, ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.fade.start))).floatValue(), ((java.lang.Float) androidx.core.util.Preconditions.checkNotNull(java.lang.Float.valueOf(this.progressThresholds.fade.end))).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() != 0) {
                this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
            }
            if (this.endContainerPaint.getColor() != 0) {
                this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
            if (this.scrimPaint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.scrimPaint);
            }
            int save = this.drawDebugEnabled ? canvas.save() : -1;
            if (this.elevationShadowEnabled && this.currentElevation > 0.0f) {
                drawElevationShadow(canvas);
            }
            this.maskEvaluator.clip(canvas);
            maybeDrawContainerColor(canvas, this.containerPaint);
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (this.drawDebugEnabled) {
                canvas.restoreToCount(save);
                drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, -65281);
                drawDebugRect(canvas, this.currentStartBoundsMasked, androidx.core.view.InputDeviceCompat.SOURCE_ANY);
                drawDebugRect(canvas, this.currentStartBounds, -16711936);
                drawDebugRect(canvas, this.currentEndBoundsMasked, -16711681);
                drawDebugRect(canvas, this.currentEndBounds, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            throw new java.lang.UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
            throw new java.lang.UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = android.R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = android.os.Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
    }

    public MaterialContainerTransform(@androidx.annotation.NonNull android.content.Context context, boolean z) {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = android.R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = android.os.Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        maybeApplyThemeValues(context, z);
        this.appliedThemeValues = true;
    }

    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup buildThresholdsGroup(boolean z) {
        androidx.transition.PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof androidx.transition.ArcMotion) || (pathMotion instanceof com.google.android.material.transition.MaterialArcMotion)) ? getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static android.graphics.RectF calculateDrawableBounds(android.view.View view, @androidx.annotation.Nullable android.view.View view2, float f, float f2) {
        if (view2 == null) {
            return new android.graphics.RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        android.graphics.RectF locationOnScreen = com.google.android.material.transition.TransitionUtils.getLocationOnScreen(view2);
        locationOnScreen.offset(f, f2);
        return locationOnScreen;
    }

    private static com.google.android.material.shape.ShapeAppearanceModel captureShapeAppearance(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        return com.google.android.material.transition.TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModel), rectF);
    }

    private static void captureValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.IdRes int i, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (i != -1) {
            transitionValues.view = com.google.android.material.transition.TransitionUtils.findDescendantOrAncestorById(transitionValues.view, i);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            android.view.View view2 = transitionValues.view;
            int i2 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i2) instanceof android.view.View) {
                android.view.View view3 = (android.view.View) transitionValues.view.getTag(i2);
                transitionValues.view.setTag(i2, null);
                transitionValues.view = view3;
            }
        }
        android.view.View view4 = transitionValues.view;
        if (!androidx.core.view.ViewCompat.isLaidOut(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        android.graphics.RectF relativeBounds = view4.getParent() == null ? com.google.android.material.transition.TransitionUtils.getRelativeBounds(view4) : com.google.android.material.transition.TransitionUtils.getLocationOnScreen(view4);
        transitionValues.values.put(PROP_BOUNDS, relativeBounds);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view4, relativeBounds, shapeAppearanceModel));
    }

    private static float getElevationOrDefault(float f, android.view.View view) {
        return f != -1.0f ? f : androidx.core.view.ViewCompat.getElevation(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.shape.ShapeAppearanceModel getShapeAppearance(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i) instanceof com.google.android.material.shape.ShapeAppearanceModel) {
            return (com.google.android.material.shape.ShapeAppearanceModel) view.getTag(i);
        }
        android.content.Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        return transitionShapeAppearanceResId != -1 ? com.google.android.material.shape.ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build() : view instanceof com.google.android.material.shape.Shapeable ? ((com.google.android.material.shape.Shapeable) view).getShapeAppearanceModel() : com.google.android.material.shape.ShapeAppearanceModel.builder().build();
    }

    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup getThresholdsOrDefault(boolean z, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup((com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.fadeProgressThresholds, progressThresholdsGroup.fade), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.scaleProgressThresholds, progressThresholdsGroup.scale), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, progressThresholdsGroup.scaleMask), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, progressThresholdsGroup.shapeMask), null);
    }

    @androidx.annotation.StyleRes
    private static int getTransitionShapeAppearanceResId(android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(@androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.RectF rectF2) {
        int i = this.transitionDirection;
        if (i == 0) {
            return com.google.android.material.transition.TransitionUtils.calculateArea(rectF2) > com.google.android.material.transition.TransitionUtils.calculateArea(rectF);
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new java.lang.IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    }

    private void maybeApplyThemeValues(android.content.Context context, boolean z) {
        com.google.android.material.transition.TransitionUtils.maybeApplyThemeInterpolator(this, context, com.google.android.material.R.attr.motionEasingStandard, com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        com.google.android.material.transition.TransitionUtils.maybeApplyThemeDuration(this, context, z ? com.google.android.material.R.attr.motionDurationLong1 : com.google.android.material.R.attr.motionDurationMedium2);
        if (this.pathMotionCustom) {
            return;
        }
        com.google.android.material.transition.TransitionUtils.maybeApplyThemePath(this, context, com.google.android.material.R.attr.motionPath);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        android.view.View findAncestorById;
        android.view.View view;
        if (transitionValues != null && transitionValues2 != null) {
            android.graphics.RectF rectF = (android.graphics.RectF) transitionValues.values.get(PROP_BOUNDS);
            com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = (com.google.android.material.shape.ShapeAppearanceModel) transitionValues.values.get(PROP_SHAPE_APPEARANCE);
            if (rectF != null && shapeAppearanceModel != null) {
                android.graphics.RectF rectF2 = (android.graphics.RectF) transitionValues2.values.get(PROP_BOUNDS);
                com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2 = (com.google.android.material.shape.ShapeAppearanceModel) transitionValues2.values.get(PROP_SHAPE_APPEARANCE);
                if (rectF2 != null && shapeAppearanceModel2 != null) {
                    android.view.View view2 = transitionValues.view;
                    android.view.View view3 = transitionValues2.view;
                    android.view.View view4 = view3.getParent() != null ? view3 : view2;
                    if (this.drawingViewId == view4.getId()) {
                        findAncestorById = (android.view.View) view4.getParent();
                        view = view4;
                    } else {
                        findAncestorById = com.google.android.material.transition.TransitionUtils.findAncestorById(view4, this.drawingViewId);
                        view = null;
                    }
                    android.graphics.RectF locationOnScreen = com.google.android.material.transition.TransitionUtils.getLocationOnScreen(findAncestorById);
                    float f = -locationOnScreen.left;
                    float f2 = -locationOnScreen.top;
                    android.graphics.RectF calculateDrawableBounds = calculateDrawableBounds(findAncestorById, view, f, f2);
                    rectF.offset(f, f2);
                    rectF2.offset(f, f2);
                    boolean isEntering = isEntering(rectF, rectF2);
                    if (!this.appliedThemeValues) {
                        maybeApplyThemeValues(view4.getContext(), isEntering);
                    }
                    com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable transitionDrawable = new com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable(getPathMotion(), view2, rectF, shapeAppearanceModel, getElevationOrDefault(this.startElevation, view2), view3, rectF2, shapeAppearanceModel2, getElevationOrDefault(this.endElevation, view3), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, isEntering, this.elevationShadowEnabled, com.google.android.material.transition.FadeModeEvaluators.get(this.fadeMode, isEntering), com.google.android.material.transition.FitModeEvaluators.get(this.fitMode, isEntering, rectF, rectF2), buildThresholdsGroup(isEntering), this.drawDebugEnabled, null);
                    transitionDrawable.setBounds(java.lang.Math.round(calculateDrawableBounds.left), java.lang.Math.round(calculateDrawableBounds.top), java.lang.Math.round(calculateDrawableBounds.right), java.lang.Math.round(calculateDrawableBounds.bottom));
                    android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new com.google.android.material.transition.MaterialContainerTransform.AnonymousClass1(transitionDrawable));
                    addListener(new com.google.android.material.transition.MaterialContainerTransform.AnonymousClass2(findAncestorById, transitionDrawable, view2, view3));
                    return ofFloat;
                }
            }
        }
        return null;
    }

    @androidx.annotation.ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @androidx.annotation.IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @androidx.annotation.ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.shape.ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @androidx.annotation.Nullable
    public android.view.View getEndView() {
        return this.endView;
    }

    @androidx.annotation.IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @androidx.annotation.ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @androidx.annotation.ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.shape.ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @androidx.annotation.Nullable
    public android.view.View getStartView() {
        return this.startView;
    }

    @androidx.annotation.IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public java.lang.String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@androidx.annotation.ColorInt int i) {
        this.containerColor = i;
        this.startContainerColor = i;
        this.endContainerColor = i;
    }

    public void setContainerColor(@androidx.annotation.ColorInt int i) {
        this.containerColor = i;
    }

    public void setDrawDebugEnabled(boolean z) {
        this.drawDebugEnabled = z;
    }

    public void setDrawingViewId(@androidx.annotation.IdRes int i) {
        this.drawingViewId = i;
    }

    public void setElevationShadowEnabled(boolean z) {
        this.elevationShadowEnabled = z;
    }

    public void setEndContainerColor(@androidx.annotation.ColorInt int i) {
        this.endContainerColor = i;
    }

    public void setEndElevation(float f) {
        this.endElevation = f;
    }

    public void setEndShapeAppearanceModel(@androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setEndView(@androidx.annotation.Nullable android.view.View view) {
        this.endView = view;
    }

    public void setEndViewId(@androidx.annotation.IdRes int i) {
        this.endViewId = i;
    }

    public void setFadeMode(int i) {
        this.fadeMode = i;
    }

    public void setFadeProgressThresholds(@androidx.annotation.Nullable com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public void setFitMode(int i) {
        this.fitMode = i;
    }

    public void setHoldAtEndEnabled(boolean z) {
        this.holdAtEndEnabled = z;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@androidx.annotation.Nullable androidx.transition.PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@androidx.annotation.Nullable com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public void setScaleProgressThresholds(@androidx.annotation.Nullable com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public void setScrimColor(@androidx.annotation.ColorInt int i) {
        this.scrimColor = i;
    }

    public void setShapeMaskProgressThresholds(@androidx.annotation.Nullable com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public void setStartContainerColor(@androidx.annotation.ColorInt int i) {
        this.startContainerColor = i;
    }

    public void setStartElevation(float f) {
        this.startElevation = f;
    }

    public void setStartShapeAppearanceModel(@androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setStartView(@androidx.annotation.Nullable android.view.View view) {
        this.startView = view;
    }

    public void setStartViewId(@androidx.annotation.IdRes int i) {
        this.startViewId = i;
    }

    public void setTransitionDirection(int i) {
        this.transitionDirection = i;
    }
}
