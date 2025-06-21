package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class k {
    public static boolean a(android.content.Context context, java.lang.String str, long j) {
        java.io.RandomAccessFile randomAccessFile;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (!(context.getPackageManager().checkPermission(com.anythink.china.common.d.b, context.getPackageName()) == 0)) {
                return true;
            }
        }
        java.nio.channels.FileLock fileLock = null;
        try {
            java.io.File file = new java.io.File(new java.io.File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp.lock");
            com.xiaomi.push.c.b(file);
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b = b(context, str, j);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    return b;
                } catch (java.io.IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    return true;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException unused3) {
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile);
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            com.xiaomi.push.c.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6 A[Catch: IOException -> 0x00e6, all -> 0x00f8, LOOP:0: B:13:0x00d0->B:15:0x00d6, LOOP_END, TRY_LEAVE, TryCatch #1 {IOException -> 0x00e6, blocks: (B:12:0x00cc, B:13:0x00d0, B:15:0x00d6), top: B:11:0x00cc }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(android.content.Context context, java.lang.String str, long j) {
        java.io.Closeable closeable;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedWriter bufferedWriter;
        java.util.Iterator it;
        java.io.File file = new java.io.File(new java.io.File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str2 = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + context.getPackageName() + "," + java.lang.System.currentTimeMillis();
        ?? exists = file.exists();
        try {
            if (exists != 0) {
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            java.lang.String[] split = readLine.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            if (split.length == 2) {
                                if (android.text.TextUtils.equals(split[0], java.lang.String.valueOf(str))) {
                                    java.lang.String[] split2 = split[1].split(",");
                                    if (split2.length == 2) {
                                        long parseLong = java.lang.Long.parseLong(split2[1]);
                                        if (!android.text.TextUtils.equals(split2[0], context.getPackageName()) && java.lang.Math.abs(r4 - parseLong) < 1000 * j * 0.9f) {
                                            com.xiaomi.push.c.a(bufferedReader);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (java.lang.Exception unused) {
                            arrayList.clear();
                            com.xiaomi.push.c.a(bufferedReader);
                            arrayList.add(str2);
                            bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file));
                            try {
                                try {
                                    it = arrayList.iterator();
                                    while (it.hasNext()) {
                                    }
                                } catch (java.io.IOException e) {
                                    e = e;
                                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                                    com.xiaomi.push.c.a(bufferedWriter);
                                    return true;
                                }
                                com.xiaomi.push.c.a(bufferedWriter);
                                return true;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                com.xiaomi.push.c.a(bufferedWriter);
                                throw th;
                            }
                        }
                    }
                } catch (java.lang.Exception unused2) {
                    bufferedReader = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    closeable = null;
                    com.xiaomi.push.c.a(closeable);
                    throw th;
                }
            } else if (!com.xiaomi.push.c.b(file)) {
                return true;
            }
            arrayList.add(str2);
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file));
                it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write((java.lang.String) it.next());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (java.io.IOException e2) {
                e = e2;
                bufferedWriter = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedWriter = null;
                com.xiaomi.push.c.a(bufferedWriter);
                throw th;
            }
            com.xiaomi.push.c.a(bufferedWriter);
            return true;
        } catch (java.lang.Throwable th4) {
            th = th4;
            closeable = exists;
        }
    }
}
