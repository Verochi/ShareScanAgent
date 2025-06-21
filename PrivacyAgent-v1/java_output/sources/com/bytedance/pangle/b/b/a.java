package com.bytedance.pangle.b.b;

/* loaded from: classes12.dex */
public final class a {
    private static java.lang.reflect.Method a;
    private static java.lang.reflect.Method b;
    private static java.lang.reflect.Method c;
    private static java.lang.reflect.Method d;

    static {
        try {
            a = java.lang.Class.class.getDeclaredMethod("getDeclaredField", java.lang.String.class);
            b = java.lang.Class.class.getDeclaredMethod("getDeclaredMethod", java.lang.String.class, java.lang.Class[].class);
            c = java.lang.Class.class.getDeclaredMethod("getDeclaredConstructor", java.lang.Class[].class);
            d = java.lang.Class.class.getDeclaredMethod("forName", java.lang.String.class);
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.reflect.Constructor a(java.lang.Class<?> cls, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Constructor constructor;
        java.lang.reflect.Method method = c;
        if (method != null) {
            try {
                constructor = (java.lang.reflect.Constructor) method.invoke(cls, clsArr);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "DoubleReflector" + java.lang.String.format("getConstructor %s<init>%s failed !!!", cls.getName(), 1), th);
            }
            return constructor == null ? constructor : com.bytedance.pangle.b.a.a.a(cls, clsArr);
        }
        constructor = null;
        if (constructor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.reflect.Field a(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.Throwable th;
        java.lang.reflect.Field field;
        java.lang.reflect.Method method = a;
        java.lang.reflect.Field field2 = null;
        if (method != null) {
            try {
                field = (java.lang.reflect.Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "DoubleReflector" + java.lang.String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                        field2 = field;
                        if (field2 == null) {
                        }
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        return field2 == null ? field2 : com.bytedance.pangle.b.a.a.a(cls, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.Throwable th;
        java.lang.reflect.Method method;
        java.lang.reflect.Method method2 = b;
        java.lang.reflect.Method method3 = null;
        if (method2 != null) {
            try {
                method = (java.lang.reflect.Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "DoubleReflector" + java.lang.String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                        method3 = method;
                        if (method3 == null) {
                        }
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        return method3 == null ? method3 : com.bytedance.pangle.b.a.a.a(cls, str, clsArr);
    }
}
