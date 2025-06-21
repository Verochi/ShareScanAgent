package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class Annotation {
    public java.lang.annotation.Annotation a;

    public Annotation(java.lang.annotation.Annotation annotation) {
        this.a = annotation;
    }

    public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> cls) {
        if (this.a.annotationType().equals(cls)) {
            return (T) this.a;
        }
        return null;
    }

    public java.lang.Class<? extends java.lang.annotation.Annotation> getAnnotationType() {
        return this.a.annotationType();
    }
}
