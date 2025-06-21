package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final java.lang.String FILE_PATH_ENTRY_BACK = "..";
    private static final java.lang.String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final java.lang.String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final java.lang.String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    public static boolean checkCanWrite(java.io.File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        java.io.File file2 = new java.io.File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(java.lang.String str, java.lang.String str2) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
            safelyCloseFile(gZIPOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            gZIPOutputStream2 = gZIPOutputStream;
            e.getMessage();
            safelyCloseFile(gZIPOutputStream2);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            safelyCloseFile(gZIPOutputStream2);
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] compress(byte[] bArr) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            safelyCloseFile(gZIPOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            gZIPOutputStream2 = gZIPOutputStream;
            e.getMessage();
            safelyCloseFile(gZIPOutputStream2);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            safelyCloseFile(gZIPOutputStream2);
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void createNoMediaFileIfNotExist(java.lang.String str) {
    }

    private static void decompress(java.io.File file, java.io.File file2, java.util.zip.ZipInputStream zipInputStream, long j, com.autonavi.base.amap.mapcore.FileUtil.ZipCompressProgressListener zipCompressProgressListener, com.autonavi.base.amap.mapcore.FileUtil.UnZipFileBrake unZipFileBrake) throws java.lang.Exception {
        boolean z = false;
        int i = 0;
        while (true) {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                zipInputStream.closeEntry();
                return;
            }
            java.lang.String name = nextEntry.getName();
            if (android.text.TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                break;
            }
            java.io.File file3 = new java.io.File(file2.getPath() + java.io.File.separator + name);
            fileProber(file3);
            if (nextEntry.isDirectory()) {
                file3.mkdirs();
            } else {
                i += decompressFile(file3, zipInputStream, i, j, zipCompressProgressListener, unZipFileBrake);
            }
            zipInputStream.closeEntry();
        }
        z = true;
        if (!z || file == null) {
            return;
        }
        try {
            file.delete();
        } catch (java.lang.Exception unused) {
        }
    }

    public static void decompress(java.io.InputStream inputStream, java.lang.String str) throws java.lang.Exception {
        decompress(inputStream, str, 0L, null);
    }

    private static void decompress(java.io.InputStream inputStream, java.lang.String str, long j, com.autonavi.base.amap.mapcore.FileUtil.ZipCompressProgressListener zipCompressProgressListener) throws java.lang.Exception {
        java.util.zip.CheckedInputStream checkedInputStream = new java.util.zip.CheckedInputStream(inputStream, new java.util.zip.CRC32());
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(checkedInputStream);
        decompress(null, new java.io.File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static int decompressFile(java.io.File file, java.util.zip.ZipInputStream zipInputStream, long j, long j2, com.autonavi.base.amap.mapcore.FileUtil.ZipCompressProgressListener zipCompressProgressListener, com.autonavi.base.amap.mapcore.FileUtil.UnZipFileBrake unZipFileBrake) throws java.lang.Exception {
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                bufferedOutputStream.close();
                return i;
            }
            bufferedOutputStream.write(bArr, 0, read);
            i += read;
            if (j2 > 0 && zipCompressProgressListener != null) {
                long j3 = ((i + j) * 100) / j2;
                if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                    zipCompressProgressListener.onFinishProgress(j3);
                }
            }
        }
    }

    public static boolean deleteFile(java.io.File file) {
        java.io.File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else {
                    if (!deleteFile(listFiles[i])) {
                        return false;
                    }
                    listFiles[i].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        fileProber(parentFile);
        parentFile.mkdir();
    }

    public static java.lang.String getExternalStroragePath(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir("").getAbsolutePath() + java.io.File.separatorChar;
    }

    public static java.lang.String getMapBaseStorage(android.content.Context context) {
        java.lang.String str = null;
        if (context == null) {
            return null;
        }
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        java.lang.String str2 = com.amap.api.maps.MapsInitializer.sdcardDir;
        if (str2 == null || str2.trim().length() <= 0) {
            java.lang.String string = sharedPreferences.getString("map_base_path_v44", "");
            java.lang.String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        } else {
            str = com.amap.api.maps.MapsInitializer.sdcardDir + java.io.File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                java.lang.String str3 = context.getCacheDir().toString() + com.autonavi.base.amap.mapcore.AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    java.io.File file2 = new java.io.File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        java.lang.String str4 = getExternalStroragePath(context) + com.autonavi.base.amap.mapcore.AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            java.io.File file3 = new java.io.File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("map_base_path_v44", str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        java.lang.String str5 = context.getCacheDir().toString() + com.autonavi.base.amap.mapcore.AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            java.io.File file4 = new java.io.File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str5;
    }

    public static java.lang.String getName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static java.io.InputStream getZipInputStream(byte[] bArr) throws java.io.IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new java.util.zip.GZIPInputStream(byteArrayInputStream) : new java.util.zip.ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(java.lang.String str) {
        if (str == null) {
            return -1;
        }
        return java.lang.Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(java.lang.String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains(FILE_PATH_ENTRY_SEPARATOR1) || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (java.io.IOException e) {
                    throw e;
                }
            } finally {
                safelyCloseFile(byteArrayOutputStream);
            }
        }
    }

    public static byte[] readFileContents(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                safelyCloseFile((java.io.OutputStream) null);
                safelyCloseFile((java.io.InputStream) null);
                return null;
            }
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            com.amap.api.mapcore.util.gd.c(th, TAG, "readFileContents");
                            com.amap.api.mapcore.util.dl.a(th);
                            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read file from disk failed " + th.getMessage());
                            return null;
                        } finally {
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readFileContentsFromAssets(android.content.Context context, java.lang.String str) {
        java.io.InputStream inputStream;
        android.content.res.AssetManager assets = context.getAssets();
        ?? r1 = 0;
        try {
            try {
                inputStream = assets.open(str);
                try {
                    int available = inputStream.available();
                    if (available == 0) {
                        safelyCloseFile(inputStream);
                        return null;
                    }
                    byte[] bArr = new byte[available];
                    for (int i = 0; i < available; i += inputStream.read(bArr, i, available - i)) {
                    }
                    safelyCloseFile(inputStream);
                    return bArr;
                } catch (java.io.IOException e) {
                    e = e;
                    com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                } catch (java.lang.OutOfMemoryError e2) {
                    e = e2;
                    com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r1 = assets;
                safelyCloseFile((java.io.InputStream) r1);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            inputStream = null;
        } catch (java.lang.OutOfMemoryError e4) {
            e = e4;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            safelyCloseFile((java.io.InputStream) r1);
            throw th;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                java.lang.String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                for (java.lang.String str3 : list) {
                    if (str3 != null && str3.contains(str2)) {
                        return readFileContentsFromAssets(context, str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3);
                    }
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof java.util.zip.ZipInputStream) {
                    ((java.util.zip.ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static void safelyCloseFile(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void saveFileContents(java.lang.String str, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(str));
            try {
                fileOutputStream2.write(bArr);
                safelyCloseFile(fileOutputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    com.amap.api.mapcore.util.gd.c(th, TAG, "saveFileContents");
                    com.amap.api.mapcore.util.dl.a(th);
                    com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "save file from disk failed " + th.getMessage());
                } finally {
                    safelyCloseFile(fileOutputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        java.io.InputStream inputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read < 0) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.getMessage();
                        return null;
                    } finally {
                        safelyCloseFile(inputStream);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
        return null;
    }

    public static android.util.Pair<java.lang.String, byte[]> uncompressToByte(byte[] bArr) {
        java.io.InputStream inputStream;
        java.lang.String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            try {
                if (inputStream instanceof java.util.zip.ZipInputStream) {
                    str = ((java.util.zip.ZipInputStream) inputStream).getNextEntry().getName();
                    if (!isSafeEntryName(str)) {
                        "gzip name contains ../ ".concat(java.lang.String.valueOf(str));
                        return null;
                    }
                } else {
                    str = "";
                }
                if (inputStream != null) {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read < 0) {
                            return new android.util.Pair<>(str, byteArrayOutputStream.toByteArray());
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    th.getMessage();
                    return null;
                } finally {
                    safelyCloseFile(inputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
        return null;
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.amap.api.mapcore.util.dl.a(th);
                    th.printStackTrace();
                    return null;
                } finally {
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(byteArrayOutputStream);
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(byteArrayInputStream);
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    public static java.util.Map<java.lang.String, byte[]> uncompressToByteWithKeys(byte[] bArr, java.lang.String[] strArr) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (bArr == null || bArr.length == 0) {
            return hashMap;
        }
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream zipInputStream = getZipInputStream(bArr);
            try {
                if (zipInputStream instanceof java.util.zip.ZipInputStream) {
                    java.util.zip.ZipInputStream zipInputStream2 = (java.util.zip.ZipInputStream) zipInputStream;
                    while (true) {
                        java.util.zip.ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            try {
                                java.lang.String name = nextEntry.getName();
                                if (!isSafeEntryName(name)) {
                                    "gzip name contains ../ ".concat(java.lang.String.valueOf(name));
                                    safelyCloseFile(zipInputStream);
                                    return null;
                                }
                                if (strArr == null) {
                                    byte[] readByteByStream = readByteByStream(zipInputStream2);
                                    if (readByteByStream != null) {
                                        hashMap.put(name, readByteByStream);
                                    }
                                } else {
                                    int length = strArr.length;
                                    int i = 0;
                                    while (true) {
                                        if (i < length) {
                                            java.lang.String str = strArr[i];
                                            if (name.equals(str)) {
                                                byte[] readByteByStream2 = readByteByStream(zipInputStream2);
                                                if (readByteByStream2 != null) {
                                                    hashMap.put(str, readByteByStream2);
                                                }
                                            } else {
                                                i++;
                                            }
                                        }
                                    }
                                }
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                safelyCloseFile(zipInputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = zipInputStream;
                try {
                    th.getMessage();
                    return hashMap;
                } finally {
                    safelyCloseFile(inputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return hashMap;
    }

    public static java.lang.String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static java.lang.String uncompressToString(byte[] bArr, java.lang.String str) {
        java.io.InputStream inputStream;
        ?? r0 = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                inputStream = getZipInputStream(bArr);
                if (inputStream != null) {
                    try {
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read < 0) {
                                java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                                safelyCloseFile(inputStream);
                                return byteArrayOutputStream2;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                        e.getMessage();
                        safelyCloseFile(inputStream);
                        return null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r0 = bArr;
                safelyCloseFile((java.io.InputStream) r0);
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            safelyCloseFile((java.io.InputStream) r0);
            throw th;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    public static void writeDatasToFile(java.lang.String str, byte[] bArr) {
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        java.io.FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                try {
                    if (bArr.length != 0) {
                        java.io.File file = new java.io.File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream2);
                            return;
                        } catch (java.lang.Exception e) {
                            fileOutputStream = fileOutputStream2;
                            e = e;
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (java.lang.Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
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
        writeLock.unlock();
        safelyCloseFile((java.io.OutputStream) null);
    }
}
