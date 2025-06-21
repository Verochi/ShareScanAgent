package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class c implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    @Override // com.alipay.sdk.m.e.j
    public final java.lang.Object a(java.lang.Object obj) {
        return java.lang.Long.valueOf(((java.util.Date) obj).getTime());
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        return new java.util.Date(((java.lang.Long) obj).longValue());
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return java.util.Date.class.isAssignableFrom(cls);
    }
}
