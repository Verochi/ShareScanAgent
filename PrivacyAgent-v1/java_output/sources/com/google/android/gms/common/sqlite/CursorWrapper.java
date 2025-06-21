package com.google.android.gms.common.sqlite;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class CursorWrapper extends android.database.CursorWrapper implements android.database.CrossProcessCursor {
    public android.database.AbstractWindowedCursor n;

    @com.google.android.gms.common.annotation.KeepForSdk
    public CursorWrapper(@androidx.annotation.RecentlyNonNull android.database.Cursor cursor) {
        super(cursor);
        for (int i = 0; i < 10 && (cursor instanceof android.database.CursorWrapper); i++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof android.database.AbstractWindowedCursor)) {
            java.lang.String name = cursor.getClass().getName();
            throw new java.lang.IllegalArgumentException(name.length() != 0 ? "Unknown type: ".concat(name) : new java.lang.String("Unknown type: "));
        }
        this.n = (android.database.AbstractWindowedCursor) cursor;
    }

    @Override // android.database.CrossProcessCursor
    @com.google.android.gms.common.annotation.KeepForSdk
    public void fillWindow(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.database.CursorWindow cursorWindow) {
        this.n.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.database.CursorWindow getWindow() {
        return this.n.getWindow();
    }

    @Override // android.database.CursorWrapper
    @androidx.annotation.RecentlyNonNull
    public /* synthetic */ android.database.Cursor getWrappedCursor() {
        return this.n;
    }

    @Override // android.database.CrossProcessCursor
    @androidx.annotation.RecentlyNonNull
    public boolean onMove(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int i2) {
        return this.n.onMove(i, i2);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void setWindow(@androidx.annotation.Nullable android.database.CursorWindow cursorWindow) {
        this.n.setWindow(cursorWindow);
    }
}
