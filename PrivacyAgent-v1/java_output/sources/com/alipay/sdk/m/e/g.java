package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class g implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[SYNTHETIC] */
    @Override // com.alipay.sdk.m.e.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object a(java.lang.Object obj) {
        java.lang.Object obj2;
        java.util.TreeMap treeMap = new java.util.TreeMap();
        java.lang.Class<?> cls = obj.getClass();
        while (true) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            if (cls.equals(java.lang.Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                for (java.lang.reflect.Field field : declaredFields) {
                    if (field != null && !"this$0".equals(field.getName())) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        java.lang.Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            field.setAccessible(isAccessible);
                            obj2 = com.alipay.sdk.m.e.f.b(obj3);
                            if (obj2 == null) {
                                treeMap.put(field.getName(), obj2);
                            }
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        if (!obj.getClass().equals(org.json.alipay.b.class)) {
            return null;
        }
        org.json.alipay.b bVar = (org.json.alipay.b) obj;
        java.lang.Class cls = (java.lang.Class) type;
        java.lang.Object newInstance = cls.newInstance();
        while (!cls.equals(java.lang.Object.class)) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (java.lang.reflect.Field field : declaredFields) {
                    java.lang.String name = field.getName();
                    java.lang.reflect.Type genericType = field.getGenericType();
                    if (bVar.b(name)) {
                        field.setAccessible(true);
                        field.set(newInstance, com.alipay.sdk.m.e.e.a(bVar.a(name), genericType));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return newInstance;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return true;
    }
}
