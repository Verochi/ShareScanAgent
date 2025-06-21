package com.efs.sdk.launch;

/* loaded from: classes22.dex */
public final class c {
    private static java.lang.String a = "";

    public static java.lang.String a(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.UMConfigure> cls;
        java.lang.reflect.Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = com.umeng.commonsdk.UMConfigure.class;
            com.umeng.commonsdk.debug.UMLog uMLog = com.umeng.commonsdk.UMConfigure.umDebugLog;
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", android.content.Context.class);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        if (context == null || str == null || android.text.TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString("first_launch_cache", str);
        edit.commit();
    }

    public static java.lang.String b(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("first_launch_cache", null);
    }

    public static void c(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString("first_launch_cache", null);
        edit.commit();
    }

    public static boolean d(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences2;
        if ((context == null || (sharedPreferences2 = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) ? false : sharedPreferences2.getBoolean("is_install", false)) {
            return false;
        }
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean("is_install", true);
            edit.commit();
        }
        return true;
    }

    public static boolean e(android.content.Context context) {
        try {
            java.lang.String currentProcessName = com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName();
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
