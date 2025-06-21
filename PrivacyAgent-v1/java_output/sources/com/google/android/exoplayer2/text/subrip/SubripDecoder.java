package com.google.android.exoplayer2.text.subrip;

/* loaded from: classes22.dex */
public final class SubripDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public static final java.util.regex.Pattern q = java.util.regex.Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final java.util.regex.Pattern r = java.util.regex.Pattern.compile("\\{\\\\.*?\\}");
    public final java.lang.StringBuilder o;
    public final java.util.ArrayList<java.lang.String> p;

    public SubripDecoder() {
        super("SubripDecoder");
        this.o = new java.lang.StringBuilder();
        this.p = new java.util.ArrayList<>();
    }

    public static float k(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static long l(java.util.regex.Matcher matcher, int i) {
        java.lang.String group = matcher.group(i + 1);
        long parseLong = (group != null ? java.lang.Long.parseLong(group) * 60 * 60 * 1000 : 0L) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(i + 2))) * 60 * 1000) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(i + 3))) * 1000);
        java.lang.String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += java.lang.Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) {
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.util.LongArray longArray = new com.google.android.exoplayer2.util.LongArray();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i);
        while (true) {
            java.lang.String readLine = parsableByteArray.readLine();
            int i2 = 0;
            if (readLine == null) {
                break;
            }
            if (readLine.length() != 0) {
                try {
                    java.lang.Integer.parseInt(readLine);
                    java.lang.String readLine2 = parsableByteArray.readLine();
                    if (readLine2 == null) {
                        com.google.android.exoplayer2.util.Log.w("SubripDecoder", "Unexpected end");
                        break;
                    }
                    java.util.regex.Matcher matcher = q.matcher(readLine2);
                    if (matcher.matches()) {
                        longArray.add(l(matcher, 1));
                        longArray.add(l(matcher, 6));
                        this.o.setLength(0);
                        this.p.clear();
                        for (java.lang.String readLine3 = parsableByteArray.readLine(); !android.text.TextUtils.isEmpty(readLine3); readLine3 = parsableByteArray.readLine()) {
                            if (this.o.length() > 0) {
                                this.o.append("<br>");
                            }
                            this.o.append(m(readLine3, this.p));
                        }
                        android.text.Spanned fromHtml = android.text.Html.fromHtml(this.o.toString());
                        while (true) {
                            if (i2 >= this.p.size()) {
                                str = null;
                                break;
                            }
                            str = this.p.get(i2);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(j(fromHtml, str));
                        arrayList.add(com.google.android.exoplayer2.text.Cue.EMPTY);
                    } else {
                        com.google.android.exoplayer2.util.Log.w("SubripDecoder", readLine2.length() != 0 ? "Skipping invalid timing: ".concat(readLine2) : new java.lang.String("Skipping invalid timing: "));
                    }
                } catch (java.lang.NumberFormatException unused) {
                    com.google.android.exoplayer2.util.Log.w("SubripDecoder", readLine.length() != 0 ? "Skipping invalid index: ".concat(readLine) : new java.lang.String("Skipping invalid index: "));
                }
            }
        }
        return new com.google.android.exoplayer2.text.subrip.SubripSubtitle((com.google.android.exoplayer2.text.Cue[]) arrayList.toArray(new com.google.android.exoplayer2.text.Cue[0]), longArray.toArray());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final com.google.android.exoplayer2.text.Cue j(android.text.Spanned spanned, @androidx.annotation.Nullable java.lang.String str) {
        char c;
        char c2;
        com.google.android.exoplayer2.text.Cue.Builder text = new com.google.android.exoplayer2.text.Cue.Builder().setText(spanned);
        if (str == null) {
            return text.build();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1 || c == 2) {
            text.setPositionAnchor(0);
        } else if (c == 3 || c == 4 || c == 5) {
            text.setPositionAnchor(2);
        } else {
            text.setPositionAnchor(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            text.setLineAnchor(2);
        } else if (c2 == 3 || c2 == 4 || c2 == 5) {
            text.setLineAnchor(0);
        } else {
            text.setLineAnchor(1);
        }
        return text.setPosition(k(text.getPositionAnchor())).setLine(k(text.getLineAnchor()), 0).build();
    }

    public final java.lang.String m(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.String trim = str.trim();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(trim);
        java.util.regex.Matcher matcher = r.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            java.lang.String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }
}
