package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class ZipUtil {
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00e0, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.closeSecure(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e3, code lost:
    
        if (r4 != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e5, code lost:
    
        g(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<java.io.File> a(java.io.File file, java.io.File file2, long j, boolean z) {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileOutputStream fileOutputStream = null;
        if (file == null || file2 == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z2 = false;
        boolean z3 = true;
        try {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
            try {
                try {
                    java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
                    int i = 0;
                    while (true) {
                        try {
                            if (!entries.hasMoreElements()) {
                                z2 = z3;
                                break;
                            }
                            try {
                                java.util.zip.ZipEntry nextElement = entries.nextElement();
                                java.lang.String name = nextElement.getName();
                                if (!android.text.TextUtils.isEmpty(name)) {
                                    java.lang.String normalize = java.text.Normalizer.normalize(name, java.text.Normalizer.Form.NFKC);
                                    if (o(normalize)) {
                                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                        sb.append("zipPath is a invalid path: ");
                                        sb.append(l(normalize));
                                        break;
                                    }
                                    java.io.File file3 = new java.io.File(file2, normalize.replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR));
                                    if (z && file3.exists() && file3.isFile()) {
                                        n(file3);
                                    }
                                    arrayList.add(file3);
                                    if (nextElement.isDirectory()) {
                                        if (!d(file3)) {
                                            com.huawei.secure.android.common.util.IOUtil.closeSecure(zipFile);
                                            g(arrayList);
                                            return null;
                                        }
                                    } else {
                                        if (!i(file3)) {
                                            com.huawei.secure.android.common.util.IOUtil.closeSecure(zipFile);
                                            g(arrayList);
                                            return null;
                                        }
                                        try {
                                            bufferedInputStream = new java.io.BufferedInputStream(zipFile.getInputStream(nextElement));
                                            try {
                                                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file3);
                                                try {
                                                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream2);
                                                    try {
                                                        byte[] bArr = new byte[1024];
                                                        while (true) {
                                                            int read = bufferedInputStream.read(bArr);
                                                            if (read == -1) {
                                                                break;
                                                            }
                                                            i += read;
                                                            if (i > j) {
                                                                z3 = false;
                                                                break;
                                                            }
                                                            bufferedOutputStream.write(bArr, 0, read);
                                                        }
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) bufferedInputStream);
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) bufferedOutputStream);
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) fileOutputStream2);
                                                    } catch (java.lang.Throwable th) {
                                                        th = th;
                                                        fileOutputStream = fileOutputStream2;
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) bufferedInputStream);
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) bufferedOutputStream);
                                                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) fileOutputStream);
                                                        throw th;
                                                    }
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    bufferedOutputStream = null;
                                                }
                                            } catch (java.lang.Throwable th3) {
                                                th = th3;
                                                bufferedOutputStream = null;
                                            }
                                        } catch (java.lang.Throwable th4) {
                                            th = th4;
                                            bufferedInputStream = null;
                                            bufferedOutputStream = null;
                                        }
                                    }
                                }
                            } catch (java.lang.IllegalArgumentException unused) {
                            }
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            z2 = z3;
                            fileOutputStream = zipFile;
                            z3 = z2;
                            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) fileOutputStream);
                            if (!z3) {
                                g(arrayList);
                            }
                            throw th;
                        }
                    }
                } catch (java.io.IOException e) {
                    e = e;
                    fileOutputStream = zipFile;
                    try {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("unzip new IOException : ");
                        sb2.append(e.getMessage());
                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) fileOutputStream);
                        g(arrayList);
                        return arrayList;
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        z3 = z2;
                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) fileOutputStream);
                        if (!z3) {
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                fileOutputStream = zipFile;
                z2 = true;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        } catch (java.lang.Throwable th8) {
            th = th8;
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) fileOutputStream);
            if (!z3) {
            }
            throw th;
        }
    }

    public static void b(java.io.FileInputStream fileInputStream, java.io.BufferedOutputStream bufferedOutputStream, java.util.zip.ZipInputStream zipInputStream, java.io.FileOutputStream fileOutputStream) {
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) fileInputStream);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) bufferedOutputStream);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) zipInputStream);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) fileOutputStream);
    }

    public static void c(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && o(str)) {
            throw new java.lang.IllegalArgumentException("path is not a standard path");
        }
    }

    public static boolean d(java.io.File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x0071
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static boolean e(java.lang.String r12, long r13, int r15) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            r4.<init>(r12)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            java.util.Enumeration r12 = r4.entries()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r5 = 0
            r2 = 0
        L12:
            boolean r7 = r12.hasMoreElements()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r8 = 1
            if (r7 == 0) goto L45
            java.lang.Object r7 = r12.nextElement()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            long r9 = r7.getSize()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            long r5 = r5 + r9
            int r2 = r2 + r8
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            boolean r8 = o(r8)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            if (r8 != 0) goto L3f
            if (r2 >= r15) goto L3f
            int r8 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r8 > 0) goto L3f
            long r7 = r7.getSize()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L12
        L3f:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r12)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            goto L46
        L45:
            r3 = 1
        L46:
            r4.close()     // Catch: java.io.IOException -> L71
            goto L74
        L4a:
            r12 = move-exception
            r2 = r4
            goto L75
        L4d:
            r12 = move-exception
            r2 = r4
            goto L53
        L50:
            r12 = move-exception
            goto L75
        L52:
            r12 = move-exception
        L53:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r13.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r14 = "not a valid zip file, IOException : "
            r13.append(r14)     // Catch: java.lang.Throwable -> L50
            java.lang.String r12 = r12.getMessage()     // Catch: java.lang.Throwable -> L50
            r13.append(r12)     // Catch: java.lang.Throwable -> L50
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L50
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r12)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.io.IOException -> L71
            goto L74
        L71:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L74:
            return r3
        L75:
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.io.IOException -> L7b
            goto L7e
        L7b:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L7e:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.e(java.lang.String, long, int):boolean");
    }

    public static boolean f(java.lang.String str, java.lang.String str2, long j, int i) throws com.huawei.secure.android.common.util.SecurityCommonException {
        if (android.text.TextUtils.isEmpty(str) || o(str)) {
            com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "zip file is not valid");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2) || o(str2)) {
            com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "target directory is not valid");
            return false;
        }
        if (e(str, j, i)) {
            return true;
        }
        com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "zip file contains valid chars or too many files");
        throw new com.huawei.secure.android.common.util.SecurityCommonException("unsecure zipfile!");
    }

    public static boolean g(java.util.List<java.io.File> list) {
        try {
            java.util.Iterator<java.io.File> it = list.iterator();
            while (it.hasNext()) {
                n(it.next());
            }
            return true;
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "unzip fail delete file failed" + e.getMessage());
            return false;
        }
    }

    public static java.io.File h(java.lang.String str) {
        c(str);
        return new java.io.File(str);
    }

    public static boolean i(java.io.File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!d(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static java.io.File j(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return h(str);
    }

    public static void k(java.io.File file) {
        if (file == null || file.delete()) {
            return;
        }
        com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "delete file error");
    }

    public static java.lang.String l(java.lang.String str) {
        int lastIndexOf;
        return (android.text.TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(java.io.File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    public static void m(java.io.File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "mkdirs error , files exists or IOException.");
    }

    public static void n(java.io.File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            k(file);
            return;
        }
        if (file.isDirectory()) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                k(file);
                return;
            }
            for (java.io.File file2 : listFiles) {
                n(file2);
            }
            k(file);
        }
    }

    public static boolean o(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || str.contains("../") || str.contains("..\\") || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0136  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZip(java.lang.String str, java.lang.String str2, long j, int i, boolean z) throws com.huawei.secure.android.common.util.SecurityCommonException {
        java.util.zip.ZipInputStream zipInputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2;
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream3;
        java.lang.String str3 = str2;
        boolean z2 = false;
        if (!f(str, str2, j, i)) {
            return false;
        }
        java.lang.String str4 = java.io.File.separator;
        if (str3.endsWith(str4) && str2.length() > str4.length()) {
            str3 = str3.substring(0, str2.length() - str4.length());
        }
        byte[] bArr = new byte[4096];
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.FileInputStream fileInputStream2 = null;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
            try {
                zipInputStream = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(fileInputStream));
                fileOutputStream2 = null;
                boolean z3 = true;
                int i2 = 0;
                while (true) {
                    try {
                        try {
                            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            }
                            java.lang.String replaceAll = nextEntry.getName().replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                            java.io.File file = new java.io.File(str3, replaceAll);
                            java.lang.String normalize = java.text.Normalizer.normalize(replaceAll, java.text.Normalizer.Form.NFKC);
                            if (o(normalize)) {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("zipPath is a invalid path: ");
                                sb.append(l(normalize));
                                z3 = false;
                                break;
                            }
                            if (z && file.exists() && file.isFile()) {
                                n(file);
                            }
                            if (nextEntry.isDirectory()) {
                                m(file);
                                arrayList.add(file);
                            } else {
                                java.io.File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    m(parentFile);
                                }
                                fileOutputStream = new java.io.FileOutputStream(file);
                                try {
                                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                                    while (true) {
                                        try {
                                            int read = zipInputStream.read(bArr, 0, 4096);
                                            if (read == -1) {
                                                break;
                                            }
                                            i2 += read;
                                            if (i2 > j) {
                                                z3 = false;
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        } catch (java.io.IOException e) {
                                            e = e;
                                            fileOutputStream3 = fileOutputStream;
                                            fileOutputStream = fileOutputStream3;
                                            fileInputStream2 = fileInputStream;
                                            try {
                                                com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                                                fileInputStream = fileInputStream2;
                                                bufferedOutputStream2 = bufferedOutputStream;
                                                fileOutputStream2 = fileOutputStream;
                                                b(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                                if (!z2) {
                                                }
                                                return z2;
                                            } catch (java.lang.Throwable th) {
                                                th = th;
                                                b(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                                throw th;
                                            }
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            fileInputStream2 = fileInputStream;
                                            b(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    }
                                    arrayList.add(file);
                                    bufferedOutputStream.flush();
                                    com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) bufferedOutputStream);
                                    com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) fileOutputStream);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileInputStream2 = fileInputStream;
                                    com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    b(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (!z2) {
                                    }
                                    return z2;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileInputStream2 = fileInputStream;
                                    b(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                    throw th;
                                }
                            }
                            try {
                                zipInputStream.closeEntry();
                            } catch (java.io.IOException e3) {
                                e = e3;
                                java.io.FileOutputStream fileOutputStream4 = fileOutputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileOutputStream3 = fileOutputStream4;
                                fileOutputStream = fileOutputStream3;
                                fileInputStream2 = fileInputStream;
                                com.huawei.secure.android.common.util.LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                                fileInputStream = fileInputStream2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream2 = fileOutputStream;
                                b(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                if (!z2) {
                                }
                                return z2;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (java.io.IOException e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream2;
                    }
                }
                com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) zipInputStream);
                com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) fileInputStream);
                z2 = z3;
            } catch (java.io.IOException e5) {
                e = e5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (java.io.IOException e6) {
            e = e6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (java.lang.Throwable th6) {
            th = th6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        b(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
        if (!z2) {
            g(arrayList);
        }
        return z2;
    }

    @java.lang.Deprecated
    public static boolean unZip(java.lang.String str, java.lang.String str2, boolean z) throws com.huawei.secure.android.common.util.SecurityCommonException {
        return unZip(str, str2, 104857600L, 100, z);
    }

    public static java.util.List<java.io.File> unZipNew(java.lang.String str, java.lang.String str2, long j, int i, boolean z) throws com.huawei.secure.android.common.util.SecurityCommonException {
        if (!f(str, str2, j, i)) {
            return null;
        }
        java.lang.String str3 = java.io.File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(j(str), j(str2), j, z);
    }

    public static java.util.List<java.io.File> unZipNew(java.lang.String str, java.lang.String str2, boolean z) throws com.huawei.secure.android.common.util.SecurityCommonException {
        return unZipNew(str, str2, 104857600L, 100, z);
    }
}
