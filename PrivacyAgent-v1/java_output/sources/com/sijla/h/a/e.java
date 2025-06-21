package com.sijla.h.a;

/* loaded from: classes19.dex */
public final class e implements com.sijla.h.c.a.a {
    private java.io.File a;

    public e(java.io.File file) {
        this.a = file;
    }

    public static java.io.File a(java.lang.String str, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        if (com.sijla.h.c.a(str) || bArr == null || com.sijla.h.a.a.o() < 1) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        c(file);
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(str);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArr);
            com.sijla.h.c.a(fileOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            com.sijla.h.c.a(fileOutputStream2);
            return file;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.sijla.h.c.a(fileOutputStream2);
            throw th;
        }
        return file;
    }

    public static void a(java.io.File file) {
        java.io.File[] listFiles;
        if (file != null) {
            try {
                if (!file.isDirectory()) {
                    file.delete();
                    return;
                }
                if (com.sijla.h.c.g(file.getAbsolutePath()) || (listFiles = file.listFiles()) == null) {
                    return;
                }
                if (listFiles.length <= 0) {
                    file.delete();
                    return;
                }
                for (java.io.File file2 : listFiles) {
                    a(file2);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) {
        com.sijla.a.a.a(new com.sijla.h.a.f(str, str2, z));
    }

    public static void a(java.util.List<java.io.File> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (java.io.File file : list) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public static boolean a(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (b(str)) {
            if (!(!b(str) ? false : new java.io.File(str).isDirectory())) {
                a(file);
            }
        }
        try {
            file.mkdirs();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return file.exists();
    }

    public static java.io.File[] a(java.lang.String str, java.io.FileFilter fileFilter) {
        java.io.File[] fileArr = new java.io.File[0];
        if (android.text.TextUtils.isEmpty(str)) {
            return fileArr;
        }
        java.io.File file = new java.io.File(str);
        return (file.exists() && file.isDirectory()) ? file.listFiles(fileFilter) : fileArr;
    }

    public static java.lang.String b(java.io.File file) {
        if (!file.getAbsolutePath().contains("../") && file.exists()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.io.BufferedReader bufferedReader = null;
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                java.lang.String sb2 = sb.toString();
                                com.sijla.h.c.a(bufferedReader2);
                                return sb2;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (java.io.IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            com.sijla.h.c.a(bufferedReader);
                            return "";
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            com.sijla.h.c.a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    private static boolean b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.Closeable[]] */
    public static boolean b(java.lang.String str, java.lang.String str2, boolean z) {
        java.io.BufferedWriter bufferedWriter;
        int read;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        if (str2.contains("../")) {
            return false;
        }
        if (!str.endsWith("\n")) {
            str = str + "\n";
        }
        java.io.BufferedWriter bufferedWriter2 = null;
        r0 = null;
        java.io.BufferedWriter bufferedWriter3 = null;
        bufferedWriter2 = null;
        try {
            try {
                java.io.File file = new java.io.File((java.lang.String) str2);
                c(file);
                str2 = new java.io.BufferedReader(new java.io.StringReader(str));
                try {
                    bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file, z));
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                char[] cArr = new char[1024];
                while (true) {
                    read = str2.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedWriter.write(cArr, 0, read);
                }
                bufferedWriter.flush();
                com.sijla.h.c.a((java.io.Closeable[]) new java.io.Closeable[]{bufferedWriter, str2});
                r1 = 1;
                bufferedWriter2 = read;
                str2 = str2;
            } catch (java.lang.Exception e2) {
                e = e2;
                bufferedWriter3 = bufferedWriter;
                e.printStackTrace();
                com.sijla.h.c.a((java.io.Closeable[]) new java.io.Closeable[]{bufferedWriter3, str2});
                bufferedWriter2 = bufferedWriter3;
                str2 = str2;
                return r1;
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                ?? r6 = new java.io.Closeable[2];
                r6[r1] = bufferedWriter2;
                r6[1] = str2;
                com.sijla.h.c.a((java.io.Closeable[]) r6);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            str2 = 0;
        } catch (java.lang.Throwable th3) {
            th = th3;
            str2 = 0;
        }
        return r1;
    }

    private static boolean c(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (parentFile.exists() || !parentFile.mkdirs()) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.sijla.h.c.a.a
    public final com.sijla.h.j a(java.io.InputStream inputStream) {
        java.io.FileOutputStream fileOutputStream;
        com.sijla.h.j jVar = new com.sijla.h.j();
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(this.a);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            jVar.a(this.a);
            this.a.getAbsolutePath();
            this.a.length();
            com.sijla.h.h.b();
            com.sijla.h.c.a(fileOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            jVar.a(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE);
            jVar.a(e.getMessage());
            java.io.File file = this.a;
            if (file != null) {
                file.delete();
            }
            com.sijla.h.c.a(fileOutputStream2);
            return jVar;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.sijla.h.c.a(fileOutputStream2);
            throw th;
        }
        return jVar;
    }
}
