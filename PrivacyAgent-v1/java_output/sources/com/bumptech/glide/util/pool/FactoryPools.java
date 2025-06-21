package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final com.bumptech.glide.util.pool.FactoryPools.Resetter<java.lang.Object> EMPTY_RESETTER = new com.bumptech.glide.util.pool.FactoryPools.AnonymousClass1();
    private static final java.lang.String TAG = "FactoryPools";

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.util.pool.FactoryPools.Resetter<java.lang.Object> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@androidx.annotation.NonNull java.lang.Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$2, reason: invalid class name */
    public class AnonymousClass2<T> implements com.bumptech.glide.util.pool.FactoryPools.Factory<java.util.List<T>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        @androidx.annotation.NonNull
        public java.util.List<T> create() {
            return new java.util.ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$3, reason: invalid class name */
    public class AnonymousClass3<T> implements com.bumptech.glide.util.pool.FactoryPools.Resetter<java.util.List<T>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@androidx.annotation.NonNull java.util.List<T> list) {
            list.clear();
        }
    }

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements androidx.core.util.Pools.Pool<T> {
        private final com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory;
        private final androidx.core.util.Pools.Pool<T> pool;
        private final com.bumptech.glide.util.pool.FactoryPools.Resetter<T> resetter;

        public FactoryPool(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<T> pool, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Resetter<T> resetter) {
            this.pool = pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (android.util.Log.isLoggable(com.bumptech.glide.util.pool.FactoryPools.TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Created new ");
                    sb.append(acquire.getClass());
                }
            }
            if (acquire instanceof com.bumptech.glide.util.pool.FactoryPools.Poolable) {
                acquire.getVerifier().setRecycled(false);
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@androidx.annotation.NonNull T t) {
            if (t instanceof com.bumptech.glide.util.pool.FactoryPools.Poolable) {
                ((com.bumptech.glide.util.pool.FactoryPools.Poolable) t).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }

    public interface Poolable {
        @androidx.annotation.NonNull
        com.bumptech.glide.util.pool.StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@androidx.annotation.NonNull T t);
    }

    private FactoryPools() {
    }

    @androidx.annotation.NonNull
    private static <T extends com.bumptech.glide.util.pool.FactoryPools.Poolable> androidx.core.util.Pools.Pool<T> build(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<T> pool, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory) {
        return build(pool, factory, emptyResetter());
    }

    @androidx.annotation.NonNull
    private static <T> androidx.core.util.Pools.Pool<T> build(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<T> pool, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Resetter<T> resetter) {
        return new com.bumptech.glide.util.pool.FactoryPools.FactoryPool(pool, factory, resetter);
    }

    @androidx.annotation.NonNull
    private static <T> com.bumptech.glide.util.pool.FactoryPools.Resetter<T> emptyResetter() {
        return (com.bumptech.glide.util.pool.FactoryPools.Resetter<T>) EMPTY_RESETTER;
    }

    @androidx.annotation.NonNull
    public static <T extends com.bumptech.glide.util.pool.FactoryPools.Poolable> androidx.core.util.Pools.Pool<T> simple(int i, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory) {
        return build(new androidx.core.util.Pools.SimplePool(i), factory);
    }

    @androidx.annotation.NonNull
    public static <T extends com.bumptech.glide.util.pool.FactoryPools.Poolable> androidx.core.util.Pools.Pool<T> threadSafe(int i, @androidx.annotation.NonNull com.bumptech.glide.util.pool.FactoryPools.Factory<T> factory) {
        return build(new androidx.core.util.Pools.SynchronizedPool(i), factory);
    }

    @androidx.annotation.NonNull
    public static <T> androidx.core.util.Pools.Pool<java.util.List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @androidx.annotation.NonNull
    public static <T> androidx.core.util.Pools.Pool<java.util.List<T>> threadSafeList(int i) {
        return build(new androidx.core.util.Pools.SynchronizedPool(i), new com.bumptech.glide.util.pool.FactoryPools.AnonymousClass2(), new com.bumptech.glide.util.pool.FactoryPools.AnonymousClass3());
    }
}
