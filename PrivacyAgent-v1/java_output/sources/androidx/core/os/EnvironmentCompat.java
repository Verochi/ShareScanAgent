package androidx.core.os;

/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final java.lang.String MEDIA_UNKNOWN = "unknown";
    private static final java.lang.String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    @androidx.annotation.NonNull
    public static java.lang.String getStorageState(@androidx.annotation.NonNull java.io.File file) {
        return android.os.Environment.getExternalStorageState(file);
    }
}
