package kotlinx.coroutines.test;

@kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @kotlin.ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@kotlin.Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001KB\u0013\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\"¢\u0006\u0004\bI\u0010JJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u001c\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0002J7\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J$\u0010(\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010)\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010*\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J*\u0010,\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0018\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0+\u0012\u0004\u0012\u00020&0$J\b\u0010-\u001a\u00020\"H\u0016R\u0016\u00100\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020%018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u000605R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020%0+8F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "a", "", "delayTime", "Lkotlinx/coroutines/test/TimedRunnableObsolete;", "b", "c", "targetTime", "d", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Ljava/util/concurrent/TimeUnit;", "unit", "now", "advanceTimeBy", "advanceTimeTo", "triggerActions", "cancelAllActions", "", "message", "Lkotlin/Function1;", "", "", "predicate", "assertUnhandledException", "assertAllUnhandledExceptions", "assertAnyUnhandledException", "", "assertExceptions", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/String;", "name", "", "t", "Ljava/util/List;", "uncaughtExceptions", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxDispatcher", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "v", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "queue", "x", "J", "counter", "y", "time", "getExceptions", "()Ljava/util/List;", "exceptions", "<init>", "(Ljava/lang/String;)V", "Dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class TestCoroutineContext implements kotlin.coroutines.CoroutineContext {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String name;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Throwable> uncaughtExceptions;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.test.TestCoroutineContext.Dispatcher ctxDispatcher;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineExceptionHandler ctxHandler;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.ThreadSafeHeap<kotlinx.coroutines.test.TimedRunnable> queue;

    /* renamed from: x, reason: from kotlin metadata */
    public long counter;

    /* renamed from: y, reason: from kotlin metadata */
    public long time;

    @kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "(Lkotlinx/coroutines/test/TestCoroutineContext;)V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "processNextEvent", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldBeProcessedFromContext", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class Dispatcher extends kotlinx.coroutines.EventLoop implements kotlinx.coroutines.Delay {
        public Dispatcher() {
            kotlinx.coroutines.EventLoop.incrementUseCount$default(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        @org.jetbrains.annotations.Nullable
        public java.lang.Object delay(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return kotlinx.coroutines.Delay.DefaultImpls.delay(this, j, continuation);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
            kotlinx.coroutines.test.TestCoroutineContext.this.a(block);
        }

        @Override // kotlinx.coroutines.Delay
        @org.jetbrains.annotations.NotNull
        public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
            return new kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$invokeOnTimeout$1(kotlinx.coroutines.test.TestCoroutineContext.this, kotlinx.coroutines.test.TestCoroutineContext.this.b(block, timeMillis));
        }

        @Override // kotlinx.coroutines.EventLoop
        public long processNextEvent() {
            return kotlinx.coroutines.test.TestCoroutineContext.this.c();
        }

        @Override // kotlinx.coroutines.Delay
        public void scheduleResumeAfterDelay(long timeMillis, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
            kotlinx.coroutines.test.TestCoroutineContext.this.b(new kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(continuation, this), timeMillis);
        }

        @Override // kotlinx.coroutines.EventLoop
        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "Dispatcher(" + kotlinx.coroutines.test.TestCoroutineContext.this + ')';
        }
    }

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.name = str;
        this.uncaughtExceptions = new java.util.ArrayList();
        this.ctxDispatcher = new kotlinx.coroutines.test.TestCoroutineContext.Dispatcher();
        this.ctxHandler = new kotlinx.coroutines.test.TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE, this);
        this.queue = new kotlinx.coroutines.internal.ThreadSafeHeap<>();
    }

    public /* synthetic */ TestCoroutineContext(java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ long advanceTimeBy$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, long j, java.util.concurrent.TimeUnit timeUnit, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public static /* synthetic */ void advanceTimeTo$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, long j, java.util.concurrent.TimeUnit timeUnit, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, java.lang.String str, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, java.lang.String str, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public static /* synthetic */ void assertExceptions$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, java.lang.String str, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public static /* synthetic */ void assertUnhandledException$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, java.lang.String str, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public static /* synthetic */ long now$default(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, java.util.concurrent.TimeUnit timeUnit, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    public final void a(java.lang.Runnable block) {
        kotlinx.coroutines.internal.ThreadSafeHeap<kotlinx.coroutines.test.TimedRunnable> threadSafeHeap = this.queue;
        long j = this.counter;
        this.counter = 1 + j;
        threadSafeHeap.addLast(new kotlinx.coroutines.test.TimedRunnable(block, j, 0L, 4, null));
    }

    public final long advanceTimeBy(long delayTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit) {
        long j = this.time;
        long nanos = unit.toNanos(delayTime) + j;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS;
        advanceTimeTo(nanos, timeUnit);
        return unit.convert(this.time - j, timeUnit);
    }

    public final void advanceTimeTo(long targetTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit) {
        long nanos = unit.toNanos(targetTime);
        d(nanos);
        if (nanos > this.time) {
            this.time = nanos;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAllUnhandledExceptions(@org.jetbrains.annotations.NotNull java.lang.String message, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> predicate) {
        java.util.List<java.lang.Throwable> list = this.uncaughtExceptions;
        boolean z = true;
        if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
            java.util.Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!predicate.invoke(it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        if (!z) {
            throw new java.lang.AssertionError(message);
        }
        this.uncaughtExceptions.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAnyUnhandledException(@org.jetbrains.annotations.NotNull java.lang.String message, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> predicate) {
        java.util.List<java.lang.Throwable> list = this.uncaughtExceptions;
        boolean z = false;
        if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
            java.util.Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (predicate.invoke(it.next()).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            throw new java.lang.AssertionError(message);
        }
        this.uncaughtExceptions.clear();
    }

    public final void assertExceptions(@org.jetbrains.annotations.NotNull java.lang.String message, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<? extends java.lang.Throwable>, java.lang.Boolean> predicate) {
        if (!predicate.invoke(this.uncaughtExceptions).booleanValue()) {
            throw new java.lang.AssertionError(message);
        }
        this.uncaughtExceptions.clear();
    }

    public final void assertUnhandledException(@org.jetbrains.annotations.NotNull java.lang.String message, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> predicate) {
        if (this.uncaughtExceptions.size() != 1 || !predicate.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            throw new java.lang.AssertionError(message);
        }
        this.uncaughtExceptions.clear();
    }

    public final kotlinx.coroutines.test.TimedRunnable b(java.lang.Runnable block, long delayTime) {
        long j = this.counter;
        this.counter = 1 + j;
        kotlinx.coroutines.test.TimedRunnable timedRunnable = new kotlinx.coroutines.test.TimedRunnable(block, j, this.time + java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(delayTime));
        this.queue.addLast(timedRunnable);
        return timedRunnable;
    }

    public final long c() {
        kotlinx.coroutines.test.TimedRunnable peek = this.queue.peek();
        if (peek != null) {
            d(peek.time);
        }
        return this.queue.isEmpty() ? Long.MAX_VALUE : 0L;
    }

    public final void cancelAllActions() {
        if (this.queue.isEmpty()) {
            return;
        }
        this.queue.clear();
    }

    public final void d(long targetTime) {
        kotlinx.coroutines.test.TimedRunnable timedRunnable;
        while (true) {
            kotlinx.coroutines.internal.ThreadSafeHeap<kotlinx.coroutines.test.TimedRunnable> threadSafeHeap = this.queue;
            synchronized (threadSafeHeap) {
                kotlinx.coroutines.test.TimedRunnable firstImpl = threadSafeHeap.firstImpl();
                if (firstImpl != null) {
                    timedRunnable = (firstImpl.time > targetTime ? 1 : (firstImpl.time == targetTime ? 0 : -1)) <= 0 ? threadSafeHeap.removeAtImpl(0) : null;
                }
            }
            kotlinx.coroutines.test.TimedRunnable timedRunnable2 = timedRunnable;
            if (timedRunnable2 == null) {
                return;
            }
            long j = timedRunnable2.time;
            if (j != 0) {
                this.time = j;
            }
            timedRunnable2.run();
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R initial, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> operation) {
        return operation.mo5invoke(operation.mo5invoke(initial, this.ctxDispatcher), this.ctxHandler);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.Nullable
    public <E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        if (key == kotlin.coroutines.ContinuationInterceptor.INSTANCE) {
            return this.ctxDispatcher;
        }
        if (key == kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE) {
            return this.ctxHandler;
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        return key == kotlin.coroutines.ContinuationInterceptor.INSTANCE ? this.ctxHandler : key == kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE ? this.ctxDispatcher : this;
    }

    public final long now(@org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit) {
        return unit.convert(this.time, java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext plus(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlin.coroutines.CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.String str = this.name;
        return str == null ? kotlin.jvm.internal.Intrinsics.stringPlus("TestCoroutineContext@", kotlinx.coroutines.DebugStringsKt.getHexAddress(this)) : str;
    }

    public final void triggerActions() {
        d(this.time);
    }
}
