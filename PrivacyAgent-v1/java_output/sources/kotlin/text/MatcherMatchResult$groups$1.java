package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class MatcherMatchResult$groups$1 extends kotlin.collections.AbstractCollection<kotlin.text.MatchGroup> implements kotlin.text.MatchNamedGroupCollection {
    public final /* synthetic */ kotlin.text.MatcherMatchResult n;

    public MatcherMatchResult$groups$1(kotlin.text.MatcherMatchResult matcherMatchResult) {
        this.n = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj == null ? true : obj instanceof kotlin.text.MatchGroup) {
            return contains((kotlin.text.MatchGroup) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(kotlin.text.MatchGroup matchGroup) {
        return super.contains((kotlin.text.MatcherMatchResult$groups$1) matchGroup);
    }

    @Override // kotlin.text.MatchGroupCollection
    @org.jetbrains.annotations.Nullable
    public kotlin.text.MatchGroup get(int index) {
        java.util.regex.MatchResult b;
        kotlin.ranges.IntRange d;
        java.util.regex.MatchResult b2;
        b = this.n.b();
        d = kotlin.text.RegexKt.d(b, index);
        if (d.getStart().intValue() < 0) {
            return null;
        }
        b2 = this.n.b();
        java.lang.String group = b2.group(index);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(group, "matchResult.group(index)");
        return new kotlin.text.MatchGroup(group, d);
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    @org.jetbrains.annotations.Nullable
    public kotlin.text.MatchGroup get(@org.jetbrains.annotations.NotNull java.lang.String name) {
        java.util.regex.MatchResult b;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.internal.PlatformImplementations platformImplementations = kotlin.internal.PlatformImplementationsKt.IMPLEMENTATIONS;
        b = this.n.b();
        return platformImplementations.getMatchResultNamedGroup(b, name);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int getCom.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE java.lang.String() {
        java.util.regex.MatchResult b;
        b = this.n.b();
        return b.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<kotlin.text.MatchGroup> iterator() {
        kotlin.ranges.IntRange indices;
        indices = kotlin.collections.CollectionsKt__CollectionsKt.getIndices(this);
        return kotlin.sequences.SequencesKt___SequencesKt.map(kotlin.collections.CollectionsKt___CollectionsKt.asSequence(indices), new kotlin.text.MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}
