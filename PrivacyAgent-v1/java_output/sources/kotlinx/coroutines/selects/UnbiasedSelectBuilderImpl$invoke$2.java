package kotlinx.coroutines.selects;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H\n"}, d2 = {"Q", "R", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class UnbiasedSelectBuilderImpl$invoke$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    final /* synthetic */ kotlin.jvm.functions.Function2<Q, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $block;
    final /* synthetic */ kotlinx.coroutines.selects.SelectClause1<Q> $this_invoke;
    final /* synthetic */ kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnbiasedSelectBuilderImpl$invoke$2(kotlinx.coroutines.selects.SelectClause1<? extends Q> selectClause1, kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        super(0);
        this.$this_invoke = selectClause1;
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_invoke.registerSelectClause1(this.this$0.getInstance(), this.$block);
    }
}
