package tv.danmaku.ijk.media.player.pragma;

/* loaded from: classes21.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    public static void d(java.lang.String str, java.lang.String str2) {
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void dfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.String.format(java.util.Locale.US, str2, objArr);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void efmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.String.format(java.util.Locale.US, str2, objArr);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void ifmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.String.format(java.util.Locale.US, str2, objArr);
    }

    public static void printCause(java.lang.Throwable th) {
        java.lang.Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        printStackTrace(th);
    }

    public static void printStackTrace(java.lang.Throwable th) {
        th.printStackTrace();
    }

    public static void v(java.lang.String str, java.lang.String str2) {
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void vfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.String.format(java.util.Locale.US, str2, objArr);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void wfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        java.lang.String.format(java.util.Locale.US, str2, objArr);
    }
}
