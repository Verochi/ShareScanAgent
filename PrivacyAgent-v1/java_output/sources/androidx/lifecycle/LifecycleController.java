package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@androidx.annotation.MainThread
/* loaded from: classes.dex */
public final class LifecycleController {

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.DispatchQueue dispatchQueue;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.Lifecycle lifecycle;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.Lifecycle.State minState;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LifecycleEventObserver observer;

    public LifecycleController(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle lifecycle, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.State minState, @org.jetbrains.annotations.NotNull androidx.lifecycle.DispatchQueue dispatchQueue, @org.jetbrains.annotations.NotNull kotlinx.coroutines.Job parentJob) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minState, "minState");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        androidx.lifecycle.LifecycleController$observer$1 lifecycleController$observer$1 = new androidx.lifecycle.LifecycleController$observer$1(this, parentJob);
        this.observer = lifecycleController$observer$1;
        if (lifecycle.getCurrentState() != androidx.lifecycle.Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleController$observer$1);
        } else {
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(parentJob, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            finish();
        }
    }

    private final void handleDestroy(kotlinx.coroutines.Job parentJob) {
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(parentJob, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        finish();
    }

    @androidx.annotation.MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
