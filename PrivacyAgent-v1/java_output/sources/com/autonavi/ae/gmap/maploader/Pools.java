package com.autonavi.ae.gmap.maploader;

/* loaded from: classes12.dex */
public final class Pools {

    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t);
    }

    public static class SimplePool<T> implements com.autonavi.ae.gmap.maploader.Pools.Pool<T> {
        private final java.lang.Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new java.lang.Object[i];
        }

        private boolean isInPool(T t) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            java.lang.Object[] objArr = this.mPool;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.mPoolSize = i - 1;
            return t;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i = 0;
            while (true) {
                java.lang.Object[] objArr = this.mPool;
                if (i >= objArr.length) {
                    return;
                }
                objArr[i] = null;
                i++;
            }
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t) {
            if (isInPool(t)) {
                throw new java.lang.IllegalStateException("Already in the pool!");
            }
            int i = this.mPoolSize;
            java.lang.Object[] objArr = this.mPool;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.mPoolSize = i + 1;
            return true;
        }
    }

    public static class SynchronizedPool<T> extends com.autonavi.ae.gmap.maploader.Pools.SimplePool<T> {
        private final java.lang.Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new java.lang.Object();
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
