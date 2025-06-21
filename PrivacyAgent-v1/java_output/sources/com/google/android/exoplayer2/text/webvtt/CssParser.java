package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
final class CssParser {
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray();
    public final java.lang.StringBuilder b = new java.lang.StringBuilder();

    public static boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        if (position + 2 > limit) {
            return false;
        }
        int i = position + 1;
        if (data[position] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (data[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= limit) {
                parsableByteArray.skipBytes(limit - parsableByteArray.getPosition());
                return true;
            }
            if (((char) data[i2]) == '*' && ((char) data[i3]) == '/') {
                i2 = i3 + 1;
                limit = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public static boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        char j = j(parsableByteArray, parsableByteArray.getPosition());
        if (j != '\t' && j != '\n' && j != '\f' && j != '\r' && j != ' ') {
            return false;
        }
        parsableByteArray.skipBytes(1);
        return true;
    }

    public static java.lang.String e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && !z) {
            char c2 = (char) parsableByteArray.getData()[position];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                position++;
                sb.append(c2);
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb.toString();
    }

    @androidx.annotation.Nullable
    public static java.lang.String f(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        m(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        java.lang.String e = e(parsableByteArray, sb);
        if (!"".equals(e)) {
            return e;
        }
        char readUnsignedByte = (char) parsableByteArray.readUnsignedByte();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(1);
        sb2.append(readUnsignedByte);
        return sb2.toString();
    }

    @androidx.annotation.Nullable
    public static java.lang.String g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        boolean z = false;
        while (!z) {
            int position = parsableByteArray.getPosition();
            java.lang.String f = f(parsableByteArray, sb);
            if (f == null) {
                return null;
            }
            if (com.alipay.sdk.m.u.i.d.equals(f) || com.alipay.sdk.m.u.i.b.equals(f)) {
                parsableByteArray.setPosition(position);
                z = true;
            } else {
                sb2.append(f);
            }
        }
        return sb2.toString();
    }

    @androidx.annotation.Nullable
    public static java.lang.String h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        m(parsableByteArray);
        if (parsableByteArray.bytesLeft() < 5 || !"::cue".equals(parsableByteArray.readString(5))) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        java.lang.String f = f(parsableByteArray, sb);
        if (f == null) {
            return null;
        }
        if ("{".equals(f)) {
            parsableByteArray.setPosition(position);
            return "";
        }
        java.lang.String k = "(".equals(f) ? k(parsableByteArray) : null;
        if (")".equals(f(parsableByteArray, sb))) {
            return k;
        }
        return null;
    }

    public static void i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, java.lang.StringBuilder sb) {
        m(parsableByteArray);
        java.lang.String e = e(parsableByteArray, sb);
        if (!"".equals(e) && com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR.equals(f(parsableByteArray, sb))) {
            m(parsableByteArray);
            java.lang.String g = g(parsableByteArray, sb);
            if (g == null || "".equals(g)) {
                return;
            }
            int position = parsableByteArray.getPosition();
            java.lang.String f = f(parsableByteArray, sb);
            if (!com.alipay.sdk.m.u.i.b.equals(f)) {
                if (!com.alipay.sdk.m.u.i.d.equals(f)) {
                    return;
                } else {
                    parsableByteArray.setPosition(position);
                }
            }
            if ("color".equals(e)) {
                webvttCssStyle.setFontColor(com.google.android.exoplayer2.util.ColorParser.parseCssColor(g));
                return;
            }
            if ("background-color".equals(e)) {
                webvttCssStyle.setBackgroundColor(com.google.android.exoplayer2.util.ColorParser.parseCssColor(g));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(e)) {
                if ("over".equals(g)) {
                    webvttCssStyle.setRubyPosition(1);
                    return;
                } else {
                    if ("under".equals(g)) {
                        webvttCssStyle.setRubyPosition(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(e)) {
                if (!"all".equals(g) && !g.startsWith("digits")) {
                    z = false;
                }
                webvttCssStyle.setCombineUpright(z);
                return;
            }
            if ("text-decoration".equals(e)) {
                if ("underline".equals(g)) {
                    webvttCssStyle.setUnderline(true);
                }
            } else {
                if ("font-family".equals(e)) {
                    webvttCssStyle.setFontFamily(g);
                    return;
                }
                if ("font-weight".equals(e)) {
                    if ("bold".equals(g)) {
                        webvttCssStyle.setBold(true);
                    }
                } else if ("font-style".equals(e) && "italic".equals(g)) {
                    webvttCssStyle.setItalic(true);
                }
            }
        }
    }

    public static char j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        return (char) parsableByteArray.getData()[i];
    }

    public static java.lang.String k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        boolean z = false;
        while (position < limit && !z) {
            int i = position + 1;
            z = ((char) parsableByteArray.getData()[position]) == ')';
            position = i;
        }
        return parsableByteArray.readString((position - 1) - parsableByteArray.getPosition()).trim();
    }

    public static void l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (!android.text.TextUtils.isEmpty(parsableByteArray.readLine())) {
        }
    }

    public static void m(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z = true; parsableByteArray.bytesLeft() > 0 && z; z = false) {
                if (!c(parsableByteArray) && !b(parsableByteArray)) {
                }
            }
            return;
        }
    }

    public final void a(com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, java.lang.String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            java.util.regex.Matcher matcher = c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                webvttCssStyle.setTargetVoice((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(str, "\\.");
        java.lang.String str2 = split[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            webvttCssStyle.setTargetTagName(str2.substring(0, indexOf2));
            webvttCssStyle.setTargetId(str2.substring(indexOf2 + 1));
        } else {
            webvttCssStyle.setTargetTagName(str2);
        }
        if (split.length > 1) {
            webvttCssStyle.setTargetClasses((java.lang.String[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopyOfRange(split, 1, split.length));
        }
    }

    public java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        this.b.setLength(0);
        int position = parsableByteArray.getPosition();
        l(parsableByteArray);
        this.a.reset(parsableByteArray.getData(), parsableByteArray.getPosition());
        this.a.setPosition(position);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {
            java.lang.String h = h(this.a, this.b);
            if (h == null || !"{".equals(f(this.a, this.b))) {
                return arrayList;
            }
            com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle = new com.google.android.exoplayer2.text.webvtt.WebvttCssStyle();
            a(webvttCssStyle, h);
            java.lang.String str = null;
            boolean z = false;
            while (!z) {
                int position2 = this.a.getPosition();
                java.lang.String f = f(this.a, this.b);
                boolean z2 = f == null || com.alipay.sdk.m.u.i.d.equals(f);
                if (!z2) {
                    this.a.setPosition(position2);
                    i(this.a, webvttCssStyle, this.b);
                }
                str = f;
                z = z2;
            }
            if (com.alipay.sdk.m.u.i.d.equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }
}
