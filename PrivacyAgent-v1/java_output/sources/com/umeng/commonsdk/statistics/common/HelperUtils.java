package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public class HelperUtils {
    public static final java.lang.String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");
    private static final java.lang.String TAG = "helper";

    public static java.lang.String MD5(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (java.lang.Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static boolean checkStrLen(java.lang.String str, int i) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return str.length() <= i;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.String getFileMD5(java.io.File file) {
        byte[] bArr = new byte[1024];
        try {
            if (!file.isFile()) {
                return "";
            }
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    return java.lang.String.format("%1$032x", new java.math.BigInteger(1, messageDigest.digest()));
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getMD5(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(java.lang.Integer.toHexString((b & 255) | androidx.core.view.InputDeviceCompat.SOURCE_ANY).substring(6));
            }
            return stringBuffer.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            com.umeng.commonsdk.statistics.common.MLog.i(TAG, "getMD5 error", e);
            return "";
        }
    }

    public static java.lang.String getUmengMD5(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(java.lang.Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.i(TAG, "getMD5 error", th);
            return "";
        }
    }

    public static java.lang.String readFile(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        try {
            if (!file.exists()) {
                safeClose((java.io.InputStream) null);
                return null;
            }
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                java.lang.String str = new java.lang.String(bArr);
                safeClose(fileInputStream);
                return str;
            } catch (java.lang.Throwable unused) {
                safeClose(fileInputStream);
                return null;
            }
        } catch (java.lang.Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] readStreamToByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static java.lang.String readStreamToString(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static void safeClose(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void safeClose(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static java.lang.String subStr(java.lang.String str, int i) {
        java.lang.String str2 = "";
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                str2 = str.substring(0, str.length() < i ? str.length() : i);
                int length = str2.getBytes("UTF-8").length;
                int i2 = i;
                while (length > i) {
                    i2--;
                    str2 = str.substring(0, i2 > str.length() ? str.length() : i2);
                    length = str2.getBytes("UTF-8").length;
                }
                return str2;
            }
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.statistics.common.MLog.e(e);
        }
        return str2;
    }

    public static void writeFile(java.io.File file, java.lang.String str) throws java.io.IOException {
        writeFile(file, str.getBytes());
    }

    public static void writeFile(java.io.File file, byte[] bArr) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            safeClose(fileOutputStream);
        }
    }
}
