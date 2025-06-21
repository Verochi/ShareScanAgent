package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ub2 {
    public static int a(int i) {
        return b(i, 0, 0);
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int b(int i, int i2, int i3) {
        return i | i2 | i3;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int c(int i) {
        return i & 24;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int d(int i) {
        return i & 7;
    }

    public static java.lang.String e(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i == 4) {
            return "YES";
        }
        throw new java.lang.IllegalStateException();
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int f(int i) {
        return i & 32;
    }
}
