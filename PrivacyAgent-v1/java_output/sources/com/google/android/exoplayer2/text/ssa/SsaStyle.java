package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes22.dex */
final class SsaStyle {
    public final java.lang.String a;
    public final int b;

    public static final class Format {
        public final int a;
        public final int b;
        public final int c;

        public Format(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @androidx.annotation.Nullable
        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Format a(java.lang.String str) {
            java.lang.String[] split = android.text.TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < split.length; i3++) {
                java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(split[i3].trim());
                lowerInvariant.hashCode();
                if (lowerInvariant.equals("name")) {
                    i = i3;
                } else if (lowerInvariant.equals("alignment")) {
                    i2 = i3;
                }
            }
            if (i != -1) {
                return new com.google.android.exoplayer2.text.ssa.SsaStyle.Format(i, i2, split.length);
            }
            return null;
        }
    }

    public static final class Overrides {
        public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("\\{([^}]*)\\}");
        public static final java.util.regex.Pattern d = java.util.regex.Pattern.compile(com.google.android.exoplayer2.util.Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final java.util.regex.Pattern e = java.util.regex.Pattern.compile(com.google.android.exoplayer2.util.Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final java.util.regex.Pattern f = java.util.regex.Pattern.compile("\\\\an(\\d+)");
        public final int a;

        @androidx.annotation.Nullable
        public final android.graphics.PointF b;

        public Overrides(int i, @androidx.annotation.Nullable android.graphics.PointF pointF) {
            this.a = i;
            this.b = pointF;
        }

        public static int a(java.lang.String str) {
            java.util.regex.Matcher matcher = f.matcher(str);
            if (matcher.find()) {
                return com.google.android.exoplayer2.text.ssa.SsaStyle.d((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
            }
            return -1;
        }

        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides b(java.lang.String str) {
            java.util.regex.Matcher matcher = c.matcher(str);
            android.graphics.PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                java.lang.String str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1));
                try {
                    android.graphics.PointF c2 = c(str2);
                    if (c2 != null) {
                        pointF = c2;
                    }
                } catch (java.lang.RuntimeException unused) {
                }
                try {
                    int a = a(str2);
                    if (a != -1) {
                        i = a;
                    }
                } catch (java.lang.RuntimeException unused2) {
                }
            }
            return new com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides(i, pointF);
        }

        @androidx.annotation.Nullable
        public static android.graphics.PointF c(java.lang.String str) {
            java.lang.String group;
            java.lang.String group2;
            java.util.regex.Matcher matcher = d.matcher(str);
            java.util.regex.Matcher matcher2 = e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 82);
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(str);
                    sb.append("'");
                    com.google.android.exoplayer2.util.Log.i("SsaStyle.Overrides", sb.toString());
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else {
                if (!find2) {
                    return null;
                }
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            return new android.graphics.PointF(java.lang.Float.parseFloat(((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(group)).trim()), java.lang.Float.parseFloat(((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(group2)).trim()));
        }

        public static java.lang.String d(java.lang.String str) {
            return c.matcher(str).replaceAll("");
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    public SsaStyle(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ssa.SsaStyle b(java.lang.String str, com.google.android.exoplayer2.text.ssa.SsaStyle.Format format) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(str.startsWith("Style:"));
        java.lang.String[] split = android.text.TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i = format.c;
        if (length != i) {
            com.google.android.exoplayer2.util.Log.w("SsaStyle", com.google.android.exoplayer2.util.Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(split.length), str));
            return null;
        }
        try {
            return new com.google.android.exoplayer2.text.ssa.SsaStyle(split[format.a].trim(), d(split[format.b]));
        } catch (java.lang.RuntimeException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 36);
            sb.append("Skipping malformed 'Style:' line: '");
            sb.append(str);
            sb.append("'");
            com.google.android.exoplayer2.util.Log.w("SsaStyle", sb.toString(), e);
            return null;
        }
    }

    public static boolean c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static int d(java.lang.String str) {
        try {
            int parseInt = java.lang.Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (java.lang.NumberFormatException unused) {
        }
        java.lang.String valueOf = java.lang.String.valueOf(str);
        com.google.android.exoplayer2.util.Log.w("SsaStyle", valueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(valueOf) : new java.lang.String("Ignoring unknown alignment: "));
        return -1;
    }
}
