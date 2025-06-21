package com.google.android.exoplayer2.mediacodec;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes22.dex */
public final class MediaCodecUtil {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("^\\D?(\\d+)$");
    public static final java.util.HashMap<com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey, java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo>> b = new java.util.HashMap<>();
    public static int c = -1;

    public static final class CodecKey {
        public final java.lang.String a;
        public final boolean b;
        public final boolean c;

        public CodecKey(java.lang.String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey.class) {
                return false;
            }
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey = (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey) obj;
            return android.text.TextUtils.equals(this.a, codecKey.a) && this.b == codecKey.b && this.c == codecKey.c;
        }

        public int hashCode() {
            return ((((this.a.hashCode() + 31) * 31) + (this.b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }
    }

    public static class DecoderQueryException extends java.lang.Exception {
        private DecoderQueryException(java.lang.Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        public /* synthetic */ DecoderQueryException(java.lang.Throwable th, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.AnonymousClass1 anonymousClass1) {
            this(th);
        }
    }

    public interface MediaCodecListCompat {
        boolean a(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        android.media.MediaCodecInfo b(int i);

        boolean c(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class MediaCodecListCompatV16 implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat {
        public MediaCodecListCompatV16() {
        }

        public /* synthetic */ MediaCodecListCompatV16(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean a(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo b(int i) {
            return android.media.MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean c(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int d() {
            return android.media.MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean e() {
            return false;
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static final class MediaCodecListCompatV21 implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat {
        public final int a;

        @androidx.annotation.Nullable
        public android.media.MediaCodecInfo[] b;

        public MediaCodecListCompatV21(boolean z, boolean z2) {
            this.a = (z || z2) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean a(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo b(int i) {
            f();
            return this.b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean c(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int d() {
            f();
            return this.b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean e() {
            return true;
        }

        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"mediaCodecInfos"})
        public final void f() {
            if (this.b == null) {
                this.b = new android.media.MediaCodecList(this.a).getCodecInfos();
            }
        }
    }

    public interface ScoreProvider<T> {
        int a(T t);
    }

    public static boolean A(android.media.MediaCodecInfo mediaCodecInfo) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29) {
            return B(mediaCodecInfo);
        }
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(mediaCodecInfo.getName());
        if (lowerInvariant.startsWith("arc.")) {
            return false;
        }
        return lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("omx.ffmpeg.") || (lowerInvariant.startsWith("omx.sec.") && lowerInvariant.contains(".sw.")) || lowerInvariant.equals("omx.qcom.video.decoder.hevcswvdec") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.") || !(lowerInvariant.startsWith("omx.") || lowerInvariant.startsWith("c2."));
    }

    @androidx.annotation.RequiresApi(29)
    public static boolean B(android.media.MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
        return isSoftwareOnly;
    }

    public static boolean C(android.media.MediaCodecInfo mediaCodecInfo) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29) {
            return D(mediaCodecInfo);
        }
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(mediaCodecInfo.getName());
        return (lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.")) ? false : true;
    }

    @androidx.annotation.RequiresApi(29)
    public static boolean D(android.media.MediaCodecInfo mediaCodecInfo) {
        boolean isVendor;
        isVendor = mediaCodecInfo.isVendor();
        return isVendor;
    }

    public static /* synthetic */ int E(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        java.lang.String str = mediaCodecInfo.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (com.google.android.exoplayer2.util.Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int F(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.name.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int G(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.isFormatSupported(format) ? 1 : 0;
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException unused) {
            return -1;
        }
    }

    public static /* synthetic */ int H(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider scoreProvider, java.lang.Object obj, java.lang.Object obj2) {
        return scoreProvider.a(obj2) - scoreProvider.a(obj);
    }

    public static int I(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static <T> void J(java.util.List<T> list, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider<T> scoreProvider) {
        java.util.Collections.sort(list, new com.google.android.exoplayer2.mediacodec.e(scoreProvider));
    }

    public static int K(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return 256;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int L(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void e(java.lang.String str, java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 26 && com.google.android.exoplayer2.util.Util.DEVICE.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            J(list, new com.google.android.exoplayer2.mediacodec.b());
        }
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i < 21 && list.size() > 1) {
            java.lang.String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                J(list, new com.google.android.exoplayer2.mediacodec.c());
            }
        }
        if (i >= 30 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
    
        if (r3.equals("av01") == false) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.codecs;
        if (str == null) {
            return null;
        }
        java.lang.String[] split = str.split("\\.");
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType)) {
            return r(format.codecs, split);
        }
        char c2 = 0;
        java.lang.String str2 = split[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3004662:
                break;
            case 3006243:
                if (str2.equals("avc1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3199032:
                if (str2.equals("hev1")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3356560:
                if (str2.equals("mp4a")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3624515:
                if (str2.equals("vp09")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return n(format.codecs, split, format.colorInfo);
            case 1:
            case 2:
                return o(format.codecs, split);
            case 3:
            case 4:
                return s(format.codecs, split);
            case 5:
                return m(format.codecs, split);
            case 6:
                return t(format.codecs, split);
            default:
                return null;
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getDecoderInfo(java.lang.String str, boolean z, boolean z2) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z, boolean z2) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        synchronized (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.class) {
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey(str, z, z2);
            java.util.HashMap<com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey, java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo>> hashMap = b;
            java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> list = hashMap.get(codecKey);
            if (list != null) {
                return list;
            }
            int i = com.google.android.exoplayer2.util.Util.SDK_INT;
            java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> q = q(codecKey, i >= 21 ? new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV21(z, z2) : new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV16(null));
            if (z && q.isEmpty() && 21 <= i && i <= 23) {
                q = q(codecKey, new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV16(null));
                if (!q.isEmpty()) {
                    java.lang.String str2 = q.get(0).name;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 63 + java.lang.String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb.toString());
                }
            }
            e(str, q);
            java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> unmodifiableList = java.util.Collections.unmodifiableList(q);
            hashMap.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    @androidx.annotation.CheckResult
    public static java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosSortedByFormatSupport(java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> list, com.google.android.exoplayer2.Format format) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        J(arrayList, new com.google.android.exoplayer2.mediacodec.d(format));
        return arrayList;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getDecryptOnlyDecoderInfo() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        return getDecoderInfo("audio/raw", false, false);
    }

    public static int h(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
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

    public static int i(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    public static boolean j(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 22) {
            java.lang.String str2 = com.google.android.exoplayer2.util.Util.MODEL;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.Nullable
    public static java.lang.Integer k(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.Integer l(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m(java.lang.String str, java.lang.String[] strArr) {
        int I;
        if (strArr.length != 3) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed MP4A codec string: "));
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(com.google.android.exoplayer2.util.MimeTypes.getMimeTypeFromMp4ObjectType(java.lang.Integer.parseInt(strArr[1], 16))) && (I = I(java.lang.Integer.parseInt(strArr[2]))) != -1) {
                return new android.util.Pair<>(java.lang.Integer.valueOf(I), 0);
            }
        } catch (java.lang.NumberFormatException unused) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed MP4A codec string: "));
        }
        return null;
    }

    public static int maxH264DecodableFrameSize() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (c == -1) {
            int i = 0;
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false, false);
            if (decoderInfo != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i2 = 0;
                while (i < length) {
                    i2 = java.lang.Math.max(h(profileLevels[i].level), i2);
                    i++;
                }
                i = java.lang.Math.max(i2, com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            c = i;
        }
        return c;
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> n(java.lang.String str, java.lang.String[] strArr, @androidx.annotation.Nullable com.google.android.exoplayer2.video.ColorInfo colorInfo) {
        int i;
        if (strArr.length < 4) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed AV1 codec string: "));
            return null;
        }
        try {
            int parseInt = java.lang.Integer.parseInt(strArr[1]);
            int parseInt2 = java.lang.Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = java.lang.Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
                sb.append("Unknown AV1 profile: ");
                sb.append(parseInt);
                com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            if (parseInt3 != 8 && parseInt3 != 10) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(34);
                sb2.append("Unknown AV1 bit depth: ");
                sb2.append(parseInt3);
                com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            int i2 = parseInt3 != 8 ? (colorInfo == null || !(colorInfo.hdrStaticInfo != null || (i = colorInfo.colorTransfer) == 7 || i == 6)) ? 2 : 4096 : 1;
            int f = f(parseInt2);
            if (f != -1) {
                return new android.util.Pair<>(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(f));
            }
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(30);
            sb3.append("Unknown AV1 level: ");
            sb3.append(parseInt2);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb3.toString());
            return null;
        } catch (java.lang.NumberFormatException unused) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed AV1 codec string: "));
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> o(java.lang.String str, java.lang.String[] strArr) {
        int parseInt;
        int i;
        if (strArr.length < 2) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i = java.lang.Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = java.lang.Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    java.lang.String valueOf2 = java.lang.String.valueOf(str);
                    com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                int parseInt2 = java.lang.Integer.parseInt(strArr[1]);
                parseInt = java.lang.Integer.parseInt(strArr[2]);
                i = parseInt2;
            }
            int i2 = i(i);
            if (i2 == -1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
                sb.append("Unknown AVC profile: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            int g = g(parseInt);
            if (g != -1) {
                return new android.util.Pair<>(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(g));
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(30);
            sb2.append("Unknown AVC level: ");
            sb2.append(parseInt);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (java.lang.NumberFormatException unused) {
            java.lang.String valueOf3 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new java.lang.String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String p(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str, java.lang.String str2) {
        for (java.lang.String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    public static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> q(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat mediaCodecListCompat) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        java.lang.String p;
        java.lang.String str;
        java.lang.String str2;
        int i;
        boolean z;
        int i2;
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean c2;
        boolean a2;
        boolean z2;
        try {
            java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> arrayList = new java.util.ArrayList<>();
            java.lang.String str3 = codecKey.a;
            boolean e = mediaCodecListCompat.e();
            int i3 = 0;
            for (int d = mediaCodecListCompat.d(); i3 < d; d = i2) {
                android.media.MediaCodecInfo b2 = mediaCodecListCompat.b(i3);
                if (!v(b2)) {
                    java.lang.String name = b2.getName();
                    if (x(b2, name, e, str3) && (p = p(b2, name, str3)) != null) {
                        try {
                            capabilitiesForType = b2.getCapabilitiesForType(p);
                            c2 = mediaCodecListCompat.c("tunneled-playback", p, capabilitiesForType);
                            a2 = mediaCodecListCompat.a("tunneled-playback", p, capabilitiesForType);
                            z2 = codecKey.c;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            str = p;
                            str2 = name;
                            i = i3;
                            z = e;
                            i2 = d;
                        }
                        if ((z2 || !a2) && (!z2 || c2)) {
                            boolean c3 = mediaCodecListCompat.c("secure-playback", p, capabilitiesForType);
                            boolean a3 = mediaCodecListCompat.a("secure-playback", p, capabilitiesForType);
                            boolean z3 = codecKey.b;
                            if ((z3 || !a3) && (!z3 || c3)) {
                                boolean y = y(b2);
                                boolean A = A(b2);
                                boolean C = C(b2);
                                boolean j = j(name);
                                if (!(e && codecKey.b == c3) && (e || codecKey.b)) {
                                    str = p;
                                    str2 = name;
                                    i = i3;
                                    z = e;
                                    i2 = d;
                                    if (!z && c3) {
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(java.lang.String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, y, A, C, j, true));
                                        return arrayList;
                                    }
                                    i3 = i + 1;
                                    e = z;
                                } else {
                                    str = p;
                                    str2 = name;
                                    i = i3;
                                    z = e;
                                    i2 = d;
                                    try {
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(name, str3, p, capabilitiesForType, y, A, C, j, false));
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        if (com.google.android.exoplayer2.util.Util.SDK_INT > 23 || arrayList.isEmpty()) {
                                            java.lang.String str4 = str2;
                                            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str4).length() + 25 + str.length());
                                            sb.append("Failed to query codec ");
                                            sb.append(str4);
                                            sb.append(" (");
                                            sb.append(str);
                                            sb.append(")");
                                            com.google.android.exoplayer2.util.Log.e("MediaCodecUtil", sb.toString());
                                            throw e;
                                        }
                                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 46);
                                        sb2.append("Skipping codec ");
                                        sb2.append(str2);
                                        sb2.append(" (failed to query capabilities)");
                                        com.google.android.exoplayer2.util.Log.e("MediaCodecUtil", sb2.toString());
                                        i3 = i + 1;
                                        e = z;
                                    }
                                    i3 = i + 1;
                                    e = z;
                                }
                            }
                        }
                    }
                }
                i = i3;
                z = e;
                i2 = d;
                i3 = i + 1;
                e = z;
            }
            return arrayList;
        } catch (java.lang.Exception e4) {
            throw new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException(e4, null);
        }
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> r(java.lang.String str, java.lang.String[] strArr) {
        if (strArr.length < 3) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        java.util.regex.Matcher matcher = a.matcher(strArr[1]);
        if (!matcher.matches()) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        java.lang.String group = matcher.group(1);
        java.lang.Integer l = l(group);
        if (l == null) {
            java.lang.String valueOf3 = java.lang.String.valueOf(group);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(valueOf3) : new java.lang.String("Unknown Dolby Vision profile string: "));
            return null;
        }
        java.lang.String str2 = strArr[2];
        java.lang.Integer k = k(str2);
        if (k != null) {
            return new android.util.Pair<>(l, k);
        }
        java.lang.String valueOf4 = java.lang.String.valueOf(str2);
        com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown Dolby Vision level string: ".concat(valueOf4) : new java.lang.String("Unknown Dolby Vision level string: "));
        return null;
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> s(java.lang.String str, java.lang.String[] strArr) {
        if (strArr.length < 4) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        int i = 1;
        java.util.regex.Matcher matcher = a.matcher(strArr[1]);
        if (!matcher.matches()) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        java.lang.String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!"2".equals(group)) {
                java.lang.String valueOf3 = java.lang.String.valueOf(group);
                com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf3) : new java.lang.String("Unknown HEVC profile string: "));
                return null;
            }
            i = 2;
        }
        java.lang.String str2 = strArr[3];
        java.lang.Integer u = u(str2);
        if (u != null) {
            return new android.util.Pair<>(java.lang.Integer.valueOf(i), u);
        }
        java.lang.String valueOf4 = java.lang.String.valueOf(str2);
        com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf4) : new java.lang.String("Unknown HEVC level string: "));
        return null;
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> t(java.lang.String str, java.lang.String[] strArr) {
        if (strArr.length < 3) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf) : new java.lang.String("Ignoring malformed VP9 codec string: "));
            return null;
        }
        try {
            int parseInt = java.lang.Integer.parseInt(strArr[1]);
            int parseInt2 = java.lang.Integer.parseInt(strArr[2]);
            int L = L(parseInt);
            if (L == -1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
                sb.append("Unknown VP9 profile: ");
                sb.append(parseInt);
                com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            int K = K(parseInt2);
            if (K != -1) {
                return new android.util.Pair<>(java.lang.Integer.valueOf(L), java.lang.Integer.valueOf(K));
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(30);
            sb2.append("Unknown VP9 level: ");
            sb2.append(parseInt2);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (java.lang.NumberFormatException unused) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf2) : new java.lang.String("Ignoring malformed VP9 codec string: "));
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.Integer u(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static boolean v(android.media.MediaCodecInfo mediaCodecInfo) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 29 && w(mediaCodecInfo);
    }

    @androidx.annotation.RequiresApi(29)
    public static boolean w(android.media.MediaCodecInfo mediaCodecInfo) {
        boolean isAlias;
        isAlias = mediaCodecInfo.isAlias();
        return isAlias;
    }

    public static void warmDecoderInfoCache(java.lang.String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e) {
            com.google.android.exoplayer2.util.Log.e("MediaCodecUtil", "Codec warming failed", e);
        }
    }

    public static boolean x(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str, boolean z, java.lang.String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            java.lang.String str3 = com.google.android.exoplayer2.util.Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            java.lang.String str4 = com.google.android.exoplayer2.util.Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            java.lang.String str5 = com.google.android.exoplayer2.util.Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER))) {
            java.lang.String str6 = com.google.android.exoplayer2.util.Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER)) {
            java.lang.String str7 = com.google.android.exoplayer2.util.Util.DEVICE;
            if (str7.startsWith(com.anythink.expressad.foundation.g.a.O) || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && com.google.android.exoplayer2.util.Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean y(android.media.MediaCodecInfo mediaCodecInfo) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 29 ? z(mediaCodecInfo) : !A(mediaCodecInfo);
    }

    @androidx.annotation.RequiresApi(29)
    public static boolean z(android.media.MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
        return isHardwareAccelerated;
    }
}
