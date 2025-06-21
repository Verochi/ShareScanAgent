package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", com.xiaomi.mipush.sdk.MiPushClient.COMMAND_REGISTER, "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends androidx.lifecycle.LifecycleCoroutineScope implements androidx.lifecycle.LifecycleEventObserver {

    @org.jetbrains.annotations.NotNull
    private final kotlin.coroutines.CoroutineContext coroutineContext;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle lifecycle, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle().getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            kotlinx.coroutines.JobKt__JobKt.j(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @org.jetbrains.annotations.NotNull
    /* renamed from: getLifecycle$lifecycle_runtime_ktx_release, reason: from getter */
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner source, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.Event event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (getLifecycle().getCurrentState().compareTo(androidx.lifecycle.Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            kotlinx.coroutines.JobKt__JobKt.j(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(this, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
