package com.umeng.commonsdk.stateless;

/* loaded from: classes19.dex */
public class b {
    public static final int a = 273;
    private static android.content.Context b = null;
    private static android.os.HandlerThread c = null;
    private static android.os.Handler d = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static com.umeng.commonsdk.stateless.b.a i;
    private static android.content.IntentFilter j;
    private static volatile boolean k;
    private static java.lang.Object e = new java.lang.Object();
    private static java.util.LinkedList<java.lang.String> l = new java.util.LinkedList<>();

    /* renamed from: com.umeng.commonsdk.stateless.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i != 512) {
                switch (i) {
                    case 273:
                        com.umeng.commonsdk.stateless.b.l();
                        return;
                    case com.umeng.commonsdk.stateless.b.f /* 274 */:
                        com.umeng.commonsdk.stateless.b.n();
                        return;
                    case com.umeng.commonsdk.stateless.b.g /* 275 */:
                        com.umeng.commonsdk.stateless.b.p();
                        break;
                    default:
                        return;
                }
            }
            com.umeng.commonsdk.stateless.b.q();
        }
    }

    public static class a extends android.os.FileObserver {
        public a(java.lang.String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, java.lang.String str) {
            if ((i & 8) != 8) {
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            com.umeng.commonsdk.stateless.b.a(com.umeng.commonsdk.stateless.b.f);
        }
    }

    public b(android.content.Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    android.content.Context applicationContext = context.getApplicationContext();
                    b = applicationContext;
                    if (applicationContext != null && c == null) {
                        android.os.HandlerThread handlerThread = new android.os.HandlerThread("SL-NetWorkSender");
                        c = handlerThread;
                        handlerThread.start();
                        if (i == null) {
                            java.lang.String str = b.getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.f;
                            java.io.File file = new java.io.File(str);
                            if (!file.exists()) {
                                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            com.umeng.commonsdk.stateless.b.a aVar = new com.umeng.commonsdk.stateless.b.a(str);
                            i = aVar;
                            aVar.startWatching();
                            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (d == null) {
                            d = new com.umeng.commonsdk.stateless.b.AnonymousClass1(c.getLooper());
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static void a(int i2) {
        android.os.Handler handler;
        if (!k || (handler = d) == null) {
            return;
        }
        android.os.Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        d.sendMessage(obtainMessage);
    }

    public static void a(boolean z) {
        k = z;
        if (!z) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f);
        }
    }

    public static boolean a() {
        synchronized (e) {
            return i != null;
        }
    }

    public static void b() {
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f);
    }

    public static void b(int i2) {
        android.os.Handler handler;
        try {
            if (!k || (handler = d) == null || handler.hasMessages(i2)) {
                return;
            }
            android.os.Message obtainMessage = d.obtainMessage();
            obtainMessage.what = i2;
            d.sendMessage(obtainMessage);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(b, th);
        }
    }

    public static void c() {
        b(g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        java.io.File[] c2 = com.umeng.commonsdk.stateless.d.c(b);
        if (c2 != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (java.io.File file : c2) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static java.lang.String j() {
        java.lang.String str = null;
        try {
            java.lang.String peek = l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                l.removeFirst();
                return peek;
            } catch (java.lang.Throwable unused) {
                str = peek;
                return str;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    @android.annotation.TargetApi(9)
    private static void k() {
        java.lang.String pollFirst;
        byte[] bArr;
        if (l.size() <= 0) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = l.pollFirst();
            if (!android.text.TextUtils.isEmpty(pollFirst)) {
                java.io.File file = new java.io.File(pollFirst);
                if (file.exists()) {
                    com.umeng.commonsdk.stateless.c cVar = new com.umeng.commonsdk.stateless.c(b);
                    try {
                        bArr = com.umeng.commonsdk.stateless.d.a(pollFirst);
                    } catch (java.lang.Exception unused) {
                        bArr = null;
                    }
                    java.lang.String name = file.getName();
                    java.lang.String substring = !android.text.TextUtils.isEmpty(name) ? name.substring(0, 1) : com.umeng.analytics.pro.bo.aN;
                    java.lang.String c2 = com.umeng.commonsdk.stateless.d.c(com.umeng.commonsdk.stateless.d.d(name));
                    if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                        cVar.b();
                    }
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.a : com.umeng.commonsdk.stateless.a.h, substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        java.io.File a2;
        byte[] bArr;
        if (!k || b == null) {
            return;
        }
        do {
            try {
                a2 = com.umeng.commonsdk.stateless.d.a(b);
                if (a2 != null && a2.getParentFile() != null && !android.text.TextUtils.isEmpty(a2.getParentFile().getName())) {
                    com.umeng.commonsdk.stateless.c cVar = new com.umeng.commonsdk.stateless.c(b);
                    java.lang.String str = new java.lang.String(android.util.Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArr = com.umeng.commonsdk.stateless.d.a(a2.getAbsolutePath());
                        } catch (java.lang.Exception unused) {
                            bArr = null;
                        }
                        java.lang.String str2 = com.umeng.analytics.pro.bo.aN;
                        if (com.umeng.commonsdk.statistics.UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str2 = "s";
                        }
                        if (com.umeng.commonsdk.statistics.UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || com.umeng.commonsdk.statistics.UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || com.umeng.commonsdk.statistics.UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str2 = "p";
                        }
                        if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0) {
                            cVar.a();
                        } else {
                            com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                            cVar.b();
                        }
                        if (!cVar.a(bArr, str, com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.a : com.umeng.commonsdk.stateless.a.h, str2)) {
                            com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        java.io.File file = new java.io.File(a2.getAbsolutePath());
                        if (!file.delete()) {
                            com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new java.io.File(a2.getAbsolutePath()).delete();
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(b, th);
            }
        } while (a2 != null);
        m();
    }

    private static void m() {
        try {
            java.io.File file = new java.io.File(b.getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                com.umeng.commonsdk.stateless.d.a(file);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            java.io.File file = new java.io.File(b.getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }
}
