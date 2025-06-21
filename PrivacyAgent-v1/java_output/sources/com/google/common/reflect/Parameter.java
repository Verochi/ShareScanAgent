package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class Parameter implements java.lang.reflect.AnnotatedElement {
    public final com.google.common.reflect.Invokable<?, ?> n;
    public final int t;
    public final com.google.common.reflect.TypeToken<?> u;
    public final com.google.common.collect.ImmutableList<java.lang.annotation.Annotation> v;

    public Parameter(com.google.common.reflect.Invokable<?, ?> invokable, int i, com.google.common.reflect.TypeToken<?> typeToken, java.lang.annotation.Annotation[] annotationArr) {
        this.n = invokable;
        this.t = i;
        this.u = typeToken;
        this.v = com.google.common.collect.ImmutableList.copyOf(annotationArr);
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.reflect.Parameter)) {
            return false;
        }
        com.google.common.reflect.Parameter parameter = (com.google.common.reflect.Parameter) obj;
        return this.t == parameter.t && this.n.equals(parameter.n);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.Class<A> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        com.google.common.collect.UnmodifiableIterator<java.lang.annotation.Annotation> it = this.v.iterator();
        while (it.hasNext()) {
            java.lang.annotation.Annotation next = it.next();
            if (cls.isInstance(next)) {
                return cls.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public java.lang.annotation.Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends java.lang.annotation.Annotation> A[] getAnnotationsByType(java.lang.Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <A extends java.lang.annotation.Annotation> A getDeclaredAnnotation(java.lang.Class<A> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        return (A) com.google.common.collect.FluentIterable.from(this.v).filter(cls).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public java.lang.annotation.Annotation[] getDeclaredAnnotations() {
        com.google.common.collect.ImmutableList<java.lang.annotation.Annotation> immutableList = this.v;
        return (java.lang.annotation.Annotation[]) immutableList.toArray(new java.lang.annotation.Annotation[immutableList.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends java.lang.annotation.Annotation> A[] getDeclaredAnnotationsByType(java.lang.Class<A> cls) {
        return (A[]) ((java.lang.annotation.Annotation[]) com.google.common.collect.FluentIterable.from(this.v).filter(cls).toArray(cls));
    }

    public com.google.common.reflect.Invokable<?, ?> getDeclaringInvokable() {
        return this.n;
    }

    public com.google.common.reflect.TypeToken<?> getType() {
        return this.u;
    }

    public int hashCode() {
        return this.t;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public java.lang.String toString() {
        return this.u + " arg" + this.t;
    }
}
