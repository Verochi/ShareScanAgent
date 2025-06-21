package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class JobKt__JobKt$DisposableHandle$1 implements kotlinx.coroutines.DisposableHandle {
    public final /* synthetic */ kotlin.jvm.functions.Function0<kotlin.Unit> n;

    public JobKt__JobKt$DisposableHandle$1(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        this.n = function0;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.n.invoke();
    }
}
