package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007\u001a\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¨\u0006\u0006"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "clear", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendln", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
class StringsKt__StringBuilderJVMKt extends kotlin.text.StringsKt__RegexExtensionsKt {
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.ReplaceWith(expression = "appendLine()", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Appendable appendln(@org.jetbrains.annotations.NotNull java.lang.Appendable appendable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(appendable, "<this>");
        java.lang.Appendable append = appendable.append(kotlin.text.SystemProperties.LINE_SEPARATOR);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.ReplaceWith(expression = "appendLine()", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final java.lang.StringBuilder appendln(@org.jetbrains.annotations.NotNull java.lang.StringBuilder sb) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(kotlin.text.SystemProperties.LINE_SEPARATOR);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final java.lang.StringBuilder clear(@org.jetbrains.annotations.NotNull java.lang.StringBuilder sb) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setLength(0);
        return sb;
    }
}
