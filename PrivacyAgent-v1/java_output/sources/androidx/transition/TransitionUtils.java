package androidx.transition;

/* loaded from: classes.dex */
class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    private static final boolean HAS_OVERLAY;
    private static final boolean HAS_PICTURE_BITMAP;
    private static final int MAX_IMAGE_SIZE = 1048576;

    public static class MatrixEvaluator implements android.animation.TypeEvaluator<android.graphics.Matrix> {
        final float[] mTempStartValues = new float[9];
        final float[] mTempEndValues = new float[9];
        final android.graphics.Matrix mTempMatrix = new android.graphics.Matrix();

        @Override // android.animation.TypeEvaluator
        public android.graphics.Matrix evaluate(float f, android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mTempEndValues;
                float f2 = fArr[i];
                float f3 = this.mTempStartValues[i];
                fArr[i] = f3 + ((f2 - f3) * f);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        HAS_PICTURE_BITMAP = i >= 28;
    }

    private TransitionUtils() {
    }

    public static android.view.View copyViewImage(android.view.ViewGroup viewGroup, android.view.View view, android.view.View view2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        androidx.transition.ViewUtils.transformMatrixToGlobal(view, matrix);
        androidx.transition.ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = java.lang.Math.round(rectF.left);
        int round2 = java.lang.Math.round(rectF.top);
        int round3 = java.lang.Math.round(rectF.right);
        int round4 = java.lang.Math.round(rectF.bottom);
        android.widget.ImageView imageView = new android.widget.ImageView(view.getContext());
        imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        android.graphics.Bitmap createViewBitmap = createViewBitmap(view, matrix, rectF, viewGroup);
        if (createViewBitmap != null) {
            imageView.setImageBitmap(createViewBitmap);
        }
        imageView.measure(android.view.View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Bitmap createViewBitmap(android.view.View view, android.graphics.Matrix matrix, android.graphics.RectF rectF, android.view.ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        boolean z3;
        android.view.ViewGroup viewGroup2;
        int i;
        int round;
        int round2;
        if (HAS_IS_ATTACHED_TO_WINDOW) {
            z = !view.isAttachedToWindow();
            if (viewGroup != null) {
                z2 = viewGroup.isAttachedToWindow();
                z3 = HAS_OVERLAY;
                android.graphics.Bitmap bitmap = null;
                if (z3 || !z) {
                    viewGroup2 = null;
                    i = 0;
                } else {
                    if (!z2) {
                        return null;
                    }
                    viewGroup2 = (android.view.ViewGroup) view.getParent();
                    i = viewGroup2.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                }
                round = java.lang.Math.round(rectF.width());
                round2 = java.lang.Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = java.lang.Math.min(1.0f, 1048576.0f / (round * round2));
                    int round3 = java.lang.Math.round(round * min);
                    int round4 = java.lang.Math.round(round2 * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (HAS_PICTURE_BITMAP) {
                        bitmap = android.graphics.Bitmap.createBitmap(round3, round4, android.graphics.Bitmap.Config.ARGB_8888);
                        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    } else {
                        android.graphics.Picture picture = new android.graphics.Picture();
                        android.graphics.Canvas beginRecording = picture.beginRecording(round3, round4);
                        beginRecording.concat(matrix);
                        view.draw(beginRecording);
                        picture.endRecording();
                        bitmap = android.graphics.Bitmap.createBitmap(picture);
                    }
                }
                if (z3 && z) {
                    viewGroup.getOverlay().remove(view);
                    viewGroup2.addView(view, i);
                }
                return bitmap;
            }
        } else {
            z = false;
        }
        z2 = false;
        z3 = HAS_OVERLAY;
        android.graphics.Bitmap bitmap2 = null;
        if (z3) {
        }
        viewGroup2 = null;
        i = 0;
        round = java.lang.Math.round(rectF.width());
        round2 = java.lang.Math.round(rectF.height());
        if (round > 0) {
            float min2 = java.lang.Math.min(1.0f, 1048576.0f / (round * round2));
            int round32 = java.lang.Math.round(round * min2);
            int round42 = java.lang.Math.round(round2 * min2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min2, min2);
            if (HAS_PICTURE_BITMAP) {
            }
        }
        if (z3) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i);
        }
        return bitmap2;
    }

    public static android.animation.Animator mergeAnimators(android.animation.Animator animator, android.animation.Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
