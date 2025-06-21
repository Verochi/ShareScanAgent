package com.sijla.h;

@android.annotation.SuppressLint({"SimpleDateFormat", "DefaultLocale"})
/* loaded from: classes19.dex */
public final class c {
    private static java.lang.String a;

    public static java.lang.String a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]).toString().trim();
        } catch (java.lang.Throwable unused) {
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return com.sijla.d.b.a(str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static java.lang.String a(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream(bArr));
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                a(gZIPInputStream);
                byteArrayOutputStream.flush();
                return new java.lang.String(byteArrayOutputStream.toByteArray(), "utf-8");
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static java.util.List<java.lang.String> a(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.sijla.b.c.b) {
            return arrayList;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.sijla.h.a.d.a(".Android").toString());
        sb.append(com.sijla.h.a.g.a(context.getPackageName() + ".Android1"));
        arrayList.add(sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(com.sijla.h.a.d.a("Android").toString());
        sb2.append(com.sijla.h.a.g.a(context.getPackageName() + "Android1"));
        arrayList.add(sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(com.sijla.h.a.d.a("qmt").toString());
        sb3.append(com.sijla.h.a.g.a(context.getPackageName() + "qmt1"));
        arrayList.add(sb3.toString());
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(com.sijla.h.a.d.a("setup").toString());
        sb4.append(com.sijla.h.a.g.a(context.getPackageName() + "setup1"));
        arrayList.add(sb4.toString());
        return arrayList;
    }

    private static org.json.JSONObject a(java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
        java.lang.String a2 = com.sijla.d.b.a(com.sijla.h.a.g.a(valueOf).substring(0, 8), str);
        if (!android.text.TextUtils.isEmpty(a2)) {
            try {
                jSONObject.put("data", a2);
                jSONObject.put("ts", valueOf);
                return jSONObject;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return new org.json.JSONObject();
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject) {
        return a(jSONObject.toString(), new org.json.JSONObject());
    }

    public static void a(android.content.Context context, java.lang.String str, com.sijla.h.e eVar) {
        org.json.JSONObject a2;
        java.lang.String concat = kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF.concat(java.lang.String.valueOf(str));
        try {
            if (concat.equalsIgnoreCase((java.lang.String) com.sijla.h.j.b(context, str, "")) || (a2 = eVar.a(context)) == null) {
                return;
            }
            a2.put("tp", str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis() / 1000);
            byte[] bytes = sb.toString().getBytes();
            byte[] a3 = com.sijla.c.a.a(a2.toString().getBytes(), bytes);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.write(a3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.sijla.h.c.a.a();
            java.lang.String str2 = (java.lang.String) com.sijla.h.c.a.a("https://d.qchannel03.cn/aul?ct=dj&aultp=dj", byteArray, new com.sijla.h.c.a.a.a()).b();
            if (android.text.TextUtils.isEmpty(str2) || !str2.contains(concat)) {
                return;
            }
            com.sijla.h.j.a(context, str, concat);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(java.io.Closeable... closeableArr) {
        for (java.io.Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void a(java.net.HttpURLConnection... httpURLConnectionArr) {
        for (int i = 0; i <= 0; i++) {
            java.net.HttpURLConnection httpURLConnection = httpURLConnectionArr[0];
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, long j) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("arch", 0);
        long j2 = sharedPreferences.getLong(str, 0L);
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        boolean z = java.lang.Math.abs(currentTimeMillis - j2) > j;
        if (z) {
            sharedPreferences.edit().putLong(str, currentTimeMillis).apply();
        }
        return z;
    }

    public static boolean a(java.lang.String str) {
        if (str != null && !"".equals(str) && !com.igexin.push.core.b.m.equalsIgnoreCase(str)) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] a(java.io.File file) {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        byte[] a2 = com.sijla.c.a.a(fileInputStream);
        a(fileInputStream);
        return a2;
    }

    public static java.lang.String b() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i != strArr.length - 1) {
                    sb.append("|");
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String b(java.lang.String str) {
        if (a(str)) {
            return "";
        }
        try {
            java.lang.String e = e();
            return e + com.sijla.d.b.a(e, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void b(android.content.Context context) {
        try {
            java.lang.String str = (java.lang.String) com.sijla.h.j.b(context, "nd_sys_t", "");
            java.lang.String e = com.sijla.c.a.e();
            if (!e.equals(str)) {
                com.sijla.c.a.a(context, f("TruthInfo"), com.sijla.f.c.a(context).a());
                a(context, "dipt", new com.sijla.h.d("dipt"));
                com.sijla.h.j.a(context, "nd_sys_t", e);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private static byte[] b(byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                } catch (java.io.IOException e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            a(gZIPOutputStream);
        } catch (java.io.IOException e3) {
            e = e3;
            gZIPOutputStream2 = gZIPOutputStream;
            e.printStackTrace();
            a(gZIPOutputStream2);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(gZIPOutputStream2);
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String c(android.content.Context context) {
        return 1 != com.sijla.c.d.a.optLong(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, 0L) ? "" : context.getSharedPreferences("arch", 0).getString("sadr", "emt");
    }

    public static java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.sijla.d.b.b(str.substring(0, 8), str.substring(8, str.length()));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.util.List<java.lang.String> c() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z = com.sijla.b.c.a;
        return arrayList;
    }

    public static java.lang.String d(android.content.Context context) {
        if (a == null) {
            a = (context.getPackageName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.sijla.h.a.a.j(context)).replace(" ", "");
        }
        return a;
    }

    public static org.json.JSONObject d(java.lang.String str) {
        if (a(str)) {
            return null;
        }
        try {
            return new org.json.JSONObject(c(str));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String[] d() {
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
        return new java.lang.String[]{com.sijla.h.a.g.a(valueOf).substring(0, 8), valueOf};
    }

    public static java.lang.String e() {
        java.util.Random random = new java.util.Random();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    public static org.json.JSONObject e(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appkey", d(context));
            jSONObject.put("qid", com.sijla.h.i.b(context));
            jSONObject.put("osver", android.os.Build.VERSION.RELEASE);
            jSONObject.put(com.baidu.mobads.sdk.internal.bm.f, android.os.Build.VERSION.SDK_INT);
            jSONObject.put("sdkver", 20230823);
            jSONObject.put("brand", android.os.Build.BRAND);
            jSONObject.put("model", android.os.Build.MODEL);
            java.lang.String str = com.sijla.b.g.c;
            if (str == null) {
                str = "";
            }
            jSONObject.put("channel", str);
            jSONObject.put("NF7", "y");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static byte[] e(java.lang.String str) {
        return b(str.getBytes());
    }

    public static java.lang.String f(java.lang.String str) {
        return str + ".csv-" + com.sijla.c.a.f();
    }

    public static void f() {
    }

    public static java.lang.String g() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String g(android.content.Context context) {
        try {
            java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (a(string)) {
                return null;
            }
            return string.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0];
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean g(java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (byte b : str.getBytes()) {
            if ((b >= 0 && b <= 31) || b >= Byte.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String h() {
        return com.sijla.b.g.c;
    }

    public static android.app.Application i() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new java.lang.Class[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (android.app.Application) declaredField.get(declaredMethod.invoke(null, new java.lang.Object[0]));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
