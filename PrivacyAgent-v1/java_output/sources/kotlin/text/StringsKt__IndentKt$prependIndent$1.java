package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class StringsKt__IndentKt$prependIndent$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> {
    final /* synthetic */ java.lang.String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$prependIndent$1(java.lang.String str) {
        super(1);
        this.$indent = str;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.lang.String invoke(@org.jetbrains.annotations.NotNull java.lang.String it) {
        boolean isBlank;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        isBlank = kotlin.text.StringsKt__StringsJVMKt.isBlank(it);
        if (isBlank) {
            return it.length() < this.$indent.length() ? this.$indent : it;
        }
        return this.$indent + it;
    }
}
