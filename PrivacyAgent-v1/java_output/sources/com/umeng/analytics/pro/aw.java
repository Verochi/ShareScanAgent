package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class aw {
    public static java.lang.Class<?> a(java.lang.String str) {
        java.lang.ClassLoader contextClassLoader = java.lang.Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = com.umeng.analytics.pro.aw.class.getClassLoader();
        }
        try {
            try {
                return java.lang.Class.forName(str, true, contextClassLoader);
            } catch (java.lang.Throwable unused) {
                return java.lang.Class.forName(str, true, com.umeng.analytics.pro.aw.class.getClassLoader());
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        return a(a(str, str2), obj);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Class<?>[] clsArr, java.lang.Object obj, java.lang.Object[] objArr) {
        java.lang.reflect.Method a = a(str, str2, clsArr);
        if (a != null) {
            return a(a, obj, objArr);
        }
        return null;
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        java.lang.Class<?> a = a(str);
        if (a == null) {
            return null;
        }
        try {
            return a.getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object a(java.lang.reflect.Field field, java.lang.Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object a(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.reflect.Field a(java.lang.String str, java.lang.String str2) {
        java.lang.Class<?> a;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (a = a(str)) == null) {
            return null;
        }
        try {
            return a.getField(str2);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.reflect.Method a(java.lang.String str, java.lang.String str2, java.lang.Class<?>... clsArr) {
        java.lang.Class<?> a;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (a = a(str)) == null) {
            return null;
        }
        try {
            return a.getDeclaredMethod(str2, clsArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
