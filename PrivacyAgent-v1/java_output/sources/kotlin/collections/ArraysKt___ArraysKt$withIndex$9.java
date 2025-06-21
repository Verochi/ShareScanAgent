package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ArraysKt___ArraysKt$withIndex$9 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<java.util.Iterator<? extends java.lang.Character>> {
    final /* synthetic */ char[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$9(char[] cArr) {
        super(0);
        this.$this_withIndex = cArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<? extends java.lang.Character> invoke() {
        return kotlin.jvm.internal.ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
