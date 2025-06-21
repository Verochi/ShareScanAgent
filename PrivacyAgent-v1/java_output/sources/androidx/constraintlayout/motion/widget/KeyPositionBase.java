package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
abstract class KeyPositionBase extends androidx.constraintlayout.motion.widget.Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = androidx.constraintlayout.motion.widget.Key.UNSET;

    public abstract void calcPosition(int i, int i2, float f, float f2, float f3, float f4);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(java.util.HashSet<java.lang.String> hashSet) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i, int i2, android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2);

    public abstract void positionAttributes(android.view.View view, android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, java.lang.String[] strArr, float[] fArr);
}
