package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public final class CameraLogger {
    public static final int LEVEL_ERROR = 3;
    public static final int LEVEL_INFO = 1;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 2;

    @androidx.annotation.VisibleForTesting
    public static java.lang.String b;

    @androidx.annotation.VisibleForTesting
    public static java.lang.String c;
    public static int d;
    public static java.util.Set<com.otaliastudios.cameraview.CameraLogger.Logger> e = new java.util.concurrent.CopyOnWriteArraySet();

    @androidx.annotation.VisibleForTesting
    public static com.otaliastudios.cameraview.CameraLogger.Logger f = new com.otaliastudios.cameraview.CameraLogger.AnonymousClass1();

    @androidx.annotation.NonNull
    public java.lang.String a;

    /* renamed from: com.otaliastudios.cameraview.CameraLogger$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.otaliastudios.cameraview.CameraLogger.Logger {
        @Override // com.otaliastudios.cameraview.CameraLogger.Logger
        public void log(int i, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        void log(int i, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th);
    }

    static {
        setLogLevel(3);
        e.add(f);
    }

    public CameraLogger(@androidx.annotation.NonNull java.lang.String str) {
        this.a = str;
    }

    public static com.otaliastudios.cameraview.CameraLogger create(@androidx.annotation.NonNull java.lang.String str) {
        return new com.otaliastudios.cameraview.CameraLogger(str);
    }

    public static void registerLogger(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraLogger.Logger logger) {
        e.add(logger);
    }

    public static void setLogLevel(int i) {
        d = i;
    }

    public static void unregisterLogger(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraLogger.Logger logger) {
        e.remove(logger);
    }

    @androidx.annotation.Nullable
    public final java.lang.String a(int i, @androidx.annotation.NonNull java.lang.Object... objArr) {
        java.lang.Throwable th = null;
        if (!b(i)) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : objArr) {
            if (obj instanceof java.lang.Throwable) {
                th = (java.lang.Throwable) obj;
            }
            sb.append(java.lang.String.valueOf(obj));
            sb.append(" ");
        }
        java.lang.String trim = sb.toString().trim();
        java.util.Iterator<com.otaliastudios.cameraview.CameraLogger.Logger> it = e.iterator();
        while (it.hasNext()) {
            it.next().log(i, this.a, trim, th);
        }
        b = trim;
        c = this.a;
        return trim;
    }

    public final boolean b(int i) {
        return d <= i && e.size() > 0;
    }

    @androidx.annotation.Nullable
    public java.lang.String e(@androidx.annotation.NonNull java.lang.Object... objArr) {
        return a(3, objArr);
    }

    @androidx.annotation.Nullable
    public java.lang.String i(@androidx.annotation.NonNull java.lang.Object... objArr) {
        return a(1, objArr);
    }

    @androidx.annotation.Nullable
    public java.lang.String v(@androidx.annotation.NonNull java.lang.Object... objArr) {
        return a(0, objArr);
    }

    @androidx.annotation.Nullable
    public java.lang.String w(@androidx.annotation.NonNull java.lang.Object... objArr) {
        return a(2, objArr);
    }
}
