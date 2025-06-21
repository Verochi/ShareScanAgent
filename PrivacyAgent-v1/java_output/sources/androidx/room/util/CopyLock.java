package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CopyLock {
    private static final java.util.Map<java.lang.String, java.util.concurrent.locks.Lock> sThreadLocks = new java.util.HashMap();
    private final java.io.File mCopyLockFile;
    private final boolean mFileLevelLock;
    private java.nio.channels.FileChannel mLockChannel;
    private final java.util.concurrent.locks.Lock mThreadLock;

    public CopyLock(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.File file, boolean z) {
        java.io.File file2 = new java.io.File(file, str + ".lck");
        this.mCopyLockFile = file2;
        this.mThreadLock = getThreadLock(file2.getAbsolutePath());
        this.mFileLevelLock = z;
    }

    private static java.util.concurrent.locks.Lock getThreadLock(java.lang.String str) {
        java.util.concurrent.locks.Lock lock;
        java.util.Map<java.lang.String, java.util.concurrent.locks.Lock> map = sThreadLocks;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new java.util.concurrent.locks.ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void lock() {
        this.mThreadLock.lock();
        if (this.mFileLevelLock) {
            try {
                java.nio.channels.FileChannel channel = new java.io.FileOutputStream(this.mCopyLockFile).getChannel();
                this.mLockChannel = channel;
                channel.lock();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException("Unable to grab copy lock.", e);
            }
        }
    }

    public void unlock() {
        java.nio.channels.FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (java.io.IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }
}
