package com.google.common.reflect;

/* loaded from: classes22.dex */
final class Types {
    public static final com.google.common.base.Function<java.lang.reflect.Type, java.lang.String> a = new com.google.common.reflect.Types.AnonymousClass1();
    public static final com.google.common.base.Joiner b = com.google.common.base.Joiner.on(", ").useForNull(com.igexin.push.core.b.m);

    /* renamed from: com.google.common.reflect.Types$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Function<java.lang.reflect.Type, java.lang.String> {
        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String apply(java.lang.reflect.Type type) {
            return com.google.common.reflect.Types.JavaVersion.CURRENT.typeName(type);
        }
    }

    /* renamed from: com.google.common.reflect.Types$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.google.common.reflect.TypeVisitor {
        public final /* synthetic */ java.util.concurrent.atomic.AtomicReference b;

        public AnonymousClass2(java.util.concurrent.atomic.AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(java.lang.Class<?> cls) {
            this.b.set(cls.getComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(java.lang.reflect.GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
            this.b.set(com.google.common.reflect.Types.q(typeVariable.getBounds()));
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(java.lang.reflect.WildcardType wildcardType) {
            this.b.set(com.google.common.reflect.Types.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class ClassOwnership {
        private static final /* synthetic */ com.google.common.reflect.Types.ClassOwnership[] $VALUES;
        static final com.google.common.reflect.Types.ClassOwnership JVM_BEHAVIOR;
        public static final com.google.common.reflect.Types.ClassOwnership LOCAL_CLASS_HAS_NO_OWNER;
        public static final com.google.common.reflect.Types.ClassOwnership OWNED_BY_ENCLOSING_CLASS;

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.reflect.Types.ClassOwnership {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.ClassOwnership
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.Class<?> getOwnerType(java.lang.Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$1LocalClass, reason: invalid class name */
        public class C1LocalClass<T> {
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.reflect.Types.ClassOwnership {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.ClassOwnership
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.Class<?> getOwnerType(java.lang.Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$3, reason: invalid class name */
        public static class AnonymousClass3 extends com.google.common.reflect.Types.ClassOwnership.C1LocalClass<java.lang.String> {
        }

        static {
            com.google.common.reflect.Types.ClassOwnership.AnonymousClass1 anonymousClass1 = new com.google.common.reflect.Types.ClassOwnership.AnonymousClass1("OWNED_BY_ENCLOSING_CLASS", 0);
            OWNED_BY_ENCLOSING_CLASS = anonymousClass1;
            com.google.common.reflect.Types.ClassOwnership.AnonymousClass2 anonymousClass2 = new com.google.common.reflect.Types.ClassOwnership.AnonymousClass2("LOCAL_CLASS_HAS_NO_OWNER", 1);
            LOCAL_CLASS_HAS_NO_OWNER = anonymousClass2;
            $VALUES = new com.google.common.reflect.Types.ClassOwnership[]{anonymousClass1, anonymousClass2};
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private ClassOwnership(java.lang.String str, int i) {
        }

        public /* synthetic */ ClassOwnership(java.lang.String str, int i, com.google.common.reflect.Types.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        private static com.google.common.reflect.Types.ClassOwnership detectJvmBehavior() {
            new com.google.common.reflect.Types.ClassOwnership.AnonymousClass3();
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) com.google.common.reflect.Types.ClassOwnership.AnonymousClass3.class.getGenericSuperclass();
            for (com.google.common.reflect.Types.ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(com.google.common.reflect.Types.ClassOwnership.C1LocalClass.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new java.lang.AssertionError();
        }

        public static com.google.common.reflect.Types.ClassOwnership valueOf(java.lang.String str) {
            return (com.google.common.reflect.Types.ClassOwnership) java.lang.Enum.valueOf(com.google.common.reflect.Types.ClassOwnership.class, str);
        }

        public static com.google.common.reflect.Types.ClassOwnership[] values() {
            return (com.google.common.reflect.Types.ClassOwnership[]) $VALUES.clone();
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public abstract java.lang.Class<?> getOwnerType(java.lang.Class<?> cls);
    }

    public static final class GenericArrayTypeImpl implements java.lang.reflect.GenericArrayType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type componentType;

        public GenericArrayTypeImpl(java.lang.reflect.Type type) {
            this.componentType = com.google.common.reflect.Types.JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof java.lang.reflect.GenericArrayType) {
                return com.google.common.base.Objects.equal(getGenericComponentType(), ((java.lang.reflect.GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public java.lang.reflect.Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public java.lang.String toString() {
            return com.google.common.reflect.Types.t(this.componentType) + "[]";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class JavaVersion {
        private static final /* synthetic */ com.google.common.reflect.Types.JavaVersion[] $VALUES;
        static final com.google.common.reflect.Types.JavaVersion CURRENT;
        public static final com.google.common.reflect.Types.JavaVersion JAVA6;
        public static final com.google.common.reflect.Types.JavaVersion JAVA7;
        public static final com.google.common.reflect.Types.JavaVersion JAVA8;
        public static final com.google.common.reflect.Types.JavaVersion JAVA9;

        /* renamed from: com.google.common.reflect.Types$JavaVersion$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.reflect.Types.JavaVersion {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.GenericArrayType newArrayType(java.lang.reflect.Type type) {
                return new com.google.common.reflect.Types.GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type usedInGenericType(java.lang.reflect.Type type) {
                com.google.common.base.Preconditions.checkNotNull(type);
                if (!(type instanceof java.lang.Class)) {
                    return type;
                }
                java.lang.Class cls = (java.lang.Class) type;
                return cls.isArray() ? new com.google.common.reflect.Types.GenericArrayTypeImpl(cls.getComponentType()) : type;
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.reflect.Types.JavaVersion {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type newArrayType(java.lang.reflect.Type type) {
                return type instanceof java.lang.Class ? com.google.common.reflect.Types.i((java.lang.Class) type) : new com.google.common.reflect.Types.GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type usedInGenericType(java.lang.reflect.Type type) {
                return (java.lang.reflect.Type) com.google.common.base.Preconditions.checkNotNull(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.reflect.Types.JavaVersion {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type newArrayType(java.lang.reflect.Type type) {
                return com.google.common.reflect.Types.JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.String typeName(java.lang.reflect.Type type) {
                try {
                    return (java.lang.String) java.lang.reflect.Type.class.getMethod("getTypeName", new java.lang.Class[0]).invoke(type, new java.lang.Object[0]);
                } catch (java.lang.IllegalAccessException e) {
                    e = e;
                    throw new java.lang.RuntimeException(e);
                } catch (java.lang.NoSuchMethodException unused) {
                    throw new java.lang.AssertionError("Type.getTypeName should be available in Java 8");
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    e = e2;
                    throw new java.lang.RuntimeException(e);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type usedInGenericType(java.lang.reflect.Type type) {
                return com.google.common.reflect.Types.JavaVersion.JAVA7.usedInGenericType(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.common.reflect.Types.JavaVersion {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type newArrayType(java.lang.reflect.Type type) {
                return com.google.common.reflect.Types.JavaVersion.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.String typeName(java.lang.reflect.Type type) {
                return com.google.common.reflect.Types.JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public java.lang.reflect.Type usedInGenericType(java.lang.reflect.Type type) {
                return com.google.common.reflect.Types.JavaVersion.JAVA8.usedInGenericType(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$5, reason: invalid class name */
        public static class AnonymousClass5 extends com.google.common.reflect.TypeCapture<java.util.Map.Entry<java.lang.String, int[][]>> {
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$6, reason: invalid class name */
        public static class AnonymousClass6 extends com.google.common.reflect.TypeCapture<int[]> {
        }

        static {
            com.google.common.reflect.Types.JavaVersion.AnonymousClass1 anonymousClass1 = new com.google.common.reflect.Types.JavaVersion.AnonymousClass1("JAVA6", 0);
            JAVA6 = anonymousClass1;
            com.google.common.reflect.Types.JavaVersion.AnonymousClass2 anonymousClass2 = new com.google.common.reflect.Types.JavaVersion.AnonymousClass2("JAVA7", 1);
            JAVA7 = anonymousClass2;
            com.google.common.reflect.Types.JavaVersion.AnonymousClass3 anonymousClass3 = new com.google.common.reflect.Types.JavaVersion.AnonymousClass3("JAVA8", 2);
            JAVA8 = anonymousClass3;
            com.google.common.reflect.Types.JavaVersion.AnonymousClass4 anonymousClass4 = new com.google.common.reflect.Types.JavaVersion.AnonymousClass4("JAVA9", 3);
            JAVA9 = anonymousClass4;
            $VALUES = new com.google.common.reflect.Types.JavaVersion[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4};
            if (java.lang.reflect.AnnotatedElement.class.isAssignableFrom(java.lang.reflect.TypeVariable.class)) {
                if (new com.google.common.reflect.Types.JavaVersion.AnonymousClass5().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = anonymousClass3;
                    return;
                } else {
                    CURRENT = anonymousClass4;
                    return;
                }
            }
            if (new com.google.common.reflect.Types.JavaVersion.AnonymousClass6().capture() instanceof java.lang.Class) {
                CURRENT = anonymousClass2;
            } else {
                CURRENT = anonymousClass1;
            }
        }

        private JavaVersion(java.lang.String str, int i) {
        }

        public /* synthetic */ JavaVersion(java.lang.String str, int i, com.google.common.reflect.Types.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.reflect.Types.JavaVersion valueOf(java.lang.String str) {
            return (com.google.common.reflect.Types.JavaVersion) java.lang.Enum.valueOf(com.google.common.reflect.Types.JavaVersion.class, str);
        }

        public static com.google.common.reflect.Types.JavaVersion[] values() {
            return (com.google.common.reflect.Types.JavaVersion[]) $VALUES.clone();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract java.lang.reflect.Type newArrayType(java.lang.reflect.Type type);

        public java.lang.String typeName(java.lang.reflect.Type type) {
            return com.google.common.reflect.Types.t(type);
        }

        public final com.google.common.collect.ImmutableList<java.lang.reflect.Type> usedInGenericType(java.lang.reflect.Type[] typeArr) {
            com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
            for (java.lang.reflect.Type type : typeArr) {
                builder.add((com.google.common.collect.ImmutableList.Builder) usedInGenericType(type));
            }
            return builder.build();
        }

        public abstract java.lang.reflect.Type usedInGenericType(java.lang.reflect.Type type);
    }

    public static final class NativeTypeVariableEquals<X> {
        public static final boolean a = !com.google.common.reflect.Types.NativeTypeVariableEquals.class.getTypeParameters()[0].equals(com.google.common.reflect.Types.l(com.google.common.reflect.Types.NativeTypeVariableEquals.class, "X", new java.lang.reflect.Type[0]));
    }

    public static final class ParameterizedTypeImpl implements java.lang.reflect.ParameterizedType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.ImmutableList<java.lang.reflect.Type> argumentsList;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final java.lang.reflect.Type ownerType;
        private final java.lang.Class<?> rawType;

        public ParameterizedTypeImpl(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.Type[] typeArr) {
            com.google.common.base.Preconditions.checkNotNull(cls);
            com.google.common.base.Preconditions.checkArgument(typeArr.length == cls.getTypeParameters().length);
            com.google.common.reflect.Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = com.google.common.reflect.Types.JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof java.lang.reflect.ParameterizedType)) {
                return false;
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.common.base.Objects.equal(getOwnerType(), parameterizedType.getOwnerType()) && java.util.Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type[] getActualTypeArguments() {
            return com.google.common.reflect.Types.s(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            java.lang.reflect.Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (this.ownerType != null) {
                com.google.common.reflect.Types.JavaVersion javaVersion = com.google.common.reflect.Types.JavaVersion.CURRENT;
                if (javaVersion.jdkTypeDuplicatesOwnerName()) {
                    sb.append(javaVersion.typeName(this.ownerType));
                    sb.append('.');
                }
            }
            sb.append(this.rawType.getName());
            sb.append(kotlin.text.Typography.less);
            sb.append(com.google.common.reflect.Types.b.join(com.google.common.collect.Iterables.transform(this.argumentsList, com.google.common.reflect.Types.a)));
            sb.append(kotlin.text.Typography.greater);
            return sb.toString();
        }
    }

    public static final class TypeVariableImpl<D extends java.lang.reflect.GenericDeclaration> {
        public final D a;
        public final java.lang.String b;
        public final com.google.common.collect.ImmutableList<java.lang.reflect.Type> c;

        public TypeVariableImpl(D d, java.lang.String str, java.lang.reflect.Type[] typeArr) {
            com.google.common.reflect.Types.g(typeArr, "bound for type variable");
            this.a = (D) com.google.common.base.Preconditions.checkNotNull(d);
            this.b = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
            this.c = com.google.common.collect.ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.a;
        }

        public java.lang.String b() {
            return this.b;
        }

        public boolean equals(java.lang.Object obj) {
            if (!com.google.common.reflect.Types.NativeTypeVariableEquals.a) {
                if (!(obj instanceof java.lang.reflect.TypeVariable)) {
                    return false;
                }
                java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) obj;
                return this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !java.lang.reflect.Proxy.isProxyClass(obj.getClass()) || !(java.lang.reflect.Proxy.getInvocationHandler(obj) instanceof com.google.common.reflect.Types.TypeVariableInvocationHandler)) {
                return false;
            }
            com.google.common.reflect.Types.TypeVariableImpl typeVariableImpl = ((com.google.common.reflect.Types.TypeVariableInvocationHandler) java.lang.reflect.Proxy.getInvocationHandler(obj)).n;
            return this.b.equals(typeVariableImpl.b()) && this.a.equals(typeVariableImpl.a()) && this.c.equals(typeVariableImpl.c);
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public java.lang.String toString() {
            return this.b;
        }
    }

    public static final class TypeVariableInvocationHandler implements java.lang.reflect.InvocationHandler {
        public static final com.google.common.collect.ImmutableMap<java.lang.String, java.lang.reflect.Method> t;
        public final com.google.common.reflect.Types.TypeVariableImpl<?> n;

        static {
            com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
            for (java.lang.reflect.Method method : com.google.common.reflect.Types.TypeVariableImpl.class.getMethods()) {
                if (method.getDeclaringClass().equals(com.google.common.reflect.Types.TypeVariableImpl.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (java.security.AccessControlException unused) {
                    }
                    builder.put(method.getName(), method);
                }
            }
            t = builder.build();
        }

        public TypeVariableInvocationHandler(com.google.common.reflect.Types.TypeVariableImpl<?> typeVariableImpl) {
            this.n = typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.String name = method.getName();
            java.lang.reflect.Method method2 = t.get(name);
            if (method2 == null) {
                throw new java.lang.UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.n, objArr);
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    public static final class WildcardTypeImpl implements java.lang.reflect.WildcardType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.ImmutableList<java.lang.reflect.Type> lowerBounds;
        private final com.google.common.collect.ImmutableList<java.lang.reflect.Type> upperBounds;

        public WildcardTypeImpl(java.lang.reflect.Type[] typeArr, java.lang.reflect.Type[] typeArr2) {
            com.google.common.reflect.Types.g(typeArr, "lower bound for wildcard");
            com.google.common.reflect.Types.g(typeArr2, "upper bound for wildcard");
            com.google.common.reflect.Types.JavaVersion javaVersion = com.google.common.reflect.Types.JavaVersion.CURRENT;
            this.lowerBounds = javaVersion.usedInGenericType(typeArr);
            this.upperBounds = javaVersion.usedInGenericType(typeArr2);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof java.lang.reflect.WildcardType)) {
                return false;
            }
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) obj;
            return this.lowerBounds.equals(java.util.Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(java.util.Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getLowerBounds() {
            return com.google.common.reflect.Types.s(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getUpperBounds() {
            return com.google.common.reflect.Types.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("?");
            com.google.common.collect.UnmodifiableIterator<java.lang.reflect.Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                java.lang.reflect.Type next = it.next();
                sb.append(" super ");
                sb.append(com.google.common.reflect.Types.JavaVersion.CURRENT.typeName(next));
            }
            for (java.lang.reflect.Type type : com.google.common.reflect.Types.h(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(com.google.common.reflect.Types.JavaVersion.CURRENT.typeName(type));
            }
            return sb.toString();
        }
    }

    public static void g(java.lang.reflect.Type[] typeArr, java.lang.String str) {
        for (java.lang.reflect.Type type : typeArr) {
            if (type instanceof java.lang.Class) {
                com.google.common.base.Preconditions.checkArgument(!r2.isPrimitive(), "Primitive type '%s' used as %s", (java.lang.Class) type, str);
            }
        }
    }

    public static java.lang.Iterable<java.lang.reflect.Type> h(java.lang.Iterable<java.lang.reflect.Type> iterable) {
        return com.google.common.collect.Iterables.filter(iterable, com.google.common.base.Predicates.not(com.google.common.base.Predicates.equalTo(java.lang.Object.class)));
    }

    public static java.lang.Class<?> i(java.lang.Class<?> cls) {
        return java.lang.reflect.Array.newInstance(cls, 0).getClass();
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.reflect.Type j(java.lang.reflect.Type type) {
        com.google.common.base.Preconditions.checkNotNull(type);
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        new com.google.common.reflect.Types.AnonymousClass2(atomicReference).a(type);
        return (java.lang.reflect.Type) atomicReference.get();
    }

    public static java.lang.reflect.Type k(java.lang.reflect.Type type) {
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return com.google.common.reflect.Types.JavaVersion.CURRENT.newArrayType(type);
        }
        java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
        java.lang.reflect.Type[] lowerBounds = wildcardType.getLowerBounds();
        com.google.common.base.Preconditions.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        java.lang.reflect.Type[] upperBounds = wildcardType.getUpperBounds();
        com.google.common.base.Preconditions.checkArgument(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    public static <D extends java.lang.reflect.GenericDeclaration> java.lang.reflect.TypeVariable<D> l(D d, java.lang.String str, java.lang.reflect.Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new java.lang.reflect.Type[]{java.lang.Object.class};
        }
        return o(d, str, typeArr);
    }

    public static java.lang.reflect.ParameterizedType m(java.lang.Class<?> cls, java.lang.reflect.Type... typeArr) {
        return new com.google.common.reflect.Types.ParameterizedTypeImpl(com.google.common.reflect.Types.ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static java.lang.reflect.ParameterizedType n(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        com.google.common.base.Preconditions.checkNotNull(typeArr);
        com.google.common.base.Preconditions.checkArgument(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new com.google.common.reflect.Types.ParameterizedTypeImpl(type, cls, typeArr);
    }

    public static <D extends java.lang.reflect.GenericDeclaration> java.lang.reflect.TypeVariable<D> o(D d, java.lang.String str, java.lang.reflect.Type[] typeArr) {
        return (java.lang.reflect.TypeVariable) com.google.common.reflect.Reflection.newProxy(java.lang.reflect.TypeVariable.class, new com.google.common.reflect.Types.TypeVariableInvocationHandler(new com.google.common.reflect.Types.TypeVariableImpl(d, str, typeArr)));
    }

    @com.google.common.annotations.VisibleForTesting
    public static java.lang.reflect.WildcardType p(java.lang.reflect.Type type) {
        return new com.google.common.reflect.Types.WildcardTypeImpl(new java.lang.reflect.Type[0], new java.lang.reflect.Type[]{type});
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.reflect.Type q(java.lang.reflect.Type[] typeArr) {
        for (java.lang.reflect.Type type : typeArr) {
            java.lang.reflect.Type j = j(type);
            if (j != null) {
                if (j instanceof java.lang.Class) {
                    java.lang.Class cls = (java.lang.Class) j;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j);
            }
        }
        return null;
    }

    @com.google.common.annotations.VisibleForTesting
    public static java.lang.reflect.WildcardType r(java.lang.reflect.Type type) {
        return new com.google.common.reflect.Types.WildcardTypeImpl(new java.lang.reflect.Type[]{type}, new java.lang.reflect.Type[]{java.lang.Object.class});
    }

    public static java.lang.reflect.Type[] s(java.util.Collection<java.lang.reflect.Type> collection) {
        return (java.lang.reflect.Type[]) collection.toArray(new java.lang.reflect.Type[collection.size()]);
    }

    public static java.lang.String t(java.lang.reflect.Type type) {
        return type instanceof java.lang.Class ? ((java.lang.Class) type).getName() : type.toString();
    }
}
