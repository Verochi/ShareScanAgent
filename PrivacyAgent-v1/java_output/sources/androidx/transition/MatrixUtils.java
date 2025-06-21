package androidx.transition;

/* loaded from: classes.dex */
class MatrixUtils {
    static final android.graphics.Matrix IDENTITY_MATRIX = new androidx.transition.MatrixUtils.AnonymousClass1();

    /* renamed from: androidx.transition.MatrixUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.graphics.Matrix {
        public void oops() {
            throw new java.lang.IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(android.graphics.Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(android.graphics.Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(android.graphics.Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(android.graphics.RectF rectF, android.graphics.RectF rectF2, android.graphics.Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f, float f2, float f3) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }
    }

    private MatrixUtils() {
    }
}
