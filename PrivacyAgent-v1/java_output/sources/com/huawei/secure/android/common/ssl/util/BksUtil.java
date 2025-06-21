package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class BksUtil {
    public static final android.net.Uri a = android.net.Uri.parse("content://com.huawei.hwid");
    public static final java.lang.String[] b = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    public static int a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            com.huawei.secure.android.common.ssl.util.g.e("BksUtil", "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            com.huawei.secure.android.common.ssl.util.g.a("BksUtil", "create directory  success");
            return 0;
        }
        com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "create directory  failed");
        return -1;
    }

    public static java.lang.String b(android.content.Context context) {
        android.content.Context createDeviceProtectedStorageContext;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return context.getApplicationContext().getFilesDir() + java.io.File.separator + "aegis";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        sb.append(createDeviceProtectedStorageContext.getFilesDir());
        sb.append(java.io.File.separator);
        sb.append("aegis");
        return sb.toString();
    }

    public static java.lang.String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static void d(java.io.InputStream inputStream, android.content.Context context) {
        java.io.FileOutputStream fileOutputStream;
        if (inputStream == null || context == null) {
            return;
        }
        java.lang.String b2 = b(context);
        if (!new java.io.File(b2).exists()) {
            a(b2);
        }
        java.io.File file = new java.io.File(b2, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        ?? r7 = 0;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "write output stream ");
                fileOutputStream = new java.io.FileOutputStream(file);
                r7 = 2048;
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException unused) {
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) fileOutputStream);
        } catch (java.io.IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            com.huawei.secure.android.common.ssl.util.g.b("BksUtil", " IOException");
            com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) fileOutputStream2);
            r7 = fileOutputStream2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r7 = fileOutputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) r7);
            throw th;
        }
    }

    public static byte[] e(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("PackageManager.NameNotFoundException : ");
            sb.append(e.getMessage());
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("get pm exception : ");
            sb2.append(e2.getMessage());
        }
        return new byte[0];
    }

    public static java.lang.String f(android.content.Context context) {
        return b(context) + java.io.File.separator + "hmsrootcas.bks";
    }

    public static java.lang.String g(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "inputstraem exception");
            return "";
        }
    }

    public static synchronized java.io.InputStream getBksFromTss(android.content.Context context) {
        java.io.InputStream inputStream;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.lang.String a2;
        java.lang.String g;
        synchronized (com.huawei.secure.android.common.ssl.util.BksUtil.class) {
            com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "get bks from tss begin");
            if (context != null) {
                com.huawei.secure.android.common.ssl.util.c.a(context);
            }
            android.content.Context a3 = com.huawei.secure.android.common.ssl.util.c.a();
            java.io.ByteArrayInputStream byteArrayInputStream2 = null;
            if (a3 == null) {
                com.huawei.secure.android.common.ssl.util.g.b("BksUtil", com.anythink.expressad.foundation.g.b.b.a);
                return null;
            }
            if (!i(com.huawei.secure.android.common.ssl.util.h.a("com.huawei.hwid")) && !i(com.huawei.secure.android.common.ssl.util.h.a(com.huawei.hms.common.PackageConstants.SERVICES_PACKAGE_ALL_SCENE))) {
                com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "hms version code is too low : " + com.huawei.secure.android.common.ssl.util.h.a("com.huawei.hwid"));
                return null;
            }
            if (!l(a3, "com.huawei.hwid") && !h(a3, com.huawei.hms.common.PackageConstants.SERVICES_PACKAGE_ALL_SCENE)) {
                com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "hms sign error");
                return null;
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                inputStream = a3.getContentResolver().openInputStream(android.net.Uri.withAppendedPath(a, "files/hmsrootcas.bks"));
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    a2 = com.huawei.secure.android.common.ssl.util.i.a("bks_hash", "", a3);
                    g = g(byteArrayOutputStream.toByteArray());
                } catch (java.lang.Exception unused2) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider");
                    com.huawei.secure.android.common.ssl.util.f.a(inputStream);
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) byteArrayOutputStream);
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) byteArrayInputStream2);
                    return getFilesBksIS(a3);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    com.huawei.secure.android.common.ssl.util.f.a(inputStream);
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) byteArrayOutputStream);
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) byteArrayInputStream2);
                    throw th;
                }
            } catch (java.lang.Exception unused3) {
                inputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (k(a3) && a2.equals(g)) {
                com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "bks not update");
                com.huawei.secure.android.common.ssl.util.f.a(inputStream);
                com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) byteArrayOutputStream);
                com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) byteArrayInputStream);
                return getFilesBksIS(a3);
            }
            com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "update bks and sp");
            d(byteArrayInputStream, a3);
            com.huawei.secure.android.common.ssl.util.i.b("bks_hash", g, a3);
            com.huawei.secure.android.common.ssl.util.f.a(inputStream);
            com.huawei.secure.android.common.ssl.util.f.a((java.io.OutputStream) byteArrayOutputStream);
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) byteArrayInputStream);
            return getFilesBksIS(a3);
        }
    }

    public static java.io.InputStream getFilesBksIS(android.content.Context context) {
        if (!k(context)) {
            return null;
        }
        com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "getFilesBksIS ");
        try {
            return new java.io.FileInputStream(f(context));
        } catch (java.io.FileNotFoundException unused) {
            com.huawei.secure.android.common.ssl.util.g.b("BksUtil", "FileNotFoundExceptio: ");
            return null;
        }
    }

    public static boolean h(android.content.Context context, java.lang.String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(j(e(context, str)));
    }

    public static boolean i(java.lang.String str) {
        int parseInt;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        com.huawei.secure.android.common.ssl.util.g.c("BksUtil", "hms version code is : " + str);
        java.lang.String[] split = str.split("\\.");
        java.lang.String[] split2 = "4.0.2.300".split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = java.lang.Math.max(length, length2);
        int i = 0;
        while (i < max) {
            if (i < length) {
                try {
                    parseInt = java.lang.Integer.parseInt(split[i]);
                } catch (java.lang.Exception e) {
                    com.huawei.secure.android.common.ssl.util.g.b("BksUtil", " exception : " + e.getMessage());
                    return i >= length2;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i < length2 ? java.lang.Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i++;
        }
        return true;
    }

    public static java.lang.String j(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return c(java.security.MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (java.security.NoSuchAlgorithmException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("NoSuchAlgorithmException");
            sb.append(e.getMessage());
            return "";
        }
    }

    public static boolean k(android.content.Context context) {
        return new java.io.File(b(context) + java.io.File.separator + "hmsrootcas.bks").exists();
    }

    public static boolean l(android.content.Context context, java.lang.String str) {
        byte[] e = e(context, str);
        for (java.lang.String str2 : b) {
            if (str2.equalsIgnoreCase(j(e))) {
                return true;
            }
        }
        return false;
    }
}
