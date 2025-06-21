package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class RoundedCornerTreatment extends com.google.android.material.shape.CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @java.lang.Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(0.0f, 0.0f, f4, f4, 180.0f, f);
    }
}
