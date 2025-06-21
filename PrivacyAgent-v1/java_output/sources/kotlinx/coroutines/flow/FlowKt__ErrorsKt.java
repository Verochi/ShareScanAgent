package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012B\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aB\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001ae\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u001423\b\u0002\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00192\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001a\u007f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012W\u0010\u0012\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a3\u0010 \u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001b\u0010$\u001a\u00020\u0011*\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u0011*\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(*\\\b\u0007\u00104\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010B6\b)\u0012\n\b*\u0012\u0006\b\n0+8,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001c\b/\u0012\u0018\b\u000bB\u0014\b0\u0012\u0006\b1\u0012\u0002\b\f\u0012\b\b2\u0012\u0004\b\b(3\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "action", "a", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "fallback", "Lkotlin/Function1;", "", "predicate", "e", "", "retries", "Lkotlin/Function2;", "h", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "g", "Lkotlin/Function4;", "attempt", "k", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "collector", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "c", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)Z", "other", "d", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "Lkotlin/Deprecated;", com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, "Lkotlin/DeprecationLevel;", com.baidu.mobads.sdk.internal.bz.l, "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "(Throwable) -> Boolean", "ExceptionPredicate", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__ErrorsKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Throwable> continuation) {
        kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) continuation;
            int i2 = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ErrorsKt$catchImpl$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    try {
                        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ErrorsKt$catchImpl$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1<>(flowCollector, objectRef2);
                        flowKt__ErrorsKt$catchImpl$1.L$0 = objectRef2;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(flowKt__ErrorsKt$catchImpl$$inlined$collect$1, flowKt__ErrorsKt$catchImpl$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        objectRef = objectRef2;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        return null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
                if (!d(th, (java.lang.Throwable) objectRef.element) || c(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
                    throw th;
                }
                return th;
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1(continuation);
        java.lang.Object obj2 = flowKt__ErrorsKt$catchImpl$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ErrorsKt$catchImpl$1.label;
        if (i != 0) {
        }
        if (d(th, (java.lang.Throwable) objectRef.element)) {
        }
        throw th;
    }

    public static final boolean c(java.lang.Throwable th, kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return d(th, job.getCancellationException());
    }

    public static final boolean d(java.lang.Throwable th, java.lang.Throwable th2) {
        return th2 != null && kotlin.jvm.internal.Intrinsics.areEqual(th2, th);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @kotlin.ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> function1) {
        return kotlinx.coroutines.flow.FlowKt.m788catch(flow, new kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2(function1, flow2, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow f(kotlinx.coroutines.flow.Flow flow, kotlinx.coroutines.flow.Flow flow2, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            function1 = kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$1.INSTANCE;
        }
        return kotlinx.coroutines.flow.FlowKt.onErrorCollect(flow, flow2, function1);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    @kotlinx.coroutines.FlowPreview
    public static final /* synthetic */ kotlinx.coroutines.flow.Flow g(kotlinx.coroutines.flow.Flow flow, int i, kotlin.jvm.functions.Function1 function1) {
        if (i > 0) {
            return kotlinx.coroutines.flow.FlowKt.retryWhen(flow, new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6(function1, i, null));
        }
        throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected positive amount of retries, but had ", java.lang.Integer.valueOf(i)).toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        if (j > 0) {
            return kotlinx.coroutines.flow.FlowKt.retryWhen(flow, new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3(j, function2, null));
        }
        throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected positive amount of retries, but had ", java.lang.Long.valueOf(j)).toString());
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow i(kotlinx.coroutines.flow.Flow flow, int i, kotlin.jvm.functions.Function1 function1, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            function1 = kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$4.INSTANCE;
        }
        return g(flow, i, function1);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow j(kotlinx.coroutines.flow.Flow flow, long j, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            function2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1(null);
        }
        return kotlinx.coroutines.flow.FlowKt.retry(flow, j, (kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object>) function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> k(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super java.lang.Long, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function4) {
        return new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, function4);
    }
}
