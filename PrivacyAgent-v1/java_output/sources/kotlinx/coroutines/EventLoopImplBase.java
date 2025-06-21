package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\b \u0018\u00002\u00020\u00012\u00020\u0002:\u00046789B\u0007¢\u0006\u0004\b5\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00032\n\u0010\u0018\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0004¢\u0006\u0004\b \u0010\u0005J\u001b\u0010\"\u001a\u00020!2\n\u0010\u0018\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005J\u0017\u0010'\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u001cH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b,\u0010\u0005R$\u0010.\u001a\u00020!2\u0006\u0010-\u001a\u00020!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00102\u001a\u00020!8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010/R\u0014\u00104\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0013¨\u0006:"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "", "shutdown", "()V", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "resetAll", "", "f", "(Ljava/lang/Runnable;)Z", "e", "()Ljava/lang/Runnable;", "c", "j", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "", "h", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "g", "value", "isCompleted", "()Z", "i", "(Z)V", "isEmpty", "getNextTime", "nextTime", "<init>", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public abstract class EventLoopImplBase extends kotlinx.coroutines.EventLoopImplPlatform implements kotlinx.coroutines.Delay {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater v = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.EventLoopImplBase.class, java.lang.Object.class, "_queue");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater w = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.EventLoopImplBase.class, java.lang.Object.class, "_delayed");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _queue = null;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _delayed = null;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _isCompleted = 0;

    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "run", "", "toString", "Lkotlinx/coroutines/CancellableContinuation;", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class DelayedResumeTask extends kotlinx.coroutines.EventLoopImplBase.DelayedTask {

        /* renamed from: u, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CancellableContinuation<kotlin.Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation) {
            super(j);
            this.cont = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(kotlinx.coroutines.EventLoopImplBase.this, kotlin.Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return kotlin.jvm.internal.Intrinsics.stringPlus(super.toString(), this.cont);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", com.umeng.analytics.pro.bo.aN, "Ljava/lang/Runnable;", "block", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class DelayedRunnableTask extends kotlinx.coroutines.EventLoopImplBase.DelayedTask {

        /* renamed from: u, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final java.lang.Runnable block;

        public DelayedRunnableTask(long j, @org.jetbrains.annotations.NotNull java.lang.Runnable runnable) {
            super(j);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return kotlin.jvm.internal.Intrinsics.stringPlus(super.toString(), this.block);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "", "now", "", "timeToExecute", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "", "dispose", "", "toString", "nanoTime", "J", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Object;", "_heap", "t", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static abstract class DelayedTask implements java.lang.Runnable, java.lang.Comparable<kotlinx.coroutines.EventLoopImplBase.DelayedTask>, kotlinx.coroutines.DisposableHandle, kotlinx.coroutines.internal.ThreadSafeHeapNode {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public java.lang.Object _heap;

        @kotlin.jvm.JvmField
        public long nanoTime;

        /* renamed from: t, reason: from kotlin metadata */
        public int index = -1;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // java.lang.Comparable
        public int compareTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase.DelayedTask other) {
            long j = this.nanoTime - other.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.Symbol symbol;
            kotlinx.coroutines.internal.Symbol symbol2;
            java.lang.Object obj = this._heap;
            symbol = kotlinx.coroutines.EventLoop_commonKt.a;
            if (obj == symbol) {
                return;
            }
            kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = obj instanceof kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue ? (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) obj : null;
            if (delayedTaskQueue != null) {
                delayedTaskQueue.remove(this);
            }
            symbol2 = kotlinx.coroutines.EventLoop_commonKt.a;
            this._heap = symbol2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.ThreadSafeHeap<?> getHeap() {
            java.lang.Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.ThreadSafeHeap) {
                return (kotlinx.coroutines.internal.ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final synchronized int scheduleTask(long now, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayed, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase eventLoop) {
            kotlinx.coroutines.internal.Symbol symbol;
            java.lang.Object obj = this._heap;
            symbol = kotlinx.coroutines.EventLoop_commonKt.a;
            if (obj == symbol) {
                return 2;
            }
            synchronized (delayed) {
                kotlinx.coroutines.EventLoopImplBase.DelayedTask firstImpl = delayed.firstImpl();
                if (eventLoop.isCompleted()) {
                    return 1;
                }
                if (firstImpl == null) {
                    delayed.timeNow = now;
                } else {
                    long j = firstImpl.nanoTime;
                    if (j - now < 0) {
                        now = j;
                    }
                    if (now - delayed.timeNow > 0) {
                        delayed.timeNow = now;
                    }
                }
                long j2 = this.nanoTime;
                long j3 = delayed.timeNow;
                if (j2 - j3 < 0) {
                    this.nanoTime = j3;
                }
                delayed.addImpl(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.ThreadSafeHeap<?> threadSafeHeap) {
            kotlinx.coroutines.internal.Symbol symbol;
            java.lang.Object obj = this._heap;
            symbol = kotlinx.coroutines.EventLoop_commonKt.a;
            if (!(obj != symbol)) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = threadSafeHeap;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0;
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DelayedTaskQueue extends kotlinx.coroutines.internal.ThreadSafeHeap<kotlinx.coroutines.EventLoopImplBase.DelayedTask> {

        @kotlin.jvm.JvmField
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    public final void c() {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        while (true) {
            java.lang.Object obj = this._queue;
            if (obj == null) {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v;
                symbol = kotlinx.coroutines.EventLoop_commonKt.b;
                if (defpackage.q1.a(atomicReferenceFieldUpdater, this, null, symbol)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore) {
                    ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) obj).close();
                    return;
                }
                symbol2 = kotlinx.coroutines.EventLoop_commonKt.b;
                if (obj == symbol2) {
                    return;
                }
                kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = new kotlinx.coroutines.internal.LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((java.lang.Runnable) obj);
                if (defpackage.q1.a(v, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.Nullable
    public java.lang.Object delay(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        enqueue(block);
    }

    public final java.lang.Runnable e() {
        kotlinx.coroutines.internal.Symbol symbol;
        while (true) {
            java.lang.Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore) {
                kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) obj;
                java.lang.Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (removeFirstOrNull != kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (java.lang.Runnable) removeFirstOrNull;
                }
                defpackage.q1.a(v, this, obj, lockFreeTaskQueueCore.next());
            } else {
                symbol = kotlinx.coroutines.EventLoop_commonKt.b;
                if (obj == symbol) {
                    return null;
                }
                if (defpackage.q1.a(v, this, obj, null)) {
                    return (java.lang.Runnable) obj;
                }
            }
        }
    }

    public final void enqueue(@org.jetbrains.annotations.NotNull java.lang.Runnable task) {
        if (f(task)) {
            unpark();
        } else {
            kotlinx.coroutines.DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    public final boolean f(java.lang.Runnable task) {
        kotlinx.coroutines.internal.Symbol symbol;
        while (true) {
            java.lang.Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (defpackage.q1.a(v, this, null, task)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore) {
                kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(task);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    defpackage.q1.a(v, this, obj, lockFreeTaskQueueCore.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else {
                symbol = kotlinx.coroutines.EventLoop_commonKt.b;
                if (obj == symbol) {
                    return false;
                }
                kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new kotlinx.coroutines.internal.LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((java.lang.Runnable) obj);
                lockFreeTaskQueueCore2.addLast(task);
                if (defpackage.q1.a(v, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    public final void g() {
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        long nanoTime = timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime();
        while (true) {
            kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
            kotlinx.coroutines.EventLoopImplBase.DelayedTask removeFirstOrNull = delayedTaskQueue == null ? null : delayedTaskQueue.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                return;
            } else {
                reschedule(nanoTime, removeFirstOrNull);
            }
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        long coerceAtLeast;
        kotlinx.coroutines.internal.Symbol symbol;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        java.lang.Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore)) {
                symbol = kotlinx.coroutines.EventLoop_commonKt.b;
                return obj == symbol ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
        kotlinx.coroutines.EventLoopImplBase.DelayedTask peek = delayedTaskQueue == null ? null : delayedTaskQueue.peek();
        if (peek == null) {
            return Long.MAX_VALUE;
        }
        long j = peek.nanoTime;
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(j - (timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime()), 0L);
        return coerceAtLeast;
    }

    public final int h(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            defpackage.q1.a(w, this, null, new kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue(now));
            delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
            kotlin.jvm.internal.Intrinsics.checkNotNull(delayedTaskQueue);
        }
        return delayedTask.scheduleTask(now, delayedTaskQueue, this);
    }

    public final void i(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long j, @org.jetbrains.annotations.NotNull java.lang.Runnable runnable, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.EventLoop
    public boolean isEmpty() {
        kotlinx.coroutines.internal.Symbol symbol;
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        java.lang.Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore) {
                return ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) obj).isEmpty();
            }
            symbol = kotlinx.coroutines.EventLoop_commonKt.b;
            if (obj != symbol) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(kotlinx.coroutines.EventLoopImplBase.DelayedTask task) {
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue == null ? null : delayedTaskQueue.peek()) == task;
    }

    @Override // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask;
        if (processUnconfinedEvent()) {
            return 0L;
        }
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            long nanoTime = timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime();
            do {
                synchronized (delayedTaskQueue) {
                    kotlinx.coroutines.EventLoopImplBase.DelayedTask firstImpl = delayedTaskQueue.firstImpl();
                    if (firstImpl != null) {
                        kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask2 = firstImpl;
                        delayedTask = delayedTask2.timeToExecute(nanoTime) ? f(delayedTask2) : false ? delayedTaskQueue.removeAtImpl(0) : null;
                    }
                }
            } while (delayedTask != null);
        }
        java.lang.Runnable e = e();
        if (e == null) {
            return getNextTime();
        }
        e.run();
        return 0L;
    }

    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long now, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        int h = h(now, delayedTask);
        if (h == 0) {
            if (j(delayedTask)) {
                unpark();
            }
        } else if (h == 1) {
            reschedule(now, delayedTask);
        } else if (h != 2) {
            throw new java.lang.IllegalStateException("unexpected result".toString());
        }
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.DisposableHandle scheduleInvokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        long delayToNanos = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(timeMillis);
        if (delayToNanos >= kotlin.time.DurationKt.MAX_MILLIS) {
            return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
        }
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        long nanoTime = timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime();
        kotlinx.coroutines.EventLoopImplBase.DelayedRunnableTask delayedRunnableTask = new kotlinx.coroutines.EventLoopImplBase.DelayedRunnableTask(delayToNanos + nanoTime, block);
        schedule(nanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
        long delayToNanos = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(timeMillis);
        if (delayToNanos < kotlin.time.DurationKt.MAX_MILLIS) {
            kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            long nanoTime = timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime();
            kotlinx.coroutines.EventLoopImplBase.DelayedResumeTask delayedResumeTask = new kotlinx.coroutines.EventLoopImplBase.DelayedResumeTask(delayToNanos + nanoTime, continuation);
            kotlinx.coroutines.CancellableContinuationKt.disposeOnCancellation(continuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        i(true);
        c();
        while (processNextEvent() <= 0) {
        }
        g();
    }
}
