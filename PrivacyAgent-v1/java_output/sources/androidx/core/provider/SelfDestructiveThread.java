package androidx.core.provider;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@java.lang.Deprecated
/* loaded from: classes.dex */
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private final int mDestructAfterMillisec;

    @androidx.annotation.GuardedBy("mLock")
    private android.os.Handler mHandler;
    private final int mPriority;

    @androidx.annotation.GuardedBy("mLock")
    private android.os.HandlerThread mThread;
    private final java.lang.String mThreadName;
    private final java.lang.Object mLock = new java.lang.Object();
    private android.os.Handler.Callback mCallback = new androidx.core.provider.SelfDestructiveThread.AnonymousClass1();

    @androidx.annotation.GuardedBy("mLock")
    private int mGeneration = 0;

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                androidx.core.provider.SelfDestructiveThread.this.onDestruction();
                return true;
            }
            if (i != 1) {
                return true;
            }
            androidx.core.provider.SelfDestructiveThread.this.onInvokeRunnable((java.lang.Runnable) message.obj);
            return true;
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.Callable val$callable;
        final /* synthetic */ android.os.Handler val$calleeHandler;
        final /* synthetic */ androidx.core.provider.SelfDestructiveThread.ReplyCallback val$reply;

        /* renamed from: androidx.core.provider.SelfDestructiveThread$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Object val$result;

            public AnonymousClass1(java.lang.Object obj) {
                this.val$result = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.core.provider.SelfDestructiveThread.AnonymousClass2.this.val$reply.onReply(this.val$result);
            }
        }

        public AnonymousClass2(java.util.concurrent.Callable callable, android.os.Handler handler, androidx.core.provider.SelfDestructiveThread.ReplyCallback replyCallback) {
            this.val$callable = callable;
            this.val$calleeHandler = handler;
            this.val$reply = replyCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj;
            try {
                obj = this.val$callable.call();
            } catch (java.lang.Exception unused) {
                obj = null;
            }
            this.val$calleeHandler.post(new androidx.core.provider.SelfDestructiveThread.AnonymousClass2.AnonymousClass1(obj));
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.Callable val$callable;
        final /* synthetic */ java.util.concurrent.locks.Condition val$cond;
        final /* synthetic */ java.util.concurrent.atomic.AtomicReference val$holder;
        final /* synthetic */ java.util.concurrent.locks.ReentrantLock val$lock;
        final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean val$running;

        public AnonymousClass3(java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.Callable callable, java.util.concurrent.locks.ReentrantLock reentrantLock, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.util.concurrent.locks.Condition condition) {
            this.val$holder = atomicReference;
            this.val$callable = callable;
            this.val$lock = reentrantLock;
            this.val$running = atomicBoolean;
            this.val$cond = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$holder.set(this.val$callable.call());
            } catch (java.lang.Exception unused) {
            }
            this.val$lock.lock();
            try {
                this.val$running.set(false);
                this.val$cond.signal();
            } finally {
                this.val$lock.unlock();
            }
        }
    }

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(java.lang.String str, int i, int i2) {
        this.mThreadName = str;
        this.mPriority = i;
        this.mDestructAfterMillisec = i2;
    }

    private void post(java.lang.Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread(this.mThreadName, this.mPriority);
                this.mThread = handlerThread;
                handlerThread.start();
                this.mHandler = new android.os.Handler(this.mThread.getLooper(), this.mCallback);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            android.os.Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    @androidx.annotation.VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.mLock) {
            i = this.mGeneration;
        }
        return i;
    }

    @androidx.annotation.VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mThread != null;
        }
        return z;
    }

    public void onDestruction() {
        synchronized (this.mLock) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
        }
    }

    public void onInvokeRunnable(java.lang.Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            android.os.Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(java.util.concurrent.Callable<T> callable, androidx.core.provider.SelfDestructiveThread.ReplyCallback<T> replyCallback) {
        post(new androidx.core.provider.SelfDestructiveThread.AnonymousClass2(callable, androidx.core.provider.CalleeHandler.create(), replyCallback));
    }

    public <T> T postAndWait(java.util.concurrent.Callable<T> callable, int i) throws java.lang.InterruptedException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        java.util.concurrent.locks.Condition newCondition = reentrantLock.newCondition();
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
        post(new androidx.core.provider.SelfDestructiveThread.AnonymousClass3(atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (java.lang.InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new java.lang.InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
