package kotlinx.coroutines.test;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlinx/coroutines/test/TestCoroutineContext$Dispatcher$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TestCoroutineContext$Dispatcher$invokeOnTimeout$1 implements kotlinx.coroutines.DisposableHandle {
    public final /* synthetic */ kotlinx.coroutines.test.TestCoroutineContext n;
    public final /* synthetic */ kotlinx.coroutines.test.TimedRunnable t;

    public TestCoroutineContext$Dispatcher$invokeOnTimeout$1(kotlinx.coroutines.test.TestCoroutineContext testCoroutineContext, kotlinx.coroutines.test.TimedRunnable timedRunnable) {
        this.n = testCoroutineContext;
        this.t = timedRunnable;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        kotlinx.coroutines.internal.ThreadSafeHeap threadSafeHeap;
        threadSafeHeap = this.n.queue;
        threadSafeHeap.remove(this.t);
    }
}
