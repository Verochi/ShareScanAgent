package com.github.chrisbanes.photoview;

/* loaded from: classes22.dex */
class Util {

    /* renamed from: com.github.chrisbanes.photoview.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    public static void a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new java.lang.IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new java.lang.IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static int b(int i) {
        return (i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static boolean c(android.widget.ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    public static boolean d(android.widget.ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (com.github.chrisbanes.photoview.Util.AnonymousClass1.a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new java.lang.IllegalStateException("Matrix scale type is not supported");
    }
}
