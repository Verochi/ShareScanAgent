package com.bytedance.pangle.util;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class MethodUtils {
    public static final java.lang.Class<?>[] EMPTY_CLASS_ARRAY;
    private static java.util.Map<java.lang.String, java.lang.reflect.Method> sMethodCache = new java.util.HashMap();
    private static final java.util.HashMap<java.lang.Class<?>, java.lang.Class<?>> sPrimitiveToWrapperMap;

    static {
        java.util.HashMap<java.lang.Class<?>, java.lang.Class<?>> hashMap = new java.util.HashMap<>();
        sPrimitiveToWrapperMap = hashMap;
        hashMap.put(java.lang.Boolean.TYPE, java.lang.Boolean.class);
        hashMap.put(java.lang.Byte.TYPE, java.lang.Byte.class);
        hashMap.put(java.lang.Character.TYPE, java.lang.Character.class);
        hashMap.put(java.lang.Short.TYPE, java.lang.Short.class);
        hashMap.put(java.lang.Integer.TYPE, java.lang.Integer.class);
        hashMap.put(java.lang.Long.TYPE, java.lang.Long.class);
        hashMap.put(java.lang.Double.TYPE, java.lang.Double.class);
        hashMap.put(java.lang.Float.TYPE, java.lang.Float.class);
        hashMap.put(java.lang.Void.TYPE, java.lang.Void.class);
        EMPTY_CLASS_ARRAY = new java.lang.Class[0];
    }

    public static java.lang.reflect.Method getAccessibleMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Method method;
        java.lang.String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (java.lang.reflect.Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && android.text.TextUtils.equals(method2.getName(), str)) {
                            java.lang.Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static java.lang.String getKey(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? java.lang.Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(java.lang.Void.class.toString());
        } else {
            for (java.lang.Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static <T> java.lang.reflect.Constructor<T> getMatchingAccessibleConstructor(java.lang.Class<T> cls, java.lang.Class<?>... clsArr) {
        try {
            java.lang.reflect.Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> T invokeConstructor(java.lang.Class<T> cls, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
        java.lang.reflect.Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
        if (matchingAccessibleConstructor != null) {
            return (T) matchingAccessibleConstructor.newInstance(objArr);
        }
        return null;
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        return invokeMethod(obj, str, objArr, toClass(objArr));
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
        java.lang.reflect.Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        throw new java.lang.NoSuchMethodException(str);
    }

    public static java.lang.Object invokeStaticMethod(java.lang.Class cls, java.lang.String str, java.lang.Object... objArr) {
        return invokeStaticMethod(cls, str, objArr, toClass(objArr));
    }

    public static java.lang.Object invokeStaticMethod(java.lang.Class cls, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
        java.lang.reflect.Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArr);
        }
        return null;
    }

    public static boolean isAssignableFrom(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static java.lang.Class<?>[] toClass(java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }
}
