package kotlinx.coroutines.selects;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n"}, d2 = {"R", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class UnbiasedSelectBuilderImpl$onTimeout$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    final /* synthetic */ kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object> $block;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnbiasedSelectBuilderImpl$onTimeout$1(kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, long j, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function1) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$timeMillis = j;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getInstance().onTimeout(this.$timeMillis, this.$block);
    }
}
