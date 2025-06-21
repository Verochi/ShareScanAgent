package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Enums {

    @com.google.common.annotations.GwtIncompatible
    public static final java.util.Map<java.lang.Class<? extends java.lang.Enum<?>>, java.util.Map<java.lang.String, java.lang.ref.WeakReference<? extends java.lang.Enum<?>>>> a = new java.util.WeakHashMap();

    public static final class StringConverter<T extends java.lang.Enum<T>> extends com.google.common.base.Converter<java.lang.String, T> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.Class<T> enumClass;

        public StringConverter(java.lang.Class<T> cls) {
            this.enumClass = (java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doBackward(T t) {
            return t.name();
        }

        @Override // com.google.common.base.Converter
        public T doForward(java.lang.String str) {
            return (T) java.lang.Enum.valueOf(this.enumClass, str);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Enums.StringConverter) {
                return this.enumClass.equals(((com.google.common.base.Enums.StringConverter) obj).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public java.lang.String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T extends java.lang.Enum<T>> java.util.Map<java.lang.String, java.lang.ref.WeakReference<? extends java.lang.Enum<?>>> a(java.lang.Class<T> cls) {
        java.util.Map<java.lang.String, java.lang.ref.WeakReference<? extends java.lang.Enum<?>>> map;
        java.util.Map<java.lang.Class<? extends java.lang.Enum<?>>, java.util.Map<java.lang.String, java.lang.ref.WeakReference<? extends java.lang.Enum<?>>>> map2 = a;
        synchronized (map2) {
            map = map2.get(cls);
            if (map == null) {
                map = b(cls);
            }
        }
        return map;
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T extends java.lang.Enum<T>> java.util.Map<java.lang.String, java.lang.ref.WeakReference<? extends java.lang.Enum<?>>> b(java.lang.Class<T> cls) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Iterator it = java.util.EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            java.lang.Enum r2 = (java.lang.Enum) it.next();
            hashMap.put(r2.name(), new java.lang.ref.WeakReference(r2));
        }
        a.put(cls, hashMap);
        return hashMap;
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.lang.reflect.Field getField(java.lang.Enum<?> r1) {
        try {
            return r1.getDeclaringClass().getDeclaredField(r1.name());
        } catch (java.lang.NoSuchFieldException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static <T extends java.lang.Enum<T>> com.google.common.base.Optional<T> getIfPresent(java.lang.Class<T> cls, java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        com.google.common.base.Preconditions.checkNotNull(str);
        return com.google.common.base.Platform.d(cls, str);
    }

    public static <T extends java.lang.Enum<T>> com.google.common.base.Converter<java.lang.String, T> stringConverter(java.lang.Class<T> cls) {
        return new com.google.common.base.Enums.StringConverter(cls);
    }
}
