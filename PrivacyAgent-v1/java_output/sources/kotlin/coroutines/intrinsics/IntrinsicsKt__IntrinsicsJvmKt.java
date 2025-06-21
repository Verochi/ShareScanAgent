package kotlin.coroutines.intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a_\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\f\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", com.tencent.open.SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes14.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        kotlin.coroutines.Continuation<?> probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(completion);
        if (function1 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl) {
            return ((kotlin.coroutines.jvm.internal.BaseContinuationImpl) function1).create(probeCoroutineCreated);
        }
        kotlin.coroutines.CoroutineContext n = probeCoroutineCreated.getN();
        return n == kotlin.coroutines.EmptyCoroutineContext.INSTANCE ? new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(probeCoroutineCreated, function1) : new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(probeCoroutineCreated, n, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static <R, T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        kotlin.coroutines.Continuation<?> probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(completion);
        if (function2 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl) {
            return ((kotlin.coroutines.jvm.internal.BaseContinuationImpl) function2).create(r, probeCoroutineCreated);
        }
        kotlin.coroutines.CoroutineContext n = probeCoroutineCreated.getN();
        return n == kotlin.coroutines.EmptyCoroutineContext.INSTANCE ? new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(probeCoroutineCreated, function2, r) : new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(probeCoroutineCreated, n, function2, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.coroutines.Continuation<T> intercepted(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlin.coroutines.Continuation<T> continuation2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(continuation, "<this>");
        kotlin.coroutines.jvm.internal.ContinuationImpl continuationImpl = continuation instanceof kotlin.coroutines.jvm.internal.ContinuationImpl ? (kotlin.coroutines.jvm.internal.ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuation2 = (kotlin.coroutines.Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }
}
