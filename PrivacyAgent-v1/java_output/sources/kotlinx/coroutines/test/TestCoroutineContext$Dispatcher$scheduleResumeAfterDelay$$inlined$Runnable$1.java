package kotlinx.coroutines.test;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1 implements java.lang.Runnable {
    public final /* synthetic */ kotlinx.coroutines.CancellableContinuation n;
    public final /* synthetic */ kotlinx.coroutines.test.TestCoroutineContext.Dispatcher t;

    public TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(kotlinx.coroutines.CancellableContinuation cancellableContinuation, kotlinx.coroutines.test.TestCoroutineContext.Dispatcher dispatcher) {
        this.n = cancellableContinuation;
        this.t = dispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.resumeUndispatched(this.t, kotlin.Unit.INSTANCE);
    }
}
