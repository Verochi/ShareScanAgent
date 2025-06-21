package com.anythink.expressad.exoplayer.f;

@android.annotation.SuppressLint({"InlinedApi"})
@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class d {
    private static final java.lang.String a = "MediaCodecUtil";
    private static final java.lang.String c = "OMX.MTK.AUDIO.DECODER.RAW";
    private static final android.util.SparseIntArray g;
    private static final android.util.SparseIntArray h;
    private static final java.lang.String i = "avc1";
    private static final java.lang.String j = "avc2";
    private static final java.util.Map<java.lang.String, java.lang.Integer> k;
    private static final java.lang.String l = "hev1";
    private static final java.lang.String m = "hvc1";
    private static final java.lang.String b = "OMX.google.raw.decoder";
    private static final com.anythink.expressad.exoplayer.f.a d = com.anythink.expressad.exoplayer.f.a.a(b);
    private static final java.util.regex.Pattern e = java.util.regex.Pattern.compile("^\\D?(\\d+)$");
    private static final java.util.HashMap<com.anythink.expressad.exoplayer.f.d.a, java.util.List<com.anythink.expressad.exoplayer.f.a>> f = new java.util.HashMap<>();
    private static int n = -1;

    public static final class a {
        public final java.lang.String a;
        public final boolean b;

        public a(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == com.anythink.expressad.exoplayer.f.d.a.class) {
                com.anythink.expressad.exoplayer.f.d.a aVar = (com.anythink.expressad.exoplayer.f.d.a) obj;
                if (android.text.TextUtils.equals(this.a, aVar.a) && this.b == aVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            java.lang.String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    public static class b extends java.lang.Exception {
        private b(java.lang.Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        public /* synthetic */ b(java.lang.Throwable th, byte b) {
            this(th);
        }
    }

    public interface c {
        int a();

        android.media.MediaCodecInfo a(int i);

        boolean a(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* renamed from: com.anythink.expressad.exoplayer.f.d$d, reason: collision with other inner class name */
    public static final class C0193d implements com.anythink.expressad.exoplayer.f.d.c {
        private C0193d() {
        }

        public /* synthetic */ C0193d(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            return android.media.MediaCodecList.getCodecCount();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final android.media.MediaCodecInfo a(int i) {
            return android.media.MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return false;
        }
    }

    @android.annotation.TargetApi(21)
    public static final class e implements com.anythink.expressad.exoplayer.f.d.c {
        private final int a;
        private android.media.MediaCodecInfo[] b;

        public e(boolean z) {
            this.a = z ? 1 : 0;
        }

        private void c() {
            if (this.b == null) {
                this.b = new android.media.MediaCodecList(this.a).getCodecInfos();
            }
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            c();
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final android.media.MediaCodecInfo a(int i) {
            c();
            return this.b[i];
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return true;
        }
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        g = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        android.util.SparseIntArray sparseIntArray2 = new android.util.SparseIntArray();
        h = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        java.util.HashMap hashMap = new java.util.HashMap();
        k = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", java.lang.Integer.valueOf(com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA));
    }

    private d() {
    }

    private static int a(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0044, code lost:
    
        if (r3.equals(com.anythink.expressad.exoplayer.f.d.i) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String[] split = str.split("\\.");
        char c2 = 0;
        java.lang.String str2 = split[0];
        str2.hashCode();
        int i2 = 2;
        switch (str2.hashCode()) {
            case 3006243:
                break;
            case 3006244:
                if (str2.equals(j)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3199032:
                if (str2.equals(l)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3214780:
                if (str2.equals(m)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 2:
            case 3:
                if (split.length >= 4) {
                    java.util.regex.Matcher matcher = e.matcher(split[1]);
                    if (!matcher.matches()) {
                        "Ignoring malformed HEVC codec string: ".concat(str);
                        break;
                    } else {
                        java.lang.String group = matcher.group(1);
                        if (!"1".equals(group)) {
                            if (!"2".equals(group)) {
                                "Unknown HEVC profile string: ".concat(java.lang.String.valueOf(group));
                                break;
                            }
                        } else {
                            i2 = 1;
                        }
                        java.lang.Integer num = k.get(split[3]);
                        if (num != null) {
                            break;
                        } else {
                            new java.lang.StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
                            break;
                        }
                    }
                } else {
                    "Ignoring malformed HEVC codec string: ".concat(str);
                    break;
                }
        }
        return null;
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String str, java.lang.String[] strArr) {
        int i2;
        if (strArr.length < 4) {
            "Ignoring malformed HEVC codec string: ".concat(java.lang.String.valueOf(str));
            return null;
        }
        java.util.regex.Matcher matcher = e.matcher(strArr[1]);
        if (!matcher.matches()) {
            "Ignoring malformed HEVC codec string: ".concat(java.lang.String.valueOf(str));
            return null;
        }
        java.lang.String group = matcher.group(1);
        if ("1".equals(group)) {
            i2 = 1;
        } else {
            if (!"2".equals(group)) {
                "Unknown HEVC profile string: ".concat(java.lang.String.valueOf(group));
                return null;
            }
            i2 = 2;
        }
        java.lang.Integer num = k.get(strArr[3]);
        if (num != null) {
            return new android.util.Pair<>(java.lang.Integer.valueOf(i2), num);
        }
        new java.lang.StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
        return null;
    }

    public static com.anythink.expressad.exoplayer.f.a a() {
        return d;
    }

    @androidx.annotation.Nullable
    public static com.anythink.expressad.exoplayer.f.a a(java.lang.String str, boolean z) {
        java.util.List<com.anythink.expressad.exoplayer.f.a> c2 = c(str, z);
        if (c2.isEmpty()) {
            return null;
        }
        return c2.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0199, code lost:
    
        if ("SCV31".equals(r13) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0137, code lost:
    
        if ("C1605".equals(r14) == false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0209 A[Catch: Exception -> 0x02de, TryCatch #1 {Exception -> 0x02de, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x002f, B:14:0x0035, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:22:0x0055, B:24:0x005d, B:28:0x006d, B:32:0x0078, B:34:0x0080, B:36:0x008a, B:38:0x0094, B:43:0x00a1, B:45:0x00a9, B:47:0x00b3, B:49:0x00bb, B:51:0x00c3, B:53:0x00cb, B:55:0x00d3, B:57:0x00db, B:59:0x00e3, B:61:0x00eb, B:63:0x00f3, B:65:0x00fb, B:67:0x0103, B:71:0x010f, B:73:0x0117, B:75:0x0121, B:77:0x0129, B:79:0x0131, B:83:0x0141, B:85:0x0149, B:87:0x0151, B:89:0x0159, B:91:0x0163, B:93:0x016b, B:95:0x0173, B:97:0x017b, B:99:0x0183, B:101:0x018b, B:103:0x0193, B:107:0x01a3, B:109:0x01ab, B:111:0x01b3, B:113:0x01bd, B:115:0x01c5, B:117:0x01cb, B:119:0x01d3, B:123:0x01df, B:125:0x01e7, B:128:0x01f1, B:130:0x01fb, B:135:0x0209, B:137:0x0211, B:172:0x0290, B:174:0x0296, B:176:0x029c, B:179:0x02ac, B:180:0x02c3), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0254 A[Catch: Exception -> 0x024f, TryCatch #0 {Exception -> 0x024f, blocks: (B:188:0x022b, B:190:0x0235, B:192:0x023d, B:194:0x0245, B:152:0x0254, B:156:0x0262, B:158:0x025d, B:163:0x026e), top: B:187:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0296 A[Catch: Exception -> 0x02de, TryCatch #1 {Exception -> 0x02de, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x002f, B:14:0x0035, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:22:0x0055, B:24:0x005d, B:28:0x006d, B:32:0x0078, B:34:0x0080, B:36:0x008a, B:38:0x0094, B:43:0x00a1, B:45:0x00a9, B:47:0x00b3, B:49:0x00bb, B:51:0x00c3, B:53:0x00cb, B:55:0x00d3, B:57:0x00db, B:59:0x00e3, B:61:0x00eb, B:63:0x00f3, B:65:0x00fb, B:67:0x0103, B:71:0x010f, B:73:0x0117, B:75:0x0121, B:77:0x0129, B:79:0x0131, B:83:0x0141, B:85:0x0149, B:87:0x0151, B:89:0x0159, B:91:0x0163, B:93:0x016b, B:95:0x0173, B:97:0x017b, B:99:0x0183, B:101:0x018b, B:103:0x0193, B:107:0x01a3, B:109:0x01ab, B:111:0x01b3, B:113:0x01bd, B:115:0x01c5, B:117:0x01cb, B:119:0x01d3, B:123:0x01df, B:125:0x01e7, B:128:0x01f1, B:130:0x01fb, B:135:0x0209, B:137:0x0211, B:172:0x0290, B:174:0x0296, B:176:0x029c, B:179:0x02ac, B:180:0x02c3), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ac A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02d3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.ArrayList<com.anythink.expressad.exoplayer.f.a> a(com.anythink.expressad.exoplayer.f.d.a aVar, com.anythink.expressad.exoplayer.f.d.c cVar, java.lang.String str) {
        boolean z;
        int i2;
        android.media.MediaCodecInfo mediaCodecInfo;
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z2;
        int i3;
        com.anythink.expressad.exoplayer.f.d.c cVar2 = cVar;
        try {
            java.util.ArrayList<com.anythink.expressad.exoplayer.f.a> arrayList = new java.util.ArrayList<>();
            java.lang.String str2 = aVar.a;
            int a2 = cVar.a();
            boolean b2 = cVar.b();
            int i4 = 0;
            while (i4 < a2) {
                android.media.MediaCodecInfo a3 = cVar2.a(i4);
                java.lang.String name = a3.getName();
                if (!a3.isEncoder() && ((b2 || !name.endsWith(".secure")) && (((i3 = com.anythink.expressad.exoplayer.k.af.a) >= 21 || (!"CIPAACDecoder".equals(name) && !"CIPMP3Decoder".equals(name) && !"CIPVorbisDecoder".equals(name) && !"CIPAMRNBDecoder".equals(name) && !"AACDecoder".equals(name) && !"MP3Decoder".equals(name))) && (i3 >= 18 || !"OMX.SEC.MP3.Decoder".equals(name))))) {
                    if (i3 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name)) {
                        java.lang.String str3 = com.anythink.expressad.exoplayer.k.af.b;
                        if (!"a70".equals(str3)) {
                            if ("Xiaomi".equals(com.anythink.expressad.exoplayer.k.af.c) && str3.startsWith("HM")) {
                            }
                        }
                    }
                    if (i3 == 16 && "OMX.qcom.audio.decoder.mp3".equals(name)) {
                        java.lang.String str4 = com.anythink.expressad.exoplayer.k.af.b;
                        if (!"dlxu".equals(str4)) {
                            if (!"protou".equals(str4)) {
                                if (!"ville".equals(str4)) {
                                    if (!"villeplus".equals(str4)) {
                                        if (!"villec2".equals(str4)) {
                                            if (!str4.startsWith("gee")) {
                                                if (!"C6602".equals(str4)) {
                                                    if (!"C6603".equals(str4)) {
                                                        if (!"C6606".equals(str4)) {
                                                            if (!"C6616".equals(str4)) {
                                                                if (!"L36h".equals(str4)) {
                                                                    if ("SO-02E".equals(str4)) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i3 == 16 && "OMX.qcom.audio.decoder.aac".equals(name)) {
                        java.lang.String str5 = com.anythink.expressad.exoplayer.k.af.b;
                        if (!"C1504".equals(str5)) {
                            if (!"C1505".equals(str5)) {
                                if (!"C1604".equals(str5)) {
                                }
                            }
                        }
                    }
                    if (i3 < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && "samsung".equals(com.anythink.expressad.exoplayer.k.af.c))) {
                        java.lang.String str6 = com.anythink.expressad.exoplayer.k.af.b;
                        if (!str6.startsWith("zeroflte")) {
                            if (!str6.startsWith("zerolte")) {
                                if (!str6.startsWith("zenlte")) {
                                    if (!"SC-05G".equals(str6)) {
                                        if (!"marinelteatt".equals(str6)) {
                                            if (!"404SC".equals(str6)) {
                                                if (!"SC-04G".equals(str6)) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i3 <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(com.anythink.expressad.exoplayer.k.af.c)) {
                        java.lang.String str7 = com.anythink.expressad.exoplayer.k.af.b;
                        if (!str7.startsWith(com.anythink.expressad.foundation.g.a.O)) {
                            if (!str7.startsWith("serrano")) {
                                if (!str7.startsWith("jflte")) {
                                    if (!str7.startsWith("santos")) {
                                        if (str7.startsWith("t0")) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i3 > 19 || !com.anythink.expressad.exoplayer.k.af.b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(name)) {
                        if ("audio/eac3-joc".equals(str) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name)) {
                            z = false;
                            if (z) {
                            }
                            i4++;
                            cVar2 = cVar;
                            a2 = a2;
                        } else {
                            z = true;
                            if (z) {
                                java.lang.String[] supportedTypes = a3.getSupportedTypes();
                                int length = supportedTypes.length;
                                int i5 = 0;
                                while (i5 < length) {
                                    java.lang.String str8 = supportedTypes[i5];
                                    if (str8.equalsIgnoreCase(str2)) {
                                        try {
                                            capabilitiesForType = a3.getCapabilitiesForType(str8);
                                            i2 = a2;
                                        } catch (java.lang.Exception e2) {
                                            e = e2;
                                            i2 = a2;
                                        }
                                        try {
                                            boolean a4 = cVar2.a(str2, capabilitiesForType);
                                            mediaCodecInfo = a3;
                                            if (com.anythink.expressad.exoplayer.k.af.a <= 22) {
                                                try {
                                                    java.lang.String str9 = com.anythink.expressad.exoplayer.k.af.d;
                                                    if (("ODROID-XU3".equals(str9) || "Nexus 10".equals(str9)) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                                        z2 = true;
                                                        if (b2) {
                                                            if (aVar.b == a4) {
                                                            }
                                                            arrayList.add(com.anythink.expressad.exoplayer.f.a.a(name, str2, capabilitiesForType, z2, false));
                                                        }
                                                        if (b2 && !aVar.b) {
                                                            arrayList.add(com.anythink.expressad.exoplayer.f.a.a(name, str2, capabilitiesForType, z2, false));
                                                        } else if (!b2 && a4) {
                                                            try {
                                                                arrayList.add(com.anythink.expressad.exoplayer.f.a.a(name + ".secure", str2, capabilitiesForType, z2, true));
                                                                return arrayList;
                                                            } catch (java.lang.Exception e3) {
                                                                e = e3;
                                                                if (com.anythink.expressad.exoplayer.k.af.a > 23) {
                                                                }
                                                                java.lang.StringBuilder sb = new java.lang.StringBuilder("Failed to query codec ");
                                                                sb.append(name);
                                                                sb.append(" (");
                                                                sb.append(str8);
                                                                sb.append(")");
                                                                throw e;
                                                            }
                                                        }
                                                    }
                                                } catch (java.lang.Exception e4) {
                                                    e = e4;
                                                    if (com.anythink.expressad.exoplayer.k.af.a > 23 || arrayList.isEmpty()) {
                                                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Failed to query codec ");
                                                        sb2.append(name);
                                                        sb2.append(" (");
                                                        sb2.append(str8);
                                                        sb2.append(")");
                                                        throw e;
                                                    }
                                                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder("Skipping codec ");
                                                    sb3.append(name);
                                                    sb3.append(" (failed to query capabilities)");
                                                    i5++;
                                                    cVar2 = cVar;
                                                    a2 = i2;
                                                    a3 = mediaCodecInfo;
                                                }
                                            }
                                            z2 = false;
                                            if (b2) {
                                            }
                                            if (b2) {
                                            }
                                            if (!b2) {
                                                arrayList.add(com.anythink.expressad.exoplayer.f.a.a(name + ".secure", str2, capabilitiesForType, z2, true));
                                                return arrayList;
                                            }
                                        } catch (java.lang.Exception e5) {
                                            e = e5;
                                            mediaCodecInfo = a3;
                                            if (com.anythink.expressad.exoplayer.k.af.a > 23) {
                                            }
                                            java.lang.StringBuilder sb22 = new java.lang.StringBuilder("Failed to query codec ");
                                            sb22.append(name);
                                            sb22.append(" (");
                                            sb22.append(str8);
                                            sb22.append(")");
                                            throw e;
                                        }
                                    } else {
                                        i2 = a2;
                                        mediaCodecInfo = a3;
                                    }
                                    i5++;
                                    cVar2 = cVar;
                                    a2 = i2;
                                    a3 = mediaCodecInfo;
                                }
                            }
                            i4++;
                            cVar2 = cVar;
                            a2 = a2;
                        }
                    }
                }
                z = false;
                if (z) {
                }
                i4++;
                cVar2 = cVar;
                a2 = a2;
            }
            return arrayList;
        } catch (java.lang.Exception e6) {
            throw new com.anythink.expressad.exoplayer.f.d.b(e6, (byte) 0);
        }
    }

    private static void a(java.util.List<com.anythink.expressad.exoplayer.f.a> list) {
        if (com.anythink.expressad.exoplayer.k.af.a < 26) {
            if (list.size() <= 1 || !c.equals(list.get(0).c)) {
                return;
            }
            for (int i2 = 1; i2 < list.size(); i2++) {
                com.anythink.expressad.exoplayer.f.a aVar = list.get(i2);
                if (b.equals(aVar.c)) {
                    list.remove(i2);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static boolean a(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str, boolean z, java.lang.String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = com.anythink.expressad.exoplayer.k.af.a;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i2 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            java.lang.String str3 = com.anythink.expressad.exoplayer.k.af.b;
            if ("a70".equals(str3) || ("Xiaomi".equals(com.anythink.expressad.exoplayer.k.af.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            java.lang.String str4 = com.anythink.expressad.exoplayer.k.af.b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            java.lang.String str5 = com.anythink.expressad.exoplayer.k.af.b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i2 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(com.anythink.expressad.exoplayer.k.af.c))) {
            java.lang.String str6 = com.anythink.expressad.exoplayer.k.af.b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i2 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(com.anythink.expressad.exoplayer.k.af.c)) {
            java.lang.String str7 = com.anythink.expressad.exoplayer.k.af.b;
            if (str7.startsWith(com.anythink.expressad.foundation.g.a.O) || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i2 <= 19 && com.anythink.expressad.exoplayer.k.af.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static int b() {
        if (n == -1) {
            int i2 = 0;
            com.anythink.expressad.exoplayer.f.a a2 = a("video/avc", false);
            if (a2 != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] a3 = a2.a();
                int length = a3.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = a3[i2].level;
                    int i5 = 25344;
                    if (i4 != 1 && i4 != 2) {
                        i5 = 9437184;
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                break;
                            case 64:
                                i5 = 202752;
                                break;
                            case 128:
                            case 256:
                                i5 = 414720;
                                break;
                            case 512:
                                i5 = 921600;
                                break;
                            case 1024:
                                i5 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i5 = 2097152;
                                break;
                            case 8192:
                                i5 = 2228224;
                                break;
                            case 16384:
                                i5 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i5 = -1;
                                break;
                        }
                    }
                    i3 = java.lang.Math.max(i5, i3);
                    i2++;
                }
                i2 = java.lang.Math.max(i3, com.anythink.expressad.exoplayer.k.af.a >= 21 ? 345600 : 172800);
            }
            n = i2;
        }
        return n;
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> b(java.lang.String str, java.lang.String[] strArr) {
        java.lang.Integer valueOf;
        java.lang.Integer num;
        if (strArr.length < 2) {
            "Ignoring malformed AVC codec string: ".concat(java.lang.String.valueOf(str));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1].substring(4), 16));
            } else {
                if (strArr.length < 3) {
                    "Ignoring malformed AVC codec string: ".concat(java.lang.String.valueOf(str));
                    return null;
                }
                java.lang.Integer valueOf2 = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1]));
                valueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[2]));
                num = valueOf2;
            }
            int i2 = g.get(num.intValue(), -1);
            if (i2 == -1) {
                "Unknown AVC profile: ".concat(java.lang.String.valueOf(num));
                return null;
            }
            int i3 = h.get(valueOf.intValue(), -1);
            if (i3 != -1) {
                return new android.util.Pair<>(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
            }
            "Unknown AVC level: ".concat(java.lang.String.valueOf(valueOf));
            return null;
        } catch (java.lang.NumberFormatException unused) {
            "Ignoring malformed AVC codec string: ".concat(java.lang.String.valueOf(str));
            return null;
        }
    }

    private static void b(java.lang.String str, boolean z) {
        try {
            c(str, z);
        } catch (com.anythink.expressad.exoplayer.f.d.b unused) {
        }
    }

    private static boolean b(java.lang.String str) {
        if (com.anythink.expressad.exoplayer.k.af.a > 22) {
            return false;
        }
        java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.d;
        if ("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static synchronized java.util.List<com.anythink.expressad.exoplayer.f.a> c(java.lang.String str, boolean z) {
        synchronized (com.anythink.expressad.exoplayer.f.d.class) {
            com.anythink.expressad.exoplayer.f.d.a aVar = new com.anythink.expressad.exoplayer.f.d.a(str, z);
            java.util.HashMap<com.anythink.expressad.exoplayer.f.d.a, java.util.List<com.anythink.expressad.exoplayer.f.a>> hashMap = f;
            java.util.List<com.anythink.expressad.exoplayer.f.a> list = hashMap.get(aVar);
            if (list != null) {
                return list;
            }
            int i2 = com.anythink.expressad.exoplayer.k.af.a;
            com.anythink.expressad.exoplayer.f.d.c eVar = i2 >= 21 ? new com.anythink.expressad.exoplayer.f.d.e(z) : new com.anythink.expressad.exoplayer.f.d.C0193d((byte) 0);
            java.util.ArrayList<com.anythink.expressad.exoplayer.f.a> a2 = a(aVar, eVar, str);
            if (z && a2.isEmpty() && 21 <= i2 && i2 <= 23) {
                eVar = new com.anythink.expressad.exoplayer.f.d.C0193d((byte) 0);
                a2 = a(aVar, eVar, str);
                if (!a2.isEmpty()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(a2.get(0).c);
                }
            }
            if ("audio/eac3-joc".equals(str)) {
                a2.addAll(a(new com.anythink.expressad.exoplayer.f.d.a("audio/eac3", aVar.b), eVar, str));
            }
            a(a2);
            java.util.List<com.anythink.expressad.exoplayer.f.a> unmodifiableList = java.util.Collections.unmodifiableList(a2);
            hashMap.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }
}
