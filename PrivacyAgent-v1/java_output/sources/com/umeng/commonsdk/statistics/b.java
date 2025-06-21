package com.umeng.commonsdk.statistics;

/* loaded from: classes19.dex */
public class b {
    public static java.lang.String a = null;
    public static java.lang.String b = "";
    private static final java.lang.String c = "EnvelopeManager";
    private static final java.lang.String d = "debug.umeng.umTaskId";
    private static final java.lang.String e = "debug.umeng.umCaseId";
    private static final java.lang.String f = "empty";
    private static java.lang.String g = "";
    private static java.lang.String h = "";
    private static java.lang.String i;
    private static java.util.Map<java.lang.String, java.lang.String> j;
    private static boolean l;
    private int k = 0;

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        j = hashMap;
        hashMap.put("header", "#h");
        j.put("sdk_type", "#sdt");
        j.put(com.umeng.analytics.pro.bo.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(com.umeng.analytics.pro.bo.g, "#umid");
        j.put("os", "os");
        j.put("language", "#lang");
        j.put(com.umeng.analytics.pro.bo.ai, "#dt");
        j.put("resolution", "#rl");
        j.put(com.umeng.analytics.pro.bo.H, "#dmf");
        j.put(com.umeng.analytics.pro.bo.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put("os_version", "#ov");
        j.put(com.umeng.analytics.pro.bo.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(com.umeng.analytics.pro.bo.F, "#db");
        j.put("appkey", "#ak");
        j.put(com.umeng.analytics.pro.bo.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(com.umeng.analytics.pro.bo.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put("package_name", "#pkg");
        j.put(com.umeng.analytics.pro.bo.p, "#sig");
        j.put(com.umeng.analytics.pro.bo.q, "#sis1");
        j.put(com.umeng.analytics.pro.bo.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(com.umeng.analytics.pro.bo.v, "#imd");
        j.put(com.umeng.analytics.pro.bo.B, "#mnc");
        j.put(com.umeng.analytics.pro.bo.E, "#boa");
        j.put(com.umeng.analytics.pro.bo.G, "#mant");
        j.put("timezone", "#tz");
        j.put("country", "#ct");
        j.put(com.umeng.analytics.pro.bo.P, "#car");
        j.put(com.umeng.analytics.pro.bo.f445s, "#disn");
        j.put("network_type", "#nt");
        j.put(com.umeng.analytics.pro.bo.b, "#cv");
        j.put(com.umeng.analytics.pro.bo.d, "#mv");
        j.put(com.umeng.analytics.pro.bo.c, "#cot");
        j.put(com.umeng.analytics.pro.bo.e, "#mod");
        j.put(com.umeng.analytics.pro.bo.aj, "#al");
        j.put("session_id", "#sid");
        j.put(com.umeng.analytics.pro.bo.S, "#ip");
        j.put(com.umeng.analytics.pro.bo.U, "#sre");
        j.put(com.umeng.analytics.pro.bo.V, "#fre");
        j.put(com.umeng.analytics.pro.bo.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(com.umeng.analytics.pro.bo.bb, "#tsv");
        j.put(com.umeng.analytics.pro.bo.bc, "#rps");
        j.put(com.umeng.analytics.pro.bo.bh, "#mov");
        j.put(com.umeng.analytics.pro.f.i, "#vt");
        j.put("secret", "#sec");
        j.put(com.umeng.analytics.pro.f.an, "#prv");
        j.put(com.umeng.analytics.pro.f.l, "#$prv");
        j.put(com.umeng.analytics.pro.f.m, "#uda");
        j.put(com.umeng.analytics.pro.bo.a, "#tok");
        j.put(com.umeng.analytics.pro.bo.aT, "#iv");
        j.put(com.umeng.analytics.pro.bo.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(com.umeng.analytics.pro.bo.ap, "#mt");
        j.put(com.umeng.analytics.pro.bo.am, "#zsv");
        j.put("others_OS", "#oos");
    }

    private int a(android.content.Context context, com.umeng.commonsdk.statistics.idtracking.Envelope envelope, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || envelope == null || android.text.TextUtils.isEmpty(str)) {
            return 101;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(context);
        }
        java.lang.String b2 = com.umeng.commonsdk.stateless.d.b(str3);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(java.lang.System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(com.anythink.china.common.a.a.f);
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return com.umeng.commonsdk.framework.UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        return (str.startsWith(com.umeng.analytics.pro.bo.aJ) || str.startsWith("i") || str.startsWith("a") || str.startsWith("t")) ? com.umeng.commonsdk.framework.UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary) : com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
    }

    public static long a(android.content.Context context) {
        long j2 = com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("free size is ");
            sb.append(j2);
        }
        return j2;
    }

    private com.umeng.commonsdk.statistics.idtracking.Envelope a(android.content.Context context, byte[] bArr) {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!android.text.TextUtils.isEmpty(imprintProperty)) {
                i2 = java.lang.Integer.valueOf(imprintProperty).intValue();
            }
        } catch (java.lang.NumberFormatException e2) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return com.umeng.commonsdk.statistics.idtracking.Envelope.genEnvelope(context, com.umeng.commonsdk.utils.UMUtils.getAppkey(context), bArr);
        }
        if (i2 != 1 && !l) {
            return com.umeng.commonsdk.statistics.idtracking.Envelope.genEnvelope(context, com.umeng.commonsdk.utils.UMUtils.getAppkey(context), bArr);
        }
        return com.umeng.commonsdk.statistics.idtracking.Envelope.genEncryptEnvelope(context, com.umeng.commonsdk.utils.UMUtils.getAppkey(context), bArr);
    }

    public static java.lang.String a(java.lang.String str) {
        return j.containsKey(str) ? j.get(str) : str;
    }

    private org.json.JSONObject a(int i2, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (java.lang.Exception unused) {
            }
            return jSONObject;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (java.lang.Exception unused2) {
        }
        return jSONObject2;
    }

    private static org.json.JSONObject a(android.content.Context context, java.lang.String str, boolean z) {
        android.content.SharedPreferences sharedPreferences;
        org.json.JSONObject jSONObject;
        try {
            android.content.SharedPreferences sharedPreferences2 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            if (android.text.TextUtils.isEmpty(i)) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(a(com.umeng.analytics.pro.bo.p), com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a(com.umeng.analytics.pro.bo.q), com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a(com.umeng.analytics.pro.bo.r), com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), java.lang.Integer.parseInt(com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a(com.umeng.analytics.pro.bo.v), com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a("cpu"), com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU());
                java.lang.String mccmnc = com.umeng.commonsdk.statistics.common.DeviceConfig.getMCCMNC(context);
                if (android.text.TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.B), "");
                } else {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.B), mccmnc);
                    b = mccmnc;
                }
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.I)) {
                    java.lang.String subOSName = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSName(context);
                    if (!android.text.TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a(com.umeng.analytics.pro.bo.K), subOSName);
                    }
                    java.lang.String subOSVersion = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSVersion(context);
                    if (!android.text.TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a(com.umeng.analytics.pro.bo.L), subOSVersion);
                    }
                }
                java.lang.String deviceType = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceType(context);
                if (!android.text.TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.ai), deviceType);
                }
                jSONObject2.put(a("package_name"), com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(context));
                jSONObject2.put(a("sdk_type"), "Android");
                jSONObject2.put(a("device_id"), com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), android.os.Build.MODEL);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.E), android.os.Build.BOARD);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.F), android.os.Build.BRAND);
                sharedPreferences = sharedPreferences2;
                jSONObject2.put(a(com.umeng.analytics.pro.bo.G), android.os.Build.TIME);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.H), android.os.Build.MANUFACTURER);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.I), android.os.Build.ID);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.J), android.os.Build.DEVICE);
                jSONObject2.put(a("os_version"), android.os.Build.VERSION.RELEASE);
                jSONObject2.put(a("os"), "Android");
                int[] resolutionArray = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put(a("resolution"), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(a(com.umeng.analytics.pro.bo.A), com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(context));
                jSONObject2.put(a("timezone"), com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(context));
                java.lang.String[] localeInfo = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a("country"), localeInfo[0]);
                jSONObject2.put(a("language"), localeInfo[1]);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.P), com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a(com.umeng.analytics.pro.bo.f445s), com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(context));
                java.lang.String[] networkAccessMode = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.Q), com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.Q), "2G/3G");
                } else {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.R), networkAccessMode[1]);
                }
                if (com.umeng.commonsdk.statistics.common.DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a("others_OS"), "harmony");
                } else {
                    jSONObject2.put(a("others_OS"), "Android");
                }
                jSONObject2.put(a("network_type"), com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkType(context));
                jSONObject2.put(a(com.umeng.analytics.pro.bo.b), "9.7.5");
                jSONObject2.put(a(com.umeng.analytics.pro.bo.c), com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE);
                jSONObject2.put(a(com.umeng.analytics.pro.bo.d), "1");
                if (!android.text.TextUtils.isEmpty(a)) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.e), a);
                }
                jSONObject2.put(a(com.umeng.analytics.pro.bo.aj), android.os.Build.VERSION.SDK_INT);
                if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a(com.umeng.analytics.pro.bo.af), com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    java.lang.String uUIDForZid = com.umeng.commonsdk.utils.UMUtils.getUUIDForZid(context);
                    if (android.text.TextUtils.isEmpty(uUIDForZid)) {
                        com.umeng.commonsdk.utils.UMUtils.setUUIDForZid(context);
                        uUIDForZid = com.umeng.commonsdk.utils.UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), uUIDForZid);
                } catch (java.lang.Throwable unused) {
                }
                try {
                    if (com.umeng.commonsdk.statistics.common.DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put(com.umeng.analytics.pro.bo.ar, "1");
                        if (com.umeng.commonsdk.statistics.common.DeviceConfig.hasOpsPermission(context.getApplicationContext())) {
                            jSONObject2.put(com.umeng.analytics.pro.bo.as, "1");
                        }
                    }
                    if (com.umeng.commonsdk.statistics.common.DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(com.umeng.analytics.pro.bo.aq, "1");
                    }
                } catch (java.lang.Throwable unused2) {
                }
                if (com.umeng.commonsdk.statistics.common.DeviceConfig.isHonorDevice()) {
                    try {
                        if (com.umeng.analytics.pro.bm.c()) {
                            jSONObject2.put(com.umeng.analytics.pro.bo.at, 2);
                        }
                        if (com.umeng.analytics.pro.bm.b()) {
                            jSONObject2.put(com.umeng.analytics.pro.bo.at, 3);
                        }
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                try {
                    jSONObject2.put(com.umeng.analytics.pro.bo.au, com.umeng.commonsdk.statistics.common.DeviceConfig.getNotificationStatus(context));
                } catch (java.lang.Throwable unused4) {
                }
                try {
                    jSONObject2.put(com.umeng.analytics.pro.bo.av, com.umeng.commonsdk.statistics.common.DeviceConfig.getRingerMode(context));
                } catch (java.lang.Throwable unused5) {
                }
                i = jSONObject2.toString();
                jSONObject = jSONObject2;
            } else {
                try {
                    jSONObject = new org.json.JSONObject(i);
                    sharedPreferences = sharedPreferences2;
                } catch (java.lang.Exception unused6) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(com.umeng.analytics.pro.bo.ak), com.umeng.commonsdk.utils.UMUtils.getOaidRequiredTime(context));
            } catch (java.lang.Exception unused7) {
            }
            try {
                android.content.SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put(a(com.umeng.analytics.pro.bo.U), sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put(a(com.umeng.analytics.pro.bo.V), sharedPreferences3.getInt(com.umeng.analytics.pro.bo.V, 0));
                jSONObject.put(a(com.umeng.analytics.pro.bo.W), sharedPreferences3.getInt("last_request_spent_ms", 0));
                java.lang.String zid = com.umeng.commonsdk.utils.UMUtils.getZid(context);
                if (!android.text.TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.al), zid);
                }
                if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.am), com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (java.lang.Exception unused8) {
            }
            jSONObject.put(a("channel"), com.umeng.commonsdk.utils.UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), com.umeng.commonsdk.utils.UMUtils.getAppkey(context));
            try {
                java.lang.String deviceToken = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(context);
                if (!android.text.TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.a), deviceToken);
                }
            } catch (java.lang.Exception e2) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
            }
            try {
                java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, com.umeng.analytics.pro.bo.g, null);
                if (!android.text.TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.g), imprintProperty);
                }
            } catch (java.lang.Exception e3) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put(a("wrapper_type"), com.umeng.commonsdk.statistics.a.a);
                jSONObject.put(a("wrapper_version"), com.umeng.commonsdk.statistics.a.b);
            } catch (java.lang.Exception unused9) {
            }
            try {
                int targetSdkVersion = com.umeng.commonsdk.utils.UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = com.umeng.commonsdk.utils.UMUtils.checkPermission(context, com.anythink.china.common.d.a);
                jSONObject.put(a(com.umeng.analytics.pro.bo.bb), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.bc), "yes");
                } else {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.bc), "no");
                }
            } catch (java.lang.Throwable unused10) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (java.lang.Throwable unused11) {
            }
            if (("t".equals(str) || "a".equals(str)) && z) {
                try {
                    int[] b2 = b(context);
                    jSONObject.put(a(com.umeng.analytics.pro.bo.by), java.lang.String.valueOf(b2[0]) + java.lang.String.valueOf(b2[1]) + java.lang.String.valueOf(b2[2]));
                } catch (java.lang.Throwable unused12) {
                }
            }
            try {
                java.util.Map<java.lang.String, java.lang.String> moduleTags = com.umeng.commonsdk.statistics.TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(com.umeng.analytics.pro.bo.ap), jSONObject3);
                }
            } catch (java.lang.Throwable unused13) {
            }
            try {
                java.lang.String realTimeDebugKey = com.umeng.analytics.AnalyticsConfig.getRealTimeDebugKey();
                if (!android.text.TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.bx), realTimeDebugKey);
                }
            } catch (java.lang.Throwable unused14) {
            }
            try {
                org.json.JSONObject moduleVer = com.umeng.commonsdk.utils.UMUtils.getModuleVer();
                if (moduleVer.length() > 0) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.bh), moduleVer);
                }
            } catch (java.lang.Throwable unused15) {
            }
            try {
                java.lang.String apmFlag = com.umeng.commonsdk.utils.UMUtils.getApmFlag();
                if (!android.text.TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.bw), apmFlag);
                }
            } catch (java.lang.Throwable unused16) {
            }
            try {
                java.lang.String str2 = android.os.Build.BRAND;
                java.lang.String a2 = com.umeng.analytics.pro.at.a(str2);
                java.lang.String b3 = com.umeng.analytics.pro.at.b(str2);
                jSONObject.put(com.umeng.analytics.pro.bo.bf, a2);
                jSONObject.put(com.umeng.analytics.pro.bo.bg, b3);
            } catch (java.lang.Throwable unused17) {
            }
            byte[] a3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).a();
            if (a3 != null && a3.length > 0) {
                try {
                    jSONObject.put(a(com.umeng.analytics.pro.bo.X), android.util.Base64.encodeToString(a3, 0));
                } catch (org.json.JSONException e4) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject.length() > 0) {
                return new org.json.JSONObject().put(a("header"), jSONObject);
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private org.json.JSONObject a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof org.json.JSONObject)) {
            org.json.JSONObject jSONObject3 = (org.json.JSONObject) jSONObject.opt(a("header"));
            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (next != null && (next instanceof java.lang.String)) {
                    java.lang.String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(com.umeng.analytics.pro.f.i)) && (jSONObject2.opt(str) instanceof java.lang.Integer)) {
                                this.k = ((java.lang.Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a() {
        if (i != null) {
            i = null;
            com.umeng.commonsdk.statistics.idtracking.f.a();
        }
    }

    public static void a(boolean z) {
        l = z;
    }

    private static boolean b() {
        g = com.umeng.commonsdk.utils.UMUtils.getSystemProperty(d, "");
        h = com.umeng.commonsdk.utils.UMUtils.getSystemProperty(e, "");
        return (!android.text.TextUtils.isEmpty(g) && !f.equals(g)) && (!android.text.TextUtils.isEmpty(h) && !f.equals(h));
    }

    private static int[] b(android.content.Context context) {
        int[] iArr = new int[3];
        try {
            android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (java.lang.Throwable unused) {
        }
        return iArr;
    }

    public org.json.JSONObject a(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        com.umeng.commonsdk.statistics.idtracking.Envelope envelope;
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(a("header"), new org.json.JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (next != null && (next instanceof java.lang.String)) {
                        java.lang.String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            com.umeng.commonsdk.statistics.idtracking.Envelope envelope2 = envelope;
            if (envelope2 != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(envelope2.toBinary().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "h==1.2.0", "", str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return a(110, new org.json.JSONObject());
        }
    }

    public org.json.JSONObject a(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject3;
        java.lang.String str4;
        boolean z;
        java.lang.String str5;
        com.umeng.commonsdk.statistics.idtracking.Envelope envelope;
        org.json.JSONObject optJSONObject;
        if (com.umeng.commonsdk.statistics.common.ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("headerJSONObject size is ");
            sb.append(jSONObject.toString().getBytes().length);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("bodyJSONObject size is ");
            sb2.append(jSONObject2.toString().getBytes().length);
        }
        org.json.JSONObject jSONObject4 = null;
        if (context == null || jSONObject2 == null) {
            return a(110, (org.json.JSONObject) null);
        }
        try {
            if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(com.umeng.analytics.pro.f.n)) {
                str4 = str2;
                z = true;
            } else {
                str4 = str2;
                z = false;
            }
            org.json.JSONObject a2 = a(context, str4, z);
            if (a2 != null && jSONObject != null) {
                a2 = a(a2, jSONObject);
            }
            org.json.JSONObject jSONObject5 = a2;
            if (jSONObject5 != null) {
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (next != null && (next instanceof java.lang.String)) {
                        java.lang.String str6 = next;
                        if (jSONObject2.opt(str6) != null) {
                            try {
                                jSONObject5.put(a(str6), jSONObject2.opt(str6));
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    }
                }
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                str4 = com.umeng.analytics.pro.bo.aN;
            }
            java.lang.String str7 = android.text.TextUtils.isEmpty(str3) ? "1.0.0" : str3;
            if (jSONObject5 != null) {
                java.lang.String str8 = str4 + "==" + str7 + "&=";
                if (android.text.TextUtils.isEmpty(str8)) {
                    return a(101, jSONObject5);
                }
                if (str8.endsWith("&=")) {
                    str8 = str8.substring(0, str8.length() - 2);
                }
                str5 = str8;
            } else {
                str5 = null;
            }
            if (jSONObject5 != null) {
                try {
                    com.umeng.commonsdk.statistics.idtracking.f a3 = com.umeng.commonsdk.statistics.idtracking.f.a(context);
                    if (a3 != null) {
                        a3.b();
                        java.lang.String encodeToString = android.util.Base64.encodeToString(new com.umeng.analytics.pro.cl().a(a3.c()), 0);
                        if (!android.text.TextUtils.isEmpty(encodeToString)) {
                            org.json.JSONObject jSONObject6 = jSONObject5.getJSONObject(a("header"));
                            jSONObject6.put(a(com.umeng.analytics.pro.bo.Y), encodeToString);
                            jSONObject5.put(a("header"), jSONObject6);
                        }
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
            if (jSONObject5 != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject5);
            }
            if (jSONObject5 != null) {
                com.umeng.commonsdk.statistics.idtracking.Envelope a4 = a(context, jSONObject5.toString().getBytes());
                if (a4 == null) {
                    return a(111, jSONObject5);
                }
                envelope = a4;
            } else {
                envelope = null;
            }
            if (envelope != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(envelope.toBinary().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject5);
            }
            int a5 = a(context, envelope, str5, jSONObject5 != null ? jSONObject5.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (a5 != 0) {
                return a(a5, jSONObject5);
            }
            if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("constructHeader size is ");
                sb3.append(jSONObject5.toString().getBytes().length);
            }
            if (!str5.startsWith(com.umeng.analytics.pro.bo.aJ) && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                new com.umeng.commonsdk.stateless.b(context);
                com.umeng.commonsdk.stateless.b.b();
            }
            return jSONObject5;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    jSONObject3 = new org.json.JSONObject();
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
                try {
                    jSONObject3.put("header", jSONObject);
                } catch (org.json.JSONException unused3) {
                } catch (java.lang.Exception e3) {
                    e = e3;
                    jSONObject4 = jSONObject3;
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                    return a(110, jSONObject4);
                }
                jSONObject4 = jSONObject3;
            }
            if (jSONObject4 == null) {
                jSONObject4 = new org.json.JSONObject();
            }
            java.util.Iterator<java.lang.String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                java.lang.String next2 = keys2.next();
                if (next2 != null && (next2 instanceof java.lang.String)) {
                    java.lang.String str9 = next2;
                    if (jSONObject2.opt(str9) != null) {
                        try {
                            jSONObject4.put(str9, jSONObject2.opt(str9));
                        } catch (java.lang.Exception unused4) {
                        }
                    }
                }
            }
            return a(110, jSONObject4);
        }
    }

    public org.json.JSONObject b(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        com.umeng.commonsdk.statistics.idtracking.Envelope envelope;
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(a("header"), new org.json.JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (java.lang.Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (next != null && (next instanceof java.lang.String)) {
                        java.lang.String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            com.umeng.commonsdk.statistics.idtracking.Envelope envelope2 = envelope;
            if (envelope2 != null && com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(envelope2.toBinary().length, com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "z==1.2.0", com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(context), str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return a(110, new org.json.JSONObject());
        }
    }
}
