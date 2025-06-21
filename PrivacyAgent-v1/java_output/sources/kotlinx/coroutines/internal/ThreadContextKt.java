package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\n\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"*\u0010\u0010\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"2\u0010\u0013\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00110\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f\"&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "threadContextElements", "countOrElement", "updateThreadContext", "oldState", "", "restoreThreadContext", "Lkotlinx/coroutines/internal/Symbol;", "NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "a", "Lkotlin/jvm/functions/Function2;", "countAll", "Lkotlinx/coroutines/ThreadContextElement;", "b", "findOne", "Lkotlinx/coroutines/internal/ThreadState;", "c", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ThreadContextKt {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol NO_THREAD_ELEMENTS = new kotlinx.coroutines.internal.Symbol("NO_THREAD_ELEMENTS");

    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.CoroutineContext.Element, java.lang.Object> a = kotlinx.coroutines.internal.ThreadContextKt$countAll$1.INSTANCE;

    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function2<kotlinx.coroutines.ThreadContextElement<?>, kotlin.coroutines.CoroutineContext.Element, kotlinx.coroutines.ThreadContextElement<?>> b = kotlinx.coroutines.internal.ThreadContextKt$findOne$1.INSTANCE;

    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function2<kotlinx.coroutines.internal.ThreadState, kotlin.coroutines.CoroutineContext.Element, kotlinx.coroutines.internal.ThreadState> c = kotlinx.coroutines.internal.ThreadContextKt$updateState$1.INSTANCE;

    public static final void restoreThreadContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof kotlinx.coroutines.internal.ThreadState) {
            ((kotlinx.coroutines.internal.ThreadState) obj).b(coroutineContext);
            return;
        }
        java.lang.Object fold = coroutineContext.fold(null, b);
        if (fold == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((kotlinx.coroutines.ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object threadContextElements(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        java.lang.Object fold = coroutineContext.fold(0, a);
        kotlin.jvm.internal.Intrinsics.checkNotNull(fold);
        return fold;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object updateThreadContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        return obj == 0 ? NO_THREAD_ELEMENTS : obj instanceof java.lang.Integer ? coroutineContext.fold(new kotlinx.coroutines.internal.ThreadState(coroutineContext, ((java.lang.Number) obj).intValue()), c) : ((kotlinx.coroutines.ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
