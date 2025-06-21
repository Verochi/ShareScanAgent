package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class c {
    public static final java.lang.String[] a = {com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG, com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG, "bmp", "gif", "webp"};

    public static java.lang.String a(java.io.File file) {
        java.io.InputStreamReader inputStreamReader;
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new java.io.InputStreamReader(new java.io.BufferedInputStream(new java.io.FileInputStream(file)));
            try {
                try {
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            java.lang.String stringWriter2 = stringWriter.toString();
                            a(inputStreamReader);
                            a(stringWriter);
                            return stringWriter2;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                } catch (java.io.IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(inputStreamReader);
                    a(stringWriter);
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStreamReader2 = inputStreamReader;
                a(inputStreamReader2);
                a(stringWriter);
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            inputStreamReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            a(inputStreamReader2);
            a(stringWriter);
            throw th;
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void a(java.io.File file, java.io.File file2) {
        java.util.zip.ZipOutputStream zipOutputStream;
        java.util.zip.ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(file, false));
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                a(zipOutputStream, file2, null, null);
                a(zipOutputStream);
            } catch (java.io.FileNotFoundException unused) {
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
            } catch (java.io.IOException e) {
                e = e;
                zipOutputStream2 = zipOutputStream;
                com.xiaomi.channel.commonutils.logger.b.a("zip file failure + " + e.getMessage());
                a(zipOutputStream2);
            } catch (java.lang.Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
                throw th;
            }
        } catch (java.io.FileNotFoundException unused2) {
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }

    public static void a(java.io.File file, java.lang.String str) {
        java.io.BufferedWriter bufferedWriter;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        java.io.BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file)));
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str);
            a(bufferedWriter);
        } catch (java.io.IOException e2) {
            e = e2;
            bufferedWriter2 = bufferedWriter;
            com.xiaomi.channel.commonutils.logger.b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a(bufferedWriter2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            a(bufferedWriter2);
            throw th;
        }
    }

    private static void a(java.util.zip.ZipOutputStream zipOutputStream, java.io.File file, java.lang.String str, java.io.FileFilter fileFilter) {
        java.lang.String str2 = "";
        if (str == null) {
            str = "";
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                if (file.isDirectory()) {
                    java.io.File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str);
                    java.lang.String str3 = java.io.File.separator;
                    sb.append(str3);
                    zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(sb.toString()));
                    if (!android.text.TextUtils.isEmpty(str)) {
                        str2 = str + str3;
                    }
                    for (int i = 0; i < listFiles.length; i++) {
                        a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                    }
                    java.io.File[] listFiles2 = file.listFiles(new com.xiaomi.push.d());
                    if (listFiles2 != null) {
                        for (java.io.File file2 : listFiles2) {
                            a(zipOutputStream, file2, str2 + java.io.File.separator + file2.getName(), fileFilter);
                        }
                    }
                } else {
                    zipOutputStream.putNextEntry(android.text.TextUtils.isEmpty(str) ? new java.util.zip.ZipEntry(java.lang.String.valueOf(new java.util.Date().getTime()) + ".txt") : new java.util.zip.ZipEntry(str));
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream = fileInputStream2;
                    } catch (java.io.IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.d("zipFiction failed with exception:" + e.toString());
                        a(fileInputStream);
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        throw th;
                    }
                }
                a(fileInputStream);
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (java.lang.Exception unused) {
            return bArr;
        }
    }

    public static void b(java.io.File file, java.io.File file2) {
        java.io.FileOutputStream fileOutputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read < 0) {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean b(java.io.File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            java.io.File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
