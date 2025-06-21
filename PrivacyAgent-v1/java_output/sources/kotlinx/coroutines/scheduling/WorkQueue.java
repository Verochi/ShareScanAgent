package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001d\u001a\u00020\u0011*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "Lkotlinx/coroutines/scheduling/Task;", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", com.anythink.expressad.d.a.b.ay, "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "victim", "", "tryStealFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealBlockingFrom", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "a", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "e", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "queue", "d", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "c", "b", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class WorkQueue {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.WorkQueue.class, java.lang.Object.class, "lastScheduledTask");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater c = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.WorkQueue.class, "producerIndex");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater d = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.WorkQueue.class, "consumerIndex");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater e = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.WorkQueue.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.Task> buffer = new java.util.concurrent.atomic.AtomicReferenceArray<>(128);

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object lastScheduledTask = null;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ kotlinx.coroutines.scheduling.Task add$default(kotlinx.coroutines.scheduling.WorkQueue workQueue, kotlinx.coroutines.scheduling.Task task, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.add(task, z);
    }

    public final kotlinx.coroutines.scheduling.Task a(kotlinx.coroutines.scheduling.Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            e.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.buffer.get(i) != null) {
            java.lang.Thread.yield();
        }
        this.buffer.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.scheduling.Task add(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.Task task, boolean fair) {
        if (fair) {
            return a(task);
        }
        kotlinx.coroutines.scheduling.Task task2 = (kotlinx.coroutines.scheduling.Task) b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return a(task2);
    }

    public final void b(kotlinx.coroutines.scheduling.Task task) {
        if (task != null) {
            if (task.taskContext.getTaskMode() == 1) {
                e.decrementAndGet(this);
            }
        }
    }

    public final kotlinx.coroutines.scheduling.Task c() {
        kotlinx.coroutines.scheduling.Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.buffer.getAndSet(i2, null)) != null) {
                b(andSet);
                return andSet;
            }
        }
    }

    public final boolean d(kotlinx.coroutines.scheduling.GlobalQueue queue) {
        kotlinx.coroutines.scheduling.Task c2 = c();
        if (c2 == null) {
            return false;
        }
        queue.addLast(c2);
        return true;
    }

    public final long e(kotlinx.coroutines.scheduling.WorkQueue victim, boolean blockingOnly) {
        kotlinx.coroutines.scheduling.Task task;
        do {
            task = (kotlinx.coroutines.scheduling.Task) victim.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (blockingOnly) {
                if (!(task.taskContext.getTaskMode() == 1)) {
                    return -2L;
                }
            }
            long nanoTime = kotlinx.coroutines.scheduling.TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            long j = kotlinx.coroutines.scheduling.TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j) {
                return j - nanoTime;
            }
        } while (!defpackage.q1.a(b, victim, task, null));
        add$default(this, task, false, 2, null);
        return -1L;
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    public final void offloadAllWorkTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.GlobalQueue globalQueue) {
        kotlinx.coroutines.scheduling.Task task = (kotlinx.coroutines.scheduling.Task) b.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        while (d(globalQueue)) {
        }
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.scheduling.Task poll() {
        kotlinx.coroutines.scheduling.Task task = (kotlinx.coroutines.scheduling.Task) b.getAndSet(this, null);
        return task == null ? c() : task;
    }

    public final long tryStealBlockingFrom(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.WorkQueue victim) {
        int i = victim.consumerIndex;
        int i2 = victim.producerIndex;
        java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.Task> atomicReferenceArray = victim.buffer;
        while (true) {
            if (i == i2) {
                break;
            }
            int i3 = i & 127;
            if (victim.blockingTasksInBuffer == 0) {
                break;
            }
            kotlinx.coroutines.scheduling.Task task = atomicReferenceArray.get(i3);
            if (task != null) {
                if ((task.taskContext.getTaskMode() == 1) && defpackage.es2.a(atomicReferenceArray, i3, task, null)) {
                    e.decrementAndGet(victim);
                    add$default(this, task, false, 2, null);
                    return -1L;
                }
            }
            i++;
        }
        return e(victim, true);
    }

    public final long tryStealFrom(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.WorkQueue victim) {
        kotlinx.coroutines.scheduling.Task c2 = victim.c();
        if (c2 == null) {
            return e(victim, false);
        }
        add$default(this, c2, false, 2, null);
        return -1L;
    }
}
