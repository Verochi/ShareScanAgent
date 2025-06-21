package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class ScreenUtil {

    public static class a implements java.security.PrivilegedAction {
        public java.lang.reflect.Method a;

        public a(java.lang.reflect.Method method) {
            this.a = method;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            java.lang.reflect.Method method = this.a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    public static void a(android.app.Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            com.huawei.secure.android.common.util.LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i);
        }
    }

    public static void b(android.app.Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            com.huawei.secure.android.common.util.LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i);
        }
    }

    public static void disableScreenshots(android.app.Activity activity) {
        a(activity, 8192);
    }

    public static void enableScreenshots(android.app.Activity activity) {
        b(activity, 8192);
    }

    public static void hideOverlayWindows(android.app.Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            android.view.Window window = activity.getWindow();
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", java.lang.Integer.TYPE);
            java.security.AccessController.doPrivileged(new com.huawei.secure.android.common.util.ScreenUtil.a(declaredMethod));
            declaredMethod.invoke(window, 524288);
        } catch (java.lang.ClassNotFoundException unused) {
            com.huawei.secure.android.common.util.LogsUtil.e("ScreenUtil", "hideOverlayWindows ClassNotFoundException");
        } catch (java.lang.IllegalAccessException unused2) {
            com.huawei.secure.android.common.util.LogsUtil.e("ScreenUtil", "hideOverlayWindows IllegalAccessException");
        } catch (java.lang.NoSuchMethodException unused3) {
            com.huawei.secure.android.common.util.LogsUtil.e("ScreenUtil", "hideOverlayWindows NoSuchMethodException");
        } catch (java.lang.reflect.InvocationTargetException unused4) {
            com.huawei.secure.android.common.util.LogsUtil.e("ScreenUtil", "hideOverlayWindows InvocationTargetException");
        }
    }
}
