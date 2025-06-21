package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", com.tencent.open.SocialConstants.PARAM_SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", "<anonymous parameter 1>", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LifecycleController$observer$1 implements androidx.lifecycle.LifecycleEventObserver {
    final /* synthetic */ kotlinx.coroutines.Job $parentJob;
    final /* synthetic */ androidx.lifecycle.LifecycleController this$0;

    public LifecycleController$observer$1(androidx.lifecycle.LifecycleController lifecycleController, kotlinx.coroutines.Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner source, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.Event noName_1) {
        androidx.lifecycle.Lifecycle.State state;
        androidx.lifecycle.DispatchQueue dispatchQueue;
        androidx.lifecycle.DispatchQueue dispatchQueue2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
        if (source.getLifecycle().getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            androidx.lifecycle.LifecycleController lifecycleController = this.this$0;
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(this.$parentJob, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            lifecycleController.finish();
            return;
        }
        androidx.lifecycle.Lifecycle.State currentState = source.getLifecycle().getCurrentState();
        state = this.this$0.minState;
        if (currentState.compareTo(state) < 0) {
            dispatchQueue2 = this.this$0.dispatchQueue;
            dispatchQueue2.pause();
        } else {
            dispatchQueue = this.this$0.dispatchQueue;
            dispatchQueue.resume();
        }
    }
}
