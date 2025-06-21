package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes22.dex */
final class TtmlRenderUtil {
    public static void a(android.text.Spannable spannable, int i, int i2, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map) {
        com.google.android.exoplayer2.text.ttml.TtmlNode e;
        if (ttmlStyle.j() != -1) {
            spannable.setSpan(new android.text.style.StyleSpan(ttmlStyle.j()), i, i2, 33);
        }
        if (ttmlStyle.p()) {
            spannable.setSpan(new android.text.style.StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.q()) {
            spannable.setSpan(new android.text.style.UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.n()) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.ForegroundColorSpan(ttmlStyle.c()), i, i2, 33);
        }
        if (ttmlStyle.m()) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.BackgroundColorSpan(ttmlStyle.b()), i, i2, 33);
        }
        if (ttmlStyle.d() != null) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.TypefaceSpan(ttmlStyle.d()), i, i2, 33);
        }
        int i3 = ttmlStyle.i();
        if (i3 == 2) {
            com.google.android.exoplayer2.text.ttml.TtmlNode d = d(ttmlNode, map);
            if (d != null && (e = e(d, map)) != null) {
                if (e.g() != 1 || e.f(0).b == null) {
                    com.google.android.exoplayer2.util.Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(e.f(0).b);
                    com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle2 = d.f;
                    spannable.setSpan(new com.google.android.exoplayer2.text.span.RubySpan(str, ttmlStyle2 != null ? ttmlStyle2.h() : -1), i, i2, 33);
                }
            }
        } else if (i3 == 3 || i3 == 4) {
            spannable.setSpan(new com.google.android.exoplayer2.text.ttml.DeleteTextSpan(), i, i2, 33);
        }
        if (ttmlStyle.l()) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan(), i, i2, 33);
        }
        int f = ttmlStyle.f();
        if (f == 1) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.AbsoluteSizeSpan((int) ttmlStyle.e(), true), i, i2, 33);
        } else if (f == 2) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.RelativeSizeSpan(ttmlStyle.e()), i, i2, 33);
        } else {
            if (f != 3) {
                return;
            }
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannable, new android.text.style.RelativeSizeSpan(ttmlStyle.e() / 100.0f), i, i2, 33);
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(android.text.SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ttml.TtmlNode d(@androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map) {
        while (ttmlNode != null) {
            com.google.android.exoplayer2.text.ttml.TtmlStyle f = f(ttmlNode.f, ttmlNode.l(), map);
            if (f != null && f.i() == 1) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.j;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ttml.TtmlNode e(com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map) {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        arrayDeque.push(ttmlNode);
        while (!arrayDeque.isEmpty()) {
            com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode2 = (com.google.android.exoplayer2.text.ttml.TtmlNode) arrayDeque.pop();
            com.google.android.exoplayer2.text.ttml.TtmlStyle f = f(ttmlNode2.f, ttmlNode2.l(), map);
            if (f != null && f.i() == 3) {
                return ttmlNode2;
            }
            for (int g = ttmlNode2.g() - 1; g >= 0; g--) {
                arrayDeque.push(ttmlNode2.f(g));
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ttml.TtmlStyle f(@androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, @androidx.annotation.Nullable java.lang.String[] strArr, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle2 = new com.google.android.exoplayer2.text.ttml.TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.a(map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return ttmlStyle.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }
}
