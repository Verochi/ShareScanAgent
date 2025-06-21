package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bc\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\b\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0016\u001a\u00020\tH\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007R:\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\b\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/BlockRunner;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "timeoutInMs", "", com.tencent.connect.common.Constants.PARAM_SCOPE, "Lkotlinx/coroutines/CoroutineScope;", "onDone", "Lkotlin/Function0;", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/jvm/functions/Function2;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function2;", "cancellationJob", "Lkotlinx/coroutines/Job;", "runningJob", com.anythink.expressad.d.a.b.dO, "maybeRun", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BlockRunner<T> {

    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<androidx.lifecycle.LiveDataScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> block;

    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job cancellationJob;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.CoroutineLiveData<T> liveData;

    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onDone;

    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job runningJob;

    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@org.jetbrains.annotations.NotNull androidx.lifecycle.CoroutineLiveData<T> liveData, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.lifecycle.LiveDataScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, long j, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "liveData");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scope, "scope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j;
        this.scope = scope;
        this.onDone = onDone;
    }

    @androidx.annotation.MainThread
    public final void cancel() {
        kotlinx.coroutines.Job e;
        if (this.cancellationJob != null) {
            throw new java.lang.IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(this.scope, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.BlockRunner$cancel$1(this, null), 2, null);
        this.cancellationJob = e;
    }

    @androidx.annotation.MainThread
    public final void maybeRun() {
        kotlinx.coroutines.Job e;
        kotlinx.coroutines.Job job = this.cancellationJob;
        if (job != null) {
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(this.scope, null, null, new androidx.lifecycle.BlockRunner$maybeRun$1(this, null), 3, null);
        this.runningJob = e;
    }
}
