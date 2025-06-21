package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class DebugProbesImpl$startWeakRefCleanerThread$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    public static final kotlinx.coroutines.debug.internal.DebugProbesImpl$startWeakRefCleanerThread$1 INSTANCE = new kotlinx.coroutines.debug.internal.DebugProbesImpl$startWeakRefCleanerThread$1();

    public DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        kotlinx.coroutines.debug.internal.ConcurrentWeakMap concurrentWeakMap;
        concurrentWeakMap = kotlinx.coroutines.debug.internal.DebugProbesImpl.callerInfoCache;
        concurrentWeakMap.runWeakRefQueueCleaningLoopUntilInterrupted();
    }
}
