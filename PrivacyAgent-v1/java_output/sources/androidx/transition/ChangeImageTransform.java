package androidx.transition;

/* loaded from: classes.dex */
public class ChangeImageTransform extends androidx.transition.Transition {
    private static final java.lang.String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final java.lang.String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final java.lang.String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_BOUNDS};
    private static final android.animation.TypeEvaluator<android.graphics.Matrix> NULL_MATRIX_EVALUATOR = new androidx.transition.ChangeImageTransform.AnonymousClass1();
    private static final android.util.Property<android.widget.ImageView, android.graphics.Matrix> ANIMATED_TRANSFORM_PROPERTY = new androidx.transition.ChangeImageTransform.AnonymousClass2(android.graphics.Matrix.class, "animatedTransform");

    /* renamed from: androidx.transition.ChangeImageTransform$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.animation.TypeEvaluator<android.graphics.Matrix> {
        @Override // android.animation.TypeEvaluator
        public android.graphics.Matrix evaluate(float f, android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
            return null;
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<android.widget.ImageView, android.graphics.Matrix> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.Matrix get(android.widget.ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public void set(android.widget.ImageView imageView, android.graphics.Matrix matrix) {
            androidx.transition.ImageViewUtils.animateTransform(imageView, matrix);
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        if ((view instanceof android.widget.ImageView) && view.getVisibility() == 0) {
            android.widget.ImageView imageView = (android.widget.ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            java.util.Map<java.lang.String, java.lang.Object> map = transitionValues.values;
            map.put(PROPNAME_BOUNDS, new android.graphics.Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put(PROPNAME_MATRIX, copyImageMatrix(imageView));
        }
    }

    private static android.graphics.Matrix centerCropMatrix(android.widget.ImageView imageView) {
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float max = java.lang.Math.max(width / f, height / f2);
        int round = java.lang.Math.round((width - (f * max)) / 2.0f);
        int round2 = java.lang.Math.round((height - (f2 * max)) / 2.0f);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }

    @androidx.annotation.NonNull
    private static android.graphics.Matrix copyImageMatrix(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i = androidx.transition.ChangeImageTransform.AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
            if (i == 1) {
                return fitXYMatrix(imageView);
            }
            if (i == 2) {
                return centerCropMatrix(imageView);
            }
        }
        return new android.graphics.Matrix(imageView.getImageMatrix());
    }

    private android.animation.ObjectAnimator createMatrixAnimator(android.widget.ImageView imageView, android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
        return android.animation.ObjectAnimator.ofObject(imageView, (android.util.Property<android.widget.ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (android.animation.TypeEvaluator) new androidx.transition.TransitionUtils.MatrixEvaluator(), (java.lang.Object[]) new android.graphics.Matrix[]{matrix, matrix2});
    }

    @androidx.annotation.NonNull
    private android.animation.ObjectAnimator createNullAnimator(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        android.util.Property<android.widget.ImageView, android.graphics.Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
        android.animation.TypeEvaluator<android.graphics.Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
        android.graphics.Matrix matrix = androidx.transition.MatrixUtils.IDENTITY_MATRIX;
        return android.animation.ObjectAnimator.ofObject(imageView, (android.util.Property<android.widget.ImageView, V>) property, (android.animation.TypeEvaluator) typeEvaluator, (java.lang.Object[]) new android.graphics.Matrix[]{matrix, matrix});
    }

    private static android.graphics.Matrix fitXYMatrix(android.widget.ImageView imageView) {
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        android.graphics.Rect rect = (android.graphics.Rect) transitionValues.values.get(PROPNAME_BOUNDS);
        android.graphics.Rect rect2 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        if (rect == null || rect2 == null) {
            return null;
        }
        android.graphics.Matrix matrix = (android.graphics.Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        android.graphics.Matrix matrix2 = (android.graphics.Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) transitionValues2.view;
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return createNullAnimator(imageView);
        }
        if (matrix == null) {
            matrix = androidx.transition.MatrixUtils.IDENTITY_MATRIX;
        }
        if (matrix2 == null) {
            matrix2 = androidx.transition.MatrixUtils.IDENTITY_MATRIX;
        }
        ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix);
        return createMatrixAnimator(imageView, matrix, matrix2);
    }

    @Override // androidx.transition.Transition
    public java.lang.String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
