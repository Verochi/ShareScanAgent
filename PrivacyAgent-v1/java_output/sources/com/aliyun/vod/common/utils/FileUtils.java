package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class FileUtils {
    public static final java.io.File[] EMPTY_FILE_ARRAY;
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final double GB = 1.073741824E9d;
    public static final double KB = 1024.0d;
    public static final double MB = 1048576.0d;
    public static final long ONE_EB = 1152921504606846976L;
    public static final java.math.BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final java.math.BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final java.math.BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final java.math.BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final java.math.BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final java.math.BigInteger ONE_TB_BI;
    public static final java.math.BigInteger ONE_YB;
    public static final java.math.BigInteger ONE_ZB;
    private static final java.nio.charset.Charset UTF8;

    public static class FileExistsException extends java.io.IOException {
        private static final long serialVersionUID = 1;

        public FileExistsException() {
        }

        public FileExistsException(java.io.File file) {
            super("File " + file + " exists");
        }

        public FileExistsException(java.lang.String str) {
            super(str);
        }
    }

    static {
        java.math.BigInteger valueOf = java.math.BigInteger.valueOf(1024L);
        ONE_KB_BI = valueOf;
        java.math.BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        java.math.BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        java.math.BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        java.math.BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        java.math.BigInteger multiply5 = java.math.BigInteger.valueOf(1024L).multiply(java.math.BigInteger.valueOf(1152921504606846976L));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
        EMPTY_FILE_ARRAY = new java.io.File[0];
        UTF8 = java.nio.charset.Charset.forName("UTF-8");
    }

    public static java.lang.String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(java.math.BigInteger.valueOf(j));
    }

    public static java.lang.String byteCountToDisplaySize(java.math.BigInteger bigInteger) {
        java.math.BigInteger bigInteger2 = ONE_EB_BI;
        java.math.BigInteger divide = bigInteger.divide(bigInteger2);
        java.math.BigInteger bigInteger3 = java.math.BigInteger.ZERO;
        if (divide.compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger2)) + " EB";
        }
        java.math.BigInteger bigInteger4 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger4)) + " PB";
        }
        java.math.BigInteger bigInteger5 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger5)) + " TB";
        }
        java.math.BigInteger bigInteger6 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger6)) + " GB";
        }
        java.math.BigInteger bigInteger7 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger7)) + " MB";
        }
        java.math.BigInteger bigInteger8 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) > 0) {
            return java.lang.String.valueOf(bigInteger.divide(bigInteger8)) + " KB";
        }
        return java.lang.String.valueOf(bigInteger) + " bytes";
    }

    private static void checkDirectory(java.io.File file) {
        if (!file.exists()) {
            throw new java.lang.IllegalArgumentException(file + " does not exist");
        }
        if (file.isDirectory()) {
            return;
        }
        throw new java.lang.IllegalArgumentException(file + " is not a directory");
    }

    public static void cleanDirectory(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            throw new java.lang.IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new java.lang.IllegalArgumentException(file + " is not a directory");
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("Failed to list contents of " + file);
        }
        java.io.IOException e = null;
        for (java.io.File file2 : listFiles) {
            try {
                forceDelete(file2);
            } catch (java.io.IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static void cleanDirectoryOnExit(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            throw new java.lang.IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new java.lang.IllegalArgumentException(file + " is not a directory");
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("Failed to list contents of " + file);
        }
        java.io.IOException e = null;
        for (java.io.File file2 : listFiles) {
            try {
                forceDeleteOnExit(file2);
            } catch (java.io.IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void clearDirectory(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteDirectory(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static boolean contentEquals(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new java.io.IOException("Can't compare directories, only files");
        }
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        java.io.FileInputStream fileInputStream3 = null;
        try {
            fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileInputStream = new java.io.FileInputStream(file2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            boolean contentEquals = com.aliyun.vod.common.utils.IOUtils.contentEquals(fileInputStream2, fileInputStream);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream2);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
            return contentEquals;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream3 = fileInputStream2;
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream3);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
            throw th;
        }
    }

    public static boolean contentEqualsIgnoreEOL(java.io.File file, java.io.File file2, java.lang.String str) throws java.io.IOException {
        java.io.InputStreamReader inputStreamReader;
        java.io.InputStreamReader inputStreamReader2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new java.io.IOException("Can't compare directories, only files");
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        java.io.InputStreamReader inputStreamReader3 = null;
        try {
            if (str == null) {
                java.io.InputStreamReader inputStreamReader4 = new java.io.InputStreamReader(new java.io.FileInputStream(file));
                try {
                    inputStreamReader2 = new java.io.InputStreamReader(new java.io.FileInputStream(file2));
                    inputStreamReader3 = inputStreamReader4;
                } catch (java.lang.Throwable th) {
                    th = th;
                    inputStreamReader = null;
                    inputStreamReader3 = inputStreamReader4;
                    com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader3);
                    com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                    throw th;
                }
            } else {
                java.io.InputStreamReader inputStreamReader5 = new java.io.InputStreamReader(new java.io.FileInputStream(file), str);
                try {
                    inputStreamReader2 = new java.io.InputStreamReader(new java.io.FileInputStream(file2), str);
                    inputStreamReader3 = inputStreamReader5;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    inputStreamReader = null;
                    inputStreamReader3 = inputStreamReader5;
                    com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader3);
                    com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
                    throw th;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStreamReader = inputStreamReader3;
        }
        try {
            boolean contentEqualsIgnoreEOL = com.aliyun.vod.common.utils.IOUtils.contentEqualsIgnoreEOL(inputStreamReader3, inputStreamReader2);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader3);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader2);
            return contentEqualsIgnoreEOL;
        } catch (java.lang.Throwable th4) {
            inputStreamReader = inputStreamReader2;
            th = th4;
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader3);
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.Reader) inputStreamReader);
            throw th;
        }
    }

    public static java.io.File[] convertFileCollectionToFileArray(java.util.Collection<java.io.File> collection) {
        return (java.io.File[]) collection.toArray(new java.io.File[collection.size()]);
    }

    public static void copyDirectory(java.io.File file, java.io.File file2) throws java.io.IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter) throws java.io.IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter, boolean z) throws java.io.IOException {
        java.util.ArrayList arrayList;
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new java.io.IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new java.io.IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            java.io.File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (listFiles != null && listFiles.length > 0) {
                arrayList = new java.util.ArrayList(listFiles.length);
                for (java.io.File file3 : listFiles) {
                    arrayList.add(new java.io.File(file2, file3.getName()).getCanonicalPath());
                }
                doCopyDirectory(file, file2, fileFilter, z, arrayList);
            }
        }
        arrayList = null;
        doCopyDirectory(file, file2, fileFilter, z, arrayList);
    }

    public static void copyDirectory(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        copyDirectory(file, file2, null, z);
    }

    public static void copyDirectoryToDirectory(java.io.File file, java.io.File file2) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file.exists() && !file.isDirectory()) {
            throw new java.lang.IllegalArgumentException("Source '" + file2 + "' is not a directory");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file2.exists() || file2.isDirectory()) {
            copyDirectory(file, new java.io.File(file2, file.getName()), true);
            return;
        }
        throw new java.lang.IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static long copyFile(java.io.File file, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            return com.aliyun.vod.common.utils.IOUtils.copyLarge(fileInputStream, outputStream);
        } finally {
            fileInputStream.close();
        }
    }

    public static void copyFile(java.io.File file, java.io.File file2) throws java.io.IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new java.io.IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new java.io.IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        java.io.File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new java.io.IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            doCopyFile(file, file2, z);
            return;
        }
        throw new java.io.IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static void copyFileToDirectory(java.io.File file, java.io.File file2) throws java.io.IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file2.exists() || file2.isDirectory()) {
            copyFile(file, new java.io.File(file2, file.getName()), z);
            return;
        }
        throw new java.lang.IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static void copyInputStreamToFile(java.io.InputStream inputStream, java.io.File file) throws java.io.IOException {
        try {
            java.io.FileOutputStream openOutputStream = openOutputStream(file);
            try {
                com.aliyun.vod.common.utils.IOUtils.copy(inputStream, openOutputStream);
                openOutputStream.close();
            } finally {
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) openOutputStream);
            }
        } finally {
            com.aliyun.vod.common.utils.IOUtils.closeQuietly(inputStream);
        }
    }

    public static void copyURLToFile(java.net.URL url, java.io.File file) throws java.io.IOException {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(java.net.URL url, java.io.File file, int i, int i2) throws java.io.IOException {
        java.net.URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i);
        openConnection.setReadTimeout(i2);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    public static java.lang.String decodeUrl(java.lang.String str) {
        int i;
        if (str == null || str.indexOf(37) < 0) {
            return str;
        }
        int length = str.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(length);
        int i2 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == '%') {
                while (true) {
                    i = i2 + 3;
                    try {
                        try {
                            allocate.put((byte) java.lang.Integer.parseInt(str.substring(i2 + 1, i), 16));
                            if (i >= length) {
                                break;
                            }
                            try {
                                if (str.charAt(i) != '%') {
                                    break;
                                }
                                i2 = i;
                            } catch (java.lang.RuntimeException unused) {
                                i2 = i;
                                if (allocate.position() > 0) {
                                    allocate.flip();
                                    stringBuffer.append(UTF8.decode(allocate).toString());
                                    allocate.clear();
                                }
                                stringBuffer.append(str.charAt(i2));
                                i2++;
                            }
                        } catch (java.lang.RuntimeException unused2) {
                        }
                    } finally {
                        if (allocate.position() > 0) {
                            allocate.flip();
                            stringBuffer.append(UTF8.decode(allocate).toString());
                            allocate.clear();
                        }
                    }
                }
                i2 = i;
            }
            stringBuffer.append(str.charAt(i2));
            i2++;
        }
        return stringBuffer.toString();
    }

    public static boolean deleteDirectory(java.io.File file) {
        clearDirectory(file);
        return file.delete();
    }

    private static void deleteDirectoryOnExit(java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (isSymlink(file)) {
                return;
            }
            cleanDirectoryOnExit(file);
        }
    }

    public static boolean deleteFD(java.io.File file) {
        if (file.exists()) {
            return file.isDirectory() ? deleteDirectory(file) : file.delete();
        }
        return false;
    }

    public static boolean deleteFD(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(file.getAbsolutePath() + java.lang.System.currentTimeMillis());
        file.renameTo(file2);
        return deleteFD(file2);
    }

    public static boolean deleteFile(java.io.File file) {
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean deleteFile(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean deleteQuietly(java.io.File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            return file.delete();
        } catch (java.lang.Exception unused2) {
            return false;
        }
    }

    private static void doCopyDirectory(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter, boolean z, java.util.List<java.lang.String> list) throws java.io.IOException {
        java.io.File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new java.io.IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new java.io.IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new java.io.IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new java.io.IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (java.io.File file3 : listFiles) {
            java.io.File file4 = new java.io.File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, z, list);
                } else {
                    doCopyFile(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream, java.io.OutputStream] */
    private static void doCopyFile(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        ?? r4;
        java.nio.channels.FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new java.io.IOException("Destination '" + file2 + "' exists but is a directory");
        }
        java.nio.channels.FileChannel fileChannel2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                r4 = new java.io.FileOutputStream(file2);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        fileChannel2 = r4.getChannel();
                        long size = fileChannel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            j += fileChannel2.transferFrom(fileChannel, j, j2 > FILE_COPY_BUFFER_SIZE ? 31457280L : j2);
                        }
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel2);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                        if (file.length() == file2.length()) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                            }
                        } else {
                            throw new java.io.IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel2);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel);
                        com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                r4 = 0;
                fileChannel = r4;
                com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel2);
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                com.aliyun.vod.common.utils.IOUtils.closeQuietly(fileChannel);
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileInputStream = null;
            r4 = 0;
        }
    }

    public static void forceDelete(java.io.File file) throws java.io.IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (exists) {
            throw new java.io.IOException("Unable to delete file: " + file);
        }
        throw new java.io.FileNotFoundException("File does not exist: " + file);
    }

    public static void forceDeleteOnExit(java.io.File file) throws java.io.IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            if (file.mkdirs() || file.isDirectory()) {
                return;
            }
            throw new java.io.IOException("Unable to create directory " + file);
        }
        if (file.isDirectory()) {
            return;
        }
        throw new java.io.IOException("File " + file + " exists and is not a directory. Unable to create directory.");
    }

    public static java.io.File getApplicationSdcardPath(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MOVIES);
        return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
    }

    public static android.graphics.BitmapFactory.Options getDropboxIMGSize(android.net.Uri uri) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(new java.io.File(uri.getPath()).getAbsolutePath(), options);
        return options;
    }

    public static java.io.File getFile(java.io.File file, java.lang.String... strArr) {
        if (file == null) {
            throw new java.lang.NullPointerException("directorydirectory must not be null");
        }
        if (strArr == null) {
            throw new java.lang.NullPointerException("names must not be null");
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            java.io.File file2 = new java.io.File(file, strArr[i]);
            i++;
            file = file2;
        }
        return file;
    }

    public static java.io.File getFile(java.lang.String... strArr) {
        if (strArr == null) {
            throw new java.lang.NullPointerException("names must not be null");
        }
        java.io.File file = null;
        for (java.lang.String str : strArr) {
            file = file == null ? new java.io.File(str) : new java.io.File(file, str);
        }
        return file;
    }

    public static java.io.InputStream getFileInputStream(android.content.Context context, java.lang.String str) {
        try {
            return com.aliyun.vod.common.utils.StringUtils.isUriPath(str) ? context.getContentResolver().openInputStream(android.net.Uri.parse(str)) : new java.io.FileInputStream(new java.io.File(str));
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getFileLength(android.content.Context context, java.lang.String str) {
        return com.aliyun.vod.common.utils.StringUtils.isUriPath(str) ? getFileLengthByUri(context, android.net.Uri.parse(str)) : new java.io.File(str).length();
    }

    public static long getFileLengthByUri(android.content.Context context, android.net.Uri uri) {
        if (context == null || uri == null) {
            return 0L;
        }
        android.database.Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        query.moveToFirst();
        return query.getLong(query.getColumnIndex("_size"));
    }

    public static java.lang.String getFileName(android.content.Context context, java.lang.String str) {
        return com.aliyun.vod.common.utils.StringUtils.isUriPath(str) ? getFileNameByUri(context, android.net.Uri.parse(str)) : new java.io.File(str).getName();
    }

    public static java.lang.String getFileNameByUri(android.content.Context context, android.net.Uri uri) {
        if (context == null || uri == null) {
            return "";
        }
        android.database.Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        query.moveToFirst();
        return query.getString(query.getColumnIndex("_display_name"));
    }

    public static java.lang.String getMd5OfFile(java.lang.String str) {
        java.lang.String str2 = "";
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            byte[] bArr = new byte[1024];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            int i = 0;
            while (i != -1) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                }
            }
            fileInputStream.close();
            for (byte b : messageDigest.digest()) {
                str2 = str2 + java.lang.Integer.toString((b & 255) + 256, 16).substring(1);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return str2.toUpperCase();
    }

    public static java.lang.String getMimeType(java.lang.String str) {
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static java.io.File getTempDirectory() {
        return new java.io.File(getTempDirectoryPath());
    }

    public static java.lang.String getTempDirectoryPath() {
        return java.lang.System.getProperty("java.io.tmpdir");
    }

    public static java.io.File getUserDirectory() {
        return new java.io.File(getUserDirectoryPath());
    }

    public static java.lang.String getUserDirectoryPath() {
        return java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR);
    }

    public static android.graphics.Bitmap getVideoSize(java.lang.String str) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return mediaMetadataRetriever.getFrameAtTime();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                mediaMetadataRetriever.release();
                return null;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static boolean isFileExists(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    public static boolean isFileNewer(java.io.File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() > j;
        }
        throw new java.lang.IllegalArgumentException("No specified file");
    }

    public static boolean isFileNewer(java.io.File file, java.io.File file2) {
        if (file2 == null) {
            throw new java.lang.IllegalArgumentException("No specified reference file");
        }
        if (file2.exists()) {
            return isFileNewer(file, file2.lastModified());
        }
        throw new java.lang.IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
    }

    public static boolean isFileNewer(java.io.File file, java.util.Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new java.lang.IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(java.io.File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() < j;
        }
        throw new java.lang.IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(java.io.File file, java.io.File file2) {
        if (file2 == null) {
            throw new java.lang.IllegalArgumentException("No specified reference file");
        }
        if (file2.exists()) {
            return isFileOlder(file, file2.lastModified());
        }
        throw new java.lang.IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
    }

    public static boolean isFileOlder(java.io.File file, java.util.Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new java.lang.IllegalArgumentException("No specified date");
    }

    public static boolean isSymlink(java.io.File file) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("File must not be null");
        }
        if (com.aliyun.vod.common.utils.FilenameUtils.isSystemWindows()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new java.io.File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean mkdirs(java.io.File file) {
        try {
            forceMkdir(file);
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static void moveDirectory(java.io.File file, java.io.File file2) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new java.io.IOException("Source '" + file + "' is not a directory");
        }
        if (file2.exists()) {
            throw new com.aliyun.vod.common.utils.FileUtils.FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (file.renameTo(file2)) {
            return;
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            throw new java.io.IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
        copyDirectory(file, file2);
        deleteDirectory(file);
        if (file.exists()) {
            throw new java.io.IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
        }
    }

    public static void moveDirectoryToDirectory(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new java.io.FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        }
        if (file2.isDirectory()) {
            moveDirectory(file, new java.io.File(file2, file.getName()));
            return;
        }
        throw new java.io.IOException("Destination '" + file2 + "' is not a directory");
    }

    public static void moveFile(java.io.File file, java.io.File file2) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new java.io.IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new com.aliyun.vod.common.utils.FileUtils.FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new java.io.IOException("Destination '" + file2 + "' is a directory");
        }
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file, file2);
        if (file.delete()) {
            return;
        }
        deleteQuietly(file2);
        throw new java.io.IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    public static void moveFileToDirectory(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new java.io.FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        }
        if (file2.isDirectory()) {
            moveFile(file, new java.io.File(file2, file.getName()));
            return;
        }
        throw new java.io.IOException("Destination '" + file2 + "' is not a directory");
    }

    public static void moveToDirectory(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                moveDirectoryToDirectory(file, file2, z);
                return;
            } else {
                moveFileToDirectory(file, file2, z);
                return;
            }
        }
        throw new java.io.FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static java.io.FileInputStream openInputStream(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new java.io.IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new java.io.FileInputStream(file);
        }
        throw new java.io.IOException("File '" + file + "' cannot be read");
    }

    public static java.io.FileOutputStream openOutputStream(java.io.File file) throws java.io.IOException {
        return openOutputStream(file, false);
    }

    public static java.io.FileOutputStream openOutputStream(java.io.File file, boolean z) throws java.io.IOException {
        if (!file.exists()) {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new java.io.IOException("Directory '" + parentFile + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new java.io.IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new java.io.IOException("File '" + file + "' cannot be written to");
            }
        }
        return new java.io.FileOutputStream(file, z);
    }

    public static java.lang.String percentEncode(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static byte[] readFileToByteArray(java.io.File file) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                byte[] byteArray = com.aliyun.vod.common.utils.IOUtils.toByteArray(fileInputStream, file.length());
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                return byteArray;
            } catch (java.lang.Throwable th) {
                th = th;
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static java.lang.String readFileToString(java.io.File file) throws java.io.IOException {
        return readFileToString(file, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String readFileToString(java.io.File file, java.lang.String str) throws java.io.IOException {
        return readFileToString(file, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.lang.String readFileToString(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                java.lang.String iOUtils = com.aliyun.vod.common.utils.IOUtils.toString(fileInputStream, com.aliyun.vod.common.utils.Charsets.toCharset(charset));
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                return iOUtils;
            } catch (java.lang.Throwable th) {
                th = th;
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static java.util.List<java.lang.String> readLines(java.io.File file) throws java.io.IOException {
        return readLines(file, java.nio.charset.Charset.defaultCharset());
    }

    public static java.util.List<java.lang.String> readLines(java.io.File file, java.lang.String str) throws java.io.IOException {
        return readLines(file, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.util.List<java.lang.String> readLines(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                java.util.List<java.lang.String> readLines = com.aliyun.vod.common.utils.IOUtils.readLines(fileInputStream, com.aliyun.vod.common.utils.Charsets.toCharset(charset));
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                return readLines;
            } catch (java.lang.Throwable th) {
                th = th;
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.InputStream) fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static long sizeOf(java.io.File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectory(file) : file.length();
        }
        throw new java.lang.IllegalArgumentException(file + " does not exist");
    }

    public static java.math.BigInteger sizeOfAsBigInteger(java.io.File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectoryAsBigInteger(file) : java.math.BigInteger.valueOf(file.length());
        }
        throw new java.lang.IllegalArgumentException(file + " does not exist");
    }

    public static long sizeOfDirectory(java.io.File file) {
        checkDirectory(file);
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j = 0;
        for (java.io.File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    j += sizeOf(file2);
                    if (j < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (java.io.IOException unused) {
            }
        }
        return j;
    }

    public static java.math.BigInteger sizeOfDirectoryAsBigInteger(java.io.File file) {
        checkDirectory(file);
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return java.math.BigInteger.ZERO;
        }
        java.math.BigInteger bigInteger = java.math.BigInteger.ZERO;
        for (java.io.File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(java.math.BigInteger.valueOf(sizeOf(file2)));
                }
            } catch (java.io.IOException unused) {
            }
        }
        return bigInteger;
    }

    public static java.io.File toFile(java.net.URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new java.io.File(decodeUrl(url.getFile().replace('/', java.io.File.separatorChar)));
    }

    public static java.io.File[] toFiles(java.net.URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        java.io.File[] fileArr = new java.io.File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            java.net.URL url = urlArr[i];
            if (url != null) {
                if (!url.getProtocol().equals("file")) {
                    throw new java.lang.IllegalArgumentException("URL could not be converted to a File: " + url);
                }
                fileArr[i] = toFile(url);
            }
        }
        return fileArr;
    }

    private static java.lang.String[] toSuffixes(java.lang.String[] strArr) {
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    public static java.net.URL[] toURLs(java.io.File[] fileArr) throws java.io.IOException {
        int length = fileArr.length;
        java.net.URL[] urlArr = new java.net.URL[length];
        for (int i = 0; i < length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) openOutputStream(file));
        }
        if (file.setLastModified(java.lang.System.currentTimeMillis())) {
            return;
        }
        throw new java.io.IOException("Unable to set the last modification time for " + file);
    }

    public static boolean waitFor(java.io.File file, int i) {
        int i2 = 0;
        int i3 = 0;
        while (!file.exists()) {
            int i4 = i2 + 1;
            if (i2 >= 10) {
                int i5 = i3 + 1;
                if (i3 > i) {
                    return false;
                }
                i3 = i5;
                i2 = 0;
            } else {
                i2 = i4;
            }
            try {
                java.lang.Thread.sleep(100L);
            } catch (java.lang.InterruptedException unused) {
            } catch (java.lang.Exception unused2) {
                return true;
            }
        }
        return true;
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence) throws java.io.IOException {
        write(file, charSequence, java.nio.charset.Charset.defaultCharset(), false);
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence, java.lang.String str) throws java.io.IOException {
        write(file, charSequence, str, false);
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence, java.lang.String str, boolean z) throws java.io.IOException {
        write(file, charSequence, com.aliyun.vod.common.utils.Charsets.toCharset(str), z);
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence, java.nio.charset.Charset charset) throws java.io.IOException {
        write(file, charSequence, charset, false);
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence, java.nio.charset.Charset charset, boolean z) throws java.io.IOException {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void write(java.io.File file, java.lang.CharSequence charSequence, boolean z) throws java.io.IOException {
        write(file, charSequence, java.nio.charset.Charset.defaultCharset(), z);
    }

    public static void writeByteArrayToFile(java.io.File file, byte[] bArr) throws java.io.IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(java.io.File file, byte[] bArr, boolean z) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
        } catch (java.lang.Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static void writeLines(java.io.File file, java.lang.String str, java.util.Collection<?> collection) throws java.io.IOException {
        writeLines(file, str, collection, null, false);
    }

    public static void writeLines(java.io.File file, java.lang.String str, java.util.Collection<?> collection, java.lang.String str2) throws java.io.IOException {
        writeLines(file, str, collection, str2, false);
    }

    public static void writeLines(java.io.File file, java.lang.String str, java.util.Collection<?> collection, java.lang.String str2, boolean z) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
            try {
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                com.aliyun.vod.common.utils.IOUtils.writeLines(collection, str2, bufferedOutputStream, str);
                bufferedOutputStream.flush();
                fileOutputStream.close();
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void writeLines(java.io.File file, java.lang.String str, java.util.Collection<?> collection, boolean z) throws java.io.IOException {
        writeLines(file, str, collection, null, z);
    }

    public static void writeLines(java.io.File file, java.util.Collection<?> collection) throws java.io.IOException {
        writeLines(file, null, collection, null, false);
    }

    public static void writeLines(java.io.File file, java.util.Collection<?> collection, java.lang.String str) throws java.io.IOException {
        writeLines(file, null, collection, str, false);
    }

    public static void writeLines(java.io.File file, java.util.Collection<?> collection, java.lang.String str, boolean z) throws java.io.IOException {
        writeLines(file, null, collection, str, z);
    }

    public static void writeLines(java.io.File file, java.util.Collection<?> collection, boolean z) throws java.io.IOException {
        writeLines(file, null, collection, null, z);
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str) throws java.io.IOException {
        writeStringToFile(file, str, java.nio.charset.Charset.defaultCharset(), false);
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        writeStringToFile(file, str, str2, false);
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str, java.lang.String str2, boolean z) throws java.io.IOException {
        writeStringToFile(file, str, com.aliyun.vod.common.utils.Charsets.toCharset(str2), z);
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str, java.nio.charset.Charset charset, boolean z) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
        } catch (java.lang.Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.aliyun.vod.common.utils.IOUtils.write(str, (java.io.OutputStream) fileOutputStream, charset);
            fileOutputStream.close();
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.aliyun.vod.common.utils.IOUtils.closeQuietly((java.io.OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static void writeStringToFile(java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        writeStringToFile(file, str, java.nio.charset.Charset.defaultCharset(), z);
    }
}
