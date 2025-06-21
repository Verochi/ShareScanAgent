package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class u {
    public static boolean a(android.content.Context context) {
        if (new com.huawei.hms.aaid.utils.PushPreferences(context, "push_notify_flag").getBoolean("notify_msg_enable")) {
            return false;
        }
        return android.os.Build.VERSION.SDK_INT >= 24 ? b(context) : b(context);
    }

    @android.annotation.SuppressLint({"NewApi", "InlinedApi"})
    public static boolean b(android.content.Context context) {
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        java.lang.String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(java.lang.Integer.class)).intValue()), java.lang.Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException | java.lang.NoSuchMethodException | java.lang.RuntimeException | java.lang.reflect.InvocationTargetException unused) {
            return true;
        }
    }
}
