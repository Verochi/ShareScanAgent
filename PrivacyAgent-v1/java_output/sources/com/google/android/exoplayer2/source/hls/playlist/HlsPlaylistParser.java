package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public final class HlsPlaylistParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    public final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist n;
    public static final java.util.regex.Pattern t = java.util.regex.Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final java.util.regex.Pattern u = java.util.regex.Pattern.compile("VIDEO=\"(.+?)\"");
    public static final java.util.regex.Pattern v = java.util.regex.Pattern.compile("AUDIO=\"(.+?)\"");
    public static final java.util.regex.Pattern w = java.util.regex.Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final java.util.regex.Pattern x = java.util.regex.Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    public static final java.util.regex.Pattern y = java.util.regex.Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final java.util.regex.Pattern z = java.util.regex.Pattern.compile("CHANNELS=\"(.+?)\"");
    public static final java.util.regex.Pattern A = java.util.regex.Pattern.compile("CODECS=\"(.+?)\"");
    public static final java.util.regex.Pattern B = java.util.regex.Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final java.util.regex.Pattern C = java.util.regex.Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final java.util.regex.Pattern D = java.util.regex.Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final java.util.regex.Pattern E = java.util.regex.Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final java.util.regex.Pattern F = java.util.regex.Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final java.util.regex.Pattern G = java.util.regex.Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final java.util.regex.Pattern H = java.util.regex.Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final java.util.regex.Pattern I = java.util.regex.Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final java.util.regex.Pattern J = java.util.regex.Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final java.util.regex.Pattern K = java.util.regex.Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final java.util.regex.Pattern L = java.util.regex.Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final java.util.regex.Pattern M = java.util.regex.Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final java.util.regex.Pattern N = java.util.regex.Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final java.util.regex.Pattern O = java.util.regex.Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final java.util.regex.Pattern P = java.util.regex.Pattern.compile("URI=\"(.+?)\"");
    public static final java.util.regex.Pattern Q = java.util.regex.Pattern.compile("IV=([^,.*]+)");
    public static final java.util.regex.Pattern R = java.util.regex.Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final java.util.regex.Pattern S = java.util.regex.Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final java.util.regex.Pattern T = java.util.regex.Pattern.compile("NAME=\"(.+?)\"");
    public static final java.util.regex.Pattern U = java.util.regex.Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final java.util.regex.Pattern V = java.util.regex.Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final java.util.regex.Pattern W = java.util.regex.Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final java.util.regex.Pattern X = b("AUTOSELECT");
    public static final java.util.regex.Pattern Y = b("DEFAULT");
    public static final java.util.regex.Pattern Z = b("FORCED");
    public static final java.util.regex.Pattern a0 = java.util.regex.Pattern.compile("VALUE=\"(.+?)\"");
    public static final java.util.regex.Pattern b0 = java.util.regex.Pattern.compile("IMPORT=\"(.+?)\"");
    public static final java.util.regex.Pattern c0 = java.util.regex.Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static class LineIterator {
        public final java.io.BufferedReader a;
        public final java.util.Queue<java.lang.String> b;

        @androidx.annotation.Nullable
        public java.lang.String c;

        public LineIterator(java.util.Queue<java.lang.String> queue, java.io.BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws java.io.IOException {
            java.lang.String trim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b.poll());
                return true;
            }
            do {
                java.lang.String readLine = this.a.readLine();
                this.c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public java.lang.String b() throws java.io.IOException {
            if (!a()) {
                throw new java.util.NoSuchElementException();
            }
            java.lang.String str = this.c;
            this.c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.EMPTY);
    }

    public HlsPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist) {
        this.n = hlsMasterPlaylist;
    }

    public static boolean a(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int u2 = u(bufferedReader, true, read);
        for (int i = 0; i < 7; i++) {
            if (u2 != "#EXTM3U".charAt(i)) {
                return false;
            }
            u2 = bufferedReader.read();
        }
        return com.google.android.exoplayer2.util.Util.isLinebreak(u(bufferedReader, false, u2));
    }

    public static java.util.regex.Pattern b(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 9);
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return java.util.regex.Pattern.compile(sb.toString());
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant c(java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> arrayList, java.lang.String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant d(java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> arrayList, java.lang.String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant e(java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> arrayList, java.lang.String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    public static double f(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Double.parseDouble(s(str, pattern, java.util.Collections.emptyMap()));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.drm.DrmInitData.SchemeData g(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.ParserException {
        java.lang.String o = o(str, O, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            java.lang.String s2 = s(str, P, map);
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C.WIDEVINE_UUID, "video/mp4", android.util.Base64.decode(s2.substring(s2.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C.WIDEVINE_UUID, "hls", com.google.android.exoplayer2.util.Util.getUtf8Bytes(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(o)) {
            return null;
        }
        java.lang.String s3 = s(str, P, map);
        byte[] decode = android.util.Base64.decode(s3.substring(s3.indexOf(44)), 0);
        java.util.UUID uuid = com.google.android.exoplayer2.C.PLAYREADY_UUID;
        return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(uuid, "video/mp4", com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(uuid, decode));
    }

    public static java.lang.String h(java.lang.String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static int i(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Integer.parseInt(s(str, pattern, java.util.Collections.emptyMap()));
    }

    public static long j(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Long.parseLong(s(str, pattern, java.util.Collections.emptyMap()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist k(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator lineIterator, java.lang.String str) throws java.io.IOException {
        android.net.Uri uri;
        char c;
        com.google.android.exoplayer2.Format format;
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        java.lang.String str2;
        java.util.ArrayList arrayList3;
        int parseInt;
        java.lang.String str3;
        java.lang.String str4;
        boolean z2;
        int i;
        java.util.ArrayList arrayList4;
        java.util.ArrayList arrayList5;
        java.util.ArrayList arrayList6;
        java.util.ArrayList arrayList7;
        java.util.ArrayList arrayList8;
        int i2;
        int i3;
        java.util.ArrayList arrayList9;
        java.util.ArrayList arrayList10;
        android.net.Uri resolveToUri;
        java.util.HashMap hashMap;
        int i4;
        java.lang.String str5 = str;
        java.util.HashMap hashMap2 = new java.util.HashMap();
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.ArrayList arrayList11 = new java.util.ArrayList();
        java.util.ArrayList arrayList12 = new java.util.ArrayList();
        java.util.ArrayList arrayList13 = new java.util.ArrayList();
        java.util.ArrayList arrayList14 = new java.util.ArrayList();
        java.util.ArrayList arrayList15 = new java.util.ArrayList();
        java.util.ArrayList arrayList16 = new java.util.ArrayList();
        java.util.ArrayList arrayList17 = new java.util.ArrayList();
        java.util.ArrayList arrayList18 = new java.util.ArrayList();
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            java.lang.String str6 = "application/x-mpegURL";
            if (!lineIterator.a()) {
                java.util.HashMap hashMap4 = hashMap2;
                java.util.ArrayList arrayList19 = arrayList16;
                java.util.ArrayList arrayList20 = arrayList12;
                java.util.ArrayList arrayList21 = arrayList13;
                java.util.ArrayList arrayList22 = arrayList14;
                java.util.ArrayList arrayList23 = arrayList15;
                java.util.ArrayList arrayList24 = arrayList18;
                boolean z5 = z3;
                java.util.ArrayList arrayList25 = arrayList17;
                java.util.ArrayList arrayList26 = new java.util.ArrayList();
                java.util.HashSet hashSet = new java.util.HashSet();
                int i5 = 0;
                while (true) {
                    uri = null;
                    if (i5 >= arrayList11.size()) {
                        break;
                    }
                    com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant variant = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant) arrayList11.get(i5);
                    if (hashSet.add(variant.url)) {
                        com.google.android.exoplayer2.util.Assertions.checkState(variant.format.metadata == null);
                        arrayList26.add(variant.copyWithFormat(variant.format.buildUpon().setMetadata(new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry(null, null, (java.util.List) com.google.android.exoplayer2.util.Assertions.checkNotNull((java.util.ArrayList) hashMap4.get(variant.url))))).build()));
                    }
                    i5++;
                }
                java.util.ArrayList arrayList27 = null;
                com.google.android.exoplayer2.Format format2 = null;
                int i6 = 0;
                while (i6 < arrayList19.size()) {
                    java.util.ArrayList arrayList28 = arrayList19;
                    java.lang.String str7 = (java.lang.String) arrayList28.get(i6);
                    java.lang.String s2 = s(str7, U, hashMap3);
                    java.lang.String s3 = s(str7, T, hashMap3);
                    com.google.android.exoplayer2.Format.Builder builder = new com.google.android.exoplayer2.Format.Builder();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(s2).length() + 1 + java.lang.String.valueOf(s3).length());
                    sb.append(s2);
                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    sb.append(s3);
                    com.google.android.exoplayer2.Format.Builder language = builder.setId(sb.toString()).setLabel(s3).setContainerMimeType(str6).setSelectionFlags(r(str7)).setRoleFlags(q(str7, hashMap3)).setLanguage(p(str7, S, hashMap3));
                    java.lang.String p = p(str7, P, hashMap3);
                    android.net.Uri resolveToUri2 = p == null ? uri : com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, p);
                    arrayList19 = arrayList28;
                    java.lang.String str8 = str6;
                    com.google.android.exoplayer2.metadata.Metadata metadata = new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry(s2, s3, java.util.Collections.emptyList()));
                    java.lang.String s4 = s(str7, R, hashMap3);
                    s4.hashCode();
                    switch (s4.hashCode()) {
                        case -959297733:
                            if (s4.equals("SUBTITLES")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -333210994:
                            if (s4.equals("CLOSED-CAPTIONS")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 62628790:
                            if (s4.equals("AUDIO")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 81665115:
                            if (s4.equals("VIDEO")) {
                                c = 3;
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
                            format = format2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant d = d(arrayList11, s2);
                            if (d != null) {
                                java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(d.format.codecs, 3);
                                language.setCodecs(codecsOfType);
                                str2 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            language.setSampleMimeType(str2).setMetadata(metadata);
                            arrayList3 = arrayList22;
                            arrayList3.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition(resolveToUri2, language.build(), s2, s3));
                            break;
                        case 1:
                            format = format2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            java.lang.String s5 = s(str7, W, hashMap3);
                            if (s5.startsWith("CC")) {
                                parseInt = java.lang.Integer.parseInt(s5.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = java.lang.Integer.parseInt(s5.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList27 == null) {
                                arrayList27 = new java.util.ArrayList();
                            }
                            language.setSampleMimeType(str3).setAccessibilityChannel(parseInt);
                            arrayList27.add(language.build());
                            arrayList3 = arrayList22;
                            break;
                        case 2:
                            arrayList2 = arrayList20;
                            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant c2 = c(arrayList11, s2);
                            if (c2 != null) {
                                format = format2;
                                java.lang.String codecsOfType2 = com.google.android.exoplayer2.util.Util.getCodecsOfType(c2.format.codecs, 1);
                                language.setCodecs(codecsOfType2);
                                str4 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                format = format2;
                                str4 = null;
                            }
                            java.lang.String p2 = p(str7, z, hashMap3);
                            if (p2 != null) {
                                language.setChannelCount(java.lang.Integer.parseInt(com.google.android.exoplayer2.util.Util.splitAtFirst(p2, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0]));
                                if ("audio/eac3".equals(str4) && p2.endsWith("/JOC")) {
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            language.setSampleMimeType(str4);
                            if (resolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList21;
                                arrayList.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition(resolveToUri2, language.build(), s2, s3));
                            } else {
                                arrayList = arrayList21;
                                if (c2 != null) {
                                    format = language.build();
                                }
                            }
                            arrayList3 = arrayList22;
                            break;
                        case 3:
                            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant e = e(arrayList11, s2);
                            if (e != null) {
                                com.google.android.exoplayer2.Format format3 = e.format;
                                java.lang.String codecsOfType3 = com.google.android.exoplayer2.util.Util.getCodecsOfType(format3.codecs, 2);
                                language.setCodecs(codecsOfType3).setSampleMimeType(com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType3)).setWidth(format3.width).setHeight(format3.height).setFrameRate(format3.frameRate);
                            }
                            if (resolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList2 = arrayList20;
                                arrayList2.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition(resolveToUri2, language.build(), s2, s3));
                                format = format2;
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                                break;
                            }
                        default:
                            format = format2;
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            break;
                    }
                    i6++;
                    arrayList22 = arrayList3;
                    arrayList21 = arrayList;
                    arrayList20 = arrayList2;
                    str6 = str8;
                    format2 = format;
                    uri = null;
                }
                return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist(str, arrayList24, arrayList26, arrayList20, arrayList21, arrayList22, arrayList23, format2, z4 ? java.util.Collections.emptyList() : arrayList27, z5, hashMap3, arrayList25);
            }
            java.lang.String b = lineIterator.b();
            if (b.startsWith("#EXT")) {
                arrayList18.add(b);
            }
            boolean startsWith = b.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z6 = z3;
            if (b.startsWith("#EXT-X-DEFINE")) {
                hashMap3.put(s(b, T, hashMap3), s(b, a0, hashMap3));
            } else {
                if (b.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    hashMap = hashMap2;
                    arrayList10 = arrayList16;
                    arrayList9 = arrayList12;
                    arrayList8 = arrayList13;
                    arrayList7 = arrayList14;
                    arrayList5 = arrayList15;
                    arrayList6 = arrayList18;
                    arrayList4 = arrayList17;
                    z3 = true;
                } else if (b.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(b);
                } else if (b.startsWith("#EXT-X-SESSION-KEY")) {
                    com.google.android.exoplayer2.drm.DrmInitData.SchemeData g = g(b, o(b, N, "identity", hashMap3), hashMap3);
                    if (g != null) {
                        arrayList17.add(new com.google.android.exoplayer2.drm.DrmInitData(h(s(b, M, hashMap3)), g));
                    }
                } else if (b.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                    boolean contains = z4 | b.contains("CLOSED-CAPTIONS=NONE");
                    if (startsWith) {
                        i = 16384;
                        z2 = contains;
                    } else {
                        z2 = contains;
                        i = 0;
                    }
                    int i7 = i(b, y);
                    arrayList4 = arrayList17;
                    arrayList5 = arrayList15;
                    int n = n(b, t, -1);
                    java.lang.String p3 = p(b, A, hashMap3);
                    arrayList6 = arrayList18;
                    java.lang.String p4 = p(b, B, hashMap3);
                    if (p4 != null) {
                        arrayList7 = arrayList14;
                        java.lang.String[] split = p4.split("x");
                        int parseInt2 = java.lang.Integer.parseInt(split[0]);
                        int parseInt3 = java.lang.Integer.parseInt(split[1]);
                        if (parseInt2 <= 0 || parseInt3 <= 0) {
                            parseInt3 = -1;
                            i4 = -1;
                        } else {
                            i4 = parseInt2;
                        }
                        arrayList8 = arrayList13;
                        i3 = parseInt3;
                        i2 = i4;
                    } else {
                        arrayList7 = arrayList14;
                        arrayList8 = arrayList13;
                        i2 = -1;
                        i3 = -1;
                    }
                    java.lang.String p5 = p(b, C, hashMap3);
                    float parseFloat = p5 != null ? java.lang.Float.parseFloat(p5) : -1.0f;
                    arrayList9 = arrayList12;
                    java.lang.String p6 = p(b, u, hashMap3);
                    arrayList10 = arrayList16;
                    java.lang.String p7 = p(b, v, hashMap3);
                    java.util.HashMap hashMap5 = hashMap2;
                    java.lang.String p8 = p(b, w, hashMap3);
                    java.lang.String p9 = p(b, x, hashMap3);
                    if (startsWith) {
                        resolveToUri = com.google.android.exoplayer2.util.UriUtil.resolveToUri(str5, s(b, P, hashMap3));
                    } else {
                        if (!lineIterator.a()) {
                            throw new com.google.android.exoplayer2.ParserException("#EXT-X-STREAM-INF must be followed by another line");
                        }
                        resolveToUri = com.google.android.exoplayer2.util.UriUtil.resolveToUri(str5, t(lineIterator.b(), hashMap3));
                    }
                    arrayList11.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant(resolveToUri, new com.google.android.exoplayer2.Format.Builder().setId(arrayList11.size()).setContainerMimeType("application/x-mpegURL").setCodecs(p3).setAverageBitrate(n).setPeakBitrate(i7).setWidth(i2).setHeight(i3).setFrameRate(parseFloat).setRoleFlags(i).build(), p6, p7, p8, p9));
                    hashMap = hashMap5;
                    java.util.ArrayList arrayList29 = (java.util.ArrayList) hashMap.get(resolveToUri);
                    if (arrayList29 == null) {
                        arrayList29 = new java.util.ArrayList();
                        hashMap.put(resolveToUri, arrayList29);
                    }
                    arrayList29.add(new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo(n, i7, p6, p7, p8, p9));
                    z3 = z6;
                    z4 = z2;
                }
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                str5 = str;
            }
            hashMap = hashMap2;
            arrayList10 = arrayList16;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList5 = arrayList15;
            arrayList6 = arrayList18;
            arrayList4 = arrayList17;
            z3 = z6;
            hashMap2 = hashMap;
            arrayList17 = arrayList4;
            arrayList15 = arrayList5;
            arrayList18 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
            str5 = str;
        }
    }

    public static com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist l(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator lineIterator, java.lang.String str) throws java.io.IOException {
        long j;
        long j2;
        long j3;
        java.util.HashMap hashMap;
        java.util.HashMap hashMap2;
        java.util.TreeMap treeMap;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData;
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        boolean z2 = hlsMasterPlaylist2.hasIndependentSegments;
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.HashMap hashMap4 = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.TreeMap treeMap2 = new java.util.TreeMap();
        char c = 0;
        long j4 = -9223372036854775807L;
        int i = 1;
        boolean z3 = z2;
        long j5 = -9223372036854775807L;
        java.lang.String str2 = "";
        int i2 = 0;
        java.lang.String str3 = null;
        long j6 = 0;
        boolean z4 = false;
        int i3 = 0;
        long j7 = 0;
        int i4 = 1;
        boolean z5 = false;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2 = null;
        long j8 = 0;
        long j9 = 0;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData3 = null;
        boolean z6 = false;
        java.lang.String str4 = null;
        java.lang.String str5 = null;
        long j10 = -1;
        int i5 = 0;
        long j11 = 0;
        boolean z7 = false;
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = null;
        while (true) {
            long j12 = 0;
            while (lineIterator.a()) {
                java.lang.String b = lineIterator.b();
                if (b.startsWith("#EXT")) {
                    arrayList2.add(b);
                }
                if (b.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    java.lang.String s2 = s(b, F, hashMap3);
                    if ("VOD".equals(s2)) {
                        i2 = 1;
                    } else if ("EVENT".equals(s2)) {
                        i2 = 2;
                    }
                } else if (b.equals("#EXT-X-I-FRAMES-ONLY")) {
                    z7 = true;
                } else if (b.startsWith("#EXT-X-START")) {
                    j4 = (long) (f(b, J) * 1000000.0d);
                } else if (b.startsWith("#EXT-X-MAP")) {
                    java.lang.String s3 = s(b, P, hashMap3);
                    java.lang.String p = p(b, L, hashMap3);
                    if (p != null) {
                        java.lang.String[] split = p.split("@");
                        long parseLong = java.lang.Long.parseLong(split[c]);
                        if (split.length > i) {
                            j = java.lang.Long.parseLong(split[i]);
                            j2 = parseLong;
                        } else {
                            j2 = parseLong;
                            j = j8;
                        }
                    } else {
                        j = j8;
                        j2 = j10;
                    }
                    if (str4 != null && str5 == null) {
                        throw new com.google.android.exoplayer2.ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                    segment = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment(s3, j, j2, str4, str5);
                    j8 = 0;
                    j10 = -1;
                } else if (b.startsWith("#EXT-X-TARGETDURATION")) {
                    j5 = i(b, D) * 1000000;
                } else if (b.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j9 = j(b, G);
                    j7 = j9;
                } else if (b.startsWith("#EXT-X-VERSION")) {
                    i4 = i(b, E);
                } else {
                    if (b.startsWith("#EXT-X-DEFINE")) {
                        java.lang.String p2 = p(b, b0, hashMap3);
                        if (p2 != null) {
                            java.lang.String str6 = hlsMasterPlaylist2.variableDefinitions.get(p2);
                            if (str6 != null) {
                                hashMap3.put(p2, str6);
                            }
                        } else {
                            hashMap3.put(s(b, T, hashMap3), s(b, a0, hashMap3));
                        }
                    } else if (b.startsWith("#EXTINF")) {
                        long f = (long) (f(b, H) * 1000000.0d);
                        str2 = o(b, I, "", hashMap3);
                        j12 = f;
                        i = 1;
                    } else {
                        if (b.startsWith("#EXT-X-KEY")) {
                            java.lang.String s4 = s(b, M, hashMap3);
                            java.lang.String o = o(b, N, "identity", hashMap3);
                            if ("NONE".equals(s4)) {
                                treeMap2.clear();
                                drmInitData3 = null;
                                str4 = null;
                                str5 = null;
                            } else {
                                java.lang.String p3 = p(b, Q, hashMap3);
                                if (!"identity".equals(o)) {
                                    if (str3 == null) {
                                        str3 = h(s4);
                                    }
                                    com.google.android.exoplayer2.drm.DrmInitData.SchemeData g = g(b, o, hashMap3);
                                    if (g != null) {
                                        treeMap2.put(o, g);
                                        str5 = p3;
                                        drmInitData3 = null;
                                        str4 = null;
                                    }
                                } else if ("AES-128".equals(s4)) {
                                    str5 = p3;
                                    str4 = s(b, P, hashMap3);
                                }
                                str5 = p3;
                                str4 = null;
                            }
                        } else if (b.startsWith("#EXT-X-BYTERANGE")) {
                            java.lang.String[] split2 = s(b, K, hashMap3).split("@");
                            j10 = java.lang.Long.parseLong(split2[0]);
                            if (split2.length > 1) {
                                j8 = java.lang.Long.parseLong(split2[1]);
                            }
                        } else if (b.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            i3 = java.lang.Integer.parseInt(b.substring(b.indexOf(58) + 1));
                            c = 0;
                            i = 1;
                            z4 = true;
                        } else if (b.equals("#EXT-X-DISCONTINUITY")) {
                            i5++;
                        } else if (!b.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                            i = 1;
                            if (b.equals("#EXT-X-GAP")) {
                                c = 0;
                                z6 = true;
                            } else if (b.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                c = 0;
                                z3 = true;
                            } else if (b.equals("#EXT-X-ENDLIST")) {
                                c = 0;
                                z5 = true;
                            } else if (!b.startsWith("#")) {
                                java.lang.String hexString = str4 == null ? null : str5 != null ? str5 : java.lang.Long.toHexString(j9);
                                long j13 = j9 + 1;
                                java.lang.String t2 = t(b, hashMap3);
                                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment2 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) hashMap4.get(t2);
                                if (j10 == -1) {
                                    j3 = 0;
                                } else {
                                    if (z7 && segment == null && segment2 == null) {
                                        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment3 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment(t2, 0L, j8, null, null);
                                        hashMap4.put(t2, segment3);
                                        segment2 = segment3;
                                    }
                                    j3 = j8;
                                }
                                if (drmInitData3 != null || treeMap2.isEmpty()) {
                                    hashMap = hashMap3;
                                    hashMap2 = hashMap4;
                                    treeMap = treeMap2;
                                    drmInitData = drmInitData3;
                                } else {
                                    hashMap = hashMap3;
                                    com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDataArr = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) treeMap2.values().toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[0]);
                                    drmInitData = new com.google.android.exoplayer2.drm.DrmInitData(str3, schemeDataArr);
                                    if (drmInitData2 == null) {
                                        com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDataArr2 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[schemeDataArr.length];
                                        hashMap2 = hashMap4;
                                        treeMap = treeMap2;
                                        int i6 = 0;
                                        while (i6 < schemeDataArr.length) {
                                            schemeDataArr2[i6] = schemeDataArr[i6].copyWithData(null);
                                            i6++;
                                            schemeDataArr = schemeDataArr;
                                        }
                                        drmInitData2 = new com.google.android.exoplayer2.drm.DrmInitData(str3, schemeDataArr2);
                                    } else {
                                        hashMap2 = hashMap4;
                                        treeMap = treeMap2;
                                    }
                                }
                                arrayList.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment(t2, segment != null ? segment : segment2, str2, j12, i5, j11, drmInitData, str4, hexString, j3, j10, z6));
                                j11 += j12;
                                if (j10 != -1) {
                                    j3 += j10;
                                }
                                j8 = j3;
                                hlsMasterPlaylist2 = hlsMasterPlaylist;
                                drmInitData3 = drmInitData;
                                j9 = j13;
                                str2 = "";
                                j10 = -1;
                                hashMap3 = hashMap;
                                hashMap4 = hashMap2;
                                treeMap2 = treeMap;
                                c = 0;
                                i = 1;
                                z6 = false;
                            }
                        } else if (j6 == 0) {
                            i = 1;
                            j6 = com.google.android.exoplayer2.C.msToUs(com.google.android.exoplayer2.util.Util.parseXsDateTime(b.substring(b.indexOf(58) + 1))) - j11;
                            c = 0;
                        }
                        c = 0;
                        i = 1;
                    }
                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                    hashMap3 = hashMap3;
                    hashMap4 = hashMap4;
                    treeMap2 = treeMap2;
                    c = 0;
                    i = 1;
                }
            }
            return new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(i2, str, arrayList2, j4, j6, z4, i3, j7, i4, j5, z3, z5, j6 != 0, drmInitData2, arrayList);
        }
    }

    public static boolean m(java.lang.String str, java.util.regex.Pattern pattern, boolean z2) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    public static int n(java.lang.String str, java.util.regex.Pattern pattern, int i) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        return matcher.find() ? java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))) : i;
    }

    public static java.lang.String o(java.lang.String str, java.util.regex.Pattern pattern, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : t(str2, map);
    }

    @androidx.annotation.Nullable
    public static java.lang.String p(java.lang.String str, java.util.regex.Pattern pattern, java.util.Map<java.lang.String, java.lang.String> map) {
        return o(str, pattern, null, map);
    }

    public static int q(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String p = p(str, V, map);
        if (android.text.TextUtils.isEmpty(p)) {
            return 0;
        }
        java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(p, ",");
        int i = com.google.android.exoplayer2.util.Util.contains(split, "public.accessibility.describes-video") ? 512 : 0;
        if (com.google.android.exoplayer2.util.Util.contains(split, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (com.google.android.exoplayer2.util.Util.contains(split, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return com.google.android.exoplayer2.util.Util.contains(split, "public.easy-to-read") ? i | 8192 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int r(java.lang.String str) {
        boolean m = m(str, Y, false);
        ?? r0 = m;
        if (m(str, Z, false)) {
            r0 = (m ? 1 : 0) | 2;
        }
        return m(str, X, false) ? r0 | 4 : r0;
    }

    public static java.lang.String s(java.lang.String str, java.util.regex.Pattern pattern, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.ParserException {
        java.lang.String p = p(str, pattern, map);
        if (p != null) {
            return p;
        }
        java.lang.String pattern2 = pattern.pattern();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(pattern2).length() + 19 + java.lang.String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    public static java.lang.String t(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.regex.Matcher matcher = c0.matcher(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (matcher.find()) {
            java.lang.String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, java.util.regex.Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int u(java.io.BufferedReader bufferedReader, boolean z2, int i) throws java.io.IOException {
        while (i != -1 && java.lang.Character.isWhitespace(i) && (z2 || !com.google.android.exoplayer2.util.Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.String trim;
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        try {
            if (!a(bufferedReader)) {
                throw new com.google.android.exoplayer2.source.UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            }
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    com.google.android.exoplayer2.util.Util.closeQuietly(bufferedReader);
                    throw new com.google.android.exoplayer2.ParserException("Failed to parse the playlist, could not identify any tags.");
                }
                trim = readLine.trim();
                if (!trim.isEmpty()) {
                    if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                        if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(trim);
                    } else {
                        arrayDeque.add(trim);
                        return k(new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(trim);
            return l(this.n, new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator(arrayDeque, bufferedReader), uri.toString());
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(bufferedReader);
        }
    }
}
