package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public class JavaCallsUtils {
    private static final java.lang.String LOG_TAG = "JavaCalls";
    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> PRIMITIVE_MAP;

    public static class JavaParam<T> {
        public final java.lang.Class<? extends T> clazz;
        public final T obj;

        public JavaParam(java.lang.Class<? extends T> cls, T t) {
            this.clazz = cls;
            this.obj = t;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        PRIMITIVE_MAP = hashMap;
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

    public static <T> T callMethod(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call Method '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        return (T) getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T callStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(java.lang.Class.forName(str), str2, objArr);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call Method '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            return null;
        }
    }

    public static <T> T callStaticMethodOrThrow(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        return (T) getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodOrThrow(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        return (T) getDeclaredMethod(java.lang.Class.forName(str), str2, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodWithClassLoader(java.lang.String str, java.lang.String str2, java.lang.ClassLoader classLoader, java.lang.Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(java.lang.Class.forName(str, true, classLoader), str2, objArr);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Meet exception when call Method '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            return null;
        }
    }

    private static boolean compareClassLists(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
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
            if (!clsArr[i].isAssignableFrom(clsArr2[i])) {
                java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map = PRIMITIVE_MAP;
                if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static java.lang.reflect.Method findMethodByName(java.lang.reflect.Method[] methodArr, java.lang.String str, java.lang.Class<?>[] clsArr) {
        if (str == null) {
            throw new java.lang.NullPointerException("Method name must not be null.");
        }
        for (java.lang.reflect.Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static java.lang.reflect.Method getDeclaredMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Method findMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
        if (findMethodByName != null) {
            findMethodByName.setAccessible(true);
            return findMethodByName;
        }
        if (cls.getSuperclass() != null) {
            return getDeclaredMethod(cls.getSuperclass(), str, clsArr);
        }
        throw new java.lang.NoSuchMethodException();
    }

    private static java.lang.Object getDefaultValue(java.lang.Class<?> cls) {
        if (java.lang.Integer.TYPE.equals(cls) || java.lang.Integer.class.equals(cls) || java.lang.Byte.TYPE.equals(cls) || java.lang.Byte.class.equals(cls) || java.lang.Short.TYPE.equals(cls) || java.lang.Short.class.equals(cls) || java.lang.Long.TYPE.equals(cls) || java.lang.Long.class.equals(cls) || java.lang.Double.TYPE.equals(cls) || java.lang.Double.class.equals(cls) || java.lang.Float.TYPE.equals(cls) || java.lang.Float.class.equals(cls)) {
            return 0;
        }
        return (java.lang.Boolean.TYPE.equals(cls) || java.lang.Boolean.class.equals(cls)) ? java.lang.Boolean.FALSE : (java.lang.Character.TYPE.equals(cls) || java.lang.Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static <T> T getField(java.lang.Object obj, java.lang.String str) {
        try {
            return (T) getFieldOrThrow(obj, str);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T getFieldOrThrow(java.lang.Object obj, java.lang.String str) {
        java.lang.Class<?> cls = obj.getClass();
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

    private static java.lang.Class<?>[] getParameterTypes(java.lang.Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof com.bytedance.android.live.base.api.JavaCallsUtils.JavaParam)) ? obj == null ? null : obj.getClass() : ((com.bytedance.android.live.base.api.JavaCallsUtils.JavaParam) obj).clazz;
        }
        return clsArr;
    }

    private static java.lang.Object[] getParameters(java.lang.Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        java.lang.Object[] objArr2 = new java.lang.Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (obj == null || !(obj instanceof com.bytedance.android.live.base.api.JavaCallsUtils.JavaParam)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((com.bytedance.android.live.base.api.JavaCallsUtils.JavaParam) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T newEmptyInstance(java.lang.Class<?> cls) {
        try {
            return (T) newEmptyInstanceOrThrow(cls);
        } catch (java.lang.Exception unused) {
            new java.lang.StringBuilder("Meet exception when make instance as a ").append(cls.getSimpleName());
            return null;
        }
    }

    public static <T> T newEmptyInstanceOrThrow(java.lang.Class<?> cls) {
        java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new java.lang.IllegalArgumentException("Can't get even one available constructor for ".concat(java.lang.String.valueOf(cls)));
        }
        java.lang.reflect.Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new java.lang.Object[0]);
        }
        java.lang.Object[] objArr = new java.lang.Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getDefaultValue(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    public static <T> T newInstance(java.lang.Class<?> cls, java.lang.Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (java.lang.Exception unused) {
            new java.lang.StringBuilder("Meet exception when make instance as a ").append(cls.getSimpleName());
            return null;
        }
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (java.lang.Exception unused) {
            "Meet exception when make instance as a ".concat(java.lang.String.valueOf(str));
            return null;
        }
    }

    public static <T> T newInstanceOrThrow(java.lang.Class<?> cls, java.lang.Object... objArr) {
        java.lang.reflect.Constructor<?> constructor = cls.getConstructor(getParameterTypes(objArr));
        constructor.setAccessible(true);
        return (T) constructor.newInstance(getParameters(objArr));
    }

    public static java.lang.Object newInstanceOrThrow(java.lang.String str, java.lang.Object... objArr) {
        return newInstanceOrThrow(java.lang.Class.forName(str), getParameters(objArr));
    }

    public static void setField(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public static void setFieldOrThrow(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
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
    }
}
