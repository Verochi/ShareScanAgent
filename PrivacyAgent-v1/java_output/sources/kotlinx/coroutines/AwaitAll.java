package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001d\u0012\u0014\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/Deferred;", "a", "[Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
final class AwaitAll<T> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.AwaitAll.class, "notCompletedCount");

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Deferred<T>[] deferreds;

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ int notCompletedCount;

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R<\u0010\u001b\u001a\u000e\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0016\u001a\u000e\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "v", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "Lkotlinx/coroutines/DisposableHandle;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/DisposableHandle;", "f", "()Lkotlinx/coroutines/DisposableHandle;", "h", "(Lkotlinx/coroutines/DisposableHandle;)V", "handle", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "e", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "g", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class AwaitAllNode extends kotlinx.coroutines.JobNode {

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _disposer = null;

        /* renamed from: v, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CancellableContinuation<java.util.List<? extends T>> continuation;

        /* renamed from: w, reason: from kotlin metadata */
        public kotlinx.coroutines.DisposableHandle handle;

        /* JADX WARN: Multi-variable type inference failed */
        public AwaitAllNode(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super java.util.List<? extends T>> cancellableContinuation) {
            this.continuation = cancellableContinuation;
        }

        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.AwaitAll<T>.DisposeHandlersOnCancel e() {
            return (kotlinx.coroutines.AwaitAll.DisposeHandlersOnCancel) this._disposer;
        }

        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.DisposableHandle f() {
            kotlinx.coroutines.DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("handle");
            throw null;
        }

        public final void g(@org.jetbrains.annotations.Nullable kotlinx.coroutines.AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this._disposer = disposeHandlersOnCancel;
        }

        public final void h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
            invoke2(th);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            if (cause != null) {
                java.lang.Object tryResumeWithException = this.continuation.tryResumeWithException(cause);
                if (tryResumeWithException != null) {
                    this.continuation.completeResume(tryResumeWithException);
                    kotlinx.coroutines.AwaitAll<T>.DisposeHandlersOnCancel e = e();
                    if (e == null) {
                        return;
                    }
                    e.a();
                    return;
                }
                return;
            }
            if (kotlinx.coroutines.AwaitAll.b.decrementAndGet(kotlinx.coroutines.AwaitAll.this) == 0) {
                kotlinx.coroutines.CancellableContinuation<java.util.List<? extends T>> cancellableContinuation = this.continuation;
                kotlinx.coroutines.Deferred[] deferredArr = kotlinx.coroutines.AwaitAll.this.deferreds;
                java.util.ArrayList arrayList = new java.util.ArrayList(deferredArr.length);
                for (kotlinx.coroutines.Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(arrayList));
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "", "a", "", "cause", "invoke", "", "toString", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "nodes", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class DisposeHandlersOnCancel extends kotlinx.coroutines.CancelHandler {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.AwaitAll<T>.AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            this.nodes = awaitAllNodeArr;
        }

        public final void a() {
            for (kotlinx.coroutines.AwaitAll<T>.AwaitAllNode awaitAllNode : this.nodes) {
                awaitAllNode.f().dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
            invoke2(th);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            a();
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Deferred<? extends T>[] deferredArr) {
        this.deferreds = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.deferreds.length;
        kotlinx.coroutines.AwaitAll.AwaitAllNode[] awaitAllNodeArr = new kotlinx.coroutines.AwaitAll.AwaitAllNode[length];
        for (int i = 0; i < length; i++) {
            kotlinx.coroutines.Deferred deferred = this.deferreds[i];
            deferred.start();
            kotlinx.coroutines.AwaitAll.AwaitAllNode awaitAllNode = new kotlinx.coroutines.AwaitAll.AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.h(deferred.invokeOnCompletion(awaitAllNode));
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            awaitAllNodeArr[i] = awaitAllNode;
        }
        kotlinx.coroutines.AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = new kotlinx.coroutines.AwaitAll.DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i2 = 0; i2 < length; i2++) {
            awaitAllNodeArr[i2].g(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            disposeHandlersOnCancel.a();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(disposeHandlersOnCancel);
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
