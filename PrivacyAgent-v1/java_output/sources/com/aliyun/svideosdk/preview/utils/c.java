package com.aliyun.svideosdk.preview.utils;

@android.annotation.TargetApi(21)
/* loaded from: classes12.dex */
public class c {
    private final java.lang.String a = com.aliyun.svideosdk.preview.utils.c.class.getSimpleName();
    private android.hardware.camera2.CameraCharacteristics b;
    private android.hardware.camera2.params.MeteringRectangle[] c;
    private android.hardware.camera2.params.MeteringRectangle[] d;

    public c() {
        new android.hardware.camera2.params.MeteringRectangle(0, 0, 0, 0, 0);
    }

    private int a(int i) {
        int[] iArr = (int[]) this.b.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        for (int i2 : iArr) {
            if (i2 == i) {
                return i;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("not support af mode:");
        sb.append(i);
        sb.append(" use mode:");
        sb.append(iArr[0]);
        return iArr[0];
    }

    private boolean a() {
        java.lang.Boolean bool = (java.lang.Boolean) this.b.get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE);
        return bool != null && bool.booleanValue();
    }

    private boolean a(boolean z) {
        android.hardware.camera2.CameraCharacteristics cameraCharacteristics;
        android.hardware.camera2.CameraCharacteristics.Key key;
        if (z) {
            cameraCharacteristics = this.b;
            key = android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF;
        } else {
            cameraCharacteristics = this.b;
            key = android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE;
        }
        return ((java.lang.Integer) cameraCharacteristics.get(key)).intValue() > 0;
    }

    private int b(int i) {
        int[] iArr = (int[]) this.b.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES);
        for (int i2 : iArr) {
            if (i2 == i) {
                return i;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("not support anti banding mode:");
        sb.append(i);
        sb.append(" use mode:");
        sb.append(iArr[0]);
        return iArr[0];
    }

    public int a(android.hardware.camera2.CaptureRequest.Builder builder, android.util.Range<java.lang.Integer> range, float f) {
        if (builder == null) {
            return 0;
        }
        int intValue = ((int) ((range.getUpper().intValue() - r0) * f)) + range.getLower().intValue();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setExposureCompensationRatio, compensatonFactor = ");
        sb.append(f);
        sb.append(", exposureCompensation = ");
        sb.append(intValue);
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, java.lang.Integer.valueOf(intValue));
        return intValue;
    }

    public android.hardware.camera2.CaptureRequest a(android.hardware.camera2.CaptureRequest.Builder builder) {
        int a = a(3);
        int b = b(3);
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, java.lang.Integer.valueOf(a));
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, java.lang.Integer.valueOf(b));
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_MODE, 1);
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 0);
        return builder.build();
    }

    public android.hardware.camera2.CaptureRequest a(android.hardware.camera2.CaptureRequest.Builder builder, float f, android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (builder == null) {
            return null;
        }
        int floor = ((int) java.lang.Math.floor(rect.width() / f)) & 65532;
        int floor2 = ((int) java.lang.Math.floor(rect.height() / f)) & 65532;
        int width = (rect.width() - floor) >> 1;
        int height = (rect.height() - floor2) >> 1;
        rect2.set(width, height, width + floor, height + floor2);
        builder.set(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION, rect2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setZoom, cropX = ");
        sb.append(width);
        sb.append(", cropY =");
        sb.append(height);
        sb.append(", cropWidth = ");
        sb.append(floor);
        sb.append(", cropHeight = ");
        sb.append(floor2);
        return builder.build();
    }

    public android.hardware.camera2.CaptureRequest a(android.hardware.camera2.CaptureRequest.Builder builder, android.hardware.camera2.params.MeteringRectangle meteringRectangle, android.hardware.camera2.params.MeteringRectangle meteringRectangle2) {
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, java.lang.Integer.valueOf(a(1)));
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_MODE, 1);
        android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr = this.c;
        if (meteringRectangleArr == null) {
            this.c = new android.hardware.camera2.params.MeteringRectangle[]{meteringRectangle};
        } else {
            meteringRectangleArr[0] = meteringRectangle;
        }
        android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr2 = this.d;
        if (meteringRectangleArr2 == null) {
            this.d = new android.hardware.camera2.params.MeteringRectangle[]{meteringRectangle2};
        } else {
            meteringRectangleArr2[0] = meteringRectangle2;
        }
        if (a(true)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, this.c);
        }
        if (a(false)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, this.d);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getTouch2FocusRequest, set CONTROL_AE_REGIONS, CONTROL_AF_MODE_AUTO, CONTROL_MODE_AUTO, CONTROL_AF_REGIONS = {");
        sb.append(this.d[0].getRect().left);
        sb.append(", ");
        sb.append(this.d[0].getRect().top);
        sb.append(", ");
        sb.append(this.d[0].getRect().right);
        sb.append(", ");
        sb.append(this.d[0].getRect().bottom);
        sb.append(com.alipay.sdk.m.u.i.d);
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 0);
        return builder.build();
    }

    public void a(android.hardware.camera2.CameraCharacteristics cameraCharacteristics) {
        this.b = cameraCharacteristics;
    }

    public void a(android.hardware.camera2.CaptureRequest.Builder builder, java.lang.String str) {
        android.hardware.camera2.CaptureRequest.Key key;
        int i;
        android.hardware.camera2.CaptureRequest.Key key2;
        int i2;
        if (a()) {
            str.hashCode();
            switch (str) {
                case "on":
                    key = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE;
                    i = 3;
                    builder.set(key, i);
                    key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                    i2 = 1;
                    builder.set(key2, i2);
                    break;
                case "off":
                    builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
                    key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                    i2 = 0;
                    builder.set(key2, i2);
                    break;
                case "auto":
                    key = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE;
                    i = 2;
                    builder.set(key, i);
                    key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                    i2 = 1;
                    builder.set(key2, i2);
                    break;
                case "torch":
                    builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
                    key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                    i2 = 2;
                    builder.set(key2, i2);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0046. Please report as an issue. */
    public android.hardware.camera2.CaptureRequest b(android.hardware.camera2.CaptureRequest.Builder builder, java.lang.String str) {
        android.hardware.camera2.CaptureRequest.Key key;
        int i;
        android.hardware.camera2.CaptureRequest.Key key2;
        int i2;
        if (!a()) {
            return builder.build();
        }
        str.hashCode();
        switch (str) {
            case "on":
                key = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE;
                i = 3;
                builder.set(key, i);
                key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                i2 = 1;
                builder.set(key2, i2);
                break;
            case "off":
                builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
                key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                i2 = 0;
                builder.set(key2, i2);
                break;
            case "auto":
                key = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE;
                i = 2;
                builder.set(key, i);
                key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                i2 = 1;
                builder.set(key2, i2);
                break;
            case "torch":
                builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
                key2 = android.hardware.camera2.CaptureRequest.FLASH_MODE;
                i2 = 2;
                builder.set(key2, i2);
                break;
        }
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 0);
        return builder.build();
    }
}
