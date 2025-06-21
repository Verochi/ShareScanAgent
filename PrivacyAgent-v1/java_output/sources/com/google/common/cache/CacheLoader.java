package com.google.common.cache;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class CacheLoader<K, V> {

    /* renamed from: com.google.common.cache.CacheLoader$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.cache.CacheLoader<K, V> {
        public final /* synthetic */ java.util.concurrent.Executor t;

        /* renamed from: com.google.common.cache.CacheLoader$1$1, reason: invalid class name and collision with other inner class name */
        public class CallableC03371 implements java.util.concurrent.Callable<V> {
            public final /* synthetic */ java.lang.Object n;
            public final /* synthetic */ java.lang.Object t;

            public CallableC03371(java.lang.Object obj, java.lang.Object obj2) {
                this.n = obj;
                this.t = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws java.lang.Exception {
                return com.google.common.cache.CacheLoader.this.reload(this.n, this.t).get();
            }
        }

        public AnonymousClass1(java.util.concurrent.Executor executor) {
            this.t = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws java.lang.Exception {
            return (V) com.google.common.cache.CacheLoader.this.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public java.util.Map<K, V> loadAll(java.lang.Iterable<? extends K> iterable) throws java.lang.Exception {
            return com.google.common.cache.CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public com.google.common.util.concurrent.ListenableFuture<V> reload(K k, V v) throws java.lang.Exception {
            com.google.common.util.concurrent.ListenableFutureTask create = com.google.common.util.concurrent.ListenableFutureTask.create(new com.google.common.cache.CacheLoader.AnonymousClass1.CallableC03371(k, v));
            this.t.execute(create);
            return create;
        }
    }

    public static final class FunctionToCacheLoader<K, V> extends com.google.common.cache.CacheLoader<K, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Function<K, V> computingFunction;

        public FunctionToCacheLoader(com.google.common.base.Function<K, V> function) {
            this.computingFunction = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return (V) this.computingFunction.apply(com.google.common.base.Preconditions.checkNotNull(k));
        }
    }

    public static final class InvalidCacheLoadException extends java.lang.RuntimeException {
        public InvalidCacheLoadException(java.lang.String str) {
            super(str);
        }
    }

    public static final class SupplierToCacheLoader<V> extends com.google.common.cache.CacheLoader<java.lang.Object, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Supplier<V> computingSupplier;

        public SupplierToCacheLoader(com.google.common.base.Supplier<V> supplier) {
            this.computingSupplier = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(java.lang.Object obj) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends java.lang.UnsupportedOperationException {
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> com.google.common.cache.CacheLoader<K, V> asyncReloading(com.google.common.cache.CacheLoader<K, V> cacheLoader, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(cacheLoader);
        com.google.common.base.Preconditions.checkNotNull(executor);
        return cacheLoader.new AnonymousClass1(executor);
    }

    public static <K, V> com.google.common.cache.CacheLoader<K, V> from(com.google.common.base.Function<K, V> function) {
        return new com.google.common.cache.CacheLoader.FunctionToCacheLoader(function);
    }

    public static <V> com.google.common.cache.CacheLoader<java.lang.Object, V> from(com.google.common.base.Supplier<V> supplier) {
        return new com.google.common.cache.CacheLoader.SupplierToCacheLoader(supplier);
    }

    public abstract V load(K k) throws java.lang.Exception;

    public java.util.Map<K, V> loadAll(java.lang.Iterable<? extends K> iterable) throws java.lang.Exception {
        throw new com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException();
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.util.concurrent.ListenableFuture<V> reload(K k, V v) throws java.lang.Exception {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        return com.google.common.util.concurrent.Futures.immediateFuture(load(k));
    }
}
