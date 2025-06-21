package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    int label;
    /* synthetic */ java.lang.Object result;
    final /* synthetic */ kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$unsafeFlow$1$collect$1(kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1 safeCollector_commonKt$unsafeFlow$1, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1> continuation) {
        super(continuation);
        this.this$0 = safeCollector_commonKt$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
