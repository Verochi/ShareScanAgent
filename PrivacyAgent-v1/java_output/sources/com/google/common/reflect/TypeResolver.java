package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class TypeResolver {
    public final com.google.common.reflect.TypeResolver.TypeTable a;

    /* renamed from: com.google.common.reflect.TypeResolver$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.reflect.TypeVisitor {
        public final /* synthetic */ java.util.Map b;
        public final /* synthetic */ java.lang.reflect.Type c;

        public AnonymousClass1(java.util.Map map, java.lang.reflect.Type type) {
            this.b = map;
            this.c = type;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(java.lang.Class<?> cls) {
            if (this.c instanceof java.lang.reflect.WildcardType) {
                return;
            }
            throw new java.lang.IllegalArgumentException("No type mapping from " + cls + " to " + this.c);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(java.lang.reflect.GenericArrayType genericArrayType) {
            java.lang.reflect.Type type = this.c;
            if (type instanceof java.lang.reflect.WildcardType) {
                return;
            }
            java.lang.reflect.Type j = com.google.common.reflect.Types.j(type);
            com.google.common.base.Preconditions.checkArgument(j != null, "%s is not an array type.", this.c);
            com.google.common.reflect.TypeResolver.g(this.b, genericArrayType.getGenericComponentType(), j);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(java.lang.reflect.ParameterizedType parameterizedType) {
            java.lang.reflect.Type type = this.c;
            if (type instanceof java.lang.reflect.WildcardType) {
                return;
            }
            java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) com.google.common.reflect.TypeResolver.e(java.lang.reflect.ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                com.google.common.reflect.TypeResolver.g(this.b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            com.google.common.base.Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.c);
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            java.lang.reflect.Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            com.google.common.base.Preconditions.checkArgument(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                com.google.common.reflect.TypeResolver.g(this.b, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
            this.b.put(new com.google.common.reflect.TypeResolver.TypeVariableKey(typeVariable), this.c);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(java.lang.reflect.WildcardType wildcardType) {
            java.lang.reflect.Type type = this.c;
            if (type instanceof java.lang.reflect.WildcardType) {
                java.lang.reflect.WildcardType wildcardType2 = (java.lang.reflect.WildcardType) type;
                java.lang.reflect.Type[] upperBounds = wildcardType.getUpperBounds();
                java.lang.reflect.Type[] upperBounds2 = wildcardType2.getUpperBounds();
                java.lang.reflect.Type[] lowerBounds = wildcardType.getLowerBounds();
                java.lang.reflect.Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                com.google.common.base.Preconditions.checkArgument(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.c);
                for (int i = 0; i < upperBounds.length; i++) {
                    com.google.common.reflect.TypeResolver.g(this.b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    com.google.common.reflect.TypeResolver.g(this.b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    public static final class TypeMappingIntrospector extends com.google.common.reflect.TypeVisitor {
        public final java.util.Map<com.google.common.reflect.TypeResolver.TypeVariableKey, java.lang.reflect.Type> b = com.google.common.collect.Maps.newHashMap();

        public static com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeResolver.TypeVariableKey, java.lang.reflect.Type> g(java.lang.reflect.Type type) {
            com.google.common.base.Preconditions.checkNotNull(type);
            com.google.common.reflect.TypeResolver.TypeMappingIntrospector typeMappingIntrospector = new com.google.common.reflect.TypeResolver.TypeMappingIntrospector();
            typeMappingIntrospector.a(type);
            return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) typeMappingIntrospector.b);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(java.lang.Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(java.lang.reflect.ParameterizedType parameterizedType) {
            java.lang.Class cls = (java.lang.Class) parameterizedType.getRawType();
            java.lang.reflect.TypeVariable[] typeParameters = cls.getTypeParameters();
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            com.google.common.base.Preconditions.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new com.google.common.reflect.TypeResolver.TypeVariableKey(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(java.lang.reflect.WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(com.google.common.reflect.TypeResolver.TypeVariableKey typeVariableKey, java.lang.reflect.Type type) {
            if (this.b.containsKey(typeVariableKey)) {
                return;
            }
            java.lang.reflect.Type type2 = type;
            while (type2 != null) {
                if (typeVariableKey.a(type2)) {
                    while (type != null) {
                        type = this.b.remove(com.google.common.reflect.TypeResolver.TypeVariableKey.c(type));
                    }
                    return;
                }
                type2 = this.b.get(com.google.common.reflect.TypeResolver.TypeVariableKey.c(type2));
            }
            this.b.put(typeVariableKey, type);
        }
    }

    public static class TypeTable {
        public final com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeResolver.TypeVariableKey, java.lang.reflect.Type> a;

        /* renamed from: com.google.common.reflect.TypeResolver$TypeTable$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.reflect.TypeResolver.TypeTable {
            public final /* synthetic */ java.lang.reflect.TypeVariable b;
            public final /* synthetic */ com.google.common.reflect.TypeResolver.TypeTable c;

            public AnonymousClass1(java.lang.reflect.TypeVariable typeVariable, com.google.common.reflect.TypeResolver.TypeTable typeTable) {
                this.b = typeVariable;
                this.c = typeTable;
            }

            @Override // com.google.common.reflect.TypeResolver.TypeTable
            public java.lang.reflect.Type b(java.lang.reflect.TypeVariable<?> typeVariable, com.google.common.reflect.TypeResolver.TypeTable typeTable) {
                return typeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration()) ? typeVariable : this.c.b(typeVariable, typeTable);
            }
        }

        public TypeTable() {
            this.a = com.google.common.collect.ImmutableMap.of();
        }

        public TypeTable(com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeResolver.TypeVariableKey, java.lang.reflect.Type> immutableMap) {
            this.a = immutableMap;
        }

        public final java.lang.reflect.Type a(java.lang.reflect.TypeVariable<?> typeVariable) {
            return b(typeVariable, new com.google.common.reflect.TypeResolver.TypeTable.AnonymousClass1(typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public java.lang.reflect.Type b(java.lang.reflect.TypeVariable<?> typeVariable, com.google.common.reflect.TypeResolver.TypeTable typeTable) {
            java.lang.reflect.Type type = this.a.get(new com.google.common.reflect.TypeResolver.TypeVariableKey(typeVariable));
            if (type != null) {
                return new com.google.common.reflect.TypeResolver(typeTable, null).resolveType(type);
            }
            java.lang.reflect.Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            java.lang.reflect.Type[] j = new com.google.common.reflect.TypeResolver(typeTable, null).j(bounds);
            return (com.google.common.reflect.Types.NativeTypeVariableEquals.a && java.util.Arrays.equals(bounds, j)) ? typeVariable : com.google.common.reflect.Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), j);
        }

        public final com.google.common.reflect.TypeResolver.TypeTable c(java.util.Map<com.google.common.reflect.TypeResolver.TypeVariableKey, ? extends java.lang.reflect.Type> map) {
            com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
            builder.putAll(this.a);
            for (java.util.Map.Entry<com.google.common.reflect.TypeResolver.TypeVariableKey, ? extends java.lang.reflect.Type> entry : map.entrySet()) {
                com.google.common.reflect.TypeResolver.TypeVariableKey key = entry.getKey();
                java.lang.reflect.Type value = entry.getValue();
                com.google.common.base.Preconditions.checkArgument(!key.a(value), "Type variable %s bound to itself", key);
                builder.put(key, value);
            }
            return new com.google.common.reflect.TypeResolver.TypeTable(builder.build());
        }
    }

    public static final class TypeVariableKey {
        public final java.lang.reflect.TypeVariable<?> a;

        public TypeVariableKey(java.lang.reflect.TypeVariable<?> typeVariable) {
            this.a = (java.lang.reflect.TypeVariable) com.google.common.base.Preconditions.checkNotNull(typeVariable);
        }

        public static com.google.common.reflect.TypeResolver.TypeVariableKey c(java.lang.reflect.Type type) {
            if (type instanceof java.lang.reflect.TypeVariable) {
                return new com.google.common.reflect.TypeResolver.TypeVariableKey((java.lang.reflect.TypeVariable) type);
            }
            return null;
        }

        public boolean a(java.lang.reflect.Type type) {
            if (type instanceof java.lang.reflect.TypeVariable) {
                return b((java.lang.reflect.TypeVariable) type);
            }
            return false;
        }

        public final boolean b(java.lang.reflect.TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.google.common.reflect.TypeResolver.TypeVariableKey) {
                return b(((com.google.common.reflect.TypeResolver.TypeVariableKey) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.a.getGenericDeclaration(), this.a.getName());
        }

        public java.lang.String toString() {
            return this.a.toString();
        }
    }

    public static class WildcardCapturer {
        public static final com.google.common.reflect.TypeResolver.WildcardCapturer b = new com.google.common.reflect.TypeResolver.WildcardCapturer();
        public final java.util.concurrent.atomic.AtomicInteger a;

        /* renamed from: com.google.common.reflect.TypeResolver$WildcardCapturer$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.reflect.TypeResolver.WildcardCapturer {
            public final /* synthetic */ java.lang.reflect.TypeVariable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.util.concurrent.atomic.AtomicInteger atomicInteger, java.lang.reflect.TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.c = typeVariable;
            }

            @Override // com.google.common.reflect.TypeResolver.WildcardCapturer
            public java.lang.reflect.TypeVariable<?> b(java.lang.reflect.Type[] typeArr) {
                java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(java.util.Arrays.asList(typeArr));
                linkedHashSet.addAll(java.util.Arrays.asList(this.c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(java.lang.Object.class);
                }
                return super.b((java.lang.reflect.Type[]) linkedHashSet.toArray(new java.lang.reflect.Type[0]));
            }
        }

        public WildcardCapturer() {
            this(new java.util.concurrent.atomic.AtomicInteger());
        }

        public WildcardCapturer(java.util.concurrent.atomic.AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        public /* synthetic */ WildcardCapturer(java.util.concurrent.atomic.AtomicInteger atomicInteger, com.google.common.reflect.TypeResolver.AnonymousClass1 anonymousClass1) {
            this(atomicInteger);
        }

        public final java.lang.reflect.Type a(java.lang.reflect.Type type) {
            com.google.common.base.Preconditions.checkNotNull(type);
            if ((type instanceof java.lang.Class) || (type instanceof java.lang.reflect.TypeVariable)) {
                return type;
            }
            if (type instanceof java.lang.reflect.GenericArrayType) {
                return com.google.common.reflect.Types.k(e().a(((java.lang.reflect.GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                if (!(type instanceof java.lang.reflect.WildcardType)) {
                    throw new java.lang.AssertionError("must have been one of the known types");
                }
                java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.Class cls = (java.lang.Class) parameterizedType.getRawType();
            java.lang.reflect.TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
            }
            return com.google.common.reflect.Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public java.lang.reflect.TypeVariable<?> b(java.lang.reflect.Type[] typeArr) {
            return com.google.common.reflect.Types.l(com.google.common.reflect.TypeResolver.WildcardCapturer.class, "capture#" + this.a.incrementAndGet() + "-of ? extends " + com.google.common.base.Joiner.on(kotlin.text.Typography.amp).join(typeArr), typeArr);
        }

        public final java.lang.reflect.Type c(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.reflect.Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final com.google.common.reflect.TypeResolver.WildcardCapturer d(java.lang.reflect.TypeVariable<?> typeVariable) {
            return new com.google.common.reflect.TypeResolver.WildcardCapturer.AnonymousClass1(this.a, typeVariable);
        }

        public final com.google.common.reflect.TypeResolver.WildcardCapturer e() {
            return new com.google.common.reflect.TypeResolver.WildcardCapturer(this.a);
        }
    }

    public TypeResolver() {
        this.a = new com.google.common.reflect.TypeResolver.TypeTable();
    }

    public TypeResolver(com.google.common.reflect.TypeResolver.TypeTable typeTable) {
        this.a = typeTable;
    }

    public /* synthetic */ TypeResolver(com.google.common.reflect.TypeResolver.TypeTable typeTable, com.google.common.reflect.TypeResolver.AnonymousClass1 anonymousClass1) {
        this(typeTable);
    }

    public static com.google.common.reflect.TypeResolver d(java.lang.reflect.Type type) {
        return new com.google.common.reflect.TypeResolver().m(com.google.common.reflect.TypeResolver.TypeMappingIntrospector.g(type));
    }

    public static <T> T e(java.lang.Class<T> cls, java.lang.Object obj) {
        try {
            return cls.cast(obj);
        } catch (java.lang.ClassCastException unused) {
            throw new java.lang.IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    public static com.google.common.reflect.TypeResolver f(java.lang.reflect.Type type) {
        return new com.google.common.reflect.TypeResolver().m(com.google.common.reflect.TypeResolver.TypeMappingIntrospector.g(com.google.common.reflect.TypeResolver.WildcardCapturer.b.a(type)));
    }

    public static void g(java.util.Map<com.google.common.reflect.TypeResolver.TypeVariableKey, java.lang.reflect.Type> map, java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new com.google.common.reflect.TypeResolver.AnonymousClass1(map, type2).a(type);
    }

    public final java.lang.reflect.Type h(java.lang.reflect.GenericArrayType genericArrayType) {
        return com.google.common.reflect.Types.k(resolveType(genericArrayType.getGenericComponentType()));
    }

    public final java.lang.reflect.ParameterizedType i(java.lang.reflect.ParameterizedType parameterizedType) {
        java.lang.reflect.Type ownerType = parameterizedType.getOwnerType();
        return com.google.common.reflect.Types.n(ownerType == null ? null : resolveType(ownerType), (java.lang.Class) resolveType(parameterizedType.getRawType()), j(parameterizedType.getActualTypeArguments()));
    }

    public final java.lang.reflect.Type[] j(java.lang.reflect.Type[] typeArr) {
        java.lang.reflect.Type[] typeArr2 = new java.lang.reflect.Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = resolveType(typeArr[i]);
        }
        return typeArr2;
    }

    public java.lang.reflect.Type[] k(java.lang.reflect.Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]);
        }
        return typeArr;
    }

    public final java.lang.reflect.WildcardType l(java.lang.reflect.WildcardType wildcardType) {
        return new com.google.common.reflect.Types.WildcardTypeImpl(j(wildcardType.getLowerBounds()), j(wildcardType.getUpperBounds()));
    }

    public com.google.common.reflect.TypeResolver m(java.util.Map<com.google.common.reflect.TypeResolver.TypeVariableKey, ? extends java.lang.reflect.Type> map) {
        return new com.google.common.reflect.TypeResolver(this.a.c(map));
    }

    public java.lang.reflect.Type resolveType(java.lang.reflect.Type type) {
        com.google.common.base.Preconditions.checkNotNull(type);
        return type instanceof java.lang.reflect.TypeVariable ? this.a.a((java.lang.reflect.TypeVariable) type) : type instanceof java.lang.reflect.ParameterizedType ? i((java.lang.reflect.ParameterizedType) type) : type instanceof java.lang.reflect.GenericArrayType ? h((java.lang.reflect.GenericArrayType) type) : type instanceof java.lang.reflect.WildcardType ? l((java.lang.reflect.WildcardType) type) : type;
    }

    public com.google.common.reflect.TypeResolver where(java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        java.util.HashMap newHashMap = com.google.common.collect.Maps.newHashMap();
        g(newHashMap, (java.lang.reflect.Type) com.google.common.base.Preconditions.checkNotNull(type), (java.lang.reflect.Type) com.google.common.base.Preconditions.checkNotNull(type2));
        return m(newHashMap);
    }
}
