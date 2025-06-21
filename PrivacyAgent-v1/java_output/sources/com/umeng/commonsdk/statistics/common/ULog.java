package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public class ULog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static java.lang.String TAG = "ULog";

    private ULog() {
    }

    public static void d(java.lang.String str) {
        d(TAG, str, (java.lang.Throwable) null);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    public static void d(java.lang.String str, java.lang.Throwable th) {
        d(TAG, str, th);
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.contains("%")) {
                d(TAG, new java.util.Formatter().format(str, objArr).toString(), (java.lang.Throwable) null);
            } else {
                d(str, objArr != null ? (java.lang.String) objArr[0] : "", (java.lang.Throwable) null);
            }
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void d(java.lang.Throwable th) {
        d(TAG, (java.lang.String) null, th);
    }

    public static void d(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            d(TAG, new java.util.Formatter(locale).format(str, objArr).toString(), (java.lang.Throwable) null);
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void e(java.lang.String str) {
        e(TAG, str, (java.lang.Throwable) null);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        e(TAG, str, th);
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.contains("%")) {
                e(TAG, new java.util.Formatter().format(str, objArr).toString(), (java.lang.Throwable) null);
            } else {
                e(str, objArr != null ? (java.lang.String) objArr[0] : "", (java.lang.Throwable) null);
            }
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void e(java.lang.Throwable th) {
        e(TAG, (java.lang.String) null, th);
    }

    public static void e(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            e(TAG, new java.util.Formatter(locale).format(str, objArr).toString(), (java.lang.Throwable) null);
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static java.lang.String getStackTrace(java.lang.Throwable th) {
        java.io.PrintWriter printWriter;
        java.io.StringWriter stringWriter;
        java.io.StringWriter stringWriter2 = null;
        try {
            stringWriter = new java.io.StringWriter();
            try {
                printWriter = new java.io.PrintWriter(stringWriter);
            } catch (java.lang.Throwable unused) {
                printWriter = null;
            }
        } catch (java.lang.Throwable unused2) {
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            java.lang.String stringWriter3 = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (java.lang.Throwable unused3) {
            }
            printWriter.close();
            return stringWriter3;
        } catch (java.lang.Throwable unused4) {
            stringWriter2 = stringWriter;
            if (stringWriter2 != null) {
                try {
                    stringWriter2.close();
                } catch (java.lang.Throwable unused5) {
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
            return "";
        }
    }

    public static void i(java.lang.String str) {
        i(TAG, str, (java.lang.Throwable) null);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    public static void i(java.lang.String str, java.lang.Throwable th) {
        i(TAG, str, th);
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.contains("%")) {
                i(TAG, new java.util.Formatter().format(str, objArr).toString(), (java.lang.Throwable) null);
            } else {
                i(str, objArr != null ? (java.lang.String) objArr[0] : "", (java.lang.Throwable) null);
            }
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void i(java.lang.Throwable th) {
        i(TAG, (java.lang.String) null, th);
    }

    public static void i(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            i(TAG, new java.util.Formatter(locale).format(str, objArr).toString(), (java.lang.Throwable) null);
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    private static void print(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = LOG_MAXLENGTH;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= 100) {
                    break;
                }
                if (length > i2) {
                    if (i == 1) {
                        str2.substring(i4, i2);
                    } else if (i == 2) {
                        str2.substring(i4, i2);
                    } else if (i == 3) {
                        str2.substring(i4, i2);
                    } else if (i == 4) {
                        str2.substring(i4, i2);
                    } else if (i == 5) {
                        str2.substring(i4, i2);
                    }
                    i3++;
                    i4 = i2;
                    i2 = LOG_MAXLENGTH + i2;
                } else if (i == 1) {
                    str2.substring(i4, length);
                } else if (i == 2) {
                    str2.substring(i4, length);
                } else if (i == 3) {
                    str2.substring(i4, length);
                } else if (i == 4) {
                    str2.substring(i4, length);
                } else if (i == 5) {
                    str2.substring(i4, length);
                }
            }
        }
        if (th != null) {
            android.text.TextUtils.isEmpty(getStackTrace(th));
        }
    }

    public static void v(java.lang.String str) {
        v(TAG, str, (java.lang.Throwable) null);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    public static void v(java.lang.String str, java.lang.Throwable th) {
        v(TAG, str, th);
    }

    public static void v(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.contains("%")) {
                v(TAG, new java.util.Formatter().format(str, objArr).toString(), (java.lang.Throwable) null);
            } else {
                v(str, objArr != null ? (java.lang.String) objArr[0] : "", (java.lang.Throwable) null);
            }
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void v(java.lang.Throwable th) {
        v(TAG, (java.lang.String) null, th);
    }

    public static void v(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            v(TAG, new java.util.Formatter(locale).format(str, objArr).toString(), (java.lang.Throwable) null);
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void w(java.lang.String str) {
        w(TAG, str, (java.lang.Throwable) null);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        w(TAG, str, th);
    }

    public static void w(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.contains("%")) {
                w(TAG, new java.util.Formatter().format(str, objArr).toString(), (java.lang.Throwable) null);
            } else {
                w(str, objArr != null ? (java.lang.String) objArr[0] : "", (java.lang.Throwable) null);
            }
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }

    public static void w(java.lang.Throwable th) {
        w(TAG, (java.lang.String) null, th);
    }

    public static void w(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            w(TAG, new java.util.Formatter(locale).format(str, objArr).toString(), (java.lang.Throwable) null);
        } catch (java.lang.Throwable th) {
            e(th);
        }
    }
}
