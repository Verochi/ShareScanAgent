package com.google.android.exoplayer2.text.span;

/* loaded from: classes22.dex */
public final class SpanUtil {
    public static void addOrReplaceSpan(android.text.Spannable spannable, java.lang.Object obj, int i, int i2, int i3) {
        for (java.lang.Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }
}
