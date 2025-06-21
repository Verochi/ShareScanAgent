package kotlin.coroutines;

@kotlin.Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a_\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aY\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", com.tencent.open.SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ContinuationKt {
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutine(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, completion);
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new kotlin.coroutines.SafeContinuation(intercepted, coroutine_suspended);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <R, T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutine(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, completion);
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new kotlin.coroutines.SafeContinuation(intercepted, coroutine_suspended);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final <T> void startCoroutine(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, completion);
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        intercepted.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final <R, T> void startCoroutine(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        kotlin.coroutines.Continuation createCoroutineUnintercepted;
        kotlin.coroutines.Continuation intercepted;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, completion);
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        intercepted.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
    }
}
