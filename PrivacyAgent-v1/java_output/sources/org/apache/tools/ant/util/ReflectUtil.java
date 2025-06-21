package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ReflectUtil {
    public static java.lang.Object getField(java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static java.lang.Object invoke(java.lang.Object obj, java.lang.String str) {
        try {
            return obj.getClass().getMethod(str, null).invoke(obj, null);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static java.lang.Object invoke(java.lang.Object obj, java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj2) {
        try {
            return obj.getClass().getMethod(str, cls).invoke(obj, obj2);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static java.lang.Object invoke(java.lang.Object obj, java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj2, java.lang.Class<?> cls2, java.lang.Object obj3) {
        try {
            return obj.getClass().getMethod(str, cls, cls2).invoke(obj, obj2, obj3);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static java.lang.Object invokeStatic(java.lang.Object obj, java.lang.String str) {
        try {
            return ((java.lang.Class) obj).getMethod(str, null).invoke(obj, null);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static <T> T newInstance(java.lang.Class<T> cls, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        try {
            return cls.getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Exception e) {
            throwBuildException(e);
            return null;
        }
    }

    public static boolean respondsTo(java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            for (java.lang.reflect.Method method : obj.getClass().getMethods()) {
                if (method.getName().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            throw toBuildException(e);
        }
    }

    public static void throwBuildException(java.lang.Exception exc) throws org.apache.tools.ant.BuildException {
        throw toBuildException(exc);
    }

    public static org.apache.tools.ant.BuildException toBuildException(java.lang.Exception exc) {
        if (!(exc instanceof java.lang.reflect.InvocationTargetException)) {
            return new org.apache.tools.ant.BuildException(exc);
        }
        java.lang.Throwable targetException = ((java.lang.reflect.InvocationTargetException) exc).getTargetException();
        return targetException instanceof org.apache.tools.ant.BuildException ? (org.apache.tools.ant.BuildException) targetException : new org.apache.tools.ant.BuildException(targetException);
    }
}
