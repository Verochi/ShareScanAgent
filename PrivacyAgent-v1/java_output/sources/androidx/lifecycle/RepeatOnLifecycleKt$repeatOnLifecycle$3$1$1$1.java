package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "<anonymous parameter 0>", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements androidx.lifecycle.LifecycleEventObserver {
    final /* synthetic */ kotlinx.coroutines.CoroutineScope $$this$coroutineScope;
    final /* synthetic */ kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> $block;
    final /* synthetic */ androidx.lifecycle.Lifecycle.Event $cancelWorkEvent;
    final /* synthetic */ kotlinx.coroutines.CancellableContinuation<kotlin.Unit> $cont;
    final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<kotlinx.coroutines.Job> $launchedJob;
    final /* synthetic */ kotlinx.coroutines.sync.Mutex $mutex;
    final /* synthetic */ androidx.lifecycle.Lifecycle.Event $startWorkEvent;

    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {171, 110}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> $block;
        final /* synthetic */ kotlinx.coroutines.sync.Mutex $mutex;
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.sync.Mutex mutex, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2, kotlin.coroutines.Continuation<? super androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mutex = mutex;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1(this.$mutex, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            java.lang.Object coroutine_suspended;
            kotlinx.coroutines.sync.Mutex mutex;
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> function2;
            kotlinx.coroutines.sync.Mutex mutex2;
            java.lang.Throwable th;
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    mutex = this.$mutex;
                    function2 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = function2;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (kotlinx.coroutines.sync.Mutex) this.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj);
                            kotlin.Unit unit = kotlin.Unit.INSTANCE;
                            mutex2.unlock(null);
                            return kotlin.Unit.INSTANCE;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    function2 = (kotlin.jvm.functions.Function2) this.L$1;
                    kotlinx.coroutines.sync.Mutex mutex3 = (kotlinx.coroutines.sync.Mutex) this.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, null);
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
                mutex2.unlock(null);
                return kotlin.Unit.INSTANCE;
            } catch (java.lang.Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(androidx.lifecycle.Lifecycle.Event event, kotlin.jvm.internal.Ref.ObjectRef<kotlinx.coroutines.Job> objectRef, kotlinx.coroutines.CoroutineScope coroutineScope, androidx.lifecycle.Lifecycle.Event event2, kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation, kotlinx.coroutines.sync.Mutex mutex, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        this.$startWorkEvent = event;
        this.$launchedJob = objectRef;
        this.$$this$coroutineScope = coroutineScope;
        this.$cancelWorkEvent = event2;
        this.$cont = cancellableContinuation;
        this.$mutex = mutex;
        this.$block = function2;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [T, kotlinx.coroutines.Job] */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner noName_0, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.Event event) {
        ?? e;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event == this.$startWorkEvent) {
            kotlin.jvm.internal.Ref.ObjectRef<kotlinx.coroutines.Job> objectRef = this.$launchedJob;
            e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(this.$$this$coroutineScope, null, null, new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1(this.$mutex, this.$block, null), 3, null);
            objectRef.element = e;
            return;
        }
        if (event == this.$cancelWorkEvent) {
            kotlinx.coroutines.Job job = this.$launchedJob.element;
            if (job != null) {
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            }
            this.$launchedJob.element = null;
        }
        if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
            this.$cont.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
        }
    }
}
