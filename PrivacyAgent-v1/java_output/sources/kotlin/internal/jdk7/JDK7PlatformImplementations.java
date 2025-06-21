package kotlin.internal.jdk7;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "", "cause", "exception", "", "addSuppressed", "", "getSuppressed", "", "version", "", "a", "<init>", "()V", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class JDK7PlatformImplementations extends kotlin.internal.PlatformImplementations {

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "", "b", "Ljava/lang/Integer;", com.heytap.mcssdk.constant.b.C, "<init>", "()V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1})
    public static final class ReflectSdkVersion {

        @org.jetbrains.annotations.NotNull
        public static final kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion a = new kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion();

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

    public final boolean a(int version) {
        java.lang.Integer num = kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion.sdkVersion;
        return num == null || num.intValue() >= version;
    }

    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(@org.jetbrains.annotations.NotNull java.lang.Throwable cause, @org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cause, "cause");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        if (a(19)) {
            cause.addSuppressed(exception);
        } else {
            super.addSuppressed(cause, exception);
        }
    }

    @Override // kotlin.internal.PlatformImplementations
    @org.jetbrains.annotations.NotNull
    public java.util.List<java.lang.Throwable> getSuppressed(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        if (!a(19)) {
            return super.getSuppressed(exception);
        }
        java.lang.Throwable[] suppressed = exception.getSuppressed();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(suppressed, "exception.suppressed");
        return kotlin.collections.ArraysKt___ArraysJvmKt.asList(suppressed);
    }
}
