package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class k {
    public static long a(java.lang.String str) {
        long j = 0;
        if (android.text.TextUtils.isEmpty(str)) {
            return 0L;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return 0L;
        }
        try {
            j = file.isDirectory() ? c(file) : b(file);
        } catch (java.lang.Throwable unused) {
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if ((b() <= 31457280) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.io.File a(android.content.Context context) {
        java.io.File file;
        java.io.File externalFilesDir;
        java.io.File file2 = null;
        try {
            externalFilesDir = context.getExternalFilesDir(null);
        } catch (java.lang.Throwable unused) {
        }
        if (externalFilesDir != null) {
            file = a(externalFilesDir);
            if (file != null) {
                return file;
            }
            if (file == null && b(context)) {
                file = a(new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + context.getPackageName()));
            }
            file2 = file;
            return file2 != null ? new java.io.File(context.getFilesDir().getAbsoluteFile().getAbsolutePath()) : file2;
        }
        file = null;
        if (file == null) {
            file = a(new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + context.getPackageName()));
        }
        file2 = file;
        if (file2 != null) {
        }
    }

    private static java.io.File a(java.io.File file) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.util.UUID.randomUUID());
        java.io.File file2 = new java.io.File(file, sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    private static boolean a() {
        return b() > 31457280;
    }

    private static long b() {
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (java.lang.Error unused) {
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    private static long b(java.io.File file) {
        long j = 0;
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                        try {
                            j = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (java.lang.Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return j;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
            return j;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static java.lang.String b(java.lang.String str) {
        return com.anythink.core.common.o.g.a(str);
    }

    private static boolean b(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission(com.anythink.china.common.d.b, context.getPackageName()) == 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static long c(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? c(listFiles[i]) : b(listFiles[i]);
            }
        }
        return j;
    }

    private static boolean c() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }
}
