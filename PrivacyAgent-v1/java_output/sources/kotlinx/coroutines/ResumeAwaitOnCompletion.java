package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "Lkotlinx/coroutines/CancellableContinuationImpl;", "v", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
final class ResumeAwaitOnCompletion<T> extends kotlinx.coroutines.JobNode {

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CancellableContinuationImpl<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.continuation = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        invoke2(th);
        return kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        java.lang.Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally)) {
            this.continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlinx.coroutines.JobSupportKt.unboxState(state$kotlinx_coroutines_core)));
            return;
        }
        kotlinx.coroutines.CancellableContinuationImpl<T> cancellableContinuationImpl = this.continuation;
        java.lang.Throwable th = ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
    }
}
