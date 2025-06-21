package kotlinx.coroutines;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {org.apache.tools.tar.TarConstants.PREFIXLEN}, m = "awaitCancellation", n = {}, s = {})
/* loaded from: classes15.dex */
public final class DelayKt$awaitCancellation$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    int label;
    /* synthetic */ java.lang.Object result;

    public DelayKt$awaitCancellation$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.DelayKt$awaitCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return kotlinx.coroutines.DelayKt.awaitCancellation(this);
    }
}
