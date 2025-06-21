package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class au {
    static com.baidu.mobads.sdk.internal.bt a = com.baidu.mobads.sdk.internal.bt.a();
    private static final java.lang.String b = "com.baidu.mobads.sdk.internal.au";

    public static java.lang.Class<?> a(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Class<?> a(java.lang.String str, java.lang.ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (java.lang.Exception e) {
                a.a(b, android.util.Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public static java.lang.ClassLoader a(android.content.Context context) {
        return com.baidu.mobads.sdk.internal.an.a(com.baidu.mobads.sdk.internal.bz.a(context), context.getFilesDir().getAbsolutePath(), (java.lang.String) null, com.baidu.mobads.sdk.internal.au.class.getClassLoader());
    }

    public static java.lang.Object a(java.lang.Class<?> cls, java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Class cls, java.lang.String str) {
        java.lang.reflect.Field b2 = b((java.lang.Class<?>) cls, str);
        if (b2 == null) {
            return null;
        }
        b2.setAccessible(true);
        try {
            return b2.get(cls);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.ClassLoader classLoader, java.lang.String str, java.lang.String str2) {
        try {
            return a((java.lang.Class) java.lang.Class.forName(str, true, classLoader), str2);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field b2 = b(obj, str);
        if (b2 == null) {
            return null;
        }
        b2.setAccessible(true);
        try {
            return b2.get(obj);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.ClassLoader classLoader, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            java.lang.Class<?> a2 = a(str, classLoader);
            if (a2 == null) {
                return null;
            }
            java.lang.reflect.Method declaredMethod = a2.getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.ClassLoader classLoader, java.lang.reflect.InvocationHandler invocationHandler) {
        java.lang.Class<?> a2 = a(str, classLoader);
        if (a2 != null) {
            return java.lang.reflect.Proxy.newProxyInstance(a2.getClassLoader(), new java.lang.Class[]{a2}, invocationHandler);
        }
        return null;
    }

    public static java.lang.Object a(java.lang.String str, java.lang.ClassLoader classLoader, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        try {
            java.lang.Class<?> a2 = a(str, classLoader);
            if (a2 != null) {
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Object obj, java.lang.ClassLoader classLoader, java.lang.String str2, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        java.lang.reflect.Method declaredMethod;
        try {
            java.lang.Class<?> a2 = a(str, classLoader);
            if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        java.lang.reflect.Method declaredMethod;
        try {
            java.lang.Class<?> a2 = a(str);
            if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.reflect.InvocationHandler invocationHandler) {
        java.lang.Class<?> a2 = a(str);
        if (a2 != null) {
            return java.lang.reflect.Proxy.newProxyInstance(a2.getClassLoader(), new java.lang.Class[]{a2}, invocationHandler);
        }
        return null;
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        try {
            java.lang.Class<?> a2 = a(str);
            if (a2 != null) {
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (java.lang.NoSuchMethodException unused) {
            return false;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return false;
        }
    }

    public static java.lang.Class<?>[] a(java.lang.Object... objArr) {
        try {
            int length = objArr.length;
            java.lang.Class<?>[] clsArr = new java.lang.Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return clsArr;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }

    public static java.lang.reflect.Field b(java.lang.Class<?> cls, java.lang.String str) {
        while (cls != java.lang.Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (java.lang.Exception e) {
                a.b(b, android.util.Log.getStackTraceString(e));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static java.lang.reflect.Field b(java.lang.Object obj, java.lang.String str) {
        for (java.lang.Class<?> cls = obj.getClass(); cls != java.lang.Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (java.lang.Exception e) {
                a.b(b, android.util.Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public static java.lang.reflect.Method b(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Exception e) {
            a.b(b, android.util.Log.getStackTraceString(e));
            return null;
        }
    }
}
