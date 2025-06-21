package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public final class Utils {
    public static final int SECOND_IN_NANOS = 1000000000;
    public static final java.lang.ThreadLocal<android.graphics.PathMeasure> a = new com.airbnb.lottie.utils.Utils.AnonymousClass1();
    public static final java.lang.ThreadLocal<android.graphics.Path> b = new com.airbnb.lottie.utils.Utils.AnonymousClass2();
    public static final java.lang.ThreadLocal<android.graphics.Path> c = new com.airbnb.lottie.utils.Utils.AnonymousClass3();
    public static final java.lang.ThreadLocal<float[]> d = new com.airbnb.lottie.utils.Utils.AnonymousClass4();
    public static final float e = (float) (java.lang.Math.sqrt(2.0d) / 2.0d);
    public static float f = -1.0f;

    /* renamed from: com.airbnb.lottie.utils.Utils$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.ThreadLocal<android.graphics.PathMeasure> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public android.graphics.PathMeasure initialValue() {
            return new android.graphics.PathMeasure();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.ThreadLocal<android.graphics.Path> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$3, reason: invalid class name */
    public class AnonymousClass3 extends java.lang.ThreadLocal<android.graphics.Path> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$4, reason: invalid class name */
    public class AnonymousClass4 extends java.lang.ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void applyTrimPathIfNeeded(android.graphics.Path path, float f2, float f3, float f4) {
        com.airbnb.lottie.L.beginSection("applyTrimPathIfNeeded");
        android.graphics.PathMeasure pathMeasure = a.get();
        android.graphics.Path path2 = b.get();
        android.graphics.Path path3 = c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.airbnb.lottie.L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || java.lang.Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.airbnb.lottie.L.endSection("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float min = java.lang.Math.min(f5, f6) + f7;
        float max = java.lang.Math.max(f5, f6) + f7;
        if (min >= length && max >= length) {
            min = com.airbnb.lottie.utils.MiscUtils.b(min, length);
            max = com.airbnb.lottie.utils.MiscUtils.b(max, length);
        }
        if (min < 0.0f) {
            min = com.airbnb.lottie.utils.MiscUtils.b(min, length);
        }
        if (max < 0.0f) {
            max = com.airbnb.lottie.utils.MiscUtils.b(max, length);
        }
        if (min == max) {
            path.reset();
            com.airbnb.lottie.L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (min >= max) {
            min -= length;
        }
        path2.reset();
        pathMeasure.getSegment(min, max, path2, true);
        if (max > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, max % length, path3, true);
            path2.addPath(path3);
        } else if (min < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(min + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.airbnb.lottie.L.endSection("applyTrimPathIfNeeded");
    }

    public static void applyTrimPathIfNeeded(android.graphics.Path path, @androidx.annotation.Nullable com.airbnb.lottie.animation.content.TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) trimPathContent.getStart()).getFloatValue() / 100.0f, ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) trimPathContent.getEnd()).getFloatValue() / 100.0f, ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) trimPathContent.getOffset()).getFloatValue() / 360.0f);
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static android.graphics.Path createPath(android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3, android.graphics.PointF pointF4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    public static float dpScale() {
        if (f == -1.0f) {
            f = android.content.res.Resources.getSystem().getDisplayMetrics().density;
        }
        return f;
    }

    public static float getAnimationScale(android.content.Context context) {
        return android.provider.Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float getScale(android.graphics.Matrix matrix) {
        float[] fArr = d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) java.lang.Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean hasZeroScaleAxis(android.graphics.Matrix matrix) {
        float[] fArr = d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int hashFor(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (i * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i * 31 * f5) : i;
    }

    public static boolean isAtLeastVersion(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static boolean isNetworkException(java.lang.Throwable th) {
        return (th instanceof java.net.SocketException) || (th instanceof java.nio.channels.ClosedChannelException) || (th instanceof java.io.InterruptedIOException) || (th instanceof java.net.ProtocolException) || (th instanceof javax.net.ssl.SSLException) || (th instanceof java.net.UnknownHostException) || (th instanceof java.net.UnknownServiceException);
    }

    public static android.graphics.Bitmap renderPath(android.graphics.Path path) {
        android.graphics.RectF rectF = new android.graphics.RectF();
        path.computeBounds(rectF, false);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        com.airbnb.lottie.animation.LPaint lPaint = new com.airbnb.lottie.animation.LPaint();
        lPaint.setAntiAlias(true);
        lPaint.setColor(-16776961);
        canvas.drawPath(path, lPaint);
        return createBitmap;
    }

    public static android.graphics.Bitmap resizeBitmapIfNeeded(android.graphics.Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void saveLayerCompat(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint) {
        saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint, int i) {
        com.airbnb.lottie.L.beginSection("Utils#saveLayer");
        if (android.os.Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.L.endSection("Utils#saveLayer");
    }
}
