package com.google.gson;

/* loaded from: classes22.dex */
public final class FieldAttributes {
    private final java.lang.reflect.Field field;

    public FieldAttributes(java.lang.reflect.Field field) {
        com.google.gson.internal.C$Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    public java.lang.Object get(java.lang.Object obj) throws java.lang.IllegalAccessException {
        return this.field.get(obj);
    }

    public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> cls) {
        return (T) this.field.getAnnotation(cls);
    }

    public java.util.Collection<java.lang.annotation.Annotation> getAnnotations() {
        return java.util.Arrays.asList(this.field.getAnnotations());
    }

    public java.lang.Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public java.lang.reflect.Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public java.lang.Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public java.lang.String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int i) {
        return (i & this.field.getModifiers()) != 0;
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
