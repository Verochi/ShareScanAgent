package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final java.lang.String SPLIT = "|";
    private static final java.lang.String TAG = "NetworkKit_Logger";
    private static final java.lang.String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final java.lang.String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static com.huawei.hms.framework.common.ExtLogger extLogger = null;
    private static boolean kitPrint = true;

    public static class ThrowableWrapper extends java.lang.Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private java.lang.String message;
        private java.lang.Throwable ownerThrowable;
        private java.lang.Throwable thisCause;

        private ThrowableWrapper(java.lang.Throwable th) {
            this.ownerThrowable = th;
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            int i = ((th instanceof java.io.IOException) || (th instanceof org.json.JSONException)) ? 8 : 20;
            if (stackTrace.length > i) {
                setStackTrace((java.lang.StackTraceElement[]) java.util.Arrays.copyOf(stackTrace, i));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(com.huawei.hms.framework.common.StringUtils.anonymizeMessage(th.getMessage()));
        }

        public /* synthetic */ ThrowableWrapper(java.lang.Throwable th, com.huawei.hms.framework.common.Logger.AnonymousClass1 anonymousClass1) {
            this(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(java.lang.Throwable th) {
            this.thisCause = th;
        }

        @Override // java.lang.Throwable
        public java.lang.Throwable getCause() {
            java.lang.Throwable th = this.thisCause;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public java.lang.String getMessage() {
            return this.message;
        }

        public void setMessage(java.lang.String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public java.lang.String toString() {
            java.lang.Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            java.lang.String name = th.getClass().getName();
            if (this.message == null) {
                return name;
            }
            java.lang.String str = name + ": ";
            if (this.message.startsWith(str)) {
                return this.message;
            }
            return str + this.message;
        }
    }

    private static java.lang.String complexAppTag(java.lang.String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static java.lang.String complexMsg(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i);
        }
        return getCallMethodInfo(i) + "|" + str;
    }

    private static java.lang.String complexTag(java.lang.String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    @android.annotation.SuppressLint({"LogTagMismatch"})
    public static void d(java.lang.String str, java.lang.Object obj) {
        println(3, str, obj);
    }

    @android.annotation.SuppressLint({"LogTagMismatch"})
    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(java.lang.String str, java.lang.Object obj) {
        println(6, str, obj);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isAPPLoggable(6)) {
            extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            complexTag(str);
            complexMsg(str2, 5);
            getNewThrowable(th);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        println(6, str, str2, objArr);
    }

    private static void extLogPrintln(int i, java.lang.String str, java.lang.String str2) {
        if (i == 2) {
            extLogger.v(str, str2);
            return;
        }
        if (i == 3) {
            extLogger.d(str, str2);
            return;
        }
        if (i == 4) {
            extLogger.i(str, str2);
        } else if (i == 5) {
            extLogger.w(str, str2);
        } else {
            if (i != 6) {
                return;
            }
            extLogger.e(str, str2);
        }
    }

    private static java.lang.String getCallMethodInfo(int i) {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i) {
            return "";
        }
        java.lang.StackTraceElement stackTraceElement = stackTrace[i];
        return java.lang.Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    private static java.lang.Throwable getNewThrowable(java.lang.Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        com.huawei.hms.framework.common.Logger.ThrowableWrapper throwableWrapper = new com.huawei.hms.framework.common.Logger.ThrowableWrapper(th, null);
        java.lang.Throwable cause = th.getCause();
        com.huawei.hms.framework.common.Logger.ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            com.huawei.hms.framework.common.Logger.ThrowableWrapper throwableWrapper3 = new com.huawei.hms.framework.common.Logger.ThrowableWrapper(cause, null);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    @android.annotation.SuppressLint({"LogTagMismatch"})
    public static void i(java.lang.String str, java.lang.Object obj) {
        println(4, str, obj);
    }

    @android.annotation.SuppressLint({"LogTagMismatch"})
    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        println(4, str, str2, objArr);
    }

    private static boolean isAPPLoggable(int i) {
        return extLogger != null && i >= 3;
    }

    private static boolean isKitLoggable(int i) {
        return kitPrint && isLoggable(i);
    }

    public static boolean isLoggable(int i) {
        return android.util.Log.isLoggable(TAG_NETWORKKIT_PRE, i);
    }

    private static int logPrintln(int i, java.lang.String str, java.lang.String str2) {
        if (isAPPLoggable(i)) {
            extLogPrintln(i, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i)) {
            return android.util.Log.println(i, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i, java.lang.String str, java.lang.Object obj) {
        if (i < 3) {
            return;
        }
        logPrintln(i, str, obj == null ? com.igexin.push.core.b.m : obj.toString());
    }

    public static void println(int i, java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (i >= 3 && str2 != null) {
            try {
                logPrintln(i, str, com.huawei.hms.framework.common.StringUtils.format(str2, objArr));
            } catch (java.util.IllegalFormatException e) {
                w(TAG, "log format error" + str2, e);
            }
        }
    }

    public static void setExtLogger(com.huawei.hms.framework.common.ExtLogger extLogger2, boolean z) {
        extLogger = extLogger2;
        kitPrint = z;
        i(TAG, "logger = " + extLogger2 + z);
    }

    public static void v(java.lang.String str, java.lang.Object obj) {
        println(2, str, obj);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(java.lang.String str, java.lang.Object obj) {
        println(5, str, obj);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isAPPLoggable(5)) {
            extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            complexTag(str);
            complexMsg(str2, 5);
            getNewThrowable(th);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        println(5, str, str2, objArr);
    }
}
