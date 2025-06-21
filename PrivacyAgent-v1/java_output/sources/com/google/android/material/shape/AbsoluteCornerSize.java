package com.google.android.material.shape;

/* loaded from: classes22.dex */
public final class AbsoluteCornerSize implements com.google.android.material.shape.CornerSize {
    private final float size;

    public AbsoluteCornerSize(float f) {
        this.size = f;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.android.material.shape.AbsoluteCornerSize) && this.size == ((com.google.android.material.shape.AbsoluteCornerSize) obj).size;
    }

    public float getCornerSize() {
        return this.size;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        return this.size;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Float.valueOf(this.size)});
    }
}
