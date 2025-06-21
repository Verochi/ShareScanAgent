package com.umeng.commonsdk.internal;

/* loaded from: classes19.dex */
public class d {
    public static org.json.JSONObject a() {
        java.lang.String str;
        int i;
        java.lang.String str2;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("a_pr", android.os.Build.PRODUCT);
            jSONObject.put("a_bl", android.os.Build.BOOTLOADER);
            jSONObject.put("a_rv", android.os.Build.getRadioVersion());
            jSONObject.put("a_fp", android.os.Build.FINGERPRINT);
            jSONObject.put("a_hw", android.os.Build.HARDWARE);
            jSONObject.put("a_host", android.os.Build.HOST);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                java.lang.String[] strArr = android.os.Build.SUPPORTED_32_BIT_ABIS;
                if (i3 >= strArr.length) {
                    break;
                }
                jSONArray.put(strArr[i3]);
                i3++;
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("a_s32", jSONArray);
            }
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            int i4 = 0;
            while (true) {
                java.lang.String[] strArr2 = android.os.Build.SUPPORTED_64_BIT_ABIS;
                if (i4 >= strArr2.length) {
                    break;
                }
                jSONArray2.put(strArr2[i4]);
                i4++;
            }
            if (jSONArray2.length() > 0) {
                jSONObject.put("a_s64", jSONArray2);
            }
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            while (true) {
                java.lang.String[] strArr3 = android.os.Build.SUPPORTED_ABIS;
                if (i2 >= strArr3.length) {
                    break;
                }
                jSONArray3.put(strArr3[i2]);
                i2++;
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put("a_sa", jSONArray3);
            }
            jSONObject.put("a_ta", android.os.Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", android.os.Build.USER);
            jSONObject.put("a_cpu1", android.os.Build.CPU_ABI);
            jSONObject.put("a_cpu2", android.os.Build.CPU_ABI2);
            jSONObject.put("a_ra", android.os.Build.RADIO);
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                str = android.os.Build.VERSION.BASE_OS;
                jSONObject.put("a_bos", str);
                i = android.os.Build.VERSION.PREVIEW_SDK_INT;
                jSONObject.put("a_pre", i);
                str2 = android.os.Build.VERSION.SECURITY_PATCH;
                jSONObject.put("a_sp", str2);
            }
            jSONObject.put("a_cn", android.os.Build.VERSION.CODENAME);
            jSONObject.put("a_intl", android.os.Build.VERSION.INCREMENTAL);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public static void a(android.content.Context context) {
        try {
            com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent send envelope");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.umeng.analytics.pro.bo.aT, com.umeng.commonsdk.internal.a.e);
            org.json.JSONObject buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), com.umeng.commonsdk.statistics.UMServerURL.PATH_ANALYTICS, "i", com.umeng.commonsdk.internal.a.e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
        }
    }

    private static void a(android.content.Context context, org.json.JSONObject jSONObject) {
        android.content.pm.PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, com.huawei.hms.push.constant.RemoteMessageConst.TO, packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(org.json.JSONObject jSONObject, java.lang.String str, boolean z) {
        if (jSONObject == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private static org.json.JSONObject b() {
        try {
            com.umeng.commonsdk.internal.utils.d.a a = com.umeng.commonsdk.internal.utils.d.a();
            if (a == null) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("pro", a.a);
                jSONObject.put("pla", a.b);
                jSONObject.put("cpus", a.c);
                jSONObject.put("fea", a.d);
                jSONObject.put(com.umeng.analytics.pro.ay.c, a.e);
                jSONObject.put("arc", a.f);
                jSONObject.put("var", a.g);
                jSONObject.put("par", a.h);
                jSONObject.put("rev", a.i);
                jSONObject.put("har", a.j);
                jSONObject.put("rev", a.k);
                jSONObject.put("ser", a.l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", java.lang.System.currentTimeMillis());
            } catch (java.lang.Exception unused) {
            }
            return jSONObject;
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    public static void b(android.content.Context context) {
        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            i(context);
        }
    }

    private static void b(android.content.Context context, org.json.JSONObject jSONObject) {
        if (context != null) {
            java.lang.String a = com.umeng.commonsdk.internal.utils.k.a(context);
            if (android.text.TextUtils.isEmpty(a)) {
                return;
            }
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(a);
                if (jSONObject == null) {
                    jSONObject = new org.json.JSONObject();
                }
                if (jSONObject2.has(com.umeng.commonsdk.internal.utils.k.d)) {
                    jSONObject.put(com.umeng.commonsdk.internal.utils.k.d, jSONObject2.opt(com.umeng.commonsdk.internal.utils.k.d));
                }
                if (jSONObject2.has(com.umeng.commonsdk.internal.utils.k.c)) {
                    jSONObject.put(com.umeng.commonsdk.internal.utils.k.c, jSONObject2.opt(com.umeng.commonsdk.internal.utils.k.c));
                }
                if (jSONObject2.has(com.umeng.commonsdk.internal.utils.k.b)) {
                    jSONObject.put(com.umeng.commonsdk.internal.utils.k.b, jSONObject2.opt(com.umeng.commonsdk.internal.utils.k.b));
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void c(android.content.Context context) {
        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !com.umeng.commonsdk.framework.UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        i(context);
    }

    public static org.json.JSONObject d(android.content.Context context) {
        org.json.JSONObject b;
        org.json.JSONArray g;
        org.json.JSONObject a;
        org.json.JSONArray k;
        org.json.JSONArray j;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            try {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.L) && (j = j(applicationContext)) != null && j.length() > 0) {
                    jSONObject2.put("rs", j);
                }
            } catch (java.lang.Exception e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e);
            }
            try {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (k = k(applicationContext)) != null && k.length() > 0) {
                    jSONObject2.put("by", k);
                }
            } catch (java.lang.Exception e2) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (java.lang.Exception e3) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (java.lang.Exception e4) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && (a = a()) != null && a.length() > 0) {
                    jSONObject2.put("build", a);
                }
            } catch (java.lang.Exception e5) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                org.json.JSONObject e6 = e(applicationContext);
                if (e6 != null && e6.length() > 0) {
                    jSONObject2.put("scr", e6);
                }
            } catch (java.lang.Exception e7) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                org.json.JSONObject f = f(applicationContext);
                if (f != null && f.length() > 0) {
                    jSONObject2.put("sinfo", f);
                }
            } catch (java.lang.Exception e8) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.ai) && (g = g(applicationContext)) != null && g.length() > 0) {
                    jSONObject2.put("appls", g);
                }
            } catch (java.lang.Exception e9) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                org.json.JSONObject h = h(applicationContext);
                if (h != null && h.length() > 0) {
                    jSONObject2.put("mem", h);
                }
            } catch (java.lang.Exception e10) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.as) && (b = b()) != null && b.length() > 0) {
                    jSONObject2.put("cpu", b);
                }
            } catch (java.lang.Exception unused) {
            }
            try {
                jSONObject.put(com.umeng.analytics.pro.bo.aA, jSONObject2);
            } catch (org.json.JSONException e11) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e11);
            }
        }
        return jSONObject;
    }

    public static org.json.JSONObject e(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (java.lang.Exception e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    public static org.json.JSONObject f(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            java.lang.String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", com.umeng.commonsdk.statistics.common.DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", com.umeng.commonsdk.statistics.common.DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                java.lang.String simICCID = com.umeng.commonsdk.statistics.common.DeviceConfig.getSimICCID(applicationContext);
                if (!android.text.TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (java.lang.Exception unused) {
                    }
                }
                java.lang.String secondSimIMEi = com.umeng.commonsdk.statistics.common.DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!android.text.TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (java.lang.Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", java.lang.System.currentTimeMillis());
            } catch (java.lang.Exception e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e);
            }
        }
        return jSONObject;
    }

    public static org.json.JSONArray g(android.content.Context context) {
        android.content.Context applicationContext;
        java.util.List<com.umeng.commonsdk.internal.utils.a.C0520a> f;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (context != null && (f = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null && !f.isEmpty()) {
            for (com.umeng.commonsdk.internal.utils.a.C0520a c0520a : f) {
                if (c0520a != null) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("a_pn", c0520a.a);
                        jSONObject.put("a_la", c0520a.b);
                        jSONObject.put("ts", java.lang.System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (java.lang.Exception e) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static org.json.JSONObject h(android.content.Context context) {
        android.content.Context applicationContext;
        android.app.ActivityManager.MemoryInfo g;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (context != null && (g = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null) {
            try {
                jSONObject.put("t", g.totalMem);
                jSONObject.put("f", g.availMem);
                jSONObject.put("ts", java.lang.System.currentTimeMillis());
            } catch (java.lang.Exception e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, e);
            }
        }
        return jSONObject;
    }

    private static void i(android.content.Context context) {
        try {
            if (com.umeng.commonsdk.framework.UMEnvelopeBuild.isReadyBuild(context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 32769, com.umeng.commonsdk.internal.b.a(context).a(), null, 5000L);
            }
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.v, com.umeng.commonsdk.internal.b.a(context).a(), null, 5000L);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    private static org.json.JSONArray j(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningServiceInfo> runningServices;
        org.json.JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i = 0; i < runningServices.size(); i++) {
                if (runningServices.get(i) != null && runningServices.get(i).service != null && runningServices.get(i).service.getClassName() != null && runningServices.get(i).service.getPackageName() != null) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new org.json.JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (org.json.JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("ts", java.lang.System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (org.json.JSONException unused2) {
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (org.json.JSONException unused3) {
            }
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (java.lang.Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static org.json.JSONArray k(android.content.Context context) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.lang.String a = com.umeng.commonsdk.internal.utils.j.a(context);
        if (!android.text.TextUtils.isEmpty(a)) {
            try {
                jSONArray.put(new org.json.JSONObject(a));
            } catch (java.lang.Exception unused) {
            }
        }
        return jSONArray;
    }
}
