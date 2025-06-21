package com.sijla.mla;

/* loaded from: classes19.dex */
final class f implements java.lang.reflect.InvocationHandler {
    private /* synthetic */ com.sijla.mla.a.r a;
    private /* synthetic */ com.sijla.mla.e b;

    public f(com.sijla.mla.e eVar, com.sijla.mla.a.r rVar) {
        this.b = eVar;
        this.a = rVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        com.sijla.mla.a.r g = this.a.g(method.getName());
        java.lang.Class<?> returnType = method.getReturnType();
        if (!returnType.equals(java.lang.Void.class) && !returnType.equals(java.lang.Void.TYPE)) {
            return g.b(com.sijla.mla.e.a(objArr));
        }
        g.b(com.sijla.mla.e.a(objArr));
        return com.sijla.mla.a.r.k;
    }
}
