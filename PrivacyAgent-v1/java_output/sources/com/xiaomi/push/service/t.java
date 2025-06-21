package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class t {
    private static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long b = 0;
    private static java.util.concurrent.ThreadPoolExecutor c = new java.util.concurrent.ThreadPoolExecutor(1, 1, 20, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());

    public static void a() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if ((c.getActiveCount() <= 0 || currentTimeMillis - b >= 1800000) && com.xiaomi.push.eh.a.a.a) {
            com.xiaomi.push.service.ay a2 = com.xiaomi.push.service.ay.a();
            a2.c();
            com.xiaomi.push.cw.a aVar = a2.a;
            if (aVar == null || aVar.b.size() <= 0) {
                return;
            }
            b = currentTimeMillis;
            c.execute(new com.xiaomi.push.service.u(aVar.b));
        }
    }

    public static void b() {
        java.lang.String c2 = c("/proc/self/net/tcp");
        if (!android.text.TextUtils.isEmpty(c2)) {
            com.xiaomi.channel.commonutils.logger.b.a("dump tcp for uid = " + android.os.Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.a(c2);
        }
        java.lang.String c3 = c("/proc/self/net/tcp6");
        if (android.text.TextUtils.isEmpty(c3)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("dump tcp6 for uid = " + android.os.Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.a(c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.a("ConnectivityTest: begin to connect to ".concat(java.lang.String.valueOf(str)));
            java.net.Socket socket = new java.net.Socket();
            socket.connect(com.xiaomi.push.bt.b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            com.xiaomi.channel.commonutils.logger.b.a("ConnectivityTest: connect to " + str + " in " + (java.lang.System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    private static java.lang.String c(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(str)));
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        java.lang.String sb2 = sb.toString();
                        com.xiaomi.push.c.a(bufferedReader);
                        return sb2;
                    }
                    sb.append("\n");
                    sb.append(readLine);
                }
            } catch (java.lang.Exception unused) {
                com.xiaomi.push.c.a(bufferedReader);
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.xiaomi.push.c.a(bufferedReader);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
