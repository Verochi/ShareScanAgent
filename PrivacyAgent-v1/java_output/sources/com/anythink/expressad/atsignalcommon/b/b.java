package com.anythink.expressad.atsignalcommon.b;

/* loaded from: classes12.dex */
public class b {

    public interface a {
    }

    /* renamed from: com.anythink.expressad.atsignalcommon.b.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0179b<T> implements java.lang.reflect.InvocationHandler {
        private T a;

        private T a() {
            return this.a;
        }

        public final void a(T t) {
            this.a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            try {
                return method.invoke(this.a, objArr);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (java.lang.IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        }
    }

    private b() {
    }

    public static <T> T a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.b.b.AbstractC0179b<T> abstractC0179b, java.lang.Class<?>... clsArr) {
        abstractC0179b.a(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.anythink.expressad.atsignalcommon.b.b.class.getClassLoader(), clsArr, abstractC0179b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(java.lang.Object obj, java.lang.Class<T> cls, com.anythink.expressad.atsignalcommon.b.b.AbstractC0179b<T> abstractC0179b) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.b.b.a) {
            return obj;
        }
        abstractC0179b.a(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.anythink.expressad.atsignalcommon.b.b.class.getClassLoader(), new java.lang.Class[]{cls, com.anythink.expressad.atsignalcommon.b.b.a.class}, abstractC0179b);
    }
}
