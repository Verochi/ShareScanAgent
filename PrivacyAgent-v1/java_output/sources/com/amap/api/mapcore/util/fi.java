package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fi {
    static java.lang.String a;
    private static final java.lang.String[] b = {"arm64-v8a", "x86_64"};
    private static final java.lang.String[] c = {"arm", "x86"};

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        }
        a = sb.toString();
    }

    public static com.amap.api.mapcore.util.fh a() throws com.amap.api.mapcore.util.eu {
        return new com.amap.api.mapcore.util.fh.a("collection", "1.0", "AMap_collection_1.0").a(new java.lang.String[]{"com.amap.api.collection"}).a();
    }

    public static java.lang.String a(long j) {
        return a(j, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static java.lang.String a(long j, java.lang.String str) {
        try {
            return new java.text.SimpleDateFormat(str, java.util.Locale.CHINA).format(new java.util.Date(j));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "ctt");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.lang.String[] strArr;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
                java.lang.reflect.Field declaredField = java.lang.Class.forName(android.content.pm.ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                str = (java.lang.String) declaredField.get(applicationInfo);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "ut", "gct");
            }
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                try {
                    java.lang.String[] strArr2 = (java.lang.String[]) android.os.Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length > 0) {
                        str = strArr2[0];
                    }
                    if (!android.text.TextUtils.isEmpty(str) && java.util.Arrays.asList(b).contains(str)) {
                        java.lang.String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            if (java.util.Arrays.asList(c).contains(str2.substring(str2.lastIndexOf(java.io.File.separator) + 1)) && (strArr = (java.lang.String[]) android.os.Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    com.amap.api.mapcore.util.ga.a(th2, "ut", "gct_p");
                }
            }
            return !android.text.TextUtils.isEmpty(str) ? android.os.Build.CPU_ABI : str;
        }
        str = "";
        if (android.os.Build.VERSION.SDK_INT >= 28) {
        }
        if (!android.text.TextUtils.isEmpty(str)) {
        }
    }

    public static java.lang.String a(java.lang.Throwable th) {
        java.io.StringWriter stringWriter;
        java.io.PrintWriter printWriter;
        try {
            stringWriter = new java.io.StringWriter();
            try {
                printWriter = new java.io.PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    for (java.lang.Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter);
                    }
                    java.lang.String obj = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        printWriter.close();
                    } catch (java.lang.Throwable th3) {
                        th3.printStackTrace();
                    }
                    return obj;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    try {
                        th.printStackTrace();
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (java.lang.Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (java.lang.Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                printWriter = null;
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            stringWriter = null;
            printWriter = null;
        }
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map.size() == 0) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            boolean z = true;
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                if (z) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(entry.getValue());
                    z = false;
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new java.lang.String(bArr, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr);
        }
    }

    public static java.lang.reflect.Method a(java.lang.Class cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(c(str), clsArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.util.Calendar a(java.lang.String str, java.lang.String str2) {
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str2, java.util.Locale.CHINA);
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
            return calendar;
        } catch (java.text.ParseException e) {
            com.amap.api.mapcore.util.ga.a(e, "ut", "ctt");
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        java.lang.String str3;
        java.lang.String string;
        java.lang.String e = com.amap.api.mapcore.util.ev.e(context);
        java.lang.String b2 = com.amap.api.mapcore.util.fd.b(e);
        java.lang.String a2 = com.amap.api.mapcore.util.ev.a(context);
        try {
            if (jSONObject.has("info")) {
                str3 = jSONObject.getString("info");
                java.lang.StringBuilder sb = new java.lang.StringBuilder("请在高德开放平台官网中搜索\"");
                sb.append(str3);
                sb.append("\"相关内容进行解决");
            } else {
                str3 = "";
            }
            if ("INVALID_USER_SCODE".equals(str3)) {
                java.lang.String string2 = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
                string = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
                if (b2.equals(string2) || b2.equals(string)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si"));
                    sb2.append("\"请求内容过长导致业务调用失败\"相关内容进行解决");
                }
            } else if ("INVALID_USER_KEY".equals(str3)) {
                string = jSONObject.has("key") ? jSONObject.getString("key") : "";
                if (string.length() > 0 && !a2.equals(string)) {
                    c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        g("SHA1Package:".concat(java.lang.String.valueOf(e)));
        g("key:".concat(java.lang.String.valueOf(a2)));
        g("csid:".concat(java.lang.String.valueOf(str)));
        g("gsid:".concat(java.lang.String.valueOf(str2)));
        g("json:" + jSONObject.toString());
    }

    public static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            int i = b2 & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (java.io.IOException e) {
            com.amap.api.mapcore.util.ga.a(e, "ut", "wFie");
        }
    }

    public static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (java.io.IOException e) {
                com.amap.api.mapcore.util.ga.a(e, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        a(byteArrayOutputStream, (byte) length, a(str));
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((java.lang.Integer) context.getClass().getMethod("checkSelfPermission", java.lang.String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "ut", "cpm");
            }
        }
        return true;
    }

    public static boolean a(org.json.JSONObject jSONObject, java.lang.String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i / 256), (byte) (i % 256)};
    }

    public static byte[] a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static com.amap.api.mapcore.util.fh b() throws com.amap.api.mapcore.util.eu {
        return new com.amap.api.mapcore.util.fh.a("co", "1.0.0", "AMap_co_1.0.0").a(new java.lang.String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String c2 = com.amap.api.mapcore.util.fa.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "tsfb64");
            return "";
        }
    }

    public static java.lang.String b(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return d(sb.toString());
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static java.lang.String c(java.lang.String str) {
        return str.length() < 2 ? "" : com.amap.api.mapcore.util.fa.a(str.substring(1));
    }

    public static byte[] c() {
        try {
            java.lang.String[] split = new java.lang.StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = java.lang.Byte.parseByte(split[i]);
            }
            java.lang.String[] split2 = new java.lang.StringBuffer(new java.lang.String(com.amap.api.mapcore.util.fa.b(new java.lang.String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = java.lang.Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x003c -> B:16:0x005c). Please report as a decompilation issue!!! */
    public static byte[] c(byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.ZipOutputStream zipOutputStream;
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "ut", "zp2");
            }
            if (bArr.length != 0) {
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        zipOutputStream = new java.util.zip.ZipOutputStream(byteArrayOutputStream);
                        try {
                            zipOutputStream.putNextEntry(new java.util.zip.ZipEntry("log"));
                            zipOutputStream.write(bArr);
                            zipOutputStream.closeEntry();
                            zipOutputStream.finish();
                            bArr2 = byteArrayOutputStream.toByteArray();
                            try {
                                zipOutputStream.close();
                            } catch (java.lang.Throwable th2) {
                                com.amap.api.mapcore.util.ga.a(th2, "ut", "zp1");
                            }
                            byteArrayOutputStream.close();
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            try {
                                com.amap.api.mapcore.util.ga.a(th, "ut", "zp");
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (java.lang.Throwable th4) {
                                        com.amap.api.mapcore.util.ga.a(th4, "ut", "zp1");
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return bArr2;
                            } finally {
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        zipOutputStream = null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    zipOutputStream = null;
                }
                return bArr2;
            }
        }
        return null;
    }

    public static java.lang.String d(java.lang.String str) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "sPa");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String[] split = str.split("&");
        java.util.Arrays.sort(split);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (java.lang.String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    public static java.security.PublicKey d() throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(com.amap.api.mapcore.util.fa.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
        } catch (java.lang.Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance(c("IWC41MDk"));
            java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance(c("EUlNB"));
            java.security.cert.Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            if (generateCertificate != null && keyFactory != null) {
                java.security.PublicKey generatePublic = keyFactory.generatePublic(new java.security.spec.X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                try {
                    byteArrayInputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                return generatePublic;
            }
            try {
                byteArrayInputStream.close();
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            return null;
        } catch (java.lang.Throwable unused2) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (java.lang.Throwable th3) {
                    th3.printStackTrace();
                }
            }
            return null;
        }
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static java.lang.String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "h2s");
            return null;
        }
    }

    public static byte[] e(java.lang.String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) java.lang.Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static java.lang.String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ut", "csb2h");
            return null;
        }
    }

    public static boolean f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return com.amap.api.mapcore.util.fa.a(str).contains(android.os.Build.MODEL + android.os.Build.VERSION.SDK_INT);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String g(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void g(java.lang.String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            java.lang.String substring = str.substring(0, 78);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("|");
            sb.append(substring);
            sb.append("|");
            str = str.substring(78);
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("|");
        sb2.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb2.append(" ");
        }
        sb2.append("|");
    }

    private static byte[] h(byte[] bArr) throws java.io.IOException, java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                java.util.zip.GZIPOutputStream gZIPOutputStream2 = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream2.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (java.lang.Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        throw th;
                    } catch (java.lang.Throwable th2) {
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }
}
