package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public final class t0 {
    public static java.lang.String a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.FileNotFoundException unused) {
        } catch (java.io.IOException unused2) {
        }
        try {
            com.huawei.hms.hatool.p0 p0Var = new com.huawei.hms.hatool.p0(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                p0Var.a(bArr, read);
            }
            if (p0Var.b() == 0) {
                a((java.io.Closeable) fileInputStream);
                return "";
            }
            java.lang.String str = new java.lang.String(p0Var.a(), "UTF-8");
            a((java.io.Closeable) fileInputStream);
            return str;
        } catch (java.io.FileNotFoundException unused3) {
            fileInputStream2 = fileInputStream;
            com.huawei.hms.hatool.y.f("hmsSdk", "getInfoFromFile(): No files need to be read");
            a((java.io.Closeable) fileInputStream2);
            return "";
        } catch (java.io.IOException unused4) {
            fileInputStream2 = fileInputStream;
            com.huawei.hms.hatool.y.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
            a((java.io.Closeable) fileInputStream2);
            return "";
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            a((java.io.Closeable) fileInputStream2);
            throw th;
        }
    }

    public static java.lang.String a(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            a((java.io.Closeable) byteArrayOutputStream);
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                com.huawei.hms.hatool.y.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void a(java.io.File file, java.lang.String str) {
        java.lang.String str2;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.FileNotFoundException unused) {
        } catch (java.io.IOException unused2) {
        }
        try {
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.flush();
        } catch (java.io.FileNotFoundException unused3) {
            fileOutputStream2 = fileOutputStream;
            str2 = "saveInfoToFile(): No files need to be read";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            fileOutputStream = fileOutputStream2;
            a((java.io.Closeable) fileOutputStream);
        } catch (java.io.IOException unused4) {
            fileOutputStream2 = fileOutputStream;
            str2 = "saveInfoToFile(): io exc from write info to file!";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            fileOutputStream = fileOutputStream2;
            a((java.io.Closeable) fileOutputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a((java.io.Closeable) fileOutputStream2);
            throw th;
        }
        a((java.io.Closeable) fileOutputStream);
    }

    public static void a(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException unused) {
                com.huawei.hms.hatool.y.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void a(java.net.HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (java.lang.Exception unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        com.huawei.hms.hatool.y.a("hmsSdk", " connHttp disconnect");
    }

    public static byte[] a(byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.Deflater deflater = new java.util.zip.Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        a((java.io.OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
