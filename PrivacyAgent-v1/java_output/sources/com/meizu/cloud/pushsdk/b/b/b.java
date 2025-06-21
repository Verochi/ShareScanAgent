package com.meizu.cloud.pushsdk.b.b;

/* loaded from: classes23.dex */
public class b {
    private final com.meizu.cloud.pushsdk.b.b.a a;
    private final java.lang.Class<?>[] b;

    public b(com.meizu.cloud.pushsdk.b.b.a aVar, java.lang.Class<?>... clsArr) {
        this.a = aVar;
        this.b = clsArr;
    }

    public <T> com.meizu.cloud.pushsdk.b.b.d<T> a(java.lang.Object... objArr) {
        com.meizu.cloud.pushsdk.b.b.d<T> dVar = new com.meizu.cloud.pushsdk.b.b.d<>();
        try {
            java.lang.reflect.Constructor<?> declaredConstructor = this.a.a().getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            dVar.b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("ReflectConstructor", "newInstance", e);
        }
        return dVar;
    }
}
