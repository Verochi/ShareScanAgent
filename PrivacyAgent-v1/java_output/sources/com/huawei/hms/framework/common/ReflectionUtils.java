package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ReflectionUtils {
    private static final java.lang.String TAG = "ReflectionUtils";

    /* renamed from: com.huawei.hms.framework.common.ReflectionUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.security.PrivilegedAction {
        final /* synthetic */ java.lang.reflect.Field val$field;

        public AnonymousClass1(java.lang.reflect.Field field) {
            this.val$field = field;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            this.val$field.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.hms.framework.common.ReflectionUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.security.PrivilegedAction {
        final /* synthetic */ java.lang.reflect.Field val$field;

        public AnonymousClass2(java.lang.reflect.Field field) {
            this.val$field = field;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            this.val$field.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.hms.framework.common.ReflectionUtils$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.security.PrivilegedAction {
        final /* synthetic */ java.lang.reflect.Field val$field;

        public AnonymousClass3(java.lang.reflect.Field field) {
            this.val$field = field;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            this.val$field.setAccessible(true);
            return null;
        }
    }

    public static boolean checkCompatible(java.lang.String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (java.lang.Exception unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    public static boolean checkCompatible(java.lang.String str, java.lang.String str2, java.lang.Class<?>... clsArr) {
        try {
            if (str == null || str2 == null) {
                com.huawei.hms.framework.common.Logger.w(TAG, "targetClass is  null or name is null:");
                return false;
            }
            java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
            com.huawei.hms.framework.common.Logger.v(TAG, "has method : " + str2);
            return true;
        } catch (java.lang.RuntimeException unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, str + " RuntimeException");
            return false;
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.framework.common.Logger.w(TAG, str2 + " NoSuchMethodException");
            return false;
        }
    }

    private static java.lang.Class<?> getClass(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public static java.lang.reflect.Field getField(java.lang.Object obj, java.lang.String str) {
        if (obj != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
                java.security.AccessController.doPrivileged(new com.huawei.hms.framework.common.ReflectionUtils.AnonymousClass2(declaredField));
                return declaredField;
            } catch (java.lang.IllegalArgumentException e) {
                com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getField :: IllegalArgumentException:", e);
            } catch (java.lang.NoSuchFieldException e2) {
                com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getField :: NoSuchFieldException:", e2);
            } catch (java.lang.SecurityException e3) {
                com.huawei.hms.framework.common.Logger.e(TAG, "not security int method getField,SecurityException:", e3);
            }
        }
        return null;
    }

    public static java.lang.Object getFieldObj(java.lang.Object obj, java.lang.String str) {
        if (obj == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            java.security.AccessController.doPrivileged(new com.huawei.hms.framework.common.ReflectionUtils.AnonymousClass1(declaredField));
            return declaredField.get(obj);
        } catch (java.lang.IllegalAccessException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e);
            return null;
        } catch (java.lang.IllegalArgumentException e2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e2);
            return null;
        } catch (java.lang.NoSuchFieldException e3) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e3);
            return null;
        } catch (java.lang.SecurityException e4) {
            com.huawei.hms.framework.common.Logger.e(TAG, "not security int method getFieldObj,SecurityException:", e4);
            return null;
        }
    }

    public static java.lang.reflect.Method getMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        if (cls == null || str == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "NoSuchMethodException:", e);
            return null;
        } catch (java.lang.SecurityException e2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "SecurityException:", e2);
            return null;
        }
    }

    public static java.lang.Object getStaticFieldObj(java.lang.String str, java.lang.String str2) {
        java.lang.Class<?> cls;
        if (str == null || (cls = getClass(str)) == null || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str2);
            java.security.AccessController.doPrivileged(new com.huawei.hms.framework.common.ReflectionUtils.AnonymousClass3(declaredField));
            return declaredField.get(cls);
        } catch (java.lang.IllegalAccessException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e);
            return null;
        } catch (java.lang.IllegalArgumentException e2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e2);
            return null;
        } catch (java.lang.NoSuchFieldException e3) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e3);
            return null;
        } catch (java.lang.SecurityException e4) {
            com.huawei.hms.framework.common.Logger.e(TAG, "not security int method getStaticFieldObj,SecurityException:", e4);
            return null;
        }
    }

    private static java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object... objArr) throws java.lang.UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "RuntimeException in invoke:", e);
            return null;
        } catch (java.lang.Exception e2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Exception in invoke:", e2);
            return null;
        }
    }

    public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        java.lang.reflect.Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new java.lang.Class[length];
            for (int i = 0; i < length; i++) {
                setClassType(clsArr, objArr[i], i);
            }
        } else {
            clsArr = null;
        }
        java.lang.reflect.Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    private static void setClassType(java.lang.Class<?>[] clsArr, java.lang.Object obj, int i) {
        if (obj instanceof java.lang.Integer) {
            clsArr[i] = java.lang.Integer.TYPE;
            return;
        }
        if (obj instanceof java.lang.Long) {
            clsArr[i] = java.lang.Long.TYPE;
            return;
        }
        if (obj instanceof java.lang.Double) {
            clsArr[i] = java.lang.Double.TYPE;
            return;
        }
        if (obj instanceof java.lang.Float) {
            clsArr[i] = java.lang.Float.TYPE;
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            clsArr[i] = java.lang.Boolean.TYPE;
            return;
        }
        if (obj instanceof java.lang.Character) {
            clsArr[i] = java.lang.Character.TYPE;
            return;
        }
        if (obj instanceof java.lang.Byte) {
            clsArr[i] = java.lang.Byte.TYPE;
            return;
        }
        if (obj instanceof java.lang.Void) {
            clsArr[i] = java.lang.Void.TYPE;
        } else if (obj instanceof java.lang.Short) {
            clsArr[i] = java.lang.Short.TYPE;
        } else {
            clsArr[i] = obj.getClass();
        }
    }

    private static void tryLoadClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        java.lang.ClassLoader classLoader = com.huawei.hms.framework.common.ReflectionUtils.class.getClassLoader();
        if (classLoader == null) {
            throw new java.lang.ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }
}
