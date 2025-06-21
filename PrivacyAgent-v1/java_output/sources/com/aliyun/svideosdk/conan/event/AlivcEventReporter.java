package com.aliyun.svideosdk.conan.event;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public class AlivcEventReporter {
    private static final java.util.Map<java.lang.Long, com.aliyun.svideosdk.conan.event.AlivcEventReporter> d = new java.util.HashMap();
    private long a;
    private java.lang.String b;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mAccessKey;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private int mBussinessType;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mClientID;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mDeviceModel;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mEndPoint;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mExpireTime;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mLogStore;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mProjectName;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mSecretKey;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mSecurityToken;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private java.lang.String mTerminalType;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private boolean mUseExternalAuth;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private long mNativeHandler = 0;

    @com.aliyun.svideosdk.conan.DoNotProguard
    private long mNativeCallback = 0;
    private com.aliyun.svideosdk.conan.event.AlivcEventReporterListener c = null;

    public class a {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private java.lang.String e;
        private java.lang.String f;
        private java.lang.String g;
        private java.lang.String h;
        private java.lang.String i;
        private java.lang.String j;
        private java.lang.String k;
        private java.lang.String l;
        private java.lang.String m;
        private java.lang.String n;
        private java.lang.String o = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
        private java.lang.String p;

        public a(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter) {
        }

        public java.lang.String a() {
            return this.e;
        }

        public void a(java.lang.String str) {
            this.e = str;
        }

        public java.lang.String b() {
            return this.d;
        }

        public void b(java.lang.String str) {
            this.d = str;
        }

        public java.lang.String c() {
            return this.h;
        }

        public void c(java.lang.String str) {
            this.h = str;
        }

        public java.lang.String d() {
            return this.k;
        }

        public void d(java.lang.String str) {
            this.k = str;
        }

        public java.lang.String e() {
            return this.j;
        }

        public void e(java.lang.String str) {
            this.j = str;
        }

        public java.lang.String f() {
            return this.l;
        }

        public void f(java.lang.String str) {
            this.l = str;
        }

        public java.lang.String g() {
            return this.o;
        }

        public void g(java.lang.String str) {
            this.o = str;
        }

        public java.lang.String h() {
            return this.p;
        }

        public void h(java.lang.String str) {
            this.p = str;
        }

        public java.lang.String i() {
            return this.i;
        }

        public void i(java.lang.String str) {
            this.i = str;
        }

        public java.lang.String j() {
            return this.g;
        }

        public void j(java.lang.String str) {
            this.g = str;
        }

        public java.lang.String k() {
            return this.n;
        }

        public void k(java.lang.String str) {
            this.n = str;
        }

        public java.lang.String l() {
            return this.c;
        }

        public void l(java.lang.String str) {
            this.c = str;
        }

        public java.lang.String m() {
            return this.a;
        }

        public void m(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String n() {
            return this.b;
        }

        public void n(java.lang.String str) {
            this.b = str;
        }

        public java.lang.String o() {
            return this.m;
        }

        public void o(java.lang.String str) {
            this.m = str;
        }

        public java.lang.String p() {
            return this.f;
        }

        public void p(java.lang.String str) {
            this.f = str;
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public AlivcEventReporter(com.aliyun.svideosdk.conan.event.AlivcEventReporterConfig alivcEventReporterConfig) {
        if (com.aliyun.svideosdk.conan.a.p() == null) {
            throw new java.lang.IllegalArgumentException("Context must NOT null, check setSDKContext");
        }
        if (alivcEventReporterConfig == null) {
            throw new java.lang.IllegalArgumentException("Unable to initialize the AlivcEventReporter with empty configuration!");
        }
        try {
            this.mClientID = com.aliyun.svideosdk.conan.a.j();
            this.mTerminalType = com.aliyun.svideosdk.conan.a.q();
            this.mDeviceModel = com.aliyun.svideosdk.conan.a.i();
            this.mBussinessType = alivcEventReporterConfig.getBusinessType().getBizType();
            this.mUseExternalAuth = alivcEventReporterConfig.isUseExternalAuth();
            this.mEndPoint = alivcEventReporterConfig.getEndPoint();
            this.mProjectName = alivcEventReporterConfig.getProjectName();
            this.mLogStore = alivcEventReporterConfig.getLogStore();
            this.mAccessKey = alivcEventReporterConfig.getAccessKey();
            this.mSecretKey = alivcEventReporterConfig.getSecretKey();
            this.mSecurityToken = alivcEventReporterConfig.getSecurityToken();
            this.mExpireTime = alivcEventReporterConfig.getExpireTime();
            initNative();
            com.aliyun.svideosdk.conan.event.a.c().a(alivcEventReporterConfig.getApplicationName());
            com.aliyun.svideosdk.conan.event.a.c().b(alivcEventReporterConfig.getApplicationVersion());
            com.aliyun.svideosdk.conan.event.a.c().a(alivcEventReporterConfig.getSDKEnvironment());
            if (this.mNativeHandler != 0) {
                long idNative = getIdNative();
                if (idNative != -1) {
                    this.a = idNative;
                    d.put(java.lang.Long.valueOf(idNative), this);
                }
                setPublicParamNative(a(com.aliyun.svideosdk.conan.event.a.c().b()));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            boolean z = true;
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                if (!z) {
                    sb.append(" *||* ");
                }
                sb.append(entry.getKey());
                sb.append(" * ");
                sb.append(entry.getValue());
                z = false;
            }
        } catch (java.lang.Throwable unused) {
        }
        return sb.toString();
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native void destoryNative();

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int flushEventNative(int i, java.lang.String str);

    @com.aliyun.svideosdk.conan.DoNotProguard
    public static java.lang.String generateSessionId() {
        return com.aliyun.svideosdk.conan.a.c();
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public static com.aliyun.svideosdk.conan.event.AlivcEventReporter getEventReporterById(long j) {
        return d.get(java.lang.Long.valueOf(j));
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native long getIdNative();

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native void initNative();

    @com.aliyun.svideosdk.conan.DoNotProguard
    private void onEventReport(java.util.Map<java.lang.String, java.lang.String> map) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporterListener alivcEventReporterListener = this.c;
        if (alivcEventReporterListener != null) {
            alivcEventReporterListener.onEventReport(this, map);
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private void onEventReportErrorOccur(int i) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporterListener alivcEventReporterListener = this.c;
        if (alivcEventReporterListener != null) {
            alivcEventReporterListener.onEventReportErrorOccur(this, i);
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private void onStsExpired() {
        com.aliyun.svideosdk.conan.event.AlivcEventReporterListener alivcEventReporterListener = this.c;
        if (alivcEventReporterListener != null) {
            alivcEventReporterListener.OnStsExpired(this);
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private void onStsWillExpireSoon(long j) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporterListener alivcEventReporterListener = this.c;
        if (alivcEventReporterListener != null) {
            alivcEventReporterListener.onStsWillExpireSoon(this, j);
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int resetAcessTokenInfoNative();

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int sendEventNative(int i, java.lang.String str);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int setPublicParamNative(java.lang.String str);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int updatePublicParamNative(java.lang.String str, java.lang.String str2);

    @com.aliyun.svideosdk.conan.DoNotProguard
    public synchronized void destory() {
        destoryNative();
        d.remove(java.lang.Long.valueOf(this.a));
        this.c = null;
        this.mNativeHandler = 0L;
        this.mNativeCallback = 0L;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int flushEvent(int i, java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.mNativeHandler != 0) {
            return flushEventNative(i, a(map));
        }
        return -1;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public synchronized long getEventReporterId() {
        return this.mNativeHandler != 0 ? getIdNative() : -1L;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String refreshSessionId() {
        java.lang.String c = com.aliyun.svideosdk.conan.a.c();
        setSessionId(c);
        return c;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void resetAcessTokenInfoWithKey(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (this.mNativeHandler != 0) {
            this.mAccessKey = str;
            this.mSecretKey = str2;
            this.mSecurityToken = str3;
            this.mExpireTime = str4;
            resetAcessTokenInfoNative();
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void sendCodecInfoEvent() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        android.media.MediaCodecInfo mediaCodecInfo;
        java.lang.String str;
        java.lang.String[] strArr;
        int i7;
        int i8;
        boolean contains;
        boolean contains2;
        android.util.Range<java.lang.Integer> supportedWidths;
        int maxSupportedInstances;
        android.media.MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            int codecCount = android.media.MediaCodecList.getCodecCount();
            int i9 = 0;
            i5 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            while (i9 < codecCount) {
                try {
                    android.media.MediaCodecInfo codecInfoAt = android.media.MediaCodecList.getCodecInfoAt(i9);
                    java.lang.String name = codecInfoAt.getName();
                    boolean isEncoder = codecInfoAt.isEncoder();
                    java.lang.String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i10 = 0;
                    while (i10 < length) {
                        java.lang.String str2 = supportedTypes[i10];
                        com.aliyun.svideosdk.conan.event.AlivcEventReporter.a aVar = new com.aliyun.svideosdk.conan.event.AlivcEventReporter.a(alivcEventReporter);
                        int i11 = codecCount;
                        try {
                            contains = str2.contains("avc");
                            strArr = supportedTypes;
                            try {
                                contains2 = str2.contains("hevc");
                            } catch (java.lang.Exception e) {
                                e = e;
                                i6 = i9;
                                mediaCodecInfo = codecInfoAt;
                                str = name;
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            i6 = i9;
                            mediaCodecInfo = codecInfoAt;
                            str = name;
                            strArr = supportedTypes;
                        }
                        if (contains || contains2) {
                            aVar.m(name);
                            str = name;
                            try {
                                aVar.n(isEncoder ? "enc" : "dec");
                                aVar.l(str2);
                                android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                int i12 = android.os.Build.VERSION.SDK_INT;
                                if (isEncoder) {
                                    mediaCodecInfo = codecInfoAt;
                                } else {
                                    mediaCodecInfo = codecInfoAt;
                                    try {
                                        aVar.h(java.lang.String.valueOf(capabilitiesForType.isFeatureSupported("adaptive-playback")));
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        i6 = i9;
                                        i7 = length;
                                        i8 = i10;
                                        e.printStackTrace();
                                        aVar.g(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                                        jSONObject.put("name", aVar.m());
                                        jSONObject.put("type", aVar.n());
                                        jSONObject.put("feat1", aVar.h());
                                        jSONObject.put("mime", aVar.l());
                                        jSONObject.put("alignW", aVar.b());
                                        jSONObject.put("alignH", aVar.a());
                                        jSONObject.put("width", aVar.p());
                                        jSONObject.put("height", aVar.j());
                                        jSONObject.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, aVar.c());
                                        jSONObject.put("frameRate", aVar.i());
                                        jSONObject.put("complexity", aVar.e());
                                        jSONObject.put("cbr", aVar.d());
                                        jSONObject.put("cq", aVar.f());
                                        jSONObject.put("vbr", aVar.o());
                                        jSONObject.put("maxInst", aVar.k());
                                        jSONObject.put("enable", aVar.g());
                                        jSONArray.put(jSONObject);
                                        i10 = i8 + 1;
                                        alivcEventReporter = this;
                                        codecCount = i11;
                                        supportedTypes = strArr;
                                        codecInfoAt = mediaCodecInfo;
                                        name = str;
                                        length = i7;
                                        i9 = i6;
                                    }
                                }
                                android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                i7 = length;
                                if (videoCapabilities != null) {
                                    try {
                                        int widthAlignment = videoCapabilities.getWidthAlignment();
                                        int heightAlignment = videoCapabilities.getHeightAlignment();
                                        aVar.b(java.lang.String.valueOf(widthAlignment));
                                        aVar.a(java.lang.String.valueOf(heightAlignment));
                                        supportedWidths = videoCapabilities.getSupportedWidths();
                                        i6 = i9;
                                    } catch (java.lang.Exception e4) {
                                        e = e4;
                                        i6 = i9;
                                    }
                                    try {
                                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                        i8 = i10;
                                        try {
                                            sb.append(supportedWidths.getLower());
                                            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            sb.append(supportedWidths.getUpper());
                                            aVar.p(sb.toString());
                                            android.util.Range<java.lang.Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                                            aVar.j(supportedHeights.getLower() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + supportedHeights.getUpper());
                                            android.util.Range<java.lang.Integer> bitrateRange = videoCapabilities.getBitrateRange();
                                            aVar.c(bitrateRange.getLower() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + bitrateRange.getUpper());
                                            android.util.Range<java.lang.Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                                            aVar.i(supportedFrameRates.getLower() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + supportedFrameRates.getUpper());
                                        } catch (java.lang.Exception e5) {
                                            e = e5;
                                            e.printStackTrace();
                                            aVar.g(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                            jSONObject2.put("name", aVar.m());
                                            jSONObject2.put("type", aVar.n());
                                            jSONObject2.put("feat1", aVar.h());
                                            jSONObject2.put("mime", aVar.l());
                                            jSONObject2.put("alignW", aVar.b());
                                            jSONObject2.put("alignH", aVar.a());
                                            jSONObject2.put("width", aVar.p());
                                            jSONObject2.put("height", aVar.j());
                                            jSONObject2.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, aVar.c());
                                            jSONObject2.put("frameRate", aVar.i());
                                            jSONObject2.put("complexity", aVar.e());
                                            jSONObject2.put("cbr", aVar.d());
                                            jSONObject2.put("cq", aVar.f());
                                            jSONObject2.put("vbr", aVar.o());
                                            jSONObject2.put("maxInst", aVar.k());
                                            jSONObject2.put("enable", aVar.g());
                                            jSONArray.put(jSONObject2);
                                            i10 = i8 + 1;
                                            alivcEventReporter = this;
                                            codecCount = i11;
                                            supportedTypes = strArr;
                                            codecInfoAt = mediaCodecInfo;
                                            name = str;
                                            length = i7;
                                            i9 = i6;
                                        }
                                    } catch (java.lang.Exception e6) {
                                        e = e6;
                                        i8 = i10;
                                        e.printStackTrace();
                                        aVar.g(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                        org.json.JSONObject jSONObject22 = new org.json.JSONObject();
                                        jSONObject22.put("name", aVar.m());
                                        jSONObject22.put("type", aVar.n());
                                        jSONObject22.put("feat1", aVar.h());
                                        jSONObject22.put("mime", aVar.l());
                                        jSONObject22.put("alignW", aVar.b());
                                        jSONObject22.put("alignH", aVar.a());
                                        jSONObject22.put("width", aVar.p());
                                        jSONObject22.put("height", aVar.j());
                                        jSONObject22.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, aVar.c());
                                        jSONObject22.put("frameRate", aVar.i());
                                        jSONObject22.put("complexity", aVar.e());
                                        jSONObject22.put("cbr", aVar.d());
                                        jSONObject22.put("cq", aVar.f());
                                        jSONObject22.put("vbr", aVar.o());
                                        jSONObject22.put("maxInst", aVar.k());
                                        jSONObject22.put("enable", aVar.g());
                                        jSONArray.put(jSONObject22);
                                        i10 = i8 + 1;
                                        alivcEventReporter = this;
                                        codecCount = i11;
                                        supportedTypes = strArr;
                                        codecInfoAt = mediaCodecInfo;
                                        name = str;
                                        length = i7;
                                        i9 = i6;
                                    }
                                } else {
                                    i6 = i9;
                                    i8 = i10;
                                }
                                if (isEncoder && (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) != null) {
                                    android.util.Range<java.lang.Integer> complexityRange = encoderCapabilities.getComplexityRange();
                                    aVar.e(complexityRange.getLower() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + complexityRange.getUpper());
                                    aVar.d(java.lang.String.valueOf(encoderCapabilities.isBitrateModeSupported(2)));
                                    try {
                                        aVar.f(java.lang.String.valueOf(encoderCapabilities.isBitrateModeSupported(0)));
                                        aVar.o(java.lang.String.valueOf(encoderCapabilities.isBitrateModeSupported(1)));
                                    } catch (java.lang.Exception e7) {
                                        e = e7;
                                        e.printStackTrace();
                                        aVar.g(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                        org.json.JSONObject jSONObject222 = new org.json.JSONObject();
                                        jSONObject222.put("name", aVar.m());
                                        jSONObject222.put("type", aVar.n());
                                        jSONObject222.put("feat1", aVar.h());
                                        jSONObject222.put("mime", aVar.l());
                                        jSONObject222.put("alignW", aVar.b());
                                        jSONObject222.put("alignH", aVar.a());
                                        jSONObject222.put("width", aVar.p());
                                        jSONObject222.put("height", aVar.j());
                                        jSONObject222.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, aVar.c());
                                        jSONObject222.put("frameRate", aVar.i());
                                        jSONObject222.put("complexity", aVar.e());
                                        jSONObject222.put("cbr", aVar.d());
                                        jSONObject222.put("cq", aVar.f());
                                        jSONObject222.put("vbr", aVar.o());
                                        jSONObject222.put("maxInst", aVar.k());
                                        jSONObject222.put("enable", aVar.g());
                                        jSONArray.put(jSONObject222);
                                        i10 = i8 + 1;
                                        alivcEventReporter = this;
                                        codecCount = i11;
                                        supportedTypes = strArr;
                                        codecInfoAt = mediaCodecInfo;
                                        name = str;
                                        length = i7;
                                        i9 = i6;
                                    }
                                }
                                if (i12 >= 23) {
                                    maxSupportedInstances = capabilitiesForType.getMaxSupportedInstances();
                                    aVar.k(java.lang.String.valueOf(maxSupportedInstances));
                                }
                                if (isEncoder) {
                                    if (contains2) {
                                        i5++;
                                    } else if (contains) {
                                        i2++;
                                    }
                                } else if (contains2) {
                                    i3++;
                                } else if (contains) {
                                    i4++;
                                }
                            } catch (java.lang.Exception e8) {
                                e = e8;
                                i6 = i9;
                                mediaCodecInfo = codecInfoAt;
                            }
                            org.json.JSONObject jSONObject2222 = new org.json.JSONObject();
                            try {
                                jSONObject2222.put("name", aVar.m());
                                jSONObject2222.put("type", aVar.n());
                                jSONObject2222.put("feat1", aVar.h());
                                jSONObject2222.put("mime", aVar.l());
                                jSONObject2222.put("alignW", aVar.b());
                                jSONObject2222.put("alignH", aVar.a());
                                jSONObject2222.put("width", aVar.p());
                                jSONObject2222.put("height", aVar.j());
                                jSONObject2222.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, aVar.c());
                                jSONObject2222.put("frameRate", aVar.i());
                                jSONObject2222.put("complexity", aVar.e());
                                jSONObject2222.put("cbr", aVar.d());
                                jSONObject2222.put("cq", aVar.f());
                                jSONObject2222.put("vbr", aVar.o());
                                jSONObject2222.put("maxInst", aVar.k());
                                jSONObject2222.put("enable", aVar.g());
                            } catch (org.json.JSONException e9) {
                                e9.printStackTrace();
                            }
                            jSONArray.put(jSONObject2222);
                            i10 = i8 + 1;
                            alivcEventReporter = this;
                            codecCount = i11;
                            supportedTypes = strArr;
                            codecInfoAt = mediaCodecInfo;
                            name = str;
                            length = i7;
                            i9 = i6;
                        } else {
                            i6 = i9;
                            mediaCodecInfo = codecInfoAt;
                            str = name;
                            i7 = length;
                            i8 = i10;
                            i10 = i8 + 1;
                            alivcEventReporter = this;
                            codecCount = i11;
                            supportedTypes = strArr;
                            codecInfoAt = mediaCodecInfo;
                            name = str;
                            length = i7;
                            i9 = i6;
                        }
                    }
                    alivcEventReporter = this;
                    i9++;
                } catch (java.lang.Exception e10) {
                    e = e10;
                    i = i5;
                    e.printStackTrace();
                    i5 = i;
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("_hevc_enc_count", java.lang.String.valueOf(i5));
                    hashMap.put("_avc_enc_count", java.lang.String.valueOf(i2));
                    hashMap.put("_hevc_dec_count", java.lang.String.valueOf(i3));
                    hashMap.put("_avc_dec_count", java.lang.String.valueOf(i4));
                    hashMap.put("codec_info", jSONArray.toString());
                    sendEventNative(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, a(hashMap));
                }
            }
        } catch (java.lang.Exception e11) {
            e = e11;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        java.util.HashMap hashMap2 = new java.util.HashMap();
        hashMap2.put("_hevc_enc_count", java.lang.String.valueOf(i5));
        hashMap2.put("_avc_enc_count", java.lang.String.valueOf(i2));
        hashMap2.put("_hevc_dec_count", java.lang.String.valueOf(i3));
        hashMap2.put("_avc_dec_count", java.lang.String.valueOf(i4));
        hashMap2.put("codec_info", jSONArray.toString());
        sendEventNative(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, a(hashMap2));
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int sendCyclistEvent() {
        if (this.mNativeHandler != 0) {
            return sendEventNative(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, a(com.aliyun.svideosdk.conan.event.a.c().a()));
        }
        return -1;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int sendEvent(int i, java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.mNativeHandler != 0) {
            return sendEventNative(i, a(map));
        }
        return -1;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int sendOnceEvent() {
        if (this.mNativeHandler == 0) {
            return -1;
        }
        java.util.Map<java.lang.String, java.lang.String> d2 = com.aliyun.svideosdk.conan.event.a.c().d();
        if (!android.text.TextUtils.isEmpty(this.b)) {
            d2.put("bcid", this.b);
        }
        return sendEventNative(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.WAITING_CONNECT, a(d2));
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setAlivcRole(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("role", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setAliyunAppId(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("ali_app_id", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setApplicationName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.aliyun.svideosdk.conan.event.a.c().a(str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setBuildIdCommitIdString(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setEventReportListener(com.aliyun.svideosdk.conan.event.AlivcEventReporterListener alivcEventReporterListener) {
        this.c = alivcEventReporterListener;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSDKEnvironment(com.aliyun.svideosdk.conan.AlivcSDKEnvironment alivcSDKEnvironment) {
        if (this.mNativeHandler == 0 || alivcSDKEnvironment == null) {
            return;
        }
        updatePublicParamNative("se", "" + alivcSDKEnvironment.getSDKEnv());
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSDKVersion(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("av", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSessionId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("ri", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSubModuleName(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("md", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updatePublicParam(java.lang.String str, java.lang.String str2) {
        updatePublicParamNative(str, str2);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updateRoomId(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("rid", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updateTraceId(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("ti", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updateUserId(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("uid", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updateVideoType(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("vt", str);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void updateVideoUrl(java.lang.String str) {
        if (this.mNativeHandler == 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("vu", str);
    }
}
