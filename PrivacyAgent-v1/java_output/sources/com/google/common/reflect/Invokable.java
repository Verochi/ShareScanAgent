package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class Invokable<T, R> extends com.google.common.reflect.Element implements java.lang.reflect.GenericDeclaration {

    public static class ConstructorInvokable<T> extends com.google.common.reflect.Invokable<T, T> {
        public final java.lang.reflect.Constructor<?> u;

        public ConstructorInvokable(java.lang.reflect.Constructor<?> constructor) {
            super(constructor);
            this.u = constructor;
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] a() {
            return this.u.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] b() {
            java.lang.reflect.Type[] genericParameterTypes = this.u.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !f()) {
                return genericParameterTypes;
            }
            java.lang.Class<?>[] parameterTypes = this.u.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (java.lang.reflect.Type[]) java.util.Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type c() {
            java.lang.Class<? super T> declaringClass = getDeclaringClass();
            java.lang.reflect.TypeVariable<java.lang.Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? com.google.common.reflect.Types.m(declaringClass, typeParameters) : declaringClass;
        }

        @Override // com.google.common.reflect.Invokable
        public final java.lang.annotation.Annotation[][] d() {
            return this.u.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final java.lang.Object e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Object[] objArr) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            try {
                return this.u.newInstance(objArr);
            } catch (java.lang.InstantiationException e) {
                throw new java.lang.RuntimeException(this.u + " failed.", e);
            }
        }

        public final boolean f() {
            java.lang.Class<?> declaringClass = this.u.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !java.lang.reflect.Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || java.lang.reflect.Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final java.lang.reflect.TypeVariable<?>[] getTypeParameters() {
            java.lang.reflect.TypeVariable<java.lang.Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<?>>[] typeParameters2 = this.u.getTypeParameters();
            java.lang.reflect.TypeVariable<?>[] typeVariableArr = new java.lang.reflect.TypeVariable[typeParameters.length + typeParameters2.length];
            java.lang.System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            java.lang.System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.u.isVarArgs();
        }
    }

    public static class MethodInvokable<T> extends com.google.common.reflect.Invokable<T, java.lang.Object> {
        public final java.lang.reflect.Method u;

        public MethodInvokable(java.lang.reflect.Method method) {
            super(method);
            this.u = method;
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] a() {
            return this.u.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] b() {
            return this.u.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public java.lang.reflect.Type c() {
            return this.u.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final java.lang.annotation.Annotation[][] d() {
            return this.u.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final java.lang.Object e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Object[] objArr) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            return this.u.invoke(obj, objArr);
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final java.lang.reflect.TypeVariable<?>[] getTypeParameters() {
            return this.u.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return (isFinal() || isPrivate() || isStatic() || java.lang.reflect.Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.u.isVarArgs();
        }
    }

    public <M extends java.lang.reflect.AccessibleObject & java.lang.reflect.Member> Invokable(M m) {
        super(m);
    }

    public static <T> com.google.common.reflect.Invokable<T, T> from(java.lang.reflect.Constructor<T> constructor) {
        return new com.google.common.reflect.Invokable.ConstructorInvokable(constructor);
    }

    public static com.google.common.reflect.Invokable<?, java.lang.Object> from(java.lang.reflect.Method method) {
        return new com.google.common.reflect.Invokable.MethodInvokable(method);
    }

    public abstract java.lang.reflect.Type[] a();

    public abstract java.lang.reflect.Type[] b();

    public abstract java.lang.reflect.Type c();

    public abstract java.lang.annotation.Annotation[][] d();

    public abstract java.lang.Object e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Object[] objArr) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException;

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.Element, java.lang.reflect.Member
    public final java.lang.Class<? super T> getDeclaringClass() {
        return (java.lang.Class<? super T>) super.getDeclaringClass();
    }

    public final com.google.common.collect.ImmutableList<com.google.common.reflect.TypeToken<? extends java.lang.Throwable>> getExceptionTypes() {
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (java.lang.reflect.Type type : a()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) com.google.common.reflect.TypeToken.of(type));
        }
        return builder.build();
    }

    @Override // com.google.common.reflect.Element
    public com.google.common.reflect.TypeToken<T> getOwnerType() {
        return com.google.common.reflect.TypeToken.of((java.lang.Class) getDeclaringClass());
    }

    public final com.google.common.collect.ImmutableList<com.google.common.reflect.Parameter> getParameters() {
        java.lang.reflect.Type[] b = b();
        java.lang.annotation.Annotation[][] d = d();
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (int i = 0; i < b.length; i++) {
            builder.add((com.google.common.collect.ImmutableList.Builder) new com.google.common.reflect.Parameter(this, i, com.google.common.reflect.TypeToken.of(b[i]), d[i]));
        }
        return builder.build();
    }

    public final com.google.common.reflect.TypeToken<? extends R> getReturnType() {
        return (com.google.common.reflect.TypeToken<? extends R>) com.google.common.reflect.TypeToken.of(c());
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final R invoke(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, java.lang.Object... objArr) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        return (R) e(t, (java.lang.Object[]) com.google.common.base.Preconditions.checkNotNull(objArr));
    }

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> com.google.common.reflect.Invokable<T, R1> returning(com.google.common.reflect.TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        throw new java.lang.IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + typeToken);
    }

    public final <R1 extends R> com.google.common.reflect.Invokable<T, R1> returning(java.lang.Class<R1> cls) {
        return returning(com.google.common.reflect.TypeToken.of((java.lang.Class) cls));
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }
}
