package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class NotchScreenUtil {
    private static final int FLAG_NOTCH_SUPPORT_HW = 65536;
    private static final int FLAG_NOTCH_SUPPORT_VIVO = 32;
    private static final java.lang.String TAG = "com.aliyun.svideo.common.utils.NotchScreenUtil";

    private static boolean checkHuaWei(android.content.Context context) {
        try {
            java.lang.Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((java.lang.Boolean) loadClass.getMethod("hasNotchInScreen", new java.lang.Class[0]).invoke(loadClass, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean checkMiUI(android.content.Context context) {
        try {
            java.lang.Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((java.lang.Integer) loadClass.getMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (java.lang.IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (java.lang.NoSuchMethodException e4) {
            e4.printStackTrace();
            return false;
        } catch (java.lang.reflect.InvocationTargetException e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public static boolean checkNotchScreen(android.content.Context context) {
        return checkHuaWei(context) || checkVivo(context) || checkMiUI(context) || checkOppo(context);
    }

    private static boolean checkOppo(android.content.Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean checkVivo(android.content.Context context) {
        try {
            java.lang.Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((java.lang.Boolean) loadClass.getMethod("isFeatureSupport", new java.lang.Class[0]).invoke(loadClass, 32)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int[] getNotchSize(android.content.Context context) {
        int[] iArr = {0, 0};
        try {
            java.lang.Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", new java.lang.Class[0]).invoke(loadClass, new java.lang.Object[0]);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.Exception unused) {
            return iArr;
        }
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(android.view.Window window) {
        if (window == null) {
            return;
        }
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException | java.lang.Exception unused) {
        }
    }

    public static void setNotFullScreenWindowLayoutInDisplayCutout(android.view.Window window) {
        if (window == null) {
            return;
        }
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("clearHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException | java.lang.Exception unused) {
        }
    }
}
