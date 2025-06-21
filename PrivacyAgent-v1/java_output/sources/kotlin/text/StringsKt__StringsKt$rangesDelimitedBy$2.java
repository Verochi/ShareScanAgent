package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<? extends java.lang.Integer, ? extends java.lang.Integer>> {
    final /* synthetic */ java.util.List<java.lang.String> $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(java.util.List<java.lang.String> list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ kotlin.Pair<? extends java.lang.Integer, ? extends java.lang.Integer> mo5invoke(java.lang.CharSequence charSequence, java.lang.Integer num) {
        return invoke(charSequence, num.intValue());
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> invoke(@org.jetbrains.annotations.NotNull java.lang.CharSequence $receiver, int i) {
        kotlin.Pair c;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        c = kotlin.text.StringsKt__StringsKt.c($receiver, this.$delimitersList, i, this.$ignoreCase, false);
        if (c != null) {
            return kotlin.TuplesKt.to(c.getFirst(), java.lang.Integer.valueOf(((java.lang.String) c.getSecond()).length()));
        }
        return null;
    }
}
