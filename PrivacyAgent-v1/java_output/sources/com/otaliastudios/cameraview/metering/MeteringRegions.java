package com.otaliastudios.cameraview.metering;

/* loaded from: classes19.dex */
public class MeteringRegions {

    @androidx.annotation.VisibleForTesting
    public final java.util.List<com.otaliastudios.cameraview.metering.MeteringRegion> a;

    public MeteringRegions(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.metering.MeteringRegion> list) {
        this.a = list;
    }

    @androidx.annotation.NonNull
    public static android.graphics.RectF a(@androidx.annotation.NonNull android.graphics.PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new android.graphics.RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.metering.MeteringRegions fromArea(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        return fromArea(size, rectF, 1000);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.metering.MeteringRegions fromArea(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        return fromArea(size, rectF, i, false);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.metering.MeteringRegions fromArea(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.RectF rectF, int i, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.graphics.PointF pointF = new android.graphics.PointF(rectF.centerX(), rectF.centerY());
        float width = rectF.width();
        float height = rectF.height();
        arrayList.add(new com.otaliastudios.cameraview.metering.MeteringRegion(rectF, i));
        if (z) {
            arrayList.add(new com.otaliastudios.cameraview.metering.MeteringRegion(a(pointF, width * 1.5f, height * 1.5f), java.lang.Math.round(i * 0.1f)));
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.otaliastudios.cameraview.metering.MeteringRegion) it.next()).b(size));
        }
        return new com.otaliastudios.cameraview.metering.MeteringRegions(arrayList2);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.metering.MeteringRegions fromPoint(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        return fromPoint(size, pointF, 1000);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.metering.MeteringRegions fromPoint(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF, int i) {
        return fromArea(size, a(pointF, size.getWidth() * 0.05f, size.getHeight() * 0.05f), i, true);
    }

    @androidx.annotation.NonNull
    public <T> java.util.List<T> get(int i, @androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringTransform<T> meteringTransform) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Collections.sort(this.a);
        for (com.otaliastudios.cameraview.metering.MeteringRegion meteringRegion : this.a) {
            arrayList.add(meteringTransform.transformMeteringRegion(meteringRegion.n, meteringRegion.t));
        }
        return arrayList.subList(0, java.lang.Math.min(i, arrayList.size()));
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.metering.MeteringRegions transform(@androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringTransform meteringTransform) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.otaliastudios.cameraview.metering.MeteringRegion> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().d(meteringTransform));
        }
        return new com.otaliastudios.cameraview.metering.MeteringRegions(arrayList);
    }
}
