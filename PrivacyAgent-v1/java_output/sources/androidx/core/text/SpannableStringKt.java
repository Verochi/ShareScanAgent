package androidx.core.text;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", com.anythink.expressad.foundation.d.c.bT, "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@org.jetbrains.annotations.NotNull android.text.Spannable clearSpans) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(clearSpans, "$this$clearSpans");
        java.lang.Object[] spans = clearSpans.getSpans(0, clearSpans.length(), java.lang.Object.class);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        for (java.lang.Object obj : spans) {
            clearSpans.removeSpan(obj);
        }
    }

    public static final void set(@org.jetbrains.annotations.NotNull android.text.Spannable set, int i, int i2, @org.jetbrains.annotations.NotNull java.lang.Object span) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(span, "span");
        set.setSpan(span, i, i2, 17);
    }

    public static final void set(@org.jetbrains.annotations.NotNull android.text.Spannable set, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range, @org.jetbrains.annotations.NotNull java.lang.Object span) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(range, "range");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(span, "span");
        set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.text.Spannable toSpannable(@org.jetbrains.annotations.NotNull java.lang.CharSequence toSpannable) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toSpannable, "$this$toSpannable");
        android.text.SpannableString valueOf = android.text.SpannableString.valueOf(toSpannable);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }
}
