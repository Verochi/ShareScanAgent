package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lkotlin/text/Charsets;", "", "Ljava/nio/charset/Charset;", "UTF_8", "Ljava/nio/charset/Charset;", "UTF_16", "UTF_16BE", "UTF_16LE", "US_ASCII", "ISO_8859_1", "a", "utf_32", "b", "utf_32le", "c", "utf_32be", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF32_LE", "UTF_32LE", "UTF32_BE", "UTF_32BE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class Charsets {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.Charsets INSTANCE = new kotlin.text.Charsets();

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset ISO_8859_1;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset US_ASCII;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset UTF_16;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset UTF_16BE;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset UTF_16LE;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final java.nio.charset.Charset UTF_8;

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static java.nio.charset.Charset utf_32;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static java.nio.charset.Charset utf_32le;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static java.nio.charset.Charset utf_32be;

    static {
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("UTF-8");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        UTF_8 = forName;
        java.nio.charset.Charset forName2 = java.nio.charset.Charset.forName("UTF-16");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName2, "forName(\"UTF-16\")");
        UTF_16 = forName2;
        java.nio.charset.Charset forName3 = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.UTF_16BE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName3, "forName(\"UTF-16BE\")");
        UTF_16BE = forName3;
        java.nio.charset.Charset forName4 = java.nio.charset.Charset.forName("UTF-16LE");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName4, "forName(\"UTF-16LE\")");
        UTF_16LE = forName4;
        java.nio.charset.Charset forName5 = java.nio.charset.Charset.forName("US-ASCII");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName5, "forName(\"US-ASCII\")");
        US_ASCII = forName5;
        java.nio.charset.Charset forName6 = java.nio.charset.Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName6, "forName(\"ISO-8859-1\")");
        ISO_8859_1 = forName6;
    }

    @kotlin.jvm.JvmName(name = "UTF32")
    @org.jetbrains.annotations.NotNull
    public final java.nio.charset.Charset UTF32() {
        java.nio.charset.Charset charset = utf_32;
        if (charset != null) {
            return charset;
        }
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("UTF-32");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32\")");
        utf_32 = forName;
        return forName;
    }

    @kotlin.jvm.JvmName(name = "UTF32_BE")
    @org.jetbrains.annotations.NotNull
    public final java.nio.charset.Charset UTF32_BE() {
        java.nio.charset.Charset charset = utf_32be;
        if (charset != null) {
            return charset;
        }
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("UTF-32BE");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32BE\")");
        utf_32be = forName;
        return forName;
    }

    @kotlin.jvm.JvmName(name = "UTF32_LE")
    @org.jetbrains.annotations.NotNull
    public final java.nio.charset.Charset UTF32_LE() {
        java.nio.charset.Charset charset = utf_32le;
        if (charset != null) {
            return charset;
        }
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("UTF-32LE");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32LE\")");
        utf_32le = forName;
        return forName;
    }
}
