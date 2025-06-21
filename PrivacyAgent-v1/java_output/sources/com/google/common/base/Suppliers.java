package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Suppliers {

    @com.google.common.annotations.VisibleForTesting
    public static class ExpiringMemoizingSupplier<T> implements com.google.common.base.Supplier<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        volatile transient T value;

        public ExpiringMemoizingSupplier(com.google.common.base.Supplier<T> supplier, long j, java.util.concurrent.TimeUnit timeUnit) {
            this.delegate = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(j);
            com.google.common.base.Preconditions.checkArgument(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long j = this.expirationNanos;
            long j2 = com.google.common.base.Platform.j();
            if (j == 0 || j2 - j >= 0) {
                synchronized (this) {
                    if (j == this.expirationNanos) {
                        T t = this.delegate.get();
                        this.value = t;
                        long j3 = j2 + this.durationNanos;
                        if (j3 == 0) {
                            j3 = 1;
                        }
                        this.expirationNanos = j3;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public java.lang.String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class MemoizingSupplier<T> implements com.google.common.base.Supplier<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Supplier<T> delegate;
        volatile transient boolean initialized;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        transient T value;

        public MemoizingSupplier(com.google.common.base.Supplier<T> supplier) {
            this.delegate = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public java.lang.String toString() {
            java.lang.Object obj;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class NonSerializableMemoizingSupplier<T> implements com.google.common.base.Supplier<T> {
        public volatile com.google.common.base.Supplier<T> n;
        public volatile boolean t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public T u;

        public NonSerializableMemoizingSupplier(com.google.common.base.Supplier<T> supplier) {
            this.n = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.t) {
                synchronized (this) {
                    if (!this.t) {
                        T t = this.n.get();
                        this.u = t;
                        this.t = true;
                        this.n = null;
                        return t;
                    }
                }
            }
            return this.u;
        }

        public java.lang.String toString() {
            java.lang.Object obj = this.n;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.u + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class SupplierComposition<F, T> implements com.google.common.base.Supplier<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Function<? super F, T> function;
        final com.google.common.base.Supplier<F> supplier;

        public SupplierComposition(com.google.common.base.Function<? super F, T> function, com.google.common.base.Supplier<F> supplier) {
            this.function = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
            this.supplier = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Suppliers.SupplierComposition)) {
                return false;
            }
            com.google.common.base.Suppliers.SupplierComposition supplierComposition = (com.google.common.base.Suppliers.SupplierComposition) obj;
            return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.function, this.supplier);
        }

        public java.lang.String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    public interface SupplierFunction<T> extends com.google.common.base.Function<com.google.common.base.Supplier<T>, T> {
    }

    public enum SupplierFunctionImpl implements com.google.common.base.Suppliers.SupplierFunction<java.lang.Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        public java.lang.Object apply(com.google.common.base.Supplier<java.lang.Object> supplier) {
            return supplier.get();
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    public static class SupplierOfInstance<T> implements com.google.common.base.Supplier<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final T instance;

        public SupplierOfInstance(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            this.instance = t;
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Suppliers.SupplierOfInstance) {
                return com.google.common.base.Objects.equal(this.instance, ((com.google.common.base.Suppliers.SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.instance);
        }

        public java.lang.String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static class ThreadSafeSupplier<T> implements com.google.common.base.Supplier<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Supplier<T> delegate;

        public ThreadSafeSupplier(com.google.common.base.Supplier<T> supplier) {
            this.delegate = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            T t;
            synchronized (this.delegate) {
                t = this.delegate.get();
            }
            return t;
        }

        public java.lang.String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    public static <F, T> com.google.common.base.Supplier<T> compose(com.google.common.base.Function<? super F, T> function, com.google.common.base.Supplier<F> supplier) {
        return new com.google.common.base.Suppliers.SupplierComposition(function, supplier);
    }

    public static <T> com.google.common.base.Supplier<T> memoize(com.google.common.base.Supplier<T> supplier) {
        return ((supplier instanceof com.google.common.base.Suppliers.NonSerializableMemoizingSupplier) || (supplier instanceof com.google.common.base.Suppliers.MemoizingSupplier)) ? supplier : supplier instanceof java.io.Serializable ? new com.google.common.base.Suppliers.MemoizingSupplier(supplier) : new com.google.common.base.Suppliers.NonSerializableMemoizingSupplier(supplier);
    }

    public static <T> com.google.common.base.Supplier<T> memoizeWithExpiration(com.google.common.base.Supplier<T> supplier, long j, java.util.concurrent.TimeUnit timeUnit) {
        return new com.google.common.base.Suppliers.ExpiringMemoizingSupplier(supplier, j, timeUnit);
    }

    public static <T> com.google.common.base.Supplier<T> ofInstance(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return new com.google.common.base.Suppliers.SupplierOfInstance(t);
    }

    public static <T> com.google.common.base.Function<com.google.common.base.Supplier<T>, T> supplierFunction() {
        return com.google.common.base.Suppliers.SupplierFunctionImpl.INSTANCE;
    }

    public static <T> com.google.common.base.Supplier<T> synchronizedSupplier(com.google.common.base.Supplier<T> supplier) {
        return new com.google.common.base.Suppliers.ThreadSafeSupplier(supplier);
    }
}
