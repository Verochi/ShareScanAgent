package com.bytedance.pangle.b.a;

/* loaded from: classes12.dex */
public final class a {
    private static java.util.Map<java.lang.String, java.lang.reflect.Field> a = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.lang.reflect.Method> b = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.lang.reflect.Constructor> c = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.lang.Class> d = new java.util.HashMap();

    static {
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(com.bytedance.pangle.b.a.b.class, "classLoader", (java.lang.Object) null);
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static java.lang.reflect.Constructor a(java.lang.Class<?> cls, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Constructor constructor;
        java.lang.String b2 = b(cls, "clinit", clsArr);
        synchronized (c) {
            constructor = c.get(b2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            java.lang.reflect.Constructor a2 = com.bytedance.pangle.b.a.b.a(cls, clsArr);
            if (a2 != null) {
                synchronized (c) {
                    c.put(b2, a2);
                }
            }
            return a2;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "HackHelper" + java.lang.String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static java.lang.reflect.Field a(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Field field;
        java.lang.String str2 = cls.getName() + "#" + str;
        synchronized (a) {
            field = a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            java.lang.reflect.Field a2 = com.bytedance.pangle.b.a.b.a(cls, str);
            if (a2 != null) {
                synchronized (a) {
                    a.put(str2, a2);
                }
            }
            return a2;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "HackHelper" + java.lang.String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Method method;
        java.lang.String b2 = b(cls, str, clsArr);
        synchronized (b) {
            method = b.get(b2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            java.lang.reflect.Method a2 = com.bytedance.pangle.b.a.b.a(cls, str, clsArr);
            if (a2 != null) {
                synchronized (b) {
                    b.put(b2, a2);
                }
            }
            return a2;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG, "HackHelper" + java.lang.String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static java.lang.String b(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(java.lang.Void.class.getName());
        } else {
            for (java.lang.Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }
}
