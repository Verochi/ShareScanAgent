package com.otaliastudios.cameraview.engine.metering;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Camera2MeteringTransform implements com.otaliastudios.cameraview.metering.MeteringTransform<android.hardware.camera2.params.MeteringRectangle> {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.metering.Camera2MeteringTransform.class.getSimpleName());
    protected static final java.lang.String TAG = "Camera2MeteringTransform";
    public final com.otaliastudios.cameraview.engine.offset.Angles a;
    public final com.otaliastudios.cameraview.size.Size b;
    public final com.otaliastudios.cameraview.size.Size c;
    public final boolean d;
    public final android.hardware.camera2.CameraCharacteristics e;
    public final android.hardware.camera2.CaptureRequest.Builder f;

    public Camera2MeteringTransform(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Angles angles, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size2, boolean z, @androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics cameraCharacteristics, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder) {
        this.a = angles;
        this.b = size;
        this.c = size2;
        this.d = z;
        this.e = cameraCharacteristics;
        this.f = builder;
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size a(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        android.graphics.Rect rect = (android.graphics.Rect) this.f.get(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION);
        pointF.x += rect == null ? 0.0f : rect.left;
        pointF.y += rect != null ? rect.top : 0.0f;
        android.graphics.Rect rect2 = (android.graphics.Rect) this.e.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect2 == null) {
            rect2 = new android.graphics.Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return new com.otaliastudios.cameraview.size.Size(rect2.width(), rect2.height());
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size b(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        android.graphics.Rect rect = (android.graphics.Rect) this.f.get(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION);
        int width = rect == null ? size.getWidth() : rect.width();
        int height = rect == null ? size.getHeight() : rect.height();
        pointF.x += (width - size.getWidth()) / 2.0f;
        pointF.y += (height - size.getHeight()) / 2.0f;
        return new com.otaliastudios.cameraview.size.Size(width, height);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size c(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        com.otaliastudios.cameraview.size.Size size2 = this.c;
        int width = size.getWidth();
        int height = size.getHeight();
        com.otaliastudios.cameraview.size.AspectRatio of = com.otaliastudios.cameraview.size.AspectRatio.of(size2);
        com.otaliastudios.cameraview.size.AspectRatio of2 = com.otaliastudios.cameraview.size.AspectRatio.of(size);
        if (this.d) {
            if (of.toFloat() > of2.toFloat()) {
                float f = of.toFloat() / of2.toFloat();
                pointF.x += (size.getWidth() * (f - 1.0f)) / 2.0f;
                width = java.lang.Math.round(size.getWidth() * f);
            } else {
                float f2 = of2.toFloat() / of.toFloat();
                pointF.y += (size.getHeight() * (f2 - 1.0f)) / 2.0f;
                height = java.lang.Math.round(size.getHeight() * f2);
            }
        }
        return new com.otaliastudios.cameraview.size.Size(width, height);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size d(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        com.otaliastudios.cameraview.size.Size size2 = this.c;
        pointF.x *= size2.getWidth() / size.getWidth();
        pointF.y *= size2.getHeight() / size.getHeight();
        return size2;
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size e(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        int offset = this.a.offset(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE);
        boolean z = offset % 180 != 0;
        float f = pointF.x;
        float f2 = pointF.y;
        if (offset == 0) {
            pointF.x = f;
            pointF.y = f2;
        } else if (offset == 90) {
            pointF.x = f2;
            pointF.y = size.getWidth() - f;
        } else if (offset == 180) {
            pointF.x = size.getWidth() - f;
            pointF.y = size.getHeight() - f2;
        } else {
            if (offset != 270) {
                throw new java.lang.IllegalStateException("Unexpected angle " + offset);
            }
            pointF.x = size.getHeight() - f2;
            pointF.y = f;
        }
        return z ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @androidx.annotation.NonNull
    public android.graphics.PointF transformMeteringPoint(@androidx.annotation.NonNull android.graphics.PointF pointF) {
        android.graphics.PointF pointF2 = new android.graphics.PointF(pointF.x, pointF.y);
        com.otaliastudios.cameraview.size.Size a = a(b(e(d(c(this.b, pointF2), pointF2), pointF2), pointF2), pointF2);
        com.otaliastudios.cameraview.CameraLogger cameraLogger = LOG;
        cameraLogger.i("input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        if (pointF2.x > a.getWidth()) {
            pointF2.x = a.getWidth();
        }
        if (pointF2.y > a.getHeight()) {
            pointF2.y = a.getHeight();
        }
        cameraLogger.i("input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @androidx.annotation.NonNull
    public android.hardware.camera2.params.MeteringRectangle transformMeteringRegion(@androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.round(rect);
        return new android.hardware.camera2.params.MeteringRectangle(rect, i);
    }
}
