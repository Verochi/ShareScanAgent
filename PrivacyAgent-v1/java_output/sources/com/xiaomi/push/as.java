package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class as {
    public static java.lang.String a(android.content.Context context) {
        java.lang.String b = com.xiaomi.push.av.a(context).b("sp_client_report_status", "sp_client_report_key", "");
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        java.lang.String a = com.xiaomi.push.ao.a(20);
        com.xiaomi.push.av.a(context).a("sp_client_report_status", "sp_client_report_key", a);
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e8, code lost:
    
        if (r7 == null) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.io.File file;
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Exception e;
        java.io.File externalFilesDir = context.getExternalFilesDir(str2);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            java.io.File externalFilesDir2 = context.getExternalFilesDir(str);
            if (externalFilesDir2 != null) {
                if (!externalFilesDir2.exists()) {
                    externalFilesDir2.mkdirs();
                    return;
                }
                java.io.File[] listFiles = externalFilesDir2.listFiles(new com.xiaomi.push.at());
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                java.nio.channels.FileLock fileLock = null;
                java.io.RandomAccessFile randomAccessFile2 = null;
                java.io.File file2 = null;
                for (java.io.File file3 : listFiles) {
                    if (file3 != null) {
                        try {
                        } catch (java.lang.Exception e2) {
                            file = file2;
                            randomAccessFile = randomAccessFile2;
                            e = e2;
                        } catch (java.lang.Throwable th) {
                            th = th;
                        }
                        if (!android.text.TextUtils.isEmpty(file3.getAbsolutePath())) {
                            file = new java.io.File(file3.getAbsolutePath() + ".lock");
                            try {
                                com.xiaomi.push.c.b(file);
                                randomAccessFile = new java.io.RandomAccessFile(file, "rw");
                                try {
                                    try {
                                        fileLock = randomAccessFile.getChannel().lock();
                                        java.io.File file4 = new java.io.File(externalFilesDir.getAbsolutePath() + java.io.File.separator + file3.getName() + currentTimeMillis);
                                        try {
                                            com.xiaomi.push.c.b(file3, file4);
                                        } catch (java.io.IOException e3) {
                                            e3.printStackTrace();
                                            file3.delete();
                                            file4.delete();
                                        }
                                        file3.delete();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (java.io.IOException e4) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                                            }
                                        }
                                        com.xiaomi.push.c.a(randomAccessFile);
                                    } catch (java.lang.Exception e5) {
                                        e = e5;
                                        com.xiaomi.channel.commonutils.logger.b.a(e);
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (java.io.IOException e6) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e6);
                                            }
                                        }
                                        com.xiaomi.push.c.a(randomAccessFile);
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    randomAccessFile2 = randomAccessFile;
                                    file2 = file;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (java.io.IOException e7) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e7);
                                        }
                                    }
                                    com.xiaomi.push.c.a(randomAccessFile2);
                                    if (file2 == null) {
                                        throw th;
                                    }
                                    file2.delete();
                                    throw th;
                                }
                            } catch (java.lang.Exception e8) {
                                randomAccessFile = randomAccessFile2;
                                e = e8;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                            file.delete();
                            randomAccessFile2 = randomAccessFile;
                            file2 = file;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e9) {
                            com.xiaomi.channel.commonutils.logger.b.a(e9);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile2);
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static void a(android.content.Context context, java.util.List<java.lang.String> list) {
        if (list == null || list.size() <= 0 || !b(context)) {
            return;
        }
        for (java.lang.String str : list) {
            if (!android.text.TextUtils.isEmpty(str)) {
                c(context, str);
            }
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(str);
        long j = com.xiaomi.a.b.b.a(context).a().d;
        if (!file.exists()) {
            com.xiaomi.push.c.b(file);
            return true;
        }
        try {
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return file.length() <= j;
    }

    @android.annotation.TargetApi(9)
    public static byte[] a(java.lang.String str) {
        byte[] copyOf = java.util.Arrays.copyOf(com.xiaomi.push.al.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    private static boolean b(android.content.Context context) {
        return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
    }

    public static java.io.File[] b(android.content.Context context, java.lang.String str) {
        java.io.File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new com.xiaomi.push.au());
        }
        return null;
    }

    private static void c(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }
}
