package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"R", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    final /* synthetic */ kotlinx.coroutines.CoroutineDispatcher $lifecycleDispatcher;
    final /* synthetic */ androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
    final /* synthetic */ androidx.lifecycle.Lifecycle $this_suspendWithStateAtLeastUnchecked;

    @kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"R", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
        final /* synthetic */ androidx.lifecycle.Lifecycle $this_suspendWithStateAtLeastUnchecked;

        public AnonymousClass1(androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
            this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
            this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        super(1);
        this.$lifecycleDispatcher = coroutineDispatcher;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        invoke2(th);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher;
        kotlin.coroutines.EmptyCoroutineContext emptyCoroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            this.$lifecycleDispatcher.dispatch(emptyCoroutineContext, new androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.AnonymousClass1(this.$this_suspendWithStateAtLeastUnchecked, this.$observer));
        } else {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
        }
    }
}
