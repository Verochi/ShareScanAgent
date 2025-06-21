package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class i implements java.lang.Thread.UncaughtExceptionHandler {
    private static volatile com.anythink.core.common.b.i d = null;
    private static final java.lang.String j = "0";
    private static final java.lang.String k = "1";
    private static final int l = 4;
    private java.lang.Thread.UncaughtExceptionHandler b;
    private android.content.Context c;
    private android.content.SharedPreferences e;
    private final java.lang.String f = com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE;
    private final java.lang.String g = "crash_msg";
    private final java.lang.String h = com.anythink.core.common.b.e.c;
    private final java.lang.String i = "crash_sdk_type";
    java.lang.String a = "com.anythink";

    private i(android.content.Context context) {
        this.c = context;
        this.e = context.getSharedPreferences(com.anythink.core.common.b.h.x, 0);
    }

    public static com.anythink.core.common.b.i a(android.content.Context context) {
        if (d == null) {
            synchronized (com.anythink.core.common.b.i.class) {
                if (d == null) {
                    d = new com.anythink.core.common.b.i(context);
                }
            }
        }
        return d;
    }

    private void a(java.lang.Throwable th) {
        try {
            java.lang.String b = b(th);
            if (a(b)) {
                java.lang.String b2 = b(b);
                java.lang.String c = c(b);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE, java.net.URLEncoder.encode(b2));
                jSONObject.put("crash_msg", java.net.URLEncoder.encode(b() + "\n" + b));
                jSONObject.put(com.anythink.core.common.b.e.c, com.anythink.core.common.b.o.a().q());
                jSONObject.put("crash_sdk_type", c);
                android.content.SharedPreferences.Editor edit = this.e.edit();
                edit.putString(java.lang.System.currentTimeMillis() + "_crash", jSONObject.toString());
                edit.commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean a(java.lang.String str) {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(this.c).b(com.anythink.core.common.b.o.a().o());
        if (b != null) {
            if (b.F() == 0) {
                return false;
            }
            java.lang.String H = b.H();
            try {
                if (android.text.TextUtils.isEmpty(H)) {
                    return true;
                }
                org.json.JSONArray jSONArray = new org.json.JSONArray(H);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str.contains(jSONArray.optString(i))) {
                        return true;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        } else if (str.contains(this.a)) {
            return true;
        }
        return false;
    }

    private java.lang.String b() {
        try {
            java.util.Map<java.lang.Thread, java.lang.StackTraceElement[]> allStackTraces = java.lang.Thread.getAllStackTraces();
            java.util.HashMap hashMap = new java.util.HashMap(4);
            java.util.Iterator<java.util.Map.Entry<java.lang.Thread, java.lang.StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                java.lang.Thread key = it.next().getKey();
                if (key.getName().startsWith("anythink")) {
                    java.lang.String str = key.getName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + key.getState();
                    if (hashMap.containsKey(str)) {
                        hashMap.put(str, java.lang.Integer.valueOf(((java.lang.Integer) hashMap.get(str)).intValue() + 1));
                    } else {
                        hashMap.put(str, 1);
                    }
                    i++;
                }
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(hashMap);
                jSONObject.put("anythink_thread_count", i);
                try {
                    android.app.ActivityManager activityManager = (android.app.ActivityManager) this.c.getSystemService("activity");
                    android.os.Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{android.os.Process.myPid()});
                    if (processMemoryInfo.length > 0) {
                        jSONObject.put("app_memory", (processMemoryInfo[0].getTotalPss() / 1024) + "MB");
                    }
                    android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("sys_total_memory", (memoryInfo.totalMem / 1048576) + "MB");
                    jSONObject.put("sys_avail_memory", (memoryInfo.availMem / 1048576) + "MB");
                } catch (java.lang.Throwable unused) {
                }
                return jSONObject.toString();
            } catch (java.lang.Throwable th) {
                return th.getMessage();
            }
        } catch (java.lang.Throwable th2) {
            return th2.getMessage();
        }
    }

    private static java.lang.String b(java.lang.String str) {
        java.lang.String group;
        java.lang.String str2 = "";
        try {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(".*?(Exception|Error|Death)", 2).matcher(str);
            group = matcher.find() ? matcher.group(0) : "";
        } catch (java.lang.Exception unused) {
        }
        try {
            return !android.text.TextUtils.isEmpty(group) ? group.replaceAll("Caused by:", "").replaceAll(" ", "") : group;
        } catch (java.lang.Exception unused2) {
            str2 = group;
            return str2;
        }
    }

    private static java.lang.String b(java.lang.Throwable th) {
        java.io.PrintWriter printWriter;
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = null;
        try {
            for (java.lang.Throwable th2 = new java.lang.Throwable(com.anythink.core.common.o.h.a(), th); th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof java.net.UnknownHostException) {
                    return "";
                }
            }
            java.io.StringWriter stringWriter2 = new java.io.StringWriter();
            try {
                printWriter = new java.io.PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    printWriter.close();
                    stringWriter2.close();
                    java.lang.String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                        stringWriter2.close();
                    } catch (java.lang.Throwable unused) {
                    }
                    return stringWriter3;
                } catch (java.lang.Exception unused2) {
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (java.lang.Throwable unused3) {
                            return "";
                        }
                    }
                    if (printWriter != null) {
                        stringWriter.close();
                    }
                    return "";
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (java.lang.Throwable unused4) {
                            throw th;
                        }
                    }
                    if (printWriter != null) {
                        stringWriter.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused5) {
                printWriter = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                printWriter = null;
            }
        } catch (java.lang.Exception unused6) {
            printWriter = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            printWriter = null;
        }
    }

    private java.lang.String c(java.lang.String str) {
        java.lang.String str2 = this.a;
        if (!android.text.TextUtils.isEmpty(str) && str.contains(str2)) {
            try {
                for (java.lang.String str3 : str.split("Caused by:")) {
                    if (str3.contains(str2)) {
                        java.lang.String[] split = str3.split("\\n");
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].contains(str2) && i <= 4) {
                                return "1";
                            }
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return "0";
    }

    private void c() {
        java.util.Map<java.lang.String, ?> all = this.e.getAll();
        java.util.Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            java.lang.String obj = next != null ? next.toString() : "";
            if (!android.text.TextUtils.isEmpty(obj)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(obj);
                    com.anythink.core.common.n.c.b(jSONObject.optString(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE), jSONObject.optString("crash_msg"), jSONObject.optString(com.anythink.core.common.b.e.c), jSONObject.optString("crash_sdk_type"));
                } catch (java.lang.Exception unused) {
                }
            }
        }
        if (all.size() > 0) {
            this.e.edit().clear().commit();
        }
    }

    public final void a() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(this.c).b(com.anythink.core.common.b.o.a().o());
        if (b == null || b.F() != 0) {
            try {
                java.util.Map<java.lang.String, ?> all = this.e.getAll();
                java.util.Iterator<?> it = all.values().iterator();
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    java.lang.String obj = next != null ? next.toString() : "";
                    if (!android.text.TextUtils.isEmpty(obj)) {
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(obj);
                            com.anythink.core.common.n.c.b(jSONObject.optString(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE), jSONObject.optString("crash_msg"), jSONObject.optString(com.anythink.core.common.b.e.c), jSONObject.optString("crash_sdk_type"));
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                if (all.size() > 0) {
                    this.e.edit().clear().commit();
                }
                if (!(java.lang.Thread.getDefaultUncaughtExceptionHandler() instanceof com.anythink.core.common.b.i)) {
                    this.b = java.lang.Thread.getDefaultUncaughtExceptionHandler();
                }
                java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        try {
            java.lang.String b = b(th);
            if (a(b)) {
                java.lang.String b2 = b(b);
                java.lang.String c = c(b);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE, java.net.URLEncoder.encode(b2));
                jSONObject.put("crash_msg", java.net.URLEncoder.encode(b() + "\n" + b));
                jSONObject.put(com.anythink.core.common.b.e.c, com.anythink.core.common.b.o.a().q());
                jSONObject.put("crash_sdk_type", c);
                android.content.SharedPreferences.Editor edit = this.e.edit();
                edit.putString(java.lang.System.currentTimeMillis() + "_crash", jSONObject.toString());
                edit.commit();
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof com.anythink.core.common.b.i)) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } catch (java.lang.Exception unused2) {
        }
    }
}
