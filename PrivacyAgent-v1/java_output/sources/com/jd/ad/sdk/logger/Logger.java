package com.jd.ad.sdk.logger;

/* loaded from: classes23.dex */
public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    @androidx.annotation.NonNull
    private static com.jd.ad.sdk.jad_kt.jad_fs printer = new com.jd.ad.sdk.jad_kt.jad_dq();

    private Logger() {
    }

    public static void addLogAdapter(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kt.jad_bo jad_boVar) {
        com.jd.ad.sdk.jad_kt.jad_fs jad_fsVar = printer;
        jad_boVar.getClass();
        jad_fsVar.jad_an(jad_boVar);
    }

    public static void clearLogAdapters() {
        printer.jad_an();
    }

    public static void d(@androidx.annotation.Nullable java.lang.Object obj) {
        printer.jad_an(obj);
    }

    public static void d(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_er(str, objArr);
    }

    public static void e(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(null, str, objArr);
    }

    public static void e(@androidx.annotation.Nullable java.lang.Throwable th, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(th, str, objArr);
    }

    public static void i(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_bo(str, objArr);
    }

    public static void json(@androidx.annotation.Nullable java.lang.String str) {
        printer.jad_bo(str);
    }

    public static void log(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        printer.jad_an(i, str, str2, th);
    }

    public static void printer(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kt.jad_fs jad_fsVar) {
        jad_fsVar.getClass();
        printer = jad_fsVar;
    }

    public static com.jd.ad.sdk.jad_kt.jad_fs t(@androidx.annotation.Nullable java.lang.String str) {
        return printer.jad_an(str);
    }

    public static void v(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_cp(str, objArr);
    }

    public static void w(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_dq(str, objArr);
    }

    public static void wtf(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(str, objArr);
    }

    public static void xml(@androidx.annotation.Nullable java.lang.String str) {
        printer.jad_cp(str);
    }
}
