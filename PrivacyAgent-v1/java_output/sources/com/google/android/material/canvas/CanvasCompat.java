package com.google.android.material.canvas;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@androidx.annotation.NonNull android.graphics.Canvas canvas, float f, float f2, float f3, float f4, int i) {
        return android.os.Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f, f2, f3, f4, i) : canvas.saveLayerAlpha(f, f2, f3, f4, i, 31);
    }

    public static int saveLayerAlpha(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.Nullable android.graphics.RectF rectF, int i) {
        return android.os.Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i) : canvas.saveLayerAlpha(rectF, i, 31);
    }
}
