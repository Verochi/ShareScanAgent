package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class m {
    public static final int a = 5;

    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) throws java.lang.Exception {
        java.lang.reflect.Method method;
        while (true) {
            java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                    break;
                }
                i++;
            }
            if (method != null) {
                method.setAccessible(true);
                return method;
            }
            if (cls.getSuperclass() == null) {
                throw new java.lang.NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    private static java.lang.reflect.Method a(java.lang.reflect.Method[] methodArr, java.lang.String str, java.lang.Class<?>[] clsArr) {
        if (str == null) {
            throw new java.lang.NullPointerException("Method name must not be null.");
        }
        for (java.lang.reflect.Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            java.lang.Class<?> cls = clsArr2[i];
            if (cls != null && !clsArr[i].isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }
}
