package com.google.android.material.shape;

/* loaded from: classes22.dex */
public final class MarkerEdgeTreatment extends com.google.android.material.shape.EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath) {
        float sqrt = (float) ((this.radius * java.lang.Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) java.lang.Math.sqrt(java.lang.Math.pow(this.radius, 2.0d) - java.lang.Math.pow(sqrt, 2.0d));
        shapePath.reset(f2 - sqrt, ((float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius))) + sqrt2);
        shapePath.lineTo(f2, (float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius)));
        shapePath.lineTo(f2 + sqrt, ((float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius))) + sqrt2);
    }
}
