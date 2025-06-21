package androidx.core.text;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    private HtmlCompat() {
    }

    @androidx.annotation.NonNull
    public static android.text.Spanned fromHtml(@androidx.annotation.NonNull java.lang.String str, int i) {
        android.text.Spanned fromHtml;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return android.text.Html.fromHtml(str);
        }
        fromHtml = android.text.Html.fromHtml(str, i);
        return fromHtml;
    }

    @androidx.annotation.NonNull
    public static android.text.Spanned fromHtml(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.Nullable android.text.Html.ImageGetter imageGetter, @androidx.annotation.Nullable android.text.Html.TagHandler tagHandler) {
        android.text.Spanned fromHtml;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return android.text.Html.fromHtml(str, imageGetter, tagHandler);
        }
        fromHtml = android.text.Html.fromHtml(str, i, imageGetter, tagHandler);
        return fromHtml;
    }

    @androidx.annotation.NonNull
    public static java.lang.String toHtml(@androidx.annotation.NonNull android.text.Spanned spanned, int i) {
        java.lang.String html;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return android.text.Html.toHtml(spanned);
        }
        html = android.text.Html.toHtml(spanned, i);
        return html;
    }
}
