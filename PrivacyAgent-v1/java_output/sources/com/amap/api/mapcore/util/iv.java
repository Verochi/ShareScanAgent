package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iv {
    public static java.lang.Object a(java.lang.Class<?> cls, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) throws java.lang.Exception {
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) throws java.lang.Exception {
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            java.lang.Class<?> cls2 = objArr[i].getClass();
            clsArr[i] = cls2;
            if (cls2 == java.lang.Integer.class) {
                clsArr[i] = java.lang.Integer.TYPE;
            }
            if (clsArr[i] == java.lang.Boolean.class) {
                clsArr[i] = java.lang.Boolean.TYPE;
            }
            if (clsArr[i] == java.lang.Double.class) {
                clsArr[i] = java.lang.Double.TYPE;
            }
        }
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            try {
                if (th instanceof java.lang.reflect.InvocationTargetException) {
                    com.amap.api.mapcore.util.it.a(th.getTargetException(), "Reflect", "invokeMethod ".concat(java.lang.String.valueOf(str)));
                }
            } catch (java.lang.Throwable unused) {
            }
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            return a(obj, obj.getClass(), str, objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.Class<?> cls = java.lang.Class.forName(str);
        java.lang.reflect.Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) throws java.lang.Exception {
        return a(java.lang.Class.forName(str), str2, objArr, clsArr);
    }

    public static int b(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) throws java.lang.Exception {
        return ((java.lang.Integer) a(obj, str, objArr)).intValue();
    }

    public static int b(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        return ((java.lang.Integer) a(str, str2)).intValue();
    }
}
