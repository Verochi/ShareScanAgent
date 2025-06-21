package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
class h {
    private static java.lang.String a = com.qq.e.comm.managers.plugin.b.a("e_qq_com_plugin");
    private static java.lang.String b = com.qq.e.comm.managers.plugin.b.a("e_qq_com_dex");

    public static java.lang.String a() {
        return "gdt_plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public static java.lang.String a(java.io.File file) throws java.io.IOException {
        java.lang.Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            java.lang.String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Exception unused) {
                                com.qq.e.comm.util.GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (java.io.IOException e) {
                            throw e;
                        }
                    } catch (java.io.IOException e2) {
                        throw e2;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (java.lang.Exception unused2) {
                                com.qq.e.comm.util.GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public static void a(android.content.Context context) {
        try {
            java.io.File dir = context.getDir(a, 0);
            if (new java.io.File(dir, "disdoat").exists()) {
                return;
            }
            a(context.getDir(b, 0), false);
            a(new java.io.File(dir, "oat"), false);
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.w(th.getMessage(), th);
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void a(java.io.File file, boolean z) {
        java.io.File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static void a(java.lang.String str, java.io.File file) throws java.io.IOException {
        java.io.OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new java.io.IOException("Target File Can not be null in StringUtil.writeTo");
        }
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            outputStreamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), "UTF-8");
            try {
                outputStreamWriter.write(str);
                a(outputStreamWriter);
            } catch (java.lang.Throwable th) {
                th = th;
                a(outputStreamWriter);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
    }

    public static boolean a(java.io.File file, android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static boolean a(java.io.File file, java.io.File file2, android.content.Context context, boolean z) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z) {
                return a(file2, context);
            }
            return true;
        }
        try {
            boolean a2 = a(new java.io.FileInputStream(file), file2);
            if (!z) {
                return a2;
            }
            if (a2) {
                return a(file2, context);
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean a(java.io.InputStream inputStream, java.io.File file) throws java.lang.Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                com.qq.e.comm.util.GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    com.qq.e.comm.util.GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void b(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(context.getDir(a, 0), "stub_ver");
            if (android.text.TextUtils.equals(a(file), com.qq.e.comm.managers.status.SDKStatus.getSDKVersion())) {
                return;
            }
            a(com.qq.e.comm.managers.status.SDKStatus.getSDKVersion(), file);
            a(context);
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.w(th.getMessage(), th);
        }
    }

    public static java.io.File c(android.content.Context context) {
        return context.getDir(b, 0);
    }

    public static java.io.File d(android.content.Context context) {
        return new java.io.File(context.getDir(a, 0), "update_lc");
    }

    public static java.io.File e(android.content.Context context) {
        return new java.io.File(context.getDir(a, 0), "gdt_plugin.next");
    }

    public static java.io.File f(android.content.Context context) {
        return new java.io.File(context.getDir(a, 0), "gdt_plugin.next.sig");
    }

    public static java.io.File g(android.content.Context context) {
        return new java.io.File(context.getDir(a, 0), "gdt_plugin.jar");
    }

    public static java.io.File h(android.content.Context context) {
        return new java.io.File(context.getDir(a, 0), "gdt_plugin.jar.sig");
    }
}
