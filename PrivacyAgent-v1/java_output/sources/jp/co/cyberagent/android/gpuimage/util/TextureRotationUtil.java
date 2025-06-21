package jp.co.cyberagent.android.gpuimage.util;

/* loaded from: classes14.dex */
public class TextureRotationUtil {
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_90 = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_180 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_270 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[jp.co.cyberagent.android.gpuimage.util.Rotation.values().length];
            a = iArr;
            try {
                iArr[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_180.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static float a(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] getRotation(jp.co.cyberagent.android.gpuimage.util.Rotation rotation, boolean z, boolean z2) {
        int i = jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil.AnonymousClass1.a[rotation.ordinal()];
        float[] fArr = i != 1 ? i != 2 ? i != 3 ? TEXTURE_NO_ROTATION : TEXTURE_ROTATED_270 : TEXTURE_ROTATED_180 : TEXTURE_ROTATED_90;
        if (z) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        return z2 ? new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])} : fArr;
    }
}
