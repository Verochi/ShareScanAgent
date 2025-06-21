package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: kotlinx.coroutines.android.HandlerDispatcherKt$awaitFrame$lambda-3$$inlined$Runnable$1, reason: invalid class name */
/* loaded from: classes15.dex */
public final class HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1 implements java.lang.Runnable {
    public final /* synthetic */ kotlinx.coroutines.CancellableContinuation n;

    public HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1(kotlinx.coroutines.CancellableContinuation cancellableContinuation) {
        this.n = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kotlinx.coroutines.android.HandlerDispatcherKt.d(this.n);
    }
}
