package androidx.core.text.util;

/* loaded from: classes.dex */
public final class LinkifyCompat {
    private static final java.lang.String[] EMPTY_STRING = new java.lang.String[0];
    private static final java.util.Comparator<androidx.core.text.util.LinkifyCompat.LinkSpec> COMPARATOR = new androidx.core.text.util.LinkifyCompat.AnonymousClass1();

    /* renamed from: androidx.core.text.util.LinkifyCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<androidx.core.text.util.LinkifyCompat.LinkSpec> {
        @Override // java.util.Comparator
        public int compare(androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec, androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec2) {
            int i;
            int i2;
            int i3 = linkSpec.start;
            int i4 = linkSpec2.start;
            if (i3 < i4) {
                return -1;
            }
            if (i3 <= i4 && (i = linkSpec.end) >= (i2 = linkSpec2.end)) {
                return i > i2 ? -1 : 0;
            }
            return 1;
        }
    }

    public static class LinkSpec {
        int end;
        android.text.style.URLSpan frameworkAddedSpan;
        int start;
        java.lang.String url;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@androidx.annotation.NonNull android.widget.TextView textView) {
        if ((textView.getMovementMethod() instanceof android.text.method.LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }

    public static void addLinks(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str) {
        if (shouldAddLinksFallbackToFramework()) {
            android.text.util.Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (java.lang.String[]) null, (android.text.util.Linkify.MatchFilter) null, (android.text.util.Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            android.text.util.Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (java.lang.String[]) null, matchFilter, transformFilter);
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void addLinks(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            android.text.util.Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        android.text.SpannableString valueOf = android.text.SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return android.text.util.Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        android.text.style.URLSpan[] uRLSpanArr = (android.text.style.URLSpan[]) spannable.getSpans(0, spannable.length(), android.text.style.URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            android.text.util.Linkify.addLinks(spannable, 4);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, androidx.core.util.PatternsCompat.AUTOLINK_WEB_URL, new java.lang.String[]{"http://", "https://", "rtsp://"}, android.text.util.Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, androidx.core.util.PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new java.lang.String[]{androidx.core.net.MailTo.MAILTO_SCHEME}, null, null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec = (androidx.core.text.util.LinkifyCompat.LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    public static boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str) {
        return shouldAddLinksFallbackToFramework() ? android.text.util.Linkify.addLinks(spannable, pattern, str) : addLinks(spannable, pattern, str, (java.lang.String[]) null, (android.text.util.Linkify.MatchFilter) null, (android.text.util.Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        return shouldAddLinksFallbackToFramework() ? android.text.util.Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : addLinks(spannable, pattern, str, (java.lang.String[]) null, matchFilter, transformFilter);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        boolean addLinks;
        if (shouldAddLinksFallbackToFramework()) {
            addLinks = android.text.util.Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
            return addLinks;
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(java.util.Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            java.lang.String str2 = strArr[i];
            i++;
            strArr2[i] = str2 == null ? "" : str2.toLowerCase(java.util.Locale.ROOT);
        }
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z = true;
            }
        }
        return z;
    }

    public static boolean addLinks(@androidx.annotation.NonNull android.widget.TextView textView, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return android.text.util.Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        java.lang.CharSequence text = textView.getText();
        if (text instanceof android.text.Spannable) {
            if (!addLinks((android.text.Spannable) text, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        android.text.SpannableString valueOf = android.text.SpannableString.valueOf(text);
        if (!addLinks(valueOf, i)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(valueOf);
        return true;
    }

    private static void applyLink(java.lang.String str, int i, int i2, android.text.Spannable spannable) {
        spannable.setSpan(new android.text.style.URLSpan(str), i, i2, 33);
    }

    private static java.lang.String findAddress(java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 28 ? android.webkit.WebView.findAddress(str) : androidx.core.text.util.FindAddress.findAddress(str);
    }

    private static void gatherLinks(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable, java.util.regex.Pattern pattern, java.lang.String[] strArr, android.text.util.Linkify.MatchFilter matchFilter, android.text.util.Linkify.TransformFilter transformFilter) {
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec = new androidx.core.text.util.LinkifyCompat.LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = start;
                linkSpec.end = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherMapLinks(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable) {
        int indexOf;
        java.lang.String obj = spannable.toString();
        int i = 0;
        while (true) {
            try {
                java.lang.String findAddress = findAddress(obj);
                if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                    androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec = new androidx.core.text.util.LinkifyCompat.LinkSpec();
                    int length = findAddress.length() + indexOf;
                    linkSpec.start = indexOf + i;
                    i += length;
                    linkSpec.end = i;
                    obj = obj.substring(length);
                    try {
                        linkSpec.url = "geo:0,0?q=" + java.net.URLEncoder.encode(findAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (java.io.UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (java.lang.UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static java.lang.String makeUrl(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String[] strArr, java.util.regex.Matcher matcher, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                z = false;
                break;
            }
            java.lang.String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                java.lang.String str3 = strArr[i];
                z = true;
                if (!str.regionMatches(false, 0, str3, 0, str3.length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                }
            } else {
                i++;
            }
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void pruneOverlaps(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable) {
        int i;
        int i2 = 0;
        android.text.style.URLSpan[] uRLSpanArr = (android.text.style.URLSpan[]) spannable.getSpans(0, spannable.length(), android.text.style.URLSpan.class);
        for (int i3 = 0; i3 < uRLSpanArr.length; i3++) {
            androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec = new androidx.core.text.util.LinkifyCompat.LinkSpec();
            android.text.style.URLSpan uRLSpan = uRLSpanArr[i3];
            linkSpec.frameworkAddedSpan = uRLSpan;
            linkSpec.start = spannable.getSpanStart(uRLSpan);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i3]);
            arrayList.add(linkSpec);
        }
        java.util.Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i2 < size - 1) {
            androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec2 = arrayList.get(i2);
            int i4 = i2 + 1;
            androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec3 = arrayList.get(i4);
            int i5 = linkSpec2.start;
            int i6 = linkSpec3.start;
            if (i5 <= i6 && (i = linkSpec2.end) > i6) {
                int i7 = linkSpec3.end;
                int i8 = (i7 > i && i - i5 <= i7 - i6) ? i - i5 < i7 - i6 ? i2 : -1 : i4;
                if (i8 != -1) {
                    java.lang.Object obj = arrayList.get(i8).frameworkAddedSpan;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i8);
                    size--;
                }
            }
            i2 = i4;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return android.os.Build.VERSION.SDK_INT >= 28;
    }
}
