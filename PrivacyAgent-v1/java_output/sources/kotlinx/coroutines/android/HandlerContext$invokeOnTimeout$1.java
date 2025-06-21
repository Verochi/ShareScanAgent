package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlinx/coroutines/android/HandlerContext$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class HandlerContext$invokeOnTimeout$1 implements kotlinx.coroutines.DisposableHandle {
    public final /* synthetic */ kotlinx.coroutines.android.HandlerContext n;
    public final /* synthetic */ java.lang.Runnable t;

    public HandlerContext$invokeOnTimeout$1(kotlinx.coroutines.android.HandlerContext handlerContext, java.lang.Runnable runnable) {
        this.n = handlerContext;
        this.t = runnable;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        android.os.Handler handler;
        handler = this.n.handler;
        handler.removeCallbacks(this.t);
    }
}
