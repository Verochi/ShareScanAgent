package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/Delay;", "a", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "DefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class DefaultExecutorKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Delay a = kotlinx.coroutines.DefaultExecutor.INSTANCE;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Delay getDefaultDelay() {
        return a;
    }
}
