package kotlin.text;

@kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class Regex$findAll$2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.text.MatchResult, kotlin.text.MatchResult> {
    public static final kotlin.text.Regex$findAll$2 INSTANCE = new kotlin.text.Regex$findAll$2();

    public Regex$findAll$2() {
        super(1, kotlin.text.MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.Nullable
    public final kotlin.text.MatchResult invoke(@org.jetbrains.annotations.NotNull kotlin.text.MatchResult p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.next();
    }
}
