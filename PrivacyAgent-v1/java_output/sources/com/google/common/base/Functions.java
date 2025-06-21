package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Functions {

    public static class ConstantFunction<E> implements com.google.common.base.Function<java.lang.Object, E>, java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final E value;

        public ConstantFunction(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
            this.value = e;
        }

        @Override // com.google.common.base.Function
        public E apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Functions.ConstantFunction) {
                return com.google.common.base.Objects.equal(this.value, ((com.google.common.base.Functions.ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e = this.value;
            if (e == null) {
                return 0;
            }
            return e.hashCode();
        }

        public java.lang.String toString() {
            return "Functions.constant(" + this.value + ")";
        }
    }

    public static class ForMapWithDefault<K, V> implements com.google.common.base.Function<K, V>, java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final V defaultValue;
        final java.util.Map<K, ? extends V> map;

        public ForMapWithDefault(java.util.Map<K, ? extends V> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            this.map = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
            this.defaultValue = v;
        }

        @Override // com.google.common.base.Function
        public V apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
            V v = this.map.get(k);
            return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Functions.ForMapWithDefault)) {
                return false;
            }
            com.google.common.base.Functions.ForMapWithDefault forMapWithDefault = (com.google.common.base.Functions.ForMapWithDefault) obj;
            return this.map.equals(forMapWithDefault.map) && com.google.common.base.Objects.equal(this.defaultValue, forMapWithDefault.defaultValue);
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.map, this.defaultValue);
        }

        public java.lang.String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }
    }

    public static class FunctionComposition<A, B, C> implements com.google.common.base.Function<A, C>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Function<A, ? extends B> f;
        private final com.google.common.base.Function<B, C> g;

        public FunctionComposition(com.google.common.base.Function<B, C> function, com.google.common.base.Function<A, ? extends B> function2) {
            this.g = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
            this.f = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Function
        public C apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
            return (C) this.g.apply(this.f.apply(a));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Functions.FunctionComposition)) {
                return false;
            }
            com.google.common.base.Functions.FunctionComposition functionComposition = (com.google.common.base.Functions.FunctionComposition) obj;
            return this.f.equals(functionComposition.f) && this.g.equals(functionComposition.g);
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.g.hashCode();
        }

        public java.lang.String toString() {
            return this.g + "(" + this.f + ")";
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements com.google.common.base.Function<K, V>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.Map<K, V> map;

        public FunctionForMapNoDefault(java.util.Map<K, V> map) {
            this.map = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.base.Function
        public V apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
            V v = this.map.get(k);
            com.google.common.base.Preconditions.checkArgument(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
            return v;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Functions.FunctionForMapNoDefault) {
                return this.map.equals(((com.google.common.base.Functions.FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public java.lang.String toString() {
            return "Functions.forMap(" + this.map + ")";
        }
    }

    public enum IdentityFunction implements com.google.common.base.Function<java.lang.Object, java.lang.Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.lang.Object apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return obj;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Functions.identity()";
        }
    }

    public static class PredicateFunction<T> implements com.google.common.base.Function<T, java.lang.Boolean>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Predicate<T> predicate;

        private PredicateFunction(com.google.common.base.Predicate<T> predicate) {
            this.predicate = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
        }

        public /* synthetic */ PredicateFunction(com.google.common.base.Predicate predicate, com.google.common.base.Functions.AnonymousClass1 anonymousClass1) {
            this(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Function
        public java.lang.Boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            return java.lang.Boolean.valueOf(this.predicate.apply(t));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ java.lang.Boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return apply((com.google.common.base.Functions.PredicateFunction<T>) obj);
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Functions.PredicateFunction) {
                return this.predicate.equals(((com.google.common.base.Functions.PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public java.lang.String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }
    }

    public static class SupplierFunction<T> implements com.google.common.base.Function<java.lang.Object, T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Supplier<T> supplier;

        private SupplierFunction(com.google.common.base.Supplier<T> supplier) {
            this.supplier = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        public /* synthetic */ SupplierFunction(com.google.common.base.Supplier supplier, com.google.common.base.Functions.AnonymousClass1 anonymousClass1) {
            this(supplier);
        }

        @Override // com.google.common.base.Function
        public T apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Functions.SupplierFunction) {
                return this.supplier.equals(((com.google.common.base.Functions.SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public java.lang.String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }
    }

    public enum ToStringFunction implements com.google.common.base.Function<java.lang.Object, java.lang.String> {
        INSTANCE;

        @Override // com.google.common.base.Function
        public java.lang.String apply(java.lang.Object obj) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Functions.toStringFunction()";
        }
    }

    public static <A, B, C> com.google.common.base.Function<A, C> compose(com.google.common.base.Function<B, C> function, com.google.common.base.Function<A, ? extends B> function2) {
        return new com.google.common.base.Functions.FunctionComposition(function, function2);
    }

    public static <E> com.google.common.base.Function<java.lang.Object, E> constant(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
        return new com.google.common.base.Functions.ConstantFunction(e);
    }

    public static <K, V> com.google.common.base.Function<K, V> forMap(java.util.Map<K, V> map) {
        return new com.google.common.base.Functions.FunctionForMapNoDefault(map);
    }

    public static <K, V> com.google.common.base.Function<K, V> forMap(java.util.Map<K, ? extends V> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.base.Functions.ForMapWithDefault(map, v);
    }

    public static <T> com.google.common.base.Function<T, java.lang.Boolean> forPredicate(com.google.common.base.Predicate<T> predicate) {
        return new com.google.common.base.Functions.PredicateFunction(predicate, null);
    }

    public static <T> com.google.common.base.Function<java.lang.Object, T> forSupplier(com.google.common.base.Supplier<T> supplier) {
        return new com.google.common.base.Functions.SupplierFunction(supplier, null);
    }

    public static <E> com.google.common.base.Function<E, E> identity() {
        return com.google.common.base.Functions.IdentityFunction.INSTANCE;
    }

    public static com.google.common.base.Function<java.lang.Object, java.lang.String> toStringFunction() {
        return com.google.common.base.Functions.ToStringFunction.INSTANCE;
    }
}
