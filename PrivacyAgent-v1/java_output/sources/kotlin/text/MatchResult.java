package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface MatchResult {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @org.jetbrains.annotations.NotNull
        public static kotlin.text.MatchResult.Destructured getDestructured(@org.jetbrains.annotations.NotNull kotlin.text.MatchResult matchResult) {
            return new kotlin.text.MatchResult.Destructured(matchResult);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/text/MatchResult$Destructured;", "", "", "", "toList", "Lkotlin/text/MatchResult;", "a", "Lkotlin/text/MatchResult;", "getMatch", "()Lkotlin/text/MatchResult;", "match", "<init>", "(Lkotlin/text/MatchResult;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class Destructured {

        /* renamed from: a, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlin.text.MatchResult match;

        public Destructured(@org.jetbrains.annotations.NotNull kotlin.text.MatchResult match) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(match, "match");
            this.match = match;
        }

        @org.jetbrains.annotations.NotNull
        public final kotlin.text.MatchResult getMatch() {
            return this.match;
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlin.text.MatchResult.Destructured getDestructured();

    @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> getGroupValues();

    @org.jetbrains.annotations.NotNull
    kotlin.text.MatchGroupCollection getGroups();

    @org.jetbrains.annotations.NotNull
    kotlin.ranges.IntRange getRange();

    @org.jetbrains.annotations.NotNull
    java.lang.String getValue();

    @org.jetbrains.annotations.Nullable
    kotlin.text.MatchResult next();
}
