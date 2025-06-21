package org.greenrobot.eventbus.android;

/* loaded from: classes26.dex */
public class AndroidLogger implements org.greenrobot.eventbus.Logger {
    public static final boolean b;
    public final java.lang.String a;

    static {
        boolean z;
        try {
            java.lang.Class.forName("android.util.Log");
            z = true;
        } catch (java.lang.ClassNotFoundException unused) {
            z = false;
        }
        b = z;
    }

    public AndroidLogger(java.lang.String str) {
        this.a = str;
    }

    public static boolean isAndroidLogAvailable() {
        return b;
    }

    public final int a(java.util.logging.Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }

    @Override // org.greenrobot.eventbus.Logger
    public void log(java.util.logging.Level level, java.lang.String str) {
        if (level != java.util.logging.Level.OFF) {
            android.util.Log.println(a(level), this.a, str);
        }
    }

    @Override // org.greenrobot.eventbus.Logger
    public void log(java.util.logging.Level level, java.lang.String str, java.lang.Throwable th) {
        if (level != java.util.logging.Level.OFF) {
            android.util.Log.println(a(level), this.a, str + "\n" + android.util.Log.getStackTraceString(th));
        }
    }
}
