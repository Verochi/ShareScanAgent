package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public class f {

    public interface a {
    }

    public static abstract class b<T> implements java.lang.reflect.InvocationHandler {
        private T a;

        private T a() {
            return this.a;
        }

        public final void a(T t) {
            this.a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            return method.invoke(this.a, objArr);
        }
    }

    private f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.f.b<T> bVar, java.lang.Class<?>... clsArr) {
        if (java.lang.reflect.Proxy.isProxyClass(obj.getClass())) {
            return obj;
        }
        bVar.a(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.anythink.expressad.atsignalcommon.windvane.f.class.getClassLoader(), clsArr, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(java.lang.Object obj, java.lang.Class<T> cls, com.anythink.expressad.atsignalcommon.windvane.f.b<T> bVar) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.f.a) {
            return obj;
        }
        bVar.a(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.anythink.expressad.atsignalcommon.windvane.f.class.getClassLoader(), new java.lang.Class[]{cls, com.anythink.expressad.atsignalcommon.windvane.f.a.class}, bVar);
    }
}
