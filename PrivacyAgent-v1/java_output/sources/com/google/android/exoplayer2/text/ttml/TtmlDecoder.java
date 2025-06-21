package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes22.dex */
public final class TtmlDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public static final java.util.regex.Pattern p = java.util.regex.Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final java.util.regex.Pattern q = java.util.regex.Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final java.util.regex.Pattern r = java.util.regex.Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s, reason: collision with root package name */
    public static final java.util.regex.Pattern f362s = java.util.regex.Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final java.util.regex.Pattern t = java.util.regex.Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final java.util.regex.Pattern u = java.util.regex.Pattern.compile("^(\\d+) (\\d+)$");
    public static final com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate v = new com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate(30.0f, 1, 1);
    public static final com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution w = new com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution(32, 15);
    public final org.xmlpull.v1.XmlPullParserFactory o;

    public static final class CellResolution {
        public final int a;
        public final int b;

        public CellResolution(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static final class FrameAndTickRate {
        public final float a;
        public final int b;
        public final int c;

        public FrameAndTickRate(float f, int i, int i2) {
            this.a = f;
            this.b = i;
            this.c = i2;
        }
    }

    public static final class TtsExtent {
        public final int a;
        public final int b;

        public TtsExtent(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            org.xmlpull.v1.XmlPullParserFactory newInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
            this.o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (org.xmlpull.v1.XmlPullParserException e) {
            throw new java.lang.RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlStyle j(@androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new com.google.android.exoplayer2.text.ttml.TtmlStyle() : ttmlStyle;
    }

    public static boolean k(java.lang.String str) {
        return str.equals("tt") || str.equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD) || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(com.anythink.expressad.foundation.h.i.e) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution l(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        java.util.regex.Matcher matcher = u.matcher(attributeValue);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new java.lang.String("Ignoring malformed cell resolution: "));
            return cellResolution;
        }
        try {
            int parseInt = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution(parseInt, parseInt2);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(parseInt);
            sb.append(" ");
            sb.append(parseInt2);
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException(sb.toString());
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new java.lang.String("Ignoring malformed cell resolution: "));
            return cellResolution;
        }
    }

    public static void m(java.lang.String str, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        java.util.regex.Matcher matcher;
        java.lang.String str2;
        java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = r.matcher(str);
        } else {
            if (split.length != 2) {
                int length = split.length;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(52);
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(length);
                sb.append(".");
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException(sb.toString());
            }
            matcher = r.matcher(split[1]);
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 36);
            sb2.append("Invalid expression for fontSize: '");
            sb2.append(str);
            sb2.append("'.");
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException(sb2.toString());
        }
        str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                ttmlStyle.w(3);
                break;
            case "em":
                ttmlStyle.w(2);
                break;
            case "px":
                ttmlStyle.w(1);
                break;
            default:
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(str2.length() + 30);
                sb3.append("Invalid unit for fontSize: '");
                sb3.append(str2);
                sb3.append("'.");
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException(sb3.toString());
        }
        ttmlStyle.v(java.lang.Float.parseFloat((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))));
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate n(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        float f;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? java.lang.Integer.parseInt(attributeValue) : 30;
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (com.google.android.exoplayer2.util.Util.split(attributeValue2, " ").length != 2) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = java.lang.Integer.parseInt(r2[0]) / java.lang.Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate = v;
        int i = frameAndTickRate.b;
        java.lang.String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = java.lang.Integer.parseInt(attributeValue3);
        }
        int i2 = frameAndTickRate.c;
        java.lang.String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = java.lang.Integer.parseInt(attributeValue4);
        }
        return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate(parseInt * f, i, i2);
    }

    public static java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> o(org.xmlpull.v1.XmlPullParser xmlPullParser, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, com.anythink.expressad.foundation.h.i.e)) {
                java.lang.String attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, com.anythink.expressad.foundation.h.i.e);
                com.google.android.exoplayer2.text.ttml.TtmlStyle s2 = s(xmlPullParser, new com.google.android.exoplayer2.text.ttml.TtmlStyle());
                if (attributeValue != null) {
                    for (java.lang.String str : t(attributeValue)) {
                        s2.a(map.get(str));
                    }
                }
                java.lang.String g = s2.g();
                if (g != null) {
                    map.put(g, s2);
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                com.google.android.exoplayer2.text.ttml.TtmlRegion r2 = r(xmlPullParser, cellResolution, ttsExtent);
                if (r2 != null) {
                    map2.put(r2.a, r2);
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "metadata")) {
                p(xmlPullParser, map3);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD));
        return map;
    }

    public static void p(org.xmlpull.v1.XmlPullParser xmlPullParser, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        java.lang.String attributeValue;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.google.android.exoplayer2.text.ttml.TtmlNode q(org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        long j;
        long j2;
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        com.google.android.exoplayer2.text.ttml.TtmlStyle s2 = s(xmlPullParser, null);
        java.lang.String[] strArr = null;
        java.lang.String str = null;
        java.lang.String str2 = "";
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        for (int i = 0; i < attributeCount; i++) {
            java.lang.String attributeName = xmlPullParser.getAttributeName(i);
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals(com.anythink.expressad.foundation.h.i.e)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals(com.sensorsdata.sf.ui.view.UIProperty.backgroundImage)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j5 = u(attributeValue, frameAndTickRate);
                    break;
                case 2:
                    j4 = u(attributeValue, frameAndTickRate);
                    break;
                case 3:
                    j3 = u(attributeValue, frameAndTickRate);
                    break;
                case 4:
                    java.lang.String[] t2 = t(attributeValue);
                    if (t2.length > 0) {
                        strArr = t2;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j6 = ttmlNode.d;
            j = -9223372036854775807L;
            if (j6 != -9223372036854775807L) {
                if (j3 != -9223372036854775807L) {
                    j3 += j6;
                }
                if (j4 != -9223372036854775807L) {
                    j4 += j6;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j7 = j3;
        if (j4 == j) {
            if (j5 != j) {
                j2 = j7 + j5;
            } else if (ttmlNode != null) {
                long j8 = ttmlNode.e;
                if (j8 != j) {
                    j2 = j8;
                }
            }
            return com.google.android.exoplayer2.text.ttml.TtmlNode.c(xmlPullParser.getName(), j7, j2, s2, strArr, str2, str, ttmlNode);
        }
        j2 = j4;
        return com.google.android.exoplayer2.text.ttml.TtmlNode.c(xmlPullParser.getName(), j7, j2, s2, strArr, str2, str, ttmlNode);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01b0, code lost:
    
        if (r0.equals("tb") == false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0183  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.text.ttml.TtmlRegion r(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent) {
        float parseFloat;
        float f;
        float parseFloat2;
        float parseFloat3;
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution2;
        float f2;
        int i;
        java.lang.String attributeValue;
        int i2;
        java.lang.String attributeValue2 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue2 == null) {
            return null;
        }
        java.lang.String attributeValue3 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
        if (attributeValue3 == null) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
        java.util.regex.Pattern pattern = f362s;
        java.util.regex.Matcher matcher = pattern.matcher(attributeValue3);
        java.util.regex.Pattern pattern2 = t;
        java.util.regex.Matcher matcher2 = pattern2.matcher(attributeValue3);
        if (matcher.matches()) {
            try {
                float parseFloat4 = java.lang.Float.parseFloat((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                parseFloat = java.lang.Float.parseFloat((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2))) / 100.0f;
                f = parseFloat4;
            } catch (java.lang.NumberFormatException unused) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with malformed origin: ".concat(attributeValue3) : new java.lang.String("Ignoring region with malformed origin: "));
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with unsupported origin: ".concat(attributeValue3) : new java.lang.String("Ignoring region with unsupported origin: "));
                return null;
            }
            if (ttsExtent == null) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(attributeValue3) : new java.lang.String("Ignoring region with missing tts:extent: "));
                return null;
            }
            try {
                int parseInt = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher2.group(1)));
                f = parseInt / ttsExtent.a;
                parseFloat = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher2.group(2))) / ttsExtent.b;
            } catch (java.lang.NumberFormatException unused2) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with malformed origin: ".concat(attributeValue3) : new java.lang.String("Ignoring region with malformed origin: "));
                return null;
            }
        }
        java.lang.String attributeValue4 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue4 == null) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        java.util.regex.Matcher matcher3 = pattern.matcher(attributeValue4);
        java.util.regex.Matcher matcher4 = pattern2.matcher(attributeValue4);
        if (matcher3.matches()) {
            try {
                parseFloat2 = java.lang.Float.parseFloat((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                parseFloat3 = java.lang.Float.parseFloat((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
            } catch (java.lang.NumberFormatException unused3) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with malformed extent: ".concat(attributeValue3) : new java.lang.String("Ignoring region with malformed extent: "));
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with unsupported extent: ".concat(attributeValue3) : new java.lang.String("Ignoring region with unsupported extent: "));
                return null;
            }
            if (ttsExtent == null) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(attributeValue3) : new java.lang.String("Ignoring region with missing tts:extent: "));
                return null;
            }
            try {
                int parseInt2 = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher4.group(1)));
                parseFloat2 = parseInt2 / ttsExtent.a;
                parseFloat3 = java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher4.group(2))) / ttsExtent.b;
            } catch (java.lang.NumberFormatException unused4) {
                com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue3.length() != 0 ? "Ignoring region with malformed extent: ".concat(attributeValue3) : new java.lang.String("Ignoring region with malformed extent: "));
                return null;
            }
        }
        java.lang.String attributeValue5 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
        char c = 0;
        if (attributeValue5 != null) {
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue5);
            lowerInvariant.hashCode();
            if (lowerInvariant.equals("center")) {
                cellResolution2 = cellResolution;
                f2 = parseFloat + (parseFloat3 / 2.0f);
                i = 1;
            } else if (lowerInvariant.equals("after")) {
                cellResolution2 = cellResolution;
                f2 = parseFloat + parseFloat3;
                i = 2;
            }
            float f3 = 1.0f / cellResolution2.b;
            attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
            if (attributeValue != null) {
                java.lang.String lowerInvariant2 = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                lowerInvariant2.hashCode();
                switch (lowerInvariant2.hashCode()) {
                    case 3694:
                        break;
                    case 3553396:
                        if (lowerInvariant2.equals("tblr")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3553576:
                        if (lowerInvariant2.equals("tbrl")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        i2 = 2;
                        break;
                    case 2:
                        i2 = 1;
                        break;
                }
                return new com.google.android.exoplayer2.text.ttml.TtmlRegion(attributeValue2, f, f2, 0, i, parseFloat2, parseFloat3, 1, f3, i2);
            }
            i2 = Integer.MIN_VALUE;
            return new com.google.android.exoplayer2.text.ttml.TtmlRegion(attributeValue2, f, f2, 0, i, parseFloat2, parseFloat3, 1, f3, i2);
        }
        cellResolution2 = cellResolution;
        f2 = parseFloat;
        i = 0;
        float f32 = 1.0f / cellResolution2.b;
        attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
        if (attributeValue != null) {
        }
        i2 = Integer.MIN_VALUE;
        return new com.google.android.exoplayer2.text.ttml.TtmlRegion(attributeValue2, f, f2, 0, i, parseFloat2, parseFloat3, 1, f32, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02a7, code lost:
    
        if (r3.equals(com.anythink.expressad.foundation.d.c.bT) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019e, code lost:
    
        if (r3.equals("text") == false) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.text.ttml.TtmlStyle s(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(i);
            java.lang.String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            char c2 = 5;
            char c3 = 4;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals(com.sensorsdata.sf.ui.view.UIProperty.textAlign)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    ttmlStyle = j(ttmlStyle).y("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = j(ttmlStyle).u(attributeValue);
                    break;
                case 2:
                    java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                    lowerInvariant.hashCode();
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3317767:
                            if (lowerInvariant.equals(com.sensorsdata.sf.ui.view.UIProperty.left)) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 108511772:
                            if (lowerInvariant.equals(com.sensorsdata.sf.ui.view.UIProperty.right)) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 109757538:
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                        case 0:
                            ttmlStyle = j(ttmlStyle).C(android.text.Layout.Alignment.ALIGN_CENTER);
                            break;
                        case 1:
                        case 3:
                            ttmlStyle = j(ttmlStyle).C(android.text.Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        case 2:
                        case 4:
                            ttmlStyle = j(ttmlStyle).C(android.text.Layout.Alignment.ALIGN_NORMAL);
                            break;
                    }
                case 3:
                    java.lang.String lowerInvariant2 = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                    lowerInvariant2.hashCode();
                    switch (lowerInvariant2) {
                        case "nounderline":
                            ttmlStyle = j(ttmlStyle).E(false);
                            break;
                        case "underline":
                            ttmlStyle = j(ttmlStyle).E(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = j(ttmlStyle).z(false);
                            break;
                        case "linethrough":
                            ttmlStyle = j(ttmlStyle).z(true);
                            break;
                    }
                case 4:
                    ttmlStyle = j(ttmlStyle).s("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (com.anythink.expressad.foundation.h.i.e.equals(xmlPullParser.getName())) {
                        ttmlStyle = j(ttmlStyle).x(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    java.lang.String lowerInvariant3 = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                    lowerInvariant3.hashCode();
                    switch (lowerInvariant3.hashCode()) {
                        case -618561360:
                            if (lowerInvariant3.equals("baseContainer")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -410956671:
                            if (lowerInvariant3.equals("container")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -250518009:
                            if (lowerInvariant3.equals(com.alibaba.sdk.android.oss.common.RequestParameters.DELIMITER)) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -136074796:
                            if (lowerInvariant3.equals("textContainer")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3016401:
                            if (lowerInvariant3.equals("base")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3556653:
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 4:
                            ttmlStyle = j(ttmlStyle).B(2);
                            break;
                        case 1:
                            ttmlStyle = j(ttmlStyle).B(1);
                            break;
                        case 2:
                            ttmlStyle = j(ttmlStyle).B(4);
                            break;
                        case 3:
                        case 5:
                            ttmlStyle = j(ttmlStyle).B(3);
                            break;
                    }
                case 7:
                    ttmlStyle = j(ttmlStyle);
                    try {
                        ttmlStyle.t(com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (java.lang.IllegalArgumentException unused) {
                        java.lang.String valueOf = java.lang.String.valueOf(attributeValue);
                        com.google.android.exoplayer2.util.Log.w("TtmlDecoder", valueOf.length() != 0 ? "Failed parsing color value: ".concat(valueOf) : new java.lang.String("Failed parsing color value: "));
                        break;
                    }
                case '\b':
                    java.lang.String lowerInvariant4 = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                    lowerInvariant4.hashCode();
                    if (lowerInvariant4.equals("all")) {
                        ttmlStyle = j(ttmlStyle).D(true);
                        break;
                    } else if (lowerInvariant4.equals("none")) {
                        ttmlStyle = j(ttmlStyle).D(false);
                        break;
                    } else {
                        break;
                    }
                case '\t':
                    try {
                        ttmlStyle = j(ttmlStyle);
                        m(attributeValue, ttmlStyle);
                        break;
                    } catch (com.google.android.exoplayer2.text.SubtitleDecoderException unused2) {
                        java.lang.String valueOf2 = java.lang.String.valueOf(attributeValue);
                        com.google.android.exoplayer2.util.Log.w("TtmlDecoder", valueOf2.length() != 0 ? "Failed parsing fontSize value: ".concat(valueOf2) : new java.lang.String("Failed parsing fontSize value: "));
                        break;
                    }
                case '\n':
                    java.lang.String lowerInvariant5 = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
                    lowerInvariant5.hashCode();
                    if (lowerInvariant5.equals("before")) {
                        ttmlStyle = j(ttmlStyle).A(1);
                        break;
                    } else if (lowerInvariant5.equals("after")) {
                        ttmlStyle = j(ttmlStyle).A(2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    ttmlStyle = j(ttmlStyle);
                    try {
                        ttmlStyle.r(com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (java.lang.IllegalArgumentException unused3) {
                        java.lang.String valueOf3 = java.lang.String.valueOf(attributeValue);
                        com.google.android.exoplayer2.util.Log.w("TtmlDecoder", valueOf3.length() != 0 ? "Failed parsing background value: ".concat(valueOf3) : new java.lang.String("Failed parsing background value: "));
                        break;
                    }
            }
        }
        return ttmlStyle;
    }

    public static java.lang.String[] t(java.lang.String str) {
        java.lang.String trim = str.trim();
        return trim.isEmpty() ? new java.lang.String[0] : com.google.android.exoplayer2.util.Util.split(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long u(java.lang.String str, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        double d;
        double d2;
        java.util.regex.Matcher matcher = p.matcher(str);
        char c = 4;
        if (matcher.matches()) {
            double parseLong = (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))) * com.anythink.expressad.d.a.b.P) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2))) * 60) + java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(3)));
            java.lang.String group = matcher.group(4);
            return (long) ((parseLong + (group != null ? java.lang.Double.parseDouble(group) : 0.0d) + (matcher.group(5) != null ? java.lang.Long.parseLong(r13) / frameAndTickRate.a : 0.0d) + (matcher.group(6) != null ? (java.lang.Long.parseLong(r13) / frameAndTickRate.b) / frameAndTickRate.a : 0.0d)) * 1000000.0d);
        }
        java.util.regex.Matcher matcher2 = q.matcher(str);
        if (!matcher2.matches()) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException(valueOf.length() != 0 ? "Malformed time expression: ".concat(valueOf) : new java.lang.String("Malformed time expression: "));
        }
        double parseDouble = java.lang.Double.parseDouble((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher2.group(1)));
        java.lang.String str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher2.group(2));
        str2.hashCode();
        switch (str2.hashCode()) {
            case 102:
                if (str2.equals("f")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 104:
                if (str2.equals("h")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 109:
                if (str2.equals(com.anythink.expressad.d.a.b.dH)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 116:
                if (str2.equals("t")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3494:
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                d = frameAndTickRate.a;
                parseDouble /= d;
                break;
            case 1:
                d2 = 3600.0d;
                break;
            case 2:
                d2 = 60.0d;
                break;
            case 3:
                d = frameAndTickRate.c;
                parseDouble /= d;
                break;
            case 4:
                d = 1000.0d;
                parseDouble /= d;
                break;
        }
        parseDouble *= d2;
        return (long) (parseDouble * 1000000.0d);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent v(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        java.util.regex.Matcher matcher = t.matcher(attributeValue);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(attributeValue) : new java.lang.String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent(java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))), java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2))));
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed tts extent: ".concat(attributeValue) : new java.lang.String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate;
        try {
            org.xmlpull.v1.XmlPullParser newPullParser = this.o.newPullParser();
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.HashMap hashMap2 = new java.util.HashMap();
            java.util.HashMap hashMap3 = new java.util.HashMap();
            hashMap2.put("", new com.google.android.exoplayer2.text.ttml.TtmlRegion(""));
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent = null;
            newPullParser.setInput(new java.io.ByteArrayInputStream(bArr, 0, i), null);
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate2 = v;
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution = w;
            com.google.android.exoplayer2.text.ttml.TtmlSubtitle ttmlSubtitle = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode = (com.google.android.exoplayer2.text.ttml.TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    java.lang.String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate2 = n(newPullParser);
                            cellResolution = l(newPullParser, w);
                            ttsExtent = v(newPullParser);
                        }
                        com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent2 = ttsExtent;
                        com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution2 = cellResolution;
                        if (k(name)) {
                            if (com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD.equals(name)) {
                                frameAndTickRate = frameAndTickRate3;
                                o(newPullParser, hashMap, cellResolution2, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                frameAndTickRate = frameAndTickRate3;
                                try {
                                    com.google.android.exoplayer2.text.ttml.TtmlNode q2 = q(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    arrayDeque.push(q2);
                                    if (ttmlNode != null) {
                                        ttmlNode.a(q2);
                                    }
                                } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e) {
                                    com.google.android.exoplayer2.util.Log.w("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            frameAndTickRate2 = frameAndTickRate;
                        } else {
                            java.lang.String valueOf = java.lang.String.valueOf(newPullParser.getName());
                            com.google.android.exoplayer2.util.Log.i("TtmlDecoder", valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new java.lang.String("Ignoring unsupported tag: "));
                            i2++;
                            frameAndTickRate2 = frameAndTickRate3;
                        }
                        ttsExtent = ttsExtent2;
                        cellResolution = cellResolution2;
                    } else if (eventType == 4) {
                        ((com.google.android.exoplayer2.text.ttml.TtmlNode) com.google.android.exoplayer2.util.Assertions.checkNotNull(ttmlNode)).a(com.google.android.exoplayer2.text.ttml.TtmlNode.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new com.google.android.exoplayer2.text.ttml.TtmlSubtitle((com.google.android.exoplayer2.text.ttml.TtmlNode) com.google.android.exoplayer2.util.Assertions.checkNotNull((com.google.android.exoplayer2.text.ttml.TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("No TTML subtitles found");
        } catch (java.io.IOException e2) {
            throw new java.lang.IllegalStateException("Unexpected error when reading input.", e2);
        } catch (org.xmlpull.v1.XmlPullParserException e3) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
