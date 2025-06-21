package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class ReflectUtil {

    @android.annotation.SuppressLint({"NewApi"})
    private static final android.util.LruCache<java.lang.String, java.lang.Class<?>> mObjectLruCache = new android.util.LruCache<>(64);
    private static final java.util.Set<java.lang.String> mObjectSet = new java.util.HashSet();

    public static <T> T callMethod(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        java.lang.Class[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        java.lang.reflect.Method method = getMethod(obj.getClass(), str, clsArr);
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(obj, objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static <T> T callStaticMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (cls == null) {
            return null;
        }
        java.lang.Class[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        java.lang.reflect.Method method = getMethod(cls, str, clsArr);
        if (method != null) {
            try {
                return (T) method.invoke(null, objArr);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static <T> T findField(java.lang.Class<?> cls, java.lang.Object obj, java.lang.String... strArr) {
        java.lang.reflect.Field findFieldObj = findFieldObj(cls, strArr);
        if (findFieldObj == null) {
            return null;
        }
        try {
            return (T) findFieldObj.get(obj);
        } catch (java.lang.IllegalAccessException | java.lang.Exception unused) {
            return null;
        }
    }

    public static <T> T findField(java.lang.String[] strArr, java.lang.Object obj, java.lang.String... strArr2) {
        java.lang.Class<?> currentClass = getCurrentClass(strArr);
        if (currentClass != null) {
            return (T) findField(currentClass, obj, strArr2);
        }
        return null;
    }

    public static java.lang.reflect.Field findFieldObj(java.lang.Class<?> cls, java.lang.String... strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    java.lang.reflect.Field field = null;
                    for (java.lang.String str : strArr) {
                        try {
                            field = cls.getDeclaredField(str);
                        } catch (java.lang.NoSuchFieldException unused) {
                            field = null;
                        }
                        if (field != null) {
                            break;
                        }
                    }
                    if (field == null) {
                        return null;
                    }
                    field.setAccessible(true);
                    return field;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        return null;
    }

    public static java.lang.reflect.Field findFieldObjRecur(java.lang.Class<?> cls, java.lang.String str) {
        while (cls != java.lang.Object.class) {
            try {
                java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (java.lang.NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static <T> T findFieldRecur(java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field findFieldObjRecur = findFieldObjRecur(obj.getClass(), str);
        if (findFieldObjRecur == null) {
            return null;
        }
        try {
            return (T) findFieldObjRecur.get(obj);
        } catch (java.lang.IllegalAccessException unused) {
            return null;
        }
    }

    public static java.lang.Class<?> getClassByName(java.lang.String str) {
        try {
            android.util.LruCache<java.lang.String, java.lang.Class<?>> lruCache = mObjectLruCache;
            java.lang.Class<?> cls = lruCache.get(str);
            if (cls != null || mObjectSet.contains(str)) {
                return cls;
            }
            java.lang.Class<?> cls2 = java.lang.Class.forName(str);
            lruCache.put(str, cls2);
            return cls2;
        } catch (java.lang.ClassNotFoundException unused) {
            mObjectSet.add(str);
            return null;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static java.lang.Class<?> getCurrentClass(java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        java.lang.Class<?> cls = null;
        for (int i = 0; i < strArr.length; i++) {
            try {
                android.util.LruCache<java.lang.String, java.lang.Class<?>> lruCache = mObjectLruCache;
                java.lang.Class<?> cls2 = lruCache.get(strArr[i]);
                if (cls2 == null && !mObjectSet.contains(strArr[i])) {
                    cls2 = java.lang.Class.forName(strArr[i]);
                    lruCache.put(strArr[i], cls2);
                }
                cls = cls2;
            } catch (java.lang.Throwable unused) {
                mObjectSet.add(strArr[i]);
                cls = null;
            }
            if (cls != null) {
                break;
            }
        }
        return cls;
    }

    public static java.lang.reflect.Method getDeclaredRecur(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        java.lang.reflect.Method declaredMethod;
        while (cls != java.lang.Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (java.lang.NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
            if (declaredMethod != null) {
                return declaredMethod;
            }
        }
        return null;
    }

    public static java.lang.reflect.Method getMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    public static boolean isInstance(java.lang.Object obj, java.lang.String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (java.lang.String str : strArr) {
            try {
                android.util.LruCache<java.lang.String, java.lang.Class<?>> lruCache = mObjectLruCache;
                java.lang.Class<?> cls = lruCache.get(str);
                if (cls == null && !mObjectSet.contains(str)) {
                    cls = java.lang.Class.forName(str);
                    lruCache.put(str, cls);
                }
                if (cls != null) {
                    z = cls.isInstance(obj);
                }
            } catch (java.lang.Throwable unused) {
                mObjectSet.add(str);
            }
            if (z) {
                break;
            }
        }
        return z;
    }
}
