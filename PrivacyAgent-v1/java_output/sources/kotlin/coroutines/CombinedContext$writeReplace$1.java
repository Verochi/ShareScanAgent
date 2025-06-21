package kotlin.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CombinedContext$writeReplace$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<kotlin.Unit, kotlin.coroutines.CoroutineContext.Element, kotlin.Unit> {
    final /* synthetic */ kotlin.coroutines.CoroutineContext[] $elements;
    final /* synthetic */ kotlin.jvm.internal.Ref.IntRef $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(kotlin.coroutines.CoroutineContext[] coroutineContextArr, kotlin.jvm.internal.Ref.IntRef intRef) {
        super(2);
        this.$elements = coroutineContextArr;
        this.$index = intRef;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ kotlin.Unit mo5invoke(kotlin.Unit unit, kotlin.coroutines.CoroutineContext.Element element) {
        invoke2(unit, element);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.NotNull kotlin.Unit unit, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        kotlin.coroutines.CoroutineContext[] coroutineContextArr = this.$elements;
        kotlin.jvm.internal.Ref.IntRef intRef = this.$index;
        int i = intRef.element;
        intRef.element = i + 1;
        coroutineContextArr[i] = element;
    }
}
