package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "Lkotlinx/coroutines/EventLoop;", "currentOrNull$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "currentOrNull", "", "resetEventLoop$kotlinx_coroutines_core", "()V", "resetEventLoop", "eventLoop", "setEventLoop$kotlinx_coroutines_core", "(Lkotlinx/coroutines/EventLoop;)V", "setEventLoop", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "a", "Ljava/lang/ThreadLocal;", "ref", "getEventLoop$kotlinx_coroutines_core", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class ThreadLocalEventLoop {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.ThreadLocalEventLoop INSTANCE = new kotlinx.coroutines.ThreadLocalEventLoop();

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.ThreadLocal<kotlinx.coroutines.EventLoop> ref = new java.lang.ThreadLocal<>();

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.EventLoop currentOrNull$kotlinx_coroutines_core() {
        return ref.get();
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.EventLoop getEventLoop$kotlinx_coroutines_core() {
        java.lang.ThreadLocal<kotlinx.coroutines.EventLoop> threadLocal = ref;
        kotlinx.coroutines.EventLoop eventLoop = threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        kotlinx.coroutines.EventLoop createEventLoop = kotlinx.coroutines.EventLoopKt.createEventLoop();
        threadLocal.set(createEventLoop);
        return createEventLoop;
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        ref.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoop eventLoop) {
        ref.set(eventLoop);
    }
}
