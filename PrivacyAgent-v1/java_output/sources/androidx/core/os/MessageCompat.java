package androidx.core.os;

/* loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    private MessageCompat() {
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@androidx.annotation.NonNull android.os.Message message) {
        boolean isAsynchronous;
        boolean isAsynchronous2;
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            isAsynchronous2 = message.isAsynchronous();
            return isAsynchronous2;
        }
        if (sTryIsAsynchronous) {
            try {
                isAsynchronous = message.isAsynchronous();
                return isAsynchronous;
            } catch (java.lang.NoSuchMethodError unused) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void setAsynchronous(@androidx.annotation.NonNull android.os.Message message, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z);
        } else if (sTrySetAsynchronous) {
            try {
                message.setAsynchronous(z);
            } catch (java.lang.NoSuchMethodError unused) {
                sTrySetAsynchronous = false;
            }
        }
    }
}
