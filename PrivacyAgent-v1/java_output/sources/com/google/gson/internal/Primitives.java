package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(java.lang.reflect.Type type) {
        return (type instanceof java.lang.Class) && ((java.lang.Class) type).isPrimitive();
    }

    public static boolean isWrapperType(java.lang.reflect.Type type) {
        return type == java.lang.Integer.class || type == java.lang.Float.class || type == java.lang.Byte.class || type == java.lang.Double.class || type == java.lang.Long.class || type == java.lang.Character.class || type == java.lang.Boolean.class || type == java.lang.Short.class || type == java.lang.Void.class;
    }

    public static <T> java.lang.Class<T> unwrap(java.lang.Class<T> cls) {
        return cls == java.lang.Integer.class ? java.lang.Integer.TYPE : cls == java.lang.Float.class ? java.lang.Float.TYPE : cls == java.lang.Byte.class ? java.lang.Byte.TYPE : cls == java.lang.Double.class ? java.lang.Double.TYPE : cls == java.lang.Long.class ? java.lang.Long.TYPE : cls == java.lang.Character.class ? java.lang.Character.TYPE : cls == java.lang.Boolean.class ? java.lang.Boolean.TYPE : cls == java.lang.Short.class ? java.lang.Short.TYPE : cls == java.lang.Void.class ? java.lang.Void.TYPE : cls;
    }

    public static <T> java.lang.Class<T> wrap(java.lang.Class<T> cls) {
        return cls == java.lang.Integer.TYPE ? java.lang.Integer.class : cls == java.lang.Float.TYPE ? java.lang.Float.class : cls == java.lang.Byte.TYPE ? java.lang.Byte.class : cls == java.lang.Double.TYPE ? java.lang.Double.class : cls == java.lang.Long.TYPE ? java.lang.Long.class : cls == java.lang.Character.TYPE ? java.lang.Character.class : cls == java.lang.Boolean.TYPE ? java.lang.Boolean.class : cls == java.lang.Short.TYPE ? java.lang.Short.class : cls == java.lang.Void.TYPE ? java.lang.Void.class : cls;
    }
}
