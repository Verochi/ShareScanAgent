package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    public void getEdgePath(float f, float f2, float f3, @androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }

    @java.lang.Deprecated
    public void getEdgePath(float f, float f2, @androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f2, shapePath);
    }
}
