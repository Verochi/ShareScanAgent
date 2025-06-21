package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/text/SystemProperties;", "", "", "b", "Ljava/lang/String;", "LINE_SEPARATOR", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class SystemProperties {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.SystemProperties a = new kotlin.text.SystemProperties();

    /* renamed from: b, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LINE_SEPARATOR;

    static {
        java.lang.String property = java.lang.System.getProperty("line.separator");
        kotlin.jvm.internal.Intrinsics.checkNotNull(property);
        LINE_SEPARATOR = property;
    }
}
