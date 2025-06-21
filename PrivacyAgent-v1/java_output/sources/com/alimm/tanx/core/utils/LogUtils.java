package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class LogUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String LOG_TAG = "TanxAdSdk";
    private static java.util.List<java.lang.String> tagCloseSwitchList;
    private static final java.lang.String[] tagCloseSwitch = {"UtRequest", "TanxAdMonitor", "TanxAdMonitor-Cover"};
    private static volatile com.alimm.tanx.core.utils.LogStatus logStatus = com.alimm.tanx.core.utils.LogStatus.LOG_DEFAULT;

    /* renamed from: com.alimm.tanx.core.utils.LogUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[com.alimm.tanx.core.utils.LogStatus.values().length];
            tanxc_do = iArr;
            try {
                iArr[com.alimm.tanx.core.utils.LogStatus.LOG_DEFAULT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                tanxc_do[com.alimm.tanx.core.utils.LogStatus.LOG_DEBUG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[com.alimm.tanx.core.utils.LogStatus.LOG_ALL_CLOSE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2 + getStackTraceMessage(th), "d");
        }
    }

    public static void d(java.lang.String str, java.lang.String... strArr) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "d");
        }
    }

    public static void d2print(java.lang.String str, java.lang.String str2) {
        startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
    }

    public static void e(java.lang.Exception exc) {
        e("", exc);
    }

    public static void e(java.lang.String str, java.lang.Exception exc) {
        e(str, exc, "");
    }

    public static void e(java.lang.String str, java.lang.Exception exc, java.lang.String str2) {
        if (isLogSwitch(str, "e")) {
            startPrint(LOG_TAG, "[" + str + "] " + getStackTraceMessage(exc), "e");
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        e(str, str2, "");
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (isLogSwitch(str, "e")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "e");
        }
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isLogSwitch(str, "e")) {
            startPrint(LOG_TAG, "[" + str + "] " + (str2 + getStackTraceMessage(th)), "e");
        }
    }

    private static java.lang.String getLogString(java.lang.String str, java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        for (java.lang.String str2 : strArr) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static java.lang.String getStackTraceMessage(java.lang.Throwable th) {
        if (th == null) {
            return "本次throwable为null";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter((java.io.Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "i");
        }
    }

    public static void i(java.lang.String str, java.lang.String... strArr) {
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "i");
        }
    }

    public static boolean isDebug(java.lang.String str) {
        try {
            str.hashCode();
            if (!com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode()) {
                if (!android.util.Log.isLoggable(LOG_TAG, 2)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            getStackTraceMessage(e);
            return false;
        }
    }

    public static boolean isLogSwitch(java.lang.String str, java.lang.String str2) {
        try {
            int i = com.alimm.tanx.core.utils.LogUtils.AnonymousClass1.tanxc_do[logStatus.ordinal()];
            if (i == 1) {
                return str2.equals("e");
            }
            if (i != 2) {
                return i != 3;
            }
            if (tagCloseSwitchList == null) {
                tagCloseSwitchList = java.util.Arrays.asList(tagCloseSwitch);
            }
            return isDebug(str2) && (!tagCloseSwitchList.contains(str));
        } catch (java.lang.Exception e) {
            getStackTraceMessage(e);
            return true;
        }
    }

    public static void setLogStatus(com.alimm.tanx.core.utils.LogStatus logStatus2) {
        logStatus = logStatus2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void startPrint(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        int length;
        str4 = str2 + " [SDK Version:" + com.alimm.tanx.core.SdkConstant.getSdkVersion() + "]";
        length = 2001 - str.length();
        str3.hashCode();
        switch (str3) {
            case "d":
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                break;
            case "e":
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                break;
            case "i":
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                break;
            case "v":
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                break;
            case "w":
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                break;
        }
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (isLogSwitch(str, "v")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "v");
        }
    }

    public static void w(java.lang.String str, java.lang.String... strArr) {
        if (isLogSwitch(str, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH)) {
            startPrint(LOG_TAG, getLogString(str, strArr), com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
        }
    }
}
