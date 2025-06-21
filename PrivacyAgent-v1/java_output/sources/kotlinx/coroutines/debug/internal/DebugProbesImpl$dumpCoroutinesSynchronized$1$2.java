package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, java.lang.Boolean> {
    public static final kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    public DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ java.lang.Boolean invoke(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return java.lang.Boolean.valueOf(invoke2(coroutineOwner));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(@org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return !kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.j(coroutineOwner);
    }
}
