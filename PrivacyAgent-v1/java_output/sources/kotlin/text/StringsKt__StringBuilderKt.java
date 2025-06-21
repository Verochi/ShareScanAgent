package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a1\u0010\u0005\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u0005\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0002\"\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "", "value", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND, "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
class StringsKt__StringBuilderKt extends kotlin.text.StringsKt__StringBuilderJVMKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.StringBuilder append(@org.jetbrains.annotations.NotNull java.lang.StringBuilder sb, @org.jetbrains.annotations.NotNull java.lang.Object... value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sb, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        for (java.lang.Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.StringBuilder append(@org.jetbrains.annotations.NotNull java.lang.StringBuilder sb, @org.jetbrains.annotations.NotNull java.lang.String... value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sb, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        for (java.lang.String str : value) {
            sb.append(str);
        }
        return sb;
    }
}
