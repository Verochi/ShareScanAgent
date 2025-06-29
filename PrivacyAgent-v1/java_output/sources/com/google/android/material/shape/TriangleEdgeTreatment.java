package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class TriangleEdgeTreatment extends com.google.android.material.shape.EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath) {
        shapePath.lineTo(f2 - (this.size * f3), 0.0f);
        shapePath.lineTo(f2, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo(f2 + (this.size * f3), 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
