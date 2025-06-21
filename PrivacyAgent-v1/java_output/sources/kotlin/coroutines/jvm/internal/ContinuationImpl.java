package kotlin.coroutines.jvm.internal;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class ContinuationImpl extends kotlin.coroutines.jvm.internal.BaseContinuationImpl {

    @org.jetbrains.annotations.Nullable
    private final kotlin.coroutines.CoroutineContext _context;

    @org.jetbrains.annotations.Nullable
    private transient kotlin.coroutines.Continuation<java.lang.Object> intercepted;

    public ContinuationImpl(@org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        this(continuation, continuation != null ? continuation.getN() : null);
    }

    public ContinuationImpl(@org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<java.lang.Object> continuation, @org.jetbrains.annotations.Nullable kotlin.coroutines.CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    /* renamed from: getContext */
    public kotlin.coroutines.CoroutineContext getN() {
        kotlin.coroutines.CoroutineContext coroutineContext = this._context;
        kotlin.jvm.internal.Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<java.lang.Object> intercepted() {
        kotlin.coroutines.Continuation<java.lang.Object> continuation = this.intercepted;
        if (continuation == null) {
            kotlin.coroutines.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.ContinuationInterceptor) getN().get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
            if (continuationInterceptor == null || (continuation = continuationInterceptor.interceptContinuation(this)) == null) {
                continuation = this;
            }
            this.intercepted = continuation;
        }
        return continuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        kotlin.coroutines.Continuation<?> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            kotlin.coroutines.CoroutineContext.Element element = getN().get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
            kotlin.jvm.internal.Intrinsics.checkNotNull(element);
            ((kotlin.coroutines.ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = kotlin.coroutines.jvm.internal.CompletedContinuation.INSTANCE;
    }
}
