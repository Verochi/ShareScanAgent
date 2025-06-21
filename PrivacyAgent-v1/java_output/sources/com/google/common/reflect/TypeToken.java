package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class TypeToken<T> extends com.google.common.reflect.TypeCapture<T> implements java.io.Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.reflect.TypeResolver covariantTypeResolver;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.reflect.TypeResolver invariantTypeResolver;
    private final java.lang.reflect.Type runtimeType;

    /* renamed from: com.google.common.reflect.TypeToken$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.reflect.Invokable.MethodInvokable<T> {
        public AnonymousClass1(java.lang.reflect.Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] a() {
            return com.google.common.reflect.TypeToken.this.getCovariantTypeResolver().k(super.a());
        }

        @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] b() {
            return com.google.common.reflect.TypeToken.this.getInvariantTypeResolver().k(super.b());
        }

        @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type c() {
            return com.google.common.reflect.TypeToken.this.getCovariantTypeResolver().resolveType(super.c());
        }

        @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
        public com.google.common.reflect.TypeToken<T> getOwnerType() {
            return com.google.common.reflect.TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
        public java.lang.String toString() {
            return getOwnerType() + "." + super.toString();
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.reflect.Invokable.ConstructorInvokable<T> {
        public AnonymousClass2(java.lang.reflect.Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] a() {
            return com.google.common.reflect.TypeToken.this.getCovariantTypeResolver().k(super.a());
        }

        @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type[] b() {
            return com.google.common.reflect.TypeToken.this.getInvariantTypeResolver().k(super.b());
        }

        @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
        public java.lang.reflect.Type c() {
            return com.google.common.reflect.TypeToken.this.getCovariantTypeResolver().resolveType(super.c());
        }

        @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
        public com.google.common.reflect.TypeToken<T> getOwnerType() {
            return com.google.common.reflect.TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
        public java.lang.String toString() {
            return getOwnerType() + "(" + com.google.common.base.Joiner.on(", ").join(b()) + ")";
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.reflect.TypeVisitor {
        public AnonymousClass3() {
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(java.lang.reflect.GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(java.lang.reflect.ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
            throw new java.lang.IllegalArgumentException(com.google.common.reflect.TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(java.lang.reflect.WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$4, reason: invalid class name */
    public class AnonymousClass4 extends com.google.common.reflect.TypeVisitor {
        public final /* synthetic */ com.google.common.collect.ImmutableSet.Builder b;

        public AnonymousClass4(com.google.common.collect.ImmutableSet.Builder builder) {
            this.b = builder;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(java.lang.Class<?> cls) {
            this.b.add((com.google.common.collect.ImmutableSet.Builder) cls);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(java.lang.reflect.GenericArrayType genericArrayType) {
            this.b.add((com.google.common.collect.ImmutableSet.Builder) com.google.common.reflect.Types.i(com.google.common.reflect.TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(java.lang.reflect.ParameterizedType parameterizedType) {
            this.b.add((com.google.common.collect.ImmutableSet.Builder) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(java.lang.reflect.WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static class Bounds {
        public final java.lang.reflect.Type[] a;
        public final boolean b;

        public Bounds(java.lang.reflect.Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        public boolean a(java.lang.reflect.Type type) {
            for (java.lang.reflect.Type type2 : this.a) {
                boolean isSubtypeOf = com.google.common.reflect.TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }

        public boolean b(java.lang.reflect.Type type) {
            com.google.common.reflect.TypeToken<?> of = com.google.common.reflect.TypeToken.of(type);
            for (java.lang.reflect.Type type2 : this.a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }
    }

    public final class ClassSet extends com.google.common.reflect.TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        public /* synthetic */ ClassSet(com.google.common.reflect.TypeToken typeToken, com.google.common.reflect.TypeToken.AnonymousClass1 anonymousClass1) {
            this();
        }

        private java.lang.Object readResolve() {
            return com.google.common.reflect.TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public com.google.common.reflect.TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<com.google.common.reflect.TypeToken<? super T>> delegate() {
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> set = com.google.common.collect.FluentIterable.from(com.google.common.reflect.TypeToken.TypeCollector.a.a().d(com.google.common.reflect.TypeToken.this)).filter(com.google.common.reflect.TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = set;
            return set;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public com.google.common.reflect.TypeToken<T>.TypeSet interfaces() {
            throw new java.lang.UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public java.util.Set<java.lang.Class<? super T>> rawTypes() {
            return com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) com.google.common.reflect.TypeToken.TypeCollector.b.a().c(com.google.common.reflect.TypeToken.this.getRawTypes()));
        }
    }

    public final class InterfaceSet extends com.google.common.reflect.TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient com.google.common.reflect.TypeToken<T>.TypeSet allTypes;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> interfaces;

        /* renamed from: com.google.common.reflect.TypeToken$InterfaceSet$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Predicate<java.lang.Class<?>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Predicate
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(java.lang.Class<?> cls) {
                return cls.isInterface();
            }
        }

        public InterfaceSet(com.google.common.reflect.TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private java.lang.Object readResolve() {
            return com.google.common.reflect.TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public com.google.common.reflect.TypeToken<T>.TypeSet classes() {
            throw new java.lang.UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<com.google.common.reflect.TypeToken<? super T>> delegate() {
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> set = com.google.common.collect.FluentIterable.from(this.allTypes).filter(com.google.common.reflect.TypeToken.TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = set;
            return set;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public com.google.common.reflect.TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public java.util.Set<java.lang.Class<? super T>> rawTypes() {
            return com.google.common.collect.FluentIterable.from(com.google.common.reflect.TypeToken.TypeCollector.b.c(com.google.common.reflect.TypeToken.this.getRawTypes())).filter(new com.google.common.reflect.TypeToken.InterfaceSet.AnonymousClass1()).toSet();
        }
    }

    public static final class SimpleTypeToken<T> extends com.google.common.reflect.TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(java.lang.reflect.Type type) {
            super(type, null);
        }
    }

    public static abstract class TypeCollector<K> {
        public static final com.google.common.reflect.TypeToken.TypeCollector<com.google.common.reflect.TypeToken<?>> a = new com.google.common.reflect.TypeToken.TypeCollector.AnonymousClass1();
        public static final com.google.common.reflect.TypeToken.TypeCollector<java.lang.Class<?>> b = new com.google.common.reflect.TypeToken.TypeCollector.AnonymousClass2();

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$1, reason: invalid class name */
        public static class AnonymousClass1 extends com.google.common.reflect.TypeToken.TypeCollector<com.google.common.reflect.TypeToken<?>> {
            public AnonymousClass1() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public java.lang.Iterable<? extends com.google.common.reflect.TypeToken<?>> e(com.google.common.reflect.TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public java.lang.Class<?> f(com.google.common.reflect.TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public com.google.common.reflect.TypeToken<?> g(com.google.common.reflect.TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$2, reason: invalid class name */
        public static class AnonymousClass2 extends com.google.common.reflect.TypeToken.TypeCollector<java.lang.Class<?>> {
            public AnonymousClass2() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public java.lang.Iterable<? extends java.lang.Class<?>> e(java.lang.Class<?> cls) {
                return java.util.Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public java.lang.Class<?> f(java.lang.Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public java.lang.Class<?> g(java.lang.Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$3, reason: invalid class name */
        public class AnonymousClass3 extends com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector<K> {
            public AnonymousClass3(com.google.common.reflect.TypeToken.TypeCollector typeCollector) {
                super(typeCollector);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public com.google.common.collect.ImmutableList<K> c(java.lang.Iterable<? extends K> iterable) {
                com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
                for (K k : iterable) {
                    if (!f(k).isInterface()) {
                        builder.add((com.google.common.collect.ImmutableList.Builder) k);
                    }
                }
                return super.c(builder.build());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector, com.google.common.reflect.TypeToken.TypeCollector
            public java.lang.Iterable<? extends K> e(K k) {
                return com.google.common.collect.ImmutableSet.of();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$4, reason: invalid class name */
        public static class AnonymousClass4 extends com.google.common.collect.Ordering<K> {
            public final /* synthetic */ java.util.Comparator n;
            public final /* synthetic */ java.util.Map t;

            public AnonymousClass4(java.util.Comparator comparator, java.util.Map map) {
                this.n = comparator;
                this.t = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                return this.n.compare(this.t.get(k), this.t.get(k2));
            }
        }

        public static class ForwardingTypeCollector<K> extends com.google.common.reflect.TypeToken.TypeCollector<K> {
            public final com.google.common.reflect.TypeToken.TypeCollector<K> c;

            public ForwardingTypeCollector(com.google.common.reflect.TypeToken.TypeCollector<K> typeCollector) {
                super(null);
                this.c = typeCollector;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public java.lang.Iterable<? extends K> e(K k) {
                return this.c.e(k);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public java.lang.Class<?> f(K k) {
                return this.c.f(k);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public K g(K k) {
                return this.c.g(k);
            }
        }

        public TypeCollector() {
        }

        public /* synthetic */ TypeCollector(com.google.common.reflect.TypeToken.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static <K, V> com.google.common.collect.ImmutableList<K> h(java.util.Map<K, V> map, java.util.Comparator<? super V> comparator) {
            return (com.google.common.collect.ImmutableList<K>) new com.google.common.reflect.TypeToken.TypeCollector.AnonymousClass4(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final com.google.common.reflect.TypeToken.TypeCollector<K> a() {
            return new com.google.common.reflect.TypeToken.TypeCollector.AnonymousClass3(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final int b(K k, java.util.Map<? super K, java.lang.Integer> map) {
            java.lang.Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k).isInterface();
            java.util.Iterator<? extends K> it = e(k).iterator();
            int i = isInterface;
            while (it.hasNext()) {
                i = java.lang.Math.max(i, b(it.next(), map));
            }
            K g = g(k);
            int i2 = i;
            if (g != null) {
                i2 = java.lang.Math.max(i, b(g, map));
            }
            int i3 = i2 + 1;
            map.put(k, java.lang.Integer.valueOf(i3));
            return i3;
        }

        public com.google.common.collect.ImmutableList<K> c(java.lang.Iterable<? extends K> iterable) {
            java.util.HashMap newHashMap = com.google.common.collect.Maps.newHashMap();
            java.util.Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), newHashMap);
            }
            return h(newHashMap, com.google.common.collect.Ordering.natural().reverse());
        }

        public final com.google.common.collect.ImmutableList<K> d(K k) {
            return c(com.google.common.collect.ImmutableList.of(k));
        }

        public abstract java.lang.Iterable<? extends K> e(K k);

        public abstract java.lang.Class<?> f(K k);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public abstract K g(K k);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class TypeFilter implements com.google.common.base.Predicate<com.google.common.reflect.TypeToken<?>> {
        private static final /* synthetic */ com.google.common.reflect.TypeToken.TypeFilter[] $VALUES;
        public static final com.google.common.reflect.TypeToken.TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD;
        public static final com.google.common.reflect.TypeToken.TypeFilter INTERFACE_ONLY;

        /* renamed from: com.google.common.reflect.TypeToken$TypeFilter$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.reflect.TypeToken.TypeFilter {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(com.google.common.reflect.TypeToken<?> typeToken) {
                return ((((com.google.common.reflect.TypeToken) typeToken).runtimeType instanceof java.lang.reflect.TypeVariable) || (((com.google.common.reflect.TypeToken) typeToken).runtimeType instanceof java.lang.reflect.WildcardType)) ? false : true;
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeFilter$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.reflect.TypeToken.TypeFilter {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(com.google.common.reflect.TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }

        static {
            com.google.common.reflect.TypeToken.TypeFilter.AnonymousClass1 anonymousClass1 = new com.google.common.reflect.TypeToken.TypeFilter.AnonymousClass1("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = anonymousClass1;
            com.google.common.reflect.TypeToken.TypeFilter.AnonymousClass2 anonymousClass2 = new com.google.common.reflect.TypeToken.TypeFilter.AnonymousClass2("INTERFACE_ONLY", 1);
            INTERFACE_ONLY = anonymousClass2;
            $VALUES = new com.google.common.reflect.TypeToken.TypeFilter[]{anonymousClass1, anonymousClass2};
        }

        private TypeFilter(java.lang.String str, int i) {
        }

        public /* synthetic */ TypeFilter(java.lang.String str, int i, com.google.common.reflect.TypeToken.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.reflect.TypeToken.TypeFilter valueOf(java.lang.String str) {
            return (com.google.common.reflect.TypeToken.TypeFilter) java.lang.Enum.valueOf(com.google.common.reflect.TypeToken.TypeFilter.class, str);
        }

        public static com.google.common.reflect.TypeToken.TypeFilter[] values() {
            return (com.google.common.reflect.TypeToken.TypeFilter[]) $VALUES.clone();
        }
    }

    public class TypeSet extends com.google.common.collect.ForwardingSet<com.google.common.reflect.TypeToken<? super T>> implements java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> types;

        public TypeSet() {
        }

        public com.google.common.reflect.TypeToken<T>.TypeSet classes() {
            return new com.google.common.reflect.TypeToken.ClassSet(com.google.common.reflect.TypeToken.this, null);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<com.google.common.reflect.TypeToken<? super T>> delegate() {
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            com.google.common.collect.ImmutableSet<com.google.common.reflect.TypeToken<? super T>> set = com.google.common.collect.FluentIterable.from(com.google.common.reflect.TypeToken.TypeCollector.a.d(com.google.common.reflect.TypeToken.this)).filter(com.google.common.reflect.TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = set;
            return set;
        }

        public com.google.common.reflect.TypeToken<T>.TypeSet interfaces() {
            return new com.google.common.reflect.TypeToken.InterfaceSet(this);
        }

        public java.util.Set<java.lang.Class<? super T>> rawTypes() {
            return com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) com.google.common.reflect.TypeToken.TypeCollector.b.c(com.google.common.reflect.TypeToken.this.getRawTypes()));
        }
    }

    public TypeToken() {
        java.lang.reflect.Type capture = capture();
        this.runtimeType = capture;
        com.google.common.base.Preconditions.checkState(!(capture instanceof java.lang.reflect.TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public TypeToken(java.lang.Class<?> cls) {
        java.lang.reflect.Type capture = super.capture();
        if (capture instanceof java.lang.Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = com.google.common.reflect.TypeResolver.d(cls).resolveType(capture);
        }
    }

    private TypeToken(java.lang.reflect.Type type) {
        this.runtimeType = (java.lang.reflect.Type) com.google.common.base.Preconditions.checkNotNull(type);
    }

    public /* synthetic */ TypeToken(java.lang.reflect.Type type, com.google.common.reflect.TypeToken.AnonymousClass1 anonymousClass1) {
        this(type);
    }

    private static com.google.common.reflect.TypeToken.Bounds any(java.lang.reflect.Type[] typeArr) {
        return new com.google.common.reflect.TypeToken.Bounds(typeArr, true);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private com.google.common.reflect.TypeToken<? super T> boundAsSuperclass(java.lang.reflect.Type type) {
        com.google.common.reflect.TypeToken<? super T> typeToken = (com.google.common.reflect.TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private com.google.common.collect.ImmutableList<com.google.common.reflect.TypeToken<? super T>> boundsAsInterfaces(java.lang.reflect.Type[] typeArr) {
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (java.lang.reflect.Type type : typeArr) {
            com.google.common.reflect.TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.add((com.google.common.collect.ImmutableList.Builder) of);
            }
        }
        return builder.build();
    }

    private static java.lang.reflect.Type canonicalizeTypeArg(java.lang.reflect.TypeVariable<?> typeVariable, java.lang.reflect.Type type) {
        return type instanceof java.lang.reflect.WildcardType ? canonicalizeWildcardType(typeVariable, (java.lang.reflect.WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    private static java.lang.reflect.WildcardType canonicalizeWildcardType(java.lang.reflect.TypeVariable<?> typeVariable, java.lang.reflect.WildcardType wildcardType) {
        java.lang.reflect.Type[] bounds = typeVariable.getBounds();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.reflect.Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new com.google.common.reflect.Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (java.lang.reflect.Type[]) arrayList.toArray(new java.lang.reflect.Type[0]));
    }

    private static java.lang.reflect.ParameterizedType canonicalizeWildcardsInParameterizedType(java.lang.reflect.ParameterizedType parameterizedType) {
        java.lang.Class cls = (java.lang.Class) parameterizedType.getRawType();
        java.lang.reflect.TypeVariable<java.lang.Class<T>>[] typeParameters = cls.getTypeParameters();
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return com.google.common.reflect.Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static java.lang.reflect.Type canonicalizeWildcardsInType(java.lang.reflect.Type type) {
        return type instanceof java.lang.reflect.ParameterizedType ? canonicalizeWildcardsInParameterizedType((java.lang.reflect.ParameterizedType) type) : type instanceof java.lang.reflect.GenericArrayType ? com.google.common.reflect.Types.k(canonicalizeWildcardsInType(((java.lang.reflect.GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static com.google.common.reflect.TypeToken.Bounds every(java.lang.reflect.Type[] typeArr) {
        return new com.google.common.reflect.TypeToken.Bounds(typeArr, false);
    }

    private com.google.common.reflect.TypeToken<? extends T> getArraySubtype(java.lang.Class<?> cls) {
        return (com.google.common.reflect.TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.google.common.reflect.TypeToken<? super T> getArraySupertype(java.lang.Class<? super T> cls) {
        return (com.google.common.reflect.TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((com.google.common.reflect.TypeToken) com.google.common.base.Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.TypeResolver getCovariantTypeResolver() {
        com.google.common.reflect.TypeResolver typeResolver = this.covariantTypeResolver;
        if (typeResolver != null) {
            return typeResolver;
        }
        com.google.common.reflect.TypeResolver d = com.google.common.reflect.TypeResolver.d(this.runtimeType);
        this.covariantTypeResolver = d;
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.TypeResolver getInvariantTypeResolver() {
        com.google.common.reflect.TypeResolver typeResolver = this.invariantTypeResolver;
        if (typeResolver != null) {
            return typeResolver;
        }
        com.google.common.reflect.TypeResolver f = com.google.common.reflect.TypeResolver.f(this.runtimeType);
        this.invariantTypeResolver = f;
        return f;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private java.lang.reflect.Type getOwnerTypeIfPresent() {
        java.lang.reflect.Type type = this.runtimeType;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return ((java.lang.reflect.ParameterizedType) type).getOwnerType();
        }
        if (type instanceof java.lang.Class) {
            return ((java.lang.Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.collect.ImmutableSet<java.lang.Class<? super T>> getRawTypes() {
        com.google.common.collect.ImmutableSet.Builder builder = com.google.common.collect.ImmutableSet.builder();
        new com.google.common.reflect.TypeToken.AnonymousClass4(builder).a(this.runtimeType);
        return builder.build();
    }

    private com.google.common.reflect.TypeToken<? extends T> getSubtypeFromLowerBounds(java.lang.Class<?> cls, java.lang.reflect.Type[] typeArr) {
        if (typeArr.length > 0) {
            return (com.google.common.reflect.TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new java.lang.IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private com.google.common.reflect.TypeToken<? super T> getSupertypeFromUpperBounds(java.lang.Class<? super T> cls, java.lang.reflect.Type[] typeArr) {
        for (java.lang.reflect.Type type : typeArr) {
            com.google.common.reflect.TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (com.google.common.reflect.TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new java.lang.IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(java.lang.reflect.Type type, java.lang.reflect.TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        java.lang.reflect.WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (java.lang.reflect.WildcardType) type);
        return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(java.lang.reflect.Type type) {
        java.util.Iterator<com.google.common.reflect.TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            java.lang.reflect.Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type type = this.runtimeType;
        if (!(type instanceof java.lang.Class)) {
            if (type instanceof java.lang.reflect.GenericArrayType) {
                return of(((java.lang.reflect.GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        java.lang.Class cls = (java.lang.Class) type;
        if (cls.isArray()) {
            return of((java.lang.Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(java.lang.reflect.ParameterizedType parameterizedType) {
        java.lang.Class<? super java.lang.Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        java.lang.reflect.TypeVariable<java.lang.Class<? super java.lang.Object>>[] typeParameters = rawType.getTypeParameters();
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!of(getCovariantTypeResolver().resolveType(typeParameters[i])).is(actualTypeArguments[i], typeParameters[i])) {
                return false;
            }
        }
        return java.lang.reflect.Modifier.isStatic(((java.lang.Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type type = this.runtimeType;
        if (type instanceof java.lang.Class) {
            java.lang.Class cls = (java.lang.Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(java.lang.Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((java.lang.reflect.GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return com.google.common.primitives.Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    private static java.lang.reflect.Type newArrayClassOrGenericArrayType(java.lang.reflect.Type type) {
        return com.google.common.reflect.Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> com.google.common.reflect.TypeToken<T> of(java.lang.Class<T> cls) {
        return new com.google.common.reflect.TypeToken.SimpleTypeToken(cls);
    }

    public static com.google.common.reflect.TypeToken<?> of(java.lang.reflect.Type type) {
        return new com.google.common.reflect.TypeToken.SimpleTypeToken(type);
    }

    private com.google.common.reflect.TypeToken<?> resolveSupertype(java.lang.reflect.Type type) {
        com.google.common.reflect.TypeToken<?> of = of(getCovariantTypeResolver().resolveType(type));
        of.covariantTypeResolver = this.covariantTypeResolver;
        of.invariantTypeResolver = this.invariantTypeResolver;
        return of;
    }

    private java.lang.reflect.Type resolveTypeArgsForSubclass(java.lang.Class<?> cls) {
        if ((this.runtimeType instanceof java.lang.Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        com.google.common.reflect.TypeToken genericType = toGenericType(cls);
        return new com.google.common.reflect.TypeResolver().where(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(java.lang.Class<?> cls) {
        com.google.common.collect.UnmodifiableIterator<java.lang.Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @com.google.common.annotations.VisibleForTesting
    public static <T> com.google.common.reflect.TypeToken<? extends T> toGenericType(java.lang.Class<T> cls) {
        if (cls.isArray()) {
            return (com.google.common.reflect.TypeToken<? extends T>) of(com.google.common.reflect.Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        java.lang.reflect.TypeVariable<java.lang.Class<T>>[] typeParameters = cls.getTypeParameters();
        java.lang.reflect.Type type = (!cls.isMemberClass() || java.lang.reflect.Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (com.google.common.reflect.TypeToken<? extends T>) of(com.google.common.reflect.Types.n(type, cls, typeParameters)) : of((java.lang.Class) cls);
    }

    public final com.google.common.reflect.Invokable<T, T> constructor(java.lang.reflect.Constructor<?> constructor) {
        com.google.common.base.Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new com.google.common.reflect.TypeToken.AnonymousClass2(constructor);
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.reflect.TypeToken) {
            return this.runtimeType.equals(((com.google.common.reflect.TypeToken) obj).runtimeType);
        }
        return false;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final com.google.common.reflect.TypeToken<?> getComponentType() {
        java.lang.reflect.Type j = com.google.common.reflect.Types.j(this.runtimeType);
        if (j == null) {
            return null;
        }
        return of(j);
    }

    public final com.google.common.collect.ImmutableList<com.google.common.reflect.TypeToken<? super T>> getGenericInterfaces() {
        java.lang.reflect.Type type = this.runtimeType;
        if (type instanceof java.lang.reflect.TypeVariable) {
            return boundsAsInterfaces(((java.lang.reflect.TypeVariable) type).getBounds());
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return boundsAsInterfaces(((java.lang.reflect.WildcardType) type).getUpperBounds());
        }
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (java.lang.reflect.Type type2 : getRawType().getGenericInterfaces()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) resolveSupertype(type2));
        }
        return builder.build();
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final com.google.common.reflect.TypeToken<? super T> getGenericSuperclass() {
        java.lang.reflect.Type type = this.runtimeType;
        if (type instanceof java.lang.reflect.TypeVariable) {
            return boundAsSuperclass(((java.lang.reflect.TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return boundAsSuperclass(((java.lang.reflect.WildcardType) type).getUpperBounds()[0]);
        }
        java.lang.reflect.Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (com.google.common.reflect.TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final java.lang.Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final com.google.common.reflect.TypeToken<? extends T> getSubtype(java.lang.Class<?> cls) {
        com.google.common.base.Preconditions.checkArgument(!(this.runtimeType instanceof java.lang.reflect.TypeVariable), "Cannot get subtype of type variable <%s>", this);
        java.lang.reflect.Type type = this.runtimeType;
        if (type instanceof java.lang.reflect.WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((java.lang.reflect.WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        com.google.common.base.Preconditions.checkArgument(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        com.google.common.reflect.TypeToken<? extends T> typeToken = (com.google.common.reflect.TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        com.google.common.base.Preconditions.checkArgument(typeToken.isSubtypeOf((com.google.common.reflect.TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final com.google.common.reflect.TypeToken<? super T> getSupertype(java.lang.Class<? super T> cls) {
        com.google.common.base.Preconditions.checkArgument(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        java.lang.reflect.Type type = this.runtimeType;
        return type instanceof java.lang.reflect.TypeVariable ? getSupertypeFromUpperBounds(cls, ((java.lang.reflect.TypeVariable) type).getBounds()) : type instanceof java.lang.reflect.WildcardType ? getSupertypeFromUpperBounds(cls, ((java.lang.reflect.WildcardType) type).getUpperBounds()) : cls.isArray() ? getArraySupertype(cls) : (com.google.common.reflect.TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final java.lang.reflect.Type getType() {
        return this.runtimeType;
    }

    public final com.google.common.reflect.TypeToken<T>.TypeSet getTypes() {
        return new com.google.common.reflect.TypeToken.TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        java.lang.reflect.Type type = this.runtimeType;
        return (type instanceof java.lang.Class) && ((java.lang.Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(com.google.common.reflect.TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSubtypeOf(java.lang.reflect.Type type) {
        com.google.common.base.Preconditions.checkNotNull(type);
        if (type instanceof java.lang.reflect.WildcardType) {
            return any(((java.lang.reflect.WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        java.lang.reflect.Type type2 = this.runtimeType;
        if (type2 instanceof java.lang.reflect.WildcardType) {
            return any(((java.lang.reflect.WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof java.lang.reflect.TypeVariable) {
            return type2.equals(type) || any(((java.lang.reflect.TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof java.lang.reflect.GenericArrayType) {
            return of(type).isSupertypeOfArray((java.lang.reflect.GenericArrayType) this.runtimeType);
        }
        if (type instanceof java.lang.Class) {
            return someRawTypeIsSubclassOf((java.lang.Class) type);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return isSubtypeOfParameterizedType((java.lang.reflect.ParameterizedType) type);
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return isSubtypeOfArrayType((java.lang.reflect.GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(com.google.common.reflect.TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(java.lang.reflect.Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final com.google.common.reflect.Invokable<T, java.lang.Object> method(java.lang.reflect.Method method) {
        com.google.common.base.Preconditions.checkArgument(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new com.google.common.reflect.TypeToken.AnonymousClass1(method);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.reflect.TypeToken<T> rejectTypeVariables() {
        new com.google.common.reflect.TypeToken.AnonymousClass3().a(this.runtimeType);
        return this;
    }

    public final com.google.common.reflect.TypeToken<?> resolveType(java.lang.reflect.Type type) {
        com.google.common.base.Preconditions.checkNotNull(type);
        return of(getInvariantTypeResolver().resolveType(type));
    }

    public java.lang.String toString() {
        return com.google.common.reflect.Types.t(this.runtimeType);
    }

    public final com.google.common.reflect.TypeToken<T> unwrap() {
        return isWrapper() ? of(com.google.common.primitives.Primitives.unwrap((java.lang.Class) this.runtimeType)) : this;
    }

    public final <X> com.google.common.reflect.TypeToken<T> where(com.google.common.reflect.TypeParameter<X> typeParameter, com.google.common.reflect.TypeToken<X> typeToken) {
        return new com.google.common.reflect.TypeToken.SimpleTypeToken(new com.google.common.reflect.TypeResolver().m(com.google.common.collect.ImmutableMap.of(new com.google.common.reflect.TypeResolver.TypeVariableKey(typeParameter.n), typeToken.runtimeType)).resolveType(this.runtimeType));
    }

    public final <X> com.google.common.reflect.TypeToken<T> where(com.google.common.reflect.TypeParameter<X> typeParameter, java.lang.Class<X> cls) {
        return where(typeParameter, of((java.lang.Class) cls));
    }

    public final com.google.common.reflect.TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.common.primitives.Primitives.wrap((java.lang.Class) this.runtimeType)) : this;
    }

    public java.lang.Object writeReplace() {
        return of(new com.google.common.reflect.TypeResolver().resolveType(this.runtimeType));
    }
}
