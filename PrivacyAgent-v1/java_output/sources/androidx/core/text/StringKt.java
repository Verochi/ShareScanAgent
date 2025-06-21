package androidx.core.text;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, d2 = {"htmlEncode", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class StringKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String htmlEncode(@org.jetbrains.annotations.NotNull java.lang.String htmlEncode) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(htmlEncode, "$this$htmlEncode");
        java.lang.String htmlEncode2 = android.text.TextUtils.htmlEncode(htmlEncode);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(htmlEncode2, "TextUtils.htmlEncode(this)");
        return htmlEncode2;
    }
}
