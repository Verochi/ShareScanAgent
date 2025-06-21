package kotlin.coroutines.intrinsics;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J$\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/Result;", "", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "label", "I", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    final /* synthetic */ kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> $block;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(kotlin.coroutines.Continuation<java.lang.Object> continuation, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> function1) {
        super(continuation, coroutineContext);
        this.$block = function1;
        kotlin.jvm.internal.Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            kotlin.ResultKt.throwOnFailure(result);
            return this.$block.invoke(this);
        }
        if (i != 1) {
            throw new java.lang.IllegalStateException("This coroutine had already completed".toString());
        }
        this.label = 2;
        kotlin.ResultKt.throwOnFailure(result);
        return result;
    }
}
