package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<no name provided>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ThreadContextKt$updateState$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.internal.ThreadState, kotlin.coroutines.CoroutineContext.Element, kotlinx.coroutines.internal.ThreadState> {
    public static final kotlinx.coroutines.internal.ThreadContextKt$updateState$1 INSTANCE = new kotlinx.coroutines.internal.ThreadContextKt$updateState$1();

    public ThreadContextKt$updateState$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final kotlinx.coroutines.internal.ThreadState mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.ThreadState threadState, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        if (element instanceof kotlinx.coroutines.ThreadContextElement) {
            kotlinx.coroutines.ThreadContextElement<?> threadContextElement = (kotlinx.coroutines.ThreadContextElement) element;
            threadState.a(threadContextElement, threadContextElement.updateThreadContext(threadState.context));
        }
        return threadState;
    }
}
