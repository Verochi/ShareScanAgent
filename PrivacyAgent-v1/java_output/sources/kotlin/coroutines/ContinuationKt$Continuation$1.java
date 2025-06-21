package kotlin.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ContinuationKt$Continuation$1 implements kotlin.coroutines.Continuation<java.lang.Object> {
    public final /* synthetic */ kotlin.coroutines.CoroutineContext n;
    public final /* synthetic */ kotlin.jvm.functions.Function1<kotlin.Result<java.lang.Object>, kotlin.Unit> t;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationKt$Continuation$1(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function1<? super kotlin.Result<java.lang.Object>, kotlin.Unit> function1) {
        this.n = coroutineContext;
        this.t = function1;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    /* renamed from: getContext, reason: from getter */
    public kotlin.coroutines.CoroutineContext getN() {
        return this.n;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        this.t.invoke(kotlin.Result.m155boximpl(result));
    }
}
