package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public class DashManifestParser extends org.xml.sax.helpers.DefaultHandler implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.dash.manifest.DashManifest> {
    public static final java.util.regex.Pattern t = java.util.regex.Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final java.util.regex.Pattern u = java.util.regex.Pattern.compile("CC([1-4])=.*");
    public static final java.util.regex.Pattern v = java.util.regex.Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    public static final int[] w = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    public final org.xmlpull.v1.XmlPullParserFactory n;

    public static final class RepresentationInfo {
        public final java.lang.String baseUrl;
        public final java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> drmSchemeDatas;

        @androidx.annotation.Nullable
        public final java.lang.String drmSchemeType;
        public final com.google.android.exoplayer2.Format format;
        public final java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> inbandEventStreams;
        public final long revisionId;
        public final com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase;

        public RepresentationInfo(com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, @androidx.annotation.Nullable java.lang.String str2, java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList2, long j) {
            this.format = format;
            this.baseUrl = str;
            this.segmentBase = segmentBase;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j;
        }
    }

    public DashManifestParser() {
        try {
            this.n = org.xmlpull.v1.XmlPullParserFactory.newInstance();
        } catch (org.xmlpull.v1.XmlPullParserException e) {
            throw new java.lang.RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static int b(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(i == i2);
        return i;
    }

    @androidx.annotation.Nullable
    public static java.lang.String c(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(str.equals(str2));
        return str;
    }

    public static void d(java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String e(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
            return com.google.android.exoplayer2.util.MimeTypes.getAudioMediaMimeType(str2);
        }
        if (com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
            return com.google.android.exoplayer2.util.MimeTypes.getVideoMediaMimeType(str2);
        }
        if (com.google.android.exoplayer2.util.MimeTypes.isText(str)) {
            return "application/x-rawcc".equals(str) ? com.google.android.exoplayer2.util.MimeTypes.getTextMediaMimeType(str2) : str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        java.lang.String mediaMimeType = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(str2);
        return "text/vtt".equals(mediaMimeType) ? "application/x-mp4-vtt" : mediaMimeType;
    }

    public static void maybeSkipTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i++;
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    public static int parseCea608AccessibilityChannel(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        java.lang.String str;
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                java.util.regex.Matcher matcher = u.matcher(str);
                if (matcher.matches()) {
                    return java.lang.Integer.parseInt(matcher.group(1));
                }
                java.lang.String valueOf = java.lang.String.valueOf(descriptor.value);
                com.google.android.exoplayer2.util.Log.w("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-608 channel number from: ".concat(valueOf) : new java.lang.String("Unable to parse CEA-608 channel number from: "));
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        java.lang.String str;
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                java.util.regex.Matcher matcher = v.matcher(str);
                if (matcher.matches()) {
                    return java.lang.Integer.parseInt(matcher.group(1));
                }
                java.lang.String valueOf = java.lang.String.valueOf(descriptor.value);
                com.google.android.exoplayer2.util.Log.w("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-708 service block number from: ".concat(valueOf) : new java.lang.String("Unable to parse CEA-708 service block number from: "));
            }
        }
        return -1;
    }

    public static long parseDateTime(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) throws com.google.android.exoplayer2.ParserException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : com.google.android.exoplayer2.util.Util.parseXsDateTime(attributeValue);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Descriptor parseDescriptor(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        java.lang.String parseString2 = parseString(xmlPullParser, "value", null);
        java.lang.String parseString3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new com.google.android.exoplayer2.source.dash.manifest.Descriptor(parseString, parseString2, parseString3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        char c;
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(xmlPullParser.getAttributeValue(null, "value"));
        if (lowerInvariant == null) {
            return -1;
        }
        switch (lowerInvariant.hashCode()) {
            case 1596796:
                if (lowerInvariant.equals("4000")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2937391:
                if (lowerInvariant.equals("a000")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3094035:
                if (lowerInvariant.equals("f801")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3133436:
                if (lowerInvariant.equals("fa01")) {
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
        }
        return -1;
    }

    public static long parseDuration(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : com.google.android.exoplayer2.util.Util.parseXsDuration(attributeValue);
    }

    public static java.lang.String parseEac3SupplementalProperties(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            java.lang.String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    public static float parseFrameRate(org.xmlpull.v1.XmlPullParser xmlPullParser, float f) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        java.util.regex.Matcher matcher = t.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = java.lang.Integer.parseInt(matcher.group(1));
        return !android.text.TextUtils.isEmpty(matcher.group(2)) ? parseInt / java.lang.Integer.parseInt(r2) : parseInt;
    }

    public static int parseInt(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : java.lang.Integer.parseInt(attributeValue);
    }

    public static long parseLastSegmentNumberSupplementalProperty(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(descriptor.schemeIdUri)) {
                return java.lang.Long.parseLong(descriptor.value);
            }
        }
        return -1L;
    }

    public static long parseLong(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : java.lang.Long.parseLong(attributeValue);
    }

    public static int parseMpegChannelConfiguration(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt < 0) {
            return -1;
        }
        int[] iArr = w;
        if (parseInt < iArr.length) {
            return iArr[parseInt];
        }
        return -1;
    }

    public static java.lang.String parseString(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static java.lang.String parseText(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    public final long a(java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, long j, long j2, int i, long j3) {
        int ceilDivide = i >= 0 ? i + 1 : (int) com.google.android.exoplayer2.util.Util.ceilDivide(j3 - j, j2);
        for (int i2 = 0; i2 < ceilDivide; i2++) {
            list.add(buildSegmentTimelineElement(j, j2));
            j += j2;
        }
        return j;
    }

    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet buildAdaptationSet(int i, int i2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list4) {
        return new com.google.android.exoplayer2.source.dash.manifest.AdaptationSet(i, i2, list, list2, list3, list4);
    }

    public com.google.android.exoplayer2.metadata.emsg.EventMessage buildEvent(java.lang.String str, java.lang.String str2, long j, long j2, byte[] bArr) {
        return new com.google.android.exoplayer2.metadata.emsg.EventMessage(str, str2, j2, j, bArr);
    }

    public com.google.android.exoplayer2.source.dash.manifest.EventStream buildEventStream(java.lang.String str, java.lang.String str2, long j, long[] jArr, com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr) {
        return new com.google.android.exoplayer2.source.dash.manifest.EventStream(str, str2, j, jArr, eventMessageArr);
    }

    public com.google.android.exoplayer2.Format buildFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, int i2, float f, int i3, int i4, int i5, @androidx.annotation.Nullable java.lang.String str3, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, @androidx.annotation.Nullable java.lang.String str4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list4) {
        java.lang.String e = e(str2, str4);
        if ("audio/eac3".equals(e)) {
            e = parseEac3SupplementalProperties(list4);
        }
        com.google.android.exoplayer2.Format.Builder language = new com.google.android.exoplayer2.Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(e).setCodecs(str4).setPeakBitrate(i5).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors(list)).setRoleFlags(parseRoleFlagsFromRoleDescriptors(list) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).setLanguage(str3);
        if (com.google.android.exoplayer2.util.MimeTypes.isVideo(e)) {
            language.setWidth(i).setHeight(i2).setFrameRate(f);
        } else if (com.google.android.exoplayer2.util.MimeTypes.isAudio(e)) {
            language.setChannelCount(i3).setSampleRate(i4);
        } else if (com.google.android.exoplayer2.util.MimeTypes.isText(e)) {
            language.setAccessibilityChannel("application/cea-608".equals(e) ? parseCea608AccessibilityChannel(list2) : "application/cea-708".equals(e) ? parseCea708AccessibilityChannel(list2) : -1);
        }
        return language.build();
    }

    public com.google.android.exoplayer2.source.dash.manifest.DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, @androidx.annotation.Nullable android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        return new com.google.android.exoplayer2.source.dash.manifest.DashManifest(j, j2, j3, z, j4, j5, j6, j7, programInformation, utcTimingElement, uri, list);
    }

    public com.google.android.exoplayer2.source.dash.manifest.Period buildPeriod(@androidx.annotation.Nullable java.lang.String str, long j, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor) {
        return new com.google.android.exoplayer2.source.dash.manifest.Period(str, j, list, list2, descriptor);
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri buildRangedUri(java.lang.String str, long j, long j2) {
        return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(str, j, j2);
    }

    public com.google.android.exoplayer2.source.dash.manifest.Representation buildRepresentation(com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo representationInfo, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList2) {
        com.google.android.exoplayer2.Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        java.lang.String str3 = representationInfo.drmSchemeType;
        if (str3 != null) {
            str2 = str3;
        }
        java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            d(arrayList3);
            buildUpon.setDrmInitData(new com.google.android.exoplayer2.drm.DrmInitData(str2, arrayList3));
        }
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return com.google.android.exoplayer2.source.dash.manifest.Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList buildSegmentList(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> list2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, list2);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate buildSegmentTemplate(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, j5, list, urlTemplate, urlTemplate2);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement(j, j2);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase buildSingleSegmentBase(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    public com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement buildUtcTimingElement(java.lang.String str, java.lang.String str2) {
        return new com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement(str, str2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        try {
            org.xmlpull.v1.XmlPullParser newPullParser = this.n.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri.toString());
            }
            throw new com.google.android.exoplayer2.ParserException("inputStream does not contain a valid media presentation description");
        } catch (org.xmlpull.v1.XmlPullParserException e) {
            throw new com.google.android.exoplayer2.ParserException(e);
        }
    }

    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, long j) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String str2;
        java.lang.String str3;
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        java.util.ArrayList arrayList3;
        java.util.ArrayList arrayList4;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList5;
        java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList6;
        java.lang.String str4;
        java.lang.String str5;
        int i;
        java.util.ArrayList arrayList7;
        org.xmlpull.v1.XmlPullParser xmlPullParser2;
        com.google.android.exoplayer2.source.dash.manifest.DashManifestParser dashManifestParser;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList8;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase parseSegmentTemplate;
        com.google.android.exoplayer2.source.dash.manifest.DashManifestParser dashManifestParser2 = this;
        org.xmlpull.v1.XmlPullParser xmlPullParser3 = xmlPullParser;
        int parseInt = parseInt(xmlPullParser3, "id", -1);
        int parseContentType = parseContentType(xmlPullParser);
        java.lang.String str6 = null;
        java.lang.String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        java.lang.String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int parseInt2 = parseInt(xmlPullParser3, "width", -1);
        int parseInt3 = parseInt(xmlPullParser3, "height", -1);
        float parseFrameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int parseInt4 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        java.lang.String str7 = "lang";
        java.lang.String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        java.lang.String attributeValue4 = xmlPullParser3.getAttributeValue(null, "label");
        java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList9 = new java.util.ArrayList<>();
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList10 = new java.util.ArrayList<>();
        java.util.ArrayList arrayList11 = new java.util.ArrayList();
        java.util.ArrayList arrayList12 = new java.util.ArrayList();
        java.util.ArrayList arrayList13 = new java.util.ArrayList();
        java.util.ArrayList arrayList14 = new java.util.ArrayList();
        java.util.ArrayList arrayList15 = new java.util.ArrayList();
        java.lang.String str8 = str;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase2 = segmentBase;
        java.lang.String str9 = attributeValue4;
        java.lang.String str10 = null;
        int i2 = -1;
        boolean z = false;
        int i3 = parseContentType;
        while (true) {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z) {
                    z = true;
                    str8 = dashManifestParser2.parseBaseUrl(xmlPullParser3, str8);
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    i = i3;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                }
                str2 = attributeValue3;
                str3 = str8;
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                dashManifestParser = dashManifestParser2;
                i = i3;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
                attributeValue3 = str2;
                str8 = str3;
            } else {
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                    java.lang.Object obj = parseContentProtection.first;
                    if (obj != null) {
                        str10 = (java.lang.String) obj;
                    }
                    java.lang.Object obj2 = parseContentProtection.second;
                    if (obj2 != null) {
                        arrayList9.add((com.google.android.exoplayer2.drm.DrmInitData.SchemeData) obj2);
                    }
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                    attributeValue3 = c(attributeValue3, xmlPullParser3.getAttributeValue(str6, str7));
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    i = b(i3, parseContentType(xmlPullParser));
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                } else {
                    if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                        arrayList12.add(parseDescriptor(xmlPullParser3, "Role"));
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                        i2 = parseAudioChannelConfiguration(xmlPullParser);
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                        arrayList11.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "EssentialProperty")) {
                        arrayList13.add(parseDescriptor(xmlPullParser3, "EssentialProperty"));
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                        arrayList14.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                    } else {
                        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                            str2 = attributeValue3;
                            str3 = str8;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str4 = str7;
                            str5 = str6;
                            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation = parseRepresentation(xmlPullParser, str8, attributeValue, attributeValue2, parseInt2, parseInt3, parseFrameRate, i2, parseInt4, str2, arrayList3, arrayList4, arrayList2, arrayList, segmentBase2, j);
                            int b = b(i3, com.google.android.exoplayer2.util.MimeTypes.getTrackType(parseRepresentation.format.sampleMimeType));
                            arrayList7 = arrayList15;
                            arrayList7.add(parseRepresentation);
                            dashManifestParser = this;
                            xmlPullParser2 = xmlPullParser;
                            i = b;
                        } else {
                            str2 = attributeValue3;
                            str3 = str8;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str4 = str7;
                            str5 = str6;
                            i = i3;
                            arrayList7 = arrayList15;
                            xmlPullParser2 = xmlPullParser;
                            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                                dashManifestParser = this;
                                parseSegmentTemplate = dashManifestParser.parseSegmentBase(xmlPullParser2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) segmentBase2);
                            } else {
                                dashManifestParser = this;
                                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                                    parseSegmentTemplate = dashManifestParser.parseSegmentList(xmlPullParser2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) segmentBase2, j);
                                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                    parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) segmentBase2, arrayList, j);
                                } else {
                                    if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                        arrayList8 = arrayList5;
                                        arrayList8.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                                    } else {
                                        arrayList8 = arrayList5;
                                        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_LABEL)) {
                                            str9 = parseLabel(xmlPullParser);
                                        } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                            parseAdaptationSetChild(xmlPullParser);
                                        }
                                    }
                                    attributeValue3 = str2;
                                    str8 = str3;
                                }
                            }
                            segmentBase2 = parseSegmentTemplate;
                        }
                        attributeValue3 = str2;
                        str8 = str3;
                        arrayList8 = arrayList5;
                    }
                    str2 = attributeValue3;
                    str3 = str8;
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    i = i3;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                    attributeValue3 = str2;
                    str8 = str3;
                }
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                dashManifestParser = dashManifestParser2;
                i = i3;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
            }
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            i3 = i;
            arrayList15 = arrayList7;
            xmlPullParser3 = xmlPullParser2;
            dashManifestParser2 = dashManifestParser;
            arrayList10 = arrayList8;
            arrayList14 = arrayList;
            arrayList13 = arrayList2;
            arrayList12 = arrayList3;
            arrayList11 = arrayList4;
            arrayList9 = arrayList6;
            str7 = str4;
            str6 = str5;
        }
        java.util.ArrayList arrayList16 = new java.util.ArrayList(arrayList7.size());
        for (int i4 = 0; i4 < arrayList7.size(); i4++) {
            arrayList16.add(buildRepresentation((com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) arrayList7.get(i4), str9, str10, arrayList6, arrayList8));
        }
        return buildAdaptationSet(parseInt, i, arrayList16, arrayList4, arrayList2, arrayList);
    }

    public void parseAdaptationSetChild(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        char c;
        java.lang.String parseString = parseString(xmlPullParser, "schemeIdUri", null);
        parseString.hashCode();
        int i = -1;
        switch (parseString.hashCode()) {
            case -1352850286:
                if (parseString.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1138141449:
                if (parseString.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -986633423:
                if (parseString.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2036691300:
                if (parseString.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
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
                i = parseInt(xmlPullParser, "value", -1);
                break;
            case 1:
            case 3:
                i = parseDolbyChannelConfiguration(xmlPullParser);
                break;
            case 2:
                i = parseMpegChannelConfiguration(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    public java.lang.String parseBaseUrl(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return com.google.android.exoplayer2.util.UriUtil.resolve(str, parseText(xmlPullParser, "BaseURL"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.UUID] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String str;
        ?? r3;
        java.lang.String str2;
        java.lang.String str3;
        ?? r4;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(attributeValue);
            lowerInvariant.hashCode();
            switch (lowerInvariant) {
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    r3 = com.google.android.exoplayer2.C.PLAYREADY_UUID;
                    str = null;
                    str2 = null;
                    str3 = str2;
                    r4 = str2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    r3 = com.google.android.exoplayer2.C.WIDEVINE_UUID;
                    str = null;
                    str2 = null;
                    str3 = str2;
                    r4 = str2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    str = xmlPullParser.getAttributeValue(null, "value");
                    java.lang.String attributeValueIgnorePrefix = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValueIgnorePrefix(xmlPullParser, "default_KID");
                    if (!android.text.TextUtils.isEmpty(attributeValueIgnorePrefix) && !"00000000-0000-0000-0000-000000000000".equals(attributeValueIgnorePrefix)) {
                        java.lang.String[] split = attributeValueIgnorePrefix.split("\\s+");
                        java.util.UUID[] uuidArr = new java.util.UUID[split.length];
                        for (int i = 0; i < split.length; i++) {
                            uuidArr[i] = java.util.UUID.fromString(split[i]);
                        }
                        r3 = com.google.android.exoplayer2.C.COMMON_PSSH_UUID;
                        str3 = null;
                        r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r3, uuidArr, null);
                        break;
                    } else {
                        r3 = null;
                        str2 = r3;
                        str3 = str2;
                        r4 = str2;
                        break;
                    }
            }
            do {
                xmlPullParser.next();
                if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                    str3 = xmlPullParser.getAttributeValue(null, "licenseUrl");
                    r4 = r4;
                } else if (r4 == 0 && com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTagIgnorePrefix(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                    byte[] decode = android.util.Base64.decode(xmlPullParser.getText(), 0);
                    java.util.UUID parseUuid = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(decode);
                    if (parseUuid == null) {
                        com.google.android.exoplayer2.util.Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                        r3 = parseUuid;
                        r4 = 0;
                    } else {
                        r4 = decode;
                        r3 = parseUuid;
                    }
                } else {
                    if (r4 == 0) {
                        ?? r7 = com.google.android.exoplayer2.C.PLAYREADY_UUID;
                        if (r7.equals(r3) && com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r7, android.util.Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                    maybeSkipTag(xmlPullParser);
                    r4 = r4;
                }
            } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
            return android.util.Pair.create(str, r3 != null ? new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(r3, str3, "video/mp4", r4) : null);
        }
        str = null;
        r3 = null;
        str2 = r3;
        str3 = str2;
        r4 = str2;
        do {
            xmlPullParser.next();
            if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
        return android.util.Pair.create(str, r3 != null ? new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(r3, str3, "video/mp4", r4) : null);
    }

    public int parseContentType(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (android.text.TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    public int parseDashRoleSchemeValue(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public android.util.Pair<java.lang.Long, com.google.android.exoplayer2.metadata.emsg.EventMessage> parseEvent(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2, long j, java.io.ByteArrayOutputStream byteArrayOutputStream) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        long parseLong = parseLong(xmlPullParser, "id", 0L);
        long parseLong2 = parseLong(xmlPullParser, "duration", -9223372036854775807L);
        long parseLong3 = parseLong(xmlPullParser, "presentationTime", 0L);
        long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parseLong2, 1000L, j);
        long scaleLargeTimestamp2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parseLong3, 1000000L, j);
        java.lang.String parseString = parseString(xmlPullParser, "messageData", null);
        byte[] parseEventObject = parseEventObject(xmlPullParser, byteArrayOutputStream);
        java.lang.Long valueOf = java.lang.Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = com.google.android.exoplayer2.util.Util.getUtf8Bytes(parseString);
        }
        return android.util.Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    public byte[] parseEventObject(org.xmlpull.v1.XmlPullParser xmlPullParser, java.io.ByteArrayOutputStream byteArrayOutputStream) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        byteArrayOutputStream.reset();
        org.xmlpull.v1.XmlSerializer newSerializer = android.util.Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.google.common.base.Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, java.lang.Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public com.google.android.exoplayer2.source.dash.manifest.EventStream parseEventStream(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        java.lang.String parseString2 = parseString(xmlPullParser, "value", "");
        long parseLong = parseLong(xmlPullParser, "timescale", 1L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr = new com.google.android.exoplayer2.metadata.emsg.EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            android.util.Pair pair = (android.util.Pair) arrayList.get(i);
            jArr[i] = ((java.lang.Long) pair.first).longValue();
            eventMessageArr[i] = (com.google.android.exoplayer2.metadata.emsg.EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri parseInitialization(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    public java.lang.String parseLabel(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return parseText(xmlPullParser, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_LABEL);
    }

    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long j;
        long j2;
        com.google.android.exoplayer2.source.dash.manifest.DashManifestParser dashManifestParser = this;
        long parseDateTime = parseDateTime(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long parseDuration = parseDuration(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long parseDuration2 = parseDuration(xmlPullParser, "minBufferTime", -9223372036854775807L);
        boolean equals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long parseDuration3 = equals ? parseDuration(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long parseDuration4 = equals ? parseDuration(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long parseDuration5 = equals ? parseDuration(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long parseDateTime2 = parseDateTime(xmlPullParser, "publishTime", -9223372036854775807L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri uri = null;
        long j3 = equals ? -9223372036854775807L : 0L;
        boolean z = false;
        boolean z2 = false;
        java.lang.String str2 = str;
        com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation = null;
        com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement = null;
        while (true) {
            xmlPullParser.next();
            long j4 = parseDuration4;
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (z) {
                    j = j3;
                    j2 = parseDuration3;
                    j3 = j;
                } else {
                    str2 = dashManifestParser.parseBaseUrl(xmlPullParser, str2);
                    j2 = parseDuration3;
                    z = true;
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "ProgramInformation")) {
                j2 = parseDuration3;
                programInformation = parseProgramInformation(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                j2 = parseDuration3;
                utcTimingElement = parseUtcTiming(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Location")) {
                j2 = parseDuration3;
                uri = android.net.Uri.parse(xmlPullParser.nextText());
            } else if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Period") || z2) {
                j = j3;
                j2 = parseDuration3;
                maybeSkipTag(xmlPullParser);
                j3 = j;
            } else {
                android.util.Pair<com.google.android.exoplayer2.source.dash.manifest.Period, java.lang.Long> parsePeriod = dashManifestParser.parsePeriod(xmlPullParser, str2, j3);
                long j5 = j3;
                com.google.android.exoplayer2.source.dash.manifest.Period period = (com.google.android.exoplayer2.source.dash.manifest.Period) parsePeriod.first;
                j2 = parseDuration3;
                if (period.startMs != -9223372036854775807L) {
                    long longValue = ((java.lang.Long) parsePeriod.second).longValue();
                    long j6 = longValue == -9223372036854775807L ? -9223372036854775807L : period.startMs + longValue;
                    arrayList.add(period);
                    j3 = j6;
                } else {
                    if (!equals) {
                        int size = arrayList.size();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(47);
                        sb.append("Unable to determine start of period ");
                        sb.append(size);
                        throw new com.google.android.exoplayer2.ParserException(sb.toString());
                    }
                    j3 = j5;
                    z2 = true;
                }
            }
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                if (parseDuration == -9223372036854775807L) {
                    if (j3 != -9223372036854775807L) {
                        parseDuration = j3;
                    } else if (!equals) {
                        throw new com.google.android.exoplayer2.ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new com.google.android.exoplayer2.ParserException("No periods found.");
                }
                return buildMediaPresentationDescription(parseDateTime, parseDuration, parseDuration2, equals, j2, j4, parseDuration5, parseDateTime2, programInformation, utcTimingElement, uri, arrayList);
            }
            dashManifestParser = this;
            parseDuration4 = j4;
            parseDuration3 = j2;
        }
    }

    public android.util.Pair<com.google.android.exoplayer2.source.dash.manifest.Period, java.lang.Long> parsePeriod(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String str2;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long parseDuration = parseDuration(xmlPullParser, com.anythink.expressad.foundation.d.c.bT, j);
        long parseDuration2 = parseDuration(xmlPullParser, "duration", -9223372036854775807L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.String str3 = str;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase = null;
        com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (z) {
                    str2 = str3;
                } else {
                    str3 = parseBaseUrl(xmlPullParser, str3);
                    z = true;
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                str2 = str3;
                arrayList.add(parseAdaptationSet(xmlPullParser, str3, segmentBase, parseDuration2));
            } else {
                str2 = str3;
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "EventStream")) {
                    arrayList2.add(parseEventStream(xmlPullParser));
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                    segmentBase = parseSegmentBase(xmlPullParser, null);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                    segmentBase = parseSegmentList(xmlPullParser, null, parseDuration2);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                    segmentBase = parseSegmentTemplate(xmlPullParser, null, java.util.Collections.emptyList(), parseDuration2);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "AssetIdentifier")) {
                    descriptor = parseDescriptor(xmlPullParser, "AssetIdentifier");
                } else {
                    maybeSkipTag(xmlPullParser);
                }
            }
            str3 = str2;
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return android.util.Pair.create(buildPeriod(attributeValue, parseDuration, arrayList, arrayList2, descriptor), java.lang.Long.valueOf(parseDuration2));
    }

    public com.google.android.exoplayer2.source.dash.manifest.ProgramInformation parseProgramInformation(org.xmlpull.v1.XmlPullParser xmlPullParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        java.lang.String str = null;
        java.lang.String parseString = parseString(xmlPullParser, "moreInformationURL", null);
        java.lang.String parseString2 = parseString(xmlPullParser, "lang", null);
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE)) {
                str = xmlPullParser.nextText();
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, androidx.exifinterface.media.ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            java.lang.String str4 = str3;
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new com.google.android.exoplayer2.source.dash.manifest.ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri parseRangedUrl(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2) {
        long j;
        long j2;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            java.lang.String[] split = attributeValue2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            j = java.lang.Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (java.lang.Long.parseLong(split[1]) - j) + 1;
                return buildRangedUri(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x019e A[LOOP:0: B:2:0x0065->B:10:0x019e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x015b A[EDGE_INSN: B:11:0x015b->B:12:0x015b BREAK  A[LOOP:0: B:2:0x0065->B:10:0x019e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, float f, int i3, int i4, @androidx.annotation.Nullable java.lang.String str4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list4, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, long j) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i5;
        int i6;
        java.lang.String str5;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase parseSegmentTemplate;
        int i7;
        java.lang.String str6;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int parseInt = parseInt(xmlPullParser, "bandwidth", -1);
        java.lang.String parseString = parseString(xmlPullParser, "mimeType", str2);
        java.lang.String parseString2 = parseString(xmlPullParser, "codecs", str3);
        int parseInt2 = parseInt(xmlPullParser, "width", i);
        int parseInt3 = parseInt(xmlPullParser, "height", i2);
        float parseFrameRate = parseFrameRate(xmlPullParser, f);
        int parseInt4 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList(list3);
        java.util.ArrayList arrayList4 = new java.util.ArrayList(list4);
        int i8 = i3;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase2 = segmentBase;
        java.lang.String str7 = null;
        boolean z = false;
        java.lang.String str8 = str;
        while (true) {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (z) {
                    str5 = str8;
                    i5 = parseInt4;
                    i6 = parseInt;
                    i7 = i8;
                    str6 = str5;
                    if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                    }
                } else {
                    str8 = parseBaseUrl(xmlPullParser, str8);
                    i5 = parseInt4;
                    i6 = parseInt;
                    i7 = i8;
                    z = true;
                    str6 = str8;
                    if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                        break;
                    }
                    parseInt4 = i5;
                    str8 = str6;
                    parseInt = i6;
                    i8 = i7;
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                i7 = parseAudioChannelConfiguration(xmlPullParser);
                str6 = str8;
                i5 = parseInt4;
                i6 = parseInt;
                if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                i5 = parseInt4;
                i6 = parseInt;
                segmentBase2 = parseSegmentBase(xmlPullParser, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) segmentBase2);
                i7 = i8;
                str6 = str8;
                if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                }
            } else {
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                    i5 = parseInt4;
                    i6 = parseInt;
                    parseSegmentTemplate = parseSegmentList(xmlPullParser, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) segmentBase2, j);
                } else {
                    i5 = parseInt4;
                    i6 = parseInt;
                    if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                        parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) segmentBase2, list4, j);
                    } else {
                        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection")) {
                            android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                            str5 = str8;
                            java.lang.Object obj = parseContentProtection.first;
                            if (obj != null) {
                                str7 = (java.lang.String) obj;
                            }
                            java.lang.Object obj2 = parseContentProtection.second;
                            if (obj2 != null) {
                                arrayList.add((com.google.android.exoplayer2.drm.DrmInitData.SchemeData) obj2);
                            }
                        } else {
                            str5 = str8;
                            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "InbandEventStream")) {
                                arrayList2.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "EssentialProperty")) {
                                arrayList3.add(parseDescriptor(xmlPullParser, "EssentialProperty"));
                            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SupplementalProperty")) {
                                arrayList4.add(parseDescriptor(xmlPullParser, "SupplementalProperty"));
                            } else {
                                maybeSkipTag(xmlPullParser);
                            }
                        }
                        i7 = i8;
                        str6 = str5;
                        if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                        }
                    }
                }
                segmentBase2 = parseSegmentTemplate;
                i7 = i8;
                str6 = str8;
                if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                }
            }
        }
        return new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo(buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i7, i5, i6, str4, list, list2, parseString2, arrayList3, arrayList4), str6, segmentBase2 != null ? segmentBase2 : new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase(), str7, arrayList, arrayList2, -1L);
    }

    public int parseRoleFlagsFromAccessibilityDescriptors(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseDashRoleSchemeValue(descriptor.value);
            } else if ("urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= parseTvaAudioPurposeCsValue;
        }
        return i;
    }

    public int parseRoleFlagsFromProperties(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(list.get(i2).schemeIdUri)) {
                i |= 16384;
            }
        }
        return i;
    }

    public int parseRoleFlagsFromRoleDescriptors(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                i |= parseDashRoleSchemeValue(descriptor.value);
            }
        }
        return i;
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase parseSegmentBase(org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase singleSegmentBase) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long j;
        long j2;
        long parseLong = parseLong(xmlPullParser, "timescale", singleSegmentBase != null ? singleSegmentBase.b : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", singleSegmentBase != null ? singleSegmentBase.c : 0L);
        long j3 = singleSegmentBase != null ? singleSegmentBase.d : 0L;
        long j4 = singleSegmentBase != null ? singleSegmentBase.e : 0L;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            java.lang.String[] split = attributeValue.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            j2 = java.lang.Long.parseLong(split[0]);
            j = (java.lang.Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j4;
            j2 = j3;
        }
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = singleSegmentBase != null ? singleSegmentBase.a : null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j2, j);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList parseSegmentList(org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList segmentList, long j) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long parseLong = parseLong(xmlPullParser, "timescale", segmentList != null ? segmentList.b : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.c : 0L);
        long parseLong3 = parseLong(xmlPullParser, "duration", segmentList != null ? segmentList.e : -9223372036854775807L);
        long parseLong4 = parseLong(xmlPullParser, "startNumber", segmentList != null ? segmentList.d : 1L);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = null;
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> list2 = null;
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser, parseLong, j);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new java.util.ArrayList<>();
                }
                list2.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (rangedUri == null) {
                rangedUri = segmentList.a;
            }
            if (list == null) {
                list = segmentList.f;
            }
            if (list2 == null) {
                list2 = segmentList.g;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, list2);
    }

    public com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate parseSegmentTemplate(org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate segmentTemplate, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, long j) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long parseLong = parseLong(xmlPullParser, "timescale", segmentTemplate != null ? segmentTemplate.b : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentTemplate != null ? segmentTemplate.c : 0L);
        long parseLong3 = parseLong(xmlPullParser, "duration", segmentTemplate != null ? segmentTemplate.e : -9223372036854775807L);
        long parseLong4 = parseLong(xmlPullParser, "startNumber", segmentTemplate != null ? segmentTemplate.d : 1L);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list2 = null;
        com.google.android.exoplayer2.source.dash.manifest.UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser, "media", segmentTemplate != null ? segmentTemplate.h : null);
        com.google.android.exoplayer2.source.dash.manifest.UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", segmentTemplate != null ? segmentTemplate.g : null);
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate.a;
            }
            if (list2 == null) {
                list2 = segmentTemplate.f;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, parseUrlTemplate2, parseUrlTemplate);
    }

    public java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> parseSegmentTimeline(org.xmlpull.v1.XmlPullParser xmlPullParser, long j, long j2) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH)) {
                long parseLong = parseLong(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    j3 = a(arrayList, j3, j4, i, parseLong);
                }
                if (parseLong == -9223372036854775807L) {
                    parseLong = j3;
                }
                j4 = parseLong(xmlPullParser, "d", -9223372036854775807L);
                i = parseInt(xmlPullParser, "r", 0);
                j3 = parseLong;
                z = true;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        if (z) {
            a(arrayList, j3, j4, i, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, j, 1000L));
        }
        return arrayList;
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri parseSegmentUrl(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public int parseSelectionFlagsFromRoleDescriptors(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri) && "main".equals(descriptor.value)) {
                return 1;
            }
        }
        return 0;
    }

    public int parseTvaAudioPurposeCsValue(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.dash.manifest.UrlTemplate parseUrlTemplate(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? com.google.android.exoplayer2.source.dash.manifest.UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    public com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement parseUtcTiming(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }
}
