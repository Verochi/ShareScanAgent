package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class aj {
    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> a;

    public static class a<T> {
        public final java.lang.Class<? extends T> a;
        public final T b;
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        a = hashMap;
        java.lang.Class cls = java.lang.Boolean.TYPE;
        hashMap.put(java.lang.Boolean.class, cls);
        hashMap.put(java.lang.Byte.class, java.lang.Byte.TYPE);
        hashMap.put(java.lang.Character.class, java.lang.Character.TYPE);
        hashMap.put(java.lang.Short.class, java.lang.Short.TYPE);
        java.lang.Class cls2 = java.lang.Integer.TYPE;
        hashMap.put(java.lang.Integer.class, cls2);
        java.lang.Class cls3 = java.lang.Float.TYPE;
        hashMap.put(java.lang.Float.class, cls3);
        java.lang.Class cls4 = java.lang.Long.TYPE;
        hashMap.put(java.lang.Long.class, cls4);
        hashMap.put(java.lang.Double.class, java.lang.Double.TYPE);
        hashMap.put(cls, cls);
        java.lang.Class cls5 = java.lang.Byte.TYPE;
        hashMap.put(cls5, cls5);
        java.lang.Class cls6 = java.lang.Character.TYPE;
        hashMap.put(cls6, cls6);
        java.lang.Class cls7 = java.lang.Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        java.lang.Class cls8 = java.lang.Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    private static <T> T a(java.lang.Class<? extends java.lang.Object> cls, java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new java.lang.NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T a(java.lang.Class<? extends java.lang.Object> cls, java.lang.String str) {
        try {
            return (T) a(cls, (java.lang.Object) null, str);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls.getSimpleName());
            sb.append(", ");
            sb.append(e);
            return null;
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str) {
        try {
            return (T) a((java.lang.Class<? extends java.lang.Object>) obj.getClass(), obj, str);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call getField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
            return null;
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call Method '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
            return null;
        }
    }

    public static <T> T a(java.lang.String str, java.lang.String str2) {
        try {
            return (T) a((java.lang.Class<? extends java.lang.Object>) com.xiaomi.push.jc.a(null, str), (java.lang.Object) null, str2);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call getStaticField '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            sb.append(", ");
            sb.append(e);
            return null;
        }
    }

    public static <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        try {
            return (T) a(com.xiaomi.push.jc.a(null, str), str2, a(objArr)).invoke(null, b(objArr));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call Method '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            sb.append(", ");
            sb.append(e);
            return null;
        }
    }

    private static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        while (true) {
            java.lang.reflect.Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
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

    public static void a(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        try {
            java.lang.Class<?> cls = obj.getClass();
            java.lang.reflect.Field field = null;
            while (field == null) {
                try {
                    field = cls.getDeclaredField(str);
                } catch (java.lang.NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                }
                if (cls == null) {
                    throw new java.lang.NoSuchFieldException();
                }
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call setField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
        }
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
                java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map = a;
                if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static java.lang.Class<?>[] a(java.lang.Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof com.xiaomi.push.aj.a)) ? obj == null ? null : obj.getClass() : ((com.xiaomi.push.aj.a) obj).a;
        }
        return clsArr;
    }

    public static <T> T b(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        return (T) a(obj.getClass(), str, a(objArr)).invoke(obj, b(objArr));
    }

    private static java.lang.Object[] b(java.lang.Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        java.lang.Object[] objArr2 = new java.lang.Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (obj == null || !(obj instanceof com.xiaomi.push.aj.a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((com.xiaomi.push.aj.a) obj).b;
            }
        }
        return objArr2;
    }
}
