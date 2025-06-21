package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dc {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private boolean d = false;
    private int e = 0;
    private int f = 20;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public static void b(boolean z) {
        b = z;
    }

    public static boolean b() {
        return b;
    }

    public static void c(boolean z) {
        c = z;
    }

    public static boolean c() {
        return c;
    }

    public static void g() {
        com.amap.api.mapcore.util.gd.c(new java.lang.Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean a(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (width / 4.0f); i2 < (width * 3) / 4.0f; i2++) {
                    for (int i3 = (int) (height / 4.0f); i3 < (height * 3) / 4.0f; i3++) {
                        int pixel = bitmap.getPixel(i2, i3);
                        if (i == -1) {
                            i = pixel;
                        }
                        if (pixel != i) {
                            return false;
                        }
                        if (pixel != -16777216) {
                            return false;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return true;
    }

    public final boolean d() {
        return this.d;
    }

    public final void e() {
        this.e++;
    }

    public final boolean f() {
        return this.e >= this.f;
    }
}
