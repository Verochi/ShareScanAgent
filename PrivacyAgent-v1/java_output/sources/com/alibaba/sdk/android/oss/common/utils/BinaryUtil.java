package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class BinaryUtil {
    public static java.lang.String calculateBase64Md5(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        return toBase64String(calculateMd5(fileDescriptor));
    }

    public static java.lang.String calculateBase64Md5(java.lang.String str) throws java.io.IOException {
        return toBase64String(calculateMd5(str));
    }

    public static java.lang.String calculateBase64Md5(byte[] bArr) {
        return toBase64String(calculateMd5(bArr));
    }

    public static byte[] calculateMd5(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileDescriptor);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.RuntimeException("MD5 algorithm not found.");
        }
    }

    public static byte[] calculateMd5(java.lang.String str) throws java.io.IOException {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.RuntimeException("MD5 algorithm not found.");
        }
    }

    public static byte[] calculateMd5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.RuntimeException("MD5 algorithm not found.");
        }
    }

    public static java.lang.String calculateMd5Str(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        return getMd5StrFromBytes(calculateMd5(fileDescriptor));
    }

    public static java.lang.String calculateMd5Str(java.lang.String str) throws java.io.IOException {
        return getMd5StrFromBytes(calculateMd5(str));
    }

    public static java.lang.String calculateMd5Str(byte[] bArr) {
        return getMd5StrFromBytes(calculateMd5(bArr));
    }

    public static byte[] calculateSha256(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.RuntimeException("SHA-256 algorithm not found.");
        }
    }

    private static java.lang.String convertHashToString(byte[] bArr) {
        java.lang.String str = "";
        for (byte b : bArr) {
            str = str + java.lang.Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    public static java.lang.String fileToSHA1(java.io.FileDescriptor fileDescriptor) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(fileDescriptor);
        } catch (java.lang.Exception unused) {
            fileInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            int i = 0;
            while (i != -1) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                }
            }
            java.lang.String convertHashToString = convertHashToString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (java.lang.Exception unused2) {
            }
            return convertHashToString;
        } catch (java.lang.Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Exception unused4) {
                }
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.lang.Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static java.lang.String fileToSHA1(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
        } catch (java.lang.Exception unused) {
            fileInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            int i = 0;
            while (i != -1) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                }
            }
            java.lang.String convertHashToString = convertHashToString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (java.lang.Exception unused2) {
            }
            return convertHashToString;
        } catch (java.lang.Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Exception unused4) {
                }
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.lang.Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static byte[] fromBase64String(java.lang.String str) {
        return android.util.Base64.decode(str, 0);
    }

    public static java.lang.String getMd5StrFromBytes(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static java.lang.String toBase64String(byte[] bArr) {
        return new java.lang.String(android.util.Base64.encode(bArr, 0)).trim();
    }

    public static java.lang.String toHex(byte[] bArr) {
        return okio.ByteString.of(bArr).hex();
    }
}
