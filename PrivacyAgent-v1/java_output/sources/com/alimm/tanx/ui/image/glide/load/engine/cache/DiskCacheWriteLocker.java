package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> locks = new java.util.HashMap();
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool writeLockPool = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool(null);

    public static class WriteLock {
        int interestedThreads;
        final java.util.concurrent.locks.Lock lock;

        private WriteLock() {
            this.lock = new java.util.concurrent.locks.ReentrantLock();
        }

        public /* synthetic */ WriteLock(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final java.util.Queue<com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> pool;

        private WriteLockPool() {
            this.pool = new java.util.ArrayDeque();
        }

        public /* synthetic */ WriteLockPool(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.AnonymousClass1 anonymousClass1) {
            this();
        }

        public com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock obtain() {
            com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock(null) : poll;
        }

        public void offer(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }

    public void acquire(com.alimm.tanx.ui.image.glide.load.Key key) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock;
        synchronized (this) {
            writeLock = this.locks.get(key);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(key, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    public void release(com.alimm.tanx.ui.image.glide.load.Key key) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock;
        int i;
        synchronized (this) {
            writeLock = this.locks.get(key);
            if (writeLock != null && (i = writeLock.interestedThreads) > 0) {
                int i2 = i - 1;
                writeLock.interestedThreads = i2;
                if (i2 == 0) {
                    com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock remove = this.locks.remove(key);
                    if (!remove.equals(writeLock)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(writeLock);
                        sb.append(", but actually removed: ");
                        sb.append(remove);
                        sb.append(", key: ");
                        sb.append(key);
                        throw new java.lang.IllegalStateException(sb.toString());
                    }
                    this.writeLockPool.offer(remove);
                }
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Cannot release a lock that is not held, key: ");
            sb2.append(key);
            sb2.append(", interestedThreads: ");
            sb2.append(writeLock == null ? 0 : writeLock.interestedThreads);
            throw new java.lang.IllegalArgumentException(sb2.toString());
        }
        writeLock.lock.unlock();
    }
}
