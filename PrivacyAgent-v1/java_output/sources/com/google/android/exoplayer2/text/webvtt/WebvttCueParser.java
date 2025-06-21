package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
public final class WebvttCueParser {
    public static final java.util.regex.Pattern CUE_HEADER_PATTERN = java.util.regex.Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("(\\S+?):(\\S+)");
    public static final java.util.Map<java.lang.String, java.lang.Integer> b;
    public static final java.util.Map<java.lang.String, java.lang.Integer> c;

    public static class Element {
        public static final java.util.Comparator<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element> c = new com.google.android.exoplayer2.text.webvtt.a();
        public final com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag a;
        public final int b;

        public Element(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag, int i) {
            this.a = startTag;
            this.b = i;
        }

        public /* synthetic */ Element(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag, int i, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.AnonymousClass1 anonymousClass1) {
            this(startTag, i);
        }

        public static /* synthetic */ int e(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element element, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element element2) {
            return java.lang.Integer.compare(element.a.b, element2.a.b);
        }
    }

    public static final class StartTag {
        public final java.lang.String a;
        public final int b;
        public final java.lang.String c;
        public final java.util.Set<java.lang.String> d;

        public StartTag(java.lang.String str, int i, java.lang.String str2, java.util.Set<java.lang.String> set) {
            this.b = i;
            this.a = str;
            this.c = str2;
            this.d = set;
        }

        public static com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag a(java.lang.String str, int i) {
            java.lang.String str2;
            java.lang.String trim = str.trim();
            com.google.android.exoplayer2.util.Assertions.checkArgument(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                java.lang.String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(trim, "\\.");
            java.lang.String str3 = split[0];
            java.util.HashSet hashSet = new java.util.HashSet();
            for (int i2 = 1; i2 < split.length; i2++) {
                hashSet.add(split[i2]);
            }
            return new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag(str3, i, str2, hashSet);
        }

        public static com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag b() {
            return new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag("", 0, "", java.util.Collections.emptySet());
        }
    }

    public static final class StyleMatch implements java.lang.Comparable<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> {
        public final int n;
        public final com.google.android.exoplayer2.text.webvtt.WebvttCssStyle t;

        public StyleMatch(int i, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle) {
            this.n = i;
            this.t = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch styleMatch) {
            return java.lang.Integer.compare(this.n, styleMatch.n);
        }
    }

    public static final class WebvttCueInfoBuilder {
        public java.lang.CharSequence c;
        public long a = 0;
        public long b = 0;
        public int d = 2;
        public float e = -3.4028235E38f;
        public int f = 1;
        public int g = 0;
        public float h = -3.4028235E38f;
        public int i = Integer.MIN_VALUE;
        public float j = 1.0f;
        public int k = Integer.MIN_VALUE;

        public static float b(float f, int i) {
            if (f == -3.4028235E38f || i != 0 || (f >= 0.0f && f <= 1.0f)) {
                return f != -3.4028235E38f ? f : i == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        @androidx.annotation.Nullable
        public static android.text.Layout.Alignment c(int i) {
            if (i != 1) {
                if (i == 2) {
                    return android.text.Layout.Alignment.ALIGN_CENTER;
                }
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(34);
                            sb.append("Unknown textAlignment: ");
                            sb.append(i);
                            com.google.android.exoplayer2.util.Log.w("WebvttCueParser", sb.toString());
                            return null;
                        }
                    }
                }
                return android.text.Layout.Alignment.ALIGN_OPPOSITE;
            }
            return android.text.Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i, float f) {
            if (i == 0) {
                return 1.0f - f;
            }
            if (i == 1) {
                return f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            }
            if (i == 2) {
                return f;
            }
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(i));
        }

        public static float e(int i) {
            if (i != 4) {
                return i != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return i != 5 ? 1 : 2;
            }
            return 0;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCueInfo a() {
            return new com.google.android.exoplayer2.text.webvtt.WebvttCueInfo(g().build(), this.a, this.b);
        }

        public com.google.android.exoplayer2.text.Cue.Builder g() {
            float f = this.h;
            if (f == -3.4028235E38f) {
                f = e(this.d);
            }
            int i = this.i;
            if (i == Integer.MIN_VALUE) {
                i = f(this.d);
            }
            com.google.android.exoplayer2.text.Cue.Builder verticalType = new com.google.android.exoplayer2.text.Cue.Builder().setTextAlignment(c(this.d)).setLine(b(this.e, this.f), this.f).setLineAnchor(this.g).setPosition(f).setPositionAnchor(i).setSize(java.lang.Math.min(this.j, d(i, f))).setVerticalType(this.k);
            java.lang.CharSequence charSequence = this.c;
            if (charSequence != null) {
                verticalType.setText(charSequence);
            }
            return verticalType;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("white", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 255, 255)));
        hashMap.put("lime", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 255, 0)));
        hashMap.put("cyan", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 255, 255)));
        hashMap.put("red", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 0, 0)));
        hashMap.put("yellow", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 255, 0)));
        hashMap.put("magenta", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 0, 255)));
        hashMap.put("blue", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 0, 255)));
        hashMap.put("black", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 0, 0)));
        b = java.util.Collections.unmodifiableMap(hashMap);
        java.util.HashMap hashMap2 = new java.util.HashMap();
        hashMap2.put("bg_white", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", java.lang.Integer.valueOf(android.graphics.Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", java.lang.Integer.valueOf(android.graphics.Color.rgb(0, 0, 0)));
        c = java.util.Collections.unmodifiableMap(hashMap2);
    }

    public static void a(android.text.SpannableStringBuilder spannableStringBuilder, java.util.Set<java.lang.String> set, int i, int i2) {
        for (java.lang.String str : set) {
            java.util.Map<java.lang.String, java.lang.Integer> map = b;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(map.get(str).intValue()), i, i2, 33);
            } else {
                java.util.Map<java.lang.String, java.lang.Integer> map2 = c;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(map2.get(str).intValue()), i, i2, 33);
                }
            }
        }
    }

    public static void b(java.lang.String str, android.text.SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        switch (str) {
            case "gt":
                spannableStringBuilder.append(kotlin.text.Typography.greater);
                break;
            case "lt":
                spannableStringBuilder.append(kotlin.text.Typography.less);
                break;
            case "amp":
                spannableStringBuilder.append(kotlin.text.Typography.amp);
                break;
            case "nbsp":
                spannableStringBuilder.append(' ');
                break;
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 33);
                sb.append("ignoring unsupported entity: '&");
                sb.append(str);
                sb.append(";'");
                com.google.android.exoplayer2.util.Log.w("WebvttCueParser", sb.toString());
                break;
        }
    }

    public static void c(android.text.SpannableStringBuilder spannableStringBuilder, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element> list, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list2) {
        int i = i(list2, str, startTag);
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        arrayList.addAll(list);
        java.util.Collections.sort(arrayList, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element.c);
        int i2 = startTag.b;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(((com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element) arrayList.get(i4)).a.a)) {
                com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element element = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element) arrayList.get(i4);
                int g = g(i(list2, str, element.a), i, 1);
                int i5 = element.a.b - i3;
                int i6 = element.b - i3;
                java.lang.CharSequence subSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new com.google.android.exoplayer2.text.span.RubySpan(subSequence.toString(), g), i2, i5, 33);
                i3 += subSequence.length();
                i2 = i5;
            }
        }
    }

    public static void d(@androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element> list, android.text.SpannableStringBuilder spannableStringBuilder, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list2) {
        int i;
        int length;
        i = startTag.b;
        length = spannableStringBuilder.length();
        java.lang.String str2 = startTag.a;
        str2.hashCode();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new android.text.style.StyleSpan(1), i, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, startTag.d, i, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), i, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i, length, 33);
                break;
            case "ruby":
                c(spannableStringBuilder, str, startTag, list, list2);
                break;
            default:
                return;
        }
        java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> h = h(list2, str, startTag);
        for (int i2 = 0; i2 < h.size(); i2++) {
            e(spannableStringBuilder, h.get(i2).t, i, length);
        }
    }

    public static void e(android.text.SpannableStringBuilder spannableStringBuilder, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, int i, int i2) {
        if (webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.getStyle() != -1) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.StyleSpan(webvttCssStyle.getStyle()), i, i2, 33);
        }
        if (webvttCssStyle.isLinethrough()) {
            spannableStringBuilder.setSpan(new android.text.style.StrikethroughSpan(), i, i2, 33);
        }
        if (webvttCssStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i, i2, 33);
        }
        if (webvttCssStyle.hasFontColor()) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.ForegroundColorSpan(webvttCssStyle.getFontColor()), i, i2, 33);
        }
        if (webvttCssStyle.hasBackgroundColor()) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i, i2, 33);
        }
        if (webvttCssStyle.getFontFamily() != null) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.TypefaceSpan(webvttCssStyle.getFontFamily()), i, i2, 33);
        }
        int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i, i2, 33);
        } else if (fontSizeUnit == 2) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.RelativeSizeSpan(webvttCssStyle.getFontSize()), i, i2, 33);
        } else if (fontSizeUnit == 3) {
            com.google.android.exoplayer2.text.span.SpanUtil.addOrReplaceSpan(spannableStringBuilder, new android.text.style.RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i, i2, 33);
        }
        if (webvttCssStyle.getCombineUpright()) {
            spannableStringBuilder.setSpan(new com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan(), i, i2, 33);
        }
    }

    public static int f(java.lang.String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    public static int g(int i, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> h(java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle = list.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.a, startTag.d, startTag.c);
            if (specificityScore > 0) {
                arrayList.add(new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag) {
        java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> h = h(list, str, startTag);
        for (int i = 0; i < h.size(); i++) {
            com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle = h.get(i).t;
            if (webvttCssStyle.getRubyPosition() != -1) {
                return webvttCssStyle.getRubyPosition();
            }
        }
        return -1;
    }

    public static java.lang.String j(java.lang.String str) {
        java.lang.String trim = str.trim();
        com.google.android.exoplayer2.util.Assertions.checkArgument(!trim.isEmpty());
        return com.google.android.exoplayer2.util.Util.splitAtFirst(trim, "[ \\.]")[0];
    }

    public static boolean k(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static com.google.android.exoplayer2.text.Cue l(java.lang.CharSequence charSequence) {
        com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder = new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder();
        webvttCueInfoBuilder.c = charSequence;
        return webvttCueInfoBuilder.g().build();
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.webvtt.WebvttCueInfo m(@androidx.annotation.Nullable java.lang.String str, java.util.regex.Matcher matcher, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder = new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.a = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
            webvttCueInfoBuilder.b = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2)));
            o((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(3)), webvttCueInfoBuilder);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String readLine = parsableByteArray.readLine();
            while (!android.text.TextUtils.isEmpty(readLine)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(readLine.trim());
                readLine = parsableByteArray.readLine();
            }
            webvttCueInfoBuilder.c = p(str, sb.toString(), list);
            return webvttCueInfoBuilder.a();
        } catch (java.lang.NumberFormatException unused) {
            java.lang.String valueOf = java.lang.String.valueOf(matcher.group());
            com.google.android.exoplayer2.util.Log.w("WebvttCueParser", valueOf.length() != 0 ? "Skipping cue with bad header: ".concat(valueOf) : new java.lang.String("Skipping cue with bad header: "));
            return null;
        }
    }

    public static com.google.android.exoplayer2.text.Cue.Builder n(java.lang.String str) {
        com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder = new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder();
        o(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.g();
    }

    public static void o(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder) {
        java.util.regex.Matcher matcher = a.matcher(str);
        while (matcher.find()) {
            java.lang.String str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1));
            java.lang.String str3 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    r(str3, webvttCueInfoBuilder);
                } else if (com.sensorsdata.sf.ui.view.UIProperty.align.equals(str2)) {
                    webvttCueInfoBuilder.d = u(str3);
                } else if (com.alibaba.sdk.android.oss.common.RequestParameters.POSITION.equals(str2)) {
                    t(str3, webvttCueInfoBuilder);
                } else if (com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE.equals(str2)) {
                    webvttCueInfoBuilder.j = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.k = v(str3);
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 21 + java.lang.String.valueOf(str3).length());
                    sb.append("Unknown cue setting ");
                    sb.append(str2);
                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    sb.append(str3);
                    com.google.android.exoplayer2.util.Log.w("WebvttCueParser", sb.toString());
                }
            } catch (java.lang.NumberFormatException unused) {
                java.lang.String valueOf = java.lang.String.valueOf(matcher.group());
                com.google.android.exoplayer2.util.Log.w("WebvttCueParser", valueOf.length() != 0 ? "Skipping bad cue setting: ".concat(valueOf) : new java.lang.String("Skipping bad cue setting: "));
            }
        }
    }

    public static android.text.SpannedString p(@androidx.annotation.Nullable java.lang.String str, java.lang.String str2, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (charAt == '&') {
                i++;
                int indexOf = str2.indexOf(59, i);
                int indexOf2 = str2.indexOf(32, i);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = java.lang.Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((java.lang.CharSequence) " ");
                    }
                    i = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i++;
            } else {
                int i2 = i + 1;
                if (i2 < str2.length()) {
                    boolean z = str2.charAt(i2) == '/';
                    i2 = f(str2, i2);
                    int i3 = i2 - 2;
                    boolean z2 = str2.charAt(i3) == '/';
                    int i4 = i + (z ? 2 : 1);
                    if (!z2) {
                        i3 = i2 - 1;
                    }
                    java.lang.String substring = str2.substring(i4, i3);
                    if (!substring.trim().isEmpty()) {
                        java.lang.String j = j(substring);
                        if (k(j)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) arrayDeque.pop();
                                    d(str, startTag, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.Element(startTag, spannableStringBuilder.length(), null));
                                    }
                                    if (startTag.a.equals(j)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                arrayDeque.push(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i = i2;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.b(), java.util.Collections.emptyList(), spannableStringBuilder, list);
        return android.text.SpannedString.valueOf(spannableStringBuilder);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.webvtt.WebvttCueInfo parseCue(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        java.lang.String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return null;
        }
        java.util.regex.Pattern pattern = CUE_HEADER_PATTERN;
        java.util.regex.Matcher matcher = pattern.matcher(readLine);
        if (matcher.matches()) {
            return m(null, matcher, parsableByteArray, list);
        }
        java.lang.String readLine2 = parsableByteArray.readLine();
        if (readLine2 == null) {
            return null;
        }
        java.util.regex.Matcher matcher2 = pattern.matcher(readLine2);
        if (matcher2.matches()) {
            return m(readLine.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    public static int q(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                com.google.android.exoplayer2.util.Log.w("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new java.lang.String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    public static void r(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.g = q(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.e = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(str);
            webvttCueInfoBuilder.f = 0;
        } else {
            webvttCueInfoBuilder.e = java.lang.Integer.parseInt(str);
            webvttCueInfoBuilder.f = 1;
        }
    }

    public static int s(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                com.google.android.exoplayer2.util.Log.w("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new java.lang.String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    public static void t(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.i = s(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        webvttCueInfoBuilder.h = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(str);
    }

    public static int u(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                com.google.android.exoplayer2.util.Log.w("WebvttCueParser", str.length() != 0 ? "Invalid alignment value: ".concat(str) : new java.lang.String("Invalid alignment value: "));
                return 2;
        }
    }

    public static int v(java.lang.String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        com.google.android.exoplayer2.util.Log.w("WebvttCueParser", str.length() != 0 ? "Invalid 'vertical' value: ".concat(str) : new java.lang.String("Invalid 'vertical' value: "));
        return Integer.MIN_VALUE;
    }
}
