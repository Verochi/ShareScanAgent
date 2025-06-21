package com.autonavi.base.ae.gmap.glyph;

/* loaded from: classes12.dex */
public final class ReflectUtil {
    public static java.lang.Object getField(java.lang.String str, java.lang.Object obj, java.lang.String str2) {
        if (str == null || str.equals("")) {
            throw new java.lang.IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new java.lang.IllegalArgumentException("fieldName 不能为空");
        }
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object getInstance(java.lang.String str, java.lang.Object... objArr) {
        if (str == null || str.equals("")) {
            throw new java.lang.IllegalArgumentException("className 不能为空");
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            if (objArr == null) {
                java.lang.reflect.Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new java.lang.Object[0]);
            }
            int length = objArr.length;
            java.lang.Class<?>[] clsArr = new java.lang.Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            java.lang.reflect.Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(clsArr);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(objArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.reflect.Method getMethod(java.lang.String str, java.lang.String str2, java.lang.Class... clsArr) {
        if (str == null || str.equals("")) {
            throw new java.lang.IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new java.lang.IllegalArgumentException("methodName不能为空");
        }
        try {
            return java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invoke(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Object... objArr) {
        if (str == null || str.equals("")) {
            throw new java.lang.IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new java.lang.IllegalArgumentException("methodName不能为空");
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            if (objArr == null) {
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str2, new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, new java.lang.Object[0]);
            }
            int length = objArr.length;
            java.lang.Class<?>[] clsArr = new java.lang.Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod(str2, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object... objArr) {
        if (method == null) {
            throw new java.lang.IllegalArgumentException("method 不能为空");
        }
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void setField(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Object obj2) {
        if (str == null || str.equals("")) {
            throw new java.lang.IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new java.lang.IllegalArgumentException("fieldName 不能为空");
        }
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
