package com.anythink.expressad.b;

/* loaded from: classes12.dex */
public final class c {
    private static final java.lang.String a = "UnzipUtility";
    private static final int b = 4096;

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00eb, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ef, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00f0, code lost:
    
        r12.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0100, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0104, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0105, code lost:
    
        r12.getMessage();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(java.lang.String str, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2;
        java.lang.String str3;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return 1;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
                fileOutputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        java.util.zip.ZipEntry nextElement = entries.nextElement();
                        if (nextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.io.IOException e) {
                                    e.getMessage();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (java.io.IOException e2) {
                                    e2.getMessage();
                                }
                            }
                            return 2;
                        }
                        java.lang.String name = nextElement.getName();
                        if (!android.text.TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            java.io.File file2 = new java.io.File(str2 + name);
                            try {
                                str3 = file2.getCanonicalPath();
                            } catch (java.io.IOException unused) {
                                str3 = "";
                            }
                            if (android.text.TextUtils.isEmpty(str3) || str3.startsWith("..") || str3.startsWith("../") || !str3.startsWith(str2)) {
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (java.io.IOException e3) {
                                        e3.getMessage();
                                    }
                                }
                                return 2;
                            }
                            if (nextElement.isDirectory()) {
                                file2.mkdirs();
                            } else {
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream(file2);
                                try {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr, 0, 1024);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, read);
                                        fileOutputStream3.flush();
                                    }
                                    fileOutputStream2 = fileOutputStream3;
                                } catch (java.io.IOException e4) {
                                    e = e4;
                                    fileOutputStream2 = fileOutputStream3;
                                    e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e5) {
                                            e5.getMessage();
                                        }
                                    }
                                    if (fileOutputStream2 == null) {
                                        return 3;
                                    }
                                    try {
                                        fileOutputStream2.close();
                                        return 3;
                                    } catch (java.io.IOException e6) {
                                        e6.getMessage();
                                        return 3;
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream3;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e7) {
                                            e7.getMessage();
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        throw th;
                                    }
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (java.io.IOException e8) {
                                        e8.getMessage();
                                        throw th;
                                    }
                                }
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.io.IOException e9) {
                                e9.getMessage();
                            }
                        }
                        return 2;
                    } catch (java.io.IOException e10) {
                        e = e10;
                    }
                }
                zipFile.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e11) {
                        e11.getMessage();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e12) {
                        e12.getMessage();
                    }
                }
                return 0;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e13) {
            e = e13;
            fileOutputStream2 = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static void a(java.util.zip.ZipInputStream zipInputStream, java.lang.String str) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.File file = new java.io.File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read == -1) {
                    bufferedOutputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException e2) {
            e = e2;
            throw new java.io.IOException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            throw th;
        }
    }
}
