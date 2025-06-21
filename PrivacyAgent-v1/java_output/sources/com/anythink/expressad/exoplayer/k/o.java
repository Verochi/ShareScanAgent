package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class o {
    public static final java.lang.String A = "audio/eac3";
    public static final java.lang.String B = "audio/eac3-joc";
    public static final java.lang.String C = "audio/true-hd";
    public static final java.lang.String D = "audio/vnd.dts";
    public static final java.lang.String E = "audio/vnd.dts.hd";
    public static final java.lang.String F = "audio/vnd.dts.hd;profile=lbr";
    public static final java.lang.String G = "audio/vorbis";
    public static final java.lang.String H = "audio/opus";
    public static final java.lang.String I = "audio/3gpp";
    public static final java.lang.String J = "audio/amr-wb";
    public static final java.lang.String K = "audio/flac";
    public static final java.lang.String L = "audio/alac";
    public static final java.lang.String M = "audio/gsm";
    public static final java.lang.String N = "audio/x-unknown";
    public static final java.lang.String O = "text/vtt";
    public static final java.lang.String P = "text/x-ssa";
    public static final java.lang.String Q = "application/mp4";
    public static final java.lang.String R = "application/webm";
    public static final java.lang.String S = "application/dash+xml";
    public static final java.lang.String T = "application/x-mpegURL";
    public static final java.lang.String U = "application/vnd.ms-sstr+xml";
    public static final java.lang.String V = "application/id3";
    public static final java.lang.String W = "application/cea-608";
    public static final java.lang.String X = "application/cea-708";
    public static final java.lang.String Y = "application/x-subrip";
    public static final java.lang.String Z = "application/ttml+xml";
    public static final java.lang.String a = "video";
    public static final java.lang.String aa = "application/x-quicktime-tx3g";
    public static final java.lang.String ab = "application/x-mp4-vtt";
    public static final java.lang.String ac = "application/x-mp4-cea-608";
    public static final java.lang.String ad = "application/x-rawcc";
    public static final java.lang.String ae = "application/vobsub";
    public static final java.lang.String af = "application/pgs";
    public static final java.lang.String ag = "application/x-scte35";
    public static final java.lang.String ah = "application/x-camera-motion";
    public static final java.lang.String ai = "application/x-emsg";
    public static final java.lang.String aj = "application/dvbsubs";
    public static final java.lang.String ak = "application/x-exif";
    private static final java.util.ArrayList<com.anythink.expressad.exoplayer.k.o.a> al = new java.util.ArrayList<>();
    public static final java.lang.String b = "audio";
    public static final java.lang.String c = "text";
    public static final java.lang.String d = "application";
    public static final java.lang.String e = "video/mp4";
    public static final java.lang.String f = "video/webm";
    public static final java.lang.String g = "video/3gpp";
    public static final java.lang.String h = "video/avc";
    public static final java.lang.String i = "video/hevc";
    public static final java.lang.String j = "video/x-vnd.on2.vp8";
    public static final java.lang.String k = "video/x-vnd.on2.vp9";
    public static final java.lang.String l = "video/mp4v-es";
    public static final java.lang.String m = "video/mpeg";
    public static final java.lang.String n = "video/mpeg2";
    public static final java.lang.String o = "video/wvc1";
    public static final java.lang.String p = "video/x-unknown";
    public static final java.lang.String q = "audio/mp4";
    public static final java.lang.String r = "audio/mp4a-latm";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f229s = "audio/webm";
    public static final java.lang.String t = "audio/mpeg";
    public static final java.lang.String u = "audio/mpeg-L1";
    public static final java.lang.String v = "audio/mpeg-L2";
    public static final java.lang.String w = "audio/raw";
    public static final java.lang.String x = "audio/g711-alaw";
    public static final java.lang.String y = "audio/g711-mlaw";
    public static final java.lang.String z = "audio/ac3";

    public static final class a {
        public final java.lang.String a;
        public final java.lang.String b;
        public final int c;

        public a(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }
    }

    private o() {
    }

    @androidx.annotation.Nullable
    public static java.lang.String a(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    default:
                        return null;
                }
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, int i2) {
        com.anythink.expressad.exoplayer.k.o.a aVar = new com.anythink.expressad.exoplayer.k.o.a(str, str2, i2);
        int size = al.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            java.util.ArrayList<com.anythink.expressad.exoplayer.k.o.a> arrayList = al;
            if (str.equals(arrayList.get(i3).a)) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        al.add(aVar);
    }

    public static boolean a(java.lang.String str) {
        return "audio".equals(k(str));
    }

    public static boolean b(java.lang.String str) {
        return "video".equals(k(str));
    }

    @androidx.annotation.Nullable
    public static java.lang.String c(@androidx.annotation.Nullable java.lang.String str) {
        java.lang.String str2 = null;
        if (str == null) {
            return null;
        }
        java.lang.String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            if (trim.startsWith("mp4a.")) {
                java.lang.String substring = trim.substring(5);
                if (substring.length() >= 2) {
                    try {
                        str2 = a(java.lang.Integer.parseInt(com.anythink.expressad.exoplayer.k.af.e(substring.substring(0, 2)), 16));
                    } catch (java.lang.NumberFormatException unused) {
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        }
        if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (trim.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (trim.startsWith("opus")) {
            return "audio/opus";
        }
        if (trim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.k.o.a aVar = al.get(i2);
            if (trim.startsWith(aVar.b)) {
                return aVar.a;
            }
        }
        return null;
    }

    public static int d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if ("text".equals(k(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
            return 4;
        }
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.k.o.a aVar = al.get(i2);
            if (str.equals(aVar.a)) {
                return aVar.c;
            }
        }
        return -1;
    }

    public static int e(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static int f(java.lang.String str) {
        return d(c(str));
    }

    private static boolean g(java.lang.String str) {
        return "text".equals(k(str));
    }

    private static boolean h(java.lang.String str) {
        return "application".equals(k(str));
    }

    @androidx.annotation.Nullable
    private static java.lang.String i(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.anythink.expressad.exoplayer.k.af.a(str, ",")) {
            java.lang.String c2 = c(str2);
            if (c2 != null && b(c2)) {
                return c2;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private static java.lang.String j(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.anythink.expressad.exoplayer.k.af.a(str, ",")) {
            java.lang.String c2 = c(str2);
            if (c2 != null && a(c2)) {
                return c2;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private static java.lang.String k(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new java.lang.IllegalArgumentException("Invalid mime type: ".concat(str));
    }

    @androidx.annotation.Nullable
    private static java.lang.String l(java.lang.String str) {
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.k.o.a aVar = al.get(i2);
            if (str.startsWith(aVar.b)) {
                return aVar.a;
            }
        }
        return null;
    }

    private static int m(java.lang.String str) {
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.k.o.a aVar = al.get(i2);
            if (str.equals(aVar.a)) {
                return aVar.c;
            }
        }
        return -1;
    }
}
