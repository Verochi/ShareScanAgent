package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class FileUtil implements com.alimm.tanx.core.utils.NotConfused {

    public interface WriteProgress {
        void error(java.lang.Exception exc);

        void writeProgress(int i);
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

    public static boolean copyFile(java.lang.String str, java.lang.String str2) {
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream;
        boolean z = false;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (new java.io.File(str).exists()) {
                    fileInputStream = new java.io.FileInputStream(str);
                    try {
                        try {
                            fileOutputStream = new java.io.FileOutputStream(str2);
                        } catch (java.lang.Exception e) {
                            e = e;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1444];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        z = true;
                        fileOutputStream2 = fileOutputStream;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return z;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } else {
                    fileInputStream = null;
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return z;
    }

    public static boolean deleteFiles(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (java.io.File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    public static synchronized java.io.File getAndCreateFile(java.lang.String str, java.lang.String str2) {
        java.io.File file;
        synchronized (com.alimm.tanx.core.utils.FileUtil.class) {
            java.io.File file2 = new java.io.File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new java.io.File(file2, str2);
        }
        return file;
    }

    private static java.io.File getCacheDirectory(android.content.Context context, boolean z) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        return new java.io.File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static long getFileName(java.io.File file) {
        if (file != null) {
            return java.lang.Long.parseLong(file.getName().replace(".txt", ""));
        }
        return 0L;
    }

    public static java.io.File getIndividualCacheDirectory(android.content.Context context, java.lang.String str) {
        return new java.io.File(getCacheDirectory(context, true), str);
    }

    public static void writeFile(okhttp3.ResponseBody responseBody, java.io.File file, long j, boolean z, com.alimm.tanx.core.utils.FileUtil.WriteProgress writeProgress) {
        if (responseBody == null) {
            return;
        }
        java.io.InputStream byteStream = responseBody.byteStream();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[1024];
                    fileOutputStream = z ? new java.io.FileOutputStream(file, true) : new java.io.FileOutputStream(file);
                    if (!z) {
                        j = 0;
                    }
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            fileOutputStream.flush();
                            byteStream.close();
                            fileOutputStream.close();
                            return;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                            j += read;
                            writeProgress.writeProgress((int) (((j * 1.0f) / responseBody.contentLength()) * 100.0f));
                        }
                    }
                } catch (java.lang.Exception e) {
                    writeProgress.error(e);
                    e.printStackTrace();
                    if (byteStream != null) {
                        byteStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            if (byteStream != null) {
                try {
                    byteStream.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
