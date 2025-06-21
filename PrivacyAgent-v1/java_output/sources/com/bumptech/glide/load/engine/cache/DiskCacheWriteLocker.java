package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final java.util.Map<java.lang.String, com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> locks = new java.util.HashMap();
    private final com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool writeLockPool = new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool();

    public static class WriteLock {
        int interestedThreads;
        final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    }

    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final java.util.Queue<com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> pool = new java.util.ArrayDeque();

        public com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock obtain() {
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock() : poll;
        }

        public void offer(com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }

    public void acquire(java.lang.String str) {
        com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock;
        synchronized (this) {
            writeLock = this.locks.get(str);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(str, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    public void release(java.lang.String str) {
        com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock;
        synchronized (this) {
            writeLock = (com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock) com.bumptech.glide.util.Preconditions.checkNotNull(this.locks.get(str));
            int i = writeLock.interestedThreads;
            if (i < 1) {
                throw new java.lang.IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
            int i2 = i - 1;
            writeLock.interestedThreads = i2;
            if (i2 == 0) {
                com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock remove = this.locks.remove(str);
                if (!remove.equals(writeLock)) {
                    throw new java.lang.IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.writeLockPool.offer(remove);
            }
        }
        writeLock.lock.unlock();
    }
}
