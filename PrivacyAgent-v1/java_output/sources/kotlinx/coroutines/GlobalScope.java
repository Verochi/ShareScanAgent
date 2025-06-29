package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/GlobalScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlinx.coroutines.DelicateCoroutinesApi
/* loaded from: classes15.dex */
public final class GlobalScope implements kotlinx.coroutines.CoroutineScope {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.GlobalScope INSTANCE = new kotlinx.coroutines.GlobalScope();

    @Override // kotlinx.coroutines.CoroutineScope
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
    }
}
