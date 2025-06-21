package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> {
    final /* synthetic */ java.lang.reflect.Constructor $constructor$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(java.lang.reflect.Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable invoke(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        java.lang.Object m156constructorimpl;
        java.lang.Object newInstance;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            newInstance = this.$constructor$inlined.newInstance(th);
        } catch (java.lang.Throwable th2) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th2));
        }
        if (newInstance == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
        m156constructorimpl = kotlin.Result.m156constructorimpl((java.lang.Throwable) newInstance);
        if (kotlin.Result.m162isFailureimpl(m156constructorimpl)) {
            m156constructorimpl = null;
        }
        return (java.lang.Throwable) m156constructorimpl;
    }
}
