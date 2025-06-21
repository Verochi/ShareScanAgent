package kotlin.internal.jdk8;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "", "version", "", "a", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/MatchGroup;", "getMatchResultNamedGroup", "Lkotlin/random/Random;", "defaultPlatformRandom", "<init>", "()V", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class JDK8PlatformImplementations extends kotlin.internal.jdk7.JDK7PlatformImplementations {

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "", "b", "Ljava/lang/Integer;", com.heytap.mcssdk.constant.b.C, "<init>", "()V", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 7, 1})
    public static final class ReflectSdkVersion {

        @org.jetbrains.annotations.NotNull
        public static final kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion a = new kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion();

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public static final java.lang.Integer sdkVersion;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        static {
            java.lang.Integer num;
            java.lang.Object obj;
            java.lang.Integer num2 = null;
            try {
                obj = java.lang.Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (java.lang.Throwable unused) {
            }
            if (obj instanceof java.lang.Integer) {
                num = (java.lang.Integer) obj;
                if (num != null) {
                    if (num.intValue() > 0) {
                        num2 = num;
                    }
                }
                sdkVersion = num2;
            }
            num = null;
            if (num != null) {
            }
            sdkVersion = num2;
        }
    }

    private final boolean a(int version) {
        java.lang.Integer num = kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion;
        return num == null || num.intValue() >= version;
    }

    @Override // kotlin.internal.PlatformImplementations
    @org.jetbrains.annotations.NotNull
    public kotlin.random.Random defaultPlatformRandom() {
        return a(24) ? new kotlin.random.jdk8.PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }

    @Override // kotlin.internal.PlatformImplementations
    @org.jetbrains.annotations.Nullable
    public kotlin.text.MatchGroup getMatchResultNamedGroup(@org.jetbrains.annotations.NotNull java.util.regex.MatchResult matchResult, @org.jetbrains.annotations.NotNull java.lang.String name) {
        int start;
        int end;
        java.lang.String group;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.regex.Matcher matcher = matchResult instanceof java.util.regex.Matcher ? (java.util.regex.Matcher) matchResult : null;
        if (matcher == null) {
            throw new java.lang.UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        start = matcher.start(name);
        end = matcher.end(name);
        kotlin.ranges.IntRange intRange = new kotlin.ranges.IntRange(start, end - 1);
        if (intRange.getStart().intValue() < 0) {
            return null;
        }
        group = matcher.group(name);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(group, "matcher.group(name)");
        return new kotlin.text.MatchGroup(group, intRange);
    }
}
