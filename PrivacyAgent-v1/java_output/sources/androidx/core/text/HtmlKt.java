package androidx.core.text;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class HtmlKt {
    @org.jetbrains.annotations.NotNull
    public static final android.text.Spanned parseAsHtml(@org.jetbrains.annotations.NotNull java.lang.String parseAsHtml, int i, @org.jetbrains.annotations.Nullable android.text.Html.ImageGetter imageGetter, @org.jetbrains.annotations.Nullable android.text.Html.TagHandler tagHandler) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(parseAsHtml, "$this$parseAsHtml");
        android.text.Spanned fromHtml = androidx.core.text.HtmlCompat.fromHtml(parseAsHtml, i, imageGetter, tagHandler);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ android.text.Spanned parseAsHtml$default(java.lang.String parseAsHtml, int i, android.text.Html.ImageGetter imageGetter, android.text.Html.TagHandler tagHandler, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(parseAsHtml, "$this$parseAsHtml");
        android.text.Spanned fromHtml = androidx.core.text.HtmlCompat.fromHtml(parseAsHtml, i, imageGetter, tagHandler);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String toHtml(@org.jetbrains.annotations.NotNull android.text.Spanned toHtml, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toHtml, "$this$toHtml");
        java.lang.String html = androidx.core.text.HtmlCompat.toHtml(toHtml, i);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ java.lang.String toHtml$default(android.text.Spanned toHtml, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toHtml, "$this$toHtml");
        java.lang.String html = androidx.core.text.HtmlCompat.toHtml(toHtml, i);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
