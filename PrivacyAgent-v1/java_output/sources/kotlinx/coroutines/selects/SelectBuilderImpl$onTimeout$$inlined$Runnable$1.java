package kotlinx.coroutines.selects;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SelectBuilderImpl$onTimeout$$inlined$Runnable$1 implements java.lang.Runnable {
    public final /* synthetic */ kotlinx.coroutines.selects.SelectInstance n;
    public final /* synthetic */ kotlin.jvm.functions.Function1 t;

    public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(kotlinx.coroutines.selects.SelectInstance selectInstance, kotlin.jvm.functions.Function1 function1) {
        this.n = selectInstance;
        this.t = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.n.trySelect()) {
            kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(this.t, this.n.getCompletion());
        }
    }
}
