package com.bytedance.pangle.b.a;

/* loaded from: classes12.dex */
public class b {
    public static java.lang.reflect.Constructor a(java.lang.Class<?> cls, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
        if (declaredConstructor != null && !declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }

    public static java.lang.reflect.Field a(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
        if (declaredField != null && !declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }

    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (declaredMethod != null && !declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }
}
