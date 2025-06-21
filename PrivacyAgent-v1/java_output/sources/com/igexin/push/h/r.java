package com.igexin.push.h;

/* loaded from: classes23.dex */
public class r {
    public static final java.lang.String a = "com.igexin.push.h.r";
    public static final java.lang.String b = "utf-8";
    private static final java.lang.String c = "POST";
    private static final java.lang.String d = "GET";
    private static final java.lang.String e = "GETUI";
    private static final int f = 30000;

    private static java.lang.String a(java.io.InputStream inputStream, java.lang.String str) throws java.lang.Exception {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, str));
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            return stringWriter.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static java.lang.String a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                java.lang.String trim = split[i].trim();
                if (trim.startsWith("charset")) {
                    java.lang.String[] split2 = trim.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (split2.length == 2 && !android.text.TextUtils.isEmpty(split2[1])) {
                        return split2[1].trim();
                    }
                } else {
                    i++;
                }
            }
        }
        return "utf-8";
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) throws java.lang.Exception {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = "utf-8";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if (!android.text.TextUtils.isEmpty(key) && !android.text.TextUtils.isEmpty(value)) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(key);
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(java.net.URLEncoder.encode(value, str));
            }
        }
        return sb.toString();
    }

    private static java.net.HttpURLConnection a(java.net.URL url, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("User-Agent", e);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + url.getPort());
        return httpURLConnection;
    }

    private static java.net.URL a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.String str3;
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        java.lang.String sb3;
        java.net.URL url = new java.net.URL(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            return url;
        }
        if (android.text.TextUtils.isEmpty(url.getQuery())) {
            str3 = "?";
            if (str.endsWith("?")) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb3 = sb2.toString();
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb3 = sb.toString();
            }
        } else {
            str3 = "&";
            if (str.endsWith("&")) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb3 = sb2.toString();
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb3 = sb.toString();
            }
        }
        return new java.net.URL(sb3);
    }

    private static java.net.URL a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) throws java.lang.Exception {
        return a(str, a(map, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(java.io.InputStream inputStream) {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            try {
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                    return byteArray;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    com.igexin.c.a.c.a.a(e);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (java.io.IOException e5) {
                        com.igexin.c.a.c.a.a(e5);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
    }

    private static byte[] a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        return ("Content-Disposition:form-data;name=\"" + str + "\"\r\nContent-Type:text/plain\r\n\r\n" + str2).getBytes(str3);
    }

    private static byte[] a(java.lang.String str, java.lang.String str2, byte[] bArr, int i, int i2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection;
        java.io.OutputStream outputStream = null;
        try {
            httpURLConnection = a(new java.net.URL(str), "POST", str2);
            try {
                try {
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i2);
                    try {
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        byte[] a2 = a(httpURLConnection);
                        outputStream.close();
                        httpURLConnection.disconnect();
                        return a2;
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        throw e2;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    com.igexin.c.a.c.a.a(e);
                    throw e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (java.io.IOException e4) {
            e = e4;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        return a(str, map, "utf-8", i, i2);
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection b2 = b(str, map, i, i2, str2);
        try {
            try {
                return a(b2);
            } catch (java.lang.Exception e2) {
                throw e2;
            }
        } finally {
            if (b2 != null) {
                b2.disconnect();
            }
        }
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, int i, int i2) throws java.lang.Exception {
        java.lang.String concat = "application/x-www-form-urlencoded;charset=".concat(java.lang.String.valueOf(str2));
        java.lang.String a2 = a(map, str2);
        byte[] bArr = new byte[0];
        if (a2 != null) {
            bArr = a2.getBytes(str2);
        }
        return a(str, concat, bArr, i, i2);
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, com.igexin.push.h.i> map2, int i, int i2) throws java.lang.Exception {
        return (map2 == null || map2.isEmpty()) ? a(str, map, "utf-8", i, i2) : a(str, map, map2, "utf-8", i, i2);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0221: MOVE (r17 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:125:0x0221 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0162 A[Catch: all -> 0x01fc, Exception -> 0x01fe, TryCatch #9 {Exception -> 0x01fe, all -> 0x01fc, blocks: (B:37:0x0159, B:40:0x017f, B:41:0x0188, B:44:0x01a4, B:46:0x01c8, B:50:0x0162, B:53:0x016b, B:56:0x0174, B:78:0x00fd, B:80:0x0103, B:83:0x010e, B:85:0x0114, B:87:0x011d, B:90:0x0128, B:92:0x012f, B:94:0x0136, B:96:0x013e, B:108:0x01d3), top: B:36:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, com.igexin.push.h.i> map2, java.lang.String str2, int i, int i2) throws java.lang.Exception {
        java.io.OutputStream outputStream;
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2;
        java.lang.String str3;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.h.i>> it;
        java.lang.Object obj;
        java.io.File file;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.System.currentTimeMillis());
        java.lang.String sb2 = sb.toString();
        try {
            try {
                java.net.HttpURLConnection a2 = a(new java.net.URL(str), "POST", "multipart/form-data;charset=" + str2 + ";boundary=" + sb2);
                try {
                    a2.setConnectTimeout(i);
                    a2.setReadTimeout(i2);
                    try {
                        java.io.OutputStream outputStream2 = a2.getOutputStream();
                        try {
                            byte[] bytes = ("\r\n--" + sb2 + "\r\n").getBytes(str2);
                            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                                byte[] bytes2 = ("Content-Disposition:form-data;name=\"" + entry.getKey() + "\"\r\nContent-Type:text/plain\r\n\r\n" + entry.getValue()).getBytes(str2);
                                outputStream2.write(bytes);
                                outputStream2.write(bytes2);
                            }
                            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.h.i>> it2 = map2.entrySet().iterator();
                            while (it2.hasNext()) {
                                java.util.Map.Entry<java.lang.String, com.igexin.push.h.i> next = it2.next();
                                com.igexin.push.h.i value = next.getValue();
                                next.getKey();
                                if (value.a == null && (file = value.c) != null && file.exists()) {
                                    value.a = value.c.getName();
                                }
                                java.lang.String str4 = value.a;
                                if (value.b == null) {
                                    byte[] a3 = value.a();
                                    try {
                                        if (a3 != null) {
                                            it = it2;
                                            if (a3.length < 10) {
                                                str3 = sb2;
                                                httpURLConnection = a2;
                                            } else {
                                                byte b2 = a3[0];
                                                httpURLConnection = a2;
                                                if (b2 == 71 && a3[1] == 73 && a3[2] == 70) {
                                                    str3 = sb2;
                                                    obj = "GIF";
                                                } else {
                                                    byte b3 = a3[1];
                                                    if (b3 == 80) {
                                                        str3 = sb2;
                                                        if (a3[2] == 78 && a3[3] == 71) {
                                                            obj = "PNG";
                                                        }
                                                    } else {
                                                        str3 = sb2;
                                                    }
                                                    if (a3[6] == 74 && a3[7] == 70 && a3[8] == 73 && a3[9] == 70) {
                                                        obj = "JPG";
                                                    } else if (b2 == 66 && b3 == 77) {
                                                        obj = "BMP";
                                                    }
                                                }
                                                value.b = !"JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? "image/bmp" : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
                                            }
                                        } else {
                                            str3 = sb2;
                                            httpURLConnection = a2;
                                            it = it2;
                                        }
                                        value.b = !"JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? "image/bmp" : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        outputStream = outputStream2;
                                        try {
                                            com.igexin.c.a.c.a.a(e);
                                            throw e;
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        outputStream = outputStream2;
                                        if (outputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                    obj = null;
                                } else {
                                    str3 = sb2;
                                    httpURLConnection = a2;
                                    it = it2;
                                }
                                java.lang.String str5 = value.b;
                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                sb3.append("Content-Disposition:form-data;name=\"");
                                sb3.append("dp_data");
                                sb3.append("\";filename=\"");
                                if (android.text.TextUtils.isEmpty(str4)) {
                                    str4 = com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME;
                                }
                                sb3.append(str4);
                                sb3.append("\"\r\nContent-Type:");
                                sb3.append(str5);
                                sb3.append("\r\n\r\n");
                                byte[] bytes3 = sb3.toString().getBytes(str2);
                                outputStream2.write(bytes);
                                outputStream2.write(bytes3);
                                byte[] a4 = value.a();
                                if (a4 != null) {
                                    outputStream2.write(a4);
                                }
                                it2 = it;
                                sb2 = str3;
                                a2 = httpURLConnection;
                            }
                            httpURLConnection = a2;
                            outputStream2.write(("\r\n--" + sb2 + "--\r\n").getBytes(str2));
                            byte[] a5 = a(httpURLConnection);
                            outputStream2.close();
                            httpURLConnection.disconnect();
                            return a5;
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            httpURLConnection = a2;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            httpURLConnection = a2;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        httpURLConnection = a2;
                        outputStream = null;
                    }
                } catch (java.io.IOException e5) {
                    throw e5;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                outputStream = null;
            }
        } catch (java.io.IOException e6) {
            throw e6;
        } catch (java.lang.Throwable th5) {
            th = th5;
            outputStream = null;
            httpURLConnection = null;
        }
    }

    public static byte[] a(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        return a(str, com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, bArr, 10000, 10000);
    }

    private static byte[] a(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        return httpURLConnection.getErrorStream() == null ? a(httpURLConnection.getInputStream()) : b(httpURLConnection).getBytes();
    }

    private static java.lang.String b(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        java.lang.String a2 = a(httpURLConnection.getErrorStream(), a(httpURLConnection.getContentType()));
        if (!android.text.TextUtils.isEmpty(a2)) {
            return a2;
        }
        throw new java.io.IOException(httpURLConnection.getResponseCode() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + httpURLConnection.getResponseMessage());
    }

    private static java.net.HttpURLConnection b(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection a2 = a(a(str, a(map, str2)), "GET", "application/x-www-form-urlencoded;charset=".concat(java.lang.String.valueOf(str2)));
        a2.setConnectTimeout(i);
        a2.setReadTimeout(i2);
        return a2;
    }

    private static byte[] b(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Content-Disposition:form-data;name=\"");
        sb.append("dp_data");
        sb.append("\";filename=\"");
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME;
        }
        sb.append(str);
        sb.append("\"\r\nContent-Type:");
        sb.append(str2);
        sb.append("\r\n\r\n");
        return sb.toString().getBytes(str3);
    }

    private static byte[] b(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        return a(str, map, i, i2, "utf-8");
    }

    private static byte[] c(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        java.net.HttpURLConnection b2 = b(str, map, i, i2, "utf-8");
        try {
            try {
                return a(b2);
            } catch (java.lang.Exception e2) {
                throw e2;
            }
        } finally {
            if (b2 != null) {
                b2.disconnect();
            }
        }
    }
}
