package kotlin.concurrent;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ThreadsKt$thread$thread$1 extends java.lang.Thread {
    public final /* synthetic */ kotlin.jvm.functions.Function0<kotlin.Unit> n;

    public ThreadsKt$thread$thread$1(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        this.n = function0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.n.invoke();
    }
}
