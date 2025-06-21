package com.efs.sdk.launch;

/* loaded from: classes22.dex */
public final class b {
    private static long a;
    private static long b;
    private static long c;
    private static long d;
    private static long e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static long i;
    private static long j;
    private static int k;
    private static java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> l = new java.util.ArrayList();
    private static java.util.Map<java.lang.String, java.lang.Long[]> m = new java.util.HashMap();

    public static void a(android.app.Activity activity, java.lang.String str, boolean z) {
        long currentTimeMillis;
        android.content.Context applicationContext;
        java.lang.String name;
        int i2;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        if (android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.PAGE_ON_CREATE)) {
            if (z) {
                boolean z2 = com.efs.sdk.launch.LaunchManager.isDebug;
                d = java.lang.System.currentTimeMillis();
                return;
            }
            return;
        }
        if (android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.PAGE_ON_RE_START)) {
            if (z && k == 0) {
                boolean z3 = com.efs.sdk.launch.LaunchManager.isDebug;
                e = java.lang.System.currentTimeMillis();
                g = true;
                return;
            }
            return;
        }
        if (android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.PAGE_ON_START)) {
            if (z) {
                boolean z4 = com.efs.sdk.launch.LaunchManager.isDebug;
                k++;
                h = true;
                return;
            }
            return;
        }
        if (!android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.PAGE_ON_RESUME)) {
            if (android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.PAGE_ON_STOP) && z) {
                boolean z5 = com.efs.sdk.launch.LaunchManager.isDebug;
                k--;
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        boolean z6 = com.efs.sdk.launch.LaunchManager.isDebug;
        if (f) {
            f = false;
            long currentTimeMillis2 = java.lang.System.currentTimeMillis();
            long j11 = currentTimeMillis2 - c;
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                "loadTime is ".concat(java.lang.String.valueOf(j11));
            }
            long j12 = currentTimeMillis2 - a;
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                "======>>>>>> coldTime is ".concat(java.lang.String.valueOf(j12));
            }
            int i3 = !com.efs.sdk.launch.c.d(activity.getApplicationContext()) ? 1 : 0;
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                "type is ".concat(java.lang.String.valueOf(i3));
            }
            a(activity.getApplicationContext(), i3, activity.getClass().getName(), j12, a, b, i, c, j, currentTimeMillis2, j11, 0L, 0L, m);
        } else if (k == 1) {
            if (g) {
                g = false;
                j10 = java.lang.System.currentTimeMillis() - e;
                if (com.efs.sdk.launch.LaunchManager.isDebug) {
                    "======>>>>>> hotTime is ".concat(java.lang.String.valueOf(j10));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i2 = 2;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
                currentTimeMillis = 0;
            } else if (h) {
                currentTimeMillis = java.lang.System.currentTimeMillis() - d;
                if (com.efs.sdk.launch.LaunchManager.isDebug) {
                    "======>>>>>> warmTime is ".concat(java.lang.String.valueOf(currentTimeMillis));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i2 = 3;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
                j10 = 0;
            }
            a(applicationContext, i2, name, j2, j3, j4, j5, j6, j7, j8, j9, j10, currentTimeMillis, m);
        }
        h = false;
    }

    private static void a(android.content.Context context, int i2, java.lang.String str, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, java.util.Map<java.lang.String, java.lang.Long[]> map) {
        java.lang.String str2;
        java.lang.String str3;
        int i3;
        java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> list;
        java.lang.StringBuilder sb;
        java.lang.String generateString;
        org.json.JSONArray jSONArray;
        java.lang.Long valueOf;
        if (!com.efs.sdk.launch.LaunchManager.isInit()) {
            if (i2 == 0) {
                boolean z = com.efs.sdk.launch.LaunchManager.isDebug;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("w_type", i2);
                    jSONObject.put("w_url", str);
                    jSONObject.put("l_version", "0.0.7.umeng");
                    jSONObject.put("wl_avgv", j2);
                    jSONObject.put("wd_init", j3);
                    jSONObject.put("wd_inittm", j4);
                    jSONObject.put("wl_init", j5);
                    jSONObject.put("wd_build", j4);
                    jSONObject.put("wd_buildtm", j6);
                    jSONObject.put("wl_build", j7);
                    jSONObject.put("wd_page", j6);
                    jSONObject.put("wd_pagetm", j8);
                    jSONObject.put("wl_page", j9);
                    if (map != null && !map.isEmpty()) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        for (java.util.Map.Entry<java.lang.String, java.lang.Long[]> entry : map.entrySet()) {
                            java.lang.String key = entry.getKey();
                            java.lang.Long[] value = entry.getValue();
                            if (key != null && value != null) {
                                try {
                                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                                    jSONArray2.put(value[0]);
                                    jSONArray2.put(value[1]);
                                    jSONObject2.put(key, jSONArray2);
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                        }
                        jSONObject.put("userExtra", jSONObject2);
                    }
                    com.efs.sdk.launch.c.a(context, jSONObject.toString());
                    if (com.efs.sdk.launch.LaunchManager.isDebug) {
                        new java.lang.StringBuilder("no init, cache first launch, content is ").append(jSONObject.toString());
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                str2 = "wl_page";
                str3 = "wd_pagetm";
                "no init, cache launch, type is ".concat(java.lang.String.valueOf(i2));
            } else {
                str2 = "wl_page";
                str3 = "wd_pagetm";
            }
            com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog(com.efs.sdk.base.Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", java.lang.Integer.valueOf(i2));
            efsJSONLog.put("w_url", str);
            efsJSONLog.put("l_version", "0.0.7.umeng");
            if (i2 == 1) {
                efsJSONLog.put("wl_avgv", java.lang.Long.valueOf(j2));
                efsJSONLog.put("wd_init", java.lang.Long.valueOf(j3));
                efsJSONLog.put("wd_inittm", java.lang.Long.valueOf(j4));
                efsJSONLog.put("wl_init", java.lang.Long.valueOf(j5));
                efsJSONLog.put("wd_build", java.lang.Long.valueOf(j4));
                efsJSONLog.put("wd_buildtm", java.lang.Long.valueOf(j6));
                efsJSONLog.put("wl_build", java.lang.Long.valueOf(j7));
                efsJSONLog.put("wd_page", java.lang.Long.valueOf(j6));
                efsJSONLog.put(str3, java.lang.Long.valueOf(j8));
                efsJSONLog.put(str2, java.lang.Long.valueOf(j9));
                if (map != null && !map.isEmpty()) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    for (java.util.Map.Entry<java.lang.String, java.lang.Long[]> entry2 : map.entrySet()) {
                        java.lang.String key2 = entry2.getKey();
                        java.lang.Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            try {
                                jSONArray = new org.json.JSONArray();
                            } catch (java.lang.Throwable unused2) {
                            }
                            try {
                                jSONArray.put(value2[0]);
                            } catch (java.lang.Throwable unused3) {
                            }
                            try {
                                jSONArray.put(value2[1]);
                                jSONObject3.put(key2, jSONArray);
                            } catch (java.lang.Throwable unused4) {
                            }
                        }
                    }
                    efsJSONLog.put("userExtra", jSONObject3);
                }
            } else if (i2 == 2) {
                efsJSONLog.put("wl_avgv", java.lang.Long.valueOf(j10));
            } else {
                i3 = 3;
                if (i2 == 3) {
                    efsJSONLog.put("wl_avgv", java.lang.Long.valueOf(j11));
                }
                list = l;
                if (list != null || list.size() >= i3) {
                    boolean z2 = com.efs.sdk.launch.LaunchManager.isDebug;
                    return;
                }
                l.add(efsJSONLog);
                if (!com.efs.sdk.launch.LaunchManager.isDebug) {
                    return;
                }
                sb = new java.lang.StringBuilder("cache launch report --->>> ");
                generateString = efsJSONLog.generateString();
            }
            i3 = 3;
            list = l;
            if (list != null) {
            }
            boolean z22 = com.efs.sdk.launch.LaunchManager.isDebug;
            return;
        }
        com.efs.sdk.launch.LaunchConfigManager launchConfigManager = com.efs.sdk.launch.LaunchManager.getLaunchConfigManager();
        if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            boolean z3 = com.efs.sdk.launch.LaunchManager.isDebug;
            return;
        }
        com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog2 = new com.efs.sdk.base.protocol.record.EfsJSONLog(com.efs.sdk.base.Constants.LOG_TYPE_STARTPERF);
        efsJSONLog2.put("w_type", java.lang.Integer.valueOf(i2));
        efsJSONLog2.put("w_url", str);
        efsJSONLog2.put("l_version", "0.0.7.umeng");
        if (i2 == 0 || i2 == 1) {
            efsJSONLog2.put("wl_avgv", java.lang.Long.valueOf(j2));
            efsJSONLog2.put("wd_init", java.lang.Long.valueOf(j3));
            efsJSONLog2.put("wd_inittm", java.lang.Long.valueOf(j4));
            efsJSONLog2.put("wl_init", java.lang.Long.valueOf(j5));
            efsJSONLog2.put("wd_build", java.lang.Long.valueOf(j4));
            efsJSONLog2.put("wd_buildtm", java.lang.Long.valueOf(j6));
            efsJSONLog2.put("wl_build", java.lang.Long.valueOf(j7));
            efsJSONLog2.put("wd_page", java.lang.Long.valueOf(j6));
            efsJSONLog2.put("wd_pagetm", java.lang.Long.valueOf(j8));
            efsJSONLog2.put("wl_page", java.lang.Long.valueOf(j9));
            if (map != null && !map.isEmpty()) {
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                for (java.util.Map.Entry<java.lang.String, java.lang.Long[]> entry3 : map.entrySet()) {
                    java.lang.String key3 = entry3.getKey();
                    java.lang.Long[] value3 = entry3.getValue();
                    if (key3 != null && value3 != null) {
                        try {
                            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                            jSONArray3.put(value3[0]);
                            jSONArray3.put(value3[1]);
                            jSONObject4.put(key3, jSONArray3);
                        } catch (java.lang.Throwable unused5) {
                        }
                    }
                }
                efsJSONLog2.put("userExtra", jSONObject4);
            }
        } else {
            if (i2 == 2) {
                valueOf = java.lang.Long.valueOf(j10);
            } else if (i2 == 3) {
                valueOf = java.lang.Long.valueOf(j11);
            }
            efsJSONLog2.put("wl_avgv", valueOf);
        }
        java.lang.String a2 = com.efs.sdk.launch.c.a(context);
        if (com.efs.sdk.launch.LaunchManager.isDebug) {
            "umid is ".concat(java.lang.String.valueOf(a2));
        }
        if (a2 != null && !android.text.TextUtils.isEmpty(a2)) {
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                new java.lang.StringBuilder("send current launch report --->>> ").append(efsJSONLog2.generateString());
            }
            com.efs.sdk.base.EfsReporter reporter = com.efs.sdk.launch.LaunchManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog2);
                return;
            }
            return;
        }
        java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> list2 = l;
        if (list2 == null || list2.size() >= 3) {
            boolean z4 = com.efs.sdk.launch.LaunchManager.isDebug;
            return;
        }
        l.add(efsJSONLog2);
        if (!com.efs.sdk.launch.LaunchManager.isDebug) {
            return;
        }
        sb = new java.lang.StringBuilder("cache launch report --->>> ");
        generateString = efsJSONLog2.generateString();
        sb.append(generateString);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        boolean z = com.efs.sdk.launch.LaunchManager.isDebug;
        if (str == null || android.text.TextUtils.isEmpty(str)) {
            str = com.efs.sdk.launch.c.a(context);
        }
        if (str == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put(com.umeng.umcrash.UMCrash.KEY_HEADER_UMID, str);
        if (com.efs.sdk.launch.LaunchManager.getReporter() != null) {
            com.efs.sdk.launch.LaunchManager.getReporter().addPublicParams(hashMap);
        }
        java.lang.String b2 = com.efs.sdk.launch.c.b(context);
        if (b2 != null && !android.text.TextUtils.isEmpty(b2)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(b2);
                jSONObject.put(com.umeng.umcrash.UMCrash.KEY_HEADER_UMID, str);
                if (a(jSONObject)) {
                    com.efs.sdk.launch.c.c(context);
                }
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
        java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> list = l;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog : l) {
            if (efsJSONLog != null) {
                if (com.efs.sdk.launch.LaunchManager.isDebug) {
                    new java.lang.StringBuilder("send cache launch report --->>> ").append(efsJSONLog.generateString());
                }
                com.efs.sdk.base.EfsReporter reporter = com.efs.sdk.launch.LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
        l.clear();
        l = null;
    }

    public static void a(java.lang.String str, long j2) {
        java.util.Map<java.lang.String, java.lang.Long[]> map = m;
        if (map == null || map.containsKey(str) || m.size() >= 10) {
            boolean z = com.efs.sdk.launch.LaunchManager.isDebug;
            return;
        }
        java.lang.Long[] lArr = new java.lang.Long[2];
        lArr[0] = java.lang.Long.valueOf(j2);
        m.put(str, lArr);
    }

    public static void a(java.lang.String str, boolean z) {
        if (android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (!android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (!android.text.TextUtils.equals(str, com.efs.sdk.launch.LaunchManager.APP_ON_CREATE) || z) {
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            c = currentTimeMillis;
            j = currentTimeMillis - b;
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                new java.lang.StringBuilder("buildTime is ").append(j);
                return;
            }
            return;
        }
        if (z) {
            a = java.lang.System.currentTimeMillis();
            f = true;
            return;
        }
        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
        b = currentTimeMillis2;
        i = currentTimeMillis2 - a;
        if (com.efs.sdk.launch.LaunchManager.isDebug) {
            new java.lang.StringBuilder("initTime is ").append(i);
        }
    }

    private static boolean a(org.json.JSONObject jSONObject) {
        try {
            com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog(com.efs.sdk.base.Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (com.efs.sdk.launch.LaunchManager.isDebug) {
                new java.lang.StringBuilder("send cache cold launch report --->>> ").append(efsJSONLog.generateString());
            }
            com.efs.sdk.base.EfsReporter reporter = com.efs.sdk.launch.LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(java.lang.String str, long j2) {
        java.util.Map<java.lang.String, java.lang.Long[]> map = m;
        if (map == null || !map.containsKey(str)) {
            boolean z = com.efs.sdk.launch.LaunchManager.isDebug;
            return;
        }
        java.lang.Long[] lArr = m.get(str);
        lArr[1] = java.lang.Long.valueOf(j2);
        m.put(str, lArr);
    }
}
