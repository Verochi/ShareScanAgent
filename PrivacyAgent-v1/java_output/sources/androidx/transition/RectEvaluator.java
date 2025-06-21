package androidx.transition;

/* loaded from: classes.dex */
class RectEvaluator implements android.animation.TypeEvaluator<android.graphics.Rect> {
    private android.graphics.Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(android.graphics.Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public android.graphics.Rect evaluate(float f, android.graphics.Rect rect, android.graphics.Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f));
        int i2 = rect.top + ((int) ((rect2.top - r1) * f));
        int i3 = rect.right + ((int) ((rect2.right - r2) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - r6) * f));
        android.graphics.Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new android.graphics.Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.mRect;
    }
}
