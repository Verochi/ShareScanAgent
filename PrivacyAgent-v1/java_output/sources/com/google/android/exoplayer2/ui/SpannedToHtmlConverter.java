package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class SpannedToHtmlConverter {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("(&#13;)?&#10;");

    public static class HtmlAndCss {
        public final java.util.Map<java.lang.String, java.lang.String> cssRuleSets;
        public final java.lang.String html;

        public HtmlAndCss(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
            this.html = str;
            this.cssRuleSets = map;
        }

        public /* synthetic */ HtmlAndCss(java.lang.String str, java.util.Map map, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.AnonymousClass1 anonymousClass1) {
            this(str, map);
        }
    }

    public static final class SpanInfo {
        public static final java.util.Comparator<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo> e = new com.google.android.exoplayer2.ui.a();
        public static final java.util.Comparator<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo> f = new com.google.android.exoplayer2.ui.b();
        public final int a;
        public final int b;
        public final java.lang.String c;
        public final java.lang.String d;

        public SpanInfo(int i, int i2, java.lang.String str, java.lang.String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        public /* synthetic */ SpanInfo(int i, int i2, java.lang.String str, java.lang.String str2, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.AnonymousClass1 anonymousClass1) {
            this(i, i2, str, str2);
        }

        public static /* synthetic */ int e(com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo spanInfo, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo spanInfo2) {
            int compare = java.lang.Integer.compare(spanInfo2.b, spanInfo.b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo.c.compareTo(spanInfo2.c);
            return compareTo != 0 ? compareTo : spanInfo.d.compareTo(spanInfo2.d);
        }

        public static /* synthetic */ int f(com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo spanInfo, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo spanInfo2) {
            int compare = java.lang.Integer.compare(spanInfo2.a, spanInfo.a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo2.c.compareTo(spanInfo.c);
            return compareTo != 0 ? compareTo : spanInfo2.d.compareTo(spanInfo.d);
        }
    }

    public static final class Transition {
        public final java.util.List<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo> a = new java.util.ArrayList();
        public final java.util.List<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo> b = new java.util.ArrayList();
    }

    public static com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss a(@androidx.annotation.Nullable java.lang.CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss("", com.google.common.collect.ImmutableMap.of(), null);
        }
        if (!(charSequence instanceof android.text.Spanned)) {
            return new com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss(b(charSequence), com.google.common.collect.ImmutableMap.of(), null);
        }
        android.text.Spanned spanned = (android.text.Spanned) charSequence;
        java.util.HashSet hashSet = new java.util.HashSet();
        int i = 0;
        for (android.text.style.BackgroundColorSpan backgroundColorSpan : (android.text.style.BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), android.text.style.BackgroundColorSpan.class)) {
            hashSet.add(java.lang.Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((java.lang.Integer) it.next()).intValue();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(14);
            sb.append("bg_");
            sb.append(intValue);
            hashMap.put(com.google.android.exoplayer2.ui.HtmlUtils.a(sb.toString()), com.google.android.exoplayer2.util.Util.formatInvariant("background-color:%s;", com.google.android.exoplayer2.ui.HtmlUtils.b(intValue)));
        }
        android.util.SparseArray<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition> c = c(spanned, f);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(spanned.length());
        int i2 = 0;
        while (i < c.size()) {
            int keyAt = c.keyAt(i);
            sb2.append(b(spanned.subSequence(i2, keyAt)));
            com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition transition = c.get(keyAt);
            java.util.Collections.sort(transition.b, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo.f);
            java.util.Iterator it2 = transition.b.iterator();
            while (it2.hasNext()) {
                sb2.append(((com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo) it2.next()).d);
            }
            java.util.Collections.sort(transition.a, com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo.e);
            java.util.Iterator it3 = transition.a.iterator();
            while (it3.hasNext()) {
                sb2.append(((com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo) it3.next()).c);
            }
            i++;
            i2 = keyAt;
        }
        sb2.append(b(spanned.subSequence(i2, spanned.length())));
        return new com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss(sb2.toString(), hashMap, null);
    }

    public static java.lang.String b(java.lang.CharSequence charSequence) {
        return a.matcher(android.text.Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static android.util.SparseArray<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition> c(android.text.Spanned spanned, float f) {
        android.util.SparseArray<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition> sparseArray = new android.util.SparseArray<>();
        for (java.lang.Object obj : spanned.getSpans(0, spanned.length(), java.lang.Object.class)) {
            java.lang.String e = e(obj, f);
            java.lang.String d = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e != null) {
                com.google.android.exoplayer2.util.Assertions.checkNotNull(d);
                com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo spanInfo = new com.google.android.exoplayer2.ui.SpannedToHtmlConverter.SpanInfo(spanStart, spanEnd, e, d, null);
                f(sparseArray, spanStart).a.add(spanInfo);
                f(sparseArray, spanEnd).b.add(spanInfo);
            }
        }
        return sparseArray;
    }

    @androidx.annotation.Nullable
    public static java.lang.String d(java.lang.Object obj) {
        if ((obj instanceof android.text.style.StrikethroughSpan) || (obj instanceof android.text.style.ForegroundColorSpan) || (obj instanceof android.text.style.BackgroundColorSpan) || (obj instanceof com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan) || (obj instanceof android.text.style.AbsoluteSizeSpan) || (obj instanceof android.text.style.RelativeSizeSpan)) {
            return "</span>";
        }
        if (obj instanceof android.text.style.TypefaceSpan) {
            if (((android.text.style.TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof android.text.style.StyleSpan) {
            int style = ((android.text.style.StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof com.google.android.exoplayer2.text.span.RubySpan) {
                java.lang.String b = b(((com.google.android.exoplayer2.text.span.RubySpan) obj).rubyText);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(b).length() + 16);
                sb.append("<rt>");
                sb.append(b);
                sb.append("</rt></ruby>");
                return sb.toString();
            }
            if (obj instanceof android.text.style.UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.String e(java.lang.Object obj, float f) {
        if (obj instanceof android.text.style.StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof android.text.style.ForegroundColorSpan) {
            return com.google.android.exoplayer2.util.Util.formatInvariant("<span style='color:%s;'>", com.google.android.exoplayer2.ui.HtmlUtils.b(((android.text.style.ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof android.text.style.BackgroundColorSpan) {
            return com.google.android.exoplayer2.util.Util.formatInvariant("<span class='bg_%s'>", java.lang.Integer.valueOf(((android.text.style.BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof android.text.style.AbsoluteSizeSpan) {
            return com.google.android.exoplayer2.util.Util.formatInvariant("<span style='font-size:%.2fpx;'>", java.lang.Float.valueOf(((android.text.style.AbsoluteSizeSpan) obj).getDip() ? r3.getSize() : r3.getSize() / f));
        }
        if (obj instanceof android.text.style.RelativeSizeSpan) {
            return com.google.android.exoplayer2.util.Util.formatInvariant("<span style='font-size:%.2f%%;'>", java.lang.Float.valueOf(((android.text.style.RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof android.text.style.TypefaceSpan) {
            java.lang.String family = ((android.text.style.TypefaceSpan) obj).getFamily();
            if (family != null) {
                return com.google.android.exoplayer2.util.Util.formatInvariant("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof android.text.style.StyleSpan) {
            int style = ((android.text.style.StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof com.google.android.exoplayer2.text.span.RubySpan)) {
            if (obj instanceof android.text.style.UnderlineSpan) {
                return "<u>";
            }
            return null;
        }
        int i = ((com.google.android.exoplayer2.text.span.RubySpan) obj).position;
        if (i == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    public static com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition f(android.util.SparseArray<com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition> sparseArray, int i) {
        com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition transition = sparseArray.get(i);
        if (transition != null) {
            return transition;
        }
        com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition transition2 = new com.google.android.exoplayer2.ui.SpannedToHtmlConverter.Transition();
        sparseArray.put(i, transition2);
        return transition2;
    }
}
