package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010!¨\u0006%"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "next", "Ljava/util/regex/Matcher;", "a", "Ljava/util/regex/Matcher;", "matcher", "", "b", "Ljava/lang/CharSequence;", "input", "Lkotlin/text/MatchGroupCollection;", "c", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groups", "", "", "d", "Ljava/util/List;", "groupValues_", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "range", "getValue", "()Ljava/lang/String;", "value", "getGroupValues", "()Ljava/util/List;", "groupValues", "Ljava/util/regex/MatchResult;", "()Ljava/util/regex/MatchResult;", "matchResult", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class MatcherMatchResult implements kotlin.text.MatchResult {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.regex.Matcher matcher;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence input;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.text.MatchGroupCollection groups;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.util.List<java.lang.String> groupValues_;

    public MatcherMatchResult(@org.jetbrains.annotations.NotNull java.util.regex.Matcher matcher, @org.jetbrains.annotations.NotNull java.lang.CharSequence input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matcher, "matcher");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new kotlin.text.MatcherMatchResult$groups$1(this);
    }

    public final java.util.regex.MatchResult b() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.NotNull
    public kotlin.text.MatchResult.Destructured getDestructured() {
        return kotlin.text.MatchResult.DefaultImpls.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.NotNull
    public java.util.List<java.lang.String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new kotlin.text.MatcherMatchResult$groupValues$1(this);
        }
        java.util.List<java.lang.String> list = this.groupValues_;
        kotlin.jvm.internal.Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.NotNull
    public kotlin.text.MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.NotNull
    public kotlin.ranges.IntRange getRange() {
        kotlin.ranges.IntRange c;
        c = kotlin.text.RegexKt.c(b());
        return c;
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.NotNull
    public java.lang.String getValue() {
        java.lang.String group = b().group();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @org.jetbrains.annotations.Nullable
    public kotlin.text.MatchResult next() {
        kotlin.text.MatchResult a;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end > this.input.length()) {
            return null;
        }
        java.util.regex.Matcher matcher = this.matcher.pattern().matcher(this.input);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        a = kotlin.text.RegexKt.a(matcher, end, this.input);
        return a;
    }
}
