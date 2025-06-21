package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000P2\u00060@j\u0002`A2\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020 2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u0012¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\nJH\u0010,\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2%\b\b\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010(H\u0086\bø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0004\b/\u00100J!\u00101\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u00102J \u00103\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00102J\u0011\u00106\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0004\b4\u00105J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u001b\u0010;\u001a\u0004\u0018\u00010\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030:¢\u0006\u0004\b;\u0010<R\u001e\u0010=\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b=\u0010>\u0012\u0004\b?\u0010\nR\u001e\u0010D\u001a\n\u0018\u00010@j\u0004\u0018\u0001`A8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010GR\u0016\u0010H\u001a\u00020\u000b8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\bH\u0010>R\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0019\u0010N\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128F@\u0006¢\u0006\u0006\u001a\u0004\bM\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "requester", "", "isReusable", "(Lkotlinx/coroutines/CancellableContinuationImpl;)Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class DispatchedContinuation<T> extends kotlinx.coroutines.DispatchedTask<T> implements kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation<T> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.DispatchedContinuation.class, java.lang.Object.class, "_reusableCancellableContinuation");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _reusableCancellableContinuation;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public java.lang.Object _state;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<T> continuation;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object countOrElement;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        super(-1);
        kotlinx.coroutines.internal.Symbol symbol;
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation;
        symbol = kotlinx.coroutines.internal.DispatchedContinuationKt.a;
        this._state = symbol;
        this.countOrElement = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(getContext());
        this._reusableCancellableContinuation = null;
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    public final void awaitReusability() {
        while (this._reusableCancellableContinuation == kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED) {
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object takenState, @org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        if (takenState instanceof kotlinx.coroutines.CompletedWithCancellation) {
            ((kotlinx.coroutines.CompletedWithCancellation) takenState).onCancellation.invoke(cause);
        }
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        while (true) {
            java.lang.Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED;
                return null;
            }
            if (obj instanceof kotlinx.coroutines.CancellableContinuationImpl) {
                if (defpackage.q1.a(n, this, obj, kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                    return (kotlinx.coroutines.CancellableContinuationImpl) obj;
                }
            } else if (obj != kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED && !(obj instanceof java.lang.Throwable)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
        kotlin.coroutines.Continuation<T> continuation = this.continuation;
        if (continuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame) {
            return (kotlin.coroutines.jvm.internal.CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        java.lang.Object obj = this._reusableCancellableContinuation;
        if (obj instanceof kotlinx.coroutines.CancellableContinuationImpl) {
            return (kotlinx.coroutines.CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuationImpl<?> requester) {
        java.lang.Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        return !(obj instanceof kotlinx.coroutines.CancellableContinuationImpl) || obj == requester;
    }

    public final boolean postponeCancellation(@org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        while (true) {
            java.lang.Object obj = this._reusableCancellableContinuation;
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED;
            if (kotlin.jvm.internal.Intrinsics.areEqual(obj, symbol)) {
                if (defpackage.q1.a(n, this, symbol, cause)) {
                    return true;
                }
            } else {
                if (obj instanceof java.lang.Throwable) {
                    return true;
                }
                if (defpackage.q1.a(n, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void release() {
        awaitReusability();
        kotlinx.coroutines.CancellableContinuationImpl<?> reusableCancellableContinuation = getReusableCancellableContinuation();
        if (reusableCancellableContinuation == null) {
            return;
        }
        reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
    }

    /* JADX WARN: Finally extract failed */
    public final void resumeCancellableWith(@org.jetbrains.annotations.NotNull java.lang.Object result, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation) {
        boolean z;
        java.lang.Object state = kotlinx.coroutines.CompletionStateKt.toState(result, onCancellation);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = state;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) getContext().get(kotlinx.coroutines.Job.INSTANCE);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                java.util.concurrent.CancellationException cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                kotlin.coroutines.Continuation<T> continuation = this.continuation;
                java.lang.Object obj = this.countOrElement;
                kotlin.coroutines.CoroutineContext context = continuation.getContext();
                java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj);
                kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext) : null;
                try {
                    this.continuation.resumeWith(result);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    kotlin.jvm.internal.InlineMarker.finallyStart(1);
                    if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                        kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                    kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                } catch (java.lang.Throwable th) {
                    kotlin.jvm.internal.InlineMarker.finallyStart(1);
                    if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                        kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                    kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
        } catch (java.lang.Throwable th2) {
            try {
                handleFatalException(th2, null);
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
            } catch (java.lang.Throwable th3) {
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
    }

    public final boolean resumeCancelled(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) getContext().get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null || job.isActive()) {
            return false;
        }
        java.util.concurrent.CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(cancellationException)));
        return true;
    }

    public final void resumeUndispatchedWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        kotlin.coroutines.Continuation<T> continuation = this.continuation;
        java.lang.Object obj = this.countOrElement;
        kotlin.coroutines.CoroutineContext context = continuation.getContext();
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj);
        kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext) : null;
        try {
            this.continuation.resumeWith(result);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        kotlin.coroutines.CoroutineContext context = this.continuation.getContext();
        java.lang.Object state$default = kotlinx.coroutines.CompletionStateKt.toState$default(result, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = state$default;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state$default;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            kotlin.coroutines.CoroutineContext context2 = getContext();
            java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
            } finally {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @org.jetbrains.annotations.Nullable
    public java.lang.Object takeState$kotlinx_coroutines_core() {
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object obj = this._state;
        symbol = kotlinx.coroutines.internal.DispatchedContinuationKt.a;
        this._state = symbol;
        return obj;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + kotlinx.coroutines.DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable tryReleaseClaimedContinuation(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<?> continuation) {
        kotlinx.coroutines.internal.Symbol symbol;
        do {
            java.lang.Object obj = this._reusableCancellableContinuation;
            symbol = kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED;
            if (obj != symbol) {
                if (!(obj instanceof java.lang.Throwable)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Inconsistent state ", obj).toString());
                }
                if (defpackage.q1.a(n, this, obj, null)) {
                    return (java.lang.Throwable) obj;
                }
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!defpackage.q1.a(n, this, symbol, continuation));
        return null;
    }
}
