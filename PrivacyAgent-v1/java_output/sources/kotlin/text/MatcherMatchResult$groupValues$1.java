package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class MatcherMatchResult$groupValues$1 extends kotlin.collections.AbstractList<java.lang.String> {
    public final /* synthetic */ kotlin.text.MatcherMatchResult n;

    public MatcherMatchResult$groupValues$1(kotlin.text.MatcherMatchResult matcherMatchResult) {
        this.n = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return contains((java.lang.String) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(java.lang.String str) {
        return super.contains((kotlin.text.MatcherMatchResult$groupValues$1) str);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @org.jetbrains.annotations.NotNull
    public java.lang.String get(int index) {
        java.util.regex.MatchResult b;
        b = this.n.b();
        java.lang.String group = b.group(index);
        return group == null ? "" : group;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int getCom.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE java.lang.String() {
        java.util.regex.MatchResult b;
        b = this.n.b();
        return b.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return indexOf((java.lang.String) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(java.lang.String str) {
        return super.indexOf((kotlin.text.MatcherMatchResult$groupValues$1) str);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return lastIndexOf((java.lang.String) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(java.lang.String str) {
        return super.lastIndexOf((kotlin.text.MatcherMatchResult$groupValues$1) str);
    }
}
