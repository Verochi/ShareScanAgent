package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements androidx.lifecycle.LifecycleEventObserver {
    final /* synthetic */ kotlin.jvm.functions.Function0<R> $block;
    final /* synthetic */ kotlinx.coroutines.CancellableContinuation<R> $co;
    final /* synthetic */ androidx.lifecycle.Lifecycle.State $state;
    final /* synthetic */ androidx.lifecycle.Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(androidx.lifecycle.Lifecycle.State state, androidx.lifecycle.Lifecycle lifecycle, kotlinx.coroutines.CancellableContinuation<? super R> cancellableContinuation, kotlin.jvm.functions.Function0<? extends R> function0) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = cancellableContinuation;
        this.$block = function0;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner source, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.Event event) {
        java.lang.Object m156constructorimpl;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event != androidx.lifecycle.Lifecycle.Event.upTo(this.$state)) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
                kotlin.coroutines.Continuation continuation = this.$co;
                androidx.lifecycle.LifecycleDestroyedException lifecycleDestroyedException = new androidx.lifecycle.LifecycleDestroyedException();
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(lifecycleDestroyedException)));
                return;
            }
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
        kotlin.coroutines.Continuation continuation2 = this.$co;
        kotlin.jvm.functions.Function0<R> function0 = this.$block;
        try {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(function0.invoke());
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        continuation2.resumeWith(m156constructorimpl);
    }
}
