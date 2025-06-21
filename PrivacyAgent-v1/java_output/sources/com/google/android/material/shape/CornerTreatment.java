package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class CornerTreatment {
    @java.lang.Deprecated
    public void getCornerPath(float f, float f2, @androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath) {
    }

    public void getCornerPath(@androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath, float f, float f2, float f3) {
        getCornerPath(f, f2, shapePath);
    }

    public void getCornerPath(@androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath, float f, float f2, @androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        getCornerPath(shapePath, f, f2, cornerSize.getCornerSize(rectF));
    }
}
