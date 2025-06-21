package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class RunnableKt$Runnable$1 implements java.lang.Runnable {
    public final /* synthetic */ kotlin.jvm.functions.Function0<kotlin.Unit> n;

    public RunnableKt$Runnable$1(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        this.n = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.invoke();
    }
}
