package com.xiaomi.push;

/* loaded from: classes19.dex */
public class ck implements com.xiaomi.channel.commonutils.logger.LoggerInterface {
    private static volatile com.xiaomi.push.ck h;
    private java.lang.String c;
    private android.content.Context d;
    private java.lang.String e = "";
    private android.os.Handler g;
    private static final java.text.SimpleDateFormat b = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    public static java.lang.String a = "/MiPushLog";
    private static java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> f = java.util.Collections.synchronizedList(new java.util.ArrayList());

    private ck(android.content.Context context) {
        this.d = context;
        if (context.getApplicationContext() != null) {
            this.d = context.getApplicationContext();
        }
        this.c = this.d.getPackageName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Process.myPid();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.g = new android.os.Handler(handlerThread.getLooper());
    }

    public static com.xiaomi.push.ck a(android.content.Context context) {
        if (h == null) {
            synchronized (com.xiaomi.push.ck.class) {
                if (h == null) {
                    h = new com.xiaomi.push.ck(context);
                }
            }
        }
        return h;
    }

    public static /* synthetic */ void b(com.xiaomi.push.ck ckVar) {
        java.nio.channels.FileLock fileLock;
        java.io.RandomAccessFile randomAccessFile;
        java.io.File externalFilesDir;
        java.io.BufferedWriter bufferedWriter = null;
        try {
            if (android.text.TextUtils.isEmpty(ckVar.e) && (externalFilesDir = ckVar.d.getExternalFilesDir(null)) != null) {
                ckVar.e = externalFilesDir.getAbsolutePath();
            }
            java.io.File file = new java.io.File(ckVar.e + a);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                return;
            }
            java.io.File file2 = new java.io.File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new java.io.RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    try {
                        java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(new java.io.File(file, "log1.txt"), true)));
                        while (!f.isEmpty()) {
                            try {
                                android.util.Pair<java.lang.String, java.lang.Throwable> remove = f.remove(0);
                                java.lang.String str = (java.lang.String) remove.first;
                                if (remove.second != null) {
                                    str = (str + "\n") + android.util.Log.getStackTraceString((java.lang.Throwable) remove.second);
                                }
                                bufferedWriter2.write(str + "\n");
                            } catch (java.lang.Exception unused) {
                                bufferedWriter = bufferedWriter2;
                                java.lang.String str2 = ckVar.c;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (java.io.IOException unused2) {
                                    }
                                }
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException unused3) {
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                        return;
                                    } catch (java.io.IOException unused4) {
                                        return;
                                    }
                                }
                                return;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (java.io.IOException unused5) {
                                        java.lang.String str3 = ckVar.c;
                                    }
                                }
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException unused6) {
                                        java.lang.String str4 = ckVar.c;
                                    }
                                }
                                if (randomAccessFile == null) {
                                    throw th;
                                }
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (java.io.IOException unused7) {
                                    java.lang.String str5 = ckVar.c;
                                    throw th;
                                }
                            }
                        }
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                        java.io.File file3 = new java.io.File(file, "log1.txt");
                        if (file3.length() >= 1048576) {
                            java.io.File file4 = new java.io.File(file, "log0.txt");
                            if (file4.exists() && file4.isFile()) {
                                file4.delete();
                            }
                            file3.renameTo(file4);
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused8) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException unused9) {
                        }
                    } catch (java.lang.Exception unused10) {
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception unused11) {
                fileLock = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileLock = null;
            }
        } catch (java.lang.Exception unused12) {
            fileLock = null;
            randomAccessFile = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileLock = null;
            randomAccessFile = null;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(java.lang.String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(java.lang.String str, java.lang.Throwable th) {
        this.g.post(new com.xiaomi.push.cl(this, str, th));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(java.lang.String str) {
        this.c = str;
    }
}
