package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DispatchQueue$dispatchAndEnqueue$1$1 implements java.lang.Runnable {
    final /* synthetic */ java.lang.Runnable $runnable;
    final /* synthetic */ androidx.lifecycle.DispatchQueue this$0;

    public DispatchQueue$dispatchAndEnqueue$1$1(androidx.lifecycle.DispatchQueue dispatchQueue, java.lang.Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$runnable = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.enqueue(this.$runnable);
    }
}
