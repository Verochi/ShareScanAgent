package com.google.android.material.shape;

/* loaded from: classes22.dex */
public final class RelativeCornerSize implements com.google.android.material.shape.CornerSize {
    private final float percent;

    public RelativeCornerSize(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.percent = f;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.android.material.shape.RelativeCornerSize) && this.percent == ((com.google.android.material.shape.RelativeCornerSize) obj).percent;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        return this.percent * rectF.height();
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getRelativePercent() {
        return this.percent;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Float.valueOf(this.percent)});
    }
}
