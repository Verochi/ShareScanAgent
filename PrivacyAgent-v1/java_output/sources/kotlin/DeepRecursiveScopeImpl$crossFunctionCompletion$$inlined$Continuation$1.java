package kotlin;

@kotlin.Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements kotlin.coroutines.Continuation<java.lang.Object> {
    public final /* synthetic */ kotlin.coroutines.CoroutineContext n;
    public final /* synthetic */ kotlin.DeepRecursiveScopeImpl t;
    public final /* synthetic */ kotlin.jvm.functions.Function3 u;
    public final /* synthetic */ kotlin.coroutines.Continuation v;

    public DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.DeepRecursiveScopeImpl deepRecursiveScopeImpl, kotlin.jvm.functions.Function3 function3, kotlin.coroutines.Continuation continuation) {
        this.n = coroutineContext;
        this.t = deepRecursiveScopeImpl;
        this.u = function3;
        this.v = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    /* renamed from: getContext, reason: from getter */
    public kotlin.coroutines.CoroutineContext getN() {
        return this.n;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        this.t.function = this.u;
        this.t.cont = this.v;
        this.t.result = result;
    }
}
