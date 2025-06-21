package androidx.core.database.sqlite;

/* loaded from: classes.dex */
public final class SQLiteCursorCompat {
    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(@androidx.annotation.NonNull android.database.sqlite.SQLiteCursor sQLiteCursor, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            sQLiteCursor.setFillWindowForwardOnly(z);
        }
    }
}
