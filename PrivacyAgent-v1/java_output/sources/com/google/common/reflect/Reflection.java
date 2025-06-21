package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class Reflection {
    public static java.lang.String getPackageName(java.lang.Class<?> cls) {
        return getPackageName(cls.getName());
    }

    public static java.lang.String getPackageName(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? "" : str.substring(0, lastIndexOf);
    }

    public static void initialize(java.lang.Class<?>... clsArr) {
        for (java.lang.Class<?> cls : clsArr) {
            try {
                java.lang.Class.forName(cls.getName(), true, cls.getClassLoader());
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public static <T> T newProxy(java.lang.Class<T> cls, java.lang.reflect.InvocationHandler invocationHandler) {
        com.google.common.base.Preconditions.checkNotNull(invocationHandler);
        com.google.common.base.Preconditions.checkArgument(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(java.lang.reflect.Proxy.newProxyInstance(cls.getClassLoader(), new java.lang.Class[]{cls}, invocationHandler));
    }
}
