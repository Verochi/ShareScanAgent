package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class g {
    static java.lang.String a = null;
    static java.lang.String b = null;
    static int c = 8192;

    public static java.lang.String a(android.content.Context context) {
        java.io.File parentFile;
        if (a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            a = parentFile.getAbsolutePath();
        }
        return a;
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void a(java.io.File file) {
        java.io.File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (java.io.File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        if (inputStream == null) {
            return;
        }
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    bufferedOutputStream.flush();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    public static void a(java.io.RandomAccessFile randomAccessFile, java.io.RandomAccessFile randomAccessFile2, long j, long j2, java.lang.String str) {
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            throw new java.io.IOException("invalid offsets  ".concat(java.lang.String.valueOf(str)));
        }
        if (j == j2) {
            return;
        }
        randomAccessFile.seek(j);
        long j4 = j2 - j;
        int i = c;
        byte[] bArr = j4 < ((long) i) ? new byte[(int) j4] : new byte[i];
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j3 += read;
            if (j3 == j4) {
                return;
            }
            if (bArr.length + j3 > j4) {
                bArr = new byte[(int) (j4 - j3)];
            }
        }
    }

    public static void a(java.lang.String str) {
        a(new java.io.File(str));
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(str2);
        if (!file.exists()) {
            throw new java.lang.Exception("文件夹不存在");
        }
        if (!file.isDirectory()) {
            throw new java.lang.Exception("源文件夹不是目录");
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file2.isDirectory()) {
            throw new java.lang.Exception("目标文件夹不是目录");
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (java.io.File file3 : listFiles) {
            java.lang.String str3 = file2 + java.io.File.separator + file3.getName();
            if (file3.isDirectory()) {
                a(file3.getAbsolutePath(), str3);
            } else if (!new java.io.File(str3).exists()) {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file3));
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(str3));
                byte[] bArr = new byte[c];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.close();
                bufferedInputStream.close();
            }
        }
    }

    public static void a(java.util.zip.ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static java.lang.String b(android.content.Context context) {
        java.io.File parentFile;
        if (b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                b = parentFile.getCanonicalPath();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        java.util.zip.ZipInputStream zipInputStream;
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(str)));
            while (true) {
                try {
                    java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        return;
                    }
                    java.lang.String name = nextEntry.getName();
                    if (!name.contains("..")) {
                        if (nextEntry.isDirectory()) {
                            new java.io.File(str2 + java.io.File.separator + name).mkdirs();
                        } else {
                            java.io.File file = new java.io.File(str2 + java.io.File.separator + name);
                            if (file.exists()) {
                                file.delete();
                            } else {
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (java.lang.Exception e) {
                                e = e;
                                bufferedOutputStream = bufferedOutputStream2;
                                a(bufferedOutputStream);
                                a(zipInputStream);
                                throw e;
                            }
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            zipInputStream = null;
        }
    }

    public static boolean b(java.io.File file) {
        java.io.FileInputStream fileInputStream = null;
        if (file == null) {
            a((java.io.Closeable) null);
            return false;
        }
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[6];
                if (fileInputStream2.read(bArr) != 6) {
                    a(fileInputStream2);
                    return false;
                }
                byte[] bArr2 = {80, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 3, 4};
                for (int i = 0; i < 4; i++) {
                    if (bArr2[i] != bArr[i]) {
                        a(fileInputStream2);
                        return false;
                    }
                }
                byte b2 = bArr[4];
                if (b2 == 0 && bArr[5] == 0) {
                    a(fileInputStream2);
                    return false;
                }
                if (b2 == 20) {
                    if (bArr[5] == 3) {
                        a(fileInputStream2);
                        return true;
                    }
                }
                a(fileInputStream2);
                return false;
            } catch (java.lang.Throwable unused) {
                fileInputStream = fileInputStream2;
                a(fileInputStream);
                return false;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }
}
