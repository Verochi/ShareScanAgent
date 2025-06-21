package com.huawei.secure.android.common.encrypt.hash;

/* loaded from: classes22.dex */
public abstract class FileSHA256 {
    public static final java.lang.String a = "FileSHA256";
    public static final java.lang.String[] b = {"SHA-256", "SHA-384", "SHA-512"};

    public static boolean a(java.io.File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean b(java.lang.String str) {
        for (java.lang.String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String fileSHA256Encrypt(java.io.File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String fileSHAEncrypt(java.io.File file, java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        if (android.text.TextUtils.isEmpty(str) || !b(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "file is not valid");
            return "";
        }
        com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream checkCRC64DownloadInputStream = 0;
        java.lang.String str2 = null;
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        z = true;
                    }
                    str2 = z ? com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(messageDigest.digest()) : null;
                    com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) fileInputStream);
                } catch (java.io.IOException e) {
                    e = e;
                    com.huawei.secure.android.common.encrypt.utils.b.b(a, "IOException" + e.getMessage());
                    com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) fileInputStream);
                    return str2;
                } catch (java.security.NoSuchAlgorithmException e2) {
                    e = e2;
                    com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException" + e.getMessage());
                    com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) fileInputStream);
                    return str2;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                checkCRC64DownloadInputStream = "";
                com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) checkCRC64DownloadInputStream);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            fileInputStream = null;
        } catch (java.security.NoSuchAlgorithmException e4) {
            e = e4;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) checkCRC64DownloadInputStream);
            throw th;
        }
        return str2;
    }

    public static java.lang.String inputStreamSHA256Encrypt(java.io.InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    public static java.lang.String inputStreamSHAEncrypt(java.io.InputStream inputStream, java.lang.String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(messageDigest.digest());
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            }
        } catch (java.io.IOException | java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "inputstraem exception");
            return "";
        } finally {
            com.huawei.secure.android.common.encrypt.utils.a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(java.io.File file, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(java.io.File file, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(java.io.InputStream inputStream, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }
}
