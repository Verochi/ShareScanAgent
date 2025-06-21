package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes22.dex */
public final class SsaDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public static final java.util.regex.Pattern t = java.util.regex.Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean o;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.text.ssa.SsaDialogueFormat p;
    public java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ssa.SsaStyle> q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f361s;

    public SsaDecoder() {
        this(null);
    }

    public SsaDecoder(@androidx.annotation.Nullable java.util.List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.f361s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(list.get(0));
        com.google.android.exoplayer2.util.Assertions.checkArgument(fromUtf8Bytes.startsWith("Format:"));
        this.p = (com.google.android.exoplayer2.text.ssa.SsaDialogueFormat) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.text.ssa.SsaDialogueFormat.a(fromUtf8Bytes));
        o(new com.google.android.exoplayer2.util.ParsableByteArray(list.get(1)));
    }

    public static int j(long j, java.util.List<java.lang.Long> list, java.util.List<java.util.List<com.google.android.exoplayer2.text.Cue>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, java.lang.Long.valueOf(j));
        list2.add(i, i == 0 ? new java.util.ArrayList() : new java.util.ArrayList(list2.get(i - 1)));
        return i;
    }

    public static float k(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static com.google.android.exoplayer2.text.Cue l(java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ssa.SsaStyle ssaStyle, com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides overrides, float f, float f2) {
        com.google.android.exoplayer2.text.Cue.Builder text = new com.google.android.exoplayer2.text.Cue.Builder().setText(str);
        int i = overrides.a;
        if (i == -1) {
            i = ssaStyle != null ? ssaStyle.b : -1;
        }
        text.setTextAlignment(u(i)).setPositionAnchor(t(i)).setLineAnchor(s(i));
        android.graphics.PointF pointF = overrides.b;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            text.setPosition(k(text.getPositionAnchor()));
            text.setLine(k(text.getLineAnchor()), 0);
        } else {
            text.setPosition(pointF.x / f);
            text.setLine(overrides.b.y / f2, 0);
        }
        return text.build();
    }

    public static java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ssa.SsaStyle> q(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        com.google.android.exoplayer2.text.ssa.SsaStyle.Format format = null;
        while (true) {
            java.lang.String readLine = parsableByteArray.readLine();
            if (readLine == null || (parsableByteArray.bytesLeft() != 0 && parsableByteArray.peekUnsignedByte() == 91)) {
                break;
            }
            if (readLine.startsWith("Format:")) {
                format = com.google.android.exoplayer2.text.ssa.SsaStyle.Format.a(readLine);
            } else if (readLine.startsWith("Style:")) {
                if (format == null) {
                    com.google.android.exoplayer2.util.Log.w("SsaDecoder", readLine.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(readLine) : new java.lang.String("Skipping 'Style:' line before 'Format:' line: "));
                } else {
                    com.google.android.exoplayer2.text.ssa.SsaStyle b = com.google.android.exoplayer2.text.ssa.SsaStyle.b(readLine, format);
                    if (b != null) {
                        linkedHashMap.put(b.a, b);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long r(java.lang.String str) {
        java.util.regex.Matcher matcher = t.matcher(str.trim());
        if (matcher.matches()) {
            return (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(matcher.group(1))) * 60 * 60 * 1000000) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(matcher.group(2))) * 60 * 1000000) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(matcher.group(3))) * 1000000) + (java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    public static int s(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("SsaDecoder", sb.toString());
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    public static int t(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("SsaDecoder", sb.toString());
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    @androidx.annotation.Nullable
    public static android.text.Layout.Alignment u(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("SsaDecoder", sb.toString());
                return null;
            case 1:
            case 4:
            case 7:
                return android.text.Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return android.text.Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return android.text.Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i);
        if (!this.o) {
            o(parsableByteArray);
        }
        n(parsableByteArray, arrayList, arrayList2);
        return new com.google.android.exoplayer2.text.ssa.SsaSubtitle(arrayList, arrayList2);
    }

    public final void m(java.lang.String str, com.google.android.exoplayer2.text.ssa.SsaDialogueFormat ssaDialogueFormat, java.util.List<java.util.List<com.google.android.exoplayer2.text.Cue>> list, java.util.List<java.lang.Long> list2) {
        int i;
        com.google.android.exoplayer2.util.Assertions.checkArgument(str.startsWith("Dialogue:"));
        java.lang.String[] split = str.substring(9).split(",", ssaDialogueFormat.e);
        if (split.length != ssaDialogueFormat.e) {
            com.google.android.exoplayer2.util.Log.w("SsaDecoder", str.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(str) : new java.lang.String("Skipping dialogue line with fewer columns than format: "));
            return;
        }
        long r = r(split[ssaDialogueFormat.a]);
        if (r == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Log.w("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new java.lang.String("Skipping invalid timing: "));
            return;
        }
        long r2 = r(split[ssaDialogueFormat.b]);
        if (r2 == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Log.w("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new java.lang.String("Skipping invalid timing: "));
            return;
        }
        java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ssa.SsaStyle> map = this.q;
        com.google.android.exoplayer2.text.ssa.SsaStyle ssaStyle = (map == null || (i = ssaDialogueFormat.c) == -1) ? null : map.get(split[i].trim());
        java.lang.String str2 = split[ssaDialogueFormat.d];
        com.google.android.exoplayer2.text.Cue l = l(com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ssaStyle, com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides.b(str2), this.r, this.f361s);
        int j = j(r2, list2, list);
        for (int j2 = j(r, list2, list); j2 < j; j2++) {
            list.get(j2).add(l);
        }
    }

    public final void n(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.util.List<java.util.List<com.google.android.exoplayer2.text.Cue>> list, java.util.List<java.lang.Long> list2) {
        com.google.android.exoplayer2.text.ssa.SsaDialogueFormat ssaDialogueFormat = this.o ? this.p : null;
        while (true) {
            java.lang.String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.startsWith("Format:")) {
                ssaDialogueFormat = com.google.android.exoplayer2.text.ssa.SsaDialogueFormat.a(readLine);
            } else if (readLine.startsWith("Dialogue:")) {
                if (ssaDialogueFormat == null) {
                    com.google.android.exoplayer2.util.Log.w("SsaDecoder", readLine.length() != 0 ? "Skipping dialogue line before complete format: ".concat(readLine) : new java.lang.String("Skipping dialogue line before complete format: "));
                } else {
                    m(readLine, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    public final void o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (true) {
            java.lang.String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(readLine)) {
                p(parsableByteArray);
            } else if ("[V4+ Styles]".equalsIgnoreCase(readLine)) {
                this.q = q(parsableByteArray);
            } else if ("[V4 Styles]".equalsIgnoreCase(readLine)) {
                com.google.android.exoplayer2.util.Log.i("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(readLine)) {
                return;
            }
        }
    }

    public final void p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (true) {
            java.lang.String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (parsableByteArray.bytesLeft() != 0 && parsableByteArray.peekUnsignedByte() == 91) {
                return;
            }
            java.lang.String[] split = readLine.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (split.length == 2) {
                java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(split[0].trim());
                lowerInvariant.hashCode();
                if (lowerInvariant.equals("playresx")) {
                    this.r = java.lang.Float.parseFloat(split[1].trim());
                } else if (lowerInvariant.equals("playresy")) {
                    try {
                        this.f361s = java.lang.Float.parseFloat(split[1].trim());
                    } catch (java.lang.NumberFormatException unused) {
                    }
                }
            }
        }
    }
}
