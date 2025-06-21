package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class XmlConfigSource implements com.commonsware.cwac.netsecurity.config.ConfigSource {
    private static final int CONFIG_BASE = 0;
    private static final int CONFIG_DEBUG = 2;
    private static final int CONFIG_DOMAIN = 1;
    private android.content.Context mContext;
    private final boolean mDebugBuild;
    private com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig mDefaultConfig;
    private java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> mDomainMap;
    private boolean mInitialized;
    private final java.lang.Object mLock;
    private final int mResourceId;
    private final int mTargetSdkVersion;

    public static class ParserException extends java.lang.Exception {
        public ParserException(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
            this(xmlPullParser, str, null);
        }

        public ParserException(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.Throwable th) {
            super(str + " at: " + xmlPullParser.getPositionDescription(), th);
        }
    }

    public XmlConfigSource(android.content.Context context, int i) {
        this(context, i, false);
    }

    public XmlConfigSource(android.content.Context context, int i, boolean z) {
        this(context, i, z, 10000);
    }

    public XmlConfigSource(android.content.Context context, int i, boolean z, int i2) {
        this.mLock = new java.lang.Object();
        this.mResourceId = i;
        this.mContext = context;
        this.mDebugBuild = z;
        this.mTargetSdkVersion = i2;
    }

    private void addDebugAnchorsIfNeeded(com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder2) {
        if (builder != null && builder.hasCertificatesEntryRefs() && builder2.hasCertificatesEntryRefs()) {
            builder2.addCertificatesEntryRefs(builder.getCertificatesEntryRefs());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: all -> 0x0066, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:15:0x0020, B:16:0x0023, B:28:0x0062, B:29:0x0065), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ensureInitialized() {
        java.lang.Throwable th;
        java.lang.Throwable e;
        synchronized (this.mLock) {
            if (this.mInitialized) {
                return;
            }
            android.content.res.XmlResourceParser xmlResourceParser = null;
            try {
                try {
                    android.content.res.XmlResourceParser xml = this.mContext.getResources().getXml(this.mResourceId);
                    try {
                        parseNetworkSecurityConfig(xml);
                        this.mContext = null;
                        this.mInitialized = true;
                        if (xml != null) {
                            xml.close();
                        }
                    } catch (android.content.res.Resources.NotFoundException e2) {
                        e = e2;
                        throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
                    } catch (com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException e3) {
                        e = e3;
                        throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
                    } catch (java.io.IOException e4) {
                        e = e4;
                        throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
                    } catch (org.xmlpull.v1.XmlPullParserException e5) {
                        e = e5;
                        throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (android.content.res.Resources.NotFoundException e6) {
                e = e6;
                e = e;
                throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
            } catch (com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException e7) {
                e = e7;
                e = e;
                throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
            } catch (java.io.IOException e8) {
                e = e8;
                e = e;
                throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
            } catch (org.xmlpull.v1.XmlPullParserException e9) {
                e = e9;
                e = e;
                throw new java.lang.RuntimeException("Failed to parse XML configuration from " + this.mContext.getResources().getResourceEntryName(this.mResourceId), e);
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
        }
    }

    private static final java.lang.String getConfigString(int i) {
        if (i == 0) {
            return "base-config";
        }
        if (i == 1) {
            return "domain-config";
        }
        if (i == 2) {
            return "debug-overrides";
        }
        throw new java.lang.IllegalArgumentException("Unknown config type: " + i);
    }

    private com.commonsware.cwac.netsecurity.config.CertificatesEntryRef parseCertificatesEntry(android.content.res.XmlResourceParser xmlResourceParser, boolean z) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        com.commonsware.cwac.netsecurity.config.CertificateSource systemCertificateSource;
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "overridePins", z);
        int attributeResourceValue = xmlResourceParser.getAttributeResourceValue(null, "src", -1);
        java.lang.String attributeValue = xmlResourceParser.getAttributeValue(null, "src");
        if (attributeValue == null) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "certificates element missing src attribute");
        }
        if (attributeResourceValue != -1) {
            systemCertificateSource = new com.commonsware.cwac.netsecurity.config.ResourceCertificateSource(attributeResourceValue, this.mContext);
        } else {
            if (!"system".equals(attributeValue) && !com.umeng.analytics.pro.ay.m.equals(attributeValue)) {
                throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Unknown certificates src. Should be one of system|user|@resourceVal");
            }
            systemCertificateSource = com.commonsware.cwac.netsecurity.config.SystemCertificateSource.getInstance();
        }
        com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
        return new com.commonsware.cwac.netsecurity.config.CertificatesEntryRef(systemCertificateSource, attributeBooleanValue);
    }

    private java.util.List<android.util.Pair<com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder, java.util.Set<com.commonsware.cwac.netsecurity.config.Domain>>> parseConfigEntry(android.content.res.XmlResourceParser xmlResourceParser, java.util.Set<java.lang.String> set, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder, int i) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder2 = new com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder();
        builder2.setParent(builder);
        java.util.HashSet hashSet = new java.util.HashSet();
        boolean z = false;
        boolean z2 = i == 2;
        xmlResourceParser.getName();
        int depth = xmlResourceParser.getDepth();
        arrayList.add(new android.util.Pair(builder2, hashSet));
        for (int i2 = 0; i2 < xmlResourceParser.getAttributeCount(); i2++) {
            java.lang.String attributeName = xmlResourceParser.getAttributeName(i2);
            if ("hstsEnforced".equals(attributeName)) {
                builder2.setHstsEnforced(xmlResourceParser.getAttributeBooleanValue(i2, false));
            } else if ("cleartextTrafficPermitted".equals(attributeName)) {
                builder2.setCleartextTrafficPermitted(xmlResourceParser.getAttributeBooleanValue(i2, true));
            }
        }
        boolean z3 = false;
        while (com.commonsware.cwac.netsecurity.internalutil.XmlUtils.nextElementWithin(xmlResourceParser, depth)) {
            java.lang.String name = xmlResourceParser.getName();
            if ("domain".equals(name)) {
                if (i != 1) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "domain element not allowed in " + getConfigString(i));
                }
                hashSet.add(parseDomain(xmlResourceParser, set));
            } else if ("trust-anchors".equals(name)) {
                if (z) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Multiple trust-anchor elements not allowed");
                }
                builder2.addCertificatesEntryRefs(parseTrustAnchors(xmlResourceParser, z2));
                z = true;
            } else if ("pin-set".equals(name)) {
                if (i != 1) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "pin-set element not allowed in " + getConfigString(i));
                }
                if (z3) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Multiple pin-set elements not allowed");
                }
                builder2.setPinSet(parsePinSet(xmlResourceParser));
                z3 = true;
            } else if (!"domain-config".equals(name)) {
                com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
            } else {
                if (i != 1) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Nested domain-config not allowed in " + getConfigString(i));
                }
                arrayList.addAll(parseConfigEntry(xmlResourceParser, set, builder2, i));
            }
        }
        if (i == 1 && hashSet.isEmpty()) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "No domain elements in domain-config");
        }
        return arrayList;
    }

    private com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder parseDebugOverridesResource() throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        android.content.res.Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(resources.getResourceEntryName(this.mResourceId) + "_debug", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML, resources.getResourcePackageName(this.mResourceId));
        android.content.res.XmlResourceParser xmlResourceParser = null;
        if (identifier == 0) {
            return null;
        }
        try {
            android.content.res.XmlResourceParser xml = resources.getXml(identifier);
            try {
                com.commonsware.cwac.netsecurity.internalutil.XmlUtils.beginDocument(xml, "network-security-config");
                int depth = xml.getDepth();
                com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = null;
                boolean z = false;
                while (com.commonsware.cwac.netsecurity.internalutil.XmlUtils.nextElementWithin(xml, depth)) {
                    if (!"debug-overrides".equals(xml.getName())) {
                        com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xml);
                    } else {
                        if (z) {
                            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xml, "Only one debug-overrides allowed");
                        }
                        if (this.mDebugBuild) {
                            builder = (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder) parseConfigEntry(xml, null, null, 2).get(0).first;
                        } else {
                            com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xml);
                        }
                        z = true;
                    }
                }
                xml.close();
                return builder;
            } catch (java.lang.Throwable th) {
                th = th;
                xmlResourceParser = xml;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private com.commonsware.cwac.netsecurity.config.Domain parseDomain(android.content.res.XmlResourceParser xmlResourceParser, java.util.Set<java.lang.String> set) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
        if (xmlResourceParser.next() != 4) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Domain name missing");
        }
        java.lang.String lowerCase = xmlResourceParser.getText().trim().toLowerCase(java.util.Locale.US);
        if (xmlResourceParser.next() != 3) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "domain contains additional elements");
        }
        if (set.add(lowerCase)) {
            return new com.commonsware.cwac.netsecurity.config.Domain(lowerCase, attributeBooleanValue);
        }
        throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, lowerCase + " has already been specified");
    }

    private void parseNetworkSecurityConfig(android.content.res.XmlResourceParser xmlResourceParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.ArrayList<android.util.Pair> arrayList = new java.util.ArrayList();
        com.commonsware.cwac.netsecurity.internalutil.XmlUtils.beginDocument(xmlResourceParser, "network-security-config");
        int depth = xmlResourceParser.getDepth();
        com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = null;
        com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder2 = null;
        boolean z = false;
        boolean z2 = false;
        while (com.commonsware.cwac.netsecurity.internalutil.XmlUtils.nextElementWithin(xmlResourceParser, depth)) {
            if ("base-config".equals(xmlResourceParser.getName())) {
                if (z) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Only one base-config allowed");
                }
                builder2 = (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder) parseConfigEntry(xmlResourceParser, hashSet, null, 0).get(0).first;
                z = true;
            } else if ("domain-config".equals(xmlResourceParser.getName())) {
                arrayList.addAll(parseConfigEntry(xmlResourceParser, hashSet, builder2, 1));
            } else if (!"debug-overrides".equals(xmlResourceParser.getName())) {
                com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
            } else {
                if (z2) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Only one debug-overrides allowed");
                }
                if (this.mDebugBuild) {
                    builder = (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder) parseConfigEntry(xmlResourceParser, null, null, 2).get(0).first;
                } else {
                    com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
                }
                z2 = true;
            }
        }
        if (this.mDebugBuild && builder == null) {
            builder = parseDebugOverridesResource();
        }
        com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder defaultBuilder = com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.getDefaultBuilder(this.mTargetSdkVersion);
        addDebugAnchorsIfNeeded(builder, defaultBuilder);
        if (builder2 != null) {
            builder2.setParent(defaultBuilder);
            addDebugAnchorsIfNeeded(builder, builder2);
        } else {
            builder2 = defaultBuilder;
        }
        java.util.HashSet hashSet2 = new java.util.HashSet();
        for (android.util.Pair pair : arrayList) {
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder3 = (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder) pair.first;
            java.util.Set set = (java.util.Set) pair.second;
            if (builder3.getParent() == null) {
                builder3.setParent(builder2);
            }
            addDebugAnchorsIfNeeded(builder, builder3);
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig build = builder3.build();
            java.util.Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet2.add(new android.util.Pair((com.commonsware.cwac.netsecurity.config.Domain) it.next(), build));
            }
        }
        this.mDefaultConfig = builder2.build();
        this.mDomainMap = hashSet2;
    }

    private com.commonsware.cwac.netsecurity.config.Pin parsePin(android.content.res.XmlResourceParser xmlResourceParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        java.lang.String attributeValue = xmlResourceParser.getAttributeValue(null, "digest");
        if (!com.commonsware.cwac.netsecurity.config.Pin.isSupportedDigestAlgorithm(attributeValue)) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Unsupported pin digest algorithm: " + attributeValue);
        }
        if (xmlResourceParser.next() != 4) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Missing pin digest");
        }
        try {
            byte[] decode = android.util.Base64.decode(xmlResourceParser.getText().trim(), 0);
            int digestLength = com.commonsware.cwac.netsecurity.config.Pin.getDigestLength(attributeValue);
            if (decode.length == digestLength) {
                if (xmlResourceParser.next() == 3) {
                    return new com.commonsware.cwac.netsecurity.config.Pin(attributeValue, decode);
                }
                throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "pin contains additional elements");
            }
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "digest length " + decode.length + " does not match expected length for " + attributeValue + " of " + digestLength);
        } catch (java.lang.IllegalArgumentException e) {
            throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Invalid pin digest", e);
        }
    }

    private com.commonsware.cwac.netsecurity.config.PinSet parsePinSet(android.content.res.XmlResourceParser xmlResourceParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        long time;
        java.lang.String attributeValue = xmlResourceParser.getAttributeValue(null, "expiration");
        if (attributeValue != null) {
            try {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                simpleDateFormat.setLenient(false);
                java.util.Date parse = simpleDateFormat.parse(attributeValue);
                if (parse == null) {
                    throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Invalid expiration date in pin-set");
                }
                time = parse.getTime();
            } catch (java.text.ParseException e) {
                throw new com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException(xmlResourceParser, "Invalid expiration date in pin-set", e);
            }
        } else {
            time = Long.MAX_VALUE;
        }
        int depth = xmlResourceParser.getDepth();
        java.util.HashSet hashSet = new java.util.HashSet();
        while (com.commonsware.cwac.netsecurity.internalutil.XmlUtils.nextElementWithin(xmlResourceParser, depth)) {
            if (xmlResourceParser.getName().equals("pin")) {
                hashSet.add(parsePin(xmlResourceParser));
            } else {
                com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
            }
        }
        return new com.commonsware.cwac.netsecurity.config.PinSet(hashSet, time);
    }

    private java.util.Collection<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> parseTrustAnchors(android.content.res.XmlResourceParser xmlResourceParser, boolean z) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, com.commonsware.cwac.netsecurity.config.XmlConfigSource.ParserException {
        int depth = xmlResourceParser.getDepth();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (com.commonsware.cwac.netsecurity.internalutil.XmlUtils.nextElementWithin(xmlResourceParser, depth)) {
            if (xmlResourceParser.getName().equals("certificates")) {
                arrayList.add(parseCertificatesEntry(xmlResourceParser, z));
            } else {
                com.commonsware.cwac.netsecurity.internalutil.XmlUtils.skipCurrentTag(xmlResourceParser);
            }
        }
        return arrayList;
    }

    @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
    public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig getDefaultConfig() {
        ensureInitialized();
        return this.mDefaultConfig;
    }

    @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
    public java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> getPerDomainConfigs() {
        ensureInitialized();
        return this.mDomainMap;
    }
}
