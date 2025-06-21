package kotlin.concurrent;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "", "run", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TimersKt$timerTask$1 extends java.util.TimerTask {
    public final /* synthetic */ kotlin.jvm.functions.Function1<java.util.TimerTask, kotlin.Unit> n;

    /* JADX WARN: Multi-variable type inference failed */
    public TimersKt$timerTask$1(kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> function1) {
        this.n = function1;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.n.invoke(this);
    }
}
