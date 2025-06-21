package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class z {
    public static final java.lang.ThreadLocal<java.lang.Object> a = new java.lang.ThreadLocal<>();
    public static final java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> b = new java.lang.ThreadLocal<>();
    public byte c = 0;
    public java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger();
    public com.alipay.android.phone.mrpc.core.x e;

    public z(com.alipay.android.phone.mrpc.core.x xVar) {
        this.e = xVar;
    }

    public final java.lang.Object a(java.lang.reflect.Method method, java.lang.Object[] objArr) {
        if (android.os.Looper.myLooper() != null && android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalThreadStateException("can't in main thread call rpc .");
        }
        com.alipay.mobile.framework.service.annotation.OperationType operationType = (com.alipay.mobile.framework.service.annotation.OperationType) method.getAnnotation(com.alipay.mobile.framework.service.annotation.OperationType.class);
        boolean z = method.getAnnotation(com.alipay.mobile.framework.service.annotation.ResetCookie.class) != null;
        java.lang.reflect.Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        java.lang.ThreadLocal<java.lang.Object> threadLocal = a;
        threadLocal.set(null);
        java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> threadLocal2 = b;
        threadLocal2.set(null);
        if (operationType == null) {
            throw new java.lang.IllegalStateException("OperationType must be set.");
        }
        java.lang.String value = operationType.value();
        int incrementAndGet = this.d.incrementAndGet();
        try {
            if (this.c == 0) {
                com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                if (threadLocal2.get() != null) {
                    eVar.a(threadLocal2.get());
                }
                byte[] bArr = (byte[]) new com.alipay.android.phone.mrpc.core.j(this.e.a(), method, incrementAndGet, value, eVar.a(), z).a();
                threadLocal2.set(null);
                java.lang.Object a2 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, bArr).a();
                if (genericReturnType != java.lang.Void.TYPE) {
                    threadLocal.set(a2);
                }
            }
            return threadLocal.get();
        } catch (com.alipay.android.phone.mrpc.core.RpcException e) {
            e.setOperationType(value);
            throw e;
        }
    }
}
