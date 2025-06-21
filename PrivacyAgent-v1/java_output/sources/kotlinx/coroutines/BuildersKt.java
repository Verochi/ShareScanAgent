package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class BuildersKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.Deferred<T> async(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineStart coroutineStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.BuildersKt__Builders_commonKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.BuildersKt__Builders_commonKt.c(coroutineDispatcher, function2, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Job launch(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineStart coroutineStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.BuildersKt__Builders_commonKt.d(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T runBlocking(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2) throws java.lang.InterruptedException {
        return (T) kotlinx.coroutines.BuildersKt__BuildersKt.a(coroutineContext, function2);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object withContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.BuildersKt__Builders_commonKt.f(coroutineContext, function2, continuation);
    }
}
