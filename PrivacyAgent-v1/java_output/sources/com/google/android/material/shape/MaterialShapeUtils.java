package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.CornerTreatment createCornerTreatment(int i) {
        return i != 0 ? i != 1 ? createDefaultCornerTreatment() : new com.google.android.material.shape.CutCornerTreatment() : new com.google.android.material.shape.RoundedCornerTreatment();
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.CornerTreatment createDefaultCornerTreatment() {
        return new com.google.android.material.shape.RoundedCornerTreatment();
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.EdgeTreatment createDefaultEdgeTreatment() {
        return new com.google.android.material.shape.EdgeTreatment();
    }

    public static void setElevation(@androidx.annotation.NonNull android.view.View view, float f) {
        android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof com.google.android.material.shape.MaterialShapeDrawable) {
            ((com.google.android.material.shape.MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public static void setParentAbsoluteElevation(@androidx.annotation.NonNull android.view.View view) {
        android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof com.google.android.material.shape.MaterialShapeDrawable) {
            setParentAbsoluteElevation(view, (com.google.android.material.shape.MaterialShapeDrawable) background);
        }
    }

    public static void setParentAbsoluteElevation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(com.google.android.material.internal.ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
