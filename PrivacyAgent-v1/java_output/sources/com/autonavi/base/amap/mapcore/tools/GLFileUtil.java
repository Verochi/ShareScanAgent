package com.autonavi.base.amap.mapcore.tools;

/* loaded from: classes12.dex */
public class GLFileUtil {
    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void copy(android.content.Context context, java.lang.String str, java.io.File file) throws java.lang.Exception {
        file.delete();
        java.io.InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        try {
            open.read(bArr);
            closeQuietly(open);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } catch (java.lang.Throwable th) {
            closeQuietly(open);
            throw th;
        }
    }

    public static void deleteFile(java.io.File file) {
        if (file == null) {
            return;
        }
        java.io.File[] listFiles = file.listFiles();
        if (file.isDirectory() && listFiles != null) {
            for (java.io.File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static java.io.File getCacheDir(android.content.Context context) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            cacheDir = new java.io.File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static java.io.File getFilesDir(android.content.Context context) {
        java.io.File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = context.getDir("files", 0);
        }
        if (filesDir == null) {
            filesDir = new java.io.File("/data/data/" + context.getPackageName() + "/app_files");
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }

    public static byte[] readFileContents(java.lang.String str) {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                closeQuietly(null);
                return null;
            }
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(fileInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (java.lang.Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void writeDatasToFile(java.lang.String str, byte[] bArr) {
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        java.io.FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    java.io.File file = new java.io.File(str);
                    java.io.File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream2);
                        return;
                    } catch (java.lang.Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (java.lang.Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        writeLock.unlock();
        closeQuietly(null);
    }
}
