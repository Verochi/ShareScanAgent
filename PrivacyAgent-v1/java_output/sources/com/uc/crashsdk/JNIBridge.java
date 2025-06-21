package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class JNIBridge {
    private static int addCachedInfo(java.lang.String str, java.lang.String str2) {
        return com.uc.crashsdk.a.b(str, str2);
    }

    private static int addDumpFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2, int i, boolean z3) {
        return com.uc.crashsdk.a.a(str, str2, z, z2, i, z3);
    }

    private static void addHeaderInfo(java.lang.String str, java.lang.String str2) {
        com.uc.crashsdk.a.a(str, str2);
    }

    public static long cmd(int i) {
        return nativeCmd(i, 0L, null, null);
    }

    public static long cmd(int i, java.lang.String str) {
        return nativeCmd(i, 0L, str, null);
    }

    private static int createCachedInfo(java.lang.String str, int i, int i2) {
        return com.uc.crashsdk.a.a(str, i, i2);
    }

    private static boolean generateCustomLog(java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        return com.uc.crashsdk.e.a(stringBuffer, str2, j, com.uc.crashsdk.a.c(str3), com.uc.crashsdk.a.c(str4), com.uc.crashsdk.a.c(str5), str6);
    }

    public static java.lang.String getCallbackInfo(java.lang.String str, boolean z) {
        return com.uc.crashsdk.a.a(str, z);
    }

    private static java.lang.String getDatasForClientJavaLog(int i, java.lang.String str) {
        boolean equals = "$all$".equals(str);
        if (i == 1) {
            return equals ? com.uc.crashsdk.a.h() : com.uc.crashsdk.a.a(str);
        }
        if (i == 2) {
            return equals ? com.uc.crashsdk.a.j() : com.uc.crashsdk.a.a(str, true);
        }
        if (i == 3) {
            return equals ? com.uc.crashsdk.a.l() : com.uc.crashsdk.a.b(str);
        }
        if (i == 4) {
            return com.uc.crashsdk.e.d(str) ? "1" : "0";
        }
        return null;
    }

    private static java.lang.String getJavaStackTrace(java.lang.Thread thread, int i) {
        if (i != 0 && i == android.os.Process.myPid()) {
            thread = android.os.Looper.getMainLooper().getThread();
        }
        if (thread != null) {
            return com.uc.crashsdk.e.a(thread.getStackTrace(), "getJavaStackTrace").toString();
        }
        return null;
    }

    public static native boolean nativeAddCachedInfo(java.lang.String str, java.lang.String str2);

    public static native int nativeAddCallbackInfo(java.lang.String str, int i, long j, int i2);

    public static native int nativeAddDumpFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2, int i, boolean z3);

    public static native void nativeAddHeaderInfo(java.lang.String str, java.lang.String str2);

    public static native boolean nativeChangeState(java.lang.String str, java.lang.String str2, boolean z);

    public static native void nativeClientCloseConnection(long j);

    public static native long nativeClientCreateConnection(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    public static native int nativeClientWriteData(long j, java.lang.String str);

    public static native void nativeCloseFile(int i);

    public static native long nativeCmd(int i, long j, java.lang.String str, java.lang.Object[] objArr);

    public static native void nativeCrash(int i, int i2);

    public static native int nativeCreateCachedInfo(java.lang.String str, int i, int i2);

    public static native java.lang.String nativeDumpThreads(java.lang.String str, long j);

    public static native int nativeGenerateUnexpLog(long j, int i);

    public static native java.lang.String nativeGet(int i, long j, java.lang.String str);

    public static native java.lang.String nativeGetCallbackInfo(java.lang.String str, long j, int i, boolean z);

    public static native boolean nativeIsCrashing();

    public static native boolean nativeLockFile(int i, boolean z);

    public static native int nativeLog(int i, java.lang.String str, java.lang.String str2);

    public static native int nativeOpenFile(java.lang.String str);

    public static native long nativeSet(int i, long j, java.lang.String str, java.lang.Object[] objArr);

    public static native void nativeSetForeground(boolean z);

    private static void onCrashLogGenerated(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        boolean equals = com.uc.crashsdk.e.h().equals(str2);
        boolean equals2 = com.uc.crashsdk.export.LogType.NATIVE_TYPE.equals(str3);
        if (!com.uc.crashsdk.e.F()) {
            if (equals && equals2) {
                try {
                    com.uc.crashsdk.f.c(true);
                } catch (java.lang.Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
            }
            str = com.uc.crashsdk.e.a(str);
        }
        com.uc.crashsdk.d.a(str, str2, str3);
        if (com.uc.crashsdk.e.F()) {
            return;
        }
        if (z || (!equals && com.uc.crashsdk.g.t())) {
            com.uc.crashsdk.e.a(false, false);
        } else if (equals) {
            com.uc.crashsdk.e.b(equals2);
        }
    }

    private static void onCrashRestarting() {
        com.uc.crashsdk.d.a(false);
        com.uc.crashsdk.b.N();
    }

    private static void onKillProcess(java.lang.String str, int i, int i2) {
        java.lang.String str2 = "onKillProcess. SIG: " + i2;
        if (com.uc.crashsdk.e.a()) {
            com.uc.crashsdk.a.a.b("crashsdk", str2);
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", str2);
        }
        java.lang.StringBuilder f = com.uc.crashsdk.e.f("onKillProcess");
        java.util.Locale locale = java.util.Locale.US;
        f.insert(0, java.lang.String.format(locale, "State in disk: '%s'\n", com.uc.crashsdk.b.p()));
        f.insert(0, java.lang.String.format(locale, "SIG: %d, fg: %s, exiting: %s, main process: %s, time: %s\n", java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(com.uc.crashsdk.b.B()), java.lang.Boolean.valueOf(com.uc.crashsdk.b.u()), java.lang.Boolean.valueOf(com.uc.crashsdk.b.F()), com.uc.crashsdk.e.n()));
        f.insert(0, java.lang.String.format(locale, "Kill PID: %d (%s) by pid: %d (%s) tid: %d (%s)\n", java.lang.Integer.valueOf(i), com.uc.crashsdk.e.a(i), java.lang.Integer.valueOf(android.os.Process.myPid()), com.uc.crashsdk.e.a(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()), java.lang.Thread.currentThread().getName()));
        java.lang.String sb = f.toString();
        if (com.uc.crashsdk.e.a()) {
            com.uc.crashsdk.a.a.b("crashsdk", sb);
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", sb);
        }
        if (com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.g.a(new java.io.File(str), sb.getBytes());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static java.lang.String onNativeEvent(int i, long j, java.lang.Object[] objArr) {
        switch (i) {
            case 1:
                return java.lang.String.valueOf(java.lang.Runtime.getRuntime().maxMemory());
            case 2:
                return com.uc.crashsdk.e.d();
            case 3:
                if (objArr != null && objArr.length == 2) {
                    java.lang.Object obj = objArr[0];
                    if (obj instanceof java.lang.String) {
                        java.lang.Object obj2 = objArr[1];
                        if (obj2 instanceof java.lang.String) {
                            return com.uc.crashsdk.e.a((java.lang.String) obj, (java.lang.String) obj2);
                        }
                    }
                }
                return null;
            case 4:
                return com.uc.crashsdk.e.g();
            case 5:
                com.uc.crashsdk.a.a(true);
                return null;
            case 6:
                return com.uc.crashsdk.a.g.d();
            case 7:
                com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(102), 8000L);
                com.uc.crashsdk.e.r();
                return null;
            default:
                return null;
        }
    }

    private static int onPreClientCustomLog(java.lang.String str, java.lang.String str2, boolean z) {
        com.uc.crashsdk.g.a();
        com.uc.crashsdk.e.a(false);
        if (com.uc.crashsdk.e.a(str, str2, z)) {
            return 0;
        }
        com.uc.crashsdk.e.b(str, str2, z);
        return 1;
    }

    private static int registerCurrentThread(java.lang.String str, int i) {
        return com.uc.crashsdk.a.a(i, str);
    }

    private static int registerInfoCallback(java.lang.String str, int i, long j, int i2) {
        return com.uc.crashsdk.a.a(str, i, null, j, i2);
    }

    public static long set(int i, long j) {
        return nativeSet(i, j, null, null);
    }

    public static long set(int i, java.lang.String str) {
        return nativeSet(i, 0L, str, null);
    }

    public static long set(int i, boolean z) {
        return nativeSet(i, z ? 1L : 0L, null, null);
    }
}
