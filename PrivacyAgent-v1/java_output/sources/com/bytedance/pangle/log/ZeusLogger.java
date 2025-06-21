package com.bytedance.pangle.log;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ZeusLogger {
    public static final java.lang.String TAG = "Zeus_pangle";
    public static final java.lang.String TAG_ACTIVITY = "Zeus/activity_pangle";
    public static final java.lang.String TAG_DOWNLOAD = "Zeus/download_pangle";
    public static final java.lang.String TAG_INIT = "Zeus/init_pangle";
    public static final java.lang.String TAG_INSTALL = "Zeus/install_pangle";
    public static final java.lang.String TAG_LOAD = "Zeus/load_pangle";
    public static final java.lang.String TAG_PAM = "Zeus/pam_pangle";
    public static final java.lang.String TAG_PPM = "Zeus/ppm_pangle";
    public static final java.lang.String TAG_PROVIDER = "Zeus/provider_pangle";
    public static final java.lang.String TAG_RECEIVER = "Zeus/receiver_pangle";
    public static final java.lang.String TAG_REPORTER = "Zeus/reporter_pangle";
    public static final java.lang.String TAG_RESOURCES = "Zeus/resources_pangle";
    public static final java.lang.String TAG_SERVER = "Zeus/server_pangle";
    public static final java.lang.String TAG_SERVICE = "Zeus/service_pangle";
    public static final java.lang.String TAG_SO = "Zeus/so_pangle";
    private static boolean sDebug = true;
    private static boolean sEnableTrace;

    public static void d(java.lang.String str) {
        d(null, str);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        i(str, str2);
    }

    public static void errReport(java.lang.String str, java.lang.String str2) {
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException();
        java.lang.StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((java.lang.StackTraceElement[]) java.util.Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    public static void errReport(java.lang.String str, java.lang.String str2, @androidx.annotation.NonNull java.lang.Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(java.lang.String str, java.lang.String str2, @androidx.annotation.NonNull java.lang.Throwable th, boolean z) {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(str, str2 + " ; " + th);
        if (!sDebug && com.bytedance.pangle.GlobalParam.getInstance().getLogger() != null) {
            com.bytedance.pangle.GlobalParam.getInstance().getLogger().e(str, str2, z ? th : null);
        }
        com.bytedance.pangle.apm.ApmUtils.getApmInstance().reportError(str2, th);
    }

    private static java.lang.String getTraceInfo() {
        java.lang.StackTraceElement stackTraceElement;
        try {
            java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
            int i = 1;
            while (true) {
                if (i >= stackTrace.length) {
                    stackTraceElement = null;
                    break;
                }
                if (!android.text.TextUtils.equals(stackTrace[i].getClassName(), com.bytedance.pangle.log.ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i];
                    break;
                }
                i++;
            }
            if (stackTraceElement == null) {
                return "\t\t[No Trace Info]";
            }
            return "\t\t[" + stackTraceElement.toString() + "]";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    public static void i(java.lang.String str) {
        i(null, str);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        java.lang.String prefixTraceInfo = prefixTraceInfo(str2);
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(str, prefixTraceInfo);
        if (sDebug || com.bytedance.pangle.GlobalParam.getInstance().getLogger() == null) {
            return;
        }
        com.bytedance.pangle.GlobalParam.getInstance().getLogger().i(str, prefixTraceInfo);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    private static java.lang.String prefixTraceInfo(java.lang.String str) {
        if (!sEnableTrace) {
            return str;
        }
        return str + getTraceInfo();
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(java.lang.String str) {
        v(null, str);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        java.lang.String prefixTraceInfo = prefixTraceInfo(str2);
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(str, prefixTraceInfo);
        if (sDebug || com.bytedance.pangle.GlobalParam.getInstance().getLogger() == null) {
            return;
        }
        com.bytedance.pangle.GlobalParam.getInstance().getLogger().v(str, prefixTraceInfo);
    }

    public static void w(java.lang.String str) {
        w(null, str);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        java.lang.String prefixTraceInfo = prefixTraceInfo(str2);
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(str, prefixTraceInfo);
        if (sDebug || com.bytedance.pangle.GlobalParam.getInstance().getLogger() == null) {
            return;
        }
        com.bytedance.pangle.GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        java.lang.String prefixTraceInfo = prefixTraceInfo(str2);
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(str, prefixTraceInfo + " ; " + th);
        if (sDebug || com.bytedance.pangle.GlobalParam.getInstance().getLogger() == null) {
            return;
        }
        com.bytedance.pangle.GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo, th);
    }
}
