package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class j {
    protected static com.anythink.core.common.o.j a = new com.anythink.core.common.o.j();

    public static com.anythink.core.api.ATBaseAdAdapter a(com.anythink.core.common.f.au auVar) {
        try {
            return a(auVar.i());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static com.anythink.core.api.ATBaseAdAdapter a(java.lang.Class<? extends com.anythink.core.common.b.a> cls) {
        java.lang.reflect.Constructor<? extends com.anythink.core.common.b.a> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (com.anythink.core.api.ATBaseAdAdapter) declaredConstructor.newInstance(new java.lang.Object[0]);
    }

    public static com.anythink.core.api.ATBaseAdAdapter a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.reflect.Constructor declaredConstructor = java.lang.Class.forName(str).asSubclass(com.anythink.core.api.ATBaseAdAdapter.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (com.anythink.core.api.ATBaseAdAdapter) declaredConstructor.newInstance(new java.lang.Object[0]);
    }
}
