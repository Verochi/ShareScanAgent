package androidx.core.database;

/* loaded from: classes.dex */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @androidx.annotation.NonNull
    public static android.database.CursorWindow create(@androidx.annotation.Nullable java.lang.String str, long j) {
        return android.os.Build.VERSION.SDK_INT >= 28 ? new android.database.CursorWindow(str, j) : new android.database.CursorWindow(str);
    }
}
