package com.otaliastudios.cameraview.engine.metering;

/* loaded from: classes19.dex */
public class Camera1MeteringTransform implements com.otaliastudios.cameraview.metering.MeteringTransform<android.hardware.Camera.Area> {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.metering.Camera1MeteringTransform.class.getSimpleName());
    protected static final java.lang.String TAG = "Camera1MeteringTransform";
    public final int a;
    public final com.otaliastudios.cameraview.size.Size b;

    public Camera1MeteringTransform(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Angles angles, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        this.a = -angles.offset(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE);
        this.b = size;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @androidx.annotation.NonNull
    public android.graphics.PointF transformMeteringPoint(@androidx.annotation.NonNull android.graphics.PointF pointF) {
        android.graphics.PointF pointF2 = new android.graphics.PointF();
        pointF2.x = ((pointF.x / this.b.getWidth()) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / this.b.getHeight()) * 2000.0f) - 1000.0f;
        android.graphics.PointF pointF3 = new android.graphics.PointF();
        double d = (this.a * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((pointF2.x * java.lang.Math.cos(d)) - (pointF2.y * java.lang.Math.sin(d)));
        pointF3.y = (float) ((pointF2.x * java.lang.Math.sin(d)) + (pointF2.y * java.lang.Math.cos(d)));
        LOG.i("scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @androidx.annotation.NonNull
    public android.hardware.Camera.Area transformMeteringRegion(@androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.round(rect);
        return new android.hardware.Camera.Area(rect, i);
    }
}
