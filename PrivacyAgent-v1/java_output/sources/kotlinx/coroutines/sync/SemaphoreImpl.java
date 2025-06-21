package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "tryAcquire", "()Z", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "()V", "c", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "d", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "f", "e", "", "a", "I", "permits", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "onCancellationRelease", "getAvailablePermits", "()I", "availablePermits", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class SemaphoreImpl implements kotlinx.coroutines.sync.Semaphore {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater c = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.SemaphoreImpl.class, java.lang.Object.class, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD);
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater d = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.sync.SemaphoreImpl.class, "deqIdx");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater e = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.SemaphoreImpl.class, java.lang.Object.class, "tail");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater f = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.sync.SemaphoreImpl.class, "enqIdx");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater g = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.sync.SemaphoreImpl.class, "_availablePermits");

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: a, reason: from kotlin metadata */
    public final int permits;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> onCancellationRelease;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ long deqIdx = 0;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ long enqIdx = 0;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object head;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object tail;

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        if (!(i > 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Semaphore should have at least 1 permit, but had ", java.lang.Integer.valueOf(i)).toString());
        }
        if (!(i2 >= 0 && i2 <= i)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("The number of acquired permits should be in 0..", java.lang.Integer.valueOf(i)).toString());
        }
        kotlinx.coroutines.sync.SemaphoreSegment semaphoreSegment = new kotlinx.coroutines.sync.SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = i - i2;
        this.onCancellationRelease = new kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1(this);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    @org.jetbrains.annotations.Nullable
    public java.lang.Object acquire(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        if (g.getAndDecrement(this) > 0) {
            return kotlin.Unit.INSTANCE;
        }
        java.lang.Object c2 = c(continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c2 == coroutine_suspended ? c2 : kotlin.Unit.INSTANCE;
    }

    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        while (true) {
            if (d(orCreateCancellableContinuation)) {
                break;
            }
            if (g.getAndDecrement(this) > 0) {
                orCreateCancellableContinuation.resume(kotlin.Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
        }
        java.lang.Object result = orCreateCancellableContinuation.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cont) {
        int i;
        java.lang.Object m806constructorimpl;
        int i2;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        boolean z;
        kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.sync.SemaphoreSegment) this.tail;
        long andIncrement = f.getAndIncrement(this);
        i = kotlinx.coroutines.sync.SemaphoreKt.f;
        long j = andIncrement / i;
        do {
            kotlinx.coroutines.internal.Segment segment2 = segment;
            while (true) {
                if (segment2.getId() >= j && !segment2.getRemoved()) {
                    m806constructorimpl = kotlinx.coroutines.internal.SegmentOrClosed.m806constructorimpl(segment2);
                    break;
                }
                java.lang.Object obj = segment2.get_next();
                if (obj == kotlinx.coroutines.internal.ConcurrentLinkedListKt.a) {
                    m806constructorimpl = kotlinx.coroutines.internal.SegmentOrClosed.m806constructorimpl(kotlinx.coroutines.internal.ConcurrentLinkedListKt.a);
                    break;
                }
                kotlinx.coroutines.internal.Segment segment3 = (kotlinx.coroutines.internal.Segment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) obj);
                if (segment3 == null) {
                    segment3 = kotlinx.coroutines.sync.SemaphoreKt.a(segment2.getId() + 1, (kotlinx.coroutines.sync.SemaphoreSegment) segment2);
                    if (segment2.trySetNext(segment3)) {
                        if (segment2.getRemoved()) {
                            segment2.remove();
                        }
                    }
                }
                segment2 = segment3;
            }
            if (!kotlinx.coroutines.internal.SegmentOrClosed.m811isClosedimpl(m806constructorimpl)) {
                kotlinx.coroutines.internal.Segment m809getSegmentimpl = kotlinx.coroutines.internal.SegmentOrClosed.m809getSegmentimpl(m806constructorimpl);
                while (true) {
                    kotlinx.coroutines.internal.Segment segment4 = (kotlinx.coroutines.internal.Segment) this.tail;
                    if (segment4.getId() >= m809getSegmentimpl.getId()) {
                        break;
                    }
                    if (!m809getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    }
                    if (defpackage.q1.a(e, this, segment4, m809getSegmentimpl)) {
                        if (segment4.decPointers$kotlinx_coroutines_core()) {
                            segment4.remove();
                        }
                    } else if (m809getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m809getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        } while (!z);
        kotlinx.coroutines.sync.SemaphoreSegment semaphoreSegment = (kotlinx.coroutines.sync.SemaphoreSegment) kotlinx.coroutines.internal.SegmentOrClosed.m809getSegmentimpl(m806constructorimpl);
        i2 = kotlinx.coroutines.sync.SemaphoreKt.f;
        int i3 = (int) (andIncrement % i2);
        if (defpackage.es2.a(semaphoreSegment.e, i3, null, cont)) {
            cont.invokeOnCancellation(new kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler(semaphoreSegment, i3));
            return true;
        }
        symbol = kotlinx.coroutines.sync.SemaphoreKt.b;
        symbol2 = kotlinx.coroutines.sync.SemaphoreKt.c;
        if (!defpackage.es2.a(semaphoreSegment.e, i3, symbol, symbol2)) {
            return false;
        }
        cont.resume(kotlin.Unit.INSTANCE, this.onCancellationRelease);
        return true;
    }

    public final boolean e(kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation) {
        java.lang.Object tryResume = cancellableContinuation.tryResume(kotlin.Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f() {
        int i;
        java.lang.Object m806constructorimpl;
        int i2;
        int i3;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        int i4;
        kotlinx.coroutines.internal.Symbol symbol3;
        kotlinx.coroutines.internal.Symbol symbol4;
        kotlinx.coroutines.internal.Symbol symbol5;
        boolean z;
        kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.sync.SemaphoreSegment) this.head;
        long andIncrement = d.getAndIncrement(this);
        i = kotlinx.coroutines.sync.SemaphoreKt.f;
        long j = andIncrement / i;
        do {
            kotlinx.coroutines.internal.Segment segment2 = segment;
            while (true) {
                if (segment2.getId() >= j && !segment2.getRemoved()) {
                    m806constructorimpl = kotlinx.coroutines.internal.SegmentOrClosed.m806constructorimpl(segment2);
                    break;
                }
                java.lang.Object obj = segment2.get_next();
                if (obj == kotlinx.coroutines.internal.ConcurrentLinkedListKt.a) {
                    m806constructorimpl = kotlinx.coroutines.internal.SegmentOrClosed.m806constructorimpl(kotlinx.coroutines.internal.ConcurrentLinkedListKt.a);
                    break;
                }
                kotlinx.coroutines.internal.Segment segment3 = (kotlinx.coroutines.internal.Segment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) obj);
                if (segment3 == null) {
                    segment3 = kotlinx.coroutines.sync.SemaphoreKt.a(segment2.getId() + 1, (kotlinx.coroutines.sync.SemaphoreSegment) segment2);
                    if (segment2.trySetNext(segment3)) {
                        if (segment2.getRemoved()) {
                            segment2.remove();
                        }
                    }
                }
                segment2 = segment3;
            }
            if (kotlinx.coroutines.internal.SegmentOrClosed.m811isClosedimpl(m806constructorimpl)) {
                break;
            }
            kotlinx.coroutines.internal.Segment m809getSegmentimpl = kotlinx.coroutines.internal.SegmentOrClosed.m809getSegmentimpl(m806constructorimpl);
            while (true) {
                kotlinx.coroutines.internal.Segment segment4 = (kotlinx.coroutines.internal.Segment) this.head;
                if (segment4.getId() >= m809getSegmentimpl.getId()) {
                    break;
                }
                if (!m809getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                if (defpackage.q1.a(c, this, segment4, m809getSegmentimpl)) {
                    if (segment4.decPointers$kotlinx_coroutines_core()) {
                        segment4.remove();
                    }
                } else if (m809getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m809getSegmentimpl.remove();
                }
            }
        } while (!z);
        kotlinx.coroutines.sync.SemaphoreSegment semaphoreSegment = (kotlinx.coroutines.sync.SemaphoreSegment) kotlinx.coroutines.internal.SegmentOrClosed.m809getSegmentimpl(m806constructorimpl);
        semaphoreSegment.cleanPrev();
        if (semaphoreSegment.getId() > j) {
            return false;
        }
        i3 = kotlinx.coroutines.sync.SemaphoreKt.f;
        int i5 = (int) (andIncrement % i3);
        symbol = kotlinx.coroutines.sync.SemaphoreKt.b;
        java.lang.Object andSet = semaphoreSegment.e.getAndSet(i5, symbol);
        if (andSet != null) {
            symbol2 = kotlinx.coroutines.sync.SemaphoreKt.e;
            if (andSet == symbol2) {
                return false;
            }
            return e((kotlinx.coroutines.CancellableContinuation) andSet);
        }
        i4 = kotlinx.coroutines.sync.SemaphoreKt.a;
        for (i2 = 0; i2 < i4; i2++) {
            java.lang.Object obj2 = semaphoreSegment.e.get(i5);
            symbol5 = kotlinx.coroutines.sync.SemaphoreKt.c;
            if (obj2 == symbol5) {
                return true;
            }
        }
        symbol3 = kotlinx.coroutines.sync.SemaphoreKt.b;
        symbol4 = kotlinx.coroutines.sync.SemaphoreKt.d;
        return !defpackage.es2.a(semaphoreSegment.e, i5, symbol3, symbol4);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return java.lang.Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        while (true) {
            int i = this._availablePermits;
            int i2 = this.permits;
            if (!(i < i2)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("The number of released permits cannot be greater than ", java.lang.Integer.valueOf(i2)).toString());
            }
            if (g.compareAndSet(this, i, i + 1) && (i >= 0 || f())) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!g.compareAndSet(this, i, i - 1));
        return true;
    }
}
