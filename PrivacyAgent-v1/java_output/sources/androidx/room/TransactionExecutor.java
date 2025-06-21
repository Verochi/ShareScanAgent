package androidx.room;

/* loaded from: classes.dex */
class TransactionExecutor implements java.util.concurrent.Executor {
    private java.lang.Runnable mActive;
    private final java.util.concurrent.Executor mExecutor;
    private final java.util.ArrayDeque<java.lang.Runnable> mTasks = new java.util.ArrayDeque<>();

    /* renamed from: androidx.room.TransactionExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable val$command;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.val$command = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$command.run();
            } finally {
                androidx.room.TransactionExecutor.this.scheduleNext();
            }
        }
    }

    public TransactionExecutor(@androidx.annotation.NonNull java.util.concurrent.Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(java.lang.Runnable runnable) {
        this.mTasks.offer(new androidx.room.TransactionExecutor.AnonymousClass1(runnable));
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        java.lang.Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
