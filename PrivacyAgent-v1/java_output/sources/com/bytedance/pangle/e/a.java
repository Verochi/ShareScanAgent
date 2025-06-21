package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class a {

    /* renamed from: com.bytedance.pangle.e.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.io.InputStream a;

        public AnonymousClass1(java.io.InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(this.a));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    } else {
                        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(readLine));
                    }
                } catch (java.io.IOException e) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(java.lang.String.valueOf(e)));
                    return;
                } finally {
                    com.bytedance.pangle.util.g.a(bufferedReader);
                }
            }
        }
    }

    private static void a(java.io.InputStream inputStream) {
        com.bytedance.pangle.d.e.a(new com.bytedance.pangle.e.a.AnonymousClass1(inputStream));
    }

    public static boolean a(java.lang.String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            java.lang.Process exec = java.lang.Runtime.getRuntime().exec(strArr);
            java.io.InputStream errorStream = exec.getErrorStream();
            java.io.InputStream inputStream = exec.getInputStream();
            a(errorStream);
            a(inputStream);
            if (exec.waitFor() == 0) {
                return true;
            }
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + java.util.Arrays.toString(strArr));
            return false;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.InterruptedException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
