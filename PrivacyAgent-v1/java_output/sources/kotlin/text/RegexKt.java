package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u001a\u001e\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"", "Lkotlin/text/FlagEnum;", "", "e", "Ljava/util/regex/Matcher;", "from", "", "input", "Lkotlin/text/MatchResult;", "a", "b", "Ljava/util/regex/MatchResult;", "Lkotlin/ranges/IntRange;", "c", "groupIndex", "d", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RegexKt {
    public static final kotlin.text.MatchResult a(java.util.regex.Matcher matcher, int i, java.lang.CharSequence charSequence) {
        if (matcher.find(i)) {
            return new kotlin.text.MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final kotlin.text.MatchResult b(java.util.regex.Matcher matcher, java.lang.CharSequence charSequence) {
        if (matcher.matches()) {
            return new kotlin.text.MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final kotlin.ranges.IntRange c(java.util.regex.MatchResult matchResult) {
        kotlin.ranges.IntRange until;
        until = kotlin.ranges.RangesKt___RangesKt.until(matchResult.start(), matchResult.end());
        return until;
    }

    public static final kotlin.ranges.IntRange d(java.util.regex.MatchResult matchResult, int i) {
        kotlin.ranges.IntRange until;
        until = kotlin.ranges.RangesKt___RangesKt.until(matchResult.start(i), matchResult.end(i));
        return until;
    }

    public static final int e(java.lang.Iterable<? extends kotlin.text.FlagEnum> iterable) {
        java.util.Iterator<? extends kotlin.text.FlagEnum> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= it.next().getValue();
        }
        return i;
    }
}
