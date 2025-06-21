package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0018\u0010\u0019\u001a\u00020\u001c2\u000e\u0010\u001a\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0017J\f\u0010\u001f\u001a\u00060\u001dj\u0002`\u001eH\u0017JA\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2'\u0010$\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001c0%j\u0002`(H\u0017J1\u0010 \u001a\u00020!2'\u0010$\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001c0%j\u0002`(H\u0017J\u0011\u0010)\u001a\u00020\u001cH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\nH\u0017J\b\u0010,\u001a\u00020-H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\t\u0010\fR\u001a\u0010\r\u001a\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000f\u001a\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "()V", "children", "Lkotlin/sequences/Sequence;", "getChildren$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "isActive$annotations", "()Z", "isCancelled", "isCancelled$annotations", "isCompleted", "isCompleted$annotations", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", com.anythink.expressad.d.a.b.dO, "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", com.anythink.expressad.foundation.d.c.bT, "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NonCancellable extends kotlin.coroutines.AbstractCoroutineContextElement implements kotlinx.coroutines.Job {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.NonCancellable INSTANCE = new kotlinx.coroutines.NonCancellable();

    public NonCancellable() {
        super(kotlinx.coroutines.Job.INSTANCE);
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static /* synthetic */ void getChildren$annotations() {
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static /* synthetic */ void isActive$annotations() {
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.ChildHandle attachChild(@org.jetbrains.annotations.NotNull kotlinx.coroutines.ChildJob child) {
        return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((java.util.concurrent.CancellationException) null);
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    public void cancel(@org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cause) {
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(java.lang.Throwable cause) {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.CancellationException getCancellationException() {
        throw new java.lang.IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public kotlin.sequences.Sequence<kotlinx.coroutines.Job> getChildren() {
        return kotlin.sequences.SequencesKt__SequencesKt.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.selects.SelectClause0 getOnJoin() {
        throw new java.lang.UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnCompletion(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    public java.lang.Object join(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        throw new java.lang.UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.Job plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        return kotlinx.coroutines.Job.DefaultImpls.plus((kotlinx.coroutines.Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    @kotlinx.coroutines.InternalCoroutinesApi
    public boolean start() {
        return false;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "NonCancellable";
    }
}
