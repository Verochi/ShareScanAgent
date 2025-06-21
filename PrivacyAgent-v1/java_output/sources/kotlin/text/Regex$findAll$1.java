package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class Regex$findAll$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.text.MatchResult> {
    final /* synthetic */ java.lang.CharSequence $input;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ kotlin.text.Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.Nullable
    public final kotlin.text.MatchResult invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
