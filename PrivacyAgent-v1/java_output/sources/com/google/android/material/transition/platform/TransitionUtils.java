package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class TransitionUtils {
    private static final java.lang.String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final java.lang.String EASING_TYPE_FORMAT_END = ")";
    private static final java.lang.String EASING_TYPE_FORMAT_START = "(";
    private static final java.lang.String EASING_TYPE_PATH = "path";

    @androidx.annotation.AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final android.graphics.RectF transformAlphaRectF = new android.graphics.RectF();

    /* renamed from: com.google.android.material.transition.platform.TransitionUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator {
        final /* synthetic */ android.graphics.RectF val$bounds;

        public AnonymousClass1(android.graphics.RectF rectF) {
            this.val$bounds = rectF;
        }

        @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
        @androidx.annotation.NonNull
        public com.google.android.material.shape.CornerSize apply(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return cornerSize instanceof com.google.android.material.shape.RelativeCornerSize ? cornerSize : new com.google.android.material.shape.RelativeCornerSize(cornerSize.getCornerSize(this.val$bounds) / this.val$bounds.height());
        }
    }

    /* renamed from: com.google.android.material.transition.platform.TransitionUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator {
        final /* synthetic */ android.graphics.RectF val$endBounds;
        final /* synthetic */ float val$endFraction;
        final /* synthetic */ float val$fraction;
        final /* synthetic */ android.graphics.RectF val$startBounds;
        final /* synthetic */ float val$startFraction;

        public AnonymousClass2(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, float f3) {
            this.val$startBounds = rectF;
            this.val$endBounds = rectF2;
            this.val$startFraction = f;
            this.val$endFraction = f2;
            this.val$fraction = f3;
        }

        @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
        @androidx.annotation.NonNull
        public com.google.android.material.shape.CornerSize apply(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize2) {
            return new com.google.android.material.shape.AbsoluteCornerSize(com.google.android.material.transition.platform.TransitionUtils.lerp(cornerSize.getCornerSize(this.val$startBounds), cornerSize2.getCornerSize(this.val$endBounds), this.val$startFraction, this.val$endFraction, this.val$fraction));
        }
    }

    public interface CanvasOperation {
        void run(android.graphics.Canvas canvas);
    }

    public interface CornerSizeBinaryOperator {
        @androidx.annotation.NonNull
        com.google.android.material.shape.CornerSize apply(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    public static float calculateArea(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        return rectF.width() * rectF.height();
    }

    public static com.google.android.material.shape.ShapeAppearanceModel convertToRelativeCornerSizes(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.graphics.RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new com.google.android.material.transition.platform.TransitionUtils.AnonymousClass1(rectF));
    }

    public static android.graphics.Shader createColorShader(@androidx.annotation.ColorInt int i) {
        return new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, android.graphics.Shader.TileMode.CLAMP);
    }

    @androidx.annotation.NonNull
    public static <T> T defaultIfNull(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull T t2) {
        return t != null ? t : t2;
    }

    public static android.view.View findAncestorById(android.view.View view, @androidx.annotation.IdRes int i) {
        java.lang.String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                java.lang.Object parent = view.getParent();
                if (!(parent instanceof android.view.View)) {
                    break;
                }
                view = (android.view.View) parent;
            } else {
                return view;
            }
        }
        throw new java.lang.IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    public static android.view.View findDescendantOrAncestorById(android.view.View view, @androidx.annotation.IdRes int i) {
        android.view.View findViewById = view.findViewById(i);
        return findViewById != null ? findViewById : findAncestorById(view, i);
    }

    private static float getControlPoint(java.lang.String[] strArr, int i) {
        float parseFloat = java.lang.Float.parseFloat(strArr[i]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new java.lang.IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static java.lang.String getEasingContent(java.lang.String str, java.lang.String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static android.graphics.RectF getLocationOnScreen(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new android.graphics.RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static android.graphics.RectF getRelativeBounds(android.view.View view) {
        return new android.graphics.RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static android.graphics.Rect getRelativeBoundsRect(android.view.View view) {
        return new android.graphics.Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean isEasingType(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append(EASING_TYPE_FORMAT_START);
        return str.startsWith(sb.toString()) && str.endsWith(EASING_TYPE_FORMAT_END);
    }

    private static boolean isShapeAppearanceSignificant(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.graphics.RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static float lerp(float f, float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f4, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return lerp(f, f2, f3, f4, f5, false);
    }

    public static float lerp(float f, float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f4, @androidx.annotation.FloatRange(from = 0.0d) float f5, boolean z) {
        return (!z || (f5 >= 0.0f && f5 <= 1.0f)) ? f5 < f3 ? f : f5 > f4 ? f2 : lerp(f, f2, (f5 - f3) / (f4 - f3)) : lerp(f, f2, f5);
    }

    public static int lerp(int i, int i2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) lerp(i, i2, (f3 - f) / (f2 - f));
    }

    public static com.google.android.material.shape.ShapeAppearanceModel lerp(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, android.graphics.RectF rectF, android.graphics.RectF rectF2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f3 < f ? shapeAppearanceModel : f3 > f2 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new com.google.android.material.transition.platform.TransitionUtils.AnonymousClass2(rectF, rectF2, f, f2, f3));
    }

    public static void maybeAddTransition(android.transition.TransitionSet transitionSet, @androidx.annotation.Nullable android.transition.Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static boolean maybeApplyThemeDuration(android.transition.Transition transition, android.content.Context context, @androidx.annotation.AttrRes int i) {
        int resolveInteger;
        if (i == 0 || transition.getDuration() != -1 || (resolveInteger = com.google.android.material.resources.MaterialAttributes.resolveInteger(context, i, -1)) == -1) {
            return false;
        }
        transition.setDuration(resolveInteger);
        return true;
    }

    public static boolean maybeApplyThemeInterpolator(android.transition.Transition transition, android.content.Context context, @androidx.annotation.AttrRes int i, android.animation.TimeInterpolator timeInterpolator) {
        if (i == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(resolveThemeInterpolator(context, i, timeInterpolator));
        return true;
    }

    public static boolean maybeApplyThemePath(android.transition.Transition transition, android.content.Context context, @androidx.annotation.AttrRes int i) {
        android.transition.PathMotion resolveThemePath;
        if (i == 0 || (resolveThemePath = resolveThemePath(context, i)) == null) {
            return false;
        }
        transition.setPathMotion(resolveThemePath);
        return true;
    }

    public static void maybeRemoveTransition(android.transition.TransitionSet transitionSet, @androidx.annotation.Nullable android.transition.Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    public static android.animation.TimeInterpolator resolveThemeInterpolator(android.content.Context context, @androidx.annotation.AttrRes int i, @androidx.annotation.NonNull android.animation.TimeInterpolator timeInterpolator) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new java.lang.IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        java.lang.String valueOf = java.lang.String.valueOf(typedValue.string);
        if (!isEasingType(valueOf, EASING_TYPE_CUBIC_BEZIER)) {
            if (isEasingType(valueOf, "path")) {
                return androidx.core.view.animation.PathInterpolatorCompat.create(androidx.core.graphics.PathParser.createPathFromPathData(getEasingContent(valueOf, "path")));
            }
            throw new java.lang.IllegalArgumentException("Invalid motion easing type: " + valueOf);
        }
        java.lang.String[] split = getEasingContent(valueOf, EASING_TYPE_CUBIC_BEZIER).split(",");
        if (split.length == 4) {
            return androidx.core.view.animation.PathInterpolatorCompat.create(getControlPoint(split, 0), getControlPoint(split, 1), getControlPoint(split, 2), getControlPoint(split, 3));
        }
        throw new java.lang.IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
    }

    @androidx.annotation.Nullable
    public static android.transition.PathMotion resolveThemePath(android.content.Context context, @androidx.annotation.AttrRes int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.type;
        if (i2 != 16) {
            if (i2 == 3) {
                return new android.transition.PatternPathMotion(androidx.core.graphics.PathParser.createPathFromPathData(java.lang.String.valueOf(typedValue.string)));
            }
            throw new java.lang.IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
        int i3 = typedValue.data;
        if (i3 == 0) {
            return null;
        }
        if (i3 == 1) {
            return new com.google.android.material.transition.platform.MaterialArcMotion();
        }
        throw new java.lang.IllegalArgumentException("Invalid motion path type: " + i3);
    }

    private static int saveLayerAlphaCompat(android.graphics.Canvas canvas, android.graphics.Rect rect, int i) {
        android.graphics.RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i);
    }

    public static void transform(android.graphics.Canvas canvas, android.graphics.Rect rect, float f, float f2, float f3, int i, com.google.android.material.transition.platform.TransitionUtils.CanvasOperation canvasOperation) {
        if (i <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            saveLayerAlphaCompat(canvas, rect, i);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(save);
    }

    public static com.google.android.material.shape.ShapeAppearanceModel transformCornerSizes(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, android.graphics.RectF rectF, com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }
}
