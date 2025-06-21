package com.umeng.umzid;

/* loaded from: classes19.dex */
public class ZIDManager {
    public static com.umeng.umzid.ZIDManager d;
    public boolean a = false;
    public boolean b = false;
    public boolean c;

    public class a implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context a;
        public final /* synthetic */ com.umeng.umzid.IZIDCompletionCallback b;

        public a(android.content.Context context, com.umeng.umzid.IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String a = com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager.this, this.a);
            if (android.text.TextUtils.isEmpty(a)) {
                com.umeng.umzid.IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(com.anythink.core.api.ErrorCode.serverError, "获取zid失败");
                    return;
                }
                return;
            }
            com.umeng.umzid.IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a);
            }
        }
    }

    public class b implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context a;

        public b(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.umeng.umzid.ZIDManager.this.b(this.a);
        }
    }

    public class c implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context a;

        public c(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager.this, this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager zIDManager, android.content.Context context) {
        java.lang.Throwable th;
        org.json.JSONObject jSONObject;
        java.lang.String b2;
        java.lang.String a2;
        java.lang.String str = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                java.lang.String id = com.umeng.umzid.Spy.getID();
                jSONObject2.put(com.umeng.analytics.pro.bo.aJ, id);
                java.lang.String e = com.umeng.umzid.d.e(context);
                jSONObject2.put(com.umeng.analytics.pro.bo.A, e);
                java.lang.String f = com.umeng.umzid.d.f(context);
                jSONObject2.put("o", f);
                try {
                    jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("vpn_pxy", com.umeng.umzid.d.i(context));
                        jSONObject.put("wifi_pxy", com.umeng.umzid.d.j(context));
                        jSONObject.put("double", com.umeng.umzid.d.g(context));
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (jSONObject != null) {
                        }
                        zIDManager.a(context, jSONObject2);
                        b2 = com.umeng.umzid.d.b(context);
                        if (b2.length() <= 0) {
                        }
                        a2 = com.umeng.umzid.a.a(b2 + "/anti/postZdata", jSONObject2.toString());
                        if (!android.text.TextUtils.isEmpty(a2)) {
                        }
                        zIDManager.a(context);
                        return str;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                zIDManager.a(context, jSONObject2);
                b2 = com.umeng.umzid.d.b(context);
                if (b2.length() <= 0) {
                    b2 = "https://utoken.umeng.com";
                }
                a2 = com.umeng.umzid.a.a(b2 + "/anti/postZdata", jSONObject2.toString());
                if (!android.text.TextUtils.isEmpty(a2)) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject(a2);
                    if (java.lang.Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.d.f(context, id);
                        com.umeng.umzid.d.a(context, e);
                        com.umeng.umzid.d.b(context, f);
                        str = jSONObject3.optString("aaid");
                        if (!android.text.TextUtils.isEmpty(str)) {
                            com.umeng.umzid.d.e(context, str);
                        }
                        java.lang.String optString = jSONObject3.optString("uabc");
                        if (!android.text.TextUtils.isEmpty(optString)) {
                            com.umeng.umzid.d.d(context, optString);
                        }
                        java.lang.String optString2 = jSONObject3.optString("resetToken");
                        if (!android.text.TextUtils.isEmpty(optString2)) {
                            com.umeng.umzid.d.c(context, optString2);
                        }
                    }
                }
                zIDManager.a(context);
            } finally {
                try {
                } finally {
                }
            }
        }
        return str;
    }

    public static void configureDomain(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        java.lang.String b2 = com.umeng.umzid.d.b(str);
        if (context == null || b2 == null || android.text.TextUtils.isEmpty(b2) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", b2).commit();
    }

    public static synchronized com.umeng.umzid.ZIDManager getInstance() {
        com.umeng.umzid.ZIDManager zIDManager;
        synchronized (com.umeng.umzid.ZIDManager.class) {
            if (d == null) {
                d = new com.umeng.umzid.ZIDManager();
            }
            zIDManager = d;
        }
        return zIDManager;
    }

    public static java.lang.String getSDKVersion() {
        return "1.8.3";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:0|1|(5:88|89|(2:96|97)|91|(37:93|4|5|6|7|8|(2:10|(30:14|15|16|17|18|19|(3:69|70|(5:72|73|(2:76|74)|77|78))|21|(1:23)(1:68)|24|(1:26)(1:67)|27|28|29|30|31|32|33|34|35|36|(1:40)|41|42|43|44|45|(2:47|(2:51|52))|54|55))|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(2:38|40)|41|42|43|44|45|(0)|54|55))|3|4|5|6|7|8|(0)|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(0)|41|42|43|44|45|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0164, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0165, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014c, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0131, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e5, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0072 A[Catch: all -> 0x0086, TryCatch #6 {all -> 0x0086, blocks: (B:6:0x0064, B:8:0x0068, B:10:0x0072, B:12:0x007f, B:14:0x0083), top: B:5:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018f A[Catch: all -> 0x01a3, TryCatch #3 {all -> 0x01a3, blocks: (B:43:0x0181, B:45:0x0185, B:47:0x018f, B:49:0x019c, B:51:0x01a0), top: B:42:0x0181 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final org.json.JSONObject a(android.content.Context context, org.json.JSONObject jSONObject) {
        java.util.Locale locale;
        int rawOffset;
        java.lang.Object obj;
        java.lang.String str;
        java.lang.reflect.Method declaredMethod;
        android.content.SharedPreferences a2;
        java.lang.reflect.Method declaredMethod2;
        java.lang.Object obj2 = "";
        jSONObject.putOpt("z_v", com.umeng.umzid.Spy.getVersion());
        jSONObject.putOpt("a_id", com.umeng.umzid.d.a(context));
        jSONObject.putOpt("os_v", android.os.Build.VERSION.RELEASE);
        java.lang.Object obj3 = null;
        if (context != null) {
            try {
                android.content.res.Configuration configuration = new android.content.res.Configuration();
                configuration.setToDefaults();
                android.provider.Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (java.lang.Throwable unused) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = java.util.Locale.getDefault();
                } catch (java.lang.Throwable unused2) {
                }
            }
            java.util.Calendar calendar = java.util.Calendar.getInstance(locale);
            if (calendar != null) {
                rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                jSONObject.putOpt(com.anythink.expressad.foundation.g.a.V, java.lang.Integer.valueOf(rawOffset));
                jSONObject.putOpt(com.anythink.expressad.d.a.b.dH, android.os.Build.MODEL);
                java.lang.String str2 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
                declaredMethod2 = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getImeiNew", android.content.Context.class);
                if (declaredMethod2 != null) {
                    declaredMethod2.setAccessible(true);
                    java.lang.Object invoke = declaredMethod2.invoke(com.umeng.commonsdk.statistics.common.DeviceConfig.class, context);
                    if (invoke != null && (invoke instanceof java.lang.String)) {
                        obj = (java.lang.String) invoke;
                        jSONObject.putOpt(com.getui.gtc.extension.distribution.gbd.f.b.o, obj);
                        java.lang.reflect.Method declaredMethod3 = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
                        declaredMethod3.setAccessible(true);
                        str = declaredMethod3.invoke(null, "net.hostname").toString();
                        if (str != null) {
                            try {
                                if (!str.equalsIgnoreCase("")) {
                                    try {
                                        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                                        messageDigest.update(str.getBytes());
                                        byte[] digest = messageDigest.digest();
                                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                                        for (byte b2 : digest) {
                                            stringBuffer.append(java.lang.Integer.toHexString(b2 & 255));
                                        }
                                        str = stringBuffer.toString();
                                    } catch (java.lang.Throwable unused3) {
                                        str = "";
                                    }
                                }
                            } catch (java.lang.Exception unused4) {
                            }
                        }
                        jSONObject.putOpt("hn", str);
                        jSONObject.putOpt("s_v", "1.8.3");
                        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
                        jSONObject.putOpt("s_t", "Android");
                        android.content.SharedPreferences a3 = com.umeng.umzid.a.a(context);
                        jSONObject.putOpt("uid", a3 != null ? a3.getString("uuid", "") : "");
                        jSONObject.putOpt("s_id", "umeng");
                        java.lang.Object obj4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        jSONObject.putOpt("a_v", obj4);
                        java.lang.Object obj5 = java.lang.String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
                        jSONObject.putOpt("a_n", obj5);
                        java.lang.Object obj6 = context.getResources().getConfiguration().locale.getCountry();
                        jSONObject.putOpt("c", obj6);
                        if (context != null && (a2 = com.umeng.umzid.a.a(context)) != null) {
                            obj3 = a2.getString("appkey", null);
                        }
                        jSONObject.putOpt("ak", obj3);
                        java.lang.String str3 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
                        declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getIdfa", android.content.Context.class);
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            java.lang.Object invoke2 = declaredMethod.invoke(com.umeng.commonsdk.statistics.common.DeviceConfig.class, context);
                            if (invoke2 != null && (invoke2 instanceof java.lang.String)) {
                                obj2 = (java.lang.String) invoke2;
                            }
                        }
                        jSONObject.putOpt("gd", obj2);
                        return jSONObject;
                    }
                }
                obj = "";
                jSONObject.putOpt(com.getui.gtc.extension.distribution.gbd.f.b.o, obj);
                java.lang.reflect.Method declaredMethod32 = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
                declaredMethod32.setAccessible(true);
                str = declaredMethod32.invoke(null, "net.hostname").toString();
                if (str != null) {
                }
                jSONObject.putOpt("hn", str);
                jSONObject.putOpt("s_v", "1.8.3");
                jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
                jSONObject.putOpt("s_t", "Android");
                android.content.SharedPreferences a32 = com.umeng.umzid.a.a(context);
                jSONObject.putOpt("uid", a32 != null ? a32.getString("uuid", "") : "");
                jSONObject.putOpt("s_id", "umeng");
                java.lang.Object obj42 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                jSONObject.putOpt("a_v", obj42);
                java.lang.Object obj52 = java.lang.String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
                jSONObject.putOpt("a_n", obj52);
                java.lang.Object obj62 = context.getResources().getConfiguration().locale.getCountry();
                jSONObject.putOpt("c", obj62);
                if (context != null) {
                    obj3 = a2.getString("appkey", null);
                }
                jSONObject.putOpt("ak", obj3);
                java.lang.String str32 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
                declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getIdfa", android.content.Context.class);
                if (declaredMethod != null) {
                }
                jSONObject.putOpt("gd", obj2);
                return jSONObject;
            }
        }
        rawOffset = 8;
        jSONObject.putOpt(com.anythink.expressad.foundation.g.a.V, java.lang.Integer.valueOf(rawOffset));
        jSONObject.putOpt(com.anythink.expressad.d.a.b.dH, android.os.Build.MODEL);
        java.lang.String str22 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
        declaredMethod2 = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getImeiNew", android.content.Context.class);
        if (declaredMethod2 != null) {
        }
        obj = "";
        jSONObject.putOpt(com.getui.gtc.extension.distribution.gbd.f.b.o, obj);
        java.lang.reflect.Method declaredMethod322 = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
        declaredMethod322.setAccessible(true);
        str = declaredMethod322.invoke(null, "net.hostname").toString();
        if (str != null) {
        }
        jSONObject.putOpt("hn", str);
        jSONObject.putOpt("s_v", "1.8.3");
        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
        jSONObject.putOpt("s_t", "Android");
        android.content.SharedPreferences a322 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt("uid", a322 != null ? a322.getString("uuid", "") : "");
        jSONObject.putOpt("s_id", "umeng");
        java.lang.Object obj422 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        jSONObject.putOpt("a_v", obj422);
        java.lang.Object obj522 = java.lang.String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        jSONObject.putOpt("a_n", obj522);
        java.lang.Object obj622 = context.getResources().getConfiguration().locale.getCountry();
        jSONObject.putOpt("c", obj622);
        if (context != null) {
        }
        jSONObject.putOpt("ak", obj3);
        java.lang.String str322 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
        declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getIdfa", android.content.Context.class);
        if (declaredMethod != null) {
        }
        jSONObject.putOpt("gd", obj2);
        return jSONObject;
    }

    public final void a(android.content.Context context) {
        java.lang.Object invoke;
        java.lang.reflect.Method declaredMethod;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.uyumao.sdk.UYMManager");
            java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(cls, new java.lang.Object[0])) == null || (declaredMethod = cls.getDeclaredMethod("init", android.content.Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, context);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:14|(3:80|81|(27:83|17|(1:79)(2:21|(1:23))|24|(1:78)(2:28|(1:30))|31|32|(1:36)|37|(1:39)|40|41|42|43|44|45|46|47|48|(1:50)|51|(1:53)|54|(2:56|(6:58|(1:60)|61|(1:63)|64|(1:66)))|67|68|69))|16|17|(1:19)|79|24|(1:26)|78|31|32|(2:34|36)|37|(0)|40|41|42|43|44|45|46|47|48|(0)|51|(0)|54|(0)|67|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ef, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f4, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f1, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r11 = r6;
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String b(android.content.Context context) {
        boolean z;
        java.lang.String str;
        java.lang.String str2;
        android.content.SharedPreferences a2;
        java.lang.Object string;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject;
        java.lang.String b2;
        java.lang.String a3;
        android.content.SharedPreferences a4;
        android.content.SharedPreferences a5;
        android.content.SharedPreferences a6;
        try {
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (new org.json.JSONObject(com.umeng.umzid.d.c(context)).optLong("ets") > java.lang.System.currentTimeMillis()) {
            z = false;
            str = null;
            if (z || this.b) {
                return null;
            }
            this.b = true;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            str2 = "";
            if (context != null) {
                try {
                    a2 = com.umeng.umzid.a.a(context);
                } catch (java.lang.Throwable unused) {
                }
                if (a2 != null) {
                    string = a2.getString("zdata", null);
                    java.lang.String id = com.umeng.umzid.Spy.getID();
                    jSONObject2.put(com.umeng.analytics.pro.bo.aJ, id);
                    jSONObject2.put("o_z", string);
                    if (context != null || (a6 = com.umeng.umzid.a.a(context)) == null) {
                        str3 = "";
                    } else {
                        str3 = a6.getString("oaid", "");
                        if (com.umeng.umzid.d.c(str3)) {
                            str3 = com.umeng.umzid.d.a(str3);
                        }
                    }
                    java.lang.String f = com.umeng.umzid.d.f(context);
                    jSONObject2.put("o_o", str3);
                    jSONObject2.put("o", f);
                    if (context != null || (a5 = com.umeng.umzid.a.a(context)) == null) {
                        str4 = "";
                    } else {
                        str4 = a5.getString("mac", "");
                        if (com.umeng.umzid.d.c(str4)) {
                            str4 = com.umeng.umzid.d.a(str4);
                        }
                    }
                    java.lang.String e2 = com.umeng.umzid.d.e(context);
                    jSONObject2.put(com.umeng.analytics.pro.bo.A, e2);
                    jSONObject2.put("o_mc", str4);
                    a(context, jSONObject2);
                    jSONObject2.put("aaid", com.umeng.umzid.d.d(context));
                    jSONObject2.put("uabc", com.umeng.umzid.d.c(context));
                    if (context != null && (a4 = com.umeng.umzid.a.a(context)) != null) {
                        str2 = a4.getString("resetToken", "");
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        jSONObject2.put("rt", str2);
                    }
                    jSONObject = new org.json.JSONObject();
                    jSONObject.put("vpn_pxy", com.umeng.umzid.d.i(context));
                    jSONObject.put("wifi_pxy", com.umeng.umzid.d.j(context));
                    jSONObject.put("double", com.umeng.umzid.d.g(context));
                    if (jSONObject != null) {
                        jSONObject2.put("anti", jSONObject);
                    }
                    b2 = com.umeng.umzid.d.b(context);
                    if (b2.length() <= 0) {
                        b2 = "https://utoken.umeng.com";
                    }
                    a3 = com.umeng.umzid.a.a(b2 + "/anti/updateZdata", jSONObject2.toString());
                    if (!android.text.TextUtils.isEmpty(a3)) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject(a3);
                        if (java.lang.Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                            com.umeng.umzid.d.f(context, id);
                            com.umeng.umzid.d.a(context, e2);
                            com.umeng.umzid.d.b(context, f);
                            str = jSONObject3.optString("aaid");
                            if (!android.text.TextUtils.isEmpty(str)) {
                                com.umeng.umzid.d.e(context, str);
                            }
                            java.lang.String optString = jSONObject3.optString("uabc");
                            if (!android.text.TextUtils.isEmpty(optString)) {
                                com.umeng.umzid.d.d(context, optString);
                            }
                            java.lang.String optString2 = jSONObject3.optString("resetToken");
                            if (!android.text.TextUtils.isEmpty(optString2)) {
                                com.umeng.umzid.d.c(context, optString2);
                            }
                        }
                    }
                    a(context);
                    this.b = false;
                    return str;
                }
            }
            string = "";
            java.lang.String id2 = com.umeng.umzid.Spy.getID();
            jSONObject2.put(com.umeng.analytics.pro.bo.aJ, id2);
            jSONObject2.put("o_z", string);
            if (context != null) {
            }
            str3 = "";
            java.lang.String f2 = com.umeng.umzid.d.f(context);
            jSONObject2.put("o_o", str3);
            jSONObject2.put("o", f2);
            if (context != null) {
            }
            str4 = "";
            java.lang.String e22 = com.umeng.umzid.d.e(context);
            jSONObject2.put(com.umeng.analytics.pro.bo.A, e22);
            jSONObject2.put("o_mc", str4);
            a(context, jSONObject2);
            jSONObject2.put("aaid", com.umeng.umzid.d.d(context));
            jSONObject2.put("uabc", com.umeng.umzid.d.c(context));
            if (context != null) {
                str2 = a4.getString("resetToken", "");
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
            }
            jSONObject = new org.json.JSONObject();
            jSONObject.put("vpn_pxy", com.umeng.umzid.d.i(context));
            jSONObject.put("wifi_pxy", com.umeng.umzid.d.j(context));
            jSONObject.put("double", com.umeng.umzid.d.g(context));
            if (jSONObject != null) {
            }
            b2 = com.umeng.umzid.d.b(context);
            if (b2.length() <= 0) {
            }
            a3 = com.umeng.umzid.a.a(b2 + "/anti/updateZdata", jSONObject2.toString());
            if (!android.text.TextUtils.isEmpty(a3)) {
            }
            a(context);
            this.b = false;
            return str;
        }
        z = true;
        str = null;
        if (z) {
            return null;
        }
        this.b = true;
        org.json.JSONObject jSONObject22 = new org.json.JSONObject();
        str2 = "";
        if (context != null) {
        }
        string = "";
        java.lang.String id22 = com.umeng.umzid.Spy.getID();
        jSONObject22.put(com.umeng.analytics.pro.bo.aJ, id22);
        jSONObject22.put("o_z", string);
        if (context != null) {
        }
        str3 = "";
        java.lang.String f22 = com.umeng.umzid.d.f(context);
        jSONObject22.put("o_o", str3);
        jSONObject22.put("o", f22);
        if (context != null) {
        }
        str4 = "";
        java.lang.String e222 = com.umeng.umzid.d.e(context);
        jSONObject22.put(com.umeng.analytics.pro.bo.A, e222);
        jSONObject22.put("o_mc", str4);
        a(context, jSONObject22);
        jSONObject22.put("aaid", com.umeng.umzid.d.d(context));
        jSONObject22.put("uabc", com.umeng.umzid.d.c(context));
        if (context != null) {
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
        }
        jSONObject = new org.json.JSONObject();
        jSONObject.put("vpn_pxy", com.umeng.umzid.d.i(context));
        jSONObject.put("wifi_pxy", com.umeng.umzid.d.j(context));
        jSONObject.put("double", com.umeng.umzid.d.g(context));
        if (jSONObject != null) {
        }
        b2 = com.umeng.umzid.d.b(context);
        if (b2.length() <= 0) {
        }
        a3 = com.umeng.umzid.a.a(b2 + "/anti/updateZdata", jSONObject22.toString());
        if (!android.text.TextUtils.isEmpty(a3)) {
        }
        a(context);
        this.b = false;
        return str;
    }

    public synchronized java.lang.String getZID(android.content.Context context) {
        if (context == null) {
            return "";
        }
        android.content.Context applicationContext = context.getApplicationContext();
        java.lang.String d2 = com.umeng.umzid.d.d(applicationContext);
        if (!android.text.TextUtils.isEmpty(d2)) {
            return d2;
        }
        com.umeng.umzid.c.a(new com.umeng.umzid.ZIDManager.c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0077 A[Catch: all -> 0x00a6, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(android.content.Context context, java.lang.String str, com.umeng.umzid.IZIDCompletionCallback iZIDCompletionCallback) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences a3;
        android.content.SharedPreferences.Editor edit;
        boolean h = com.umeng.umzid.d.h(context);
        this.c = h;
        if (h) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(com.anythink.core.api.ErrorCode.networkError, "传入参数Context为null");
                }
                return;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !android.text.TextUtils.isEmpty(str) && (a3 = com.umeng.umzid.a.a(applicationContext)) != null && (edit = a3.edit()) != null) {
                edit.putString("appkey", str).commit();
            }
            java.lang.String d2 = com.umeng.umzid.d.d(applicationContext);
            if (d2 != null && !android.text.TextUtils.isEmpty(d2)) {
                com.umeng.umzid.c.a(new com.umeng.umzid.ZIDManager.b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(d2);
                }
                a2 = com.umeng.umzid.a.a(context);
                if (android.text.TextUtils.isEmpty(a2 != null ? a2.getString("uuid", "") : "")) {
                    java.lang.String str2 = "";
                    android.content.SharedPreferences a4 = com.umeng.umzid.a.a(context);
                    try {
                        str2 = java.util.UUID.randomUUID().toString();
                    } catch (java.lang.Throwable unused) {
                    }
                    if (a4 != null) {
                        a4.edit().putString("uuid", str2).commit();
                    }
                }
            }
            com.umeng.umzid.c.a(new com.umeng.umzid.ZIDManager.a(applicationContext, iZIDCompletionCallback));
            a2 = com.umeng.umzid.a.a(context);
            if (android.text.TextUtils.isEmpty(a2 != null ? a2.getString("uuid", "") : "")) {
            }
        }
    }
}
