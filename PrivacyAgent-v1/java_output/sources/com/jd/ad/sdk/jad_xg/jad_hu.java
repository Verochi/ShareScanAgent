package com.jd.ad.sdk.jad_xg;

/* loaded from: classes23.dex */
public final class jad_hu {
    public static final java.lang.ThreadLocal<android.graphics.PathMeasure> jad_an = new com.jd.ad.sdk.jad_xg.jad_hu.jad_an();
    public static final java.lang.ThreadLocal<android.graphics.Path> jad_bo = new com.jd.ad.sdk.jad_xg.jad_hu.jad_bo();
    public static final java.lang.ThreadLocal<android.graphics.Path> jad_cp = new com.jd.ad.sdk.jad_xg.jad_hu.jad_cp();
    public static final java.lang.ThreadLocal<float[]> jad_dq = new com.jd.ad.sdk.jad_xg.jad_hu.jad_dq();
    public static final float jad_er = (float) (java.lang.Math.sqrt(2.0d) / 2.0d);
    public static float jad_fs = -1.0f;

    public class jad_an extends java.lang.ThreadLocal<android.graphics.PathMeasure> {
        @Override // java.lang.ThreadLocal
        public android.graphics.PathMeasure initialValue() {
            return new android.graphics.PathMeasure();
        }
    }

    public class jad_bo extends java.lang.ThreadLocal<android.graphics.Path> {
        @Override // java.lang.ThreadLocal
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    }

    public class jad_cp extends java.lang.ThreadLocal<android.graphics.Path> {
        @Override // java.lang.ThreadLocal
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    }

    public class jad_dq extends java.lang.ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static float jad_an() {
        if (jad_fs == -1.0f) {
            jad_fs = android.content.res.Resources.getSystem().getDisplayMetrics().density;
        }
        return jad_fs;
    }

    public static float jad_an(android.graphics.Matrix matrix) {
        float[] fArr = jad_dq.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = jad_er;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) java.lang.Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void jad_an(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint, int i) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Utils#saveLayer");
    }

    public static void jad_an(android.graphics.Path path, float f, float f2, float f3) {
        android.graphics.PathMeasure pathMeasure = jad_an.get();
        android.graphics.Path path2 = jad_bo.get();
        android.graphics.Path path3 = jad_cp.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || java.lang.Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float min = java.lang.Math.min(f4, f5) + f6;
        float max = java.lang.Math.max(f4, f5) + f6;
        if (min >= length && max >= length) {
            min = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(min, length);
            max = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(max, length);
        }
        if (min < 0.0f) {
            min = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(min, length);
        }
        if (max < 0.0f) {
            max = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(max, length);
        }
        if (min == max) {
            path.reset();
        } else {
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
            } else {
                if (min < 0.0f) {
                    path3.reset();
                    pathMeasure.getSegment(min + length, length, path3, true);
                }
                path.set(path2);
            }
            path2.addPath(path3);
            path.set(path2);
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("applyTrimPathIfNeeded");
    }

    public static void jad_an(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
