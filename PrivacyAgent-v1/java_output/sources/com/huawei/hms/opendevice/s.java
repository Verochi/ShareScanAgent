package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class s {
    public static java.lang.String a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int read = inputStream.read();
        while (-1 != read) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
        }
        java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
        a((java.io.Closeable) inputStream);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream2;
    }

    public static java.lang.String a(java.lang.String str) {
        java.io.InputStreamReader inputStreamReader;
        java.io.File file = new java.io.File(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8");
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (java.io.FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                            com.huawei.hms.support.log.HMSLog.e("StreamUtil", "file not exist.");
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader);
                            return sb.toString();
                        } catch (java.io.IOException unused2) {
                            bufferedReader = bufferedReader2;
                            com.huawei.hms.support.log.HMSLog.e("StreamUtil", "read value IOException.");
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader);
                            return sb.toString();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader);
                            throw th;
                        }
                    }
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader2);
                } catch (java.io.FileNotFoundException unused3) {
                } catch (java.io.IOException unused4) {
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.FileNotFoundException unused5) {
            inputStreamReader = null;
        } catch (java.io.IOException unused6) {
            inputStreamReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
        return sb.toString();
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                com.huawei.hms.support.log.HMSLog.w("StreamUtil", "close IOException");
            }
        }
    }

    public static void a(java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null) {
            com.huawei.hms.support.log.HMSLog.e("StreamUtil", "parent file is null.");
            throw new java.io.IOException("parent file is null");
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            com.huawei.hms.support.log.HMSLog.e("StreamUtil", "make parent dirs failed.");
            throw new java.io.IOException("make parent dirs failed");
        }
        if (file.createNewFile()) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.e("StreamUtil", "create file failed.");
        throw new java.io.IOException("create file failed");
    }

    public static void a(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Throwable unused) {
                com.huawei.hms.support.log.HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
            }
        }
    }
}
