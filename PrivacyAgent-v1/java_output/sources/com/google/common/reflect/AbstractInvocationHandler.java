package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class AbstractInvocationHandler implements java.lang.reflect.InvocationHandler {
    public static final java.lang.Object[] n = new java.lang.Object[0];

    public static boolean a(java.lang.Object obj, java.lang.Class<?> cls) {
        return cls.isInstance(obj) || (java.lang.reflect.Proxy.isProxyClass(obj.getClass()) && java.util.Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces()));
    }

    public boolean equals(java.lang.Object obj) {
        return super.equals(obj);
    }

    public abstract java.lang.Object handleInvocation(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable;

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object[] objArr) throws java.lang.Throwable {
        if (objArr == null) {
            objArr = n;
        }
        if (objArr.length == 0 && method.getName().equals(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE)) {
            return java.lang.Integer.valueOf(hashCode());
        }
        if (objArr.length != 1 || !method.getName().equals("equals") || method.getParameterTypes()[0] != java.lang.Object.class) {
            return (objArr.length == 0 && method.getName().equals("toString")) ? toString() : handleInvocation(obj, method, objArr);
        }
        java.lang.Object obj2 = objArr[0];
        if (obj2 == null) {
            return java.lang.Boolean.FALSE;
        }
        if (obj == obj2) {
            return java.lang.Boolean.TRUE;
        }
        return java.lang.Boolean.valueOf(a(obj2, obj.getClass()) && equals(java.lang.reflect.Proxy.getInvocationHandler(obj2)));
    }

    public java.lang.String toString() {
        return super.toString();
    }
}
