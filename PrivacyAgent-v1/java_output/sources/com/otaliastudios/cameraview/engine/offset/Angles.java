package com.otaliastudios.cameraview.engine.offset;

/* loaded from: classes19.dex */
public class Angles {
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.offset.Angles.class.getSimpleName());
    public com.otaliastudios.cameraview.controls.Facing a;

    @androidx.annotation.VisibleForTesting
    public int b = 0;

    @androidx.annotation.VisibleForTesting
    public int c = 0;

    @androidx.annotation.VisibleForTesting
    public int d = 0;

    /* renamed from: com.otaliastudios.cameraview.engine.offset.Angles$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.engine.offset.Reference.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.engine.offset.Reference.VIEW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.otaliastudios.cameraview.engine.offset.Reference.SENSOR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public final int a(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference2) {
        if (reference == reference2) {
            return 0;
        }
        com.otaliastudios.cameraview.engine.offset.Reference reference3 = com.otaliastudios.cameraview.engine.offset.Reference.BASE;
        if (reference2 == reference3) {
            return d(360 - a(reference2, reference));
        }
        if (reference != reference3) {
            return d(a(reference3, reference2) - a(reference3, reference));
        }
        int i = com.otaliastudios.cameraview.engine.offset.Angles.AnonymousClass1.a[reference2.ordinal()];
        if (i == 1) {
            return d(360 - this.c);
        }
        if (i == 2) {
            return d(this.d);
        }
        if (i == 3) {
            return d(360 - this.b);
        }
        throw new java.lang.RuntimeException("Unknown reference: " + reference2);
    }

    public final void b() {
        e.i("Angles changed:", "sensorOffset:", java.lang.Integer.valueOf(this.b), "displayOffset:", java.lang.Integer.valueOf(this.c), "deviceOrientation:", java.lang.Integer.valueOf(this.d));
    }

    public final void c(int i) {
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            return;
        }
        throw new java.lang.IllegalStateException("This value is not sanitized: " + i);
    }

    public final int d(int i) {
        return (i + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    public boolean flip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference2) {
        return offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE) % 180 != 0;
    }

    public int offset(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference2, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Axis axis) {
        int a = a(reference, reference2);
        return (axis == com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR && this.a == com.otaliastudios.cameraview.controls.Facing.FRONT) ? d(360 - a) : a;
    }

    public void setDeviceOrientation(int i) {
        c(i);
        this.d = i;
        b();
    }

    public void setDisplayOffset(int i) {
        c(i);
        this.c = i;
        b();
    }

    public void setSensorOffset(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing, int i) {
        c(i);
        this.a = facing;
        this.b = i;
        if (facing == com.otaliastudios.cameraview.controls.Facing.FRONT) {
            this.b = d(360 - i);
        }
        b();
    }
}
