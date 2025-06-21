package androidx.transition;

/* loaded from: classes.dex */
class ViewUtilsBase {
    private static final java.lang.String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static java.lang.reflect.Method sSetFrameMethod;
    private static java.lang.reflect.Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @android.annotation.SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        if (sSetFrameFetched) {
            return;
        }
        try {
            java.lang.Class cls = java.lang.Integer.TYPE;
            java.lang.reflect.Method declaredMethod = android.view.View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            sSetFrameMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (java.lang.NoSuchMethodException unused) {
        }
        sSetFrameFetched = true;
    }

    public void clearNonTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        if (view.getVisibility() == 0) {
            view.setTag(androidx.transition.R.id.save_non_transition_alpha, null);
        }
    }

    public float getTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        java.lang.Float f = (java.lang.Float) view.getTag(androidx.transition.R.id.save_non_transition_alpha);
        return f != null ? view.getAlpha() / f.floatValue() : view.getAlpha();
    }

    public void saveNonTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        int i = androidx.transition.R.id.save_non_transition_alpha;
        if (view.getTag(i) == null) {
            view.setTag(i, java.lang.Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.graphics.Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.mMatrixValues;
        if (fArr == null) {
            fArr = new float[9];
            this.mMatrixValues = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float sqrt = ((float) java.lang.Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) java.lang.Math.toDegrees(java.lang.Math.atan2(f, sqrt));
        float f2 = fArr[0] / sqrt;
        float f3 = fArr[4] / sqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    public void setLeftTopRightBottom(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
        fetchSetFrame();
        java.lang.reflect.Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
            } catch (java.lang.IllegalAccessException unused) {
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw new java.lang.RuntimeException(e.getCause());
            }
        }
    }

    public void setTransitionAlpha(@androidx.annotation.NonNull android.view.View view, float f) {
        java.lang.Float f2 = (java.lang.Float) view.getTag(androidx.transition.R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public void setTransitionVisibility(@androidx.annotation.NonNull android.view.View view, int i) {
        if (!sViewFlagsFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sViewFlagsFieldFetched = true;
        }
        java.lang.reflect.Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (java.lang.IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            transformMatrixToGlobal((android.view.View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        android.graphics.Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void transformMatrixToLocal(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            transformMatrixToLocal((android.view.View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        android.graphics.Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        android.graphics.Matrix matrix3 = new android.graphics.Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
