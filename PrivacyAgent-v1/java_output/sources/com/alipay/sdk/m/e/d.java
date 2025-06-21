package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class d implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    @Override // com.alipay.sdk.m.e.j
    public final java.lang.Object a(java.lang.Object obj) {
        return ((java.lang.Enum) obj).name();
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        return java.lang.Enum.valueOf((java.lang.Class) type, obj.toString());
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return java.lang.Enum.class.isAssignableFrom(cls);
    }
}
