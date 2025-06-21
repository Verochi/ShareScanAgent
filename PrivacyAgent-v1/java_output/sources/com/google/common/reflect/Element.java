package com.google.common.reflect;

/* loaded from: classes22.dex */
class Element extends java.lang.reflect.AccessibleObject implements java.lang.reflect.Member {
    public final java.lang.reflect.AccessibleObject n;
    public final java.lang.reflect.Member t;

    public <M extends java.lang.reflect.AccessibleObject & java.lang.reflect.Member> Element(M m) {
        com.google.common.base.Preconditions.checkNotNull(m);
        this.n = m;
        this.t = m;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.reflect.Element)) {
            return false;
        }
        com.google.common.reflect.Element element = (com.google.common.reflect.Element) obj;
        return getOwnerType().equals(element.getOwnerType()) && this.t.equals(element.t);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.Class<A> cls) {
        return (A) this.n.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final java.lang.annotation.Annotation[] getAnnotations() {
        return this.n.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final java.lang.annotation.Annotation[] getDeclaredAnnotations() {
        return this.n.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public java.lang.Class<?> getDeclaringClass() {
        return this.t.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.t.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final java.lang.String getName() {
        return this.t.getName();
    }

    public com.google.common.reflect.TypeToken<?> getOwnerType() {
        return com.google.common.reflect.TypeToken.of((java.lang.Class) getDeclaringClass());
    }

    public int hashCode() {
        return this.t.hashCode();
    }

    public final boolean isAbstract() {
        return java.lang.reflect.Modifier.isAbstract(getModifiers());
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.n.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return this.n.isAnnotationPresent(cls);
    }

    public final boolean isFinal() {
        return java.lang.reflect.Modifier.isFinal(getModifiers());
    }

    public final boolean isNative() {
        return java.lang.reflect.Modifier.isNative(getModifiers());
    }

    public final boolean isPackagePrivate() {
        return (isPrivate() || isPublic() || isProtected()) ? false : true;
    }

    public final boolean isPrivate() {
        return java.lang.reflect.Modifier.isPrivate(getModifiers());
    }

    public final boolean isProtected() {
        return java.lang.reflect.Modifier.isProtected(getModifiers());
    }

    public final boolean isPublic() {
        return java.lang.reflect.Modifier.isPublic(getModifiers());
    }

    public final boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(getModifiers());
    }

    public final boolean isSynchronized() {
        return java.lang.reflect.Modifier.isSynchronized(getModifiers());
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.t.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws java.lang.SecurityException {
        this.n.setAccessible(z);
    }

    public java.lang.String toString() {
        return this.t.toString();
    }
}
