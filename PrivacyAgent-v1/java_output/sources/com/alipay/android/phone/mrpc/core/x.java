package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class x {
    public com.alipay.android.phone.mrpc.core.g a;
    public com.alipay.android.phone.mrpc.core.z b = new com.alipay.android.phone.mrpc.core.z(this);

    public x(com.alipay.android.phone.mrpc.core.g gVar) {
        this.a = gVar;
    }

    public final com.alipay.android.phone.mrpc.core.g a() {
        return this.a;
    }

    public final <T> T a(java.lang.Class<T> cls) {
        return (T) java.lang.reflect.Proxy.newProxyInstance(cls.getClassLoader(), new java.lang.Class[]{cls}, new com.alipay.android.phone.mrpc.core.y(this.a, cls, this.b));
    }
}
