package kotlinx.coroutines.intrinsics;

@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0010\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "startCoroutineCancellable", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", com.tencent.open.SocialConstants.PARAM_RECEIVER, "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "fatalCompletion", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class CancellableKt {
    public static final void startCoroutineCancellable(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation2) {
        kotlin.coroutines.Continuation intercepted;
        try {
            intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith$default(intercepted, kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE), null, 2, null);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            continuation2.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        try {
            createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, continuation);
            intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith$default(intercepted, kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE), null, 2, null);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineCancellable(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        try {
            createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation);
            intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(intercepted, kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE), function1);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(kotlin.jvm.functions.Function2 function2, java.lang.Object obj, kotlin.coroutines.Continuation continuation, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }
}
