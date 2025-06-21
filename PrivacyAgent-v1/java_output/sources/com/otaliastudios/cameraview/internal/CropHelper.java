package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class CropHelper {
    @androidx.annotation.NonNull
    public static android.graphics.Rect computeCrop(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio) {
        int round;
        int width = size.getWidth();
        int height = size.getHeight();
        int i = 0;
        if (aspectRatio.matches(size, 5.0E-4f)) {
            return new android.graphics.Rect(0, 0, width, height);
        }
        if (com.otaliastudios.cameraview.size.AspectRatio.of(width, height).toFloat() > aspectRatio.toFloat()) {
            int round2 = java.lang.Math.round(height * aspectRatio.toFloat());
            int round3 = java.lang.Math.round((width - round2) / 2.0f);
            width = round2;
            i = round3;
            round = 0;
        } else {
            int round4 = java.lang.Math.round(width / aspectRatio.toFloat());
            round = java.lang.Math.round((height - round4) / 2.0f);
            height = round4;
        }
        return new android.graphics.Rect(i, round, width + i, height + round);
    }
}
