package com.alipay.sdk.m.z;

/* loaded from: classes.dex */
public final class a {
    public static java.lang.String a(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        return (map == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public static boolean a(java.lang.String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!java.lang.Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }

    public static boolean b(java.lang.String str) {
        return !a(str);
    }

    public static boolean c(java.lang.String str) {
        for (byte b : str.getBytes()) {
            if ((b >= 0 && b <= 31) || b >= Byte.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.String d(java.lang.String str) {
        return str == null ? "" : str;
    }

    public static java.lang.String e(java.lang.String str) {
        try {
            if (a(str)) {
                return null;
            }
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String f(java.lang.String str) {
        try {
            byte[] array = java.nio.ByteBuffer.allocate(4).order(java.nio.ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(str.length());
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] bArr = new byte[byteArrayOutputStream.toByteArray().length + 4];
            java.lang.System.arraycopy(array, 0, bArr, 0, 4);
            java.lang.System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
            return android.util.Base64.encodeToString(bArr, 8);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String g(java.lang.String str) {
        if (a(str)) {
            return "";
        }
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(str.getBytes("utf-8"));
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    return new java.lang.String(android.util.Base64.encode(byteArray, 2));
                }
                gZIPOutputStream.write(bArr, 0, read);
            }
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
