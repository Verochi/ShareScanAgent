package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class a implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    @Override // com.alipay.sdk.m.e.j
    public final java.lang.Object a(java.lang.Object obj) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj2 : (java.lang.Object[]) obj) {
            arrayList.add(com.alipay.sdk.m.e.f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        if (type instanceof java.lang.reflect.GenericArrayType) {
            throw new java.lang.IllegalArgumentException("Does not support generic array!");
        }
        java.lang.Class<?> componentType = ((java.lang.Class) type).getComponentType();
        int a = aVar.a();
        java.lang.Object newInstance = java.lang.reflect.Array.newInstance(componentType, a);
        for (int i = 0; i < a; i++) {
            java.lang.reflect.Array.set(newInstance, i, com.alipay.sdk.m.e.e.a(aVar.a(i), componentType));
        }
        return newInstance;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return cls.isArray();
    }
}
