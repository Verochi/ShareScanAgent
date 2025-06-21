package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "()V", "finished", "", "isDraining", "paused", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "canRun", "dispatchAndEnqueue", "", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "drainQueue", "enqueue", "finish", com.anythink.expressad.foundation.d.c.cb, com.anythink.expressad.foundation.d.c.cc, "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;

    @org.jetbrains.annotations.NotNull
    private final java.util.Queue<java.lang.Runnable> queue = new java.util.ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.MainThread
    public final void enqueue(java.lang.Runnable runnable) {
        if (!this.queue.offer(runnable)) {
            throw new java.lang.IllegalStateException("cannot enqueue any more runnables".toString());
        }
        drainQueue();
    }

    @androidx.annotation.MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @androidx.annotation.AnyThread
    @android.annotation.SuppressLint({"WrongThread"})
    public final void dispatchAndEnqueue(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable runnable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(runnable, "runnable");
        kotlinx.coroutines.MainCoroutineDispatcher immediate = kotlinx.coroutines.Dispatchers.getMain().getImmediate();
        if (immediate.isDispatchNeeded(context) || canRun()) {
            immediate.dispatch(context, new androidx.lifecycle.DispatchQueue$dispatchAndEnqueue$1$1(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @androidx.annotation.MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while ((!this.queue.isEmpty()) && canRun()) {
                java.lang.Runnable poll = this.queue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @androidx.annotation.MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @androidx.annotation.MainThread
    public final void pause() {
        this.paused = true;
    }

    @androidx.annotation.MainThread
    public final void resume() {
        if (this.paused) {
            if (!(!this.finished)) {
                throw new java.lang.IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.paused = false;
            drainQueue();
        }
    }
}
