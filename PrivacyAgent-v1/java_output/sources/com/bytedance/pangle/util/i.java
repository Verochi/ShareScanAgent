package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class i {
    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return false;
    }

    public static boolean c() {
        return android.os.Build.VERSION.SDK_INT <= 23;
    }

    public static boolean d() {
        return android.os.Build.VERSION.SDK_INT < 23;
    }

    public static boolean e() {
        return android.os.Build.VERSION.SDK_INT <= 25;
    }

    public static boolean f() {
        int i = android.os.Build.VERSION.SDK_INT;
        return i >= 26 && i <= 28;
    }

    public static boolean g() {
        int i = android.os.Build.VERSION.SDK_INT;
        return i >= 29 && i <= 30;
    }

    public static boolean h() {
        return android.os.Build.VERSION.SDK_INT > 23;
    }

    public static boolean i() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static boolean j() {
        int i;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return true;
        }
        if (i2 != 27) {
            return false;
        }
        i = android.os.Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    public static boolean k() {
        int i;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            return true;
        }
        if (i2 != 30) {
            return false;
        }
        i = android.os.Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }
}
