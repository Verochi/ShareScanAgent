package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class y implements java.lang.reflect.InvocationHandler {
    public com.alipay.android.phone.mrpc.core.g a;
    public java.lang.Class<?> b;
    public com.alipay.android.phone.mrpc.core.z c;

    public y(com.alipay.android.phone.mrpc.core.g gVar, java.lang.Class<?> cls, com.alipay.android.phone.mrpc.core.z zVar) {
        this.a = gVar;
        this.b = cls;
        this.c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
