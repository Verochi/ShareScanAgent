package kotlin.coroutines.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0005\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0002R0\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class RunSuspend implements kotlin.coroutines.Continuation<kotlin.Unit> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlin.Result<kotlin.Unit> result;

    public final void a() {
        synchronized (this) {
            while (true) {
                kotlin.Result<kotlin.Unit> result = this.result;
                if (result == null) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } else {
                    kotlin.ResultKt.throwOnFailure(result.getValue());
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    /* renamed from: getContext */
    public kotlin.coroutines.CoroutineContext getN() {
        return kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        synchronized (this) {
            this.result = kotlin.Result.m155boximpl(result);
            kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public final void setResult(@org.jetbrains.annotations.Nullable kotlin.Result<kotlin.Unit> result) {
        this.result = result;
    }
}
