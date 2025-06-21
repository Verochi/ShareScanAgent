package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "old", "new", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Boolean> {
    public static final kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1 INSTANCE = new kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1();

    public FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Boolean mo5invoke(java.lang.Object obj, java.lang.Object obj2) {
        return java.lang.Boolean.valueOf(invoke2(obj, obj2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.Nullable java.lang.Object obj2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(obj, obj2);
    }
}
