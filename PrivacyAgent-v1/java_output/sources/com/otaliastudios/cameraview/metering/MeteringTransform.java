package com.otaliastudios.cameraview.metering;

/* loaded from: classes19.dex */
public interface MeteringTransform<T> {
    @androidx.annotation.NonNull
    android.graphics.PointF transformMeteringPoint(@androidx.annotation.NonNull android.graphics.PointF pointF);

    @androidx.annotation.NonNull
    T transformMeteringRegion(@androidx.annotation.NonNull android.graphics.RectF rectF, int i);
}
