package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class FileUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final java.lang.String TAG = "FileUtils";

    public interface FileKeepRule {
        boolean needKept(java.lang.String str);
    }

    private static void closeIO(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean copyFile(java.io.InputStream inputStream, java.io.FileOutputStream fileOutputStream) {
        try {
            try {
                byte[] bArr = new byte[1444];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
                inputStream.close();
                return true;
            } catch (java.lang.Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
            if (inputStream == null) {
                return false;
            }
            inputStream.close();
            return false;
        }
    }

    private static boolean copyTo(java.io.File file, java.io.InputStream inputStream) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    closeIO(fileOutputStream);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "copyTo exception: output = " + file, e);
            closeIO(fileOutputStream2);
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            closeIO(fileOutputStream2);
            throw th;
        }
    }

    public static boolean decompress(java.lang.String str, java.lang.String str2) {
        java.util.zip.ZipInputStream zipInputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                java.util.zip.ZipInputStream zipInputStream2 = new java.util.zip.ZipInputStream(new java.io.FileInputStream(new java.io.File(str)));
                boolean z = true;
                while (true) {
                    try {
                        java.util.zip.ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            closeIO(zipInputStream2);
                            return z;
                        }
                        if (!android.text.TextUtils.isEmpty(nextEntry.getName()) && nextEntry.getName().contains("../")) {
                            com.alimm.tanx.core.utils.LogUtils.e("decompress", "发现不安全的zip文件解压路径！");
                            closeIO(zipInputStream2);
                            return false;
                        }
                        java.lang.String joinPath = joinPath(str2, nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            mkdir(joinPath);
                        } else {
                            z &= copyTo(new java.io.File(joinPath), zipInputStream2);
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        com.alimm.tanx.core.utils.LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void delete(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            deleteFile(new java.io.File(str));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpiredFile(java.io.File file, int i, com.alimm.tanx.core.utils.FileUtils.FileKeepRule fileKeepRule) {
        if (file != null) {
            try {
                if (!file.exists() || java.lang.System.currentTimeMillis() - file.lastModified() <= java.util.concurrent.TimeUnit.DAYS.toMillis(i)) {
                    return;
                }
                if (fileKeepRule == null || !fileKeepRule.needKept(file.getName())) {
                    com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                    deleteFile(file);
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
            }
        }
    }

    public static void deleteExpiredFile(java.lang.String str, int i, com.alimm.tanx.core.utils.FileUtils.FileKeepRule fileKeepRule) {
        java.io.File[] listFiles;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.io.File file = new java.io.File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (java.io.File file2 : listFiles) {
                    deleteExpiredFile(file2, i, fileKeepRule);
                }
            }
            deleteExpiredFile(new java.io.File(str), i, fileKeepRule);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public static void deleteExpiredFiles(java.lang.String str, int i, com.alimm.tanx.core.utils.FileUtils.FileKeepRule fileKeepRule) {
        try {
            java.util.List<java.io.File> files = getFiles(str);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i);
            if (files == null || files.size() <= 0) {
                return;
            }
            java.util.Iterator<java.io.File> it = files.iterator();
            while (it.hasNext()) {
                deleteExpiredFile(it.next(), i, fileKeepRule);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "deleteExpiredFiles: exception.", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteExpiredFiles: exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    public static synchronized boolean deleteFile(java.io.File file) {
        java.io.File[] listFiles;
        synchronized (com.alimm.tanx.core.utils.FileUtils.class) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (java.io.File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
    }

    private static boolean ensureFileExists(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return true;
        }
        try {
            java.io.File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (java.io.IOException | java.lang.SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exists(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return new java.io.File(str).exists();
        } catch (java.lang.SecurityException e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "call exists failed.", e);
            return false;
        }
    }

    public static java.io.File getExternalDir(android.content.Context context, int i) {
        java.io.File file = null;
        try {
        } catch (java.lang.Throwable unused) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getExternalDir exception: type = " + i);
        }
        if (i != 0) {
            if (i == 1) {
                file = context.getExternalCacheDir();
            }
            return file;
        }
        file = context.getExternalFilesDir(null);
        return file;
    }

    public static java.util.List<java.io.File> getFiles(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    private static java.util.List<java.io.File> getFiles(java.lang.String str, java.util.List<java.io.File> list) {
        java.io.File[] listFiles;
        java.io.File file = new java.io.File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    public static synchronized java.lang.String getStrFromFile(java.io.File file) {
        synchronized (com.alimm.tanx.core.utils.FileUtils.class) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.io.FileInputStream fileInputStream = null;
            try {
                try {
                } catch (java.lang.Exception e) {
                    e = e;
                }
                if (!file.exists()) {
                    closeIO(null);
                    return null;
                }
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                try {
                    java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(fileInputStream2, java.nio.charset.StandardCharsets.UTF_8);
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    closeIO(fileInputStream2);
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    closeIO(fileInputStream);
                    return sb.toString();
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    closeIO(fileInputStream);
                    throw th;
                }
                return sb.toString();
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public static synchronized java.lang.String getStrFromFile(java.lang.String str) {
        java.lang.String str2;
        synchronized (com.alimm.tanx.core.utils.FileUtils.class) {
            java.lang.String str3 = "";
            java.io.FileInputStream fileInputStream = null;
            try {
                try {
                } catch (java.lang.Exception e) {
                    e = e;
                }
                if (!new java.io.File(str).exists()) {
                    closeIO(null);
                    return null;
                }
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
                try {
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr);
                        str2 = new java.lang.String(bArr, java.nio.charset.StandardCharsets.UTF_8);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        closeIO(fileInputStream);
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
                try {
                    fileInputStream2.close();
                    closeIO(fileInputStream2);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    str3 = str2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    closeIO(fileInputStream);
                    str2 = str3;
                    return str2;
                }
                return str2;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public static java.lang.String joinPath(java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length && !android.text.TextUtils.isEmpty(strArr[i]); i++) {
                if (i > 0) {
                    sb.append(java.io.File.separator);
                }
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static java.io.File mkdir(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.mkdirs();
            return file;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e);
            return file;
        }
    }

    public static java.lang.String readAssetFile(android.content.Context context, java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        if (context == null || str == null) {
            return "";
        }
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(context).open(str)));
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    java.lang.String sb2 = sb.toString();
                    closeIO(bufferedReader);
                    return sb2;
                }
                sb.append(readLine);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            closeIO(bufferedReader2);
            return "";
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            closeIO(bufferedReader2);
            throw th;
        }
    }

    public static java.util.List<java.lang.String> readLines(java.lang.String str) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        if (exists(str)) {
            java.io.BufferedReader bufferedReader = null;
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(str)));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            linkedList.add(readLine);
                        } catch (java.io.IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    }
                    closeIO(bufferedReader2);
                } catch (java.io.IOException e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStr2File(java.io.File file, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        synchronized (com.alimm.tanx.core.utils.FileUtils.class) {
            boolean z = false;
            if (file == null) {
                return false;
            }
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                closeIO(fileOutputStream);
                z = true;
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "saveStrToFile ", e);
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                e.printStackTrace();
                closeIO(fileOutputStream2);
                return z;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                closeIO(fileOutputStream2);
                throw th;
            }
            return z;
        }
    }

    public static synchronized boolean saveStr2File(java.lang.String str, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        synchronized (com.alimm.tanx.core.utils.FileUtils.class) {
            boolean z = false;
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                return false;
            }
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    java.io.File file = new java.io.File(str);
                    if (!file.exists()) {
                        new java.io.File(file.getParent()).mkdirs();
                        file.createNewFile();
                    }
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
                closeIO(fileOutputStream);
                z = true;
            } catch (java.lang.Exception e2) {
                fileOutputStream2 = fileOutputStream;
                e = e2;
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "saveStrToFile ", e);
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                e.printStackTrace();
                closeIO(fileOutputStream2);
                return z;
            } catch (java.lang.Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                closeIO(fileOutputStream2);
                throw th;
            }
            return z;
        }
    }

    public static boolean unZipFolder(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        if (!new java.io.File(str).exists()) {
            return false;
        }
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.FileInputStream(str));
        while (true) {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return true;
            }
            java.lang.String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                new java.io.File(str2 + java.io.File.separator + name.substring(0, name.length() - 1)).mkdirs();
            } else {
                java.io.File file = new java.io.File(str2 + java.io.File.separator + name);
                file.createNewFile();
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                fileOutputStream.close();
            }
        }
    }

    public static java.io.InputStream upZip(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void writeLine(java.lang.String str, boolean z, java.lang.String str2) {
        java.io.PrintWriter printWriter;
        if (ensureFileExists(str)) {
            java.io.PrintWriter printWriter2 = null;
            try {
                try {
                    printWriter = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(str, z)));
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.IOException e) {
                e = e;
            }
            try {
                printWriter.println(str2);
                closeIO(printWriter);
            } catch (java.io.IOException e2) {
                e = e2;
                printWriter2 = printWriter;
                e.printStackTrace();
                closeIO(printWriter2);
            } catch (java.lang.Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                closeIO(printWriter2);
                throw th;
            }
        }
    }
}
