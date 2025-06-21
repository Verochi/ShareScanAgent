package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class FileUtil {
    private static final java.util.Random a = new java.util.Random();

    public static void copy(java.io.File file, java.io.File file2) {
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        java.io.File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new java.io.File(file2, file.getName());
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            com.efs.sdk.base.core.util.Log.e("efs.util.file", "error when copy", e);
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        safeClose(fileInputStream);
                        safeClose(fileOutputStream);
                        throw th;
                    }
                }
                safeClose(fileInputStream2);
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        safeClose(fileOutputStream);
    }

    public static com.efs.sdk.base.core.model.LogDto createCodeLogDtoByName(java.lang.String str) {
        java.lang.String[] split = str.split("_");
        if (split.length != 11) {
            com.efs.sdk.base.core.util.Log.w("efs.util.file", "[code log]File name error, name is ".concat(str));
            return null;
        }
        java.lang.String str2 = split[0];
        java.lang.String str3 = split[1];
        byte byteValue = java.lang.Byte.valueOf(split[2]).byteValue();
        byte byteValue2 = java.lang.Byte.valueOf(split[3]).byteValue();
        java.lang.String str4 = split[7];
        java.lang.String str5 = split[8];
        long longValue = java.lang.Long.valueOf(split[9]).longValue();
        long longValue2 = java.lang.Long.valueOf(split[10]).longValue();
        com.efs.sdk.base.core.model.LogDto logDto = new com.efs.sdk.base.core.model.LogDto(str2, byteValue2);
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        logDto.setUid(str4);
        logDto.setDid(str5);
        logDto.setBeginTime(longValue);
        logDto.setEndTime(longValue2);
        return logDto;
    }

    public static com.efs.sdk.base.core.model.LogDto createLogDtoByName(java.lang.String str) {
        java.lang.String[] split = str.split("_");
        if (split.length != 7) {
            com.efs.sdk.base.core.util.Log.w("efs.util.file", "File name error, name is ".concat(str));
            return null;
        }
        java.lang.String str2 = split[0];
        java.lang.String str3 = split[1];
        byte byteValue = java.lang.Byte.valueOf(split[2]).byteValue();
        com.efs.sdk.base.core.model.LogDto logDto = new com.efs.sdk.base.core.model.LogDto(str2, java.lang.Byte.valueOf(split[3]).byteValue());
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        return logDto;
    }

    public static void delete(java.io.File file) {
        java.io.File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (java.io.File file2 : listFiles) {
                delete(file2);
            }
        }
        file.delete();
    }

    public static java.lang.String getCodelogFileName(com.efs.sdk.base.core.model.LogDto logDto) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append((int) logDto.getLogProtocol());
        sb.append("_");
        sb.append(com.efs.sdk.base.core.util.ProcessUtil.myPid());
        sb.append("_");
        sb.append(a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        sb.append("_");
        sb.append(logDto.getUid());
        sb.append("_");
        sb.append(logDto.getDid());
        sb.append("_");
        sb.append(logDto.getBeginTime());
        sb.append("_");
        sb.append(logDto.getEndTime());
        return sb.toString();
    }

    public static java.lang.String getFileName(com.efs.sdk.base.core.model.LogDto logDto) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append((int) logDto.getLogProtocol());
        sb.append("_");
        sb.append(com.efs.sdk.base.core.util.ProcessUtil.myPid());
        sb.append("_");
        sb.append(a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        return sb.toString();
    }

    public static long getFolderSize(java.io.File file) {
        long j = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        for (java.io.File file2 : listFiles) {
            j += getFolderSize(file2);
        }
        return j;
    }

    public static java.util.List<java.io.File> listFiles(java.io.File file) {
        if (file.isFile()) {
            return java.util.Collections.emptyList();
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.io.File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
                com.efs.sdk.base.core.util.Log.i("efs.util.file", "file is " + file2.getName());
            } else {
                arrayList.addAll(listFiles(file2));
            }
        }
        return arrayList;
    }

    public static void move(java.io.File file, java.io.File file2) {
        copy(file, file2);
        delete(file);
    }

    public static java.lang.String read(java.io.File file) {
        return read(file, 1024);
    }

    public static java.lang.String read(java.io.File file, int i) {
        java.io.FileInputStream fileInputStream;
        java.lang.String str = "";
        if (!file.exists()) {
            return "";
        }
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[i];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb.append(new java.lang.String(bArr, 0, read));
            }
            str = sb.toString();
            safeClose(fileInputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                com.efs.sdk.base.core.util.Log.e("efs.util.file", "read file error", th);
                return str;
            } finally {
                safeClose(fileInputStream2);
            }
        }
        return str;
    }

    public static byte[] read(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            safeClose(fileInputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            com.efs.sdk.base.core.util.Log.e("efs.util.file", "read data error", e);
            safeClose(fileInputStream2);
            return bArr;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            safeClose(fileInputStream2);
            throw th;
        }
        return bArr;
    }

    public static void safeClose(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable th) {
                com.efs.sdk.base.core.util.Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean write(java.io.File file, java.lang.String str) {
        return write(file, str.getBytes());
    }

    public static boolean write(java.io.File file, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                safeClose(fileOutputStream2);
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    com.efs.sdk.base.core.util.Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    safeClose(fileOutputStream);
                    return false;
                } catch (java.lang.Throwable th2) {
                    safeClose(fileOutputStream);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static boolean write(java.lang.String str, byte[] bArr) {
        return write(new java.io.File(str), bArr);
    }
}
