package kotlin.text.jdk8;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, pn = "kotlin.text", xi = 48)
@kotlin.jvm.JvmName(name = "RegexExtensionsJDK8Kt")
/* loaded from: classes14.dex */
public final class RegexExtensionsJDK8Kt {
    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.Nullable
    public static final kotlin.text.MatchGroup get(@org.jetbrains.annotations.NotNull kotlin.text.MatchGroupCollection matchGroupCollection, @org.jetbrains.annotations.NotNull java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matchGroupCollection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.text.MatchNamedGroupCollection matchNamedGroupCollection = matchGroupCollection instanceof kotlin.text.MatchNamedGroupCollection ? (kotlin.text.MatchNamedGroupCollection) matchGroupCollection : null;
        if (matchNamedGroupCollection != null) {
            return matchNamedGroupCollection.get(name);
        }
        throw new java.lang.UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
