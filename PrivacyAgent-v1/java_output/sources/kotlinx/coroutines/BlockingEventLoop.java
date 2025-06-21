package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Thread;", "x", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class BlockingEventLoop extends kotlinx.coroutines.EventLoopImplBase {

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Thread thread;

    public BlockingEventLoop(@org.jetbrains.annotations.NotNull java.lang.Thread thread) {
        this.thread = thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @org.jetbrains.annotations.NotNull
    public java.lang.Thread getThread() {
        return this.thread;
    }
}
