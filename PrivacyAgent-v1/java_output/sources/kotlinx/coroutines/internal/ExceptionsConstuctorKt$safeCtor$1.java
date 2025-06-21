package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "e", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> {
    final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstuctorKt$safeCtor$1(kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends java.lang.Throwable> function1) {
        super(1);
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable invoke(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        java.lang.Object m156constructorimpl;
        kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> function1 = this.$block;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(function1.invoke(th));
        } catch (java.lang.Throwable th2) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th2));
        }
        if (kotlin.Result.m162isFailureimpl(m156constructorimpl)) {
            m156constructorimpl = null;
        }
        return (java.lang.Throwable) m156constructorimpl;
    }
}
