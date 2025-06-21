package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class lm0 implements android.view.Choreographer.FrameCallback {
    public final /* synthetic */ kotlinx.coroutines.CancellableContinuation n;

    public /* synthetic */ lm0(kotlinx.coroutines.CancellableContinuation cancellableContinuation) {
        this.n = cancellableContinuation;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        kotlinx.coroutines.android.HandlerDispatcherKt.c(this.n, j);
    }
}
