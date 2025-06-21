package com.google.android.exoplayer2.source.smoothstreaming.manifest;

/* loaded from: classes22.dex */
public class SsManifestParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> {
    public final org.xmlpull.v1.XmlPullParserFactory n;

    public static abstract class ElementParser {
        public final java.lang.String a;
        public final java.lang.String b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser c;
        public final java.util.List<android.util.Pair<java.lang.String, java.lang.Object>> d = new java.util.LinkedList();

        public ElementParser(@androidx.annotation.Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str, java.lang.String str2) {
            this.c = elementParser;
            this.a = str;
            this.b = str2;
        }

        public void a(java.lang.Object obj) {
        }

        public abstract java.lang.Object b();

        @androidx.annotation.Nullable
        public final java.lang.Object c(java.lang.String str) {
            for (int i = 0; i < this.d.size(); i++) {
                android.util.Pair<java.lang.String, java.lang.Object> pair = this.d.get(i);
                if (((java.lang.String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser = this.c;
            if (elementParser == null) {
                return null;
            }
            return elementParser.c(str);
        }

        public boolean d(java.lang.String str) {
            return false;
        }

        public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser e(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str, java.lang.String str2) {
            if ("QualityLevel".equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.QualityLevelParser(elementParser, str2);
            }
            if ("Protection".equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ProtectionParser(elementParser, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.StreamIndexParser(elementParser, str2);
            }
            return null;
        }

        public final java.lang.Object f(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    java.lang.String name = xmlPullParser.getName();
                    if (this.b.equals(name)) {
                        n(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser e = e(this, name, this.a);
                            if (e == null) {
                                i = 1;
                            } else {
                                a(e.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    java.lang.String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, boolean z) {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? java.lang.Boolean.parseBoolean(attributeValue) : z;
        }

        public void h(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        }

        public final int i(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i;
            }
            try {
                return java.lang.Integer.parseInt(attributeValue);
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.android.exoplayer2.ParserException(e);
            }
        }

        public final long j(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return java.lang.Long.parseLong(attributeValue);
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.android.exoplayer2.ParserException(e);
            }
        }

        public final int k(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
            }
            try {
                return java.lang.Integer.parseInt(attributeValue);
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.android.exoplayer2.ParserException(e);
            }
        }

        public final long l(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
            }
            try {
                return java.lang.Long.parseLong(attributeValue);
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.android.exoplayer2.ParserException(e);
            }
        }

        public final java.lang.String m(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
        }

        public void n(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
        }

        public void o(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        }

        public final void p(java.lang.String str, @androidx.annotation.Nullable java.lang.Object obj) {
            this.d.add(android.util.Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends com.google.android.exoplayer2.ParserException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MissingFieldException(java.lang.String str) {
            super(r3.length() != 0 ? "Missing required field: ".concat(r3) : new java.lang.String("Missing required field: "));
            java.lang.String valueOf = java.lang.String.valueOf(str);
        }
    }

    public static class ProtectionParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        public boolean e;
        public java.util.UUID f;
        public byte[] g;

        public ProtectionParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, "Protection");
        }

        public static com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] q(byte[] bArr) {
            return new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[]{new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox(true, null, 8, r(bArr), 0, 0, null)};
        }

        public static byte[] r(byte[] bArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            java.lang.String sb2 = sb.toString();
            byte[] decode = android.util.Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        public static java.lang.String s(java.lang.String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void t(byte[] bArr, int i, int i2) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object b() {
            java.util.UUID uuid = this.f;
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement(uuid, com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(uuid, this.g), q(this.g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean d(java.lang.String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void h(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void n(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = true;
                this.f = java.util.UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void o(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (this.e) {
                this.g = android.util.Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class QualityLevelParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        public com.google.android.exoplayer2.Format e;

        public QualityLevelParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, "QualityLevel");
        }

        public static java.util.List<byte[]> q(java.lang.String str) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!android.text.TextUtils.isEmpty(str)) {
                byte[] bytesFromHexString = com.google.android.exoplayer2.util.Util.getBytesFromHexString(str);
                byte[][] splitNalUnits = com.google.android.exoplayer2.util.CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                if (splitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    java.util.Collections.addAll(arrayList, splitNalUnits);
                }
            }
            return arrayList;
        }

        @androidx.annotation.Nullable
        public static java.lang.String r(java.lang.String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object b() {
            return this.e;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void n(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            int i;
            com.google.android.exoplayer2.Format.Builder builder = new com.google.android.exoplayer2.Format.Builder();
            java.lang.String r = r(m(xmlPullParser, "FourCC"));
            int intValue = ((java.lang.Integer) c("Type")).intValue();
            if (intValue == 2) {
                builder.setContainerMimeType("video/mp4").setWidth(k(xmlPullParser, "MaxWidth")).setHeight(k(xmlPullParser, "MaxHeight")).setInitializationData(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r == null) {
                    r = "audio/mp4a-latm";
                }
                int k = k(xmlPullParser, "Channels");
                int k2 = k(xmlPullParser, "SamplingRate");
                java.util.List<byte[]> q = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q.isEmpty() && "audio/mp4a-latm".equals(r)) {
                    q = java.util.Collections.singletonList(com.google.android.exoplayer2.audio.AacUtil.buildAacLcAudioSpecificConfig(k2, k));
                }
                builder.setContainerMimeType("audio/mp4").setChannelCount(k).setSampleRate(k2).setInitializationData(q);
            } else if (intValue == 3) {
                java.lang.String str = (java.lang.String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i = 64;
                    } else if (str.equals("DESC")) {
                        i = 1024;
                    }
                    builder.setContainerMimeType("application/mp4").setRoleFlags(i);
                }
                i = 0;
                builder.setContainerMimeType("application/mp4").setRoleFlags(i);
            } else {
                builder.setContainerMimeType("application/mp4");
            }
            this.e = builder.setId(xmlPullParser.getAttributeValue(null, "Index")).setLabel((java.lang.String) c(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME)).setSampleMimeType(r).setAverageBitrate(k(xmlPullParser, com.aliyun.auth.core.AliyunVodKey.KEY_VOD_BITRATE)).setLanguage((java.lang.String) c("Language")).build();
        }
    }

    public static class SmoothStreamingMediaParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        public final java.util.List<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement> e;
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;
        public int k;
        public boolean l;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement m;

        public SmoothStreamingMediaParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, "SmoothStreamingMedia");
            this.k = -1;
            this.m = null;
            this.e = new java.util.LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void a(java.lang.Object obj) {
            if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement) {
                this.e.add((com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement) obj);
            } else if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.m == null);
                this.m = (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object b() {
            int size = this.e.size();
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr = new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[size];
            this.e.toArray(streamElementArr);
            if (this.m != null) {
                com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement = this.m;
                com.google.android.exoplayer2.drm.DrmInitData drmInitData = new com.google.android.exoplayer2.drm.DrmInitData(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(protectionElement.uuid, "video/mp4", protectionElement.data));
                for (int i = 0; i < size; i++) {
                    com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = streamElementArr[i];
                    int i2 = streamElement.type;
                    if (i2 == 2 || i2 == 1) {
                        com.google.android.exoplayer2.Format[] formatArr = streamElement.formats;
                        for (int i3 = 0; i3 < formatArr.length; i3++) {
                            formatArr[i3] = formatArr[i3].buildUpon().setDrmInitData(drmInitData).build();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, streamElementArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void n(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            this.f = k(xmlPullParser, "MajorVersion");
            this.g = k(xmlPullParser, "MinorVersion");
            this.h = j(xmlPullParser, "TimeScale", 10000000L);
            this.i = l(xmlPullParser, com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION);
            this.j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.k = i(xmlPullParser, "LookaheadCount", -1);
            this.l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", java.lang.Long.valueOf(this.h));
        }
    }

    public static class StreamIndexParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        public final java.lang.String e;
        public final java.util.List<com.google.android.exoplayer2.Format> f;
        public int g;
        public java.lang.String h;
        public long i;
        public java.lang.String j;
        public java.lang.String k;
        public int l;
        public int m;
        public int n;
        public int o;
        public java.lang.String p;
        public java.util.ArrayList<java.lang.Long> q;
        public long r;

        public StreamIndexParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, "StreamIndex");
            this.e = str;
            this.f = new java.util.LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void a(java.lang.Object obj) {
            if (obj instanceof com.google.android.exoplayer2.Format) {
                this.f.add((com.google.android.exoplayer2.Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object b() {
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[this.f.size()];
            this.f.toArray(formatArr);
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement(this.e, this.k, this.g, this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, formatArr, this.q, this.r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean d(java.lang.String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void n(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }

        public final void q(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            int s2 = s(xmlPullParser);
            this.g = s2;
            p("Type", java.lang.Integer.valueOf(s2));
            if (this.g == 3) {
                this.h = m(xmlPullParser, "Subtype");
            } else {
                this.h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            p("Subtype", this.h);
            this.j = xmlPullParser.getAttributeValue(null, org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME);
            this.k = m(xmlPullParser, "Url");
            this.l = i(xmlPullParser, "MaxWidth", -1);
            this.m = i(xmlPullParser, "MaxHeight", -1);
            this.n = i(xmlPullParser, "DisplayWidth", -1);
            this.o = i(xmlPullParser, "DisplayHeight", -1);
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
            this.p = attributeValue;
            p("Language", attributeValue);
            long i = i(xmlPullParser, "TimeScale", -1);
            this.i = i;
            if (i == -1) {
                this.i = ((java.lang.Long) c("TimeScale")).longValue();
            }
            this.q = new java.util.ArrayList<>();
        }

        public final void r(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            int size = this.q.size();
            long j = j(xmlPullParser, "t", -9223372036854775807L);
            int i = 1;
            if (j == -9223372036854775807L) {
                if (size == 0) {
                    j = 0;
                } else {
                    if (this.r == -1) {
                        throw new com.google.android.exoplayer2.ParserException("Unable to infer start time");
                    }
                    j = this.q.get(size - 1).longValue() + this.r;
                }
            }
            this.q.add(java.lang.Long.valueOf(j));
            this.r = j(xmlPullParser, "d", -9223372036854775807L);
            long j2 = j(xmlPullParser, "r", 1L);
            if (j2 > 1 && this.r == -9223372036854775807L) {
                throw new com.google.android.exoplayer2.ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j3 = i;
                if (j3 >= j2) {
                    return;
                }
                this.q.add(java.lang.Long.valueOf((this.r * j3) + j));
                i++;
            }
        }

        public final int s(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(attributeValue.length() + 19);
            sb.append("Invalid key value[");
            sb.append(attributeValue);
            sb.append("]");
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
    }

    public SsManifestParser() {
        try {
            this.n = org.xmlpull.v1.XmlPullParserFactory.newInstance();
        } catch (org.xmlpull.v1.XmlPullParserException e) {
            throw new java.lang.RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        try {
            org.xmlpull.v1.XmlPullParser newPullParser = this.n.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest) new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.SmoothStreamingMediaParser(null, uri.toString()).f(newPullParser);
        } catch (org.xmlpull.v1.XmlPullParserException e) {
            throw new com.google.android.exoplayer2.ParserException(e);
        }
    }
}
