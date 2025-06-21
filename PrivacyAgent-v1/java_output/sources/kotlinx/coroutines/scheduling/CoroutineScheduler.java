package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0003OPQB+\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\u0006\u0010@\u001a\u00020\u0005\u0012\b\b\u0002\u0010A\u001a\u00020\u000e\u0012\b\b\u0002\u0010C\u001a\u00020&¢\u0006\u0004\bM\u0010NJ)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010 \u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0012j\u0002`\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\"2\n\u0010\u001c\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\"¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\"H\u0002¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\b\u0018\u00010\u0003R\u00020\u0000H\u0002¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0005H\u0002¢\u0006\u0004\b9\u0010:J+\u0010;\u001a\u0004\u0018\u00010\"*\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010)\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\b\u0018\u00010\u0003R\u00020\u0000H\u0002¢\u0006\u0004\b=\u0010/R\u0014\u0010>\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010?R\u0014\u0010A\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010GR \u0010J\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u0003R\u00020\u00000I8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bL\u00108¨\u0006R"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "", "oldIndex", "newIndex", "", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "availableCpuPermits", "(J)I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", com.heytap.mcssdk.constant.b.y, "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "shutdown", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "Lkotlinx/coroutines/scheduling/Task;", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "signalCpuWork", "", "toString", "()Ljava/lang/String;", "task", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "a", "(Lkotlinx/coroutines/scheduling/Task;)Z", "g", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "f", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "skipUnpark", "h", "(Z)V", "j", "(J)Z", "l", "()Z", "c", "()I", "i", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "e", "corePoolSize", "I", "maxPoolSize", "idleWorkerKeepAliveNs", "J", "schedulerName", "Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class CoroutineScheduler implements java.util.concurrent.Executor, java.io.Closeable {
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _isTerminated;

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ long controlState;

    @kotlin.jvm.JvmField
    public final int corePoolSize;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.scheduling.GlobalQueue globalBlockingQueue;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.scheduling.GlobalQueue globalCpuQueue;

    @kotlin.jvm.JvmField
    public final long idleWorkerKeepAliveNs;

    @kotlin.jvm.JvmField
    public final int maxPoolSize;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final java.lang.String schedulerName;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler.Worker> workers;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol NOT_IN_STACK = new kotlinx.coroutines.internal.Symbol("NOT_IN_STACK");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater n = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.CoroutineScheduler.class, "parkedWorkersStack");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater t = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.CoroutineScheduler.class, "controlState");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater u = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.CoroutineScheduler.class, "_isTerminated");

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.valuesCustom().length];
            iArr[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
            iArr[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
            iArr[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
            iArr[kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bG\u0010HB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\n¢\u0006\u0004\bG\u0010IJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u001cJ\u0019\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0011J\u0011\u0010#\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0011R*\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u001cR\u0014\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010>\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00104R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010)R\u0016\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0012\u0010F\u001a\u00020C8Æ\u0002¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "", "run", "()V", "", "upperBound", "nextInt", "(I)I", "scanLocalQueue", "Lkotlinx/coroutines/scheduling/Task;", "findTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "j", "()Z", "i", "k", "f", "task", "c", "(Lkotlinx/coroutines/scheduling/Task;)V", "taskMode", "b", "(I)V", "a", "g", com.anythink.expressad.d.a.b.dH, "mode", "e", "d", "h", "()Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "l", "index", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "t", "minDelayUntilStealableTaskNs", com.umeng.analytics.pro.bo.aN, "rngState", "mayHaveLocalTasks", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class Worker extends java.lang.Thread {
        public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater w = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.class, "workerCtl");
        private volatile int indexInArray;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.scheduling.WorkQueue localQueue;

        @kotlin.jvm.JvmField
        public boolean mayHaveLocalTasks;

        /* renamed from: n, reason: from kotlin metadata */
        public long terminationDeadline;

        @org.jetbrains.annotations.Nullable
        private volatile java.lang.Object nextParkedWorker;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState state;

        /* renamed from: t, reason: from kotlin metadata */
        public long minDelayUntilStealableTaskNs;

        /* renamed from: u, reason: from kotlin metadata */
        public int rngState;

        @org.jetbrains.annotations.NotNull
        volatile /* synthetic */ int workerCtl;

        public Worker() {
            setDaemon(true);
            this.localQueue = new kotlinx.coroutines.scheduling.WorkQueue();
            this.state = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = kotlinx.coroutines.scheduling.CoroutineScheduler.NOT_IN_STACK;
            this.rngState = kotlin.random.Random.INSTANCE.nextInt();
        }

        public Worker(int i) {
            this();
            setIndexInArray(i);
        }

        public final void a(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            kotlinx.coroutines.scheduling.CoroutineScheduler.t.addAndGet(kotlinx.coroutines.scheduling.CoroutineScheduler.this, -2097152L);
            if (this.state != kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED) {
                this.state = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT;
            }
        }

        public final void b(int taskMode) {
            if (taskMode != 0 && tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING)) {
                kotlinx.coroutines.scheduling.CoroutineScheduler.this.signalCpuWork();
            }
        }

        public final void c(kotlinx.coroutines.scheduling.Task task) {
            int taskMode = task.taskContext.getTaskMode();
            e(taskMode);
            b(taskMode);
            kotlinx.coroutines.scheduling.CoroutineScheduler.this.runSafely(task);
            a(taskMode);
        }

        public final kotlinx.coroutines.scheduling.Task d(boolean scanLocalQueue) {
            kotlinx.coroutines.scheduling.Task h;
            kotlinx.coroutines.scheduling.Task h2;
            if (scanLocalQueue) {
                boolean z = nextInt(kotlinx.coroutines.scheduling.CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z && (h2 = h()) != null) {
                    return h2;
                }
                kotlinx.coroutines.scheduling.Task poll = this.localQueue.poll();
                if (poll != null) {
                    return poll;
                }
                if (!z && (h = h()) != null) {
                    return h;
                }
            } else {
                kotlinx.coroutines.scheduling.Task h3 = h();
                if (h3 != null) {
                    return h3;
                }
            }
            return l(false);
        }

        public final void e(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING) {
                this.state = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING;
            }
        }

        public final boolean f() {
            return this.nextParkedWorker != kotlinx.coroutines.scheduling.CoroutineScheduler.NOT_IN_STACK;
        }

        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.scheduling.Task findTask(boolean scanLocalQueue) {
            kotlinx.coroutines.scheduling.Task removeFirstOrNull;
            if (j()) {
                return d(scanLocalQueue);
            }
            if (scanLocalQueue) {
                removeFirstOrNull = this.localQueue.poll();
                if (removeFirstOrNull == null) {
                    removeFirstOrNull = kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                }
            } else {
                removeFirstOrNull = kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            return removeFirstOrNull == null ? l(true) : removeFirstOrNull;
        }

        public final void g() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = java.lang.System.nanoTime() + kotlinx.coroutines.scheduling.CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            java.util.concurrent.locks.LockSupport.parkNanos(kotlinx.coroutines.scheduling.CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (java.lang.System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                m();
            }
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @org.jetbrains.annotations.NotNull
        /* renamed from: getScheduler, reason: from getter */
        public final kotlinx.coroutines.scheduling.CoroutineScheduler getV() {
            return kotlinx.coroutines.scheduling.CoroutineScheduler.this;
        }

        public final kotlinx.coroutines.scheduling.Task h() {
            if (nextInt(2) == 0) {
                kotlinx.coroutines.scheduling.Task removeFirstOrNull = kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                return removeFirstOrNull == null ? kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull() : removeFirstOrNull;
            }
            kotlinx.coroutines.scheduling.Task removeFirstOrNull2 = kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return removeFirstOrNull2 == null ? kotlinx.coroutines.scheduling.CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull() : removeFirstOrNull2;
        }

        public final void i() {
            loop0: while (true) {
                boolean z = false;
                while (!kotlinx.coroutines.scheduling.CoroutineScheduler.this.isTerminated() && this.state != kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED) {
                    kotlinx.coroutines.scheduling.Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        c(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            k();
                        } else if (z) {
                            tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING);
                            java.lang.Thread.interrupted();
                            java.util.concurrent.locks.LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED);
        }

        public final boolean j() {
            boolean z;
            if (this.state == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
                return true;
            }
            kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler = kotlinx.coroutines.scheduling.CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    z = false;
                    break;
                }
                if (kotlinx.coroutines.scheduling.CoroutineScheduler.t.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.state = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final void k() {
            if (!f()) {
                kotlinx.coroutines.scheduling.CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            this.workerCtl = -1;
            while (f() && this.workerCtl == -1 && !kotlinx.coroutines.scheduling.CoroutineScheduler.this.isTerminated() && this.state != kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED) {
                tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING);
                java.lang.Thread.interrupted();
                g();
            }
        }

        public final kotlinx.coroutines.scheduling.Task l(boolean blockingOnly) {
            int i = (int) (kotlinx.coroutines.scheduling.CoroutineScheduler.this.controlState & org.apache.tools.tar.TarConstants.MAXID);
            if (i < 2) {
                return null;
            }
            int nextInt = nextInt(i);
            kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler = kotlinx.coroutines.scheduling.CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                nextInt++;
                if (nextInt > i) {
                    nextInt = 1;
                }
                kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = coroutineScheduler.workers.get(nextInt);
                if (worker != null && worker != this) {
                    long tryStealBlockingFrom = blockingOnly ? this.localQueue.tryStealBlockingFrom(worker.localQueue) : this.localQueue.tryStealFrom(worker.localQueue);
                    if (tryStealBlockingFrom == -1) {
                        return this.localQueue.poll();
                    }
                    if (tryStealBlockingFrom > 0) {
                        j = java.lang.Math.min(j, tryStealBlockingFrom);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.minDelayUntilStealableTaskNs = j;
            return null;
        }

        public final void m() {
            kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler = kotlinx.coroutines.scheduling.CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & org.apache.tools.tar.TarConstants.MAXID)) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (w.compareAndSet(this, -1, 1)) {
                    int indexInArray = getIndexInArray();
                    setIndexInArray(0);
                    coroutineScheduler.parkedWorkersStackTopUpdate(this, indexInArray, 0);
                    int andDecrement = (int) (kotlinx.coroutines.scheduling.CoroutineScheduler.t.getAndDecrement(coroutineScheduler) & org.apache.tools.tar.TarConstants.MAXID);
                    if (andDecrement != indexInArray) {
                        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = coroutineScheduler.workers.get(andDecrement);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(worker);
                        coroutineScheduler.workers.set(indexInArray, worker);
                        worker.setIndexInArray(indexInArray);
                        coroutineScheduler.parkedWorkersStackTopUpdate(worker, andDecrement, indexInArray);
                    }
                    coroutineScheduler.workers.set(andDecrement, null);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    this.state = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED;
                }
            }
        }

        public final int nextInt(int upperBound) {
            int i = this.rngState;
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >> 17);
            int i4 = i3 ^ (i3 << 5);
            this.rngState = i4;
            int i5 = upperBound - 1;
            return (i5 & upperBound) == 0 ? i4 & i5 : (i4 & Integer.MAX_VALUE) % upperBound;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            i();
        }

        public final void setIndexInArray(int i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(kotlinx.coroutines.scheduling.CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : java.lang.String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState newState) {
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState workerState = this.state;
            boolean z = workerState == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED;
            if (z) {
                kotlinx.coroutines.scheduling.CoroutineScheduler.t.addAndGet(kotlinx.coroutines.scheduling.CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState[] valuesCustom() {
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState[] valuesCustom = values();
            return (kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState[]) java.util.Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public CoroutineScheduler(int i, int i2, long j, @org.jetbrains.annotations.NotNull java.lang.String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (!(i >= 1)) {
            throw new java.lang.IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new java.lang.IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new java.lang.IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new java.lang.IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.globalCpuQueue = new kotlinx.coroutines.scheduling.GlobalQueue();
        this.globalBlockingQueue = new kotlinx.coroutines.scheduling.GlobalQueue();
        this.parkedWorkersStack = 0L;
        this.workers = new java.util.concurrent.atomic.AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, java.lang.String str, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? kotlinx.coroutines.scheduling.TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? kotlinx.coroutines.scheduling.TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public static /* synthetic */ void dispatch$default(kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler, java.lang.Runnable runnable, kotlinx.coroutines.scheduling.TaskContext taskContext, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            taskContext = kotlinx.coroutines.scheduling.NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public static /* synthetic */ boolean k(kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler, long j, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.j(j);
    }

    public final boolean a(kotlinx.coroutines.scheduling.Task task) {
        return task.taskContext.getTaskMode() == 1 ? this.globalBlockingQueue.addLast(task) : this.globalCpuQueue.addLast(task);
    }

    public final int availableCpuPermits(long state) {
        return (int) ((state & 9223367638808264704L) >> 42);
    }

    public final int c() {
        int coerceAtLeast;
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & org.apache.tools.tar.TarConstants.MAXID);
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (this.controlState & org.apache.tools.tar.TarConstants.MAXID)) + 1;
            if (!(i2 > 0 && this.workers.get(i2) == null)) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = new kotlinx.coroutines.scheduling.CoroutineScheduler.Worker(i2);
            this.workers.set(i2, worker);
            if (!(i2 == ((int) (org.apache.tools.tar.TarConstants.MAXID & t.incrementAndGet(this))))) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            worker.start();
            return coerceAtLeast + 1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.scheduling.Task createTask(@org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.TaskContext taskContext) {
        long nanoTime = kotlinx.coroutines.scheduling.TasksKt.schedulerTimeSource.nanoTime();
        if (!(block instanceof kotlinx.coroutines.scheduling.Task)) {
            return new kotlinx.coroutines.scheduling.TaskImpl(block, nanoTime, taskContext);
        }
        kotlinx.coroutines.scheduling.Task task = (kotlinx.coroutines.scheduling.Task) block;
        task.submissionTime = nanoTime;
        task.taskContext = taskContext;
        return task;
    }

    public final void dispatch(@org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.TaskContext taskContext, boolean tailDispatch) {
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        kotlinx.coroutines.scheduling.Task createTask = createTask(block, taskContext);
        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker e = e();
        kotlinx.coroutines.scheduling.Task i = i(e, createTask, tailDispatch);
        if (i != null && !a(i)) {
            throw new java.util.concurrent.RejectedExecutionException(kotlin.jvm.internal.Intrinsics.stringPlus(this.schedulerName, " was terminated"));
        }
        boolean z = tailDispatch && e != null;
        if (createTask.taskContext.getTaskMode() != 0) {
            h(z);
        } else {
            if (z) {
                return;
            }
            signalCpuWork();
        }
    }

    public final kotlinx.coroutines.scheduling.CoroutineScheduler.Worker e() {
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = currentThread instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker ? (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) currentThread : null;
        if (worker != null && kotlin.jvm.internal.Intrinsics.areEqual(kotlinx.coroutines.scheduling.CoroutineScheduler.this, this)) {
            return worker;
        }
        return null;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@org.jetbrains.annotations.NotNull java.lang.Runnable command) {
        dispatch$default(this, command, null, false, 6, null);
    }

    public final int f(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker) {
        java.lang.Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker2 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    public final kotlinx.coroutines.scheduling.CoroutineScheduler.Worker g() {
        while (true) {
            long j = this.parkedWorkersStack;
            kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = this.workers.get((int) (org.apache.tools.tar.TarConstants.MAXID & j));
            if (worker == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int f = f(worker);
            if (f >= 0 && n.compareAndSet(this, j, f | j2)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    public final void h(boolean skipUnpark) {
        long addAndGet = t.addAndGet(this, 2097152L);
        if (skipUnpark || l() || j(addAndGet)) {
            return;
        }
        l();
    }

    public final kotlinx.coroutines.scheduling.Task i(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker, kotlinx.coroutines.scheduling.Task task, boolean z) {
        if (worker == null || worker.state == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean j(long state) {
        int coerceAtLeast;
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(((int) (org.apache.tools.tar.TarConstants.MAXID & state)) - ((int) ((state & 4398044413952L) >> 21)), 0);
        if (coerceAtLeast < this.corePoolSize) {
            int c = c();
            if (c == 1 && this.corePoolSize > 1) {
                c();
            }
            if (c > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker g;
        do {
            g = g();
            if (g == null) {
                return false;
            }
        } while (!kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.w.compareAndSet(g, -1, 0));
        java.util.concurrent.locks.LockSupport.unpark(g);
        return true;
    }

    public final boolean parkedWorkersStackPush(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker) {
        long j;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (org.apache.tools.tar.TarConstants.MAXID & j);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.get(i));
        } while (!n.compareAndSet(this, j, ((2097152 + j) & (-2097152)) | indexInArray));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker, int oldIndex, int newIndex) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i = (int) (org.apache.tools.tar.TarConstants.MAXID & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i == oldIndex) {
                i = newIndex == 0 ? f(worker) : newIndex;
            }
            if (i >= 0 && n.compareAndSet(this, j, j2 | i)) {
                return;
            }
        }
    }

    public final void runSafely(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.Task task) {
        try {
            task.run();
        } catch (java.lang.Throwable th) {
            try {
                java.lang.Thread currentThread = java.lang.Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    public final void shutdown(long timeout) {
        int i;
        if (u.compareAndSet(this, 0, 1)) {
            kotlinx.coroutines.scheduling.CoroutineScheduler.Worker e = e();
            synchronized (this.workers) {
                i = (int) (this.controlState & org.apache.tools.tar.TarConstants.MAXID);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    int i3 = i2 + 1;
                    kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = this.workers.get(i2);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(worker);
                    if (worker != e) {
                        while (worker.isAlive()) {
                            java.util.concurrent.locks.LockSupport.unpark(worker);
                            worker.join(timeout);
                        }
                        worker.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                kotlinx.coroutines.scheduling.Task findTask = e == null ? null : e.findTask(true);
                if (findTask == null) {
                    findTask = this.globalCpuQueue.removeFirstOrNull();
                }
                if (findTask == null && (findTask = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                    break;
                } else {
                    runSafely(findTask);
                }
            }
            if (e != null) {
                e.tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void signalCpuWork() {
        if (l() || k(this, 0L, 1, null)) {
            return;
        }
        l();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = this.workers.length();
        int i5 = 0;
        if (1 < length) {
            i2 = 0;
            int i6 = 0;
            i3 = 0;
            i4 = 0;
            int i7 = 1;
            while (true) {
                int i8 = i7 + 1;
                kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker = this.workers.get(i7);
                if (worker != null) {
                    int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                    int i9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                    if (i9 == 1) {
                        i5++;
                    } else if (i9 == 2) {
                        i2++;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(size$kotlinx_coroutines_core);
                        sb.append(com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM);
                        arrayList.add(sb.toString());
                    } else if (i9 == 3) {
                        i6++;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(size$kotlinx_coroutines_core);
                        sb2.append('c');
                        arrayList.add(sb2.toString());
                    } else if (i9 == 4) {
                        i3++;
                        if (size$kotlinx_coroutines_core > 0) {
                            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                            sb3.append(size$kotlinx_coroutines_core);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (i9 == 5) {
                        i4++;
                    }
                }
                if (i8 >= length) {
                    break;
                }
                i7 = i8;
            }
            i = i5;
            i5 = i6;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        long j = this.controlState;
        return this.schedulerName + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i5 + ", blocking = " + i2 + ", parked = " + i + ", dormant = " + i3 + ", terminated = " + i4 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (org.apache.tools.tar.TarConstants.MAXID & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }
}
