package androidx.core.os;

/* loaded from: classes.dex */
public class BuildCompat {
    private BuildCompat() {
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 24)
    @java.lang.Deprecated
    public static boolean isAtLeastN() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 25)
    @java.lang.Deprecated
    public static boolean isAtLeastNMR1() {
        return android.os.Build.VERSION.SDK_INT >= 25;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 26)
    @java.lang.Deprecated
    public static boolean isAtLeastO() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 27)
    @java.lang.Deprecated
    public static boolean isAtLeastOMR1() {
        return android.os.Build.VERSION.SDK_INT >= 27;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 28)
    @java.lang.Deprecated
    public static boolean isAtLeastP() {
        return android.os.Build.VERSION.SDK_INT >= 28;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 29)
    @java.lang.Deprecated
    public static boolean isAtLeastQ() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(api = 30)
    @java.lang.Deprecated
    public static boolean isAtLeastR() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }

    @androidx.annotation.ChecksSdkIntAtLeast(codename = androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH)
    public static boolean isAtLeastS() {
        return android.os.Build.VERSION.CODENAME.equals(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
    }
}
