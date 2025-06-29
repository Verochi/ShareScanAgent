package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0000\u0018\u00002\u00020\fB%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class CancelledContinuation extends kotlinx.coroutines.CompletedExceptionally {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.CancelledContinuation.class, "_resumed");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CancelledContinuation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation, @org.jetbrains.annotations.Nullable java.lang.Throwable th, boolean z) {
        super(th, z);
        if (th == null) {
            th = new java.util.concurrent.CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        this._resumed = 0;
    }

    public final boolean makeResumed() {
        return b.compareAndSet(this, 0, 1);
    }
}
