package jp.co.cyberagent.android.gpuimage.util;

/* loaded from: classes14.dex */
public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    /* renamed from: jp.co.cyberagent.android.gpuimage.util.Rotation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[jp.co.cyberagent.android.gpuimage.util.Rotation.values().length];
            a = iArr;
            try {
                iArr[jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_180.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static jp.co.cyberagent.android.gpuimage.util.Rotation fromInt(int i) {
        if (i == 0) {
            return NORMAL;
        }
        if (i == 90) {
            return ROTATION_90;
        }
        if (i == 180) {
            return ROTATION_180;
        }
        if (i == 270) {
            return ROTATION_270;
        }
        if (i == 360) {
            return NORMAL;
        }
        throw new java.lang.IllegalStateException(i + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }

    public int asInt() {
        int i = jp.co.cyberagent.android.gpuimage.util.Rotation.AnonymousClass1.a[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 4) {
            return 270;
        }
        throw new java.lang.IllegalStateException("Unknown Rotation!");
    }
}
