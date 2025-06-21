package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class c {
    static final /* synthetic */ boolean a = true;
    private static java.lang.String b = "";

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new java.lang.AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    public static boolean a(java.io.File file, java.lang.String str, java.lang.String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            com.uc.crashsdk.a.a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, java.lang.String str, java.lang.String str2) {
        java.io.InputStream inputStream;
        java.net.HttpURLConnection httpURLConnection;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        com.uc.crashsdk.a.a.a("Uploading to " + str2);
        java.io.OutputStream outputStream = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + 40 + bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(length));
                java.io.OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    com.uc.crashsdk.a.a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        com.uc.crashsdk.a.g.a(outputStream2);
                        com.uc.crashsdk.a.g.a((java.io.Closeable) null);
                        com.uc.crashsdk.a.g.a((java.io.Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable unused) {
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    com.uc.crashsdk.a.g.b(th);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (java.lang.Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } finally {
                                    com.uc.crashsdk.a.g.a(outputStream);
                                    com.uc.crashsdk.a.g.a(inputStream);
                                    com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (java.lang.Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray == null) {
                            com.uc.crashsdk.a.g.a(outputStream2);
                            com.uc.crashsdk.a.g.a(inputStream);
                            com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (java.lang.Throwable unused4) {
                            }
                            return false;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Log upload response: " + new java.lang.String(byteArray));
                        com.uc.crashsdk.a.g.a(outputStream2);
                        com.uc.crashsdk.a.g.a(inputStream);
                        com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable unused5) {
                        }
                        return true;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a() {
        return new byte[]{org.apache.tools.tar.TarConstants.LF_NORMAL, com.google.common.base.Ascii.EM, 6, org.apache.tools.tar.TarConstants.LF_CONTIG};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static byte[] a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        java.io.BufferedInputStream bufferedInputStream;
        ?? r1 = 0;
        byte[] bArr2 = null;
        r1 = null;
        java.io.Closeable closeable = null;
        r1 = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                length = (int) file.length();
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    bufferedInputStream = new java.io.BufferedInputStream(fileInputStream);
                } catch (java.lang.Exception e) {
                    e = e;
                    bArr = null;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                bArr = null;
                fileInputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i = 0;
                while (i < length) {
                    int read = bufferedInputStream.read(bArr2, i, length - i);
                    if (-1 == read) {
                        break;
                    }
                    i += read;
                }
                com.uc.crashsdk.a.g.a(bufferedInputStream);
                com.uc.crashsdk.a.g.a(fileInputStream);
                r1 = bArr2;
            } catch (java.lang.Exception e3) {
                e = e3;
                byte[] bArr3 = bArr2;
                closeable = bufferedInputStream;
                bArr = bArr3;
                com.uc.crashsdk.a.g.b(e);
                com.uc.crashsdk.a.g.a(closeable);
                com.uc.crashsdk.a.g.a(fileInputStream);
                r1 = bArr;
                return r1;
            } catch (java.lang.Throwable th2) {
                th = th2;
                r1 = bufferedInputStream;
                com.uc.crashsdk.a.g.a((java.io.Closeable) r1);
                com.uc.crashsdk.a.g.a(fileInputStream);
                throw th;
            }
            return r1;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(java.lang.String str, byte[] bArr) {
        java.net.HttpURLConnection httpURLConnection;
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream;
        ?? r4;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bArr.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    if (httpURLConnection.getResponseCode() != 200) {
                        com.uc.crashsdk.a.g.a(outputStream);
                        com.uc.crashsdk.a.g.a((java.io.Closeable) null);
                        com.uc.crashsdk.a.g.a((java.io.Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable unused) {
                        }
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        r4 = new java.io.ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                r4.write(bArr2, 0, read);
                            } catch (java.lang.Throwable unused2) {
                                com.uc.crashsdk.a.g.a(outputStream);
                                com.uc.crashsdk.a.g.a(inputStream);
                                com.uc.crashsdk.a.g.a((java.io.Closeable) r4);
                                if (httpURLConnection != null) {
                                }
                                return null;
                            }
                        }
                        byte[] byteArray = r4.toByteArray();
                        com.uc.crashsdk.a.g.a(outputStream);
                        com.uc.crashsdk.a.g.a(inputStream);
                        com.uc.crashsdk.a.g.a((java.io.Closeable) r4);
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable unused3) {
                        }
                        return byteArray;
                    } catch (java.lang.Throwable unused4) {
                        r4 = 0;
                    }
                } catch (java.lang.Throwable unused5) {
                    inputStream = null;
                    r4 = 0;
                }
            } catch (java.lang.Throwable unused6) {
                inputStream = null;
                outputStream = inputStream;
                r4 = outputStream;
                com.uc.crashsdk.a.g.a(outputStream);
                com.uc.crashsdk.a.g.a(inputStream);
                com.uc.crashsdk.a.g.a((java.io.Closeable) r4);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable unused7) {
                    }
                }
                return null;
            }
        } catch (java.lang.Throwable unused8) {
            httpURLConnection = null;
            inputStream = null;
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        java.lang.System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return cipher.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static boolean b(java.io.File file, java.lang.String str, java.lang.String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return a(a2, str, str2);
            }
            return false;
        } catch (java.lang.Exception e) {
            com.uc.crashsdk.a.g.a(e);
            return false;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }
}
